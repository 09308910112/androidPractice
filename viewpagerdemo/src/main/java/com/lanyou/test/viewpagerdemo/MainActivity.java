package com.lanyou.test.viewpagerdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private Button btnChange;
    private ViewPager viewPager;
    /**
     * key :index
     * value : LinearLayout
     */
    HashMap<Integer, LinearLayout> itemHashMap = new HashMap<>();
    private PagerAdapter adapter;
    private Button btnRemove;
    private TextView tvShow;
    private LinearLayout ll_gray_point;
    private View redPoint;
    private Button testSingleTaskBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.e("lpc666", "onCreate()");
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initListener();


        //实例化SharedPreferences对象,参数1是存储文件的名称，参数2是文件的打开方式，当文件不存在时，直接创建，如果存在，则直接使用
        SharedPreferences mySharePreferences = getSharedPreferences("test666", AppCompatActivity.MODE_PRIVATE);

        //实例化SharedPreferences.Editor对象
        SharedPreferences.Editor editor = mySharePreferences.edit();

        //用putString的方法保存数据
        editor.putString("3333", "tinyphp");

        //提交数据
        editor.commit();
    }

    int index = 0;
    ArrayList<CarControlMenuBean> dataList = CarControlMenuBean.getControlMenuDataList();

    private void initListener() {

        testSingleTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "添加了一个", Toast.LENGTH_SHORT).show();
                CarControlMenuBean bean = new CarControlMenuBean();
                String name = "条目" + (index++);
                Log.e("lpc777", "添加了：" + name);
                bean.setDisplayItemName(name);
                bean.setDisplayItemCode(name);
                dataList.add(bean);
                show();
                initDefaultViewPagerData();
                initViewPageer();
                viewPager.setAdapter(adapter);
                initDotView();

            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dataList.size() == 0) {
                    Toast.makeText(MainActivity.this, "stack is empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(MainActivity.this, "删除一个了", Toast.LENGTH_SHORT).show();
                dataList.remove(dataList.get(0));
                show();
                initDefaultViewPagerData();
                initViewPageer();
                viewPager.setAdapter(adapter);
                initDotView();
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                Log.e("lpc777", "i = :" + i + ",v:" + v + ",il:" + i1);

                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) redPoint.getLayoutParams();
                View firstChildView = ll_gray_point.getChildAt(0);
                View secondChildView = ll_gray_point.getChildAt(1);
                int viewMargin = secondChildView.getLeft() - firstChildView.getLeft();

                float scrollDistance = viewMargin * i + viewMargin * v;

                layoutParams.leftMargin = (int) scrollDistance;
                Log.e("lpc777", "margin:" + layoutParams.leftMargin);
                redPoint.setLayoutParams(layoutParams);
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void show() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dataList.size(); i++) {
            String name = dataList.get(i).getDisplayItemName();
            sb.append(name).append("\n");
        }
        tvShow.setText(sb.toString());
    }


    private void initData() {
        CarControlMenuBean bean = new CarControlMenuBean();
        String name = "NB";
        bean.setDisplayItemName(name);
        bean.setDisplayItemCode(name);
        dataList.add(bean);

        initDefaultViewPagerData();
        initViewPageer();
        viewPager.setAdapter(adapter);
        initDotView();
    }

    private void initDefaultViewPagerData() {
        LayoutInflater li = getLayoutInflater();
        int pageCount = getPageCount();
        Log.e("lpc777", "pageCount:" + pageCount);
        for (int i = 0; i < pageCount; i++) {
            final LinearLayout llItemView = (LinearLayout) li.inflate(R.layout.pager_item, null, false);
            CarControlMenuBean bean = dataList.get(i);
            llItemView.setTag(dataList.get(i).getDisplayItemName());
            TextView tv = llItemView.findViewById(R.id.tv);
            tv.setText(dataList.get(i).getDisplayItemName());
            itemHashMap.put(i, llItemView);
            llItemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, llItemView.getTag() + "", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public int getPageCount() {
        return dataList.size();
    }

    private void initViewPageer() {

        adapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return getPageCount();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                final LinearLayout pagerView = itemHashMap.get(position);
                container.addView(pagerView);
                return pagerView;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView((View) object);
            }

         /*   @Override
            public int getItemPosition(@NonNull Object object) {
                return POSITION_NONE;
            }*/
        };
    }

    private void initView() {
        viewPager = findViewById(R.id.viewpager);
        btnChange = findViewById(R.id.btn_change);
        btnRemove = findViewById(R.id.btn_remove);
        tvShow = findViewById(R.id.tv_show);
        testSingleTaskBtn = findViewById(R.id.testSingleTask);
        ll_gray_point = findViewById(R.id.ll_gray_point);
        redPoint = findViewById(R.id.red_point);
    }

    private void initDotView() {
        ll_gray_point.removeAllViews();
        for (int i = 0; i < dataList.size(); i++) {
            TextView tv = new TextView(this);
            tv.setBackgroundResource(R.drawable.ic_dot_shape);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(60, 20);
            layoutParams.rightMargin = 20;
            ll_gray_point.addView(tv, layoutParams);
        }
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("lpc666", "onRestart");

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e("lpc666", "onNewIntent");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("lpc666", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("lpc666", "onPause");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("lpc666", "onStart");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("lpc666", "onDestroy");

    }
}