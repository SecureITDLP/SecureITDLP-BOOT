package com.velox.dto;

public class ClipboardModalDto {

    private String hostname;
    private String ipaddress;
    private String keyword;
    private String branch;
    
	public ClipboardModalDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClipboardModalDto(String hostname, String ipaddress, String keyword, String branch) {
		super();
		this.hostname = hostname;
		this.ipaddress = ipaddress;
		this.keyword = keyword;
		this.branch = branch;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}
	
    
}