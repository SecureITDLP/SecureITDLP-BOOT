package com.velox.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "printer_log")
public class PrinterDLP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SR_NO")
    private Long srNo;

    @Column(name = "BRANCH")
    private String branch;

    @Column(name = "COLOR")
    private String color;

    @Column(name = "DATE")
    private String date;

    @Column(name = "DOCUMENT")
    private String document;

    @Column(name = "DRIVERNAME")
    private String driverName;

    @Column(name = "HOSTPRINTQUEUE")
    private String hostPrintQueue;

    @Column(name = "HOST_NAME")
    private String hostName;

    @Column(name = "IP_ADDRESS")
    private String ipAddress;

    @Column(name = "JobStatus")
    private String jobStatus;

    @Column(name = "Name")
    private String name;

    @Column(name = "OWNER")
    private String owner;

    @Column(name = "PAGESPRINTED")
    private Integer pagesPrinted;

    @Column(name = "PAPERLENGTH")
    private String paperLength;

    @Column(name = "PAPERSIZE")
    private String paperSize;

    @Column(name = "PAPERWIDTH")
    private String paperWidth;

    @Column(name = "PRINTPROCESSOR")
    private String printProcessor;

    @Column(name = "TIME")
    private String time;

    @Column(name = "TOTALPAGES")
    private Integer totalPages;

    @Lob
    @Column(name = "fileData", columnDefinition = "LONGBLOB")
    private byte[] fileData;
    
    @Column(name="one_time")
    private String onetime;
    
    @Column(name="USER_NAME")
    private String username;
    
    @Column (name="job_status")
    private String jobstatus;
    
    @Column(name="pages_printed")
    private String pagesprinted;
    
    @Column (name="paper_length")
    private String paperlength;

    
    @Column (name="paper_size")
    private String papersize;
    
    
    @Column (name="paper_width")
    private String paperwidth ;
    
    @Column (name="print_processor")
    private String printprocessor ;
    
    @Column (name="total_pages")
    private String totalpages;


    
    
    // Generate Getters and Setters
	public Long getSrNo() {
		return srNo;
	}

	public void setSrNo(Long srNo) {
		this.srNo = srNo;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getHostPrintQueue() {
		return hostPrintQueue;
	}

	public void setHostPrintQueue(String hostPrintQueue) {
		this.hostPrintQueue = hostPrintQueue;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Integer getPagesPrinted() {
		return pagesPrinted;
	}

	public void setPagesPrinted(Integer pagesPrinted) {
		this.pagesPrinted = pagesPrinted;
	}

	public String getPaperLength() {
		return paperLength;
	}

	public void setPaperLength(String paperLength) {
		this.paperLength = paperLength;
	}

	public String getPaperSize() {
		return paperSize;
	}

	public void setPaperSize(String paperSize) {
		this.paperSize = paperSize;
	}

	public String getPaperWidth() {
		return paperWidth;
	}

	public void setPaperWidth(String paperWidth) {
		this.paperWidth = paperWidth;
	}

	public String getPrintProcessor() {
		return printProcessor;
	}

	public void setPrintProcessor(String printProcessor) {
		this.printProcessor = printProcessor;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	public String getOnetime() {
		return onetime;
	}

	public void setOnetime(String onetime) {
		this.onetime = onetime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getJobstatus() {
		return jobstatus;
	}

	public void setJobstatus(String jobstatus) {
		this.jobstatus = jobstatus;
	}

	public String getPagesprinted() {
		return pagesprinted;
	}

	public void setPagesprinted(String pagesprinted) {
		this.pagesprinted = pagesprinted;
	}

	public String getPaperlength() {
		return paperlength;
	}

	public void setPaperlength(String paperlength) {
		this.paperlength = paperlength;
	}

	public String getPapersize() {
		return papersize;
	}

	public void setPapersize(String papersize) {
		this.papersize = papersize;
	}

	public String getPaperwidth() {
		return paperwidth;
	}

	public void setPaperwidth(String paperwidth) {
		this.paperwidth = paperwidth;
	}

	public String getPrintprocessor() {
		return printprocessor;
	}

	public void setPrintprocessor(String printprocessor) {
		this.printprocessor = printprocessor;
	}

	public String getTotalpages() {
		return totalpages;
	}

	public void setTotalpages(String totalpages) {
		this.totalpages = totalpages;
	}



 
    
    
}