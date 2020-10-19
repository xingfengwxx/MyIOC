package com.wangxingxing.ioclib.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * author : 王星星
 * date : 2020/10/19 23:39
 * email : 1099420259@qq.com
 * description :
 */
@Target(ElementType.FIELD) // 用于属性上的注解
@Retention(RetentionPolicy.RUNTIME) // 存在于运行期
public @interface ViewInject {
    int value();
}
