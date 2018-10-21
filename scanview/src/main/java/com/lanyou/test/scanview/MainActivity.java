package com.lanyou.test.scanview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ScanView sv_whistle = findViewById(R.id.sv);
        BaseScanComponent.getComponent().init(sv_whistle);
    }

    public void click(View view) {
        BaseScanComponent.getComponent().onClick(this);
    }
}
