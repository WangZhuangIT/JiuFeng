package com.lingzhuo.jiufeng.bean;

/**
 * Created by Wang on 2016/7/8.
 */
public class ArticialDetial {
    private String ArticleAuthor;
    private String ArticleClass;
    private String ArticleClassID;
    private String ArticleHtml;
    private String ArticleImg;
    private String ArticleSource;
    private String ArticleTitle;
    private String ChangeDate;
    private String ChangeUser;
    private String CreateDate;
    private String CreateUser;
    private String Id;
    private boolean IsDisplay;
    private String MemorialID;
    private String MemorialNumber;

    public ArticialDetial() {
    }

    public ArticialDetial(String articleAuthor, String articleClass, String articleClassID, String articleHtml, String articleImg, String articleSource, String articleTitle, String changeDate, String changeUser, String createDate, String createUser, String id, boolean isDisplay, String memorialID, String memorialNumber) {
        ArticleAuthor = articleAuthor;
        ArticleClass = articleClass;
        ArticleClassID = articleClassID;
        ArticleHtml = articleHtml;
        ArticleImg = articleImg;
        ArticleSource = articleSource;
        ArticleTitle = articleTitle;
        ChangeDate = changeDate;
        ChangeUser = changeUser;
        CreateDate = createDate;
        CreateUser = createUser;
        Id = id;
        IsDisplay = isDisplay;
        MemorialID = memorialID;
        MemorialNumber = memorialNumber;
    }

    public String getArticleAuthor() {
        return ArticleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        ArticleAuthor = articleAuthor;
    }

    public String getArticleClass() {
        return ArticleClass;
    }

    public void setArticleClass(String articleClass) {
        ArticleClass = articleClass;
    }

    public String getArticleClassID() {
        return ArticleClassID;
    }

    public void setArticleClassID(String articleClassID) {
        ArticleClassID = articleClassID;
    }

    public String getArticleHtml() {
        return ArticleHtml;
    }

    public void setArticleHtml(String articleHtml) {
        ArticleHtml = articleHtml;
    }

    public String getArticleImg() {
        return ArticleImg;
    }

    public void setArticleImg(String articleImg) {
        ArticleImg = articleImg;
    }

    public String getArticleSource() {
        return ArticleSource;
    }

    public void setArticleSource(String articleSource) {
        ArticleSource = articleSource;
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
}
