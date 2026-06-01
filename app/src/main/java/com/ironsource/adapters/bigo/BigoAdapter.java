package com.ironsource.adapters.bigo;

import android.content.Context;
import com.google.android.gms.ads.internal.client.a;
import com.ironsource.Df;
import com.ironsource.adapters.bigo.banner.BigoBannerAdapter;
import com.ironsource.adapters.bigo.interstitial.BigoInterstitialAdapter;
import com.ironsource.adapters.bigo.rewardedvideo.BigoRewardedVideoAdapter;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.INetworkInitCallbackListener;
import com.ironsource.mediationsdk.IntegrationData;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.metadata.MetaData;
import com.ironsource.mediationsdk.metadata.MetaDataUtils;
import com.unity3d.mediation.LevelPlay;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import org.json.JSONObject;
import sg.bigo.ads.BigoAdSdk;
import sg.bigo.ads.ConsentOptions;
import sg.bigo.ads.api.AdConfig;
import sg.bigo.ads.api.AdError;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class BigoAdapter extends AbstractAdapter implements INetworkInitCallbackListener, BigoAdSdk.InitListener {
    private static final String APP_ID = "appId";
    public static final Companion Companion = new Companion(null);
    private static final String GitHash = "9f697d2";
    private static final String MEDIATION_INFO;
    private static final String META_DATA_BIGO_COPPA_KEY = "LevelPlay_ChildDirected";
    private static final String NETWORK_NAME = "Bigo";
    public static final String SLOT_ID = "slotId";
    private static final String VERSION = "5.0.0";
    private static final HashSet<INetworkInitCallbackListener> initCallbackListeners;
    private static Companion.InitState mInitState;
    private static final AtomicBoolean mWasInitCalled;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public enum InitState {
            INIT_STATE_NONE,
            INIT_STATE_IN_PROGRESS,
            INIT_STATE_SUCCESS
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final String getAdapterSDKVersion() {
            String sDKVersionName = BigoAdSdk.getSDKVersionName();
            k.d(sDKVersionName, "getSDKVersionName()");
            return sDKVersionName;
        }

        public final String getAppIdKey() {
            return "appId";
        }

        public final IntegrationData getIntegrationData(Context context) {
            return new IntegrationData(BigoAdapter.NETWORK_NAME, "5.0.0");
        }

        public final IronSourceError getLoadError(AdError error) {
            k.e(error, "error");
            return new IronSourceError(error.getCode(), error.getMessage());
        }

        public final String getMEDIATION_INFO() {
            return BigoAdapter.MEDIATION_INFO;
        }

        public final String getSlotIdKey() {
            return BigoAdapter.SLOT_ID;
        }

        public final BigoAdapter startAdapter(String providerName) {
            k.e(providerName, "providerName");
            return new BigoAdapter(providerName);
        }

        private Companion() {
        }
    }

    static {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("mediationName", "LevelPlay");
            jSONObject.putOpt("mediationVersion", LevelPlay.getSdkVersion());
            jSONObject.putOpt(Df.f6629b, "5.0.0");
        } catch (Throwable th) {
            IronLog.INTERNAL.error("Error creating mediation info JSON in BigoAdapter " + th);
        }
        String string = jSONObject.toString();
        k.d(string, "mediationInfoJSON.toString()");
        MEDIATION_INFO = string;
        mWasInitCalled = new AtomicBoolean(false);
        mInitState = Companion.InitState.INIT_STATE_NONE;
        initCallbackListeners = new HashSet<>();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BigoAdapter(String providerName) {
        super(providerName);
        k.e(providerName, "providerName");
        setRewardedVideoAdapter(new BigoRewardedVideoAdapter(this));
        setInterstitialAdapter(new BigoInterstitialAdapter(this));
        setBannerAdapter(new BigoBannerAdapter(this));
        this.mLWSSupportState = LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_INSTANCE;
    }

    public static final String getAdapterSDKVersion() {
        return Companion.getAdapterSDKVersion();
    }

    public static final IntegrationData getIntegrationData(Context context) {
        return Companion.getIntegrationData(context);
    }

    private final void initializationSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose();
        mInitState = Companion.InitState.INIT_STATE_SUCCESS;
        for (INetworkInitCallbackListener initCallbackListeners2 : initCallbackListeners) {
            k.d(initCallbackListeners2, "initCallbackListeners");
            initCallbackListeners2.onNetworkInitCallbackSuccess();
        }
        initCallbackListeners.clear();
    }

    private final void setCCPAValue(boolean z2) {
        IronLog.ADAPTER_API.verbose("ccpa = " + z2);
        BigoAdSdk.setUserConsent(ContextProvider.getInstance().getApplicationContext(), ConsentOptions.CCPA, z2 ^ true);
    }

    private final void setCOPPAValue(boolean z2) {
        IronLog.ADAPTER_API.verbose("isCoppa = " + z2);
        BigoAdSdk.setUserConsent(ContextProvider.getInstance().getApplicationContext(), ConsentOptions.COPPA, z2 ^ true);
    }

    public static final BigoAdapter startAdapter(String str) {
        return Companion.startAdapter(str);
    }

    public final Map<String, Object> getBiddingData$bigoadapter_release() {
        if (mInitState != Companion.InitState.INIT_STATE_SUCCESS) {
            IronLog.INTERNAL.error("returning nil as token since init isn't completed");
            return null;
        }
        HashMap map = new HashMap();
        String bidderToken = BigoAdSdk.getBidderToken();
        a.p("token = ", bidderToken, IronLog.ADAPTER_API);
        map.put("token", bidderToken);
        return map;
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
        return "5.0.0";
    }

    public final void initSdk(String appId) {
        k.e(appId, "appId");
        if (mInitState == Companion.InitState.INIT_STATE_NONE || mInitState == Companion.InitState.INIT_STATE_IN_PROGRESS) {
            initCallbackListeners.add(this);
        }
        if (mWasInitCalled.compareAndSet(false, true)) {
            mInitState = Companion.InitState.INIT_STATE_IN_PROGRESS;
            IronLog.ADAPTER_API.verbose("appId = ".concat(appId));
        }
        BigoAdSdk.initialize(ContextProvider.getInstance().getApplicationContext(), new AdConfig.Builder().setDebug(isAdaptersDebugEnabled()).setAppId(appId).build(), this);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public boolean isUsingActivityBeforeImpression(LevelPlay.AdFormat adFormat) {
        k.e(adFormat, "adFormat");
        return false;
    }

    @Override // sg.bigo.ads.BigoAdSdk.InitListener
    public void onInitialized() {
        IronLog.ADAPTER_API.verbose("BIGO SDK Initialized");
        initializationSuccess();
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public void setConsent(boolean z2) {
        IronLog.ADAPTER_API.verbose("consent = " + z2);
        BigoAdSdk.setUserConsent(ContextProvider.getInstance().getApplicationContext(), ConsentOptions.GDPR, z2);
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
        k.d(valueForType, "formatValueForType(value….META_DATA_VALUE_BOOLEAN)");
        if (MetaDataUtils.isValidCCPAMetaData(key, str)) {
            setCCPAValue(MetaDataUtils.getMetaDataBooleanValue(str));
        } else if (MetaDataUtils.isValidMetaData(key, META_DATA_BIGO_COPPA_KEY, valueForType)) {
            setCOPPAValue(MetaDataUtils.getMetaDataBooleanValue(valueForType));
        }
    }
}
