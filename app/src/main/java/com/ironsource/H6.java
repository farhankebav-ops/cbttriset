package com.ironsource;

import android.app.Activity;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class H6 implements L6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final F6 f6914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C2567t6 f6915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final C2567t6 f6916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private LevelPlayAdInfo f6917d;

    public H6(F6 strategy, C2567t6 currentAdUnit, C2567t6 progressiveAdUnit, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(strategy, "strategy");
        kotlin.jvm.internal.k.e(currentAdUnit, "currentAdUnit");
        kotlin.jvm.internal.k.e(progressiveAdUnit, "progressiveAdUnit");
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f6914a = strategy;
        this.f6915b = currentAdUnit;
        this.f6916c = progressiveAdUnit;
        this.f6917d = adInfo;
    }

    @Override // com.ironsource.L6
    public void a(Activity activity) {
        kotlin.jvm.internal.k.e(activity, "activity");
        this.f6914a.d().c(new IronSourceError(LevelPlayAdError.ERROR_CODE_SHOW_BEFORE_LOAD_SUCCESS_CALLBACK, "Show called before load success"));
    }

    @Override // com.ironsource.L6
    public void b(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f6917d = adInfo;
    }

    @Override // com.ironsource.L6
    public void c(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f6914a.a("load success on progressive ad unit is already loaded");
    }

    @Override // com.ironsource.L6
    public void loadAd() {
        this.f6914a.d().b(this.f6917d);
        F6 f62 = this.f6914a;
        f62.a(new J6(f62, this.f6916c));
    }

    @Override // com.ironsource.L6
    public void c(IronSourceError ironSourceError) {
        this.f6914a.a("show failed on progressive ad unit that already loaded");
    }

    @Override // com.ironsource.L6
    public void a(IronSourceError ironSourceError) {
        this.f6914a.a("load failed on progressive ad unit that already loaded");
    }

    @Override // com.ironsource.L6
    public void a() {
        F6 f62 = this.f6914a;
        f62.a(new G6(f62, this.f6915b, true));
    }

    @Override // com.ironsource.L6
    public void a(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f6914a.a("show success on progressive ad unit that already loaded");
    }
}
