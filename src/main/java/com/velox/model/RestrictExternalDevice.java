package com.velox.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restrict_external_device")
public class RestrictExternalDevice {

    @Id
    @Column(name = "sr_no")
    private int srNo;

    @Column(name = "branch_name")
    private String branchName;

    @Column(name = "device_name")
    private String deviceName;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "mode_access")
    private String modeAccess;

    @Column(name = "pc_name")
    private String pcName;

    @Column(name = "DEVICE_ID")
    private String deviceId;

    @Column(name = "c_time")
    private String cTime;

    @Column(name = "username")
    private String username;

    @Column(name = "email_sent")
    private String emailSent;

    // Getters and Setters

    public int getSrNo() {
        return srNo;
    }

    public void setSrNo(int srNo) {
        this.srNo = srNo;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getModeAccess() {
        return modeAccess;
    }

    public void setModeAccess(String modeAccess) {
        this.modeAccess = modeAccess;
    }

    public String getPcName() {
        return pcName;
    }

    public void setPcName(String pcName) {
        this.pcName = pcName;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getCTime() {
        return cTime;
    }

    public void setCTime(String cTime) {
        this.cTime = cTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailSent() {
        return emailSent;
    }

    public void setEmailSent(String emailSent) {
        this.emailSent = emailSent;
    }
}