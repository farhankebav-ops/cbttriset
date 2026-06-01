package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeAd;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbux extends zzbjv {
    private final NativeAd.OnNativeAdLoadedListener zza;

    public zzbux(NativeAd.OnNativeAdLoadedListener onNativeAdLoadedListener) {
        this.zza = onNativeAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzbjw
    public final void zze(zzbkc zzbkcVar) {
        this.zza.onNativeAdLoaded(new zzbus(zzbkcVar));
    }
}
