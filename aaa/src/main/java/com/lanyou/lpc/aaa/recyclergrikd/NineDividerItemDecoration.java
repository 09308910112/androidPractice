package com.lanyou.lpc.aaa.recyclergrikd;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * RecyclerView 九宫格分割线
 *
 * @author 更生
 */
public class NineDividerItemDecoration extends RecyclerView.ItemDecoration {

    private static final int[] ATTRS = new int[]{android.R.attr.listDivider};
    private int spanColumnpan;

    private Drawable mDivider;

    // spanColumn 是 几列
    public NineDividerItemDecoration(Context context, int spanColumn) {
        final TypedArray a = context.obtainStyledAttributes(ATTRS);
        mDivider = a.getDrawable(0);
        a.recycle();
        this.spanColumnpan = spanColumn;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent) {
        drawHorizontal(c, parent);
        drawVertical(c, parent);
    }

    // listview 平行线
    public void drawVertical(Canvas c, RecyclerView parent) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        int childCount = parent.getChildCount();
        int top = 0;
        for (int i = 0; i < childCount; i += spanColumnpan) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            top = child.getBottom() + params.bottomMargin;
            int bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

    // gridview 竖线
    public void drawHorizontal(Canvas c, RecyclerView parent) {
        int top = parent.getPaddingTop();
        int childCount = parent.getChildCount();
        int left = 0;
        int bottom = 0;
        for (int i = 0; i < childCount; i = i + spanColumnpan) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            left = child.getRight() + params.rightMargin;
            bottom = child.getBottom() + params.bottomMargin;
            top = child.getTop() + params.topMargin;
            for (int j = 0; j <= spanColumnpan; j++) {
                int mLeft = left * j;
                int right = mLeft + mDivider.getIntrinsicHeight();
                mDivider.setBounds(mLeft, top, right, bottom);
                mDivider.draw(c);
            }
        }
    }

    // 控件的padding
    @Override
    public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) {
    }
}


