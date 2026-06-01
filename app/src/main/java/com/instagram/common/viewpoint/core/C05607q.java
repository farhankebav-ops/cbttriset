package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7q, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C05607q implements InterfaceC1916kk {
    public static byte[] A04;
    public final long A00;
    public final long A01;
    public final long[] A02;
    public final long[] A03;

    static {
        A02();
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C05607q A00(long j, long j3, C0773Gl c0773Gl, C4J c4j) {
        int iA0I;
        long j8 = j3;
        c4j.A0g(10);
        int iA0C = c4j.A0C();
        if (iA0C <= 0) {
            return null;
        }
        int i2 = c0773Gl.A03;
        long jA0U = AbstractC04664a.A0U(iA0C, ((long) (i2 >= 32000 ? 1152 : 576)) * 1000000, i2);
        int iA0M = c4j.A0M();
        int iA0M2 = c4j.A0M();
        int iA0M3 = c4j.A0M();
        c4j.A0g(2);
        long j9 = j8 + ((long) c0773Gl.A02);
        long[] jArr = new long[iA0M];
        long[] jArr2 = new long[iA0M];
        for (int i8 = 0; i8 < iA0M; i8++) {
            jArr[i8] = (((long) i8) * jA0U) / ((long) iA0M);
            jArr2[i8] = Math.max(j8, j9);
            switch (iA0M3) {
                case 1:
                    iA0I = c4j.A0I();
                    break;
                case 2:
                    iA0I = c4j.A0M();
                    break;
                case 3:
                    iA0I = c4j.A0K();
                    break;
                case 4:
                    iA0I = c4j.A0L();
                    break;
                default:
                    return null;
            }
            j8 += ((long) iA0I) * ((long) iA0M2);
        }
        if (j != -1 && j != j8) {
            AnonymousClass44.A07(A01(27, 10, 89), A01(2, 25, 50) + j + A01(0, 2, 80) + j8);
        }
        return new C05607q(jArr, jArr2, jA0U, j8);
    }

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 43);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A04 = new byte[]{-89, -101, -77, -97, -81, -90, 125, -63, -66, -47, -66, 125, -48, -58, -41, -62, 125, -54, -58, -48, -54, -66, -47, -64, -59, -105, 125, -38, -26, -10, -19, -41, -23, -23, -17, -23, -10};
    }

    public C05607q(long[] jArr, long[] jArr2, long j, long j3) {
        this.A03 = jArr;
        this.A02 = jArr2;
        this.A01 = j;
        this.A00 = j3;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1916kk
    public final long A7b() {
        return this.A00;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0784Gw
    public final long A7l() {
        return this.A01;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0784Gw
    public final C0783Gv A8t(long j) {
        int iA0L = AbstractC04664a.A0L(this.A03, j, true, true);
        C0785Gx c0785Gx = new C0785Gx(this.A03[iA0L], this.A02[iA0L]);
        if (c0785Gx.A01 < j) {
            int tableIndex = this.A03.length;
            if (iA0L != tableIndex - 1) {
                int tableIndex2 = iA0L + 1;
                long j3 = this.A03[tableIndex2];
                int tableIndex3 = iA0L + 1;
                C0785Gx nextSeekPoint = new C0785Gx(j3, this.A02[tableIndex3]);
                return new C0783Gv(c0785Gx, nextSeekPoint);
            }
        }
        return new C0783Gv(c0785Gx);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1916kk
    public final long A99(long j) {
        return this.A03[AbstractC04664a.A0L(this.A02, j, true, true)];
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0784Gw
    public final boolean AAa() {
        return true;
    }
}
