package com.example.dell.am0928.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.dell.am0928.R;
import com.example.dell.am0928.bean.news_shop;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class InnerAdapter_shop extends RecyclerView.Adapter<InnerAdapter_shop.TwoHolder>{
    private Context context;
    private List<news_shop.DataBean.ListBean> list;
    public InnerAdapter_shop(Context context, List<news_shop.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TwoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.include2, null);
        TwoHolder holder = new TwoHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TwoHolder holder, int position) {
        holder.shop_name.setText("商品名称为:"+list.get(position).getTitle());
        holder.shop_price.setText("商品单价为:"+list.get(position).getBargainPrice()+"");
        String images = list.get(position).getImages();
        String[] strings = images.split("\\|");
        Uri uri = Uri.parse(strings[0]);
        holder.simp01.setImageURI(uri);
        holder.cb_03.setChecked(list.get(position).isInnerchecked());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class TwoHolder extends RecyclerView.ViewHolder{

        private final CheckBox cb_03;
        private final TextView shop_name;
        private final TextView shop_price;
        private final SimpleDraweeView simp01;

        public TwoHolder(View itemView) {
            super(itemView);
            cb_03 = itemView.findViewById(R.id.cb_03);
            shop_name = itemView.findViewById(R.id.shop_name);
            shop_price = itemView.findViewById(R.id.shop_price);
            simp01 = itemView.findViewById(R.id.simp01);

        }
    }
}
