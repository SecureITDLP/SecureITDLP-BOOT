package com.velox.model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "monitoring_folder")
public class MonitoringFolderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SR_NO")
    private Integer srNo;

    @Column(name = "BRANCH_NAME")
    private String branchName;

    @Column(name = "CDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cdate;

    @Column(name = "FILE_ALTERED")
    private String fileAltered;

    @Column(name = "FILE_PATH_ALTERED")
    private String filePathAltered;

    @Column(name = "IP_ADDRESS")
    private String ipAddress;

    @Column(name = "PC_NAME")
    private String pcName;

    @Column(name = "RST_PATH")
    private String rstPath;

    @Column(name = "RST_TYPE")
    private String rstType;

    @Column(name = "USER_NAME1")
    private String userName1;

    @Column(name = "OLD_FILE_NAME")
    private String oldFileName;

    @Column(name = "NEW_FILE_NAME")
    private String newFileName;

    // No explicit constructors – JPA uses the implicit no-arg constructor.

    // Getters and Setters
    public Integer getSrNo() {
        return srNo;
    }

    public void setSrNo(Integer srNo) {
        this.srNo = srNo;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public String getFileAltered() {
        return fileAltered;
    }

    public void setFileAltered(String fileAltered) {
        this.fileAltered = fileAltered;
    }

    public String getFilePathAltered() {
        return filePathAltered;
    }

    public void setFilePathAltered(String filePathAltered) {
        this.filePathAltered = filePathAltered;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getPcName() {
        return pcName;
    }

    public void setPcName(String pcName) {
        this.pcName = pcName;
    }

    public String getRstPath() {
        return rstPath;
    }

    public void setRstPath(String rstPath) {
        this.rstPath = rstPath;
    }

    public String getRstType() {
        return rstType;
    }

    public void setRstType(String rstType) {
        this.rstType = rstType;
    }

    public String getUserName1() {
        return userName1;
    }

    public void setUserName1(String userName1) {
        this.userName1 = userName1;
    }

    public String getOldFileName() {
        return oldFileName;
    }

    public void setOldFileName(String oldFileName) {
        this.oldFileName = oldFileName;
    }

    public String getNewFileName() {
        return newFileName;
    }

    public void setNewFileName(String newFileName) {
        this.newFileName = newFileName;
    }

    @Override
    public String toString() {
        return "MonitoringFolderEntity [srNo=" + srNo + ", branchName=" + branchName + ", cdate=" + cdate
                + ", fileAltered=" + fileAltered + ", ipAddress=" + ipAddress + ", pcName=" + pcName
                + ", userName1=" + userName1 + "]";
    }
}
