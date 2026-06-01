package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.w3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractC2615w3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f10476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final C2452md f10477d;

    public AbstractC2615w3(int i2, String placementName, boolean z2, C2452md c2452md) {
        kotlin.jvm.internal.k.e(placementName, "placementName");
        this.f10474a = i2;
        this.f10475b = placementName;
        this.f10476c = z2;
        this.f10477d = c2452md;
    }

    public final C2452md a() {
        return this.f10477d;
    }

    public final int b() {
        return this.f10474a;
    }

    public final String c() {
        return this.f10475b;
    }

    public final boolean d() {
        return this.f10476c;
    }

    public String toString() {
        return a1.a.l("placement name: ", this.f10475b);
    }

    public final boolean a(int i2) {
        return this.f10474a == i2;
    }

    public /* synthetic */ AbstractC2615w3(int i2, String str, boolean z2, C2452md c2452md, int i8, kotlin.jvm.internal.f fVar) {
        this((i8 & 1) != 0 ? 0 : i2, str, (i8 & 4) != 0 ? false : z2, (i8 & 8) != 0 ? null : c2452md);
    }
}
