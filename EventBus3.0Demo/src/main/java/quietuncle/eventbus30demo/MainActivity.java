package quietuncle.eventbus30demo;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Outline;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnAge;
    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @SuppressLint("NewApi")
    private void init() {
 /*       Button btn = findViewById(R.id.btn);
        btnAge = findViewById(R.id.btn_age);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(MainActivity.this, TestDemo.class));
                Intent intent = new Intent(MainActivity.this, TestDemo.class);
                startActivityForResult(intent, 0);
            }
        });*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            String age = data.getStringExtra("age");
            btnAge.setText(age);
        }
    }
}
