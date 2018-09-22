package com.lanyou.test.longrunservice;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Copyright (c) 2017. 深圳联友科技. All rights reserved
 * Created by lpc on 2018/9/22.
 */
public class LongRunService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
     /*   new Thread(new Runnable() {
            @Override
            public void run() {*/
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                System.out.println();// new Date()为获取当前系统时间
                Log.e("lpc999", "当前时间：" + df.format(new Date()));
     /*       }
        });*/

        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        int second = 10 * 1000;
        long triggerAtTime = SystemClock.elapsedRealtime() + second;
        Intent i = new Intent(this, LongRunService.class);
        PendingIntent pi = PendingIntent.getService(this, 0, i, 0);
        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime, pi);
        return super.onStartCommand(intent, flags, startId);
    }
}
