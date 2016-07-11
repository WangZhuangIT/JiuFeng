package com.lingzhuo.jiufeng.bean;

import java.util.List;

/**
 * Created by Wang on 2016/7/11.
 */
public class DeadPhotoAll {
    private String exCode;
    private String exMsg;
    private List<DeadPhoto> rows;
    private String total;

    public DeadPhotoAll() {
    }

    public DeadPhotoAll(String exCode, String exMsg, List<DeadPhoto> rows, String total) {
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

    public List<DeadPhoto> getRows() {
        return rows;
    }

    public void setRows(List<DeadPhoto> rows) {
        this.rows = rows;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
