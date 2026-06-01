package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class Xe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final N f7798a;

    public Xe(N n2) {
        this.f7798a = n2;
    }

    public final N a() {
        return this.f7798a;
    }

    public abstract EnumC2311ef b();

    public final C2577u a(Lb<Xe, C2577u> mapper) {
        kotlin.jvm.internal.k.e(mapper, "mapper");
        return mapper.a(this);
    }
}
