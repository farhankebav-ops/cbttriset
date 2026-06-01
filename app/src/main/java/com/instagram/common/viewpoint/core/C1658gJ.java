package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.gJ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1658gJ implements QM {
    public static byte[] A04;
    public int A00;
    public int A01;
    public int A02;
    public int[] A03;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 51);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{-95, -74, -50, -60, -54, -55, 117, -59, -60, -56, -66, -55, -66, -60, -61, -56, 117, -62, -54, -56, -55, 117, -73, -70, 117, -61, -60, -61, -126, -61, -70, -68, -74, -55, -66, -53, -70, -117, -92, -77, -96, -89, 91, -97, -92, -82, -81, -100, -87, -98, -96, 91, -88, -80, -82, -81, 91, -99, -96, 91, -87, -86, -87, 104, -87, -96, -94, -100, -81, -92, -79, -96};
    }

    public final void A02() {
        if (this.A03 != null) {
            Arrays.fill(this.A03, -1);
        }
        this.A00 = 0;
    }

    public final void A03(int i2, int i8) {
        this.A01 = i2;
        this.A02 = i8;
    }

    public final void A04(C05246g c05246g, boolean z2) {
        this.A00 = 0;
        if (this.A03 != null) {
            Arrays.fill(this.A03, -1);
        }
        QO qo = c05246g.A06;
        if (c05246g.A04 != null && qo != null && qo.A1W()) {
            if (z2) {
                if (!c05246g.A00.A0B()) {
                    qo.A1t(c05246g.A04.A0B(), this);
                }
            } else if (!c05246g.A1r()) {
                qo.A1s(this.A01, this.A02, c05246g.A0s, this);
            }
            if (this.A00 > qo.A00) {
                qo.A00 = this.A00;
                qo.A08 = z2;
                c05246g.A0r.A0O();
            }
        }
    }

    public final boolean A05(int i2) {
        if (this.A03 != null) {
            int i8 = this.A00 * 2;
            for (int i9 = 0; i9 < i8; i9 += 2) {
                int count = this.A03[i9];
                if (count == i2) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // com.instagram.common.viewpoint.core.QM
    public final void A3u(int i2, int i8) {
        if (i2 >= 0) {
            if (i8 >= 0) {
                int i9 = this.A00 * 2;
                if (this.A03 == null) {
                    this.A03 = new int[4];
                    Arrays.fill(this.A03, -1);
                } else {
                    int storagePosition = this.A03.length;
                    if (i9 >= storagePosition) {
                        int[] iArr = this.A03;
                        int storagePosition2 = i9 * 2;
                        this.A03 = new int[storagePosition2];
                        System.arraycopy(iArr, 0, this.A03, 0, iArr.length);
                    }
                }
                this.A03[i9] = i2;
                int storagePosition3 = i9 + 1;
                this.A03[storagePosition3] = i8;
                int storagePosition4 = this.A00;
                this.A00 = storagePosition4 + 1;
                return;
            }
            throw new IllegalArgumentException(A00(37, 35, 8));
        }
        throw new IllegalArgumentException(A00(0, 37, 34));
    }
}
