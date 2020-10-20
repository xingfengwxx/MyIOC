package com.wangxingxing.ioclib.proxy;

import android.app.Activity;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 *  author : 王星星
 *  date : 2020/10/20 8:21
 *  email : 1099420259@qq.com
 *  description : 
 */
public class EventInvocationHandler implements InvocationHandler {


    private Activity activity;
    private Map<String, Method> methodMap;

    public EventInvocationHandler(Activity activity, Map<String, Method> methodMap) {
        this.activity = activity;
        this.methodMap = methodMap;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //发现Method是onClick方法，执行fix方法
        Method mtd = methodMap.get(method.getName());
        if(mtd != null){
            return mtd.invoke(activity,args);
        }
        return method.invoke(proxy,args);
    }
}
