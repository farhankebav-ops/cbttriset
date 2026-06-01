package com.ironsource.adapters.admob.nativead;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.internal.client.a;
import com.google.android.gms.ads.nativead.NativeAd;
import com.ironsource.adapters.admob.AdMobAdapter;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdSmashListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class AdMobNativeAdListener extends AdListener implements NativeAd.OnNativeAdLoadedListener {
    private final String mAdUnitId;
    private final WeakReference<AdMobNativeAdAdapter> mAdapter;
    private final NativeAdSmashListener mListener;

    public AdMobNativeAdListener(AdMobNativeAdAdapter adMobNativeAdAdapter, String str, NativeAdSmashListener nativeAdSmashListener) {
        this.mAdapter = new WeakReference<>(adMobNativeAdAdapter);
        this.mAdUnitId = str;
        this.mListener = nativeAdSmashListener;
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdClicked() {
        a.t(new StringBuilder("adUnitId = "), this.mAdUnitId, IronLog.ADAPTER_CALLBACK);
        NativeAdSmashListener nativeAdSmashListener = this.mListener;
        if (nativeAdSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            nativeAdSmashListener.onNativeAdClicked();
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdClosed() {
        a.t(new StringBuilder("adUnitId = "), this.mAdUnitId, IronLog.ADAPTER_CALLBACK);
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        a.t(new StringBuilder("adUnitId = "), this.mAdUnitId, ironLog);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        String string = loadAdError.getMessage() + "( " + loadAdError.getCode() + " ) ";
        if (loadAdError.getCause() != null) {
            StringBuilder sbX = a1.a.x(string, " Caused by - ");
            sbX.append(loadAdError.getCause());
            string = sbX.toString();
        }
        ironLog.error("adapterError = " + string);
        this.mListener.onNativeAdLoadFailed(AdMobAdapter.isNoFillError(loadAdError.getCode()) ? new IronSourceError(706, string) : ErrorBuilder.buildLoadFailedError(string));
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdImpression() {
        a.t(new StringBuilder("adUnitId = "), this.mAdUnitId, IronLog.ADAPTER_CALLBACK);
        NativeAdSmashListener nativeAdSmashListener = this.mListener;
        if (nativeAdSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            nativeAdSmashListener.onNativeAdShown();
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdOpened() {
        a.t(new StringBuilder("adUnitId = "), this.mAdUnitId, IronLog.ADAPTER_CALLBACK);
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.OnNativeAdLoadedListener
    public void onNativeAdLoaded(@NonNull NativeAd nativeAd) {
        a.t(new StringBuilder("adUnitId = "), this.mAdUnitId, IronLog.ADAPTER_CALLBACK);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        WeakReference<AdMobNativeAdAdapter> weakReference = this.mAdapter;
        if (weakReference == null || weakReference.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
            return;
        }
        this.mAdapter.get().mAd = new WeakReference<>(nativeAd);
        this.mListener.onNativeAdLoaded(new AdMobNativeAdData(nativeAd), new AdMobNativeAdViewBinder(nativeAd));
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdLoaded() {
    }
}
