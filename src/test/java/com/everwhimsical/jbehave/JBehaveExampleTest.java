package com.everwhimsical.jbehave;

import com.everwhimsical.jbehave.reporter.ExecutionModelReporterBuilder;
import com.everwhimsical.jbehave.step.classes.clean.Step1;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

public class JBehaveExampleTest extends JUnitStory {

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
            .useStoryPathResolver(embeddableClass -> "com/everwhimsical/jbehave/Simple.story")
            .useStoryReporterBuilder(
                new ExecutionModelReporterBuilder().withDefaultFormats().withFormats(
                    Format.CONSOLE));
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new Step1());
    }
}