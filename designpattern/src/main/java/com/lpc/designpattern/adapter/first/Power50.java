package com.lpc.designpattern.adapter.first;

import android.util.Log;

/**
 * Created by lpc on 2018/10/25.
 */
public class Power50 implements IElectric {
    @Override
    public void chargePower() {
        Log.i("lpc","50伏电压");
    }
}
