package com.unity3d.ads.core.domain;

import com.google.protobuf.ByteString;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.ads.adplayer.model.ShowStatus;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.model.Listeners;
import com.unity3d.ads.core.data.model.OperationType;
import com.unity3d.ads.core.data.model.ShowEvent;
import com.unity3d.ads.core.data.repository.AdRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.domain.events.GetOperativeEventApi;
import com.unity3d.ads.core.extensions.ExceptionExtensionsKt;
import com.unity3d.ads.core.extensions.ProtobufExtensionsKt;
import com.unity3d.ads.core.extensions.ShowStatusExtensionsKt;
import com.unity3d.ads.core.extensions.TimeExtensionsKt;
import com.unity3d.services.UnityAdsConstants;
import com.unity3d.services.core.log.DeviceLog;
import com.vungle.ads.internal.protos.Sdk;
import e6.p;
import e6.q;
import e6.t;
import gatewayprotocol.v1.DiagnosticEventRequestOuterClass;
import gatewayprotocol.v1.NativeConfigurationOuterClass;
import gatewayprotocol.v1.OperativeEventErrorDataKt;
import gatewayprotocol.v1.OperativeEventRequestOuterClass;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import org.json.JSONObject;
import q5.x;
import t6.d1;
import t6.q0;
import t6.x0;
import x5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class LegacyShowUseCase {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_OBJECT_ID = "objectId";
    public static final String MESSAGE_AD_OBJECT_EXPIRED = "The ad has expired";
    public static final String MESSAGE_AD_PLAYER_UNAVAILABLE = "Ad player is unavailable.";
    public static final String MESSAGE_ALREADY_SHOWING = "Can't show a new ad unit when ad unit is already open";
    public static final String MESSAGE_NO_AD_OBJECT = "No ad object found for opportunity id: ";
    public static final String MESSAGE_OPPORTUNITY_ID = "No valid opportunity id provided";
    public static final String MESSAGE_OPT_TIMEOUT = "timeout";
    public static final String MESSAGE_PLACEMENT_NOT_LOADED = "Placement %s must be Loaded before calling Show";
    public static final String MESSAGE_TIMEOUT = "[UnityAds] Timeout while trying to show ";
    public static final String MSG_OPPORTUNITY_AND_PLACEMENT_NOT_MATCHING = "[UnityAds] Object ID and Placement ID provided does not match previously loaded ad";
    private static volatile boolean isFullscreenAdShowing;
    private AdObject adObject;
    private final AdRepository adRepository;
    private final GetInitializationState getInitializationState;
    private final GetOperativeEventApi getOperativeEventApi;
    private final q0 hasStarted;
    private String placement;
    private final SafeCallbackInvoke safeCallbackInvoke;
    private final SendDiagnosticEvent sendDiagnosticEvent;
    private final SessionRepository sessionRepository;
    private final Show show;
    private final q0 timeoutCancellationRequested;
    private UnityAdsShowOptions unityAdsShowOptions;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.domain.LegacyShowUseCase", f = "LegacyShowUseCase.kt", l = {Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE, 128, Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE, 141, 146, 152, 159, 164, 195}, m = "invoke")
    public static final class AnonymousClass1 extends c {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LegacyShowUseCase.this.invoke(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$2", f = "LegacyShowUseCase.kt", l = {178, 184, 185}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ AdObject $adObject;
        final /* synthetic */ boolean $isBanner;
        final /* synthetic */ String $placement;
        final /* synthetic */ t $reportShowError;
        final /* synthetic */ boolean $useTimeout;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(boolean z2, AdObject adObject, boolean z7, t tVar, String str, v5.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$isBanner = z2;
            this.$adObject = adObject;
            this.$useTimeout = z7;
            this.$reportShowError = tVar;
            this.$placement = str;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            AnonymousClass2 anonymousClass2 = LegacyShowUseCase.this.new AnonymousClass2(this.$isBanner, this.$adObject, this.$useTimeout, this.$reportShowError, this.$placement, cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // e6.p
        public final Object invoke(e6.a aVar, v5.c<? super x> cVar) {
            return ((AnonymousClass2) create(aVar, cVar)).invokeSuspend(x.f13520a);
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x00b5  */
        @Override // x5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
            /*
                r11 = this;
                w5.a r0 = w5.a.f17774a
                int r1 = r11.label
                q5.x r2 = q5.x.f13520a
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L32
                if (r1 == r5) goto L2a
                if (r1 == r4) goto L22
                if (r1 != r3) goto L1a
                java.lang.Object r0 = r11.L$0
                e6.a r0 = (e6.a) r0
                r2.q.z0(r12)
                goto Lb6
            L1a:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L22:
                java.lang.Object r1 = r11.L$0
                e6.a r1 = (e6.a) r1
                r2.q.z0(r12)
                goto L91
            L2a:
                java.lang.Object r1 = r11.L$0
                e6.a r1 = (e6.a) r1
                r2.q.z0(r12)
                goto L7a
            L32:
                r2.q.z0(r12)
                java.lang.Object r12 = r11.L$0
                r1 = r12
                e6.a r1 = (e6.a) r1
                com.unity3d.ads.core.domain.LegacyShowUseCase r12 = com.unity3d.ads.core.domain.LegacyShowUseCase.this
                t6.q0 r12 = com.unity3d.ads.core.domain.LegacyShowUseCase.access$getHasStarted$p(r12)
                t6.d1 r12 = (t6.d1) r12
                java.lang.Object r12 = r12.getValue()
                java.lang.Boolean r12 = (java.lang.Boolean) r12
                boolean r12 = r12.booleanValue()
                if (r12 != 0) goto Lb9
                com.unity3d.ads.core.domain.LegacyShowUseCase r12 = com.unity3d.ads.core.domain.LegacyShowUseCase.this
                t6.q0 r12 = com.unity3d.ads.core.domain.LegacyShowUseCase.access$getTimeoutCancellationRequested$p(r12)
                t6.d1 r12 = (t6.d1) r12
                java.lang.Object r12 = r12.getValue()
                java.lang.Boolean r12 = (java.lang.Boolean) r12
                boolean r12 = r12.booleanValue()
                if (r12 != 0) goto Lb9
                boolean r12 = r11.$isBanner
                if (r12 == 0) goto L67
                goto Lb9
            L67:
                com.unity3d.ads.core.domain.LegacyShowUseCase r12 = com.unity3d.ads.core.domain.LegacyShowUseCase.this
                gatewayprotocol.v1.OperativeEventRequestOuterClass$OperativeEventErrorType r6 = gatewayprotocol.v1.OperativeEventRequestOuterClass.OperativeEventErrorType.OPERATIVE_EVENT_ERROR_TYPE_TIMEOUT
                com.unity3d.ads.core.data.model.AdObject r7 = r11.$adObject
                r11.L$0 = r1
                r11.label = r5
                java.lang.String r5 = "timeout"
                java.lang.Object r12 = com.unity3d.ads.core.domain.LegacyShowUseCase.access$sendOperativeError(r12, r6, r5, r7, r11)
                if (r12 != r0) goto L7a
                goto Lb4
            L7a:
                boolean r12 = r11.$useTimeout
                if (r12 == 0) goto Lb9
                com.unity3d.ads.core.domain.LegacyShowUseCase r12 = com.unity3d.ads.core.domain.LegacyShowUseCase.this
                com.unity3d.ads.core.domain.Show r12 = com.unity3d.ads.core.domain.LegacyShowUseCase.access$getShow$p(r12)
                com.unity3d.ads.core.data.model.AdObject r5 = r11.$adObject
                r11.L$0 = r1
                r11.label = r4
                java.lang.Object r12 = r12.terminate(r5, r11)
                if (r12 != r0) goto L91
                goto Lb4
            L91:
                e6.t r4 = r11.$reportShowError
                com.unity3d.ads.UnityAds$UnityAdsShowError r6 = com.unity3d.ads.UnityAds.UnityAdsShowError.TIMEOUT
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                java.lang.String r5 = "[UnityAds] Timeout while trying to show "
                r12.<init>(r5)
                java.lang.String r5 = r11.$placement
                r12.append(r5)
                java.lang.String r7 = r12.toString()
                r11.L$0 = r1
                r11.label = r3
                java.lang.String r5 = "timeout"
                r8 = 0
                r9 = 0
                r10 = r11
                java.lang.Object r12 = r4.invoke(r5, r6, r7, r8, r9, r10)
                if (r12 != r0) goto Lb5
            Lb4:
                return r0
            Lb5:
                r0 = r1
            Lb6:
                r0.invoke()
            Lb9:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.LegacyShowUseCase.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$3", f = "LegacyShowUseCase.kt", l = {190}, m = "invokeSuspend")
    public static final class AnonymousClass3 extends i implements q {
        final /* synthetic */ boolean $isBanner;
        final /* synthetic */ t $reportShowError;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(t tVar, boolean z2, v5.c<? super AnonymousClass3> cVar) {
            super(3, cVar);
            this.$reportShowError = tVar;
            this.$isBanner = z2;
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            AnonymousClass3 anonymousClass3;
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                r2.q.z0(obj);
                Throwable th = (Throwable) this.L$0;
                t tVar = this.$reportShowError;
                UnityAds.UnityAdsShowError unityAdsShowError = UnityAds.UnityAdsShowError.INTERNAL_ERROR;
                String shortenedStackTrace$default = ExceptionExtensionsKt.getShortenedStackTrace$default(th, 0, 1, null);
                this.label = 1;
                anonymousClass3 = this;
                if (tVar.invoke("uncaught_exception", unityAdsShowError, UnityAdsConstants.Messages.MSG_INTERNAL_ERROR, null, shortenedStackTrace$default, anonymousClass3) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r2.q.z0(obj);
                anonymousClass3 = this;
            }
            if (!anonymousClass3.$isBanner) {
                LegacyShowUseCase.isFullscreenAdShowing = false;
            }
            return x.f13520a;
        }

        @Override // e6.q
        public final Object invoke(t6.f fVar, Throwable th, v5.c<? super x> cVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$reportShowError, this.$isBanner, cVar);
            anonymousClass3.L$0 = th;
            return anonymousClass3.invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.LegacyShowUseCase$showClicked$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C29071 extends l implements e6.a {
        final /* synthetic */ Listeners $listeners;
        final /* synthetic */ String $placement;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C29071(Listeners listeners, String str) {
            super(0);
            this.$listeners = listeners;
            this.$placement = str;
        }

        @Override // e6.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m3213invoke();
            return x.f13520a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m3213invoke() {
            this.$listeners.onClick(this.$placement);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.LegacyShowUseCase$showCompleted$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C29081 extends l implements e6.a {
        final /* synthetic */ Listeners $listeners;
        final /* synthetic */ String $placement;
        final /* synthetic */ ShowStatus $status;
        final /* synthetic */ LegacyShowUseCase this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C29081(Listeners listeners, String str, ShowStatus showStatus, LegacyShowUseCase legacyShowUseCase) {
            super(0);
            this.$listeners = listeners;
            this.$placement = str;
            this.$status = showStatus;
            this.this$0 = legacyShowUseCase;
        }

        @Override // e6.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m3214invoke();
            return x.f13520a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m3214invoke() {
            Listeners listeners = this.$listeners;
            String str = this.$placement;
            ShowStatus showStatus = this.$status;
            NativeConfigurationOuterClass.ShowCompletionState defaultShowCompletionState = this.this$0.sessionRepository.getNativeConfiguration().getDefaultShowCompletionState();
            k.d(defaultShowCompletionState, "sessionRepository.native…efaultShowCompletionState");
            listeners.onComplete(str, ShowStatusExtensionsKt.toUnityAdsShowCompletionState(showStatus, defaultShowCompletionState));
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.LegacyShowUseCase$showError$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.domain.LegacyShowUseCase$showError$1", f = "LegacyShowUseCase.kt", l = {}, m = "invokeSuspend")
    public static final class C29091 extends i implements t {
        final /* synthetic */ Listeners $listeners;
        final /* synthetic */ String $opportunityId;
        final /* synthetic */ String $placement;
        final /* synthetic */ o6.e $startTime;
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        /* synthetic */ Object L$3;
        /* synthetic */ Object L$4;
        int label;
        final /* synthetic */ LegacyShowUseCase this$0;

        /* JADX INFO: renamed from: com.unity3d.ads.core.domain.LegacyShowUseCase$showError$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class C02131 extends l implements e6.a {
            final /* synthetic */ Listeners $listeners;
            final /* synthetic */ String $message;
            final /* synthetic */ String $placement;
            final /* synthetic */ UnityAds.UnityAdsShowError $reason;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02131(Listeners listeners, String str, UnityAds.UnityAdsShowError unityAdsShowError, String str2) {
                super(0);
                this.$listeners = listeners;
                this.$placement = str;
                this.$reason = unityAdsShowError;
                this.$message = str2;
            }

            @Override // e6.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m3215invoke();
                return x.f13520a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m3215invoke() {
                this.$listeners.onError(this.$placement, this.$reason, this.$message);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C29091(String str, LegacyShowUseCase legacyShowUseCase, String str2, o6.e eVar, Listeners listeners, v5.c<? super C29091> cVar) {
            super(6, cVar);
            this.$placement = str;
            this.this$0 = legacyShowUseCase;
            this.$opportunityId = str2;
            this.$startTime = eVar;
            this.$listeners = listeners;
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r2.q.z0(obj);
            String str = (String) this.L$0;
            UnityAds.UnityAdsShowError unityAdsShowError = (UnityAds.UnityAdsShowError) this.L$1;
            String str2 = (String) this.L$2;
            Integer num = (Integer) this.L$3;
            String str3 = (String) this.L$4;
            DeviceLog.debug("Unity Ads Show Failed for placement " + this.$placement);
            AdObject tmpAdObject = this.this$0.adObject;
            if (tmpAdObject == null) {
                tmpAdObject = this.this$0.getTmpAdObject(this.$opportunityId);
            }
            SendDiagnosticEvent.DefaultImpls.invoke$default(this.this$0.sendDiagnosticEvent, "native_show_failure_time", new Double(TimeExtensionsKt.elapsedMillis(this.$startTime)), this.this$0.getTags(str, num, str3), null, tmpAdObject, null, 40, null);
            this.this$0.safeCallbackInvoke.invoke(new C02131(this.$listeners, this.$placement, unityAdsShowError, str2));
            return x.f13520a;
        }

        @Override // e6.t
        public final Object invoke(String str, UnityAds.UnityAdsShowError unityAdsShowError, String str2, Integer num, String str3, v5.c<? super x> cVar) {
            C29091 c29091 = new C29091(this.$placement, this.this$0, this.$opportunityId, this.$startTime, this.$listeners, cVar);
            c29091.L$0 = str;
            c29091.L$1 = unityAdsShowError;
            c29091.L$2 = str2;
            c29091.L$3 = num;
            c29091.L$4 = str3;
            return c29091.invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.LegacyShowUseCase$showStarted$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C29101 extends l implements e6.a {
        final /* synthetic */ Listeners $listeners;
        final /* synthetic */ String $placement;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C29101(Listeners listeners, String str) {
            super(0);
            this.$listeners = listeners;
            this.$placement = str;
        }

        @Override // e6.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m3216invoke();
            return x.f13520a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m3216invoke() {
            this.$listeners.onStart(this.$placement);
        }
    }

    public LegacyShowUseCase(Show show, AdRepository adRepository, SendDiagnosticEvent sendDiagnosticEvent, GetOperativeEventApi getOperativeEventApi, GetInitializationState getInitializationState, SessionRepository sessionRepository, SafeCallbackInvoke safeCallbackInvoke) {
        k.e(show, "show");
        k.e(adRepository, "adRepository");
        k.e(sendDiagnosticEvent, "sendDiagnosticEvent");
        k.e(getOperativeEventApi, "getOperativeEventApi");
        k.e(getInitializationState, "getInitializationState");
        k.e(sessionRepository, "sessionRepository");
        k.e(safeCallbackInvoke, "safeCallbackInvoke");
        this.show = show;
        this.adRepository = adRepository;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
        this.getOperativeEventApi = getOperativeEventApi;
        this.getInitializationState = getInitializationState;
        this.sessionRepository = sessionRepository;
        this.safeCallbackInvoke = safeCallbackInvoke;
        Boolean bool = Boolean.FALSE;
        this.hasStarted = x0.c(bool);
        this.timeoutCancellationRequested = x0.c(bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bannerLeftApplication(o6.e eVar, String str, Listeners listeners) {
        DeviceLog.debug("Unity Ads Show Left Application for placement " + str);
        SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_show_left_app", Double.valueOf(TimeExtensionsKt.elapsedMillis(eVar)), null, null, this.adObject, null, 44, null);
        listeners.onLeftApplication(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelTimeout(o6.e eVar) {
        q0 q0Var = this.timeoutCancellationRequested;
        Boolean bool = Boolean.TRUE;
        d1 d1Var = (d1) q0Var;
        d1Var.getClass();
        d1Var.i(null, bool);
        SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_show_cancel_timeout", Double.valueOf(TimeExtensionsKt.elapsedMillis(eVar)), null, null, this.adObject, null, 44, null);
    }

    private final String getOpportunityId(UnityAdsShowOptions unityAdsShowOptions) throws IllegalArgumentException {
        Object objOpt;
        String string;
        JSONObject data = unityAdsShowOptions.getData();
        if (data == null || (objOpt = data.opt("objectId")) == null || (string = objOpt.toString()) == null) {
            return null;
        }
        return UUID.fromString(string).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, String> getTags(String str, Integer num, String str2) {
        LinkedHashMap linkedHashMapG0 = r5.x.g0(new q5.i("operation", OperationType.SHOW.toString()), new q5.i("reason", str));
        if (num != null) {
        }
        if (str2 != null) {
            linkedHashMapG0.put("reason_debug", str2);
        }
        return linkedHashMapG0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AdObject getTmpAdObject(String str) {
        UUID uuidFromString = UUID.fromString(str);
        k.d(uuidFromString, "fromString(opportunityId)");
        ByteString byteString = ProtobufExtensionsKt.toByteString(uuidFromString);
        AdObject ad = this.adRepository.getAd(byteString);
        if (ad != null) {
            return ad;
        }
        String str2 = this.placement;
        if (str2 == null) {
            str2 = "";
        }
        ByteString EMPTY = ByteString.EMPTY;
        k.d(EMPTY, "EMPTY");
        return new AdObject(byteString, str2, EMPTY, false, null, null, null, false, null, null, null, new UnityAdsLoadOptions(), false, DiagnosticEventRequestOuterClass.DiagnosticAdType.DIAGNOSTIC_AD_TYPE_UNSPECIFIED, null, null, 50680, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object sendOperativeError(OperativeEventRequestOuterClass.OperativeEventErrorType operativeEventErrorType, String str, AdObject adObject, v5.c<? super x> cVar) throws Throwable {
        OperativeEventErrorDataKt.Dsl.Companion companion = OperativeEventErrorDataKt.Dsl.Companion;
        OperativeEventRequestOuterClass.OperativeEventErrorData.Builder builderNewBuilder = OperativeEventRequestOuterClass.OperativeEventErrorData.newBuilder();
        k.d(builderNewBuilder, "newBuilder()");
        OperativeEventErrorDataKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setErrorType(operativeEventErrorType);
        dsl_create.setMessage(str);
        OperativeEventRequestOuterClass.OperativeEventErrorData operativeEventErrorData_build = dsl_create._build();
        GetOperativeEventApi getOperativeEventApi = this.getOperativeEventApi;
        OperativeEventRequestOuterClass.OperativeEventType operativeEventType = OperativeEventRequestOuterClass.OperativeEventType.OPERATIVE_EVENT_TYPE_SHOW_ERROR;
        ByteString byteString = operativeEventErrorData_build.toByteString();
        k.d(byteString, "errorData.toByteString()");
        Object objInvoke = getOperativeEventApi.invoke(operativeEventType, adObject, byteString, cVar);
        return objInvoke == w5.a.f17774a ? objInvoke : x.f13520a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showClicked(o6.e eVar, String str, Listeners listeners) {
        DeviceLog.debug("Unity Ads Show Clicked for placement " + str);
        SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_show_clicked", Double.valueOf(TimeExtensionsKt.elapsedMillis(eVar)), null, null, this.adObject, null, 44, null);
        this.safeCallbackInvoke.invoke(new C29071(listeners, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showCompleted(o6.e eVar, String str, ShowStatus showStatus, Listeners listeners, String str2, String str3) {
        DeviceLog.debug("Unity Ads Show Completed for placement " + str);
        s5.f fVar = new s5.f();
        if (str2 != null) {
        }
        if (str3 != null) {
            fVar.put("reason_debug", str3);
        }
        s5.f fVarB = fVar.b();
        SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_show_success_time", Double.valueOf(TimeExtensionsKt.elapsedMillis(eVar)), fVarB, null, this.adObject, null, 40, null);
        this.safeCallbackInvoke.invoke(new C29081(listeners, str, showStatus, this));
    }

    public static /* synthetic */ void showCompleted$default(LegacyShowUseCase legacyShowUseCase, o6.e eVar, String str, ShowStatus showStatus, Listeners listeners, String str2, String str3, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            str2 = null;
        }
        if ((i2 & 32) != 0) {
            str3 = null;
        }
        legacyShowUseCase.showCompleted(eVar, str, showStatus, listeners, str2, str3);
    }

    private final t showError(o6.e eVar, String str, String str2, Listeners listeners) {
        return new C29091(str, this, str2, eVar, listeners, null);
    }

    private final void showStart(String str) {
        SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_show_started", null, null, null, getTmpAdObject(str), null, 46, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showStarted(o6.e eVar, String str, Listeners listeners) {
        DeviceLog.debug("Unity Ads Show WV Start for placement " + str);
        q0 q0Var = this.hasStarted;
        Boolean bool = Boolean.TRUE;
        d1 d1Var = (d1) q0Var;
        d1Var.getClass();
        d1Var.i(null, bool);
        SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_show_wv_started", Double.valueOf(TimeExtensionsKt.elapsedMillis(eVar)), null, null, this.adObject, null, 44, null);
        this.safeCallbackInvoke.invoke(new C29101(listeners, str));
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x01f1, code lost:
    
        if (r13.invoke("ad_player_scope_not_active", r11, com.unity3d.ads.core.domain.LegacyShowUseCase.MESSAGE_AD_PLAYER_UNAVAILABLE, null, null, r15) == r3) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0211, code lost:
    
        if (r13.invoke("already_showing", r11, com.unity3d.ads.core.domain.LegacyShowUseCase.MESSAGE_ALREADY_SHOWING, null, null, r15) == r3) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x023f, code lost:
    
        if (r13.invoke("placement_validation", r11, com.unity3d.ads.core.domain.LegacyShowUseCase.MSG_OPPORTUNITY_AND_PLACEMENT_NOT_MATCHING, null, null, r15) == r3) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0113, code lost:
    
        if (r13.invoke("not_initialized", r11, com.unity3d.ads.core.data.model.LoadResult.MSG_NOT_INITIALIZED, null, null, r15) == r3) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x012a, code lost:
    
        if (r13.invoke("placement_null", r11, com.unity3d.ads.core.data.model.LoadResult.MSG_PLACEMENT_NULL, null, null, r15) == r3) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0152, code lost:
    
        if (r13.invoke("no_opportunity_id", r11, com.unity3d.ads.core.domain.LegacyShowUseCase.MESSAGE_OPPORTUNITY_ID, null, r12, r15) == r3) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0172, code lost:
    
        if (r13.invoke("placement_not_loaded", r11, r12, null, null, r15) == r3) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x019f, code lost:
    
        if (r13.invoke("ad_object_not_found", r11, r12, null, null, r15) == r3) goto L66;
     */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invoke(java.lang.String r25, com.unity3d.ads.UnityAdsShowOptions r26, com.unity3d.ads.core.data.model.Listeners r27, v5.c<? super q5.x> r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 702
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.LegacyShowUseCase.invoke(java.lang.String, com.unity3d.ads.UnityAdsShowOptions, com.unity3d.ads.core.data.model.Listeners, v5.c):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass4<T> implements t6.f {
        final /* synthetic */ AdObject $adObject;
        final /* synthetic */ Listeners $listeners;
        final /* synthetic */ String $placement;
        final /* synthetic */ t $reportShowError;
        final /* synthetic */ long $startTime;

        public AnonymousClass4(long j, String str, Listeners listeners, AdObject adObject, t tVar) {
            this.$startTime = j;
            this.$placement = str;
            this.$listeners = listeners;
            this.$adObject = adObject;
            this.$reportShowError = tVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(com.unity3d.ads.core.data.model.ShowEvent r20, v5.c<? super q5.x> r21) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 325
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.LegacyShowUseCase.AnonymousClass4.emit(com.unity3d.ads.core.data.model.ShowEvent, v5.c):java.lang.Object");
        }

        @Override // t6.f
        public /* bridge */ /* synthetic */ Object emit(Object obj, v5.c cVar) {
            return emit((ShowEvent) obj, (v5.c<? super x>) cVar);
        }
    }
}
