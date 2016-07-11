package com.lingzhuo.jiufeng.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.lingzhuo.jiufeng.R;

/**
 * Created by Wang on 2016/7/6.
 * 逝者展示头像的自定义View
 */
public class ManPhotoItem extends LinearLayout {
    public ManPhotoItem(final Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.man_photo_item,this);
    }
    public ManPhotoItem(final Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.man_photo_item,this);
    }
}
