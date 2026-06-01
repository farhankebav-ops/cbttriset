package com.mimikridev.ads.nativead;

import com.google.android.gms.ads.nativead.NativeAd;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class d implements NativeAd.OnNativeAdLoadedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ NativeAdView f10682b;

    public /* synthetic */ d(NativeAdView nativeAdView, int i2) {
        this.f10681a = i2;
        this.f10682b = nativeAdView;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.OnNativeAdLoadedListener
    public final void onNativeAdLoaded(com.google.android.gms.ads.nativead.NativeAd nativeAd) {
        switch (this.f10681a) {
            case 0:
                this.f10682b.lambda$loadBackupNativeAd$3(nativeAd);
                break;
            default:
                this.f10682b.lambda$loadNativeAd$1(nativeAd);
                break;
        }
    }
}
