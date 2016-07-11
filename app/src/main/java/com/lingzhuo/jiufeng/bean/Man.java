package com.lingzhuo.jiufeng.bean;

/**
 * Created by Wang on 2016/7/6.
 * 这是单个逝者信息的bean类
 */
public class Man {
    private String AuditDate;
    private String AuditUser;
    private String ChangeDate;
    private String ChangeUser;
    private String ClickCount;
    private String CreateDate;
    private String CreateUser;
    private boolean IsAudit;
    private String ManPhoto;
    private String MemorialName;
    private String Number;
    private String RowNumber;
    private String TombType;
    private String UpdateDate;
    private String id;
    private String man;

    public Man() {
    }

    public Man(String auditDate, String auditUser, String changeDate, String changeUser, String clickCount, String createDate, String createUser, boolean isAudit, String manPhoto, String memorialName, String number, String rowNumber, String tombType, String updateDate, String id, String man) {
        AuditDate = auditDate;
        AuditUser = auditUser;
        ChangeDate = changeDate;
        ChangeUser = changeUser;
        ClickCount = clickCount;
        CreateDate = createDate;
        CreateUser = createUser;
        IsAudit = isAudit;
        ManPhoto = manPhoto;
        MemorialName = memorialName;
        Number = number;
        RowNumber = rowNumber;
        TombType = tombType;
        UpdateDate = updateDate;
        this.id = id;
        this.man = man;
    }

    public String getAuditDate() {
        return AuditDate;
    }

    public void setAuditDate(String auditDate) {
        AuditDate = auditDate;
    }

    public String getAuditUser() {
        return AuditUser;
    }

    public void setAuditUser(String auditUser) {
        AuditUser = auditUser;
    }

    public String getChangeDate() {
        return ChangeDate;
    }

    public void setChangeDate(String changeDate) {
        ChangeDate = changeDate;
    }

    public String getChangeUser() {
        return ChangeUser;
    }

    public void setChangeUser(String changeUser) {
        ChangeUser = changeUser;
    }

    public String getClickCount() {
        return ClickCount;
    }

    public void setClickCount(String clickCount) {
        ClickCount = clickCount;
    }

    public String getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(String createDate) {
        CreateDate = createDate;
    }

    public String getCreateUser() {
        return CreateUser;
    }

    public void setCreateUser(String createUser) {
        CreateUser = createUser;
    }

    public boolean isAudit() {
        return IsAudit;
    }

    public void setAudit(boolean audit) {
        IsAudit = audit;
    }

    public String getManPhoto() {
        return ManPhoto;
    }

    public void setManPhoto(String manPhoto) {
        ManPhoto = manPhoto;
    }

    public String getMemorialName() {
        return MemorialName;
    }

    public void setMemorialName(String memorialName) {
        MemorialName = memorialName;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getRowNumber() {
        return RowNumber;
    }

    public void setRowNumber(String rowNumber) {
        RowNumber = rowNumber;
    }

    public String getTombType() {
        return TombType;
    }

    public void setTombType(String tombType) {
        TombType = tombType;
    }

    public String getUpdateDate() {
        return UpdateDate;
    }

    public void setUpdateDate(String updateDate) {
        UpdateDate = updateDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMan() {
        return man;
    }

    public void setMan(String man) {
        this.man = man;
    }
}
