package com.ironsource;

import android.app.Activity;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdInfo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class A6 implements E6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2669z6 f6326a;

    public A6(C2669z6 strategy) {
        kotlin.jvm.internal.k.e(strategy, "strategy");
        this.f6326a = strategy;
    }

    @Override // com.ironsource.E6
    public void a(Activity activity) {
        kotlin.jvm.internal.k.e(activity, "activity");
        this.f6326a.a("show called before load success");
    }

    @Override // com.ironsource.E6
    public void b(C2567t6 adUnit, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f6326a.a("load success before load called");
    }

    @Override // com.ironsource.E6
    public void c(C2567t6 adUnit, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f6326a.a("load success with better ad before load called");
    }

    @Override // com.ironsource.E6
    public void loadAd() {
        C2567t6 c2567t6A = this.f6326a.b().a(true, this.f6326a.c());
        this.f6326a.a(new C6(this.f6326a, c2567t6A, true));
        c2567t6A.a(this.f6326a);
    }

    @Override // com.ironsource.E6
    public void a(C2567t6 adUnit) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        this.f6326a.a("ad expired before load called");
    }

    @Override // com.ironsource.E6
    public void b(C2567t6 adUnit, IronSourceError ironSourceError) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        this.f6326a.a("load failed before load called");
    }

    @Override // com.ironsource.E6
    public void a(C2567t6 adUnit, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f6326a.a("ad display success before load called");
    }

    @Override // com.ironsource.E6
    public void a(C2567t6 adUnit, IronSourceError ironSourceError) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        this.f6326a.a("ad display failed before load called");
    }
}
