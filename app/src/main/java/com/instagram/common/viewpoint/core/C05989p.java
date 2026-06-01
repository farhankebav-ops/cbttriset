package com.instagram.common.viewpoint.core;

import android.os.Bundle;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9p, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C05989p extends AbstractC2132oU {
    public static byte[] A02;
    public static String[] A03 = {"Ze0y2PQb31vngbi38k5mfZCC", "5", "jLmR5cr6Hwks3p4PsKfIxGU921nipvRD", "Pp3qhBBlWU8bouyoK5QiOWA", "ww40dK", "331B", "UQZ2ltoBgBcCSgXWY09raSZ", "C"};
    public static final C1R<C05989p> A04;
    public static final String A05;
    public static final String A06;
    public final float A00;
    public final int A01;

    public static String A02(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i2, i2 + i8);
        int i10 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A03;
            if (strArr[5].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            A03[4] = "26ayShss4mhG1SZ6mAOlhU0";
            if (i10 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 13);
            i10++;
        }
    }

    public static void A03() {
        A02 = new byte[]{-108, -120, -97, 122, -101, -120, -103, -102, 71, -108, -100, -102, -101, 71, -119, -116, 71, -120, 71, -105, -106, -102, -112, -101, -112, -99, -116, 71, -112, -107, -101, -116, -114, -116, -103, -68, -67, -86, -69, -101, -86, -67, -78, -73, -80, 105, -78, -68, 105, -72, -66, -67, 105, -72, -81, 105, -69, -86, -73, -80, -82, 105, -92, 121, 117, 105, -74, -86, -63, -100, -67, -86, -69, -68, -90};
    }

    static {
        A03();
        A05 = AbstractC04664a.A0h(1);
        A06 = AbstractC04664a.A0h(2);
        A04 = new C1R() { // from class: com.facebook.ads.redexgen.X.oT
            @Override // com.instagram.common.viewpoint.core.C1R
            public final C1S A6X(Bundle bundle) {
                return C05989p.A00(bundle);
            }
        };
    }

    public C05989p(int i2) {
        C3M.A09(i2 > 0, A02(0, 35, 26));
        this.A01 = i2;
        this.A00 = -1.0f;
    }

    public C05989p(int i2, float f4) {
        C3M.A09(i2 > 0, A02(0, 35, 26));
        C3M.A09(f4 >= 0.0f && f4 <= ((float) i2), A02(35, 40, 60));
        this.A01 = i2;
        this.A00 = f4;
    }

    public static C05989p A00(Bundle bundle) {
        C3M.A07(bundle.getInt(AbstractC2132oU.A02, -1) == 2);
        int i2 = bundle.getInt(A05, 5);
        float starRating = bundle.getFloat(A06, -1.0f);
        if (starRating == -1.0f) {
            return new C05989p(i2);
        }
        return new C05989p(i2, starRating);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C05989p)) {
            return false;
        }
        C05989p c05989p = (C05989p) obj;
        return this.A01 == c05989p.A01 && this.A00 == c05989p.A00;
    }

    public final int hashCode() {
        return BX.A00(Integer.valueOf(this.A01), Float.valueOf(this.A00));
    }
}
