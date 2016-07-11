package com.lingzhuo.jiufeng.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.List;

/**
 * Created by Wang on 2016/5/7.
 */
public class MyViewPagerDeadAdapter extends PagerAdapter {
    private List<LinearLayout> imageViewList;
    private List<String> titleList;

    public MyViewPagerDeadAdapter(List<LinearLayout> imageViewList, List<String> titleList, Context context) {
        this.imageViewList = imageViewList;
        this.titleList=titleList;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

    @Override
    public Object instantiateItem(final ViewGroup container, int position) {
        container.addView(imageViewList.get(position));
        return imageViewList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(imageViewList.get(position));
    }

    @Override
    public int getCount() {
        return imageViewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
