package com.lingzhuo.jiufeng.bean;

/**
 * Created by Wang on 2016/7/11.
 */
public class DeadPhoto {
    private String ChangeDate;
    private String ChangeUser;
    private String CreateDate;
    private String CreateUser;
    private String Id;
    private boolean IsDisplay;
    private String MemorialID;
    private String MemorialNumber;
    private String Photo;
    private String Summary;
    private String Title;

    public DeadPhoto() {
    }

    public DeadPhoto(String changeDate, String changeUser, String createDate, String createUser, String id, boolean isDisplay, String memorialID, String memorialNumber, String photo, String summary, String title) {
        ChangeDate = changeDate;
        ChangeUser = changeUser;
        CreateDate = createDate;
        CreateUser = createUser;
        Id = id;
        IsDisplay = isDisplay;
        MemorialID = memorialID;
        MemorialNumber = memorialNumber;
        Photo = photo;
        Summary = summary;
        Title = title;
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

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public boolean isDisplay() {
        return IsDisplay;
    }

    public void setDisplay(boolean display) {
        IsDisplay = display;
    }

    public String getMemorialID() {
        return MemorialID;
    }

    public void setMemorialID(String memorialID) {
        MemorialID = memorialID;
    }

    public String getMemorialNumber() {
        return MemorialNumber;
    }

    public void setMemorialNumber(String memorialNumber) {
        MemorialNumber = memorialNumber;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
