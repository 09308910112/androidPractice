package com.lanyou.test.viewpagerdemo;

import android.app.Application;

import com.facebook.stetho.Stetho;

public class CApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
