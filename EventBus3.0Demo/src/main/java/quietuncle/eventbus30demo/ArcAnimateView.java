package quietuncle.eventbus30demo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Copyright (c) 2017. 深圳联友科技. All rights reserved
 * <p>
 * Created by lpc on 2017/12/29-09.
 */

public class ArcAnimateView extends View {

    private int imgResId;
    private Shader shader;
    private Paint paint;
    private int size;
    private int width;
    private float angle = -90;
    private boolean showArc = true;

    public ArcAnimateView(Context context) {
        this(context,null);
    }

    public ArcAnimateView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ArcAnimateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //init();
    }

    public void init() {
            paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            if (imgResId != 0) {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgResId);
                shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            }
            showArc = true;
            angle = -90;
            invalidate();
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {

            angle += 10;
            invalidate();
            if(angle>270){
                angle = -90;
            }
          /*  if (angle < 270) {
               // angle += 10;
                angle += 2;
                invalidate();
            } else {
                removeCallbacks(runnable);
            }*/
        }
    };

    public void setImageRes(int resId) {
        imgResId = resId;
    }

    public void setSize(int size) {
        this.size = size;
    }

   /* @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = widthMeasureSpec;
    }*/

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (showArc) {
            if (size == 0) {
                size = this.getWidth();
            }
            Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
           // paint1.setColor(Color.GREEN);
            paint1.setColor(Color.parseColor("#aaf34649"));
            paint1.setStyle(Paint.Style.FILL);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                canvas.drawArc(0, 0, size, size, -90, angle + 90, true, paint1);
            } else {
                RectF rectF = new RectF(0, 0, size, size);
                canvas.drawArc(rectF, -90, angle + 90, true, paint1);
            }
       /*     if (angle >= 270) {
                showArc = false;
                invalidate();
            }*/
            postDelayed(runnable, 50);
        }
    }

    public void hidenArc(){
        showArc = false;
        removeCallbacks(runnable);
        invalidate();
    }
}
