package com.lingzhuo.jiufeng.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lingzhuo.jiufeng.R;
import com.lingzhuo.jiufeng.activity.PhotoActivity;
import com.lingzhuo.jiufeng.bean.DeadPhoto;
import com.lingzhuo.jiufeng.utils.Address;

import java.util.List;

/**
 * Created by Wang on 2016/7/11.
 */
public class MyGridViewPhotoAdapter extends BaseAdapter {

    private Context context;
    private List<DeadPhoto> dataList;

    public MyGridViewPhotoAdapter(Context context, List<DeadPhoto> dataList) {
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
            convertView= LayoutInflater.from(context).inflate(R.layout.photo_item,null);
            viewHolder.textView= (TextView) convertView.findViewById(R.id.photo_title);
            viewHolder.imageView= (ImageView) convertView.findViewById(R.id.photo_pic);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        DeadPhoto deadPhoto=dataList.get(position);
        viewHolder.textView.setText(deadPhoto.getTitle());
        Glide.with(context).load(Address.DEAD_PHOTO+deadPhoto.getPhoto().substring(1)).into(viewHolder.imageView);
        initListener(convertView,deadPhoto);
        return convertView;
    }

    private void initListener(View view, final DeadPhoto deadPhoto) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, PhotoActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("TITLE",deadPhoto.getTitle());
                intent.putExtra("URLS",Address.DEAD_PHOTO+deadPhoto.getPhoto().substring(1));
                context.startActivity(intent);
            }
        });
    }

    class ViewHolder{
        ImageView imageView;
        TextView textView;
    }

}
