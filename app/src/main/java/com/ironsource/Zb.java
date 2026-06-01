package com.ironsource;

import com.ironsource.mediationsdk.ads.nativead.AdapterNativeAdData;
import com.ironsource.mediationsdk.ads.nativead.internal.InternalNativeAdListener;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Zb extends K0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InternalNativeAdListener f7920a;

    public Zb(InternalNativeAdListener mNativeAdListener) {
        kotlin.jvm.internal.k.e(mNativeAdListener, "mNativeAdListener");
        this.f7920a = mNativeAdListener;
    }

    @Override // com.ironsource.K0
    public void a(AdapterNativeAdData adapterNativeAdData, AdapterNativeAdViewBinder nativeAdViewBinder, AdInfo adInfo) {
        kotlin.jvm.internal.k.e(adapterNativeAdData, "adapterNativeAdData");
        kotlin.jvm.internal.k.e(nativeAdViewBinder, "nativeAdViewBinder");
        this.f7920a.onNativeAdLoaded(adInfo, adapterNativeAdData, nativeAdViewBinder);
    }

    @Override // com.ironsource.K0
    public void d(AdInfo adInfo) {
        this.f7920a.onNativeAdImpression(adInfo);
    }

    @Override // com.ironsource.K0
    public void a(IronSourceError ironSourceError) {
        this.f7920a.onNativeAdLoadFailed(ironSourceError);
    }

    @Override // com.ironsource.K0
    public void a(C2434ld placement, AdInfo adInfo) {
        kotlin.jvm.internal.k.e(placement, "placement");
        this.f7920a.onNativeAdClicked(adInfo);
    }
}
