package com.lingzhuo.jiufeng.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Wang on 2016/5/7.
 */
public class MyViewPagerFragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> dataList;
    private List<String> titleList;

    public MyViewPagerFragmentAdapter(FragmentManager fm, List<Fragment> dataList, List<String> titleList) {
        super(fm);
        this.dataList = dataList;
        this.titleList = titleList;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

    public MyViewPagerFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public int getCount() {
        return dataList.size();
    }
}
