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

public class ThemeThusActivity extends AppCompatActivity implements View.OnClickListener {

    private MsgTitleView msgTitleView;
    private String people_id;
    private int style;
    private Dialog dialog;

    private ImageView imageView_thus_add, imageView_thus_title_add, imageView_thus_content_add;
    private MyEditText textView_thuser, textView_thus_title, textView_thus_content;
    private Button button_finish_thus;

    private CircleImageView thus1, thus2, thus3;
    private List<CircleImageView> list;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_thus);
        initMsgTitle();
        init();
        initThus();
    }

    private void init() {
        imageView_thus_add = (ImageView) findViewById(R.id.imageView_thus_add);
        imageView_thus_title_add = (ImageView) findViewById(R.id.imageView_thus_title_add);
        imageView_thus_content_add = (ImageView) findViewById(R.id.imageView_thus_content_add);

        textView_thuser = (MyEditText) findViewById(R.id.textView_thuser);
        textView_thus_title = (MyEditText) findViewById(R.id.textView_thus_title);
        textView_thus_content = (MyEditText) findViewById(R.id.textView_thus_content);

        button_finish_thus = (Button) findViewById(R.id.button_finish_thus);
        button_finish_thus.setOnClickListener(this);


        imageView_thus_add.setOnClickListener(this);
        imageView_thus_title_add.setOnClickListener(this);
        imageView_thus_content_add.setOnClickListener(this);
    }

    private void initThus() {
        thus1 = (CircleImageView) findViewById(R.id.thus1);
        thus2 = (CircleImageView) findViewById(R.id.thus2);
        thus3 = (CircleImageView) findViewById(R.id.thus3);


        list = new ArrayList<>();
        list.add(thus1);
        list.add(thus2);
        list.add(thus3);

        thus1.setOnClickListener(this);
        thus2.setOnClickListener(this);
        thus3.setOnClickListener(this);
    }

    private void initMsgTitle() {
        msgTitleView = (MsgTitleView) findViewById(R.id.MsgTitleView_thus);
        ImageView imageView_back = (ImageView) msgTitleView.findViewById(R.id.msgTitleView_back);
        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        TextView textView = (TextView) msgTitleView.findViewById(R.id.msgTitleView_title);
        textView.setText("上香");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageView_thus_add:
                addThuser();
                break;
            case R.id.imageView_thus_title_add:
                addThus_title();
                break;
            case R.id.imageView_thus_content_add:
                addThus_content();
                break;
            case R.id.button_finish_thus:
                Toast.makeText(ThemeThusActivity.this, "没有登录是不能祭拜的哟！", Toast.LENGTH_SHORT).show();
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

    private void addThus_title() {
        dialog=new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view= LayoutInflater.from(this).inflate(R.layout.dialog_title,null);
        TextView textView= (TextView) view.findViewById(R.id.name1);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_thus_title.setText(textView_thus_title.getText()+"祭拜");
                dialog.dismiss();
            }
        });
        TextView textView1= (TextView) view.findViewById(R.id.name2);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_thus_title.setText(textView_thus_title.getText()+"怀念");
                dialog.dismiss();
            }
        });
        dialog.setContentView(view);
        dialog.show();
    }

    private void addThuser() {
        dialog=new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view= LayoutInflater.from(this).inflate(R.layout.dialog_name,null);
        TextView textView= (TextView) view.findViewById(R.id.name1);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_thuser.setText(textView_thuser.getText()+"家属");
                dialog.dismiss();
            }
        });
        TextView textView1= (TextView) view.findViewById(R.id.name2);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_thuser.setText(textView_thuser.getText()+"祭拜者");
                dialog.dismiss();
            }
        });
        dialog.setContentView(view);
        dialog.show();
    }

    private void addThus_content() {
        dialog=new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view= LayoutInflater.from(this).inflate(R.layout.dialog_content,null);
        TextView textView= (TextView) view.findViewById(R.id.name1);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_thus_content.setText(textView_thus_content.getText()+"永远怀念！");
                dialog.dismiss();
            }
        });
        TextView textView1= (TextView) view.findViewById(R.id.name2);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_thus_content.setText(textView_thus_content.getText()+"深刻的缅怀！");
                dialog.dismiss();
            }
        });
        dialog.setContentView(view);
        dialog.show();
    }
}
