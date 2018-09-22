package com.lanyou.lpc.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class AppService extends Service {
    public AppService() {
    }

    String data = "默认值尼";
    boolean running = false;
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("lpc","app启动了");

        new Thread(){
            @Override
            public void run() {
                super.run();
                running = true;
                while(running){
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.e("lpc",data);
                }
            }
        }.start();
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        running = false;
        Log.e("lpc","app service 停止了");
    }

    @Override
    public IBinder onBind(Intent intent) {
      return new IAppServiceRemoteBinder.Stub() {
          @Override
          public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

          }

          @Override
          public void setData(String data) throws RemoteException {
              AppService.this.data = data;
          }
      };
    }
}
