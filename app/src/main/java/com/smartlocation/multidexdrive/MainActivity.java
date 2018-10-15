package com.smartlocation.multidexdrive;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Property;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = " =====";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Class clas1 = Person.class;

        Log.d(TAG, "onResume: ");
        try {
            Class clas2 = Class.forName("com.smartlocation.multidexdrive.Person");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Person person = new Person("Tom", 19);
        Class clz = person.getClass();

//        Field[] fileds = clz.getDeclaredFields();
//
//        for(Field field:fileds) {
//            String key = field.getName();
//            PropertyDescriptor descriptor = new PropertyDescriptor(key, clz);
//            Method method = descriptor.getReadMethod(); // getWriteMethod..
//            Object value = method.invoke(person);
//
//            Log.d(TAG, "onResume: key " + key + " value " + value);
//        }

        RealObj real = new RealObj();
        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(), new Class[] {Interface.class}, new DynamicProxyHandler(real));

        proxy.doSomeThing();
        proxy.somethingsElse("=====");

        AssetManager manager = null;
        try {
            AssetManager assetManager = AssetManager.class.newInstance();
            Method method = assetManager.getClass().getMethod("addAssetPath", String.class);
            method.invoke(assetManager, "path");
            manager = assetManager;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Resources resources = super.getResources();
        Resources mResource = new Resources(manager, resources.getDisplayMetrics(), resources.getConfiguration());
        Resources.Theme mTheme = mResource.newTheme();
        mTheme.setTo(super.getTheme());
    }
}
