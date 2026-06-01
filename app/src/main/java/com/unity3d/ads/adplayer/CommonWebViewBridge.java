package com.unity3d.ads.adplayer;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.ironsource.C2300e4;
import com.unity3d.ads.adplayer.model.WebViewEvent;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.ui.AdActivity;
import e6.p;
import kotlin.jvm.internal.k;
import org.json.JSONArray;
import q5.x;
import q6.a0;
import q6.c0;
import q6.f0;
import q6.w;
import q6.z;
import r2.q;
import r5.t;
import t6.p0;
import t6.q0;
import t6.r0;
import t6.t0;
import t6.w0;
import t6.x0;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CommonWebViewBridge implements WebViewBridge {
    private final p0 _onInvocation;
    private final q0 callbacks;
    private final t0 onInvocation;
    private final a0 scope;
    private final SendDiagnosticEvent sendDiagnosticEvent;
    private final WebViewContainer webViewContainer;

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.CommonWebViewBridge$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.adplayer.CommonWebViewBridge$1", f = "CommonWebViewBridge.kt", l = {33}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements p {
        int label;

        public AnonymousClass1(c<? super AnonymousClass1> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return CommonWebViewBridge.this.new AnonymousClass1(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                WebViewContainer webViewContainer = CommonWebViewBridge.this.webViewContainer;
                CommonWebViewBridge commonWebViewBridge = CommonWebViewBridge.this;
                this.label = 1;
                if (webViewContainer.addJavascriptInterface(commonWebViewBridge, "webviewbridge", this) == aVar) {
                    return aVar;
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
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.CommonWebViewBridge$handleInvocation$7, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.adplayer.CommonWebViewBridge$handleInvocation$7", f = "CommonWebViewBridge.kt", l = {127, Sdk.SDKError.Reason.EMPTY_TPAT_ERROR_VALUE, Sdk.SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR_VALUE, Sdk.SDKError.Reason.MRAID_JS_WRITE_FAILED_VALUE, Sdk.SDKError.Reason.OMSDK_DOWNLOAD_JS_ERROR_VALUE, 139}, m = "invokeSuspend")
    public static final class AnonymousClass7 extends i implements p {
        final /* synthetic */ String $callback;
        final /* synthetic */ String $location;
        final /* synthetic */ JSONArray $parameters;
        Object L$0;
        int label;
        final /* synthetic */ CommonWebViewBridge this$0;

        /* JADX INFO: renamed from: com.unity3d.ads.adplayer.CommonWebViewBridge$handleInvocation$7$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @e(c = "com.unity3d.ads.adplayer.CommonWebViewBridge$handleInvocation$7$1", f = "CommonWebViewBridge.kt", l = {Sdk.SDKError.Reason.EMPTY_TPAT_ERROR_VALUE}, m = "invokeSuspend")
        public static final class AnonymousClass1 extends i implements p {
            final /* synthetic */ Invocation $invocation;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Invocation invocation, c<? super AnonymousClass1> cVar) {
                super(2, cVar);
                this.$invocation = invocation;
            }

            @Override // x5.a
            public final c<x> create(Object obj, c<?> cVar) {
                return new AnonymousClass1(this.$invocation, cVar);
            }

            @Override // x5.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                a aVar = a.f17774a;
                int i2 = this.label;
                if (i2 == 0) {
                    q.z0(obj);
                    f0 f0VarIsHandled = this.$invocation.isHandled();
                    this.label = 1;
                    if (f0VarIsHandled.j(this) == aVar) {
                        return aVar;
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
            public final Object invoke(a0 a0Var, c<? super x> cVar) {
                return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass7(String str, JSONArray jSONArray, CommonWebViewBridge commonWebViewBridge, String str2, c<? super AnonymousClass7> cVar) {
            super(2, cVar);
            this.$location = str;
            this.$parameters = jSONArray;
            this.this$0 = commonWebViewBridge;
            this.$callback = str2;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return new AnonymousClass7(this.$location, this.$parameters, this.this$0, this.$callback, cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x0099, code lost:
        
            if (r1.respond(r5, "OK", r7, r8) == r0) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00d8, code lost:
        
            if (r1.respond(r5, "ERROR", r3, r8) != r0) goto L44;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x006a A[Catch: Exception -> 0x001c, PHI: r1
  0x006a: PHI (r1v14 com.unity3d.ads.adplayer.Invocation) = (r1v11 com.unity3d.ads.adplayer.Invocation), (r1v16 com.unity3d.ads.adplayer.Invocation) binds: [B:21:0x0066, B:13:0x0027] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {Exception -> 0x001c, blocks: (B:7:0x0017, B:10:0x001f, B:26:0x0076, B:28:0x007a, B:31:0x0088, B:13:0x0027, B:23:0x006a, B:20:0x0056), top: B:46:0x0007 }] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0075  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0076 A[Catch: Exception -> 0x001c, PHI: r9
  0x0076: PHI (r9v17 java.lang.Object) = (r9v16 java.lang.Object), (r9v0 java.lang.Object) binds: [B:24:0x0073, B:10:0x001f] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {Exception -> 0x001c, blocks: (B:7:0x0017, B:10:0x001f, B:26:0x0076, B:28:0x007a, B:31:0x0088, B:13:0x0027, B:23:0x006a, B:20:0x0056), top: B:46:0x0007 }] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x007a A[Catch: Exception -> 0x001c, TryCatch #0 {Exception -> 0x001c, blocks: (B:7:0x0017, B:10:0x001f, B:26:0x0076, B:28:0x007a, B:31:0x0088, B:13:0x0027, B:23:0x006a, B:20:0x0056), top: B:46:0x0007 }] */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0088 A[Catch: Exception -> 0x001c, TRY_LEAVE, TryCatch #0 {Exception -> 0x001c, blocks: (B:7:0x0017, B:10:0x001f, B:26:0x0076, B:28:0x007a, B:31:0x0088, B:13:0x0027, B:23:0x006a, B:20:0x0056), top: B:46:0x0007 }] */
        @Override // x5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 240
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.adplayer.CommonWebViewBridge.AnonymousClass7.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((AnonymousClass7) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.CommonWebViewBridge$request$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.adplayer.CommonWebViewBridge", f = "CommonWebViewBridge.kt", l = {ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT, 68}, m = AdActivity.REQUEST_KEY_EXTRA)
    public static final class C28561 extends x5.c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C28561(c<? super C28561> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CommonWebViewBridge.this.request(null, null, null, this);
        }
    }

    public CommonWebViewBridge(w dispatcher, WebViewContainer webViewContainer, a0 adPlayerScope, SendDiagnosticEvent sendDiagnosticEvent) {
        k.e(dispatcher, "dispatcher");
        k.e(webViewContainer, "webViewContainer");
        k.e(adPlayerScope, "adPlayerScope");
        k.e(sendDiagnosticEvent, "sendDiagnosticEvent");
        this.webViewContainer = webViewContainer;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
        v6.c cVarX = c0.x(c0.x(adPlayerScope, dispatcher), new z("CommonWebViewBridge"));
        this.scope = cVarX;
        this.callbacks = x0.c(t.f13640a);
        w0 w0VarA = x0.a((7 & 1) != 0 ? 0 : 100, (7 & 2) == 0 ? 64 : 0, s6.a.f13718a);
        this._onInvocation = w0VarA;
        this.onInvocation = new r0(w0VarA);
        c0.u(cVarX, null, new AnonymousClass1(null), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object execute(HandlerType handlerType, String str, c<? super x> cVar) {
        Object objEvaluateJavascript = this.webViewContainer.evaluateJavascript("window.nativebridge." + handlerType.getJsPath() + '(' + str + ");", cVar);
        return objEvaluateJavascript == a.f17774a ? objEvaluateJavascript : x.f13520a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object respond(String str, String str2, Object[] objArr, c<? super x> cVar) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(str);
        jSONArray.put(str2);
        jSONArray.put(new JSONArray(objArr));
        Object objExecute = execute(HandlerType.CALLBACK, C2300e4.i.f8403d + jSONArray + ']', cVar);
        return objExecute == a.f17774a ? objExecute : x.f13520a;
    }

    @Override // com.unity3d.ads.adplayer.WebViewBridge
    public t0 getOnInvocation() {
        return this.onInvocation;
    }

    public final a0 getScope() {
        return this.scope;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00c8  */
    @Override // com.unity3d.ads.adplayer.WebViewBridge
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void handleCallback(java.lang.String r18, java.lang.String r19, java.lang.String r20) {
        /*
            Method dump skipped, instruction units count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.adplayer.CommonWebViewBridge.handleCallback(java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0198  */
    @Override // com.unity3d.ads.adplayer.WebViewBridge
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void handleInvocation(java.lang.String r28) {
        /*
            Method dump skipped, instruction units count: 471
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.adplayer.CommonWebViewBridge.handleInvocation(java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // com.unity3d.ads.adplayer.WebViewBridge
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object request(java.lang.String r15, java.lang.String r16, java.lang.Object[] r17, v5.c<? super java.lang.Object[]> r18) throws java.lang.Throwable {
        /*
            r14 = this;
            r0 = r17
            r1 = r18
            boolean r2 = r1 instanceof com.unity3d.ads.adplayer.CommonWebViewBridge.C28561
            if (r2 == 0) goto L17
            r2 = r1
            com.unity3d.ads.adplayer.CommonWebViewBridge$request$1 r2 = (com.unity3d.ads.adplayer.CommonWebViewBridge.C28561) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.label = r3
            goto L1c
        L17:
            com.unity3d.ads.adplayer.CommonWebViewBridge$request$1 r2 = new com.unity3d.ads.adplayer.CommonWebViewBridge$request$1
            r2.<init>(r1)
        L1c:
            java.lang.Object r1 = r2.result
            w5.a r3 = w5.a.f17774a
            int r4 = r2.label
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L3e
            if (r4 == r6) goto L36
            if (r4 != r5) goto L2e
            r2.q.z0(r1)
            return r1
        L2e:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L36:
            java.lang.Object r15 = r2.L$0
            q6.q r15 = (q6.q) r15
            r2.q.z0(r1)
            goto Lb0
        L3e:
            r2.q.z0(r1)
            q6.r r1 = q6.c0.a()
            int r4 = r1.hashCode()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            t6.q0 r7 = r14.callbacks
        L4f:
            r8 = r7
            t6.d1 r8 = (t6.d1) r8
            java.lang.Object r9 = r8.getValue()
            r10 = r9
            java.util.Set r10 = (java.util.Set) r10
            q5.i r11 = new q5.i
            r11.<init>(r4, r1)
            java.lang.String r12 = "<this>"
            kotlin.jvm.internal.k.e(r10, r12)
            java.util.LinkedHashSet r12 = new java.util.LinkedHashSet
            int r13 = r10.size()
            int r13 = r13 + r6
            int r13 = r5.x.d0(r13)
            r12.<init>(r13)
            r12.addAll(r10)
            r12.add(r11)
            boolean r8 = r8.g(r9, r12)
            if (r8 == 0) goto Lc1
            org.json.JSONArray r7 = new org.json.JSONArray
            r7.<init>()
            r7.put(r15)
            r8 = r16
            r7.put(r8)
            r7.put(r4)
            int r15 = r0.length
            r4 = 0
        L8f:
            if (r4 >= r15) goto L99
            r8 = r0[r4]
            r7.put(r8)
            int r4 = r4 + 1
            goto L8f
        L99:
            com.unity3d.ads.adplayer.HandlerType r15 = com.unity3d.ads.adplayer.HandlerType.INVOCATION
            java.lang.String r0 = r7.toString()
            java.lang.String r4 = "arguments.toString()"
            kotlin.jvm.internal.k.d(r0, r4)
            r2.L$0 = r1
            r2.label = r6
            java.lang.Object r15 = r14.execute(r15, r0, r2)
            if (r15 != r3) goto Laf
            goto Lbf
        Laf:
            r15 = r1
        Lb0:
            r0 = 0
            r2.L$0 = r0
            r2.label = r5
            q6.r r15 = (q6.r) r15
            java.lang.Object r15 = r15.t(r2)
            w5.a r0 = w5.a.f17774a
            if (r15 != r3) goto Lc0
        Lbf:
            return r3
        Lc0:
            return r15
        Lc1:
            r8 = r16
            goto L4f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.adplayer.CommonWebViewBridge.request(java.lang.String, java.lang.String, java.lang.Object[], v5.c):java.lang.Object");
    }

    @Override // com.unity3d.ads.adplayer.WebViewBridge
    public Object sendEvent(WebViewEvent webViewEvent, c<? super x> cVar) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(webViewEvent.getCategory());
        jSONArray.put(webViewEvent.getName());
        for (Object obj : webViewEvent.getParameters()) {
            jSONArray.put(obj);
        }
        HandlerType handlerType = HandlerType.EVENT;
        String string = jSONArray.toString();
        k.d(string, "arguments.toString()");
        Object objExecute = execute(handlerType, string, cVar);
        return objExecute == a.f17774a ? objExecute : x.f13520a;
    }
}
