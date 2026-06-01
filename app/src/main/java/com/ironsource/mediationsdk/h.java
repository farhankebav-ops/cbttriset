package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f9181c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f9182d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, ArrayList<a>> f9183a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f9184b;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum a {
        ISAuctionPerformanceDidntAttemptToLoad,
        ISAuctionPerformanceFailedToLoad,
        ISAuctionPerformanceLoadedSuccessfully,
        ISAuctionPerformanceFailedToShow,
        ISAuctionPerformanceShowedSuccessfully,
        ISAuctionPerformanceNotPartOfWaterfall
    }

    public h(List<NetworkSettings> list, int i2) {
        this.f9184b = i2;
        for (NetworkSettings networkSettings : list) {
            this.f9183a.put(networkSettings.getProviderName(), new ArrayList<>());
        }
    }

    public void a(ConcurrentHashMap<String, a> concurrentHashMap) {
        if (this.f9184b == 0) {
            return;
        }
        for (String str : this.f9183a.keySet()) {
            a aVar = a.ISAuctionPerformanceNotPartOfWaterfall;
            if (concurrentHashMap.containsKey(str)) {
                aVar = concurrentHashMap.get(str);
            }
            ArrayList<a> arrayList = this.f9183a.get(str);
            if (this.f9184b != -1 && arrayList.size() == this.f9184b) {
                arrayList.remove(0);
            }
            arrayList.add(aVar);
        }
    }

    public String a(String str) {
        ArrayList<a> arrayList = this.f9183a.get(str);
        String string = "";
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<a> it = arrayList.iterator();
            string = "" + it.next().ordinal();
            while (it.hasNext()) {
                StringBuilder sbR = androidx.camera.core.processing.util.a.r(a1.a.C(string, ","));
                sbR.append(it.next().ordinal());
                string = sbR.toString();
            }
        }
        return string;
    }
}
