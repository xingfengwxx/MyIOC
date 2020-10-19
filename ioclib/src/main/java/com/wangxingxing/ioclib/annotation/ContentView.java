package com.wangxingxing.ioclib.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * author : 王星星
 * date : 2020/10/19 23:29
 * email : 1099420259@qq.com
 * description :
 */
@Target(ElementType.TYPE) // 用于类上面的注解
@Retention(RetentionPolicy.RUNTIME) // 存在运行期
public @interface ContentView {
    int value();
}
