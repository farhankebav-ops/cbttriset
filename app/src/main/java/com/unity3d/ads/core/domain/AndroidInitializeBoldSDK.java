package com.unity3d.ads.core.domain;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.core.data.manager.SDKPropertiesManager;
import com.unity3d.ads.core.data.manager.StorageManager;
import com.unity3d.ads.core.data.model.InitializationState;
import com.unity3d.ads.core.data.model.OperationType;
import com.unity3d.ads.core.data.model.exception.GatewayException;
import com.unity3d.ads.core.data.model.exception.InitializationException;
import com.unity3d.ads.core.data.repository.DiagnosticEventRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.domain.events.EventObservers;
import com.unity3d.ads.core.domain.om.InitializeOMSDK;
import com.unity3d.ads.core.extensions.TimeExtensionsKt;
import com.unity3d.ads.gatewayclient.GatewayClient;
import com.unity3d.services.UnityAdsConstants;
import com.unity3d.services.core.configuration.ConfigurationReader;
import com.unity3d.services.core.log.DeviceLog;
import com.vungle.ads.internal.protos.Sdk;
import e6.p;
import gatewayprotocol.v1.InitializationResponseOuterClass;
import gatewayprotocol.v1.NativeConfigurationOuterClass;
import gatewayprotocol.v1.UniversalResponseOuterClass;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import n6.t;
import o6.d;
import q5.x;
import q6.a0;
import q6.c0;
import q6.w;
import r2.q;
import x5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidInitializeBoldSDK implements InitializeBoldSDK {
    public static final Companion Companion = new Companion(null);
    public static final String MSG_GATEWAY_DENIED = "Gateway communication failure";
    public static final String MSG_NETWORK = "Network";
    public static final String MSG_TIMEOUT = "Timeout";
    public static final String MSG_UNKNOWN = "Initialization failure";
    private final CleanAssets cleanAssets;
    private final w defaultDispatcher;
    private final DiagnosticEventRepository diagnosticEventRepository;
    private final EventObservers eventObservers;
    private final GatewayClient gatewayClient;
    private final GetGameId getGameId;
    private final GetInitializationRequest getInitializeRequest;
    private final GetRequestPolicy getRequestPolicy;
    private final AndroidHandleFocusCounters handleFocusCounters;
    private final HandleGatewayInitializationResponse handleGatewayInitializationResponse;
    private final InitializeOMSDK initializeOM;
    private final ConfigurationReader legacyConfigurationReader;
    private final SDKPropertiesManager sdkPropertiesManager;
    private final SendDiagnosticEvent sendDiagnosticEvent;
    private final SessionRepository sessionRepository;
    private final StorageManager storageManager;
    private final TriggerInitializeListener triggerInitializeListener;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidInitializeBoldSDK$initializationSuccess$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.domain.AndroidInitializeBoldSDK", f = "AndroidInitializeBoldSDK.kt", l = {Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE, 126, Sdk.SDKError.Reason.EMPTY_TPAT_ERROR_VALUE}, m = "initializationSuccess")
    public static final class AnonymousClass1 extends c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidInitializeBoldSDK.this.initializationSuccess(null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidInitializeBoldSDK$invoke$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.domain.AndroidInitializeBoldSDK$invoke$2", f = "AndroidInitializeBoldSDK.kt", l = {ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT, 83}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ String $source;
        int I$0;
        long J$0;
        int label;

        /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidInitializeBoldSDK$invoke$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @e(c = "com.unity3d.ads.core.domain.AndroidInitializeBoldSDK$invoke$2$1", f = "AndroidInitializeBoldSDK.kt", l = {ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL, 69, 71, 72}, m = "invokeSuspend")
        public static final class AnonymousClass1 extends i implements p {
            final /* synthetic */ boolean $isRetry;
            final /* synthetic */ String $source;
            int label;
            final /* synthetic */ AndroidInitializeBoldSDK this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(AndroidInitializeBoldSDK androidInitializeBoldSDK, String str, boolean z2, v5.c<? super AnonymousClass1> cVar) {
                super(2, cVar);
                this.this$0 = androidInitializeBoldSDK;
                this.$source = str;
                this.$isRetry = z2;
            }

            @Override // x5.a
            public final v5.c<x> create(Object obj, v5.c<?> cVar) {
                return new AnonymousClass1(this.this$0, this.$source, this.$isRetry, cVar);
            }

            /* JADX WARN: Code restructure failed: missing block: B:24:0x0080, code lost:
            
                if (r1.handleResponse((gatewayprotocol.v1.UniversalResponseOuterClass.UniversalResponse) r13, r12) != r0) goto L26;
             */
            /* JADX WARN: Removed duplicated region for block: B:23:0x0076 A[PHI: r9 r13
  0x0076: PHI (r9v2 com.unity3d.ads.core.domain.AndroidInitializeBoldSDK$invoke$2$1) = 
  (r9v1 com.unity3d.ads.core.domain.AndroidInitializeBoldSDK$invoke$2$1)
  (r9v3 com.unity3d.ads.core.domain.AndroidInitializeBoldSDK$invoke$2$1)
 binds: [B:21:0x0073, B:11:0x0020] A[DONT_GENERATE, DONT_INLINE]
  0x0076: PHI (r13v12 java.lang.Object) = (r13v11 java.lang.Object), (r13v0 java.lang.Object) binds: [B:21:0x0073, B:11:0x0020] A[DONT_GENERATE, DONT_INLINE]] */
            @Override // x5.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
                /*
                    r12 = this;
                    w5.a r0 = w5.a.f17774a
                    int r1 = r12.label
                    r2 = 4
                    r3 = 3
                    r4 = 2
                    r5 = 1
                    if (r1 == 0) goto L2d
                    if (r1 == r5) goto L29
                    if (r1 == r4) goto L25
                    if (r1 == r3) goto L20
                    if (r1 != r2) goto L18
                    r2.q.z0(r13)
                    r9 = r12
                    goto L83
                L18:
                    java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r13.<init>(r0)
                    throw r13
                L20:
                    r2.q.z0(r13)
                    r9 = r12
                    goto L76
                L25:
                    r2.q.z0(r13)
                    goto L54
                L29:
                    r2.q.z0(r13)
                    goto L40
                L2d:
                    r2.q.z0(r13)
                    com.unity3d.ads.core.domain.AndroidInitializeBoldSDK r13 = r12.this$0
                    java.lang.String r1 = r12.$source
                    boolean r6 = r12.$isRetry
                    r12.label = r5
                    java.lang.Object r13 = com.unity3d.ads.core.domain.AndroidInitializeBoldSDK.access$initializationStart(r13, r1, r6, r12)
                    if (r13 != r0) goto L40
                L3e:
                    r9 = r12
                    goto L82
                L40:
                    com.unity3d.ads.core.domain.AndroidInitializeBoldSDK r13 = r12.this$0
                    com.unity3d.ads.core.domain.AndroidInitializeBoldSDK.access$checkCanInitialize(r13)
                    com.unity3d.ads.core.domain.AndroidInitializeBoldSDK r13 = r12.this$0
                    com.unity3d.ads.core.domain.GetInitializationRequest r13 = com.unity3d.ads.core.domain.AndroidInitializeBoldSDK.access$getGetInitializeRequest$p(r13)
                    r12.label = r4
                    java.lang.Object r13 = r13.invoke(r12)
                    if (r13 != r0) goto L54
                    goto L3e
                L54:
                    r6 = r13
                    gatewayprotocol.v1.UniversalRequestOuterClass$UniversalRequest r6 = (gatewayprotocol.v1.UniversalRequestOuterClass.UniversalRequest) r6
                    com.unity3d.ads.core.domain.AndroidInitializeBoldSDK r13 = r12.this$0
                    com.unity3d.ads.core.domain.GetRequestPolicy r13 = com.unity3d.ads.core.domain.AndroidInitializeBoldSDK.access$getGetRequestPolicy$p(r13)
                    com.unity3d.ads.gatewayclient.RequestPolicy r7 = r13.invoke()
                    com.unity3d.ads.core.domain.AndroidInitializeBoldSDK r13 = r12.this$0
                    com.unity3d.ads.gatewayclient.GatewayClient r4 = com.unity3d.ads.core.domain.AndroidInitializeBoldSDK.access$getGatewayClient$p(r13)
                    com.unity3d.ads.core.data.model.OperationType r8 = com.unity3d.ads.core.data.model.OperationType.INITIALIZATION
                    r12.label = r3
                    r5 = 0
                    r10 = 1
                    r11 = 0
                    r9 = r12
                    java.lang.Object r13 = com.unity3d.ads.gatewayclient.GatewayClient.DefaultImpls.request$default(r4, r5, r6, r7, r8, r9, r10, r11)
                    if (r13 != r0) goto L76
                    goto L82
                L76:
                    gatewayprotocol.v1.UniversalResponseOuterClass$UniversalResponse r13 = (gatewayprotocol.v1.UniversalResponseOuterClass.UniversalResponse) r13
                    com.unity3d.ads.core.domain.AndroidInitializeBoldSDK r1 = r9.this$0
                    r9.label = r2
                    java.lang.Object r13 = com.unity3d.ads.core.domain.AndroidInitializeBoldSDK.access$handleResponse(r1, r13, r12)
                    if (r13 != r0) goto L83
                L82:
                    return r0
                L83:
                    q5.x r13 = q5.x.f13520a
                    return r13
                */
                throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.AndroidInitializeBoldSDK.AnonymousClass2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // e6.p
            public final Object invoke(a0 a0Var, v5.c<? super x> cVar) {
                return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, v5.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$source = str;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return AndroidInitializeBoldSDK.this.new AnonymousClass2(this.$source, cVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.String, long] */
        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            long jB;
            ?? r62;
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            x xVar = x.f13520a;
            try {
                if (i2 == 0) {
                    q.z0(obj);
                    jB = d.b();
                    ?? r1 = !AndroidInitializeBoldSDK.this.sessionRepository.isFirstInitAttempt();
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(AndroidInitializeBoldSDK.this, this.$source, r1, null);
                    this.J$0 = jB;
                    this.I$0 = r1;
                    this.label = 1;
                    i2 = r1;
                    if (c0.I(UnityAdsConstants.Timeout.INIT_TIMEOUT_MS, anonymousClass1, this) != aVar) {
                    }
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    q.z0(obj);
                    return xVar;
                }
                int i8 = this.I$0;
                jB = this.J$0;
                q.z0(obj);
                i2 = i8;
                AndroidInitializeBoldSDK androidInitializeBoldSDK = AndroidInitializeBoldSDK.this;
                o6.f fVar = new o6.f(jB);
                r62 = this.$source;
                boolean z2 = i2 != 0;
                this.label = 2;
                return androidInitializeBoldSDK.initializationSuccess(fVar, r62, z2, this) == aVar ? aVar : xVar;
            } catch (Exception e) {
                InitializationException from = InitializationException.Companion.parseFrom(e);
                if (e instanceof GatewayException) {
                    AndroidInitializeBoldSDK.this.sessionRepository.setShouldInitialize(false);
                }
                AndroidInitializeBoldSDK.this.initializationFailure(new o6.f(r62), from, this.$source, i2 != 0);
                return xVar;
            }
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, v5.c<? super x> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public AndroidInitializeBoldSDK(w defaultDispatcher, InitializeOMSDK initializeOM, GetInitializationRequest getInitializeRequest, GetRequestPolicy getRequestPolicy, CleanAssets cleanAssets, HandleGatewayInitializationResponse handleGatewayInitializationResponse, GatewayClient gatewayClient, SessionRepository sessionRepository, EventObservers eventObservers, TriggerInitializeListener triggerInitializeListener, SendDiagnosticEvent sendDiagnosticEvent, DiagnosticEventRepository diagnosticEventRepository, StorageManager storageManager, ConfigurationReader legacyConfigurationReader, SDKPropertiesManager sdkPropertiesManager, GetGameId getGameId, AndroidHandleFocusCounters handleFocusCounters) {
        k.e(defaultDispatcher, "defaultDispatcher");
        k.e(initializeOM, "initializeOM");
        k.e(getInitializeRequest, "getInitializeRequest");
        k.e(getRequestPolicy, "getRequestPolicy");
        k.e(cleanAssets, "cleanAssets");
        k.e(handleGatewayInitializationResponse, "handleGatewayInitializationResponse");
        k.e(gatewayClient, "gatewayClient");
        k.e(sessionRepository, "sessionRepository");
        k.e(eventObservers, "eventObservers");
        k.e(triggerInitializeListener, "triggerInitializeListener");
        k.e(sendDiagnosticEvent, "sendDiagnosticEvent");
        k.e(diagnosticEventRepository, "diagnosticEventRepository");
        k.e(storageManager, "storageManager");
        k.e(legacyConfigurationReader, "legacyConfigurationReader");
        k.e(sdkPropertiesManager, "sdkPropertiesManager");
        k.e(getGameId, "getGameId");
        k.e(handleFocusCounters, "handleFocusCounters");
        this.defaultDispatcher = defaultDispatcher;
        this.initializeOM = initializeOM;
        this.getInitializeRequest = getInitializeRequest;
        this.getRequestPolicy = getRequestPolicy;
        this.cleanAssets = cleanAssets;
        this.handleGatewayInitializationResponse = handleGatewayInitializationResponse;
        this.gatewayClient = gatewayClient;
        this.sessionRepository = sessionRepository;
        this.eventObservers = eventObservers;
        this.triggerInitializeListener = triggerInitializeListener;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
        this.diagnosticEventRepository = diagnosticEventRepository;
        this.storageManager = storageManager;
        this.legacyConfigurationReader = legacyConfigurationReader;
        this.sdkPropertiesManager = sdkPropertiesManager;
        this.getGameId = getGameId;
        this.handleFocusCounters = handleFocusCounters;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkCanInitialize() throws InitializationException {
        if (!this.sessionRepository.getShouldInitialize()) {
            throw new InitializationException(MSG_GATEWAY_DENIED, null, "gateway", "!sessionRepository.shouldInitialize", 2, null);
        }
        String strInvoke = this.getGameId.invoke();
        if ((strInvoke != null ? t.o0(strInvoke) : null) != null) {
        } else {
            throw new InitializationException(a1.a.m("gameId \"", strInvoke, "\" should be a number."), null, "invalid_game_id", strInvoke, 2, null);
        }
    }

    private final Map<String, String> getTags(InitializationException initializationException, String str, boolean z2) {
        s5.f fVar = new s5.f();
        fVar.put("operation", OperationType.INITIALIZATION.toString());
        fVar.put("reason", initializationException.getReason());
        fVar.put("source", str);
        fVar.put("is_retry", String.valueOf(z2));
        if (initializationException.getReasonDebug() != null) {
            fVar.put("reason_debug", initializationException.getReasonDebug());
        }
        return fVar.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleResponse(UniversalResponseOuterClass.UniversalResponse universalResponse, v5.c<? super x> cVar) throws InitializationException {
        if (universalResponse.hasError()) {
            this.sessionRepository.setShouldInitialize(false);
            throw new InitializationException(MSG_GATEWAY_DENIED, null, "gateway", universalResponse.getError().getErrorText(), 2, null);
        }
        if (!universalResponse.hasPayload()) {
            throw new InitializationException(MSG_GATEWAY_DENIED, null, "gateway", "No payload", 2, null);
        }
        if (!universalResponse.getPayload().hasInitializationResponse()) {
            throw new InitializationException(MSG_GATEWAY_DENIED, null, "gateway", "No initialization response", 2, null);
        }
        HandleGatewayInitializationResponse handleGatewayInitializationResponse = this.handleGatewayInitializationResponse;
        InitializationResponseOuterClass.InitializationResponse initializationResponse = universalResponse.getPayload().getInitializationResponse();
        k.d(initializationResponse, "response.payload.initializationResponse");
        Object objInvoke = handleGatewayInitializationResponse.invoke(initializationResponse, cVar);
        return objInvoke == w5.a.f17774a ? objInvoke : x.f13520a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initializationFailure(o6.e eVar, InitializationException initializationException, String str, boolean z2) {
        DeviceLog.debug("Unity Ads Initialization Failure: " + initializationException.getMessage());
        SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_initialize_task_failure_time", Double.valueOf(TimeExtensionsKt.elapsedMillis(eVar)), getTags(initializationException, str, z2), null, null, null, 56, null);
        this.sessionRepository.setInitializationState(InitializationState.FAILED);
        this.sdkPropertiesManager.setInitialized(false);
        this.triggerInitializeListener.error(UnityAds.UnityAdsInitializationError.INTERNAL_ERROR, initializationException.getMessage());
        setupDiagnosticEvents();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object initializationStart(String str, boolean z2, v5.c<? super x> cVar) throws Throwable {
        DeviceLog.debug("Unity Ads Initialization Start");
        this.sdkPropertiesManager.setInitializationTime();
        this.sdkPropertiesManager.setInitializationTimeSinceEpoch();
        SendDiagnosticEvent sendDiagnosticEvent = this.sendDiagnosticEvent;
        q5.i iVar = new q5.i("source", str);
        q5.i iVar2 = new q5.i("is_retry", String.valueOf(z2));
        q5.e.f13492b.getClass();
        SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent, "native_initialization_started", null, r5.x.f0(iVar, iVar2, new q5.i("kotlin_version", "2.2.0")), null, null, null, 58, null);
        this.sessionRepository.setInitializationState(InitializationState.INITIALIZING);
        Object objInvoke = this.eventObservers.invoke(cVar);
        return objInvoke == w5.a.f17774a ? objInvoke : x.f13520a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object initializationSuccess(o6.e r18, java.lang.String r19, boolean r20, v5.c<? super q5.x> r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.AndroidInitializeBoldSDK.initializationSuccess(o6.e, java.lang.String, boolean, v5.c):java.lang.Object");
    }

    private final void setupDiagnosticEvents() {
        NativeConfigurationOuterClass.DiagnosticEventsConfiguration config = this.sessionRepository.getNativeConfiguration().getDiagnosticEvents();
        DiagnosticEventRepository diagnosticEventRepository = this.diagnosticEventRepository;
        k.d(config, "config");
        diagnosticEventRepository.configure(config);
    }

    @Override // com.unity3d.ads.core.domain.InitializeBoldSDK
    public Object invoke(String str, v5.c<? super x> cVar) throws Throwable {
        Object objH = c0.H(new AnonymousClass2(str, null), this.defaultDispatcher, cVar);
        return objH == w5.a.f17774a ? objH : x.f13520a;
    }
}
