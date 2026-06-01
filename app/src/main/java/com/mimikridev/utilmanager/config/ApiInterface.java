package com.mimikridev.utilmanager.config;

import com.ironsource.C2300e4;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface ApiInterface {
    public static final String AGENT = "Data-Agent: UtilManager";
    public static final String CACHE = "Cache-Control: max-age=0";

    @Headers({CACHE, AGENT})
    @GET("utama/get_config")
    Call<CallbackConfig> getConfig(@Query("api_key") String str, @Query(C2300e4.h.V) String str2, @Query("apk_version") int i2);
}
