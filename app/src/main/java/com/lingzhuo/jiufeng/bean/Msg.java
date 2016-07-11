package com.lingzhuo.jiufeng.bean;

/**
 * Created by Wang on 2016/7/5.
 * 单个文章信息的bean类
 */
public class Msg {
    private String AddDate;
    private String Author;
    private String CheckedLevel;
    private String ID;
    private String ImageUrl;
    private String NodeID;
    private String RowNumber;
    private String Source;
    private String SubTitle;
    private String Summary;
    private String Title;

    public Msg() {
    }

    public Msg(String addDate, String author, String checkedLevel, String ID, String imageUrl, String nodeID, String rowNumber, String source, String subTitle, String summary, String title) {
        AddDate = addDate;
        Author = author;
        CheckedLevel = checkedLevel;
        this.ID = ID;
        ImageUrl = imageUrl;
        NodeID = nodeID;
        RowNumber = rowNumber;
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

    public String getRowNumber() {
        return RowNumber;
    }

    public void setRowNumber(String rowNumber) {
        RowNumber = rowNumber;
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
