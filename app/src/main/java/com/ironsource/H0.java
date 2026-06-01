package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class H0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f6891a;

    public H0(long j) {
        this.f6891a = j;
    }

    public final long a() {
        return this.f6891a;
    }

    public final long b() {
        return this.f6891a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof H0) && this.f6891a == ((H0) obj).f6891a;
    }

    public int hashCode() {
        long j = this.f6891a;
        return (int) (j ^ (j >>> 32));
    }

    public String toString() {
        return "AdUnitInteractionData(impressionTimeout=" + this.f6891a + ")";
    }

    public final H0 a(long j) {
        return new H0(j);
    }

    public static /* synthetic */ H0 a(H0 h0, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = h0.f6891a;
        }
        return h0.a(j);
    }
}
