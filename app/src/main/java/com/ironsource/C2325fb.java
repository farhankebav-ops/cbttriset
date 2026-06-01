package com.ironsource;

import android.app.Activity;
import com.ironsource.C2271cb;
import com.ironsource.mediationsdk.logger.IronLog;
import com.unity3d.mediation.LevelPlay;
import com.unity3d.mediation.interstitial.LevelPlayInterstitialAdListener;

/* JADX INFO: renamed from: com.ironsource.fb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2325fb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final L7 f8530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C2271cb f8531b;

    /* JADX INFO: renamed from: com.ironsource.fb$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a implements InterfaceC2612w0 {
        public a() {
        }

        @Override // com.ironsource.InterfaceC2612w0
        public AbstractC2595v0 a(boolean z2, C2314f0 adProperties) {
            kotlin.jvm.internal.k.e(adProperties, "adProperties");
            return D9.f6605z.a(adProperties, C2325fb.this.f8530a.e().a(), z2);
        }
    }

    public C2325fb(String adUnitId, C2271cb.b config, C2459n0 adTools, C2374i6 adControllerFactory, L7 provider, InterfaceC2565t4 currentTimeProvider, C2670z7 idFactory) {
        kotlin.jvm.internal.k.e(adUnitId, "adUnitId");
        kotlin.jvm.internal.k.e(config, "config");
        kotlin.jvm.internal.k.e(adTools, "adTools");
        kotlin.jvm.internal.k.e(adControllerFactory, "adControllerFactory");
        kotlin.jvm.internal.k.e(provider, "provider");
        kotlin.jvm.internal.k.e(currentTimeProvider, "currentTimeProvider");
        kotlin.jvm.internal.k.e(idFactory, "idFactory");
        this.f8530a = provider;
        this.f8531b = new C2271cb(LevelPlay.AdFormat.INTERSTITIAL, adUnitId, config, adTools, adControllerFactory, a(), provider, currentTimeProvider, idFactory);
    }

    public final String b() {
        String string = this.f8531b.e().toString();
        kotlin.jvm.internal.k.d(string, "fullScreenAdInternal.adId.toString()");
        return string;
    }

    public final boolean c() {
        IronLog.API.info("LevelPlayInterstitialAd.isAdReady()");
        return this.f8531b.m();
    }

    public final void d() {
        IronLog.API.info("LevelPlayInterstitialAd.loadAd()");
        this.f8531b.n();
    }

    public final void a(LevelPlayInterstitialAdListener levelPlayInterstitialAdListener) {
        IronLog.API.info("LevelPlayInterstitialAd.setListener()");
        this.f8531b.a(levelPlayInterstitialAdListener != null ? C2343gb.b(levelPlayInterstitialAdListener) : null);
    }

    public final void a(Activity activity, String str) {
        kotlin.jvm.internal.k.e(activity, "activity");
        IronLog.API.info("LevelPlayInterstitialAd.showAd() placementName: " + str);
        this.f8531b.a(activity, str);
    }

    private final InterfaceC2612w0 a() {
        return new a();
    }
}
