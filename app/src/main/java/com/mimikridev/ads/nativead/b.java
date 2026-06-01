package com.mimikridev.ads.nativead;

import com.google.android.gms.ads.nativead.NativeAd;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class b implements NativeAd.OnNativeAdLoadedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ NativeAd f10678b;

    public /* synthetic */ b(NativeAd nativeAd, int i2) {
        this.f10677a = i2;
        this.f10678b = nativeAd;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.OnNativeAdLoadedListener
    public final void onNativeAdLoaded(com.google.android.gms.ads.nativead.NativeAd nativeAd) {
        switch (this.f10677a) {
            case 0:
                this.f10678b.lambda$loadBackupNativeAd$3(nativeAd);
                break;
            default:
                this.f10678b.lambda$loadNativeAd$1(nativeAd);
                break;
        }
    }
}
