package com.velox.dto;

public class PrinterMonitoringDTO {
    private Integer srNo;
    private String allowPrevent;
    private String branch;
    private String ipAddress;
    
    // Getters and Setters
    public Integer getSrNo() {
        return srNo;
    }
    
    public void setSrNo(Integer srNo) {
        this.srNo = srNo;
    }
    
    public String getAllowPrevent() {
        return allowPrevent;
    }
    
    public void setAllowPrevent(String allowPrevent) {
        this.allowPrevent = allowPrevent;
    }
    
    public String getBranch() {
        return branch;
    }
    
    public void setBranch(String branch) {
        this.branch = branch;
    }
    
    public String getIpAddress() {
        return ipAddress;
    }
    
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}