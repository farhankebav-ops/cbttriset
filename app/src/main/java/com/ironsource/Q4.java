package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Q4 implements InterfaceC2551s7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Boolean f7424a;

    public Q4(Boolean bool) {
        this.f7424a = bool;
    }

    @Override // com.ironsource.InterfaceC2551s7
    public Object a() {
        Boolean bool = this.f7424a;
        return bool == null ? r2.q.M(new Exception("enabled flag is not provided or invalid")) : bool;
    }
}
