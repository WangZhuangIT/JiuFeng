package com.lingzhuo.jiufeng.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lingzhuo.jiufeng.R;
import com.lingzhuo.jiufeng.utils.Address;

public class PhotoActivity extends AppCompatActivity {
    private ImageView imageView_back,imageView_pic;
    private TextView textView_title;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        init();
        textView_title.setText(getIntent().getStringExtra("TITLE"));
        Glide.with(getApplicationContext()).load(getIntent().getStringExtra("URLS")).into(imageView_pic);
    }

    private void init() {
        imageView_back= (ImageView) findViewById(R.id.pic_back);
        imageView_pic= (ImageView) findViewById(R.id.pic_pic);
        textView_title= (TextView) findViewById(R.id.pic_title);

        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
