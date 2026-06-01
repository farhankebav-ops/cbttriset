package com.mimikridev.ads.nativead;

import android.content.Context;
import com.google.android.gms.ads.nativead.NativeAd;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class e implements NativeAd.OnNativeAdLoadedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ NativeAdViewHolder f10684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f10685c;

    public /* synthetic */ e(NativeAdViewHolder nativeAdViewHolder, Context context, int i2) {
        this.f10683a = i2;
        this.f10684b = nativeAdViewHolder;
        this.f10685c = context;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.OnNativeAdLoadedListener
    public final void onNativeAdLoaded(com.google.android.gms.ads.nativead.NativeAd nativeAd) {
        switch (this.f10683a) {
            case 0:
                this.f10684b.lambda$loadNativeAd$1(this.f10685c, nativeAd);
                break;
            default:
                this.f10684b.lambda$loadBackupNativeAd$2(this.f10685c, nativeAd);
                break;
        }
    }
}
