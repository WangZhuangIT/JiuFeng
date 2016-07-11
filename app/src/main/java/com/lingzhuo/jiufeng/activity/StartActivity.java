package com.lingzhuo.jiufeng.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.lingzhuo.jiufeng.R;

/**
 * 这是开启软件的闪屏界面
 */
public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        myHandler.sendEmptyMessageDelayed(0,2000);
    }


    Handler myHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();
        }
    };



}
