package com.everwhimsical.jbehave.model;

import com.everwhimsical.jbehave.internal.Commons;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class IScenario {

    private String id;
    private String name;
    private ZonedDateTime startDateTime;
    private ZonedDateTime endDateTime;
    private Map<String, String> meta;
    private Map<String, String> exampleRows;
    private String duration;
    private Status statusEnum;
    private String status;
    private List<IStep> ISteps;

    public IScenario() {
        this.meta = new HashMap<>();
        this.exampleRows = new HashMap<>();
        this.ISteps = new LinkedList<>();
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

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDuration() {
        return duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.statusEnum = status;
        this.status = status.getDisplayValue();
    }

    public Status getStatusEnum() {
        return statusEnum;
    }

    public List<IStep> getISteps() {
        if (ISteps == null) {
            ISteps = new ArrayList<>();
        }
        return ISteps;
    }

    public void setISteps(List<IStep> ISteps) {
        this.ISteps = ISteps;
    }

    public void addStep(IStep iStep) {
        this.ISteps.add(iStep);
    }

    public void updateScenarioStart() {
        setStartDateTime(ZonedDateTime.now(ZoneOffset.UTC));
    }

    public void updateScenarioEnd() {
        setEndDateTime(ZonedDateTime.now(ZoneOffset.UTC));
    }

    @Override
    public String toString() {
        return "IScenario{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", startDateTime=" + startDateTime +
            ", duration='" + duration + '\'' +
            ", status=" + status +
            ", ISteps=" + ISteps +
            '}';
    }
}
