package com.instagram.common.viewpoint.core;

import java.math.RoundingMode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.mv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2037mv implements InterfaceC05708d {
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;

    public C2037mv(C05788o c05788o) {
        this.A02 = c05788o.A02;
        this.A01 = c05788o.A01;
        this.A05 = c05788o.A05;
        this.A04 = c05788o.A04;
        this.A03 = c05788o.A03;
        this.A00 = c05788o.A00;
    }

    public static int A00(int i2) {
        switch (i2) {
            case 5:
                return 80000;
            case 6:
            case 18:
                return 768000;
            case 7:
                return 192000;
            case 8:
                return 2250000;
            case 9:
                return 40000;
            case 10:
                return 100000;
            case 11:
                return 16000;
            case 12:
                return 7000;
            case 13:
            case 19:
            default:
                throw new IllegalArgumentException();
            case 14:
                return 3062500;
            case 15:
                return 8000;
            case 16:
                return 256000;
            case 17:
                return 336000;
            case 20:
                return 63750;
        }
    }

    private final int A01(int i2) {
        int iA00 = A00(i2);
        int maxByteRate = this.A03;
        return AD.A03((((long) maxByteRate) * ((long) iA00)) / 1000000);
    }

    private final int A02(int i2, int i8) {
        int bufferSizeUs;
        int i9 = this.A04;
        if (i2 == 5) {
            int bufferSizeUs2 = this.A00;
            i9 *= bufferSizeUs2;
        }
        if (i8 != -1) {
            bufferSizeUs = C9D.A00(i8, 8, RoundingMode.CEILING);
        } else {
            bufferSizeUs = A00(i2);
        }
        return AD.A03((((long) i9) * ((long) bufferSizeUs)) / 1000000);
    }

    public static int A03(int i2, int i8, int i9) {
        return AD.A03(((((long) i2) * ((long) i8)) * ((long) i9)) / 1000000);
    }

    private final int A04(int i2, int i8, int i9) {
        int maxAppBufferSize = this.A05 * i2;
        int targetBufferSize = this.A02;
        int minAppBufferSize = A03(targetBufferSize, i8, i9);
        int targetBufferSize2 = this.A01;
        return AbstractC04664a.A07(maxAppBufferSize, minAppBufferSize, A03(targetBufferSize2, i8, i9));
    }

    private final int A05(int i2, int i8, int i9, int i10, int i11, int i12) {
        switch (i9) {
            case 0:
                return A04(i2, i11, i10);
            case 1:
                return A01(i8);
            case 2:
                return A02(i8, i12);
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC05708d
    public final int A6x(int i2, int i8, int i9, int i10, int i11, int i12, double d8) {
        int bufferSize = A05(i2, i8, i9, i10, i11, i12);
        return (((Math.max(i2, (int) (((double) bufferSize) * d8)) + i10) - 1) / i10) * i10;
    }
}
