package com.lingzhuo.jiufeng.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.lingzhuo.jiufeng.R;
import com.lingzhuo.jiufeng.utils.MusicUtils;
import com.lingzhuo.jiufeng.view.Mp3Item;
import com.lingzhuo.jiufeng.view.MsgTitleView;

public class Mp3Activity extends AppCompatActivity {

    private MsgTitleView msgTitleView;
    private String dead_id;

    private GridLayout gridLayout;
    private Mp3Item song1, song2, song3, song4;

    private ImageView imageView_song1, imageView_song2, imageView_song3, imageView_song4;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp3);
        dead_id = getIntent().getStringExtra("PEOPLE_ID");
        initMsgTitle();
        init();
        initListener();
        initPlayButton(MusicUtils.position);
    }

    private void initListener() {
        song1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initPlayButton(0);
                MusicUtils.playMusic(0, getApplicationContext());
                MusicUtils.position = 0;
            }
        });
        song2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initPlayButton(1);
                MusicUtils.playMusic(1, getApplicationContext());
                MusicUtils.position = 1;
            }
        });
        song3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initPlayButton(2);
                MusicUtils.playMusic(2, getApplicationContext());
                MusicUtils.position = 2;
            }
        });
        song4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initPlayButton(3);
                MusicUtils.playMusic(3, getApplicationContext());
                MusicUtils.position = 3;
            }
        });
    }

    private void initPlayButton(int position) {
        switch (position) {
            case 0:
                imageView_song1.setImageResource(R.mipmap.playing);
                imageView_song2.setImageResource(R.mipmap.play);
                imageView_song3.setImageResource(R.mipmap.play);
                imageView_song4.setImageResource(R.mipmap.play);
                break;
            case 1:
                imageView_song1.setImageResource(R.mipmap.play);
                imageView_song2.setImageResource(R.mipmap.playing);
                imageView_song3.setImageResource(R.mipmap.play);
                imageView_song4.setImageResource(R.mipmap.play);
                break;
            case 2:
                imageView_song1.setImageResource(R.mipmap.play);
                imageView_song2.setImageResource(R.mipmap.play);
                imageView_song3.setImageResource(R.mipmap.playing);
                imageView_song4.setImageResource(R.mipmap.play);
                break;
            case 3:
                imageView_song1.setImageResource(R.mipmap.play);
                imageView_song2.setImageResource(R.mipmap.play);
                imageView_song3.setImageResource(R.mipmap.play);
                imageView_song4.setImageResource(R.mipmap.playing);
                break;
        }
    }

    private void init() {
        gridLayout = (GridLayout) findViewById(R.id.gridLayout_mp3);

        song1 = new Mp3Item(getApplicationContext(), "Lone Ranger", "03:07");
        song2 = new Mp3Item(getApplicationContext(), "El Dorado Dubstep", "03:05");
        song3 = new Mp3Item(getApplicationContext(), "小幸运", "04:25");
        song4 = new Mp3Item(getApplicationContext(), "刚刚好", "04:10");

        gridLayout.addView(song1);
        gridLayout.addView(song2);
        gridLayout.addView(song3);
        gridLayout.addView(song4);

        imageView_song1 = (ImageView) song1.findViewById(R.id.mp3_isPlay);
        imageView_song2 = (ImageView) song2.findViewById(R.id.mp3_isPlay);
        imageView_song3 = (ImageView) song3.findViewById(R.id.mp3_isPlay);
        imageView_song4 = (ImageView) song4.findViewById(R.id.mp3_isPlay);

    }

    private void initMsgTitle() {
        msgTitleView = (MsgTitleView) findViewById(R.id.msgTitleView_mp3);
        ImageView imageView_back = (ImageView) msgTitleView.findViewById(R.id.msgTitleView_back);
        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        TextView textView = (TextView) msgTitleView.findViewById(R.id.msgTitleView_title);
        textView.setText("背景音乐");

    }
}
