package com.everwhimsical.jbehave.reporter;

import org.jbehave.core.reporters.StoryReporter;
import org.jbehave.core.reporters.StoryReporterBuilder;

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