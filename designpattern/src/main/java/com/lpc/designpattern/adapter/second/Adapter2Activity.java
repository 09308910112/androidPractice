package com.lpc.designpattern.adapter.second;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lpc.designpattern.R;
import com.lpc.designpattern.adapter.first.ElectricAdapter;
import com.lpc.designpattern.adapter.first.Power50;


public class Adapter2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proxy);
        new com.lpc.designpattern.adapter.second.ElectricAdapter().transmit();
        new com.lpc.designpattern.adapter.second.ElectricAdapter().chargePower();
    }
}
