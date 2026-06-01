package com.instagram.common.viewpoint.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0771Gj {
    public static byte[] A09;
    public static String[] A0A = {"EsB1Svc2O0r", "neXgiGAVZF2hPSW", "e5UrGC6TzR", "xWVfqfZ1XD25z1nFBwMIBfHnywy3RQhb", "m9mgew9TdIxun9z0pjAF4NJPGlbJBstI", "nE", "RVA0jPrNpk", "4CgUEtTVWe3Kq65nNHH5xBV3YKPxdnIZ"};
    public final float A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final String A07;
    public final List<byte[]> A08;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C0771Gj A00(C4J c4j) throws C04222i {
        try {
            c4j.A0g(21);
            int iA0I = c4j.A0I() & 3;
            int iA0I2 = c4j.A0I();
            int i2 = 0;
            int iA09 = c4j.A09();
            for (int i8 = 0; i8 < iA0I2; i8++) {
                c4j.A0g(1);
                int iA0M = c4j.A0M();
                for (int i9 = 0; i9 < iA0M; i9++) {
                    int iA0M2 = c4j.A0M();
                    i2 += iA0M2 + 4;
                    c4j.A0g(iA0M2);
                }
            }
            c4j.A0f(iA09);
            byte[] bArr = new byte[i2];
            int i10 = 0;
            int i11 = -1;
            int i12 = -1;
            int i13 = -1;
            int i14 = -1;
            int i15 = -1;
            float f4 = 1.0f;
            String strA03 = null;
            for (int i16 = 0; i16 < iA0I2; i16++) {
                int iA0I3 = c4j.A0I() & 63;
                int iA0M3 = c4j.A0M();
                for (int i17 = 0; i17 < iA0M3; i17++) {
                    int iA0M4 = c4j.A0M();
                    System.arraycopy(AbstractC0778Gq.A03, 0, bArr, i10, AbstractC0778Gq.A03.length);
                    int length = i10 + AbstractC0778Gq.A03.length;
                    System.arraycopy(c4j.A0l(), c4j.A09(), bArr, length, iA0M4);
                    if (iA0I3 == 33 && i17 == 0) {
                        C0775Gn c0775GnA05 = AbstractC0778Gq.A05(bArr, length, length + iA0M4);
                        i11 = c0775GnA05.A0A;
                        i12 = c0775GnA05.A08;
                        i13 = c0775GnA05.A02;
                        i14 = c0775GnA05.A01;
                        i15 = c0775GnA05.A03;
                        f4 = c0775GnA05.A00;
                        strA03 = C3U.A03(c0775GnA05.A07, c0775GnA05.A0B, c0775GnA05.A06, c0775GnA05.A05, c0775GnA05.A0C, c0775GnA05.A04);
                    }
                    i10 = length + iA0M4;
                    c4j.A0g(iA0M4);
                }
            }
            return new C0771Gj(i2 == 0 ? Collections.emptyList() : Collections.singletonList(bArr), iA0I + 1, i11, i12, f4, strA03, i13, i14, i15);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw C04222i.A01(A01(0, 25, 126), e);
        }
    }

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A09, i2, i2 + i8);
        int i10 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A0A[5].length() == 29) {
                throw new RuntimeException();
            }
            A0A[5] = "YyBlh7kREcvGfk8zeLahZrRMr2fR36";
            if (i10 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 68);
            i10++;
        }
    }

    public static void A02() {
        A09 = new byte[]{127, 72, 72, 85, 72, 26, 74, 91, 72, 73, 83, 84, 93, 26, 114, 127, 108, 121, 26, 89, 85, 84, 92, 83, 93};
    }

    static {
        A02();
    }

    public C0771Gj(List<byte[]> initializationData, int i2, int i8, int i9, float f4, String str, int i10, int i11, int i12) {
        this.A08 = initializationData;
        this.A05 = i2;
        this.A06 = i8;
        this.A04 = i9;
        this.A00 = f4;
        this.A07 = str;
        this.A02 = i10;
        this.A01 = i11;
        this.A03 = i12;
    }
}
