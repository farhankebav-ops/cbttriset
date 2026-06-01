package com.google.ads.mediation.vungle.waterfall;

import com.google.ads.mediation.vungle.VungleFactory;
import com.google.ads.mediation.vungle.renderers.VungleAppOpenAd;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationAppOpenAd;
import com.google.android.gms.ads.mediation.MediationAppOpenAdCallback;
import com.google.android.gms.ads.mediation.MediationAppOpenAdConfiguration;
import com.vungle.ads.AdConfig;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class VungleWaterfallAppOpenAd extends VungleAppOpenAd {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VungleWaterfallAppOpenAd(MediationAdLoadCallback<MediationAppOpenAd, MediationAppOpenAdCallback> mediationAdLoadCallback, VungleFactory vungleFactory) {
        super(mediationAdLoadCallback, vungleFactory);
        k.e(mediationAdLoadCallback, "mediationAdLoadCallback");
        k.e(vungleFactory, "vungleFactory");
    }

    @Override // com.google.ads.mediation.vungle.renderers.VungleAppOpenAd
    public String getAdMarkup(MediationAppOpenAdConfiguration mediationAppOpenAdConfiguration) {
        k.e(mediationAppOpenAdConfiguration, "mediationAppOpenAdConfiguration");
        return null;
    }

    @Override // com.google.ads.mediation.vungle.renderers.VungleAppOpenAd
    public void maybeAddWatermarkToVungleAdConfig(AdConfig adConfig, MediationAppOpenAdConfiguration mediationAppOpenAdConfiguration) {
        k.e(adConfig, "adConfig");
        k.e(mediationAppOpenAdConfiguration, "mediationAppOpenAdConfiguration");
    }
}
