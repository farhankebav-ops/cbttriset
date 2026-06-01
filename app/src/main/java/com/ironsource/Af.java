package com.ironsource;

import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import com.unity3d.mediation.banner.LevelPlayBannerAdViewListener;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Af implements LevelPlayBannerAdViewListener {
    @Override // com.unity3d.mediation.banner.LevelPlayBannerAdViewListener
    public void onAdClicked(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        C2580u2.a().b(Pf.f7396a.a(adInfo));
    }

    @Override // com.unity3d.mediation.banner.LevelPlayBannerAdViewListener
    public final /* synthetic */ void onAdCollapsed(LevelPlayAdInfo levelPlayAdInfo) {
        q3.a.b(this, levelPlayAdInfo);
    }

    @Override // com.unity3d.mediation.banner.LevelPlayBannerAdViewListener
    public final /* synthetic */ void onAdDisplayFailed(LevelPlayAdInfo levelPlayAdInfo, LevelPlayAdError levelPlayAdError) {
        q3.a.c(this, levelPlayAdInfo, levelPlayAdError);
    }

    @Override // com.unity3d.mediation.banner.LevelPlayBannerAdViewListener
    public void onAdDisplayed(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        C2580u2.a().f(Pf.f7396a.a(adInfo));
    }

    @Override // com.unity3d.mediation.banner.LevelPlayBannerAdViewListener
    public final /* synthetic */ void onAdExpanded(LevelPlayAdInfo levelPlayAdInfo) {
        q3.a.e(this, levelPlayAdInfo);
    }

    @Override // com.unity3d.mediation.banner.LevelPlayBannerAdViewListener
    public void onAdLeftApplication(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        C2580u2.a().c(Pf.f7396a.a(adInfo));
    }

    @Override // com.unity3d.mediation.banner.LevelPlayBannerAdViewListener
    public void onAdLoadFailed(LevelPlayAdError error) {
        kotlin.jvm.internal.k.e(error, "error");
        C2580u2.a().a(Pf.f7396a.a(error));
    }

    @Override // com.unity3d.mediation.banner.LevelPlayBannerAdViewListener
    public void onAdLoaded(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        C2580u2.a().d(Pf.f7396a.a(adInfo));
    }
}
