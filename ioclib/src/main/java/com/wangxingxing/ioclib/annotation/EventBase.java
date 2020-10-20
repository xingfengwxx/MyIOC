package com.wangxingxing.ioclib.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * author : 王星星
 * date : 2020/10/20 7:55
 * email : 1099420259@qq.com
 * description :
 */
@Target(ElementType.ANNOTATION_TYPE) // 用于注解上的注解
@Retention(RetentionPolicy.RUNTIME) // 存在于运行期
public @interface EventBase {
    /**
     * 设置监听的方法
     * 监听器的类型
     * 事件触发之后执行的回调方法
     *     btn.setOnClickListener(new View.OnClickListener() {
     *         @Override
     *         public void onClick (View v){
     *
     *         }
     *     });
     */

    /**
     * 设置监听的方法
     *
     * @return
     */
    String listenerSetter();

    /**
     * 设置监听的类型
     *
     * @return
     */
    Class<?> listenerType();

    /**
     * 事件触发之后执行的回调方法
     *
     * @return
     */
    String callbackMethod();
}
