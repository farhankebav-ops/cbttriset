package com.unity3d.services;

import android.content.Context;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.IUnityAdsTokenListener;
import com.unity3d.ads.TokenConfiguration;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.ads.core.configuration.AlternativeFlowReader;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.model.InitializationState;
import com.unity3d.ads.core.data.model.Listeners;
import com.unity3d.ads.core.domain.GetAdObject;
import com.unity3d.ads.core.domain.GetAsyncHeaderBiddingToken;
import com.unity3d.ads.core.domain.GetGameId;
import com.unity3d.ads.core.domain.GetHeaderBiddingToken;
import com.unity3d.ads.core.domain.GetInitializationState;
import com.unity3d.ads.core.domain.InitializeBoldSDK;
import com.unity3d.ads.core.domain.LegacyLoadUseCase;
import com.unity3d.ads.core.domain.LegacyShowUseCase;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.domain.ShouldAllowInitialization;
import com.unity3d.ads.core.domain.TokenNumberProvider;
import com.unity3d.ads.core.domain.om.OmFinishSession;
import com.unity3d.ads.core.extensions.ExceptionExtensionsKt;
import com.unity3d.ads.core.extensions.TimeExtensionsKt;
import com.unity3d.services.banners.UnityBannerSize;
import com.unity3d.services.core.di.IServiceComponent;
import com.unity3d.services.core.di.IServiceProvider;
import com.unity3d.services.core.di.ServiceProvider;
import com.unity3d.services.core.domain.task.InitializeSDK;
import com.vungle.ads.internal.protos.Sdk;
import e6.p;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.k;
import n7.b;
import o6.d;
import q5.f;
import q5.g;
import q5.x;
import q6.a0;
import q6.c0;
import q6.f1;
import q6.h1;
import r2.q;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class UnityAdsSDK implements IServiceComponent {
    private final IServiceProvider serviceProvider;

    /* JADX INFO: renamed from: com.unity3d.services.UnityAdsSDK$finishOMIDSession$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.services.UnityAdsSDK$finishOMIDSession$2", f = "UnityAdsSDK.kt", l = {202}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ f $getAdObject$delegate;
        final /* synthetic */ f $omFinishSession$delegate;
        final /* synthetic */ a0 $omidScope;
        final /* synthetic */ String $opportunityId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, a0 a0Var, f fVar, f fVar2, c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$opportunityId = str;
            this.$omidScope = a0Var;
            this.$getAdObject$delegate = fVar;
            this.$omFinishSession$delegate = fVar2;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return new AnonymousClass2(this.$opportunityId, this.$omidScope, this.$getAdObject$delegate, this.$omFinishSession$delegate, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                AdObject adObjectInvoke = UnityAdsSDK.finishOMIDSession$lambda$18(this.$getAdObject$delegate).invoke(this.$opportunityId);
                if (adObjectInvoke != null) {
                    OmFinishSession omFinishSessionFinishOMIDSession$lambda$19 = UnityAdsSDK.finishOMIDSession$lambda$19(this.$omFinishSession$delegate);
                    this.label = 1;
                    if (omFinishSessionFinishOMIDSession$lambda$19.invoke(adObjectInvoke, this) == aVar) {
                        return aVar;
                    }
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
            }
            c0.i(this.$omidScope, null);
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.services.UnityAdsSDK$getToken$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.services.UnityAdsSDK$getToken$1", f = "UnityAdsSDK.kt", l = {Sdk.SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR_VALUE}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements p {
        int label;

        public AnonymousClass1(c<? super AnonymousClass1> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return UnityAdsSDK.this.new AnonymousClass1(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
                return obj;
            }
            q.z0(obj);
            UnityAdsSDK unityAdsSDK = UnityAdsSDK.this;
            this.label = 1;
            Object objFetchToken = unityAdsSDK.fetchToken(com.ironsource.mediationsdk.metadata.a.g, this);
            return objFetchToken == aVar ? aVar : objFetchToken;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super String> cVar) {
            return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.services.UnityAdsSDK$getToken$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.services.UnityAdsSDK$getToken$2", f = "UnityAdsSDK.kt", l = {146}, m = "invokeSuspend")
    public static final class C29612 extends i implements p {
        final /* synthetic */ f $getAsyncHeaderBiddingToken$delegate;
        final /* synthetic */ a0 $getTokenScope;
        final /* synthetic */ IUnityAdsTokenListener $listener;
        final /* synthetic */ TokenConfiguration $tokenConfiguration;
        final /* synthetic */ f $tokenNumberProvider$delegate;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C29612(TokenConfiguration tokenConfiguration, IUnityAdsTokenListener iUnityAdsTokenListener, a0 a0Var, f fVar, f fVar2, c<? super C29612> cVar) {
            super(2, cVar);
            this.$tokenConfiguration = tokenConfiguration;
            this.$listener = iUnityAdsTokenListener;
            this.$getTokenScope = a0Var;
            this.$getAsyncHeaderBiddingToken$delegate = fVar;
            this.$tokenNumberProvider$delegate = fVar2;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return new C29612(this.$tokenConfiguration, this.$listener, this.$getTokenScope, this.$getAsyncHeaderBiddingToken$delegate, this.$tokenNumberProvider$delegate, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                GetAsyncHeaderBiddingToken token$lambda$8 = UnityAdsSDK.getToken$lambda$8(this.$getAsyncHeaderBiddingToken$delegate);
                int iInvoke = UnityAdsSDK.getToken$lambda$7(this.$tokenNumberProvider$delegate).invoke();
                TokenConfiguration tokenConfiguration = this.$tokenConfiguration;
                IUnityAdsTokenListener iUnityAdsTokenListener = this.$listener;
                this.label = 1;
                if (token$lambda$8.invoke(iInvoke, tokenConfiguration, iUnityAdsTokenListener, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
            }
            c0.i(this.$getTokenScope, null);
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((C29612) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.services.UnityAdsSDK$initialize$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.services.UnityAdsSDK$initialize$1", f = "UnityAdsSDK.kt", l = {87, 89}, m = "invokeSuspend")
    public static final class C29621 extends i implements p {
        final /* synthetic */ f $alternativeFlowReader$delegate;
        final /* synthetic */ a0 $initScope;
        final /* synthetic */ f $initializeBoldSDK$delegate;
        final /* synthetic */ f $initializeSDK$delegate;
        final /* synthetic */ String $source;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C29621(String str, a0 a0Var, f fVar, f fVar2, f fVar3, c<? super C29621> cVar) {
            super(2, cVar);
            this.$source = str;
            this.$initScope = a0Var;
            this.$alternativeFlowReader$delegate = fVar;
            this.$initializeBoldSDK$delegate = fVar2;
            this.$initializeSDK$delegate = fVar3;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return new C29621(this.$source, this.$initScope, this.$alternativeFlowReader$delegate, this.$initializeBoldSDK$delegate, this.$initializeSDK$delegate, cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x003e, code lost:
        
            if (r5.invoke(r1, r4) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x004f, code lost:
        
            if (r5.mo3222invokegIAlus(r1, r4) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0051, code lost:
        
            return r0;
         */
        @Override // x5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
            /*
                r4 = this;
                w5.a r0 = w5.a.f17774a
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L21
                if (r1 == r3) goto L1d
                if (r1 != r2) goto L15
                r2.q.z0(r5)
                q5.k r5 = (q5.k) r5
                r5.getClass()
                goto L52
            L15:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L1d:
                r2.q.z0(r5)
                goto L52
            L21:
                r2.q.z0(r5)
                q5.f r5 = r4.$alternativeFlowReader$delegate
                com.unity3d.ads.core.configuration.AlternativeFlowReader r5 = com.unity3d.services.UnityAdsSDK.access$initialize$lambda$1(r5)
                boolean r5 = r5.invoke()
                if (r5 == 0) goto L41
                q5.f r5 = r4.$initializeBoldSDK$delegate
                com.unity3d.ads.core.domain.InitializeBoldSDK r5 = com.unity3d.services.UnityAdsSDK.access$initialize$lambda$3(r5)
                java.lang.String r1 = r4.$source
                r4.label = r3
                java.lang.Object r5 = r5.invoke(r1, r4)
                if (r5 != r0) goto L52
                goto L51
            L41:
                q5.f r5 = r4.$initializeSDK$delegate
                com.unity3d.services.core.domain.task.InitializeSDK r5 = com.unity3d.services.UnityAdsSDK.access$initialize$lambda$2(r5)
                com.unity3d.services.core.domain.task.EmptyParams r1 = com.unity3d.services.core.domain.task.EmptyParams.INSTANCE
                r4.label = r2
                java.lang.Object r5 = r5.mo3222invokegIAlus(r1, r4)
                if (r5 != r0) goto L52
            L51:
                return r0
            L52:
                q6.a0 r5 = r4.$initScope
                r0 = 0
                q6.c0.i(r5, r0)
                q5.x r5 = q5.x.f13520a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.UnityAdsSDK.C29621.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((C29621) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.services.UnityAdsSDK$load$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.services.UnityAdsSDK$load$1", f = "UnityAdsSDK.kt", l = {110}, m = "invokeSuspend")
    public static final class C29631 extends i implements p {
        final /* synthetic */ UnityBannerSize $bannerSize;
        final /* synthetic */ f $context$delegate;
        final /* synthetic */ IUnityAdsLoadListener $listener;
        final /* synthetic */ UnityAdsLoadOptions $loadOptions;
        final /* synthetic */ a0 $loadScope;
        final /* synthetic */ String $placementId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C29631(String str, UnityAdsLoadOptions unityAdsLoadOptions, IUnityAdsLoadListener iUnityAdsLoadListener, UnityBannerSize unityBannerSize, a0 a0Var, f fVar, c<? super C29631> cVar) {
            super(2, cVar);
            this.$placementId = str;
            this.$loadOptions = unityAdsLoadOptions;
            this.$listener = iUnityAdsLoadListener;
            this.$bannerSize = unityBannerSize;
            this.$loadScope = a0Var;
            this.$context$delegate = fVar;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return UnityAdsSDK.this.new C29631(this.$placementId, this.$loadOptions, this.$listener, this.$bannerSize, this.$loadScope, this.$context$delegate, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            C29631 c29631;
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                LegacyLoadUseCase legacyLoadUseCase = (LegacyLoadUseCase) UnityAdsSDK.this.getServiceProvider().getRegistry().getService("", b0.a(LegacyLoadUseCase.class));
                Context contextLoad$lambda$5 = UnityAdsSDK.load$lambda$5(this.$context$delegate);
                String str = this.$placementId;
                UnityAdsLoadOptions unityAdsLoadOptions = this.$loadOptions;
                IUnityAdsLoadListener iUnityAdsLoadListener = this.$listener;
                UnityBannerSize unityBannerSize = this.$bannerSize;
                this.label = 1;
                c29631 = this;
                if (legacyLoadUseCase.invoke(contextLoad$lambda$5, str, unityAdsLoadOptions, iUnityAdsLoadListener, unityBannerSize, c29631) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
                c29631 = this;
            }
            c0.i(c29631.$loadScope, null);
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((C29631) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.services.UnityAdsSDK$show$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.services.UnityAdsSDK$show$1", f = "UnityAdsSDK.kt", l = {120}, m = "invokeSuspend")
    public static final class C29641 extends i implements p {
        final /* synthetic */ Listeners $listener;
        final /* synthetic */ String $placementId;
        final /* synthetic */ LegacyShowUseCase $showBoldSDK;
        final /* synthetic */ UnityAdsShowOptions $showOptions;
        final /* synthetic */ a0 $showScope;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C29641(LegacyShowUseCase legacyShowUseCase, String str, UnityAdsShowOptions unityAdsShowOptions, Listeners listeners, a0 a0Var, c<? super C29641> cVar) {
            super(2, cVar);
            this.$showBoldSDK = legacyShowUseCase;
            this.$placementId = str;
            this.$showOptions = unityAdsShowOptions;
            this.$listener = listeners;
            this.$showScope = a0Var;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return new C29641(this.$showBoldSDK, this.$placementId, this.$showOptions, this.$listener, this.$showScope, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                LegacyShowUseCase legacyShowUseCase = this.$showBoldSDK;
                String str = this.$placementId;
                UnityAdsShowOptions unityAdsShowOptions = this.$showOptions;
                Listeners listeners = this.$listener;
                this.label = 1;
                if (legacyShowUseCase.invoke(str, unityAdsShowOptions, listeners, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
            }
            c0.i(this.$showScope, null);
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((C29641) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public UnityAdsSDK() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fetchToken(String str, c<? super String> cVar) {
        String str2;
        String str3;
        String str4;
        g gVar = g.f13496c;
        f fVarB = b.B(gVar, new UnityAdsSDK$fetchToken$$inlined$inject$default$1(this, ""));
        f fVarB2 = b.B(gVar, new UnityAdsSDK$fetchToken$$inlined$inject$default$2(this, ""));
        f fVarB3 = b.B(gVar, new UnityAdsSDK$fetchToken$$inlined$inject$default$3(this, ""));
        f fVarB4 = b.B(gVar, new UnityAdsSDK$fetchToken$$inlined$inject$default$4(this, ""));
        long jB = d.b();
        SendDiagnosticEvent.DefaultImpls.invoke$default(fetchToken$lambda$12(fVarB4), "native_gateway_token_started", null, r5.x.f0(new q5.i("sync", str), new q5.i("state", GetInitializationState.DefaultImpls.invoke$default(fetchToken$lambda$11(fVarB3), false, 1, null).toString())), null, null, null, 58, null);
        if (GetInitializationState.DefaultImpls.invoke$default(fetchToken$lambda$11(fVarB3), false, 1, null) != InitializationState.INITIALIZED) {
            str2 = "not_initialized";
            str3 = null;
            str4 = null;
        } else {
            try {
                str4 = (String) c0.A(v5.i.f17610a, new UnityAdsSDK$fetchToken$token$1(fVarB2, fVarB, null));
                str2 = null;
                str3 = null;
            } catch (Exception e) {
                String shortenedStackTrace$default = ExceptionExtensionsKt.getShortenedStackTrace$default(e, 0, 1, null);
                str2 = "uncaught_exception";
                str3 = shortenedStackTrace$default;
                str4 = null;
            }
        }
        SendDiagnosticEvent sendDiagnosticEventFetchToken$lambda$12 = fetchToken$lambda$12(fVarB4);
        String str5 = str4 == null ? "native_gateway_token_failure_time" : "native_gateway_token_success_time";
        Double d8 = new Double(TimeExtensionsKt.elapsedMillis(new o6.f(jB)));
        s5.f fVar = new s5.f();
        fVar.put("sync", str);
        fVar.put("state", GetInitializationState.DefaultImpls.invoke$default(fetchToken$lambda$11(fVarB3), false, 1, null).toString());
        if (str2 != null) {
        }
        if (str3 != null) {
            fVar.put("reason_debug", str3);
        }
        SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEventFetchToken$lambda$12, str5, d8, fVar.b(), null, null, new Integer(fetchToken$lambda$9(fVarB).invoke()), 24, null);
        return str4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GetHeaderBiddingToken fetchToken$lambda$10(f fVar) {
        return (GetHeaderBiddingToken) fVar.getValue();
    }

    private static final GetInitializationState fetchToken$lambda$11(f fVar) {
        return (GetInitializationState) fVar.getValue();
    }

    private static final SendDiagnosticEvent fetchToken$lambda$12(f fVar) {
        return (SendDiagnosticEvent) fVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TokenNumberProvider fetchToken$lambda$9(f fVar) {
        return (TokenNumberProvider) fVar.getValue();
    }

    private static final AlternativeFlowReader finishOMIDSession$lambda$16(f fVar) {
        return (AlternativeFlowReader) fVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GetAdObject finishOMIDSession$lambda$18(f fVar) {
        return (GetAdObject) fVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OmFinishSession finishOMIDSession$lambda$19(f fVar) {
        return (OmFinishSession) fVar.getValue();
    }

    private static final GetGameId getToken$lambda$6(f fVar) {
        return (GetGameId) fVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TokenNumberProvider getToken$lambda$7(f fVar) {
        return (TokenNumberProvider) fVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GetAsyncHeaderBiddingToken getToken$lambda$8(f fVar) {
        return (GetAsyncHeaderBiddingToken) fVar.getValue();
    }

    public static /* synthetic */ f1 initialize$default(UnityAdsSDK unityAdsSDK, String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = "api";
        }
        return unityAdsSDK.initialize(str, str2);
    }

    private static final ShouldAllowInitialization initialize$lambda$0(f fVar) {
        return (ShouldAllowInitialization) fVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AlternativeFlowReader initialize$lambda$1(f fVar) {
        return (AlternativeFlowReader) fVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InitializeSDK initialize$lambda$2(f fVar) {
        return (InitializeSDK) fVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InitializeBoldSDK initialize$lambda$3(f fVar) {
        return (InitializeBoldSDK) fVar.getValue();
    }

    public static /* synthetic */ f1 load$default(UnityAdsSDK unityAdsSDK, String str, UnityAdsLoadOptions unityAdsLoadOptions, IUnityAdsLoadListener iUnityAdsLoadListener, UnityBannerSize unityBannerSize, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            unityBannerSize = null;
        }
        return unityAdsSDK.load(str, unityAdsLoadOptions, iUnityAdsLoadListener, unityBannerSize);
    }

    private static final GetGameId load$lambda$4(f fVar) {
        return (GetGameId) fVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Context load$lambda$5(f fVar) {
        return (Context) fVar.getValue();
    }

    private static final AlternativeFlowReader sendBannerDestroyed$lambda$20(f fVar) {
        return (AlternativeFlowReader) fVar.getValue();
    }

    private static final SendDiagnosticEvent sendBannerDestroyed$lambda$21(f fVar) {
        return (SendDiagnosticEvent) fVar.getValue();
    }

    public final f1 finishOMIDSession(String opportunityId) {
        k.e(opportunityId, "opportunityId");
        g gVar = g.f13496c;
        if (!finishOMIDSession$lambda$16(b.B(gVar, new UnityAdsSDK$finishOMIDSession$$inlined$inject$default$1(this, ""))).invoke()) {
            h1 h1VarC = c0.c();
            h1VarC.N(x.f13520a);
            return h1VarC;
        }
        f fVarB = b.B(gVar, new UnityAdsSDK$finishOMIDSession$$inlined$inject$default$2(this, ""));
        f fVarB2 = b.B(gVar, new UnityAdsSDK$finishOMIDSession$$inlined$inject$default$3(this, ""));
        a0 a0Var = (a0) getServiceProvider().getRegistry().getService(ServiceProvider.NAMED_OMID_SCOPE, b0.a(a0.class));
        return c0.u(a0Var, null, new AnonymousClass2(opportunityId, a0Var, fVarB, fVarB2, null), 3);
    }

    @Override // com.unity3d.services.core.di.IServiceComponent
    public IServiceProvider getServiceProvider() {
        return this.serviceProvider;
    }

    public final String getToken() {
        return (String) c0.A(v5.i.f17610a, new AnonymousClass1(null));
    }

    public final synchronized f1 initialize(String str, String source) {
        k.e(source, "source");
        g gVar = g.f13496c;
        if (!initialize$lambda$0(b.B(gVar, new UnityAdsSDK$initialize$$inlined$inject$default$1(this, ""))).invoke(str)) {
            return c0.c();
        }
        f fVarB = b.B(gVar, new UnityAdsSDK$initialize$$inlined$inject$default$2(this, ""));
        f fVarB2 = b.B(gVar, new UnityAdsSDK$initialize$$inlined$inject$default$3(this, ""));
        f fVarB3 = b.B(gVar, new UnityAdsSDK$initialize$$inlined$inject$default$4(this, ""));
        a0 a0Var = (a0) getServiceProvider().getRegistry().getService(ServiceProvider.NAMED_INIT_SCOPE, b0.a(a0.class));
        return c0.u(a0Var, null, new C29621(source, a0Var, fVarB, fVarB3, fVarB2, null), 3);
    }

    public final f1 load(String str, UnityAdsLoadOptions loadOptions, IUnityAdsLoadListener iUnityAdsLoadListener, UnityBannerSize unityBannerSize) {
        k.e(loadOptions, "loadOptions");
        g gVar = g.f13496c;
        initialize(load$lambda$4(b.B(gVar, new UnityAdsSDK$load$$inlined$inject$default$1(this, ""))).invoke(), "load");
        a0 a0Var = (a0) getServiceProvider().getRegistry().getService(ServiceProvider.NAMED_LOAD_SCOPE, b0.a(a0.class));
        return c0.u(a0Var, null, new C29631(str, loadOptions, iUnityAdsLoadListener, unityBannerSize, a0Var, b.B(gVar, new UnityAdsSDK$load$$inlined$inject$default$2(this, "")), null), 3);
    }

    public final void sendBannerDestroyed() {
        g gVar = g.f13496c;
        if (sendBannerDestroyed$lambda$20(b.B(gVar, new UnityAdsSDK$sendBannerDestroyed$$inlined$inject$default$1(this, ""))).invoke()) {
            SendDiagnosticEvent.DefaultImpls.invoke$default(sendBannerDestroyed$lambda$21(b.B(gVar, new UnityAdsSDK$sendBannerDestroyed$$inlined$inject$default$2(this, ""))), "native_banner_destroyed", null, null, null, null, null, 62, null);
        }
    }

    public final f1 show(String str, UnityAdsShowOptions unityAdsShowOptions, Listeners listener) {
        k.e(listener, "listener");
        a0 a0Var = (a0) getServiceProvider().getRegistry().getService(ServiceProvider.NAMED_SHOW_SCOPE, b0.a(a0.class));
        return c0.u(a0Var, null, new C29641((LegacyShowUseCase) getServiceProvider().getRegistry().getService("", b0.a(LegacyShowUseCase.class)), str, unityAdsShowOptions, listener, a0Var, null), 3);
    }

    public UnityAdsSDK(IServiceProvider serviceProvider) {
        k.e(serviceProvider, "serviceProvider");
        this.serviceProvider = serviceProvider;
    }

    public /* synthetic */ UnityAdsSDK(IServiceProvider iServiceProvider, int i2, kotlin.jvm.internal.f fVar) {
        this((i2 & 1) != 0 ? ServiceProvider.INSTANCE : iServiceProvider);
    }

    public final f1 getToken(IUnityAdsTokenListener iUnityAdsTokenListener) {
        return getToken(null, iUnityAdsTokenListener);
    }

    public final f1 getToken(TokenConfiguration tokenConfiguration, IUnityAdsTokenListener iUnityAdsTokenListener) {
        g gVar = g.f13496c;
        initialize(getToken$lambda$6(b.B(gVar, new UnityAdsSDK$getToken$$inlined$inject$default$1(this, ""))).invoke(), "get_token");
        f fVarB = b.B(gVar, new UnityAdsSDK$getToken$$inlined$inject$default$2(this, ""));
        f fVarB2 = b.B(gVar, new UnityAdsSDK$getToken$$inlined$inject$default$3(this, ""));
        a0 a0Var = (a0) getServiceProvider().getRegistry().getService(ServiceProvider.NAMED_GET_TOKEN_SCOPE, b0.a(a0.class));
        return c0.u(a0Var, null, new C29612(tokenConfiguration, iUnityAdsTokenListener, a0Var, fVarB2, fVarB, null), 3);
    }
}
