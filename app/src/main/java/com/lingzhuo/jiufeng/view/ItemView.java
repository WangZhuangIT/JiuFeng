package com.lingzhuo.jiufeng.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.lingzhuo.jiufeng.R;

/**
 * Created by Wang on 2016/7/5.
 * 文章列表的单个条目的自定义View
 */
public class ItemView extends LinearLayout {
    public ItemView(final Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.layout_item,this);
    }
    public ItemView(final Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.layout_item,this);
    }
}