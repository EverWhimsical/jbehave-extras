# JBehave Extras

[![Build Status](https://travis-ci.org/EverWhimsical/jbehave-extras.svg?branch=master)](https://travis-ci.org/EverWhimsical/jbehave-extras)

Simple utility classes to gather information about your JBehave project and execution.

## Usage
### JBehaveStepScanner
Easily get all steps and duplicate steps in your project by using [JBehaveStepScanner](src/main/java/com/everwhimsical/jbehave/step/JBehaveStepScanner.java)

Using the result list, it can be used to fail the execution before picking up stories if duplicate steps are found.
```java
    @org.junit.Before
    public void verifySteps() {
        JBehaveStepScanner jBehaveStepScanner = new JBehaveStepScanner(
                    "com.everwhimsical.jbehave.step.classes.clean",
                    "com.everwhimsical.jbehave.step.classes.duplicate");
        List<JBehaveStepInfo> duplicateSteps = jBehaveStepScanner.getDuplicateSteps();
        if (duplicateSteps.size() > 0) {
            Assert.fail("Duplicate steps found");
        }
    }
```

Or we can just print all the steps information.
```java
    @org.junit.Before
    public void verifySteps() {
        JBehaveStepScanner jBehaveStepScanner = new JBehaveStepScanner(
                    "com.everwhimsical.jbehave.step.classes.clean",
                    "com.everwhimsical.jbehave.step.classes.duplicate");
        List<JBehaveStepInfo> allSteps = jBehaveStepScanner.getAllSteps();
        allSteps.forEach(System.out::println);
    }
```


### JBehaveExecution
Get information about the current Story, Scenario, Step, Examples in a thread-safe manner using [JBehaveExecution](src/main/java/com/everwhimsical/jbehave/execution/JBehaveExecution.java)

Add the [ExecutionModelReporter](src/main/java/com/everwhimsical/jbehave/execution/ExecutionModelReporter.java) to your configuration as below and use the methods in JBehaveExecution.
```java
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
```

To get information about entities, use the below methods


* Execution -> [JBehaveExecution.getExecution](src/main/java/com/everwhimsical/jbehave/execution/JBehaveExecution.java#L31)
* Story -> [JBehaveExecution.getStory](src/main/java/com/everwhimsical/jbehave/execution/JBehaveExecution.java#L57)
* Scenario -> [JBehaveExecution.getScenario](src/main/java/com/everwhimsical/jbehave/execution/JBehaveExecution.java#L87)
* Step -> [JBehaveExecution.getStep](src/main/java/com/everwhimsical/jbehave/execution/JBehaveExecution.java#L117)

Using these entities build your custom reporter with ease.

