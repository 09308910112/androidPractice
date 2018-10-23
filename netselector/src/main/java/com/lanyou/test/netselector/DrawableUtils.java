package com.lanyou.test.netselector;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;

/**
 * Copyright (c) 2017. 深圳联友科技. All rights reserved
 * Created by lpc on 2018/10/23.
 */
public class DrawableUtils {

    StateListDrawable drawable = new StateListDrawable();
    Context mContext;
    String normalUrl;
    String checkedUrl;
    OnLoadDrawableCallBack callBack;
    RadioButton targetView;
    TextView textView;

    /**
     * 通过回调获取drawable
     * @param normalUrl  正常情况下的url
     * @param checkedUrl 操作后的url
     * @param callBack   回调
     */

    public void obtainSelecorDrawable(Context mContext, String normalUrl, String checkedUrl,
                                      OnLoadDrawableCallBack callBack) {
        this.mContext = mContext;
        this.normalUrl = normalUrl;
        this.checkedUrl = checkedUrl;
        this.callBack = callBack;
        loadFirstImage();
    }

    /**
     * 设置drawable到targetView
     */
    public void setSelectDrawable(Context mContext, String normalUrl, String checkedUrl, RadioButton targetView) {
        this.targetView = targetView;
        initData(mContext,  normalUrl,  checkedUrl);
    }

    public void setSelectTextViewDrawable(Context mContext, String normalUrl, String checkedUrl, TextView textView) {
        this.textView = textView;
        initData(mContext,  normalUrl,  checkedUrl);
    }

    private void initData(Context mContext, String normalUrl, String checkedUrl) {
        this.mContext = mContext;
        this.normalUrl = normalUrl;
        this.checkedUrl = checkedUrl;
        loadFirstImage();
    }


    private void loadFirstImage() {
        SimpleTarget<Drawable> simpleTarget = new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable com.bumptech.glide.request.transition
                    .Transition<? super Drawable> transition) {
                drawable.addState(new int[]{-android.R.attr.state_checked}, resource);
                drawable.setBounds(0, 0, 150, 150);
                loadSecondImage();
            }
        };
        Glide.with(mContext)
                .load(checkedUrl)
                .into(simpleTarget);
    }

    private void loadSecondImage() {
        SimpleTarget<Drawable> simpleTarget1 = new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable com.bumptech.glide.request.transition
                    .Transition<? super Drawable> transition) {
                drawable.addState(new int[]{android.R.attr.state_checked}, resource);
                drawable.setBounds(0, 0, 150, 150);
                if (callBack != null) {
                    callBack.loadDrawableSuccess(drawable);
                }
                if (targetView != null) {
                    targetView.setCompoundDrawables(null, drawable, null, null);
                }else if(textView != null){
                    textView.setCompoundDrawables(null, drawable, null, null);
                }
            }
        };

        Glide.with(mContext)
                .load(normalUrl)
                .into(simpleTarget1);
    }

    public interface OnLoadDrawableCallBack {
        void loadDrawableSuccess(Drawable drawable);
    }


}
