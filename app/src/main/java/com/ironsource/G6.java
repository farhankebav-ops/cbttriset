package com.ironsource;

import android.app.Activity;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class G6 implements L6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final F6 f6819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C2567t6 f6820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f6821c;

    public G6(F6 strategy, C2567t6 c2567t6, boolean z2) {
        kotlin.jvm.internal.k.e(strategy, "strategy");
        this.f6819a = strategy;
        this.f6820b = c2567t6;
        this.f6821c = z2;
    }

    @Override // com.ironsource.L6
    public void a(Activity activity) {
        kotlin.jvm.internal.k.e(activity, "activity");
        this.f6819a.d().c(new IronSourceError(LevelPlayAdError.ERROR_CODE_SHOW_BEFORE_LOAD_SUCCESS_CALLBACK, this.f6821c ? "Show called on expired ad" : "Show called before load success"));
    }

    @Override // com.ironsource.L6
    public void b(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f6819a.a(this.f6821c ? "load with better ad on expired ad" : "load success with better ad before load success");
    }

    @Override // com.ironsource.L6
    public void c(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f6819a.a(this.f6821c ? "load success on expired ad" : "load success before load called");
    }

    @Override // com.ironsource.L6
    public void loadAd() {
        C2567t6 c2567t6A = this.f6819a.b().a(true, this.f6819a.c());
        F6 f62 = this.f6819a;
        f62.a(new K6(f62, c2567t6A));
        c2567t6A.a(this.f6819a);
    }

    @Override // com.ironsource.L6
    public void c(IronSourceError ironSourceError) {
        this.f6819a.a(this.f6821c ? "show failed on expired ad" : "show failed before load called");
    }

    public /* synthetic */ G6(F6 f62, C2567t6 c2567t6, boolean z2, int i2, kotlin.jvm.internal.f fVar) {
        this(f62, c2567t6, (i2 & 4) != 0 ? false : z2);
    }

    @Override // com.ironsource.L6
    public void a(IronSourceError ironSourceError) {
        this.f6819a.a(this.f6821c ? "load failed on expired ad" : "load failed before load called");
    }

    @Override // com.ironsource.L6
    public void a() {
        this.f6819a.a(this.f6821c ? "ad expired on expired ad" : "ad expired before load called");
    }

    @Override // com.ironsource.L6
    public void a(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f6819a.a(this.f6821c ? "show success on expired ad" : "show success before load called");
    }
}
