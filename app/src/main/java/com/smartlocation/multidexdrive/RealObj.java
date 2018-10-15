package com.smartlocation.multidexdrive;

import android.util.Log;

public class RealObj implements Interface {
    public static final String TAG = "RealObject";

    @Override
    public void doSomeThing() {
        Log.d(TAG, "doSomeThing: do_some_things");
    }

    @Override
    public void somethingsElse(String args) {
        Log.d(TAG, "somethingsElse: args " + args);
    }

}
