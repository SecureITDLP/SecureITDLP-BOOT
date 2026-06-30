package com.velox.dto;

public class IncidentByChannelDto {

    private long emailIncident;
    private long networkIncident;
    private long printerIncident;
    private long clipboardIncident;
    private long driveIncident;
    private long peripheralIncident;
    
	public IncidentByChannelDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IncidentByChannelDto(long emailIncident, long networkIncident, long printerIncident, long clipboardIncident,
			long driveIncident, long peripheralIncident) {
		super();
		this.emailIncident = emailIncident;
		this.networkIncident = networkIncident;
		this.printerIncident = printerIncident;
		this.clipboardIncident = clipboardIncident;
		this.driveIncident = driveIncident;
		this.peripheralIncident = peripheralIncident;
	}

	public long getEmailIncident() {
		return emailIncident;
	}

	public void setEmailIncident(long emailIncident) {
		this.emailIncident = emailIncident;
	}

	public long getNetworkIncident() {
		return networkIncident;
	}

	public void setNetworkIncident(long networkIncident) {
		this.networkIncident = networkIncident;
	}

	public long getPrinterIncident() {
		return printerIncident;
	}

	public void setPrinterIncident(long printerIncident) {
		this.printerIncident = printerIncident;
	}

	public long getClipboardIncident() {
		return clipboardIncident;
	}

	public void setClipboardIncident(long clipboardIncident) {
		this.clipboardIncident = clipboardIncident;
	}

	public long getDriveIncident() {
		return driveIncident;
	}

	public void setDriveIncident(long driveIncident) {
		this.driveIncident = driveIncident;
	}

	public long getPeripheralIncident() {
		return peripheralIncident;
	}

	public void setPeripheralIncident(long peripheralIncident) {
		this.peripheralIncident = peripheralIncident;
	}
	
   
	
    // Getters and Setters
}