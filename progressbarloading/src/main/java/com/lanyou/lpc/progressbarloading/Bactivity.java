package com.lanyou.lpc.progressbarloading;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * Copyright (c) 2017. 深圳联友科技. All rights reserved
 * Created by lpc on 2018/3/13.
 */

public class Bactivity extends Activity {

    public static Activity mActivity;

    public static void setB(Activity activity) {
        mActivity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
       Button b =  findViewById(R.id.btn);
       b.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Bactivity.this.finish();
           }
       });
    }


}
