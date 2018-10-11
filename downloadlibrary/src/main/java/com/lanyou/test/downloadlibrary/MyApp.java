package com.lanyou.test.downloadlibrary;

import android.app.Application;
import android.content.Context;

/**
 * Copyright (c) 2017. 深圳联友科技. All rights reserved
 * Created by lpc on 2018/10/11.
 */
public class MyApp extends Application {

    private static MyApp context;

    @Override
    public void onCreate() {
        context = this;
        super.onCreate();
    }

    public static Context getContext() {
        return context;
    }
}
