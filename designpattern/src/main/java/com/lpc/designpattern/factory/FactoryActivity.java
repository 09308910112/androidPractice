package com.lpc.designpattern.factory;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.lpc.designpattern.R;

public class FactoryActivity extends AppCompatActivity {

    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factory);
        tvResult = findViewById(R.id.tv_result);
        ShapeFactory sp = new ShapeFactory();
        Shape shapeCircle = sp.createShape(ShapeFactory.TYPE_CIRCLE);
        Shape shapeRectange = sp.createShape(ShapeFactory.TYPE_RECTANGE);
        String rectange = shapeRectange.draw();
        String circle = shapeCircle.draw();
        tvResult.setText(rectange + "\n" + circle);

    }
}
