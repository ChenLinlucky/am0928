package com.example.dell.am0928.di;

import com.example.dell.am0928.bean.User;

import java.util.List;

public interface Icontract {
    interface iview{
        void data(List<User> users);
        void data1(String s1);
        void data_shop(String s_shop);
    }
    interface ipresenter<iview>{
        void attchview(iview iview);
        void datachview(iview iview);
        void requestinfo();
        void requestinfo1();
        void requestinfo_shop();
    }
    interface imoudle{
        interface callisten{
            void requestinfo(List<User> users);
            void requestinfo1(String s1);
            void requestinfo_shop(String s_shop);
        }
        void requestdata(callisten callisten);
        void requestdata1(callisten callisten);
        void requestdata_shop(callisten callisten);
    }
}
