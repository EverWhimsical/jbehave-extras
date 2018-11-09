package com.everwhimsical.jbehave.step.classes.duplicate;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class Step2 {

    @Given("I open Home Page")
    public void given1() {

    }

    @Given("I open Home Page")
    @Alias("I Open Home Page")
    @Aliases(values = {"I open Home Page", "I Open Home Page"})
    public void given2() {

    }

    @Aliases(values = {"I open Home Page", "I Open Home Page"})
    public void given3() {

    }

    @When("I click header 1")
    public void when1() {

    }

    @When("I click header 1")
    public void when2() {

    }

    @Then("I verify header 1")
    public void then1() {

    }

    @Then("I verify header 1")
    public void then2() {

    }

    @Then("I verify header 1")
    public void then3() {

    }

    @Then("I verify header 1")
    public void then4() {

    }
}
