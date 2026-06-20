package com.velox.dto;

import java.time.LocalDateTime;

public class NetworkDlpRequestDto {

    private String branchname;
    private String username;
    private String eventType;
    private String fileSourcePath;
    private LocalDateTime timestamp;

    public NetworkDlpRequestDto() {
    }

    public String getBranchname() {
        return branchname;
    }

    public void setBranchname(String branchname) {
        this.branchname = branchname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getFileSourcePath() {
        return fileSourcePath;
    }

    public void setFileSourcePath(String fileSourcePath) {
        this.fileSourcePath = fileSourcePath;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}