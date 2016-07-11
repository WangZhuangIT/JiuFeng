package com.lingzhuo.jiufeng.bean;

import java.util.List;

/**
 * Created by Wang on 2016/7/5.
 * 文章详细信息集合的解析类
 */
public class MsgDetialAll {
    private String exCode;
    private String exMsg;
    private List<MsgDetial> pInfo;

    public MsgDetialAll() {
    }

    public MsgDetialAll(String exCode, String exMsg, List<MsgDetial> pInfo) {
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

    public List<MsgDetial> getpInfo() {
        return pInfo;
    }

    public void setpInfo(List<MsgDetial> pInfo) {
        this.pInfo = pInfo;
    }
}
