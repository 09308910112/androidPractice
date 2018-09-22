package quietuncle.eventbus30demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Copyright (c) 2017. 深圳联友科技. All rights reserved
 * Created by lpc on 2018/2/10.
 */

public class NewActivity extends AppCompatActivity {

    private EditText etContent;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        etContent = findViewById(R.id.et_content);
        btnOk = findViewById(R.id.btn_ok);
        initListener();
    }

    private void initListener() {
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String age = etContent.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("age", age);
                setResult(100, intent);
                finish();
            }
        });
    }
}
