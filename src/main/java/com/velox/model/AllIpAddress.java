package com.velox.model;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "all_ipaddress")
public class AllIpAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "ADMINISTRATOR_NAME")
	private String administratorName;

	@Column(name = "AGENT_COMMUNICATION")
	private LocalDateTime agentCommunication;

	@Column(name = "AGENT_STATUS")
	private String agentStatus;

	@Column(name = "ASSET_MOVE")
	private String assetMove;

	@Column(name = "ATM_USER")
	private String atmUser;

	@Column(name = "BRANCH_NAME")
	private String branchName;

	@Column(name = "CLIENT_CONNECTED_TIME")
	private String clientConnectedTime;

	@Column(name = "CURRENT_DATE_TIME")
	private String currentDateTime;

	@Column(name = "TOTAL_DAYS")
	private String totalDays;

	@Column(name = "CUSTOMER_NAME")
	private String customerName;

	@Column(name = "DISPLAY_WIFI_PWD")
	private String displayWifiPwd;

	@Column(name = "IP_ADDRESS")
	private String ipAddress;

	@Column(name = "Name")
	private String name;

	@Column(name = "OEM")
	private String oem;

	@Column(name = "ONE_TIME")
	private String oneTime;

	@Column(name = "ONLY_ALLOWED_WEBSITE")
	private String onlyAllowedWebsite;

	@Column(name = "PC_NAME")
	private String pcName;

	@Column(name = "REMOTE_RESTART")
	private String remoteRestart;

	@Column(name = "REMOTE_RESTART_TIME")
	private String remoteRestartTime;

	@Column(name = "REMOTE_SERVER_IP")
	private String remoteServerIp;

	@Column(name = "REMOTE_STATUS")
	private String remoteStatus;

	@Column(name = "RESTART_SERVICE_TIME")
	private String restartServiceTime;

	@Column(name = "SECUREIT_RESTART")
	private String secureitRestart;

	@Column(name = "SECUREIT_RESTART_TIME")
	private String secureitRestartTime;

	@Column(name = "SID")
	private String sid;

	@Column(name = "STATE_UT")
	private String stateUt;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "STATUS_TIMESTAMP")
	private LocalDateTime statusTimestamp;

	@Column(name = "STATUS_VAL")
	private String statusVal;

	@Column(name = "TRANSFER_STATUS")
	private String transferStatus;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "ZONE_NAME")
	private String zoneName;

	@Column(name = "wipe_status")
	private String wipeStatus;

	@Column(name = "OS")
	private String os;

	@Column(name = "ATM_ID")
	private String atmId;

	@Column(name = "FIXED_USER")
	private String fixedUser;

	@Column(name = "group_name")
	private String groupName;

	@Column(name = "DEVICE_IP")
	private String deviceIp;

	@Column(name = "DEVICE_STATUS")
	private String deviceStatus;

	@Column(name = "DEVICE_STATUS_TIMESTAMP")
	private LocalDateTime deviceStatusTimestamp;

	@Column(name = "OS_TYPE")
	private String osType;

	@Column(name = "file_name")
	private String fileName;

	@Column(name = "email_sent")
	private Boolean emailSent;

	@Column(name = "SYSTEM_DOWNTIME")
	private LocalDateTime systemDowntime;

	@Column(name = "SYSTEM_UPTIME")
	private LocalDateTime systemUptime;

	@CreationTimestamp
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createdAt;

	@UpdateTimestamp
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime updatedAt;

	// Default constructor (required by JPA)
	public AllIpAddress() {
	}

	// Getters and setters

	public Long getId() {
		return id;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdministratorName() {
		return administratorName;
	}

	public void setAdministratorName(String administratorName) {
		this.administratorName = administratorName;
	}

	public LocalDateTime getAgentCommunication() {
		return agentCommunication;
	}

	public void setAgentCommunication(LocalDateTime agentCommunication) {
		this.agentCommunication = agentCommunication;
	}

	public String getAgentStatus() {
		return agentStatus;
	}

	public void setAgentStatus(String agentStatus) {
		this.agentStatus = agentStatus;
	}

	public String getAssetMove() {
		return assetMove;
	}

	public void setAssetMove(String assetMove) {
		this.assetMove = assetMove;
	}

	public String getAtmUser() {
		return atmUser;
	}

	public void setAtmUser(String atmUser) {
		this.atmUser = atmUser;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getClientConnectedTime() {
		return clientConnectedTime;
	}

	public void setClientConnectedTime(String clientConnectedTime) {
		this.clientConnectedTime = clientConnectedTime;
	}

	public String getCurrentDateTime() {
		return currentDateTime;
	}

	public void setCurrentDateTime(String currentDateTime) {
		this.currentDateTime = currentDateTime;
	}

	public String getTotalDays() {
		return totalDays;
	}

	public void setTotalDays(String totalDays) {
		this.totalDays = totalDays;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDisplayWifiPwd() {
		return displayWifiPwd;
	}

	public void setDisplayWifiPwd(String displayWifiPwd) {
		this.displayWifiPwd = displayWifiPwd;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOem() {
		return oem;
	}

	public void setOem(String oem) {
		this.oem = oem;
	}

	public String getOneTime() {
		return oneTime;
	}

	public void setOneTime(String oneTime) {
		this.oneTime = oneTime;
	}

	public String getOnlyAllowedWebsite() {
		return onlyAllowedWebsite;
	}

	public void setOnlyAllowedWebsite(String onlyAllowedWebsite) {
		this.onlyAllowedWebsite = onlyAllowedWebsite;
	}

	public String getPcName() {
		return pcName;
	}

	public void setPcName(String pcName) {
		this.pcName = pcName;
	}

	public String getRemoteRestart() {
		return remoteRestart;
	}

	public void setRemoteRestart(String remoteRestart) {
		this.remoteRestart = remoteRestart;
	}

	public String getRemoteRestartTime() {
		return remoteRestartTime;
	}

	public void setRemoteRestartTime(String remoteRestartTime) {
		this.remoteRestartTime = remoteRestartTime;
	}

	public String getRemoteServerIp() {
		return remoteServerIp;
	}

	public void setRemoteServerIp(String remoteServerIp) {
		this.remoteServerIp = remoteServerIp;
	}

	public String getRemoteStatus() {
		return remoteStatus;
	}

	public void setRemoteStatus(String remoteStatus) {
		this.remoteStatus = remoteStatus;
	}

	public String getRestartServiceTime() {
		return restartServiceTime;
	}

	public void setRestartServiceTime(String restartServiceTime) {
		this.restartServiceTime = restartServiceTime;
	}

	public String getSecureitRestart() {
		return secureitRestart;
	}

	public void setSecureitRestart(String secureitRestart) {
		this.secureitRestart = secureitRestart;
	}

	public String getSecureitRestartTime() {
		return secureitRestartTime;
	}

	public void setSecureitRestartTime(String secureitRestartTime) {
		this.secureitRestartTime = secureitRestartTime;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getStateUt() {
		return stateUt;
	}

	public void setStateUt(String stateUt) {
		this.stateUt = stateUt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getStatusTimestamp() {
		return statusTimestamp;
	}

	public void setStatusTimestamp(LocalDateTime statusTimestamp) {
		this.statusTimestamp = statusTimestamp;
	}

	public String getStatusVal() {
		return statusVal;
	}

	public void setStatusVal(String statusVal) {
		this.statusVal = statusVal;
	}

	public String getTransferStatus() {
		return transferStatus;
	}

	public void setTransferStatus(String transferStatus) {
		this.transferStatus = transferStatus;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public String getWipeStatus() {
		return wipeStatus;
	}

	public void setWipeStatus(String wipeStatus) {
		this.wipeStatus = wipeStatus;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getAtmId() {
		return atmId;
	}

	public void setAtmId(String atmId) {
		this.atmId = atmId;
	}

	public String getFixedUser() {
		return fixedUser;
	}

	public void setFixedUser(String fixedUser) {
		this.fixedUser = fixedUser;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getDeviceIp() {
		return deviceIp;
	}

	public void setDeviceIp(String deviceIp) {
		this.deviceIp = deviceIp;
	}

	public String getDeviceStatus() {
		return deviceStatus;
	}

	public void setDeviceStatus(String deviceStatus) {
		this.deviceStatus = deviceStatus;
	}

	public LocalDateTime getDeviceStatusTimestamp() {
		return deviceStatusTimestamp;
	}

	public void setDeviceStatusTimestamp(LocalDateTime deviceStatusTimestamp) {
		this.deviceStatusTimestamp = deviceStatusTimestamp;
	}

	public String getOsType() {
		return osType;
	}

	public void setOsType(String osType) {
		this.osType = osType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Boolean getEmailSent() {
		return emailSent;
	}

	public void setEmailSent(Boolean emailSent) {
		this.emailSent = emailSent;
	}

	public LocalDateTime getSystemDowntime() {
		return systemDowntime;
	}

	public void setSystemDowntime(LocalDateTime systemDowntime) {
		this.systemDowntime = systemDowntime;
	}

	public LocalDateTime getSystemUptime() {
		return systemUptime;
	}

	public void setSystemUptime(LocalDateTime systemUptime) {
		this.systemUptime = systemUptime;
	}
}