package com.lanyou.test.netselector;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;


public class MainActivity extends AppCompatActivity {

    private StateListDrawable drawable;
    private TextView btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawable = new StateListDrawable();
        btn = findViewById(R.id.btn);
        init();

        ImageView btn1 = findViewById(R.id.btn1);
        Glide.with(this)
                .load("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3298597340,1396845332&fm=200&gp=0.jpg")
                .into(btn1);
    }

    private void init() {
        Log.e("lpc111", "0000");
        loadFirstImage();

    }

    private void loadSecondImage() {
        SimpleTarget<Drawable> simpleTarget1 = new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable com.bumptech.glide.request.transition
                    .Transition<? super Drawable> transition) {
                drawable.addState(new int[]{android.R.attr.state_pressed}, resource);
                drawable.setBounds(0, 0, 150, 150);
                btn.setCompoundDrawables(null, drawable, null, null);
            }
        };

        Glide.with(this)
                .load("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1643843887,3215689086&fm=26&gp=0.jpg")
                .into(simpleTarget1);
    }

    private void loadFirstImage() {

        SimpleTarget<Drawable> simpleTarget = new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable com.bumptech.glide.request.transition
                    .Transition<? super Drawable> transition) {
                drawable.addState(new int[]{-android.R.attr.state_pressed}, resource);
                drawable.setBounds(0, 0, 150, 150);
                loadSecondImage();
            }
        };
        Glide.with(this)
                .load("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3298597340,1396845332&fm=200&gp=0.jpg")
                .into(simpleTarget);
    }
}
