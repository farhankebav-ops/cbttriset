package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.ig, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2383ig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC2565t4 f8739a;

    public C2383ig(InterfaceC2565t4 currentTimeProvider) {
        kotlin.jvm.internal.k.e(currentTimeProvider, "currentTimeProvider");
        this.f8739a = currentTimeProvider;
    }

    public final boolean a(long j, long j3) {
        long jA = this.f8739a.a();
        return j3 <= 0 || j <= 0 || jA < j || jA - j > j3;
    }
}
