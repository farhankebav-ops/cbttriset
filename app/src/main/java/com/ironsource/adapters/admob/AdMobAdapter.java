package com.ironsource.adapters.admob;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.internal.client.a;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.ironsource.adapters.admob.banner.AdMobBannerAdapter;
import com.ironsource.adapters.admob.interstitial.AdMobInterstitialAdapter;
import com.ironsource.adapters.admob.nativead.AdMobNativeAdAdapter;
import com.ironsource.adapters.admob.rewardedvideo.AdMobRewardedVideoAdapter;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.StringUtils;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.AdapterNetworkData;
import com.ironsource.mediationsdk.INetworkInitCallbackListener;
import com.ironsource.mediationsdk.IntegrationData;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.metadata.MetaData;
import com.ironsource.mediationsdk.metadata.MetaDataUtils;
import com.unity3d.mediation.LevelPlay;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class AdMobAdapter extends AbstractAdapter {
    private static final String AD_UNIT_ID = "adUnitId";
    private static final String EMPTY_STRING = "";
    private static final String GitHash = "e5f22ae";
    private static final String NETWORK_DATA_CONTENT_MAPPING = "ContentMapping";
    private static final String NETWORK_DATA_CONTENT_RATING = "MaxAdContentRating";
    private static final String VERSION = "5.2.0";
    private static Boolean mCCPAValue = null;
    private static Boolean mConsent = null;
    private static String mContentMappingURLValue = "";
    private static Integer mCoppaValue = null;
    private static Integer mEuValue = null;
    private static String mRatingValue = "";
    private final String INIT_RESPONSE_REQUIRED;
    private final String NETWORK_ONLY_INIT;
    private final String PLATFORM_NAME;
    private final String REQUEST_AGENT;
    private static List<String> mNeighboringContentMappingURLValue = new ArrayList();
    private static final HashSet<INetworkInitCallbackListener> initCallbackListeners = new HashSet<>();
    public static InitState mInitState = InitState.INIT_STATE_NONE;
    private static final AtomicBoolean mWasInitCalled = new AtomicBoolean(false);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface AdMobMaxContentRating {
        public static final String ADMOB_MAX_AD_CONTENT_RATING_G = "max_ad_content_rating_g";
        public static final String ADMOB_MAX_AD_CONTENT_RATING_MA = "max_ad_content_rating_ma";
        public static final String ADMOB_MAX_AD_CONTENT_RATING_PG = "max_ad_content_rating_pg";
        public static final String ADMOB_MAX_AD_CONTENT_RATING_T = "max_ad_content_rating_t";
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface AdMobMetaDataFlags {
        public static final String ADMOB_CONTENT_MAPPING_KEY = "google_content_mapping";
        public static final String ADMOB_MAX_RATING_KEY = "admob_maxcontentrating";
        public static final String ADMOB_TFCD_KEY = "admob_tfcd";
        public static final String ADMOB_TFUA_KEY = "admob_tfua";
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum InitState {
        INIT_STATE_NONE,
        INIT_STATE_IN_PROGRESS,
        INIT_STATE_SUCCESS,
        INIT_STATE_FAILED
    }

    private AdMobAdapter(String str) {
        super(str);
        this.REQUEST_AGENT = "unity";
        this.PLATFORM_NAME = "unity";
        this.NETWORK_ONLY_INIT = "networkOnlyInit";
        this.INIT_RESPONSE_REQUIRED = "initResponseRequired";
        IronLog.INTERNAL.verbose();
        setRewardedVideoAdapter(new AdMobRewardedVideoAdapter(this));
        setInterstitialAdapter(new AdMobInterstitialAdapter(this));
        setBannerAdapter(new AdMobBannerAdapter(this));
        setNativeAdAdapter(new AdMobNativeAdAdapter(this));
        this.mLWSSupportState = LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_INSTANCE;
    }

    private int getAdMobCoppaValue(String str) {
        return MetaDataUtils.getMetaDataBooleanValue(str) ? 1 : 0;
    }

    private int getAdMobEuValue(String str) {
        return MetaDataUtils.getMetaDataBooleanValue(str) ? 1 : 0;
    }

    private String getAdMobRatingValue(String str) {
        if (TextUtils.isEmpty(str)) {
            IronLog.INTERNAL.error("The ratingValue is null");
            return null;
        }
        str.getClass();
        switch (str) {
            case "max_ad_content_rating_ma":
                return RequestConfiguration.MAX_AD_CONTENT_RATING_MA;
            case "max_ad_content_rating_pg":
                return RequestConfiguration.MAX_AD_CONTENT_RATING_PG;
            case "max_ad_content_rating_g":
                return RequestConfiguration.MAX_AD_CONTENT_RATING_G;
            case "max_ad_content_rating_t":
                return "T";
            default:
                IronLog.INTERNAL.error("The ratingValue = " + str + " is undefine");
                return "";
        }
    }

    public static String getAdapterSDKVersion() {
        return MobileAds.getVersion().toString();
    }

    public static IntegrationData getIntegrationData(Context context) {
        return new IntegrationData("AdMob", "5.2.0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initializationFailure() {
        mInitState = InitState.INIT_STATE_FAILED;
        Iterator<INetworkInitCallbackListener> it = initCallbackListeners.iterator();
        while (it.hasNext()) {
            it.next().onNetworkInitCallbackFailed("AdMob sdk init failed");
        }
        initCallbackListeners.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initializationSuccess() {
        mInitState = InitState.INIT_STATE_SUCCESS;
        Iterator<INetworkInitCallbackListener> it = initCallbackListeners.iterator();
        while (it.hasNext()) {
            it.next().onNetworkInitCallbackSuccess();
        }
        initCallbackListeners.clear();
    }

    public static boolean isNoFillError(int i2) {
        return i2 == 3 || i2 == 9;
    }

    private void processContentMapping(String str) {
        mContentMappingURLValue = str;
        a.t(new StringBuilder("key = ContentMapping, contentMappingValue = "), mContentMappingURLValue, IronLog.ADAPTER_API);
    }

    private void processContentRating(String str) {
        mRatingValue = getAdMobRatingValue(StringUtils.toLowerCase(str));
        a.t(a1.a.y("key = MaxAdContentRating, inputValue = ", str, ", ratingValue = "), mRatingValue, IronLog.ADAPTER_API);
        setRequestConfiguration();
    }

    private void setAdMobMetaDataValue(String str, String str2) {
        String valueForType;
        if (AdMobMetaDataFlags.ADMOB_TFCD_KEY.equals(str) || AdMobMetaDataFlags.ADMOB_TFUA_KEY.equals(str)) {
            valueForType = MetaDataUtils.formatValueForType(str2, MetaData.MetaDataValueTypes.META_DATA_VALUE_BOOLEAN);
            if (TextUtils.isEmpty(valueForType)) {
                a.r("MetaData value for key ", str, " is invalid ", str2, IronLog.ADAPTER_API);
                return;
            }
        } else {
            valueForType = str2;
        }
        str.getClass();
        switch (str) {
            case "google_content_mapping":
                mContentMappingURLValue = str2;
                a.t(a1.a.y("key = ", str, ", contentMappingValue = "), mContentMappingURLValue, IronLog.ADAPTER_API);
                break;
            case "admob_maxcontentrating":
                mRatingValue = getAdMobRatingValue(valueForType);
                a.t(a1.a.y("key = ", str, ", ratingValue = "), mRatingValue, IronLog.ADAPTER_API);
                break;
            case "admob_tfcd":
                mCoppaValue = Integer.valueOf(getAdMobCoppaValue(valueForType));
                IronLog ironLog = IronLog.ADAPTER_API;
                StringBuilder sbY = a1.a.y("key = ", str, ", coppaValue = ");
                sbY.append(mCoppaValue);
                ironLog.verbose(sbY.toString());
                break;
            case "admob_tfua":
                mEuValue = Integer.valueOf(getAdMobEuValue(valueForType));
                IronLog ironLog2 = IronLog.ADAPTER_API;
                StringBuilder sbY2 = a1.a.y("key = ", str, ", euValue = ");
                sbY2.append(mEuValue);
                ironLog2.verbose(sbY2.toString());
                break;
        }
        setRequestConfiguration();
    }

    private void setCCPAValue(boolean z2) {
        IronLog.ADAPTER_API.verbose("value = " + z2);
        mCCPAValue = Boolean.valueOf(z2);
    }

    private void setRequestConfiguration() {
        RequestConfiguration.Builder builder = MobileAds.getRequestConfiguration().toBuilder();
        Integer num = mCoppaValue;
        RequestConfiguration requestConfigurationBuild = num != null ? builder.setTagForChildDirectedTreatment(num.intValue()).build() : null;
        Integer num2 = mEuValue;
        if (num2 != null) {
            requestConfigurationBuild = builder.setTagForUnderAgeOfConsent(num2.intValue()).build();
        }
        if (!TextUtils.isEmpty(mRatingValue)) {
            requestConfigurationBuild = builder.setMaxAdContentRating(mRatingValue).build();
        }
        if (requestConfigurationBuild != null) {
            MobileAds.setRequestConfiguration(requestConfigurationBuild);
        }
    }

    public static AdMobAdapter startAdapter(String str) {
        return new AdMobAdapter(str);
    }

    public void collectBiddingData(final BiddingDataCallback biddingDataCallback, AdFormat adFormat, Bundle bundle) {
        if (mInitState == InitState.INIT_STATE_NONE) {
            IronLog.INTERNAL.verbose("returning null as token since init hasn't started");
            biddingDataCallback.onFailure("returning null as token since init hasn't started - AdMob");
            return;
        }
        Bundle bundleC = androidx.camera.core.processing.util.a.c("query_info_type", "requester_type_2");
        if (bundle != null) {
            bundleC.putAll(bundle);
        }
        IronLog.ADAPTER_API.verbose(adFormat.toString());
        QueryInfo.generate(ContextProvider.getInstance().getApplicationContext(), adFormat, new AdRequest.Builder().setRequestAgent("unity").addNetworkExtrasBundle(com.google.ads.mediation.admob.AdMobAdapter.class, bundleC).build(), new QueryInfoGenerationCallback() { // from class: com.ironsource.adapters.admob.AdMobAdapter.2
            @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
            public void onFailure(@NonNull String str) {
                biddingDataCallback.onFailure("failed to receive token - AdMob " + str);
            }

            @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
            public void onSuccess(@NonNull QueryInfo queryInfo) {
                String query = !TextUtils.isEmpty(queryInfo.getQuery()) ? queryInfo.getQuery() : "";
                String coreSDKVersion = AdMobAdapter.this.getCoreSDKVersion();
                IronLog.ADAPTER_API.verbose("token = " + query + ", sdkVersion = " + coreSDKVersion);
                HashMap map = new HashMap();
                map.put("token", query);
                map.put("sdkVersion", coreSDKVersion);
                biddingDataCallback.onSuccess(map);
            }
        });
    }

    public AdRequest createAdRequest(JSONObject jSONObject, String str) {
        AdRequest.Builder builder = new AdRequest.Builder();
        builder.setRequestAgent("unity");
        if (str != null) {
            builder.setAdString(str);
        }
        Bundle bundleC = androidx.camera.core.processing.util.a.c("platform_name", "unity");
        boolean zOptBoolean = false;
        if (jSONObject != null) {
            String strOptString = jSONObject.optString("requestId", "");
            zOptBoolean = jSONObject.optBoolean("isHybrid", false);
            if (!strOptString.isEmpty()) {
                bundleC.putString("placement_req_id", strOptString);
                IronLog.INTERNAL.verbose("adData requestId = " + strOptString + ", isHybrid = " + zOptBoolean);
            }
        } else {
            IronLog.INTERNAL.verbose("adData is null, using default hybridMode = false");
        }
        bundleC.putString("is_hybrid_setup", String.valueOf(zOptBoolean));
        setRequestConfiguration();
        Boolean bool = mConsent;
        if (bool != null || mCCPAValue != null) {
            if (bool != null && !bool.booleanValue()) {
                IronLog.ADAPTER_API.verbose("mConsent = " + mConsent);
                bundleC.putString("npa", "1");
            }
            if (mCCPAValue != null) {
                IronLog.ADAPTER_API.verbose("mCCPAValue = " + mCCPAValue);
                bundleC.putInt("rdp", mCCPAValue.booleanValue() ? 1 : 0);
            }
        }
        if (!TextUtils.isEmpty(mContentMappingURLValue)) {
            a.t(new StringBuilder("mContentMappingURLValue = "), mContentMappingURLValue, IronLog.ADAPTER_API);
            builder.setContentUrl(mContentMappingURLValue);
        }
        if (!mNeighboringContentMappingURLValue.isEmpty()) {
            IronLog.ADAPTER_API.verbose("mNeighboringContentMappingURLValue = " + mNeighboringContentMappingURLValue);
            builder.setNeighboringContentUrls(mNeighboringContentMappingURLValue);
        }
        builder.addNetworkExtrasBundle(com.google.ads.mediation.admob.AdMobAdapter.class, bundleC);
        return builder.build();
    }

    public String getAdUnitIdKey() {
        return "adUnitId";
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getCoreSDKVersion() {
        return getAdapterSDKVersion();
    }

    public InitState getInitState() {
        return mInitState;
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getVersion() {
        return "5.2.0";
    }

    public void initSDK(JSONObject jSONObject) {
        if (mInitState == InitState.INIT_STATE_NONE || mInitState == InitState.INIT_STATE_IN_PROGRESS) {
            initCallbackListeners.add(this);
        }
        if (mWasInitCalled.compareAndSet(false, true)) {
            mInitState = InitState.INIT_STATE_IN_PROGRESS;
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose();
            if (jSONObject.optBoolean("networkOnlyInit", true)) {
                ironLog.verbose("disableMediationAdapterInitialization");
                MobileAds.disableMediationAdapterInitialization(ContextProvider.getInstance().getApplicationContext());
            }
            if (jSONObject.optBoolean("initResponseRequired", false)) {
                ironLog.verbose("init and wait for callback");
                MobileAds.initialize(ContextProvider.getInstance().getApplicationContext(), new OnInitializationCompleteListener() { // from class: com.ironsource.adapters.admob.AdMobAdapter.1
                    @Override // com.google.android.gms.ads.initialization.OnInitializationCompleteListener
                    public void onInitializationComplete(InitializationStatus initializationStatus) {
                        AdapterStatus adapterStatus = initializationStatus.getAdapterStatusMap().get("com.google.android.gms.ads.MobileAds");
                        if ((adapterStatus != null ? adapterStatus.getInitializationState() : null) == AdapterStatus.State.READY) {
                            IronLog.ADAPTER_API.verbose("initializationStatus = READY");
                            AdMobAdapter.this.initializationSuccess();
                        } else {
                            IronLog.ADAPTER_API.verbose("initializationStatus = NOT READY");
                            AdMobAdapter.this.initializationFailure();
                        }
                    }
                });
            } else {
                ironLog.verbose("init without callback");
                MobileAds.initialize(ContextProvider.getInstance().getApplicationContext());
                initializationSuccess();
            }
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public boolean isUsingActivityBeforeImpression(LevelPlay.AdFormat adFormat) {
        return false;
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public void setConsent(boolean z2) {
        IronLog.ADAPTER_API.verbose("consent = " + z2);
        mConsent = Boolean.valueOf(z2);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public void setMetaData(String str, List<String> list) {
        if (list.isEmpty()) {
            return;
        }
        if (list.size() <= 1 || !str.equalsIgnoreCase(AdMobMetaDataFlags.ADMOB_CONTENT_MAPPING_KEY)) {
            String str2 = list.get(0);
            a.r("key = ", str, ", value = ", str2, IronLog.ADAPTER_API);
            if (MetaDataUtils.isValidCCPAMetaData(str, str2)) {
                setCCPAValue(MetaDataUtils.getMetaDataBooleanValue(str2));
                return;
            } else {
                setAdMobMetaDataValue(StringUtils.toLowerCase(str), StringUtils.toLowerCase(str2));
                return;
            }
        }
        mNeighboringContentMappingURLValue = list;
        IronLog.ADAPTER_API.verbose("key = " + str + ", values = " + list);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNetworkDataInterface
    public void setNetworkData(@NonNull AdapterNetworkData adapterNetworkData) {
        adapterNetworkData.allData();
        String str = (String) adapterNetworkData.dataByKeyIgnoreCase(NETWORK_DATA_CONTENT_MAPPING, String.class);
        if (str != null) {
            processContentMapping(str);
        }
        JSONArray jSONArray = (JSONArray) adapterNetworkData.dataByKeyIgnoreCase(NETWORK_DATA_CONTENT_MAPPING, JSONArray.class);
        if (jSONArray != null) {
            processContentMapping(jSONArray);
        }
        String str2 = (String) adapterNetworkData.dataByKeyIgnoreCase(NETWORK_DATA_CONTENT_RATING, String.class);
        if (str2 != null) {
            processContentRating(str2);
        }
    }

    private void processContentMapping(JSONArray jSONArray) {
        mNeighboringContentMappingURLValue.clear();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            mNeighboringContentMappingURLValue.add(jSONArray.optString(i2));
        }
        IronLog.ADAPTER_API.verbose("key = ContentMapping, contentMappingValues = " + mNeighboringContentMappingURLValue.toString());
    }
}
