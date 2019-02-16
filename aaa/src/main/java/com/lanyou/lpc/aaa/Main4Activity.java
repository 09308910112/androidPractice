package com.lanyou.lpc.aaa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {
   // https://blog.csdn.net/sfshine/article/details/8764858
    private GridView grid_photo;
    private BaseAdapter mAdapter = null;
    private ArrayList<Icon> mData = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        initData();
    }

    private void initData() {
        grid_photo = (GridView) findViewById(R.id.grid_photo);

        mData = new ArrayList<Icon>();
        mData.add(new Icon(R.drawable.iv_icon_1, "图标1"));
        mData.add(new Icon(R.drawable.iv_icon_2, "图标2"));
        mData.add(new Icon(R.drawable.iv_icon_3, "图标3"));
        mData.add(new Icon(R.drawable.iv_icon_4, "图标4"));
        mData.add(new Icon(R.drawable.iv_icon_5, "图标5"));
        mData.add(new Icon(R.drawable.iv_icon_6, "图标6"));
        mData.add(new Icon(R.drawable.iv_icon_7, "图标7"));


        mAdapter = new MyAdapter<Icon>(mData, R.layout.item_grid_icon) {
            @Override
            public void bindView(ViewHolder holder, Icon obj) {
                holder.setImageResource(R.id.img_icon, obj.getiId());
                holder.setText(R.id.txt_icon, obj.getiName());
            }
        };

        grid_photo.setAdapter(mAdapter);

        grid_photo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Main4Activity.this, "你点击了~" + position + "~项", Toast.LENGTH_SHORT).show();
                update();
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    private void update() {
        mData.clear();
        mData.add(new Icon(R.drawable.iv_icon_1, "000"));
        mData.add(new Icon(R.drawable.iv_icon_2, "111"));
        mData.add(new Icon(R.drawable.iv_icon_3, "222"));
        mData.add(new Icon(R.drawable.iv_icon_4, "333"));
        mData.add(new Icon(R.drawable.iv_icon_5, "444"));
        mData.add(new Icon(R.drawable.iv_icon_6, "555"));
        mData.add(new Icon(R.drawable.iv_icon_7, "666"));
    }
}
