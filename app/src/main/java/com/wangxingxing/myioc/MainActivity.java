package com.wangxingxing.myioc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.wangxingxing.ioclib.activity.BaseActivity;
import com.wangxingxing.ioclib.annotation.ContentView;
import com.wangxingxing.ioclib.annotation.ViewInject;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    @ViewInject(R.id.tv_hello)
    private TextView mTextViewHello;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "text=" + mTextViewHello.getText());
    }
}