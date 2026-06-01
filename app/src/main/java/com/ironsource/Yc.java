package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Yc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f7869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final P3 f7870b;

    public Yc(long j, P3 unit) {
        kotlin.jvm.internal.k.e(unit, "unit");
        this.f7869a = j;
        this.f7870b = unit;
    }

    public final long a() {
        return this.f7869a;
    }

    public final P3 b() {
        return this.f7870b;
    }

    public String toString() {
        return "PacingCappingConfig(timeInterval=" + this.f7869a + " unit=" + this.f7870b + ")";
    }

    public /* synthetic */ Yc(long j, P3 p3, int i2, kotlin.jvm.internal.f fVar) {
        this(j, (i2 & 2) != 0 ? P3.Second : p3);
    }
}
