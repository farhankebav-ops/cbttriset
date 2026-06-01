package com.ironsource.adapters.admob.interstitial;

import a1.a;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.ironsource.adapters.admob.AdMobAdapter;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class AdMobInterstitialAdLoadListener extends InterstitialAdLoadCallback {
    private final String mAdUnitId;
    private final WeakReference<AdMobInterstitialAdapter> mAdapter;
    private final InterstitialSmashListener mListener;

    public AdMobInterstitialAdLoadListener(AdMobInterstitialAdapter adMobInterstitialAdapter, String str, InterstitialSmashListener interstitialSmashListener) {
        this.mAdapter = new WeakReference<>(adMobInterstitialAdapter);
        this.mAdUnitId = str;
        this.mListener = interstitialSmashListener;
    }

    @Override // com.google.android.gms.ads.AdLoadCallback
    public void onAdFailedToLoad(LoadAdError loadAdError) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("adUnitId = " + this.mAdUnitId);
        int code = loadAdError.getCode();
        String string = loadAdError.getMessage() + "( " + code + " ) ";
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        if (AdMobAdapter.isNoFillError(code)) {
            code = 1158;
            string = "No Fill";
        }
        if (loadAdError.getCause() != null) {
            StringBuilder sbX = a.x(string, " Caused by - ");
            sbX.append(loadAdError.getCause());
            string = sbX.toString();
        }
        ironLog.error("adapterError = " + string);
        this.mListener.onInterstitialAdLoadFailed(new IronSourceError(code, string));
    }

    @Override // com.google.android.gms.ads.AdLoadCallback
    public void onAdLoaded(InterstitialAd interstitialAd) {
        com.google.android.gms.ads.internal.client.a.t(new StringBuilder("adUnitId = "), this.mAdUnitId, IronLog.ADAPTER_CALLBACK);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        WeakReference<AdMobInterstitialAdapter> weakReference = this.mAdapter;
        if (weakReference == null || weakReference.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
        } else {
            this.mAdapter.get().onInterstitialAdLoaded(this.mAdUnitId, interstitialAd);
            this.mListener.onInterstitialAdReady();
        }
    }
}
