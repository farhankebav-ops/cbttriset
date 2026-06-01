package com.vungle.ads.internal.network;

import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.PowerManager;
import android.security.NetworkSecurityPolicy;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.URLUtil;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.G5;
import com.unity3d.ads.gatewayclient.CommonGatewayClient;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.TimeIntervalMetric;
import com.vungle.ads.UserAgentError;
import com.vungle.ads.VungleAdSize;
import com.vungle.ads.VungleAds;
import com.vungle.ads.fpd.FirstPartyData;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.AdvertisingInfo;
import com.vungle.ads.internal.model.AppNode;
import com.vungle.ads.internal.model.CommonRequestBody;
import com.vungle.ads.internal.model.ConfigPayload;
import com.vungle.ads.internal.model.Cookie;
import com.vungle.ads.internal.model.DeviceNode;
import com.vungle.ads.internal.model.ErrorInfo;
import com.vungle.ads.internal.model.Placement;
import com.vungle.ads.internal.persistence.FilePreferences;
import com.vungle.ads.internal.platform.AndroidPlatform;
import com.vungle.ads.internal.platform.Platform;
import com.vungle.ads.internal.privacy.COPPA;
import com.vungle.ads.internal.privacy.PrivacyManager;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.signals.SignalManager;
import com.vungle.ads.internal.util.FileUtility;
import com.vungle.ads.internal.util.LogEntry;
import com.vungle.ads.internal.util.Logger;
import g7.c;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import k6.d;
import kotlin.jvm.internal.b0;
import l7.b;
import l7.i0;
import l7.j;
import l7.k;
import l7.y;
import n6.t;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import q5.f;
import q5.g;
import r2.q;
import r5.l;
import r5.m;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class VungleApiClient {
    private static final String TAG = "VungleApiClient";
    private AdvertisingInfo advertisingInfo;
    private VungleApi api;
    private AppNode appBody;
    private final Context applicationContext;
    private DeviceNode baseDeviceInfo;
    private final FilePreferences filePreferences;
    private VungleApi gzipApi;
    private Boolean isGooglePlayServicesAvailable;
    private final Platform platform;
    private Interceptor responseInterceptor;
    private Map<String, Long> retryAfterDataMap;
    private final f signalManager$delegate;
    private String uaString;
    public static final Companion Companion = new Companion(null);
    private static final String BASE_URL = "https://config.ads.vungle.com/";
    private static final Set<Interceptor> networkInterceptors = new HashSet();
    private static final Set<Interceptor> logInterceptors = new HashSet();
    private static final c json = a.a.b(VungleApiClient$Companion$json$1.INSTANCE);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final String getBASE_URL$vungle_ads_release() {
            return VungleApiClient.BASE_URL;
        }

        public final void reset$vungle_ads_release() {
            VungleHeader.INSTANCE.reset();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ConnectionTypeDetail {
        public static final String CDMA_1XRTT = "cdma_1xrtt";
        public static final String CDMA_EVDO_0 = "cdma_evdo_0";
        public static final String CDMA_EVDO_A = "cdma_evdo_a";
        public static final String CDMA_EVDO_B = "cdma_evdo_b";
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final String EDGE = "edge";
        public static final String FIFTH_G = "5g";
        public static final String GPRS = "gprs";
        public static final String HRPD = "hrpd";
        public static final String HSDPA = "hsdpa";
        public static final String HSUPA = "hsupa";
        public static final String LTE = "lte";
        public static final String UNKNOWN = "unknown";
        public static final String WCDMA = "wcdma";

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final String CDMA_1XRTT = "cdma_1xrtt";
            public static final String CDMA_EVDO_0 = "cdma_evdo_0";
            public static final String CDMA_EVDO_A = "cdma_evdo_a";
            public static final String CDMA_EVDO_B = "cdma_evdo_b";
            public static final String EDGE = "edge";
            public static final String FIFTH_G = "5g";
            public static final String GPRS = "gprs";
            public static final String HRPD = "hrpd";
            public static final String HSDPA = "hsdpa";
            public static final String HSUPA = "hsupa";
            public static final String LTE = "lte";
            public static final String UNKNOWN = "unknown";
            public static final String WCDMA = "wcdma";

            private Companion() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class GzipRequestInterceptor implements Interceptor {
        private static final String CONTENT_ENCODING = "Content-Encoding";
        public static final Companion Companion = new Companion(null);
        private static final String GZIP = "gzip";

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
                this();
            }

            private Companion() {
            }
        }

        private final RequestBody gzip(final RequestBody requestBody) throws IOException {
            final j jVar = new j();
            i0 i0VarB = b.b(new y(jVar));
            requestBody.writeTo(i0VarB);
            i0VarB.close();
            return new RequestBody() { // from class: com.vungle.ads.internal.network.VungleApiClient$GzipRequestInterceptor$gzip$1
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return jVar.f12868b;
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return requestBody.contentType();
                }

                @Override // okhttp3.RequestBody
                public void writeTo(k sink) throws IOException {
                    kotlin.jvm.internal.k.e(sink, "sink");
                    sink.E(jVar.t());
                }
            };
        }

        @Override // okhttp3.Interceptor
        public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
            kotlin.jvm.internal.k.e(chain, "chain");
            Request request = chain.request();
            RequestBody requestBodyBody = request.body();
            return (requestBodyBody == null || request.header(CONTENT_ENCODING) != null) ? chain.proceed(request) : chain.proceed(request.newBuilder().header(CONTENT_ENCODING, GZIP).method(request.method(), gzip(requestBodyBody)).build());
        }
    }

    public VungleApiClient(Context applicationContext, Platform platform, FilePreferences filePreferences) {
        kotlin.jvm.internal.k.e(applicationContext, "applicationContext");
        kotlin.jvm.internal.k.e(platform, "platform");
        kotlin.jvm.internal.k.e(filePreferences, "filePreferences");
        this.applicationContext = applicationContext;
        this.platform = platform;
        this.filePreferences = filePreferences;
        this.uaString = System.getProperty("http.agent");
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        this.signalManager$delegate = n7.b.B(g.f13494a, new VungleApiClient$special$$inlined$inject$1(applicationContext));
        this.retryAfterDataMap = new ConcurrentHashMap();
        this.responseInterceptor = new Interceptor() { // from class: com.vungle.ads.internal.network.a
            @Override // okhttp3.Interceptor
            public final okhttp3.Response intercept(Interceptor.Chain chain) {
                return VungleApiClient.m3330responseInterceptor$lambda0(this.f11009a, chain);
            }
        };
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient.Builder builderProxySelector = builder.readTimeout(60L, timeUnit).connectTimeout(60L, timeUnit).addInterceptor(this.responseInterceptor).proxySelector(new ProxySelector() { // from class: com.vungle.ads.internal.network.VungleApiClient$builder$1
            @Override // java.net.ProxySelector
            public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
                try {
                    ProxySelector.getDefault().connectFailed(uri, socketAddress, iOException);
                } catch (Exception unused) {
                }
            }

            @Override // java.net.ProxySelector
            public List<Proxy> select(URI uri) {
                try {
                    List<Proxy> listSelect = ProxySelector.getDefault().select(uri);
                    kotlin.jvm.internal.k.d(listSelect, "{\n                      …ri)\n                    }");
                    return listSelect;
                } catch (Exception unused) {
                    return q.j0(Proxy.NO_PROXY);
                }
            }
        });
        OkHttpClient okHttpClientBuild = builderProxySelector.build();
        OkHttpClient okHttpClientBuild2 = builderProxySelector.addInterceptor(new GzipRequestInterceptor()).build();
        this.api = new VungleApiImpl(okHttpClientBuild);
        this.gzipApi = new VungleApiImpl(okHttpClientBuild2);
    }

    private final String bodyToString(RequestBody requestBody) {
        try {
            j jVar = new j();
            if (requestBody != null) {
                requestBody.writeTo(jVar);
                return jVar.r();
            }
        } catch (Exception unused) {
        }
        return "";
    }

    private final okhttp3.Response defaultErrorResponse(Request request) {
        return new Response.Builder().request(request).code(500).protocol(Protocol.HTTP_1_1).message("Server is busy").body(ResponseBody.Companion.create("{\"Error\":\"Server is busy\"}", MediaType.Companion.parse(G5.L))).build();
    }

    private final DeviceNode getBasicDeviceBody(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Object systemService = context.getSystemService("window");
        kotlin.jvm.internal.k.c(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        if (defaultDisplay != null) {
            defaultDisplay.getMetrics(displayMetrics);
        }
        String MANUFACTURER = Build.MANUFACTURER;
        kotlin.jvm.internal.k.d(MANUFACTURER, "MANUFACTURER");
        String MODEL = Build.MODEL;
        kotlin.jvm.internal.k.d(MODEL, "MODEL");
        String RELEASE = Build.VERSION.RELEASE;
        kotlin.jvm.internal.k.d(RELEASE, "RELEASE");
        DeviceNode deviceNode = new DeviceNode(MANUFACTURER, MODEL, RELEASE, AndroidPlatform.Companion.getCarrierName$vungle_ads_release(context), "Amazon".equals(MANUFACTURER) ? "amazon" : "android", displayMetrics.widthPixels, displayMetrics.heightPixels, this.uaString, (String) null, (Integer) null, (DeviceNode.VungleExt) null, 1792, (kotlin.jvm.internal.f) null);
        try {
            String userAgent = this.platform.getUserAgent();
            this.uaString = userAgent;
            deviceNode.setUa(userAgent);
            initUserAgentLazy();
            AdvertisingInfo advertisingInfo = this.advertisingInfo;
            if (advertisingInfo == null) {
                advertisingInfo = this.platform.getAdvertisingInfo();
            }
            this.advertisingInfo = advertisingInfo;
            return deviceNode;
        } catch (Exception e) {
            Logger.Companion.e(TAG, "Cannot Get UserAgent. Setting Default Device UserAgent." + e.getLocalizedMessage());
            return deviceNode;
        }
    }

    private final String getConnectionType() {
        if (ContextCompat.checkSelfPermission(this.applicationContext, "android.permission.ACCESS_NETWORK_STATE") != 0) {
            return null;
        }
        Object systemService = this.applicationContext.getSystemService("connectivity");
        kotlin.jvm.internal.k.c(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return "NONE";
        }
        int type = activeNetworkInfo.getType();
        return type != 0 ? (type == 1 || type == 6) ? "WIFI" : type != 7 ? type != 9 ? "UNKNOWN" : "ETHERNET" : "BLUETOOTH" : "MOBILE";
    }

    private final DeviceNode getDeviceBody() throws IllegalStateException {
        return getDeviceBody$vungle_ads_release(false);
    }

    private final CommonRequestBody.RequestExt getExtBody(boolean z2) {
        String strGenerateSignals;
        String configExtension = ConfigManager.INSTANCE.getConfigExtension();
        if (configExtension != null && configExtension.length() == 0) {
            configExtension = this.filePreferences.getString(Cookie.CONFIG_EXTENSION);
        }
        if (z2) {
            try {
                strGenerateSignals = getSignalManager().generateSignals();
            } catch (Exception e) {
                Logger.Companion.e(TAG, "Couldn't convert signals for sending. Error: " + e.getMessage());
                strGenerateSignals = null;
            }
        } else {
            strGenerateSignals = null;
        }
        if ((configExtension == null || configExtension.length() == 0) && (strGenerateSignals == null || strGenerateSignals.length() == 0)) {
            return null;
        }
        return new CommonRequestBody.RequestExt(configExtension, strGenerateSignals, Long.valueOf(ConfigManager.INSTANCE.configLastValidatedTimestamp()));
    }

    public static /* synthetic */ CommonRequestBody.RequestExt getExtBody$default(VungleApiClient vungleApiClient, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = false;
        }
        return vungleApiClient.getExtBody(z2);
    }

    private final String getPlacementID(RequestBody requestBody) {
        List<String> placements;
        try {
            c cVar = json;
            CommonRequestBody.RequestParam request = ((CommonRequestBody) cVar.a(q.q0(cVar.f11599b, b0.b(CommonRequestBody.class)), bodyToString(requestBody))).getRequest();
            if (request == null || (placements = request.getPlacements()) == null) {
                return "";
            }
            String str = placements.get(0);
            return str == null ? "" : str;
        } catch (Exception unused) {
            return "";
        }
    }

    private final SignalManager getSignalManager() {
        return (SignalManager) this.signalManager$delegate.getValue();
    }

    private final CommonRequestBody.User getUserBody(boolean z2) {
        CommonRequestBody.User user = new CommonRequestBody.User((CommonRequestBody.GDPR) null, (CommonRequestBody.CCPA) null, (CommonRequestBody.COPPA) null, (FirstPartyData) null, (CommonRequestBody.IAB) null, 31, (kotlin.jvm.internal.f) null);
        PrivacyManager privacyManager = PrivacyManager.INSTANCE;
        user.setGdpr(new CommonRequestBody.GDPR(privacyManager.getConsentStatus(), privacyManager.getConsentSource(), privacyManager.getConsentTimestamp(), privacyManager.getConsentMessageVersion()));
        user.setCcpa(new CommonRequestBody.CCPA(privacyManager.getCcpaStatus()));
        if (privacyManager.getCoppaStatus() != COPPA.COPPA_NOTSET) {
            user.setCoppa(new CommonRequestBody.COPPA(privacyManager.getCoppaStatus().getValue()));
        }
        if (privacyManager.shouldSendTCFString()) {
            user.setIab(new CommonRequestBody.IAB(privacyManager.getIABTCFString()));
        }
        if (z2) {
            user.setFpd(VungleAds.firstPartyData);
        }
        return user;
    }

    public static /* synthetic */ CommonRequestBody.User getUserBody$default(VungleApiClient vungleApiClient, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = false;
        }
        return vungleApiClient.getUserBody(z2);
    }

    private final void initUserAgentLazy() {
        final TimeIntervalMetric timeIntervalMetric = new TimeIntervalMetric(Sdk.SDKMetric.SDKMetricType.USER_AGENT_LOAD_DURATION_MS);
        timeIntervalMetric.markStart();
        this.platform.getUserAgentLazy(new Consumer<String>() { // from class: com.vungle.ads.internal.network.VungleApiClient.initUserAgentLazy.1
            @Override // androidx.core.util.Consumer
            public void accept(String str) throws Throwable {
                if (str == null) {
                    Logger.Companion.e(VungleApiClient.TAG, "Cannot Get UserAgent. Setting Default Device UserAgent");
                    new UserAgentError().logErrorNoReturnValue$vungle_ads_release();
                } else {
                    timeIntervalMetric.markEnd();
                    AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, timeIntervalMetric, (LogEntry) null, (String) null, 6, (Object) null);
                    this.uaString = str;
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ErrorInfo pingTPAT$default(VungleApiClient vungleApiClient, String str, Map map, String str2, HttpMethod httpMethod, LogEntry logEntry, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            map = null;
        }
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        if ((i2 & 8) != 0) {
            httpMethod = HttpMethod.GET;
        }
        if ((i2 & 16) != 0) {
            logEntry = null;
        }
        return vungleApiClient.pingTPAT(str, map, str2, httpMethod, logEntry);
    }

    public static /* synthetic */ CommonRequestBody requestBody$default(VungleApiClient vungleApiClient, boolean z2, boolean z7, int i2, Object obj) throws IllegalStateException {
        if ((i2 & 1) != 0) {
            z2 = false;
        }
        if ((i2 & 2) != 0) {
            z7 = false;
        }
        return vungleApiClient.requestBody(z2, z7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: responseInterceptor$lambda-0, reason: not valid java name */
    public static final okhttp3.Response m3330responseInterceptor$lambda0(VungleApiClient this$0, Interceptor.Chain chain) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(chain, "chain");
        Request request = chain.request();
        try {
            try {
                okhttp3.Response responseProceed = chain.proceed(request);
                String str = responseProceed.headers().get(CommonGatewayClient.HEADER_RETRY_AFTER);
                if (str != null && str.length() != 0) {
                    try {
                        long j = Long.parseLong(str);
                        if (j > 0) {
                            String strEncodedPath = request.url().encodedPath();
                            long jCurrentTimeMillis = (j * ((long) 1000)) + System.currentTimeMillis();
                            if (t.f0(strEncodedPath, "ads", false)) {
                                String placementID = this$0.getPlacementID(request.body());
                                if (placementID.length() > 0) {
                                    this$0.retryAfterDataMap.put(placementID, Long.valueOf(jCurrentTimeMillis));
                                }
                            }
                        }
                    } catch (Exception unused) {
                        Logger.Companion.d(TAG, "Retry-After value is not an valid value");
                    }
                }
                return responseProceed;
            } catch (Exception e) {
                Logger.Companion.e(TAG, "Exception: " + e.getMessage() + " for " + request.url());
                return this$0.defaultErrorResponse(request);
            }
        } catch (OutOfMemoryError unused2) {
            Logger.Companion.e(TAG, "OOM for " + request.url());
            return this$0.defaultErrorResponse(request);
        }
    }

    @VisibleForTesting
    public final void addPlaySvcAvailabilityInCookie(boolean z2) {
        this.filePreferences.put(Cookie.IS_PLAY_SERVICE_AVAILABLE, z2).apply();
    }

    public final boolean checkIsRetryAfterActive(String placementID) {
        kotlin.jvm.internal.k.e(placementID, "placementID");
        Long l = this.retryAfterDataMap.get(placementID);
        if ((l != null ? l.longValue() : 0L) > System.currentTimeMillis()) {
            return true;
        }
        this.retryAfterDataMap.remove(placementID);
        return false;
    }

    public final Call<ConfigPayload> config() throws IOException {
        AppNode appNode = this.appBody;
        if (appNode == null) {
            return null;
        }
        CommonRequestBody commonRequestBody = new CommonRequestBody(getDeviceBody$vungle_ads_release(true), appNode, getUserBody$default(this, false, 1, null), (CommonRequestBody.RequestExt) null, (CommonRequestBody.RequestParam) null, 24, (kotlin.jvm.internal.f) null);
        CommonRequestBody.RequestExt extBody$default = getExtBody$default(this, false, 1, null);
        if (extBody$default != null) {
            commonRequestBody.setExt(extBody$default);
        }
        FileUtility fileUtility = FileUtility.INSTANCE;
        String strConcat = BASE_URL;
        if (!fileUtility.isValidUrl(strConcat)) {
            strConcat = "https://config.ads.vungle.com/";
        }
        if (!t.f0(strConcat, "/", false)) {
            strConcat = strConcat.concat("/");
        }
        return this.api.config(VungleHeader.INSTANCE.getHeaderUa(), strConcat + "config", commonRequestBody);
    }

    public final AppNode getAppBody$vungle_ads_release() {
        return this.appBody;
    }

    public final String getConnectionTypeDetail(int i2) {
        if (i2 == 1) {
            return "gprs";
        }
        if (i2 == 2) {
            return "edge";
        }
        if (i2 == 20) {
            return "5g";
        }
        switch (i2) {
            case 4:
                return "wcdma";
            case 5:
                return "cdma_evdo_0";
            case 6:
                return "cdma_evdo_a";
            case 7:
                return "cdma_1xrtt";
            case 8:
                return "hsdpa";
            case 9:
                return "hsupa";
            default:
                switch (i2) {
                    case 12:
                        return "cdma_evdo_b";
                    case 13:
                        return "lte";
                    case 14:
                        return "hrpd";
                    default:
                        return "unknown";
                }
        }
    }

    public final String getConnectionTypeDetail$vungle_ads_release() {
        if (ContextCompat.checkSelfPermission(this.applicationContext, "android.permission.ACCESS_NETWORK_STATE") != 0) {
            return null;
        }
        Object systemService = this.applicationContext.getSystemService("connectivity");
        kotlin.jvm.internal.k.c(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        return activeNetworkInfo != null ? getConnectionTypeDetail(activeNetworkInfo.getSubtype()) : "unknown";
    }

    @VisibleForTesting
    public final synchronized DeviceNode getDeviceBody$vungle_ads_release(boolean z2) throws IllegalStateException {
        DeviceNode deviceNodeCopy$default;
        String str;
        try {
            DeviceNode basicDeviceBody = this.baseDeviceInfo;
            if (basicDeviceBody == null) {
                basicDeviceBody = getBasicDeviceBody(this.applicationContext);
                this.baseDeviceInfo = basicDeviceBody;
            }
            deviceNodeCopy$default = DeviceNode.copy$default(basicDeviceBody, null, null, null, null, null, 0, 0, null, null, null, null, 2047, null);
            DeviceNode.VungleExt vungleExt = new DeviceNode.VungleExt(false, (String) null, (Integer) null, 0.0f, (String) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 0.0f, 0, false, 0, false, (String) null, (String) null, (Long) null, (Long) null, (Long) null, (Long) null, 4194303, (kotlin.jvm.internal.f) null);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Object systemService = this.applicationContext.getSystemService("window");
            kotlin.jvm.internal.k.c(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
            if (defaultDisplay != null) {
                defaultDisplay.getMetrics(displayMetrics);
            }
            deviceNodeCopy$default.setH(displayMetrics.heightPixels);
            deviceNodeCopy$default.setW(displayMetrics.widthPixels);
            AdvertisingInfo advertisingInfo = this.advertisingInfo;
            if (advertisingInfo == null) {
                advertisingInfo = this.platform.getAdvertisingInfo();
            }
            this.advertisingInfo = advertisingInfo;
            String advertisingId = advertisingInfo != null ? advertisingInfo.getAdvertisingId() : null;
            AdvertisingInfo advertisingInfo2 = this.advertisingInfo;
            Boolean boolValueOf = advertisingInfo2 != null ? Boolean.valueOf(advertisingInfo2.getLimitAdTracking()) : null;
            PrivacyManager privacyManager = PrivacyManager.INSTANCE;
            if (privacyManager.shouldSendAdIds()) {
                if (advertisingId != null) {
                    if ("Amazon".equals(Build.MANUFACTURER)) {
                        vungleExt.setAmazonAdvertisingId(advertisingId);
                    } else {
                        vungleExt.setGaid(advertisingId);
                    }
                    deviceNodeCopy$default.setIfa(advertisingId);
                } else {
                    deviceNodeCopy$default.setIfa("");
                }
            }
            if (z2 || !privacyManager.shouldSendAdIds()) {
                deviceNodeCopy$default.setIfa(null);
                vungleExt.setGaid(null);
                vungleExt.setAmazonAdvertisingId(null);
            }
            Boolean bool = Boolean.TRUE;
            boolean zHasSystemFeature = false;
            deviceNodeCopy$default.setLmt(kotlin.jvm.internal.k.a(boolValueOf, bool) ? 1 : 0);
            vungleExt.setGooglePlayServicesAvailable(bool.equals(isGooglePlayServicesAvailable()));
            if (privacyManager.allowDeviceIDFromTCF() != PrivacyManager.DeviceIdAllowed.DISABLE_ID) {
                String appSetId = this.platform.getAppSetId();
                if (appSetId != null) {
                    vungleExt.setAppSetId(appSetId);
                }
                Integer appSetIdScope = this.platform.getAppSetIdScope();
                if (appSetIdScope != null) {
                    vungleExt.setAppSetIdScope(Integer.valueOf(appSetIdScope.intValue()));
                }
            }
            Intent intentRegisterReceiver = this.applicationContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intentRegisterReceiver != null) {
                int intExtra = intentRegisterReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
                int intExtra2 = intentRegisterReceiver.getIntExtra("scale", -1);
                if (intExtra > 0 && intExtra2 > 0) {
                    vungleExt.setBatteryLevel(intExtra / intExtra2);
                }
                int intExtra3 = intentRegisterReceiver.getIntExtra("status", -1);
                if (intExtra3 == -1) {
                    str = "UNKNOWN";
                } else if (intExtra3 == 2 || intExtra3 == 5) {
                    int intExtra4 = intentRegisterReceiver.getIntExtra("plugged", -1);
                    str = intExtra4 != 1 ? intExtra4 != 2 ? intExtra4 != 4 ? "BATTERY_PLUGGED_OTHERS" : "BATTERY_PLUGGED_WIRELESS" : "BATTERY_PLUGGED_USB" : "BATTERY_PLUGGED_AC";
                } else {
                    str = "NOT_CHARGING";
                }
            } else {
                str = "UNKNOWN";
            }
            vungleExt.setBatteryState(str);
            Object systemService2 = this.applicationContext.getSystemService("power");
            kotlin.jvm.internal.k.c(systemService2, "null cannot be cast to non-null type android.os.PowerManager");
            vungleExt.setBatterySaverEnabled(((PowerManager) systemService2).isPowerSaveMode() ? 1 : 0);
            String connectionType = getConnectionType();
            if (connectionType != null) {
                vungleExt.setConnectionType(connectionType);
            }
            String connectionTypeDetail$vungle_ads_release = getConnectionTypeDetail$vungle_ads_release();
            if (connectionTypeDetail$vungle_ads_release != null) {
                vungleExt.setConnectionTypeDetail(connectionTypeDetail$vungle_ads_release);
            }
            vungleExt.setLocale(Locale.getDefault().toString());
            vungleExt.setLanguage(Locale.getDefault().getLanguage());
            vungleExt.setTimeZone(TimeZone.getDefault().getID());
            vungleExt.setVolumeLevel(this.platform.getVolumeLevel());
            vungleExt.setSoundEnabled(this.platform.isSoundEnabled() ? 1 : 0);
            if ("Amazon".equals(Build.MANUFACTURER)) {
                zHasSystemFeature = this.applicationContext.getPackageManager().hasSystemFeature("amazon.hardware.fire_tv");
            } else {
                Object systemService3 = this.applicationContext.getSystemService("uimode");
                kotlin.jvm.internal.k.c(systemService3, "null cannot be cast to non-null type android.app.UiModeManager");
                if (((UiModeManager) systemService3).getCurrentModeType() == 4) {
                    zHasSystemFeature = true;
                }
            }
            vungleExt.setTv(zHasSystemFeature);
            vungleExt.setSideloadEnabled(this.platform.isSideLoaded());
            vungleExt.setSdCardAvailable(this.platform.isSdCardPresent() ? 1 : 0);
            if (ConfigManager.INSTANCE.otEnabled()) {
                vungleExt.setSit(Long.valueOf(this.platform.getSDKInstallationTime()));
                vungleExt.setOit(Long.valueOf(this.platform.getOSInstallationTime()));
                vungleExt.setOrt(Long.valueOf(this.platform.getLastBootTime()));
                vungleExt.setObt(Long.valueOf(this.platform.getBuildTime()));
            }
            deviceNodeCopy$default.setUa(this.uaString);
            deviceNodeCopy$default.setExt(vungleExt);
        } catch (Throwable th) {
            throw th;
        }
        return deviceNodeCopy$default;
    }

    public final VungleApi getGzipApi$vungle_ads_release() {
        return this.gzipApi;
    }

    @VisibleForTesting
    public final Boolean getPlayServicesAvailabilityFromAPI() {
        Boolean boolValueOf = null;
        try {
            GoogleApiAvailabilityLight googleApiAvailabilityLight = GoogleApiAvailabilityLight.getInstance();
            kotlin.jvm.internal.k.d(googleApiAvailabilityLight, "getInstance()");
            boolean z2 = googleApiAvailabilityLight.isGooglePlayServicesAvailable(this.applicationContext) == 0;
            boolValueOf = Boolean.valueOf(z2);
            addPlaySvcAvailabilityInCookie(z2);
            return boolValueOf;
        } catch (Exception unused) {
            Logger.Companion.w(TAG, "Unexpected exception from Play services lib.");
            return boolValueOf;
        } catch (NoClassDefFoundError unused2) {
            Logger.Companion.w(TAG, "Play services Not available");
            boolValueOf = Boolean.FALSE;
            try {
                addPlaySvcAvailabilityInCookie(false);
            } catch (Exception unused3) {
                Logger.Companion.w(TAG, "Failure to write GPS availability to DB");
            }
            return boolValueOf;
        }
    }

    @VisibleForTesting
    public final Boolean getPlayServicesAvailabilityFromCookie() {
        return this.filePreferences.getBoolean(Cookie.IS_PLAY_SERVICE_AVAILABLE);
    }

    public final Interceptor getResponseInterceptor$vungle_ads_release() {
        return this.responseInterceptor;
    }

    public final Map<String, Long> getRetryAfterDataMap$vungle_ads_release() {
        return this.retryAfterDataMap;
    }

    public final long getRetryAfterHeaderValue(String placementID) {
        kotlin.jvm.internal.k.e(placementID, "placementID");
        Long l = this.retryAfterDataMap.get(placementID);
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    public final synchronized void initialize(String appId) {
        PackageInfo packageInfo;
        try {
            kotlin.jvm.internal.k.e(appId, "appId");
            VungleHeader.INSTANCE.setAppId(appId);
            String str = "1.0";
            try {
                if (Build.VERSION.SDK_INT >= 33) {
                    packageInfo = this.applicationContext.getPackageManager().getPackageInfo(this.applicationContext.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
                    kotlin.jvm.internal.k.d(packageInfo, "{\n                    ap…      )\n                }");
                } else {
                    packageInfo = this.applicationContext.getPackageManager().getPackageInfo(this.applicationContext.getPackageName(), 0);
                    kotlin.jvm.internal.k.d(packageInfo, "{\n                    ap…      )\n                }");
                }
                String str2 = packageInfo.versionName;
                kotlin.jvm.internal.k.d(str2, "packageInfo.versionName");
                str = str2;
            } catch (Exception unused) {
            }
            VungleHeader.INSTANCE.setAppVersion(str);
            this.baseDeviceInfo = getBasicDeviceBody(this.applicationContext);
            String packageName = this.applicationContext.getPackageName();
            kotlin.jvm.internal.k.d(packageName, "applicationContext.packageName");
            this.appBody = new AppNode(packageName, str, appId);
            this.isGooglePlayServicesAvailable = getPlayServicesAvailabilityFromAPI();
        } catch (Throwable th) {
            throw th;
        }
    }

    @VisibleForTesting
    public final Boolean isGooglePlayServicesAvailable() {
        if (this.isGooglePlayServicesAvailable == null) {
            this.isGooglePlayServicesAvailable = getPlayServicesAvailabilityFromCookie();
        }
        if (this.isGooglePlayServicesAvailable == null) {
            this.isGooglePlayServicesAvailable = getPlayServicesAvailabilityFromAPI();
        }
        return this.isGooglePlayServicesAvailable;
    }

    public final ErrorInfo pingTPAT(String url, Map<String, String> map, String str, HttpMethod requestType, LogEntry logEntry) {
        okhttp3.Response responseRaw;
        kotlin.jvm.internal.k.e(url, "url");
        kotlin.jvm.internal.k.e(requestType, "requestType");
        if (url.length() == 0 || HttpUrl.Companion.parse(url) == null) {
            return new ErrorInfo("Invalid URL", true, false, 4, null);
        }
        try {
            if (!(Build.VERSION.SDK_INT >= 24 ? NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(new URL(url).getHost()) : NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) && URLUtil.isHttpUrl(url)) {
                return new ErrorInfo("Clear Text Traffic is blocked", false, false, 6, null);
            }
            try {
                String str2 = this.uaString;
                if (str2 == null) {
                    str2 = "";
                }
                Response<Void> responseExecute = this.api.pingTPAT(str2, url, requestType, map, str != null ? RequestBody.Companion.create(str, MediaType.Companion.parse(G5.L)) : null).execute();
                if (responseExecute != null && responseExecute.isSuccessful()) {
                    return null;
                }
                Integer numValueOf = (responseExecute == null || (responseRaw = responseExecute.raw()) == null) ? null : Integer.valueOf(responseRaw.code());
                boolean z2 = false;
                if (l.T0(m.H0(301, 302, 307, 308), numValueOf)) {
                    AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, Sdk.SDKMetric.SDKMetricType.NOTIFICATION_REDIRECT, 0L, logEntry, url, 2, null);
                    return null;
                }
                d dVar = new d(500, CommonGatewayClient.CODE_599, 1);
                if (numValueOf != null) {
                    int iIntValue = numValueOf.intValue();
                    if (500 <= iIntValue && iIntValue <= dVar.f12710b) {
                        z2 = true;
                    }
                }
                StringBuilder sb = new StringBuilder("unsuccessful response, error code: ");
                sb.append(numValueOf);
                sb.append(", message: ");
                sb.append(responseExecute != null ? responseExecute.message() : null);
                return new ErrorInfo(sb.toString(), false, z2, 2, null);
            } catch (Throwable th) {
                String localizedMessage = th.getLocalizedMessage();
                if (localizedMessage == null) {
                    localizedMessage = "IOException";
                }
                return new ErrorInfo(localizedMessage, false, true, 2, null);
            }
        } catch (MalformedURLException e) {
            String localizedMessage2 = e.getLocalizedMessage();
            if (localizedMessage2 == null) {
                localizedMessage2 = "MalformedURLException";
            }
            return new ErrorInfo(localizedMessage2, true, false, 4, null);
        }
    }

    public final void reportErrors(BlockingQueue<Sdk.SDKError.Builder> errors, final AnalyticsClient.RequestListener requestListener) {
        kotlin.jvm.internal.k.e(errors, "errors");
        kotlin.jvm.internal.k.e(requestListener, "requestListener");
        String errorLoggingEndpoint = ConfigManager.INSTANCE.getErrorLoggingEndpoint();
        if (errorLoggingEndpoint.length() == 0) {
            requestListener.onFailure();
            return;
        }
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        for (Sdk.SDKError.Builder builder : errors) {
            builder.setSessionId(getSignalManager().getUuid());
            Placement placement = ConfigManager.INSTANCE.getPlacement(builder.getPlacementReferenceId());
            if (placement != null) {
                builder.setIsHbPlacement(placement.getHeaderBidding() ? 1L : 0L);
                String type = placement.getType();
                if (type == null) {
                    type = "";
                }
                builder.setPlacementType(type);
            }
            String connectionType = getConnectionType();
            if (connectionType != null) {
                builder.setConnectionType(connectionType);
            }
            String connectionTypeDetail$vungle_ads_release = getConnectionTypeDetail$vungle_ads_release();
            if (connectionTypeDetail$vungle_ads_release != null) {
                builder.setConnectionTypeDetail(connectionTypeDetail$vungle_ads_release);
            }
            Sdk.SDKError sDKErrorBuild = builder.build();
            Logger.Companion.e(TAG, "Sending Error: " + sDKErrorBuild.getReason());
            linkedBlockingQueue.add(sDKErrorBuild);
        }
        Sdk.SDKErrorBatch sDKErrorBatchBuild = Sdk.SDKErrorBatch.newBuilder().addAllErrors(linkedBlockingQueue).build();
        RequestBody.Companion companion = RequestBody.Companion;
        byte[] byteArray = sDKErrorBatchBuild.toByteArray();
        kotlin.jvm.internal.k.d(byteArray, "batch.toByteArray()");
        this.api.sendErrors(VungleHeader.INSTANCE.getHeaderUa(), errorLoggingEndpoint, companion.create(byteArray, MediaType.Companion.parse(CommonGatewayClient.HEADER_PROTOBUF), 0, sDKErrorBatchBuild.toByteArray().length)).enqueue(new Callback<Void>() { // from class: com.vungle.ads.internal.network.VungleApiClient.reportErrors.2
            @Override // com.vungle.ads.internal.network.Callback
            public void onFailure(Call<Void> call, Throwable th) {
                requestListener.onFailure();
            }

            @Override // com.vungle.ads.internal.network.Callback
            public void onResponse(Call<Void> call, Response<Void> response) {
                requestListener.onSuccess();
            }
        });
    }

    public final void reportMetrics(BlockingQueue<Sdk.SDKMetric.Builder> metrics, final AnalyticsClient.RequestListener requestListener) {
        kotlin.jvm.internal.k.e(metrics, "metrics");
        kotlin.jvm.internal.k.e(requestListener, "requestListener");
        String metricsEndpoint = ConfigManager.INSTANCE.getMetricsEndpoint();
        if (metricsEndpoint.length() == 0) {
            requestListener.onFailure();
            return;
        }
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        for (Sdk.SDKMetric.Builder builder : metrics) {
            builder.setSessionId(getSignalManager().getUuid());
            Placement placement = ConfigManager.INSTANCE.getPlacement(builder.getPlacementReferenceId());
            if (placement != null) {
                builder.setIsHbPlacement(placement.getHeaderBidding() ? 1L : 0L);
                String type = placement.getType();
                if (type == null) {
                    type = "";
                }
                builder.setPlacementType(type);
            }
            String connectionType = getConnectionType();
            if (connectionType != null) {
                builder.setConnectionType(connectionType);
            }
            String connectionTypeDetail$vungle_ads_release = getConnectionTypeDetail$vungle_ads_release();
            if (connectionTypeDetail$vungle_ads_release != null) {
                builder.setConnectionTypeDetail(connectionTypeDetail$vungle_ads_release);
            }
            Sdk.SDKMetric sDKMetricBuild = builder.build();
            Logger.Companion.e(TAG, "Sending Metric: " + sDKMetricBuild.getType());
            linkedBlockingQueue.add(sDKMetricBuild);
        }
        Sdk.MetricBatch metricBatchBuild = Sdk.MetricBatch.newBuilder().addAllMetrics(linkedBlockingQueue).build();
        RequestBody.Companion companion = RequestBody.Companion;
        MediaType mediaType = MediaType.Companion.parse(CommonGatewayClient.HEADER_PROTOBUF);
        byte[] byteArray = metricBatchBuild.toByteArray();
        kotlin.jvm.internal.k.d(byteArray, "batch.toByteArray()");
        this.api.sendMetrics(VungleHeader.INSTANCE.getHeaderUa(), metricsEndpoint, RequestBody.Companion.create$default(companion, mediaType, byteArray, 0, 0, 12, (Object) null)).enqueue(new Callback<Void>() { // from class: com.vungle.ads.internal.network.VungleApiClient.reportMetrics.2
            @Override // com.vungle.ads.internal.network.Callback
            public void onFailure(Call<Void> call, Throwable th) {
                requestListener.onFailure();
            }

            @Override // com.vungle.ads.internal.network.Callback
            public void onResponse(Call<Void> call, Response<Void> response) {
                requestListener.onSuccess();
            }
        });
    }

    public final Call<AdPayload> requestAd(String placement, VungleAdSize vungleAdSize) throws IllegalStateException {
        kotlin.jvm.internal.k.e(placement, "placement");
        ConfigManager configManager = ConfigManager.INSTANCE;
        String adsEndpoint = configManager.getAdsEndpoint();
        CommonRequestBody commonRequestBodyRequestBody = requestBody(!configManager.signalsDisabled(), configManager.fpdEnabled());
        CommonRequestBody.RequestParam requestParam = new CommonRequestBody.RequestParam(q.j0(placement), (CommonRequestBody.AdSizeParam) null, (Long) null, (String) null, (String) null, (String) null, 62, (kotlin.jvm.internal.f) null);
        if (vungleAdSize != null) {
            requestParam.setAdSize(new CommonRequestBody.AdSizeParam(vungleAdSize.getWidth(), vungleAdSize.getHeight()));
        }
        commonRequestBodyRequestBody.setRequest(requestParam);
        return this.gzipApi.ads(VungleHeader.INSTANCE.getHeaderUa(), adsEndpoint, commonRequestBodyRequestBody);
    }

    public final CommonRequestBody requestBody(boolean z2, boolean z7) throws IllegalStateException {
        CommonRequestBody commonRequestBody = new CommonRequestBody(getDeviceBody(), this.appBody, getUserBody(z7), (CommonRequestBody.RequestExt) null, (CommonRequestBody.RequestParam) null, 24, (kotlin.jvm.internal.f) null);
        CommonRequestBody.RequestExt extBody = getExtBody(z2);
        if (extBody != null) {
            commonRequestBody.setExt(extBody);
        }
        return commonRequestBody;
    }

    public final Call<Void> ri(CommonRequestBody.RequestParam request) {
        AppNode appNode;
        kotlin.jvm.internal.k.e(request, "request");
        String riEndpoint = ConfigManager.INSTANCE.getRiEndpoint();
        if (riEndpoint == null || riEndpoint.length() == 0 || (appNode = this.appBody) == null) {
            return null;
        }
        CommonRequestBody commonRequestBody = new CommonRequestBody(getDeviceBody(), appNode, getUserBody$default(this, false, 1, null), (CommonRequestBody.RequestExt) null, (CommonRequestBody.RequestParam) null, 24, (kotlin.jvm.internal.f) null);
        commonRequestBody.setRequest(request);
        CommonRequestBody.RequestExt extBody$default = getExtBody$default(this, false, 1, null);
        if (extBody$default != null) {
            commonRequestBody.setExt(extBody$default);
        }
        return this.api.ri(VungleHeader.INSTANCE.getHeaderUa(), riEndpoint, commonRequestBody);
    }

    public final void sendAdMarkup(String adMarkup, String endpoint) {
        kotlin.jvm.internal.k.e(adMarkup, "adMarkup");
        kotlin.jvm.internal.k.e(endpoint, "endpoint");
        this.api.sendAdMarkup(endpoint, RequestBody.Companion.create(adMarkup, MediaType.Companion.parse(G5.L))).enqueue(new Callback<Void>() { // from class: com.vungle.ads.internal.network.VungleApiClient.sendAdMarkup.1
            @Override // com.vungle.ads.internal.network.Callback
            public void onFailure(Call<Void> call, Throwable th) {
            }

            @Override // com.vungle.ads.internal.network.Callback
            public void onResponse(Call<Void> call, Response<Void> response) {
            }
        });
    }

    public final void setAppBody$vungle_ads_release(AppNode appNode) {
        this.appBody = appNode;
    }

    public final void setGzipApi$vungle_ads_release(VungleApi vungleApi) {
        kotlin.jvm.internal.k.e(vungleApi, "<set-?>");
        this.gzipApi = vungleApi;
    }

    public final void setResponseInterceptor$vungle_ads_release(Interceptor interceptor) {
        kotlin.jvm.internal.k.e(interceptor, "<set-?>");
        this.responseInterceptor = interceptor;
    }

    public final void setRetryAfterDataMap$vungle_ads_release(Map<String, Long> map) {
        kotlin.jvm.internal.k.e(map, "<set-?>");
        this.retryAfterDataMap = map;
    }

    @VisibleForTesting
    public static /* synthetic */ void getAppBody$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getGzipApi$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getResponseInterceptor$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getRetryAfterDataMap$vungle_ads_release$annotations() {
    }
}
