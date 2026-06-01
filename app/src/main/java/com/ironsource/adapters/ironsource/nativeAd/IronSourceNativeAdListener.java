package com.ironsource.adapters.ironsource.nativeAd;

import com.ironsource.G8;
import com.ironsource.I8;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdSmashListener;
import com.ironsource.mediationsdk.logger.IronSourceError;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class IronSourceNativeAdListener implements I8.a {
    private final IronSourceNativeAdViewBinder binder;
    private final NativeAdSmashListener smashListener;

    public IronSourceNativeAdListener(IronSourceNativeAdViewBinder binder, NativeAdSmashListener smashListener) {
        k.e(binder, "binder");
        k.e(smashListener, "smashListener");
        this.binder = binder;
        this.smashListener = smashListener;
    }

    @Override // com.ironsource.I8.a
    public void onNativeAdClicked() {
        this.smashListener.onNativeAdClicked();
    }

    @Override // com.ironsource.I8.a
    public void onNativeAdLoadFailed(String reason) {
        k.e(reason, "reason");
        this.smashListener.onNativeAdLoadFailed(new IronSourceError(510, "Load failed - ".concat(reason)));
    }

    @Override // com.ironsource.I8.a
    public void onNativeAdLoadSuccess(G8 adData) {
        k.e(adData, "adData");
        this.smashListener.onNativeAdLoaded(new IronSourceNativeAdData(adData), this.binder);
    }

    @Override // com.ironsource.I8.a
    public void onNativeAdShown() {
        this.smashListener.onNativeAdShown();
    }
}
