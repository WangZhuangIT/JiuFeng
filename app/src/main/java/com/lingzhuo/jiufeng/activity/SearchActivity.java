package com.lingzhuo.jiufeng.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lingzhuo.jiufeng.R;
import com.lingzhuo.jiufeng.utils.Address;
import com.lingzhuo.jiufeng.view.TitleView;

/**
 * 点击搜索的界面
 */
public class SearchActivity extends AppCompatActivity implements View.OnClickListener{

    private TitleView titleView;
    private TextView textView_title,textView_text;
    private ImageView imageView_title;
    private EditText editText;
    private Button button_search;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        init();
        initListener();
    }

    private void initListener() {
        button_search.setOnClickListener(this);
    }

    private void init() {
        titleView= (TitleView) findViewById(R.id.titleView_search);
        textView_title= (TextView) titleView.findViewById(R.id.titleView_title);
        textView_text= (TextView) titleView.findViewById(R.id.titleView_textView);
        imageView_title= (ImageView) titleView.findViewById(R.id.titleView_imageView);
        textView_title.setText("资讯搜索");
        imageView_title.setVisibility(View.GONE);
        textView_text.setVisibility(View.GONE);
        button_search= (Button) findViewById(R.id.button_search);
        editText= (EditText) findViewById(R.id.editText_search);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_search:
                if (TextUtils.isEmpty(editText.getText())){
                    Toast.makeText(SearchActivity.this, "请输入搜索关键字", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent=new Intent(this,SearchResultActivity.class);
                    intent.putExtra("SEARCH_URLS",Address.MSG_SEARCH+editText.getText());
                    startActivity(intent);
                }
                break;
        }
    }
}
