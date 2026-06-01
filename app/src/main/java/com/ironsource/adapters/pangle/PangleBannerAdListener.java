package com.ironsource.adapters.pangle;

import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdLoadListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class PangleBannerAdListener implements PAGBannerAdLoadListener, PAGBannerAdInteractionListener {
    private final WeakReference<PangleAdapter> mAdapter;
    private final FrameLayout.LayoutParams mLayoutParams;
    private final BannerSmashListener mListener;
    private final String mSlotId;

    public PangleBannerAdListener(BannerSmashListener bannerSmashListener, WeakReference<PangleAdapter> weakReference, String mSlotId, FrameLayout.LayoutParams mLayoutParams) {
        k.e(mSlotId, "mSlotId");
        k.e(mLayoutParams, "mLayoutParams");
        this.mListener = bannerSmashListener;
        this.mAdapter = weakReference;
        this.mSlotId = mSlotId;
        this.mLayoutParams = mLayoutParams;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
    public void onAdClicked() {
        com.google.android.gms.ads.internal.client.a.p("slotId = ", this.mSlotId, IronLog.ADAPTER_CALLBACK);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener != null) {
            bannerSmashListener.onBannerAdClicked();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
    public void onAdDismissed() {
        com.google.android.gms.ads.internal.client.a.p("slotId = ", this.mSlotId, IronLog.ADAPTER_CALLBACK);
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
    public void onAdShowed() {
        com.google.android.gms.ads.internal.client.a.p("slotId = ", this.mSlotId, IronLog.ADAPTER_CALLBACK);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener != null) {
            bannerSmashListener.onBannerAdShown();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.vCE
    public void onError(int i2, String message) {
        k.e(message, "message");
        com.google.android.gms.ads.internal.client.a.t(androidx.camera.core.processing.util.a.s("slotId = ", i2, this.mSlotId, ", error code = ", ", message = "), message, IronLog.ADAPTER_CALLBACK);
        if (i2 == 20001) {
            i2 = 606;
        }
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener != null) {
            bannerSmashListener.onBannerAdLoadFailed(new IronSourceError(i2, message));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
    public void onAdLoaded(PAGBannerAd bannerAd) {
        PangleAdapter pangleAdapter;
        k.e(bannerAd, "bannerAd");
        com.google.android.gms.ads.internal.client.a.p("slotId = ", this.mSlotId, IronLog.ADAPTER_CALLBACK);
        WeakReference<PangleAdapter> weakReference = this.mAdapter;
        if (weakReference != null && (pangleAdapter = weakReference.get()) != null) {
            pangleAdapter.setBannerAd$pangleadapter_release(this.mSlotId, bannerAd);
        }
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener != null) {
            bannerSmashListener.onBannerAdLoaded(bannerAd.getBannerView(), this.mLayoutParams);
        }
    }
}
