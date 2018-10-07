package com.example.dell.am0928.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.example.dell.am0928.R;
import com.example.dell.am0928.adapter.OutAdapter_shop;
import com.example.dell.am0928.bean.User;
import com.example.dell.am0928.bean.news_shop;
import com.example.dell.am0928.di.Icontract;
import com.example.dell.am0928.di.Presenterimp;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class frag3 extends Fragment implements Icontract.iview {

    @BindView(R.id.recyView01)
    RecyclerView recyView01;
    Unbinder unbinder;
    @BindView(R.id.cb_01)
    CheckBox cb01;
    private Presenterimp presenterimp;
    private OutAdapter_shop outAdapter_shop;
    private List<news_shop.DataBean> data;
    private com.example.dell.am0928.bean.news_shop news_shop;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag3, container, false);
        presenterimp = new Presenterimp();
        presenterimp.attchview(this);
        presenterimp.requestinfo_shop();
        unbinder = ButterKnife.bind(this, view);
        cb01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cb01.isChecked()){
                    for (int i = 0; i < news_shop.getData().size(); i++) {
                        news_shop.getData().get(i).setOutChecked(true);
                        for (int j = 0; j < news_shop.getData().get(i).getList().size(); j++) {
                            news_shop.getData().get(i).getList().get(j).setInnerchecked(true);
                        }
                    }
                }else{
                    for (int i = 0; i < news_shop.getData().size(); i++) {
                        news_shop.getData().get(i).setOutChecked(false);
                        for (int j = 0; j < news_shop.getData().get(i).getList().size(); j++) {
                            news_shop.getData().get(i).getList().get(j).setInnerchecked(false);
                        }
                    }
                }
                outAdapter_shop.notifyDataSetChanged();
            }
        });
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenterimp.datachview(this);
    }

    @Override
    public void data(List<User> s) {

    }

    @Override
    public void data1(String s1) {

    }

    @Override
    public void data_shop(final String s_shop) {
        getActivity().runOnUiThread(new Runnable() {




            @Override
            public void run() {
                //  Toast.makeText(getActivity(), s_shop, Toast.LENGTH_SHORT).show();
                Gson gson = new Gson();
                news_shop = gson.fromJson(s_shop, news_shop.class);
                data = news_shop.getData();
                LinearLayoutManager manager = new LinearLayoutManager(getActivity());
                recyView01.setLayoutManager(manager);
                outAdapter_shop = new OutAdapter_shop(getActivity(), data);
                recyView01.setAdapter(outAdapter_shop);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
