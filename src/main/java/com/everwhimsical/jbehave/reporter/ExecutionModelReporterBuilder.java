package com.everwhimsical.jbehave.reporter;

import org.jbehave.core.reporters.StoryReporter;
import org.jbehave.core.reporters.StoryReporterBuilder;

/**
 * Extension of {@link StoryReporter}. <br /> Usage: <br />
 * <pre>
 * public Configuration configuration() {
 *      return new MostUsefulConfiguration()
 *      .useStoryPathResolver(embeddableClass -> "com/everwhimsical/jbehave/Simple.story")
 *      .useStoryReporterBuilder(
 *      new ExecutionModelReporterBuilder().withDefaultFormats().withFormats(Format.CONSOLE));
 * }
 * </pre>
 */
public class ExecutionModelReporterBuilder extends StoryReporterBuilder {

    @Override
    public StoryReporter build(String storyPath) {
        StoryReporter delegate = super.build(storyPath);
        if (!storyPath.endsWith(".story")) {
            return delegate;
        }
        return new ExecutionModelReporter(delegate);
    }

}