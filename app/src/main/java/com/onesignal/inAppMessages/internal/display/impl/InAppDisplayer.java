package com.onesignal.inAppMessages.internal.display.impl;

import android.app.Activity;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.language.ILanguageContext;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.internal.InAppMessageContent;
import com.onesignal.inAppMessages.internal.backend.IInAppBackendService;
import com.onesignal.inAppMessages.internal.display.IInAppDisplayer;
import com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleService;
import com.onesignal.inAppMessages.internal.prompt.IInAppMessagePromptFactory;
import com.onesignal.session.internal.influence.IInfluenceManager;
import com.vungle.ads.internal.protos.Sdk;
import e6.p;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import n6.m;
import q5.x;
import q6.a0;
import r2.q;
import x5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InAppDisplayer implements IInAppDisplayer {
    public static final Companion Companion = new Companion(null);
    private static final int IN_APP_MESSAGE_INIT_DELAY = 200;
    private final IApplicationService _applicationService;
    private final IInAppBackendService _backend;
    private final ConfigModelStore _configModelStore;
    private final IInfluenceManager _influenceManager;
    private final ILanguageContext _languageContext;
    private final IInAppLifecycleService _lifecycle;
    private final IInAppMessagePromptFactory _promptFactory;
    private final ITime _time;
    private WebViewManager lastInstance;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$displayMessage$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer", f = "InAppDisplayer.kt", l = {48, Sdk.SDKMetric.SDKMetricType.INIT_TO_SUCCESS_CALLBACK_DURATION_MS_VALUE}, m = "displayMessage")
    public static final class AnonymousClass1 extends c {
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
            return InAppDisplayer.this.displayMessage(null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$displayPreviewMessage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer", f = "InAppDisplayer.kt", l = {73, 79}, m = "displayPreviewMessage")
    public static final class C27321 extends c {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C27321(v5.c<? super C27321> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InAppDisplayer.this.displayPreviewMessage(null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$initInAppMessage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer", f = "InAppDisplayer.kt", l = {145}, m = "initInAppMessage")
    public static final class C27331 extends c {
        int label;
        /* synthetic */ Object result;

        public C27331(v5.c<? super C27331> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InAppDisplayer.this.initInAppMessage(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$initInAppMessage$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$initInAppMessage$2", f = "InAppDisplayer.kt", l = {148}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ String $base64Str;
        final /* synthetic */ InAppMessageContent $content;
        final /* synthetic */ Activity $currentActivity;
        final /* synthetic */ WebViewManager $webViewManager;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(WebViewManager webViewManager, Activity activity, String str, InAppMessageContent inAppMessageContent, v5.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$webViewManager = webViewManager;
            this.$currentActivity = activity;
            this.$base64Str = str;
            this.$content = inAppMessageContent;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return new AnonymousClass2(this.$webViewManager, this.$currentActivity, this.$base64Str, this.$content, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Exception {
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            try {
                if (i2 == 0) {
                    q.z0(obj);
                    WebViewManager webViewManager = this.$webViewManager;
                    Activity activity = this.$currentActivity;
                    String base64Str = this.$base64Str;
                    k.d(base64Str, "base64Str");
                    boolean zIsFullBleed = this.$content.isFullBleed();
                    this.label = 1;
                    if (webViewManager.setupWebView(activity, base64Str, zIsFullBleed, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    q.z0(obj);
                }
            } catch (Exception e) {
                if (e.getMessage() != null) {
                    String message = e.getMessage();
                    k.b(message);
                    if (m.q0(message, "No WebView installed", false)) {
                        Logging.error("Error setting up WebView: ", e);
                    }
                }
                throw e;
            }
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, v5.c<? super x> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$showMessageContent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer", f = "InAppDisplayer.kt", l = {105, 107, 109, 114, 115}, m = "showMessageContent")
    public static final class C27341 extends c {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C27341(v5.c<? super C27341> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InAppDisplayer.this.showMessageContent(null, null, this);
        }
    }

    public InAppDisplayer(IApplicationService _applicationService, IInAppLifecycleService _lifecycle, IInAppMessagePromptFactory _promptFactory, IInAppBackendService _backend, IInfluenceManager _influenceManager, ConfigModelStore _configModelStore, ILanguageContext _languageContext, ITime _time) {
        k.e(_applicationService, "_applicationService");
        k.e(_lifecycle, "_lifecycle");
        k.e(_promptFactory, "_promptFactory");
        k.e(_backend, "_backend");
        k.e(_influenceManager, "_influenceManager");
        k.e(_configModelStore, "_configModelStore");
        k.e(_languageContext, "_languageContext");
        k.e(_time, "_time");
        this._applicationService = _applicationService;
        this._lifecycle = _lifecycle;
        this._promptFactory = _promptFactory;
        this._backend = _backend;
        this._influenceManager = _influenceManager;
        this._configModelStore = _configModelStore;
        this._languageContext = _languageContext;
        this._time = _time;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object initInAppMessage(android.app.Activity r18, com.onesignal.inAppMessages.internal.InAppMessage r19, com.onesignal.inAppMessages.internal.InAppMessageContent r20, v5.c<? super q5.x> r21) throws java.lang.Throwable {
        /*
            r17 = this;
            r1 = r17
            r0 = r21
            boolean r2 = r0 instanceof com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer.C27331
            if (r2 == 0) goto L17
            r2 = r0
            com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$initInAppMessage$1 r2 = (com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer.C27331) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.label = r3
            goto L1c
        L17:
            com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$initInAppMessage$1 r2 = new com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$initInAppMessage$1
            r2.<init>(r0)
        L1c:
            java.lang.Object r0 = r2.result
            w5.a r3 = w5.a.f17774a
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L37
            if (r4 != r5) goto L2f
            r2.q.z0(r0)     // Catch: java.io.UnsupportedEncodingException -> L2c
            goto L9d
        L2c:
            r0 = move-exception
            goto L98
        L2f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L37:
            r2.q.z0(r0)
            java.lang.String r0 = r20.getContentHtml()     // Catch: java.io.UnsupportedEncodingException -> L2c
            kotlin.jvm.internal.k.b(r0)     // Catch: java.io.UnsupportedEncodingException -> L2c
            java.lang.String r4 = "UTF-8"
            java.nio.charset.Charset r4 = java.nio.charset.Charset.forName(r4)     // Catch: java.io.UnsupportedEncodingException -> L2c
            java.lang.String r6 = "forName(charsetName)"
            kotlin.jvm.internal.k.d(r4, r6)     // Catch: java.io.UnsupportedEncodingException -> L2c
            byte[] r0 = r0.getBytes(r4)     // Catch: java.io.UnsupportedEncodingException -> L2c
            java.lang.String r4 = "this as java.lang.String).getBytes(charset)"
            kotlin.jvm.internal.k.d(r0, r4)     // Catch: java.io.UnsupportedEncodingException -> L2c
            r4 = 2
            java.lang.String r9 = android.util.Base64.encodeToString(r0, r4)     // Catch: java.io.UnsupportedEncodingException -> L2c
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager r7 = new com.onesignal.inAppMessages.internal.display.impl.WebViewManager     // Catch: java.io.UnsupportedEncodingException -> L2c
            com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleService r14 = r1._lifecycle     // Catch: java.io.UnsupportedEncodingException -> L2c
            com.onesignal.core.internal.application.IApplicationService r15 = r1._applicationService     // Catch: java.io.UnsupportedEncodingException -> L2c
            com.onesignal.inAppMessages.internal.prompt.IInAppMessagePromptFactory r0 = r1._promptFactory     // Catch: java.io.UnsupportedEncodingException -> L2c
            r12 = r18
            r11 = r19
            r13 = r20
            r16 = r0
            r10 = r7
            r10.<init>(r11, r12, r13, r14, r15, r16)     // Catch: java.io.UnsupportedEncodingException -> L2c
            r7 = r10
            r1.lastInstance = r7     // Catch: java.io.UnsupportedEncodingException -> L2c
            boolean r0 = r20.isFullBleed()     // Catch: java.io.UnsupportedEncodingException -> L2c
            if (r0 == 0) goto L7f
            r12 = r18
            r13 = r20
            r7.setContentSafeAreaInsets(r13, r12)     // Catch: java.io.UnsupportedEncodingException -> L2c
            goto L83
        L7f:
            r12 = r18
            r13 = r20
        L83:
            x6.e r0 = q6.m0.f13566a     // Catch: java.io.UnsupportedEncodingException -> L2c
            r6.c r0 = v6.n.f17641a     // Catch: java.io.UnsupportedEncodingException -> L2c
            com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$initInAppMessage$2 r6 = new com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$initInAppMessage$2     // Catch: java.io.UnsupportedEncodingException -> L2c
            r11 = 0
            r8 = r12
            r10 = r13
            r6.<init>(r7, r8, r9, r10, r11)     // Catch: java.io.UnsupportedEncodingException -> L2c
            r2.label = r5     // Catch: java.io.UnsupportedEncodingException -> L2c
            java.lang.Object r0 = q6.c0.H(r6, r0, r2)     // Catch: java.io.UnsupportedEncodingException -> L2c
            if (r0 != r3) goto L9d
            return r3
        L98:
            java.lang.String r2 = "Catch on initInAppMessage: "
            com.onesignal.debug.internal.logging.Logging.error(r2, r0)
        L9d:
            q5.x r0 = q5.x.f13520a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer.initInAppMessage(android.app.Activity, com.onesignal.inAppMessages.internal.InAppMessage, com.onesignal.inAppMessages.internal.InAppMessageContent, v5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object showMessageContent(com.onesignal.inAppMessages.internal.InAppMessage r12, com.onesignal.inAppMessages.internal.InAppMessageContent r13, v5.c<? super q5.x> r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer.showMessageContent(com.onesignal.inAppMessages.internal.InAppMessage, com.onesignal.inAppMessages.internal.InAppMessageContent, v5.c):java.lang.Object");
    }

    @Override // com.onesignal.inAppMessages.internal.display.IInAppDisplayer
    public void dismissCurrentInAppMessage() {
        Logging.debug$default("WebViewManager IAM dismissAndAwaitNextMessage lastInstance: " + this.lastInstance, null, 2, null);
        WebViewManager webViewManager = this.lastInstance;
        if (webViewManager != null) {
            k.b(webViewManager);
            webViewManager.backgroundDismissAndAwaitNextMessage();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a2, code lost:
    
        if (r2.showMessageContent(r9, r10, r0) == r1) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.onesignal.inAppMessages.internal.display.IInAppDisplayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object displayMessage(com.onesignal.inAppMessages.internal.InAppMessage r9, v5.c<? super java.lang.Boolean> r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r10
            com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$displayMessage$1 r0 = (com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$displayMessage$1 r0 = new com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$displayMessage$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3f
            if (r2 == r4) goto L33
            if (r2 != r3) goto L2b
            r2.q.z0(r10)
            goto La5
        L2b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L33:
            java.lang.Object r9 = r0.L$1
            com.onesignal.inAppMessages.internal.InAppMessage r9 = (com.onesignal.inAppMessages.internal.InAppMessage) r9
            java.lang.Object r2 = r0.L$0
            com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer r2 = (com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer) r2
            r2.q.z0(r10)
            goto L6a
        L3f:
            r2.q.z0(r10)
            com.onesignal.inAppMessages.internal.backend.IInAppBackendService r10 = r8._backend
            com.onesignal.core.internal.config.ConfigModelStore r2 = r8._configModelStore
            com.onesignal.common.modeling.Model r2 = r2.getModel()
            com.onesignal.core.internal.config.ConfigModel r2 = (com.onesignal.core.internal.config.ConfigModel) r2
            java.lang.String r2 = r2.getAppId()
            java.lang.String r5 = r9.getMessageId()
            com.onesignal.inAppMessages.internal.common.InAppHelper r6 = com.onesignal.inAppMessages.internal.common.InAppHelper.INSTANCE
            com.onesignal.core.internal.language.ILanguageContext r7 = r8._languageContext
            java.lang.String r6 = r6.variantIdForMessage(r9, r7)
            r0.L$0 = r8
            r0.L$1 = r9
            r0.label = r4
            java.lang.Object r10 = r10.getIAMData(r2, r5, r6, r0)
            if (r10 != r1) goto L69
            goto La4
        L69:
            r2 = r8
        L6a:
            com.onesignal.inAppMessages.internal.backend.GetIAMDataResponse r10 = (com.onesignal.inAppMessages.internal.backend.GetIAMDataResponse) r10
            com.onesignal.inAppMessages.internal.InAppMessageContent r4 = r10.getContent()
            r5 = 0
            if (r4 == 0) goto La8
            com.onesignal.inAppMessages.internal.InAppMessageContent r4 = r10.getContent()
            kotlin.jvm.internal.k.b(r4)
            java.lang.Double r4 = r4.getDisplayDuration()
            kotlin.jvm.internal.k.b(r4)
            double r6 = r4.doubleValue()
            r9.setDisplayDuration(r6)
            com.onesignal.session.internal.influence.IInfluenceManager r4 = r2._influenceManager
            java.lang.String r6 = r9.getMessageId()
            r4.onInAppMessageDisplayed(r6)
            com.onesignal.inAppMessages.internal.InAppMessageContent r10 = r10.getContent()
            kotlin.jvm.internal.k.b(r10)
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r9 = r2.showMessageContent(r9, r10, r0)
            if (r9 != r1) goto La5
        La4:
            return r1
        La5:
            java.lang.Boolean r9 = java.lang.Boolean.TRUE
            return r9
        La8:
            boolean r9 = r10.getShouldRetry()
            if (r9 == 0) goto Laf
            return r5
        Laf:
            java.lang.Boolean r9 = java.lang.Boolean.FALSE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer.displayMessage(com.onesignal.inAppMessages.internal.InAppMessage, v5.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0086, code lost:
    
        if (r2.showMessageContent(r8, r9, r0) == r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.onesignal.inAppMessages.internal.display.IInAppDisplayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object displayPreviewMessage(java.lang.String r8, v5.c<? super java.lang.Boolean> r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer.C27321
            if (r0 == 0) goto L13
            r0 = r9
            com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$displayPreviewMessage$1 r0 = (com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer.C27321) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$displayPreviewMessage$1 r0 = new com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$displayPreviewMessage$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            r2.q.z0(r9)
            goto L89
        L2a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L32:
            java.lang.Object r8 = r0.L$1
            com.onesignal.inAppMessages.internal.InAppMessage r8 = (com.onesignal.inAppMessages.internal.InAppMessage) r8
            java.lang.Object r2 = r0.L$0
            com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer r2 = (com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer) r2
            r2.q.z0(r9)
            goto L67
        L3e:
            r2.q.z0(r9)
            com.onesignal.inAppMessages.internal.InAppMessage r9 = new com.onesignal.inAppMessages.internal.InAppMessage
            com.onesignal.core.internal.time.ITime r2 = r7._time
            r9.<init>(r4, r2)
            com.onesignal.inAppMessages.internal.backend.IInAppBackendService r2 = r7._backend
            com.onesignal.core.internal.config.ConfigModelStore r5 = r7._configModelStore
            com.onesignal.common.modeling.Model r5 = r5.getModel()
            com.onesignal.core.internal.config.ConfigModel r5 = (com.onesignal.core.internal.config.ConfigModel) r5
            java.lang.String r5 = r5.getAppId()
            r0.L$0 = r7
            r0.L$1 = r9
            r0.label = r4
            java.lang.Object r8 = r2.getIAMPreviewData(r5, r8, r0)
            if (r8 != r1) goto L63
            goto L88
        L63:
            r2 = r9
            r9 = r8
            r8 = r2
            r2 = r7
        L67:
            com.onesignal.inAppMessages.internal.InAppMessageContent r9 = (com.onesignal.inAppMessages.internal.InAppMessageContent) r9
            if (r9 != 0) goto L6d
            r4 = 0
            goto L89
        L6d:
            java.lang.Double r5 = r9.getDisplayDuration()
            kotlin.jvm.internal.k.b(r5)
            double r5 = r5.doubleValue()
            r8.setDisplayDuration(r5)
            r5 = 0
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r8 = r2.showMessageContent(r8, r9, r0)
            if (r8 != r1) goto L89
        L88:
            return r1
        L89:
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r4)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer.displayPreviewMessage(java.lang.String, v5.c):java.lang.Object");
    }
}
