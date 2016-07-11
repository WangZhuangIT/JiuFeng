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

public class ThemeFlowerActivity extends AppCompatActivity implements View.OnClickListener {

    private MsgTitleView msgTitleView;
    private String people_id;
    private int style;
    private Dialog dialog;

    private ImageView imageView_flower_add, imageView_worship_flower_add, imageView_flower_content_add;
    private MyEditText textView_flower, textView_flower_title, textView_flower_content;
    private Button button_finish_flower;

    private CircleImageView flower1,flower2,flower3,flower4;
    private CircleImageView flower5,flower6,flower7,flower8;

    private List<CircleImageView> list;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_flower);
        people_id = getIntent().getStringExtra("PEOPLE_ID");
        style = getIntent().getIntExtra("STYLE", 0);
        initMsgTitle();
        init();
        initFlower();
    }

    private void initFlower() {
        flower1= (CircleImageView) findViewById(R.id.flower1);
        flower2= (CircleImageView) findViewById(R.id.flower2);
        flower3= (CircleImageView) findViewById(R.id.flower3);
        flower4= (CircleImageView) findViewById(R.id.flower4);


        flower5= (CircleImageView) findViewById(R.id.flower5);
        flower6= (CircleImageView) findViewById(R.id.flower6);
        flower7= (CircleImageView) findViewById(R.id.flower7);
        flower8= (CircleImageView) findViewById(R.id.flower8);

        list=new ArrayList<>();
        list.add(flower1);
        list.add(flower2);
        list.add(flower3);
        list.add(flower4);
        list.add(flower5);
        list.add(flower6);
        list.add(flower7);
        list.add(flower8);

        flower1.setOnClickListener(this);
        flower2.setOnClickListener(this);
        flower3.setOnClickListener(this);
        flower4.setOnClickListener(this);

        flower5.setOnClickListener(this);
        flower6.setOnClickListener(this);
        flower7.setOnClickListener(this);
        flower8.setOnClickListener(this);
    }

    private void init() {
        imageView_flower_add = (ImageView) findViewById(R.id.imageView_flower_add);
        imageView_worship_flower_add = (ImageView) findViewById(R.id.imageView_flower_title_add);
        imageView_flower_content_add = (ImageView) findViewById(R.id.imageView_flower_content_add);

        textView_flower = (MyEditText) findViewById(R.id.textView_flower);
        textView_flower_title = (MyEditText) findViewById(R.id.textView_flower_title);
        textView_flower_content = (MyEditText) findViewById(R.id.textView_flower_content);

        button_finish_flower = (Button) findViewById(R.id.button_finish_flower);
        button_finish_flower.setOnClickListener(this);


        imageView_flower_add.setOnClickListener(this);
        imageView_worship_flower_add.setOnClickListener(this);
        imageView_flower_content_add.setOnClickListener(this);
    }

    private void initMsgTitle() {
        msgTitleView = (MsgTitleView) findViewById(R.id.MsgTitleView_flower);
        ImageView imageView_back = (ImageView) msgTitleView.findViewById(R.id.msgTitleView_back);
        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        TextView textView = (TextView) msgTitleView.findViewById(R.id.msgTitleView_title);
        textView.setText("献花");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageView_flower_add:
                addFlower();
                break;
            case R.id.imageView_flower_title_add:
                addFlower_title();
                break;
            case R.id.imageView_flower_content_add:
                addFlower_content();
                break;
            case R.id.button_finish_flower:
                Toast.makeText(ThemeFlowerActivity.this, "没有登录是不能祭拜的哟！", Toast.LENGTH_SHORT).show();
                break;
            default:
                for (CircleImageView circleImageView:list){
                    if (circleImageView.getId()==v.getId()){
                        circleImageView.setBackgroundResource(R.drawable.circle);
                    }else {
                        circleImageView.setBackgroundResource(0);
                    }
                }
                break;
        }
    }

    private void addFlower_title() {
        dialog=new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view= LayoutInflater.from(this).inflate(R.layout.dialog_title,null);
        TextView textView= (TextView) view.findViewById(R.id.name1);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_flower_title.setText(textView_flower_title.getText()+"祭拜");
                dialog.dismiss();
            }
        });
        TextView textView1= (TextView) view.findViewById(R.id.name2);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_flower_title.setText(textView_flower_title.getText()+"怀念");
                dialog.dismiss();
            }
        });
        dialog.setContentView(view);
        dialog.show();
    }

    private void addFlower() {
        dialog=new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view= LayoutInflater.from(this).inflate(R.layout.dialog_name,null);
        TextView textView= (TextView) view.findViewById(R.id.name1);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_flower.setText(textView_flower.getText()+"家属");
                dialog.dismiss();
            }
        });
        TextView textView1= (TextView) view.findViewById(R.id.name2);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_flower.setText(textView_flower.getText()+"祭拜者");
                dialog.dismiss();
            }
        });
        dialog.setContentView(view);
        dialog.show();
    }

    private void addFlower_content() {
        dialog=new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view= LayoutInflater.from(this).inflate(R.layout.dialog_content,null);
        TextView textView= (TextView) view.findViewById(R.id.name1);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_flower_content.setText(textView_flower_content.getText()+"永远怀念！");
                dialog.dismiss();
            }
        });
        TextView textView1= (TextView) view.findViewById(R.id.name2);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_flower_content.setText(textView_flower_content.getText()+"深刻的缅怀！");
                dialog.dismiss();
            }
        });
        dialog.setContentView(view);
        dialog.show();
    }

}
