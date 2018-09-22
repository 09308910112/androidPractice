package com.lanyou.lpc.aaa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


/**
 * Copyright (c) 2017. 深圳联友科技. All rights reserved
 * Created by lpc on 2018/4/6.
 */

public class AActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Intent intent = new Intent(getApplicationContext(),
               BActivity.class);
        startActivity(intent);
    }
}
