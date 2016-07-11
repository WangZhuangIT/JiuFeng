package com.lingzhuo.jiufeng.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bumptech.glide.Glide;
import com.lingzhuo.jiufeng.R;
import com.lingzhuo.jiufeng.bean.ArticleSubjectTitleAll;
import com.lingzhuo.jiufeng.bean.MsgDetial;
import com.lingzhuo.jiufeng.bean.MsgDetialAll;
import com.lingzhuo.jiufeng.utils.Address;
import com.lingzhuo.jiufeng.utils.TextFormat;
import com.lingzhuo.jiufeng.utils.VolleyUtils;
import com.lingzhuo.jiufeng.view.MsgTitleView;

/**
 * 用于查看显示文章内容界面
 */
public class MsgDetialActivity extends AppCompatActivity implements View.OnClickListener{

    private String urls;
    private TextView textView_title,textView_time;
    private ImageView imageView_pic,imageView_title_back;
    private MsgTitleView msgTitleView;
    private MsgDetialAll msgDetialAll;
    private String msg_title;

    private WebView webView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg_detial);
        urls= Address.MSG_DETIAL+getIntent().getStringExtra("MSG_ID");
        msg_title=getIntent().getStringExtra("MSG_TITLE");
        init();
        initListener();
        getAllMsg();
    }

    private void initListener() {
        imageView_title_back.setOnClickListener(this);

        webView= (WebView) findViewById(R.id.webView);
    }

    private void init() {
        textView_title= (TextView) findViewById(R.id.msg_activity_title);
        textView_time= (TextView) findViewById(R.id.msg_activity_time);
        imageView_pic= (ImageView) findViewById(R.id.msg_activity_pic);

        msgTitleView= (MsgTitleView) findViewById(R.id.msgTitleView);
        imageView_title_back= (ImageView) msgTitleView.findViewById(R.id.msgTitleView_back);
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
     * 用于获取网络上的文章内容的方法
     */
    public void getAllMsg() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, urls,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        response=response.substring(response.indexOf("(")+1,response.lastIndexOf(")"));
                        msgDetialAll= JSON.parseObject(response, MsgDetialAll.class);
                        initAllUI();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "网络不可用", Toast.LENGTH_SHORT).show();
                    }
                });
        VolleyUtils.newInstance(getApplicationContext()).addQueue(stringRequest);
    }

    /**
     * 初始化界面上的各种UI控件
     */
    private void initAllUI() {
        MsgDetial msgDetial=msgDetialAll.getpInfo().get(0);
        textView_title.setText(msg_title);
        textView_time.setText(msgDetial.getAddDate()+"    "+msgDetial.getAuthor());
        if (!TextUtils.isEmpty(msgDetial.getImageUrl())){
            Glide.with(this).load(Address.URL+msgDetial.getImageUrl().substring(1)).into(imageView_pic);
        }else {
            imageView_pic.setVisibility(View.GONE);
        }
        getWebViewData(msgDetial);
    }

    /**
     * 使用webView加载文章的主要内容
     * @param msgDetial
     */
    private void getWebViewData(MsgDetial msgDetial) {
        String body=msgDetial.getContent();
        String html = "<html><head>" + "</head><body>" + body+ "</body></html>";
        html=html.replace("<img","<img style=\"width:100%;height:auto\" ");
        html=html.replaceFirst("<img style=\"width:100%;height:auto\" ","<img");
        webView.loadDataWithBaseURL("x-data://base", html, "text/html", "UTF-8", null);
        //让我们的webView支持java脚本
        webView.getSettings().setJavaScriptEnabled(true);
    }
}
