package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.d6, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2284d6 implements InterfaceC2413ka {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Pe f8203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f8204b;

    public C2284d6(InterfaceC2466n7 applicationLifecycleService, Pe task) {
        kotlin.jvm.internal.k.e(applicationLifecycleService, "applicationLifecycleService");
        kotlin.jvm.internal.k.e(task, "task");
        this.f8203a = task;
        applicationLifecycleService.a(this);
        f();
    }

    private final long e() {
        return System.currentTimeMillis() - this.f8204b;
    }

    private final void f() {
        this.f8204b = System.currentTimeMillis();
    }

    @Override // com.ironsource.InterfaceC2413ka
    public void a() {
        this.f8203a.a(Long.valueOf(e()));
        this.f8203a.run();
    }

    @Override // com.ironsource.InterfaceC2413ka
    public void b() {
        f();
    }

    @Override // com.ironsource.InterfaceC2413ka
    public void c() {
    }

    @Override // com.ironsource.InterfaceC2413ka
    public void d() {
    }
}
