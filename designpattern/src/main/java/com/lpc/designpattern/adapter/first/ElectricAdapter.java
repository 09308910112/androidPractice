package com.lpc.designpattern.adapter.first;

/**
 * Created by lpc on 2018/10/25.
 */
public class ElectricAdapter extends Power220 {

    IElectric electric;

    public ElectricAdapter(IElectric electric) {
        this.electric = electric;
    }

    @Override
    public void chargePower() {
        super.chargePower();
    }

    public void adapterPower() {
        electric.chargePower();
    }
}
