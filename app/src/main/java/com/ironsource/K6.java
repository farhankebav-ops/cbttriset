package com.ironsource;

import android.app.Activity;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class K6 implements L6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final F6 f7050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C2567t6 f7051b;

    public K6(F6 strategy, C2567t6 adUnit) {
        kotlin.jvm.internal.k.e(strategy, "strategy");
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        this.f7050a = strategy;
        this.f7051b = adUnit;
    }

    @Override // com.ironsource.L6
    public void a(Activity activity) {
        kotlin.jvm.internal.k.e(activity, "activity");
        this.f7050a.d().c(new IronSourceError(LevelPlayAdError.ERROR_CODE_SHOW_BEFORE_LOAD_SUCCESS_CALLBACK, "Show called before load success"));
    }

    @Override // com.ironsource.L6
    public void b(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f7050a.a("load success with better ad while loading");
    }

    @Override // com.ironsource.L6
    public void c(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        F6 f62 = this.f7050a;
        f62.a(new J6(f62, this.f7051b));
        this.f7050a.d().b(adInfo);
    }

    @Override // com.ironsource.L6
    public void loadAd() {
        this.f7050a.d().a(new IronSourceError(LevelPlayAdError.ERROR_CODE_LOAD_FAILED_ALREADY_CALLED, "Load called before load success"));
    }

    @Override // com.ironsource.L6
    public void c(IronSourceError ironSourceError) {
        this.f7050a.a("show failed while loading");
    }

    @Override // com.ironsource.L6
    public void a(IronSourceError ironSourceError) {
        F6 f62 = this.f7050a;
        f62.a(new G6(f62, this.f7051b, false, 4, null));
        this.f7050a.d().a(ironSourceError);
    }

    @Override // com.ironsource.L6
    public void a() {
        this.f7050a.a("ad expired while loading");
    }

    @Override // com.ironsource.L6
    public void a(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f7050a.a("show success while loading");
    }
}
