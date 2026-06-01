package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1002Pk {
    public static byte[] A02;
    public static String[] A03 = {"eKMrgqlCE6gemHc3i8XP3AKPCikI", "F056EMXFpemItrIKSNHDMT", "UP7tmvacf", "VwJuHcYZb6pOUF9c5fygzqO1xhwXl8", "rbSS0TX92cN6cYo9TUPXDkEXEuy61J", "qalk034xToBy0kTaZmHtwYGALLiE8EwC", "z1", "iDDMQnl7H0FoGDQAr6PhZLTqZy2Xncag"};
    public long A00 = 0;
    public C1002Pk A01;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 37);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{47, 47};
    }

    static {
        A02();
    }

    private void A01() {
        if (this.A01 == null) {
            this.A01 = new C1002Pk();
        }
    }

    public final int A03(int i2) {
        if (this.A01 == null) {
            if (i2 >= 64) {
                return Long.bitCount(this.A00);
            }
            long j = this.A00;
            long j3 = (1 << i2) - 1;
            if (A03[6].length() != 2) {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[3] = "eBNk3oMk3zKdgPZGJWBoIC6ya78Y9W";
            strArr[4] = "SZljZRIwDL4qj86IVN03h7W6Ja49N5";
            return Long.bitCount(j & j3);
        }
        if (i2 < 64) {
            return Long.bitCount(this.A00 & ((1 << i2) - 1));
        }
        return this.A01.A03(i2 - 64) + Long.bitCount(this.A00);
    }

    public final void A04() {
        this.A00 = 0L;
        if (this.A01 != null) {
            C1002Pk c1002Pk = this.A01;
            String[] strArr = A03;
            if (strArr[1].length() == strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[1] = "MSI1mtfoMLAkHcYJR6PW0K";
            strArr2[7] = "fUjJFSbhC3MyLq7bD4XnyNju1VoRa1IS";
            c1002Pk.A04();
        }
    }

    public final void A05(int i2) {
        if (i2 >= 64) {
            if (this.A01 != null) {
                C1002Pk c1002Pk = this.A01;
                int i8 = i2 - 64;
                if (A03[6].length() != 2) {
                    throw new RuntimeException();
                }
                A03[6] = "gh";
                c1002Pk.A05(i8);
                return;
            }
            return;
        }
        this.A00 &= ~(1 << i2);
    }

    public final void A06(int i2) {
        if (i2 >= 64) {
            A01();
            this.A01.A06(i2 - 64);
        } else {
            this.A00 |= 1 << i2;
        }
    }

    public final void A07(int i2, boolean z2) {
        if (i2 >= 64) {
            A01();
            this.A01.A07(i2 - 64, z2);
            return;
        }
        boolean z7 = (this.A00 & Long.MIN_VALUE) != 0;
        long j = (1 << i2) - 1;
        long j3 = this.A00 & j;
        long j8 = this.A00;
        long mask = ~j;
        this.A00 = j3 | ((j8 & mask) << 1);
        if (z2) {
            A06(i2);
        } else {
            A05(i2);
        }
        if (!z7 && this.A01 == null) {
            return;
        }
        A01();
        this.A01.A07(0, z7);
    }

    public final boolean A08(int i2) {
        if (i2 < 64) {
            return (this.A00 & (1 << i2)) != 0;
        }
        A01();
        return this.A01.A08(i2 - 64);
    }

    public final boolean A09(int i2) {
        if (i2 >= 64) {
            A01();
            return this.A01.A09(i2 - 64);
        }
        long j = 1 << i2;
        boolean z2 = (this.A00 & j) != 0;
        long mask = this.A00;
        this.A00 = mask & (~j);
        long j3 = j - 1;
        long j8 = this.A00 & j3;
        long mask2 = this.A00;
        long before = ~j3;
        this.A00 = j8 | Long.rotateRight(mask2 & before, 1);
        if (this.A01 != null) {
            if (this.A01.A08(0)) {
                A06(63);
            }
            this.A01.A09(0);
        }
        return z2;
    }

    public final String toString() {
        return this.A01 == null ? Long.toBinaryString(this.A00) : this.A01.toString() + A00(0, 2, 114) + Long.toBinaryString(this.A00);
    }
}
