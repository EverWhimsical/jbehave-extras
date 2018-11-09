package com.everwhimsical.jbehave.model;

import com.everwhimsical.jbehave.internal.Commons;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class IStep {

    private String id;
    private String name;
    private String startDateTime;
    private String endDateTime;
    private String duration;
    private Status status;
    private List<String> logOutput;
    private Bug bug;
    private String stepClass;
    private String annotation;
    private String stepMethod;

    public IStep() {
        this.logOutput = new ArrayList<>();
        this.status = Status.PASSED;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDateTime() {
        return startDateTime;
    }

    public String getEndDateTime() {
        return endDateTime;
    }

    public String getDuration() {
        return duration;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<String> getLogOutput() {
        return logOutput;
    }

    public void setLogOutput(List<String> logOutput) {
        this.logOutput = logOutput;
    }

    public void addLogOutput(String log) {
        this.logOutput.add(log);
    }

    public Bug getBug() {
        return bug;
    }

    public void setBug(Bug bug) {
        this.bug = bug;
    }

    public String getStepClass() {
        return stepClass;
    }

    public void setStepClass(String stepClass) {
        this.stepClass = stepClass;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getStepMethod() {
        return stepMethod;
    }

    public void setStepMethod(String stepMethod) {
        this.stepMethod = stepMethod;
    }

    public void updateStepStart() {
        this.startDateTime = ZonedDateTime.now(ZoneOffset.UTC).toString();
    }

    public void updateStepEnd() {
        this.endDateTime = ZonedDateTime.now(ZoneOffset.UTC).toString();
        this.duration = Commons.calculateDuration(ZonedDateTime.parse(startDateTime),
            ZonedDateTime.parse(endDateTime));
    }

    @Override
    public String toString() {
        return "IStep{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", startDateTime='" + startDateTime + '\'' +
            ", endDateTime='" + endDateTime + '\'' +
            ", duration='" + duration + '\'' +
            ", status=" + status +
            ", logOutput=" + logOutput +
            ", bug=" + bug +
            ", stepClass='" + stepClass + '\'' +
            ", annotation='" + annotation + '\'' +
            ", stepMethod='" + stepMethod + '\'' +
            '}';
    }
}
