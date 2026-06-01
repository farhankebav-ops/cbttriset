package com.ironsource;

import android.app.Activity;
import com.ironsource.C2271cb;
import com.ironsource.mediationsdk.logger.IronLog;
import com.unity3d.mediation.LevelPlay;
import com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener;

/* JADX INFO: renamed from: com.ironsource.qb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2522qb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2271cb f9707a;

    /* JADX INFO: renamed from: com.ironsource.qb$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a implements InterfaceC2612w0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ L7 f9708a;

        public a(L7 l72) {
            this.f9708a = l72;
        }

        @Override // com.ironsource.InterfaceC2612w0
        public AbstractC2595v0 a(boolean z2, C2314f0 adProperties) {
            kotlin.jvm.internal.k.e(adProperties, "adProperties");
            return Td.f7636z.a(adProperties, this.f9708a.e().a(), z2);
        }
    }

    public C2522qb(String adUnitId, C2271cb.b config, C2459n0 adTools, C2374i6 adControllerFactory, L7 provider, InterfaceC2565t4 currentTimeProvider, C2670z7 idFactory) {
        kotlin.jvm.internal.k.e(adUnitId, "adUnitId");
        kotlin.jvm.internal.k.e(config, "config");
        kotlin.jvm.internal.k.e(adTools, "adTools");
        kotlin.jvm.internal.k.e(adControllerFactory, "adControllerFactory");
        kotlin.jvm.internal.k.e(provider, "provider");
        kotlin.jvm.internal.k.e(currentTimeProvider, "currentTimeProvider");
        kotlin.jvm.internal.k.e(idFactory, "idFactory");
        this.f9707a = new C2271cb(LevelPlay.AdFormat.REWARDED, adUnitId, config, adTools, adControllerFactory, a(provider), provider, currentTimeProvider, idFactory);
    }

    public final String a() {
        String string = this.f9707a.e().toString();
        kotlin.jvm.internal.k.d(string, "fullScreenAdInternal.adId.toString()");
        return string;
    }

    public final boolean b() {
        IronLog.API.info("LevelPlayRewardedAd.isAdReady()");
        return this.f9707a.m();
    }

    public final void c() {
        IronLog.API.info("LevelPlayRewardedAd.loadAd()");
        this.f9707a.n();
    }

    public final void a(Activity activity, String str) {
        kotlin.jvm.internal.k.e(activity, "activity");
        IronLog.API.info("LevelPlayRewardedAd.showAd() placementName: " + str);
        this.f9707a.a(activity, str);
    }

    public final void a(LevelPlayRewardedAdListener levelPlayRewardedAdListener) {
        IronLog.API.info("LevelPlayRewardedAd.setListener()");
        this.f9707a.a(levelPlayRewardedAdListener != null ? C2538rb.b(levelPlayRewardedAdListener) : null);
    }

    private final a a(L7 l72) {
        return new a(l72);
    }
}
