package com.lanyou.test.customview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.lanyou.test.customview.R;


/**
 * Copyright (c) 2017. 深圳联友科技. All rights reserved
 * Created by lpc on 2018/10/17.
 */
public class Sample01ClipRectView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Path path1 = new Path();
    Path path2 = new Path();
    Point point1 = new Point(0, 0);
    Point point2 = new Point(600, 200);

    public Sample01ClipRectView(Context context) {
        super(context);
    }

    public Sample01ClipRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample01ClipRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        path1.addCircle(point1.x + 200, point1.y + 200, 150, Path.Direction.CW);

        path2.setFillType(Path.FillType.INVERSE_WINDING);
        path2.addCircle(point2.x + 200, point2.y + 200, 150, Path.Direction.CW);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);


    }

    @Override
    public void onDrawForeground(Canvas canvas) {
        super.onDrawForeground(canvas);
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setTextSize(40);
        p.setColor(Color.WHITE);
        canvas.save();
        canvas.rotate(50);
        canvas.drawText("老铁666",100,100,p);
        canvas.restore();

    }
}
