package com.velox.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class LatestIncidentDto {
    private String ipAddress;
    private String username;
    private String eventType;
    private String fileDetails;
    private String fileSourcePath; // from file_source_path
    private LocalDateTime timestamp;

    // Default constructor (required for JSON deserialization)
    public LatestIncidentDto() {}

//    // All-args constructor for JPQL projection
//    public LatestIncidentDto(String ipAddress, String username, String eventType, 
//                             String fileDetails, Date timestamp) {
//        this.ipAddress = ipAddress;
//        this.username = username;
//        this.eventType = eventType;
//        this.fileDetails = fileDetails;
//        this.timestamp = timestamp;
//    }
    public LatestIncidentDto(String ipAddress,
            String username,
            String eventType,
            String fileSourcePath,
            LocalDateTime timestamp) {
this.ipAddress = ipAddress;
this.username = username;
this.eventType = eventType;
this.fileSourcePath = fileSourcePath;
this.timestamp = timestamp;
}
    // Getters and Setters
    public String getIpAddress() { return ipAddress; }
    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEventType() { return eventType; }
    public void setEventType(String eventType) { this.eventType = eventType; }

    public String getFileDetails() { return fileDetails; }
    public void setFileDetails(String fileDetails) { this.fileDetails = fileDetails; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
