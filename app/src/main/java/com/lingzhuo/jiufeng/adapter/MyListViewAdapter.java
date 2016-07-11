package com.lingzhuo.jiufeng.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lingzhuo.jiufeng.R;
import com.lingzhuo.jiufeng.activity.ArticialActivity;
import com.lingzhuo.jiufeng.bean.Articial;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Wang on 2016/7/8.
 */
public class MyListViewAdapter extends BaseAdapter {
    private List<Articial> dataList;
    private Context context;

    public MyListViewAdapter(List<Articial> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.articial_item, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView_pic = (ImageView) convertView.findViewById(R.id.articial_pic);
            viewHolder.textView_title = (TextView) convertView.findViewById(R.id.articial_title);
            viewHolder.textView_time = (TextView) convertView.findViewById(R.id.articial_time);
            viewHolder.textView_creater = (TextView) convertView.findViewById(R.id.articial_creater);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Articial articial = dataList.get(position);
        viewHolder.textView_title.setText(articial.getArticleTitle());
        if (!TextUtils.isEmpty(articial.getChangeDate())) {
            viewHolder.textView_time.setText(articial.getChangeDate());
        }else {
            viewHolder.textView_time.setText(articial.getCreateDate());
        }
        if (!TextUtils.isEmpty(articial.getChangeUser())) {
            viewHolder.textView_creater.setText(articial.getChangeUser());
        }else {
            viewHolder.textView_creater.setText(articial.getCreateUser());
        }
        return convertView;
    }

    class ViewHolder {
        ImageView imageView_pic;
        TextView textView_title, textView_time, textView_creater;
    }

}
