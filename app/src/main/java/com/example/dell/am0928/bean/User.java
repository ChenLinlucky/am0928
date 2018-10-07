package com.example.dell.am0928.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class User {
    @Id(autoincrement = true)
    Long id;
    @Property
    String goods_name;
    @Property
    String shop_price;
    @Property
    String thumb;
    @Generated(hash = 2019766772)
    public User(Long id, String goods_name, String shop_price, String thumb) {
        this.id = id;
        this.goods_name = goods_name;
        this.shop_price = shop_price;
        this.thumb = thumb;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getGoods_name() {
        return this.goods_name;
    }
    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }
    public String getShop_price() {
        return this.shop_price;
    }
    public void setShop_price(String shop_price) {
        this.shop_price = shop_price;
    }
    public String getThumb() {
        return this.thumb;
    }
    public void setThumb(String thumb) {
        this.thumb = thumb;
    }
}
