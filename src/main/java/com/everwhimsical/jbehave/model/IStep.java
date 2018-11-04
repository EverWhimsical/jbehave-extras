package com.everwhimsical.jbehave.model;

import com.everwhimsical.jbehave.internal.Commons;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class IStep {

    private String id;
    private String name;
    private ZonedDateTime startDateTime;
    private ZonedDateTime endDateTime;
    private String duration;
    private Status statusEnum;
    private List<String> logOutput;
    private String status;
    private Bug bug;
    private String stepClass;
    private String annotation;
    private String stepMethod;

    public IStep() {
        this.logOutput = new ArrayList<>();
        this.statusEnum = Status.PASSED;
        this.status = Status.PASSED.getDisplayValue();
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

    public ZonedDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(ZonedDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public ZonedDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(ZonedDateTime endDateTime) {
        this.endDateTime = endDateTime;
        this.duration = Commons.calculateDuration(startDateTime, endDateTime);
    }

    public String getDuration() {
        return duration;
    }

    public Status getStatusEnum() {
        return statusEnum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.statusEnum = status;
        this.status = status.getDisplayValue();
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
        setStartDateTime(ZonedDateTime.now(ZoneOffset.UTC));
    }

    public void updateStepEnd() {
        setEndDateTime(ZonedDateTime.now(ZoneOffset.UTC));
    }

    @Override
    public String toString() {
        return "IStep{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", startDateTime=" + startDateTime +
            ", duration='" + duration + '\'' +
            ", status=" + status +
            ", bug=" + bug +
            '}';
    }
}
