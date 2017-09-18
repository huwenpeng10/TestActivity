package com.example.merxu.testactivity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.merxu.testactivity.view.MyEditText;

/**
 * Created by MerXu on 2017/9/18.
 */

public class MyEdtitTextActivity extends Activity {
    MyEditText edit_text;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edittext_main);
        edit_text = (MyEditText) findViewById(R.id.edit_text);
        edit_text.setFixedText("请输入内容：");
    }
}
