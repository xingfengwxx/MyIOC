package com.wangxingxing.ioclib.utils;

import android.app.Activity;
import android.view.View;

import com.wangxingxing.ioclib.annotation.ContentView;
import com.wangxingxing.ioclib.annotation.EventBase;
import com.wangxingxing.ioclib.annotation.ViewInject;
import com.wangxingxing.ioclib.proxy.EventInvocationHandler;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

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

    /**
     * 注入事件
     *
     * @param activity
     */
    private static void injectEvents(Activity activity) {
        Class<? extends Activity> clazz = activity.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            // 获取方法所有的注解
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                Class<? extends Annotation> annotationType = annotation.annotationType();
                EventBase eventBase = annotationType.getAnnotation(EventBase.class);
                if (eventBase == null) {
                    continue;
                }

                //本质上还是要干这件事情，但是要通过反射
                //    btn.setOnClickListener(new View.OnClickListener() {
                //        @Override
                //        public void onClick (View v){
                //
                //        }
                //    });

                //事件要素
                String listenerSetter = eventBase.listenerSetter();
                Class<?> listenerType = eventBase.listenerType();
                String callbackMethod = eventBase.callbackMethod();

                //方法拦截的对应关系
                Map<String, Method> methodMap = new HashMap<>();
                methodMap.put(callbackMethod, method);

                //事件源
                //通过方法拿到事件源
                try {
                    Method valueMethod = annotationType.getDeclaredMethod("value");
                    int[] viewIds = (int[]) valueMethod.invoke(annotation);
                    for (int id : viewIds) {
                        View view = activity.findViewById(id);
                        if (view == null) {
                            continue;
                        }

                        //setOnClickListener method
                        Method setListenerMethod = view.getClass().getMethod(listenerSetter, listenerType);
                        // 如何得到View.OnClickListener监听器的代理对象
                        EventInvocationHandler invocationHandler = new EventInvocationHandler(activity, methodMap);
                        Object proxy = Proxy.newProxyInstance(listenerType.getClassLoader(), new Class<?>[]{listenerType}, invocationHandler);
                        setListenerMethod.invoke(view, proxy);
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }


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
