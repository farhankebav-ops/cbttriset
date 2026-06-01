package com.unity3d.scar.adapter.common;

import android.content.Context;
import com.unity3d.services.ads.gmascar.handlers.ScarBannerAdHandler;
import com.unity3d.services.ads.gmascar.handlers.ScarInterstitialAdHandler;
import com.unity3d.services.ads.gmascar.handlers.ScarRewardedAdHandler;
import com.unity3d.services.banners.BannerView;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface f {
    void a(Context context, BannerView bannerView, u3.c cVar, int i2, int i8, ScarBannerAdHandler scarBannerAdHandler);

    void b(Context context, u3.c cVar, ScarInterstitialAdHandler scarInterstitialAdHandler);

    void c(Context context, u3.c cVar, ScarRewardedAdHandler scarRewardedAdHandler);
}
