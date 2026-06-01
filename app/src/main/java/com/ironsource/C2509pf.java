package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.pf, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2509pf extends Hg {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Xc f9674d;
    private final Cg e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final F f9675f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2509pf(V0 adTools, Xc outcomeReporter, Cg waterfallInstances, F adInstanceLoadStrategy) {
        super(adTools, outcomeReporter);
        kotlin.jvm.internal.k.e(adTools, "adTools");
        kotlin.jvm.internal.k.e(outcomeReporter, "outcomeReporter");
        kotlin.jvm.internal.k.e(waterfallInstances, "waterfallInstances");
        kotlin.jvm.internal.k.e(adInstanceLoadStrategy, "adInstanceLoadStrategy");
        this.f9674d = outcomeReporter;
        this.e = waterfallInstances;
        this.f9675f = adInstanceLoadStrategy;
    }

    @Override // com.ironsource.Hg
    public void a(AbstractC2662z instance) {
        AbstractC2662z abstractC2662zA;
        kotlin.jvm.internal.k.e(instance, "instance");
        if (this.f9675f.a(instance)) {
            this.f9674d.a(this.e.b(), instance);
        } else {
            if (!this.f9675f.a() || (abstractC2662zA = this.f9675f.c().a()) == null) {
                return;
            }
            this.f9674d.a(this.e.b(), abstractC2662zA);
        }
    }

    @Override // com.ironsource.Hg
    public void b(AbstractC2662z instance) {
        kotlin.jvm.internal.k.e(instance, "instance");
    }

    @Override // com.ironsource.Hg
    public void c(AbstractC2662z instanceToShow) {
        kotlin.jvm.internal.k.e(instanceToShow, "instanceToShow");
        this.f9674d.a(this.e.b(), instanceToShow);
    }

    @Override // com.ironsource.Hg
    public void a() {
        AbstractC2662z abstractC2662zA = this.f9675f.c().a();
        if (abstractC2662zA != null) {
            this.f9674d.a(this.e.b(), abstractC2662zA);
        }
    }
}
