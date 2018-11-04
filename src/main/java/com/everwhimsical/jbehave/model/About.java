package com.everwhimsical.jbehave.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

public class About {

    private String runId;
    private String projectName;
    private String team;
    private String releaseVersion;
    private String executionOS;
    private String environment;
    private String environmentHealth;
    private String userName;
    private List<String> remoteList;
    private String branch;
    private String testToolName;
    private String frameworkName;
    private String frameworkVersion;

    public About() {
        this.executionOS = System.getProperty("os.name") + " " + System.getProperty("os.version");
        this.userName = System.getProperty("user.name");
        this.testToolName = "JBehave";
        this.remoteList = new ArrayList<>();
    }

    public static About generateAbout() {
        About about = new About();
        about.setProjectName("JBehave Example");
        about.setTeam("Lone Star");
        about.setReleaseVersion("1.0.0");
        about.setEnvironment("DEV");
        about.setFrameworkName("JUnit");
        about.setFrameworkVersion("4.12");
        return about;
    }

    public void addGitInformation() {
        try {
            FileRepositoryBuilder repositoryBuilder = new FileRepositoryBuilder();
            Repository repository = repositoryBuilder
                .setGitDir(new File(System.getProperty("user.dir") + File.separator + ".git"))
                .readEnvironment()
                .findGitDir()
                .setMustExist(true)
                .build();
            setBranch(repository.getBranch());
            repository.getConfig().getSubsections("remote")
                .forEach(subSection -> {
                    String remote = repository.getConfig().getString("remote", subSection, "url");
                    addRemote(remote);
                });

        } catch (Exception ignored) {

        }
    }

    public String getRunId() {
        return runId;
    }

    public void setRunId(String runId) {
        this.runId = runId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getReleaseVersion() {
        return releaseVersion;
    }

    public void setReleaseVersion(String releaseVersion) {
        this.releaseVersion = releaseVersion;
    }

    public String getExecutionOS() {
        return executionOS;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getEnvironmentHealth() {
        return environmentHealth;
    }

    public void setEnvironmentHealth(String environmentHealth) {
        this.environmentHealth = environmentHealth;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getRemoteList() {
        return remoteList;
    }

    public void setRemoteList(List<String> remoteList) {
        this.remoteList = remoteList;
    }

    public void addRemote(String remote) {
        this.remoteList.add(remote);
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getTestToolName() {
        return testToolName;
    }

    public void setTestToolName(String testToolName) {
        this.testToolName = testToolName;
    }

    public String getFrameworkName() {
        return frameworkName;
    }

    public void setFrameworkName(String frameworkName) {
        this.frameworkName = frameworkName;
    }

    public String getFrameworkVersion() {
        return frameworkVersion;
    }

    public void setFrameworkVersion(String frameworkVersion) {
        this.frameworkVersion = frameworkVersion;
    }
}
