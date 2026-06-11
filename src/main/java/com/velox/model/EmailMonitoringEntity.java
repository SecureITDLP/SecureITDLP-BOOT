package com.velox.model;

import javax.persistence.*;

@Entity
@Table(name = "email_monittoring")
public class EmailMonitoringEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "sender")
    private String sender;

    @Column(name = "receiver")
    private String receiver;

    @Column(name = "subject", columnDefinition = "TEXT")
    private String subject;

    @Column(name = "body", columnDefinition = "TEXT")
    private String body;

    @Column(name = "date_time", length = 200)
    private String dateTime;

    @Column(name = "time", length = 100)
    private String time;

    @Column(name = "host_name")
    private String hostName;

    @Column(name = "attachments", columnDefinition = "TEXT")
    private String attachments;

    @Column(name = "username")
    private String username;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "C_DATE", length = 255)
    private String cDate;      // column name C_DATE

    @Lob
    @Column(name = "attachment_data", columnDefinition = "LONGBLOB")
    private byte[] attachmentData;   // LONGBLOB maps to byte[]

    // Default constructor (required by JPA)
    public EmailMonitoringEntity() {
        super();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSender() { return sender; }
    public void setSender(String sender) { this.sender = sender; }

    public String getReceiver() { return receiver; }
    public void setReceiver(String receiver) { this.receiver = receiver; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }

    public String getDateTime() { return dateTime; }
    public void setDateTime(String dateTime) { this.dateTime = dateTime; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public String getHostName() { return hostName; }
    public void setHostName(String hostName) { this.hostName = hostName; }

    public String getAttachments() { return attachments; }
    public void setAttachments(String attachments) { this.attachments = attachments; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getIpAddress() { return ipAddress; }
    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getCDate() { return cDate; }
    public void setCDate(String cDate) { this.cDate = cDate; }

    public byte[] getAttachmentData() { return attachmentData; }
    public void setAttachmentData(byte[] attachmentData) { this.attachmentData = attachmentData; }

    @Override
    public String toString() {
        return "EmailMonitoringEntity [id=" + id + ", sender=" + sender + ", receiver=" + receiver
                + ", subject=" + subject + ", dateTime=" + dateTime + ", username=" + username + "]";
    }
}
