package com.ironsource.adapters.ironsource;

import android.text.TextUtils;
import androidx.camera.core.processing.util.a;
import com.ironsource.Lc;
import com.ironsource.M9;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class IronSourceInterstitialListener implements Lc {
    public final String AD_VISIBLE_EVENT_NAME = "impressions";
    private final String mDemandSourceName;
    private final InterstitialSmashListener mListener;

    public IronSourceInterstitialListener(InterstitialSmashListener interstitialSmashListener, String str) {
        this.mDemandSourceName = str;
        this.mListener = interstitialSmashListener;
    }

    @Override // com.ironsource.Lc
    public void onInterstitialAdRewarded(String str, int i2) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        StringBuilder sb = new StringBuilder();
        a.A(sb, this.mDemandSourceName, " interstitialListener demandSourceId=", str, " amount=");
        sb.append(i2);
        ironLog.verbose(sb.toString());
    }

    @Override // com.ironsource.Lc
    public void onInterstitialClick() {
        com.google.android.gms.ads.internal.client.a.u(new StringBuilder(), this.mDemandSourceName, " interstitialListener", IronLog.ADAPTER_CALLBACK);
        this.mListener.onInterstitialAdClicked();
    }

    @Override // com.ironsource.Lc
    public void onInterstitialClose() {
        com.google.android.gms.ads.internal.client.a.u(new StringBuilder(), this.mDemandSourceName, " interstitialListener", IronLog.ADAPTER_CALLBACK);
        this.mListener.onInterstitialAdClosed();
    }

    @Override // com.ironsource.Lc
    public void onInterstitialEventNotificationReceived(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        IronLog.ADAPTER_CALLBACK.verbose(this.mDemandSourceName + " interstitialListener eventName = " + str);
        if ("impressions".equals(str)) {
            this.mListener.onInterstitialAdVisible();
        }
    }

    @Override // com.ironsource.Lc
    public void onInterstitialInitFailed(String str) {
        com.google.android.gms.ads.internal.client.a.u(new StringBuilder(), this.mDemandSourceName, " interstitialListener", IronLog.ADAPTER_CALLBACK);
    }

    @Override // com.ironsource.Lc
    public void onInterstitialInitSuccess() {
        com.google.android.gms.ads.internal.client.a.u(new StringBuilder(), this.mDemandSourceName, " interstitialListener", IronLog.ADAPTER_CALLBACK);
    }

    @Override // com.ironsource.Lc
    public void onInterstitialLoadFailed(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(this.mDemandSourceName + " interstitialListener " + str);
        this.mListener.onInterstitialAdLoadFailed(ErrorBuilder.buildLoadFailedError(str));
    }

    @Override // com.ironsource.Lc
    public void onInterstitialLoadSuccess(M9 m9) {
        com.google.android.gms.ads.internal.client.a.u(new StringBuilder(), this.mDemandSourceName, " interstitialListener", IronLog.ADAPTER_CALLBACK);
        this.mListener.onInterstitialAdReady();
    }

    @Override // com.ironsource.Lc
    public void onInterstitialOpen() {
        com.google.android.gms.ads.internal.client.a.u(new StringBuilder(), this.mDemandSourceName, " interstitialListener", IronLog.ADAPTER_CALLBACK);
        this.mListener.onInterstitialAdOpened();
    }

    @Override // com.ironsource.Lc
    public void onInterstitialShowFailed(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(this.mDemandSourceName + " interstitialListener " + str);
        this.mListener.onInterstitialAdShowFailed(ErrorBuilder.buildShowFailedError("Interstitial", str));
    }

    @Override // com.ironsource.Lc
    public void onInterstitialShowSuccess() {
        com.google.android.gms.ads.internal.client.a.u(new StringBuilder(), this.mDemandSourceName, " interstitialListener", IronLog.ADAPTER_CALLBACK);
        this.mListener.onInterstitialAdShowSucceeded();
    }
}
