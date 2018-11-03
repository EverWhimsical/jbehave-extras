package com.everwhimsical.jbehave.step;

import java.util.Objects;

/**
 * Step Information model.
 */
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

    /**
     * Get the Annotation as String
     *
     * @return {@link org.jbehave.core.annotations.Given}, {@link org.jbehave.core.annotations.When},
     * {@link org.jbehave.core.annotations.Then} value
     */
    public String getAnnotation() {
        return annotation;
    }

    void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    /**
     * Get the step name.
     *
     * @return Step name as String.
     */
    public String getStep() {
        return step;
    }

    void setStep(String step) {
        this.step = step;
    }

    /**
     * Get the qualified class name
     *
     * @return class name as String.
     */
    public String getClassName() {
        return className;
    }

    void setClassName(String className) {
        this.className = className;
    }

    /**
     * Get the method name.
     *
     * @return method name as String.
     */
    public String getMethodName() {
        return methodName;
    }

    void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    /**
     * Get step name with annotation.
     *
     * @return step name.
     */
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
