package com.lingzhuo.jiufeng.bean;

/**
 * Created by Wang on 2016/7/5.
 * 文章详细内容的bean类
 */
public class MsgDetial {
    private String AddDate;
    private String Author;
    private String CheckedLevel;
    private String Content;
    private String ID;
    private String ImageUrl;
    private String NodeID;
    private String Source;
    private String SubTitle;
    private String Summary;
    private String Title;

    public MsgDetial() {
    }

    public MsgDetial(String addDate, String author, String checkedLevel, String content, String ID, String imageUrl, String nodeID, String source, String subTitle, String summary, String title) {
        AddDate = addDate;
        Author = author;
        CheckedLevel = checkedLevel;
        Content = content;
        this.ID = ID;
        ImageUrl = imageUrl;
        NodeID = nodeID;
        Source = source;
        SubTitle = subTitle;
        Summary = summary;
        Title = title;
    }

    public String getAddDate() {
        return AddDate;
    }

    public void setAddDate(String addDate) {
        AddDate = addDate;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getCheckedLevel() {
        return CheckedLevel;
    }

    public void setCheckedLevel(String checkedLevel) {
        CheckedLevel = checkedLevel;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getNodeID() {
        return NodeID;
    }

    public void setNodeID(String nodeID) {
        NodeID = nodeID;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getSubTitle() {
        return SubTitle;
    }

    public void setSubTitle(String subTitle) {
        SubTitle = subTitle;
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
