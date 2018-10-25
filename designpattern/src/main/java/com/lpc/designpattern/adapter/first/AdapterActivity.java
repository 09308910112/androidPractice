package com.lpc.designpattern.adapter.first;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lpc.designpattern.R;


public class AdapterActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proxy);

        ElectricAdapter electricAdapter = new ElectricAdapter(new Power50());
        electricAdapter.adapterPower();
        electricAdapter.chargePower();
    }
}
