package com.velox.dto;

import java.util.Date;

public class MonitoringFolderDto {

    private String branchName;
    private String ipAddress;
    private Date cdate;
    private String pcName;

    public MonitoringFolderDto(String branchName,
                               String ipAddress,
                               Date cdate,
                               String pcName) {
        this.branchName = branchName;
        this.ipAddress = ipAddress;
        this.cdate = cdate;
        this.pcName = pcName;
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

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public String getPcName() {
		return pcName;
	}

	public void setPcName(String pcName) {
		this.pcName = pcName;
	}

    // getters setters
    
    
}