package com.ironsource.adapters.pangle;

import android.app.Activity;
import android.content.Context;
import android.widget.FrameLayout;
import androidx.camera.core.processing.c;
import androidx.camera.core.w;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerRequest;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerSize;
import com.bytedance.sdk.openadsdk.api.bidding.PAGBiddingRequest;
import com.bytedance.sdk.openadsdk.api.init.PAGConfig;
import com.bytedance.sdk.openadsdk.api.init.PAGSdk;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialRequest;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedRequest;
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
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.metadata.MetaDataUtils;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.unity3d.mediation.LevelPlay;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import n6.t;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class PangleAdapter extends AbstractAdapter implements INetworkInitCallbackListener {
    private static final String ADAPTER_VERSION_KEY = "adapter_version";
    private static final String APP_ID_KEY = "appID";
    private static final String GitHash = "bb3668c";
    private static final String LEVELPLAY_ADXID = "33";
    private static final String MEDIATION_NAME = "Ironsource";
    private static final String MEDIATION_NAME_KEY = "mediation";
    private static final String META_DATA_PANGLE_COPPA_KEY = "Pangle_COPPA";
    private static final String NAME_KEY = "name";
    private static final int PANGLE_CHILD_DIRECTED_TYPE_CHILD = 1;
    private static final int PANGLE_CHILD_DIRECTED_TYPE_DEFAULT = -1;
    private static final int PANGLE_CHILD_DIRECTED_TYPE_NON_CHILD = 0;
    public static final int PANGLE_NOT_ALLOW_CHILD_ERROR_CODE = 20002;
    public static final String PANGLE_NOT_ALLOW_CHILD_ERROR_MSG = "Pangle_COPPA indicates the user is a child. Pangle SDK V71 or higher does not support child users.";
    public static final int PANGLE_NO_FILL_ERROR_CODE = 20001;
    private static final String SLOT_ID_KEY = "slotID";
    private static final String VALUE_KEY = "value";
    private static final String VERSION = "5.1.0";
    private final CopyOnWriteArraySet<String> mRewardedVideoSlotIdsForInitCallbacks;
    private ConcurrentHashMap<String, PangleBannerAdListener> mSlotIdToBannerAdListener;
    private ConcurrentHashMap<String, BannerSmashListener> mSlotIdToBannerListener;
    private ConcurrentHashMap<String, PAGBannerAd> mSlotIdToBannerView;
    private ConcurrentHashMap<String, PAGInterstitialAd> mSlotIdToInterstitialAd;
    private final ConcurrentHashMap<String, Boolean> mSlotIdToInterstitialAdAvailability;
    private ConcurrentHashMap<String, PangleInterstitialAdListener> mSlotIdToInterstitialAdListener;
    private ConcurrentHashMap<String, InterstitialSmashListener> mSlotIdToInterstitialListener;
    private ConcurrentHashMap<String, PAGRewardedAd> mSlotIdToRewardedVideoAd;
    private final ConcurrentHashMap<String, Boolean> mSlotIdToRewardedVideoAdAvailability;
    private ConcurrentHashMap<String, PangleRewardedVideoAdListener> mSlotIdToRewardedVideoAdListener;
    private ConcurrentHashMap<String, RewardedVideoSmashListener> mSlotIdToRewardedVideoListener;
    public static final Companion Companion = new Companion(null);
    private static int mChildDirected = -1;
    private static final PAGConfig.Builder mPAGConfigBuilder = new PAGConfig.Builder();
    private static final AtomicBoolean mWasInitCalled = new AtomicBoolean(false);
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
            String sDKVersion = PAGSdk.getSDKVersion();
            k.d(sDKVersion, "getSDKVersion()");
            return sDKVersion;
        }

        public final IntegrationData getIntegrationData(Context context) {
            return new IntegrationData("Pangle", "5.1.0");
        }

        public final PangleAdapter startAdapter(String providerName) {
            k.e(providerName, "providerName");
            return new PangleAdapter(providerName);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Companion.InitState.values().length];
            try {
                iArr[Companion.InitState.INIT_STATE_SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Companion.InitState.INIT_STATE_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PangleAdapter(String providerName) {
        super(providerName);
        k.e(providerName, "providerName");
        this.mSlotIdToRewardedVideoListener = new ConcurrentHashMap<>();
        this.mSlotIdToRewardedVideoAdListener = new ConcurrentHashMap<>();
        this.mSlotIdToRewardedVideoAd = new ConcurrentHashMap<>();
        this.mSlotIdToRewardedVideoAdAvailability = new ConcurrentHashMap<>();
        this.mRewardedVideoSlotIdsForInitCallbacks = new CopyOnWriteArraySet<>();
        this.mSlotIdToInterstitialListener = new ConcurrentHashMap<>();
        this.mSlotIdToInterstitialAdListener = new ConcurrentHashMap<>();
        this.mSlotIdToInterstitialAd = new ConcurrentHashMap<>();
        this.mSlotIdToInterstitialAdAvailability = new ConcurrentHashMap<>();
        this.mSlotIdToBannerListener = new ConcurrentHashMap<>();
        this.mSlotIdToBannerAdListener = new ConcurrentHashMap<>();
        this.mSlotIdToBannerView = new ConcurrentHashMap<>();
        this.mLWSSupportState = LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_INSTANCE;
    }

    private final void collectBiddingData(BiddingDataCallback biddingDataCallback, JSONObject jSONObject) {
        String strOptString = jSONObject.optString(SLOT_ID_KEY);
        if (mInitState == Companion.InitState.INIT_STATE_FAILED) {
            IronLog.INTERNAL.verbose("returning null as token since init is not successful");
            biddingDataCallback.onFailure("returning null as token since init is not successful - Pangle");
        } else if (isCoppaChildUser()) {
            IronLog.INTERNAL.verbose(PANGLE_NOT_ALLOW_CHILD_ERROR_MSG);
            biddingDataCallback.onFailure("Pangle_COPPA indicates the user is a child. Pangle SDK V71 or higher does not support child users. - Pangle");
        } else {
            PAGBiddingRequest pAGBiddingRequest = new PAGBiddingRequest();
            pAGBiddingRequest.setSlotId(strOptString);
            pAGBiddingRequest.setAdxId(LEVELPLAY_ADXID);
            PAGSdk.getBiddingToken(ContextProvider.getInstance().getApplicationContext(), pAGBiddingRequest, new a(biddingDataCallback));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void collectBiddingData$lambda$18(BiddingDataCallback biddingDataCallback, String bidToken) {
        k.e(biddingDataCallback, "$biddingDataCallback");
        if (bidToken == null || bidToken.length() == 0) {
            biddingDataCallback.onFailure("Failed to receive token - Pangle");
            return;
        }
        IronLog.ADAPTER_API.verbose("token = " + bidToken);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        k.d(bidToken, "bidToken");
        linkedHashMap.put("token", bidToken);
        biddingDataCallback.onSuccess(linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void destroyBanner$lambda$14(PangleAdapter this$0, String str) {
        k.e(this$0, "this$0");
        PAGBannerAd pAGBannerAd = this$0.mSlotIdToBannerView.get(str);
        if (pAGBannerAd != null) {
            pAGBannerAd.setAdInteractionListener(null);
        }
        PAGBannerAd pAGBannerAd2 = this$0.mSlotIdToBannerView.get(str);
        if (pAGBannerAd2 != null) {
            pAGBannerAd2.destroy();
        }
        this$0.mSlotIdToBannerView.remove(str);
    }

    public static final String getAdapterSDKVersion() {
        return Companion.getAdapterSDKVersion();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final android.widget.FrameLayout.LayoutParams getBannerLayoutParams(com.ironsource.mediationsdk.ISBannerSize r6) {
        /*
            r5 = this;
            com.ironsource.environment.ContextProvider r0 = com.ironsource.environment.ContextProvider.getInstance()
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r6 = r6.getDescription()
            if (r6 == 0) goto L87
            int r1 = r6.hashCode()
            r2 = -387072689(0xffffffffe8edbd4f, float:-8.981544E24)
            if (r1 == r2) goto L6c
            r2 = 79011241(0x4b59da9, float:4.2697683E-36)
            r3 = 50
            r4 = 320(0x140, float:4.48E-43)
            if (r1 == r2) goto L3d
            r2 = 1951953708(0x7458732c, float:6.859571E31)
            if (r1 == r2) goto L26
            goto L87
        L26:
            java.lang.String r1 = "BANNER"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L2f
            goto L87
        L2f:
            android.widget.FrameLayout$LayoutParams r6 = new android.widget.FrameLayout$LayoutParams
            int r1 = com.ironsource.mediationsdk.AdapterUtils.dpToPixels(r0, r4)
            int r0 = com.ironsource.mediationsdk.AdapterUtils.dpToPixels(r0, r3)
            r6.<init>(r1, r0)
            goto L8d
        L3d:
            java.lang.String r1 = "SMART"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L46
            goto L87
        L46:
            boolean r6 = com.ironsource.mediationsdk.AdapterUtils.isLargeScreen(r0)
            if (r6 == 0) goto L5e
            android.widget.FrameLayout$LayoutParams r6 = new android.widget.FrameLayout$LayoutParams
            r1 = 728(0x2d8, float:1.02E-42)
            int r1 = com.ironsource.mediationsdk.AdapterUtils.dpToPixels(r0, r1)
            r2 = 90
            int r0 = com.ironsource.mediationsdk.AdapterUtils.dpToPixels(r0, r2)
            r6.<init>(r1, r0)
            goto L8d
        L5e:
            android.widget.FrameLayout$LayoutParams r6 = new android.widget.FrameLayout$LayoutParams
            int r1 = com.ironsource.mediationsdk.AdapterUtils.dpToPixels(r0, r4)
            int r0 = com.ironsource.mediationsdk.AdapterUtils.dpToPixels(r0, r3)
            r6.<init>(r1, r0)
            goto L8d
        L6c:
            java.lang.String r1 = "RECTANGLE"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L75
            goto L87
        L75:
            android.widget.FrameLayout$LayoutParams r6 = new android.widget.FrameLayout$LayoutParams
            r1 = 300(0x12c, float:4.2E-43)
            int r1 = com.ironsource.mediationsdk.AdapterUtils.dpToPixels(r0, r1)
            r2 = 250(0xfa, float:3.5E-43)
            int r0 = com.ironsource.mediationsdk.AdapterUtils.dpToPixels(r0, r2)
            r6.<init>(r1, r0)
            goto L8d
        L87:
            android.widget.FrameLayout$LayoutParams r6 = new android.widget.FrameLayout$LayoutParams
            r0 = 0
            r6.<init>(r0, r0)
        L8d:
            r0 = 17
            r6.gravity = r0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adapters.pangle.PangleAdapter.getBannerLayoutParams(com.ironsource.mediationsdk.ISBannerSize):android.widget.FrameLayout$LayoutParams");
    }

    private final PAGBannerSize getBannerSize(ISBannerSize iSBannerSize) {
        String description = iSBannerSize.getDescription();
        if (description != null) {
            int iHashCode = description.hashCode();
            if (iHashCode != -387072689) {
                if (iHashCode != 79011241) {
                    if (iHashCode == 1951953708 && description.equals(l.f9204a)) {
                        PAGBannerSize BANNER_W_320_H_50 = PAGBannerSize.BANNER_W_320_H_50;
                        k.d(BANNER_W_320_H_50, "BANNER_W_320_H_50");
                        return BANNER_W_320_H_50;
                    }
                } else if (description.equals(l.e)) {
                    PAGBannerSize pAGBannerSize = AdapterUtils.isLargeScreen(ContextProvider.getInstance().getApplicationContext()) ? PAGBannerSize.BANNER_W_728_H_90 : PAGBannerSize.BANNER_W_320_H_50;
                    k.d(pAGBannerSize, "if (AdapterUtils.isLarge…20_H_50\n                }");
                    return pAGBannerSize;
                }
            } else if (description.equals(l.f9206c)) {
                PAGBannerSize BANNER_W_300_H_250 = PAGBannerSize.BANNER_W_300_H_250;
                k.d(BANNER_W_300_H_250, "BANNER_W_300_H_250");
                return BANNER_W_300_H_250;
            }
        }
        return new PAGBannerSize(0, 0);
    }

    public static final IntegrationData getIntegrationData(Context context) {
        return Companion.getIntegrationData(context);
    }

    private final String getMediationInfo() {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", MEDIATION_NAME_KEY);
            jSONObject.put("value", MEDIATION_NAME);
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("name", ADAPTER_VERSION_KEY);
            jSONObject2.put("value", "5.1.0");
            jSONArray.put(jSONObject2);
            IronLog.INTERNAL.verbose("mediationInfo = " + jSONArray);
        } catch (JSONException e) {
            IronLog.INTERNAL.error("Error while creating mediation info object - " + e);
        }
        String string = jSONArray.toString();
        k.d(string, "mediationInfo.toString()");
        return string;
    }

    private final void initSdk(String str) {
        if (mInitState == Companion.InitState.INIT_STATE_NONE || mInitState == Companion.InitState.INIT_STATE_IN_PROGRESS) {
            initCallbackListeners.add(this);
        }
        if (mWasInitCalled.compareAndSet(false, true)) {
            mInitState = Companion.InitState.INIT_STATE_IN_PROGRESS;
            com.google.android.gms.ads.internal.client.a.p("appId = ", str, IronLog.ADAPTER_API);
            if (isCoppaChildUser()) {
                initializationFailure(PANGLE_NOT_ALLOW_CHILD_ERROR_CODE, PANGLE_NOT_ALLOW_CHILD_ERROR_MSG);
            } else {
                AbstractAdapter.postOnUIThread(new c(ContextProvider.getInstance().getApplicationContext(), mPAGConfigBuilder.appId(str).setAdxId(LEVELPLAY_ADXID).setUserData(getMediationInfo()).debugLog(isAdaptersDebugEnabled()).supportMultiProcess(false).build(), this, 15));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initSdk$lambda$0(Context context, PAGConfig pAGConfig, final PangleAdapter this$0) {
        k.e(this$0, "this$0");
        PAGSdk.init(context, pAGConfig, new PAGSdk.PAGInitCallback() { // from class: com.ironsource.adapters.pangle.PangleAdapter$initSdk$1$1
            @Override // com.bytedance.sdk.openadsdk.api.init.PAGSdk.PAGInitCallback
            public void fail(int i2, String message) {
                k.e(message, "message");
                this.this$0.initializationFailure(i2, message);
            }

            @Override // com.bytedance.sdk.openadsdk.api.init.PAGSdk.PAGInitCallback
            public void success() {
                this.this$0.initializationSuccess();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initializationFailure(int i2, String str) {
        IronLog.ADAPTER_CALLBACK.verbose("error code = " + i2 + ", message = " + str);
        mInitState = Companion.InitState.INIT_STATE_FAILED;
        Iterator<INetworkInitCallbackListener> it = initCallbackListeners.iterator();
        while (it.hasNext()) {
            it.next().onNetworkInitCallbackFailed(str);
        }
        initCallbackListeners.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initializationSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose();
        mInitState = Companion.InitState.INIT_STATE_SUCCESS;
        for (INetworkInitCallbackListener initCallbackListeners2 : initCallbackListeners) {
            k.d(initCallbackListeners2, "initCallbackListeners");
            initCallbackListeners2.onNetworkInitCallbackSuccess();
        }
        initCallbackListeners.clear();
    }

    private final boolean isCoppaChildUser() {
        return mChildDirected == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadBannerForBidding$lambda$13(ISBannerSize iSBannerSize, BannerSmashListener listener, String str, PAGBannerRequest bannerRequest, PangleBannerAdListener bannerAdListener) {
        k.e(listener, "$listener");
        k.e(bannerRequest, "$bannerRequest");
        k.e(bannerAdListener, "$bannerAdListener");
        if (iSBannerSize != null) {
            PAGBannerAd.loadAd(str, bannerRequest, bannerAdListener);
        } else {
            IronLog.INTERNAL.error("banner size is null");
            listener.onBannerAdLoadFailed(ErrorBuilder.buildNoConfigurationAvailableError("banner size is null"));
        }
    }

    private final void loadInterstitialInternal(String str, String str2, InterstitialSmashListener interstitialSmashListener) {
        setInterstitialAdAvailability$pangleadapter_release(str, false);
        if (isCoppaChildUser()) {
            IronLog.INTERNAL.error("Child user - Pangle_COPPA indicates the user is a child. Pangle SDK V71 or higher does not support child users.");
            interstitialSmashListener.onInterstitialAdLoadFailed(new IronSourceError(PANGLE_NOT_ALLOW_CHILD_ERROR_CODE, "Child user - Pangle_COPPA indicates the user is a child. Pangle SDK V71 or higher does not support child users."));
            return;
        }
        PangleInterstitialAdListener pangleInterstitialAdListener = new PangleInterstitialAdListener(interstitialSmashListener, new WeakReference(this), str);
        this.mSlotIdToInterstitialAdListener.put(str, pangleInterstitialAdListener);
        PAGInterstitialRequest pAGInterstitialRequest = new PAGInterstitialRequest();
        if (str2 != null) {
            pAGInterstitialRequest.setAdString(str2);
        }
        AbstractAdapter.postOnUIThread(new c(str, pAGInterstitialRequest, pangleInterstitialAdListener, 16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadInterstitialInternal$lambda$10(String slotId, PAGInterstitialRequest request, PangleInterstitialAdListener interstitialAdListener) {
        k.e(slotId, "$slotId");
        k.e(request, "$request");
        k.e(interstitialAdListener, "$interstitialAdListener");
        PAGInterstitialAd.loadAd(slotId, request, interstitialAdListener);
    }

    private final void loadRewardedVideoInternal(String str, String str2, RewardedVideoSmashListener rewardedVideoSmashListener) {
        com.google.android.gms.ads.internal.client.a.p("slotId = ", str, IronLog.ADAPTER_API);
        setRewardedVideoAdAvailability$pangleadapter_release(str, false);
        if (isCoppaChildUser()) {
            IronLog.INTERNAL.error("Child user - Pangle_COPPA indicates the user is a child. Pangle SDK V71 or higher does not support child users.");
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
            rewardedVideoSmashListener.onRewardedVideoLoadFailed(new IronSourceError(PANGLE_NOT_ALLOW_CHILD_ERROR_CODE, "Child user - Pangle_COPPA indicates the user is a child. Pangle SDK V71 or higher does not support child users."));
        } else {
            PangleRewardedVideoAdListener pangleRewardedVideoAdListener = new PangleRewardedVideoAdListener(rewardedVideoSmashListener, new WeakReference(this), str);
            this.mSlotIdToRewardedVideoAdListener.put(str, pangleRewardedVideoAdListener);
            PAGRewardedRequest pAGRewardedRequest = new PAGRewardedRequest();
            if (str2 != null) {
                pAGRewardedRequest.setAdString(str2);
            }
            AbstractAdapter.postOnUIThread(new c(str, pAGRewardedRequest, pangleRewardedVideoAdListener, 17));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadRewardedVideoInternal$lambda$7(String slotId, PAGRewardedRequest request, PangleRewardedVideoAdListener rewardedVideoAdListener) {
        k.e(slotId, "$slotId");
        k.e(request, "$request");
        k.e(rewardedVideoAdListener, "$rewardedVideoAdListener");
        PAGRewardedAd.loadAd(slotId, request, rewardedVideoAdListener);
    }

    private final void setCCPAValue(boolean z2) {
        int i2;
        String str;
        if (z2) {
            i2 = 0;
            str = "PAG_PA_CONSENT_TYPE_NO_CONSENT";
        } else {
            i2 = 1;
            str = "PAG_PA_CONSENT_TYPE_CONSENT";
        }
        IronLog.ADAPTER_API.verbose("ccpaValue = ".concat(str));
        mPAGConfigBuilder.setPAConsent(i2);
    }

    private final void setCOPPAValue(String str) {
        String str2;
        Integer numO0 = t.o0(str);
        if (numO0 != null && numO0.intValue() == 1) {
            mChildDirected = 1;
            str2 = "PANGLE_CHILD_DIRECTED_TYPE_CHILD";
        } else if (numO0 != null && numO0.intValue() == 0) {
            mChildDirected = 0;
            str2 = "PANGLE_CHILD_DIRECTED_TYPE_NON_CHILD";
        } else {
            mChildDirected = -1;
            str2 = "PANGLE_CHILD_DIRECTED_TYPE_DEFAULT";
        }
        IronLog.ADAPTER_API.verbose("coppaValue = ".concat(str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showInterstitial$lambda$12$lambda$11(PAGInterstitialAd interstitialAd, Activity activity) {
        k.e(interstitialAd, "$interstitialAd");
        interstitialAd.show(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showRewardedVideo$lambda$9$lambda$8(PAGRewardedAd rewardedVideoAd, Activity activity) {
        k.e(rewardedVideoAd, "$rewardedVideoAd");
        rewardedVideoAd.show(activity);
    }

    public static final PangleAdapter startAdapter(String str) {
        return Companion.startAdapter(str);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void collectBannerBiddingData(JSONObject config, JSONObject jSONObject, BiddingDataCallback biddingDataCallback) {
        k.e(config, "config");
        k.e(biddingDataCallback, "biddingDataCallback");
        collectBiddingData(biddingDataCallback, config);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void collectInterstitialBiddingData(JSONObject config, JSONObject jSONObject, BiddingDataCallback biddingDataCallback) {
        k.e(config, "config");
        k.e(biddingDataCallback, "biddingDataCallback");
        collectBiddingData(biddingDataCallback, config);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void collectRewardedVideoBiddingData(JSONObject config, JSONObject jSONObject, BiddingDataCallback biddingDataCallback) {
        k.e(config, "config");
        k.e(biddingDataCallback, "biddingDataCallback");
        collectBiddingData(biddingDataCallback, config);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void destroyBanner(JSONObject jSONObject) {
        String strOptString = jSONObject != null ? jSONObject.optString(SLOT_ID_KEY) : null;
        IronLog ironLog = IronLog.ADAPTER_API;
        com.google.android.gms.ads.internal.client.a.p("slotId = ", strOptString, ironLog);
        if (!this.mSlotIdToBannerView.containsKey(strOptString)) {
            ironLog.verbose("Banner is already destroyed");
        } else {
            if (strOptString == null || strOptString.length() == 0) {
                return;
            }
            AbstractAdapter.postOnUIThread(new a3.c(22, this, strOptString));
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getCoreSDKVersion() {
        return Companion.getAdapterSDKVersion();
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getVersion() {
        return "5.1.0";
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void initAndLoadRewardedVideo(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, RewardedVideoSmashListener listener) {
        k.e(listener, "listener");
        String strOptString = jSONObject != null ? jSONObject.optString(SLOT_ID_KEY) : null;
        String strOptString2 = jSONObject != null ? jSONObject.optString(APP_ID_KEY) : null;
        if (strOptString == null || strOptString.length() == 0) {
            IronLog.INTERNAL.error("Missing param - slotID");
            listener.onRewardedVideoAvailabilityChanged(false);
            return;
        }
        if (strOptString2 == null || strOptString2.length() == 0) {
            IronLog.INTERNAL.error("Missing param - appID");
            listener.onRewardedVideoAvailabilityChanged(false);
            return;
        }
        com.google.android.gms.ads.internal.client.a.p("slotId = ", strOptString, IronLog.ADAPTER_API);
        this.mSlotIdToRewardedVideoListener.put(strOptString, listener);
        int i2 = WhenMappings.$EnumSwitchMapping$0[mInitState.ordinal()];
        if (i2 == 1) {
            loadRewardedVideoInternal(strOptString, null, listener);
            return;
        }
        if (i2 != 2) {
            initSdk(strOptString2);
            return;
        }
        IronLog.INTERNAL.verbose("init failed - slotId = " + strOptString);
        listener.onRewardedVideoAvailabilityChanged(false);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void initBannerForBidding(String str, String str2, JSONObject jSONObject, BannerSmashListener listener) {
        k.e(listener, "listener");
        String strOptString = jSONObject != null ? jSONObject.optString(SLOT_ID_KEY) : null;
        String strOptString2 = jSONObject != null ? jSONObject.optString(APP_ID_KEY) : null;
        if (strOptString == null || strOptString.length() == 0) {
            IronLog.INTERNAL.error("Missing param - slotID");
            listener.onBannerInitFailed(ErrorBuilder.buildInitFailedError("Missing params - slotID", "Banner"));
            return;
        }
        if (strOptString2 == null || strOptString2.length() == 0) {
            IronLog.INTERNAL.error("Missing param - appID");
            listener.onBannerInitFailed(ErrorBuilder.buildInitFailedError("Missing params - appID", "Banner"));
            return;
        }
        com.google.android.gms.ads.internal.client.a.p("slotId = ", strOptString, IronLog.ADAPTER_API);
        this.mSlotIdToBannerListener.put(strOptString, listener);
        int i2 = WhenMappings.$EnumSwitchMapping$0[mInitState.ordinal()];
        if (i2 == 1) {
            listener.onBannerInitSuccess();
            return;
        }
        if (i2 != 2) {
            initSdk(strOptString2);
            return;
        }
        IronLog.INTERNAL.verbose("init failed - slotId = " + strOptString);
        listener.onBannerInitFailed(ErrorBuilder.buildInitFailedError("Pangle SDK init failed", "Banner"));
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void initInterstitial(String str, String str2, JSONObject jSONObject, InterstitialSmashListener listener) {
        k.e(listener, "listener");
        String strOptString = jSONObject != null ? jSONObject.optString(SLOT_ID_KEY) : null;
        String strOptString2 = jSONObject != null ? jSONObject.optString(APP_ID_KEY) : null;
        if (strOptString == null || strOptString.length() == 0) {
            IronLog.INTERNAL.error("Missing param - slotID");
            listener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("Missing params - slotID", "Interstitial"));
            return;
        }
        if (strOptString2 == null || strOptString2.length() == 0) {
            IronLog.INTERNAL.error("Missing param - appID");
            listener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("Missing params - appID", "Interstitial"));
            return;
        }
        com.google.android.gms.ads.internal.client.a.p("slotId = ", strOptString, IronLog.ADAPTER_API);
        this.mSlotIdToInterstitialListener.put(strOptString, listener);
        int i2 = WhenMappings.$EnumSwitchMapping$0[mInitState.ordinal()];
        if (i2 == 1) {
            listener.onInterstitialInitSuccess();
            return;
        }
        if (i2 != 2) {
            initSdk(strOptString2);
            return;
        }
        IronLog.INTERNAL.verbose("init failed - slotId = " + strOptString);
        listener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("Pangle SDK init failed", "Interstitial"));
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void initInterstitialForBidding(String str, String str2, JSONObject jSONObject, InterstitialSmashListener listener) {
        k.e(listener, "listener");
        IronLog.INTERNAL.verbose();
        initInterstitial(str, str2, jSONObject, listener);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void initRewardedVideoWithCallback(String str, String str2, JSONObject jSONObject, RewardedVideoSmashListener listener) {
        k.e(listener, "listener");
        String strOptString = jSONObject != null ? jSONObject.optString(SLOT_ID_KEY) : null;
        String strOptString2 = jSONObject != null ? jSONObject.optString(APP_ID_KEY) : null;
        if (strOptString == null || strOptString.length() == 0) {
            IronLog.INTERNAL.error("Missing param - slotID");
            listener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("Missing params - slotID", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            return;
        }
        if (strOptString2 == null || strOptString2.length() == 0) {
            IronLog.INTERNAL.error("Missing param - appID");
            listener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("Missing params - appID", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            return;
        }
        com.google.android.gms.ads.internal.client.a.p("slotId = ", strOptString, IronLog.ADAPTER_API);
        this.mSlotIdToRewardedVideoListener.put(strOptString, listener);
        this.mRewardedVideoSlotIdsForInitCallbacks.add(strOptString);
        int i2 = WhenMappings.$EnumSwitchMapping$0[mInitState.ordinal()];
        if (i2 == 1) {
            listener.onRewardedVideoInitSuccess();
            return;
        }
        if (i2 != 2) {
            initSdk(strOptString2);
            return;
        }
        IronLog.INTERNAL.verbose("init failed - slotId = " + strOptString);
        listener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("Pangle SDK init failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public boolean isInterstitialReady(JSONObject config) {
        k.e(config, "config");
        String strOptString = config.optString(SLOT_ID_KEY);
        return strOptString != null && strOptString.length() != 0 && this.mSlotIdToInterstitialAd.containsKey(strOptString) && this.mSlotIdToInterstitialAdAvailability.containsKey(strOptString) && k.a(this.mSlotIdToInterstitialAdAvailability.get(strOptString), Boolean.TRUE);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public boolean isRewardedVideoAvailable(JSONObject config) {
        k.e(config, "config");
        String strOptString = config.optString(SLOT_ID_KEY);
        return strOptString != null && strOptString.length() != 0 && this.mSlotIdToRewardedVideoAd.containsKey(strOptString) && this.mSlotIdToRewardedVideoAdAvailability.containsKey(strOptString) && k.a(this.mSlotIdToRewardedVideoAdAvailability.get(strOptString), Boolean.TRUE);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public boolean isUsingActivityBeforeImpression(LevelPlay.AdFormat adFormat) {
        k.e(adFormat, "adFormat");
        return false;
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void loadBannerForBidding(JSONObject config, JSONObject jSONObject, String str, ISBannerSize iSBannerSize, BannerSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
        String slotId = config.optString(SLOT_ID_KEY);
        com.google.android.gms.ads.internal.client.a.p("slotId = ", slotId, IronLog.ADAPTER_API);
        if (iSBannerSize == null) {
            IronLog.INTERNAL.error("banner size is null");
            listener.onBannerAdLoadFailed(ErrorBuilder.buildNoConfigurationAvailableError("banner size is null"));
            return;
        }
        if (isCoppaChildUser()) {
            IronLog.INTERNAL.error("Child user - Pangle_COPPA indicates the user is a child. Pangle SDK V71 or higher does not support child users.");
            listener.onBannerAdLoadFailed(new IronSourceError(PANGLE_NOT_ALLOW_CHILD_ERROR_CODE, "Child user - Pangle_COPPA indicates the user is a child. Pangle SDK V71 or higher does not support child users."));
            return;
        }
        FrameLayout.LayoutParams bannerLayoutParams = getBannerLayoutParams(iSBannerSize);
        WeakReference weakReference = new WeakReference(this);
        k.d(slotId, "slotId");
        PangleBannerAdListener pangleBannerAdListener = new PangleBannerAdListener(listener, weakReference, slotId, bannerLayoutParams);
        this.mSlotIdToBannerAdListener.put(slotId, pangleBannerAdListener);
        PAGBannerRequest pAGBannerRequest = new PAGBannerRequest(getBannerSize(iSBannerSize));
        pAGBannerRequest.setAdString(str);
        AbstractAdapter.postOnUIThread(new w(iSBannerSize, listener, slotId, pAGBannerRequest, pangleBannerAdListener, 2));
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void loadInterstitial(JSONObject config, JSONObject jSONObject, InterstitialSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
        String slotId = config.optString(SLOT_ID_KEY);
        IronLog.ADAPTER_API.verbose("slotId = " + slotId);
        k.d(slotId, "slotId");
        loadInterstitialInternal(slotId, null, listener);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void loadInterstitialForBidding(JSONObject config, JSONObject jSONObject, String str, InterstitialSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
        String slotId = config.optString(SLOT_ID_KEY);
        IronLog.ADAPTER_API.verbose("slotId = " + slotId);
        k.d(slotId, "slotId");
        loadInterstitialInternal(slotId, str, listener);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void loadRewardedVideo(JSONObject config, JSONObject jSONObject, RewardedVideoSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
        String slotId = config.optString(SLOT_ID_KEY);
        k.d(slotId, "slotId");
        loadRewardedVideoInternal(slotId, null, listener);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void loadRewardedVideoForBidding(JSONObject config, JSONObject jSONObject, String str, RewardedVideoSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
        String slotId = config.optString(SLOT_ID_KEY);
        k.d(slotId, "slotId");
        loadRewardedVideoInternal(slotId, str, listener);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackFailed(String error) {
        k.e(error, "error");
        for (Map.Entry<String, RewardedVideoSmashListener> entry : this.mSlotIdToRewardedVideoListener.entrySet()) {
            String key = entry.getKey();
            RewardedVideoSmashListener value = entry.getValue();
            if (this.mRewardedVideoSlotIdsForInitCallbacks.contains(key)) {
                value.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError(error, IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            } else {
                value.onRewardedVideoAvailabilityChanged(false);
            }
        }
        Iterator<Map.Entry<String, InterstitialSmashListener>> it = this.mSlotIdToInterstitialListener.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().onInterstitialInitFailed(ErrorBuilder.buildInitFailedError(error, "Interstitial"));
        }
        Iterator<Map.Entry<String, BannerSmashListener>> it2 = this.mSlotIdToBannerListener.entrySet().iterator();
        while (it2.hasNext()) {
            it2.next().getValue().onBannerInitFailed(ErrorBuilder.buildInitFailedError(error, "Banner"));
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackSuccess() {
        for (Map.Entry<String, RewardedVideoSmashListener> entry : this.mSlotIdToRewardedVideoListener.entrySet()) {
            String key = entry.getKey();
            RewardedVideoSmashListener value = entry.getValue();
            if (this.mRewardedVideoSlotIdsForInitCallbacks.contains(key)) {
                value.onRewardedVideoInitSuccess();
            } else {
                loadRewardedVideoInternal(key, null, value);
            }
        }
        Iterator<Map.Entry<String, InterstitialSmashListener>> it = this.mSlotIdToInterstitialListener.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().onInterstitialInitSuccess();
        }
        Iterator<Map.Entry<String, BannerSmashListener>> it2 = this.mSlotIdToBannerListener.entrySet().iterator();
        while (it2.hasNext()) {
            it2.next().getValue().onBannerInitSuccess();
        }
    }

    public final void setBannerAd$pangleadapter_release(String slotId, PAGBannerAd pAGBannerAd) {
        k.e(slotId, "slotId");
        if (pAGBannerAd != null) {
            this.mSlotIdToBannerView.put(slotId, pAGBannerAd);
            pAGBannerAd.setAdInteractionListener(this.mSlotIdToBannerAdListener.get(slotId));
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public void setConsent(boolean z2) {
        int i2;
        String str;
        if (z2) {
            i2 = 1;
            str = "PAG_GDPR_CONSENT_TYPE_CONSENT";
        } else {
            i2 = 0;
            str = "PAG_GDPR_CONSENT_TYPE_NO_CONSENT";
        }
        IronLog.ADAPTER_API.verbose("consent = ".concat(str));
        mPAGConfigBuilder.setGDPRConsent(i2);
    }

    public final void setInterstitialAd$pangleadapter_release(String slotId, PAGInterstitialAd pAGInterstitialAd) {
        k.e(slotId, "slotId");
        if (pAGInterstitialAd != null) {
            this.mSlotIdToInterstitialAd.put(slotId, pAGInterstitialAd);
        }
    }

    public final void setInterstitialAdAvailability$pangleadapter_release(String slotId, boolean z2) {
        k.e(slotId, "slotId");
        this.mSlotIdToInterstitialAdAvailability.put(slotId, Boolean.valueOf(z2));
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
        } else if (MetaDataUtils.isValidMetaData(key, META_DATA_PANGLE_COPPA_KEY, str)) {
            setCOPPAValue(str);
        }
    }

    public final void setRewardedVideoAd$pangleadapter_release(String slotId, PAGRewardedAd pAGRewardedAd) {
        k.e(slotId, "slotId");
        if (pAGRewardedAd != null) {
            this.mSlotIdToRewardedVideoAd.put(slotId, pAGRewardedAd);
        }
    }

    public final void setRewardedVideoAdAvailability$pangleadapter_release(String slotId, boolean z2) {
        k.e(slotId, "slotId");
        this.mSlotIdToRewardedVideoAdAvailability.put(slotId, Boolean.valueOf(z2));
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void showInterstitial(JSONObject config, InterstitialSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
        String slotId = config.optString(SLOT_ID_KEY);
        com.google.android.gms.ads.internal.client.a.p("slotId = ", slotId, IronLog.ADAPTER_API);
        if (isCoppaChildUser()) {
            IronLog.INTERNAL.error("Child user - Pangle_COPPA indicates the user is a child. Pangle SDK V71 or higher does not support child users.");
            listener.onInterstitialAdShowFailed(new IronSourceError(PANGLE_NOT_ALLOW_CHILD_ERROR_CODE, "Child user - Pangle_COPPA indicates the user is a child. Pangle SDK V71 or higher does not support child users."));
            return;
        }
        if (isInterstitialReady(config)) {
            Activity currentActiveActivity = ContextProvider.getInstance().getCurrentActiveActivity();
            PAGInterstitialAd pAGInterstitialAd = this.mSlotIdToInterstitialAd.get(slotId);
            if (pAGInterstitialAd != null) {
                pAGInterstitialAd.setAdInteractionListener(this.mSlotIdToInterstitialAdListener.get(slotId));
                AbstractAdapter.postOnUIThread(new a3.c(21, pAGInterstitialAd, currentActiveActivity));
            }
        } else {
            listener.onInterstitialAdShowFailed(ErrorBuilder.buildNoAdsToShowError("Interstitial"));
        }
        k.d(slotId, "slotId");
        setInterstitialAdAvailability$pangleadapter_release(slotId, false);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void showRewardedVideo(JSONObject config, RewardedVideoSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
        String slotId = config.optString(SLOT_ID_KEY);
        com.google.android.gms.ads.internal.client.a.p("slotId = ", slotId, IronLog.ADAPTER_API);
        if (isCoppaChildUser()) {
            IronLog.INTERNAL.error("Child user - Pangle_COPPA indicates the user is a child. Pangle SDK V71 or higher does not support child users.");
            listener.onRewardedVideoAdShowFailed(new IronSourceError(PANGLE_NOT_ALLOW_CHILD_ERROR_CODE, "Child user - Pangle_COPPA indicates the user is a child. Pangle SDK V71 or higher does not support child users."));
            return;
        }
        if (isRewardedVideoAvailable(config)) {
            Activity currentActiveActivity = ContextProvider.getInstance().getCurrentActiveActivity();
            PAGRewardedAd pAGRewardedAd = this.mSlotIdToRewardedVideoAd.get(slotId);
            if (pAGRewardedAd != null) {
                pAGRewardedAd.setAdInteractionListener(this.mSlotIdToRewardedVideoAdListener.get(slotId));
                AbstractAdapter.postOnUIThread(new a3.c(20, pAGRewardedAd, currentActiveActivity));
            }
        } else {
            listener.onRewardedVideoAdShowFailed(ErrorBuilder.buildNoAdsToShowError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
        }
        k.d(slotId, "slotId");
        setRewardedVideoAdAvailability$pangleadapter_release(slotId, false);
    }
}
