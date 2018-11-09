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
    private String startDateTime;
    private String endDateTime;
    private String duration;
    private Status status;
    private List<IScenario> IScenarios;

    public IStory() {
        this.IScenarios = new LinkedList<>();
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
        this.startDateTime = ZonedDateTime.now(ZoneOffset.UTC).toString();
    }

    public void updateTestSuiteEnd() {
        this.endDateTime = ZonedDateTime.now(ZoneOffset.UTC).toString();
        this.duration = Commons.calculateDuration(ZonedDateTime.parse(startDateTime),
            ZonedDateTime.parse(endDateTime));

    }

    @Override
    public String toString() {
        return "IStory{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", path='" + path + '\'' +
            ", startDateTime='" + startDateTime + '\'' +
            ", endDateTime='" + endDateTime + '\'' +
            ", duration='" + duration + '\'' +
            ", status=" + status +
            ", IScenarios=" + IScenarios.size() +
            '}';
    }
}
