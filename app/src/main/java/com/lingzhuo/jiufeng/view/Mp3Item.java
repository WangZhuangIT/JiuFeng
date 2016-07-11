package com.lingzhuo.jiufeng.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lingzhuo.jiufeng.R;

/**
 * Created by Wang on 2016/7/9.
 */
public class Mp3Item extends LinearLayout {
    private View view;

    private TextView textView_name,textView_time;

    public Mp3Item(Context context, String mp3_name, String mp3_time) {
        super(context);
        view=LayoutInflater.from(context).inflate(R.layout.music_item,this);

        textView_name= (TextView) view.findViewById(R.id.mp3_name);
        textView_time= (TextView) view.findViewById(R.id.mp3_time);

        textView_name.setText(mp3_name);
        textView_time.setText(mp3_time);
    }

    public Mp3Item(Context context) {
        super(context);
    }
}
