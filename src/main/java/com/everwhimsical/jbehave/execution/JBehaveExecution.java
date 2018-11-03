package com.everwhimsical.jbehave.execution;

import java.util.HashMap;
import java.util.Map;
import org.jbehave.core.model.Scenario;
import org.jbehave.core.model.Story;

public class JBehaveExecution {

    private static final ThreadLocal<Story> STORY_THREAD = new InheritableThreadLocal<>();
    private static final ThreadLocal<Scenario> SCENARIO_THREAD = new InheritableThreadLocal<>();
    private static final ThreadLocal<String> STEP_THREAD = new InheritableThreadLocal<>();
    private static final ThreadLocal<Map<String, String>> EXAMPLE_THREAD = InheritableThreadLocal
        .withInitial(HashMap::new);

    public synchronized static void startStory(Story story) {
        STORY_THREAD.set(story);
    }

    public synchronized static Story getStory() {
        return STORY_THREAD.get();
    }

    public synchronized static void endStory() {
        STORY_THREAD.remove();
    }

    public synchronized static void startScenario(Scenario scenario) {
        SCENARIO_THREAD.set(scenario);
    }

    public synchronized static Scenario getScenario() {
        return SCENARIO_THREAD.get();
    }

    public synchronized static void endScenario() {
        SCENARIO_THREAD.remove();
    }

    public synchronized static void startStep(String step) {
        STEP_THREAD.set(step);
    }

    public synchronized static String getStep() {
        return STEP_THREAD.get();
    }

    public synchronized static void endStep() {
        STEP_THREAD.remove();
    }

    public synchronized static void startExample(Map<String, String> exampleRows) {
        EXAMPLE_THREAD.set(exampleRows);
    }

    public synchronized static Map<String, String> getExample() {
        return EXAMPLE_THREAD.get();
    }

    public synchronized static void endExample() {
        EXAMPLE_THREAD.remove();
    }
}
