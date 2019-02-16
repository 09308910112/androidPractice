package com.lanyou.lpc.aaa.recyclergrikd;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lanyou.lpc.aaa.Icon;
import com.lanyou.lpc.aaa.R;

import java.util.ArrayList;

/**
 * Created by Giousa on 2016/3/23.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ListHolder> {

    private Context mContext;

    public MyRecyclerAdapter(Context context) {
        this.mContext = context;
        initData();
    }

    ArrayList<Icon> mData;
    int realLength;
    private void initData() {
        mData = new ArrayList<Icon>();
        mData.add(new Icon(R.drawable.iv_icon_1, "1号"));
        mData.add(new Icon(R.drawable.iv_icon_2, "图标2"));
        mData.add(new Icon(R.drawable.iv_icon_3, "图标3"));
        mData.add(new Icon(R.drawable.iv_icon_4, "4号"));
        mData.add(new Icon(R.drawable.iv_icon_5, "图标5"));
        mData.add(new Icon(R.drawable.iv_icon_6, "图标6"));
        mData.add(new Icon(R.drawable.iv_icon_7, "7号"));
         realLength = mData.size();
        if (mData.size() % 3 != 0) {
            int spaceNum = mData.size() % 3;
            for (int i = 0; i < 3 - spaceNum; i++) {
                mData.add(new Icon(0, ""));
            }
        }
    }


    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_grid_icon, null);
        return new ListHolder(view);
    }


    @Override
    public void onBindViewHolder(ListHolder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int position = (int) v.getTag();
            if (realLength <= position) {
                return;
            }
            Toast.makeText(mContext, "位置:" + position, Toast.LENGTH_SHORT).show();
        }
    };


    class ListHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView tv;

        public ListHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(onClickListener);
            icon = itemView.findViewById(R.id.img_icon);
            tv = itemView.findViewById(R.id.txt_icon);
        }

        public void setData(int position) {
            itemView.setTag(position);
            icon.setImageResource(mData.get(position).getiId());
            tv.setText(mData.get(position).getiName());
        }
    }
}
