package com.lanyou.test.customview.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.lanyou.test.customview.MyApp;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Copyright (c) 2017. 深圳联友科技. All rights reserved
 * Created by lpc on 2018/8/15.
 */
public class CustomView1 extends View {

    private Paint paintRect;
    private Paint paintOval;

    public CustomView1(Context context) {
        this(context, null);
    }

    public CustomView1(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    int endAngle = 0;
    public CustomView1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Observable.interval(15, TimeUnit.MILLISECONDS).subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
               if(endAngle++ >360){
                   endAngle =0;
               }
               invalidate();
            }
        });
        initData();

    }

    Paint paintCircle;
    Paint paintText;
    Paint paintPoint;

    private void initData() {
        paintCircle = new Paint();
        paintCircle.setColor(Color.GREEN);
        paintCircle.setStrokeWidth(12);
        paintCircle.setStyle(Paint.Style.FILL);
        //  paintCircle.setAntiAlias(true);

        paintText = new Paint();
        paintText.setColor(Color.BLUE);
        paintText.setTextSize(36);

        paintRect = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintRect.setColor(Color.BLUE);

        paintPoint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintPoint.setColor(Color.RED);
        paintPoint.setStrokeCap(Paint.Cap.ROUND);
        paintPoint.setStrokeWidth(40);

        paintOval = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintOval.setStyle(Paint.Style.FILL);
    }


    @SuppressLint("Range")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float cx = Utils.dip2px(MyApp.getContext(), 50);
        float cy = Utils.dip2px(MyApp.getContext(), 50);
        float radius = Utils.dip2px(MyApp.getContext(), 50);
        //会把整个区域染成纯黑色
        // canvas.drawColor(Color.BLACK);
        canvas.drawCircle(cx, cy, radius, paintCircle);
        canvas.drawText("刘鹏程", cx, cy, paintText);

        //画矩形
        canvas.drawRect(200, 200, 400, 400, paintRect);

        // canvas.drawPoint(500,500,paintPoint);
        float[] floatArr = new float[]{20, 20, 50, 50, 100, 100, 200, 200, 300, 300, 400, 400};
        canvas.drawPoints(floatArr, 2, 8, paintPoint);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawOval(300, 300, 600, 500, paintOval);
        }

    /*    paintOval.setStrokeWidth(8);
        canvas.drawLine(602, 502, 700, 730, paintOval);

        float[] floatArr1 = new float[]{10, 10, 30, 20, 40, 555, 60, 30, 42, 2, 222, 323, 7, 44};
        canvas.drawLines(floatArr1, paintOval);*/

        paintOval.setStyle(Paint.Style.STROKE);
        paintOval.setStrokeWidth(10);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawRoundRect(600, 600, 800, 800, 50, 50, paintOval);
        }

        Paint paintArc = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintArc.setStyle(Paint.Style.FILL);
        paintArc.setColor(Color.RED);

        float bottom = 1300;
        float top = 900;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            paintOval.setStrokeWidth(3);
            paintOval.setStyle(Paint.Style.STROKE);
            canvas.drawOval(200, top, 800, bottom, paintOval);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
           /* canvas.drawArc(200, top, 800, bottom, -110, 100, true, paintArc);
            canvas.drawArc(200, top, 800, bottom, 20, 140, false, paintArc);*/
            //canvas.drawArc(200, top, 800, bottom, 0, endAngle, true, paintArc);
           // canvas.drawCircle(200,900,80,paintArc);
            paintArc.setStrokeWidth(5);
            paintArc.setStyle(Paint.Style.STROKE);
            canvas.drawArc(200, 740, 360, 900, 0, endAngle, false, paintArc);

            paintOval.setStrokeWidth(10);
            paintOval.setColor(Color.BLUE);

           // canvas.drawArc(200, top, 800, bottom, 180, 60, false, paintOval);
        }

     /*   Path path = new Path();
        path.moveTo(750,1300);
        path.lineTo(850,1400);
        path.lineTo(950,1300);
        path.addCircle(800,1300,50,Path.Direction.CW);
        path.addCircle(900,1300,50,Path.Direction.CW);
        path.close();*/
        Path path = new Path();
        paintArc.setStyle(Paint.Style.STROKE);
        paintArc.setColor(Color.BLUE);
        paintArc.setStrokeWidth(4);
        path.lineTo(100,100);
        path.rLineTo(100,0);
        canvas.drawPath(path, paintArc);

        Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint1.setStyle(Paint.Style.FILL);
        Path p = new Path();
        p.moveTo(600,400);
        p.lineTo(1000,400);
        p.lineTo(800,600);
        p.close();
        canvas.drawPath(p,paint1);

        Paint paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint2.setTextSize(40);
        paint1.setStyle(Paint.Style.FILL);
        Path p2 = new Path();
        p2.setFillType(Path.FillType.EVEN_ODD);
        p2.addCircle(600,800,70,Path.Direction.CW);
        p2.addCircle(600,800,90,Path.Direction.CW);
     /*   p.moveTo(600,400);
        p.lineTo(1000,400);
        p.lineTo(800,600);
        p.close();*/
        canvas.drawPath(p2,paint2);
        canvas.drawText("我自横刀向天笑",600,1100,paint2);
    }
}
