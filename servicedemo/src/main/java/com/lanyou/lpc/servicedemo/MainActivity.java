package com.lanyou.lpc.servicedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity /*implements ServiceConnection*/{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }




/*
    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        System.out.println("连接成功了");
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        System.out.println("连接失败了");
    }*/
}
