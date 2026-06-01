package com.ironsource;

import com.ironsource.mediationsdk.ads.nativead.AdapterNativeAdData;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Qb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AdapterNativeAdViewBinder f7520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AdapterNativeAdData f7521b;

    public final void a(AdapterNativeAdViewBinder adapterNativeAdViewBinder) {
        this.f7520a = adapterNativeAdViewBinder;
    }

    public final AdapterNativeAdViewBinder b() {
        return this.f7520a;
    }

    public final AdapterNativeAdData a() {
        return this.f7521b;
    }

    public final void a(AdapterNativeAdData adapterNativeAdData) {
        this.f7521b = adapterNativeAdData;
    }
}
