package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdInfo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
final class Ya implements InterfaceC2424l3, P2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Ca f7867a;

    public Ya(Ca listener) {
        kotlin.jvm.internal.k.e(listener, "listener");
        this.f7867a = listener;
    }

    public void a() {
        this.f7867a.onAdLeftApplication();
    }

    public void b() {
        this.f7867a.n();
    }

    @Override // com.ironsource.InterfaceC2424l3
    public void c(C2544s0 adUnitCallback) {
        kotlin.jvm.internal.k.e(adUnitCallback, "adUnitCallback");
        LevelPlayAdInfo levelPlayAdInfoC = adUnitCallback.c();
        if (levelPlayAdInfoC != null) {
            this.f7867a.onAdLoaded(levelPlayAdInfoC);
        }
    }

    @Override // com.ironsource.InterfaceC2424l3
    public void d(IronSourceError ironSourceError) {
        this.f7867a.b(ironSourceError);
    }

    @Override // com.ironsource.InterfaceC2424l3
    public void f(IronSourceError ironSourceError) {
        this.f7867a.e(ironSourceError);
    }

    @Override // com.ironsource.J0
    public void g() {
        this.f7867a.onAdClicked();
    }

    @Override // com.ironsource.InterfaceC2424l3
    public void h() {
        this.f7867a.k();
    }

    @Override // com.ironsource.P2
    public /* bridge */ /* synthetic */ q5.x i() {
        a();
        return q5.x.f13520a;
    }

    @Override // com.ironsource.P2
    public /* bridge */ /* synthetic */ q5.x j() {
        c();
        return q5.x.f13520a;
    }

    @Override // com.ironsource.P2
    public /* bridge */ /* synthetic */ q5.x m() {
        b();
        return q5.x.f13520a;
    }

    public void c() {
        this.f7867a.l();
    }
}
