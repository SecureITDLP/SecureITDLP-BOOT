package com.velox.model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "network_dlp")
public class NetworkDlpEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sr_no")
    private Long srNo;

    @Column(name = "branchname")
    private String branchName;

    @Column(name = "hostname")
    private String hostname;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "username")
    private String username;

    @Column(name = "event_type")
    private String eventType;

    @Column(name = "file_source_path", length = 1000)
    private String fileSourcePath;

    @Column(name = "file_name", length = 500)
    private String fileName;

    @Column(name = "destination_path", length = 1000)
    private String destinationPath;

    @Column(name = "extension", length = 100)
    private String extension;

    @Lob
    @Column(name = "file_data", columnDefinition = "LONGBLOB")
    private byte[] fileData;   // LONGBLOB maps to byte[]

    @Column(name = "application_name")
    private String applicationName;

    @Column(name = "timestamp", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;    // Maps to TIMESTAMP, uses DB default CURRENT_TIMESTAMP

    @Column(name = "keyword", length = 1000)
    private String keyword;

    @Column(name = "regex_pattern", length = 1000)
    private String regexPattern;

    @Column(name = "action")
    private String action;

    // Default constructor (required by JPA)
    public NetworkDlpEntity() {
        super();
    }

    // Getters and Setters
    public Long getSrNo() { return srNo; }
    public void setSrNo(Long srNo) { this.srNo = srNo; }

    public String getBranchName() { return branchName; }
    public void setBranchName(String branchName) { this.branchName = branchName; }

    public String getHostname() { return hostname; }
    public void setHostname(String hostname) { this.hostname = hostname; }

    public String getIpAddress() { return ipAddress; }
    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEventType() { return eventType; }
    public void setEventType(String eventType) { this.eventType = eventType; }

    public String getFileSourcePath() { return fileSourcePath; }
    public void setFileSourcePath(String fileSourcePath) { this.fileSourcePath = fileSourcePath; }

    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }

    public String getDestinationPath() { return destinationPath; }
    public void setDestinationPath(String destinationPath) { this.destinationPath = destinationPath; }

    public String getExtension() { return extension; }
    public void setExtension(String extension) { this.extension = extension; }

    public byte[] getFileData() { return fileData; }
    public void setFileData(byte[] fileData) { this.fileData = fileData; }

    public String getApplicationName() { return applicationName; }
    public void setApplicationName(String applicationName) { this.applicationName = applicationName; }

    public Date getTimestamp() { return timestamp; }
    public void setTimestamp(Date timestamp) { this.timestamp = timestamp; }

    public String getKeyword() { return keyword; }
    public void setKeyword(String keyword) { this.keyword = keyword; }

    public String getRegexPattern() { return regexPattern; }
    public void setRegexPattern(String regexPattern) { this.regexPattern = regexPattern; }

    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }

    @Override
    public String toString() {
        return "NetworkDlpEntity [srNo=" + srNo + ", branchName=" + branchName + ", hostname=" + hostname
                + ", ipAddress=" + ipAddress + ", username=" + username + ", eventType=" + eventType
                + ", fileName=" + fileName + ", timestamp=" + timestamp + "]";
    }
}
