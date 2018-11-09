package com.everwhimsical.jbehave.model;

import java.util.List;

public class DuplicateJBehaveStepInfo {

    private final String annotatedStep;
    private final List<JBehaveStepInfo> jBehaveStepInfoList;

    public DuplicateJBehaveStepInfo(String annotatedStep,
        List<JBehaveStepInfo> jBehaveStepInfoList) {
        this.annotatedStep = annotatedStep;
        this.jBehaveStepInfoList = jBehaveStepInfoList;
    }

    public String getAnnotatedStep() {
        return annotatedStep;
    }

    public List<JBehaveStepInfo> getjBehaveStepInfoList() {
        return jBehaveStepInfoList;
    }

    @Override
    public String toString() {
        return "DuplicateJBehaveStepInfo{" +
            "annotatedStep='" + getAnnotatedStep() + '\'' +
            ", duplicateCount=" + getjBehaveStepInfoList().size() +
            '}';
    }
}
