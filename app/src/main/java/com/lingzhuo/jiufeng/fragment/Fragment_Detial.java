package com.lingzhuo.jiufeng.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bumptech.glide.Glide;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.lingzhuo.jiufeng.R;
import com.lingzhuo.jiufeng.activity.MsgDetialActivity;
import com.lingzhuo.jiufeng.bean.ArticleSubjectTitleAll;
import com.lingzhuo.jiufeng.bean.Msg;
import com.lingzhuo.jiufeng.bean.MsgAll;
import com.lingzhuo.jiufeng.utils.Address;
import com.lingzhuo.jiufeng.utils.TextFormat;
import com.lingzhuo.jiufeng.utils.VolleyUtils;
import com.lingzhuo.jiufeng.view.ItemView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by Wang on 2016/7/3.
 * 除去带viewpager的文章展示界面的fragment
 */
@SuppressLint("ValidFragment")
public class Fragment_Detial extends Fragment{
    private View view;
    private String urls;
    private int count=1;
    private MsgAll msgAll;
    private GridLayout gridLayout;
    private PullToRefreshScrollView pullToRefreshScrollView;

    @SuppressLint("ValidFragment")
    public Fragment_Detial(String urls) {
        this.urls = urls;
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_detial,null);
        init();
        getMsgTitle(urls);
        initPullToRefreshScrollView();
        return view;
    }

    private void init() {
        gridLayout= (GridLayout) view.findViewById(R.id.gridLayout);
        pullToRefreshScrollView= (PullToRefreshScrollView) view.findViewById(R.id.pullToRefreshScrollView);
    }

    /**
     * 初识化下拉控件
     */
    private void initPullToRefreshScrollView() {
        pullToRefreshScrollView.setMode(PullToRefreshBase.Mode.PULL_FROM_END);
        pullToRefreshScrollView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                //设置刷新标签
                pullToRefreshScrollView.getLoadingLayoutProxy().setRefreshingLabel("正在加载");
                //设置释放标签
                pullToRefreshScrollView.getLoadingLayoutProxy().setReleaseLabel("加载更多");
                getMsgTitle(urls + "&page=" + (++count));

                //此处执行下拉加载的逻辑处理
                //pullToRefreshScrollView.onRefreshComplete();这行代码必须调用
            }
        });
    }

    /**
     * 获取当前栏目下的文章标题等信息的方法
     * @param urls
     */
    private void getMsgTitle(String urls) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, urls,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        response=response.substring(response.indexOf("(")+1,response.lastIndexOf(")"));
                        msgAll= JSON.parseObject(response, MsgAll.class);
                        if (msgAll.getRows().size()==0){
                            Toast.makeText(getContext(), "已加载全部", Toast.LENGTH_SHORT).show();
                        }else {
                            initMsg();
                        }
                        pullToRefreshScrollView.onRefreshComplete();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), "网络不可用", Toast.LENGTH_SHORT).show();
                        pullToRefreshScrollView.onRefreshComplete();
                    }
                });
        VolleyUtils.newInstance(getContext()).addQueue(stringRequest);
    }

    /**’
     * 根据返回的信息加载相应的界面
     */
    private void initMsg() {
        for (final Msg msg:msgAll.getRows()){
            TextFormat.formatTitle(msg);
            ItemView itemView=new ItemView(getContext());
            TextView textView_title= (TextView) itemView.findViewById(R.id.layout_item_title);
            TextView textView_time= (TextView) itemView.findViewById(R.id.layout_item_time);
            ImageView imageView_pic= (ImageView) itemView.findViewById(R.id.layout_item_imageView);
            if (TextUtils.isEmpty(msg.getImageUrl())){
                imageView_pic.setVisibility(View.GONE);
            }else {
                Glide.with(this).load(Address.URL+msg.getImageUrl().substring(1)).into(imageView_pic);
            }
            textView_title.setText(msg.getTitle());
            textView_time.setText(msg.getAddDate()+"    "+msg.getAuthor());
            gridLayout.addView(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getContext(), MsgDetialActivity.class);
                    intent.putExtra("MSG_ID",msg.getID());
                    intent.putExtra("MSG_TITLE",msg.getTitle());
                    startActivity(intent);
                }
            });

        }
    }
}
