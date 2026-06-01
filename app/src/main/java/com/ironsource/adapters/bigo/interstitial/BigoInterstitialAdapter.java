package com.ironsource.adapters.bigo.interstitial;

import com.ironsource.adapters.bigo.BigoAdapter;
import com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.k;
import org.json.JSONObject;
import sg.bigo.ads.api.AdLoadListener;
import sg.bigo.ads.api.InterstitialAd;
import sg.bigo.ads.api.InterstitialAdLoader;
import sg.bigo.ads.api.InterstitialAdRequest;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class BigoInterstitialAdapter extends AbstractInterstitialAdapter<BigoAdapter> {
    private boolean isInterstitialAdAvailable;
    private BigoInterstitialAdListener mAdListener;
    private InterstitialAdLoader mAdLoader;
    private InterstitialAd mInterstitialAd;
    private InterstitialSmashListener mSmashListener;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BigoAdapter.Companion.InitState.values().length];
            try {
                iArr[BigoAdapter.Companion.InitState.INIT_STATE_SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BigoAdapter.Companion.InitState.INIT_STATE_NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BigoAdapter.Companion.InitState.INIT_STATE_IN_PROGRESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BigoInterstitialAdapter(BigoAdapter adapter) {
        super(adapter);
        k.e(adapter, "adapter");
    }

    public final void destroyInterstitialAd$bigoadapter_release() {
        InterstitialAd interstitialAd = this.mInterstitialAd;
        if (interstitialAd != null) {
            interstitialAd.setAdInteractionListener(null);
        }
        InterstitialAd interstitialAd2 = this.mInterstitialAd;
        if (interstitialAd2 != null) {
            interstitialAd2.destroy();
        }
        this.mAdLoader = null;
        this.mInterstitialAd = null;
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public Map<String, Object> getInterstitialBiddingData(JSONObject config, JSONObject jSONObject) {
        k.e(config, "config");
        return getAdapter().getBiddingData$bigoadapter_release();
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void initInterstitialForBidding(String str, String str2, JSONObject config, InterstitialSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
        String appId = config.optString(BigoAdapter.Companion.getAppIdKey());
        k.d(appId, "appId");
        if (appId.length() == 0) {
            IronLog.INTERNAL.error(getAdUnitIdMissingErrorString(appId));
            listener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError(getAdUnitIdMissingErrorString(appId), "Interstitial"));
            return;
        }
        this.mSmashListener = listener;
        int i2 = WhenMappings.$EnumSwitchMapping$0[getAdapter().getInitState().ordinal()];
        if (i2 == 1) {
            listener.onInterstitialInitSuccess();
        } else if (i2 == 2 || i2 == 3) {
            getAdapter().initSdk(appId);
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public boolean isInterstitialReady(JSONObject config) {
        k.e(config, "config");
        InterstitialAd interstitialAd = this.mInterstitialAd;
        return (interstitialAd == null || interstitialAd == null || interstitialAd.isExpired()) ? false : true;
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void loadInterstitialForBidding(JSONObject config, JSONObject jSONObject, String str, InterstitialSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
        IronLog.ADAPTER_API.verbose();
        if (str == null || str.length() == 0) {
            IronLog.INTERNAL.error("serverData is empty");
            listener.onInterstitialAdLoadFailed(ErrorBuilder.buildLoadFailedError("serverData is empty"));
            return;
        }
        setInterstitialAdAvailability$bigoadapter_release(false);
        BigoAdapter.Companion companion = BigoAdapter.Companion;
        String configStringValueFromKey = getConfigStringValueFromKey(config, companion.getSlotIdKey());
        this.mAdListener = new BigoInterstitialAdListener(new WeakReference(this), listener);
        InterstitialAdLoader interstitialAdLoaderBuild = new InterstitialAdLoader.Builder().withAdLoadListener((AdLoadListener<InterstitialAd>) this.mAdListener).withExt(companion.getMEDIATION_INFO()).build();
        k.d(interstitialAdLoaderBuild, "Builder()\n            .w…NFO)\n            .build()");
        this.mAdLoader = interstitialAdLoaderBuild;
        interstitialAdLoaderBuild.loadAd(new InterstitialAdRequest.Builder().withBid(str).withSlotId(configStringValueFromKey).build());
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractAdUnitAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackSuccess() {
        InterstitialSmashListener interstitialSmashListener = this.mSmashListener;
        if (interstitialSmashListener != null) {
            interstitialSmashListener.onInterstitialInitSuccess();
        }
    }

    public final void setInterstitialAd$bigoadapter_release(InterstitialAd ad) {
        k.e(ad, "ad");
        this.mInterstitialAd = ad;
    }

    public final void setInterstitialAdAvailability$bigoadapter_release(boolean z2) {
        this.isInterstitialAdAvailable = z2;
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void showInterstitial(JSONObject config, InterstitialSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
        IronLog.ADAPTER_API.verbose();
        if (!isInterstitialReady(config)) {
            listener.onInterstitialAdShowFailed(ErrorBuilder.buildNoAdsToShowError("Interstitial"));
            return;
        }
        InterstitialAd interstitialAd = this.mInterstitialAd;
        if (interstitialAd != null) {
            interstitialAd.setAdInteractionListener(this.mAdListener);
        }
        InterstitialAd interstitialAd2 = this.mInterstitialAd;
        if (interstitialAd2 != null) {
            interstitialAd2.show();
        }
        setInterstitialAdAvailability$bigoadapter_release(false);
    }
}
