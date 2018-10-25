package com.lpc.designpattern.adapter.first;

import android.util.Log;

/**
 * Created by lpc on 2018/10/25.
 */
public class Power220 implements IElectric {
    @Override
    public void chargePower() {
        Log.i("lpc","220伏电压");
    }
}
