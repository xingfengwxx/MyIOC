package com.wangxingxing.ioclib.utils;

import android.app.Activity;
import android.view.View;

import com.wangxingxing.ioclib.annotation.ContentView;
import com.wangxingxing.ioclib.annotation.ViewInject;

import java.lang.reflect.Field;

/**
 * author : 王星星
 * date : 2020/10/19 23:26
 * email : 1099420259@qq.com
 * description :
 */
public class InjectUtils {

    /**
     * 注入
     *
     * @param activity
     */
    public static void inject(Activity activity) {
        //注入布局
        injectLayout(activity);
        //注入视图
        injectViews(activity);
        //注入事件
        injectEvents(activity);
    }

    private static void injectEvents(Activity activity) {

    }

    /**
     * 注入视图
     *
     * @param activity
     */
    private static void injectViews(Activity activity) {
        Class<? extends Activity> clazz = activity.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            ViewInject viewInject = field.getAnnotation(ViewInject.class);
            if (viewInject == null) {
                continue;
            }
            int id = viewInject.value();
            View view = activity.findViewById(id);
            field.setAccessible(true);
            try {
                field.set(activity, view);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 注入布局
     *
     * @param activity
     */
    private static void injectLayout(Activity activity) {
        Class<? extends Activity> clazz = activity.getClass();
        ContentView contentView = clazz.getAnnotation(ContentView.class);
        int layoutId = contentView.value();
        activity.setContentView(layoutId);
    }
}
