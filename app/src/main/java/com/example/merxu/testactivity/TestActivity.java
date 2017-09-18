package com.example.merxu.testactivity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by MerXu on 2017/9/14.
 */

public class TestActivity extends Activity {

    private EditText editText;
    private Button btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testactivity);
        initView();
//        doBusiness();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = "";
                String result = editText.getText().toString().trim();
                String [] data =result.split("");
//                Log.e("TAG","RESULT====="+editText.getText().toString()+data.length);
                for(int i= 1 ;i<data.length;i++){
//                    Log.e("TAG","I======"+data[i]+ " tag i=="+i);
                    if(i == data.length -1  ){
                        break;
                    }else{
                        if(data[i].equals(data[i+1])){
                            data[i] = "";
//                            data[0]="";
                            str += data[i+1];
//                            Log.e("TAG","data[i]=="+i);
                        }
                    }
                }
                    editText.setText(str);
            }
        });
    }



    private void initView() {
        editText = (EditText) findViewById(R.id.editView);
        btn = (Button) findViewById(R.id.button);
    }
}
