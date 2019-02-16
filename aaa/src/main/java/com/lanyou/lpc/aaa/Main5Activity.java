package com.lanyou.lpc.aaa;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        LinearLayout llFirst = findViewById(R.id.ll_first);

        LinearLayout child1 = (LinearLayout) llFirst.getChildAt(0);
        child1.setId(R.id.control_air_item);

        LinearLayout child2 = (LinearLayout) llFirst.getChildAt(2);
        child2.setId(R.id.control_light);

    final LinearLayout airItem =    findViewById(R.id.control_air_item);
     airItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main5Activity.this, "0000000", Toast.LENGTH_SHORT).show();
                ImageView imageView = (ImageView) airItem.getChildAt(0);
                imageView.setImageResource(R.mipmap.ic_launcher);

                TextView textView = (TextView) airItem.getChildAt(1);
                textView.setText("6666666");


            }
        });

        findViewById(R.id.control_light).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main5Activity.this, "111111111111", Toast.LENGTH_SHORT).show();
            }
        });
    }

    class SpaceItemDecoration extends RecyclerView.ItemDecoration {
        int mSpace;

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State
                state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.left = mSpace;
            outRect.right = mSpace;
            outRect.bottom = mSpace;
            if (parent.getChildAdapterPosition(view) == 0) {
                outRect.top = mSpace;
            }
        }

        public SpaceItemDecoration(int space) {
            this.mSpace = space;
        }
    }
}
