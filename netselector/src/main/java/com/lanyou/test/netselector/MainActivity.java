package com.lanyou.test.netselector;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private String normalUrl;
    private String checkedUrl;
    private RadioButton first;
    private RadioButton second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        new DrawableUtils().setSelectDrawable(this, checkedUrl, normalUrl, first);
        new DrawableUtils().setSelectDrawable(this, checkedUrl, normalUrl, second);
    }

    private void initData() {
        first = findViewById(R.id.first);
        second = findViewById(R.id.second);
        normalUrl = "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3298597340," +
                "1396845332&fm=200&gp=0.jpg";
        checkedUrl = "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1643843887," +
                "3215689086&fm=26&gp=0.jpg";
    }
}
