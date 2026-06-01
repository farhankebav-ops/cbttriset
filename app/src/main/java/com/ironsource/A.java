package com.ironsource;

import com.ironsource.C2494p0;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AbstractC2595v0 f6270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final NetworkSettings f6271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final C2405k2 f6272c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final C2243b1 f6273d;
    private final C2461n2 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f6274f;
    private final H g;
    private final IronSource.a h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final JSONObject f6275i;
    private final String j;
    private final int k;
    private final String l;
    private final C2461n2 m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final String f6276n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final String f6277o;
    private final int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final AdData f6278q;

    public A(AbstractC2595v0 adUnitData, NetworkSettings providerSettings, C2405k2 auctionData, C2243b1 adapterConfig, C2461n2 auctionResponseItem, int i2) {
        kotlin.jvm.internal.k.e(adUnitData, "adUnitData");
        kotlin.jvm.internal.k.e(providerSettings, "providerSettings");
        kotlin.jvm.internal.k.e(auctionData, "auctionData");
        kotlin.jvm.internal.k.e(adapterConfig, "adapterConfig");
        kotlin.jvm.internal.k.e(auctionResponseItem, "auctionResponseItem");
        this.f6270a = adUnitData;
        this.f6271b = providerSettings;
        this.f6272c = auctionData;
        this.f6273d = adapterConfig;
        this.e = auctionResponseItem;
        this.f6274f = i2;
        this.g = new H(C2494p0.a.DidntAttemptToLoad);
        IronSource.a aVarA = adUnitData.b().a();
        this.h = aVarA;
        this.f6275i = auctionData.h();
        this.j = auctionData.g();
        this.k = auctionData.i();
        this.l = auctionData.f();
        this.m = auctionData.j();
        String strF = adapterConfig.f();
        kotlin.jvm.internal.k.d(strF, "adapterConfig.providerName");
        this.f6276n = strF;
        this.f6277o = String.format("%s %s", Arrays.copyOf(new Object[]{strF, Integer.valueOf(hashCode())}, 2));
        this.p = adapterConfig.d();
        String strK = auctionResponseItem.k();
        Map<String, Object> mapA = C2395ja.a(auctionResponseItem.a());
        kotlin.jvm.internal.k.d(mapA, "jsonObjectToMap(auctionResponseItem.adData)");
        mapA.put("adUnit", aVarA);
        HashMap map = new HashMap();
        Map<String, Object> mapA2 = C2395ja.a(adapterConfig.c());
        kotlin.jvm.internal.k.d(mapA2, "jsonObjectToMap(adapterConfig.adUnitSettings)");
        map.putAll(mapA2);
        mapA.put("userId", adUnitData.r());
        mapA.put("adUnitId", adUnitData.b().c());
        mapA.put("isMultipleAdUnits", Boolean.TRUE);
        this.f6278q = new AdData(strK, map, mapA);
    }

    public final AbstractC2595v0 a() {
        return this.f6270a;
    }

    public final NetworkSettings b() {
        return this.f6271b;
    }

    public final C2405k2 c() {
        return this.f6272c;
    }

    public final C2243b1 d() {
        return this.f6273d;
    }

    public final C2461n2 e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof A)) {
            return false;
        }
        A a8 = (A) obj;
        return kotlin.jvm.internal.k.a(this.f6270a, a8.f6270a) && kotlin.jvm.internal.k.a(this.f6271b, a8.f6271b) && kotlin.jvm.internal.k.a(this.f6272c, a8.f6272c) && kotlin.jvm.internal.k.a(this.f6273d, a8.f6273d) && kotlin.jvm.internal.k.a(this.e, a8.e) && this.f6274f == a8.f6274f;
    }

    public final int f() {
        return this.f6274f;
    }

    public final AdData g() {
        return this.f6278q;
    }

    public final IronSource.a h() {
        return this.h;
    }

    public int hashCode() {
        return ((this.e.hashCode() + ((this.f6273d.hashCode() + ((this.f6272c.hashCode() + ((this.f6271b.hashCode() + (this.f6270a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31) + this.f6274f;
    }

    public final AbstractC2595v0 i() {
        return this.f6270a;
    }

    public final C2243b1 j() {
        return this.f6273d;
    }

    public final C2405k2 k() {
        return this.f6272c;
    }

    public final String l() {
        return this.l;
    }

    public final String m() {
        return this.j;
    }

    public final C2461n2 n() {
        return this.e;
    }

    public final int o() {
        return this.k;
    }

    public final C2461n2 p() {
        return this.m;
    }

    public final JSONObject q() {
        return this.f6275i;
    }

    public final String r() {
        return this.f6276n;
    }

    public final int s() {
        return this.p;
    }

    public final H t() {
        return this.g;
    }

    public String toString() {
        return "AdInstanceData(adUnitData=" + this.f6270a + ", providerSettings=" + this.f6271b + ", auctionData=" + this.f6272c + ", adapterConfig=" + this.f6273d + ", auctionResponseItem=" + this.e + ", sessionDepth=" + this.f6274f + ")";
    }

    public final NetworkSettings u() {
        return this.f6271b;
    }

    public final int v() {
        return this.f6274f;
    }

    public final String w() {
        return this.f6277o;
    }

    public final A a(AbstractC2595v0 adUnitData, NetworkSettings providerSettings, C2405k2 auctionData, C2243b1 adapterConfig, C2461n2 auctionResponseItem, int i2) {
        kotlin.jvm.internal.k.e(adUnitData, "adUnitData");
        kotlin.jvm.internal.k.e(providerSettings, "providerSettings");
        kotlin.jvm.internal.k.e(auctionData, "auctionData");
        kotlin.jvm.internal.k.e(adapterConfig, "adapterConfig");
        kotlin.jvm.internal.k.e(auctionResponseItem, "auctionResponseItem");
        return new A(adUnitData, providerSettings, auctionData, adapterConfig, auctionResponseItem, i2);
    }

    public static /* synthetic */ A a(A a8, AbstractC2595v0 abstractC2595v0, NetworkSettings networkSettings, C2405k2 c2405k2, C2243b1 c2243b1, C2461n2 c2461n2, int i2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            abstractC2595v0 = a8.f6270a;
        }
        if ((i8 & 2) != 0) {
            networkSettings = a8.f6271b;
        }
        if ((i8 & 4) != 0) {
            c2405k2 = a8.f6272c;
        }
        if ((i8 & 8) != 0) {
            c2243b1 = a8.f6273d;
        }
        if ((i8 & 16) != 0) {
            c2461n2 = a8.e;
        }
        if ((i8 & 32) != 0) {
            i2 = a8.f6274f;
        }
        C2461n2 c2461n22 = c2461n2;
        int i9 = i2;
        return a8.a(abstractC2595v0, networkSettings, c2405k2, c2243b1, c2461n22, i9);
    }

    public final void a(C2494p0.a performance) {
        kotlin.jvm.internal.k.e(performance, "performance");
        this.g.b(performance);
    }
}
