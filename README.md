# JBehave Extras

[![Build Status](https://travis-ci.org/EverWhimsical/jbehave-extras.svg?branch=master)](https://travis-ci.org/EverWhimsical/jbehave-extras)
[![License](https://img.shields.io/badge/license-Apache%202-blue.svg)](https://raw.githubusercontent.com/EverWhimsical/jbehave-extras/master/LICENSE)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.everwhimsical/jbehave-extras/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.everwhimsical/jbehave-extras)
[![Known Vulnerabilities](https://snyk.io/test/github/EverWhimsical/jbehave-extras/badge.svg?targetFile=pom.xml)](https://snyk.io/test/github/EverWhimsical/jbehave-extras?targetFile=pom.xml)

Simple utility classes to gather information about your JBehave project and execution.

## Usage

### JBehaveStepScanner
Easily get all steps and duplicate steps in your project by using [JBehaveStepScanner](src/main/java/com/everwhimsical/jbehave/step/JBehaveStepScanner.java)

We can process the result as per the requirement.
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

By default, `Given`, `When`, `Then` annotations are scanned. To include scanning of `@Alias` and `@Aliases` annotations, set the following attribute.
```
jBehaveStepScanner.setAliasScan(true);
```
#### Duplicate Steps

Using the duplicate result list, it can be used to fail the execution before executing stories.

```java
    @org.junit.Before
    public void verifySteps() {
        JBehaveStepScanner jBehaveStepScanner = new JBehaveStepScanner(
                    "com.everwhimsical.jbehave.step.classes.clean",
                    "com.everwhimsical.jbehave.step.classes.duplicate");
        List<DuplicateJBehaveStepInfo> duplicateSteps = jBehaveStepScanner.getDuplicateSteps();
        duplicateSteps.forEach(System.out::println);
        if (duplicateSteps.size() > 0) {
            Assert.fail("Duplicate steps found");
        }
    }
```
#### Duplicate Condition
* A step is considered duplicate if the annotation and step name is present more than once.
* If alias scanning is included, steps are considered duplicate if step name is present more than once.

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

