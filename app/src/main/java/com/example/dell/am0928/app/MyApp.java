package com.example.dell.am0928.app;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.dell.am0928.bean.DaoMaster;
import com.example.dell.am0928.bean.DaoSession;
import com.facebook.drawee.backends.pipeline.Fresco;


public class MyApp extends Application{

    private static MyApp app;
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        app = MyApp.this;
        //创建数据库
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "database");
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster master = new DaoMaster(db);
        daoSession = master.newSession();
    }
    public static MyApp getinstance(){
        if(app == null){
            app = new MyApp();
        }
        return app;
    }
    public DaoSession daoSession(){
        return daoSession;
    }
}
