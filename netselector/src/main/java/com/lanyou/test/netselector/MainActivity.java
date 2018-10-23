package com.lanyou.test.netselector;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView btn1;
    private TextView btn2;
    private TextView btn3;
    private TextView btn4;
    private String normalUrl;
    private String checkedUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        new DrawableUtils().setSelectDrawable(this, checkedUrl, normalUrl, btn1);
        new DrawableUtils().setSelectDrawable(this, checkedUrl, normalUrl, btn2);
        new DrawableUtils().setSelectDrawable(this, checkedUrl, normalUrl, btn3);
        new DrawableUtils().setSelectDrawable(this, checkedUrl, normalUrl, btn4);
    }

    private void initData() {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        normalUrl = "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3298597340," +
                "1396845332&fm=200&gp=0.jpg";
        checkedUrl = "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1643843887," +
                "3215689086&fm=26&gp=0.jpg";
    }
}
