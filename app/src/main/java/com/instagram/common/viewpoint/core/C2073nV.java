package com.instagram.common.viewpoint.core;

import com.ironsource.C2300e4;
import com.unity3d.services.UnityAdsConstants;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nV, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2073nV implements C6S {
    public static byte[] A0B;
    public static String[] A0C = {"WWBqbqM8cT7NtZ20aOE3uXs3Aw8DSv9K", "wsMqXc0RGaIy4bMjDS0CDKFK5K3H0E7a", "tXUn5oHGArEZhR5EfIYxUHEmkE2i7Wlz", "L3oqKt7yiugAXq9nLkVCiYddeszNHWIU", "GxMV2HKS42DeS6e3iSG9rTJ", "iBUmcZRwnnz5BMe8LKV", "MLtAALupoqSZMT31TgfSKHmksSEA2gyG", "KlBG0Bt2bdiLbLP3pzzetkFN2"};
    public int A00;
    public boolean A01;
    public final int A02;
    public final long A03;
    public final long A04;
    public final long A05;
    public final long A06;
    public final long A07;
    public final C1962lh A08;
    public final boolean A09;
    public final boolean A0A;

    public static String A02(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0B, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 69);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A0B = new byte[]{-127, -60, -62, -49, -49, -48, -43, -127, -61, -58, -127, -51, -58, -44, -44, -127, -43, -55, -62, -49, -127, 123, -91, -58, -57, -62, -42, -51, -43, -83, -48, -62, -59, -92, -48, -49, -43, -45, -48, -51, 3, 16, 33, 22, 20, 35, -49, 17, 36, 21, 21, 20, 33, -49, 34, 24, 41, 20, -49, 33, 20, 16, 18, 23, 20, 19, -49, 38, 24, 35, 23, -49, 27, 20, 34, 34, -49, 35, 23, 16, 29, -49, -28, -33, -33, 28, 34, -49, 30, 21, -49, 17, 36, 21, 21, 20, 33, 20, 19, -49, 28, 20, 19, 24, 16, -49, 19, 16, 35, 16, -35, -36, -37, -35, -27, -68, -17, -32, -32, -33, -20, -66, -17, -20, -37, -18, -29, -23, -24, -57, -19, -77, -58, -73, -73, -74, -61, -105, -64, -61, -95, -67, -78, -54, -77, -78, -76, -68, -110, -73, -59, -74, -61, -93, -74, -77, -58, -73, -73, -74, -61, -98, -60, 21, 40, 25, 25, 24, 37, -7, 34, 37, 3, 31, 20, 44, 21, 20, 22, 30, 0, 38, -12, -24, -1, -55, -4, -19, -19, -20, -7, -44, -6, 43, 39, 44, 0, 51, 36, 36, 35, 48, 11, 49};
    }

    static {
        A03();
    }

    public C2073nV() {
        this(new C1962lh(true, 65536), C2300e4.b.f8307d, C2300e4.b.f8307d, UnityAdsConstants.RequestPolicy.RETRY_MAX_INTERVAL, 5000, -1, false, 0, false);
    }

    public C2073nV(C1962lh c1962lh, int i2, int i8, int i9, int i10, int i11, boolean z2, int i12, boolean z7) {
        int i13;
        String strA02 = A02(163, 19, 110);
        String strA022 = A02(21, 1, 6);
        A04(i9, 0, strA02, strA022);
        String strA023 = A02(Sdk.SDKError.Reason.MRAID_JS_WRITE_FAILED_VALUE, 32, 12);
        A04(i10, 0, strA023, strA022);
        String strA024 = A02(193, 11, Sdk.SDKError.Reason.TPAT_ERROR_VALUE);
        A04(i2, i9, strA024, strA02);
        A04(i2, i10, strA024, strA023);
        A04(i8, i2, A02(182, 11, 66), strA024);
        A04(i12, 0, A02(111, 20, 53), strA022);
        this.A08 = c1962lh;
        this.A07 = AbstractC04664a.A0O(i2);
        this.A06 = AbstractC04664a.A0O(i8);
        this.A05 = AbstractC04664a.A0O(i9);
        this.A04 = AbstractC04664a.A0O(i10);
        this.A02 = i11;
        if (this.A02 != -1) {
            i13 = this.A02;
        } else {
            i13 = 13107200;
        }
        this.A00 = i13;
        this.A09 = z2;
        this.A03 = AbstractC04664a.A0O(i12);
        this.A0A = z7;
    }

    public static int A00(int i2) {
        switch (i2) {
            case -2:
                return 0;
            case -1:
            default:
                throw new IllegalArgumentException();
            case 0:
                return 144310272;
            case 1:
                return 13107200;
            case 2:
                if (A0C[7].length() == 32) {
                    throw new RuntimeException();
                }
                A0C[5] = "ABED08YC";
                return 131072000;
            case 3:
                return 131072;
            case 4:
                return 131072;
            case 5:
                return 131072;
            case 6:
                return 131072;
        }
    }

    private final int A01(InterfaceC1964lj[] interfaceC1964ljArr) {
        int iA00 = 0;
        for (InterfaceC1964lj interfaceC1964lj : interfaceC1964ljArr) {
            if (interfaceC1964lj != null) {
                int targetBufferSize = interfaceC1964lj.A9D().A02;
                iA00 += A00(targetBufferSize);
            }
        }
        int iMax = Math.max(13107200, iA00);
        if (A0C[0].charAt(6) == 'f') {
            throw new RuntimeException();
        }
        A0C[0] = "RHrwW0B94f4UqoylhYQPwgHgnQSWW3zM";
        return iMax;
    }

    public static void A04(int i2, int i8, String str, String str2) {
        C3M.A09(i2 >= i8, str + A02(0, 21, 28) + str2);
    }

    private void A05(boolean z2) {
        int i2;
        if (this.A02 == -1) {
            i2 = 13107200;
        } else {
            i2 = this.A02;
        }
        this.A00 = i2;
        this.A01 = false;
        if (z2) {
            this.A08.A01();
        }
    }

    @Override // com.instagram.common.viewpoint.core.C6S
    public final C1962lh A6n() {
        return this.A08;
    }

    @Override // com.instagram.common.viewpoint.core.C6S
    public final long A6s(C05567m c05567m) {
        return this.A03;
    }

    @Override // com.instagram.common.viewpoint.core.C6S
    public final void AEj(C05567m c05567m) {
        A05(false);
    }

    @Override // com.instagram.common.viewpoint.core.C6S
    public final void AEu(C05567m c05567m) {
        A05(true);
    }

    @Override // com.instagram.common.viewpoint.core.C6S
    public final void AFN(C05567m c05567m) {
        A05(true);
    }

    @Override // com.instagram.common.viewpoint.core.C6S
    public final void AFV(C6R c6r, C1991mA c1991mA, InterfaceC1964lj[] interfaceC1964ljArr) {
        int iA01;
        if (this.A02 == -1) {
            iA01 = A01(interfaceC1964ljArr);
        } else {
            iA01 = this.A02;
        }
        this.A00 = iA01;
        this.A08.A02(this.A00);
    }

    @Override // com.instagram.common.viewpoint.core.C6S
    public final boolean AI3(C05567m c05567m) {
        return this.A0A;
    }

    @Override // com.instagram.common.viewpoint.core.C6S
    public final boolean AJB(C6R c6r) {
        boolean z2 = true;
        boolean z7 = this.A08.A00() >= this.A00;
        long jMin = this.A07;
        if (c6r.A00 > 1.0f) {
            jMin = Math.min(AbstractC04664a.A0Q(jMin, c6r.A00), this.A06);
        }
        if (c6r.A01 < Math.max(jMin, 500000L)) {
            boolean targetBufferSizeReached = this.A09;
            if (!targetBufferSizeReached && z7) {
                z2 = false;
            }
            this.A01 = z2;
            boolean targetBufferSizeReached2 = this.A01;
            if (!targetBufferSizeReached2 && c6r.A01 < 500000) {
                AnonymousClass44.A07(A02(22, 18, 28), A02(40, 71, 106));
            }
        } else if (c6r.A01 >= this.A06 || z7) {
            this.A01 = false;
        }
        boolean targetBufferSizeReached3 = this.A01;
        return targetBufferSizeReached3;
    }

    @Override // com.instagram.common.viewpoint.core.C6S
    public final boolean AJE(long j, float f4, boolean z2, boolean z7, long minBufferDurationUs) {
        long jA0R = AbstractC04664a.A0R(j, f4);
        long jMin = z2 ? this.A04 : this.A05;
        String[] strArr = A0C;
        if (strArr[3].charAt(20) == strArr[1].charAt(20)) {
            throw new RuntimeException();
        }
        A0C[4] = "l7tzQS6toEbIIxnpfZA1NGx";
        if (minBufferDurationUs != -9223372036854775807L) {
            jMin = Math.min(minBufferDurationUs / 2, jMin);
        }
        return jMin <= 0 || jA0R >= jMin || (!this.A09 && this.A08.A00() >= this.A00);
    }
}
