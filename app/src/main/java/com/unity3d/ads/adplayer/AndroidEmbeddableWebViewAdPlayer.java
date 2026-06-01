package com.unity3d.ads.adplayer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.core.view.ViewCompat;
import com.unity3d.ads.core.data.datasource.LifecycleDataSource;
import com.unity3d.ads.core.data.manager.ScarManager;
import com.unity3d.ads.core.data.repository.OpenMeasurementRepository;
import com.unity3d.services.ads.offerwall.OfferwallEvent;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.BannerViewCache;
import com.unity3d.services.banners.UnityBannerSize;
import com.unity3d.services.banners.bridge.BannerBridge;
import com.unity3d.services.core.misc.ViewUtilities;
import com.vungle.ads.internal.protos.Sdk;
import e6.p;
import java.util.Map;
import kotlin.jvm.internal.k;
import q5.x;
import q6.a0;
import q6.c0;
import r2.q;
import t6.r0;
import t6.x0;
import w5.a;
import x5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidEmbeddableWebViewAdPlayer implements AdPlayer, EmbeddableAdPlayer {
    private final Context context;
    private final LifecycleDataSource lifecycleDataSource;
    private final OpenMeasurementRepository openMeasurementRepository;
    private final String opportunityId;
    private final ScarManager scarManager;
    private final WebViewAdPlayer webViewAdPlayer;
    private final AndroidWebViewContainer webViewContainer;

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer$destroy$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer", f = "AndroidEmbeddableWebViewAdPlayer.kt", l = {Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE, 128, Sdk.SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR_VALUE}, m = "destroy")
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
            return AndroidEmbeddableWebViewAdPlayer.this.destroy(this);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer$show$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer$show$2", f = "AndroidEmbeddableWebViewAdPlayer.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ BannerView $bannerView;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(BannerView bannerView, v5.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$bannerView = bannerView;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return AndroidEmbeddableWebViewAdPlayer.this.new AnonymousClass2(this.$bannerView, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            AndroidEmbeddableWebViewAdPlayer.this.getWebViewContainer().getWebView().setLayoutParams(new ViewGroup.LayoutParams((int) ViewUtilities.pxFromDp(AndroidEmbeddableWebViewAdPlayer.this.context, this.$bannerView.getSize().getWidth()), (int) ViewUtilities.pxFromDp(AndroidEmbeddableWebViewAdPlayer.this.context, this.$bannerView.getSize().getHeight())));
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, v5.c<? super x> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer$show$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer$show$4", f = "AndroidEmbeddableWebViewAdPlayer.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass4 extends i implements p {
        final /* synthetic */ BannerView $bannerView;
        int label;
        final /* synthetic */ AndroidEmbeddableWebViewAdPlayer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(BannerView bannerView, AndroidEmbeddableWebViewAdPlayer androidEmbeddableWebViewAdPlayer, v5.c<? super AnonymousClass4> cVar) {
            super(2, cVar);
            this.$bannerView = bannerView;
            this.this$0 = androidEmbeddableWebViewAdPlayer;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return new AnonymousClass4(this.$bannerView, this.this$0, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            this.$bannerView.addView(this.this$0.getWebViewContainer().getWebView());
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, v5.c<? super x> cVar) {
            return ((AnonymousClass4) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public AndroidEmbeddableWebViewAdPlayer(WebViewAdPlayer webViewAdPlayer, String opportunityId, AndroidWebViewContainer webViewContainer, OpenMeasurementRepository openMeasurementRepository, ScarManager scarManager, LifecycleDataSource lifecycleDataSource, Context context) {
        k.e(webViewAdPlayer, "webViewAdPlayer");
        k.e(opportunityId, "opportunityId");
        k.e(webViewContainer, "webViewContainer");
        k.e(openMeasurementRepository, "openMeasurementRepository");
        k.e(scarManager, "scarManager");
        k.e(lifecycleDataSource, "lifecycleDataSource");
        k.e(context, "context");
        this.webViewAdPlayer = webViewAdPlayer;
        this.opportunityId = opportunityId;
        this.webViewContainer = webViewContainer;
        this.openMeasurementRepository = openMeasurementRepository;
        this.scarManager = scarManager;
        this.lifecycleDataSource = lifecycleDataSource;
        this.context = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0065, code lost:
    
        if (q6.c0.k(1000, r0) == r1) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0081, code lost:
    
        if (com.unity3d.ads.adplayer.AdPlayer.DefaultImpls.destroy(r2, r0) != r1) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.unity3d.ads.adplayer.AdPlayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object destroy(v5.c<? super q5.x> r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer$destroy$1 r0 = (com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer$destroy$1 r0 = new com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer$destroy$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L45
            if (r2 == r5) goto L3d
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            r2.q.z0(r8)
            goto L84
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L35:
            java.lang.Object r2 = r0.L$0
            com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer r2 = (com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer) r2
            r2.q.z0(r8)
            goto L78
        L3d:
            java.lang.Object r2 = r0.L$0
            com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer r2 = (com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer) r2
            r2.q.z0(r8)
            goto L69
        L45:
            r2.q.z0(r8)
            com.unity3d.ads.adplayer.WebViewAdPlayer r8 = r7.webViewAdPlayer
            r8.dispatchShowCompleted()
            com.unity3d.ads.core.data.repository.OpenMeasurementRepository r8 = r7.openMeasurementRepository
            java.lang.String r2 = r7.opportunityId
            com.google.protobuf.ByteString r2 = com.google.protobuf.kotlin.ByteStringsKt.toByteStringUtf8(r2)
            boolean r8 = r8.hasSessionFinished(r2)
            if (r8 == 0) goto L68
            r0.L$0 = r7
            r0.label = r5
            r5 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r8 = q6.c0.k(r5, r0)
            if (r8 != r1) goto L68
            goto L83
        L68:
            r2 = r7
        L69:
            com.unity3d.ads.adplayer.AndroidWebViewContainer r8 = r2.getWebViewContainer()
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r8 = r8.destroy(r0)
            if (r8 != r1) goto L78
            goto L83
        L78:
            r8 = 0
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r8 = com.unity3d.ads.adplayer.AdPlayer.DefaultImpls.destroy(r2, r0)
            if (r8 != r1) goto L84
        L83:
            return r1
        L84:
            q5.x r8 = q5.x.f13520a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer.destroy(v5.c):java.lang.Object");
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public void dispatchShowCompleted() {
        this.webViewAdPlayer.dispatchShowCompleted();
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public t6.e getOnLoadEvent() {
        return this.webViewAdPlayer.getOnLoadEvent();
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public t6.e getOnOfferwallEvent() {
        return this.webViewAdPlayer.getOnOfferwallEvent();
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public t6.e getOnScarEvent() {
        return this.webViewAdPlayer.getOnScarEvent();
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public t6.e getOnShowEvent() {
        return this.webViewAdPlayer.getOnShowEvent();
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public a0 getScope() {
        return this.webViewAdPlayer.getScope();
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object onAllowedPiiChange(byte[] bArr, v5.c<? super x> cVar) {
        return this.webViewAdPlayer.onAllowedPiiChange(bArr, cVar);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object onBroadcastEvent(String str, v5.c<? super x> cVar) {
        return this.webViewAdPlayer.onBroadcastEvent(str, cVar);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object requestShow(Map<String, ? extends Object> map, v5.c<? super x> cVar) {
        return this.webViewAdPlayer.requestShow(map, cVar);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendActivityDestroyed(v5.c<? super x> cVar) {
        return this.webViewAdPlayer.sendActivityDestroyed(cVar);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendFocusChange(boolean z2, v5.c<? super x> cVar) {
        return this.webViewAdPlayer.sendFocusChange(z2, cVar);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendGmaEvent(com.unity3d.scar.adapter.common.c cVar, v5.c<? super x> cVar2) {
        return this.webViewAdPlayer.sendGmaEvent(cVar, cVar2);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendMuteChange(boolean z2, v5.c<? super x> cVar) {
        return this.webViewAdPlayer.sendMuteChange(z2, cVar);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendOfferwallEvent(OfferwallEvent offerwallEvent, v5.c<? super x> cVar) {
        return this.webViewAdPlayer.sendOfferwallEvent(offerwallEvent, cVar);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendPrivacyFsmChange(byte[] bArr, v5.c<? super x> cVar) {
        return this.webViewAdPlayer.sendPrivacyFsmChange(bArr, cVar);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendScarBannerEvent(BannerBridge.BannerEvent bannerEvent, v5.c<? super x> cVar) {
        return this.webViewAdPlayer.sendScarBannerEvent(bannerEvent, cVar);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendUserConsentChange(byte[] bArr, v5.c<? super x> cVar) {
        return this.webViewAdPlayer.sendUserConsentChange(bArr, cVar);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendVisibilityChange(boolean z2, v5.c<? super x> cVar) {
        return this.webViewAdPlayer.sendVisibilityChange(z2, cVar);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendVolumeChange(double d8, v5.c<? super x> cVar) {
        return this.webViewAdPlayer.sendVolumeChange(d8, cVar);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public void show(final ShowOptions showOptions) {
        k.e(showOptions, "showOptions");
        if (!(showOptions instanceof AndroidShowOptions)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        BannerViewCache bannerViewCache = BannerViewCache.getInstance();
        final BannerView bannerView = bannerViewCache.getBannerView(this.opportunityId);
        if (bannerView == null) {
            throw new IllegalStateException((bannerViewCache.isBannerViewDeleted(this.opportunityId) ? "BannerView has been deleted" : "BannerView not found").toString());
        }
        AndroidShowOptions androidShowOptions = (AndroidShowOptions) showOptions;
        if (!androidShowOptions.isScarAd()) {
            c0.u(c0.d(), null, new AnonymousClass2(bannerView, null), 3);
            final WebView webView = getWebViewContainer().getWebView();
            if (ViewCompat.isAttachedToWindow(webView)) {
                c0.u(this.webViewAdPlayer.getScope(), null, new AndroidEmbeddableWebViewAdPlayer$show$3$1(this, showOptions, null), 3);
                if (ViewCompat.isAttachedToWindow(webView)) {
                    webView.addOnAttachStateChangeListener(new AndroidEmbeddableWebViewAdPlayer$show$lambda$4$$inlined$doOnDetach$1(webView, this));
                } else {
                    c0.u(this.webViewAdPlayer.getScope(), null, new AndroidEmbeddableWebViewAdPlayer$show$3$2$1(this, null), 3);
                }
            } else {
                webView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer$show$$inlined$doOnAttach$2
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View view) {
                        k.e(view, "view");
                        webView.removeOnAttachStateChangeListener(this);
                        c0.u(this.webViewAdPlayer.getScope(), null, new AndroidEmbeddableWebViewAdPlayer$show$3$1(this, showOptions, null), 3);
                        if (ViewCompat.isAttachedToWindow(view)) {
                            view.addOnAttachStateChangeListener(new AndroidEmbeddableWebViewAdPlayer$show$lambda$4$$inlined$doOnDetach$1(view, this));
                        } else {
                            c0.u(this.webViewAdPlayer.getScope(), null, new AndroidEmbeddableWebViewAdPlayer$show$3$2$1(this, null), 3);
                        }
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view) {
                        k.e(view, "view");
                    }
                });
            }
            c0.u(c0.d(), null, new AnonymousClass4(bannerView, this, null), 3);
            return;
        }
        String placementId = androidShowOptions.getPlacementId();
        if (placementId == null) {
            placementId = "";
        }
        String scarQueryId = androidShowOptions.getScarQueryId();
        if (scarQueryId == null) {
            scarQueryId = "";
        }
        String scarAdUnitId = androidShowOptions.getScarAdUnitId();
        if (scarAdUnitId == null) {
            scarAdUnitId = "";
        }
        String scarAdString = androidShowOptions.getScarAdString();
        u3.c cVar = new u3.c(placementId, scarQueryId, scarAdUnitId, scarAdString == null ? "" : scarAdString, 0);
        ScarManager scarManager = this.scarManager;
        Context context = this.context;
        UnityBannerSize size = bannerView.getSize();
        k.d(size, "bannerView.size");
        final r0 r0VarP = x0.p(scarManager.loadBannerAd(context, bannerView, cVar, size, this.opportunityId), getScope(), 10);
        if (!ViewCompat.isAttachedToWindow(bannerView)) {
            bannerView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer$show$$inlined$doOnAttach$1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    k.e(view, "view");
                    bannerView.removeOnAttachStateChangeListener(this);
                    c0.u(this.getScope(), null, new AndroidEmbeddableWebViewAdPlayer$show$1$1(this, r0VarP, showOptions, null), 3);
                    BannerView bannerView2 = bannerView;
                    if (ViewCompat.isAttachedToWindow(bannerView2)) {
                        bannerView2.addOnAttachStateChangeListener(new AndroidEmbeddableWebViewAdPlayer$show$lambda$2$$inlined$doOnDetach$1(bannerView2, this));
                    } else {
                        c0.u(this.webViewAdPlayer.getScope(), null, new AndroidEmbeddableWebViewAdPlayer$show$1$2$1(this, null), 3);
                    }
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                    k.e(view, "view");
                }
            });
            return;
        }
        c0.u(getScope(), null, new AndroidEmbeddableWebViewAdPlayer$show$1$1(this, r0VarP, showOptions, null), 3);
        if (ViewCompat.isAttachedToWindow(bannerView)) {
            bannerView.addOnAttachStateChangeListener(new AndroidEmbeddableWebViewAdPlayer$show$lambda$2$$inlined$doOnDetach$1(bannerView, this));
        } else {
            c0.u(this.webViewAdPlayer.getScope(), null, new AndroidEmbeddableWebViewAdPlayer$show$1$2$1(this, null), 3);
        }
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public AndroidWebViewContainer getWebViewContainer() {
        return this.webViewContainer;
    }
}
