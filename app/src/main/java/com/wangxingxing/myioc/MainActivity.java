package com.wangxingxing.myioc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wangxingxing.ioclib.activity.BaseActivity;
import com.wangxingxing.ioclib.annotation.ContentView;
import com.wangxingxing.ioclib.annotation.OnClick;
import com.wangxingxing.ioclib.annotation.ViewInject;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    @ViewInject(R.id.tv_hello)
    private TextView mTextViewHello;

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "text=" + mTextViewHello.getText());
    }

    @OnClick({R.id.btn_test_1, R.id.btn_test_2})
    public void fix(View view) {
        Log.i(TAG, "fix: onClick=" + ((Button) view).getText().toString());
    }
}