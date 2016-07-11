package com.lingzhuo.jiufeng.bean;

/**
 * Created by Wang on 2016/7/8.
 */
public class Articial {
    private String ArticleClass;
    private String ArticleTitle;
    private String ChangeDate;
    private String ChangeUser;
    private String CreateDate;
    private String CreateUser;
    private boolean IsDisplay;
    private String MemorialID;
    private String MemorialNumber;
    private String RowNumber;
    private String id;

    public Articial() {
    }

    public Articial(String articleClass, String articleTitle, String changeDate, String changeUser, String createDate, String createUser, boolean isDisplay, String memorialID, String memorialNumber, String rowNumber, String id) {
        ArticleClass = articleClass;
        ArticleTitle = articleTitle;
        ChangeDate = changeDate;
        ChangeUser = changeUser;
        CreateDate = createDate;
        CreateUser = createUser;
        IsDisplay = isDisplay;
        MemorialID = memorialID;
        MemorialNumber = memorialNumber;
        RowNumber = rowNumber;
        this.id = id;
    }

    public String getArticleClass() {
        return ArticleClass;
    }

    public void setArticleClass(String articleClass) {
        ArticleClass = articleClass;
    }

    public String getArticleTitle() {
        return ArticleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        ArticleTitle = articleTitle;
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

    public String getRowNumber() {
        return RowNumber;
    }

    public void setRowNumber(String rowNumber) {
        RowNumber = rowNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
