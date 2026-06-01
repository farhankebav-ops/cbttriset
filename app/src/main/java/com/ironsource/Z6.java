package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Z6 implements InterfaceC2231a7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f7896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EnumC2285d7 f7897b;

    public Z6(long j, EnumC2285d7 recoveryStrategy) {
        kotlin.jvm.internal.k.e(recoveryStrategy, "recoveryStrategy");
        this.f7896a = j;
        this.f7897b = recoveryStrategy;
    }

    @Override // com.ironsource.InterfaceC2231a7
    public long a() {
        return this.f7896a;
    }

    @Override // com.ironsource.InterfaceC2231a7
    public EnumC2285d7 b() {
        return this.f7897b;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Z6(C2267c7 feature) {
        this(feature.a(), feature.c());
        kotlin.jvm.internal.k.e(feature, "feature");
    }
}
