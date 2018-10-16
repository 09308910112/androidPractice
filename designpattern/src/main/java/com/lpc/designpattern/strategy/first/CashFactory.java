package com.lpc.designpattern.strategy.first;

import com.lpc.designpattern.R;

/**
 * Created by lpc on 2018/10/15.
 */
public class CashFactory {

    public static CashSuper createCashAccept(int checkedId) {
        CashSuper cashSuper = null;
        switch (checkedId) {
            case R.id.rb_normal:
                cashSuper = new CashNormal();
                break;
            case R.id.rb_discount:
                cashSuper = new CashDiscount();
                break;
            case R.id.rb_return:
                cashSuper = new CashReturn();
                break;
        }
        return cashSuper;
    }
}
