package com.unity3d.services.core.di;

import android.content.Context;
import androidx.datastore.core.DataMigration;
import androidx.datastore.core.DataStore;
import com.unity3d.ads.adplayer.AdPlayerScope;
import com.unity3d.ads.adplayer.AndroidWebViewClient;
import com.unity3d.ads.core.configuration.AlternativeFlowReader;
import com.unity3d.ads.core.configuration.AndroidManifestIntPropertyReader;
import com.unity3d.ads.core.configuration.CommonAlternativeFlowReader;
import com.unity3d.ads.core.configuration.GameServerIdReader;
import com.unity3d.ads.core.configuration.MediationInitBlobMetadataReader;
import com.unity3d.ads.core.configuration.MediationTraitsMetadataReader;
import com.unity3d.ads.core.data.datasource.AnalyticsDataSource;
import com.unity3d.ads.core.data.datasource.AndroidAnalyticsDataSource;
import com.unity3d.ads.core.data.datasource.AndroidAppSetIdDataSource;
import com.unity3d.ads.core.data.datasource.AndroidDeveloperConsentDataSource;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import com.unity3d.ads.core.data.datasource.AndroidFIdDataSource;
import com.unity3d.ads.core.data.datasource.AndroidFIdExistenceDataSource;
import com.unity3d.ads.core.data.datasource.AndroidLegacyConfigStoreDataSource;
import com.unity3d.ads.core.data.datasource.AndroidLegacyUserConsentDataSource;
import com.unity3d.ads.core.data.datasource.AndroidLifecycleDataSource;
import com.unity3d.ads.core.data.datasource.AndroidLocalCacheDataSource;
import com.unity3d.ads.core.data.datasource.AndroidMediationDataSource;
import com.unity3d.ads.core.data.datasource.AndroidPrivacyDeviceInfoDataSource;
import com.unity3d.ads.core.data.datasource.AndroidRemoteCacheDataSource;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import com.unity3d.ads.core.data.datasource.AndroidStoreDataSource;
import com.unity3d.ads.core.data.datasource.AndroidTcfDataSource;
import com.unity3d.ads.core.data.datasource.AndroidUnityBootConfigDataSource;
import com.unity3d.ads.core.data.datasource.AndroidUnityInfoDataSource;
import com.unity3d.ads.core.data.datasource.ByteStringDataSource;
import com.unity3d.ads.core.data.datasource.CacheDataSource;
import com.unity3d.ads.core.data.datasource.DeveloperConsentDataSource;
import com.unity3d.ads.core.data.datasource.DynamicDeviceInfoDataSource;
import com.unity3d.ads.core.data.datasource.FIdDataSource;
import com.unity3d.ads.core.data.datasource.FIdExistenceDataSource;
import com.unity3d.ads.core.data.datasource.FetchGLInfoDataMigration;
import com.unity3d.ads.core.data.datasource.LegacyUserConsentDataSource;
import com.unity3d.ads.core.data.datasource.LifecycleDataSource;
import com.unity3d.ads.core.data.datasource.MediationDataSource;
import com.unity3d.ads.core.data.datasource.PrivacyDeviceInfoDataSource;
import com.unity3d.ads.core.data.datasource.StaticDeviceInfoDataSource;
import com.unity3d.ads.core.data.datasource.StoreDataSource;
import com.unity3d.ads.core.data.datasource.TcfDataSource;
import com.unity3d.ads.core.data.datasource.UnityBootConfigDataSource;
import com.unity3d.ads.core.data.datasource.UniversalRequestDataSource;
import com.unity3d.ads.core.data.datasource.WebviewConfigurationDataSource;
import com.unity3d.ads.core.data.manager.AndroidOfferwallManager;
import com.unity3d.ads.core.data.manager.AndroidOmidManager;
import com.unity3d.ads.core.data.manager.AndroidSDKPropertiesManager;
import com.unity3d.ads.core.data.manager.AndroidScarManager;
import com.unity3d.ads.core.data.manager.AndroidStorageManager;
import com.unity3d.ads.core.data.manager.OfferwallManager;
import com.unity3d.ads.core.data.manager.OmidManager;
import com.unity3d.ads.core.data.manager.SDKPropertiesManager;
import com.unity3d.ads.core.data.manager.ScarManager;
import com.unity3d.ads.core.data.manager.StorageManager;
import com.unity3d.ads.core.data.manager.TransactionEventManager;
import com.unity3d.ads.core.data.repository.AdRepository;
import com.unity3d.ads.core.data.repository.AndroidAdRepository;
import com.unity3d.ads.core.data.repository.AndroidCacheRepository;
import com.unity3d.ads.core.data.repository.AndroidCampaignRepository;
import com.unity3d.ads.core.data.repository.AndroidDeveloperConsentRepository;
import com.unity3d.ads.core.data.repository.AndroidDeviceInfoRepository;
import com.unity3d.ads.core.data.repository.AndroidDiagnosticEventRepository;
import com.unity3d.ads.core.data.repository.AndroidLegacyUserConsentRepository;
import com.unity3d.ads.core.data.repository.AndroidMediationRepository;
import com.unity3d.ads.core.data.repository.AndroidOpenMeasurementRepository;
import com.unity3d.ads.core.data.repository.AndroidSessionRepository;
import com.unity3d.ads.core.data.repository.AndroidTcfRepository;
import com.unity3d.ads.core.data.repository.AndroidTransactionEventRepository;
import com.unity3d.ads.core.data.repository.CacheRepository;
import com.unity3d.ads.core.data.repository.CampaignRepository;
import com.unity3d.ads.core.data.repository.DeveloperConsentRepository;
import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.DiagnosticEventRepository;
import com.unity3d.ads.core.data.repository.FocusRepository;
import com.unity3d.ads.core.data.repository.LegacyUserConsentRepository;
import com.unity3d.ads.core.data.repository.MediationRepository;
import com.unity3d.ads.core.data.repository.OpenMeasurementRepository;
import com.unity3d.ads.core.data.repository.OperativeEventRepository;
import com.unity3d.ads.core.data.repository.OrientationRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.data.repository.TcfRepository;
import com.unity3d.ads.core.data.repository.TransactionEventRepository;
import com.unity3d.ads.core.domain.AndroidBuildHeaderBiddingToken;
import com.unity3d.ads.core.domain.AndroidCacheWebViewAssets;
import com.unity3d.ads.core.domain.AndroidExecuteAdViewerRequest;
import com.unity3d.ads.core.domain.AndroidGenerateByteStringId;
import com.unity3d.ads.core.domain.AndroidGetAdDataRefreshRequest;
import com.unity3d.ads.core.domain.AndroidGetAdPlayerConfigRequest;
import com.unity3d.ads.core.domain.AndroidGetAdPlayerContext;
import com.unity3d.ads.core.domain.AndroidGetAdRequest;
import com.unity3d.ads.core.domain.AndroidGetAdRequestPolicy;
import com.unity3d.ads.core.domain.AndroidGetClientInfo;
import com.unity3d.ads.core.domain.AndroidGetInitializationCompletedRequest;
import com.unity3d.ads.core.domain.AndroidGetInitializationData;
import com.unity3d.ads.core.domain.AndroidGetInitializationRequest;
import com.unity3d.ads.core.domain.AndroidGetInitializationRequestPayload;
import com.unity3d.ads.core.domain.AndroidGetIsAdActivity;
import com.unity3d.ads.core.domain.AndroidGetLifecycleFlow;
import com.unity3d.ads.core.domain.AndroidGetLimitedSessionToken;
import com.unity3d.ads.core.domain.AndroidGetOpenGLRendererInfo;
import com.unity3d.ads.core.domain.AndroidGetSharedDataTimestamps;
import com.unity3d.ads.core.domain.AndroidGetUniversalRequestForPayLoad;
import com.unity3d.ads.core.domain.AndroidGetUniversalRequestSharedData;
import com.unity3d.ads.core.domain.AndroidGetWebViewContainerUseCase;
import com.unity3d.ads.core.domain.AndroidHandleFocusCounters;
import com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse;
import com.unity3d.ads.core.domain.AndroidHandleGatewayInitializationResponse;
import com.unity3d.ads.core.domain.AndroidHandleGatewayUniversalResponse;
import com.unity3d.ads.core.domain.AndroidHandleOpenUrl;
import com.unity3d.ads.core.domain.AndroidHttpClientProvider;
import com.unity3d.ads.core.domain.AndroidInitializeBoldSDK;
import com.unity3d.ads.core.domain.AndroidLoad;
import com.unity3d.ads.core.domain.AndroidRefresh;
import com.unity3d.ads.core.domain.AndroidRemoveUrlQuery;
import com.unity3d.ads.core.domain.AndroidSendDiagnosticEvent;
import com.unity3d.ads.core.domain.AndroidSendWebViewClientErrorDiagnostics;
import com.unity3d.ads.core.domain.AndroidShow;
import com.unity3d.ads.core.domain.AndroidTestDataInfo;
import com.unity3d.ads.core.domain.AndroidTriggerInitializationCompletedRequest;
import com.unity3d.ads.core.domain.AwaitInitialization;
import com.unity3d.ads.core.domain.BuildHeaderBiddingToken;
import com.unity3d.ads.core.domain.CacheFile;
import com.unity3d.ads.core.domain.CacheWebViewAssets;
import com.unity3d.ads.core.domain.CheckForGameIdAndTestModeChanges;
import com.unity3d.ads.core.domain.CleanAssets;
import com.unity3d.ads.core.domain.CleanUpWhenOpportunityExpires;
import com.unity3d.ads.core.domain.CommonAwaitInitialization;
import com.unity3d.ads.core.domain.CommonCacheFile;
import com.unity3d.ads.core.domain.CommonCheckForGameIdAndTestModeChanges;
import com.unity3d.ads.core.domain.CommonCleanAssets;
import com.unity3d.ads.core.domain.CommonCreateFile;
import com.unity3d.ads.core.domain.CommonGetAdObject;
import com.unity3d.ads.core.domain.CommonGetAdPlayer;
import com.unity3d.ads.core.domain.CommonGetCacheDirectory;
import com.unity3d.ads.core.domain.CommonGetFileExtensionFromUrl;
import com.unity3d.ads.core.domain.CommonGetGameId;
import com.unity3d.ads.core.domain.CommonGetHeaderBiddingToken;
import com.unity3d.ads.core.domain.CommonGetInitializationState;
import com.unity3d.ads.core.domain.CommonGetIsFileCache;
import com.unity3d.ads.core.domain.CommonGetWebViewBridgeUseCase;
import com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken;
import com.unity3d.ads.core.domain.CommonSafeCallbackInvoke;
import com.unity3d.ads.core.domain.CommonSetGameId;
import com.unity3d.ads.core.domain.CommonSetInitializationState;
import com.unity3d.ads.core.domain.CommonShouldAllowInitialization;
import com.unity3d.ads.core.domain.CommonTokenNumberProvider;
import com.unity3d.ads.core.domain.CommonValidateGameId;
import com.unity3d.ads.core.domain.CreateFile;
import com.unity3d.ads.core.domain.ExecuteAdViewerRequest;
import com.unity3d.ads.core.domain.GetAdDataRefreshRequest;
import com.unity3d.ads.core.domain.GetAdObject;
import com.unity3d.ads.core.domain.GetAdPlayer;
import com.unity3d.ads.core.domain.GetAdPlayerConfigRequest;
import com.unity3d.ads.core.domain.GetAdRequest;
import com.unity3d.ads.core.domain.GetAsyncHeaderBiddingToken;
import com.unity3d.ads.core.domain.GetByteStringId;
import com.unity3d.ads.core.domain.GetCacheDirectory;
import com.unity3d.ads.core.domain.GetCachedAsset;
import com.unity3d.ads.core.domain.GetClientInfo;
import com.unity3d.ads.core.domain.GetFileExtensionFromUrl;
import com.unity3d.ads.core.domain.GetGameId;
import com.unity3d.ads.core.domain.GetHeaderBiddingToken;
import com.unity3d.ads.core.domain.GetInitRequestPolicy;
import com.unity3d.ads.core.domain.GetInitializationCompletedRequest;
import com.unity3d.ads.core.domain.GetInitializationData;
import com.unity3d.ads.core.domain.GetInitializationRequest;
import com.unity3d.ads.core.domain.GetInitializationRequestPayload;
import com.unity3d.ads.core.domain.GetInitializationState;
import com.unity3d.ads.core.domain.GetIsFileCache;
import com.unity3d.ads.core.domain.GetLatestWebViewConfiguration;
import com.unity3d.ads.core.domain.GetLimitedSessionToken;
import com.unity3d.ads.core.domain.GetOpenGLRendererInfo;
import com.unity3d.ads.core.domain.GetOperativeEventRequestPolicy;
import com.unity3d.ads.core.domain.GetOtherRequestPolicy;
import com.unity3d.ads.core.domain.GetPrivacyUpdateRequest;
import com.unity3d.ads.core.domain.GetRequestPolicy;
import com.unity3d.ads.core.domain.GetSharedDataTimestamps;
import com.unity3d.ads.core.domain.GetUniversalRequestForPayLoad;
import com.unity3d.ads.core.domain.GetUniversalRequestSharedData;
import com.unity3d.ads.core.domain.GetWebViewBridgeUseCase;
import com.unity3d.ads.core.domain.HandleDebugSettings;
import com.unity3d.ads.core.domain.HandleGatewayAdResponse;
import com.unity3d.ads.core.domain.HandleGatewayInitializationResponse;
import com.unity3d.ads.core.domain.HandleGatewayUniversalResponse;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import com.unity3d.ads.core.domain.HandleOpenUrl;
import com.unity3d.ads.core.domain.HttpClientProvider;
import com.unity3d.ads.core.domain.InitializeBoldSDK;
import com.unity3d.ads.core.domain.LegacyLoadUseCase;
import com.unity3d.ads.core.domain.LegacyShowUseCase;
import com.unity3d.ads.core.domain.Load;
import com.unity3d.ads.core.domain.Refresh;
import com.unity3d.ads.core.domain.RemoveUrlQuery;
import com.unity3d.ads.core.domain.SafeCallbackInvoke;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.domain.SendPrivacyUpdateRequest;
import com.unity3d.ads.core.domain.SendWebViewClientErrorDiagnostics;
import com.unity3d.ads.core.domain.SetGameId;
import com.unity3d.ads.core.domain.SetInitializationState;
import com.unity3d.ads.core.domain.ShouldAllowInitialization;
import com.unity3d.ads.core.domain.Show;
import com.unity3d.ads.core.domain.TokenNumberProvider;
import com.unity3d.ads.core.domain.TriggerInitializationCompletedRequest;
import com.unity3d.ads.core.domain.TriggerInitializeListener;
import com.unity3d.ads.core.domain.ValidateGameId;
import com.unity3d.ads.core.domain.attribution.AndroidAttribution;
import com.unity3d.ads.core.domain.billing.CommonProductDetailsFetcher;
import com.unity3d.ads.core.domain.billing.IsBillingClientAvailable;
import com.unity3d.ads.core.domain.billing.ProductDetailsFetcher;
import com.unity3d.ads.core.domain.billing.ProductDetailsFetcherWithFallback;
import com.unity3d.ads.core.domain.events.AndroidGetTransactionData;
import com.unity3d.ads.core.domain.events.AndroidHandleGatewayEventResponse;
import com.unity3d.ads.core.domain.events.CommonGetTransactionRequest;
import com.unity3d.ads.core.domain.events.CommonUniversalRequestTtlValidator;
import com.unity3d.ads.core.domain.events.DiagnosticEventObserver;
import com.unity3d.ads.core.domain.events.EventObservers;
import com.unity3d.ads.core.domain.events.GetDiagnosticEventBatchRequest;
import com.unity3d.ads.core.domain.events.GetDiagnosticEventRequest;
import com.unity3d.ads.core.domain.events.GetOperativeEventApi;
import com.unity3d.ads.core.domain.events.GetOperativeEventRequest;
import com.unity3d.ads.core.domain.events.GetTransactionData;
import com.unity3d.ads.core.domain.events.GetTransactionRequest;
import com.unity3d.ads.core.domain.events.HandleGatewayEventResponse;
import com.unity3d.ads.core.domain.events.OperativeEventObserver;
import com.unity3d.ads.core.domain.events.TransactionEventObserver;
import com.unity3d.ads.core.domain.events.UniversalRequestEventSender;
import com.unity3d.ads.core.domain.events.UniversalRequestTtlValidator;
import com.unity3d.ads.core.domain.offerwall.GetIsOfferwallAdReady;
import com.unity3d.ads.core.domain.offerwall.LoadOfferwallAd;
import com.unity3d.ads.core.domain.om.AndroidInitializeOMSDK;
import com.unity3d.ads.core.domain.om.AndroidOmFinishSession;
import com.unity3d.ads.core.domain.om.AndroidOmImpressionOccurred;
import com.unity3d.ads.core.domain.om.AndroidOmInteraction;
import com.unity3d.ads.core.domain.om.AndroidOmStartSession;
import com.unity3d.ads.core.domain.om.CommonGetOmData;
import com.unity3d.ads.core.domain.om.CommonIsOMActivated;
import com.unity3d.ads.core.domain.om.GetOmData;
import com.unity3d.ads.core.domain.om.InitializeOMSDK;
import com.unity3d.ads.core.domain.om.IsOMActivated;
import com.unity3d.ads.core.domain.om.OmFinishSession;
import com.unity3d.ads.core.domain.om.OmImpressionOccurred;
import com.unity3d.ads.core.domain.privacy.DeveloperConsentFlattenerRulesUseCase;
import com.unity3d.ads.core.domain.privacy.FlattenerRulesUseCase;
import com.unity3d.ads.core.domain.privacy.LegacyUserConsentFlattenerRulesUseCase;
import com.unity3d.ads.core.domain.scar.AndroidFetchSignalsAndSendUseCase;
import com.unity3d.ads.core.domain.scar.CommonScarEventReceiver;
import com.unity3d.ads.core.domain.scar.FetchSignalsAndSendUseCase;
import com.unity3d.ads.core.domain.scar.GetAndroidTokenEventRequest;
import com.unity3d.ads.core.domain.scar.GetHbTokenEventRequest;
import com.unity3d.ads.core.domain.scar.HandleAndroidGetTokenRequest;
import com.unity3d.ads.core.domain.scar.HandleGetTokenRequest;
import com.unity3d.ads.core.domain.scar.LoadScarAd;
import com.unity3d.ads.core.domain.scar.ScarTimeHackFixer;
import com.unity3d.ads.core.domain.work.BackgroundWorker;
import com.unity3d.ads.core.domain.work.DiagnosticEventRequestWorkModifier;
import com.unity3d.ads.core.domain.work.DownloadPriorityQueue;
import com.unity3d.ads.core.log.Logger;
import com.unity3d.ads.core.log.UnityLogger;
import com.unity3d.ads.core.utils.CommonCoroutineTimer;
import com.unity3d.ads.core.utils.CoroutineTimer;
import com.unity3d.ads.datastore.ByteStringStoreOuterClass;
import com.unity3d.ads.datastore.UniversalRequestStoreOuterClass;
import com.unity3d.ads.datastore.WebviewConfigurationStore;
import com.unity3d.ads.gatewayclient.CommonGatewayClient;
import com.unity3d.ads.gatewayclient.GatewayClient;
import com.unity3d.services.SDKErrorHandler;
import com.unity3d.services.ads.gmascar.GMA;
import com.unity3d.services.ads.gmascar.GMAScarAdapterBridge;
import com.unity3d.services.ads.gmascar.utils.GMAEventSender;
import com.unity3d.services.ads.measurements.MeasurementsService;
import com.unity3d.services.ads.offerwall.OfferwallAdapterBridge;
import com.unity3d.services.ads.token.AsyncTokenStorage;
import com.unity3d.services.ads.token.InMemoryTokenStorage;
import com.unity3d.services.ads.token.TokenStorage;
import com.unity3d.services.ads.topics.TopicsService;
import com.unity3d.services.core.configuration.ConfigurationReader;
import com.unity3d.services.core.device.VolumeChange;
import com.unity3d.services.core.device.VolumeChangeContentObserver;
import com.unity3d.services.core.device.VolumeChangeMonitor;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage;
import com.unity3d.services.core.domain.task.InitializeSDK;
import com.unity3d.services.core.domain.task.InitializeStateComplete;
import com.unity3d.services.core.domain.task.InitializeStateConfig;
import com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader;
import com.unity3d.services.core.domain.task.InitializeStateCreate;
import com.unity3d.services.core.domain.task.InitializeStateError;
import com.unity3d.services.core.domain.task.InitializeStateLoadCache;
import com.unity3d.services.core.domain.task.InitializeStateLoadWeb;
import com.unity3d.services.core.domain.task.InitializeStateNetworkError;
import com.unity3d.services.core.domain.task.InitializeStateReset;
import com.unity3d.services.core.fid.Constants;
import com.unity3d.services.core.misc.JsonStorage;
import com.unity3d.services.core.network.core.CronetEngineBuilderFactory;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.domain.CleanupDirectory;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.webview.bridge.IEventSender;
import com.unity3d.services.core.webview.bridge.SharedInstances;
import com.unity3d.services.store.StoreMonitor;
import com.unity3d.services.store.StoreWebViewEventSender;
import com.unity3d.services.store.core.GatewayStoreExceptionHandler;
import com.unity3d.services.store.core.StoreEventListenerFactory;
import com.unity3d.services.store.core.StoreExceptionHandler;
import com.unity3d.services.store.gpbl.bridges.billingclient.BillingClientAdapter;
import com.unity3d.services.store.gpbl.bridges.billingclient.BillingClientAdapterFactory;
import e6.a;
import e6.p;
import gatewayprotocol.v1.NativeConfigurationOuterClass;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import n7.b;
import q5.x;
import q6.a0;
import q6.c0;
import q6.f1;
import q6.w;
import q6.y;
import r2.q;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ServiceProvider implements IServiceProvider {
    public static final String CDN_CREATIVES_HOST = "cdn-creatives-cf-prd.acquire.unity3dusercontent.com";
    public static final int CDN_CREATIVES_PORT = 443;
    public static final String DATA_STORE_GATEWAY_CACHE = "gateway_cache.pb";
    public static final String DATA_STORE_GL_INFO = "glinfo.pb";
    public static final String DATA_STORE_IAP_TRANSACTION = "iap_transaction.pb";
    public static final String DATA_STORE_NATIVE_CONFIG = "native_configuration.pb";
    public static final String DATA_STORE_PRIVACY = "privacy.pb";
    public static final String DATA_STORE_PRIVACY_FSM = "privacy_fsm.pb";
    public static final String DATA_STORE_UNIVERSAL_REQUEST = "universal_request.pb";
    public static final String DATA_STORE_WEBVIEW_CONFIG = "webview_config.pb";
    public static final String DEFAULT_DISPATCHER = "default_dispatcher";
    public static final String DEV_CONSENT_PRIVACY_RULES = "dev_consent_privacy_rules";
    public static final String GATEWAY_HOST = "gateway.unityads.unity3d.com";
    public static final int GATEWAY_PORT = 443;
    public static final long HTTP_CACHE_DISK_SIZE = 20971520;
    public static final long HTTP_CLIENT_FETCH_TIMEOUT = 500;
    public static final ServiceProvider INSTANCE;
    public static final String IO_DISPATCHER = "io_dispatcher";
    public static final String LEGACY_PRIVACY_RULES = "legacy_privacy_rules";
    public static final String MAIN_DISPATCHER = "main_dispatcher";
    public static final String NAMED_AD_REQ = "ad_req";
    public static final String NAMED_GATEWAY_HTTP_CLIENT = "gateway_http_client";
    public static final String NAMED_GET_TOKEN_SCOPE = "get_token_scope";
    public static final String NAMED_INIT_REQ = "init_req";
    public static final String NAMED_INIT_SCOPE = "init_scope";
    public static final String NAMED_LOAD_SCOPE = "load_scope";
    public static final String NAMED_LOCAL = "local";
    public static final String NAMED_OFFERWALL_SCOPE = "offerwall_scope";
    public static final String NAMED_OMID_SCOPE = "omid_scope";
    public static final String NAMED_OPERATIVE_REQ = "op_event_req";
    public static final String NAMED_OTHER_REQ = "other_req";
    public static final String NAMED_PUBLIC_JOB = "public_job";
    public static final String NAMED_REMOTE = "remote";
    public static final String NAMED_SCAR_SCOPE = "scar_scope";
    public static final String NAMED_SDK = "sdk";
    public static final String NAMED_SHOW_SCOPE = "show_scope";
    public static final String NAMED_TRANSACTION_SCOPE = "transaction_scope";
    public static final String PREF_GL_INFO = "glinfo";
    public static final long SCAR_SIGNALS_FETCH_TIMEOUT = 50000;
    public static final long SCAR_VERSION_FETCH_TIMEOUT = 5000;
    private static final IServicesRegistry serviceRegistry;

    /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 extends l implements e6.l {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class C02201 extends l implements a {
            public static final C02201 INSTANCE = new C02201();

            public C02201() {
                super(0);
            }

            @Override // e6.a
            public final Context invoke() {
                return ClientProperties.getApplicationContext();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$10, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass10 extends l implements a {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass10(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final a0 invoke() {
                return this.$moduleInstance.transactionCoroutineScope((ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", b0.a(ISDKDispatchers.class))), (y) this.$this_registry.resolveService(new ServiceKey("sdk", b0.a(y.class))), (f1) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_PUBLIC_JOB, b0.a(f1.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$100, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass100 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass100(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final GetInitializationState invoke() {
                return new CommonGetInitializationState((SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))), (SDKPropertiesManager) this.$this_registry.resolveService(new ServiceKey("", b0.a(SDKPropertiesManager.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$101, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass101 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass101(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final GetIsFileCache invoke() {
                return new CommonGetIsFileCache((CacheRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(CacheRepository.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", b0.a(SendDiagnosticEvent.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$102, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass102 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass102(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final SetInitializationState invoke() {
                return new CommonSetInitializationState((SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))), (SDKPropertiesManager) this.$this_registry.resolveService(new ServiceKey("", b0.a(SDKPropertiesManager.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$103, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass103 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass103(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final GetRequestPolicy invoke() {
                return new AndroidGetAdRequestPolicy((SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$104, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass104 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass104(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final GetAdDataRefreshRequest invoke() {
                return new AndroidGetAdDataRefreshRequest((GetUniversalRequestForPayLoad) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetUniversalRequestForPayLoad.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))), (DeviceInfoRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(DeviceInfoRepository.class))), (CampaignRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(CampaignRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$105, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass105 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass105(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final GetAdPlayerConfigRequest invoke() {
                return new AndroidGetAdPlayerConfigRequest((GetUniversalRequestForPayLoad) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetUniversalRequestForPayLoad.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$106, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass106 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass106(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final AndroidGetAdPlayerContext invoke() {
                return new AndroidGetAdPlayerContext((DeviceInfoRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(DeviceInfoRepository.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$107, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass107 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass107(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final GetAdRequest invoke() {
                return new AndroidGetAdRequest((GetUniversalRequestForPayLoad) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetUniversalRequestForPayLoad.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))), (DeviceInfoRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(DeviceInfoRepository.class))), (CampaignRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(CampaignRepository.class))), (WebviewConfigurationDataSource) this.$this_registry.resolveService(new ServiceKey("", b0.a(WebviewConfigurationDataSource.class))), (TcfRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(TcfRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$108, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass108 extends l implements a {
            public static final AnonymousClass108 INSTANCE = new AnonymousClass108();

            public AnonymousClass108() {
                super(0);
            }

            @Override // e6.a
            public final GetHbTokenEventRequest invoke() {
                return new GetAndroidTokenEventRequest();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$109, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass109 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass109(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final CommonScarEventReceiver invoke() {
                return new CommonScarEventReceiver((a0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_SCAR_SCOPE, b0.a(a0.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$11, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass11 extends l implements a {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass11(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final a0 invoke() {
                return this.$moduleInstance.getTokenCoroutineScope((ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", b0.a(ISDKDispatchers.class))), (y) this.$this_registry.resolveService(new ServiceKey("sdk", b0.a(y.class))), (f1) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_PUBLIC_JOB, b0.a(f1.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$110, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass110 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass110(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final GMAScarAdapterBridge invoke() {
                GMAScarAdapterBridge bridge = GMA.getInstance(new GMAEventSender((IEventSender) this.$this_registry.resolveService(new ServiceKey("", b0.a(CommonScarEventReceiver.class))))).getBridge();
                k.d(bridge, "getInstance(GMAEventSend…EventReceiver>())).bridge");
                return bridge;
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$111, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass111 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass111(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final ScarTimeHackFixer invoke() {
                return new ScarTimeHackFixer((SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", b0.a(SendDiagnosticEvent.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$112, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass112 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass112(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final ScarManager invoke() {
                return new AndroidScarManager((CommonScarEventReceiver) this.$this_registry.resolveService(new ServiceKey("", b0.a(CommonScarEventReceiver.class))), (GMAScarAdapterBridge) this.$this_registry.resolveService(new ServiceKey("", b0.a(GMAScarAdapterBridge.class))), (ScarTimeHackFixer) this.$this_registry.resolveService(new ServiceKey("", b0.a(ScarTimeHackFixer.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$113, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass113 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass113(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final FetchSignalsAndSendUseCase invoke() {
                return new AndroidFetchSignalsAndSendUseCase((a0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_SCAR_SCOPE, b0.a(a0.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))), (ScarManager) this.$this_registry.resolveService(new ServiceKey("", b0.a(ScarManager.class))), (HandleGetTokenRequest) this.$this_registry.resolveService(new ServiceKey("", b0.a(HandleGetTokenRequest.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", b0.a(SendDiagnosticEvent.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$114, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass114 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass114(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final LoadScarAd invoke() {
                return new LoadScarAd((ScarManager) this.$this_registry.resolveService(new ServiceKey("", b0.a(ScarManager.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$115, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass115 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass115(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final HandleGetTokenRequest invoke() {
                return new HandleAndroidGetTokenRequest((GetUniversalRequestForPayLoad) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetUniversalRequestForPayLoad.class))), (GetHbTokenEventRequest) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetHbTokenEventRequest.class))), (GetRequestPolicy) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_OTHER_REQ, b0.a(GetRequestPolicy.class))), (GatewayClient) this.$this_registry.resolveService(new ServiceKey("", b0.a(GatewayClient.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$116, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass116 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass116(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final GetClientInfo invoke() {
                return new AndroidGetClientInfo((SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))), (MediationRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(MediationRepository.class))), (OmidManager) this.$this_registry.resolveService(new ServiceKey("", b0.a(OmidManager.class))), (ScarManager) this.$this_registry.resolveService(new ServiceKey("", b0.a(ScarManager.class))), (OfferwallManager) this.$this_registry.resolveService(new ServiceKey("", b0.a(OfferwallManager.class))), (FIdExistenceDataSource) this.$this_registry.resolveService(new ServiceKey("", b0.a(FIdExistenceDataSource.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$117, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass117 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass117(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final GetInitializationCompletedRequest invoke() {
                return new AndroidGetInitializationCompletedRequest((GetUniversalRequestForPayLoad) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetUniversalRequestForPayLoad.class))), (DeviceInfoRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(DeviceInfoRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$118, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass118 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass118(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final GetInitializationRequest invoke() {
                return new AndroidGetInitializationRequest((GetInitializationRequestPayload) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetInitializationRequestPayload.class))), (GetUniversalRequestForPayLoad) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetUniversalRequestForPayLoad.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$119, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass119 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass119(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final GetLimitedSessionToken invoke() {
                return new AndroidGetLimitedSessionToken((DeviceInfoRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(DeviceInfoRepository.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))), (MediationRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(MediationRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$12, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass12 extends l implements a {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass12(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final a0 invoke() {
                return this.$moduleInstance.scarSignalsCoroutineScope((ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", b0.a(ISDKDispatchers.class))), (y) this.$this_registry.resolveService(new ServiceKey("sdk", b0.a(y.class))), (f1) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_PUBLIC_JOB, b0.a(f1.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$120, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass120 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass120(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final GetOpenGLRendererInfo invoke() {
                return new AndroidGetOpenGLRendererInfo((SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$121, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass121 extends l implements a {
            public static final AnonymousClass121 INSTANCE = new AnonymousClass121();

            public AnonymousClass121() {
                super(0);
            }

            @Override // e6.a
            public final GetSharedDataTimestamps invoke() {
                return new AndroidGetSharedDataTimestamps();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$122, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass122 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass122(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final GetUniversalRequestForPayLoad invoke() {
                return new AndroidGetUniversalRequestForPayLoad((GetUniversalRequestSharedData) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetUniversalRequestSharedData.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$123, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass123 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass123(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final GetUniversalRequestSharedData invoke() {
                return new AndroidGetUniversalRequestSharedData((GetSharedDataTimestamps) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetSharedDataTimestamps.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))), (DeviceInfoRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(DeviceInfoRepository.class))), (GetLimitedSessionToken) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetLimitedSessionToken.class))), (DeveloperConsentRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(DeveloperConsentRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$124, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass124 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass124(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final GetCachedAsset invoke() {
                return new GetCachedAsset((CacheRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(CacheRepository.class))), (Context) this.$this_registry.resolveService(new ServiceKey("", b0.a(Context.class))), (CacheWebViewAssets) this.$this_registry.resolveService(new ServiceKey("", b0.a(CacheWebViewAssets.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$125, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass125 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass125(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final GetWebViewBridgeUseCase invoke() {
                return new CommonGetWebViewBridgeUseCase((w) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, b0.a(w.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", b0.a(SendDiagnosticEvent.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$126, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass126 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass126(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final GetRequestPolicy invoke() {
                return new GetInitRequestPolicy((SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$127, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass127 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass127(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final GetLatestWebViewConfiguration invoke() {
                return new GetLatestWebViewConfiguration((WebviewConfigurationDataSource) this.$this_registry.resolveService(new ServiceKey("", b0.a(WebviewConfigurationDataSource.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$128, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass128 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass128(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final GetRequestPolicy invoke() {
                return new GetOperativeEventRequestPolicy((SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$129, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass129 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass129(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final GetRequestPolicy invoke() {
                return new GetOtherRequestPolicy((SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$13, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass13 extends l implements a {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass13(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final a0 invoke() {
                return this.$moduleInstance.offerwallSignalsCoroutineScope((ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", b0.a(ISDKDispatchers.class))), (y) this.$this_registry.resolveService(new ServiceKey("sdk", b0.a(y.class))), (f1) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_PUBLIC_JOB, b0.a(f1.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$130, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass130 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass130(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final GetPrivacyUpdateRequest invoke() {
                return new GetPrivacyUpdateRequest((GetUniversalRequestForPayLoad) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetUniversalRequestForPayLoad.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$131, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass131 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass131(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final HandleGatewayInitializationResponse invoke() {
                return new AndroidHandleGatewayInitializationResponse((TransactionEventManager) this.$this_registry.resolveService(new ServiceKey("", b0.a(TransactionEventManager.class))), (TriggerInitializationCompletedRequest) this.$this_registry.resolveService(new ServiceKey("", b0.a(TriggerInitializationCompletedRequest.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))), (a0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_INIT_SCOPE, b0.a(a0.class))), (HandleDebugSettings) this.$this_registry.resolveService(new ServiceKey("", b0.a(HandleDebugSettings.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$132, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass132 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass132(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final HandleGatewayUniversalResponse invoke() {
                return new AndroidHandleGatewayUniversalResponse((SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))), (DeviceInfoRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(DeviceInfoRepository.class))), (AndroidAppSetIdDataSource) this.$this_registry.resolveService(new ServiceKey("", b0.a(AndroidAppSetIdDataSource.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$133, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass133 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass133(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final InitializeBoldSDK invoke() {
                return new AndroidInitializeBoldSDK((w) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, b0.a(w.class))), (InitializeOMSDK) this.$this_registry.resolveService(new ServiceKey("", b0.a(InitializeOMSDK.class))), (GetInitializationRequest) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetInitializationRequest.class))), (GetRequestPolicy) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_INIT_REQ, b0.a(GetRequestPolicy.class))), (CleanAssets) this.$this_registry.resolveService(new ServiceKey("", b0.a(CleanAssets.class))), (HandleGatewayInitializationResponse) this.$this_registry.resolveService(new ServiceKey("", b0.a(HandleGatewayInitializationResponse.class))), (GatewayClient) this.$this_registry.resolveService(new ServiceKey("", b0.a(GatewayClient.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))), (EventObservers) this.$this_registry.resolveService(new ServiceKey("", b0.a(EventObservers.class))), (TriggerInitializeListener) this.$this_registry.resolveService(new ServiceKey("", b0.a(TriggerInitializeListener.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", b0.a(SendDiagnosticEvent.class))), (DiagnosticEventRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(DiagnosticEventRepository.class))), (StorageManager) this.$this_registry.resolveService(new ServiceKey("", b0.a(StorageManager.class))), (ConfigurationReader) this.$this_registry.resolveService(new ServiceKey("", b0.a(ConfigurationReader.class))), (SDKPropertiesManager) this.$this_registry.resolveService(new ServiceKey("", b0.a(SDKPropertiesManager.class))), (GetGameId) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetGameId.class))), (AndroidHandleFocusCounters) this.$this_registry.resolveService(new ServiceKey("", b0.a(AndroidHandleFocusCounters.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$134, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass134 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass134(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final LegacyShowUseCase invoke() {
                return new LegacyShowUseCase((Show) this.$this_registry.resolveService(new ServiceKey("", b0.a(Show.class))), (AdRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(AdRepository.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", b0.a(SendDiagnosticEvent.class))), (GetOperativeEventApi) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetOperativeEventApi.class))), (GetInitializationState) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetInitializationState.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))), (SafeCallbackInvoke) this.$this_registry.resolveService(new ServiceKey("", b0.a(SafeCallbackInvoke.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$135, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass135 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass135(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final SendPrivacyUpdateRequest invoke() {
                return new SendPrivacyUpdateRequest((GetPrivacyUpdateRequest) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetPrivacyUpdateRequest.class))), (GetRequestPolicy) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_OTHER_REQ, b0.a(GetRequestPolicy.class))), (GatewayClient) this.$this_registry.resolveService(new ServiceKey("", b0.a(GatewayClient.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$136, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass136 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass136(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final TriggerInitializationCompletedRequest invoke() {
                return new AndroidTriggerInitializationCompletedRequest((GetInitializationCompletedRequest) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetInitializationCompletedRequest.class))), (GetRequestPolicy) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_INIT_REQ, b0.a(GetRequestPolicy.class))), (GatewayClient) this.$this_registry.resolveService(new ServiceKey("", b0.a(GatewayClient.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", b0.a(SendDiagnosticEvent.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$137, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass137 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass137(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final TriggerInitializeListener invoke() {
                return new TriggerInitializeListener((w) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.MAIN_DISPATCHER, b0.a(w.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$138, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass138 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass138(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final DiagnosticEventObserver invoke() {
                return new DiagnosticEventObserver((GetUniversalRequestForPayLoad) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetUniversalRequestForPayLoad.class))), (GetDiagnosticEventBatchRequest) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetDiagnosticEventBatchRequest.class))), (w) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, b0.a(w.class))), (DiagnosticEventRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(DiagnosticEventRepository.class))), (UniversalRequestDataSource) this.$this_registry.resolveService(new ServiceKey("", b0.a(UniversalRequestDataSource.class))), (BackgroundWorker) this.$this_registry.resolveService(new ServiceKey("", b0.a(BackgroundWorker.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$139, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass139 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass139(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final EventObservers invoke() {
                return new EventObservers((OperativeEventObserver) this.$this_registry.resolveService(new ServiceKey("", b0.a(OperativeEventObserver.class))), (DiagnosticEventObserver) this.$this_registry.resolveService(new ServiceKey("", b0.a(DiagnosticEventObserver.class))), (TransactionEventObserver) this.$this_registry.resolveService(new ServiceKey("", b0.a(TransactionEventObserver.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$14, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass14 extends l implements a {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass14(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final a0 invoke() {
                return this.$moduleInstance.omidCoroutineScope((ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", b0.a(ISDKDispatchers.class))), (y) this.$this_registry.resolveService(new ServiceKey("sdk", b0.a(y.class))), (f1) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_PUBLIC_JOB, b0.a(f1.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$140, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass140 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass140(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final GetTransactionData invoke() {
                return new AndroidGetTransactionData((GetByteStringId) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetByteStringId.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$141, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass141 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass141(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final GetTransactionRequest invoke() {
                return new CommonGetTransactionRequest((DeviceInfoRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(DeviceInfoRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$142, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass142 extends l implements a {
            public static final AnonymousClass142 INSTANCE = new AnonymousClass142();

            public AnonymousClass142() {
                super(0);
            }

            @Override // e6.a
            public final GetDiagnosticEventBatchRequest invoke() {
                return new GetDiagnosticEventBatchRequest();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$143, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass143 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass143(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final GetDiagnosticEventRequest invoke() {
                return new GetDiagnosticEventRequest((GetSharedDataTimestamps) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetSharedDataTimestamps.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$144, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass144 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass144(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final GetOperativeEventApi invoke() {
                return new GetOperativeEventApi((OperativeEventRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(OperativeEventRepository.class))), (GetOperativeEventRequest) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetOperativeEventRequest.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$145, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass145 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass145(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final GetOperativeEventRequest invoke() {
                return new GetOperativeEventRequest((GetByteStringId) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetByteStringId.class))), (DeviceInfoRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(DeviceInfoRepository.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))), (CampaignRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(CampaignRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$146, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass146 extends l implements a {
            public static final AnonymousClass146 INSTANCE = new AnonymousClass146();

            public AnonymousClass146() {
                super(0);
            }

            @Override // e6.a
            public final HandleGatewayEventResponse invoke() {
                return new AndroidHandleGatewayEventResponse();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$147, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass147 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass147(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final OperativeEventObserver invoke() {
                return new OperativeEventObserver((GetUniversalRequestForPayLoad) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetUniversalRequestForPayLoad.class))), (w) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, b0.a(w.class))), (OperativeEventRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(OperativeEventRepository.class))), (UniversalRequestDataSource) this.$this_registry.resolveService(new ServiceKey("", b0.a(UniversalRequestDataSource.class))), (BackgroundWorker) this.$this_registry.resolveService(new ServiceKey("", b0.a(BackgroundWorker.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$148, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass148 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass148(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final TransactionEventObserver invoke() {
                return new TransactionEventObserver((GetUniversalRequestForPayLoad) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetUniversalRequestForPayLoad.class))), (w) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, b0.a(w.class))), (TransactionEventRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(TransactionEventRepository.class))), (GatewayClient) this.$this_registry.resolveService(new ServiceKey("", b0.a(GatewayClient.class))), (GetRequestPolicy) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_OTHER_REQ, b0.a(GetRequestPolicy.class))), (ByteStringDataSource) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_IAP_TRANSACTION, b0.a(ByteStringDataSource.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$149, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass149 extends l implements a {
            public static final AnonymousClass149 INSTANCE = new AnonymousClass149();

            public AnonymousClass149() {
                super(0);
            }

            @Override // e6.a
            public final UniversalRequestTtlValidator invoke() {
                return new CommonUniversalRequestTtlValidator();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$15, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass15 extends l implements a {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass15(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final f1 invoke() {
                return this.$moduleInstance.publicApiJob((DiagnosticEventRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(DiagnosticEventRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$150, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass150 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass150(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final UniversalRequestEventSender invoke() {
                return new UniversalRequestEventSender((GatewayClient) this.$this_registry.resolveService(new ServiceKey("", b0.a(GatewayClient.class))), (HandleGatewayEventResponse) this.$this_registry.resolveService(new ServiceKey("", b0.a(HandleGatewayEventResponse.class))), (UniversalRequestTtlValidator) this.$this_registry.resolveService(new ServiceKey("", b0.a(UniversalRequestTtlValidator.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$151, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass151 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass151(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final OmFinishSession invoke() {
                return new AndroidOmFinishSession((OpenMeasurementRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(OpenMeasurementRepository.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", b0.a(SendDiagnosticEvent.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$152, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass152 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass152(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final OmImpressionOccurred invoke() {
                return new AndroidOmImpressionOccurred((OpenMeasurementRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(OpenMeasurementRepository.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", b0.a(SendDiagnosticEvent.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$153, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass153 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass153(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final AndroidOmInteraction invoke() {
                return new AndroidOmStartSession((OpenMeasurementRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(OpenMeasurementRepository.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", b0.a(SendDiagnosticEvent.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$154, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass154 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass154(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final GetOmData invoke() {
                return new CommonGetOmData((OpenMeasurementRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(OpenMeasurementRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$155, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass155 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass155(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final IsOMActivated invoke() {
                return new CommonIsOMActivated((OpenMeasurementRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(OpenMeasurementRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$156, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass156 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass156(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final InitializeOMSDK invoke() {
                return new AndroidInitializeOMSDK((Context) this.$this_registry.resolveService(new ServiceKey("", b0.a(Context.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", b0.a(SendDiagnosticEvent.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))), (OpenMeasurementRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(OpenMeasurementRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$157, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass157 extends l implements a {
            public static final AnonymousClass157 INSTANCE = new AnonymousClass157();

            public AnonymousClass157() {
                super(0);
            }

            @Override // e6.a
            public final FlattenerRulesUseCase invoke() {
                return new DeveloperConsentFlattenerRulesUseCase();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$158, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass158 extends l implements a {
            public static final AnonymousClass158 INSTANCE = new AnonymousClass158();

            public AnonymousClass158() {
                super(0);
            }

            @Override // e6.a
            public final FlattenerRulesUseCase invoke() {
                return new LegacyUserConsentFlattenerRulesUseCase();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$159, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass159 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass159(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final BackgroundWorker invoke() {
                return new BackgroundWorker((Context) this.$this_registry.resolveService(new ServiceKey("", b0.a(Context.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$16, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass16 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass16(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final ByteStringDataSource invoke() {
                return new AndroidLegacyConfigStoreDataSource((StorageManager) this.$this_registry.resolveService(new ServiceKey("", b0.a(StorageManager.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$160, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass160 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass160(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final DiagnosticEventRequestWorkModifier invoke() {
                return new DiagnosticEventRequestWorkModifier((SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$161, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass161 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass161(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final GatewayClient invoke() {
                return new CommonGatewayClient((HttpClient) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_GATEWAY_HTTP_CLIENT, b0.a(HttpClient.class))), (HandleGatewayUniversalResponse) this.$this_registry.resolveService(new ServiceKey("", b0.a(HandleGatewayUniversalResponse.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", b0.a(SendDiagnosticEvent.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$162, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass162 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass162(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final y invoke() {
                return new SDKErrorHandler((w) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.IO_DISPATCHER, b0.a(w.class))), (AlternativeFlowReader) this.$this_registry.resolveService(new ServiceKey("", b0.a(AlternativeFlowReader.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", b0.a(SendDiagnosticEvent.class))), (SDKMetricsSender) this.$this_registry.resolveService(new ServiceKey("", b0.a(SDKMetricsSender.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$163, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass163 extends l implements a {
            public static final AnonymousClass163 INSTANCE = new AnonymousClass163();

            public AnonymousClass163() {
                super(0);
            }

            @Override // e6.a
            public final TokenStorage invoke() {
                return new InMemoryTokenStorage();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$164, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass164 extends l implements a {
            public static final AnonymousClass164 INSTANCE = new AnonymousClass164();

            public AnonymousClass164() {
                super(0);
            }

            @Override // e6.a
            public final VolumeChange invoke() {
                return new VolumeChangeContentObserver();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$165, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass165 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass165(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final ConfigFileFromLocalStorage invoke() {
                return new ConfigFileFromLocalStorage((ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", b0.a(ISDKDispatchers.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$166, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass166 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass166(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final InitializeSDK invoke() {
                return new InitializeSDK((ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", b0.a(ISDKDispatchers.class))), (ConfigFileFromLocalStorage) this.$this_registry.resolveService(new ServiceKey("", b0.a(ConfigFileFromLocalStorage.class))), (InitializeStateReset) this.$this_registry.resolveService(new ServiceKey("", b0.a(InitializeStateReset.class))), (InitializeStateError) this.$this_registry.resolveService(new ServiceKey("", b0.a(InitializeStateError.class))), (InitializeStateConfig) this.$this_registry.resolveService(new ServiceKey("", b0.a(InitializeStateConfig.class))), (InitializeStateCreate) this.$this_registry.resolveService(new ServiceKey("", b0.a(InitializeStateCreate.class))), (InitializeStateLoadCache) this.$this_registry.resolveService(new ServiceKey("", b0.a(InitializeStateLoadCache.class))), (InitializeStateLoadWeb) this.$this_registry.resolveService(new ServiceKey("", b0.a(InitializeStateLoadWeb.class))), (InitializeStateComplete) this.$this_registry.resolveService(new ServiceKey("", b0.a(InitializeStateComplete.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$167, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass167 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass167(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final InitializeStateComplete invoke() {
                return new InitializeStateComplete((DataStore) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_NATIVE_CONFIG, b0.a(DataStore.class))), (ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", b0.a(ISDKDispatchers.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$168, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass168 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass168(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final InitializeStateConfig invoke() {
                return new InitializeStateConfig((ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", b0.a(ISDKDispatchers.class))), (InitializeStateConfigWithLoader) this.$this_registry.resolveService(new ServiceKey("", b0.a(InitializeStateConfigWithLoader.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$169, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass169 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass169(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final InitializeStateConfigWithLoader invoke() {
                return new InitializeStateConfigWithLoader((ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", b0.a(ISDKDispatchers.class))), (InitializeStateNetworkError) this.$this_registry.resolveService(new ServiceKey("", b0.a(InitializeStateNetworkError.class))), (TokenStorage) this.$this_registry.resolveService(new ServiceKey("", b0.a(TokenStorage.class))), (SDKMetricsSender) this.$this_registry.resolveService(new ServiceKey("", b0.a(SDKMetricsSender.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$17, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass17 extends l implements a {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass17(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final DataStore<ByteStringStoreOuterClass.ByteStringStore> invoke() {
                return this.$moduleInstance.privacyDataStore((Context) this.$this_registry.resolveService(new ServiceKey("", b0.a(Context.class))), (w) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.IO_DISPATCHER, b0.a(w.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$170, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass170 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass170(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final InitializeStateCreate invoke() {
                return new InitializeStateCreate((ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", b0.a(ISDKDispatchers.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$171, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass171 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass171(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final InitializeStateError invoke() {
                return new InitializeStateError((ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", b0.a(ISDKDispatchers.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$172, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass172 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass172(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final InitializeStateLoadCache invoke() {
                return new InitializeStateLoadCache((ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", b0.a(ISDKDispatchers.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$173, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass173 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass173(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final InitializeStateLoadWeb invoke() {
                return new InitializeStateLoadWeb((ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", b0.a(ISDKDispatchers.class))), (InitializeStateNetworkError) this.$this_registry.resolveService(new ServiceKey("", b0.a(InitializeStateNetworkError.class))), (HttpClient) this.$this_registry.resolveService(new ServiceKey("", b0.a(HttpClient.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$174, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass174 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass174(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final InitializeStateReset invoke() {
                return new InitializeStateReset((ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", b0.a(ISDKDispatchers.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$175, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass175 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass175(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final StoreMonitor invoke() {
                return new StoreMonitor((StoreExceptionHandler) this.$this_registry.resolveService(new ServiceKey("", b0.a(StoreExceptionHandler.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$176, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass176 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass176(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final StoreWebViewEventSender invoke() {
                return new StoreWebViewEventSender((IEventSender) this.$this_registry.resolveService(new ServiceKey("", b0.a(IEventSender.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$177, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass177 extends l implements a {
            public static final AnonymousClass177 INSTANCE = new AnonymousClass177();

            public AnonymousClass177() {
                super(0);
            }

            @Override // e6.a
            public final StoreExceptionHandler invoke() {
                return new GatewayStoreExceptionHandler();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$178, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass178 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass178(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final StoreEventListenerFactory invoke() {
                return new StoreEventListenerFactory((StoreWebViewEventSender) this.$this_registry.resolveService(new ServiceKey("", b0.a(StoreWebViewEventSender.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$179, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass179 extends l implements a {
            public static final AnonymousClass179 INSTANCE = new AnonymousClass179();

            public AnonymousClass179() {
                super(0);
            }

            @Override // e6.a
            public final ConfigurationReader invoke() {
                return new ConfigurationReader();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$18, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass18 extends l implements a {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass18(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final ByteStringDataSource invoke() {
                return this.$moduleInstance.privacyDataStore((DataStore) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_PRIVACY, b0.a(DataStore.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$180, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass180 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass180(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final AndroidAttribution invoke() {
                return new AndroidAttribution((Context) this.$this_registry.resolveService(new ServiceKey("", b0.a(Context.class))), (ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", b0.a(ISDKDispatchers.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$181, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass181 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass181(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final AdPlayerScope invoke() {
                return new AdPlayerScope((w) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, b0.a(w.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$182, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass182 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass182(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final AndroidWebViewClient invoke() {
                return new AndroidWebViewClient((GetCachedAsset) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetCachedAsset.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", b0.a(SendDiagnosticEvent.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$183, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass183 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass183(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final AndroidGetWebViewContainerUseCase invoke() {
                return new AndroidGetWebViewContainerUseCase((Context) this.$this_registry.resolveService(new ServiceKey("", b0.a(Context.class))), (AndroidWebViewClient) this.$this_registry.resolveService(new ServiceKey("", b0.a(AndroidWebViewClient.class))), (SendWebViewClientErrorDiagnostics) this.$this_registry.resolveService(new ServiceKey("", b0.a(SendWebViewClientErrorDiagnostics.class))), (w) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.MAIN_DISPATCHER, b0.a(w.class))), (w) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, b0.a(w.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$184, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass184 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass184(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final Load invoke() {
                return new AndroidLoad((w) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, b0.a(w.class))), (GetAdRequest) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetAdRequest.class))), (GetAdPlayerConfigRequest) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetAdPlayerConfigRequest.class))), (GetRequestPolicy) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_AD_REQ, b0.a(GetRequestPolicy.class))), (HandleGatewayAdResponse) this.$this_registry.resolveService(new ServiceKey("", b0.a(HandleGatewayAdResponse.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))), (GatewayClient) this.$this_registry.resolveService(new ServiceKey("", b0.a(GatewayClient.class))), (AdRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(AdRepository.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", b0.a(SendDiagnosticEvent.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$185, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass185 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass185(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final AwaitInitialization invoke() {
                return new CommonAwaitInitialization((SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$186, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass186 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass186(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final GetAsyncHeaderBiddingToken invoke() {
                return new CommonInitAwaitingGetHeaderBiddingToken((GetHeaderBiddingToken) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetHeaderBiddingToken.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", b0.a(SendDiagnosticEvent.class))), (GetInitializationState) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetInitializationState.class))), (AwaitInitialization) this.$this_registry.resolveService(new ServiceKey("", b0.a(AwaitInitialization.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))), (SafeCallbackInvoke) this.$this_registry.resolveService(new ServiceKey("", b0.a(SafeCallbackInvoke.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$187, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass187 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass187(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final GetAdPlayer invoke() {
                return new CommonGetAdPlayer((DeviceInfoRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(DeviceInfoRepository.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", b0.a(SendDiagnosticEvent.class))), (w) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, b0.a(w.class))), (a0) this.$this_registry.resolveService(new ServiceKey("", b0.a(AdPlayerScope.class))), (OpenMeasurementRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(OpenMeasurementRepository.class))), (ScarManager) this.$this_registry.resolveService(new ServiceKey("", b0.a(ScarManager.class))), (OfferwallManager) this.$this_registry.resolveService(new ServiceKey("", b0.a(OfferwallManager.class))), (AdRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(AdRepository.class))), (LifecycleDataSource) this.$this_registry.resolveService(new ServiceKey("", b0.a(LifecycleDataSource.class))), (OrientationRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(OrientationRepository.class))), (Context) this.$this_registry.resolveService(new ServiceKey("", b0.a(Context.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$188, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass188 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass188(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final CacheWebViewAssets invoke() {
                return new AndroidCacheWebViewAssets((CacheRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(CacheRepository.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$189, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass189 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass189(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final HandleGatewayAdResponse invoke() {
                return new AndroidHandleGatewayAdResponse((AdRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(AdRepository.class))), (AndroidGetWebViewContainerUseCase) this.$this_registry.resolveService(new ServiceKey("", b0.a(AndroidGetWebViewContainerUseCase.class))), (GetWebViewBridgeUseCase) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetWebViewBridgeUseCase.class))), (DeviceInfoRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(DeviceInfoRepository.class))), (HandleInvocationsFromAdViewer) this.$this_registry.resolveService(new ServiceKey("", b0.a(HandleInvocationsFromAdViewer.class))), (CampaignRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(CampaignRepository.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", b0.a(SendDiagnosticEvent.class))), (GetOperativeEventApi) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetOperativeEventApi.class))), (GetLatestWebViewConfiguration) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetLatestWebViewConfiguration.class))), (AdPlayerScope) this.$this_registry.resolveService(new ServiceKey("", b0.a(AdPlayerScope.class))), (GetAdPlayer) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetAdPlayer.class))), (CacheWebViewAssets) this.$this_registry.resolveService(new ServiceKey("", b0.a(CacheWebViewAssets.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$19, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass19 extends l implements a {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass19(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final DataStore<ByteStringStoreOuterClass.ByteStringStore> invoke() {
                return this.$moduleInstance.privacyFsmDataStore((Context) this.$this_registry.resolveService(new ServiceKey("", b0.a(Context.class))), (w) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.IO_DISPATCHER, b0.a(w.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$190, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass190 extends l implements a {
            public static final AnonymousClass190 INSTANCE = new AnonymousClass190();

            public AnonymousClass190() {
                super(0);
            }

            @Override // e6.a
            public final HandleInvocationsFromAdViewer invoke() {
                return new HandleInvocationsFromAdViewer();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$191, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass191 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass191(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final LegacyLoadUseCase invoke() {
                return new LegacyLoadUseCase((Load) this.$this_registry.resolveService(new ServiceKey("", b0.a(Load.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", b0.a(SendDiagnosticEvent.class))), (GetInitializationState) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetInitializationState.class))), (AwaitInitialization) this.$this_registry.resolveService(new ServiceKey("", b0.a(AwaitInitialization.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))), (AdRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(AdRepository.class))), (SafeCallbackInvoke) this.$this_registry.resolveService(new ServiceKey("", b0.a(SafeCallbackInvoke.class))), (CleanUpWhenOpportunityExpires) this.$this_registry.resolveService(new ServiceKey("", b0.a(CleanUpWhenOpportunityExpires.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$192, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass192 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass192(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final SafeCallbackInvoke invoke() {
                return new CommonSafeCallbackInvoke((w) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.MAIN_DISPATCHER, b0.a(w.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$193, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass193 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass193(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final InitializeStateNetworkError invoke() {
                return new InitializeStateNetworkError((ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", b0.a(ISDKDispatchers.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$194, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass194 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass194(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final CoroutineTimer invoke() {
                return new CommonCoroutineTimer((w) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, b0.a(w.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$195, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass195 extends l implements a {
            public static final AnonymousClass195 INSTANCE = new AnonymousClass195();

            public AnonymousClass195() {
                super(0);
            }

            @Override // e6.a
            public final IEventSender invoke() {
                return SharedInstances.INSTANCE.getWebViewEventSender();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$196, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass196 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass196(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final SetGameId invoke() {
                return new CommonSetGameId((SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$197, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass197 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass197(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final GetGameId invoke() {
                return new CommonGetGameId((SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$198, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass198 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass198(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final ValidateGameId invoke() {
                return new CommonValidateGameId((GetGameId) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetGameId.class))), (SetGameId) this.$this_registry.resolveService(new ServiceKey("", b0.a(SetGameId.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$199, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass199 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass199(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final ShouldAllowInitialization invoke() {
                return new CommonShouldAllowInitialization((AlternativeFlowReader) this.$this_registry.resolveService(new ServiceKey("", b0.a(AlternativeFlowReader.class))), (CheckForGameIdAndTestModeChanges) this.$this_registry.resolveService(new ServiceKey("", b0.a(CheckForGameIdAndTestModeChanges.class))), (GetInitializationState) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetInitializationState.class))), (SetInitializationState) this.$this_registry.resolveService(new ServiceKey("", b0.a(SetInitializationState.class))), (ValidateGameId) this.$this_registry.resolveService(new ServiceKey("", b0.a(ValidateGameId.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass2 extends l implements a {
            final /* synthetic */ UnityAdsModule $moduleInstance;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(UnityAdsModule unityAdsModule) {
                super(0);
                this.$moduleInstance = unityAdsModule;
            }

            @Override // e6.a
            public final w invoke() {
                return this.$moduleInstance.mainDispatcher();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$20, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass20 extends l implements a {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass20(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final ByteStringDataSource invoke() {
                return this.$moduleInstance.privacyFsmDataStore((DataStore) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_PRIVACY_FSM, b0.a(DataStore.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$200, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass200 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass200(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final CheckForGameIdAndTestModeChanges invoke() {
                return new CommonCheckForGameIdAndTestModeChanges((GetGameId) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetGameId.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", b0.a(SendDiagnosticEvent.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$201, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass201 extends l implements a {
            public static final AnonymousClass201 INSTANCE = new AnonymousClass201();

            public AnonymousClass201() {
                super(0);
            }

            @Override // e6.a
            public final DownloadPriorityQueue invoke() {
                return new DownloadPriorityQueue();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$202, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass202 extends l implements a {
            public static final AnonymousClass202 INSTANCE = new AnonymousClass202();

            public AnonymousClass202() {
                super(0);
            }

            @Override // e6.a
            public final CleanupDirectory invoke() {
                return new CleanupDirectory();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$203, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass203 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass203(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final FocusRepository invoke() {
                return new FocusRepository((AndroidGetLifecycleFlow) this.$this_registry.resolveService(new ServiceKey("", b0.a(AndroidGetLifecycleFlow.class))), (w) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, b0.a(w.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$204, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass204 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass204(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final AndroidGetIsAdActivity invoke() {
                return new AndroidGetIsAdActivity((SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$205, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass205 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass205(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final AndroidGetLifecycleFlow invoke() {
                return new AndroidGetLifecycleFlow((Context) this.$this_registry.resolveService(new ServiceKey("", b0.a(Context.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$206, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass206 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass206(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final AndroidHandleFocusCounters invoke() {
                return new AndroidHandleFocusCounters((SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))), (FocusRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(FocusRepository.class))), (AndroidGetIsAdActivity) this.$this_registry.resolveService(new ServiceKey("", b0.a(AndroidGetIsAdActivity.class))), (w) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, b0.a(w.class))), null, 16, null);
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$207, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass207 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass207(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final OfferwallAdapterBridge invoke() {
                return new OfferwallAdapterBridge((a0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_OFFERWALL_SCOPE, b0.a(a0.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$208, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass208 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass208(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final OfferwallManager invoke() {
                return new AndroidOfferwallManager((OfferwallAdapterBridge) this.$this_registry.resolveService(new ServiceKey("", b0.a(OfferwallAdapterBridge.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$209, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass209 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass209(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final LoadOfferwallAd invoke() {
                return new LoadOfferwallAd((OfferwallManager) this.$this_registry.resolveService(new ServiceKey("", b0.a(OfferwallManager.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$21, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass21 extends l implements a {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass21(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final DataStore<ByteStringStoreOuterClass.ByteStringStore> invoke() {
                return this.$moduleInstance.nativeConfigurationDataStore((Context) this.$this_registry.resolveService(new ServiceKey("", b0.a(Context.class))), (w) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.IO_DISPATCHER, b0.a(w.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$210, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass210 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass210(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final GetIsOfferwallAdReady invoke() {
                return new GetIsOfferwallAdReady((OfferwallManager) this.$this_registry.resolveService(new ServiceKey("", b0.a(OfferwallManager.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$211, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass211 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass211(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final FIdDataSource invoke() {
                return new AndroidFIdDataSource((Context) this.$this_registry.resolveService(new ServiceKey("", b0.a(Context.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$212, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass212 extends l implements a {
            public static final AnonymousClass212 INSTANCE = new AnonymousClass212();

            public AnonymousClass212() {
                super(0);
            }

            @Override // e6.a
            public final FIdExistenceDataSource invoke() {
                return new AndroidFIdExistenceDataSource(Constants.FID_CLASS);
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$213, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass213 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass213(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final CleanUpWhenOpportunityExpires invoke() {
                return new CleanUpWhenOpportunityExpires((w) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, b0.a(w.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$214, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass214 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass214(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final OrientationRepository invoke() {
                return new OrientationRepository((AndroidGetLifecycleFlow) this.$this_registry.resolveService(new ServiceKey("", b0.a(AndroidGetLifecycleFlow.class))), (w) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, b0.a(w.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$215, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass215 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass215(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final AndroidAppSetIdDataSource invoke() {
                return new AndroidAppSetIdDataSource((Context) this.$this_registry.resolveService(new ServiceKey("", b0.a(Context.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$216, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass216 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass216(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final AndroidUnityInfoDataSource invoke() {
                return new AndroidUnityInfoDataSource((Context) this.$this_registry.resolveService(new ServiceKey("", b0.a(Context.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$217, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass217 extends l implements a {
            public static final AnonymousClass217 INSTANCE = new AnonymousClass217();

            public AnonymousClass217() {
                super(0);
            }

            @Override // e6.a
            public final HandleDebugSettings invoke() {
                return new HandleDebugSettings();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$218, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass218 extends l implements a {
            public static final AnonymousClass218 INSTANCE = new AnonymousClass218();

            public AnonymousClass218() {
                super(0);
            }

            @Override // e6.a
            public final Logger invoke() {
                return new UnityLogger();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$219, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass219 extends l implements a {
            public static final AnonymousClass219 INSTANCE = new AnonymousClass219();

            public AnonymousClass219() {
                super(0);
            }

            @Override // e6.a
            public final IsBillingClientAvailable invoke() {
                return new IsBillingClientAvailable();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$22, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass22 extends l implements a {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass22(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final ByteStringDataSource invoke() {
                return this.$moduleInstance.nativeConfigurationDataStore((DataStore) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_NATIVE_CONFIG, b0.a(DataStore.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$220, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass220 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass220(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final UnityBootConfigDataSource invoke() {
                return new AndroidUnityBootConfigDataSource((Context) this.$this_registry.resolveService(new ServiceKey("", b0.a(Context.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$23, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass23 extends l implements a {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass23(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final DataStore<ByteStringStoreOuterClass.ByteStringStore> invoke() {
                return this.$moduleInstance.glInfoDataStore((Context) this.$this_registry.resolveService(new ServiceKey("", b0.a(Context.class))), (w) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.IO_DISPATCHER, b0.a(w.class))), (DataMigration) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.PREF_GL_INFO, b0.a(DataMigration.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$24, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass24 extends l implements a {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass24(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final ByteStringDataSource invoke() {
                return this.$moduleInstance.glInfoDataStore((DataStore) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_GL_INFO, b0.a(DataStore.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$25, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass25 extends l implements a {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass25(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final DataStore<UniversalRequestStoreOuterClass.UniversalRequestStore> invoke() {
                return this.$moduleInstance.universalRequestDataStore((Context) this.$this_registry.resolveService(new ServiceKey("", b0.a(Context.class))), (w) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.IO_DISPATCHER, b0.a(w.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$26, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass26 extends l implements a {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass26(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final DataStore<ByteStringStoreOuterClass.ByteStringStore> invoke() {
                return this.$moduleInstance.iapTransactionDataStore((Context) this.$this_registry.resolveService(new ServiceKey("", b0.a(Context.class))), (w) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.IO_DISPATCHER, b0.a(w.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$27, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass27 extends l implements a {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass27(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final ByteStringDataSource invoke() {
                return this.$moduleInstance.iapTransactionDataStore((DataStore) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_IAP_TRANSACTION, b0.a(DataStore.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$28, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass28 extends l implements a {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass28(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final DataStore<WebviewConfigurationStore.WebViewConfigurationStore> invoke() {
                return this.$moduleInstance.webViewConfigurationDataStore((Context) this.$this_registry.resolveService(new ServiceKey("", b0.a(Context.class))), (w) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.IO_DISPATCHER, b0.a(w.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$29, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass29 extends l implements a {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass29(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final AsyncTokenStorage invoke() {
                return this.$moduleInstance.asyncTokenStorage((TokenStorage) this.$this_registry.resolveService(new ServiceKey("", b0.a(TokenStorage.class))), (SDKMetricsSender) this.$this_registry.resolveService(new ServiceKey("", b0.a(SDKMetricsSender.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass3 extends l implements a {
            final /* synthetic */ UnityAdsModule $moduleInstance;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(UnityAdsModule unityAdsModule) {
                super(0);
                this.$moduleInstance = unityAdsModule;
            }

            @Override // e6.a
            public final w invoke() {
                return this.$moduleInstance.defaultDispatcher();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$30, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass30 extends l implements a {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass30(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final VolumeChangeMonitor invoke() {
                return this.$moduleInstance.volumeChangeMonitor((VolumeChange) this.$this_registry.resolveService(new ServiceKey("", b0.a(VolumeChange.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$31, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass31 extends l implements a {
            final /* synthetic */ UnityAdsModule $moduleInstance;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass31(UnityAdsModule unityAdsModule) {
                super(0);
                this.$moduleInstance = unityAdsModule;
            }

            @Override // e6.a
            public final JsonStorage invoke() {
                return this.$moduleInstance.publicJsonStorage();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$32, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass32 extends l implements a {
            final /* synthetic */ UnityAdsModule $moduleInstance;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass32(UnityAdsModule unityAdsModule) {
                super(0);
                this.$moduleInstance = unityAdsModule;
            }

            @Override // e6.a
            public final JsonStorage invoke() {
                return this.$moduleInstance.privateJsonStorage();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$33, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass33 extends l implements a {
            final /* synthetic */ UnityAdsModule $moduleInstance;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass33(UnityAdsModule unityAdsModule) {
                super(0);
                this.$moduleInstance = unityAdsModule;
            }

            @Override // e6.a
            public final JsonStorage invoke() {
                return this.$moduleInstance.memoryJsonStorage();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$34, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass34 extends l implements a {
            final /* synthetic */ UnityAdsModule $moduleInstance;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass34(UnityAdsModule unityAdsModule) {
                super(0);
                this.$moduleInstance = unityAdsModule;
            }

            @Override // e6.a
            public final NativeConfigurationOuterClass.NativeConfiguration invoke() {
                return this.$moduleInstance.defaultNativeConfiguration();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$35, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass35 extends l implements a {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass35(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final MeasurementsService invoke() {
                return this.$moduleInstance.measurementService((Context) this.$this_registry.resolveService(new ServiceKey("", b0.a(Context.class))), (ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", b0.a(ISDKDispatchers.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$36, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass36 extends l implements a {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass36(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final TopicsService invoke() {
                return this.$moduleInstance.topicsService((Context) this.$this_registry.resolveService(new ServiceKey("", b0.a(Context.class))), (ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", b0.a(ISDKDispatchers.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$37, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass37 extends l implements a {
            public static final AnonymousClass37 INSTANCE = new AnonymousClass37();

            public AnonymousClass37() {
                super(0);
            }

            @Override // e6.a
            public final CronetEngineBuilderFactory invoke() {
                return new CronetEngineBuilderFactory();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$38, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass38 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass38(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final HttpClientProvider invoke() {
                return new AndroidHttpClientProvider((ConfigFileFromLocalStorage) this.$this_registry.resolveService(new ServiceKey("", b0.a(ConfigFileFromLocalStorage.class))), (AlternativeFlowReader) this.$this_registry.resolveService(new ServiceKey("", b0.a(AlternativeFlowReader.class))), (ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", b0.a(ISDKDispatchers.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", b0.a(SendDiagnosticEvent.class))), (Context) this.$this_registry.resolveService(new ServiceKey("", b0.a(Context.class))), (CronetEngineBuilderFactory) this.$this_registry.resolveService(new ServiceKey("", b0.a(CronetEngineBuilderFactory.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))), (CleanupDirectory) this.$this_registry.resolveService(new ServiceKey("", b0.a(CleanupDirectory.class))), (MediationTraitsMetadataReader) this.$this_registry.resolveService(new ServiceKey("", b0.a(MediationTraitsMetadataReader.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$39, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass39 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$39$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
            @e(c = "com.unity3d.services.core.di.ServiceProvider$initialize$1$39$1", f = "ServiceProvider.kt", l = {460}, m = "invokeSuspend")
            public static final class C02211 extends i implements p {
                final /* synthetic */ ServicesRegistry $this_registry;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C02211(ServicesRegistry servicesRegistry, c<? super C02211> cVar) {
                    super(2, cVar);
                    this.$this_registry = servicesRegistry;
                }

                @Override // x5.a
                public final c<x> create(Object obj, c<?> cVar) {
                    return new C02211(this.$this_registry, cVar);
                }

                @Override // x5.a
                public final Object invokeSuspend(Object obj) throws Throwable {
                    w5.a aVar = w5.a.f17774a;
                    int i2 = this.label;
                    if (i2 != 0) {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        q.z0(obj);
                        return obj;
                    }
                    q.z0(obj);
                    HttpClientProvider httpClientProvider = (HttpClientProvider) this.$this_registry.resolveService(new ServiceKey("", b0.a(HttpClientProvider.class)));
                    this.label = 1;
                    Object objInvoke$default = HttpClientProvider.DefaultImpls.invoke$default(httpClientProvider, false, this, 1, null);
                    return objInvoke$default == aVar ? aVar : objInvoke$default;
                }

                @Override // e6.p
                public final Object invoke(a0 a0Var, c<? super HttpClient> cVar) {
                    return ((C02211) create(a0Var, cVar)).invokeSuspend(x.f13520a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass39(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final HttpClient invoke() {
                return (HttpClient) c0.A(v5.i.f17610a, new C02211(this.$this_registry, null));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$4, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass4 extends l implements a {
            final /* synthetic */ UnityAdsModule $moduleInstance;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass4(UnityAdsModule unityAdsModule) {
                super(0);
                this.$moduleInstance = unityAdsModule;
            }

            @Override // e6.a
            public final w invoke() {
                return this.$moduleInstance.ioDispatcher();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$40, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass40 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$40$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
            @e(c = "com.unity3d.services.core.di.ServiceProvider$initialize$1$40$1", f = "ServiceProvider.kt", l = {461}, m = "invokeSuspend")
            public static final class C02221 extends i implements p {
                final /* synthetic */ ServicesRegistry $this_registry;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C02221(ServicesRegistry servicesRegistry, c<? super C02221> cVar) {
                    super(2, cVar);
                    this.$this_registry = servicesRegistry;
                }

                @Override // x5.a
                public final c<x> create(Object obj, c<?> cVar) {
                    return new C02221(this.$this_registry, cVar);
                }

                @Override // x5.a
                public final Object invokeSuspend(Object obj) throws Throwable {
                    w5.a aVar = w5.a.f17774a;
                    int i2 = this.label;
                    if (i2 != 0) {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        q.z0(obj);
                        return obj;
                    }
                    q.z0(obj);
                    HttpClientProvider httpClientProvider = (HttpClientProvider) this.$this_registry.resolveService(new ServiceKey("", b0.a(HttpClientProvider.class)));
                    this.label = 1;
                    Object objInvoke = httpClientProvider.invoke(true, this);
                    return objInvoke == aVar ? aVar : objInvoke;
                }

                @Override // e6.p
                public final Object invoke(a0 a0Var, c<? super HttpClient> cVar) {
                    return ((C02221) create(a0Var, cVar)).invokeSuspend(x.f13520a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass40(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final HttpClient invoke() {
                return (HttpClient) c0.A(v5.i.f17610a, new C02221(this.$this_registry, null));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$41, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass41 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass41(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final MediationTraitsMetadataReader invoke() {
                return new MediationTraitsMetadataReader((JsonStorage) this.$this_registry.resolveService(new ServiceKey("MEMORY", b0.a(JsonStorage.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$42, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass42 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass42(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final AlternativeFlowReader invoke() {
                return new CommonAlternativeFlowReader((ConfigurationReader) this.$this_registry.resolveService(new ServiceKey("", b0.a(ConfigurationReader.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))), (MediationTraitsMetadataReader) this.$this_registry.resolveService(new ServiceKey("", b0.a(MediationTraitsMetadataReader.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$43, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass43 extends l implements a {
            public static final AnonymousClass43 INSTANCE = new AnonymousClass43();

            public AnonymousClass43() {
                super(0);
            }

            @Override // e6.a
            public final TcfDataSource invoke() {
                return new AndroidTcfDataSource();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$44, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass44 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass44(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final TcfRepository invoke() {
                return new AndroidTcfRepository((TcfDataSource) this.$this_registry.resolveService(new ServiceKey("", b0.a(TcfDataSource.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$45, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass45 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass45(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final AndroidManifestIntPropertyReader invoke() {
                return new AndroidManifestIntPropertyReader((Context) this.$this_registry.resolveService(new ServiceKey("", b0.a(Context.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$46, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass46 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass46(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final AndroidTestDataInfo invoke() {
                return new AndroidTestDataInfo((AndroidManifestIntPropertyReader) this.$this_registry.resolveService(new ServiceKey("", b0.a(AndroidManifestIntPropertyReader.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$47, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass47 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass47(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final GameServerIdReader invoke() {
                return new GameServerIdReader((JsonStorage) this.$this_registry.resolveService(new ServiceKey("PUBLIC", b0.a(JsonStorage.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$48, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass48 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass48(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final StoreDataSource invoke() {
                return new AndroidStoreDataSource((Context) this.$this_registry.resolveService(new ServiceKey("", b0.a(Context.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$49, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass49 extends l implements a {
            public static final AnonymousClass49 INSTANCE = new AnonymousClass49();

            public AnonymousClass49() {
                super(0);
            }

            @Override // e6.a
            public final AnalyticsDataSource invoke() {
                return new AndroidAnalyticsDataSource();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$5, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass5 extends l implements a {
            final /* synthetic */ UnityAdsModule $moduleInstance;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass5(UnityAdsModule unityAdsModule) {
                super(0);
                this.$moduleInstance = unityAdsModule;
            }

            @Override // e6.a
            public final ISDKDispatchers invoke() {
                return this.$moduleInstance.sdkDispatchers();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$50, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass50 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass50(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final DeveloperConsentDataSource invoke() {
                return new AndroidDeveloperConsentDataSource((FlattenerRulesUseCase) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DEV_CONSENT_PRIVACY_RULES, b0.a(FlattenerRulesUseCase.class))), (JsonStorage) this.$this_registry.resolveService(new ServiceKey("PUBLIC", b0.a(JsonStorage.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$51, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass51 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass51(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final DynamicDeviceInfoDataSource invoke() {
                return new AndroidDynamicDeviceInfoDataSource((Context) this.$this_registry.resolveService(new ServiceKey("", b0.a(Context.class))), (LifecycleDataSource) this.$this_registry.resolveService(new ServiceKey("", b0.a(LifecycleDataSource.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$52, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass52 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass52(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final LegacyUserConsentDataSource invoke() {
                return new AndroidLegacyUserConsentDataSource((FlattenerRulesUseCase) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.LEGACY_PRIVACY_RULES, b0.a(FlattenerRulesUseCase.class))), (JsonStorage) this.$this_registry.resolveService(new ServiceKey("PRIVATE", b0.a(JsonStorage.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$53, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass53 extends l implements a {
            public static final AnonymousClass53 INSTANCE = new AnonymousClass53();

            public AnonymousClass53() {
                super(0);
            }

            @Override // e6.a
            public final LifecycleDataSource invoke() {
                return new AndroidLifecycleDataSource();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$54, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass54 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass54(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final CacheDataSource invoke() {
                return new AndroidLocalCacheDataSource((CreateFile) this.$this_registry.resolveService(new ServiceKey("", b0.a(CreateFile.class))), (GetFileExtensionFromUrl) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetFileExtensionFromUrl.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$55, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass55 extends l implements a {
            public static final AnonymousClass55 INSTANCE = new AnonymousClass55();

            public AnonymousClass55() {
                super(0);
            }

            @Override // e6.a
            public final CreateFile invoke() {
                return new CommonCreateFile();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$56, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass56 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass56(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final GetFileExtensionFromUrl invoke() {
                return new CommonGetFileExtensionFromUrl((RemoveUrlQuery) this.$this_registry.resolveService(new ServiceKey("", b0.a(RemoveUrlQuery.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$57, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass57 extends l implements a {
            public static final AnonymousClass57 INSTANCE = new AnonymousClass57();

            public AnonymousClass57() {
                super(0);
            }

            @Override // e6.a
            public final RemoveUrlQuery invoke() {
                return new AndroidRemoveUrlQuery();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$58, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass58 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass58(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final MediationDataSource invoke() {
                return new AndroidMediationDataSource((JsonStorage) this.$this_registry.resolveService(new ServiceKey("MEMORY", b0.a(JsonStorage.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$59, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass59 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass59(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final PrivacyDeviceInfoDataSource invoke() {
                return new AndroidPrivacyDeviceInfoDataSource((Context) this.$this_registry.resolveService(new ServiceKey("", b0.a(Context.class))), (FIdDataSource) this.$this_registry.resolveService(new ServiceKey("", b0.a(FIdDataSource.class))), (AndroidAppSetIdDataSource) this.$this_registry.resolveService(new ServiceKey("", b0.a(AndroidAppSetIdDataSource.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$6, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass6 extends l implements a {
            final /* synthetic */ UnityAdsModule $moduleInstance;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass6(UnityAdsModule unityAdsModule) {
                super(0);
                this.$moduleInstance = unityAdsModule;
            }

            @Override // e6.a
            public final SDKMetricsSender invoke() {
                return this.$moduleInstance.sdkMetrics();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$60, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass60 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass60(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final CacheDataSource invoke() {
                return new AndroidRemoteCacheDataSource((w) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.IO_DISPATCHER, b0.a(w.class))), (CreateFile) this.$this_registry.resolveService(new ServiceKey("", b0.a(CreateFile.class))), (GetFileExtensionFromUrl) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetFileExtensionFromUrl.class))), (HttpClient) this.$this_registry.resolveService(new ServiceKey("", b0.a(HttpClient.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$61, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass61 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass61(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final StaticDeviceInfoDataSource invoke() {
                return new AndroidStaticDeviceInfoDataSource((Context) this.$this_registry.resolveService(new ServiceKey("", b0.a(Context.class))), (ByteStringDataSource) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_GL_INFO, b0.a(ByteStringDataSource.class))), (AnalyticsDataSource) this.$this_registry.resolveService(new ServiceKey("", b0.a(AnalyticsDataSource.class))), (StoreDataSource) this.$this_registry.resolveService(new ServiceKey("", b0.a(StoreDataSource.class))), (UnityBootConfigDataSource) this.$this_registry.resolveService(new ServiceKey("", b0.a(UnityBootConfigDataSource.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$62, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass62 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass62(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final DataMigration<ByteStringStoreOuterClass.ByteStringStore> invoke() {
                return new FetchGLInfoDataMigration((GetOpenGLRendererInfo) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetOpenGLRendererInfo.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$63, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass63 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass63(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final UniversalRequestDataSource invoke() {
                return new UniversalRequestDataSource((DataStore) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_UNIVERSAL_REQUEST, b0.a(DataStore.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$64, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass64 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass64(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final WebviewConfigurationDataSource invoke() {
                return new WebviewConfigurationDataSource((DataStore) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_WEBVIEW_CONFIG, b0.a(DataStore.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$65, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass65 extends l implements a {
            public static final AnonymousClass65 INSTANCE = new AnonymousClass65();

            public AnonymousClass65() {
                super(0);
            }

            @Override // e6.a
            public final OmidManager invoke() {
                return new AndroidOmidManager();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$66, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass66 extends l implements a {
            public static final AnonymousClass66 INSTANCE = new AnonymousClass66();

            public AnonymousClass66() {
                super(0);
            }

            @Override // e6.a
            public final SDKPropertiesManager invoke() {
                return new AndroidSDKPropertiesManager();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$67, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass67 extends l implements a {
            public static final AnonymousClass67 INSTANCE = new AnonymousClass67();

            public AnonymousClass67() {
                super(0);
            }

            @Override // e6.a
            public final StorageManager invoke() {
                return new AndroidStorageManager();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$68, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass68 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass68(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final BillingClientAdapter invoke() {
                return new BillingClientAdapterFactory().createBillingClientAdapter((Context) this.$this_registry.resolveService(new ServiceKey("", b0.a(Context.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$69, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass69 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass69(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final ProductDetailsFetcher invoke() {
                return new ProductDetailsFetcherWithFallback(new CommonProductDetailsFetcher((BillingClientAdapter) this.$this_registry.resolveService(new ServiceKey("", b0.a(BillingClientAdapter.class))), "inapp"), new CommonProductDetailsFetcher((BillingClientAdapter) this.$this_registry.resolveService(new ServiceKey("", b0.a(BillingClientAdapter.class))), "subs"));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$7, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass7 extends l implements a {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass7(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final a0 invoke() {
                return this.$moduleInstance.initCoroutineScope((ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", b0.a(ISDKDispatchers.class))), (y) this.$this_registry.resolveService(new ServiceKey("sdk", b0.a(y.class))), (f1) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_PUBLIC_JOB, b0.a(f1.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$70, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass70 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass70(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final TransactionEventManager invoke() {
                return new TransactionEventManager((a0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_TRANSACTION_SCOPE, b0.a(a0.class))), (BillingClientAdapter) this.$this_registry.resolveService(new ServiceKey("", b0.a(BillingClientAdapter.class))), (GetTransactionData) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetTransactionData.class))), (GetTransactionRequest) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetTransactionRequest.class))), (TransactionEventRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(TransactionEventRepository.class))), (ByteStringDataSource) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_IAP_TRANSACTION, b0.a(ByteStringDataSource.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", b0.a(SendDiagnosticEvent.class))), (IsBillingClientAvailable) this.$this_registry.resolveService(new ServiceKey("", b0.a(IsBillingClientAvailable.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))), (ProductDetailsFetcher) this.$this_registry.resolveService(new ServiceKey("", b0.a(ProductDetailsFetcher.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$71, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass71 extends l implements a {
            public static final AnonymousClass71 INSTANCE = new AnonymousClass71();

            public AnonymousClass71() {
                super(0);
            }

            @Override // e6.a
            public final AdRepository invoke() {
                return new AndroidAdRepository();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$72, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass72 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass72(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final CacheRepository invoke() {
                return new AndroidCacheRepository((w) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.IO_DISPATCHER, b0.a(w.class))), (GetCacheDirectory) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetCacheDirectory.class))), (CacheDataSource) this.$this_registry.resolveService(new ServiceKey("local", b0.a(CacheDataSource.class))), (CacheDataSource) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_REMOTE, b0.a(CacheDataSource.class))), (Context) this.$this_registry.resolveService(new ServiceKey("", b0.a(Context.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))), (CleanupDirectory) this.$this_registry.resolveService(new ServiceKey("", b0.a(CleanupDirectory.class))), (DownloadPriorityQueue) this.$this_registry.resolveService(new ServiceKey("", b0.a(DownloadPriorityQueue.class))), (CreateFile) this.$this_registry.resolveService(new ServiceKey("", b0.a(CreateFile.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$73, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass73 extends l implements a {
            public static final AnonymousClass73 INSTANCE = new AnonymousClass73();

            public AnonymousClass73() {
                super(0);
            }

            @Override // e6.a
            public final GetCacheDirectory invoke() {
                return new CommonGetCacheDirectory();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$74, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass74 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass74(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final CampaignRepository invoke() {
                return new AndroidCampaignRepository((GetSharedDataTimestamps) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetSharedDataTimestamps.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$75, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass75 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass75(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final DeveloperConsentRepository invoke() {
                return new AndroidDeveloperConsentRepository((DeveloperConsentDataSource) this.$this_registry.resolveService(new ServiceKey("", b0.a(DeveloperConsentDataSource.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$76, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass76 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass76(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final DeviceInfoRepository invoke() {
                return new AndroidDeviceInfoRepository((StaticDeviceInfoDataSource) this.$this_registry.resolveService(new ServiceKey("", b0.a(StaticDeviceInfoDataSource.class))), (DynamicDeviceInfoDataSource) this.$this_registry.resolveService(new ServiceKey("", b0.a(DynamicDeviceInfoDataSource.class))), (PrivacyDeviceInfoDataSource) this.$this_registry.resolveService(new ServiceKey("", b0.a(PrivacyDeviceInfoDataSource.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$77, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass77 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass77(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final DiagnosticEventRepository invoke() {
                return new AndroidDiagnosticEventRepository((CoroutineTimer) this.$this_registry.resolveService(new ServiceKey("", b0.a(CoroutineTimer.class))), (GetDiagnosticEventRequest) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetDiagnosticEventRequest.class))), (w) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, b0.a(w.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$78, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass78 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass78(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final LegacyUserConsentRepository invoke() {
                return new AndroidLegacyUserConsentRepository((LegacyUserConsentDataSource) this.$this_registry.resolveService(new ServiceKey("", b0.a(LegacyUserConsentDataSource.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$79, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass79 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass79(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final MediationRepository invoke() {
                return new AndroidMediationRepository((MediationDataSource) this.$this_registry.resolveService(new ServiceKey("", b0.a(MediationDataSource.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$8, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass8 extends l implements a {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass8(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final a0 invoke() {
                return this.$moduleInstance.loadCoroutineScope((ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", b0.a(ISDKDispatchers.class))), (y) this.$this_registry.resolveService(new ServiceKey("sdk", b0.a(y.class))), (f1) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_PUBLIC_JOB, b0.a(f1.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$80, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass80 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass80(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final OpenMeasurementRepository invoke() {
                return new AndroidOpenMeasurementRepository((w) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.MAIN_DISPATCHER, b0.a(w.class))), (OmidManager) this.$this_registry.resolveService(new ServiceKey("", b0.a(OmidManager.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$81, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass81 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass81(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final SessionRepository invoke() {
                return new AndroidSessionRepository((ByteStringDataSource) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_GATEWAY_CACHE, b0.a(ByteStringDataSource.class))), (ByteStringDataSource) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_PRIVACY, b0.a(ByteStringDataSource.class))), (ByteStringDataSource) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_PRIVACY_FSM, b0.a(ByteStringDataSource.class))), (ByteStringDataSource) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_NATIVE_CONFIG, b0.a(ByteStringDataSource.class))), (AndroidUnityInfoDataSource) this.$this_registry.resolveService(new ServiceKey("", b0.a(AndroidUnityInfoDataSource.class))), (NativeConfigurationOuterClass.NativeConfiguration) this.$this_registry.resolveService(new ServiceKey("", b0.a(NativeConfigurationOuterClass.NativeConfiguration.class))), (w) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.IO_DISPATCHER, b0.a(w.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", b0.a(SendDiagnosticEvent.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$82, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass82 extends l implements a {
            public static final AnonymousClass82 INSTANCE = new AnonymousClass82();

            public AnonymousClass82() {
                super(0);
            }

            @Override // e6.a
            public final TransactionEventRepository invoke() {
                return new AndroidTransactionEventRepository();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$83, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass83 extends l implements a {
            public static final AnonymousClass83 INSTANCE = new AnonymousClass83();

            public AnonymousClass83() {
                super(0);
            }

            @Override // e6.a
            public final OperativeEventRepository invoke() {
                return new OperativeEventRepository();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$84, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass84 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass84(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final ExecuteAdViewerRequest invoke() {
                return new AndroidExecuteAdViewerRequest((w) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.IO_DISPATCHER, b0.a(w.class))), (HttpClient) this.$this_registry.resolveService(new ServiceKey("", b0.a(HttpClient.class))), (GetCachedAsset) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetCachedAsset.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$85, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass85 extends l implements a {
            public static final AnonymousClass85 INSTANCE = new AnonymousClass85();

            public AnonymousClass85() {
                super(0);
            }

            @Override // e6.a
            public final GetByteStringId invoke() {
                return new AndroidGenerateByteStringId();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$86, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass86 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass86(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final HandleOpenUrl invoke() {
                return new AndroidHandleOpenUrl((Context) this.$this_registry.resolveService(new ServiceKey("", b0.a(Context.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$87, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass87 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass87(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final Refresh invoke() {
                return new AndroidRefresh((w) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, b0.a(w.class))), (GetAdDataRefreshRequest) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetAdDataRefreshRequest.class))), (GetRequestPolicy) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_AD_REQ, b0.a(GetRequestPolicy.class))), (GatewayClient) this.$this_registry.resolveService(new ServiceKey("", b0.a(GatewayClient.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$88, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass88 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass88(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final SendDiagnosticEvent invoke() {
                return new AndroidSendDiagnosticEvent((DiagnosticEventRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(DiagnosticEventRepository.class))), (GetDiagnosticEventRequest) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetDiagnosticEventRequest.class))), (LifecycleDataSource) this.$this_registry.resolveService(new ServiceKey("", b0.a(LifecycleDataSource.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$89, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass89 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass89(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final SendWebViewClientErrorDiagnostics invoke() {
                return new AndroidSendWebViewClientErrorDiagnostics((SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", b0.a(SendDiagnosticEvent.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$9, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass9 extends l implements a {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass9(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final a0 invoke() {
                return this.$moduleInstance.showCoroutineScope((ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", b0.a(ISDKDispatchers.class))), (y) this.$this_registry.resolveService(new ServiceKey("sdk", b0.a(y.class))), (f1) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_PUBLIC_JOB, b0.a(f1.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$90, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass90 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass90(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final Show invoke() {
                return new AndroidShow((AdRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(AdRepository.class))), (GameServerIdReader) this.$this_registry.resolveService(new ServiceKey("", b0.a(GameServerIdReader.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", b0.a(SendDiagnosticEvent.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$91, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass91 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass91(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final CacheFile invoke() {
                return new CommonCacheFile((CacheRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(CacheRepository.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", b0.a(SendDiagnosticEvent.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$92, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass92 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass92(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final CleanAssets invoke() {
                return new CommonCleanAssets((CacheRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(CacheRepository.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", b0.a(SendDiagnosticEvent.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$93, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass93 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass93(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final GetAdObject invoke() {
                return new CommonGetAdObject((AdRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(AdRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$94, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass94 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass94(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final GetHeaderBiddingToken invoke() {
                return new CommonGetHeaderBiddingToken((BuildHeaderBiddingToken) this.$this_registry.resolveService(new ServiceKey("", b0.a(BuildHeaderBiddingToken.class))), (FetchSignalsAndSendUseCase) this.$this_registry.resolveService(new ServiceKey("", b0.a(FetchSignalsAndSendUseCase.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$95, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass95 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass95(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final BuildHeaderBiddingToken invoke() {
                return new AndroidBuildHeaderBiddingToken((GetByteStringId) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetByteStringId.class))), (GetClientInfo) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetClientInfo.class))), (GetSharedDataTimestamps) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetSharedDataTimestamps.class))), (GetLimitedSessionToken) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetLimitedSessionToken.class))), (GetInitializationData) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetInitializationData.class))), (DeviceInfoRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(DeviceInfoRepository.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))), (CampaignRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(CampaignRepository.class))), (TcfRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(TcfRepository.class))), (AndroidTestDataInfo) this.$this_registry.resolveService(new ServiceKey("", b0.a(AndroidTestDataInfo.class))), (OfferwallManager) this.$this_registry.resolveService(new ServiceKey("", b0.a(OfferwallManager.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$96, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass96 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass96(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final TokenNumberProvider invoke() {
                return new CommonTokenNumberProvider((SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$97, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass97 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass97(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final GetInitializationData invoke() {
                return new AndroidGetInitializationData((GetInitializationRequestPayload) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetInitializationRequestPayload.class))), (GetUniversalRequestSharedData) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetUniversalRequestSharedData.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$98, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass98 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass98(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final MediationInitBlobMetadataReader invoke() {
                return new MediationInitBlobMetadataReader((JsonStorage) this.$this_registry.resolveService(new ServiceKey("MEMORY", b0.a(JsonStorage.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$99, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass99 extends l implements a {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass99(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // e6.a
            public final GetInitializationRequestPayload invoke() {
                return new AndroidGetInitializationRequestPayload((GetClientInfo) this.$this_registry.resolveService(new ServiceKey("", b0.a(GetClientInfo.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(SessionRepository.class))), (DeviceInfoRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(DeviceInfoRepository.class))), (LegacyUserConsentRepository) this.$this_registry.resolveService(new ServiceKey("", b0.a(LegacyUserConsentRepository.class))), (MediationInitBlobMetadataReader) this.$this_registry.resolveService(new ServiceKey("", b0.a(MediationInitBlobMetadataReader.class))));
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ServicesRegistry) obj);
            return x.f13520a;
        }

        public final void invoke(ServicesRegistry registry) {
            k.e(registry, "$this$registry");
            UnityAdsModule unityAdsModule = new UnityAdsModule();
            registry.updateService(new ServiceKey("", b0.a(Context.class)), b.C(C02201.INSTANCE));
            registry.updateService(new ServiceKey(ServiceProvider.MAIN_DISPATCHER, b0.a(w.class)), b.C(new AnonymousClass2(unityAdsModule)));
            registry.updateService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, b0.a(w.class)), b.C(new AnonymousClass3(unityAdsModule)));
            registry.updateService(new ServiceKey(ServiceProvider.IO_DISPATCHER, b0.a(w.class)), b.C(new AnonymousClass4(unityAdsModule)));
            registry.updateService(new ServiceKey("", b0.a(ISDKDispatchers.class)), b.C(new AnonymousClass5(unityAdsModule)));
            registry.updateService(new ServiceKey("", b0.a(SDKMetricsSender.class)), b.C(new AnonymousClass6(unityAdsModule)));
            registry.updateService(new ServiceKey(ServiceProvider.NAMED_INIT_SCOPE, b0.a(a0.class)), ServiceFactoryKt.factoryOf(new AnonymousClass7(unityAdsModule, registry)));
            registry.updateService(new ServiceKey(ServiceProvider.NAMED_LOAD_SCOPE, b0.a(a0.class)), ServiceFactoryKt.factoryOf(new AnonymousClass8(unityAdsModule, registry)));
            registry.updateService(new ServiceKey(ServiceProvider.NAMED_SHOW_SCOPE, b0.a(a0.class)), ServiceFactoryKt.factoryOf(new AnonymousClass9(unityAdsModule, registry)));
            registry.updateService(new ServiceKey(ServiceProvider.NAMED_TRANSACTION_SCOPE, b0.a(a0.class)), ServiceFactoryKt.factoryOf(new AnonymousClass10(unityAdsModule, registry)));
            registry.updateService(new ServiceKey(ServiceProvider.NAMED_GET_TOKEN_SCOPE, b0.a(a0.class)), ServiceFactoryKt.factoryOf(new AnonymousClass11(unityAdsModule, registry)));
            registry.updateService(new ServiceKey(ServiceProvider.NAMED_SCAR_SCOPE, b0.a(a0.class)), ServiceFactoryKt.factoryOf(new AnonymousClass12(unityAdsModule, registry)));
            registry.updateService(new ServiceKey(ServiceProvider.NAMED_OFFERWALL_SCOPE, b0.a(a0.class)), ServiceFactoryKt.factoryOf(new AnonymousClass13(unityAdsModule, registry)));
            registry.updateService(new ServiceKey(ServiceProvider.NAMED_OMID_SCOPE, b0.a(a0.class)), ServiceFactoryKt.factoryOf(new AnonymousClass14(unityAdsModule, registry)));
            registry.updateService(new ServiceKey(ServiceProvider.NAMED_PUBLIC_JOB, b0.a(f1.class)), ServiceFactoryKt.factoryOf(new AnonymousClass15(unityAdsModule, registry)));
            registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_GATEWAY_CACHE, b0.a(ByteStringDataSource.class)), b.C(new AnonymousClass16(registry)));
            registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_PRIVACY, b0.a(DataStore.class)), b.C(new AnonymousClass17(unityAdsModule, registry)));
            registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_PRIVACY, b0.a(ByteStringDataSource.class)), b.C(new AnonymousClass18(unityAdsModule, registry)));
            registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_PRIVACY_FSM, b0.a(DataStore.class)), b.C(new AnonymousClass19(unityAdsModule, registry)));
            registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_PRIVACY_FSM, b0.a(ByteStringDataSource.class)), b.C(new AnonymousClass20(unityAdsModule, registry)));
            registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_NATIVE_CONFIG, b0.a(DataStore.class)), b.C(new AnonymousClass21(unityAdsModule, registry)));
            registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_NATIVE_CONFIG, b0.a(ByteStringDataSource.class)), b.C(new AnonymousClass22(unityAdsModule, registry)));
            registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_GL_INFO, b0.a(DataStore.class)), b.C(new AnonymousClass23(unityAdsModule, registry)));
            registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_GL_INFO, b0.a(ByteStringDataSource.class)), b.C(new AnonymousClass24(unityAdsModule, registry)));
            registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_UNIVERSAL_REQUEST, b0.a(DataStore.class)), b.C(new AnonymousClass25(unityAdsModule, registry)));
            registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_IAP_TRANSACTION, b0.a(DataStore.class)), b.C(new AnonymousClass26(unityAdsModule, registry)));
            registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_IAP_TRANSACTION, b0.a(ByteStringDataSource.class)), b.C(new AnonymousClass27(unityAdsModule, registry)));
            registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_WEBVIEW_CONFIG, b0.a(DataStore.class)), b.C(new AnonymousClass28(unityAdsModule, registry)));
            registry.updateService(new ServiceKey("", b0.a(AsyncTokenStorage.class)), b.C(new AnonymousClass29(unityAdsModule, registry)));
            registry.updateService(new ServiceKey("", b0.a(VolumeChangeMonitor.class)), b.C(new AnonymousClass30(unityAdsModule, registry)));
            registry.updateService(new ServiceKey("PUBLIC", b0.a(JsonStorage.class)), b.C(new AnonymousClass31(unityAdsModule)));
            registry.updateService(new ServiceKey("PRIVATE", b0.a(JsonStorage.class)), b.C(new AnonymousClass32(unityAdsModule)));
            registry.updateService(new ServiceKey("MEMORY", b0.a(JsonStorage.class)), b.C(new AnonymousClass33(unityAdsModule)));
            registry.updateService(new ServiceKey("", b0.a(NativeConfigurationOuterClass.NativeConfiguration.class)), b.C(new AnonymousClass34(unityAdsModule)));
            registry.updateService(new ServiceKey("", b0.a(MeasurementsService.class)), b.C(new AnonymousClass35(unityAdsModule, registry)));
            registry.updateService(new ServiceKey("", b0.a(TopicsService.class)), b.C(new AnonymousClass36(unityAdsModule, registry)));
            registry.updateService(new ServiceKey("", b0.a(CronetEngineBuilderFactory.class)), b.C(AnonymousClass37.INSTANCE));
            registry.updateService(new ServiceKey("", b0.a(HttpClientProvider.class)), b.C(new AnonymousClass38(registry)));
            registry.updateService(new ServiceKey("", b0.a(HttpClient.class)), b.C(new AnonymousClass39(registry)));
            registry.updateService(new ServiceKey(ServiceProvider.NAMED_GATEWAY_HTTP_CLIENT, b0.a(HttpClient.class)), b.C(new AnonymousClass40(registry)));
            registry.updateService(new ServiceKey("", b0.a(MediationTraitsMetadataReader.class)), ServiceFactoryKt.factoryOf(new AnonymousClass41(registry)));
            registry.updateService(new ServiceKey("", b0.a(AlternativeFlowReader.class)), b.C(new AnonymousClass42(registry)));
            registry.updateService(new ServiceKey("", b0.a(TcfDataSource.class)), b.C(AnonymousClass43.INSTANCE));
            registry.updateService(new ServiceKey("", b0.a(TcfRepository.class)), b.C(new AnonymousClass44(registry)));
            registry.updateService(new ServiceKey("", b0.a(AndroidManifestIntPropertyReader.class)), b.C(new AnonymousClass45(registry)));
            registry.updateService(new ServiceKey("", b0.a(AndroidTestDataInfo.class)), b.C(new AnonymousClass46(registry)));
            registry.updateService(new ServiceKey("", b0.a(GameServerIdReader.class)), b.C(new AnonymousClass47(registry)));
            registry.updateService(new ServiceKey("", b0.a(StoreDataSource.class)), b.C(new AnonymousClass48(registry)));
            registry.updateService(new ServiceKey("", b0.a(AnalyticsDataSource.class)), b.C(AnonymousClass49.INSTANCE));
            registry.updateService(new ServiceKey("", b0.a(DeveloperConsentDataSource.class)), b.C(new AnonymousClass50(registry)));
            registry.updateService(new ServiceKey("", b0.a(DynamicDeviceInfoDataSource.class)), b.C(new AnonymousClass51(registry)));
            registry.updateService(new ServiceKey("", b0.a(LegacyUserConsentDataSource.class)), b.C(new AnonymousClass52(registry)));
            registry.updateService(new ServiceKey("", b0.a(LifecycleDataSource.class)), b.C(AnonymousClass53.INSTANCE));
            registry.updateService(new ServiceKey("local", b0.a(CacheDataSource.class)), b.C(new AnonymousClass54(registry)));
            registry.updateService(new ServiceKey("", b0.a(CreateFile.class)), b.C(AnonymousClass55.INSTANCE));
            registry.updateService(new ServiceKey("", b0.a(GetFileExtensionFromUrl.class)), b.C(new AnonymousClass56(registry)));
            registry.updateService(new ServiceKey("", b0.a(RemoveUrlQuery.class)), b.C(AnonymousClass57.INSTANCE));
            registry.updateService(new ServiceKey("", b0.a(MediationDataSource.class)), b.C(new AnonymousClass58(registry)));
            registry.updateService(new ServiceKey("", b0.a(PrivacyDeviceInfoDataSource.class)), b.C(new AnonymousClass59(registry)));
            registry.updateService(new ServiceKey(ServiceProvider.NAMED_REMOTE, b0.a(CacheDataSource.class)), b.C(new AnonymousClass60(registry)));
            registry.updateService(new ServiceKey("", b0.a(StaticDeviceInfoDataSource.class)), b.C(new AnonymousClass61(registry)));
            registry.updateService(new ServiceKey(ServiceProvider.PREF_GL_INFO, b0.a(DataMigration.class)), b.C(new AnonymousClass62(registry)));
            registry.updateService(new ServiceKey("", b0.a(UniversalRequestDataSource.class)), b.C(new AnonymousClass63(registry)));
            registry.updateService(new ServiceKey("", b0.a(WebviewConfigurationDataSource.class)), b.C(new AnonymousClass64(registry)));
            registry.updateService(new ServiceKey("", b0.a(OmidManager.class)), b.C(AnonymousClass65.INSTANCE));
            registry.updateService(new ServiceKey("", b0.a(SDKPropertiesManager.class)), b.C(AnonymousClass66.INSTANCE));
            registry.updateService(new ServiceKey("", b0.a(StorageManager.class)), b.C(AnonymousClass67.INSTANCE));
            registry.updateService(new ServiceKey("", b0.a(BillingClientAdapter.class)), b.C(new AnonymousClass68(registry)));
            registry.updateService(new ServiceKey("", b0.a(ProductDetailsFetcher.class)), b.C(new AnonymousClass69(registry)));
            registry.updateService(new ServiceKey("", b0.a(TransactionEventManager.class)), b.C(new AnonymousClass70(registry)));
            registry.updateService(new ServiceKey("", b0.a(AdRepository.class)), b.C(AnonymousClass71.INSTANCE));
            registry.updateService(new ServiceKey("", b0.a(CacheRepository.class)), b.C(new AnonymousClass72(registry)));
            registry.updateService(new ServiceKey("", b0.a(GetCacheDirectory.class)), b.C(AnonymousClass73.INSTANCE));
            registry.updateService(new ServiceKey("", b0.a(CampaignRepository.class)), b.C(new AnonymousClass74(registry)));
            registry.updateService(new ServiceKey("", b0.a(DeveloperConsentRepository.class)), b.C(new AnonymousClass75(registry)));
            registry.updateService(new ServiceKey("", b0.a(DeviceInfoRepository.class)), b.C(new AnonymousClass76(registry)));
            registry.updateService(new ServiceKey("", b0.a(DiagnosticEventRepository.class)), b.C(new AnonymousClass77(registry)));
            registry.updateService(new ServiceKey("", b0.a(LegacyUserConsentRepository.class)), b.C(new AnonymousClass78(registry)));
            registry.updateService(new ServiceKey("", b0.a(MediationRepository.class)), b.C(new AnonymousClass79(registry)));
            registry.updateService(new ServiceKey("", b0.a(OpenMeasurementRepository.class)), b.C(new AnonymousClass80(registry)));
            registry.updateService(new ServiceKey("", b0.a(SessionRepository.class)), b.C(new AnonymousClass81(registry)));
            registry.updateService(new ServiceKey("", b0.a(TransactionEventRepository.class)), b.C(AnonymousClass82.INSTANCE));
            registry.updateService(new ServiceKey("", b0.a(OperativeEventRepository.class)), b.C(AnonymousClass83.INSTANCE));
            registry.updateService(new ServiceKey("", b0.a(ExecuteAdViewerRequest.class)), b.C(new AnonymousClass84(registry)));
            registry.updateService(new ServiceKey("", b0.a(GetByteStringId.class)), b.C(AnonymousClass85.INSTANCE));
            registry.updateService(new ServiceKey("", b0.a(HandleOpenUrl.class)), b.C(new AnonymousClass86(registry)));
            registry.updateService(new ServiceKey("", b0.a(Refresh.class)), b.C(new AnonymousClass87(registry)));
            registry.updateService(new ServiceKey("", b0.a(SendDiagnosticEvent.class)), b.C(new AnonymousClass88(registry)));
            registry.updateService(new ServiceKey("", b0.a(SendWebViewClientErrorDiagnostics.class)), b.C(new AnonymousClass89(registry)));
            registry.updateService(new ServiceKey("", b0.a(Show.class)), b.C(new AnonymousClass90(registry)));
            registry.updateService(new ServiceKey("", b0.a(CacheFile.class)), b.C(new AnonymousClass91(registry)));
            registry.updateService(new ServiceKey("", b0.a(CleanAssets.class)), b.C(new AnonymousClass92(registry)));
            registry.updateService(new ServiceKey("", b0.a(GetAdObject.class)), b.C(new AnonymousClass93(registry)));
            registry.updateService(new ServiceKey("", b0.a(GetHeaderBiddingToken.class)), ServiceFactoryKt.factoryOf(new AnonymousClass94(registry)));
            registry.updateService(new ServiceKey("", b0.a(BuildHeaderBiddingToken.class)), ServiceFactoryKt.factoryOf(new AnonymousClass95(registry)));
            registry.updateService(new ServiceKey("", b0.a(TokenNumberProvider.class)), ServiceFactoryKt.factoryOf(new AnonymousClass96(registry)));
            registry.updateService(new ServiceKey("", b0.a(GetInitializationData.class)), b.C(new AnonymousClass97(registry)));
            registry.updateService(new ServiceKey("", b0.a(MediationInitBlobMetadataReader.class)), ServiceFactoryKt.factoryOf(new AnonymousClass98(registry)));
            registry.updateService(new ServiceKey("", b0.a(GetInitializationRequestPayload.class)), b.C(new AnonymousClass99(registry)));
            registry.updateService(new ServiceKey("", b0.a(GetInitializationState.class)), b.C(new AnonymousClass100(registry)));
            registry.updateService(new ServiceKey("", b0.a(GetIsFileCache.class)), b.C(new AnonymousClass101(registry)));
            registry.updateService(new ServiceKey("", b0.a(SetInitializationState.class)), b.C(new AnonymousClass102(registry)));
            registry.updateService(new ServiceKey(ServiceProvider.NAMED_AD_REQ, b0.a(GetRequestPolicy.class)), b.C(new AnonymousClass103(registry)));
            registry.updateService(new ServiceKey("", b0.a(GetAdDataRefreshRequest.class)), b.C(new AnonymousClass104(registry)));
            registry.updateService(new ServiceKey("", b0.a(GetAdPlayerConfigRequest.class)), b.C(new AnonymousClass105(registry)));
            registry.updateService(new ServiceKey("", b0.a(AndroidGetAdPlayerContext.class)), b.C(new AnonymousClass106(registry)));
            registry.updateService(new ServiceKey("", b0.a(GetAdRequest.class)), b.C(new AnonymousClass107(registry)));
            registry.updateService(new ServiceKey("", b0.a(GetHbTokenEventRequest.class)), b.C(AnonymousClass108.INSTANCE));
            registry.updateService(new ServiceKey("", b0.a(CommonScarEventReceiver.class)), b.C(new AnonymousClass109(registry)));
            registry.updateService(new ServiceKey("", b0.a(GMAScarAdapterBridge.class)), b.C(new AnonymousClass110(registry)));
            registry.updateService(new ServiceKey("", b0.a(ScarTimeHackFixer.class)), b.C(new AnonymousClass111(registry)));
            registry.updateService(new ServiceKey("", b0.a(ScarManager.class)), b.C(new AnonymousClass112(registry)));
            registry.updateService(new ServiceKey("", b0.a(FetchSignalsAndSendUseCase.class)), b.C(new AnonymousClass113(registry)));
            registry.updateService(new ServiceKey("", b0.a(LoadScarAd.class)), b.C(new AnonymousClass114(registry)));
            registry.updateService(new ServiceKey("", b0.a(HandleGetTokenRequest.class)), b.C(new AnonymousClass115(registry)));
            registry.updateService(new ServiceKey("", b0.a(GetClientInfo.class)), b.C(new AnonymousClass116(registry)));
            registry.updateService(new ServiceKey("", b0.a(GetInitializationCompletedRequest.class)), b.C(new AnonymousClass117(registry)));
            registry.updateService(new ServiceKey("", b0.a(GetInitializationRequest.class)), b.C(new AnonymousClass118(registry)));
            registry.updateService(new ServiceKey("", b0.a(GetLimitedSessionToken.class)), b.C(new AnonymousClass119(registry)));
            registry.updateService(new ServiceKey("", b0.a(GetOpenGLRendererInfo.class)), b.C(new AnonymousClass120(registry)));
            registry.updateService(new ServiceKey("", b0.a(GetSharedDataTimestamps.class)), b.C(AnonymousClass121.INSTANCE));
            registry.updateService(new ServiceKey("", b0.a(GetUniversalRequestForPayLoad.class)), b.C(new AnonymousClass122(registry)));
            registry.updateService(new ServiceKey("", b0.a(GetUniversalRequestSharedData.class)), b.C(new AnonymousClass123(registry)));
            registry.updateService(new ServiceKey("", b0.a(GetCachedAsset.class)), b.C(new AnonymousClass124(registry)));
            registry.updateService(new ServiceKey("", b0.a(GetWebViewBridgeUseCase.class)), b.C(new AnonymousClass125(registry)));
            registry.updateService(new ServiceKey(ServiceProvider.NAMED_INIT_REQ, b0.a(GetRequestPolicy.class)), b.C(new AnonymousClass126(registry)));
            registry.updateService(new ServiceKey("", b0.a(GetLatestWebViewConfiguration.class)), b.C(new AnonymousClass127(registry)));
            registry.updateService(new ServiceKey(ServiceProvider.NAMED_OPERATIVE_REQ, b0.a(GetRequestPolicy.class)), b.C(new AnonymousClass128(registry)));
            registry.updateService(new ServiceKey(ServiceProvider.NAMED_OTHER_REQ, b0.a(GetRequestPolicy.class)), b.C(new AnonymousClass129(registry)));
            registry.updateService(new ServiceKey("", b0.a(GetPrivacyUpdateRequest.class)), b.C(new AnonymousClass130(registry)));
            registry.updateService(new ServiceKey("", b0.a(HandleGatewayInitializationResponse.class)), b.C(new AnonymousClass131(registry)));
            registry.updateService(new ServiceKey("", b0.a(HandleGatewayUniversalResponse.class)), b.C(new AnonymousClass132(registry)));
            registry.updateService(new ServiceKey("", b0.a(InitializeBoldSDK.class)), b.C(new AnonymousClass133(registry)));
            registry.updateService(new ServiceKey("", b0.a(LegacyShowUseCase.class)), ServiceFactoryKt.factoryOf(new AnonymousClass134(registry)));
            registry.updateService(new ServiceKey("", b0.a(SendPrivacyUpdateRequest.class)), b.C(new AnonymousClass135(registry)));
            registry.updateService(new ServiceKey("", b0.a(TriggerInitializationCompletedRequest.class)), b.C(new AnonymousClass136(registry)));
            registry.updateService(new ServiceKey("", b0.a(TriggerInitializeListener.class)), b.C(new AnonymousClass137(registry)));
            registry.updateService(new ServiceKey("", b0.a(DiagnosticEventObserver.class)), b.C(new AnonymousClass138(registry)));
            registry.updateService(new ServiceKey("", b0.a(EventObservers.class)), b.C(new AnonymousClass139(registry)));
            registry.updateService(new ServiceKey("", b0.a(GetTransactionData.class)), b.C(new AnonymousClass140(registry)));
            registry.updateService(new ServiceKey("", b0.a(GetTransactionRequest.class)), b.C(new AnonymousClass141(registry)));
            registry.updateService(new ServiceKey("", b0.a(GetDiagnosticEventBatchRequest.class)), b.C(AnonymousClass142.INSTANCE));
            registry.updateService(new ServiceKey("", b0.a(GetDiagnosticEventRequest.class)), b.C(new AnonymousClass143(registry)));
            registry.updateService(new ServiceKey("", b0.a(GetOperativeEventApi.class)), b.C(new AnonymousClass144(registry)));
            registry.updateService(new ServiceKey("", b0.a(GetOperativeEventRequest.class)), b.C(new AnonymousClass145(registry)));
            registry.updateService(new ServiceKey("", b0.a(HandleGatewayEventResponse.class)), b.C(AnonymousClass146.INSTANCE));
            registry.updateService(new ServiceKey("", b0.a(OperativeEventObserver.class)), b.C(new AnonymousClass147(registry)));
            registry.updateService(new ServiceKey("", b0.a(TransactionEventObserver.class)), b.C(new AnonymousClass148(registry)));
            registry.updateService(new ServiceKey("", b0.a(UniversalRequestTtlValidator.class)), b.C(AnonymousClass149.INSTANCE));
            registry.updateService(new ServiceKey("", b0.a(UniversalRequestEventSender.class)), b.C(new AnonymousClass150(registry)));
            registry.updateService(new ServiceKey("", b0.a(OmFinishSession.class)), b.C(new AnonymousClass151(registry)));
            registry.updateService(new ServiceKey("", b0.a(OmImpressionOccurred.class)), b.C(new AnonymousClass152(registry)));
            registry.updateService(new ServiceKey("", b0.a(AndroidOmInteraction.class)), b.C(new AnonymousClass153(registry)));
            registry.updateService(new ServiceKey("", b0.a(GetOmData.class)), b.C(new AnonymousClass154(registry)));
            registry.updateService(new ServiceKey("", b0.a(IsOMActivated.class)), b.C(new AnonymousClass155(registry)));
            registry.updateService(new ServiceKey("", b0.a(InitializeOMSDK.class)), b.C(new AnonymousClass156(registry)));
            registry.updateService(new ServiceKey(ServiceProvider.DEV_CONSENT_PRIVACY_RULES, b0.a(FlattenerRulesUseCase.class)), b.C(AnonymousClass157.INSTANCE));
            registry.updateService(new ServiceKey(ServiceProvider.LEGACY_PRIVACY_RULES, b0.a(FlattenerRulesUseCase.class)), b.C(AnonymousClass158.INSTANCE));
            registry.updateService(new ServiceKey("", b0.a(BackgroundWorker.class)), b.C(new AnonymousClass159(registry)));
            registry.updateService(new ServiceKey("", b0.a(DiagnosticEventRequestWorkModifier.class)), b.C(new AnonymousClass160(registry)));
            registry.updateService(new ServiceKey("", b0.a(GatewayClient.class)), b.C(new AnonymousClass161(registry)));
            registry.updateService(new ServiceKey("sdk", b0.a(y.class)), b.C(new AnonymousClass162(registry)));
            registry.updateService(new ServiceKey("", b0.a(TokenStorage.class)), b.C(AnonymousClass163.INSTANCE));
            registry.updateService(new ServiceKey("", b0.a(VolumeChange.class)), b.C(AnonymousClass164.INSTANCE));
            registry.updateService(new ServiceKey("", b0.a(ConfigFileFromLocalStorage.class)), b.C(new AnonymousClass165(registry)));
            registry.updateService(new ServiceKey("", b0.a(InitializeSDK.class)), b.C(new AnonymousClass166(registry)));
            registry.updateService(new ServiceKey("", b0.a(InitializeStateComplete.class)), b.C(new AnonymousClass167(registry)));
            registry.updateService(new ServiceKey("", b0.a(InitializeStateConfig.class)), b.C(new AnonymousClass168(registry)));
            registry.updateService(new ServiceKey("", b0.a(InitializeStateConfigWithLoader.class)), b.C(new AnonymousClass169(registry)));
            registry.updateService(new ServiceKey("", b0.a(InitializeStateCreate.class)), b.C(new AnonymousClass170(registry)));
            registry.updateService(new ServiceKey("", b0.a(InitializeStateError.class)), b.C(new AnonymousClass171(registry)));
            registry.updateService(new ServiceKey("", b0.a(InitializeStateLoadCache.class)), b.C(new AnonymousClass172(registry)));
            registry.updateService(new ServiceKey("", b0.a(InitializeStateLoadWeb.class)), b.C(new AnonymousClass173(registry)));
            registry.updateService(new ServiceKey("", b0.a(InitializeStateReset.class)), b.C(new AnonymousClass174(registry)));
            registry.updateService(new ServiceKey("", b0.a(StoreMonitor.class)), b.C(new AnonymousClass175(registry)));
            registry.updateService(new ServiceKey("", b0.a(StoreWebViewEventSender.class)), b.C(new AnonymousClass176(registry)));
            registry.updateService(new ServiceKey("", b0.a(StoreExceptionHandler.class)), b.C(AnonymousClass177.INSTANCE));
            registry.updateService(new ServiceKey("", b0.a(StoreEventListenerFactory.class)), b.C(new AnonymousClass178(registry)));
            registry.updateService(new ServiceKey("", b0.a(ConfigurationReader.class)), b.C(AnonymousClass179.INSTANCE));
            registry.updateService(new ServiceKey("", b0.a(AndroidAttribution.class)), b.C(new AnonymousClass180(registry)));
            registry.updateService(new ServiceKey("", b0.a(AdPlayerScope.class)), ServiceFactoryKt.factoryOf(new AnonymousClass181(registry)));
            registry.updateService(new ServiceKey("", b0.a(AndroidWebViewClient.class)), ServiceFactoryKt.factoryOf(new AnonymousClass182(registry)));
            registry.updateService(new ServiceKey("", b0.a(AndroidGetWebViewContainerUseCase.class)), ServiceFactoryKt.factoryOf(new AnonymousClass183(registry)));
            registry.updateService(new ServiceKey("", b0.a(Load.class)), ServiceFactoryKt.factoryOf(new AnonymousClass184(registry)));
            registry.updateService(new ServiceKey("", b0.a(AwaitInitialization.class)), ServiceFactoryKt.factoryOf(new AnonymousClass185(registry)));
            registry.updateService(new ServiceKey("", b0.a(GetAsyncHeaderBiddingToken.class)), ServiceFactoryKt.factoryOf(new AnonymousClass186(registry)));
            registry.updateService(new ServiceKey("", b0.a(GetAdPlayer.class)), ServiceFactoryKt.factoryOf(new AnonymousClass187(registry)));
            registry.updateService(new ServiceKey("", b0.a(CacheWebViewAssets.class)), b.C(new AnonymousClass188(registry)));
            registry.updateService(new ServiceKey("", b0.a(HandleGatewayAdResponse.class)), ServiceFactoryKt.factoryOf(new AnonymousClass189(registry)));
            registry.updateService(new ServiceKey("", b0.a(HandleInvocationsFromAdViewer.class)), ServiceFactoryKt.factoryOf(AnonymousClass190.INSTANCE));
            registry.updateService(new ServiceKey("", b0.a(LegacyLoadUseCase.class)), ServiceFactoryKt.factoryOf(new AnonymousClass191(registry)));
            registry.updateService(new ServiceKey("", b0.a(SafeCallbackInvoke.class)), b.C(new AnonymousClass192(registry)));
            registry.updateService(new ServiceKey("", b0.a(InitializeStateNetworkError.class)), ServiceFactoryKt.factoryOf(new AnonymousClass193(registry)));
            registry.updateService(new ServiceKey("", b0.a(CoroutineTimer.class)), ServiceFactoryKt.factoryOf(new AnonymousClass194(registry)));
            registry.updateService(new ServiceKey("", b0.a(IEventSender.class)), b.C(AnonymousClass195.INSTANCE));
            registry.updateService(new ServiceKey("", b0.a(SetGameId.class)), b.C(new AnonymousClass196(registry)));
            registry.updateService(new ServiceKey("", b0.a(GetGameId.class)), b.C(new AnonymousClass197(registry)));
            registry.updateService(new ServiceKey("", b0.a(ValidateGameId.class)), b.C(new AnonymousClass198(registry)));
            registry.updateService(new ServiceKey("", b0.a(ShouldAllowInitialization.class)), b.C(new AnonymousClass199(registry)));
            registry.updateService(new ServiceKey("", b0.a(CheckForGameIdAndTestModeChanges.class)), b.C(new AnonymousClass200(registry)));
            registry.updateService(new ServiceKey("", b0.a(DownloadPriorityQueue.class)), b.C(AnonymousClass201.INSTANCE));
            registry.updateService(new ServiceKey("", b0.a(CleanupDirectory.class)), b.C(AnonymousClass202.INSTANCE));
            registry.updateService(new ServiceKey("", b0.a(FocusRepository.class)), b.C(new AnonymousClass203(registry)));
            registry.updateService(new ServiceKey("", b0.a(AndroidGetIsAdActivity.class)), b.C(new AnonymousClass204(registry)));
            registry.updateService(new ServiceKey("", b0.a(AndroidGetLifecycleFlow.class)), b.C(new AnonymousClass205(registry)));
            registry.updateService(new ServiceKey("", b0.a(AndroidHandleFocusCounters.class)), b.C(new AnonymousClass206(registry)));
            registry.updateService(new ServiceKey("", b0.a(OfferwallAdapterBridge.class)), b.C(new AnonymousClass207(registry)));
            registry.updateService(new ServiceKey("", b0.a(OfferwallManager.class)), b.C(new AnonymousClass208(registry)));
            registry.updateService(new ServiceKey("", b0.a(LoadOfferwallAd.class)), b.C(new AnonymousClass209(registry)));
            registry.updateService(new ServiceKey("", b0.a(GetIsOfferwallAdReady.class)), b.C(new AnonymousClass210(registry)));
            registry.updateService(new ServiceKey("", b0.a(FIdDataSource.class)), b.C(new AnonymousClass211(registry)));
            registry.updateService(new ServiceKey("", b0.a(FIdExistenceDataSource.class)), b.C(AnonymousClass212.INSTANCE));
            registry.updateService(new ServiceKey("", b0.a(CleanUpWhenOpportunityExpires.class)), b.C(new AnonymousClass213(registry)));
            registry.updateService(new ServiceKey("", b0.a(OrientationRepository.class)), b.C(new AnonymousClass214(registry)));
            registry.updateService(new ServiceKey("", b0.a(AndroidAppSetIdDataSource.class)), b.C(new AnonymousClass215(registry)));
            registry.updateService(new ServiceKey("", b0.a(AndroidUnityInfoDataSource.class)), b.C(new AnonymousClass216(registry)));
            registry.updateService(new ServiceKey("", b0.a(HandleDebugSettings.class)), b.C(AnonymousClass217.INSTANCE));
            registry.updateService(new ServiceKey("", b0.a(Logger.class)), b.C(AnonymousClass218.INSTANCE));
            registry.updateService(new ServiceKey("", b0.a(IsBillingClientAvailable.class)), b.C(AnonymousClass219.INSTANCE));
            registry.updateService(new ServiceKey("", b0.a(UnityBootConfigDataSource.class)), b.C(new AnonymousClass220(registry)));
        }
    }

    static {
        ServiceProvider serviceProvider = new ServiceProvider();
        INSTANCE = serviceProvider;
        serviceRegistry = serviceProvider.initialize();
    }

    private ServiceProvider() {
    }

    @Override // com.unity3d.services.core.di.IServiceProvider
    public IServicesRegistry getRegistry() {
        return serviceRegistry;
    }

    @Override // com.unity3d.services.core.di.IServiceProvider
    public IServicesRegistry initialize() {
        return ServicesRegistryKt.registry(AnonymousClass1.INSTANCE);
    }
}
