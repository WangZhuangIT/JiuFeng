package com.lingzhuo.jiufeng.bean;

/**
 * Created by Wang on 2016/7/7.
 */
public class LogDetial {
    private String ActionImg;
    private String ActionName;
    private String ActionUser;
    private String ArticleContent;
    private String CreateDate;
    private String IPAddress;
    private String Id;
    private boolean IsDisplay;
    private String MemorialID;
    private String MemorialNumber;
    private String Title;

    public LogDetial() {
    }

    public LogDetial(String actionImg, String actionName, String actionUser, String articleContent, String createDate, String IPAddress, String id, boolean isDisplay, String memorialID, String memorialNumber, String title) {
        ActionImg = actionImg;
        ActionName = actionName;
        ActionUser = actionUser;
        ArticleContent = articleContent;
        CreateDate = createDate;
        this.IPAddress = IPAddress;
        Id = id;
        IsDisplay = isDisplay;
        MemorialID = memorialID;
        MemorialNumber = memorialNumber;
        Title = title;
    }

    public String getActionImg() {
        return ActionImg;
    }

    public void setActionImg(String actionImg) {
        ActionImg = actionImg;
    }

    public String getActionName() {
        return ActionName;
    }

    public void setActionName(String actionName) {
        ActionName = actionName;
    }

    public String getActionUser() {
        return ActionUser;
    }

    public void setActionUser(String actionUser) {
        ActionUser = actionUser;
    }

    public String getArticleContent() {
        return ArticleContent;
    }

    public void setArticleContent(String articleContent) {
        ArticleContent = articleContent;
    }

    public String getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(String createDate) {
        CreateDate = createDate;
    }

    public String getIPAddress() {
        return IPAddress;
    }

    public void setIPAddress(String IPAddress) {
        this.IPAddress = IPAddress;
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

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
