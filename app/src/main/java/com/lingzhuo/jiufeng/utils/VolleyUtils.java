package com.lingzhuo.jiufeng.utils;

import android.content.Context;
import android.graphics.Bitmap;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by Wang on 2016/5/5.
 * 用于进行网络访问的工具类
 */
public class VolleyUtils {
    private static VolleyUtils volleyUtils;
    private RequestQueue requestQueue;
    private Context context;
    private ImageLoader imageLoader;

    public VolleyUtils(Context context) {
        this.context = context;
        if (requestQueue==null){
            requestQueue= Volley.newRequestQueue(context);
        }
    }

    public static synchronized VolleyUtils newInstance(Context context){
        if (volleyUtils==null){
            volleyUtils=new VolleyUtils(context);
        }
        return volleyUtils;
    }

    public RequestQueue getRequestQueue(){
        return requestQueue;
    }

    public void addQueue(Request request){
        requestQueue.add(request);
    }
}
