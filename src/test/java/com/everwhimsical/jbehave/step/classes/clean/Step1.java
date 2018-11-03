package com.everwhimsical.jbehave.step.classes.clean;

import com.everwhimsical.jbehave.execution.JBehaveExecution;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class Step1 {

    void printMethodName() {
        System.out.println("Method: " + Thread.currentThread().getStackTrace()[2].getMethodName());
    }

    @Given("I open Home Page")
    public void given1() {
        printMethodName();
        System.out.println(JBehaveExecution.getStory().getName());
        System.out.println(JBehaveExecution.getScenario().getTitle());
        System.out.println(JBehaveExecution.getStep());
        System.out.println(JBehaveExecution.getExample());
    }

    @Given("I open Login Page")
    public void given2() {
        printMethodName();
    }

    @When("I click header 1")
    public void when1() {
        printMethodName();
    }

    @When("I click header 2")
    public void when2() {
        printMethodName();
    }

    @Then("I verify header 1")
    public void then1() {
        printMethodName();
        System.out.println(JBehaveExecution.getStep());
    }

    @Then("I verify header 2")
    public void then2() {
        printMethodName();
    }

    @Then("I print <symbol>")
    public void then3(@Named("symbol") String symbol) {
        printMethodName();
        System.out.println(symbol);
    }
}
