package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1913kh implements IL {
    public static byte[] A03;
    public final int A00;
    public final int A01;
    public final C4J A02;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 108);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{65, 77, 30, 25, 30, 23, 77, 30, 12, 0, 29, 1, 8, 77, 30, 4, 23, 8, 87, 77, 70, 115, 104, 106, 87, 102, 117, 116, 98, 117, 116, 9, 61, 44, 33, 39, 104, 59, 41, 37, 56, 36, 45, 104, 59, 33, 50, 45, 104, 37, 33, 59, 37, 41, 60, 43, 32, 102, 104, 59, 60, 59, 44, 104, 59, 41, 37, 56, 36, 45, 104, 59, 33, 50, 45, 114, 104, 25, 13, 28, 17, 23, 87, 10, 25, 15};
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C1913kh(com.instagram.common.viewpoint.core.C1914ki r7, com.instagram.common.viewpoint.core.C2154or r8) {
        /*
            r6 = this;
            r6.<init>()
            com.facebook.ads.redexgen.X.4J r0 = r7.A00
            r6.A02 = r0
            com.facebook.ads.redexgen.X.4J r1 = r6.A02
            r0 = 12
            r1.A0f(r0)
            com.facebook.ads.redexgen.X.4J r0 = r6.A02
            int r5 = r0.A0L()
            r2 = 77
            r1 = 9
            r0 = 20
            java.lang.String r1 = A00(r2, r1, r0)
            java.lang.String r0 = r8.A0W
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L6d
            int r1 = r8.A0C
            int r0 = r8.A06
            int r4 = com.instagram.common.viewpoint.core.AbstractC04664a.A06(r1, r0)
            if (r5 == 0) goto L34
            int r0 = r5 % r4
            if (r0 == 0) goto L6d
        L34:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r2 = 31
            r1 = 46
            r0 = 36
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.StringBuilder r3 = r0.append(r4)
            r2 = 0
            r1 = 20
            r0 = 1
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.String r3 = r0.toString()
            r2 = 20
            r1 = 11
            r0 = 107(0x6b, float:1.5E-43)
            java.lang.String r0 = A00(r2, r1, r0)
            com.instagram.common.viewpoint.core.AnonymousClass44.A07(r0, r3)
            r5 = r4
        L6d:
            if (r5 != 0) goto L70
            r5 = -1
        L70:
            r6.A00 = r5
            com.facebook.ads.redexgen.X.4J r0 = r6.A02
            int r0 = r0.A0L()
            r6.A01 = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C1913kh.<init>(com.facebook.ads.redexgen.X.ki, com.facebook.ads.redexgen.X.or):void");
    }

    @Override // com.instagram.common.viewpoint.core.IL
    public final int A82() {
        return this.A00;
    }

    @Override // com.instagram.common.viewpoint.core.IL
    public final int A8n() {
        return this.A01;
    }

    @Override // com.instagram.common.viewpoint.core.IL
    public final int AGi() {
        return this.A00 == -1 ? this.A02.A0L() : this.A00;
    }
}
