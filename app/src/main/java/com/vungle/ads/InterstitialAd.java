package com.vungle.ads;

import android.content.Context;
import com.vungle.ads.internal.InterstitialAdInternal;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InterstitialAd extends BaseFullscreenAd {
    public /* synthetic */ InterstitialAd(Context context, String str, AdConfig adConfig, int i2, f fVar) {
        this(context, str, (i2 & 4) != 0 ? new AdConfig() : adConfig);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterstitialAd(Context context, String placementId, AdConfig adConfig) {
        super(context, placementId, adConfig);
        k.e(context, "context");
        k.e(placementId, "placementId");
        k.e(adConfig, "adConfig");
    }

    @Override // com.vungle.ads.BaseAd
    public InterstitialAdInternal constructAdInternal$vungle_ads_release(Context context) {
        k.e(context, "context");
        return new InterstitialAdInternal(context);
    }
}
