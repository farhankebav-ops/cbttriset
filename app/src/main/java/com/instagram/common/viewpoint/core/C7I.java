package com.instagram.common.viewpoint.core;

import androidx.core.location.LocationRequestCompat;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7I, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C7I {
    public final long A00;
    public final long A01;
    public static final C7I A04 = new C7I(0, 0);
    public static final C7I A02 = new C7I(LocationRequestCompat.PASSIVE_INTERVAL, LocationRequestCompat.PASSIVE_INTERVAL);
    public static final C7I A06 = new C7I(LocationRequestCompat.PASSIVE_INTERVAL, 0);
    public static final C7I A05 = new C7I(0, LocationRequestCompat.PASSIVE_INTERVAL);
    public static final C7I A03 = A04;

    public C7I(long j, long j3) {
        C3M.A07(j >= 0);
        C3M.A07(j3 >= 0);
        this.A01 = j;
        this.A00 = j3;
    }

    public final long A00(long minPositionUs, long j, long j3) {
        if (this.A01 == 0 && this.A00 == 0) {
            return minPositionUs;
        }
        long jA0V = AbstractC04664a.A0V(minPositionUs, this.A01, Long.MIN_VALUE);
        long jA0S = AbstractC04664a.A0S(minPositionUs, this.A00, LocationRequestCompat.PASSIVE_INTERVAL);
        boolean z2 = true;
        boolean z7 = jA0V <= j && j <= jA0S;
        if (jA0V > j3 || j3 > jA0S) {
            z2 = false;
        }
        if (z7 && z2) {
            long jAbs = Math.abs(j - minPositionUs);
            long maxPositionUs = Math.abs(j3 - minPositionUs);
            if (jAbs <= maxPositionUs) {
                return j;
            }
            return j3;
        }
        if (z7) {
            return j;
        }
        if (z2) {
            return j3;
        }
        return jA0V;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C7I c7i = (C7I) obj;
        return this.A01 == c7i.A01 && this.A00 == c7i.A00;
    }

    public final int hashCode() {
        return (((int) this.A01) * 31) + ((int) this.A00);
    }
}
