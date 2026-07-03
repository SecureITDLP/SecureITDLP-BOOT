package com.velox.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "printer_monitoring")
public class PrinterMonitoring {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SR_NO")
    private Integer srNo;
    
    @Column(name = "ALLOW_PREVENT")
    private String allowPrevent;
    
    @Column(name = "BRANCH")
    private String branch;
    
    @Column(name = "IP_ADDRESS")
    private String ipAddress;
    
    @Column(name = "MAINTAIN_DOWNLOAD")
    private String maintainDownload;
    
    @Column(name = "USERNAME")
    private String username;
    
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
    
    public String getMaintainDownload() {
        return maintainDownload;
    }
    
    public void setMaintainDownload(String maintainDownload) {
        this.maintainDownload = maintainDownload;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
}