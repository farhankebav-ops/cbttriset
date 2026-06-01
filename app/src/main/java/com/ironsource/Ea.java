package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
final class Ea implements Ba {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AbstractC2388j3 f6673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Ca f6674b;

    public Ea(AbstractC2388j3 legacyStrategy, Ca listener) {
        kotlin.jvm.internal.k.e(legacyStrategy, "legacyStrategy");
        kotlin.jvm.internal.k.e(listener, "listener");
        this.f6673a = legacyStrategy;
        this.f6674b = listener;
    }

    @Override // com.ironsource.Ba
    public void a(Ca listener) {
        kotlin.jvm.internal.k.e(listener, "listener");
    }

    @Override // com.ironsource.Ba
    public void b() {
        this.f6673a.b();
    }

    @Override // com.ironsource.Ba
    public void c() {
        this.f6673a.c();
    }

    @Override // com.ironsource.Ba
    public void d() {
        this.f6673a.d();
    }

    @Override // com.ironsource.Ba
    public void e() {
        this.f6673a.e();
    }
}
