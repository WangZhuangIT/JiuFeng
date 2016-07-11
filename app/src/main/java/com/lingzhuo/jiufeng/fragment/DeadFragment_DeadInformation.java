package com.lingzhuo.jiufeng.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.lingzhuo.jiufeng.R;
import com.lingzhuo.jiufeng.adapter.MyViewPagerDeadAdapter;
import com.lingzhuo.jiufeng.adapter.MyViewPagerFragmentAdapter;
import com.lingzhuo.jiufeng.bean.DeadPeople;
import com.lingzhuo.jiufeng.bean.DeadPeopleAll;
import com.lingzhuo.jiufeng.utils.Address;
import com.lingzhuo.jiufeng.utils.VolleyUtils;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wang on 2016/7/6.
 */
public class DeadFragment_DeadInformation extends LinearLayout implements ViewPager.OnPageChangeListener{
    private View view;
    private String dead_id;
    private DeadPeopleAll deadPeopleAll;
    private List<String> titleList;
    private List<LinearLayout> dataList;
    private ViewPager dead_viewPager_information;
    private MyViewPagerDeadAdapter adapter;
    private ImageView dead_information_image_photo;

    private Button dead_text_name1,dead_text_name2;

    public DeadFragment_DeadInformation(Context context,String dead_id) {
        super(context);
        this.dead_id = dead_id;
        view=LayoutInflater.from(context).inflate(R.layout.fragment_deadinformation,this);
        getDeadPeople();
        init();
    }

    private void init() {
        dead_information_image_photo= (ImageView) view.findViewById(R.id.dead_information_image_photo);
        dead_viewPager_information= (ViewPager) view.findViewById(R.id.dead_viewPager_information);
        dead_text_name1= (Button) view.findViewById(R.id.dead_text_name1);
        dead_text_name2= (Button) view.findViewById(R.id.dead_text_name2);

        dataList=new ArrayList<>();
        titleList=new ArrayList<>();
    }

    private void getDeadPeople() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Address.DEAD_ALL_INFORMATION + dead_id,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        response = response.substring(response.indexOf("(") + 1, response.lastIndexOf(")"));
                        deadPeopleAll = JSON.parseObject(response, DeadPeopleAll.class);
                        initPhoto();
                        initFragment();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), "网络不可用", Toast.LENGTH_SHORT).show();
                    }
                });
        VolleyUtils.newInstance(getContext()).addQueue(stringRequest);
    }

    private void initFragment() {
        for (DeadPeople deadPeople:deadPeopleAll.getRows()){
            titleList.add(deadPeople.getDeadName());
            dataList.add(new Fragment_DeadPeople(getContext(),deadPeople));
        }
        adapter =new MyViewPagerDeadAdapter(dataList,titleList,getContext());
        dead_viewPager_information.setAdapter(adapter);
        dead_viewPager_information.setOnPageChangeListener(this);

        if (deadPeopleAll.getRows().size()==1){
            dead_text_name2.setVisibility(GONE);
            dead_text_name1.setText(deadPeopleAll.getRows().get(0).getDeadName());
            dead_text_name1.setTextColor(Color.rgb(255,64,129));
        }else {
            dead_text_name1.setText(deadPeopleAll.getRows().get(0).getDeadName());
            dead_text_name1.setTextColor(Color.rgb(255,64,129));
            dead_text_name2.setText(deadPeopleAll.getRows().get(1).getDeadName());
        }

    }

    private void initPhoto() {
        if (!TextUtils.isEmpty(deadPeopleAll.getManPhoto())){
            String urls = Address.IMAGEADDRESS + deadPeopleAll.getManPhoto().substring(1);
            DisplayImageOptions options = new DisplayImageOptions.Builder()
                    .cacheInMemory(true)
                    .cacheOnDisc(true)
                    .showImageOnFail(R.mipmap.photo_default)
                    .showImageOnLoading(R.mipmap.photo_default)
                    .build();
            ImageLoader.getInstance().displayImage(urls, dead_information_image_photo, options);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        switch (position){
            case 0:
                dead_text_name1.setTextColor(Color.rgb(255,64,129));
                dead_text_name2.setTextColor(Color.BLACK);
                break;
            case 1:
                dead_text_name2.setTextColor(Color.rgb(255, 64, 129));
                dead_text_name1.setTextColor(Color.BLACK);
                break;
        }
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }
}
