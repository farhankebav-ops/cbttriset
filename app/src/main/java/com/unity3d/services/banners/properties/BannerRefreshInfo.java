package com.unity3d.services.banners.properties;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class BannerRefreshInfo {
    private static BannerRefreshInfo instance;
    private HashMap<String, Integer> _refreshRateMap = new HashMap<>();

    public static BannerRefreshInfo getInstance() {
        if (instance == null) {
            instance = new BannerRefreshInfo();
        }
        return instance;
    }

    public synchronized Integer getRefreshRate(String str) {
        return this._refreshRateMap.get(str);
    }

    public synchronized void setRefreshRate(String str, Integer num) {
        this._refreshRateMap.put(str, num);
    }
}
