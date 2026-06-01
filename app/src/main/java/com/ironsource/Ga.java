package com.ironsource;

import android.graphics.Rect;
import android.view.ViewTreeObserver;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdInfo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Ga implements Ba {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2459n0 f6856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final X2 f6857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f6858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f6859d;
    private final K2 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Ca f6860f;
    private final O2 g;
    private final InterfaceC2610vf h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final InterfaceC2565t4 f6861i;
    private L0 j;
    private InterfaceC2629x0 k;
    private P2 l;
    private Qa m;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a implements P2 {
        public a() {
        }

        public void a() {
            Ga.this.n().onAdLeftApplication();
        }

        public void b() {
            Ga.this.n().n();
        }

        public void c() {
            Ga.this.n().l();
        }

        @Override // com.ironsource.J0
        public void g() {
            Ga.this.n().onAdClicked();
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
            Ga.this.m().a(adUnitCallback);
        }

        @Override // com.ironsource.L0
        public void a(IronSourceError ironSourceError) {
            Ga.this.m().a(ironSourceError);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class c implements InterfaceC2629x0 {
        public c() {
        }

        @Override // com.ironsource.InterfaceC2629x0
        public void c(IronSourceError ironSourceError) {
            Ga.this.n().e(ironSourceError);
        }

        @Override // com.ironsource.InterfaceC2629x0
        public void f() {
            Ga.this.n().k();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class d extends kotlin.jvm.internal.l implements e6.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ M2 f6866b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AbstractC2406k3 f6867c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(M2 m2, AbstractC2406k3 abstractC2406k3) {
            super(0);
            this.f6866b = m2;
            this.f6867c = abstractC2406k3;
        }

        public final void a() {
            Ga.this.a(this.f6866b, this.f6867c);
        }

        @Override // e6.a
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return q5.x.f13520a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class e extends kotlin.jvm.internal.l implements e6.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ M2 f6869b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Long f6870c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(M2 m2, Long l) {
            super(0);
            this.f6869b = m2;
            this.f6870c = l;
        }

        public final void a() {
            Ga ga = Ga.this;
            ga.a((Qa) new Ka(ga, this.f6869b, this.f6870c));
        }

        @Override // e6.a
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return q5.x.f13520a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class f implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ M2 f6872b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AbstractC2406k3 f6873c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Long f6874d;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class a extends kotlin.jvm.internal.l implements e6.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Ga f6875a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ M2 f6876b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ AbstractC2406k3 f6877c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Ga ga, M2 m2, AbstractC2406k3 abstractC2406k3) {
                super(0);
                this.f6875a = ga;
                this.f6876b = m2;
                this.f6877c = abstractC2406k3;
            }

            public final void a() {
                this.f6875a.a(this.f6876b, this.f6877c);
            }

            @Override // e6.a
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return q5.x.f13520a;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class b extends kotlin.jvm.internal.l implements e6.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Ga f6878a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ M2 f6879b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Long f6880c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Ga ga, M2 m2, Long l) {
                super(0);
                this.f6878a = ga;
                this.f6879b = m2;
                this.f6880c = l;
            }

            public final void a() {
                Ga ga = this.f6878a;
                ga.a((Qa) new Ka(ga, this.f6879b, this.f6880c));
            }

            @Override // e6.a
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return q5.x.f13520a;
            }
        }

        public f(M2 m2, AbstractC2406k3 abstractC2406k3, Long l) {
            this.f6872b = m2;
            this.f6873c = abstractC2406k3;
            this.f6874d = l;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Ga.this.k().getViewTreeObserver().isAlive()) {
                Ga.this.k().getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
            if (vg.a(Ga.this.k(), new Rect())) {
                C2623wb.a((C2623wb) Ga.this.a(), AbstractRunnableC2382ie.f8732a.a(new a(Ga.this, this.f6872b, this.f6873c)), 0L, 2, (Object) null);
            } else {
                C2623wb.a((C2623wb) Ga.this.a(), AbstractRunnableC2382ie.f8732a.a(new b(Ga.this, this.f6872b, this.f6874d)), 0L, 2, (Object) null);
            }
        }
    }

    public Ga(C2459n0 adTools, X2 bannerContainer, long j, long j3, K2 bannerAdProperties, Ca strategyListener, O2 bannerAdUnitFactory, InterfaceC2610vf taskScheduler, InterfaceC2565t4 timeProvider) {
        kotlin.jvm.internal.k.e(adTools, "adTools");
        kotlin.jvm.internal.k.e(bannerContainer, "bannerContainer");
        kotlin.jvm.internal.k.e(bannerAdProperties, "bannerAdProperties");
        kotlin.jvm.internal.k.e(strategyListener, "strategyListener");
        kotlin.jvm.internal.k.e(bannerAdUnitFactory, "bannerAdUnitFactory");
        kotlin.jvm.internal.k.e(taskScheduler, "taskScheduler");
        kotlin.jvm.internal.k.e(timeProvider, "timeProvider");
        this.f6856a = adTools;
        this.f6857b = bannerContainer;
        this.f6858c = j;
        this.f6859d = j3;
        this.e = bannerAdProperties;
        this.f6860f = strategyListener;
        this.g = bannerAdUnitFactory;
        this.h = taskScheduler;
        this.f6861i = timeProvider;
        this.j = new b();
        this.k = new c();
        this.l = new a();
        this.m = new Ia(this, false, 2, null);
    }

    public final C2459n0 a() {
        return this.f6856a;
    }

    @Override // com.ironsource.Ba
    public void c() {
        this.m.c();
    }

    @Override // com.ironsource.Ba
    public void d() {
        this.m.d();
    }

    @Override // com.ironsource.Ba
    public void e() {
        this.m.e();
    }

    public final P2 f() {
        return this.l;
    }

    public final L0 g() {
        return this.j;
    }

    public final InterfaceC2629x0 h() {
        return this.k;
    }

    public final K2 i() {
        return this.e;
    }

    public final O2 j() {
        return this.g;
    }

    public final X2 k() {
        return this.f6857b;
    }

    public final long l() {
        return this.f6858c;
    }

    public final Qa m() {
        return this.m;
    }

    public final Ca n() {
        return this.f6860f;
    }

    public final InterfaceC2610vf o() {
        return this.h;
    }

    public final InterfaceC2565t4 p() {
        return this.f6861i;
    }

    public final long q() {
        return this.f6859d;
    }

    public final void r() {
        this.f6856a.e().h().h("Banner view is not visible");
    }

    public final void a(L0 l02) {
        kotlin.jvm.internal.k.e(l02, "<set-?>");
        this.j = l02;
    }

    public final void b(Ca ca) {
        kotlin.jvm.internal.k.e(ca, "<set-?>");
        this.f6860f = ca;
    }

    public final void a(InterfaceC2629x0 interfaceC2629x0) {
        kotlin.jvm.internal.k.e(interfaceC2629x0, "<set-?>");
        this.k = interfaceC2629x0;
    }

    @Override // com.ironsource.Ba
    public void b() {
        this.m.b();
    }

    public final void a(P2 p2) {
        kotlin.jvm.internal.k.e(p2, "<set-?>");
        this.l = p2;
    }

    public final void a(Qa qa) {
        kotlin.jvm.internal.k.e(qa, "<set-?>");
        this.m = qa;
    }

    public final void a(String message) {
        kotlin.jvm.internal.k.e(message, "message");
        this.f6856a.e().h().f("Banner Reload Strategy - ".concat(message));
    }

    public final void a(C2544s0 adUnitCallback, M2 currentAdUnit, M2 m2, AbstractC2406k3 reloadReason, boolean z2, Long l) {
        q5.x xVar;
        kotlin.jvm.internal.k.e(adUnitCallback, "adUnitCallback");
        kotlin.jvm.internal.k.e(currentAdUnit, "currentAdUnit");
        kotlin.jvm.internal.k.e(reloadReason, "reloadReason");
        currentAdUnit.a(this.f6857b.getViewBinder(), this.k);
        LevelPlayAdInfo levelPlayAdInfoC = adUnitCallback.c();
        if (levelPlayAdInfoC != null) {
            this.f6860f.onAdLoaded(levelPlayAdInfoC);
            xVar = q5.x.f13520a;
        } else {
            xVar = null;
        }
        if (xVar == null) {
            IronLog.INTERNAL.error(C2459n0.a(this.f6856a, "adInfo is null in handleLoadSuccess", (String) null, 2, (Object) null));
        }
        if (m2 != null) {
            m2.a(false);
        }
        if (z2) {
            this.m = new Ma(this, currentAdUnit);
        } else {
            a(currentAdUnit, reloadReason, l);
        }
    }

    public /* synthetic */ Ga(C2459n0 c2459n0, X2 x2, long j, long j3, K2 k22, Ca ca, O2 o2, InterfaceC2610vf interfaceC2610vf, InterfaceC2565t4 interfaceC2565t4, int i2, kotlin.jvm.internal.f fVar) {
        this(c2459n0, x2, j, j3, k22, ca, o2, (i2 & 128) != 0 ? new W6(X6.a(c2459n0.a())) : interfaceC2610vf, interfaceC2565t4);
    }

    public final void a(IronSourceError ironSourceError, M2 currentAdUnit, AbstractC2406k3 reloadReason, boolean z2, boolean z7, Long l) {
        kotlin.jvm.internal.k.e(currentAdUnit, "currentAdUnit");
        kotlin.jvm.internal.k.e(reloadReason, "reloadReason");
        this.f6860f.b(ironSourceError);
        if (z7) {
            this.m = new Ma(this, currentAdUnit);
        } else if (z2) {
            a(currentAdUnit, reloadReason, l);
        } else {
            a(currentAdUnit, reloadReason);
        }
    }

    public final void a(M2 currentAdUnit, AbstractC2406k3 reloadReason, Long l) {
        kotlin.jvm.internal.k.e(currentAdUnit, "currentAdUnit");
        kotlin.jvm.internal.k.e(reloadReason, "reloadReason");
        C2623wb.a(this.f6856a, new a3.d(this, currentAdUnit, reloadReason, l, 5), 0L, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Ga this$0, M2 currentAdUnit, AbstractC2406k3 reloadReason, Long l) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(currentAdUnit, "$currentAdUnit");
        kotlin.jvm.internal.k.e(reloadReason, "$reloadReason");
        if (vg.a(this$0.f6857b, new Rect())) {
            C2623wb.a((C2623wb) this$0.f6856a, AbstractRunnableC2382ie.f8732a.a(this$0.new d(currentAdUnit, reloadReason)), 0L, 2, (Object) null);
        } else if (!this$0.f6857b.getViewTreeObserver().isAlive()) {
            C2623wb.a((C2623wb) this$0.f6856a, AbstractRunnableC2382ie.f8732a.a(this$0.new e(currentAdUnit, l)), 0L, 2, (Object) null);
        } else {
            this$0.f6857b.getViewTreeObserver().addOnGlobalLayoutListener(this$0.new f(currentAdUnit, reloadReason, l));
        }
    }

    public final void a(M2 currentAdUnit, AbstractC2406k3 reloadReason) {
        kotlin.jvm.internal.k.e(currentAdUnit, "currentAdUnit");
        kotlin.jvm.internal.k.e(reloadReason, "reloadReason");
        M2 m2A = this.g.a(false);
        Na na = new Na(this, currentAdUnit, m2A, this.f6861i.a());
        a(reloadReason);
        this.m = na;
        m2A.a(this.j);
    }

    private final void a(AbstractC2406k3 abstractC2406k3) {
        this.f6856a.e().h().a(abstractC2406k3.c(), abstractC2406k3.b(), abstractC2406k3.a());
    }

    @Override // com.ironsource.Ba
    public void a(Ca listener) {
        kotlin.jvm.internal.k.e(listener, "listener");
        this.f6860f = listener;
    }
}
