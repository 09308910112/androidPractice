package com.lpc.designpattern.adapter.second;

import android.util.Log;

/**
 * Created by lpc on 2018/10/25.
 */
public class ElectricAdapter extends Electric220 implements ITarget50{

    @Override
    public void transmit() {
        Log.e("lpc888","转成50伏");
    }
}
