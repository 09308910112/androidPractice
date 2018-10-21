package com.lanyou.test.scanview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.view.animation.LinearInterpolator;
import android.widget.Toast;

public class BaseScanComponent {
    private ObjectAnimator scanAnimator;
    private ObjectAnimator countDownAnimator;

    private ScanView scanView;

    static BaseScanComponent component;

    public static BaseScanComponent getComponent() {
        if (component == null) {
            component = new BaseScanComponent();
        }
        return component;
    }

    public void init(ScanView scanView) {
        this.scanView = scanView;
        initAnimator();
    }

    public void onClick(Context mContext) {
        if (scanView.getLoadingStart()) {
            //如果正在请求接口，不允许点击取消
            Toast.makeText(mContext, "正在执行，不能取消", Toast.LENGTH_SHORT).show();
            return;
        }

        if (scanView.getCountDownStart()) {
            //如果正在倒计时，点击取消
            Toast.makeText(mContext, "正在执行取消操作", Toast.LENGTH_SHORT).show();
            countDownAnimator.cancel();
            scanAnimator.start();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    scanAnimator.cancel();
                }
            }, 10000);
            return;
        }

        scanAnimator.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                scanAnimator.cancel();
                countDownAnimator.start();
            }
        }, 10000);
    }

    private void initAnimator() {
        scanAnimator = ObjectAnimator.ofInt(scanView, "progress", 0, 360);
        scanAnimator.setDuration(15000);
        //重复一百次，动画一次15s，实际上走不到100次
        scanAnimator.setRepeatCount(100);
        scanAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                scanView.setLoadingStart();
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                scanView.reset();
            }
        });

        countDownAnimator = ObjectAnimator.ofInt(scanView, "countDown", 10, 0);
        countDownAnimator.setDuration(10000);
        countDownAnimator.setInterpolator(new LinearInterpolator());

        countDownAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                scanView.reset();
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                scanView.setCountDownStart();
            }
        });
    }
}
