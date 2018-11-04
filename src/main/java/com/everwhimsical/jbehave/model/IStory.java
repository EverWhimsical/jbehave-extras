package com.everwhimsical.jbehave.model;

import com.everwhimsical.jbehave.internal.Commons;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.LinkedList;
import java.util.List;

public class IStory {

    private String id;
    private String name;
    private String description;
    private String path;
    private ZonedDateTime startDateTime;
    private ZonedDateTime endDateTime;
    private String duration;
    private Status statusEnum;
    private String status;
    private List<IScenario> IScenarios;

    public IStory() {
        this.IScenarios = new LinkedList<>();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

    public void setStatus(String status) {
        this.status = status;
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

    public List<IScenario> getIScenarios() {
        return IScenarios;
    }

    public void setIScenarios(List<IScenario> IScenarios) {
        this.IScenarios = IScenarios;
    }

    public void addScenario(IScenario iScenario) {
        this.IScenarios.add(iScenario);
    }

    public void updateTestSuiteStart() {
        setStartDateTime(ZonedDateTime.now(ZoneOffset.UTC));
    }

    public void updateTestSuiteEnd() {
        setEndDateTime(ZonedDateTime.now(ZoneOffset.UTC));
    }

    @Override
    public String toString() {
        return "IStory{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", startDateTime=" + startDateTime +
            ", duration='" + duration + '\'' +
            ", status=" + status +
            ", IScenarios=" + IScenarios +
            '}';
    }
}
