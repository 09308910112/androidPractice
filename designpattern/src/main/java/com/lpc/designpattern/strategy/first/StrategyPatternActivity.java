package com.lpc.designpattern.strategy.first;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.lpc.designpattern.R;

public class StrategyPatternActivity extends AppCompatActivity {

    private RadioGroup rgSelect;
    private TextView tvSum;
    private Button btnOk;
    private EditText etMoney;
    private TextView tvCurrentBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strategy_pattern);
        initView();
        initData();
        initListener();
    }

    private void initView() {
        rgSelect = findViewById(R.id.rg_select);
        tvSum = findViewById(R.id.tv_sum);
        btnOk = findViewById(R.id.btn_ok);
        etMoney = findViewById(R.id.et_money);
        tvCurrentBill = findViewById(R.id.tv_current_bill);
    }

    private void initData() {

    }

    double total = 0.0;
    //类型
    int cashType;

    private void initListener() {
        rgSelect.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                cashType = checkedId;
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double money = Double.parseDouble(etMoney.getText().toString());
                double evaluateResult = CashFactory.createCashAccept(cashType).acceptCash(money);
                tvCurrentBill.setText("原价：" + money + ", 折价:" + evaluateResult);
                total += evaluateResult;
                tvSum.setText(String.valueOf(total));
            }
        });
    }
}
