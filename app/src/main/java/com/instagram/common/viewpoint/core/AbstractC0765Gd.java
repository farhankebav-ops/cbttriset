package com.instagram.common.viewpoint.core;

import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC0765Gd {
    public static String[] A00 = {"o6dy0jxWVFoVpdfIHLQ5kJFOMlq1Sn1Q", "79oj", "9g10QGOLUMPWkkbPiEKlPZ6GdmncXBXa", "6fmIgIVXmOYY3cUB7ZYAXnWSgE20TitB", "v6a7Yb3DANDL70kkwlzLnkI1heNzynkm", "eDdjZQkAYxVEYJ3d9Q78IvgSo191T7ve", "sHmXnPOOobIrXpWrquJBTDw1maWJKk3u", "k0vF7vRBeJQaOBXZ"};

    public static int A00(C4J c4j, int i2) {
        switch (i2) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i2 - 2);
            case 6:
                return c4j.A0I() + 1;
            case 7:
                int iA0M = c4j.A0M();
                String[] strArr = A00;
                if (strArr[6].charAt(23) != strArr[4].charAt(23)) {
                    throw new RuntimeException();
                }
                A00[7] = "hcXiJWofr5Txci555yuma5X";
                return iA0M + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i2 - 8);
            default:
                return -1;
        }
    }

    public static long A01(InterfaceC1943lN interfaceC1943lN, C0769Gh c0769Gh) throws IOException {
        interfaceC1943lN.AI1();
        boolean z2 = true;
        interfaceC1943lN.A3z(1);
        byte[] bArr = new byte[1];
        interfaceC1943lN.AG9(bArr, 0, 1);
        if ((bArr[0] & 1) != 1) {
            z2 = false;
        }
        interfaceC1943lN.A3z(2);
        int i2 = z2 ? 7 : 6;
        C4J c4j = new C4J(i2);
        c4j.A0e(GZ.A00(interfaceC1943lN, c4j.A0l(), 0, i2));
        interfaceC1943lN.AI1();
        C0764Gc c0764Gc = new C0764Gc();
        boolean isBlockSizeVariable = A08(c4j, c0769Gh, z2, c0764Gc);
        if (isBlockSizeVariable) {
            return c0764Gc.A00;
        }
        throw C04222i.A01(null, null);
    }

    public static boolean A02(int i2, C0769Gh c0769Gh) {
        if (i2 == 0) {
            return true;
        }
        int i8 = c0769Gh.A01;
        if (A00[7].length() == 8) {
            throw new RuntimeException();
        }
        A00[0] = "dnyA5Em4Vekc9hKZNMMqKWCBR5ivXppC";
        return i2 == i8;
    }

    public static boolean A03(int i2, C0769Gh c0769Gh) {
        if (i2 <= 7) {
            return i2 == c0769Gh.A02 - 1;
        }
        if (A00[3].charAt(10) != 'Y') {
            throw new RuntimeException();
        }
        A00[3] = "e0AkGTV6jhYRPjlSs9AVJSXBXenCNngQ";
        return i2 <= 10 && c0769Gh.A02 == 2;
    }

    public static boolean A04(C4J c4j, int i2) {
        int iA0I = c4j.A0I();
        int crc = c4j.A09();
        return iA0I == AbstractC04664a.A0J(c4j.A0l(), i2, crc + (-1), 0);
    }

    public static boolean A05(C4J c4j, C0769Gh c0769Gh, int i2) {
        int iA00 = A00(c4j, i2);
        if (iA00 != -1) {
            int blockSizeSamples = c0769Gh.A03;
            if (iA00 <= blockSizeSamples) {
                return true;
            }
        }
        return false;
    }

    public static boolean A06(C4J c4j, C0769Gh c0769Gh, int i2) {
        int sampleRate = c0769Gh.A07;
        if (i2 == 0) {
            return true;
        }
        if (i2 <= 11) {
            return i2 == c0769Gh.A08;
        }
        if (i2 == 12) {
            return c4j.A0I() * 1000 == sampleRate;
        }
        if (i2 > 14) {
            return false;
        }
        int expectedSampleRate = c4j.A0M();
        if (i2 == 14) {
            expectedSampleRate *= 10;
        }
        return expectedSampleRate == sampleRate;
    }

    public static boolean A07(C4J c4j, C0769Gh c0769Gh, int i2, C0764Gc c0764Gc) {
        int iA09 = c4j.A09();
        long jA0Q = c4j.A0Q();
        long frameHeaderBytes = jA0Q >>> 16;
        if (frameHeaderBytes != i2) {
            return false;
        }
        int blockSizeKey = (int) ((jA0Q >> 8) & 15);
        long frameHeaderBytes2 = jA0Q >> 1;
        int frameStartPosition = (int) (frameHeaderBytes2 & 7);
        return A03((int) ((jA0Q >> 4) & 15), c0769Gh) && A02(frameStartPosition, c0769Gh) && !(((jA0Q & 1) > 1L ? 1 : ((jA0Q & 1) == 1L ? 0 : -1)) == 0) && A08(c4j, c0769Gh, (((jA0Q >>> 16) & 1) > 1L ? 1 : (((jA0Q >>> 16) & 1) == 1L ? 0 : -1)) == 0, c0764Gc) && A05(c4j, c0769Gh, (int) ((jA0Q >> 12) & 15)) && A06(c4j, c0769Gh, blockSizeKey) && A04(c4j, iA09);
    }

    public static boolean A08(C4J c4j, C0769Gh c0769Gh, boolean z2, C0764Gc c0764Gc) {
        long utf8Value;
        try {
            long jA0S = c4j.A0S();
            if (z2) {
                utf8Value = jA0S;
            } else {
                long utf8Value2 = c0769Gh.A03;
                utf8Value = utf8Value2 * jA0S;
            }
            c0764Gc.A00 = utf8Value;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean A09(InterfaceC1943lN interfaceC1943lN, C0769Gh c0769Gh, int i2, C0764Gc c0764Gc) throws IOException {
        long jA8a = interfaceC1943lN.A8a();
        byte[] bArr = new byte[2];
        interfaceC1943lN.AG9(bArr, 0, 2);
        if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i2) {
            interfaceC1943lN.AI1();
            interfaceC1943lN.A3z((int) (jA8a - interfaceC1943lN.A8f()));
            return false;
        }
        C4J c4j = new C4J(16);
        System.arraycopy(bArr, 0, c4j.A0l(), 0, 2);
        byte[] frameStartBytes = c4j.A0l();
        c4j.A0e(GZ.A00(interfaceC1943lN, frameStartBytes, 2, 14));
        interfaceC1943lN.AI1();
        interfaceC1943lN.A3z((int) (jA8a - interfaceC1943lN.A8f()));
        return A07(c4j, c0769Gh, i2, c0764Gc);
    }
}
