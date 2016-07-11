package com.lingzhuo.jiufeng.activity;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lingzhuo.jiufeng.R;
import com.lingzhuo.jiufeng.fragment.FragmentPage1;
import com.lingzhuo.jiufeng.fragment.FragmentPage2;
import com.lingzhuo.jiufeng.fragment.FragmentPage3;
import com.lingzhuo.jiufeng.view.TitleView;
import com.lingzhuo.jiufeng.zbar.CameraTestActivity;

/**
 * 这是应用程序的主界面
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView_bottom1, imageView_bottom2, imageView_bottom3, imageView_bottom4;
    private FragmentPage1 fragmentPage1;
    private FragmentPage2 fragmentPage2;
    private FragmentPage3 fragmentPage3;
    private FragmentManager manager;
    private TitleView titleView;
    private TextView titleView_title,titleView_text;
    private ImageView titleView_image;

    private long exit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initListener();

        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.frameLayout, fragmentPage1);
        transaction.commit();

    }

    /**
     * 对各种控件添加监听事件
     */
    private void initListener() {
        imageView_bottom1.setOnClickListener(this);
        imageView_bottom2.setOnClickListener(this);
        imageView_bottom3.setOnClickListener(this);
        imageView_bottom4.setOnClickListener(this);
        titleView_image.setOnClickListener(this);
        titleView_text.setOnClickListener(this);
    }

    /**
     * 初识化各种控件的方法
     */
    private void init() {
        imageView_bottom1 = (ImageView) findViewById(R.id.bottom1);
        imageView_bottom2 = (ImageView) findViewById(R.id.bottom2);
        imageView_bottom3 = (ImageView) findViewById(R.id.bottom3);
        imageView_bottom4 = (ImageView) findViewById(R.id.bottom4);


        fragmentPage1 = new FragmentPage1();
        fragmentPage2 = new FragmentPage2();
        fragmentPage3 = new FragmentPage3();

        titleView= (TitleView) findViewById(R.id.titleView);
        titleView_title= (TextView) titleView.findViewById(R.id.titleView_title);
        titleView_image= (ImageView) titleView.findViewById(R.id.titleView_imageView);
        titleView_text= (TextView) titleView.findViewById(R.id.titleView_textView);

        titleView_image.setVisibility(View.VISIBLE);
        titleView_text.setVisibility(View.GONE);
    }

    /**
     * 设置底部的四个按键的显示效果与屏幕当前所在的Fragment显示的位置一致的方法
     * @param position
     */
    public void moveTo(int position) {
        imageView_bottom1.setImageResource(R.mipmap.bottom1_n);
        imageView_bottom2.setImageResource(R.mipmap.bottom2_n);
        imageView_bottom3.setImageResource(R.mipmap.bottom3_n);
        switch (position) {
            case 0:
                imageView_bottom1.setImageResource(R.mipmap.bottom1_y);
                break;
            case 1:
                imageView_bottom2.setImageResource(R.mipmap.bottom2_y);
                break;
            case 2:
                imageView_bottom3.setImageResource(R.mipmap.bottom3_y);
                break;
        }
    }


    /**
     * 点击下方的按键，切换当前屏幕所显示的Fragment
     */
    public void onClick(View v) {
        FragmentTransaction transaction = manager.beginTransaction();
        switch (v.getId()) {
            case R.id.bottom1:
                transaction.replace(R.id.frameLayout, fragmentPage1);
                transaction.commit();
                moveTo(0);
                titleView_title.setText("九峰资讯");
                titleView_image.setImageResource(R.mipmap.search);
                titleView_image.setVisibility(View.VISIBLE);
                titleView_text.setVisibility(View.GONE);
                break;
            case R.id.bottom2:
                transaction.replace(R.id.frameLayout, fragmentPage2);
                transaction.commit();
                moveTo(1);
                titleView_title.setText("在线祭拜");
                titleView_image.setImageResource(R.mipmap.jibai_pic);
                titleView_image.setVisibility(View.GONE);
                titleView_text.setVisibility(View.VISIBLE);
                break;
            case R.id.bottom3:
                transaction.replace(R.id.frameLayout, fragmentPage3);
                transaction.commit();
                moveTo(2);
                titleView_title.setText("灵堂登录");
                titleView_image.setVisibility(View.GONE);
                titleView_text.setVisibility(View.GONE);
                break;
            case R.id.bottom4:
                startActivity(new Intent(getApplicationContext(), CameraTestActivity.class));
                break;
            case R.id.titleView_imageView:
                Intent intent=new Intent(getApplicationContext(),SearchActivity.class);
                startActivity(intent);
                break;
            case R.id.titleView_textView:

                break;
        }
    }

    @Override
    public void onBackPressed() {
        long systemTime= System.currentTimeMillis();;
        if (systemTime-exit<1000){
            finish();
        }else {
            Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            exit=systemTime;
        }
    }

}
