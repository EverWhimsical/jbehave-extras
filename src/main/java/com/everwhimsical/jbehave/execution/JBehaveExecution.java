package com.everwhimsical.jbehave.execution;

import com.everwhimsical.jbehave.model.IExecution;
import com.everwhimsical.jbehave.model.IScenario;
import com.everwhimsical.jbehave.model.IStep;
import com.everwhimsical.jbehave.model.IStory;
import java.util.Optional;

/**
 * JBehave Utility class to get {@link IStory}, {@link IScenario}, {@link IStep} information.
 */
public class JBehaveExecution {

    private static IExecution IEXECUTION = new IExecution();
    private static final ThreadLocal<IStory> STORY_THREAD = new InheritableThreadLocal<>();
    private static final ThreadLocal<IScenario> SCENARIO_THREAD = new InheritableThreadLocal<>();
    private static final ThreadLocal<IStep> STEP_THREAD = new InheritableThreadLocal<>();

    /**
     * Invoked before Execution starts and saves it.
     */
    public synchronized static void startExecution() {
        getExecution().startExecution();
    }

    /**
     * Get the current Execution.
     *
     * @return {@link IExecution} object.
     */
    public synchronized static IExecution getExecution() {
        return IEXECUTION;
    }

    /**
     * End and clear the current Execution.
     */
    public synchronized static void endExecution() {
        updateStatus(getExecution());
        getExecution().endExecution();
    }

    /**
     * Invoked before IStory executes and saves it.
     *
     * @param IStory {@link IStory} object.
     */
    public synchronized static void startStory(IStory IStory) {
        STORY_THREAD.set(IStory);
    }

    /**
     * Get the current IStory.
     *
     * @return {@link IStory} object.
     */
    public synchronized static IStory getStory() {
        return STORY_THREAD.get();
    }

    /**
     * End and clear the current story.
     */
    public synchronized static void endStory() {
        Optional.ofNullable(STORY_THREAD.get())
            .ifPresent(iStory -> {
                iStory.updateTestSuiteEnd();
                getExecution().addStory(iStory);
            });
        STORY_THREAD.remove();
    }

    /**
     * Invoked before IScenario executes and saves it.
     *
     * @param IScenario {@link IScenario} object.
     */
    public synchronized static void startScenario(IScenario IScenario) {
        SCENARIO_THREAD.set(IScenario);
    }

    /**
     * Get the current IScenario.
     *
     * @return {@link IScenario} object.
     */
    public synchronized static IScenario getScenario() {
        return SCENARIO_THREAD.get();
    }

    /**
     * End and clear the current scenario.
     */
    public synchronized static void endScenario() {
        Optional.ofNullable(SCENARIO_THREAD.get())
            .ifPresent(iScenario -> {
                iScenario.updateScenarioEnd();
                getStory().addScenario(iScenario);
            });
        SCENARIO_THREAD.remove();
    }

    /**
     * Invoked before IStep executes and saves it.
     *
     * @param IStep {@link IStep} object.
     */
    public synchronized static void startStep(IStep IStep) {
        STEP_THREAD.set(IStep);
    }

    /**
     * Get the current IStep name.
     *
     * @return step {@link IStep} object.
     */
    public synchronized static IStep getStep() {
        return STEP_THREAD.get();
    }

    /**
     * End and clear the current step.
     */
    public synchronized static void endStep() {
        Optional.ofNullable(STEP_THREAD.get())
            .ifPresent(iStep -> {
                iStep.updateStepEnd();
                getScenario().addStep(iStep);
            });
        STEP_THREAD.remove();
    }

    private synchronized static void updateStatus(IExecution IExecution) {
        for (IStory iStory : IExecution.getStories()) {

            // Set the status of Story
            for (IScenario iScenario : iStory.getIScenarios()) {

                // Set the status of Scenario
                for (IStep iStep : iScenario.getISteps()) {

                    if (iStep.getStatusEnum().getPriority() < iScenario.getStatusEnum()
                        .getPriority()) {
                        iScenario.setStatus(iStep.getStatusEnum());
                        iStory.setStatus(iStep.getStatusEnum());
                        IExecution.setStatus(iStep.getStatusEnum());
                        break;
                    }
                }
                if (iScenario.getStatusEnum().getPriority() < iStory.getStatusEnum()
                    .getPriority()) {
                    iStory.setStatus(iScenario.getStatusEnum());
                    IExecution.setStatus(iScenario.getStatusEnum());
                    break;
                }
            }

            if (iStory.getStatusEnum().getPriority() < IExecution.getStatusEnum()
                .getPriority()) {
                IExecution.setStatus(iStory.getStatusEnum());
                break;
            }
        }
    }
}
