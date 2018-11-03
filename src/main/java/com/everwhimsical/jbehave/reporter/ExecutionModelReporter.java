package com.everwhimsical.jbehave.reporter;

import com.everwhimsical.jbehave.execution.JBehaveExecution;
import java.util.Map;
import org.jbehave.core.model.Scenario;
import org.jbehave.core.model.Story;
import org.jbehave.core.reporters.DelegatingStoryReporter;
import org.jbehave.core.reporters.StoryReporter;

public class ExecutionModelReporter extends DelegatingStoryReporter {

    private StoryReporter delegate;

    public ExecutionModelReporter(StoryReporter delegate) {
        this.delegate = delegate;
    }

    @Override
    public void beforeStory(Story story, boolean givenStory) {
        delegate.beforeStory(story, givenStory);
        JBehaveExecution.startStory(story);
    }

    @Override
    public void afterStory(boolean givenOrRestartingStory) {
        delegate.afterStory(givenOrRestartingStory);
        JBehaveExecution.endStory();
    }

    @Override
    public void beforeScenario(Scenario scenario) {
        delegate.beforeScenario(scenario);
        JBehaveExecution.startScenario(scenario);
    }

    @Override
    public void afterScenario() {
        delegate.afterScenario();
        JBehaveExecution.endExample();
        JBehaveExecution.endScenario();
    }

    @Override
    public void example(Map<String, String> tableRow) {
        delegate.example(tableRow);
        JBehaveExecution.startExample(tableRow);
    }

    @Override
    public void beforeStep(String step) {
        delegate.beforeStep(step);
        JBehaveExecution.startStep(step);
    }

    @Override
    public void successful(String step) {
        delegate.successful(step);
        JBehaveExecution.endStep();
    }

    @Override
    public void ignorable(String step) {
        delegate.ignorable(step);
        JBehaveExecution.endStep();
    }

    @Override
    public void comment(String step) {
        delegate.comment(step);
        JBehaveExecution.endStep();
    }

    @Override
    public void pending(String step) {
        delegate.pending(step);
        JBehaveExecution.endStep();
    }

    @Override
    public void notPerformed(String step) {
        delegate.notPerformed(step);
        JBehaveExecution.endStep();
    }

    @Override
    public void failed(String step, Throwable cause) {
        delegate.failed(step, cause);
        JBehaveExecution.endStep();
    }
}