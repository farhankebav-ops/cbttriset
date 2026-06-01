package com.vungle.ads.internal;

import a3.d;
import android.content.Context;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.InitializationListener;
import com.vungle.ads.InvalidAppId;
import com.vungle.ads.OutOfMemory;
import com.vungle.ads.SdkVersionTooLow;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.SingleValueMetric;
import com.vungle.ads.TimeIntervalMetric;
import com.vungle.ads.VungleError;
import com.vungle.ads.VungleWrapperFramework;
import com.vungle.ads.internal.executor.Executors;
import com.vungle.ads.internal.model.ConfigPayload;
import com.vungle.ads.internal.network.VungleApiClient;
import com.vungle.ads.internal.network.VungleHeader;
import com.vungle.ads.internal.persistence.FilePreferences;
import com.vungle.ads.internal.privacy.PrivacyManager;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.task.CleanupJob;
import com.vungle.ads.internal.task.JobRunner;
import com.vungle.ads.internal.util.LogEntry;
import com.vungle.ads.internal.util.Logger;
import com.vungle.ads.internal.util.ThreadUtil;
import com.vungle.ads.internal.util.Utils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import n6.m;
import n7.b;
import q5.g;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class VungleInitializer {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "VungleInitializer";
    private AtomicBoolean isInitialized = new AtomicBoolean(false);
    private AtomicBoolean isInitializing = new AtomicBoolean(false);
    private final CopyOnWriteArrayList<InitializationListener> initializationCallbackArray = new CopyOnWriteArrayList<>();
    private final TimeIntervalMetric initDurationMetric = new TimeIntervalMetric(Sdk.SDKMetric.SDKMetricType.INIT_TO_SUCCESS_CALLBACK_DURATION_MS);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.vungle.ads.internal.VungleInitializer$configure$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 extends l implements e6.l {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke(((Boolean) obj).booleanValue());
            return x.f13520a;
        }

        public final void invoke(boolean z2) {
            Logger.Companion.d(VungleInitializer.TAG, "Config fetch result: " + z2);
        }
    }

    /* JADX INFO: renamed from: com.vungle.ads.internal.VungleInitializer$onInitError$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C29761 extends l implements e6.a {
        final /* synthetic */ VungleError $exception;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C29761(VungleError vungleError) {
            super(0);
            this.$exception = vungleError;
        }

        @Override // e6.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m3306invoke();
            return x.f13520a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m3306invoke() {
            Logger.Companion.e(VungleInitializer.TAG, "onError");
            CopyOnWriteArrayList copyOnWriteArrayList = VungleInitializer.this.initializationCallbackArray;
            VungleError vungleError = this.$exception;
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                ((InitializationListener) it.next()).onError(vungleError);
            }
            VungleInitializer.this.initializationCallbackArray.clear();
        }
    }

    /* JADX INFO: renamed from: com.vungle.ads.internal.VungleInitializer$onInitSuccess$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C29771 extends l implements e6.a {
        public C29771() {
            super(0);
        }

        @Override // e6.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m3307invoke();
            return x.f13520a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m3307invoke() {
            Iterator it = VungleInitializer.this.initializationCallbackArray.iterator();
            while (it.hasNext()) {
                ((InitializationListener) it.next()).onSuccess();
            }
            VungleInitializer.this.initializationCallbackArray.clear();
        }
    }

    private final void configure(Context context, String str) {
        Context context2;
        boolean z2;
        try {
            ServiceLocator.Companion companion = ServiceLocator.Companion;
            g gVar = g.f13494a;
            q5.f fVarB = b.B(gVar, new VungleInitializer$configure$$inlined$inject$1(context));
            ConfigManager configManager = ConfigManager.INSTANCE;
            ConfigPayload cachedConfig = configManager.getCachedConfig(m3299configure$lambda4(fVarB), str);
            if (cachedConfig != null) {
                context2 = context;
                ConfigManager.initWithConfig$vungle_ads_release$default(configManager, context2, cachedConfig, true, null, 8, null);
                z2 = true;
            } else {
                context2 = context;
                z2 = false;
            }
            this.isInitialized.set(true);
            onInitSuccess();
            Logger.Companion.d(TAG, "Running cleanup jobs. " + Thread.currentThread().getId());
            m3300configure$lambda5(b.B(gVar, new VungleInitializer$configure$$inlined$inject$2(context2))).execute(CleanupJob.Companion.makeJobInfo$default(CleanupJob.Companion, null, 1, null));
            if (z2) {
                return;
            }
            configManager.fetchConfigAsync$vungle_ads_release(context2, AnonymousClass1.INSTANCE);
        } catch (Throwable th) {
            Logger.Companion.e(TAG, "Cannot get config", th);
        }
    }

    /* JADX INFO: renamed from: configure$lambda-4, reason: not valid java name */
    private static final FilePreferences m3299configure$lambda4(q5.f fVar) {
        return (FilePreferences) fVar.getValue();
    }

    /* JADX INFO: renamed from: configure$lambda-5, reason: not valid java name */
    private static final JobRunner m3300configure$lambda5(q5.f fVar) {
        return (JobRunner) fVar.getValue();
    }

    private final boolean hasInvalidChar(String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (!Character.isLetterOrDigit(cCharAt) && cCharAt != '.') {
                return true;
            }
        }
        return false;
    }

    private final boolean hasRequiredNetworkPermissions(Context context) {
        return (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0) && (ContextCompat.checkSelfPermission(context, "android.permission.INTERNET") == 0);
    }

    /* JADX INFO: renamed from: init$lambda-0, reason: not valid java name */
    private static final Executors m3301init$lambda0(q5.f fVar) {
        return (Executors) fVar.getValue();
    }

    /* JADX INFO: renamed from: init$lambda-1, reason: not valid java name */
    private static final VungleApiClient m3302init$lambda1(q5.f fVar) {
        return (VungleApiClient) fVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: init$lambda-2, reason: not valid java name */
    public static final void m3303init$lambda2(VungleInitializer this$0, Context context, String appId, q5.f vungleApiClient$delegate) {
        k.e(this$0, "this$0");
        k.e(context, "$context");
        k.e(appId, "$appId");
        k.e(vungleApiClient$delegate, "$vungleApiClient$delegate");
        if (!this$0.hasRequiredNetworkPermissions(context)) {
            Logger.Companion.e(TAG, "Network permissions not granted");
            ThreadUtil.INSTANCE.runOnUiThread(new VungleInitializer$init$1$1(this$0));
        } else {
            PrivacyManager.INSTANCE.init(context);
            m3302init$lambda1(vungleApiClient$delegate).initialize(appId);
            this$0.configure(context, appId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: init$lambda-3, reason: not valid java name */
    public static final void m3304init$lambda3(VungleInitializer this$0) throws Throwable {
        k.e(this$0, "this$0");
        this$0.onInitError(new OutOfMemory("Config: Out of Memory").logError$vungle_ads_release());
    }

    private final boolean isAppIdInvalid(String str) {
        return m.A0(str) || hasInvalidChar(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onInitError(VungleError vungleError) throws Throwable {
        this.isInitializing.set(false);
        String localizedMessage = vungleError.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = "Exception code is " + vungleError.getCode();
        }
        this.initDurationMetric.setMetricType(Sdk.SDKMetric.SDKMetricType.INIT_TO_FAIL_CALLBACK_DURATION_MS);
        this.initDurationMetric.markEnd();
        AnalyticsClient.INSTANCE.logMetric$vungle_ads_release(this.initDurationMetric, (LogEntry) null, localizedMessage);
        ThreadUtil.INSTANCE.runOnUiThread(new C29761(vungleError));
        Logger.Companion.e(TAG, localizedMessage);
    }

    private final void onInitSuccess() throws Throwable {
        this.isInitializing.set(false);
        this.initDurationMetric.setMetricType(Sdk.SDKMetric.SDKMetricType.INIT_TO_SUCCESS_CALLBACK_DURATION_MS);
        this.initDurationMetric.markEnd();
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.initDurationMetric, (LogEntry) null, (String) null, 6, (Object) null);
        Logger.Companion.d(TAG, "onSuccess " + Thread.currentThread().getId());
        ThreadUtil.INSTANCE.runOnUiThread(new C29771());
    }

    public final void deInit$vungle_ads_release() {
        ServiceLocator.Companion.deInit();
        VungleApiClient.Companion.reset$vungle_ads_release();
        this.isInitialized.set(false);
        this.isInitializing.set(false);
        this.initializationCallbackArray.clear();
    }

    public final void init(String appId, Context context, InitializationListener initializationCallback) throws Throwable {
        k.e(appId, "appId");
        k.e(context, "context");
        k.e(initializationCallback, "initializationCallback");
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, new SingleValueMetric(Sdk.SDKMetric.SDKMetricType.SDK_INIT_API), (LogEntry) null, (String) null, 6, (Object) null);
        this.initDurationMetric.markStart();
        this.initializationCallbackArray.add(initializationCallback);
        if (isAppIdInvalid(appId)) {
            StringBuilder sbY = a1.a.y("App id invalid: ", appId, ", package name: ");
            sbY.append(context.getPackageName());
            onInitError(new InvalidAppId(sbY.toString()).logError$vungle_ads_release());
            return;
        }
        if (Utils.INSTANCE.isOSVersionInvalid()) {
            Logger.Companion.e(TAG, "Init: SDK is supported only for API versions 25 and above.");
            onInitError(new SdkVersionTooLow("Init: SDK is supported only for API versions 25 and above.").logError$vungle_ads_release());
            return;
        }
        ConfigManager.INSTANCE.setAppId$vungle_ads_release(appId);
        if (this.isInitialized.get()) {
            Logger.Companion.d(TAG, "init already complete");
            onInitSuccess();
        } else {
            if (this.isInitializing.getAndSet(true)) {
                Logger.Companion.d(TAG, "init already in progress");
                return;
            }
            ServiceLocator.Companion companion = ServiceLocator.Companion;
            g gVar = g.f13494a;
            m3301init$lambda0(b.B(gVar, new VungleInitializer$init$$inlined$inject$1(context))).getBackgroundExecutor().execute(new d(this, context, appId, b.B(gVar, new VungleInitializer$init$$inlined$inject$2(context)), 7), new a3.b(this, 28));
        }
    }

    public final boolean isInitialized() {
        return this.isInitialized.get();
    }

    public final AtomicBoolean isInitialized$vungle_ads_release() {
        return this.isInitialized;
    }

    public final AtomicBoolean isInitializing$vungle_ads_release() {
        return this.isInitializing;
    }

    public final void setInitialized$vungle_ads_release(AtomicBoolean atomicBoolean) {
        k.e(atomicBoolean, "<set-?>");
        this.isInitialized = atomicBoolean;
    }

    public final void setInitializing$vungle_ads_release(AtomicBoolean atomicBoolean) {
        k.e(atomicBoolean, "<set-?>");
        this.isInitializing = atomicBoolean;
    }

    public final void setIntegrationName(VungleWrapperFramework wrapperFramework, String wrapperFrameworkVersion) {
        k.e(wrapperFramework, "wrapperFramework");
        k.e(wrapperFrameworkVersion, "wrapperFrameworkVersion");
        if (wrapperFramework == VungleWrapperFramework.none) {
            Logger.Companion.e(TAG, "Wrapper is null or is none");
            return;
        }
        VungleHeader vungleHeader = VungleHeader.INSTANCE;
        String headerUa = vungleHeader.getHeaderUa();
        String str = wrapperFramework.name() + (wrapperFrameworkVersion.length() > 0 ? "/".concat(wrapperFrameworkVersion) : "");
        if (m.q0(headerUa, str, false)) {
            Logger.Companion.w(TAG, "Wrapper info already set");
            return;
        }
        vungleHeader.setHeaderUa(headerUa + ';' + str);
        if (isInitialized()) {
            Logger.Companion.w(TAG, "VUNGLE WARNING: SDK already initialized, you should've set wrapper info before");
        }
    }

    @VisibleForTesting
    public static /* synthetic */ void isInitialized$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void isInitializing$vungle_ads_release$annotations() {
    }
}
