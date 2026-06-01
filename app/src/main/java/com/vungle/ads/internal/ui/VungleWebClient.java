package com.vungle.ads.internal.ui;

import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.camera.camera2.interop.c;
import androidx.camera.core.w;
import androidx.webkit.ProxyConfig;
import com.bumptech.glide.load.Key;
import com.ironsource.C2300e4;
import com.ironsource.Q6;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.BuildConfig;
import com.vungle.ads.EvaluateJsError;
import com.vungle.ads.OneShotSingleValueMetric;
import com.vungle.ads.OutOfMemory;
import com.vungle.ads.SingleValueMetric;
import com.vungle.ads.internal.model.AdAsset;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.Placement;
import com.vungle.ads.internal.omsdk.WebViewObserver;
import com.vungle.ads.internal.platform.Platform;
import com.vungle.ads.internal.presenter.PreloadDelegate;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.ui.view.WebViewAPI;
import com.vungle.ads.internal.util.Logger;
import f7.h0;
import g7.b0;
import g7.n;
import g7.x;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import n7.b;
import q5.i;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class VungleWebClient extends WebViewClient implements WebViewAPI {
    private static final String COMMAND_COMPLETE = "window.vungle.mraidBridge.notifyCommandComplete()";
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "VungleWebClient";
    private final AdPayload advertisement;
    private boolean collectConsent;
    private final PreloadDelegate delegate;
    private WebViewAPI.WebClientErrorHandler errorHandler;
    private String gdprAccept;
    private String gdprBody;
    private String gdprDeny;
    private String gdprTitle;
    private final Handler handler;
    private Boolean isViewable;
    private final Long loadDuration;
    private WebView loadedWebView;
    private WebViewAPI.MraidDelegate mraidDelegate;
    private final ExecutorService offloadExecutor;
    private final OneShotSingleValueMetric partialDownloadErrorMetric;
    private final OneShotSingleValueMetric partialDownloadMetric;
    private final Placement placement;
    private final Platform platform;
    private boolean ready;
    private final SingleValueMetric skippedUrlMetric;
    private WebViewObserver webViewObserver;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresApi(29)
    public static final class VungleWebViewRenderProcessClient extends WebViewRenderProcessClient {
        private WebViewAPI.WebClientErrorHandler errorHandler;

        public VungleWebViewRenderProcessClient(WebViewAPI.WebClientErrorHandler webClientErrorHandler) {
            this.errorHandler = webClientErrorHandler;
        }

        public void onRenderProcessResponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
            k.e(webView, "webView");
        }

        public void onRenderProcessUnresponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
            k.e(webView, "webView");
            Logger.Companion companion = Logger.Companion;
            StringBuilder sb = new StringBuilder("onRenderProcessUnresponsive(Title = ");
            sb.append(webView.getTitle());
            sb.append(", URL = ");
            sb.append(webView.getOriginalUrl());
            sb.append(", (webViewRenderProcess != null) = ");
            sb.append(webViewRenderProcess != null);
            companion.w(VungleWebClient.TAG, sb.toString());
            WebViewAPI.WebClientErrorHandler webClientErrorHandler = this.errorHandler;
            if (webClientErrorHandler != null) {
                webClientErrorHandler.onRenderProcessUnresponsive(webView, webViewRenderProcess);
            }
        }
    }

    public /* synthetic */ VungleWebClient(AdPayload adPayload, Placement placement, ExecutorService executorService, Platform platform, PreloadDelegate preloadDelegate, Long l, int i2, f fVar) {
        this(adPayload, placement, executorService, (i2 & 8) != 0 ? null : platform, (i2 & 16) != 0 ? null : preloadDelegate, (i2 & 32) != 0 ? null : l);
    }

    private final void handleWebViewError(String str, String str2, boolean z2) {
        String str3 = str2 + ' ' + str;
        WebViewAPI.WebClientErrorHandler webClientErrorHandler = this.errorHandler;
        if (webClientErrorHandler != null) {
            webClientErrorHandler.onReceivedError(str3, z2);
        }
    }

    private final boolean isCriticalAsset(String str) {
        if (str.length() > 0) {
            return this.advertisement.isCriticalAsset(str);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: notifyPropertiesChange$lambda-25, reason: not valid java name */
    public static final void m3363notifyPropertiesChange$lambda25(boolean z2, VungleWebClient this$0) {
        k.e(this$0, "this$0");
        a4.a aVar = new a4.a(12);
        b.J(aVar, "placementType", this$0.advertisement.templateType());
        Boolean bool = this$0.isViewable;
        if (bool != null) {
            b.I(aVar, C2300e4.h.f8376o, bool);
        }
        b.J(aVar, Q6.F, "android");
        b.J(aVar, "osVersion", String.valueOf(Build.VERSION.SDK_INT));
        b.I(aVar, "incentivized", Boolean.valueOf(this$0.placement.isRewardedVideo()));
        Platform platform = this$0.platform;
        if (platform != null) {
            b.I(aVar, "isSilent", Boolean.valueOf(platform.isSilentModeEnabled()));
        }
        Long l = this$0.loadDuration;
        if (l != null) {
            aVar.l("timeLoaded", n.a(l));
        }
        if (this$0.collectConsent) {
            b.I(aVar, "consentRequired", Boolean.TRUE);
            b.J(aVar, "consentTitleText", this$0.gdprTitle);
            b.J(aVar, "consentBodyText", this$0.gdprBody);
            b.J(aVar, "consentAcceptButtonText", this$0.gdprAccept);
            b.J(aVar, "consentDenyButtonText", this$0.gdprDeny);
        } else {
            b.I(aVar, "consentRequired", Boolean.FALSE);
        }
        b.J(aVar, "sdkVersion", BuildConfig.VERSION_NAME);
        this$0.handler.post(new com.unity3d.services.ads.operation.show.b(7, this$0, "window.vungle.mraidBridge.notifyPropertiesChange(" + new x((LinkedHashMap) aVar.f3216b) + ',' + z2 + ')'));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: notifyPropertiesChange$lambda-25$lambda-24, reason: not valid java name */
    public static final void m3364notifyPropertiesChange$lambda25$lambda24(VungleWebClient this$0, String injectJs) {
        k.e(this$0, "this$0");
        k.e(injectJs, "$injectJs");
        WebView webView = this$0.loadedWebView;
        if (webView != null) {
            this$0.runJavascriptOnWebView(webView, injectJs);
        }
    }

    private final void runJavascriptOnWebView(WebView webView, String str) {
        try {
            Logger.Companion.w(TAG, "mraid Injecting JS " + str);
            if (webView != null) {
                webView.evaluateJavascript(str, null);
            }
        } catch (Throwable th) {
            new EvaluateJsError("Evaluate js failed " + th.getLocalizedMessage()).setLogEntry$vungle_ads_release(this.advertisement.getLogEntry$vungle_ads_release()).logErrorNoReturnValue$vungle_ads_release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: shouldOverrideUrlLoading$lambda-16$lambda-10, reason: not valid java name */
    public static final void m3365shouldOverrideUrlLoading$lambda16$lambda10(VungleWebClient this$0, WebView webView) {
        k.e(this$0, "this$0");
        PreloadDelegate preloadDelegate = this$0.delegate;
        if (preloadDelegate != null) {
            preloadDelegate.onAdFailedToPlay();
        }
        this$0.handler.post(new a(this$0, webView, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: shouldOverrideUrlLoading$lambda-16$lambda-10$lambda-9, reason: not valid java name */
    public static final void m3366shouldOverrideUrlLoading$lambda16$lambda10$lambda9(VungleWebClient this$0, WebView webView) {
        k.e(this$0, "this$0");
        this$0.runJavascriptOnWebView(webView, COMMAND_COMPLETE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: shouldOverrideUrlLoading$lambda-16$lambda-11, reason: not valid java name */
    public static final void m3367shouldOverrideUrlLoading$lambda16$lambda11(VungleWebClient this$0, WebView webView) {
        k.e(this$0, "this$0");
        this$0.runJavascriptOnWebView(webView, COMMAND_COMPLETE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: shouldOverrideUrlLoading$lambda-16$lambda-15$lambda-14, reason: not valid java name */
    public static final void m3368shouldOverrideUrlLoading$lambda16$lambda15$lambda14(WebViewAPI.MraidDelegate it, String command, x args, VungleWebClient this$0, WebView webView) {
        k.e(it, "$it");
        k.e(command, "$command");
        k.e(args, "$args");
        k.e(this$0, "this$0");
        if (it.processCommand(command, args)) {
            this$0.handler.post(new a(this$0, webView, 3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: shouldOverrideUrlLoading$lambda-16$lambda-15$lambda-14$lambda-13, reason: not valid java name */
    public static final void m3369shouldOverrideUrlLoading$lambda16$lambda15$lambda14$lambda13(VungleWebClient this$0, WebView webView) {
        k.e(this$0, "this$0");
        this$0.runJavascriptOnWebView(webView, COMMAND_COMPLETE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: shouldOverrideUrlLoading$lambda-16$lambda-6, reason: not valid java name */
    public static final void m3370shouldOverrideUrlLoading$lambda16$lambda6(VungleWebClient this$0, WebView webView) {
        k.e(this$0, "this$0");
        this$0.handler.post(new com.vungle.ads.b(this$0, webView, "window.vungle.mraidBridge.notifyReadyEvent(" + this$0.advertisement.createMRAIDArgs() + ')'));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: shouldOverrideUrlLoading$lambda-16$lambda-6$lambda-5, reason: not valid java name */
    public static final void m3371shouldOverrideUrlLoading$lambda16$lambda6$lambda5(VungleWebClient this$0, WebView webView, String injectJs) {
        k.e(this$0, "this$0");
        k.e(injectJs, "$injectJs");
        this$0.runJavascriptOnWebView(webView, injectJs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: shouldOverrideUrlLoading$lambda-16$lambda-8, reason: not valid java name */
    public static final void m3372shouldOverrideUrlLoading$lambda16$lambda8(VungleWebClient this$0, WebView webView) {
        k.e(this$0, "this$0");
        PreloadDelegate preloadDelegate = this$0.delegate;
        if (preloadDelegate != null) {
            preloadDelegate.onAdReadyToPlay();
        }
        this$0.handler.post(new a(this$0, webView, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: shouldOverrideUrlLoading$lambda-16$lambda-8$lambda-7, reason: not valid java name */
    public static final void m3373shouldOverrideUrlLoading$lambda16$lambda8$lambda7(VungleWebClient this$0, WebView webView) {
        k.e(this$0, "this$0");
        this$0.runJavascriptOnWebView(webView, COMMAND_COMPLETE);
    }

    public final boolean getCollectConsent$vungle_ads_release() {
        return this.collectConsent;
    }

    public final WebViewAPI.WebClientErrorHandler getErrorHandler$vungle_ads_release() {
        return this.errorHandler;
    }

    public final String getGdprAccept$vungle_ads_release() {
        return this.gdprAccept;
    }

    public final String getGdprBody$vungle_ads_release() {
        return this.gdprBody;
    }

    public final String getGdprDeny$vungle_ads_release() {
        return this.gdprDeny;
    }

    public final String getGdprTitle$vungle_ads_release() {
        return this.gdprTitle;
    }

    public final Handler getHandler$vungle_ads_release() {
        return this.handler;
    }

    public final WebView getLoadedWebView$vungle_ads_release() {
        return this.loadedWebView;
    }

    public final WebViewAPI.MraidDelegate getMraidDelegate$vungle_ads_release() {
        return this.mraidDelegate;
    }

    public final boolean getReady$vungle_ads_release() {
        return this.ready;
    }

    public final WebViewObserver getWebViewObserver$vungle_ads_release() {
        return this.webViewObserver;
    }

    public final Boolean isViewable$vungle_ads_release() {
        return this.isViewable;
    }

    public final void notifyDiskAvailableSize(long j, long j3) {
        WebView webView = this.loadedWebView;
        if (webView != null) {
            runJavascriptOnWebView(webView, "window.vungle.mraidBridgeExt.notifyAvailableDiskSpace(" + j + '-' + j3 + ')');
        }
    }

    @Override // com.vungle.ads.internal.ui.view.WebViewAPI
    public void notifyPropertiesChange(boolean z2) {
        this.offloadExecutor.submit(new c(z2, this));
    }

    public final void notifySilentModeChange(boolean z2) {
        WebView webView = this.loadedWebView;
        if (webView != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Boolean boolValueOf = Boolean.valueOf(z2);
            h0 h0Var = n.f11618a;
            runJavascriptOnWebView(webView, "window.vungle.mraidBridge.notifyPropertiesChange(" + new x(linkedHashMap) + ')');
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        Logger.Companion.w(TAG, "onPageFinished.");
        if (webView == null) {
            return;
        }
        this.loadedWebView = webView;
        webView.setVisibility(0);
        notifyPropertiesChange(true);
        if (Build.VERSION.SDK_INT >= 29) {
            webView.setWebViewRenderProcessClient(new VungleWebViewRenderProcessClient(this.errorHandler));
        }
        WebViewObserver webViewObserver = this.webViewObserver;
        if (webViewObserver != null) {
            webViewObserver.onPageFinished(webView);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i2, String description, String failingUrl) {
        k.e(description, "description");
        k.e(failingUrl, "failingUrl");
        super.onReceivedError(webView, i2, description, failingUrl);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        String strValueOf = String.valueOf(webResourceResponse != null ? Integer.valueOf(webResourceResponse.getStatusCode()) : null);
        String strValueOf2 = String.valueOf(webResourceRequest != null ? webResourceRequest.getUrl() : null);
        boolean z2 = false;
        boolean z7 = webResourceRequest != null && webResourceRequest.isForMainFrame();
        Logger.Companion.e(TAG, "Http Error desc " + strValueOf + ' ' + z7 + " for URL " + strValueOf2);
        if (isCriticalAsset(strValueOf2) && z7) {
            z2 = true;
        }
        handleWebViewError(strValueOf, strValueOf2, z2);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        this.loadedWebView = null;
        if (Build.VERSION.SDK_INT < 26) {
            Logger.Companion companion = Logger.Companion;
            StringBuilder sb = new StringBuilder("onRenderProcessGone url: ");
            sb.append(webView != null ? webView.getUrl() : null);
            companion.w(TAG, sb.toString());
            WebViewAPI.WebClientErrorHandler webClientErrorHandler = this.errorHandler;
            if (webClientErrorHandler != null) {
                return webClientErrorHandler.onWebRenderingProcessGone(webView, Boolean.TRUE);
            }
            return true;
        }
        Logger.Companion companion2 = Logger.Companion;
        StringBuilder sb2 = new StringBuilder("onRenderProcessGone url: ");
        sb2.append(webView != null ? webView.getUrl() : null);
        sb2.append(", did crash: ");
        sb2.append(renderProcessGoneDetail != null ? Boolean.valueOf(renderProcessGoneDetail.didCrash()) : null);
        companion2.w(TAG, sb2.toString());
        WebViewAPI.WebClientErrorHandler webClientErrorHandler2 = this.errorHandler;
        if (webClientErrorHandler2 != null) {
            return webClientErrorHandler2.onWebRenderingProcessGone(webView, renderProcessGoneDetail != null ? Boolean.valueOf(renderProcessGoneDetail.didCrash()) : null);
        }
        return super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0056 A[Catch: all -> 0x002f, TRY_LEAVE, TryCatch #0 {all -> 0x002f, blocks: (B:5:0x000c, B:7:0x0013, B:9:0x002a, B:13:0x0032, B:15:0x003a, B:20:0x0046, B:21:0x0050, B:22:0x0056), top: B:31:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final q5.i parseRange$vungle_ads_release(java.lang.String r7, long r8) {
        /*
            r6 = this;
            java.lang.String r0 = "bytes="
            r1 = 0
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            r2 = 0
            if (r7 == 0) goto L56
            r3 = 0
            boolean r4 = n6.t.n0(r7, r0, r3)     // Catch: java.lang.Throwable -> L2f
            r5 = 1
            if (r4 != r5) goto L56
            java.lang.String r7 = n6.m.F0(r7, r0)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r0 = "-"
            java.lang.String[] r0 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L2f
            r4 = 6
            java.util.List r7 = n6.m.K0(r7, r0, r4)     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r0 = r5.l.Z0(r3, r7)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L2f
            if (r0 == 0) goto L31
            java.lang.Long r0 = n6.t.p0(r0)     // Catch: java.lang.Throwable -> L2f
            goto L32
        L2f:
            r7 = move-exception
            goto L5c
        L31:
            r0 = r2
        L32:
            java.lang.Object r7 = r5.l.Z0(r5, r7)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Throwable -> L2f
            if (r7 == 0) goto L3f
            java.lang.Long r7 = n6.t.p0(r7)     // Catch: java.lang.Throwable -> L2f
            goto L40
        L3f:
            r7 = r2
        L40:
            if (r0 != 0) goto L50
            if (r7 != 0) goto L46
            r0 = r1
            goto L50
        L46:
            long r3 = r7.longValue()     // Catch: java.lang.Throwable -> L2f
            long r8 = r8 - r3
            java.lang.Long r0 = java.lang.Long.valueOf(r8)     // Catch: java.lang.Throwable -> L2f
            r7 = r2
        L50:
            q5.i r8 = new q5.i     // Catch: java.lang.Throwable -> L2f
            r8.<init>(r0, r7)     // Catch: java.lang.Throwable -> L2f
            goto L60
        L56:
            q5.i r8 = new q5.i     // Catch: java.lang.Throwable -> L2f
            r8.<init>(r1, r2)     // Catch: java.lang.Throwable -> L2f
            goto L60
        L5c:
            q5.j r8 = r2.q.M(r7)
        L60:
            java.lang.Throwable r7 = q5.k.a(r8)
            if (r7 != 0) goto L67
            goto L6c
        L67:
            q5.i r8 = new q5.i
            r8.<init>(r1, r2)
        L6c:
            q5.i r8 = (q5.i) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.ui.VungleWebClient.parseRange$vungle_ads_release(java.lang.String, long):q5.i");
    }

    @Override // com.vungle.ads.internal.ui.view.WebViewAPI
    public void setAdVisibility(boolean z2) {
        this.isViewable = Boolean.valueOf(z2);
        notifyPropertiesChange(false);
    }

    public final void setCollectConsent$vungle_ads_release(boolean z2) {
        this.collectConsent = z2;
    }

    @Override // com.vungle.ads.internal.ui.view.WebViewAPI
    public void setConsentStatus(boolean z2, String str, String str2, String str3, String str4) {
        this.collectConsent = z2;
        this.gdprTitle = str;
        this.gdprBody = str2;
        this.gdprAccept = str3;
        this.gdprDeny = str4;
    }

    @Override // com.vungle.ads.internal.ui.view.WebViewAPI
    public void setErrorHandler(WebViewAPI.WebClientErrorHandler errorHandler) {
        k.e(errorHandler, "errorHandler");
        this.errorHandler = errorHandler;
    }

    public final void setErrorHandler$vungle_ads_release(WebViewAPI.WebClientErrorHandler webClientErrorHandler) {
        this.errorHandler = webClientErrorHandler;
    }

    public final void setGdprAccept$vungle_ads_release(String str) {
        this.gdprAccept = str;
    }

    public final void setGdprBody$vungle_ads_release(String str) {
        this.gdprBody = str;
    }

    public final void setGdprDeny$vungle_ads_release(String str) {
        this.gdprDeny = str;
    }

    public final void setGdprTitle$vungle_ads_release(String str) {
        this.gdprTitle = str;
    }

    public final void setLoadedWebView$vungle_ads_release(WebView webView) {
        this.loadedWebView = webView;
    }

    @Override // com.vungle.ads.internal.ui.view.WebViewAPI
    public void setMraidDelegate(WebViewAPI.MraidDelegate mraidDelegate) {
        this.mraidDelegate = mraidDelegate;
    }

    public final void setMraidDelegate$vungle_ads_release(WebViewAPI.MraidDelegate mraidDelegate) {
        this.mraidDelegate = mraidDelegate;
    }

    public final void setReady$vungle_ads_release(boolean z2) {
        this.ready = z2;
    }

    public final void setViewable$vungle_ads_release(Boolean bool) {
        this.isViewable = bool;
    }

    @Override // com.vungle.ads.internal.ui.view.WebViewAPI
    public void setWebViewObserver(WebViewObserver webViewObserver) {
        this.webViewObserver = webViewObserver;
    }

    public final void setWebViewObserver$vungle_ads_release(WebViewObserver webViewObserver) {
        this.webViewObserver = webViewObserver;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        String scheme;
        long length;
        Uri url = webResourceRequest != null ? webResourceRequest.getUrl() : null;
        if (url != null && (scheme = url.getScheme()) != null) {
            Locale ROOT = Locale.ROOT;
            k.d(ROOT, "ROOT");
            String lowerCase = scheme.toLowerCase(ROOT);
            k.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (lowerCase.equals(ProxyConfig.MATCH_HTTP) || lowerCase.equals("https")) {
                if (!this.advertisement.isPartialDownloadEnabled()) {
                    Logger.Companion.w(TAG, "shouldInterceptRequest called but partial download is disabled.");
                    return null;
                }
                String string = url.toString();
                k.d(string, "uri.toString()");
                AdAsset localPartialDownloadAssets = this.advertisement.getLocalPartialDownloadAssets(string);
                String localPath = localPartialDownloadAssets != null ? localPartialDownloadAssets.getLocalPath() : null;
                if (localPath != null && localPath.length() != 0) {
                    File file = new File(localPath);
                    if (file.exists()) {
                        long contentLength = localPartialDownloadAssets.getContentLength();
                        if (contentLength > 0) {
                            long length2 = file.length();
                            String str = webResourceRequest.getRequestHeaders().get("Range");
                            this.partialDownloadMetric.setMeta(str + " cached:" + length2 + ' ' + string);
                            AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.partialDownloadMetric, this.advertisement.getLogEntry$vungle_ads_release(), (String) null, 4, (Object) null);
                            i range$vungle_ads_release = parseRange$vungle_ads_release(str, contentLength);
                            Object obj = range$vungle_ads_release.f13498a;
                            Object obj2 = range$vungle_ads_release.f13499b;
                            localPartialDownloadAssets.setRangeStart(((Number) obj).longValue());
                            Long l = (Long) obj2;
                            localPartialDownloadAssets.setRangeEnd(l);
                            long jLongValue = ((Number) range$vungle_ads_release.f13498a).longValue();
                            long j = length2 - jLongValue;
                            Logger.Companion companion = Logger.Companion;
                            StringBuilder sb = new StringBuilder(">>request: ");
                            sb.append(str);
                            sb.append(" rangeStart=");
                            sb.append(jLongValue);
                            sb.append(" rangeEnd=");
                            sb.append(l);
                            sb.append(" cachedFileLength=");
                            sb.append(length2);
                            androidx.camera.core.processing.util.a.y(sb, " availableBytes=", j, " contentLength=");
                            sb.append(contentLength);
                            sb.append(' ');
                            companion.i(TAG, sb.toString());
                            if (j <= 0) {
                                companion.w(TAG, "Requested range exceeds cached file: " + str);
                                localPartialDownloadAssets.waitForDownload();
                                length = file.length();
                            } else {
                                length = length2;
                            }
                            long jLongValue2 = l != null ? l.longValue() : length - 1;
                            long j3 = (jLongValue2 - jLongValue) + 1;
                            try {
                                FileInputStream fileInputStream = new FileInputStream(file);
                                WebResourceResponse webResourceResponse = new WebResourceResponse("video/mp4", Key.STRING_CHARSET_NAME, 206, "Partial Content", r5.x.f0(new i("Content-Type", "video/mp4"), new i("Accept-Ranges", "bytes"), new i("Content-Length", String.valueOf(j3)), new i("Content-Range", "bytes " + jLongValue + '-' + jLongValue2 + '/' + contentLength)), new BufferedInputStream(fileInputStream, 1024));
                                StringBuilder sb2 = new StringBuilder("<<Return:");
                                sb2.append(webResourceResponse.getResponseHeaders());
                                companion.i(TAG, sb2.toString());
                                return webResourceResponse;
                            } catch (Throwable th) {
                                Throwable thA = q5.k.a(q.M(th));
                                if (thA == null) {
                                    return null;
                                }
                                Logger.Companion.e(TAG, "Error serving local range video: " + thA.getMessage(), thA);
                                this.partialDownloadErrorMetric.setMeta(string + ' ' + thA.getMessage());
                                AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.partialDownloadErrorMetric, this.advertisement.getLogEntry$vungle_ads_release(), (String) null, 4, (Object) null);
                                return null;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Logger.Companion companion;
        String str2;
        try {
            companion = Logger.Companion;
            companion.d(TAG, "MRAID Command " + str);
        } catch (Throwable th) {
            if (th instanceof OutOfMemoryError) {
                new OutOfMemory(a1.a.l("mraid:", str)).logErrorNoReturnValue$vungle_ads_release();
            }
        }
        if (str != null && str.length() != 0) {
            Uri uri = Uri.parse(str);
            k.d(uri, "parse(this)");
            String scheme = uri.getScheme();
            if (scheme != null && scheme.length() != 0) {
                String scheme2 = uri.getScheme();
                if (!k.a(scheme2, "mraid")) {
                    str2 = "url: ";
                    if (!ProxyConfig.MATCH_HTTP.equalsIgnoreCase(scheme2)) {
                        if ("https".equalsIgnoreCase(scheme2)) {
                        }
                        this.skippedUrlMetric.setMeta(str2.concat(str));
                        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.skippedUrlMetric, this.advertisement.getLogEntry$vungle_ads_release(), (String) null, 4, (Object) null);
                        companion.w(TAG, "skipped url: ".concat(str));
                        return false;
                    }
                    companion.d(TAG, "Open URL".concat(str));
                    WebViewAPI.MraidDelegate mraidDelegate = this.mraidDelegate;
                    if (mraidDelegate != null) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        b0 element = n.b(str);
                        k.e(element, "element");
                        mraidDelegate.processCommand("openNonMraid", new x(linkedHashMap));
                    }
                    return true;
                }
                str2 = "url: ";
                String host = uri.getHost();
                if (host != null) {
                    int iHashCode = host.hashCode();
                    if (iHashCode != -1943542072) {
                        if (iHashCode != 88409791) {
                            if (iHashCode == 119543762 && host.equals("readyToPlay")) {
                                this.offloadExecutor.submit(new a(this, webView, 5));
                                return true;
                            }
                        } else if (host.equals("failToLoad")) {
                            this.offloadExecutor.submit(new a(this, webView, 6));
                            return true;
                        }
                    } else if (host.equals("propertiesChangeCompleted")) {
                        if (!this.ready) {
                            this.ready = true;
                            this.offloadExecutor.submit(new a(this, webView, 4));
                            return true;
                        }
                        return true;
                    }
                    WebViewAPI.MraidDelegate mraidDelegate2 = this.mraidDelegate;
                    if (mraidDelegate2 == null) {
                        this.handler.post(new a(this, webView, 0));
                        return true;
                    }
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    for (String param : uri.getQueryParameterNames()) {
                        k.d(param, "param");
                        b0 element2 = n.b(uri.getQueryParameter(param));
                        k.e(element2, "element");
                    }
                    this.offloadExecutor.submit(new w(mraidDelegate2, host, new x(linkedHashMap2), this, webView, 4));
                    return true;
                }
                this.skippedUrlMetric.setMeta(str2.concat(str));
                AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.skippedUrlMetric, this.advertisement.getLogEntry$vungle_ads_release(), (String) null, 4, (Object) null);
                companion.w(TAG, "skipped url: ".concat(str));
                return false;
            }
            return false;
        }
        companion.e(TAG, "Invalid URL ");
        return false;
    }

    public VungleWebClient(AdPayload advertisement, Placement placement, ExecutorService offloadExecutor, Platform platform, PreloadDelegate preloadDelegate, Long l) {
        k.e(advertisement, "advertisement");
        k.e(placement, "placement");
        k.e(offloadExecutor, "offloadExecutor");
        this.advertisement = advertisement;
        this.placement = placement;
        this.offloadExecutor = offloadExecutor;
        this.platform = platform;
        this.delegate = preloadDelegate;
        this.loadDuration = l;
        this.handler = new Handler(Looper.getMainLooper());
        Sdk.SDKMetric.SDKMetricType sDKMetricType = Sdk.SDKMetric.SDKMetricType.AD_PLAY_WITH_PARTIAL_DOWNLOAD_ASSET;
        this.partialDownloadMetric = new OneShotSingleValueMetric(sDKMetricType);
        this.partialDownloadErrorMetric = new OneShotSingleValueMetric(sDKMetricType);
        this.skippedUrlMetric = new SingleValueMetric(Sdk.SDKMetric.SDKMetricType.BANNER_AUTO_REDIRECT_NOT_OVERRIDE_URL);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        String strValueOf = String.valueOf(webResourceError != null ? webResourceError.getDescription() : null);
        String strValueOf2 = String.valueOf(webResourceRequest != null ? webResourceRequest.getUrl() : null);
        boolean z2 = false;
        boolean z7 = webResourceRequest != null && webResourceRequest.isForMainFrame();
        Logger.Companion.e(TAG, "Error desc " + strValueOf + ' ' + z7 + " for URL " + strValueOf2);
        if (isCriticalAsset(strValueOf2) && z7) {
            z2 = true;
        }
        handleWebViewError(strValueOf, strValueOf2, z2);
    }

    @VisibleForTesting
    public static /* synthetic */ void getCollectConsent$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getErrorHandler$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getGdprAccept$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getGdprBody$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getGdprDeny$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getGdprTitle$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getLoadedWebView$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getMraidDelegate$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getReady$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getWebViewObserver$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void isViewable$vungle_ads_release$annotations() {
    }
}
