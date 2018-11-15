package com.everwhimsical.jbehave.execution;

import com.everwhimsical.jbehave.model.Bug;
import com.everwhimsical.jbehave.model.IScenario;
import com.everwhimsical.jbehave.model.IStep;
import com.everwhimsical.jbehave.model.IStory;
import com.everwhimsical.jbehave.model.Status;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.jbehave.core.model.Meta;
import org.jbehave.core.model.Scenario;
import org.jbehave.core.model.Story;
import org.jbehave.core.reporters.NullStoryReporter;
import org.jbehave.core.reporters.StoryReporter;

/**
 * Extension of {@link StoryReporter}. <br> Usage: <br>
 * <pre>
 * public Configuration configuration() {
 *      return new MostUsefulConfiguration()
 *      .useStoryPathResolver(embeddableClass -&gt; "com/everwhimsical/jbehave/Simple.story")
 *      .useStoryReporterBuilder(
 *      new StoryReporterBuilder().withDefaultFormats().withReporters(new ExecutionModelReporter())
 *      .withFormats(Format.CONSOLE));
 * }
 * </pre>
 */
public class ExecutionModelReporter extends NullStoryReporter {

    private static final ThreadLocal<Scenario> SCENARIO_THREAD = new InheritableThreadLocal<>();

    @Override
    public void beforeStory(Story story, boolean givenStory) {
        IStory iStory = new IStory();
        iStory.updateTestSuiteStart();
        iStory.setName(story.getName());
        iStory.setDescription(story.getDescription().asString());
        iStory.setPath(story.getPath());
        JBehaveExecution.startStory(iStory);
        SCENARIO_THREAD.remove();
    }

    @Override
    public void afterStory(boolean givenOrRestartingStory) {
        JBehaveExecution.endStory();
        SCENARIO_THREAD.remove();
    }

    @Override
    public void beforeScenario(Scenario scenario) {
        SCENARIO_THREAD.set(scenario);
        if (scenario.getExamplesTable().getRowCount() > 0) {
            return;
        }
        Meta meta = scenario.getMeta();
        Map<String, String> metaMap = new HashMap<>();
        meta.getPropertyNames().forEach(key -> {
            String value = meta.getProperty(key);
            metaMap.put(key, value);
        });
        IScenario iScenario = new IScenario();
        iScenario.updateScenarioStart();
        iScenario.setName(scenario.getTitle());
        iScenario.setMeta(metaMap);
        JBehaveExecution.startScenario(iScenario);
    }

    @Override
    public void afterScenario() {
        JBehaveExecution.endScenario();
    }

    @Override
    public void example(Map<String, String> tableRow) {
        Scenario scenario = SCENARIO_THREAD.get();
        Optional.ofNullable(JBehaveExecution.getScenario())
            .ifPresent(s -> JBehaveExecution.endScenario());
        Meta meta = scenario.getMeta();
        Map<String, String> metaMap = new HashMap<>();
        meta.getPropertyNames().forEach(key -> {
            String value = meta.getProperty(key);
            metaMap.put(key, value);
        });
        IScenario iScenario = new IScenario();
        iScenario.updateScenarioStart();
        iScenario.setName(scenario.getTitle());
        iScenario.setMeta(metaMap);
        iScenario.setExampleRows(tableRow);
        JBehaveExecution.startScenario(iScenario);
    }

    @Override
    public void beforeStep(String step) {
        String annotation = StringUtils.substringBefore(step, " ");
        String stepValue = StringUtils.substringAfter(step, " ");

        IStep iStep = new IStep();
        iStep.updateStepStart();
        iStep.setAnnotation(annotation);
        iStep.setName(stepValue);
        JBehaveExecution.startStep(iStep);
    }

    private void afterStep(Status status) {
        JBehaveExecution.getStep().setStatus(status);
        JBehaveExecution.endStep();
    }

    @Override
    public void successful(String step) {
        afterStep(Status.PASSED);
    }

    @Override
    public void ignorable(String step) {
        afterStep(Status.SKIPPED);
    }

    @Override
    public void comment(String step) {
        afterStep(Status.PASSED);
    }

    @Override
    public void pending(String step) {
        afterStep(Status.INCOMPLETE);
    }

    @Override
    public void notPerformed(String step) {
        afterStep(Status.SKIPPED);
    }

    @Override
    public void failed(String step, Throwable cause) {
        JBehaveExecution.getStep().setBug(generateBug(cause));
        afterStep(Status.FAILED);
    }

    private Bug generateBug(Throwable throwable) {
        Bug bug = new Bug();
        if (throwable != null) {
            bug.setMessage(ExceptionUtils.getRootCauseMessage(throwable));
            bug.setStackTrace(ExceptionUtils.getStackTrace(throwable));
        }
        return bug;
    }
}