package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Ha {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f6918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f6919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f6920c;

    public Ha(long j, long j3, boolean z2) {
        this.f6918a = j;
        this.f6919b = j3;
        this.f6920c = z2;
    }

    public final long a() {
        return this.f6918a;
    }

    public final long b() {
        return this.f6919b;
    }

    public final boolean c() {
        return this.f6920c;
    }

    public final long d() {
        return this.f6918a;
    }

    public final long e() {
        return this.f6919b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Ha)) {
            return false;
        }
        Ha ha = (Ha) obj;
        return this.f6918a == ha.f6918a && this.f6919b == ha.f6919b && this.f6920c == ha.f6920c;
    }

    public final boolean f() {
        return this.f6920c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        long j = this.f6918a;
        long j3 = this.f6919b;
        int i2 = ((((int) (j ^ (j >>> 32))) * 31) + ((int) ((j3 >>> 32) ^ j3))) * 31;
        boolean z2 = this.f6920c;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return i2 + r1;
    }

    public String toString() {
        long j = this.f6918a;
        long j3 = this.f6919b;
        boolean z2 = this.f6920c;
        StringBuilder sbT = androidx.camera.core.processing.util.a.t("LevelPlayBannerReloadAdUnitStrategyConfig(refreshInterval=", j, ", visibilityCheckerInterval=");
        sbT.append(j3);
        sbT.append(", isAutoRefreshEnabled=");
        sbT.append(z2);
        sbT.append(")");
        return sbT.toString();
    }

    public final Ha a(long j, long j3, boolean z2) {
        return new Ha(j, j3, z2);
    }

    public static /* synthetic */ Ha a(Ha ha, long j, long j3, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = ha.f6918a;
        }
        long j8 = j;
        if ((i2 & 2) != 0) {
            j3 = ha.f6919b;
        }
        long j9 = j3;
        if ((i2 & 4) != 0) {
            z2 = ha.f6920c;
        }
        return ha.a(j8, j9, z2);
    }
}
