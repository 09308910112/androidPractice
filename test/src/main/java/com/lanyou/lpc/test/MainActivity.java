package com.lanyou.lpc.test;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("lpc666","MainActivity onCreate()");
        setContentView(R.layout.activity_main);
    }
}
