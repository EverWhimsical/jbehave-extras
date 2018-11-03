package com.everwhimsical.jbehave.step;

import java.util.Objects;

public class JBehaveStepInfo {

    private String annotation;
    private String step;
    private String className;
    private String methodName;

    JBehaveStepInfo(String annotation, String step, String className,
        String methodName) {
        this.annotation = annotation;
        this.step = step;
        this.className = className;
        this.methodName = methodName;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getAnnotatedStep() {
        return annotation + " " + step;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        JBehaveStepInfo that = (JBehaveStepInfo) o;
        return Objects.equals(getAnnotatedStep(), that.getAnnotatedStep());
    }

    @Override
    public int hashCode() {
        return Objects.hash(annotation, step, className, methodName);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("JBehaveStepInfo{");
        sb.append("annotation='").append(getAnnotation()).append('\'');
        sb.append(", step='").append(getStep()).append('\'');
        sb.append(", className='").append(getClassName()).append('\'');
        sb.append(", methodName='").append(getMethodName()).append('\'');
        sb.append(", annotatedStep='").append(getAnnotatedStep()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
