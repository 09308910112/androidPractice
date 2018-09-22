package com.lanyou.lpc.progressbarloading;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


/**
 * Copyright (c) 2017. 深圳联友科技. All rights reserved
 * Created by lpc on 2018/3/13.
 */

public class Aactivity extends Activity {

    public static Activity mActivity;

    public static void setA(Activity activity) {
        mActivity = activity;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Button button =  findViewById(R.id.btn_a);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Aactivity.this,Bactivity.class);
                mActivity.startActivityForResult(intent,1);
            }
        });

        Button buttonb =  findViewById(R.id.btn_b);
        buttonb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Aactivity.this,Bactivity.class);
                Aactivity.this.startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==1){
            Toast.makeText(this,"Aactivity is 66666",Toast.LENGTH_LONG).show();
            Log.e("lpc55555","Aactivity");
        }
    }
}
