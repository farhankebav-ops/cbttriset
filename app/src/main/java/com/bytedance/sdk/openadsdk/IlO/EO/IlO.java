package com.bytedance.sdk.openadsdk.IlO.EO;

import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.bytedance.sdk.openadsdk.utils.mmj;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO implements PAGInterstitialAdLoadListener {
    private final PAGInterstitialAdLoadListener IlO;

    public IlO(PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        this.IlO = pAGInterstitialAdLoadListener;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.vCE
    public void onError(final int i2, final String str) {
        if (this.IlO == null) {
            return;
        }
        if (str == null) {
            str = "Unknown exception.";
        }
        mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.IlO.EO.IlO.1
            @Override // java.lang.Runnable
            public void run() {
                if (IlO.this.IlO != null) {
                    IlO.this.IlO.onError(i2, str);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
    /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
    public void onAdLoaded(final PAGInterstitialAd pAGInterstitialAd) {
        if (this.IlO == null) {
            return;
        }
        mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.IlO.EO.IlO.2
            @Override // java.lang.Runnable
            public void run() {
                if (IlO.this.IlO != null) {
                    IlO.this.IlO.onAdLoaded(pAGInterstitialAd);
                }
            }
        });
    }
}
