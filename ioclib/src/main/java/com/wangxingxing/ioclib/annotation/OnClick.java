package com.wangxingxing.ioclib.annotation;

import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * author : 王星星
 * date : 2020/10/20 7:50
 * email : 1099420259@qq.com
 * description :
 */
@Target(ElementType.METHOD) // 用于方法上的注解
@Retention(RetentionPolicy.RUNTIME) // 存在于运行期
@EventBase(listenerSetter = "setOnClickListener",listenerType = View.OnClickListener.class,callbackMethod = "onClick")
public @interface OnClick {
    int[] value();
}
