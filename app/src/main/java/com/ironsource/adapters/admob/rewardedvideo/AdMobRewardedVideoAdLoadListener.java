package com.ironsource.adapters.admob.rewardedvideo;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.internal.client.a;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.ironsource.adapters.admob.AdMobAdapter;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class AdMobRewardedVideoAdLoadListener extends RewardedAdLoadCallback {
    private String mAdUnitId;
    private RewardedVideoSmashListener mListener;
    private WeakReference<AdMobRewardedVideoAdapter> mRewardedVideoAdapter;

    public AdMobRewardedVideoAdLoadListener(AdMobRewardedVideoAdapter adMobRewardedVideoAdapter, String str, RewardedVideoSmashListener rewardedVideoSmashListener) {
        this.mRewardedVideoAdapter = new WeakReference<>(adMobRewardedVideoAdapter);
        this.mAdUnitId = str;
        this.mListener = rewardedVideoSmashListener;
    }

    @Override // com.google.android.gms.ads.AdLoadCallback
    public void onAdFailedToLoad(LoadAdError loadAdError) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        a.t(new StringBuilder("adUnitId = "), this.mAdUnitId, ironLog);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        int code = loadAdError.getCode();
        String string = loadAdError.getMessage() + "( " + code + " )";
        ironLog.error("adapterError = " + string);
        if (AdMobAdapter.isNoFillError(code)) {
            code = 1058;
            string = "No Fill";
        }
        if (loadAdError.getCause() != null) {
            StringBuilder sbX = a1.a.x(string, "Caused by ");
            sbX.append(loadAdError.getCause());
            string = sbX.toString();
        }
        ironLog.error("adapterError = " + string);
        this.mListener.onRewardedVideoAvailabilityChanged(false);
        this.mListener.onRewardedVideoLoadFailed(new IronSourceError(code, string));
    }

    @Override // com.google.android.gms.ads.AdLoadCallback
    public void onAdLoaded(RewardedAd rewardedAd) {
        a.t(new StringBuilder("adUnitId = "), this.mAdUnitId, IronLog.ADAPTER_CALLBACK);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        WeakReference<AdMobRewardedVideoAdapter> weakReference = this.mRewardedVideoAdapter;
        if (weakReference == null || weakReference.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
        } else {
            this.mRewardedVideoAdapter.get().onRewardedVideoAdLoaded(this.mAdUnitId, rewardedAd);
            this.mListener.onRewardedVideoAvailabilityChanged(true);
        }
    }
}
