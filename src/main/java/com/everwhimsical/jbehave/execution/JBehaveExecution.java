package com.everwhimsical.jbehave.execution;

import java.util.HashMap;
import java.util.Map;
import org.jbehave.core.model.Scenario;
import org.jbehave.core.model.Story;

/**
 * JBehave Utility class to get {@link Story}, {@link Scenario}, Examples and Step information.
 */
public class JBehaveExecution {

    private static final ThreadLocal<Story> STORY_THREAD = new InheritableThreadLocal<>();
    private static final ThreadLocal<Scenario> SCENARIO_THREAD = new InheritableThreadLocal<>();
    private static final ThreadLocal<String> STEP_THREAD = new InheritableThreadLocal<>();
    private static final ThreadLocal<Map<String, String>> EXAMPLE_THREAD = InheritableThreadLocal
        .withInitial(HashMap::new);

    /**
     * Invoked before Story executes and saves it.
     *
     * @param story {@link Story} object.
     */
    public synchronized static void startStory(Story story) {
        STORY_THREAD.set(story);
    }

    /**
     * Get the current Story.
     *
     * @return {@link Story} object.
     */
    public synchronized static Story getStory() {
        return STORY_THREAD.get();
    }

    /**
     * End and clear the current story.
     */
    public synchronized static void endStory() {
        STORY_THREAD.remove();
    }

    /**
     * Invoked before Scenario executes and saves it.
     *
     * @param scenario {@link Scenario} object.
     */
    public synchronized static void startScenario(Scenario scenario) {
        SCENARIO_THREAD.set(scenario);
    }

    /**
     * Get the current Scenario.
     *
     * @return {@link Scenario} object.
     */
    public synchronized static Scenario getScenario() {
        return SCENARIO_THREAD.get();
    }

    /**
     * End and clear the current scenario.
     */
    public synchronized static void endScenario() {
        SCENARIO_THREAD.remove();
    }

    /**
     * Invoked before Step executes and saves it.
     *
     * @param step Step name.
     */
    public synchronized static void startStep(String step) {
        STEP_THREAD.set(step);
    }

    /**
     * Get the current Step name.
     *
     * @return Step name.
     */
    public synchronized static String getStep() {
        return STEP_THREAD.get();
    }

    /**
     * End and clear the current step.
     */
    public synchronized static void endStep() {
        STEP_THREAD.remove();
    }

    /**
     * Invoked before Scenario executes and saves the example rows.
     *
     * @param exampleRows Example rows if present.
     */
    public synchronized static void startExample(Map<String, String> exampleRows) {
        EXAMPLE_THREAD.set(exampleRows);
    }

    /**
     * Get the current Scenario's example rows.
     *
     * @return Example Rows as a Map.
     */
    public synchronized static Map<String, String> getExample() {
        return EXAMPLE_THREAD.get();
    }

    /**
     * End and clear the current scenario's example row after scenario ends.
     */
    public synchronized static void endExample() {
        EXAMPLE_THREAD.remove();
    }
}
