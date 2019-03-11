package com.lanyou.test.viewpagerdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this, MainActivity.class));
            }
        });


        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("userId", "abc");
            jsonObject.put("sign", "111");
            jsonObject.put("timestamp", "222");
            jsonObject.put("appCode", "3333");
            jsonObject.put("projectType", "444");
            Log.e("lpc999",jsonObject.toString());
            TextView textView = findViewById(R.id.tv);
            textView.setText(jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
