package com.lingzhuo.jiufeng.bean;

/**
 * Created by Wang on 2016/7/7.
 */
public class DeadPeople {
    private String ArticleSummary;
    private String BFYEAR;
    private String ChangeDate;
    private String ChangeUser;
    private String CreateDate;
    private String CreateUser;
    private String DeadName;
    private String Filename;
    private String MemorialID;
    private String Summary;
    private String birthday;
    private String feteday;
    private String id;
    private String nationality;
    private String nativeplace;
    private String sex;

    public DeadPeople() {
    }

    public DeadPeople(String articleSummary, String BFYEAR, String changeDate, String changeUser, String createDate, String createUser, String deadName, String filename, String memorialID, String summary, String birthday, String feteday, String id, String nationality, String nativeplace, String sex) {
        ArticleSummary = articleSummary;
        this.BFYEAR = BFYEAR;
        ChangeDate = changeDate;
        ChangeUser = changeUser;
        CreateDate = createDate;
        CreateUser = createUser;
        DeadName = deadName;
        Filename = filename;
        MemorialID = memorialID;
        Summary = summary;
        this.birthday = birthday;
        this.feteday = feteday;
        this.id = id;
        this.nationality = nationality;
        this.nativeplace = nativeplace;
        this.sex = sex;
    }

    public String getArticleSummary() {
        return ArticleSummary;
    }

    public void setArticleSummary(String articleSummary) {
        ArticleSummary = articleSummary;
    }

    public String getBFYEAR() {
        return BFYEAR;
    }

    public void setBFYEAR(String BFYEAR) {
        this.BFYEAR = BFYEAR;
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

    public String getDeadName() {
        return DeadName;
    }

    public void setDeadName(String deadName) {
        DeadName = deadName;
    }

    public String getFilename() {
        return Filename;
    }

    public void setFilename(String filename) {
        Filename = filename;
    }

    public String getMemorialID() {
        return MemorialID;
    }

    public void setMemorialID(String memorialID) {
        MemorialID = memorialID;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getFeteday() {
        return feteday;
    }

    public void setFeteday(String feteday) {
        this.feteday = feteday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNativeplace() {
        return nativeplace;
    }

    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
