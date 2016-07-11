package com.lingzhuo.jiufeng.bean;


import java.util.List;

/**
 * Created by Wang on 2016/7/4.
 * 这是获取第一个页面的所有标题的bean类
 */
public class ArticleSubjectTitleAll {
    private String exCode;
    private String exMsg;
    private List<ArticleTitle> pInfo;

    public ArticleSubjectTitleAll() {
    }

    public ArticleSubjectTitleAll(String exCode, String exMsg, List<ArticleTitle> pInfo) {
        this.exCode = exCode;
        this.exMsg = exMsg;
        this.pInfo = pInfo;
    }

    public String getExCode() {
        return exCode;
    }

    public void setExCode(String exCode) {
        this.exCode = exCode;
    }

    public String getExMsg() {
        return exMsg;
    }

    public void setExMsg(String exMsg) {
        this.exMsg = exMsg;
    }

    public List<ArticleTitle> getpInfo() {
        return pInfo;
    }

    public void setpInfo(List<ArticleTitle> pInfo) {
        this.pInfo = pInfo;
    }
}
