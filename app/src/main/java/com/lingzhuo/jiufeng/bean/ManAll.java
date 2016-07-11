package com.lingzhuo.jiufeng.bean;

import java.util.List;

/**
 * Created by Wang on 2016/7/5.
 * 这是所有逝者信息的解析类
 */
public class ManAll {
    private String exCode;
    private String exMsg;
    private List<Man> rows;
    private String total;

    public ManAll() {
    }

    public ManAll(String exCode, String exMsg, List<Man> rows, String total) {
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

    public List<Man> getRows() {
        return rows;
    }

    public void setRows(List<Man> rows) {
        this.rows = rows;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
