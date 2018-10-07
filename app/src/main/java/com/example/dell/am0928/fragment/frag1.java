package com.example.dell.am0928.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.am0928.R;
import com.example.dell.am0928.adapter.MyAdapter;
import com.example.dell.am0928.bean.User;
import com.example.dell.am0928.di.Icontract;
import com.example.dell.am0928.di.Presenterimp;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class frag1 extends Fragment implements Icontract.iview {

    @BindView(R.id.recy_view)
    RecyclerView recyView;
    Unbinder unbinder;
    @BindView(R.id.smart)
    SmartRefreshLayout smart;
    private Presenterimp presenterimp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag1, container, false);
        presenterimp = new Presenterimp();
        presenterimp.attchview(this);
        presenterimp.requestinfo();
        unbinder = ButterKnife.bind(this, view);

        smart.setOnLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
            }
        });
        //设置 Header 为 贝塞尔雷达 样式
        smart.setRefreshHeader(new BezierRadarHeader(getActivity()).setEnableHorizontalDrag(true));
//设置 Footer 为 球脉冲 样式
        smart.setRefreshFooter(new BallPulseFooter(getActivity()).setSpinnerStyle(SpinnerStyle.Scale));

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenterimp.datachview(this);
    }

    @Override
    public void data(final List<User> users) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {

                GridLayoutManager manager = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);
                recyView.setLayoutManager(manager);
                MyAdapter adapter = new MyAdapter(getActivity(),users);
                recyView.setAdapter(adapter);
            }
        });
    }

    @Override
    public void data1(String s1) {

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
