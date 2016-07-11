package com.lingzhuo.jiufeng.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lingzhuo.jiufeng.R;

/**
 * 这是自定义的标题栏
 * 文章展示页面的标题栏控件
 */
public class MsgTitleView extends LinearLayout {
    public MsgTitleView(final Context context, AttributeSet attrs) {
        super(context, attrs);
        View view=LayoutInflater.from(context).inflate(R.layout.msg_title,this);
    }
}