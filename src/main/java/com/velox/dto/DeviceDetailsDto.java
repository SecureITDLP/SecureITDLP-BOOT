package com.velox.dto;

import java.time.LocalDateTime;

public class DeviceDetailsDto {

	private String branchName;
	private String ipAddress;
	private String deviceIp;
	private String userName;
	private String agentStatus;
	private LocalDateTime agentCommunication;
	private String zoneName;
	private String fixedUser;

	public DeviceDetailsDto() {
	}

	public DeviceDetailsDto(String branchName, String ipAddress, String deviceIp, String userName, String agentStatus,
			LocalDateTime agentCommunication, String zoneName, String fixedUser) {
		this.branchName = branchName;
		this.ipAddress = ipAddress;
		this.deviceIp = deviceIp;
		this.userName = userName;
		this.agentStatus = agentStatus;
		this.agentCommunication = agentCommunication;
		this.zoneName = zoneName;
		this.fixedUser = fixedUser;
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

	public String getDeviceIp() {
		return deviceIp;
	}

	public void setDeviceIp(String deviceIp) {
		this.deviceIp = deviceIp;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAgentStatus() {
		return agentStatus;
	}

	public void setAgentStatus(String agentStatus) {
		this.agentStatus = agentStatus;
	}

	public LocalDateTime getAgentCommunication() {
		return agentCommunication;
	}

	public void setAgentCommunication(LocalDateTime agentCommunication) {
		this.agentCommunication = agentCommunication;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public String getFixedUser() {
		return fixedUser;
	}

	public void setFixedUser(String fixedUser) {
		this.fixedUser = fixedUser;
	}
}