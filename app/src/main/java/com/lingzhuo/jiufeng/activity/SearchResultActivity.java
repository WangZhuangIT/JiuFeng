package com.lingzhuo.jiufeng.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
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
import com.lingzhuo.jiufeng.bean.Msg;
import com.lingzhuo.jiufeng.bean.MsgAll;
import com.lingzhuo.jiufeng.utils.Address;
import com.lingzhuo.jiufeng.utils.TextFormat;
import com.lingzhuo.jiufeng.utils.VolleyUtils;
import com.lingzhuo.jiufeng.view.ItemView;
import com.lingzhuo.jiufeng.view.MsgTitleView;

/**
 * 搜索资讯结果的界面
 */
public class SearchResultActivity extends AppCompatActivity implements View.OnClickListener{

    private String urls,keyword;
    private MsgTitleView msgTitleView;
    private TextView textView_title,textView_keyWord;
    private ImageView imageView_back;
    private int count=1 ;
    private MsgAll msgAll;

    private PullToRefreshScrollView pullToRefreshScrollView;
    private GridLayout gridLayout;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        urls=""+getIntent().getStringExtra("SEARCH_URLS");;
        keyword= urls.substring(urls.lastIndexOf("=")+1);
        init();
        initListener();
        textView_title.setText("搜索结果");
        textView_keyWord.setText(keyword);
        getMsgTitle(urls);
        initPullToRefreshScrollView();
    }

    private void initListener() {
        imageView_back.setOnClickListener(this);
        gridLayout= (GridLayout) findViewById(R.id.gridLayout_search);
        pullToRefreshScrollView= (PullToRefreshScrollView) findViewById(R.id.pullToRefreshScrollView_search);
    }

    private void init() {
        msgTitleView= (MsgTitleView) findViewById(R.id.msgTitleView_search);
        textView_title= (TextView) msgTitleView.findViewById(R.id.msgTitleView_title);
        textView_keyWord= (TextView) msgTitleView.findViewById(R.id.msgTitleView_searchKey);
        imageView_back= (ImageView) msgTitleView.findViewById(R.id.msgTitleView_back);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.msgTitleView_back:
                finish();
                break;
        }
    }


    /**
     * 初始化下拉刷新控件
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
     * 获取搜索返回的信息
     */
    private void getMsgTitle(String urls) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, urls,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        response=response.substring(response.indexOf("(")+1,response.lastIndexOf(")"));
                        msgAll= JSON.parseObject(response, MsgAll.class);
                        if (msgAll.getRows().size()==0){
                            Toast.makeText(SearchResultActivity.this, "已加载全部", Toast.LENGTH_SHORT).show();
                        }else {
                            initMsg();
                        }
                        pullToRefreshScrollView.onRefreshComplete();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "网络不可用", Toast.LENGTH_SHORT).show();
                        pullToRefreshScrollView.onRefreshComplete();
                    }
                });
        VolleyUtils.newInstance(this).addQueue(stringRequest);
    }

    /**
     * 根据返回的搜索结果，加载相应的条目控件
     */
    private void initMsg() {
        for (final Msg msg:msgAll.getRows()){
            TextFormat.formatTitle(msg);
            ItemView itemView=new ItemView(this);
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
                    Intent intent=new Intent(getApplicationContext(), MsgDetialActivity.class);
                    intent.putExtra("MSG_ID",msg.getID());
                    intent.putExtra("MSG_TITLE",msg.getTitle());
                    startActivity(intent);
                }
            });

        }
    }

}
