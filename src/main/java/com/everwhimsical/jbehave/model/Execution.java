package com.everwhimsical.jbehave.model;

import com.everwhimsical.jbehave.internal.Commons;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Execution {

    private About about;
    private String id;
    private String name;
    private ZonedDateTime startDateTime;
    private ZonedDateTime endDateTime;
    private String duration;
    private Status statusEnum;
    private String status;
    private List<String> filters;
    private List<Story> stories;

    public Execution() {
        this.stories = new LinkedList<>();
        this.statusEnum = Status.PASSED;
        this.status = Status.PASSED.getDisplayValue();
        this.filters = new ArrayList<>();
    }

    public About getAbout() {
        return about;
    }

    public void setAbout(About about) {
        this.about = about;
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
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
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

    public List<String> getFilters() {
        return filters;
    }

    public void setFilters(List<String> filters) {
        this.filters = filters;
    }

    public List<Story> getStories() {
        if (stories == null) {
            stories = new ArrayList<>();
        }
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    public void startExecution() {
        this.startDateTime = ZonedDateTime.now(ZoneOffset.UTC);
    }

    public void endExecution() {
        this.endDateTime = ZonedDateTime.now(ZoneOffset.UTC);
        this.duration = Commons.calculateDuration(startDateTime, endDateTime);
    }

    public void addTestSuite(Story story) {
        this.stories.add(story);
    }

    @Override
    public String toString() {
        return "Execution{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", startDateTime=" + startDateTime +
            ", duration='" + duration + '\'' +
            ", status=" + status +
            ", stories=" + stories +
            '}';
    }
}
