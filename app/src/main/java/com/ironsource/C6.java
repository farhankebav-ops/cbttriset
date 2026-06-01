package com.ironsource;

import android.app.Activity;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdInfo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C6 implements E6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2669z6 f6406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C2567t6 f6407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f6408c;

    public C6(C2669z6 strategy, C2567t6 currentAdUnit, boolean z2) {
        kotlin.jvm.internal.k.e(strategy, "strategy");
        kotlin.jvm.internal.k.e(currentAdUnit, "currentAdUnit");
        this.f6406a = strategy;
        this.f6407b = currentAdUnit;
        this.f6408c = z2;
    }

    @Override // com.ironsource.E6
    public void a(Activity activity) {
        kotlin.jvm.internal.k.e(activity, "activity");
        this.f6406a.a("show called while loading");
    }

    @Override // com.ironsource.E6
    public void b(C2567t6 adUnit, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        if (!this.f6408c) {
            this.f6406a.a(new B6(this.f6406a, this.f6407b, null, false));
            return;
        }
        C2567t6 c2567t6A = this.f6406a.b().a(false, this.f6406a.c());
        this.f6406a.a(new B6(this.f6406a, this.f6407b, c2567t6A, true));
        this.f6406a.d().b(adInfo);
        c2567t6A.a(this.f6406a);
    }

    @Override // com.ironsource.E6
    public void c(C2567t6 adUnit, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f6406a.a("ad info changed while loading");
    }

    @Override // com.ironsource.E6
    public void loadAd() {
        if (this.f6408c) {
            this.f6406a.a("load called while loading");
        }
        this.f6408c = true;
    }

    @Override // com.ironsource.E6
    public void a(C2567t6 adUnit, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f6406a.a("show success while loading");
    }

    @Override // com.ironsource.E6
    public void a(C2567t6 adUnit, IronSourceError ironSourceError) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        this.f6406a.a("show failed while loading");
    }

    @Override // com.ironsource.E6
    public void a(C2567t6 adUnit) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        this.f6406a.a("ad expired while loading");
    }

    @Override // com.ironsource.E6
    public void b(C2567t6 adUnit, IronSourceError ironSourceError) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        this.f6406a.a(new A6(this.f6406a));
        if (this.f6408c) {
            this.f6406a.d().a(ironSourceError);
        }
    }
}
