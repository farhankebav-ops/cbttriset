package com.unity3d.services.core.di;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.datastore.core.DataMigration;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreFactory;
import com.unity3d.ads.core.data.datasource.AndroidByteStringDataSource;
import com.unity3d.ads.core.data.datasource.ByteStringDataSource;
import com.unity3d.ads.core.data.model.ByteStringSerializer;
import com.unity3d.ads.core.data.model.UniversalRequestStoreSerializer;
import com.unity3d.ads.core.data.model.WebViewConfigurationStoreSerializer;
import com.unity3d.ads.core.data.repository.DiagnosticEventRepository;
import com.unity3d.ads.core.extensions.ContextExtensionsKt;
import com.unity3d.ads.datastore.ByteStringStoreOuterClass;
import com.unity3d.ads.datastore.UniversalRequestStoreOuterClass;
import com.unity3d.ads.datastore.WebviewConfigurationStore;
import com.unity3d.services.UnityAdsConstants;
import com.unity3d.services.ads.measurements.MeasurementsService;
import com.unity3d.services.ads.token.AsyncTokenStorage;
import com.unity3d.services.ads.token.InMemoryAsyncTokenStorage;
import com.unity3d.services.ads.token.TokenStorage;
import com.unity3d.services.ads.topics.TopicsService;
import com.unity3d.services.core.device.Storage;
import com.unity3d.services.core.device.StorageManager;
import com.unity3d.services.core.device.VolumeChange;
import com.unity3d.services.core.device.VolumeChangeMonitor;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.domain.SDKDispatchers;
import com.unity3d.services.core.misc.JsonStorage;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.request.metrics.SDKMetrics;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.webview.bridge.SharedInstances;
import e6.a;
import gatewayprotocol.v1.AdOperationsConfigurationKt;
import gatewayprotocol.v1.DiagnosticEventsConfigurationKt;
import gatewayprotocol.v1.FeatureFlagsKt;
import gatewayprotocol.v1.NativeConfigurationKt;
import gatewayprotocol.v1.NativeConfigurationOuterClass;
import gatewayprotocol.v1.RequestPolicyKt;
import gatewayprotocol.v1.RequestRetryPolicyKt;
import gatewayprotocol.v1.RequestTimeoutPolicyKt;
import java.io.File;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import q6.a0;
import q6.c0;
import q6.f1;
import q6.h1;
import q6.m0;
import q6.w;
import q6.y;
import q6.z;
import r2.q;
import v6.n;
import x6.d;
import x6.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class UnityAdsModule {

    /* JADX INFO: renamed from: com.unity3d.services.core.di.UnityAdsModule$glInfoDataStore$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 extends l implements a {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context) {
            super(0);
            this.$context = context;
        }

        @Override // e6.a
        public final File invoke() {
            return ContextExtensionsKt.unityAdsDataStoreFile(this.$context, ServiceProvider.DATA_STORE_GL_INFO);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.services.core.di.UnityAdsModule$provideByteStringDataStore$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C29651 extends l implements a {
        final /* synthetic */ Context $context;
        final /* synthetic */ String $dataStoreFile;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C29651(Context context, String str) {
            super(0);
            this.$context = context;
            this.$dataStoreFile = str;
        }

        @Override // e6.a
        public final File invoke() {
            return ContextExtensionsKt.unityAdsDataStoreFile(this.$context, this.$dataStoreFile);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.services.core.di.UnityAdsModule$universalRequestDataStore$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C29661 extends l implements a {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C29661(Context context) {
            super(0);
            this.$context = context;
        }

        @Override // e6.a
        public final File invoke() {
            return ContextExtensionsKt.unityAdsDataStoreFile(this.$context, ServiceProvider.DATA_STORE_UNIVERSAL_REQUEST);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.services.core.di.UnityAdsModule$webViewConfigurationDataStore$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C29671 extends l implements a {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C29671(Context context) {
            super(0);
            this.$context = context;
        }

        @Override // e6.a
        public final File invoke() {
            return ContextExtensionsKt.unityAdsDataStoreFile(this.$context, ServiceProvider.DATA_STORE_WEBVIEW_CONFIG);
        }
    }

    private final NativeConfigurationOuterClass.AdOperationsConfiguration getDefaultAdOperations() {
        AdOperationsConfigurationKt.Dsl.Companion companion = AdOperationsConfigurationKt.Dsl.Companion;
        NativeConfigurationOuterClass.AdOperationsConfiguration.Builder builderNewBuilder = NativeConfigurationOuterClass.AdOperationsConfiguration.newBuilder();
        k.d(builderNewBuilder, "newBuilder()");
        AdOperationsConfigurationKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setLoadTimeoutMs(30000);
        dsl_create.setShowTimeoutMs(10000);
        dsl_create.setGetTokenTimeoutMs(UnityAdsConstants.AdOperations.GET_TOKEN_TIMEOUT_MS);
        return dsl_create._build();
    }

    private final NativeConfigurationOuterClass.RequestPolicy getDefaultRequestPolicy() {
        RequestPolicyKt.Dsl.Companion companion = RequestPolicyKt.Dsl.Companion;
        NativeConfigurationOuterClass.RequestPolicy.Builder builderNewBuilder = NativeConfigurationOuterClass.RequestPolicy.newBuilder();
        k.d(builderNewBuilder, "newBuilder()");
        RequestPolicyKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setRetryPolicy(getDefaultRequestRetryPolicy());
        dsl_create.setTimeoutPolicy(getDefaultRequestTimeoutPolicy());
        return dsl_create._build();
    }

    private final NativeConfigurationOuterClass.RequestRetryPolicy getDefaultRequestRetryPolicy() {
        RequestRetryPolicyKt.Dsl.Companion companion = RequestRetryPolicyKt.Dsl.Companion;
        NativeConfigurationOuterClass.RequestRetryPolicy.Builder builderNewBuilder = NativeConfigurationOuterClass.RequestRetryPolicy.newBuilder();
        k.d(builderNewBuilder, "newBuilder()");
        RequestRetryPolicyKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setMaxDuration(UnityAdsConstants.RequestPolicy.RETRY_MAX_DURATION);
        dsl_create.setRetryWaitBase(500);
        dsl_create.setRetryJitterPct(0.1f);
        dsl_create.setShouldStoreLocally(false);
        dsl_create.setRetryMaxInterval(UnityAdsConstants.RequestPolicy.RETRY_MAX_INTERVAL);
        dsl_create.setRetryScalingFactor(2.0f);
        return dsl_create._build();
    }

    private final NativeConfigurationOuterClass.RequestTimeoutPolicy getDefaultRequestTimeoutPolicy() {
        RequestTimeoutPolicyKt.Dsl.Companion companion = RequestTimeoutPolicyKt.Dsl.Companion;
        NativeConfigurationOuterClass.RequestTimeoutPolicy.Builder builderNewBuilder = NativeConfigurationOuterClass.RequestTimeoutPolicy.newBuilder();
        k.d(builderNewBuilder, "newBuilder()");
        RequestTimeoutPolicyKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setConnectTimeoutMs(30000);
        dsl_create.setReadTimeoutMs(30000);
        dsl_create.setWriteTimeoutMs(30000);
        dsl_create.setOverallTimeoutMs(30000);
        return dsl_create._build();
    }

    private final ByteStringDataSource provideByteStringDataSource(DataStore<ByteStringStoreOuterClass.ByteStringStore> dataStore) {
        return new AndroidByteStringDataSource(dataStore);
    }

    private final DataStore<ByteStringStoreOuterClass.ByteStringStore> provideByteStringDataStore(Context context, w wVar, String str) {
        return DataStoreFactory.create$default(DataStoreFactory.INSTANCE, new ByteStringSerializer(), null, null, c0.b(wVar.plus(c0.e())), new C29651(context, str), 4, null);
    }

    private final JsonStorage provideJsonStorage(StorageManager.StorageType storageType) {
        if (!StorageManager.init(ClientProperties.getApplicationContext())) {
            throw new IllegalStateException("StorageManager failed to initialize");
        }
        Storage storage = StorageManager.getStorage(storageType);
        k.d(storage, "getStorage(storageType)");
        return storage;
    }

    public final Context androidContext() {
        Context applicationContext = ClientProperties.getApplicationContext();
        k.d(applicationContext, "getApplicationContext()");
        return applicationContext;
    }

    public final AsyncTokenStorage asyncTokenStorage(TokenStorage tokenStorage, SDKMetricsSender sdkMetricsSender) {
        k.e(tokenStorage, "tokenStorage");
        k.e(sdkMetricsSender, "sdkMetricsSender");
        return new InMemoryAsyncTokenStorage(null, new Handler(Looper.getMainLooper()), sdkMetricsSender, tokenStorage);
    }

    public final ByteStringDataSource auidDataStore(DataStore<ByteStringStoreOuterClass.ByteStringStore> dataStore) {
        k.e(dataStore, "dataStore");
        return provideByteStringDataSource(dataStore);
    }

    public final w defaultDispatcher() {
        return m0.f13566a;
    }

    public final NativeConfigurationOuterClass.NativeConfiguration defaultNativeConfiguration() {
        NativeConfigurationKt.Dsl.Companion companion = NativeConfigurationKt.Dsl.Companion;
        NativeConfigurationOuterClass.NativeConfiguration.Builder builderNewBuilder = NativeConfigurationOuterClass.NativeConfiguration.newBuilder();
        k.d(builderNewBuilder, "newBuilder()");
        NativeConfigurationKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setAdOperations(getDefaultAdOperations());
        dsl_create.setInitPolicy(getDefaultRequestPolicy());
        dsl_create.setAdPolicy(getDefaultRequestPolicy());
        dsl_create.setOtherPolicy(getDefaultRequestPolicy());
        dsl_create.setOperativeEventPolicy(getDefaultRequestPolicy());
        DiagnosticEventsConfigurationKt.Dsl.Companion companion2 = DiagnosticEventsConfigurationKt.Dsl.Companion;
        NativeConfigurationOuterClass.DiagnosticEventsConfiguration.Builder builderNewBuilder2 = NativeConfigurationOuterClass.DiagnosticEventsConfiguration.newBuilder();
        k.d(builderNewBuilder2, "newBuilder()");
        DiagnosticEventsConfigurationKt.Dsl dsl_create2 = companion2._create(builderNewBuilder2);
        dsl_create2.setEnabled(true);
        dsl_create2.setMaxBatchSize(10);
        dsl_create2.setMaxBatchIntervalMs(30000);
        dsl_create2.setTtmEnabled(false);
        dsl_create.setDiagnosticEvents(dsl_create2._build());
        FeatureFlagsKt.Dsl.Companion companion3 = FeatureFlagsKt.Dsl.Companion;
        NativeConfigurationOuterClass.FeatureFlags.Builder builderNewBuilder3 = NativeConfigurationOuterClass.FeatureFlags.newBuilder();
        k.d(builderNewBuilder3, "newBuilder()");
        FeatureFlagsKt.Dsl dsl_create3 = companion3._create(builderNewBuilder3);
        dsl_create3.setBoldSdkNextSessionEnabled(true);
        dsl_create.setFeatureFlags(dsl_create3._build());
        return dsl_create._build();
    }

    public final ByteStringDataSource gatewayCacheDataStore(DataStore<ByteStringStoreOuterClass.ByteStringStore> dataStore) {
        k.e(dataStore, "dataStore");
        return provideByteStringDataSource(dataStore);
    }

    public final DataStore<ByteStringStoreOuterClass.ByteStringStore> gatewayDataStore(Context context, w dispatcher) {
        k.e(context, "context");
        k.e(dispatcher, "dispatcher");
        return provideByteStringDataStore(context, dispatcher, ServiceProvider.DATA_STORE_GATEWAY_CACHE);
    }

    public final a0 getTokenCoroutineScope(ISDKDispatchers dispatchers, y errorHandler, f1 parentJob) {
        k.e(dispatchers, "dispatchers");
        k.e(errorHandler, "errorHandler");
        k.e(parentJob, "parentJob");
        return c0.b(parentJob.plus(dispatchers.getDefault()).plus(new z(ServiceProvider.NAMED_GET_TOKEN_SCOPE)).plus(errorHandler));
    }

    public final DataStore<ByteStringStoreOuterClass.ByteStringStore> glInfoDataStore(Context context, w dispatcher, DataMigration<ByteStringStoreOuterClass.ByteStringStore> fetchGLInfo) {
        k.e(context, "context");
        k.e(dispatcher, "dispatcher");
        k.e(fetchGLInfo, "fetchGLInfo");
        return DataStoreFactory.create$default(DataStoreFactory.INSTANCE, new ByteStringSerializer(), null, q.j0(fetchGLInfo), c0.b(dispatcher.plus(c0.e())), new AnonymousClass1(context), 2, null);
    }

    public final DataStore<ByteStringStoreOuterClass.ByteStringStore> iapTransactionDataStore(Context context, w dispatcher) {
        k.e(context, "context");
        k.e(dispatcher, "dispatcher");
        return provideByteStringDataStore(context, dispatcher, ServiceProvider.DATA_STORE_IAP_TRANSACTION);
    }

    public final ByteStringDataSource idfiDataStore(DataStore<ByteStringStoreOuterClass.ByteStringStore> dataStore) {
        k.e(dataStore, "dataStore");
        return provideByteStringDataSource(dataStore);
    }

    public final a0 initCoroutineScope(ISDKDispatchers dispatchers, y errorHandler, f1 parentJob) {
        k.e(dispatchers, "dispatchers");
        k.e(errorHandler, "errorHandler");
        k.e(parentJob, "parentJob");
        return c0.b(parentJob.plus(dispatchers.getDefault()).plus(new z(ServiceProvider.NAMED_INIT_SCOPE)).plus(errorHandler));
    }

    public final w ioDispatcher() {
        e eVar = m0.f13566a;
        return d.f17810a;
    }

    public final a0 loadCoroutineScope(ISDKDispatchers dispatchers, y errorHandler, f1 parentJob) {
        k.e(dispatchers, "dispatchers");
        k.e(errorHandler, "errorHandler");
        k.e(parentJob, "parentJob");
        return c0.b(parentJob.plus(dispatchers.getDefault()).plus(new z(ServiceProvider.NAMED_LOAD_SCOPE)).plus(errorHandler));
    }

    public final w mainDispatcher() {
        e eVar = m0.f13566a;
        return n.f17641a;
    }

    public final MeasurementsService measurementService(Context context, ISDKDispatchers dispatchers) {
        k.e(context, "context");
        k.e(dispatchers, "dispatchers");
        return new MeasurementsService(context, dispatchers, SharedInstances.INSTANCE.getWebViewEventSender());
    }

    public final JsonStorage memoryJsonStorage() {
        return provideJsonStorage(StorageManager.StorageType.MEMORY);
    }

    public final DataStore<ByteStringStoreOuterClass.ByteStringStore> nativeConfigurationDataStore(Context context, w dispatcher) {
        k.e(context, "context");
        k.e(dispatcher, "dispatcher");
        return provideByteStringDataStore(context, dispatcher, ServiceProvider.DATA_STORE_NATIVE_CONFIG);
    }

    public final a0 offerwallSignalsCoroutineScope(ISDKDispatchers dispatchers, y errorHandler, f1 parentJob) {
        k.e(dispatchers, "dispatchers");
        k.e(errorHandler, "errorHandler");
        k.e(parentJob, "parentJob");
        return c0.b(parentJob.plus(dispatchers.getDefault()).plus(new z(ServiceProvider.NAMED_OFFERWALL_SCOPE)).plus(errorHandler));
    }

    public final a0 omidCoroutineScope(ISDKDispatchers dispatchers, y errorHandler, f1 parentJob) {
        k.e(dispatchers, "dispatchers");
        k.e(errorHandler, "errorHandler");
        k.e(parentJob, "parentJob");
        return c0.b(parentJob.plus(dispatchers.getDefault()).plus(new z(ServiceProvider.NAMED_OMID_SCOPE)).plus(errorHandler));
    }

    public final DataStore<ByteStringStoreOuterClass.ByteStringStore> privacyDataStore(Context context, w dispatcher) {
        k.e(context, "context");
        k.e(dispatcher, "dispatcher");
        return provideByteStringDataStore(context, dispatcher, ServiceProvider.DATA_STORE_PRIVACY);
    }

    public final DataStore<ByteStringStoreOuterClass.ByteStringStore> privacyFsmDataStore(Context context, w dispatcher) {
        k.e(context, "context");
        k.e(dispatcher, "dispatcher");
        return provideByteStringDataStore(context, dispatcher, ServiceProvider.DATA_STORE_PRIVACY_FSM);
    }

    public final JsonStorage privateJsonStorage() {
        return provideJsonStorage(StorageManager.StorageType.PRIVATE);
    }

    public final f1 publicApiJob(DiagnosticEventRepository diagnosticEventRepository) {
        k.e(diagnosticEventRepository, "diagnosticEventRepository");
        h1 h1VarC = c0.c();
        h1VarC.n(new UnityAdsModule$publicApiJob$1$1(diagnosticEventRepository));
        return h1VarC;
    }

    public final JsonStorage publicJsonStorage() {
        return provideJsonStorage(StorageManager.StorageType.PUBLIC);
    }

    public final a0 scarSignalsCoroutineScope(ISDKDispatchers dispatchers, y errorHandler, f1 parentJob) {
        k.e(dispatchers, "dispatchers");
        k.e(errorHandler, "errorHandler");
        k.e(parentJob, "parentJob");
        return c0.b(parentJob.plus(dispatchers.getDefault()).plus(new z(ServiceProvider.NAMED_SCAR_SCOPE)).plus(errorHandler));
    }

    public final ISDKDispatchers sdkDispatchers() {
        return new SDKDispatchers();
    }

    public final SDKMetricsSender sdkMetrics() {
        SDKMetricsSender sDKMetrics = SDKMetrics.getInstance();
        k.d(sDKMetrics, "getInstance()");
        return sDKMetrics;
    }

    public final a0 showCoroutineScope(ISDKDispatchers dispatchers, y errorHandler, f1 parentJob) {
        k.e(dispatchers, "dispatchers");
        k.e(errorHandler, "errorHandler");
        k.e(parentJob, "parentJob");
        return c0.b(parentJob.plus(dispatchers.getDefault()).plus(new z(ServiceProvider.NAMED_SHOW_SCOPE)).plus(errorHandler));
    }

    public final TopicsService topicsService(Context context, ISDKDispatchers dispatchers) {
        k.e(context, "context");
        k.e(dispatchers, "dispatchers");
        return new TopicsService(context, dispatchers, SharedInstances.INSTANCE.getWebViewEventSender());
    }

    public final a0 transactionCoroutineScope(ISDKDispatchers dispatchers, y errorHandler, f1 parentJob) {
        k.e(dispatchers, "dispatchers");
        k.e(errorHandler, "errorHandler");
        k.e(parentJob, "parentJob");
        return c0.b(parentJob.plus(dispatchers.getDefault()).plus(new z(ServiceProvider.NAMED_TRANSACTION_SCOPE)).plus(errorHandler));
    }

    public final DataStore<UniversalRequestStoreOuterClass.UniversalRequestStore> universalRequestDataStore(Context context, w dispatcher) {
        k.e(context, "context");
        k.e(dispatcher, "dispatcher");
        return DataStoreFactory.create$default(DataStoreFactory.INSTANCE, new UniversalRequestStoreSerializer(), null, null, c0.b(dispatcher.plus(c0.e())), new C29661(context), 4, null);
    }

    public final VolumeChangeMonitor volumeChangeMonitor(VolumeChange volumeChange) {
        k.e(volumeChange, "volumeChange");
        return new VolumeChangeMonitor(SharedInstances.INSTANCE.getWebViewEventSender(), volumeChange);
    }

    public final DataStore<WebviewConfigurationStore.WebViewConfigurationStore> webViewConfigurationDataStore(Context context, w dispatcher) {
        k.e(context, "context");
        k.e(dispatcher, "dispatcher");
        return DataStoreFactory.create$default(DataStoreFactory.INSTANCE, new WebViewConfigurationStoreSerializer(), null, null, c0.b(dispatcher.plus(c0.e())), new C29671(context), 4, null);
    }

    public final ByteStringDataSource iapTransactionDataStore(DataStore<ByteStringStoreOuterClass.ByteStringStore> dataStore) {
        k.e(dataStore, "dataStore");
        return provideByteStringDataSource(dataStore);
    }

    public final ByteStringDataSource nativeConfigurationDataStore(DataStore<ByteStringStoreOuterClass.ByteStringStore> dataStore) {
        k.e(dataStore, "dataStore");
        return provideByteStringDataSource(dataStore);
    }

    public final ByteStringDataSource privacyDataStore(DataStore<ByteStringStoreOuterClass.ByteStringStore> dataStore) {
        k.e(dataStore, "dataStore");
        return provideByteStringDataSource(dataStore);
    }

    public final ByteStringDataSource privacyFsmDataStore(DataStore<ByteStringStoreOuterClass.ByteStringStore> dataStore) {
        k.e(dataStore, "dataStore");
        return provideByteStringDataSource(dataStore);
    }

    public final ByteStringDataSource glInfoDataStore(DataStore<ByteStringStoreOuterClass.ByteStringStore> dataStore) {
        k.e(dataStore, "dataStore");
        return provideByteStringDataSource(dataStore);
    }
}
