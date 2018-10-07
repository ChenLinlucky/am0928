package com.example.dell.am0928.di;

import com.example.dell.am0928.bean.User;

import java.lang.ref.WeakReference;
import java.util.List;

public class Presenterimp implements Icontract.ipresenter<Icontract.iview>{
    private Icontract.iview iview;
    private Moudleimp moudleimp;
    private WeakReference<Icontract.iview> iviewWeakReference;
    private WeakReference<Icontract.imoudle> imoudleWeakReference;

    @Override
    public void attchview(Icontract.iview iview) {
        this.iview=iview;
        moudleimp = new Moudleimp();
        iviewWeakReference = new WeakReference<>(iview);
        imoudleWeakReference = new WeakReference<Icontract.imoudle>(moudleimp);

    }

    @Override
    public void datachview(Icontract.iview iview) {
        iviewWeakReference.clear();
        imoudleWeakReference.clear();

    }

    @Override
    public void requestinfo() {
        moudleimp.requestdata(new Icontract.imoudle.callisten() {

            @Override
            public void requestinfo(List<User> users) {
                iview.data(users);
            }

            @Override
            public void requestinfo1(String s1) {

            }

            @Override
            public void requestinfo_shop(String s_shop) {

            }
        });
    }

    @Override
    public void requestinfo1() {
        moudleimp.requestdata1(new Icontract.imoudle.callisten() {

            @Override
            public void requestinfo(List<User> users) {

            }

            @Override
            public void requestinfo1(String s1) {
                iview.data1(s1);
            }

            @Override
            public void requestinfo_shop(String s_shop) {

            }
        });
    }

    @Override
    public void requestinfo_shop() {
        moudleimp.requestdata_shop(new Icontract.imoudle.callisten() {

            @Override
            public void requestinfo(List<User> users) {

            }

            @Override
            public void requestinfo1(String s1) {

            }

            @Override
            public void requestinfo_shop(String s_shop) {
                iview.data_shop(s_shop);
            }
        });
    }


}
