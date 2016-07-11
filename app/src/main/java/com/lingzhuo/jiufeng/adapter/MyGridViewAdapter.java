package com.lingzhuo.jiufeng.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lingzhuo.jiufeng.R;
import com.lingzhuo.jiufeng.activity.DeadActivity;
import com.lingzhuo.jiufeng.bean.Man;
import com.lingzhuo.jiufeng.utils.Address;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Wang on 2016/7/6.
 */
public class MyGridViewAdapter extends BaseAdapter {
    private Context context;
    private List<Man> dataList;

    public MyGridViewAdapter(Context context, List<Man> dataList) {
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
            convertView= LayoutInflater.from(context).inflate(R.layout.man_photo_item,null);
            viewHolder.textView= (TextView) convertView.findViewById(R.id.textView_man_name);
            viewHolder.imageView= (ImageView) convertView.findViewById(R.id.imageView_man_photo);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(dataList.get(position).getMemorialName());
        if (!TextUtils.isEmpty(dataList.get(position).getManPhoto())){
            String urls = Address.IMAGEADDRESS + dataList.get(position).getManPhoto().substring(1);
            DisplayImageOptions options = new DisplayImageOptions.Builder()
                    .cacheInMemory(true)
                    .cacheOnDisc(true)
                    .showImageOnFail(R.mipmap.photo_default)
                    .showImageOnLoading(R.mipmap.photo_default)
                    .build();
            ImageLoader.getInstance().displayImage(urls, viewHolder.imageView, options);
        }else {
            viewHolder.imageView.setImageResource(R.mipmap.photo_default);
        }
        initListener(convertView,dataList.get(position));
        return convertView;
    }

    private void initListener(View view, final Man man) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, DeadActivity.class);
                intent.putExtra("DEAD_ID",man.getId());
                context.startActivity(intent);
            }
        });
    }

    class ViewHolder{
        TextView textView;
        ImageView imageView;
    }

}
