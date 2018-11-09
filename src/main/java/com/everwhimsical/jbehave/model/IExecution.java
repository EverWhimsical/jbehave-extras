package com.everwhimsical.jbehave.model;

import com.everwhimsical.jbehave.internal.Commons;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IExecution {

    private About about;
    private String id;
    private String name;
    private String startDateTime;
    private String endDateTime;
    private String duration;
    private Status status;
    private List<String> labels;
    private List<String> filters;
    private List<IStory> stories;

    public IExecution() {
        this.stories = new LinkedList<>();
        this.status = Status.PASSED;
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

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<String> getFilters() {
        return filters;
    }

    public void setFilters(List<String> filters) {
        this.filters = filters;
    }

    public List<IStory> getStories() {
        return stories;
    }

    public void setStories(List<IStory> stories) {
        this.stories = stories;
    }

    public void startExecution() {
        this.startDateTime = ZonedDateTime.now(ZoneOffset.UTC).toString();
    }

    public void endExecution() {
        this.endDateTime = ZonedDateTime.now(ZoneOffset.UTC).toString();
        this.duration = Commons.calculateDuration(ZonedDateTime.parse(startDateTime),
            ZonedDateTime.parse(endDateTime));
    }

    public void addStory(IStory iStory) {
        this.stories.add(iStory);
    }

    @Override
    public String toString() {
        return "IExecution{" +
            "about=" + about +
            ", id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", startDateTime='" + startDateTime + '\'' +
            ", endDateTime='" + endDateTime + '\'' +
            ", duration='" + duration + '\'' +
            ", status=" + status +
            ", labels=" + labels +
            ", filters=" + filters +
            ", stories=" + stories.size() +
            '}';
    }
}
