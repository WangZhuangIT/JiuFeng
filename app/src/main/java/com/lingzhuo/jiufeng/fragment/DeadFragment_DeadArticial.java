package com.lingzhuo.jiufeng.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.lingzhuo.jiufeng.R;
import com.lingzhuo.jiufeng.activity.ArticialActivity;
import com.lingzhuo.jiufeng.adapter.MyListViewAdapter;
import com.lingzhuo.jiufeng.bean.Articial;
import com.lingzhuo.jiufeng.bean.ArticialAll;
import com.lingzhuo.jiufeng.bean.LogDetialAll;
import com.lingzhuo.jiufeng.utils.Address;
import com.lingzhuo.jiufeng.utils.VolleyUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wang on 2016/7/6.
 */
public class DeadFragment_DeadArticial extends LinearLayout implements AdapterView.OnItemClickListener{
    private View view;
    private String dead_id;
    private ArticialAll articialAll;
    private PullToRefreshListView pullToRefreshListView_articial;
    private int count = 1;
    private TextView text_noArticial;
    private MyListViewAdapter myListViewAdapter;
    private List<Articial> dataList;

    public DeadFragment_DeadArticial(Context context,String dead_id) {
        super(context);
        this.dead_id = dead_id;
        view=LayoutInflater.from(context).inflate(R.layout.fragment_deadarticial,this);
        init();
        initListener();
        getDeadArticialList(Address.DEAD_ARTICIAL_LIST + dead_id + "&page=" + (count++),true);
        initPullToRefreshScrollView();
    }

    private void initListener() {
        pullToRefreshListView_articial.setOnItemClickListener(this);
    }

    private void init() {
        pullToRefreshListView_articial= (PullToRefreshListView) view.findViewById(R.id.pullToRefreshListView_articial);
        text_noArticial= (TextView) view.findViewById(R.id.text_noArticial);

        dataList=new ArrayList<>();
        myListViewAdapter=new MyListViewAdapter(dataList,getContext());
        pullToRefreshListView_articial.setAdapter(myListViewAdapter);

    }

    private void initPullToRefreshScrollView() {
        pullToRefreshListView_articial.setMode(PullToRefreshBase.Mode.BOTH);
        pullToRefreshListView_articial.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                //设置刷新标签
                pullToRefreshListView_articial.getLoadingLayoutProxy().setRefreshingLabel("正在刷新");
                //设置释放标签
                pullToRefreshListView_articial.getLoadingLayoutProxy().setReleaseLabel("正在刷新");
                dataList.clear();
                count = 1;
                getDeadArticialList(Address.DEAD_ARTICIAL_LIST + dead_id + "&page=" + (count++),false);

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                //设置刷新标签
                pullToRefreshListView_articial.getLoadingLayoutProxy().setRefreshingLabel("正在加载");
                //设置释放标签
                pullToRefreshListView_articial.getLoadingLayoutProxy().setReleaseLabel("加载更多");
                getDeadArticialList(Address.DEAD_ARTICIAL_LIST + dead_id + "&page=" + (count++),false);
            }
        });
    }

    private void getDeadArticialList(String urls, final boolean isFirst) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, urls,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        response = response.substring(response.indexOf("(") + 1, response.lastIndexOf(")"));
                        articialAll = JSON.parseObject(response, ArticialAll.class);
                        if (isFirst&&articialAll.getRows().size() == 0){
                            pullToRefreshListView_articial.setVisibility(GONE);
                        }else {
                            text_noArticial.setVisibility(GONE);
                        }
                        if (!isFirst&&articialAll.getRows().size() == 0) {
                            Toast.makeText(getContext(), "已加载全部", Toast.LENGTH_SHORT).show();
                        } else {
                            for (Articial articial:articialAll.getRows()){
                                dataList.add(articial);
                            }
                        }
                        myListViewAdapter.notifyDataSetChanged();
                        pullToRefreshListView_articial.onRefreshComplete();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), "网络不可用", Toast.LENGTH_SHORT).show();
                        pullToRefreshListView_articial.onRefreshComplete();
                    }
                });
        VolleyUtils.newInstance(getContext()).addQueue(stringRequest);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Articial articial=dataList.get(position-1);
        Intent intent=new Intent(getContext(), ArticialActivity.class);
        intent.putExtra("ARTICIAL_ID",articial.getId());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getContext().startActivity(intent);
    }
}
