package com.lingzhuo.jiufeng.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.lingzhuo.jiufeng.R;
import com.lingzhuo.jiufeng.activity.ActionThemeActivity;
import com.lingzhuo.jiufeng.activity.ArticialActivity;
import com.lingzhuo.jiufeng.activity.Mp3Activity;
import com.lingzhuo.jiufeng.bean.DeadPeople;
import com.lingzhuo.jiufeng.bean.DeadPeopleAll;
import com.lingzhuo.jiufeng.utils.Address;
import com.lingzhuo.jiufeng.utils.VolleyUtils;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by Wang on 2016/7/6.
 */
public class DeadFragment_SweepOnline extends LinearLayout implements View.OnClickListener{
    private View view;
    private String dead_id;
    private DeadPeopleAll deadPeopleAll;

    private ImageView dead_image_photo, dead_image_flower, dead_image_wine, dead_image_wine2, dead_image_xiang, dead_image_sweep, dead_image_music;
    private TextView dead_text_name, dead_text_age;

    public DeadFragment_SweepOnline(Context context, String dead_id) {
        super(context);
        this.dead_id = dead_id;
        view = LayoutInflater.from(context).inflate(R.layout.fragment_sweeponline, this);
        getDeadPeople();
        init();
        initListener();
    }

    private void initListener() {
        dead_image_sweep.setOnClickListener(this);
        dead_image_music.setOnClickListener(this);
    }

    private void init() {
        dead_image_photo = (ImageView) view.findViewById(R.id.dead_image_photo);
        dead_image_flower = (ImageView) view.findViewById(R.id.dead_image_flower);
        dead_image_wine = (ImageView) view.findViewById(R.id.dead_image_wine);
        dead_image_wine2 = (ImageView) view.findViewById(R.id.dead_image_wine2);
        dead_image_photo = (ImageView) view.findViewById(R.id.dead_image_photo);
        dead_image_xiang = (ImageView) view.findViewById(R.id.dead_image_xiang);
        dead_image_music = (ImageView) view.findViewById(R.id.dead_image_music);
        dead_image_sweep = (ImageView) view.findViewById(R.id.dead_image_sweep);

        dead_text_name = (TextView) view.findViewById(R.id.dead_text_name);
        dead_text_age = (TextView) view.findViewById(R.id.dead_text_age);
        ;
    }

    private void getDeadPeople() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Address.DEAD_ALL_INFORMATION + dead_id,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        response = response.substring(response.indexOf("(") + 1, response.lastIndexOf(")"));
                        deadPeopleAll = JSON.parseObject(response, DeadPeopleAll.class);

                        initFlower();
                        initWine();
                        initXiang();
                        initDeadMsg();
                        initPhoto();
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

    private void initPhoto() {
        if (!TextUtils.isEmpty(deadPeopleAll.getManPhoto())) {
            String urls = Address.IMAGEADDRESS + deadPeopleAll.getManPhoto().substring(1);
            DisplayImageOptions options = new DisplayImageOptions.Builder()
                    .cacheInMemory(true)
                    .cacheOnDisc(true)
                    .showImageOnFail(R.mipmap.photo_default)
                    .showImageOnLoading(R.mipmap.photo_default)
                    .build();
            ImageLoader.getInstance().displayImage(urls, dead_image_photo, options);
        }
    }

    private void initDeadMsg() {
        if (deadPeopleAll.getTombType().contains("单人")) {
            dead_text_name.setText(deadPeopleAll.getRows().get(0).getDeadName().replace(" ", ""));
            if (deadPeopleAll.getRows().get(0).getBirthday().contains("null")) {
                dead_text_age.setText("");
            } else {
                dead_text_age.setText(deadPeopleAll.getRows().get(0).getBirthday().substring(0, deadPeopleAll.getRows().get(0).getBirthday().indexOf("-")) + "-" + deadPeopleAll.getRows().get(0).getFeteday().substring(0, deadPeopleAll.getRows().get(0).getBirthday().indexOf("-")));
            }
        } else {
            if (deadPeopleAll.getRows().get(0).getBirthday().contains("null")) {
                dead_text_age.setText("");
            } else {
                dead_text_name.setText(deadPeopleAll.getRows().get(0).getDeadName().replace(" ", "") + "   " + deadPeopleAll.getRows().get(1).getDeadName().replace(" ", ""));
                dead_text_age.setText(deadPeopleAll.getRows().get(0).getBirthday().substring(0, deadPeopleAll.getRows().get(0).getBirthday().indexOf("-")) + "-" + deadPeopleAll.getRows().get(0).getFeteday().substring(0, deadPeopleAll.getRows().get(0).getBirthday().indexOf("-")) + "   " + deadPeopleAll.getRows().get(0).getBirthday().substring(0, deadPeopleAll.getRows().get(0).getBirthday().indexOf("-")) + "-" + deadPeopleAll.getRows().get(1).getFeteday().substring(0, deadPeopleAll.getRows().get(1).getBirthday().indexOf("-")));
            }
        }
    }

    private void initXiang() {
        switch (deadPeopleAll.getCupState()) {
            case 1:
                dead_image_xiang.setImageResource(R.mipmap.thus_forefather);
                break;
            case 2:
                dead_image_xiang.setImageResource(R.mipmap.thus_god);
                break;
            case 3:
                dead_image_xiang.setImageResource(R.mipmap.thus_red);
                break;
            default:
                dead_image_xiang.setVisibility(View.INVISIBLE);
                break;
        }
    }

    private void initWine() {
        switch (deadPeopleAll.getCupState()) {
            case 1:
                dead_image_wine.setImageResource(R.mipmap.wine1);
                dead_image_wine2.setImageResource(R.mipmap.wine1);
                break;
            case 2:
                dead_image_wine.setImageResource(R.mipmap.wine2);
                dead_image_wine2.setImageResource(R.mipmap.wine2);
                break;
            case 3:
                dead_image_wine.setImageResource(R.mipmap.wine3);
                dead_image_wine2.setImageResource(R.mipmap.wine3);
                break;
            case 4:
                dead_image_wine.setImageResource(R.mipmap.wine4);
                dead_image_wine2.setImageResource(R.mipmap.wine4);
                break;
            default:
                dead_image_wine.setVisibility(View.INVISIBLE);
                dead_image_wine2.setVisibility(View.INVISIBLE);
        }
    }

    private void initFlower() {
        switch (deadPeopleAll.getFlowerState()) {
            case 1:
            case 2:
                dead_image_flower.setImageResource(R.mipmap.flower2);
                break;
            case 3:
            case 4:
            case 5:
                dead_image_flower.setImageResource(R.mipmap.flower3);
                break;
            case 6:
            case 7:
            case 8:
                dead_image_flower.setImageResource(R.mipmap.flower4);
                break;
            default:
                dead_image_flower.setVisibility(View.INVISIBLE);
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.dead_image_sweep:
                Intent intent_sweep=new Intent(getContext(), ActionThemeActivity.class);
                intent_sweep.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent_sweep.putExtra("PEOPLE_ID",dead_id);
                getContext().startActivity(intent_sweep);
                break;
            case R.id.dead_image_music:
                Intent intent_music=new Intent(getContext(), Mp3Activity.class);
                intent_music.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent_music.putExtra("PEOPLE_ID",dead_id);
                getContext().startActivity(intent_music);
                break;
        }
    }
}
