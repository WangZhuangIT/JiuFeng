package com.lingzhuo.jiufeng.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.lingzhuo.jiufeng.R;
import com.lingzhuo.jiufeng.adapter.MyViewPagerAdapter;
import com.lingzhuo.jiufeng.bean.ArticleSubjectTitleAll;
import com.lingzhuo.jiufeng.utils.Address;
import com.lingzhuo.jiufeng.utils.VolleyUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wang on 2016/7/3.
 * 对应九峰咨询点击切换的fragment
 */
public class FragmentPage1 extends Fragment {
    private View view;
    private ArticleSubjectTitleAll articleSubjectTitleAll;
    private TabLayout tabLayout;
    private FragmentManager manager;
    private Fragment_Detial fragment_detial;
    private Fragment_Main fragment_main;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_1, null);
        init();
        getArticialTitle();
        manager = getFragmentManager();
        initListener();
        return view;
    }

    /**
     * 对应tabLayout点击事件的处理逻辑
     */
    private void initListener() {
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                FragmentTransaction transaction = manager.beginTransaction();
                if (tab.getPosition()==0){
                    fragment_main=new Fragment_Main("http://123.56.236.240/mvcwebmis/nologin/FindWithPagerForCMSArticle?nodeid="+articleSubjectTitleAll.getpInfo().get(tab.getPosition()).getNodeID());
                    transaction.replace(R.id.frameLayout_page1, fragment_main);
                }else {
                    fragment_detial=new Fragment_Detial("http://123.56.236.240/mvcwebmis/nologin/FindWithPagerForCMSArticle?nodeid="+articleSubjectTitleAll.getpInfo().get(tab.getPosition()).getNodeID());
                    transaction.replace(R.id.frameLayout_page1, fragment_detial);
                }
                transaction.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }


    private void init() {
        tabLayout= (TabLayout) view.findViewById(R.id.tablelayout);
    }

    /**
     * 这是用来获取第一个页面所有标题的方法
     */
    private void getArticialTitle() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Address.ALL_TITLE,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        response=response.substring(response.indexOf("(")+1,response.lastIndexOf(")"));
                        articleSubjectTitleAll= JSON.parseObject(response, ArticleSubjectTitleAll.class);
                        for (int i=0;i<articleSubjectTitleAll.getpInfo().size();i++){
                            tabLayout.addTab(tabLayout.newTab().setText(articleSubjectTitleAll.getpInfo().get(i).getNodeName()+""));
                        }
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
}
