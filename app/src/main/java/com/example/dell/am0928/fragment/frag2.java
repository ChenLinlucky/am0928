package com.example.dell.am0928.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.am0928.R;
import com.example.dell.am0928.bean.User;
import com.example.dell.am0928.bean.news1;
import com.example.dell.am0928.di.Icontract;
import com.example.dell.am0928.di.Presenterimp;
import com.google.gson.Gson;
import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class frag2 extends Fragment implements Icontract.iview {

    @BindView(R.id.fly)
    FlyBanner fly;
    Unbinder unbinder;
    private Presenterimp presenterimp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag2, container, false);
        presenterimp = new Presenterimp();
        presenterimp.attchview(this);
        presenterimp.requestinfo1();
        unbinder = ButterKnife.bind(this, view);
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
    public void data1(final String s1) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Gson gson = new Gson();
                news1 news1 = gson.fromJson(s1, news1.class);
                List<com.example.dell.am0928.bean.news1.DataBean> data = news1.getData();
                ArrayList<String> list = new ArrayList<>();
              //  Toast.makeText(getActivity(), "data:" + data, Toast.LENGTH_SHORT).show()
                for (int i = 0; i < data.size(); i++) {
                    String icon = data.get(i).getIcon();
                    list.add(data.get(i).getIcon());
                }
                fly.setImagesUrl(list);
            }
        });
    }

    @Override
    public void data_shop(String s_shop) {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
