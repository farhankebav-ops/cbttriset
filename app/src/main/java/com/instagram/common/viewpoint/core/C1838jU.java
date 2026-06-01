package com.instagram.common.viewpoint.core;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jU, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1838jU implements InterfaceC0874Kj {
    public static byte[] A08;
    public static String[] A09 = {"mF6wsmKEoSH0oaFjYCs54xiQsDf", "7fvgeHK83IOxRTsxSXxl4b3GDJCkJYIR", "3AWdxUjQjYm4RALX7ZxT6TNspaUhotFB", "ejd6qsjsHb99jkL857XJ5GpzVF9O4Dmm", "HjmRuX1Dl2gTeBJaQInX56gY9CThxDdt", "4dP72HMzoJKZI0lPLVreHOZSlD0czmst", "VabPsN9EmqWHNd02VeXfGkhVpY5qzzPo", "1TiSMCKkeVz3FItUT5PAcFJ22kgDAGxf"};
    public int A00;
    public long A01;
    public long A02;
    public final int A03;
    public final C2154or A04;
    public final GY A05;
    public final H1 A06;
    public final C0876Kl A07;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 81);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A08 = new byte[]{-68, -95, -24, -16, -11, -69, -95, -34, 17, 9, -2, -4, 13, -2, -3, -71, -5, 5, 8, -4, 4, -71, 12, 2, 19, -2, -45, -71};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.instagram.common.viewpoint.core.InterfaceC0874Kj
    public final boolean AI9(InterfaceC1943lN interfaceC1943lN, long j) throws IOException {
        long j3 = j;
        while (true) {
            String[] strArr = A09;
            if (strArr[6].charAt(28) != strArr[5].charAt(28)) {
                throw new RuntimeException();
            }
            A09[7] = "xyHijgDe1t0LZE27YhGAb5keyZPdsLp6";
            if (j3 <= 0 || this.A00 >= this.A03) {
                break;
            }
            int iAI5 = this.A06.AI5(interfaceC1943lN, (int) Math.min(this.A03 - this.A00, j3), true);
            if (iAI5 == -1) {
                j3 = 0;
            } else {
                this.A00 += iAI5;
                j3 -= (long) iAI5;
            }
        }
        int i2 = this.A07.A02;
        int i8 = this.A00 / i2;
        if (i8 > 0) {
            long jA0U = this.A02 + AbstractC04664a.A0U(this.A01, 1000000L, this.A07.A04);
            int i9 = i8 * i2;
            int i10 = this.A00 - i9;
            this.A06.AIA(jA0U, 1, i9, i10, null);
            this.A01 += (long) i8;
            this.A00 = i10;
        }
        return j3 <= 0;
    }

    static {
        A01();
    }

    public C1838jU(GY gy, H1 h12, C0876Kl c0876Kl, String str, int i2) throws C04222i {
        this.A05 = gy;
        this.A06 = h12;
        this.A07 = c0876Kl;
        int i8 = (c0876Kl.A05 * c0876Kl.A01) / 8;
        int bytesPerFrame = c0876Kl.A02;
        if (bytesPerFrame == i8) {
            int bytesPerFrame2 = c0876Kl.A04;
            int constantBitrate = bytesPerFrame2 * i8 * 8;
            int bytesPerFrame3 = c0876Kl.A04;
            this.A03 = Math.max(i8, (bytesPerFrame3 * i8) / 10);
            C2D c2dA0j = new C2D().A11(str).A0a(constantBitrate).A0j(constantBitrate);
            int bytesPerFrame4 = this.A03;
            C2D c2dA0h = c2dA0j.A0h(bytesPerFrame4);
            int bytesPerFrame5 = c0876Kl.A05;
            C2D c2dA0b = c2dA0h.A0b(bytesPerFrame5);
            int bytesPerFrame6 = c0876Kl.A04;
            this.A04 = c2dA0b.A0m(bytesPerFrame6).A0i(i2).A14();
            return;
        }
        StringBuilder sbAppend = new StringBuilder().append(A00(7, 21, 72)).append(i8).append(A00(0, 7, 48));
        int bytesPerFrame7 = c0876Kl.A02;
        throw C04222i.A01(sbAppend.append(bytesPerFrame7).toString(), null);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0874Kj
    public final void AA0(int i2, long j) {
        this.A05.AIN(new C1836jS(this.A07, 1, i2, j));
        this.A06.A6W(this.A04);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0874Kj
    public final void AI0(long j) {
        this.A02 = j;
        this.A00 = 0;
        this.A01 = 0L;
    }
}
