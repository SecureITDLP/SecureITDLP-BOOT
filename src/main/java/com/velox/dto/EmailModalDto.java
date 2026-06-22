package com.velox.dto;

public class EmailModalDto {

    private String sender;
    private String receiver;
    private String hostName;
    private String attachments;
    private String subject;

    public EmailModalDto(String sender, String receiver, String hostName, String attachments,String subject) {
        this.sender = sender;
        this.receiver = receiver;
        this.hostName = hostName;
        this.attachments = attachments;
        this.subject=subject;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getHostName() {
        return hostName;
    }

    public String getAttachments() {
        return attachments;
    }
    
    public String getSubject() {
    	return subject;
    }
}