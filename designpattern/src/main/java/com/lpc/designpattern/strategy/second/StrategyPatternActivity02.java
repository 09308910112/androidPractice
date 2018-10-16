package com.lpc.designpattern.strategy.second;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.lpc.designpattern.R;

public class StrategyPatternActivity02 extends AppCompatActivity {

    private RadioGroup rgSelect;
    private TextView tvSum;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strategy_pattern_02);
        initView();
        initListener();
    }

    private void initView() {
        rgSelect = findViewById(R.id.rg_select);
        tvSum = findViewById(R.id.tv_sum);
        btnOk = findViewById(R.id.btn_ok);
    }


    StrategyOperation operation;

    private void initListener() {
        rgSelect.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_plus:
                        operation = new AdditionStrategy();
                        break;
                    case R.id.rb_sub:
                        operation = new SubstractionOperation();
                        break;
                    case R.id.rb_mul:
                        operation = new MultiplyOperation();
                        break;
                    case R.id.rb_div:
                        operation = new DivisionOperation();
                        break;
                }
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double result = new ContextStrategy(operation).executeStrategy(20, 40);
                tvSum.setText("20#40 =" + result);
            }
        });
    }
}
