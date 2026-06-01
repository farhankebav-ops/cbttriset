package com.ironsource;

import android.app.Activity;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class I6 implements L6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final F6 f6979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C2567t6 f6980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final C2567t6 f6981c;

    public I6(F6 strategy, C2567t6 currentAdUnit, C2567t6 progressiveAdUnit) {
        kotlin.jvm.internal.k.e(strategy, "strategy");
        kotlin.jvm.internal.k.e(currentAdUnit, "currentAdUnit");
        kotlin.jvm.internal.k.e(progressiveAdUnit, "progressiveAdUnit");
        this.f6979a = strategy;
        this.f6980b = currentAdUnit;
        this.f6981c = progressiveAdUnit;
    }

    @Override // com.ironsource.L6
    public void a(Activity activity) {
        kotlin.jvm.internal.k.e(activity, "activity");
        this.f6979a.d().c(new IronSourceError(LevelPlayAdError.ERROR_CODE_SHOW_WHILE_LOAD, "Show called while progressive loading another ad"));
    }

    @Override // com.ironsource.L6
    public void b(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f6979a.a("load success with better ad before progressive load success");
    }

    @Override // com.ironsource.L6
    public void c(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        F6 f62 = this.f6979a;
        f62.a(new H6(f62, this.f6980b, this.f6981c, adInfo));
    }

    @Override // com.ironsource.L6
    public void loadAd() {
        F6 f62 = this.f6979a;
        f62.a(new K6(f62, this.f6981c));
    }

    @Override // com.ironsource.L6
    public void a(IronSourceError ironSourceError) {
        F6 f62 = this.f6979a;
        f62.a(new G6(f62, this.f6980b, false, 4, null));
    }

    @Override // com.ironsource.L6
    public void a() {
        this.f6979a.a("ad expired before progressive load success");
    }

    @Override // com.ironsource.L6
    public void a(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f6979a.a("show success before progressive load success");
    }

    @Override // com.ironsource.L6
    public void c(IronSourceError ironSourceError) {
        this.f6979a.a("show failed before progressive load success");
    }
}
