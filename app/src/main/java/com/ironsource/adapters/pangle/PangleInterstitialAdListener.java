package com.ironsource.adapters.pangle;

import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class PangleInterstitialAdListener implements PAGInterstitialAdLoadListener, PAGInterstitialAdInteractionListener {
    private final WeakReference<PangleAdapter> mAdapter;
    private final InterstitialSmashListener mListener;
    private final String mSlotId;

    public PangleInterstitialAdListener(InterstitialSmashListener interstitialSmashListener, WeakReference<PangleAdapter> weakReference, String mSlotId) {
        k.e(mSlotId, "mSlotId");
        this.mListener = interstitialSmashListener;
        this.mAdapter = weakReference;
        this.mSlotId = mSlotId;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
    public void onAdClicked() {
        com.google.android.gms.ads.internal.client.a.p("slotId = ", this.mSlotId, IronLog.ADAPTER_CALLBACK);
        InterstitialSmashListener interstitialSmashListener = this.mListener;
        if (interstitialSmashListener != null) {
            interstitialSmashListener.onInterstitialAdClicked();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
    public void onAdDismissed() {
        com.google.android.gms.ads.internal.client.a.p("slotId = ", this.mSlotId, IronLog.ADAPTER_CALLBACK);
        InterstitialSmashListener interstitialSmashListener = this.mListener;
        if (interstitialSmashListener != null) {
            interstitialSmashListener.onInterstitialAdClosed();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
    public void onAdShowed() {
        com.google.android.gms.ads.internal.client.a.p("slotId = ", this.mSlotId, IronLog.ADAPTER_CALLBACK);
        InterstitialSmashListener interstitialSmashListener = this.mListener;
        if (interstitialSmashListener != null) {
            interstitialSmashListener.onInterstitialAdOpened();
        }
        InterstitialSmashListener interstitialSmashListener2 = this.mListener;
        if (interstitialSmashListener2 != null) {
            interstitialSmashListener2.onInterstitialAdShowSucceeded();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.vCE
    public void onError(int i2, String message) {
        PangleAdapter pangleAdapter;
        k.e(message, "message");
        com.google.android.gms.ads.internal.client.a.t(androidx.camera.core.processing.util.a.s("Failed to load slotId = ", i2, this.mSlotId, ", error code = ", ", message = "), message, IronLog.ADAPTER_CALLBACK);
        WeakReference<PangleAdapter> weakReference = this.mAdapter;
        if (weakReference != null && (pangleAdapter = weakReference.get()) != null) {
            pangleAdapter.setInterstitialAdAvailability$pangleadapter_release(this.mSlotId, false);
        }
        if (i2 == 20001) {
            i2 = 1158;
        }
        InterstitialSmashListener interstitialSmashListener = this.mListener;
        if (interstitialSmashListener != null) {
            interstitialSmashListener.onInterstitialAdLoadFailed(new IronSourceError(i2, message));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
    public void onAdLoaded(PAGInterstitialAd interstitialAd) {
        PangleAdapter pangleAdapter;
        PangleAdapter pangleAdapter2;
        k.e(interstitialAd, "interstitialAd");
        com.google.android.gms.ads.internal.client.a.p("slotId = ", this.mSlotId, IronLog.ADAPTER_CALLBACK);
        WeakReference<PangleAdapter> weakReference = this.mAdapter;
        if (weakReference != null && (pangleAdapter2 = weakReference.get()) != null) {
            pangleAdapter2.setInterstitialAd$pangleadapter_release(this.mSlotId, interstitialAd);
        }
        WeakReference<PangleAdapter> weakReference2 = this.mAdapter;
        if (weakReference2 != null && (pangleAdapter = weakReference2.get()) != null) {
            pangleAdapter.setInterstitialAdAvailability$pangleadapter_release(this.mSlotId, true);
        }
        InterstitialSmashListener interstitialSmashListener = this.mListener;
        if (interstitialSmashListener != null) {
            interstitialSmashListener.onInterstitialAdReady();
        }
    }
}
