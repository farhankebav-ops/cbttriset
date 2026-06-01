package com.ironsource;

import android.webkit.JavascriptInterface;
import com.unity3d.mediation.LevelPlay;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Ff {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2678zf f6773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Gf f6774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final V8 f6775c;

    public Ff(C2678zf adsManager, V8 uiLifeCycleListener, Gf javaScriptEvaluator) {
        kotlin.jvm.internal.k.e(adsManager, "adsManager");
        kotlin.jvm.internal.k.e(uiLifeCycleListener, "uiLifeCycleListener");
        kotlin.jvm.internal.k.e(javaScriptEvaluator, "javaScriptEvaluator");
        this.f6773a = adsManager;
        this.f6774b = javaScriptEvaluator;
        this.f6775c = uiLifeCycleListener;
    }

    private final void a(String str, LevelPlay.AdFormat adFormat, List<? extends Object> list) {
        this.f6774b.a(str, adFormat, list);
    }

    @JavascriptInterface
    public final void addBannerAdToScreen(double d8) {
        this.f6773a.a(d8);
    }

    @JavascriptInterface
    public final void closeTestSuite() {
        destroyBannerAd();
        this.f6775c.onClosed();
    }

    @JavascriptInterface
    public final void destroyBannerAd() {
        this.f6773a.a();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @JavascriptInterface
    public final void isInterstitialReady() {
        a("isInterstitialReady", LevelPlay.AdFormat.INTERSTITIAL, Pf.f7396a.a(Boolean.valueOf(this.f6773a.c())));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @JavascriptInterface
    public final void isRewardedVideoReady() {
        a("isRewardedVideoReady", LevelPlay.AdFormat.REWARDED, Pf.f7396a.a(Boolean.valueOf(this.f6773a.d())));
    }

    @JavascriptInterface
    public final void loadBannerAd(String adNetwork, boolean z2, boolean z7, String description, int i2, int i8) {
        kotlin.jvm.internal.k.e(adNetwork, "adNetwork");
        kotlin.jvm.internal.k.e(description, "description");
        loadBannerAd(null, adNetwork, z2, z7, description, i2, i8);
    }

    @JavascriptInterface
    public final void loadInterstitialAd(String adNetwork, boolean z2, boolean z7) {
        kotlin.jvm.internal.k.e(adNetwork, "adNetwork");
        loadInterstitialAd(null, adNetwork, z2, z7);
    }

    @JavascriptInterface
    public final void loadRewardedVideoAd(String adNetwork, boolean z2, boolean z7) {
        kotlin.jvm.internal.k.e(adNetwork, "adNetwork");
        loadRewardedVideoAd(null, adNetwork, z2, z7);
    }

    @JavascriptInterface
    public final void onDataLoaded() {
        this.f6775c.onUIReady();
    }

    @JavascriptInterface
    public final void showInterstitialAd() {
        this.f6773a.e();
    }

    @JavascriptInterface
    public final void showRewardedVideoAd() {
        this.f6773a.f();
    }

    @JavascriptInterface
    public final void loadBannerAd(String str, String adNetwork, boolean z2, boolean z7, String description, int i2, int i8) {
        kotlin.jvm.internal.k.e(adNetwork, "adNetwork");
        kotlin.jvm.internal.k.e(description, "description");
        this.f6773a.a(new Hf(adNetwork, z2, Boolean.valueOf(z7), str), description, i2, i8);
    }

    @JavascriptInterface
    public final void loadInterstitialAd(String str, String adNetwork, boolean z2, boolean z7) {
        kotlin.jvm.internal.k.e(adNetwork, "adNetwork");
        this.f6773a.a(new Hf(adNetwork, z2, Boolean.valueOf(z7), str));
    }

    @JavascriptInterface
    public final void loadRewardedVideoAd(String str, String adNetwork, boolean z2, boolean z7) {
        kotlin.jvm.internal.k.e(adNetwork, "adNetwork");
        this.f6773a.b(new Hf(adNetwork, z2, Boolean.valueOf(z7), str));
    }
}
