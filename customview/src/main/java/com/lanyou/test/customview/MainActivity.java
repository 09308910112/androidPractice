package com.lanyou.test.customview;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observers.ResourceObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //timerCountDown();
    }

    private void timerCountDown() {
        CountDownTimer timer = new CountDownTimer(10*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Log.e("lpc666","millisUntilFinished:"+millisUntilFinished);
            }

            @Override
            public void onFinish() {
                Log.e("lpc666","9999");
            }
        };
        timer.start();
    }

    String TAG = "lpc777";
    Disposable mDisposable;
    private void rxJavaCountDown() {
         mDisposable = Flowable.intervalRange(0, 11, 0, 1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.e(TAG,"倒计时 " + String.valueOf(10 - aLong) + " 秒");
                        if(aLong ==5){
                            mDisposable.dispose();

                        }
                    }
                })
                .doOnComplete(new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.d(TAG, "倒计时完毕");

                        Toast.makeText(MainActivity.this, "倒计时完毕", Toast.LENGTH_SHORT).show();
                    }
                })
                .subscribe();
    }
}
