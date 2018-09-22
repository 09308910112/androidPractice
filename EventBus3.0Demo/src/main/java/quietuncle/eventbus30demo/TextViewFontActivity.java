package quietuncle.eventbus30demo;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

/**
 * Copyright (c) 2017. 深圳联友科技. All rights reserved
 * <p>
 * Created by lpc on 2018/1/9-08.
 */

public class TextViewFontActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_text_view_font);
        initView();
        initData();
    }

    private void initData() {
        int startPos = 3;
        int endPos = 7;
        SpannableString text = new SpannableString("今年是2018年");
        text.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, android.R.color.holo_red_light)),
                startPos, endPos, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        text.setSpan(new AbsoluteSizeSpan(30), startPos, endPos, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv.setText(text);
    }

    private void initView() {
        tv = findViewById(R.id.tv);
    }
}
