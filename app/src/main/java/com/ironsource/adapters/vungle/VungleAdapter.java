package com.ironsource.adapters.vungle;

import android.content.Context;
import com.google.android.gms.ads.internal.client.a;
import com.ironsource.adapters.vungle.banner.VungleBannerAdapter;
import com.ironsource.adapters.vungle.interstitial.VungleInterstitialAdapter;
import com.ironsource.adapters.vungle.rewardedvideo.VungleRewardedVideoAdapter;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.INetworkInitCallbackListener;
import com.ironsource.mediationsdk.IntegrationData;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.metadata.MetaData;
import com.ironsource.mediationsdk.metadata.MetaDataUtils;
import com.unity3d.mediation.LevelPlay;
import com.vungle.ads.BidTokenCallback;
import com.vungle.ads.VungleAds;
import com.vungle.ads.VunglePrivacySettings;
import com.vungle.ads.VungleWrapperFramework;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class VungleAdapter extends AbstractAdapter implements INetworkInitCallbackListener {
    public static final String APP_ID = "AppID";
    public static final String CREATIVE_ID_KEY = "creativeId";
    private static final String GitHash = "ad53ae3";
    private static final String META_DATA_VUNGLE_CONSENT_MESSAGE_VERSION = "1.0.0";
    private static final String META_DATA_VUNGLE_COPPA_KEY = "Vungle_COPPA";
    public static final String PLACEMENT_ID = "PlacementId";
    private static final String VERSION = "5.1.0";
    private static final String VUNGLE_KEYWORD = "Vungle";
    public static final Companion Companion = new Companion(null);
    private static AtomicBoolean isInitiated = new AtomicBoolean(false);
    private static Companion.InitState mInitState = Companion.InitState.INIT_STATE_NONE;
    private static final HashSet<INetworkInitCallbackListener> initCallbackListeners = new HashSet<>();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public enum InitState {
            INIT_STATE_NONE,
            INIT_STATE_IN_PROGRESS,
            INIT_STATE_SUCCESS,
            INIT_STATE_FAILED
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final String getAdapterSDKVersion() {
            return VungleAds.Companion.getSdkVersion();
        }

        public final HashSet<INetworkInitCallbackListener> getInitCallbackListeners$vungleadapter_release() {
            return VungleAdapter.initCallbackListeners;
        }

        public final IntegrationData getIntegrationData(Context context) {
            k.e(context, "context");
            return new IntegrationData("Vungle", "5.1.0");
        }

        public final InitState getMInitState$vungleadapter_release() {
            return VungleAdapter.mInitState;
        }

        public final void setMInitState$vungleadapter_release(InitState initState) {
            k.e(initState, "<set-?>");
            VungleAdapter.mInitState = initState;
        }

        public final VungleAdapter startAdapter(String providerName) {
            k.e(providerName, "providerName");
            return new VungleAdapter(providerName);
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VungleAdapter(String providerName) {
        super(providerName);
        k.e(providerName, "providerName");
        setRewardedVideoAdapter(new VungleRewardedVideoAdapter(this));
        setInterstitialAdapter(new VungleInterstitialAdapter(this));
        setBannerAdapter(new VungleBannerAdapter(this));
        this.mLWSSupportState = LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_INSTANCE;
    }

    public static final String getAdapterSDKVersion() {
        return Companion.getAdapterSDKVersion();
    }

    public static final IntegrationData getIntegrationData(Context context) {
        return Companion.getIntegrationData(context);
    }

    private final void setCCPAValue(boolean z2) {
        boolean z7 = !z2;
        IronLog.ADAPTER_API.verbose("ccpa = " + z7);
        VunglePrivacySettings.setCCPAStatus(z7);
    }

    private final void setCOPPAValue(boolean z2) {
        IronLog.ADAPTER_API.verbose("coppa = " + z2);
        VunglePrivacySettings.setCOPPAStatus(z2);
    }

    public static final VungleAdapter startAdapter(String str) {
        return Companion.startAdapter(str);
    }

    public final void collectBiddingData(final BiddingDataCallback biddingDataCallback) {
        k.e(biddingDataCallback, "biddingDataCallback");
        VungleAds.Companion companion = VungleAds.Companion;
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        k.d(applicationContext, "getInstance().applicationContext");
        companion.getBiddingToken(applicationContext, new BidTokenCallback() { // from class: com.ironsource.adapters.vungle.VungleAdapter.collectBiddingData.1
            @Override // com.vungle.ads.BidTokenCallback
            public void onBidTokenCollected(String bidToken) {
                k.e(bidToken, "bidToken");
                HashMap map = new HashMap();
                String coreSDKVersion = VungleAdapter.this.getCoreSDKVersion();
                a.r("sdkVersion = ", coreSDKVersion, ", token = ", bidToken, IronLog.ADAPTER_API);
                map.put("sdkVersion", coreSDKVersion);
                map.put("token", bidToken);
                biddingDataCallback.onSuccess(map);
            }

            @Override // com.vungle.ads.BidTokenCallback
            public void onBidTokenError(String errorMessage) {
                k.e(errorMessage, "errorMessage");
                biddingDataCallback.onFailure("failed to receive token - Vungle , error = ".concat(errorMessage));
            }
        });
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getCoreSDKVersion() {
        return Companion.getAdapterSDKVersion();
    }

    public final Companion.InitState getInitState() {
        return mInitState;
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getVersion() {
        return "5.1.0";
    }

    public final void initSDK(Context context, String appID) {
        k.e(context, "context");
        k.e(appID, "appID");
        if (mInitState == Companion.InitState.INIT_STATE_NONE || mInitState == Companion.InitState.INIT_STATE_IN_PROGRESS) {
            initCallbackListeners.add(this);
        }
        if (isInitiated.compareAndSet(false, true)) {
            IronLog.ADAPTER_API.verbose("appId = ".concat(appID));
            mInitState = Companion.InitState.INIT_STATE_IN_PROGRESS;
            VungleAds.Companion companion = VungleAds.Companion;
            companion.setIntegrationName(VungleWrapperFramework.ironsource, "5.1.0");
            companion.init(context, appID, new VungleInitListener());
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public boolean isUsingActivityBeforeImpression(LevelPlay.AdFormat adFormat) {
        k.e(adFormat, "adFormat");
        return false;
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public void setConsent(boolean z2) {
        IronLog.ADAPTER_API.verbose("gdpr = " + z2);
        VunglePrivacySettings.setGDPRStatus(z2, "1.0.0");
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public void setMetaData(String key, List<String> values) {
        k.e(key, "key");
        k.e(values, "values");
        if (values.isEmpty()) {
            return;
        }
        String str = values.get(0);
        a.r("key = ", key, ", value = ", str, IronLog.ADAPTER_API);
        String valueForType = MetaDataUtils.formatValueForType(str, MetaData.MetaDataValueTypes.META_DATA_VALUE_BOOLEAN);
        k.d(valueForType, "formatValueForType(\n    …A_VALUE_BOOLEAN\n        )");
        if (MetaDataUtils.isValidCCPAMetaData(key, str)) {
            setCCPAValue(MetaDataUtils.getMetaDataBooleanValue(str));
        } else if (MetaDataUtils.isValidMetaData(key, META_DATA_VUNGLE_COPPA_KEY, valueForType)) {
            setCOPPAValue(MetaDataUtils.getMetaDataBooleanValue(valueForType));
        }
    }
}
