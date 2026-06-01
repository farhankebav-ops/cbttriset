package com.vungle.ads.internal.presenter;

import android.content.Context;
import android.webkit.WebView;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.executor.Executors;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.Placement;
import com.vungle.ads.internal.platform.Platform;
import com.vungle.ads.internal.platform.WebViewUtil;
import com.vungle.ads.internal.presenter.WebViewManager;
import com.vungle.ads.internal.privacy.PrivacyManager;
import com.vungle.ads.internal.ui.VungleWebClient;
import com.vungle.ads.internal.util.Logger;
import kotlin.jvm.internal.l;
import q5.f;
import q5.g;
import q5.k;
import q5.x;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class WebViewManager$preloadWebView$1$1 extends l implements e6.a {
    final /* synthetic */ AdPayload $adv;
    final /* synthetic */ Context $context;
    final /* synthetic */ PreloadDelegate $delegate;
    final /* synthetic */ String $key;
    final /* synthetic */ Long $loadDuration;
    final /* synthetic */ Placement $placement;
    final /* synthetic */ String $templatePath;
    final /* synthetic */ AdPayload.WebViewSettings $webSettings;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewManager$preloadWebView$1$1(Context context, AdPayload adPayload, Placement placement, PreloadDelegate preloadDelegate, Long l, String str, String str2, AdPayload.WebViewSettings webViewSettings) {
        super(0);
        this.$context = context;
        this.$adv = adPayload;
        this.$placement = placement;
        this.$delegate = preloadDelegate;
        this.$loadDuration = l;
        this.$templatePath = str;
        this.$key = str2;
        this.$webSettings = webViewSettings;
    }

    /* JADX INFO: renamed from: invoke$lambda-3$lambda-1, reason: not valid java name */
    private static final Executors m3347invoke$lambda3$lambda1(f fVar) {
        return (Executors) fVar.getValue();
    }

    /* JADX INFO: renamed from: invoke$lambda-3$lambda-2, reason: not valid java name */
    private static final Platform m3348invoke$lambda3$lambda2(f fVar) {
        return (Platform) fVar.getValue();
    }

    @Override // e6.a
    public /* bridge */ /* synthetic */ Object invoke() {
        m3349invoke();
        return x.f13520a;
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
    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m3349invoke() {
        Object objM;
        WebViewManager webViewManager = WebViewManager.INSTANCE;
        Context context = this.$context;
        AdPayload adPayload = this.$adv;
        Placement placement = this.$placement;
        PreloadDelegate preloadDelegate = this.$delegate;
        Long l = this.$loadDuration;
        String str = this.$templatePath;
        String str2 = this.$key;
        AdPayload.WebViewSettings webViewSettings = this.$webSettings;
        try {
            WebView webView = new WebView(context.getApplicationContext());
            WebViewUtil.INSTANCE.applyWebSettings(webView, webViewSettings);
            ServiceLocator.Companion companion = ServiceLocator.Companion;
            g gVar = g.f13494a;
            VungleWebClient vungleWebClient = new VungleWebClient(adPayload, placement, m3347invoke$lambda3$lambda1(n7.b.B(gVar, new WebViewManager$preloadWebView$1$1$invoke$lambda3$$inlined$inject$1(context))).getOffloadExecutor(), m3348invoke$lambda3$lambda2(n7.b.B(gVar, new WebViewManager$preloadWebView$1$1$invoke$lambda3$$inlined$inject$2(context))), preloadDelegate, l);
            ConfigManager configManager = ConfigManager.INSTANCE;
            vungleWebClient.setConsentStatus(configManager.getGDPRIsCountryDataProtected() && "unknown".equals(PrivacyManager.INSTANCE.getConsentStatus()), configManager.getGDPRConsentTitle(), configManager.getGDPRConsentMessage(), configManager.getGDPRButtonAccept(), configManager.getGDPRButtonDeny());
            webView.setWebViewClient(vungleWebClient);
            webView.loadUrl(str);
            WebViewManager.webViewCache.put(String.valueOf(str2), new WebViewManager.WebViewEntry(webView, vungleWebClient));
            objM = Integer.valueOf(Logger.Companion.d("WebViewManager", "Preload complete. Cache size: " + WebViewManager.webViewCache.size()));
        } catch (Throwable th) {
            objM = q.M(th);
        }
        PreloadDelegate preloadDelegate2 = this.$delegate;
        Throwable thA = k.a(objM);
        if (thA != null) {
            Logger.Companion.e("WebViewManager", "Preload webview failed", thA);
            preloadDelegate2.onAdReadyToPlay();
        }
    }
}
