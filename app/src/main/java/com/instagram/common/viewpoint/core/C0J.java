package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0J, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0J extends AbstractC03640a {
    public static byte[] A00;
    public static final BZ A01;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 70);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{9, 34, 43, 56, 7, 43, 62, 41, 34, 47, 56, 100, 36, 37, 36, 47, 98, 99};
    }

    static {
        A01();
        A01 = new C0J();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C0J() {
        final String strA00 = A00(0, 18, 12);
        new AbstractC04051p(strA00) { // from class: com.facebook.ads.redexgen.X.0a
            public final String A00;

            {
                this.A00 = (String) AbstractC1819jA.A04(strA00);
            }

            public final String toString() {
                return this.A00;
            }
        };
    }

    @Override // com.instagram.common.viewpoint.core.BZ
    public final int A08(CharSequence sequence, int start) {
        int length = sequence.length();
        AbstractC1819jA.A01(start, length);
        return -1;
    }

    @Override // com.instagram.common.viewpoint.core.BZ
    public final boolean A09(char c7) {
        return false;
    }
}
