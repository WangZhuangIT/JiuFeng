package com.lingzhuo.jiufeng.utils;

import com.lingzhuo.jiufeng.bean.Msg;
import com.lingzhuo.jiufeng.bean.MsgDetial;

/**
 * Created by Wang on 2016/7/5.
 * 用于对文章标题进行相应标点的替换的工具类
 */
public class TextFormat {
    public static void formatTitle(Msg msg) {
        msg.setTitle(msg.getTitle().replace("&#12289;","、"));
        msg.setTitle(msg.getTitle().replace("&#65288;","("));
        msg.setTitle(msg.getTitle().replace("&#65289;",")"));
        msg.setTitle(msg.getTitle().replace("&#65306;",":"));
        msg.setTitle(msg.getTitle().replace("&#8212;","-"));
        msg.setTitle(msg.getTitle().replace("&#12298;","《"));
        msg.setTitle(msg.getTitle().replace("&#12299;","》"));
        msg.setTitle(msg.getTitle().replace("&#91;","["));
        msg.setTitle(msg.getTitle().replace("&#93;","]"));
        msg.setTitle(msg.getTitle().replace("&#40;","("));
        msg.setTitle(msg.getTitle().replace("&#41;",")"));
        msg.setTitle(msg.getTitle().replace("&#65281;","!"));
        msg.setTitle(msg.getTitle().replace("&#12304;","【"));
        msg.setTitle(msg.getTitle().replace("&#12305;","】"));
    }
}
