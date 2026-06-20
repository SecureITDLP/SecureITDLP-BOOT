package com.velox.dto;

public class IncidentByChannelDto {
    private long emailCount;
    private long networkUploadCount;
    private long printerCount;
    private long clipboardCount;
    private long monitoringFolderCount;
    private long peripheralCount; // USB Transfer + DVD Burn

    // Constructors, getters, setters
    public IncidentByChannelDto() {}

    public IncidentByChannelDto(long emailCount, long networkUploadCount, long printerCount,
                                long clipboardCount, long monitoringFolderCount, long peripheralCount) {
        this.emailCount = emailCount;
        this.networkUploadCount = networkUploadCount;
        this.printerCount = printerCount;
        this.clipboardCount = clipboardCount;
        this.monitoringFolderCount = monitoringFolderCount;
        this.peripheralCount = peripheralCount;
    }

    // getters and setters
    public long getEmailCount() { return emailCount; }
    public void setEmailCount(long emailCount) { this.emailCount = emailCount; }
    public long getNetworkUploadCount() { return networkUploadCount; }
    public void setNetworkUploadCount(long networkUploadCount) { this.networkUploadCount = networkUploadCount; }
    public long getPrinterCount() { return printerCount; }
    public void setPrinterCount(long printerCount) { this.printerCount = printerCount; }
    public long getClipboardCount() { return clipboardCount; }
    public void setClipboardCount(long clipboardCount) { this.clipboardCount = clipboardCount; }
    public long getMonitoringFolderCount() { return monitoringFolderCount; }
    public void setMonitoringFolderCount(long monitoringFolderCount) { this.monitoringFolderCount = monitoringFolderCount; }
    public long getPeripheralCount() { return peripheralCount; }
    public void setPeripheralCount(long peripheralCount) { this.peripheralCount = peripheralCount; }
}