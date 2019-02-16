package com.lanyou.lpc.test;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {


    private ViewPager vpager_one;
    private ArrayList<View> aList;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
        initIndicator();
    }

    private void initIndicator() {
        radioGroup = findViewById(R.id.rg_indicator);
         findViewById(R.id.rb1);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb1:
                        break;
                    case R.id.rb2:
                        break;
                }
            }
        });
    }


    private void initView() {
        aList = new ArrayList<>();
        LayoutInflater li = getLayoutInflater();
        aList.add(li.inflate(R.layout.view_one,null,false));
        aList.add(li.inflate(R.layout.view_one,null,false));
        aList.add(li.inflate(R.layout.view_one,null,false));
        ViewPager viewPager = findViewById(R.id.vp);
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return aList.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                LinearLayout layout = (LinearLayout) aList.get(position);
                TextView textView = layout.findViewById(R.id.first);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Main3Activity.this, "first", Toast.LENGTH_SHORT).show();
                    }
                });
                TextView textView1 = layout.findViewById(R.id.second);
                textView1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Main3Activity.this, "second", Toast.LENGTH_SHORT).show();
                    }
                });
                container.addView(aList.get(position));
                return aList.get(position);
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView(aList.get(position));
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position == 0){
                    radioGroup.check(R.id.rb1);
                }else if(position == 1){
                    radioGroup.check(R.id.rb2);
                }else{
                    radioGroup.check(R.id.rb3);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

}
