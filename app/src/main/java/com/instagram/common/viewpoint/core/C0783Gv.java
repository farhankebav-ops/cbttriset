package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0783Gv {
    public static byte[] A02;
    public static String[] A03 = {"", "4aEfCmC", "2kTu4wHTiMw5FCYmIpZKoA3S7RkYvI9O", "", "w", "MqF3b2p", "5cCqnzmPstBPsSiWHPZbbxeHAyWMz3nO", "kSg1dz9TqTWY2puBAJqsQN0JUmM78NMM"};
    public final C0785Gx A00;
    public final C0785Gx A01;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 82);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{27, 23, 123, 7};
    }

    static {
        A01();
    }

    public C0783Gv(C0785Gx c0785Gx) {
        this(c0785Gx, c0785Gx);
    }

    public C0783Gv(C0785Gx c0785Gx, C0785Gx c0785Gx2) {
        this.A00 = (C0785Gx) C3M.A01(c0785Gx);
        this.A01 = (C0785Gx) C3M.A01(c0785Gx2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0783Gv c0783Gv = (C0783Gv) obj;
        if (A03[7].charAt(24) != 'U') {
            throw new RuntimeException();
        }
        A03[4] = "g";
        return this.A00.equals(c0783Gv.A00) && this.A01.equals(c0783Gv.A01);
    }

    public final int hashCode() {
        return (this.A00.hashCode() * 31) + this.A01.hashCode();
    }

    public final String toString() {
        String strA00;
        StringBuilder sbAppend = new StringBuilder().append(A00(2, 1, 114)).append(this.A00);
        if (!this.A00.equals(this.A01)) {
            strA00 = A00(0, 2, 101) + this.A01;
        } else {
            if (A03[0].length() != 0) {
                throw new RuntimeException();
            }
            A03[0] = "";
            strA00 = A00(0, 0, 76);
        }
        return sbAppend.append(strA00).append(A00(3, 1, 8)).toString();
    }
}
