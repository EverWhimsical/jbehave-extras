package com.everwhimsical.jbehave;

import org.junit.Assert;
import org.junit.Test;

public class JBehaveStepScannerTest {

    @Test
    public void testGetAllSteps() {
        JBehaveStepScanner jBehaveStepScanner = new JBehaveStepScanner(
            "com.everwhimsical.jbehave.steps.clean");
        Assert.assertEquals("Mismatch in All step count",
            6, jBehaveStepScanner.getAllSteps().size());
    }

    @Test
    public void testGetDuplicateSteps() {
        JBehaveStepScanner jBehaveStepScanner = new JBehaveStepScanner(
            "com.everwhimsical.jbehave.steps.duplicate");
        Assert.assertEquals("Mismatch in Duplicate step count",
            8, jBehaveStepScanner.getDuplicateSteps().size());
    }
}