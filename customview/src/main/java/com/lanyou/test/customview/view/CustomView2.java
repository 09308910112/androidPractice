package com.lanyou.test.customview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.EmbossMaskFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.lanyou.test.customview.R;

/**
 * Copyright (c) 2017. 深圳联友科技. All rights reserved
 * Created by lpc on 2018/8/15.
 */
public class CustomView2 extends View {

    public CustomView2(Context context) {
        this(context, null);
    }

    public CustomView2(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData();

    }

    Paint paint1;
    Paint paint2;
    Paint paint3;
    Paint paint4;
    Paint paint5;
    Paint paint6;
    Paint paint7;

    private void initData() {
        paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        //int[] colors = new int[]{Color.parseColor("#E91E63"),Color.parseColor("#2196E3")};
        int c1 = Color.RED;
        int c2 = Color.YELLOW;
        Shader shader = new LinearGradient(500, 120, 120, 400, c1, c2, Shader.TileMode.MIRROR);
        paint1.setShader(shader);

        paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        Shader shader2 = new RadialGradient(300, 700, 200, Color.RED, Color.YELLOW, Shader.TileMode.REPEAT);
        paint2.setShader(shader2);

        paint3 = new Paint(Paint.ANTI_ALIAS_FLAG);
        Shader shader3 = new SweepGradient(300, 1100, Color.YELLOW, Color.RED);
        paint3.setShader(shader3);

        paint4 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint4.setStyle(Paint.Style.STROKE);
        paint4.setStrokeWidth(5);
 /*       Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        Shader shader4 = new BitmapShader(bitmap, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR);
        paint4.setFilterBitmap(true);
        paint4.setShader(shader4);*/
        PathEffect pathEffect = new DashPathEffect(new float[]{20f, 5f}, 10);
        paint4.setPathEffect(pathEffect);

        paint5 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint5.setStyle(Paint.Style.STROKE);
        paint5.setColor(Color.RED);
        paint5.setStrokeWidth(5);
        PathEffect pathEffect5 = new CornerPathEffect(40);
        paint5.setPathEffect(pathEffect5);


        paint6 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint6.setColor(Color.BLACK);
        paint6.setTextSize(50);

        paint7 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint7.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(300, 300, 200, paint1);
        canvas.drawCircle(300, 700, 200, paint2);
        canvas.drawCircle(300, 1100, 200, paint3);
        canvas.drawCircle(300, 1500, 200, paint4);

        RectF rectF = new RectF(100, 500, 500, 900);
        canvas.drawRoundRect(rectF, 100, 100, paint4);

        Path p = new Path();
        p.moveTo(0, 0);
        p.lineTo(100, 200);
        p.lineTo(400, 0);
        p.lineTo(800, 400);
/*        PathEffect pathEffect5_1 = new PathDashPathEffect(p,40,0, PathDashPathEffect.Style.ROTATE);
        paint5.setPathEffect(pathEffect5_1);*/
        canvas.drawPath(p, paint5);

        paint6.setShadowLayer(10,0,0,Color.RED);
        paint6.setUnderlineText(true);
        paint6.setStrikeThruText(true);
        canvas.drawText("我的自定义View",300,1500,paint6);
        paint7.setMaskFilter(new EmbossMaskFilter(new float[]{0, 1, 1}, 0.2f, 8, 10));
       // paint7.setMaskFilter(new BlurMaskFilter(500, BlurMaskFilter.Blur.OUTER));
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        canvas.drawBitmap(bmp,200,200,paint7);

    }
}
