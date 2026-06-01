package com.instagram.common.viewpoint.core;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAdListener;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Nd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0945Nd implements InterstitialAdListener {
    public final /* synthetic */ AbstractC1752hy A00;
    public final /* synthetic */ C1702h4 A01;

    public C0945Nd(C1702h4 c1702h4, AbstractC1752hy abstractC1752hy) {
        this.A01 = c1702h4;
        this.A00 = abstractC1752hy;
    }

    @Override // com.facebook.ads.AdListener
    public final void onAdClicked(Ad ad) {
    }

    @Override // com.facebook.ads.AdListener
    public final void onAdLoaded(Ad ad) {
        this.A01.A00.A07.onAdLoaded(this.A01.A00.A08.A6c());
    }

    @Override // com.facebook.ads.AdListener
    public final void onError(Ad ad, AdError adError) {
        this.A01.A00.A01 = null;
        this.A00.A2A(false);
        this.A01.A00.A07.onAdLoaded(this.A01.A00.A08.A6c());
    }

    @Override // com.facebook.ads.InterstitialAdListener
    public final void onInterstitialDismissed(Ad ad) {
        this.A01.A00.A04 = false;
        if (this.A01.A00.A03 != null) {
            this.A01.A00.A03.A0S(new C1704h6(this));
            this.A01.A00.A03.A0N();
            this.A01.A00.A03.A0K();
            this.A01.A00.A03 = null;
        }
        this.A01.A00.A07.onInterstitialDismissed(this.A01.A00.A08.A6c());
    }

    @Override // com.facebook.ads.InterstitialAdListener
    public final void onInterstitialDisplayed(Ad ad) {
    }

    @Override // com.facebook.ads.AdListener
    public final void onLoggingImpression(Ad ad) {
    }
}
