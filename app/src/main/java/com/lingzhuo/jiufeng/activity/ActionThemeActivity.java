package com.lingzhuo.jiufeng.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.lingzhuo.jiufeng.R;
import com.lingzhuo.jiufeng.adapter.MyGridViewThemeAdapter;
import com.lingzhuo.jiufeng.bean.ThemItem;
import com.lingzhuo.jiufeng.utils.ThemeAction;
import com.lingzhuo.jiufeng.view.MsgTitleView;

import java.util.ArrayList;
import java.util.List;

public class ActionThemeActivity extends AppCompatActivity implements View.OnClickListener, GridView.OnItemClickListener {

    private GridView gridView;
    private MsgTitleView msgTitleView;
    private ImageView msgTitleView_back;
    private TextView msgTitleView_title;
    private String people_id;

    private MyGridViewThemeAdapter adapter;
    private List<ThemItem> dataList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_theme);
        people_id = getIntent().getStringExtra("PEOPLE_ID");
        init();

        ThemItem themItemWorship = new ThemItem(R.mipmap.worship_style, "祭拜");
        ThemItem themItemFlower = new ThemItem(R.mipmap.flower_style, "献花");
        ThemItem themItemWine = new ThemItem(R.mipmap.wine_style, "敬酒");
        ThemItem themItemThou = new ThemItem(R.mipmap.thou_style, "上香");
        ThemItem themItemMsg = new ThemItem(R.mipmap.msg_style, "留言");
        ThemItem themItemClean = new ThemItem(R.mipmap.clean_style, "清洁");

        dataList.add(themItemWorship);
        dataList.add(themItemFlower);
        dataList.add(themItemWine);
        dataList.add(themItemThou);
        dataList.add(themItemMsg);
        dataList.add(themItemClean);

        adapter = new MyGridViewThemeAdapter(getApplicationContext(), dataList);

        gridView.setAdapter(adapter);


        gridView.setOnItemClickListener(this);


    }

    private void init() {
        gridView = (GridView) findViewById(R.id.gridView_theme);
        msgTitleView = (MsgTitleView) findViewById(R.id.theme_msgTitleView);
        msgTitleView_back = (ImageView) msgTitleView.findViewById(R.id.msgTitleView_back);
        msgTitleView_title = (TextView) msgTitleView.findViewById(R.id.msgTitleView_title);

        msgTitleView_title.setText("选择主题");
        msgTitleView_back.setOnClickListener(this);

        dataList = new ArrayList<>();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.msgTitleView_back:
                finish();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 1:
                //献花
                Intent intent_flower=new Intent(getApplicationContext(),ThemeFlowerActivity.class);
                intent_flower.putExtra("PEOPLE_ID",people_id);
                intent_flower.putExtra("STYLE",ThemeAction.THEME_FLOWER);
                startActivity(intent_flower);
                break;
            case 2:
                //敬酒
                Intent intent_wine=new Intent(getApplicationContext(),ThemeWineActivity.class);
                intent_wine.putExtra("PEOPLE_ID",people_id);
                intent_wine.putExtra("STYLE",ThemeAction.THEME_WINE);
                startActivity(intent_wine);
                break;
            case 3:
                //上香
                Intent intent_thus=new Intent(getApplicationContext(),ThemeThusActivity.class);
                intent_thus.putExtra("PEOPLE_ID",people_id);
                intent_thus.putExtra("STYLE",ThemeAction.THEME_THOU);
                startActivity(intent_thus);
                break;


            //下面是一样的界面
            case 0:
                //祭拜
                Intent intent=new Intent(getApplicationContext(),ThemeWorshipActivity.class);
                intent.putExtra("PEOPLE_ID",people_id);
                intent.putExtra("STYLE",ThemeAction.THEME_WORSHIP);
                startActivity(intent);
                break;
            case 4:
                //留言
                intent=new Intent(getApplicationContext(),ThemeWorshipActivity.class);
                intent.putExtra("PEOPLE_ID",people_id);
                intent.putExtra("STYLE",ThemeAction.THEME_MSG);
                startActivity(intent);
                break;
            case 5:
                //清洁
                intent=new Intent(getApplicationContext(),ThemeWorshipActivity.class);
                intent.putExtra("PEOPLE_ID",people_id);
                intent.putExtra("STYLE",ThemeAction.THEME_CLEAN);
                startActivity(intent);
                break;
        }
    }
}
