package com.google.ads.mediation.vungle.waterfall;

import com.google.ads.mediation.vungle.VungleFactory;
import com.google.ads.mediation.vungle.renderers.VungleBannerAd;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.vungle.ads.VungleBannerView;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class VungleWaterfallBannerAd extends VungleBannerAd {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VungleWaterfallBannerAd(MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback, VungleFactory vungleFactory) {
        super(mediationAdLoadCallback, vungleFactory);
        k.e(mediationAdLoadCallback, "mediationAdLoadCallback");
        k.e(vungleFactory, "vungleFactory");
    }

    @Override // com.google.ads.mediation.vungle.renderers.VungleBannerAd
    public void loadAd(VungleBannerView bannerAdView, MediationBannerAdConfiguration mediationBannerAdConfiguration) {
        k.e(bannerAdView, "bannerAdView");
        k.e(mediationBannerAdConfiguration, "mediationBannerAdConfiguration");
        bannerAdView.load(null);
    }
}
