package com.mimikridev.utilmanager.config;

import java.util.concurrent.TimeUnit;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class RestAdapter {
    public static ApiInterface createAPI(String str) {
        new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder.connectTimeout(10L, timeUnit);
        builder.writeTimeout(10L, timeUnit);
        builder.readTimeout(30L, timeUnit);
        builder.cache(null);
        builder.dns(Dns.SYSTEM);
        return (ApiInterface) new Retrofit.Builder().baseUrl(str).addConverterFactory(GsonConverterFactory.create()).client(builder.build()).build().create(ApiInterface.class);
    }
}
