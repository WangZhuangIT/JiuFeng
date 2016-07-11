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

import com.lingzhuo.jiufeng.R;
import com.lingzhuo.jiufeng.activity.DeadActivity;
import com.lingzhuo.jiufeng.bean.Man;
import com.lingzhuo.jiufeng.bean.ThemItem;
import com.lingzhuo.jiufeng.utils.Address;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Wang on 2016/7/6.
 */
public class MyGridViewThemeAdapter extends BaseAdapter {
    private Context context;
    private List<ThemItem> dataList;

    public MyGridViewThemeAdapter(Context context, List<ThemItem> dataList) {
        this.context = context;
        this.dataList = dataList;
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
        if (convertView==null){
            viewHolder=new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.theme_item,null);
            viewHolder.textView= (TextView) convertView.findViewById(R.id.theme_action);
            viewHolder.imageView= (ImageView) convertView.findViewById(R.id.theme_img);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(dataList.get(position).getAction());
        viewHolder.imageView.setImageResource(dataList.get(position).getPic_id());
        return convertView;
    }

    class ViewHolder{
        TextView textView;
        ImageView imageView;
    }

}
