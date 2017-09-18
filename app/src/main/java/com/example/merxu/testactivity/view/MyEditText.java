package com.example.merxu.testactivity.view;

/**
 * Created by xinyan on 2017/5/7.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.merxu.testactivity.R;


/**
 * 左边有固定文字EditText
 */
public class MyEditText extends android.support.v7.widget.AppCompatEditText implements  View.OnFocusChangeListener, TextWatcher {
    private String fixedText;
    private View.OnClickListener mListener;
    /**
     * 控件是否有焦点
     */
    private boolean hasFoucs;
    Context mContext;
    private Drawable imgInable;
    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext=context;
        init();
    }
    private void init() {
        imgInable = getCompoundDrawables()[2] ;
        imgInable = mContext.getResources().getDrawable(R.drawable.delete);

        imgInable.setBounds(0, 0, imgInable.getIntrinsicWidth(), imgInable.getIntrinsicHeight());
        setClearIconVisible(false);
//        addTextChangedListener(new TextWatcher() {
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {}
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
//            @Override
//            public void afterTextChanged(Editable s) {
////                setDrawable();
//            }
//        });
//        setDrawable();

        //设置焦点改变的监听
        setOnFocusChangeListener(this);
        //设置输入框里面内容发生改变的监听
        addTextChangedListener(this);
    }
    private void setDrawable() {
        if(length() < 1)
            setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        else
            setCompoundDrawablesWithIntrinsicBounds(null, null, imgInable, null);
    }
    public void setFixedText(String text) {
        fixedText = text;
        int left = (int) getPaint().measureText(fixedText) + getPaddingLeft();
        setPadding(left, getPaddingTop(), getPaddingBottom(), getPaddingRight());
//        paint.setColor(Color.GREEN);
        invalidate();
    }
    protected void setClearIconVisible(boolean visible) {
        Drawable right = visible ? imgInable : null;
        setCompoundDrawables(getCompoundDrawables()[0],
                getCompoundDrawables()[1], right, getCompoundDrawables()[3]);
    }

    public void setDrawableClk(View.OnClickListener listener) {
        mListener = listener;
    }
    Paint paint = new Paint();

    @Override
    protected void onDraw(Canvas canvas) {
        if (!TextUtils.isEmpty(fixedText)) {
//            canvas.drawColor(Color.RED);

//            canvas.drawPaint(paint);
//            paint.setColor(Color.RED);
            canvas.drawText(fixedText, 0, (getMeasuredHeight() - getTextSize()) / 2 + getTextSize(), getPaint());
//            paint.setColor(Color.WHITE);
//            paint.setColor(Color.GREEN);
        }
        super.onDraw(canvas);
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//
//        if (mListener != null && getCompoundDrawables()[2] != null) {
//
//            switch (event.getAction()) {
//                case MotionEvent.ACTION_DOWN:
//                    int i = getMeasuredWidth() - getCompoundDrawables()[2].getIntrinsicWidth();
//                    if (event.getX() > i) {
//                        mListener.onClick(this);
//                        return true;
//                    }
//                    break;
//                case MotionEvent.ACTION_UP:
//
//                    break;
//                default:
//                    break;
//            }
//
//        }
//
//        return super.onTouchEvent(event);
//    }
    /**
     * 因为我们不能直接给EditText设置点击事件，所以我们用记住我们按下的位置来模拟点击事件
     * 当我们按下的位置 在  EditText的宽度 - 图标到控件右边的间距 - 图标的宽度  和
     * EditText的宽度 - 图标到控件右边的间距之间我们就算点击了图标，竖直方向就没有考虑
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            if (getCompoundDrawables()[2] != null) {


                boolean touchable = event.getX() > (getWidth() - getTotalPaddingRight())
                        && (event.getX() < ((getWidth() - getPaddingRight())));


                if (touchable) {
                    this.setText("");
                }
            }
        }


        return super.onTouchEvent(event);
    }
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        this.hasFoucs = hasFocus;
        if (hasFocus) {
            setClearIconVisible(getText().length() > 0);
        } else {
            setClearIconVisible(false);
        }
    }
    /*
    * 当输入框里面内容发生变化的时候回调的方法
    */
    @Override
    public void onTextChanged(CharSequence s, int start, int count,
                              int after) {
        if (hasFoucs) {
            setClearIconVisible(s.length() > 0);
        }
    }
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
