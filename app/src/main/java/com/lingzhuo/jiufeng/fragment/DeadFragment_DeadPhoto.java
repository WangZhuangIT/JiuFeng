package com.lingzhuo.jiufeng.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.lingzhuo.jiufeng.R;
import com.lingzhuo.jiufeng.adapter.MyGridViewPhotoAdapter;
import com.lingzhuo.jiufeng.bean.DeadPhoto;
import com.lingzhuo.jiufeng.bean.DeadPhotoAll;
import com.lingzhuo.jiufeng.utils.Address;
import com.lingzhuo.jiufeng.utils.VolleyUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wang on 2016/7/6.
 */
public class DeadFragment_DeadPhoto extends LinearLayout{
    private View view;
    private String dead_id;
    private DeadPhotoAll deadPhotoAll;
    private PullToRefreshGridView pullToRefreshGridView;
    private TextView text_noPhoto;
    private List<DeadPhoto> dataList;
    private MyGridViewPhotoAdapter adapter;
    private int count = 1;

    public DeadFragment_DeadPhoto(Context context,String dead_id) {
        super(context);
        this.dead_id = dead_id;
        view=LayoutInflater.from(context).inflate(R.layout.fragment_deadphoto,this);
        init();
        initPullToRefreshScrollView();
        getDeadPhoto(Address.DEAD_PHOTO_LIST+ dead_id + "&page=" + (count++),true);
    }

    private void initPullToRefreshScrollView() {
        pullToRefreshGridView.setMode(PullToRefreshBase.Mode.BOTH);

        pullToRefreshGridView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<GridView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<GridView> pullToRefreshBase) {
                //设置刷新标签
                pullToRefreshGridView.getLoadingLayoutProxy().setRefreshingLabel("正在刷新");
                //设置释放标签
                pullToRefreshGridView.getLoadingLayoutProxy().setReleaseLabel("正在刷新");
                dataList.clear();
                count = 1;
                getDeadPhoto(Address.DEAD_PHOTO_LIST + dead_id + "&page=" + (count++),false);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<GridView> pullToRefreshBase) {
                //设置刷新标签
                pullToRefreshGridView.getLoadingLayoutProxy().setRefreshingLabel("正在加载");
                //设置释放标签
                pullToRefreshGridView.getLoadingLayoutProxy().setReleaseLabel("加载更多");
                getDeadPhoto(Address.DEAD_PHOTO_LIST + dead_id + "&page=" + (count++),false);
            }
        });
    }

    private void init() {
        text_noPhoto= (TextView) view.findViewById(R.id.text_noPhoto);
        dataList=new ArrayList<>();
        pullToRefreshGridView= (PullToRefreshGridView) view.findViewById(R.id.pullToRefreshGridView_photo);
        adapter=new MyGridViewPhotoAdapter(getContext(),dataList);
        pullToRefreshGridView.setAdapter(adapter);

    }

    private void getDeadPhoto(String urls, final boolean isFirst) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, urls,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        response = response.substring(response.indexOf("(") + 1, response.lastIndexOf(")"));
                        deadPhotoAll = JSON.parseObject(response, DeadPhotoAll.class);
                        if (isFirst&& deadPhotoAll.getRows().size() == 0){
                            pullToRefreshGridView.setVisibility(GONE);
                        }else {
                            text_noPhoto.setVisibility(GONE);
                        }
                        if (!isFirst&& deadPhotoAll.getRows().size() == 0) {
                            Toast.makeText(getContext(), "已加载全部", Toast.LENGTH_SHORT).show();
                        } else {
                            for (DeadPhoto deadPhoto: deadPhotoAll.getRows()){
                                dataList.add(deadPhoto);
                            }
                        }
                        adapter.notifyDataSetChanged();
                        pullToRefreshGridView.onRefreshComplete();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), "网络不可用", Toast.LENGTH_SHORT).show();
                        pullToRefreshGridView.onRefreshComplete();
                    }
                });
        VolleyUtils.newInstance(getContext()).addQueue(stringRequest);
    }
}
