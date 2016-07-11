package com.lingzhuo.jiufeng.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.lingzhuo.jiufeng.R;

/**
 * 这是主页面的自定义的标题栏
 */
public class TitleView extends LinearLayout {
    public TitleView(final Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.layout_title,this);
    }
}