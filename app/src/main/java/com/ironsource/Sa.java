package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdInfo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Sa implements Ba {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2459n0 f7593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final X2 f7594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final O2 f7595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Ca f7596d;
    private Xa e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private M2 f7597f;
    private final L0 g;
    private final InterfaceC2629x0 h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final P2 f7598i;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a implements P2 {
        public a() {
        }

        public void a() {
            Ca caM = Sa.this.m();
            if (caM != null) {
                caM.onAdLeftApplication();
            }
        }

        public void b() {
            Ca caM = Sa.this.m();
            if (caM != null) {
                caM.n();
            }
        }

        public void c() {
            Ca caM = Sa.this.m();
            if (caM != null) {
                caM.l();
            }
        }

        @Override // com.ironsource.J0
        public void g() {
            Ca caM = Sa.this.m();
            if (caM != null) {
                caM.onAdClicked();
            }
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
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b implements L0 {
        public b() {
        }

        @Override // com.ironsource.L0
        public final /* synthetic */ void a() {
            mh.a(this);
        }

        @Override // com.ironsource.L0
        public final /* synthetic */ void b(C2544s0 c2544s0) {
            mh.b(this, c2544s0);
        }

        @Override // com.ironsource.L0
        public void a(C2544s0 adUnitCallback) {
            kotlin.jvm.internal.k.e(adUnitCallback, "adUnitCallback");
            Sa.this.l().a(adUnitCallback);
        }

        @Override // com.ironsource.L0
        public void a(IronSourceError ironSourceError) {
            Sa.this.l().a(ironSourceError);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class c implements InterfaceC2629x0 {
        public c() {
        }

        @Override // com.ironsource.InterfaceC2629x0
        public void c(IronSourceError ironSourceError) {
            Ca caM = Sa.this.m();
            if (caM != null) {
                caM.e(ironSourceError);
            }
        }

        @Override // com.ironsource.InterfaceC2629x0
        public void f() {
            Ca caM = Sa.this.m();
            if (caM != null) {
                caM.k();
            }
        }
    }

    public Sa(C2459n0 adTools, X2 bannerContainer, O2 bannerAdUnitFactory) {
        kotlin.jvm.internal.k.e(adTools, "adTools");
        kotlin.jvm.internal.k.e(bannerContainer, "bannerContainer");
        kotlin.jvm.internal.k.e(bannerAdUnitFactory, "bannerAdUnitFactory");
        this.f7593a = adTools;
        this.f7594b = bannerContainer;
        this.f7595c = bannerAdUnitFactory;
        this.e = new Ta(this);
        this.g = new b();
        this.h = new c();
        this.f7598i = new a();
    }

    public final C2459n0 a() {
        return this.f7593a;
    }

    public final void b(Ca ca) {
        this.f7596d = ca;
    }

    @Override // com.ironsource.Ba
    public void c() {
        this.e.c();
    }

    public final P2 f() {
        return this.f7598i;
    }

    public final L0 g() {
        return this.g;
    }

    public final InterfaceC2629x0 h() {
        return this.h;
    }

    public final O2 i() {
        return this.f7595c;
    }

    public final X2 j() {
        return this.f7594b;
    }

    public final M2 k() {
        return this.f7597f;
    }

    public final Xa l() {
        return this.e;
    }

    public final Ca m() {
        return this.f7596d;
    }

    public final void a(Xa xa) {
        kotlin.jvm.internal.k.e(xa, "<set-?>");
        this.e = xa;
    }

    @Override // com.ironsource.Ba
    public void b() {
        this.e.b();
    }

    public final void a(M2 m2) {
        this.f7597f = m2;
    }

    public final void a(String message) {
        kotlin.jvm.internal.k.e(message, "message");
        this.f7593a.e().h().f("Banner Single Ad Unit Strategy - ".concat(message));
    }

    public final void a(C2544s0 adUnitCallback, M2 adUnit) {
        Ca ca;
        kotlin.jvm.internal.k.e(adUnitCallback, "adUnitCallback");
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        adUnit.a(this.f7594b.getViewBinder(), this.h);
        LevelPlayAdInfo levelPlayAdInfoC = adUnitCallback.c();
        if (levelPlayAdInfoC == null || (ca = this.f7596d) == null) {
            return;
        }
        ca.onAdLoaded(levelPlayAdInfoC);
    }

    public final void a(IronSourceError ironSourceError) {
        Ca ca = this.f7596d;
        if (ca != null) {
            ca.b(ironSourceError);
        }
    }

    @Override // com.ironsource.Ba
    public void a(Ca listener) {
        kotlin.jvm.internal.k.e(listener, "listener");
        this.f7596d = listener;
    }

    @Override // com.ironsource.Ba
    public void d() {
    }

    @Override // com.ironsource.Ba
    public void e() {
    }
}
