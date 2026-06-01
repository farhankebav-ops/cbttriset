package com.ironsource;

import android.graphics.Rect;
import com.ironsource.AbstractC2406k3;
import com.ironsource.InterfaceC2610vf;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Ka implements Qa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Ga f7052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final M2 f7053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Long f7054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private InterfaceC2610vf.a f7055d;
    private final long e;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a extends kotlin.jvm.internal.l implements e6.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AbstractC2406k3.c f7057b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f7058c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AbstractC2406k3.c cVar, long j) {
            super(0);
            this.f7057b = cVar;
            this.f7058c = j;
        }

        public final void a() {
            Ka.this.f7052a.a(Ka.this.f7053b, this.f7057b, Long.valueOf(this.f7058c));
        }

        @Override // e6.a
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return q5.x.f13520a;
        }
    }

    public Ka(Ga strategy, M2 currentAdUnit, Long l) {
        kotlin.jvm.internal.k.e(strategy, "strategy");
        kotlin.jvm.internal.k.e(currentAdUnit, "currentAdUnit");
        this.f7052a = strategy;
        this.f7053b = currentAdUnit;
        this.f7054c = l;
        this.e = strategy.p().a();
        strategy.r();
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Ka this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        C2623wb.a(this$0.f7052a.a(), new lh(this$0, 1), 0L, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Ka this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        if (!vg.a(this$0.f7052a.k(), new Rect())) {
            this$0.f();
            return;
        }
        long jA = this$0.f7052a.p().a();
        long j = jA - this$0.e;
        Long l = this$0.f7054c;
        C2623wb.a((C2623wb) this$0.f7052a.a(), AbstractRunnableC2382ie.f8732a.a(this$0.new a(new AbstractC2406k3.c(l != null ? jA - l.longValue() : 0L, new AbstractC2406k3.d.f(j)), jA)), 0L, 2, (Object) null);
    }

    @Override // com.ironsource.L0
    public final /* synthetic */ void a() {
        mh.a(this);
    }

    @Override // com.ironsource.L0
    public final /* synthetic */ void b(C2544s0 c2544s0) {
        mh.b(this, c2544s0);
    }

    private final void f() {
        long jQ = this.f7052a.q();
        InterfaceC2610vf interfaceC2610vfO = this.f7052a.o();
        lh lhVar = new lh(this, 0);
        int i2 = o6.a.f13207d;
        this.f7055d = interfaceC2610vfO.a(lhVar, r2.q.B0(jQ, o6.c.f13211c));
    }

    @Override // com.ironsource.Qa
    public void c() {
        InterfaceC2610vf.a aVar = this.f7055d;
        if (aVar != null) {
            aVar.a();
        }
        this.f7053b.a(true);
        Ga ga = this.f7052a;
        ga.a((Qa) new Ja(ga));
    }

    @Override // com.ironsource.Qa
    public void e() {
    }

    @Override // com.ironsource.L0
    public void a(C2544s0 adUnitCallback) {
        kotlin.jvm.internal.k.e(adUnitCallback, "adUnitCallback");
        this.f7052a.a("Received load success while paused not visible");
    }

    @Override // com.ironsource.Qa
    public void b() {
        this.f7052a.a("Loading a loaded ad");
    }

    @Override // com.ironsource.L0
    public void a(IronSourceError ironSourceError) {
        this.f7052a.a("Received load success while paused not visible");
    }

    @Override // com.ironsource.Qa
    public void d() {
        InterfaceC2610vf.a aVar = this.f7055d;
        if (aVar != null) {
            aVar.a();
        }
        Ga ga = this.f7052a;
        ga.a((Qa) new Ma(ga, this.f7053b));
    }
}
