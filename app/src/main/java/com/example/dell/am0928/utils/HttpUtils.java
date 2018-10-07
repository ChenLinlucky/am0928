package com.example.dell.am0928.utils;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpUtils {

    private static HttpUtils httpUtils;
    private final OkHttpClient okHttpClient;

    public HttpUtils(){
        okHttpClient = new OkHttpClient();
    }
    public static HttpUtils getinstan(){
        if(httpUtils==null){
            httpUtils = new HttpUtils();
        }
    return httpUtils;
    }
    public void getdata(String path, Callback callback){
        Request request = new Request.Builder().url(path).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }

}
