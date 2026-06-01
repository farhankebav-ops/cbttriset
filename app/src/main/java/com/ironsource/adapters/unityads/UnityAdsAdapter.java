package com.ironsource.adapters.unityads;

import android.content.Context;
import android.widget.FrameLayout;
import com.google.mlkit.common.MlKitException;
import com.ironsource.Q6;
import com.ironsource.adapters.pangle.a;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.AdapterUtils;
import com.ironsource.mediationsdk.INetworkInitCallbackListener;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IntegrationData;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.l;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.metadata.MetaData;
import com.ironsource.mediationsdk.metadata.MetaDataUtils;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.unity3d.ads.AdFormat;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.TokenConfiguration;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.ads.metadata.MediationMetaData;
import com.unity3d.ads.metadata.MetaData;
import com.unity3d.ads.metadata.PlayerMetaData;
import com.unity3d.mediation.LevelPlay;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;
import com.vungle.ads.internal.protos.Sdk;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import n6.t;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class UnityAdsAdapter extends AbstractAdapter implements IUnityAdsInitializationListener, INetworkInitCallbackListener {
    private static final String ADAPTER_VERSION_KEY = "adapter_version";
    private static final String CONSENT_CCPA = "privacy.consent";
    private static final String CONSENT_GDPR = "gdpr.consent";
    public static final Companion Companion = new Companion(null);
    private static final String GAME_DESIGNATION = "mode";
    private static final String GAME_ID = "sourceId";
    private static final String GitHash = "b606d6b";
    private static final String LWS_SUPPORT_STATE = "isSupportedLWS";
    private static final String MEDIATION_NAME = "ironSource";
    private static final String MIXED_AUDIENCE = "mixed";
    private static final String PLACEMENT_ID = "zoneId";
    private static final String UADS_INIT_BLOB = "uads_init_blob";
    private static final String UADS_TRAITS = "traits";
    private static final String UNITYADS_COPPA = "user.nonBehavioral";
    private static final String UNITYADS_METADATA_COPPA_KEY = "unityads_coppa";
    private static final String VERSION = "5.2.0";
    private final HashSet<INetworkInitCallbackListener> initCallbackListeners;
    private final ConcurrentHashMap<String, String> interstitialPlacementIdToLoadedAdObjectId;
    private final ConcurrentHashMap<String, BannerView> placementIdToBannerAd;
    private final ConcurrentHashMap<String, UnityAdsBannerAdListener> placementIdToBannerAdListener;
    private final ConcurrentHashMap<String, Boolean> placementIdToInterstitialAdAvailability;
    private final ConcurrentHashMap<String, UnityAdsInterstitialAdListener> placementIdToInterstitialAdListener;
    private final ConcurrentHashMap<String, Boolean> placementIdToRewardedVideoAdAvailability;
    private final ConcurrentHashMap<String, UnityAdsRewardedVideoAdListener> placementIdToRewardedVideoAdListener;
    private final ConcurrentHashMap<String, String> rewardedVideoPlacementIdToLoadedAdObjectId;
    private final Object unityAdsStorageLock;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final String getAdapterSDKVersion() {
            return UnityAds.getVersion();
        }

        public final IntegrationData getIntegrationData(Context context) {
            return new IntegrationData(Q6.G1, "5.2.0");
        }

        public final UnityAdsAdapter startAdapter(String providerName) {
            k.e(providerName, "providerName");
            return new UnityAdsAdapter(providerName);
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnityAdsAdapter(String providerName) {
        super(providerName);
        k.e(providerName, "providerName");
        this.placementIdToRewardedVideoAdListener = new ConcurrentHashMap<>();
        this.rewardedVideoPlacementIdToLoadedAdObjectId = new ConcurrentHashMap<>();
        this.placementIdToRewardedVideoAdAvailability = new ConcurrentHashMap<>();
        this.placementIdToInterstitialAdListener = new ConcurrentHashMap<>();
        this.interstitialPlacementIdToLoadedAdObjectId = new ConcurrentHashMap<>();
        this.placementIdToInterstitialAdAvailability = new ConcurrentHashMap<>();
        this.placementIdToBannerAdListener = new ConcurrentHashMap<>();
        this.placementIdToBannerAd = new ConcurrentHashMap<>();
        this.initCallbackListeners = new HashSet<>();
        this.unityAdsStorageLock = new Object();
    }

    private final void collectBiddingData(AdFormat adFormat, JSONObject jSONObject, BiddingDataCallback biddingDataCallback) {
        UnityAds.getToken(new TokenConfiguration(adFormat, null, 2, 0 == true ? 1 : 0), new a(biddingDataCallback));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void collectBiddingData$lambda$7(BiddingDataCallback biddingDataCallback, String bidToken) {
        k.e(biddingDataCallback, "$biddingDataCallback");
        if (bidToken == null || bidToken.length() == 0) {
            biddingDataCallback.onFailure("Failed to receive token - UnityAds");
            return;
        }
        IronLog.ADAPTER_API.verbose("token = " + bidToken);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        k.d(bidToken, "bidToken");
        linkedHashMap.put("token", bidToken);
        biddingDataCallback.onSuccess(linkedHashMap);
    }

    public static final String getAdapterSDKVersion() {
        return Companion.getAdapterSDKVersion();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final UnityBannerSize getBannerSize(ISBannerSize iSBannerSize, boolean z2) {
        String description = iSBannerSize.getDescription();
        if (description == null) {
            return null;
        }
        switch (description.hashCode()) {
            case -387072689:
                if (description.equals(l.f9206c)) {
                    return new UnityBannerSize(MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE, 250);
                }
                return null;
            case 72205083:
                if (!description.equals(l.f9205b)) {
                    return null;
                }
                break;
            case 79011241:
                if (description.equals(l.e)) {
                    return z2 ? new UnityBannerSize(728, 90) : new UnityBannerSize(Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 50);
                }
                return null;
            case 1951953708:
                if (!description.equals(l.f9204a)) {
                    return null;
                }
                break;
            default:
                return null;
        }
        return new UnityBannerSize(Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 50);
    }

    private final BannerView getBannerView(ISBannerSize iSBannerSize, String str, BannerSmashListener bannerSmashListener) {
        if (this.placementIdToBannerAd.get(str) != null) {
            BannerView bannerView = this.placementIdToBannerAd.get(str);
            if (bannerView != null) {
                bannerView.destroy();
            }
            this.placementIdToBannerAd.remove(str);
        }
        BannerView bannerView2 = new BannerView(ContextProvider.getInstance().getCurrentActiveActivity(), str, getBannerSize(iSBannerSize, AdapterUtils.isLargeScreen(ContextProvider.getInstance().getApplicationContext())));
        UnityAdsBannerAdListener unityAdsBannerAdListener = new UnityAdsBannerAdListener(bannerSmashListener, new WeakReference(this), str);
        this.placementIdToBannerAdListener.put(str, unityAdsBannerAdListener);
        bannerView2.setListener(unityAdsBannerAdListener);
        this.placementIdToBannerAd.put(str, bannerView2);
        return bannerView2;
    }

    public static final IntegrationData getIntegrationData(Context context) {
        return Companion.getIntegrationData(context);
    }

    private final int getUnityAdsInitializationErrorCode(UnityAds.UnityAdsInitializationError unityAdsInitializationError) {
        if (unityAdsInitializationError == null) {
            return 510;
        }
        for (UnityAds.UnityAdsInitializationError unityAdsInitializationError2 : UnityAds.UnityAdsInitializationError.values()) {
            if (t.g0(unityAdsInitializationError2.name(), unityAdsInitializationError.toString())) {
                return UnityAds.UnityAdsInitializationError.valueOf(unityAdsInitializationError.toString()).ordinal();
            }
        }
        return 510;
    }

    private final void initSDK(JSONObject jSONObject) {
        String strOptString = jSONObject.optString(GAME_ID);
        IronLog.ADAPTER_API.verbose("gameId = " + strOptString);
        if (!UnityAds.isInitialized()) {
            this.initCallbackListeners.add(this);
        }
        synchronized (this.unityAdsStorageLock) {
            try {
                MediationMetaData mediationMetaData = new MediationMetaData(ContextProvider.getInstance().getApplicationContext());
                mediationMetaData.setName(MEDIATION_NAME);
                mediationMetaData.setVersion(LevelPlay.getSdkVersion());
                mediationMetaData.set(ADAPTER_VERSION_KEY, "5.2.0");
                if (jSONObject.has(UADS_INIT_BLOB)) {
                    mediationMetaData.set(UADS_INIT_BLOB, jSONObject.optString(UADS_INIT_BLOB));
                }
                if (jSONObject.has("traits")) {
                    mediationMetaData.set("traits", jSONObject.optJSONObject("traits"));
                }
                mediationMetaData.commit();
            } catch (Throwable th) {
                throw th;
            }
        }
        UnityAds.setDebugMode(isAdaptersDebugEnabled());
        UnityAds.initialize(ContextProvider.getInstance().getApplicationContext(), strOptString, false, this);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final boolean isBannerSizeSupported(ISBannerSize iSBannerSize) {
        String description = iSBannerSize.getDescription();
        if (description == null) {
            return false;
        }
        switch (description.hashCode()) {
            case -387072689:
                return description.equals(l.f9206c);
            case 72205083:
                return description.equals(l.f9205b);
            case 79011241:
                return description.equals(l.e);
            case 1951953708:
                return description.equals(l.f9204a);
            default:
                return false;
        }
    }

    private final void setCCPAValue(boolean z2) {
        IronLog.ADAPTER_API.verbose("value = " + z2);
        setUnityAdsMetaData(CONSENT_CCPA, z2 ^ true);
    }

    private final void setCOPPAValue(boolean z2) {
        IronLog.ADAPTER_API.verbose("value = " + z2);
        setUnityAdsMetaData("user.nonBehavioral", z2);
    }

    private final void setUnityAdsMetaData(String str, boolean z2) {
        IronLog.INTERNAL.verbose("key = " + str + ", value = " + z2);
        synchronized (this.unityAdsStorageLock) {
            try {
                MetaData metaData = new MetaData(ContextProvider.getInstance().getApplicationContext());
                metaData.set(str, Boolean.valueOf(z2));
                if (k.a(str, "user.nonBehavioral")) {
                    metaData.set("mode", MIXED_AUDIENCE);
                }
                metaData.commit();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static final UnityAdsAdapter startAdapter(String str) {
        return Companion.startAdapter(str);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void collectBannerBiddingData(JSONObject jSONObject, JSONObject jSONObject2, BiddingDataCallback biddingDataCallback) {
        k.e(biddingDataCallback, "biddingDataCallback");
        collectBiddingData(AdFormat.BANNER, jSONObject, biddingDataCallback);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void collectInterstitialBiddingData(JSONObject jSONObject, JSONObject jSONObject2, BiddingDataCallback biddingDataCallback) {
        k.e(biddingDataCallback, "biddingDataCallback");
        collectBiddingData(AdFormat.INTERSTITIAL, jSONObject, biddingDataCallback);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void collectRewardedVideoBiddingData(JSONObject jSONObject, JSONObject jSONObject2, BiddingDataCallback biddingDataCallback) {
        k.e(biddingDataCallback, "biddingDataCallback");
        collectBiddingData(AdFormat.REWARDED, jSONObject, biddingDataCallback);
    }

    public final FrameLayout.LayoutParams createLayoutParams(UnityBannerSize size) {
        k.e(size, "size");
        return new FrameLayout.LayoutParams(AdapterUtils.dpToPixels(ContextProvider.getInstance().getApplicationContext(), size.getWidth()), -2, 17);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void destroyBanner(JSONObject jSONObject) {
        String strOptString = jSONObject != null ? jSONObject.optString(PLACEMENT_ID) : null;
        com.google.android.gms.ads.internal.client.a.p("placementId = ", strOptString, IronLog.ADAPTER_API);
        if (this.placementIdToBannerAd.get(strOptString) != null) {
            BannerView bannerView = this.placementIdToBannerAd.get(strOptString);
            if (bannerView != null) {
                bannerView.destroy();
            }
            d0.c(this.placementIdToBannerAd).remove(strOptString);
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getCoreSDKVersion() {
        return Companion.getAdapterSDKVersion();
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public LoadWhileShowSupportState getLoadWhileShowSupportState(JSONObject mAdUnitSettings) {
        k.e(mAdUnitSettings, "mAdUnitSettings");
        return !mAdUnitSettings.optBoolean(LWS_SUPPORT_STATE, true) ? LoadWhileShowSupportState.NONE : LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_INSTANCE;
    }

    public final int getUnityAdsLoadErrorCode(UnityAds.UnityAdsLoadError error) {
        k.e(error, "error");
        for (UnityAds.UnityAdsLoadError unityAdsLoadError : UnityAds.UnityAdsLoadError.values()) {
            if (t.g0(unityAdsLoadError.name(), error.toString())) {
                return UnityAds.UnityAdsLoadError.valueOf(error.toString()).ordinal();
            }
        }
        return 510;
    }

    public final int getUnityAdsShowErrorCode(UnityAds.UnityAdsShowError error) {
        k.e(error, "error");
        for (UnityAds.UnityAdsShowError unityAdsShowError : UnityAds.UnityAdsShowError.values()) {
            if (t.g0(unityAdsShowError.name(), error.toString())) {
                return UnityAds.UnityAdsShowError.valueOf(error.toString()).ordinal();
            }
        }
        return 510;
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getVersion() {
        return "5.2.0";
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void initBannerForBidding(String str, String str2, JSONObject jSONObject, BannerSmashListener bannerSmashListener) {
        String strOptString = jSONObject != null ? jSONObject.optString(PLACEMENT_ID) : null;
        String strOptString2 = jSONObject != null ? jSONObject.optString(GAME_ID) : null;
        if (strOptString == null || strOptString.length() == 0) {
            IronLog.ADAPTER_API.error("Missing param - zoneId");
            if (bannerSmashListener != null) {
                bannerSmashListener.onBannerInitFailed(ErrorBuilder.buildInitFailedError("Missing params - zoneId", "Banner"));
                return;
            }
            return;
        }
        if (strOptString2 == null || strOptString2.length() == 0) {
            IronLog.ADAPTER_API.error("Missing param - sourceId");
            if (bannerSmashListener != null) {
                bannerSmashListener.onBannerInitFailed(ErrorBuilder.buildInitFailedError("Missing params - sourceId", "Banner"));
                return;
            }
            return;
        }
        IronLog.ADAPTER_API.verbose("placementId = " + strOptString);
        if (!UnityAds.isInitialized()) {
            initSDK(jSONObject);
        }
        if (bannerSmashListener != null) {
            bannerSmashListener.onBannerInitSuccess();
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void initInterstitialForBidding(String str, String str2, JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        String strOptString = jSONObject != null ? jSONObject.optString(PLACEMENT_ID) : null;
        String strOptString2 = jSONObject != null ? jSONObject.optString(GAME_ID) : null;
        if (strOptString == null || strOptString.length() == 0) {
            IronLog.ADAPTER_API.error("Missing param - zoneId");
            if (interstitialSmashListener != null) {
                interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("Missing params - zoneId", "Interstitial"));
                return;
            }
            return;
        }
        if (strOptString2 == null || strOptString2.length() == 0) {
            IronLog.ADAPTER_API.error("Missing param - sourceId");
            if (interstitialSmashListener != null) {
                interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("Missing params - sourceId", "Interstitial"));
                return;
            }
            return;
        }
        IronLog.ADAPTER_API.verbose("placementId = " + strOptString);
        if (!UnityAds.isInitialized()) {
            initSDK(jSONObject);
        }
        if (interstitialSmashListener != null) {
            interstitialSmashListener.onInterstitialInitSuccess();
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void initRewardedVideoWithCallback(String str, String str2, JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        String strOptString = jSONObject != null ? jSONObject.optString(PLACEMENT_ID) : null;
        String strOptString2 = jSONObject != null ? jSONObject.optString(GAME_ID) : null;
        if (strOptString == null || strOptString.length() == 0) {
            IronLog.ADAPTER_API.error("Missing param - zoneId");
            if (rewardedVideoSmashListener != null) {
                rewardedVideoSmashListener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("Missing params - zoneId", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                return;
            }
            return;
        }
        if (strOptString2 == null || strOptString2.length() == 0) {
            IronLog.ADAPTER_API.error("Missing param - sourceId");
            if (rewardedVideoSmashListener != null) {
                rewardedVideoSmashListener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("Missing params - sourceId", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                return;
            }
            return;
        }
        IronLog.ADAPTER_API.verbose("placementId = " + strOptString);
        if (!UnityAds.isInitialized()) {
            initSDK(jSONObject);
        }
        if (rewardedVideoSmashListener != null) {
            rewardedVideoSmashListener.onRewardedVideoInitSuccess();
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public boolean isInterstitialReady(JSONObject jSONObject) {
        String strOptString = jSONObject != null ? jSONObject.optString(PLACEMENT_ID) : null;
        com.google.android.gms.ads.internal.client.a.p("placementId = ", strOptString, IronLog.ADAPTER_API);
        return strOptString != null && strOptString.length() != 0 && this.placementIdToInterstitialAdAvailability.containsKey(strOptString) && k.a(this.placementIdToInterstitialAdAvailability.get(strOptString), Boolean.TRUE);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public boolean isRewardedVideoAvailable(JSONObject jSONObject) {
        String strOptString = jSONObject != null ? jSONObject.optString(PLACEMENT_ID) : null;
        com.google.android.gms.ads.internal.client.a.p("placementId = ", strOptString, IronLog.ADAPTER_API);
        return strOptString != null && strOptString.length() != 0 && this.placementIdToRewardedVideoAdAvailability.containsKey(strOptString) && k.a(this.placementIdToRewardedVideoAdAvailability.get(strOptString), Boolean.TRUE);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public boolean isUsingActivityBeforeImpression(LevelPlay.AdFormat adFormat) {
        k.e(adFormat, "adFormat");
        return false;
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void loadBannerForBidding(JSONObject jSONObject, JSONObject jSONObject2, String str, ISBannerSize iSBannerSize, BannerSmashListener bannerSmashListener) {
        String strOptString = jSONObject != null ? jSONObject.optString(PLACEMENT_ID) : null;
        if (strOptString == null || strOptString.length() == 0) {
            IronLog.ADAPTER_API.error("Missing param - zoneId");
            if (bannerSmashListener != null) {
                bannerSmashListener.onBannerAdLoadFailed(ErrorBuilder.buildLoadFailedError("Banner", getProviderName(), "Missing params - zoneId"));
                return;
            }
            return;
        }
        if (iSBannerSize == null || !isBannerSizeSupported(iSBannerSize)) {
            IronLog.ADAPTER_API.error("size not supported, size = " + (iSBannerSize != null ? iSBannerSize.getDescription() : null));
            if (bannerSmashListener != null) {
                bannerSmashListener.onBannerAdLoadFailed(ErrorBuilder.unsupportedBannerSize(getProviderName()));
                return;
            }
            return;
        }
        com.google.android.gms.ads.internal.client.a.p("placementId = ", strOptString, IronLog.ADAPTER_API);
        BannerView bannerView = getBannerView(iSBannerSize, strOptString, bannerSmashListener);
        UnityAdsLoadOptions unityAdsLoadOptions = new UnityAdsLoadOptions();
        String string = UUID.randomUUID().toString();
        k.d(string, "randomUUID().toString()");
        unityAdsLoadOptions.setObjectId(string);
        if (str != null && str.length() != 0) {
            unityAdsLoadOptions.setAdMarkup(str);
        }
        bannerView.load(unityAdsLoadOptions);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void loadInterstitialForBidding(JSONObject jSONObject, JSONObject jSONObject2, String str, InterstitialSmashListener interstitialSmashListener) {
        String strOptString = jSONObject != null ? jSONObject.optString(PLACEMENT_ID) : null;
        if (strOptString == null || strOptString.length() == 0) {
            IronLog.ADAPTER_API.error("Missing param - zoneId");
            if (interstitialSmashListener != null) {
                interstitialSmashListener.onInterstitialAdLoadFailed(ErrorBuilder.buildLoadFailedError("Interstitial", getProviderName(), "Missing params - zoneId"));
                return;
            }
            return;
        }
        com.google.android.gms.ads.internal.client.a.p("placementId = ", strOptString, IronLog.ADAPTER_API);
        setInterstitialAdAvailability$unityadsadapter_release(strOptString, false);
        UnityAdsInterstitialAdListener unityAdsInterstitialAdListener = new UnityAdsInterstitialAdListener(interstitialSmashListener, new WeakReference(this), strOptString);
        this.placementIdToInterstitialAdListener.put(strOptString, unityAdsInterstitialAdListener);
        UnityAdsLoadOptions unityAdsLoadOptions = new UnityAdsLoadOptions();
        String string = UUID.randomUUID().toString();
        k.d(string, "randomUUID().toString()");
        unityAdsLoadOptions.setObjectId(string);
        if (str != null && str.length() != 0) {
            unityAdsLoadOptions.setAdMarkup(str);
        }
        this.interstitialPlacementIdToLoadedAdObjectId.put(strOptString, string);
        UnityAds.load(strOptString, unityAdsLoadOptions, unityAdsInterstitialAdListener);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void loadRewardedVideoForBidding(JSONObject jSONObject, JSONObject jSONObject2, String str, RewardedVideoSmashListener rewardedVideoSmashListener) {
        String strOptString = jSONObject != null ? jSONObject.optString(PLACEMENT_ID) : null;
        if (strOptString == null || strOptString.length() == 0) {
            IronLog.ADAPTER_API.error("Missing param - zoneId");
            if (rewardedVideoSmashListener != null) {
                rewardedVideoSmashListener.onRewardedVideoLoadFailed(ErrorBuilder.buildLoadFailedError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT, getProviderName(), "Missing params - zoneId"));
                return;
            }
            return;
        }
        com.google.android.gms.ads.internal.client.a.p("placementId = ", strOptString, IronLog.ADAPTER_API);
        setRewardedVideoAdAvailability$unityadsadapter_release(strOptString, false);
        UnityAdsRewardedVideoAdListener unityAdsRewardedVideoAdListener = new UnityAdsRewardedVideoAdListener(rewardedVideoSmashListener, new WeakReference(this), strOptString);
        this.placementIdToRewardedVideoAdListener.put(strOptString, unityAdsRewardedVideoAdListener);
        UnityAdsLoadOptions unityAdsLoadOptions = new UnityAdsLoadOptions();
        String string = UUID.randomUUID().toString();
        k.d(string, "randomUUID().toString()");
        unityAdsLoadOptions.setObjectId(string);
        if (str != null && str.length() != 0) {
            unityAdsLoadOptions.setAdMarkup(str);
        }
        this.rewardedVideoPlacementIdToLoadedAdObjectId.put(strOptString, string);
        UnityAds.load(strOptString, unityAdsLoadOptions, unityAdsRewardedVideoAdListener);
    }

    @Override // com.unity3d.ads.IUnityAdsInitializationListener
    public void onInitializationComplete() {
        IronLog.ADAPTER_CALLBACK.verbose();
        Iterator<T> it = this.initCallbackListeners.iterator();
        while (it.hasNext()) {
            ((INetworkInitCallbackListener) it.next()).onNetworkInitCallbackSuccess();
        }
        this.initCallbackListeners.clear();
    }

    @Override // com.unity3d.ads.IUnityAdsInitializationListener
    public void onInitializationFailed(UnityAds.UnityAdsInitializationError unityAdsInitializationError, String str) {
        String str2 = getUnityAdsInitializationErrorCode(unityAdsInitializationError) + str;
        com.google.android.gms.ads.internal.client.a.p("initError = ", str2, IronLog.ADAPTER_CALLBACK);
        Iterator<T> it = this.initCallbackListeners.iterator();
        while (it.hasNext()) {
            ((INetworkInitCallbackListener) it.next()).onNetworkInitCallbackFailed(str2);
        }
        this.initCallbackListeners.clear();
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackFailed(String error) {
        k.e(error, "error");
        IronLog.ADAPTER_CALLBACK.verbose();
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose();
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public void setConsent(boolean z2) {
        IronLog.ADAPTER_API.verbose("setConsent = " + z2);
        setUnityAdsMetaData(CONSENT_GDPR, z2);
    }

    public final void setInterstitialAdAvailability$unityadsadapter_release(String placementId, boolean z2) {
        k.e(placementId, "placementId");
        this.placementIdToInterstitialAdAvailability.put(placementId, Boolean.valueOf(z2));
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public void setMetaData(String key, List<String> values) {
        k.e(key, "key");
        k.e(values, "values");
        if (values.isEmpty()) {
            return;
        }
        String str = values.get(0);
        com.google.android.gms.ads.internal.client.a.r("key = ", key, ", value = ", str, IronLog.ADAPTER_API);
        if (MetaDataUtils.isValidCCPAMetaData(key, str)) {
            setCCPAValue(MetaDataUtils.getMetaDataBooleanValue(str));
            return;
        }
        String valueForType = MetaDataUtils.formatValueForType(str, MetaData.MetaDataValueTypes.META_DATA_VALUE_BOOLEAN);
        if (MetaDataUtils.isValidMetaData(key, UNITYADS_METADATA_COPPA_KEY, valueForType)) {
            setCOPPAValue(MetaDataUtils.getMetaDataBooleanValue(valueForType));
        }
    }

    public final void setRewardedVideoAdAvailability$unityadsadapter_release(String placementId, boolean z2) {
        k.e(placementId, "placementId");
        this.placementIdToRewardedVideoAdAvailability.put(placementId, Boolean.valueOf(z2));
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void showInterstitial(JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        String strOptString = jSONObject != null ? jSONObject.optString(PLACEMENT_ID) : null;
        if (strOptString == null || strOptString.length() == 0) {
            IronLog.ADAPTER_API.error("Missing param - zoneId");
            if (interstitialSmashListener != null) {
                interstitialSmashListener.onInterstitialAdShowFailed(ErrorBuilder.buildShowFailedError("Interstitial", "Missing params - zoneId"));
                return;
            }
            return;
        }
        IronLog.ADAPTER_API.verbose("placementId = " + strOptString);
        if (isInterstitialReady(jSONObject)) {
            UnityAdsInterstitialAdListener unityAdsInterstitialAdListener = this.placementIdToInterstitialAdListener.get(strOptString);
            String str = this.interstitialPlacementIdToLoadedAdObjectId.get(strOptString);
            UnityAdsShowOptions unityAdsShowOptions = new UnityAdsShowOptions();
            unityAdsShowOptions.setObjectId(str);
            UnityAds.show(ContextProvider.getInstance().getCurrentActiveActivity(), strOptString, unityAdsShowOptions, unityAdsInterstitialAdListener);
        } else if (interstitialSmashListener != null) {
            interstitialSmashListener.onInterstitialAdShowFailed(ErrorBuilder.buildNoAdsToShowError("Interstitial"));
        }
        setInterstitialAdAvailability$unityadsadapter_release(strOptString, false);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void showRewardedVideo(JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        String strOptString = jSONObject != null ? jSONObject.optString(PLACEMENT_ID) : null;
        if (strOptString == null || strOptString.length() == 0) {
            IronLog.ADAPTER_API.error("Missing param - zoneId");
            if (rewardedVideoSmashListener != null) {
                rewardedVideoSmashListener.onRewardedVideoAdShowFailed(ErrorBuilder.buildShowFailedError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT, "Missing params - zoneId"));
                return;
            }
            return;
        }
        IronLog.ADAPTER_API.verbose("placementId = " + strOptString);
        if (isRewardedVideoAvailable(jSONObject)) {
            String dynamicUserId = getDynamicUserId();
            if (dynamicUserId != null && dynamicUserId.length() != 0) {
                synchronized (this.unityAdsStorageLock) {
                    PlayerMetaData playerMetaData = new PlayerMetaData(ContextProvider.getInstance().getApplicationContext());
                    playerMetaData.setServerId(getDynamicUserId());
                    playerMetaData.commit();
                }
            }
            UnityAdsRewardedVideoAdListener unityAdsRewardedVideoAdListener = this.placementIdToRewardedVideoAdListener.get(strOptString);
            String str = this.rewardedVideoPlacementIdToLoadedAdObjectId.get(strOptString);
            UnityAdsShowOptions unityAdsShowOptions = new UnityAdsShowOptions();
            unityAdsShowOptions.setObjectId(str);
            UnityAds.show(ContextProvider.getInstance().getCurrentActiveActivity(), strOptString, unityAdsShowOptions, unityAdsRewardedVideoAdListener);
        } else if (rewardedVideoSmashListener != null) {
            rewardedVideoSmashListener.onRewardedVideoAdShowFailed(ErrorBuilder.buildNoAdsToShowError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
        }
        setRewardedVideoAdAvailability$unityadsadapter_release(strOptString, false);
    }
}
