package com.lanyou.test.scanview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;


public class ScanView extends View {

    /**
     * 扫描进度
     */
    int progress = 0;
    /**
     * 倒计时
     */
    int countDown = 0;
    Paint paint;
    Context mContext;
    Path path;

    /**
     * 扫描的底图
     */
    private Rect rect;
    private boolean isLoadingStart = false;
    private boolean isCountDownStart = false;
    private int centerX;
    private int centerY;
    private PorterDuffXfermode mode;
    private RectF rectF;


    public ScanView(Context context) {
        this(context, null);
    }

    public ScanView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public ScanView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mContext = context;
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        path = new Path();
        rect = new Rect();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (centerX == 0) {
            centerX = getWidth() / 2;
        }
        if (centerY == 0) {
            centerY = getHeight() / 2;
        }

        if (isLoadingStart) {
            int saved = canvas.saveLayer(null, null, Canvas.ALL_SAVE_FLAG);
            paint.setColor(Color.parseColor("#80000000"));
            // 画大圆
            canvas.drawCircle(centerX, centerY, centerX, paint);
            mode = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
            // 设置 Xfermode
            paint.setXfermode(mode);
            paint.setColor(Color.parseColor("#00FFFFFF"));
            // 画中圆
            canvas.drawCircle(centerX, centerY, 41, paint);
            // 用完及时清除 Xfermode
            paint.setXfermode(null);
            canvas.restoreToCount(saved);
            rectF = new RectF(centerX - 33, centerY - 33, centerX + 33, centerY + 33);
            paint.setColor(Color.parseColor("#80000000"));
            canvas.drawArc(rectF, -90, progress - 360, true, paint);
        }

        if (isCountDownStart) {
            Log.e("walker", "绘制倒计时");
            paint.reset();
            paint.setAntiAlias(true);
            paint.setColor(Color.parseColor("#1EB1EB"));
            canvas.drawCircle(centerX, centerY, centerX, paint);
            paint.setColor(Color.parseColor("#FFFFFF"));
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTextSize(Utils.dp2px(mContext, 14));
            //获取文字高度
            String text = countDown + "S";
            paint.getTextBounds(text, 0, text.length(), rect);
            int height = rect.height();
            canvas.drawText(countDown + "S", centerX, centerY + height / 2, paint);
        }
    }

    public void reset() {
        progress = 0;
        countDown = 0;
        isLoadingStart = false;
        isCountDownStart = false;
        invalidate();
    }

    public void setLoadingStart() {
        isLoadingStart = true;
    }

    public boolean getLoadingStart() {
        return isLoadingStart;
    }

    public void setCountDownStart() {
        progress = 0;
        isLoadingStart = false;
        isCountDownStart = true;
    }

    public boolean getCountDownStart() {
        return isCountDownStart;
    }

    public int getCountDown() {
        return countDown;
    }

    public void setCountDown(int countDown) {
        this.countDown = countDown;
        invalidate();
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
        invalidate();
    }
}
