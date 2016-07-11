package com.lingzhuo.jiufeng.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lingzhuo.jiufeng.R;
import com.lingzhuo.jiufeng.bean.LogDetial;

/**
 * Created by Wang on 2016/7/7.
 */
public class LogItem extends LinearLayout {

    private View view;
    private LogDetial logDetial;

    private TextView log_date_year, log_date_day;
    private TextView log_title, log_content, log_people, log_ip;

    public LogItem(Context context, LogDetial logDetial) {
        super(context);
        this.logDetial = logDetial;
        view = LayoutInflater.from(context).inflate(R.layout.view_log_item, this);
        init();
        initAllData();
    }

    private void initAllData() {
        log_date_year.setText(logDetial.getCreateDate().substring(0,4)+"年");
        log_date_day.setText(logDetial.getCreateDate().substring(5,7)+"月"+logDetial.getCreateDate().substring(8)+"日");
        log_title.setText(logDetial.getTitle());
        log_content.setText(logDetial.getArticleContent());
        log_people.setText(logDetial.getActionUser()+"  为逝者  "+logDetial.getActionName());
        String ip_address=logDetial.getIPAddress();
        ip_address=ip_address.substring(0,ip_address.lastIndexOf("."));
        ip_address=ip_address.substring(0,ip_address.lastIndexOf("."));
        log_ip.setText(ip_address+".**.**");
    }

    private void init() {
        log_date_year= (TextView) view.findViewById(R.id.log_date_year);
        log_date_day= (TextView) view.findViewById(R.id.log_date_day);
        log_title= (TextView) view.findViewById(R.id.log_title);
        log_content= (TextView) view.findViewById(R.id.log_content);
        log_people= (TextView) view.findViewById(R.id.log_people);
        log_ip= (TextView) view.findViewById(R.id.log_ip);
    }
}
