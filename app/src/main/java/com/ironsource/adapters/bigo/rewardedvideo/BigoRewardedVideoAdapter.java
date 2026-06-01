package com.ironsource.adapters.bigo.rewardedvideo;

import com.google.android.gms.ads.internal.client.a;
import com.ironsource.adapters.bigo.BigoAdapter;
import com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.k;
import org.json.JSONObject;
import sg.bigo.ads.api.AdLoadListener;
import sg.bigo.ads.api.RewardAdInteractionListener;
import sg.bigo.ads.api.RewardVideoAd;
import sg.bigo.ads.api.RewardVideoAdLoader;
import sg.bigo.ads.api.RewardVideoAdRequest;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class BigoRewardedVideoAdapter extends AbstractRewardedVideoAdapter<BigoAdapter> {
    private boolean isRewardedVideoAdAvailable;
    private BigoRewardedVideoAdListener mAdListener;
    private RewardVideoAdLoader mAdLoader;
    private RewardVideoAd mRewardedAd;
    private RewardedVideoSmashListener mSmashListener;

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
    public BigoRewardedVideoAdapter(BigoAdapter adapter) {
        super(adapter);
        k.e(adapter, "adapter");
    }

    public final void destroyRewardedVideoAd$bigoadapter_release() {
        RewardVideoAd rewardVideoAd = this.mRewardedAd;
        if (rewardVideoAd != null) {
            rewardVideoAd.setAdInteractionListener((RewardAdInteractionListener) null);
        }
        RewardVideoAd rewardVideoAd2 = this.mRewardedAd;
        if (rewardVideoAd2 != null) {
            rewardVideoAd2.destroy();
        }
        this.mAdLoader = null;
        this.mRewardedAd = null;
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public Map<String, Object> getRewardedVideoBiddingData(JSONObject config, JSONObject jSONObject) {
        k.e(config, "config");
        return getAdapter().getBiddingData$bigoadapter_release();
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void initRewardedVideoWithCallback(String str, String str2, JSONObject config, RewardedVideoSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
        String configStringValueFromKey = getConfigStringValueFromKey(config, BigoAdapter.Companion.getAppIdKey());
        if (configStringValueFromKey.length() == 0) {
            IronLog.INTERNAL.error(getAdUnitIdMissingErrorString(configStringValueFromKey));
            listener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError(getAdUnitIdMissingErrorString(configStringValueFromKey), IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            return;
        }
        a.p("appId = ", configStringValueFromKey, IronLog.ADAPTER_API);
        this.mSmashListener = listener;
        int i2 = WhenMappings.$EnumSwitchMapping$0[getAdapter().getInitState().ordinal()];
        if (i2 == 1) {
            listener.onRewardedVideoInitSuccess();
        } else if (i2 == 2 || i2 == 3) {
            getAdapter().initSdk(configStringValueFromKey);
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public boolean isRewardedVideoAvailable(JSONObject config) {
        k.e(config, "config");
        RewardVideoAd rewardVideoAd = this.mRewardedAd;
        return (rewardVideoAd == null || rewardVideoAd.isExpired()) ? false : true;
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void loadRewardedVideoForBidding(JSONObject config, JSONObject jSONObject, String str, RewardedVideoSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
        IronLog.ADAPTER_API.verbose();
        if (str == null || str.length() == 0) {
            IronLog.INTERNAL.error("serverData is empty");
            listener.onRewardedVideoLoadFailed(ErrorBuilder.buildLoadFailedError("serverData is empty"));
            return;
        }
        setRewardedVideoAdAvailability$bigoadapter_release(false);
        BigoAdapter.Companion companion = BigoAdapter.Companion;
        String configStringValueFromKey = getConfigStringValueFromKey(config, companion.getSlotIdKey());
        this.mAdListener = new BigoRewardedVideoAdListener(new WeakReference(this), listener);
        RewardVideoAdLoader rewardVideoAdLoaderBuild = new RewardVideoAdLoader.Builder().withAdLoadListener((AdLoadListener<RewardVideoAd>) this.mAdListener).withExt(companion.getMEDIATION_INFO()).build();
        k.d(rewardVideoAdLoaderBuild, "Builder()\n            .w…NFO)\n            .build()");
        this.mAdLoader = rewardVideoAdLoaderBuild;
        rewardVideoAdLoaderBuild.loadAd(new RewardVideoAdRequest.Builder().withBid(str).withSlotId(configStringValueFromKey).build());
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractAdUnitAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackSuccess() {
        RewardedVideoSmashListener rewardedVideoSmashListener = this.mSmashListener;
        if (rewardedVideoSmashListener != null) {
            rewardedVideoSmashListener.onRewardedVideoInitSuccess();
        }
    }

    public final void setRewardedVideoAd$bigoadapter_release(RewardVideoAd ad) {
        k.e(ad, "ad");
        this.mRewardedAd = ad;
    }

    public final void setRewardedVideoAdAvailability$bigoadapter_release(boolean z2) {
        this.isRewardedVideoAdAvailable = z2;
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void showRewardedVideo(JSONObject config, RewardedVideoSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
        IronLog.ADAPTER_API.verbose();
        if (!isRewardedVideoAvailable(config)) {
            listener.onRewardedVideoAdShowFailed(ErrorBuilder.buildNoAdsToShowError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            return;
        }
        RewardVideoAd rewardVideoAd = this.mRewardedAd;
        if (rewardVideoAd != null) {
            rewardVideoAd.setAdInteractionListener((RewardAdInteractionListener) this.mAdListener);
        }
        RewardVideoAd rewardVideoAd2 = this.mRewardedAd;
        if (rewardVideoAd2 != null) {
            rewardVideoAd2.show();
        }
        setRewardedVideoAdAvailability$bigoadapter_release(false);
    }
}
