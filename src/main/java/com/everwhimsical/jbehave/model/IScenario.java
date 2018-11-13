package com.everwhimsical.jbehave.model;

import com.everwhimsical.jbehave.internal.Commons;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class IScenario {

    private String id;
    private String name;
    private String description;
    private String startDateTime;
    private String endDateTime;
    private Map<String, String> meta;
    private Map<String, String> exampleRows;
    private String duration;
    private Status status;
    private List<IStep> ISteps;

    public IScenario() {
        this.meta = new HashMap<>();
        this.exampleRows = new HashMap<>();
        this.ISteps = new LinkedList<>();
        this.status = Status.PASSED;
    }

    public void generateId(String name) {
        this.id = String.format("%s_%s_%s", name, System.currentTimeMillis(),
            Thread.currentThread().getId());
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
        generateId(name);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDateTime() {
        return startDateTime;
    }

    public String getEndDateTime() {
        return endDateTime;
    }

    public Map<String, String> getMeta() {
        return meta;
    }

    public void setMeta(Map<String, String> meta) {
        this.meta = meta;
    }

    public Map<String, String> getExampleRows() {
        return exampleRows;
    }

    public void setExampleRows(Map<String, String> exampleRows) {
        this.exampleRows = exampleRows;
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

    public List<IStep> getISteps() {
        return ISteps;
    }

    public void setISteps(List<IStep> ISteps) {
        this.ISteps = ISteps;
    }

    public void addStep(IStep iStep) {
        this.ISteps.add(iStep);
    }

    public void updateScenarioStart() {
        this.startDateTime = ZonedDateTime.now(ZoneOffset.UTC).toString();
    }

    public void updateScenarioEnd() {
        this.endDateTime = ZonedDateTime.now(ZoneOffset.UTC).toString();
        this.duration = Commons.calculateDuration(ZonedDateTime.parse(startDateTime),
            ZonedDateTime.parse(endDateTime));
    }

    @Override
    public String toString() {
        return "IScenario{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", startDateTime='" + startDateTime + '\'' +
            ", endDateTime='" + endDateTime + '\'' +
            ", meta=" + meta +
            ", exampleRows=" + exampleRows +
            ", duration='" + duration + '\'' +
            ", status=" + status +
            ", ISteps=" + ISteps.size() +
            '}';
    }
}
