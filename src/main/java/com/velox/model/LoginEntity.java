package com.velox.model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "login")
public class LoginEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int SR_NO;
	private int group_Id;
	private int id;
	private String CHANGEBY;
	private String CONTACT_NO;
	private String CUSTOMER_NAME;
	private String CUSTOMIZE_VIEW;
	private String EMAIL_ID;
	private String FIRST_NAME;
	private String GROUP_NAME;
	private String LAST_NAME;
	private String STATE_UT;
	private String TYPE;
	private String USERNAME;
	private String ZONE_NAME;
	private String email;
	private String mobile;

	@Column(columnDefinition = "TEXT")
	private String parameters;
	private String action;
	private String usertype;
	private String PASS;
//	private String PASS;
	private String PASS1;
	private String cpassword;
	private String otp;
	private String password;
	private String branch;
	private String pcName;
	private String loginStatus;
	private Timestamp c_time;
	private Timestamp currentTime;

	@Column(name = "ad_sync_status")
	private String adSyncStatus;

	@Column(name = "last_ad_sync_time")
	private Timestamp lastAdSyncTime;

	@Column(name = "ad_account_status")
	private String adAccountStatus;

	public String getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getPcName() {
		return pcName;
	}

	public void setPcName(String pcName) {
		this.pcName = pcName;
	}

	public int getSR_NO() {
		return SR_NO;
	}

	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}

	public int getGroup_Id() {
		return group_Id;
	}

	public void setGroup_Id(int group_Id) {
		this.group_Id = group_Id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCHANGEBY() {
		return CHANGEBY;
	}

	public void setCHANGEBY(String cHANGEBY) {
		CHANGEBY = cHANGEBY;
	}

	public String getCONTACT_NO() {
		return CONTACT_NO;
	}

	public void setCONTACT_NO(String cONTACT_NO) {
		CONTACT_NO = cONTACT_NO;
	}

	public String getCUSTOMER_NAME() {
		return CUSTOMER_NAME;
	}

	public void setCUSTOMER_NAME(String cUSTOMER_NAME) {
		CUSTOMER_NAME = cUSTOMER_NAME;
	}

	public String getCUSTOMIZE_VIEW() {
		return CUSTOMIZE_VIEW;
	}

	public void setCUSTOMIZE_VIEW(String cUSTOMIZE_VIEW) {
		CUSTOMIZE_VIEW = cUSTOMIZE_VIEW;
	}

	public String getEMAIL_ID() {
		return EMAIL_ID;
	}

	public void setEMAIL_ID(String eMAIL_ID) {
		EMAIL_ID = eMAIL_ID;
	}

	public String getFIRST_NAME() {
		return FIRST_NAME;
	}

	public void setFIRST_NAME(String fIRST_NAME) {
		FIRST_NAME = fIRST_NAME;
	}

	public String getGROUP_NAME() {
		return GROUP_NAME;
	}

	public void setGROUP_NAME(String gROUP_NAME) {
		GROUP_NAME = gROUP_NAME;
	}

	public String getLAST_NAME() {
		return LAST_NAME;
	}

	public void setLAST_NAME(String lAST_NAME) {
		LAST_NAME = lAST_NAME;
	}

	public String getSTATE_UT() {
		return STATE_UT;
	}

	public void setSTATE_UT(String sTATE_UT) {
		STATE_UT = sTATE_UT;
	}

	public String getTYPE() {
		return TYPE;
	}

	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	public String getZONE_NAME() {
		return ZONE_NAME;
	}

	public void setZONE_NAME(String zONE_NAME) {
		ZONE_NAME = zONE_NAME;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getPASS() {
		return PASS;
	}

	public void setPASS(String pASS) {
		PASS = pASS;
	}

	public String getPASS1() {
		return PASS1;
	}

	public void setPASS1(String pASS1) {
		PASS1 = pASS1;
	}

	public String getCpassword() {
		return cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getC_time() {
		return c_time;
	}

	public void setC_time(Timestamp c_time) {
		this.c_time = c_time;
	}

	public Timestamp getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(Timestamp currentTime) {
		this.currentTime = currentTime;
	}

	public String getAdSyncStatus() {
		return adSyncStatus;
	}

	public Timestamp getLastAdSyncTime() {
		return lastAdSyncTime;
	}

	public String getAdAccountStatus() {
		return adAccountStatus;
	}

	public void setAdSyncStatus(String adSyncStatus) {
		this.adSyncStatus = adSyncStatus;
	}

	public void setLastAdSyncTime(Timestamp lastAdSyncTime) {
		this.lastAdSyncTime = lastAdSyncTime;
	}

	public void setAdAccountStatus(String adAccountStatus) {
		this.adAccountStatus = adAccountStatus;
	}

	@Override
	public String toString() {
		return "LOGIN [SR_NO=" + SR_NO + ", group_Id=" + group_Id + ", id=" + id + ", CHANGEBY=" + CHANGEBY
				+ ", CONTACT_NO=" + CONTACT_NO + ", CUSTOMER_NAME=" + CUSTOMER_NAME + ", CUSTOMIZE_VIEW="
				+ CUSTOMIZE_VIEW + ", EMAIL_ID=" + EMAIL_ID + ", FIRST_NAME=" + FIRST_NAME + ", GROUP_NAME="
				+ GROUP_NAME + ", LAST_NAME=" + LAST_NAME + ", STATE_UT=" + STATE_UT + ", TYPE=" + TYPE + ", USERNAME="
				+ USERNAME + ", ZONE_NAME=" + ZONE_NAME + ", email=" + email + ", mobile=" + mobile + ", parameters="
				+ parameters + ", action=" + action + ", usertype=" + usertype + ", PASS=" + PASS + ", PASS1=" + PASS1
				+ ", cpassword=" + cpassword + ", otp=" + otp + ", password=" + password + ", branch=" + branch
				+ ", pcName=" + pcName + ", loginStatus=" + loginStatus + ", c_time=" + c_time + ", currentTime="
				+ currentTime + ", adSyncStatus=" + adSyncStatus + ", lastAdSyncTime=" + lastAdSyncTime
				+ ", adAccountStatus=" + adAccountStatus + "]";
	}

}
