package com.lingzhuo.jiufeng.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lingzhuo.jiufeng.R;
import com.lingzhuo.jiufeng.bean.DeadPeople;

/**
 * Created by Wang on 2016/7/7.
 */
public class Fragment_DeadPeople extends LinearLayout {
    private View view;
    private DeadPeople deadPeople;
    private TextView dead_name, dead_minzu, dead_birthday, dead_sex, dead_address, dead_deadday;
    private WebView dead_life;

    public Fragment_DeadPeople(Context context,DeadPeople deadPeople) {
        super(context);
        this.deadPeople = deadPeople;
        view = LayoutInflater.from(context).inflate(R.layout.fragment_dead_people, this);
        init();
        initDeadPeopleInfromation();
    }

    private void initDeadPeopleInfromation() {
        dead_name.setText(dead_name.getText() + deadPeople.getDeadName());
        dead_minzu.setText(dead_minzu.getText() + deadPeople.getNationality());
        dead_birthday.setText(dead_birthday.getText() + deadPeople.getBirthday());
        dead_sex.setText(dead_sex.getText() + deadPeople.getSex());
        dead_address.setText(dead_address.getText() + deadPeople.getNativeplace());
        dead_deadday.setText(dead_deadday.getText() + deadPeople.getFeteday());

        initSummary();
    }

    private void initSummary() {
        String body =deadPeople.getSummary();
        String html = "<html><head>" + "</head><body>" + body + "</body></html>";
        html = html.replace("<img", "<img style=\"width:100%;height:auto\" ");
        html = html.replaceFirst("<img style=\"width:100%;height:auto\" ", "<img");
        dead_life.loadDataWithBaseURL("x-data://base", html, "text/html", "UTF-8", null);
        //让我们的webView支持java脚本
        dead_life.getSettings().setJavaScriptEnabled(true);
    }

    private void init() {
        dead_name = (TextView) view.findViewById(R.id.dead_name);
        dead_minzu = (TextView) view.findViewById(R.id.dead_minzu);
        dead_birthday = (TextView) view.findViewById(R.id.dead_birthday);
        dead_sex = (TextView) view.findViewById(R.id.dead_sex);
        dead_address = (TextView) view.findViewById(R.id.dead_address);
        dead_deadday = (TextView) view.findViewById(R.id.dead_deadday);
        dead_life = (WebView) view.findViewById(R.id.dead_life);
    }
}
