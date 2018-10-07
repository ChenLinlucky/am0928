package com.example.dell.am0928.di;

import com.example.dell.am0928.app.MyApp;
import com.example.dell.am0928.bean.User;
import com.example.dell.am0928.bean.UserDao;
import com.example.dell.am0928.bean.news;
import com.example.dell.am0928.utils.HttpUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

public class Moudleimp implements Icontract.imoudle{
    private String path="http://atp.fulishe.com/ClientApi/category.php?api_version=1.0&act=search_category_goods_list&c_id=35&order_price=0&page_num=20&page=1&debug=true&client_id=null";
    private String path1="https://www.zhaoapi.cn/ad/getAd";
    private String path_shop="https://www.zhaoapi.cn/product/getCarts?uid=71";
    private List<User> users;

    @Override
    public void requestdata(final callisten callisten) {
        final UserDao userDao = MyApp.getinstance().daoSession().getUserDao();
        users = userDao.loadAll();
        if (users.size()>0){
            callisten.requestinfo(users);
            return;
        }
        HttpUtils.getinstan().getdata(path, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
                Gson gson = new Gson();
                news news = gson.fromJson(s, news.class);
                List<com.example.dell.am0928.bean.news.InfoBean.GoodsBean> goods = news.getInfo().getGoods();
                ArrayList<User> list = new ArrayList<>();
                for (int i = 0; i < goods.size(); i++) {
                    String goods_name = goods.get(i).getGoods_name();
                    String shop_price = goods.get(i).getShop_price();
                    String thumb = goods.get(i).getThumb();
                    User user = new User();
                    user.setGoods_name(goods_name);
                    user.setShop_price(shop_price);
                    user.setThumb(thumb);
                    list.add(user);
                }
                callisten.requestinfo(list);
                userDao.insertInTx(list);
            }
        });
    }



    @Override
    public void requestdata1(final callisten callisten) {
        HttpUtils.getinstan().getdata(path1, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s1 = response.body().string();
                callisten.requestinfo1(s1);
            }
        });
    }

    @Override
    public void requestdata_shop(final callisten callisten) {

        HttpUtils.getinstan().getdata(path_shop, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s_shop = response.body().string();
                callisten.requestinfo_shop(s_shop);
            }
        });
    }
}
