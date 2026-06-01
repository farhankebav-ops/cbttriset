package com.ironsource.adapters.admob.interstitial;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.client.a;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.ironsource.adapters.admob.AdMobAdapter;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class AdMobInterstitialAdapter extends AbstractInterstitialAdapter<AdMobAdapter> {
    private final ConcurrentHashMap<String, InterstitialAd> mAdUnitIdToAd;
    private final ConcurrentHashMap<String, Boolean> mAdUnitIdToAdsAvailability;
    private final ConcurrentHashMap<String, InterstitialSmashListener> mAdUnitIdToListener;

    public AdMobInterstitialAdapter(AdMobAdapter adMobAdapter) {
        super(adMobAdapter);
        this.mAdUnitIdToListener = new ConcurrentHashMap<>();
        this.mAdUnitIdToAd = new ConcurrentHashMap<>();
        this.mAdUnitIdToAdsAvailability = new ConcurrentHashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InterstitialAd getInterstitialAd(String str) {
        if (TextUtils.isEmpty(str) || !this.mAdUnitIdToAd.containsKey(str)) {
            return null;
        }
        return this.mAdUnitIdToAd.get(str);
    }

    private void initInterstitialInternal(@NonNull JSONObject jSONObject, @NonNull InterstitialSmashListener interstitialSmashListener) {
        String adUnitIdKey = getAdapter().getAdUnitIdKey();
        String configStringValueFromKey = getConfigStringValueFromKey(jSONObject, adUnitIdKey);
        if (TextUtils.isEmpty(configStringValueFromKey)) {
            interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError(getAdUnitIdMissingErrorString(adUnitIdKey), "Interstitial"));
            return;
        }
        a.p("adUnitId = ", configStringValueFromKey, IronLog.ADAPTER_API);
        this.mAdUnitIdToListener.put(configStringValueFromKey, interstitialSmashListener);
        if (getAdapter().getInitState() == AdMobAdapter.InitState.INIT_STATE_SUCCESS) {
            IronLog.INTERNAL.verbose("onInterstitialInitSuccess - adUnitId = " + configStringValueFromKey);
            interstitialSmashListener.onInterstitialInitSuccess();
            return;
        }
        if (getAdapter().getInitState() != AdMobAdapter.InitState.INIT_STATE_FAILED) {
            getAdapter().initSDK(jSONObject);
            return;
        }
        IronLog.INTERNAL.verbose("onInterstitialInitFailed - adUnitId = " + configStringValueFromKey);
        interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("AdMob sdk init failed", "Interstitial"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInterstitialReadyForAdUnitId(String str) {
        return !TextUtils.isEmpty(str) && this.mAdUnitIdToAdsAvailability.containsKey(str) && this.mAdUnitIdToAdsAvailability.get(str).booleanValue();
    }

    private void loadInterstitialInternal(@NonNull final JSONObject jSONObject, final JSONObject jSONObject2, final String str, @NonNull final InterstitialSmashListener interstitialSmashListener) {
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.admob.interstitial.AdMobInterstitialAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                AdMobInterstitialAdapter adMobInterstitialAdapter = AdMobInterstitialAdapter.this;
                String configStringValueFromKey = adMobInterstitialAdapter.getConfigStringValueFromKey(jSONObject, adMobInterstitialAdapter.getAdapter().getAdUnitIdKey());
                a.p("adUnitId = ", configStringValueFromKey, IronLog.ADAPTER_API);
                AdMobInterstitialAdapter.this.mAdUnitIdToAdsAvailability.put(configStringValueFromKey, Boolean.FALSE);
                InterstitialAd.load(ContextProvider.getInstance().getApplicationContext(), configStringValueFromKey, AdMobInterstitialAdapter.this.getAdapter().createAdRequest(jSONObject2, str), new AdMobInterstitialAdLoadListener(AdMobInterstitialAdapter.this, configStringValueFromKey, interstitialSmashListener));
            }
        });
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void collectInterstitialBiddingData(@NonNull JSONObject jSONObject, JSONObject jSONObject2, BiddingDataCallback biddingDataCallback) {
        getAdapter().collectBiddingData(biddingDataCallback, AdFormat.INTERSTITIAL, null);
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void initInterstitial(String str, String str2, @NonNull JSONObject jSONObject, @NonNull InterstitialSmashListener interstitialSmashListener) {
        initInterstitialInternal(jSONObject, interstitialSmashListener);
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void initInterstitialForBidding(String str, String str2, @NonNull JSONObject jSONObject, @NonNull InterstitialSmashListener interstitialSmashListener) {
        initInterstitialInternal(jSONObject, interstitialSmashListener);
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public final boolean isInterstitialReady(@NonNull JSONObject jSONObject) {
        return isInterstitialReadyForAdUnitId(getConfigStringValueFromKey(jSONObject, getAdapter().getAdUnitIdKey()));
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void loadInterstitial(@NonNull JSONObject jSONObject, JSONObject jSONObject2, @NonNull InterstitialSmashListener interstitialSmashListener) {
        loadInterstitialInternal(jSONObject, jSONObject2, null, interstitialSmashListener);
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void loadInterstitialForBidding(@NonNull JSONObject jSONObject, JSONObject jSONObject2, String str, @NonNull InterstitialSmashListener interstitialSmashListener) {
        loadInterstitialInternal(jSONObject, jSONObject2, str, interstitialSmashListener);
    }

    public void onInterstitialAdLoaded(String str, InterstitialAd interstitialAd) {
        this.mAdUnitIdToAd.put(str, interstitialAd);
        this.mAdUnitIdToAdsAvailability.put(str, Boolean.TRUE);
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractAdUnitAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackFailed(String str) {
        Iterator<InterstitialSmashListener> it = this.mAdUnitIdToListener.values().iterator();
        while (it.hasNext()) {
            it.next().onInterstitialInitFailed(ErrorBuilder.buildInitFailedError(str, "Interstitial"));
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractAdUnitAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackSuccess() {
        Iterator<InterstitialSmashListener> it = this.mAdUnitIdToListener.values().iterator();
        while (it.hasNext()) {
            it.next().onInterstitialInitSuccess();
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void showInterstitial(@NonNull final JSONObject jSONObject, @NonNull final InterstitialSmashListener interstitialSmashListener) {
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.admob.interstitial.AdMobInterstitialAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                AdMobInterstitialAdapter adMobInterstitialAdapter = AdMobInterstitialAdapter.this;
                String configStringValueFromKey = adMobInterstitialAdapter.getConfigStringValueFromKey(jSONObject, adMobInterstitialAdapter.getAdapter().getAdUnitIdKey());
                IronLog ironLog = IronLog.ADAPTER_API;
                a.p("adUnitId = ", configStringValueFromKey, ironLog);
                InterstitialAd interstitialAd = AdMobInterstitialAdapter.this.getInterstitialAd(configStringValueFromKey);
                if (!AdMobInterstitialAdapter.this.isInterstitialReadyForAdUnitId(configStringValueFromKey) || interstitialAd == null) {
                    ironLog.error("Ad not ready to display");
                    interstitialSmashListener.onInterstitialAdShowFailed(ErrorBuilder.buildNoAdsToShowError("Interstitial"));
                } else {
                    interstitialAd.setFullScreenContentCallback(new AdMobInterstitialAdShowListener(configStringValueFromKey, interstitialSmashListener));
                    interstitialAd.show(ContextProvider.getInstance().getCurrentActiveActivity());
                }
                AdMobInterstitialAdapter.this.mAdUnitIdToAdsAvailability.put(configStringValueFromKey, Boolean.FALSE);
            }
        });
    }
}
