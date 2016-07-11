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
import com.lingzhuo.jiufeng.view.MsgTitleView;
import com.lingzhuo.jiufeng.view.MyEditText;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ThemeWineActivity extends AppCompatActivity implements View.OnClickListener {

    private MsgTitleView msgTitleView;
    private String people_id;
    private int style;
    private Dialog dialog;

    private ImageView imageView_wine_add, imageView_wine_title_add, imageView_wine_content_add;
    private MyEditText textView_winer, textView_wine_title, textView_wine_content;
    private Button button_finish_wine;

    private CircleImageView wine1, wine2, wine3, wine4;
    private List<CircleImageView> list;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_wine);
        initMsgTitle();
        init();
        initWine();
    }

    private void init() {
        imageView_wine_add = (ImageView) findViewById(R.id.imageView_wine_add);
        imageView_wine_title_add = (ImageView) findViewById(R.id.imageView_wine_title_add);
        imageView_wine_content_add = (ImageView) findViewById(R.id.imageView_wine_content_add);

        textView_winer = (MyEditText) findViewById(R.id.textView_winer);
        textView_wine_title = (MyEditText) findViewById(R.id.textView_wine_title);
        textView_wine_content = (MyEditText) findViewById(R.id.textView_wine_content);

        button_finish_wine = (Button) findViewById(R.id.button_finish_wine);
        button_finish_wine.setOnClickListener(this);


        imageView_wine_add.setOnClickListener(this);
        imageView_wine_title_add.setOnClickListener(this);
        imageView_wine_content_add.setOnClickListener(this);
    }


    private void initMsgTitle() {
        msgTitleView = (MsgTitleView) findViewById(R.id.MsgTitleView_wine);
        ImageView imageView_back = (ImageView) msgTitleView.findViewById(R.id.msgTitleView_back);
        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        TextView textView = (TextView) msgTitleView.findViewById(R.id.msgTitleView_title);
        textView.setText("敬酒");

    }

    private void initWine() {
        wine1 = (CircleImageView) findViewById(R.id.wine1);
        wine2 = (CircleImageView) findViewById(R.id.wine2);
        wine3 = (CircleImageView) findViewById(R.id.wine3);
        wine4 = (CircleImageView) findViewById(R.id.wine4);


        list = new ArrayList<>();
        list.add(wine1);
        list.add(wine2);
        list.add(wine3);
        list.add(wine4);

        wine1.setOnClickListener(this);
        wine2.setOnClickListener(this);
        wine3.setOnClickListener(this);
        wine4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageView_wine_add:
                addWiner();
                break;
            case R.id.imageView_wine_title_add:
                addWiner_title();
                break;
            case R.id.imageView_wine_content_add:
                addWine_content();
                break;
            case R.id.button_finish_wine:
                Toast.makeText(ThemeWineActivity.this, "没有登录是不能祭拜的哟！", Toast.LENGTH_SHORT).show();
                break;
            default:
                for (CircleImageView circleImageView : list) {
                    if (circleImageView.getId() == v.getId()) {
                        circleImageView.setBackgroundResource(R.drawable.circle);
                    } else {
                        circleImageView.setBackgroundResource(0);
                    }
                }
                break;
        }
    }

    private void addWiner_title() {
        dialog=new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view= LayoutInflater.from(this).inflate(R.layout.dialog_title,null);
        TextView textView= (TextView) view.findViewById(R.id.name1);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_wine_title.setText(textView_wine_title.getText()+"祭拜");
                dialog.dismiss();
            }
        });
        TextView textView1= (TextView) view.findViewById(R.id.name2);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_wine_title.setText(textView_wine_title.getText()+"怀念");
                dialog.dismiss();
            }
        });
        dialog.setContentView(view);
        dialog.show();
    }

    private void addWiner() {
        dialog=new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view= LayoutInflater.from(this).inflate(R.layout.dialog_name,null);
        TextView textView= (TextView) view.findViewById(R.id.name1);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_winer.setText(textView_winer.getText()+"家属");
                dialog.dismiss();
            }
        });
        TextView textView1= (TextView) view.findViewById(R.id.name2);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_winer.setText(textView_winer.getText()+"祭拜者");
                dialog.dismiss();
            }
        });
        dialog.setContentView(view);
        dialog.show();
    }

    private void addWine_content() {
        dialog=new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view= LayoutInflater.from(this).inflate(R.layout.dialog_content,null);
        TextView textView= (TextView) view.findViewById(R.id.name1);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_wine_content.setText(textView_wine_content.getText()+"永远怀念！");
                dialog.dismiss();
            }
        });
        TextView textView1= (TextView) view.findViewById(R.id.name2);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_wine_content.setText(textView_wine_content.getText()+"深刻的缅怀！");
                dialog.dismiss();
            }
        });
        dialog.setContentView(view);
        dialog.show();
    }

}
