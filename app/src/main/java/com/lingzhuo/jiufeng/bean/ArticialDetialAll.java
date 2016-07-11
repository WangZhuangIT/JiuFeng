package com.lingzhuo.jiufeng.bean;

import java.util.List;

/**
 * Created by Wang on 2016/7/8.
 */
public class ArticialDetialAll {
    private String exCode;
    private String exMsg;
    private List<ArticialDetial> pInfo;

    public ArticialDetialAll() {
    }

    public ArticialDetialAll(String exCode, String exMsg, List<ArticialDetial> pInfo) {
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

    public List<ArticialDetial> getpInfo() {
        return pInfo;
    }

    public void setpInfo(List<ArticialDetial> pInfo) {
        this.pInfo = pInfo;
    }
}
