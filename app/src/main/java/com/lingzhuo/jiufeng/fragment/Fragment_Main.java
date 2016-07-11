package com.lingzhuo.jiufeng.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.lingzhuo.jiufeng.adapter.MyViewPagerAdapter;
import com.lingzhuo.jiufeng.bean.Msg;
import com.lingzhuo.jiufeng.bean.MsgAll;
import com.lingzhuo.jiufeng.utils.Address;
import com.lingzhuo.jiufeng.utils.TextFormat;
import com.lingzhuo.jiufeng.utils.VolleyUtils;
import com.lingzhuo.jiufeng.view.ItemView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wang on 2016/7/3.
 * 带viewpager的文章展示界面的fragment，打开软件第一个界面
 */
@SuppressLint("ValidFragment")
public class Fragment_Main extends Fragment implements ViewPager.OnPageChangeListener {
    private View view;
    private String urls;
    private int count = 1;
    private MsgAll msgAll;
    private GridLayout gridLayout;
    private ViewPager viewPager;
    private LinearLayout linearLayout_dot;
    private List<ImageView> imageViewList, imageViewDotList;
    private MyViewPagerAdapter myViewPagerAdapter;
    private List<Msg> topMsgList;
    private PullToRefreshScrollView pullToRefreshScrollView;
    private boolean isFirst = true;

    @SuppressLint("ValidFragment")
    public Fragment_Main(String urls) {
        this.urls = urls;
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, null);
        init();
        getMsgTitle(urls, true);
        initPullToRefreshScrollView();
        return view;
    }

    private void init() {
        gridLayout = (GridLayout) view.findViewById(R.id.gridLayout_main);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        linearLayout_dot = (LinearLayout) view.findViewById(R.id.linearLayout_dot);
        pullToRefreshScrollView = (PullToRefreshScrollView) view.findViewById(R.id.pullToRefreshScrollView_main);
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
                getMsgTitle(urls + "&page=" + (++count), false);

                //此处执行下拉加载的逻辑处理
                //pullToRefreshScrollView.onRefreshComplete();这行代码必须调用
            }
        });
    }

    /**
     * 获取文章标题等信息的方法
     * @param urls
     * @param isFirst
     */
    private void getMsgTitle(String urls, final boolean isFirst) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, urls,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        response = response.substring(response.indexOf("(") + 1, response.lastIndexOf(")"));
                        msgAll = JSON.parseObject(response, MsgAll.class);
                        if (msgAll.getRows().size()==0){
                            Toast.makeText(getContext(), "已加载全部", Toast.LENGTH_SHORT).show();
                        }else {
                            initMsg();
                            if (isFirst) {
                                initTopMsg();
                            }
                            initViewPager();
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

    /**
     *
     */
    private void initTopMsg() {
        topMsgList = new ArrayList<>();
        for (Msg msg : msgAll.getRows()) {
            if (!TextUtils.isEmpty(msg.getImageUrl())) {
                topMsgList.add(msg);
            }
        }
        myHander.sendEmptyMessageDelayed(1, 2000);
    }

    /**
     * 根据返回的信息加载界面控件
     */
    private void initMsg() {
        for (final Msg msg : msgAll.getRows()) {
            TextFormat.formatTitle(msg);
            ItemView itemView = new ItemView(getContext());
            TextView textView_title = (TextView) itemView.findViewById(R.id.layout_item_title);
            TextView textView_time = (TextView) itemView.findViewById(R.id.layout_item_time);
            ImageView imageView_pic = (ImageView) itemView.findViewById(R.id.layout_item_imageView);
            if (TextUtils.isEmpty(msg.getImageUrl())) {
                imageView_pic.setVisibility(View.GONE);
            } else {
                Glide.with(this).load(Address.URL + msg.getImageUrl().substring(1)).into(imageView_pic);
            }
            textView_title.setText(msg.getTitle());
            textView_time.setText(msg.getAddDate() + "    " + msg.getAuthor());
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

    /**
     * 加载上部ViewPager数据的方法
     */
    private void initViewPager() {
        imageViewList = new ArrayList<>();
        for (Msg msg : topMsgList) {
            ImageView imageView = new ImageView(getContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Glide.with(this).load(Address.URL + msg.getImageUrl().substring(1)).into(imageView);
            imageViewList.add(imageView);
        }
        myViewPagerAdapter = new MyViewPagerAdapter(imageViewList, getContext());
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.setOnPageChangeListener(this);
        getDotImage();
    }

    /**
     * 根据ViewPager的页面个数，定义相应个数的小点
     */
    private void getDotImage() {
        imageViewDotList = new ArrayList<>();
        linearLayout_dot.removeAllViews();
        for (int i = 0; i < imageViewList.size(); i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageViewDotList.add(imageView);
            //这是将这些小点，添加到相应的布局中，同时设置布局的各种属性，边距，大小等等。
            LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(20, 20);
            layout.leftMargin = 5;
            layout.rightMargin = 5;
            linearLayout_dot.addView(imageViewDotList.get(i), layout);
        }
    }

    //根据ViewPager的位置，动态的更改小点的显示，使其和viewpager的位置对应一致
    public void getDots(int position) {
        for (int i = 0; i < imageViewDotList.size(); i++) {
            if (i == position) {
                imageViewDotList.get(i).setImageResource(R.mipmap.dot_yes);
            } else {
                imageViewDotList.get(i).setImageResource(R.mipmap.dot_no);
            }
        }
    }

    /**
     * 当ViewPager自动滚动之后，让下方的定位小点相应更新，同时为ViewPager各个界面添加相应的点击事件
     */
    public void onPageScrolled(final int position, float positionOffset, int positionOffsetPixels) {
        getDots(position);
        imageViewList.get(position).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MsgDetialActivity.class);
                intent.putExtra("MSG_ID",topMsgList.get(position).getID());
                intent.putExtra("MSG_TITLE",topMsgList.get(position).getTitle());
                getContext().startActivity(intent);
            }
        });
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    /**
     * 让页面上方的ViewPager自动滚动
     */
    private Handler myHander = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            myHander.sendEmptyMessageDelayed(1, 2000);
            if (viewPager.getCurrentItem() + 1 >= topMsgList.size()) {
                viewPager.setCurrentItem(0, false);
            } else {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }
        }
    };

}
