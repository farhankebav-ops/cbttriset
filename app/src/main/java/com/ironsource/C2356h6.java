package com.ironsource;

import android.app.Activity;
import com.ironsource.InterfaceC2652y6;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import com.unity3d.mediation.rewarded.LevelPlayReward;

/* JADX INFO: renamed from: com.ironsource.h6, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2356h6 extends AbstractC2438m implements InterfaceC2618w6, InterfaceC2635x6 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InterfaceC2391j6 f8642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final C2314f0 f8643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final InterfaceC2652y6 f8644d;

    public /* synthetic */ C2356h6(InterfaceC2391j6 interfaceC2391j6, C2459n0 c2459n0, C2314f0 c2314f0, InterfaceC2652y6.b bVar, InterfaceC2584u6 interfaceC2584u6, int i2, kotlin.jvm.internal.f fVar) {
        this(interfaceC2391j6, c2459n0, c2314f0, (i2 & 8) != 0 ? new InterfaceC2652y6.b() : bVar, interfaceC2584u6);
    }

    public final void a(Activity activity, C2434ld c2434ld) {
        kotlin.jvm.internal.k.e(activity, "activity");
        this.f8643c.a(c2434ld);
        this.f8644d.a(activity);
    }

    @Override // com.ironsource.InterfaceC2635x6
    public void b(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f8642b.onAdLoaded(adInfo);
    }

    @Override // com.ironsource.InterfaceC2635x6
    public void c(IronSourceError ironSourceError) {
        InterfaceC2391j6 interfaceC2391j6 = this.f8642b;
        String string = this.f8643c.b().toString();
        kotlin.jvm.internal.k.d(string, "adProperties.adId.toString()");
        interfaceC2391j6.a(new LevelPlayAdError(ironSourceError, string, this.f8643c.c()));
    }

    @Override // com.ironsource.J0
    public void g() {
        this.f8642b.onAdClicked();
    }

    @Override // com.ironsource.InterfaceC2635x6
    public void onAdInfoChanged(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f8642b.onAdInfoChanged(adInfo);
    }

    @Override // com.ironsource.InterfaceC2618w6
    public void onClosed() {
        this.f8642b.onAdClosed();
    }

    public final void p() {
        this.f8644d.loadAd();
    }

    public C2356h6(InterfaceC2391j6 listener, C2459n0 adTools, C2314f0 adProperties, InterfaceC2652y6.b adUnitStrategyFactory, InterfaceC2584u6 fullscreenAdUnitFactory) {
        kotlin.jvm.internal.k.e(listener, "listener");
        kotlin.jvm.internal.k.e(adTools, "adTools");
        kotlin.jvm.internal.k.e(adProperties, "adProperties");
        kotlin.jvm.internal.k.e(adUnitStrategyFactory, "adUnitStrategyFactory");
        kotlin.jvm.internal.k.e(fullscreenAdUnitFactory, "fullscreenAdUnitFactory");
        this.f8642b = listener;
        this.f8643c = adProperties;
        this.f8644d = adUnitStrategyFactory.a(adTools, adTools.b(adProperties.e(), adProperties.c()), fullscreenAdUnitFactory, this, this);
    }

    @Override // com.ironsource.InterfaceC2635x6
    public void a(IronSourceError ironSourceError) {
        InterfaceC2391j6 interfaceC2391j6 = this.f8642b;
        String string = this.f8643c.b().toString();
        kotlin.jvm.internal.k.d(string, "adProperties.adId.toString()");
        interfaceC2391j6.onAdLoadFailed(new LevelPlayAdError(ironSourceError, string, this.f8643c.c()));
    }

    @Override // com.ironsource.InterfaceC2635x6
    public void a(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f8642b.onAdDisplayed(adInfo);
    }

    @Override // com.ironsource.InterfaceC2618w6
    public void a(LevelPlayReward reward) {
        kotlin.jvm.internal.k.e(reward, "reward");
        this.f8642b.a(reward);
    }

    @Override // com.ironsource.InterfaceC2635x6
    public void a() {
        this.f8642b.a();
    }
}
