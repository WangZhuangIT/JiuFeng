package com.lingzhuo.jiufeng.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.lingzhuo.jiufeng.R;
import com.lingzhuo.jiufeng.bean.ArticialDetial;
import com.lingzhuo.jiufeng.bean.ArticialDetialAll;
import com.lingzhuo.jiufeng.utils.Address;
import com.lingzhuo.jiufeng.utils.VolleyUtils;
import com.lingzhuo.jiufeng.view.MsgTitleView;

public class ArticialActivity extends AppCompatActivity implements View.OnClickListener{

    private MsgTitleView msgTitleView;
    private WebView webView;
    private ImageView msgTitleView_back;
    private TextView msgTitleView_title;
    private String articial_id;
    private TextView textView_title,textView_detial;


    private ArticialDetialAll articialDetialAll;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articial);
        init();
        articial_id=getIntent().getStringExtra("ARTICIAL_ID");
        getDeadArticial(Address.DEAD_ARTICIAL+articial_id);
    }

    private void init() {
        msgTitleView= (MsgTitleView) findViewById(R.id.msgTitleView_articial);
        webView= (WebView) findViewById(R.id.webView_articial);
        msgTitleView_back = (ImageView) msgTitleView.findViewById(R.id.msgTitleView_back);
        msgTitleView_back.setOnClickListener(this);
        msgTitleView_title = (TextView) msgTitleView.findViewById(R.id.msgTitleView_title);
        msgTitleView_title.setText("纪念文选");

        textView_title= (TextView) findViewById(R.id.text_articial_title);
        textView_detial= (TextView) findViewById(R.id.text_articial_detial);
    }


    private void getDeadArticial(String urls) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, urls,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        response = response.substring(response.indexOf("(") + 1, response.lastIndexOf(")"));
                        articialDetialAll = JSON.parseObject(response, ArticialDetialAll.class);
                        initData();
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

    private void initData() {
        ArticialDetial articialDetial=articialDetialAll.getpInfo().get(0);
        textView_title.setText(articialDetial.getArticleTitle());

        String source;
        if (TextUtils.isEmpty(articialDetial.getArticleSource())){
            source="暂无";
        }else {
            source=articialDetial.getArticleSource();
        }
        String msg="";
        if (TextUtils.isEmpty(articialDetial.getChangeUser())){
            msg+=articialDetial.getCreateUser()+"        ";
        }else {
            msg+=articialDetial.getChangeUser()+"        ";
        }
        if (TextUtils.isEmpty(articialDetial.getCreateDate())) {
            msg+=articialDetial.getChangeDate();
        }else {
            msg+=articialDetial.getCreateDate();
        }
        textView_detial.setText("来源："+source+"      发布者："+msg);
        getWebViewData(articialDetialAll.getpInfo().get(0));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.msgTitleView_back:
                finish();
                break;
        }
    }

    private void getWebViewData(ArticialDetial articialDetial) {
        String body=articialDetial.getArticleHtml();
        String html = "<html><head>" + "</head><body>" + body+ "</body></html>";
        webView.loadDataWithBaseURL("x-data://base", html, "text/html", "UTF-8", null);
        //让我们的webView支持java脚本
        webView.getSettings().setJavaScriptEnabled(true);
    }

}
