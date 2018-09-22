package com.lanyou.lpc.progressbarloading;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

  /*      Animation operatingAnim = AnimationUtils.loadAnimation(this, R.anim.loading_progress_bar);
        LinearInterpolator lin = new LinearInterpolator();
        operatingAnim.setInterpolator(lin);

        ImageView iv = findViewById(R.id.iv);
        iv.startAnimation(operatingAnim);*/

        Animation rotate = AnimationUtils.loadAnimation(this, R.anim.loading_progress_bar);
        ((ImageView) findViewById(R.id.iv)).setAnimation(rotate);
        ((ImageView) findViewById(R.id.iv)).startAnimation(rotate);

/*      TextView tvPadding =  findViewById(R.id.tv_padding);
        tvPadding.measure(0,0);
        int height = tvPadding.getMeasuredHeight();
        Log.e("lpc","height = "+height);
        int newHeight = height/2;
        Log.e("lpc","newHeight = "+newHeight);
        tvPadding.setPadding(0,-200,0,0);*/
        initView();
    }

    private void initView() {
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Aactivity.class);
                Aactivity.setA(MainActivity.this);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==1){
            Toast.makeText(this,"MainActivity界面接收到了",Toast.LENGTH_LONG).show();
            Log.e("lpc55555","mainActivity");
        }
    }
}
