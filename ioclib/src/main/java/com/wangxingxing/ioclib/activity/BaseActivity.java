package com.wangxingxing.ioclib.activity;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.wangxingxing.ioclib.utils.InjectUtils;

/**
 *  author : 王星星
 *  date : 2020/10/19 23:25
 *  email : 1099420259@qq.com
 *  description : 
 */
public class BaseActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 注入
        InjectUtils.inject(this);
    }
}
