package com.lanyou.lpc.aaa;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextInputLayout layoutName;
    private TextInputEditText etName;
    private TextInputLayout layoutPwd;
    private TextInputEditText etPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        initData();
    }

    private void initData() {









        etName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                   // if(etName.getText().toString().equals("")){
                    if(layoutName.getEditText().getText().toString().equals("")){
                        layoutName.setError("请输入名称");
                    }else{
                        layoutName.setErrorEnabled(false);
                    }
                }
            }
        });
    }

    private void initView() {
        layoutName = findViewById(R.id.layout_name);
        etName = findViewById(R.id.et_name);

        layoutPwd = findViewById(R.id.layout_pwd);
        etPwd = findViewById(R.id.et_pwd);
    }
}
