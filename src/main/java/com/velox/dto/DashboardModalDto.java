package com.velox.dto;

import java.time.LocalDateTime;

public class DashboardModalDto {

    private String branchname;
    private String username;
    private String eventType;
    private String fileSourcePath;
    private LocalDateTime timestamp;

    public DashboardModalDto(String branchname, String username,
                             String eventType, String fileSourcePath,
                             LocalDateTime timestamp) {
        this.branchname = branchname;
        this.username = username;
        this.eventType = eventType;
        this.fileSourcePath = fileSourcePath;
        this.timestamp = timestamp;
    }

    public String getBranchname() {
        return branchname;
    }

    public String getUsername() {
        return username;
    }

    public String getEventType() {
        return eventType;
    }

    public String getFileSourcePath() {
        return fileSourcePath;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}