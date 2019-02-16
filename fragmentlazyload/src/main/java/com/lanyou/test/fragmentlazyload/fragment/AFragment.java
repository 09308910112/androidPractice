package com.lanyou.test.fragmentlazyload.fragment;

import android.util.Log;

/**
 * Created by wangxw on 2017/2/10 0010 14:58.
 * E-mail:wangxw725@163.com
 * function:
 */
public class AFragment extends BaseFragment {

    @Override
    protected void loadData() {
        Log.i("wxw","AFragment可见,可以加载数据了");
    }

    @Override
    protected String getFragmentTextviewContent() {
        return "Page_0";
    }
}
