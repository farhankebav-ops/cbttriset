package com.google.android.gms.ads.mediation;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.internal.ads.zzbjd;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public interface MediationNativeListener {
    void onAdClicked(@NonNull MediationNativeAdapter mediationNativeAdapter);

    void onAdClosed(@NonNull MediationNativeAdapter mediationNativeAdapter);

    @Deprecated
    void onAdFailedToLoad(@NonNull MediationNativeAdapter mediationNativeAdapter, int i2);

    void onAdFailedToLoad(@NonNull MediationNativeAdapter mediationNativeAdapter, @NonNull AdError adError);

    void onAdImpression(@NonNull MediationNativeAdapter mediationNativeAdapter);

    void onAdLeftApplication(@NonNull MediationNativeAdapter mediationNativeAdapter);

    void onAdLoaded(@NonNull MediationNativeAdapter mediationNativeAdapter, @NonNull UnifiedNativeAdMapper unifiedNativeAdMapper);

    void onAdOpened(@NonNull MediationNativeAdapter mediationNativeAdapter);

    void onVideoEnd(@NonNull MediationNativeAdapter mediationNativeAdapter);

    void zzc(MediationNativeAdapter mediationNativeAdapter, zzbjd zzbjdVar);

    void zzd(MediationNativeAdapter mediationNativeAdapter, zzbjd zzbjdVar, String str);
}
