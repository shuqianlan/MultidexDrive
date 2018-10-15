package com.smartlocation.multidexdrive;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxyHandler implements InvocationHandler {
    public static final String TAG = "DynamicProxyHandler";
    private Object proxy;

    public DynamicProxyHandler(Object proxy) {
        this.proxy = proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Log.d(TAG, "invoke: ");
        return method.invoke(this.proxy, args);
    }
}
