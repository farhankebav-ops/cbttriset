package com.google.ads.mediation.vungle.rtb;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.ads.mediation.vungle.VungleFactory;
import com.google.ads.mediation.vungle.renderers.VungleBannerAd;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.vungle.ads.BannerAdListener;
import com.vungle.ads.VungleBannerView;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class VungleRtbBannerAd extends VungleBannerAd implements BannerAdListener {
    public VungleRtbBannerAd(@NonNull MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback, VungleFactory vungleFactory) {
        super(mediationAdLoadCallback, vungleFactory);
    }

    @Override // com.google.ads.mediation.vungle.renderers.VungleBannerAd
    public void loadAd(VungleBannerView vungleBannerView, MediationBannerAdConfiguration mediationBannerAdConfiguration) {
        String bidResponse = mediationBannerAdConfiguration.getBidResponse();
        String watermark = mediationBannerAdConfiguration.getWatermark();
        if (!TextUtils.isEmpty(watermark)) {
            vungleBannerView.getAdConfig().setWatermark(watermark);
        }
        vungleBannerView.load(bidResponse);
    }
}
