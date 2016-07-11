package com.lingzhuo.jiufeng.bean;

/**
 * Created by Wang on 2016/7/8.
 */
public class ThemItem {
    private int pic_id;
    private String action;

    public ThemItem(int pic_id, String action) {
        this.pic_id = pic_id;
        this.action = action;
    }

    public int getPic_id() {
        return pic_id;
    }

    public void setPic_id(int pic_id) {
        this.pic_id = pic_id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
