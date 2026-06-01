package com.ironsource;

import android.app.Activity;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdInfo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class J6 implements L6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final F6 f7000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C2567t6 f7001b;

    public J6(F6 strategy, C2567t6 adUnit) {
        kotlin.jvm.internal.k.e(strategy, "strategy");
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        this.f7000a = strategy;
        this.f7001b = adUnit;
    }

    @Override // com.ironsource.L6
    public void a(Activity activity) {
        kotlin.jvm.internal.k.e(activity, "activity");
        this.f7001b.a(activity, this.f7000a);
    }

    @Override // com.ironsource.L6
    public void b(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f7000a.d().onAdInfoChanged(adInfo);
    }

    @Override // com.ironsource.L6
    public void c(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f7000a.a("Ad unit is already loaded");
    }

    @Override // com.ironsource.L6
    public void loadAd() {
        F6 f62 = this.f7000a;
        f62.a(new G6(f62, null, false, 4, null));
        this.f7000a.loadAd();
    }

    @Override // com.ironsource.L6
    public void a(IronSourceError ironSourceError) {
        this.f7000a.a("load failed after ad unit is already loaded");
    }

    @Override // com.ironsource.L6
    public void c(IronSourceError ironSourceError) {
        if (!C2319f5.f8526a.a(ironSourceError)) {
            F6 f62 = this.f7000a;
            f62.a(new G6(f62, null, false, 4, null));
        }
        this.f7000a.d().c(ironSourceError);
    }

    @Override // com.ironsource.L6
    public void a() {
        F6 f62 = this.f7000a;
        f62.a(new G6(f62, null, true));
        this.f7000a.d().a();
    }

    @Override // com.ironsource.L6
    public void a(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f7000a.d().a(adInfo);
        C2567t6 c2567t6A = this.f7000a.b().a(false, this.f7000a.c());
        F6 f62 = this.f7000a;
        f62.a(new I6(f62, this.f7001b, c2567t6A));
        c2567t6A.a(this.f7000a);
    }
}
