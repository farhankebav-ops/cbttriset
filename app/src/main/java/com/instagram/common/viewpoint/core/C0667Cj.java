package com.instagram.common.viewpoint.core;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Cj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0667Cj {
    public static String[] A07 = {"1TUPUvqjuckMieKxy618dXqeho2I2nXO", "1tw", "Rv8BHxt03y9lIrpcW4kHhbfWsqmFKBVK", "r8Px", "D2vXeeTjlCXB4Odv", "hN", "uuD40", "TpLNmCJV5wG1YwTXf3toM93vl9iWeWk7"};
    public long A00;
    public C1996mG A01;
    public C1996mG A02;
    public C1996mG A03;
    public final int A04;
    public final C4J A05 = new C4J(32);
    public final EO A06;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C1996mG A04(C1996mG c1996mG, C2076nY c2076nY, C0669Cl c0669Cl, C4J c4j) {
        int iA0M;
        long j = c0669Cl.A01;
        c4j.A0d(1);
        C1996mG c1996mGA03 = A03(c1996mG, j, c4j.A0l(), 1);
        long j3 = j + 1;
        byte b8 = c4j.A0l()[0];
        boolean z2 = (b8 & 128) != 0;
        int i2 = b8 & 127;
        C5N c5n = c2076nY.A05;
        if (c5n.A04 == null) {
            c5n.A04 = new byte[16];
        } else {
            Arrays.fill(c5n.A04, (byte) 0);
        }
        C1996mG c1996mGA032 = A03(c1996mGA03, j3, c5n.A04, i2);
        long j8 = j3 + ((long) i2);
        if (z2) {
            c4j.A0d(2);
            c1996mGA032 = A03(c1996mGA032, j8, c4j.A0l(), 2);
            j8 += 2;
            iA0M = c4j.A0M();
        } else {
            iA0M = 1;
            if (A07[7].charAt(5) == 'i') {
                throw new RuntimeException();
            }
            A07[7] = "Hpyz1f8ALnZx1iP9R6alck8MxH3P54oK";
        }
        int[] iArr = c5n.A06;
        if (iArr == null || iArr.length < iA0M) {
            iArr = new int[iA0M];
        }
        int[] iArr2 = c5n.A07;
        if (iArr2 == null || iArr2.length < iA0M) {
            iArr2 = new int[iA0M];
        }
        if (z2) {
            int i8 = iA0M * 6;
            c4j.A0d(i8);
            c1996mGA032 = A03(c1996mGA032, j8, c4j.A0l(), i8);
            j8 += (long) i8;
            c4j.A0f(0);
            for (int i9 = 0; i9 < iA0M; i9++) {
                iArr[i9] = c4j.A0M();
                iArr2[i9] = c4j.A0L();
            }
        } else {
            iArr[0] = 0;
            iArr2[0] = c0669Cl.A00 - ((int) (j8 - c0669Cl.A01));
        }
        C0787Gz c0787Gz = (C0787Gz) AbstractC04664a.A0f(c0669Cl.A02);
        c5n.A02(iA0M, iArr, iArr2, c0787Gz.A03, c5n.A04, c0787Gz.A01, c0787Gz.A02, c0787Gz.A00);
        int i10 = (int) (j8 - c0669Cl.A01);
        c0669Cl.A01 += (long) i10;
        if (A07[0].charAt(1) == 'T') {
            A07[0] = "nTpP9ibfF3cbwjVbkTA4UIhNPpZui5fl";
            c0669Cl.A00 -= i10;
            return c1996mGA032;
        }
        String[] strArr = A07;
        strArr[3] = "b8i1";
        strArr[6] = "bRWrT";
        c0669Cl.A00 -= i10;
        return c1996mGA032;
    }

    public C0667Cj(EO eo) {
        this.A06 = eo;
        this.A04 = eo.A8A();
        this.A01 = new C1996mG(0L, this.A04);
        this.A02 = this.A01;
        this.A03 = this.A01;
    }

    private int A00(int i2) {
        if (this.A03.A03 == null) {
            this.A03.A03(this.A06.A41(), new C1996mG(this.A03.A00, this.A04));
        }
        return Math.min(i2, (int) (this.A03.A00 - this.A00));
    }

    public static C1996mG A01(C1996mG c1996mG, long j) {
        while (j >= c1996mG.A00) {
            c1996mG = c1996mG.A02;
        }
        return c1996mG;
    }

    public static C1996mG A02(C1996mG c1996mG, long j, ByteBuffer byteBuffer, int i2) {
        C1996mG c1996mGA01 = A01(c1996mG, j);
        while (i2 > 0) {
            int remaining = (int) (c1996mGA01.A00 - j);
            int iMin = Math.min(i2, remaining);
            byte[] bArr = c1996mGA01.A03.A01;
            int remaining2 = c1996mGA01.A00(j);
            byteBuffer.put(bArr, remaining2, iMin);
            i2 -= iMin;
            j += (long) iMin;
            if (j == c1996mGA01.A00) {
                c1996mGA01 = c1996mGA01.A02;
            }
        }
        return c1996mGA01;
    }

    public static C1996mG A03(C1996mG c1996mG, long j, byte[] bArr, int i2) {
        C1996mG c1996mGA01 = A01(c1996mG, j);
        int i8 = i2;
        while (i8 > 0) {
            int iMin = Math.min(i8, (int) (c1996mGA01.A00 - j));
            byte[] bArr2 = c1996mGA01.A03.A01;
            int toCopy = c1996mGA01.A00(j);
            int remaining = i2 - i8;
            System.arraycopy(bArr2, toCopy, bArr, remaining, iMin);
            i8 -= iMin;
            j += (long) iMin;
            if (j == c1996mGA01.A00) {
                c1996mGA01 = c1996mGA01.A02;
            }
        }
        return c1996mGA01;
    }

    public static C1996mG A05(C1996mG c1996mG, C2076nY c2076nY, C0669Cl c0669Cl, C4J c4j) {
        if (c2076nY.A0E()) {
            c1996mG = A04(c1996mG, c2076nY, c0669Cl, c4j);
        }
        if (c2076nY.A03()) {
            c4j.A0d(4);
            C1996mG c1996mGA03 = A03(c1996mG, c0669Cl.A01, c4j.A0l(), 4);
            int iA0L = c4j.A0L();
            c0669Cl.A01 += 4;
            c0669Cl.A00 -= 4;
            c2076nY.A0C(iA0L);
            C1996mG c1996mGA02 = A02(c1996mGA03, c0669Cl.A01, c2076nY.A02, iA0L);
            c0669Cl.A01 += (long) iA0L;
            c0669Cl.A00 -= iA0L;
            c2076nY.A0D(c0669Cl.A00);
            return A02(c1996mGA02, c0669Cl.A01, c2076nY.A03, c0669Cl.A00);
        }
        c2076nY.A0C(c0669Cl.A00);
        return A02(c1996mG, c0669Cl.A01, c2076nY.A02, c0669Cl.A00);
    }

    private void A06(int i2) {
        this.A00 += (long) i2;
        if (this.A00 == this.A03.A00) {
            this.A03 = this.A03.A02;
        }
    }

    private void A07(C1996mG c1996mG) {
        if (c1996mG.A03 == null) {
            return;
        }
        this.A06.AGu(c1996mG);
        c1996mG.A01();
    }

    public final int A08(AnonymousClass20 anonymousClass20, int i2, boolean z2) throws IOException {
        int i8 = anonymousClass20.read(this.A03.A03.A01, this.A03.A00(this.A00), A00(i2));
        if (i8 == -1) {
            if (z2) {
                return -1;
            }
            throw new EOFException();
        }
        A06(i8);
        return i8;
    }

    public final long A09() {
        return this.A00;
    }

    public final void A0A() {
        A07(this.A01);
        this.A01.A02(0L, this.A04);
        this.A02 = this.A01;
        this.A03 = this.A01;
        this.A00 = 0L;
        this.A06.AJi();
    }

    public final void A0B() {
        this.A02 = this.A01;
    }

    public final void A0C(long j) {
        if (j == -1) {
            return;
        }
        while (j >= this.A01.A00) {
            this.A06.AGt(this.A01.A03);
            this.A01 = this.A01.A01();
        }
        long j3 = this.A02.A01;
        long j8 = this.A01.A01;
        String[] strArr = A07;
        if (strArr[3].length() == strArr[6].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A07;
        strArr2[3] = "kTcq";
        strArr2[6] = "Dj6YZ";
        if (j3 < j8) {
            this.A02 = this.A01;
        }
    }

    public final void A0D(C4J c4j, int i2) {
        while (i2 > 0) {
            int iA00 = A00(i2);
            byte[] bArr = this.A03.A03.A01;
            int bytesAppended = this.A03.A00(this.A00);
            c4j.A0k(bArr, bytesAppended, iA00);
            i2 -= iA00;
            A06(iA00);
        }
    }

    public final void A0E(C2076nY c2076nY, C0669Cl c0669Cl) {
        A05(this.A02, c2076nY, c0669Cl, this.A05);
    }

    public final void A0F(C2076nY c2076nY, C0669Cl c0669Cl) {
        this.A02 = A05(this.A02, c2076nY, c0669Cl, this.A05);
    }
}
