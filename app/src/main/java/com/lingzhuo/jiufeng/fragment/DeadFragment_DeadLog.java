package com.lingzhuo.jiufeng.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.lingzhuo.jiufeng.R;
import com.lingzhuo.jiufeng.bean.DeadPeopleAll;
import com.lingzhuo.jiufeng.bean.LogDetial;
import com.lingzhuo.jiufeng.bean.LogDetialAll;
import com.lingzhuo.jiufeng.utils.Address;
import com.lingzhuo.jiufeng.utils.VolleyUtils;
import com.lingzhuo.jiufeng.view.LogItem;

/**
 * Created by Wang on 2016/7/6.
 */
@SuppressLint("ValidFragment")
public class DeadFragment_DeadLog extends LinearLayout {
    private View view;
    private String dead_id;
    private LogDetialAll logDetialAll;
    private GridLayout gridLayout_log;
    private PullToRefreshScrollView pullToRefreshScrollView_log;
    private int count = 1;

    public DeadFragment_DeadLog(Context context,String dead_id) {
        super(context);
        this.dead_id = dead_id;
        view = LayoutInflater.from(context).inflate(R.layout.fragment_deadlog, this);
        init();
        getDeadLog(Address.DEAD_LOG + dead_id + "&page=" + (count++));
        initPullToRefreshScrollView();
    }

    private void init() {
        gridLayout_log = (GridLayout) view.findViewById(R.id.gridLayout_log);
        pullToRefreshScrollView_log = (PullToRefreshScrollView) view.findViewById(R.id.pullToRefreshScrollView_log);
    }

    private void initPullToRefreshScrollView() {
        pullToRefreshScrollView_log.setMode(PullToRefreshBase.Mode.BOTH);
        pullToRefreshScrollView_log.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                //设置刷新标签
                pullToRefreshScrollView_log.getLoadingLayoutProxy().setRefreshingLabel("正在加载");
                //设置释放标签
                pullToRefreshScrollView_log.getLoadingLayoutProxy().setReleaseLabel("正在刷新");
                gridLayout_log.removeAllViews();
                count = 1;
                getDeadLog(Address.DEAD_LOG + dead_id + "&page=" + (count++));

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                //设置刷新标签
                pullToRefreshScrollView_log.getLoadingLayoutProxy().setRefreshingLabel("正在加载");
                //设置释放标签
                pullToRefreshScrollView_log.getLoadingLayoutProxy().setReleaseLabel("加载更多");
                getDeadLog(Address.DEAD_LOG + dead_id + "&page=" + (count++));
            }
        });
    }

    private void getDeadLog(String urls) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, urls,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        response = response.substring(response.indexOf("(") + 1, response.lastIndexOf(")"));
                        logDetialAll = JSON.parseObject(response, LogDetialAll.class);
                        if (logDetialAll.getRows().size() == 0) {
                            Toast.makeText(getContext(), "已加载全部", Toast.LENGTH_SHORT).show();
                        } else {
                            initLogGridLayout();
                        }
                        pullToRefreshScrollView_log.onRefreshComplete();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), "网络不可用", Toast.LENGTH_SHORT).show();
                        pullToRefreshScrollView_log.onRefreshComplete();
                    }
                });
        VolleyUtils.newInstance(getContext()).addQueue(stringRequest);
    }

    private void initLogGridLayout() {
        for (LogDetial logDetial : logDetialAll.getRows()) {
            gridLayout_log.addView(new LogItem(getContext(), logDetial));
        }
    }

}
