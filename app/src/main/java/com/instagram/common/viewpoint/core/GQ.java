package com.instagram.common.viewpoint.core;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class GQ {
    public static byte[] A04;
    public static String[] A05 = {"uP2VmRjmPrkQ", "gRGWgf4lLYF9Rif8PQPDNbGokb9BUMtV", "bSjOyzwe8Lqn79dPeHIi8kfJVgfNJaEZ", "7R1XMZQjg8S2TiXm1wE8kLqT1leJFKD3", "sD", "qKJRf3b", "Q40N8hoONMcQBFaHNU", "iAP6W7CwppN1UlUQVXHbR"};
    public GK A00;
    public final int A01;
    public final C1950lV A02;
    public final GP A03;

    public static String A02(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 35);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A04 = new byte[]{7, 32, 56, 47, 34, 39, 42, 110, 45, 47, 61, 43};
    }

    static {
        A03();
    }

    public GQ(GL gl, GP gp, long j, long j3, long j8, long j9, long j10, long j11, int i2) {
        this.A03 = gp;
        this.A01 = i2;
        this.A02 = new C1950lV(gl, j, j3, j8, j9, j10, j11);
    }

    private final int A00(InterfaceC1943lN interfaceC1943lN, long j, C0781Gt c0781Gt) {
        if (j != interfaceC1943lN.A8f()) {
            c0781Gt.A00 = j;
            return 1;
        }
        if (A05[5].length() != 7) {
            throw new RuntimeException();
        }
        A05[4] = "eb0wJDSKJb6zWnRAqReB9UTGfXv";
        return 0;
    }

    private final GK A01(long j) {
        return new GK(j, this.A02.A05(j), this.A02.A05, this.A02.A02, this.A02.A04, this.A02.A01, this.A02.A00);
    }

    private final void A04(boolean z2, long j) {
        this.A00 = null;
        this.A03.AFA();
    }

    private final boolean A05(InterfaceC1943lN interfaceC1943lN, long j) throws IOException {
        long jA8f = j - interfaceC1943lN.A8f();
        if (jA8f >= 0 && jA8f <= 262144) {
            interfaceC1943lN.AJJ((int) jA8f);
            return true;
        }
        return false;
    }

    public final int A06(InterfaceC1943lN interfaceC1943lN, C0781Gt c0781Gt) throws IOException {
        while (true) {
            GK gk = (GK) C3M.A02(this.A00);
            long jA01 = gk.A01();
            long jA00 = gk.A00();
            long jA02 = gk.A02();
            if (jA00 - jA01 <= this.A01) {
                A04(false, jA01);
                String[] strArr = A05;
                if (strArr[3].charAt(1) != strArr[1].charAt(1)) {
                    throw new RuntimeException();
                }
                A05[5] = "cjf3Phs";
                return A00(interfaceC1943lN, jA01, c0781Gt);
            }
            if (!A05(interfaceC1943lN, jA02)) {
                return A00(interfaceC1943lN, jA02, c0781Gt);
            }
            interfaceC1943lN.AI1();
            GN gnAIC = this.A03.AIC(interfaceC1943lN, gk.A04());
            switch (gnAIC.A00) {
                case -3:
                    A04(false, jA02);
                    return A00(interfaceC1943lN, jA02, c0781Gt);
                case -2:
                    gk.A0D(gnAIC.A02, gnAIC.A01);
                    break;
                case -1:
                    gk.A0C(gnAIC.A02, gnAIC.A01);
                    break;
                case 0:
                    A05(interfaceC1943lN, gnAIC.A01);
                    long floorPosition = gnAIC.A01;
                    A04(true, floorPosition);
                    return A00(interfaceC1943lN, gnAIC.A01, c0781Gt);
                default:
                    throw new IllegalStateException(A02(0, 12, 109));
            }
        }
    }

    public final C1950lV A07() {
        return this.A02;
    }

    public final void A08(long j) {
        if (this.A00 != null && this.A00.A03() == j) {
            return;
        }
        this.A00 = A01(j);
    }

    public final boolean A09() {
        return this.A00 != null;
    }
}
