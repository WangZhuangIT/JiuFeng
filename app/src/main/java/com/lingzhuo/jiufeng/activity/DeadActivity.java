package com.lingzhuo.jiufeng.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.lingzhuo.jiufeng.R;
import com.lingzhuo.jiufeng.adapter.MyViewPagerDeadAdapter;
import com.lingzhuo.jiufeng.fragment.DeadFragment_DeadArticial;
import com.lingzhuo.jiufeng.fragment.DeadFragment_DeadInformation;
import com.lingzhuo.jiufeng.fragment.DeadFragment_DeadLog;
import com.lingzhuo.jiufeng.fragment.DeadFragment_DeadPhoto;
import com.lingzhuo.jiufeng.fragment.DeadFragment_SweepOnline;
import com.lingzhuo.jiufeng.utils.MusicUtils;

import java.util.ArrayList;
import java.util.List;

public class DeadActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String dead_id;
    private List<LinearLayout> dataList;
    private List<String> titleList;
    private MyViewPagerDeadAdapter adapter;

    private long exit;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dead);
        dead_id = getIntent().getStringExtra("DEAD_ID");
        init();
        initMp3();
    }

    private void initMp3() {
        int position = (int) (Math.random() * 4);
        MusicUtils.playMusic(position,getApplicationContext());
        MusicUtils.position=position;
    }

    private void init() {
        tabLayout = (TabLayout) findViewById(R.id.tablelayout_dead);
        viewPager = (ViewPager) findViewById(R.id.viewPager_dead);

        dataList = new ArrayList<>();
        titleList = new ArrayList<>();

        dataList = new ArrayList<>();
        dataList.add(new DeadFragment_SweepOnline(getApplicationContext(), dead_id));
        dataList.add(new DeadFragment_DeadInformation(getApplicationContext(), dead_id));
        dataList.add(new DeadFragment_DeadLog(getApplicationContext(), dead_id));
        dataList.add(new DeadFragment_DeadPhoto(getApplicationContext(), dead_id));
        dataList.add(new DeadFragment_DeadArticial(getApplicationContext(), dead_id));

        titleList.add("在线祭扫");
        titleList.add("逝者资料");
        titleList.add("祭扫日志");
        titleList.add("历史相册");
        titleList.add("纪念文选");

        adapter = new MyViewPagerDeadAdapter(dataList, titleList, getApplicationContext());
        viewPager.setAdapter(adapter);


        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public void onBackPressed() {
        long systemTime = System.currentTimeMillis();
        ;
        if (systemTime - exit < 1000) {
            finish();
            MusicUtils.stopMusic();
        } else {
            Toast.makeText(DeadActivity.this, "再按一次退出祭扫主页", Toast.LENGTH_SHORT).show();
            exit = systemTime;
        }
    }
}
