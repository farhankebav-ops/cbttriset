package com.ironsource;

import com.ironsource.AbstractC2388j3;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Uf extends AbstractC2388j3 implements L0, InterfaceC2629x0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final C2459n0 f7692d;
    private final X2 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final InterfaceC2424l3 f7693f;
    private final O2 g;
    private C2276cg h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final C2613w1 f7694i;
    private final sg j;
    private final Kb k;
    private a l;
    private a m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f7695n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f7696o;
    private C2544s0 p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private IronSourceError f7697q;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final M2 f7698a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public C2544s0 f7699b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f7700c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Uf f7701d;

        public a(Uf uf, O2 bannerAdUnitFactory, boolean z2) {
            kotlin.jvm.internal.k.e(bannerAdUnitFactory, "bannerAdUnitFactory");
            this.f7701d = uf;
            this.f7698a = bannerAdUnitFactory.a(z2);
            this.f7700c = true;
        }

        public final C2544s0 a() {
            C2544s0 c2544s0 = this.f7699b;
            if (c2544s0 != null) {
                return c2544s0;
            }
            kotlin.jvm.internal.k.l("adUnitCallback");
            throw null;
        }

        public final M2 b() {
            return this.f7698a;
        }

        public final boolean c() {
            return this.f7700c;
        }

        public final boolean d() {
            return this.f7698a.d().a();
        }

        public final void e() {
            this.f7698a.a((L0) this.f7701d);
        }

        public final void a(C2544s0 c2544s0) {
            kotlin.jvm.internal.k.e(c2544s0, "<set-?>");
            this.f7699b = c2544s0;
        }

        public final void b(boolean z2) {
            this.f7700c = z2;
        }

        public final void a(boolean z2) {
            this.f7698a.a(z2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Uf(C2459n0 adTools, X2 bannerContainer, AbstractC2388j3.b config, K2 bannerAdProperties, InterfaceC2424l3 bannerStrategyListener, O2 bannerAdUnitFactory) {
        super(config, bannerAdProperties);
        kotlin.jvm.internal.k.e(adTools, "adTools");
        kotlin.jvm.internal.k.e(bannerContainer, "bannerContainer");
        kotlin.jvm.internal.k.e(config, "config");
        kotlin.jvm.internal.k.e(bannerAdProperties, "bannerAdProperties");
        kotlin.jvm.internal.k.e(bannerStrategyListener, "bannerStrategyListener");
        kotlin.jvm.internal.k.e(bannerAdUnitFactory, "bannerAdUnitFactory");
        this.f7692d = adTools;
        this.e = bannerContainer;
        this.f7693f = bannerStrategyListener;
        this.g = bannerAdUnitFactory;
        IronLog.INTERNAL.verbose(C2459n0.a(adTools, "refresh interval: " + g() + ", auto refresh: " + h(), (String) null, 2, (Object) null));
        this.f7694i = new C2613w1(adTools.b());
        this.j = new sg(bannerContainer);
        this.k = new Kb(h() ^ true);
        this.m = new a(this, bannerAdUnitFactory, true);
        this.f7696o = true;
    }

    private final void k() {
        this.f7693f.d(this.f7697q);
        this.p = null;
        this.f7697q = null;
    }

    private final void l() {
        this.f7696o = false;
        this.m.b().a(this.e.getViewBinder(), this);
        this.f7693f.c(this.m.a());
        a aVar = this.l;
        if (aVar != null) {
            aVar.a(false);
        }
        this.l = this.m;
        i();
        a(this.j, this.f7694i, this.k);
    }

    @Override // com.ironsource.L0
    public final /* synthetic */ void a() {
        mh.a(this);
    }

    @Override // com.ironsource.L0
    public final /* synthetic */ void b(C2544s0 c2544s0) {
        mh.b(this, c2544s0);
    }

    @Override // com.ironsource.InterfaceC2629x0
    public void c(IronSourceError ironSourceError) {
        this.f7693f.f(ironSourceError);
    }

    @Override // com.ironsource.AbstractC2388j3
    public void d() {
        if (h()) {
            this.k.e();
        }
    }

    @Override // com.ironsource.AbstractC2388j3
    public void e() {
        if (h()) {
            this.k.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Uf this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        this$0.f7695n = true;
        if (this$0.m.d()) {
            this$0.l();
        } else {
            if (this$0.m.c()) {
                return;
            }
            this$0.i();
            this$0.a(this$0.f7694i, this$0.k);
        }
    }

    private final void i() {
        if (h()) {
            a aVar = new a(this, this.g, false);
            this.m = aVar;
            aVar.e();
        }
    }

    private final void j() {
        this.f7692d.a(new vh(this, 0));
    }

    @Override // com.ironsource.AbstractC2388j3
    public void b() {
        this.m.e();
    }

    @Override // com.ironsource.AbstractC2388j3
    public void c() {
        this.f7694i.e();
        this.j.e();
        C2276cg c2276cg = this.h;
        if (c2276cg != null) {
            c2276cg.c();
        }
        this.h = null;
        a aVar = this.l;
        if (aVar != null) {
            aVar.a(true);
        }
        this.m.a(true);
    }

    @Override // com.ironsource.InterfaceC2629x0
    public void f() {
        this.f7693f.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Uf this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        this$0.j();
    }

    private final void a(AbstractC2345gd... abstractC2345gdArr) {
        this.f7695n = false;
        this.f7692d.c(new ti(12, this, abstractC2345gdArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Uf this$0, AbstractC2345gd[] triggers) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(triggers, "$triggers");
        C2276cg c2276cg = this$0.h;
        if (c2276cg != null) {
            c2276cg.c();
        }
        this$0.h = new C2276cg(this$0.f7692d, new vh(this$0, 1), this$0.g(), r5.j.s0(triggers));
    }

    @Override // com.ironsource.L0
    public void a(C2544s0 adUnitCallback) {
        kotlin.jvm.internal.k.e(adUnitCallback, "adUnitCallback");
        this.m.a(adUnitCallback);
        this.m.b(false);
        if (this.f7695n || this.f7696o) {
            l();
        }
    }

    @Override // com.ironsource.L0
    public void a(IronSourceError ironSourceError) {
        this.m.b(false);
        this.f7697q = ironSourceError;
        if (this.f7696o) {
            k();
            a(this.f7694i, this.k);
        } else if (this.f7695n) {
            k();
            i();
            a(this.f7694i, this.k);
        }
    }
}
