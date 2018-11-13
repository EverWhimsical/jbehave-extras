package com.everwhimsical.jbehave;

import com.everwhimsical.jbehave.execution.ExecutionModelReporter;
import com.everwhimsical.jbehave.execution.JBehaveExecution;
import com.everwhimsical.jbehave.model.About;
import com.everwhimsical.jbehave.step.classes.clean.Step1;
import com.github.valfirst.jbehave.junit.monitoring.JUnitReportingRunner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

//@RunWith(JUnitReportingRunner.class)
public class JBehaveExampleTest extends JUnitStory {

    private static final Gson GSON_PRETTY = new GsonBuilder().setPrettyPrinting().create();

    @Before
    public void setup() {
        JBehaveExecution.startExecution();
        About about = About.generateAbout();
        about.addGitInformation();
        JBehaveExecution.getExecution().setAbout(about);
    }

    @After
    public void teardown() throws IOException {
        JBehaveExecution.endExecution();
        ReportBuilder.buildSlingshotV1Report();
        System.out.println(GSON_PRETTY.toJson(JBehaveExecution.getExecution()));
    }

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
            .useStoryPathResolver(embeddableClass -> "com/everwhimsical/jbehave/Simple.story")
            .useStoryReporterBuilder(
                new StoryReporterBuilder()
                    .withDefaultFormats()
                    .withReporters(new ExecutionModelReporter())
                    .withFormats(Format.CONSOLE));
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new Step1());
    }
}