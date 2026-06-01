package com.bytedance.sdk.openadsdk.component.EO;

import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdInteractionListener;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO implements com.bytedance.sdk.openadsdk.IlO.EO.MY {
    private final PAGInterstitialAdInteractionListener IlO;

    public IlO(PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener) {
        this.IlO = pAGInterstitialAdInteractionListener;
    }

    @Override // com.bytedance.sdk.openadsdk.IlO.EO.MY
    public void IlO() {
        PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener = this.IlO;
        if (pAGInterstitialAdInteractionListener != null) {
            pAGInterstitialAdInteractionListener.onAdShowed();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.IlO.EO.MY
    public void MY() {
        PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener = this.IlO;
        if (pAGInterstitialAdInteractionListener != null) {
            pAGInterstitialAdInteractionListener.onAdDismissed();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGAdWrapperListener
    public void onAdClicked() {
        PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener = this.IlO;
        if (pAGInterstitialAdInteractionListener != null) {
            pAGInterstitialAdInteractionListener.onAdClicked();
        }
    }
}
