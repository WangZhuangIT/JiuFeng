package com.lingzhuo.jiufeng.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EditText;

import com.lingzhuo.jiufeng.R;

/**
 * Created by Wang on 2016/5/19.
 * 自定义的输入框控件，可以计数已经输入的字数
 */
public class MyEditText extends EditText {
    private Paint paint;
    private float width,height;
    private int textNum;
    public MyEditText(Context context) {
        super(context);
        init(context, null);
    }

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public MyEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MyEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context,AttributeSet attrs){
        paint=new Paint();
        paint.setAntiAlias(true);
//        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(5);
        paint.setTextSize(30);
        if (attrs!=null){
            TypedArray array=getContext().obtainStyledAttributes(attrs, R.styleable.MyEditText);
            int color=array.getColor(R.styleable.MyEditText_attrColor,Color.BLACK);
            textNum=array.getInteger(R.styleable.MyEditText_attrNums,0);
            paint.setColor(color);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width=getWidth();
        height=getHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String text=getText().length()+"/"+textNum;
        if (textNum!=0){
            canvas.drawText(text,getWidth()-paint.measureText(text)-10,getHeight()+getScaleY()-15,paint);
        }
        invalidate();
    }
}
