package com.unity3d.ads.core.domain;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.unity3d.ads.IUnityAdsTokenListener;
import com.unity3d.ads.core.data.model.InitializationState;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.domain.AwaitInitialization;
import com.unity3d.ads.core.domain.GetInitializationState;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.extensions.TimeExtensionsKt;
import com.vungle.ads.internal.protos.Sdk;
import e6.p;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import o6.d;
import o6.f;
import q5.x;
import q6.a0;
import r2.q;
import r5.j;
import x5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CommonInitAwaitingGetHeaderBiddingToken implements GetAsyncHeaderBiddingToken {
    private final AwaitInitialization awaitInitialization;
    private boolean didAwaitInit;
    private final GetHeaderBiddingToken getHeaderBiddingToken;
    private final GetInitializationState getInitializationState;
    private IUnityAdsTokenListener listener;
    private final SafeCallbackInvoke safeCallbackInvoke;
    private final SendDiagnosticEvent sendDiagnosticEvent;
    private final SessionRepository sessionRepository;
    private InitializationState startState;
    private final long startTime;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken$fetchToken$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken", f = "CommonInitAwaitingGetHeaderBiddingToken.kt", l = {73}, m = "fetchToken")
    public static final class AnonymousClass1 extends c {
        int I$0;
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
            return CommonInitAwaitingGetHeaderBiddingToken.this.fetchToken(0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken$invoke$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken", f = "CommonInitAwaitingGetHeaderBiddingToken.kt", l = {54, ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT}, m = "invoke")
    public static final class C29021 extends c {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C29021(v5.c<? super C29021> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CommonInitAwaitingGetHeaderBiddingToken.this.invoke(0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken$invoke$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken$invoke$2", f = "CommonInitAwaitingGetHeaderBiddingToken.kt", l = {Sdk.SDKMetric.SDKMetricType.INIT_TO_SUCCESS_CALLBACK_DURATION_MS_VALUE}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        int label;

        public AnonymousClass2(v5.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return CommonInitAwaitingGetHeaderBiddingToken.this.new AnonymousClass2(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                if (j.Y(new InitializationState[]{InitializationState.NOT_INITIALIZED, InitializationState.INITIALIZING}, GetInitializationState.DefaultImpls.invoke$default(CommonInitAwaitingGetHeaderBiddingToken.this.getGetInitializationState(), false, 1, null))) {
                    CommonInitAwaitingGetHeaderBiddingToken.this.didAwaitInit = true;
                    AwaitInitialization awaitInitialization = CommonInitAwaitingGetHeaderBiddingToken.this.getAwaitInitialization();
                    this.label = 1;
                    if (AwaitInitialization.DefaultImpls.invoke$default(awaitInitialization, 0L, this, 1, null) == aVar) {
                        return aVar;
                    }
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
            }
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, v5.c<? super x> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken$tokenFailure$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C29032 extends l implements e6.a {
        public C29032() {
            super(0);
        }

        @Override // e6.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m3209invoke();
            return x.f13520a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m3209invoke() {
            IUnityAdsTokenListener listener = CommonInitAwaitingGetHeaderBiddingToken.this.getListener();
            if (listener != null) {
                listener.onUnityAdsTokenReady(null);
            }
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken$tokenSuccess$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C29041 extends l implements e6.a {
        final /* synthetic */ String $token;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C29041(String str) {
            super(0);
            this.$token = str;
        }

        @Override // e6.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m3210invoke();
            return x.f13520a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m3210invoke() {
            IUnityAdsTokenListener listener = CommonInitAwaitingGetHeaderBiddingToken.this.getListener();
            if (listener != null) {
                listener.onUnityAdsTokenReady(this.$token);
            }
        }
    }

    public CommonInitAwaitingGetHeaderBiddingToken(GetHeaderBiddingToken getHeaderBiddingToken, SendDiagnosticEvent sendDiagnosticEvent, GetInitializationState getInitializationState, AwaitInitialization awaitInitialization, SessionRepository sessionRepository, SafeCallbackInvoke safeCallbackInvoke) {
        k.e(getHeaderBiddingToken, "getHeaderBiddingToken");
        k.e(sendDiagnosticEvent, "sendDiagnosticEvent");
        k.e(getInitializationState, "getInitializationState");
        k.e(awaitInitialization, "awaitInitialization");
        k.e(sessionRepository, "sessionRepository");
        k.e(safeCallbackInvoke, "safeCallbackInvoke");
        this.getHeaderBiddingToken = getHeaderBiddingToken;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
        this.getInitializationState = getInitializationState;
        this.awaitInitialization = awaitInitialization;
        this.sessionRepository = sessionRepository;
        this.safeCallbackInvoke = safeCallbackInvoke;
        this.startTime = d.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object fetchToken(int r6, com.unity3d.ads.TokenConfiguration r7, v5.c<? super q5.x> r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken$fetchToken$1 r0 = (com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken$fetchToken$1 r0 = new com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken$fetchToken$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$0
            com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken r7 = (com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken) r7
            r2.q.z0(r8)     // Catch: java.lang.Exception -> L2e
            goto L4b
        L2e:
            r8 = move-exception
            goto L53
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            r2.q.z0(r8)
            com.unity3d.ads.core.domain.GetHeaderBiddingToken r8 = r5.getHeaderBiddingToken     // Catch: java.lang.Exception -> L51
            r0.L$0 = r5     // Catch: java.lang.Exception -> L51
            r0.I$0 = r6     // Catch: java.lang.Exception -> L51
            r0.label = r3     // Catch: java.lang.Exception -> L51
            java.lang.Object r8 = r8.invoke(r6, r7, r0)     // Catch: java.lang.Exception -> L51
            if (r8 != r1) goto L4a
            return r1
        L4a:
            r7 = r5
        L4b:
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.Exception -> L2e
            r0 = r4
            r4 = r8
            r8 = r0
            goto L5a
        L51:
            r8 = move-exception
            r7 = r5
        L53:
            r0 = 0
            java.lang.String r8 = com.unity3d.ads.core.extensions.ExceptionExtensionsKt.getShortenedStackTrace$default(r8, r0, r3, r4)
            java.lang.String r0 = "uncaught_exception"
        L5a:
            if (r4 != 0) goto L60
            r7.tokenFailure(r6, r0, r8)
            goto L63
        L60:
            r7.tokenSuccess(r6, r4)
        L63:
            q5.x r6 = q5.x.f13520a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken.fetchToken(int, com.unity3d.ads.TokenConfiguration, v5.c):java.lang.Object");
    }

    private final void tokenFailure(int i2, String str, String str2) {
        SendDiagnosticEvent sendDiagnosticEvent = this.sendDiagnosticEvent;
        Double dValueOf = Double.valueOf(TimeExtensionsKt.elapsedMillis(new f(this.startTime)));
        s5.f fVar = new s5.f();
        fVar.put("sync", "false");
        fVar.put("state", String.valueOf(this.startState));
        fVar.put("complete_state", GetInitializationState.DefaultImpls.invoke$default(this.getInitializationState, false, 1, null).toString());
        fVar.put("awaited_init", String.valueOf(this.didAwaitInit));
        if (str != null) {
        }
        if (str2 != null) {
            fVar.put("reason_debug", str2);
        }
        SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent, "native_gateway_token_failure_time", dValueOf, fVar.b(), null, null, Integer.valueOf(i2), 24, null);
        this.safeCallbackInvoke.invoke(new C29032());
    }

    public static /* synthetic */ void tokenFailure$default(CommonInitAwaitingGetHeaderBiddingToken commonInitAwaitingGetHeaderBiddingToken, int i2, String str, String str2, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            str2 = null;
        }
        commonInitAwaitingGetHeaderBiddingToken.tokenFailure(i2, str, str2);
    }

    private final void tokenStart(int i2) {
        InitializationState initializationStateInvoke$default = GetInitializationState.DefaultImpls.invoke$default(this.getInitializationState, false, 1, null);
        this.startState = initializationStateInvoke$default;
        SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_gateway_token_started", null, r5.x.f0(new q5.i("sync", "false"), new q5.i("state", String.valueOf(initializationStateInvoke$default))), null, null, Integer.valueOf(i2), 26, null);
    }

    private final void tokenSuccess(int i2, String str) {
        SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_gateway_token_success_time", Double.valueOf(TimeExtensionsKt.elapsedMillis(new f(this.startTime))), r5.x.f0(new q5.i("sync", "false"), new q5.i("state", String.valueOf(this.startState)), new q5.i("complete_state", GetInitializationState.DefaultImpls.invoke$default(this.getInitializationState, false, 1, null).toString()), new q5.i("awaited_init", String.valueOf(this.didAwaitInit))), null, null, Integer.valueOf(i2), 24, null);
        this.safeCallbackInvoke.invoke(new C29041(str));
    }

    public final AwaitInitialization getAwaitInitialization() {
        return this.awaitInitialization;
    }

    public final GetHeaderBiddingToken getGetHeaderBiddingToken() {
        return this.getHeaderBiddingToken;
    }

    public final GetInitializationState getGetInitializationState() {
        return this.getInitializationState;
    }

    public final IUnityAdsTokenListener getListener() {
        return this.listener;
    }

    public final SafeCallbackInvoke getSafeCallbackInvoke() {
        return this.safeCallbackInvoke;
    }

    public final SendDiagnosticEvent getSendDiagnosticEvent() {
        return this.sendDiagnosticEvent;
    }

    public final SessionRepository getSessionRepository() {
        return this.sessionRepository;
    }

    /* JADX INFO: renamed from: getStartTime-z9LOYto, reason: not valid java name */
    public final long m3208getStartTimez9LOYto() {
        return this.startTime;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.unity3d.ads.core.domain.GetAsyncHeaderBiddingToken
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object invoke(int r10, com.unity3d.ads.TokenConfiguration r11, com.unity3d.ads.IUnityAdsTokenListener r12, v5.c<? super q5.x> r13) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r13 instanceof com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken.C29021
            if (r0 == 0) goto L13
            r0 = r13
            com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken$invoke$1 r0 = (com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken.C29021) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken$invoke$1 r0 = new com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken$invoke$1
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            java.lang.String r3 = "!sessionRepository.shouldInitialize"
            java.lang.String r4 = "gateway"
            r5 = 2
            r6 = 1
            r7 = 0
            q5.x r8 = q5.x.f13520a
            if (r2 == 0) goto L47
            if (r2 == r6) goto L39
            if (r2 != r5) goto L31
            r2.q.z0(r13)
            goto La2
        L31:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L39:
            int r10 = r0.I$0
            java.lang.Object r11 = r0.L$1
            com.unity3d.ads.TokenConfiguration r11 = (com.unity3d.ads.TokenConfiguration) r11
            java.lang.Object r12 = r0.L$0
            com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken r12 = (com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken) r12
            r2.q.z0(r13)
            goto L89
        L47:
            r2.q.z0(r13)
            r9.listener = r12
            r9.tokenStart(r10)
            if (r12 != 0) goto L59
            java.lang.String r11 = "listener_null"
            java.lang.String r12 = "IUnityAdsTokenListener is null"
            r9.tokenFailure(r10, r11, r12)
            return r8
        L59:
            com.unity3d.ads.core.data.repository.SessionRepository r12 = r9.sessionRepository
            boolean r12 = r12.getShouldInitialize()
            if (r12 != 0) goto L65
            r9.tokenFailure(r10, r4, r3)
            return r8
        L65:
            com.unity3d.ads.core.data.repository.SessionRepository r12 = r9.sessionRepository
            gatewayprotocol.v1.NativeConfigurationOuterClass$NativeConfiguration r12 = r12.getNativeConfiguration()
            gatewayprotocol.v1.NativeConfigurationOuterClass$AdOperationsConfiguration r12 = r12.getAdOperations()
            int r12 = r12.getGetTokenTimeoutMs()
            long r12 = (long) r12
            com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken$invoke$2 r2 = new com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken$invoke$2
            r2.<init>(r7)
            r0.L$0 = r9
            r0.L$1 = r11
            r0.I$0 = r10
            r0.label = r6
            java.lang.Object r12 = q6.c0.J(r12, r2, r0)
            if (r12 != r1) goto L88
            goto La1
        L88:
            r12 = r9
        L89:
            com.unity3d.ads.core.data.repository.SessionRepository r13 = r12.sessionRepository
            boolean r13 = r13.getShouldInitialize()
            if (r13 != 0) goto L95
            r12.tokenFailure(r10, r4, r3)
            return r8
        L95:
            r0.L$0 = r7
            r0.L$1 = r7
            r0.label = r5
            java.lang.Object r10 = r12.fetchToken(r10, r11, r0)
            if (r10 != r1) goto La2
        La1:
            return r1
        La2:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken.invoke(int, com.unity3d.ads.TokenConfiguration, com.unity3d.ads.IUnityAdsTokenListener, v5.c):java.lang.Object");
    }

    public final void setListener(IUnityAdsTokenListener iUnityAdsTokenListener) {
        this.listener = iUnityAdsTokenListener;
    }
}
