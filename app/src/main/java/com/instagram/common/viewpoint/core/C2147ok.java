package com.instagram.common.viewpoint.core;

import android.os.Bundle;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ok, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2147ok implements C1S {
    public final float A00;
    public final float A01;
    public final long A02;
    public final long A03;
    public final long A04;
    public static String[] A05 = {"DHM3ogSyPiOeoDv5bW0AxEOdKkHHyzoj", "DikGrT", "5TP2r3oYS7ZAxQ2Lbh6O1Hwgb27IVuVZ", "BcOsGW4wr7kIZtXNBjWS4kH8Hq7r3t1j", "xCBSo", "o3SRWC", "etImtR6pfOeyK0p12rnN", "VXmJTa"};
    public static final C2147ok A07 = new C2O().A05();
    public static final C1R<C2147ok> A06 = new C1R() { // from class: com.facebook.ads.redexgen.X.ol
        @Override // com.instagram.common.viewpoint.core.C1R
        public final C1S A6X(Bundle bundle) {
            return C2147ok.A00(bundle);
        }
    };

    @Deprecated
    public C2147ok(long j, long j3, long j8, float f4, float f8) {
        this.A04 = j;
        this.A03 = j3;
        this.A02 = j8;
        this.A01 = f4;
        this.A00 = f8;
    }

    public C2147ok(C2O c2o) {
        this(c2o.A04, c2o.A03, c2o.A02, c2o.A01, c2o.A00);
    }

    public static /* synthetic */ C2147ok A00(Bundle bundle) {
        return new C2147ok(bundle.getLong(A01(0), -9223372036854775807L), bundle.getLong(A01(1), -9223372036854775807L), bundle.getLong(A01(2), -9223372036854775807L), bundle.getFloat(A01(3), -3.4028235E38f), bundle.getFloat(A01(4), -3.4028235E38f));
    }

    public static String A01(int i2) {
        return Integer.toString(i2, 36);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2147ok)) {
            return false;
        }
        C2147ok c2147ok = (C2147ok) obj;
        if (this.A04 == c2147ok.A04 && this.A03 == c2147ok.A03) {
            long j = this.A02;
            if (A05[3].charAt(15) == 'f') {
                throw new RuntimeException();
            }
            A05[3] = "Dnbo0S1X4SiwSLqrl4n96G4h1rg7k6Qp";
            if (j == c2147ok.A02) {
                float f4 = this.A01;
                float f8 = c2147ok.A01;
                String[] strArr = A05;
                if (strArr[5].length() != strArr[7].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A05;
                strArr2[0] = "apznZec0lqKPAkNyEzYuPUZE7fb8LaPc";
                strArr2[6] = "99vPzfkBdBLW0Tl0nQsz";
                if (f4 == f8 && this.A00 == c2147ok.A00) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = ((((int) (this.A04 ^ (this.A04 >>> 32))) * 31) + ((int) (this.A03 ^ (this.A03 >>> 32)))) * 31;
        int result = (int) (this.A02 ^ (this.A02 >>> 32));
        return ((((i2 + result) * 31) + (this.A01 != 0.0f ? Float.floatToIntBits(this.A01) : 0)) * 31) + (this.A00 != 0.0f ? Float.floatToIntBits(this.A00) : 0);
    }
}
