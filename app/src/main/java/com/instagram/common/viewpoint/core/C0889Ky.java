package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ky, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0889Ky<T> {
    public boolean A00;
    public boolean A01 = true;
    public final InterfaceC0883Ks<T> A02;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Ks != com.facebook.ads.cache.api.ResponseAdapter<T> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Ky != com.facebook.ads.cache.config.CacheRequestConfig<T> */
    public C0889Ky(InterfaceC0883Ks<T> interfaceC0883Ks) {
        this.A02 = interfaceC0883Ks;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Ky != com.facebook.ads.cache.config.CacheRequestConfig<T> */
    public final InterfaceC0883Ks<T> A00() {
        return this.A02;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Ky != com.facebook.ads.cache.config.CacheRequestConfig<T> */
    public final void A01(boolean z2) {
        this.A00 = z2;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Ky != com.facebook.ads.cache.config.CacheRequestConfig<T> */
    public final void A02(boolean z2) {
        this.A01 = z2;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Ky != com.facebook.ads.cache.config.CacheRequestConfig<T> */
    public final boolean A03() {
        return this.A00;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Ky != com.facebook.ads.cache.config.CacheRequestConfig<T> */
    public final boolean A04() {
        return this.A01;
    }
}
