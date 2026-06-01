package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class IJ {
    public static byte[] A09;
    public int A00;
    public int A01;
    public long A02;
    public int A03;
    public int A04;
    public final int A05;
    public final C4J A06;
    public final C4J A07;
    public final boolean A08;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A09, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 78);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A09 = new byte[]{-42, -39, -30, -29, -28, -49, -45, -40, -27, -34, -37, -112, -35, -27, -29, -28, -112, -46, -43, -112, -95};
    }

    public IJ(C4J c4j, C4J c4j2, boolean z2) throws C04222i {
        this.A07 = c4j;
        this.A06 = c4j2;
        this.A08 = z2;
        c4j2.A0f(12);
        this.A05 = c4j2.A0L();
        c4j.A0f(12);
        this.A04 = c4j.A0L();
        GZ.A01(c4j.A0C() == 1, A00(0, 21, 34));
        this.A00 = -1;
    }

    public final boolean A02() {
        long jA0Q;
        int iA0L;
        int i2 = this.A00 + 1;
        this.A00 = i2;
        if (i2 == this.A05) {
            return false;
        }
        if (this.A08) {
            jA0Q = this.A06.A0R();
        } else {
            jA0Q = this.A06.A0Q();
        }
        this.A02 = jA0Q;
        if (this.A00 == this.A03) {
            this.A01 = this.A07.A0L();
            this.A07.A0g(4);
            int i8 = this.A04 - 1;
            this.A04 = i8;
            if (i8 > 0) {
                iA0L = this.A07.A0L() - 1;
            } else {
                iA0L = -1;
            }
            this.A03 = iA0L;
        }
        return true;
    }
}
