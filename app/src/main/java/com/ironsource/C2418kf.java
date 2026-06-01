package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.kf, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2418kf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final P3 f8868b;

    public C2418kf(int i2, P3 unit) {
        kotlin.jvm.internal.k.e(unit, "unit");
        this.f8867a = i2;
        this.f8868b = unit;
    }

    public final int a() {
        return this.f8867a;
    }

    public final P3 b() {
        return this.f8868b;
    }

    public String toString() {
        return "ShowCountCappingConfig(maxImpressions=" + this.f8867a + ", unit=" + this.f8868b + ")";
    }
}
