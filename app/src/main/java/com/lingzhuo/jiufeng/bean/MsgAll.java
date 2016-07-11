package com.lingzhuo.jiufeng.bean;

import java.util.List;

/**
 * Created by Wang on 2016/7/5.
 * 文章集合的解析类
 */
public class MsgAll {
    private String exCode;
    private String exMsg;
    private List<Msg> rows;
    private String total;

    public MsgAll() {
    }

    public MsgAll(String exCode, String exMsg, List<Msg> rows, String total) {
        this.exCode = exCode;
        this.exMsg = exMsg;
        this.rows = rows;
        this.total = total;
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

    public List<Msg> getRows() {
        return rows;
    }

    public void setRows(List<Msg> rows) {
        this.rows = rows;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
