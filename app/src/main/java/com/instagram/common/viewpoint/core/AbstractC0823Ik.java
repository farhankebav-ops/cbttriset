package com.instagram.common.viewpoint.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ik, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@MetaExoPlayerCustomization(type = {"INCREASE_VISIBILITY"}, value = "To support OculusMp4Extractor")
public abstract class AbstractC0823Ik {
    public static String[] A00 = {"FTgkNuEfB21sdffM4MB", "AHdMCcfHPrYhHZuJq7ar8kaDD0", "m1AQBHavwMcQPTMSh8yPHqRX8TIuxSKu", "w1PNvsr2QHXMQttzrVJcJFpvqWAZZ2ue", "3yahnNe", "CLySAaMkPHNUkUwJF2Q2hF0h64PJDpTx", "AMIcFao4vlNbyapwbaOz2OEX2RJAnqn2", "UMo3DITmDXTtEPejAH8oJ9deLVPgGECA"};
    public static final int[] A01 = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static boolean A00(int i2, boolean z2) {
        if ((i2 >>> 8) == 3368816) {
            return true;
        }
        if (A00[1].length() == 5) {
            throw new RuntimeException();
        }
        A00[1] = "W7vtI7n9AGcg3kiZwr1R4Wd";
        if (i2 == 1751476579 && z2) {
            return true;
        }
        int[] iArr = A01;
        if (A00[1].length() == 5) {
            throw new RuntimeException();
        }
        String[] strArr = A00;
        strArr[6] = "p6Add4WRgBlZ7U9sigG7YhPBNKEcLx90";
        strArr[7] = "5Tff00eh7q1qfGppTlmWVovL6e7TawLb";
        for (int i8 : iArr) {
            if (i8 == i2) {
                return true;
            }
        }
        return false;
    }

    public static boolean A01(InterfaceC1943lN interfaceC1943lN) throws IOException {
        return A03(interfaceC1943lN, true, false);
    }

    public static boolean A02(InterfaceC1943lN interfaceC1943lN, boolean z2) throws IOException {
        return A03(interfaceC1943lN, false, z2);
    }

    public static boolean A03(InterfaceC1943lN interfaceC1943lN, boolean z2, boolean z7) throws IOException {
        long jA8G = interfaceC1943lN.A8G();
        long inputLength = 4096;
        if (jA8G != -1 && jA8G <= 4096) {
            inputLength = jA8G;
        }
        int i2 = (int) inputLength;
        C4J c4j = new C4J(64);
        int i8 = 0;
        boolean z8 = false;
        boolean z9 = false;
        while (i8 < i2) {
            int i9 = 8;
            c4j.A0d(8);
            if (!interfaceC1943lN.AGA(c4j.A0l(), 0, 8, true)) {
                break;
            }
            long jA0Q = c4j.A0Q();
            int headerSize = c4j.A0C();
            if (jA0Q == 1) {
                i9 = 16;
                interfaceC1943lN.AG9(c4j.A0l(), 8, 8);
                c4j.A0e(16);
                jA0Q = c4j.A0P();
            } else if (jA0Q == 0) {
                long jA8G2 = interfaceC1943lN.A8G();
                if (jA8G2 != -1) {
                    jA0Q = (jA8G2 - interfaceC1943lN.A8a()) + ((long) 8);
                }
            }
            if (jA0Q < i9) {
                return false;
            }
            i8 += i9;
            if (headerSize == 1836019574) {
                int i10 = (int) jA0Q;
                String[] strArr = A00;
                if (strArr[2].charAt(21) == strArr[5].charAt(21)) {
                    throw new RuntimeException();
                }
                A00[1] = "1NOCBl6uYr6a5zcz7K9cJi9";
                i2 += i10;
                if (jA8G != -1 && i2 > jA8G) {
                    i2 = (int) jA8G;
                }
            } else {
                if (headerSize == 1836019558 || headerSize == 1836475768) {
                    z9 = true;
                    break;
                }
                if ((((long) i8) + jA0Q) - ((long) i9) >= i2) {
                    break;
                }
                int atomDataSize = (int) (jA0Q - ((long) i9));
                i8 += atomDataSize;
                if (headerSize == 1718909296) {
                    if (atomDataSize >= 8) {
                        c4j.A0d(atomDataSize);
                        interfaceC1943lN.AG9(c4j.A0l(), 0, atomDataSize);
                        int atomDataSize2 = atomDataSize / 4;
                        int brandsCount = 0;
                        while (true) {
                            if (brandsCount >= atomDataSize2) {
                                break;
                            }
                            if (brandsCount == 1) {
                                c4j.A0g(4);
                            } else if (A00(c4j.A0C(), z7)) {
                                z8 = true;
                                break;
                            }
                            brandsCount++;
                        }
                        if (!z8) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else if (atomDataSize != 0) {
                    interfaceC1943lN.A3z(atomDataSize);
                }
            }
        }
        return z8 && z2 == z9;
    }
}
