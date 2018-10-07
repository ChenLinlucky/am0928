package com.example.dell.am0928.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.example.dell.am0928.R;
import com.example.dell.am0928.bean.news_shop;

import java.util.List;

public class OutAdapter_shop extends RecyclerView.Adapter<OutAdapter_shop.OneHolder> {
    private Context context;
    private List<news_shop.DataBean> list;
    public OutAdapter_shop(Context context, List<news_shop.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public OneHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.include1, null);
        OneHolder holder = new OneHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull OneHolder holder, int position) {
        holder.cb_02.setChecked(list.get(position).isOutChecked());
        holder.cb_02.setText(list.get(position).getSellerName());

        LinearLayoutManager manager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        holder.recyView02.setLayoutManager(manager);
        InnerAdapter_shop innerAdapter_shop = new InnerAdapter_shop(context, list.get(position).getList());
        holder.recyView02.setAdapter(innerAdapter_shop);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class OneHolder extends RecyclerView.ViewHolder{

        private final CheckBox cb_02;
        private final RecyclerView recyView02;

        public OneHolder(View itemView) {
            super(itemView);
            cb_02 = itemView.findViewById(R.id.cb_02);
            recyView02 = itemView.findViewById(R.id.recyView02);
        }
    }
}
