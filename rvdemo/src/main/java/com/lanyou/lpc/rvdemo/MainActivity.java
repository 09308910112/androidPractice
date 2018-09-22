package com.lanyou.lpc.rvdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private RecyclerView rv;
    String[] str = new String[]{"长沙", "长沙", "常德", "常德", "郴州", "郴州",
            "衡阳", "衡阳","怀化", "怀化", "吉首", "吉首","娄底", "娄底","邵阳", "邵阳","湘潭", "湘潭",
            "益阳", "益阳", "岳阳", "岳阳", "永州", "永州", "张家界", "张家界", "株洲", "株洲", "长沙", "常德", "常德", "郴州", "郴州",
            "衡阳", "衡阳","怀化", "怀化", "吉首", "吉首","娄底", "娄底","邵阳", "邵阳","湘潭", "湘潭",
            "益阳", "益阳", "岳阳", "岳阳", "永州", "永州", "张家界", "张家界", "株洲", "株洲"};
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvHint = findViewById(R.id.tv_hint);
        String hint = "实名认证过程中如有异常请拨打实名制中心热线"+"<font color ='#FF0000'>400-665-2200</font>"+"咨询";
        tvHint.setText(Html.fromHtml(hint));
       /* initView();
        initData();
        initListener();*/
    }

    private void initListener() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rv.setVisibility(View.VISIBLE);
            }
        });
    }

    private void initView() {
        btn = findViewById(R.id.btn);
        rv = findViewById(R.id.rv);

    }

    private void initData() {
        StaggeredGridLayoutManager manager =
                new StaggeredGridLayoutManager(5,StaggeredGridLayoutManager.HORIZONTAL);
        rv.setLayoutManager(manager);

        rv.setAdapter(new RVAdapter());
    }

    public class RVAdapter extends RecyclerView.Adapter<MyViewHolder> {

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.rv_item, null);
            MyViewHolder holder = new MyViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
            myViewHolder.tv.setText(str[i]);
        }

        @Override
        public int getItemCount() {
            return str.length;
        }
    }

    private class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv_content);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   String text =  ((TextView)v).getText().toString();
                    Toast.makeText(MainActivity.this,text,Toast.LENGTH_LONG).show();
                }
            });
        }

        public void setData(){

        }


    }
}
