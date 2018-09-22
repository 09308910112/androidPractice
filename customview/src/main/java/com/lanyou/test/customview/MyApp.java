package com.lanyou.test.customview;

import android.app.Application;
import android.content.Context;


/**
 * Copyright (c) 2017. 深圳联友科技. All rights reserved
 * Created by lpc on 2018/8/15.
 */
public class MyApp extends Application {
    private static Context context;

    public MyApp() {
        context = this;
    }

    public static Context getContext() {
        return context;
    }
}
