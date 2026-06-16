package com.velox.model;   // or your preferred package

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "application_info_report")
public class ApplicationInfoReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sr_no")
    private Long srNo;

    @Column(name = "application_hash", length = 255)
    private String applicationHash;

    @Column(name = "application_name", length = 255)
    private String applicationName;

    @Column(name = "application_path", length = 1000)
    private String applicationPath;

    @Column(name = "group_name", length = 100)
    private String groupName;

    @Column(name = "c_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cTime;

    @Column(name = "host_name", length = 255)
    private String hostName;

    @Column(name = "ip_address", length = 255)
    private String ipAddress;

    @Column(name = "one_time", length = 10)
    private String oneTime;

    @Column(name = "user_name", length = 255)
    private String userName;

    // No constructors – Java provides the default no‑arg constructor

    // Getters and Setters
    public Long getSrNo() { return srNo; }
    public void setSrNo(Long srNo) { this.srNo = srNo; }

    public String getApplicationHash() { return applicationHash; }
    public void setApplicationHash(String applicationHash) { this.applicationHash = applicationHash; }

    public String getApplicationName() { return applicationName; }
    public void setApplicationName(String applicationName) { this.applicationName = applicationName; }

    public String getApplicationPath() { return applicationPath; }
    public void setApplicationPath(String applicationPath) { this.applicationPath = applicationPath; }

    public String getGroupName() { return groupName; }
    public void setGroupName(String groupName) { this.groupName = groupName; }

    public Date getCTime() { return cTime; }
    public void setCTime(Date cTime) { this.cTime = cTime; }

    public String getHostName() { return hostName; }
    public void setHostName(String hostName) { this.hostName = hostName; }

    public String getIpAddress() { return ipAddress; }
    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }

    public String getOneTime() { return oneTime; }
    public void setOneTime(String oneTime) { this.oneTime = oneTime; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    @Override
    public String toString() {
        return "ApplicationInfoReport{" +
                "srNo=" + srNo +
                ", applicationHash='" + applicationHash + '\'' +
                ", applicationName='" + applicationName + '\'' +
                ", applicationPath='" + applicationPath + '\'' +
                ", groupName='" + groupName + '\'' +
                ", cTime=" + cTime +
                ", hostName='" + hostName + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", oneTime='" + oneTime + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
