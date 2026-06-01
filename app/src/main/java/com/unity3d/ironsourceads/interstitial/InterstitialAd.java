package com.unity3d.ironsourceads.interstitial;

import android.app.Activity;
import com.ironsource.C2587u9;
import com.ironsource.InterfaceC2604v9;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InterstitialAd implements InterfaceC2604v9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2587u9 f10882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private InterstitialAdListener f10883b;

    public InterstitialAd(C2587u9 interstitialAdInternal) {
        k.e(interstitialAdInternal, "interstitialAdInternal");
        this.f10882a = interstitialAdInternal;
        interstitialAdInternal.a(this);
    }

    public final InterstitialAdInfo getAdInfo() {
        return this.f10882a.b();
    }

    public final InterstitialAdListener getListener() {
        return this.f10883b;
    }

    public final boolean isReadyToShow() {
        IronLog.API.info();
        return this.f10882a.d();
    }

    @Override // com.ironsource.InterfaceC2604v9
    public void onAdInstanceDidBecomeVisible() {
        IronLog.CALLBACK.info("InterstitialAdListener onInterstitialAdShown adInfo: " + getAdInfo());
        InterstitialAdListener interstitialAdListener = this.f10883b;
        if (interstitialAdListener != null) {
            interstitialAdListener.onInterstitialAdShown(this);
        }
    }

    @Override // com.ironsource.InterfaceC2604v9
    public void onAdInstanceDidClick() {
        IronLog.CALLBACK.info("InterstitialAdListener onInterstitialAdClicked adInfo: " + getAdInfo());
        InterstitialAdListener interstitialAdListener = this.f10883b;
        if (interstitialAdListener != null) {
            interstitialAdListener.onInterstitialAdClicked(this);
        }
    }

    @Override // com.ironsource.InterfaceC2604v9
    public void onAdInstanceDidDismiss() {
        IronLog.CALLBACK.info("InterstitialAdListener onInterstitialAdDismissed adInfo: " + getAdInfo());
        InterstitialAdListener interstitialAdListener = this.f10883b;
        if (interstitialAdListener != null) {
            interstitialAdListener.onInterstitialAdDismissed(this);
        }
    }

    @Override // com.ironsource.InterfaceC2604v9
    public void onAdInstanceDidFailedToShow(IronSourceError error) {
        k.e(error, "error");
        IronLog.CALLBACK.info("InterstitialAdListener onInterstitialAdFailedToShow error : " + error + " adInfo: " + getAdInfo());
        InterstitialAdListener interstitialAdListener = this.f10883b;
        if (interstitialAdListener != null) {
            interstitialAdListener.onInterstitialAdFailedToShow(this, error);
        }
    }

    @Override // com.ironsource.InterfaceC2604v9
    public void onAdInstanceDidShow() {
        IronLog.CALLBACK.info("InterstitialAdListener onInterstitialAdShown adInfo: " + getAdInfo());
        InterstitialAdListener interstitialAdListener = this.f10883b;
        if (interstitialAdListener != null) {
            interstitialAdListener.onInterstitialAdShown(this);
        }
    }

    public final void setListener(InterstitialAdListener interstitialAdListener) {
        this.f10883b = interstitialAdListener;
    }

    public final void show(Activity activity) {
        k.e(activity, "activity");
        IronLog.API.info();
        this.f10882a.a(activity);
    }

    @Override // com.ironsource.InterfaceC2604v9
    public void onAdInstanceDidReward(String str, int i2) {
    }
}
