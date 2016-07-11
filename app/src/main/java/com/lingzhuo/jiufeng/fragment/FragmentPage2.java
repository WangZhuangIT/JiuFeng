package com.lingzhuo.jiufeng.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.lingzhuo.jiufeng.R;
import com.lingzhuo.jiufeng.adapter.MyGridViewAdapter;
import com.lingzhuo.jiufeng.bean.Man;
import com.lingzhuo.jiufeng.bean.ManAll;
import com.lingzhuo.jiufeng.utils.Address;
import com.lingzhuo.jiufeng.utils.VolleyUtils;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wang on 2016/7/3.
 * 对应在线祭拜点击切换的fragment
 */
public class FragmentPage2 extends Fragment implements View.OnClickListener {
    private View view;
    private PullToRefreshGridView gridView;
    private ImageView imageView_search;
    private EditText editText_search_man;
    private ManAll manAll;
    private int count;
    private MyGridViewAdapter myGridViewAdapter;
    private List<Man> dataList;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_2, null);
        init();
        initListener();
        getManInfromation(Address.MAN_INFORMATION + "&page=" + (++count));
        initPullToRefreshGridView();
        return view;
    }

    private void initListener() {
        imageView_search.setOnClickListener(this);
    }

    private void init() {
        gridView = (PullToRefreshGridView) view.findViewById(R.id.gridView_man);
        imageView_search = (ImageView) view.findViewById(R.id.imageView_search_man);
        editText_search_man = (EditText) view.findViewById(R.id.editText_search_man);

        dataList = new ArrayList<>();
        myGridViewAdapter = new MyGridViewAdapter(getContext(), dataList);
        gridView.setAdapter(myGridViewAdapter);
    }

    /**
     * 初始化下拉加载控件
     */
    private void initPullToRefreshGridView() {
        gridView.setMode(PullToRefreshBase.Mode.PULL_FROM_END);
        gridView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<GridView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<GridView> pullToRefreshBase) {
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<GridView> pullToRefreshBase) {
                //设置刷新标签
                gridView.getLoadingLayoutProxy().setRefreshingLabel("正在加载");
                //设置释放标签
                gridView.getLoadingLayoutProxy().setReleaseLabel("加载更多");
                getManInfromation(Address.MAN_INFORMATION + "&page=" + (++count) + "&name=" + editText_search_man.getText());

                //此处执行下拉加载的逻辑处理
                //pullToRefreshScrollView.onRefreshComplete();这行代码必须调用
            }
        });
    }

    /**
     * 获取逝者头像信息的方法
     */
    private void getManInfromation(String urls) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, urls,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        response = response.substring(response.indexOf("(") + 1, response.lastIndexOf(")"));
                        manAll = JSON.parseObject(response, ManAll.class);
                        if (manAll.getRows().size()==0){
                            Toast.makeText(getContext(), "已经加载全部", Toast.LENGTH_SHORT).show();
                        }else {
                            for (Man man : manAll.getRows()) {
                                dataList.add(man);
                            }
                            myGridViewAdapter.notifyDataSetChanged();
                        }
                        gridView.onRefreshComplete();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), "网络不可用", Toast.LENGTH_SHORT).show();
                        gridView.onRefreshComplete();
                    }
                });
        VolleyUtils.newInstance(getContext()).addQueue(stringRequest);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageView_search_man:
                searchMan();
                break;
        }
    }

    /**
     * 用来相应逝者搜索点击事件处理的逻辑
     */
    private void searchMan() {
        count = 1;
        dataList.clear();
        getManInfromation(Address.MAN_INFORMATION + "&page=" + count + "&name=" + editText_search_man.getText());
    }
}
