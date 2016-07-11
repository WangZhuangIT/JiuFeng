package com.lingzhuo.jiufeng.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lingzhuo.jiufeng.R;
import com.lingzhuo.jiufeng.utils.Address;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by Wang on 2016/7/3.
 * 对应灵堂登录的点击切换的fragment
 */
public class FragmentPage3 extends Fragment implements View.OnClickListener{
    private View view;
    private EditText editText_id,editText_password,editText_code;
    private Button button_login;
    private ImageView imageView_code;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_3,null);
        init();
        getCheckCode();
        return view;
    }

    /**
     * 初始化各种控件的方法
     */
    private void init() {
        editText_id= (EditText) view.findViewById(R.id.editText_id);
        editText_password= (EditText) view.findViewById(R.id.editText_password);
        editText_code= (EditText) view.findViewById(R.id.editText_code);
        button_login= (Button) view.findViewById(R.id.button_login);
        imageView_code= (ImageView) view.findViewById(R.id.imageView_code);

        button_login.setOnClickListener(this);
        imageView_code.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_login:
                checkLogin();
                break;
            case R.id.imageView_code:
                getCheckCode();
                break;
        }
    }

    /**
     * 这是用来对登录的信息进行验证的方法
     */
    private void checkLogin() {
        if (TextUtils.isEmpty(editText_id.getText())||TextUtils.isEmpty(editText_password.getText())){
            Toast.makeText(getContext(), "请输入用户名和密码", Toast.LENGTH_SHORT).show();
        }else{

        }
    }

    /**
     * 用于获取登录验证码的方法
     */
    public void getCheckCode() {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(false)//在内存中缓存
                .cacheOnDisc(false)//存储卡的缓存，需要添加相应的存储卡读写权限
                .build();
        ImageLoader.getInstance().displayImage(Address.GET_CODES, imageView_code, options);//加载图片
    }
}
