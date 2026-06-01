package com.ironsource.adapters.facebook;

import a1.a;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.BidderTokenProvider;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.internal.settings.AdSdkVersion;
import com.ironsource.adapters.facebook.banner.FacebookBannerAdapter;
import com.ironsource.adapters.facebook.interstitial.FacebookInterstitialAdapter;
import com.ironsource.adapters.facebook.nativead.FacebookNativeAdAdapter;
import com.ironsource.adapters.facebook.rewardedvideo.FacebookRewardedVideoAdapter;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.StringUtils;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.AdapterNetworkData;
import com.ironsource.mediationsdk.INetworkInitCallbackListener;
import com.ironsource.mediationsdk.IntegrationData;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.metadata.MetaData;
import com.ironsource.mediationsdk.metadata.MetaDataUtils;
import com.unity3d.mediation.LevelPlay;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class FacebookAdapter extends AbstractAdapter implements AudienceNetworkAds.InitListener {
    private static final String GitHash = "9f697d2";
    private static final String MEDIATION_NAME = "ironSource";
    protected static final String META_NETWORK_NAME = "Facebook";
    private static final String NETWORK_DATA_CACHE_FLAG = "CacheFlag";
    private static final String VERSION = "5.0.0";
    protected final String ALL_PLACEMENT_IDS;
    protected final String FACEBOOK_INTERSTITIAL_CACHE_FLAG;
    protected final String META_INTERSTITIAL_CACHE_FLAG;
    protected final String META_MIXED_AUDIENCE;
    protected final String PLACEMENT_ID;
    protected static EnumSet<CacheFlag> mInterstitialFacebookCacheFlags = EnumSet.allOf(CacheFlag.class);
    protected static HashSet<INetworkInitCallbackListener> initCallbackListeners = new HashSet<>();
    protected static InitState mInitState = InitState.INIT_STATE_NONE;
    protected static AtomicBoolean mWasInitCalled = new AtomicBoolean(false);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum InitState {
        INIT_STATE_NONE,
        INIT_STATE_IN_PROGRESS,
        INIT_STATE_SUCCESS,
        INIT_STATE_FAILED
    }

    private FacebookAdapter(String str) {
        super(str);
        this.PLACEMENT_ID = "placementId";
        this.ALL_PLACEMENT_IDS = "placementIds";
        this.FACEBOOK_INTERSTITIAL_CACHE_FLAG = "facebook_is_cacheflag";
        this.META_INTERSTITIAL_CACHE_FLAG = "meta_is_cacheflag";
        this.META_MIXED_AUDIENCE = "meta_mixed_audience";
        IronLog.INTERNAL.verbose();
        setRewardedVideoAdapter(new FacebookRewardedVideoAdapter(this));
        setInterstitialAdapter(new FacebookInterstitialAdapter(this));
        setBannerAdapter(new FacebookBannerAdapter(this));
        setNativeAdAdapter(new FacebookNativeAdAdapter(this));
        this.mLWSSupportState = LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_INSTANCE;
    }

    public static String getAdapterSDKVersion() {
        return AdSdkVersion.BUILD;
    }

    private EnumSet<CacheFlag> getFacebookAllCacheFlags() {
        IronLog.ADAPTER_API.verbose();
        return EnumSet.allOf(CacheFlag.class);
    }

    private CacheFlag getFacebookCacheFlag(String str) {
        IronLog.ADAPTER_API.verbose("value = " + str);
        return CacheFlag.valueOf(StringUtils.toUpperCase(str));
    }

    public static IntegrationData getIntegrationData(Context context) {
        return new IntegrationData(META_NETWORK_NAME, "5.0.0");
    }

    private String getMediationServiceInfo() {
        String strM = a.m("ironSource_", LevelPlay.getSdkVersion(), ":5.0.0");
        IronLog.INTERNAL.verbose("mediationServiceInfo = ".concat(strM));
        return strM;
    }

    public static boolean isNoFillError(AdError adError) {
        return adError.getErrorCode() == 1001;
    }

    private boolean isValidMixedAudienceMetaData(String str) {
        return !TextUtils.isEmpty(str);
    }

    private void processCacheFlags(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            arrayList.add(jSONArray.optString(i2));
        }
        processCacheFlags(NETWORK_DATA_CACHE_FLAG, arrayList);
    }

    private void setMixedAudience(boolean z2) {
        IronLog.ADAPTER_API.verbose("isMixedAudience = " + z2);
        AdSettings.setMixedAudience(z2);
    }

    public static FacebookAdapter startAdapter(String str) {
        return new FacebookAdapter(str);
    }

    @NonNull
    public String getAllPlacementIdsKey() {
        return "placementIds";
    }

    public Map<String, Object> getBiddingData() {
        if (mInitState == InitState.INIT_STATE_FAILED) {
            IronLog.INTERNAL.verbose("returning null as token since init failed");
            return null;
        }
        String bidderToken = BidderTokenProvider.getBidderToken(ContextProvider.getInstance().getApplicationContext());
        if (TextUtils.isEmpty(bidderToken)) {
            bidderToken = "";
        }
        IronLog.ADAPTER_API.verbose("token = " + bidderToken);
        HashMap map = new HashMap();
        map.put("token", bidderToken);
        return map;
    }

    public EnumSet<CacheFlag> getCacheFlags() {
        return mInterstitialFacebookCacheFlags;
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getCoreSDKVersion() {
        return getAdapterSDKVersion();
    }

    public InitState getInitState() {
        return mInitState;
    }

    public String getPlacementIdKey() {
        return "placementId";
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getVersion() {
        return "5.0.0";
    }

    public void initSDK(String str) {
        if (mInitState == InitState.INIT_STATE_NONE || mInitState == InitState.INIT_STATE_IN_PROGRESS) {
            initCallbackListeners.add(this);
        }
        if (mWasInitCalled.compareAndSet(false, true)) {
            List<String> listAsList = Arrays.asList(str.split(","));
            IronLog.ADAPTER_API.verbose("Initialize Meta with placement ids = " + listAsList.toString());
            AudienceNetworkAds.buildInitSettings(ContextProvider.getInstance().getApplicationContext()).withInitListener(this).withMediationService(getMediationServiceInfo()).withPlacementIds(listAsList).initialize();
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public boolean isUsingActivityBeforeImpression(LevelPlay.AdFormat adFormat) {
        return false;
    }

    @Override // com.facebook.ads.AudienceNetworkAds.InitListener
    public void onInitialized(AudienceNetworkAds.InitResult initResult) {
        IronLog.ADAPTER_CALLBACK.verbose("init SDK is completed with status: " + initResult.isSuccess() + ", " + initResult.getMessage());
        if (initResult.isSuccess()) {
            mInitState = InitState.INIT_STATE_SUCCESS;
            Iterator<INetworkInitCallbackListener> it = initCallbackListeners.iterator();
            while (it.hasNext()) {
                it.next().onNetworkInitCallbackSuccess();
            }
        } else {
            mInitState = InitState.INIT_STATE_FAILED;
            Iterator<INetworkInitCallbackListener> it2 = initCallbackListeners.iterator();
            while (it2.hasNext()) {
                it2.next().onNetworkInitCallbackFailed(initResult.getMessage());
            }
        }
        initCallbackListeners.clear();
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public void setMetaData(String str, List<String> list) {
        if (list.isEmpty()) {
            return;
        }
        String lowerCase = StringUtils.toLowerCase(str);
        lowerCase.getClass();
        switch (lowerCase) {
            case "meta_mixed_audience":
                String str2 = list.get(0);
                com.google.android.gms.ads.internal.client.a.r("key = ", str, ", value = ", str2, IronLog.ADAPTER_API);
                String valueForType = MetaDataUtils.formatValueForType(str2, MetaData.MetaDataValueTypes.META_DATA_VALUE_BOOLEAN);
                if (isValidMixedAudienceMetaData(valueForType)) {
                    setMixedAudience(MetaDataUtils.getMetaDataBooleanValue(valueForType));
                    break;
                }
                break;
            case "meta_is_cacheflag":
            case "facebook_is_cacheflag":
                processCacheFlags(str, list);
                break;
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNetworkDataInterface
    public void setNetworkData(@NonNull AdapterNetworkData adapterNetworkData) {
        JSONArray jSONArray = (JSONArray) adapterNetworkData.dataByKeyIgnoreCase(NETWORK_DATA_CACHE_FLAG, JSONArray.class);
        if (jSONArray != null) {
            processCacheFlags(jSONArray);
        }
    }

    private void processCacheFlags(String str, List<String> list) {
        IronLog.ADAPTER_API.verbose("key = " + str + ", values = " + list);
        mInterstitialFacebookCacheFlags.clear();
        try {
            for (String str2 : list) {
                CacheFlag facebookCacheFlag = getFacebookCacheFlag(str2);
                IronLog.ADAPTER_API.verbose("flag for value " + str2 + " is " + facebookCacheFlag.name());
                mInterstitialFacebookCacheFlags.add(facebookCacheFlag);
            }
        } catch (Exception unused) {
            IronLog.INTERNAL.error("flag is unknown or all, set all as default");
            mInterstitialFacebookCacheFlags = getFacebookAllCacheFlags();
        }
        IronLog.ADAPTER_API.verbose("all flags:" + mInterstitialFacebookCacheFlags.toString());
    }
}
