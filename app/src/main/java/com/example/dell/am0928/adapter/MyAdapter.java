package com.example.dell.am0928.adapter;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dell.am0928.R;
import com.example.dell.am0928.bean.User;
import com.example.dell.am0928.bean.news;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.OneHolder>{
    private Context context;
    private List<User> list;
    public MyAdapter(Context context, List<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public OneHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, null);
        OneHolder holder = new OneHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull OneHolder holder, int position) {
        holder.text_name.setText(list.get(position).getGoods_name());
        holder.text_price.setText(list.get(position).getShop_price());

        Uri uri = Uri.parse(list.get(position).getThumb());
        holder.simp.setImageURI(uri);
        

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class OneHolder extends RecyclerView.ViewHolder{

        private final TextView text_name;
        private final TextView text_price;
        private final SimpleDraweeView simp;

        public OneHolder(View itemView) {
            super(itemView);
            text_name = itemView.findViewById(R.id.text_name);
            text_price = itemView.findViewById(R.id.text_price);
            simp = itemView.findViewById(R.id.simp);
        }
    }
}
