package com.velox.dto;

public class RestrictExternalDeviceDto {

    private String branchName;
    private String ipAddress;
    private String deviceName;
    private String modeAccess;
    private String cTime;

    public RestrictExternalDeviceDto(String branchName, String ipAddress,
                                     String deviceName, String modeAccess,
                                     String cTime) {
        this.branchName = branchName;
        this.ipAddress = ipAddress;
        this.deviceName = deviceName;
        this.modeAccess = modeAccess;
        this.cTime = cTime;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getModeAccess() {
        return modeAccess;
    }

    public void setModeAccess(String modeAccess) {
        this.modeAccess = modeAccess;
    }

    public String getCTime() {
        return cTime;
    }

    public void setCTime(String cTime) {
        this.cTime = cTime;
    }
}