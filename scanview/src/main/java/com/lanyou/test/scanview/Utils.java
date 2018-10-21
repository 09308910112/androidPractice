package com.lanyou.test.scanview;

import android.content.Context;
import android.util.TypedValue;

public class Utils {

    private Utils() {
    }

    /**
     * dp to px
     */
    public static int dp2px(Context context, float dp) {
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources()
                .getDisplayMetrics());
        return Math.round(px);
    }
}
