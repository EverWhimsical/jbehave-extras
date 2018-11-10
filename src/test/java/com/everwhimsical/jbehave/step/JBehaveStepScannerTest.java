package com.everwhimsical.jbehave.step;

import org.junit.Assert;
import org.junit.Test;

public class JBehaveStepScannerTest {

    @Test
    public void testGetAllSteps() {
        JBehaveStepScanner jBehaveStepScanner = new JBehaveStepScanner(
            "com.everwhimsical.jbehave.step.classes.clean");
        Assert.assertEquals("Mismatch in All step count",
            7, jBehaveStepScanner.getAllSteps().size());
    }

    @Test
    public void testGetAllStepsWithAlias() {
        JBehaveStepScanner jBehaveStepScanner = new JBehaveStepScanner(
            "com.everwhimsical.jbehave.step.classes.clean");
        jBehaveStepScanner.setAliasScan(true);
        Assert.assertEquals("Mismatch in All step count",
            10, jBehaveStepScanner.getAllSteps().size());
    }

    @Test
    public void testGetDuplicateSteps() {
        JBehaveStepScanner jBehaveStepScanner = new JBehaveStepScanner(
            "com.everwhimsical.jbehave.step.classes.duplicate");
        Assert.assertEquals("Mismatch in Duplicate step count",
            3, jBehaveStepScanner.getDuplicateSteps().size());
    }

    @Test
    public void testGetDuplicateStepsWithAlias() {
        JBehaveStepScanner jBehaveStepScanner = new JBehaveStepScanner(
            "com.everwhimsical.jbehave.step.classes.duplicate");
        jBehaveStepScanner.setAliasScan(true);
        Assert.assertEquals("Mismatch in Duplicate step count",
            4, jBehaveStepScanner.getDuplicateSteps().size());
    }
}