package com.ironsource;

import com.ironsource.AbstractC2406k3;
import com.ironsource.InterfaceC2505pb;
import com.ironsource.InterfaceC2610vf;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdInfo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Na implements Qa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Ga f7283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final M2 f7284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final M2 f7285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f7286d;
    private InterfaceC2505pb<LevelPlayAdInfo> e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private InterfaceC2610vf.a f7287f;

    public Na(Ga strategy, M2 currentAdUnit, M2 reloadingAdUnit, long j) {
        kotlin.jvm.internal.k.e(strategy, "strategy");
        kotlin.jvm.internal.k.e(currentAdUnit, "currentAdUnit");
        kotlin.jvm.internal.k.e(reloadingAdUnit, "reloadingAdUnit");
        this.f7283a = strategy;
        this.f7284b = currentAdUnit;
        this.f7285c = reloadingAdUnit;
        this.f7286d = j;
        g();
    }

    private final void f() {
        InterfaceC2505pb<LevelPlayAdInfo> interfaceC2505pb = this.e;
        if (interfaceC2505pb == null) {
            Ga ga = this.f7283a;
            ga.a((Qa) new Pa(ga, this.f7284b, this.f7285c, this.f7286d));
        } else if (interfaceC2505pb instanceof InterfaceC2505pb.b) {
            a((LevelPlayAdInfo) ((InterfaceC2505pb.b) interfaceC2505pb).b());
        } else if (interfaceC2505pb instanceof InterfaceC2505pb.a) {
            b(((InterfaceC2505pb.a) interfaceC2505pb).b());
        }
    }

    private final void g() {
        InterfaceC2610vf interfaceC2610vfO = this.f7283a.o();
        ch chVar = new ch(this, 3);
        int i2 = o6.a.f13207d;
        this.f7287f = interfaceC2610vfO.a(chVar, r2.q.B0(this.f7283a.l(), o6.c.f13211c));
    }

    @Override // com.ironsource.L0
    public final /* synthetic */ void a() {
        mh.a(this);
    }

    @Override // com.ironsource.Qa
    public void c() {
        InterfaceC2610vf.a aVar = this.f7287f;
        if (aVar != null) {
            aVar.a();
        }
        this.f7284b.a(true);
        this.f7285c.a(true);
        Ga ga = this.f7283a;
        ga.a((Qa) new Ja(ga));
    }

    @Override // com.ironsource.Qa
    public void d() {
        InterfaceC2610vf.a aVar = this.f7287f;
        if (aVar != null) {
            aVar.a();
        }
        Ga ga = this.f7283a;
        ga.a((Qa) new Ma(ga, this.f7284b));
    }

    @Override // com.ironsource.Qa
    public void e() {
        Ga ga = this.f7283a;
        ga.a((Qa) new Na(ga, this.f7284b, this.f7285c, ga.p().a()));
    }

    @Override // com.ironsource.L0
    public void a(C2544s0 adUnitCallback) {
        kotlin.jvm.internal.k.e(adUnitCallback, "adUnitCallback");
        LevelPlayAdInfo levelPlayAdInfoC = adUnitCallback.c();
        if (levelPlayAdInfoC != null) {
            a(new InterfaceC2505pb.b(levelPlayAdInfoC));
        } else {
            a(new InterfaceC2505pb.a(new IronSourceError(0, "Missing ad info")));
        }
    }

    @Override // com.ironsource.L0
    public final /* synthetic */ void b(C2544s0 c2544s0) {
        mh.b(this, c2544s0);
    }

    @Override // com.ironsource.Qa
    public void b() {
        this.f7283a.a("Loading an ad while reloading");
    }

    private final void b(IronSourceError ironSourceError) {
        this.f7283a.a(ironSourceError, this.f7284b, (AbstractC2406k3) new AbstractC2406k3.c(this.f7283a.p().a() - this.f7286d, AbstractC2406k3.d.g.f8829a), true, false, Long.valueOf(this.f7286d));
    }

    @Override // com.ironsource.L0
    public void a(IronSourceError ironSourceError) {
        if (ironSourceError == null) {
            ironSourceError = new IronSourceError(0, "Unknown error");
        }
        a(new InterfaceC2505pb.a(ironSourceError));
    }

    private final void a(LevelPlayAdInfo levelPlayAdInfo) {
        long jA = this.f7283a.p().a() - this.f7286d;
        this.f7283a.a(new C2544s0(this.f7285c, levelPlayAdInfo), this.f7285c, this.f7284b, (AbstractC2406k3) new AbstractC2406k3.c(jA, AbstractC2406k3.d.h.f8830a), false, Long.valueOf(this.f7286d));
    }

    private final void a(InterfaceC2505pb<LevelPlayAdInfo> interfaceC2505pb) {
        if (this.e != null) {
            this.f7283a.a("Received excessive load " + Oa.b(interfaceC2505pb) + " while reloading");
            return;
        }
        this.e = interfaceC2505pb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Na this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        this$0.f();
    }
}
