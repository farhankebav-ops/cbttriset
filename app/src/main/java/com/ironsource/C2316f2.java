package com.ironsource;

import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.ironsource.f2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2316f2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AbstractC2595v0 f8514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, Object> f8515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<String> f8516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final StringBuilder f8517d;

    public C2316f2(AbstractC2595v0 adUnitData) {
        kotlin.jvm.internal.k.e(adUnitData, "adUnitData");
        this.f8514a = adUnitData;
        this.f8515b = new HashMap();
        this.f8516c = new ArrayList();
        this.f8517d = new StringBuilder();
    }

    public final Map<String, Object> a() {
        return this.f8515b;
    }

    public final List<String> b() {
        return this.f8516c;
    }

    public final StringBuilder c() {
        return this.f8517d;
    }

    public final boolean d() {
        return (this.f8515b.isEmpty() && this.f8516c.isEmpty()) ? false : true;
    }

    public final void a(NetworkSettings providerSettings) {
        kotlin.jvm.internal.k.e(providerSettings, "providerSettings");
        List<String> list = this.f8516c;
        String providerInstanceName = providerSettings.getProviderInstanceName();
        kotlin.jvm.internal.k.d(providerInstanceName, "providerSettings.providerInstanceName");
        list.add(providerInstanceName);
        StringBuilder sb = this.f8517d;
        sb.append(providerSettings.getInstanceType(this.f8514a.b().a()));
        sb.append(providerSettings.getProviderInstanceName());
        sb.append(",");
    }

    public final void a(NetworkSettings providerSettings, Map<String, ? extends Object> biddingData) {
        kotlin.jvm.internal.k.e(providerSettings, "providerSettings");
        kotlin.jvm.internal.k.e(biddingData, "biddingData");
        String providerInstanceName = providerSettings.getProviderInstanceName();
        kotlin.jvm.internal.k.d(providerInstanceName, "providerSettings.providerInstanceName");
        a(providerInstanceName, providerSettings.getInstanceType(this.f8514a.b().a()), biddingData);
    }

    public final void a(D3 biddingResponse) {
        kotlin.jvm.internal.k.e(biddingResponse, "biddingResponse");
        String strC = biddingResponse.c();
        kotlin.jvm.internal.k.d(strC, "biddingResponse.instanceName");
        int iD = biddingResponse.d();
        Map<String, Object> mapA = biddingResponse.a();
        kotlin.jvm.internal.k.d(mapA, "biddingResponse.biddingData");
        a(strC, iD, mapA);
    }

    private final void a(String str, int i2, Map<String, ? extends Object> map) {
        this.f8515b.put(str, map);
        StringBuilder sb = this.f8517d;
        sb.append(i2);
        sb.append(str);
        sb.append(",");
    }
}
