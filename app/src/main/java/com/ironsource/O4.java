package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class O4 extends Hg {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Xc f7313d;
    private final Cg e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public O4(V0 adTools, Xc outcomeReporter, Cg waterfallInstances) {
        super(adTools, outcomeReporter);
        kotlin.jvm.internal.k.e(adTools, "adTools");
        kotlin.jvm.internal.k.e(outcomeReporter, "outcomeReporter");
        kotlin.jvm.internal.k.e(waterfallInstances, "waterfallInstances");
        this.f7313d = outcomeReporter;
        this.e = waterfallInstances;
    }

    @Override // com.ironsource.Hg
    public void a() {
    }

    @Override // com.ironsource.Hg
    public void b(AbstractC2662z instance) {
        kotlin.jvm.internal.k.e(instance, "instance");
        this.f7313d.a(this.e.b(), instance);
    }

    @Override // com.ironsource.Hg
    public void c(AbstractC2662z instanceToShow) {
        kotlin.jvm.internal.k.e(instanceToShow, "instanceToShow");
    }

    @Override // com.ironsource.Hg
    public void a(AbstractC2662z instance) {
        kotlin.jvm.internal.k.e(instance, "instance");
    }
}
