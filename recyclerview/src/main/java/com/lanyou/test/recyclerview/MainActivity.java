package com.lanyou.test.recyclerview;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<RecyclerDataBean> dataList = new ArrayList<>();
    private TextView btnChange;
    private RVAdaper adaper;

    //选中的位置
    private int posSelected = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        initListener();
    }

    private void initListener() {
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataList.clear();
                for (int i = 0; i < 6; i++) {
                    RecyclerDataBean bean = new RecyclerDataBean();
                    bean.setMsg("新item：" + i);
                    dataList.add(bean);
                }
                adaper.setRecyclerDataBean(dataList);
            }
        });
    }


    private void initData() {
        for (int i = 0; i < 60; i++) {
            RecyclerDataBean bean = new RecyclerDataBean();
            bean.setMsg("这个条目：" + i);
            dataList.add(bean);
        }
    }

    private void initView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        btnChange = findViewById(R.id.btn_change);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        adaper = new RVAdaper(this, dataList);
        recyclerView.setAdapter(adaper);
    }

    public class RVAdaper extends RecyclerView.Adapter<RVViewHolder> {

        Context context;
        ArrayList<RecyclerDataBean> dataBeanList;

        private RVAdaper() {

        }

        private RVAdaper(Context context, ArrayList<RecyclerDataBean> dataBeanList) {
            this.context = context;
            this.dataBeanList = dataBeanList;
        }

        public void setRecyclerDataBean(ArrayList<RecyclerDataBean> dataBeanList){
            this.dataBeanList = dataBeanList;
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public RVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View viewItem = LayoutInflater.from(getApplicationContext()).inflate(R.layout.layout_recyclerview_item,
                    parent, false);
            return new RVViewHolder(viewItem);
        }

        @Override
        public void onBindViewHolder(@NonNull RVViewHolder holder, final int position) {
            holder.tvMsg.setText(dataBeanList.get(position).getMsg());
            if(posSelected == position){
                holder.tvMsg.setTextColor(Color.RED);
            }else{
                holder.tvMsg.setTextColor(Color.WHITE);
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(posSelected != position){
                        posSelected = position;
                        notifyDataSetChanged();
                    }
                    Toast.makeText(MainActivity.this, "POS:" + position, Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }
    }

    private class RVViewHolder extends RecyclerView.ViewHolder {
        TextView tvMsg;
        public RVViewHolder(View itemView) {
            super(itemView);
            tvMsg = itemView.findViewById(R.id.tv_msg);
        }
    }


}
