package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.u;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
final class C2455b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u.d f9018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f9019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f9020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f9021d;

    public C2455b(u.d sdkState, boolean z2, boolean z7, boolean z8) {
        kotlin.jvm.internal.k.e(sdkState, "sdkState");
        this.f9018a = sdkState;
        this.f9019b = z2;
        this.f9020c = z7;
        this.f9021d = z8;
    }

    public final u.d a() {
        return this.f9018a;
    }

    public final boolean b() {
        return this.f9019b;
    }

    public final boolean c() {
        return this.f9020c;
    }

    public final boolean d() {
        return this.f9021d;
    }

    public final u.d e() {
        return this.f9018a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2455b)) {
            return false;
        }
        C2455b c2455b = (C2455b) obj;
        return this.f9018a == c2455b.f9018a && this.f9019b == c2455b.f9019b && this.f9020c == c2455b.f9020c && this.f9021d == c2455b.f9021d;
    }

    public final boolean f() {
        return this.f9021d;
    }

    public final boolean g() {
        return this.f9020c;
    }

    public final boolean h() {
        return this.f9019b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = this.f9018a.hashCode() * 31;
        boolean z2 = this.f9019b;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i2 = (iHashCode + r1) * 31;
        boolean z7 = this.f9020c;
        ?? r12 = z7;
        if (z7) {
            r12 = 1;
        }
        int i8 = (i2 + r12) * 31;
        boolean z8 = this.f9021d;
        return i8 + (z8 ? 1 : z8);
    }

    public String toString() {
        return "AdUnitInitStateInfo(sdkState=" + this.f9018a + ", isRetryForMoreThan15Secs=" + this.f9019b + ", isDemandOnlyInitRequested=" + this.f9020c + ", isAdUnitInitRequested=" + this.f9021d + ")";
    }

    public final C2455b a(u.d sdkState, boolean z2, boolean z7, boolean z8) {
        kotlin.jvm.internal.k.e(sdkState, "sdkState");
        return new C2455b(sdkState, z2, z7, z8);
    }

    public static /* synthetic */ C2455b a(C2455b c2455b, u.d dVar, boolean z2, boolean z7, boolean z8, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            dVar = c2455b.f9018a;
        }
        if ((i2 & 2) != 0) {
            z2 = c2455b.f9019b;
        }
        if ((i2 & 4) != 0) {
            z7 = c2455b.f9020c;
        }
        if ((i2 & 8) != 0) {
            z8 = c2455b.f9021d;
        }
        return c2455b.a(dVar, z2, z7, z8);
    }
}
