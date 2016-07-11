package com.lingzhuo.jiufeng.activity;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lingzhuo.jiufeng.R;
import com.lingzhuo.jiufeng.utils.ThemeAction;
import com.lingzhuo.jiufeng.view.MsgTitleView;
import com.lingzhuo.jiufeng.view.MyEditText;

public class ThemeWorshipActivity extends AppCompatActivity implements View.OnClickListener {

    private MsgTitleView msgTitleView;
    private String people_id;
    private int style;
    private Dialog dialog;

    private ImageView imageView_worshiper_add, imageView_worship_title_add, imageView_worship_content_add;
    private MyEditText textView_worshiper, textView_worship_title, textView_worship_content;
    private Button button_finish_worship;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_worship);
        people_id = getIntent().getStringExtra("PEOPLE_ID");
        style = getIntent().getIntExtra("STYLE", 0);
        initMsgTitle();
        init();
    }

    private void init() {
        imageView_worshiper_add = (ImageView) findViewById(R.id.imageView_worshiper_add);
        imageView_worship_title_add = (ImageView) findViewById(R.id.imageView_worship_title_add);
        imageView_worship_content_add = (ImageView) findViewById(R.id.imageView_worship_content_add);

        textView_worshiper = (MyEditText) findViewById(R.id.textView_worshiper);
        textView_worship_title = (MyEditText) findViewById(R.id.textView_worship_title);
        textView_worship_content = (MyEditText) findViewById(R.id.textView_worship_content);

        button_finish_worship = (Button) findViewById(R.id.button_finish_worship);
        button_finish_worship.setOnClickListener(this);


        imageView_worshiper_add.setOnClickListener(this);
        imageView_worship_title_add.setOnClickListener(this);
        imageView_worship_content_add.setOnClickListener(this);
    }

    private void initMsgTitle() {
        msgTitleView = (MsgTitleView) findViewById(R.id.MsgTitleView_theme3);
        ImageView imageView_back = (ImageView) msgTitleView.findViewById(R.id.msgTitleView_back);
        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        TextView textView = (TextView) msgTitleView.findViewById(R.id.msgTitleView_title);
        switch (style) {
            case ThemeAction.THEME_WORSHIP:
                textView.setText("祭拜");
                break;
            case ThemeAction.THEME_MSG:
                textView.setText("留言");
                break;
            case ThemeAction.THEME_CLEAN:
                textView.setText("清洁");
                break;

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageView_worshiper_add:
                addWorshiper();
                break;
            case R.id.imageView_worship_title_add:
                addWorship_title();
                break;
            case R.id.imageView_worship_content_add:
                addWorship_content();
                break;
            case R.id.button_finish_worship:
                Toast.makeText(ThemeWorshipActivity.this, "没有登录是不能祭拜的哟！", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void addWorship_content() {
        dialog=new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view= LayoutInflater.from(this).inflate(R.layout.dialog_content,null);
        TextView textView= (TextView) view.findViewById(R.id.name1);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_worship_content.setText(textView_worship_content.getText()+"永远怀念！");
                dialog.dismiss();
            }
        });
        TextView textView1= (TextView) view.findViewById(R.id.name2);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_worship_content.setText(textView_worship_content.getText()+"深刻的缅怀！");
                dialog.dismiss();
            }
        });
        dialog.setContentView(view);
        dialog.show();
    }

    private void addWorship_title() {
        dialog=new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view= LayoutInflater.from(this).inflate(R.layout.dialog_title,null);
        TextView textView= (TextView) view.findViewById(R.id.name1);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_worship_title.setText(textView_worship_title.getText()+"祭拜");
                dialog.dismiss();
            }
        });
        TextView textView1= (TextView) view.findViewById(R.id.name2);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_worship_title.setText(textView_worship_title.getText()+"怀念");
                dialog.dismiss();
            }
        });
        dialog.setContentView(view);
        dialog.show();
    }

    private void addWorshiper() {
        dialog=new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view= LayoutInflater.from(this).inflate(R.layout.dialog_name,null);
        TextView textView= (TextView) view.findViewById(R.id.name1);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_worshiper.setText(textView_worshiper.getText()+"家属");
                dialog.dismiss();
            }
        });
        TextView textView1= (TextView) view.findViewById(R.id.name2);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_worshiper.setText(textView_worshiper.getText()+"祭拜者");
                dialog.dismiss();
            }
        });
        dialog.setContentView(view);
        dialog.show();
    }
}
