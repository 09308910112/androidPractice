package com.lanyou.test.longrunservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launch(View view) {
        Intent i = new Intent(this, LongRunService.class);
        startService(i);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("lpc999","mainActivity onDestory()");
    }
}
