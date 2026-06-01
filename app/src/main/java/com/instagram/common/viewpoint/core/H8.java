package com.instagram.common.viewpoint.core;

import android.util.Base64;
import com.facebook.ads.androidx.media3.common.Metadata;
import com.facebook.ads.androidx.media3.extractor.metadata.flac.PictureFrame;
import com.facebook.ads.androidx.media3.extractor.metadata.vorbis.VorbisComment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class H8 {
    public static byte[] A00;
    public static String[] A01 = {"AQUfun8uWtpAPz6T54JXA8DVdz19i7cg", "A9xQ060X7I53O0IPhfx7pChTdPn89BVs", "HA6OUY8aFXslM4giueBriDg2S", "9RrkKnX7ioGd8UIKmUAG7ayOJ1mW6fCZ", "mjtW7HF4JFIVQBQAuWhSkP1cuiqQ", "mMlJtFouJ3Md3SAWQWV0HJ1iYftjtiDS", "", "7UUPgjEseHhf3IW21ENlLsXr9tr9mert"};

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 16 out of bounds for length 16
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static H7 A06(C4J c4j) throws C04222i {
        A0C(1, c4j, false);
        int iA0F = c4j.A0F();
        int iA0I = c4j.A0I();
        int iA0F2 = c4j.A0F();
        int iA0E = c4j.A0E();
        if (iA0E <= 0) {
            iA0E = -1;
        }
        int iA0E2 = c4j.A0E();
        if (iA0E2 <= 0) {
            iA0E2 = -1;
        }
        int iA0E3 = c4j.A0E();
        if (iA0E3 <= 0) {
            iA0E3 = -1;
            String[] strArr = A01;
            if (strArr[6].length() == strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[6] = "";
            strArr2[4] = "hx6vx8O5nOwfxHxHuzSsxOXMbdPf";
        }
        int iA0I2 = c4j.A0I();
        return new H7(iA0F, iA0I, iA0F2, iA0E, iA0E2, iA0E3, (int) Math.pow(2.0d, iA0I2 & 15), (int) Math.pow(2.0d, (iA0I2 & 240) >> 4), (c4j.A0I() & 1) > 0, Arrays.copyOf(c4j.A0l(), c4j.A0A()));
    }

    public static String A07(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 110);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        A00 = new byte[]{107, 25, 62, 54, 51, 58, 59, 127, 43, 48, 127, 47, 62, 45, 44, 58, 127, 9, 48, 45, 61, 54, 44, 127, 60, 48, 50, 50, 58, 49, 43, 101, 127, 40, 15, 7, 2, 11, 10, 78, 26, 1, 78, 30, 15, 28, 29, 11, 78, 24, 1, 28, 12, 7, 29, 78, 30, 7, 13, 26, 27, 28, 11, 118, 126, 111, 122, 127, 122, 111, 122, 100, 121, 119, 116, 120, 112, 100, 107, 114, 120, 111, 110, 105, 126, 62, 7, 26, 10, 1, 27, 61, 28, 1, 4, 58, 39, 47, 58, 60, 43, 58, 59, 127, 60, 55, 62, 45, 62, 60, 43, 58, 45, 44, 127, 120, 41, 48, 45, 61, 54, 44, 120, 64, 93, 85, 64, 70, 81, 64, 65, 5, 70, 74, 65, 64, 5, 71, 74, 74, 78, 5, 81, 74, 5, 86, 81, 68, 87, 81, 5, 82, 76, 81, 77, 5, 126, 21, 93, 16, 19, 9, 5, 21, 93, 17, 22, 9, 5, 21, 93, 17, 23, 120, 5, 68, 81, 5, 62, 35, 43, 62, 56, 47, 62, 63, 123, 51, 62, 58, 63, 62, 41, 123, 47, 34, 43, 62, 123, 107, 97, 98, 98, 127, 45, 121, 116, 125, 104, 45, 106, 127, 104, 108, 121, 104, 127, 45, 121, 101, 108, 99, 45, 60, 45, 99, 98, 121, 45, 105, 104, 110, 98, 105, 108, 111, 97, 104, 55, 45, 97, 117, 102, 106, 110, 105, 96, 39, 101, 110, 115, 39, 102, 97, 115, 98, 117, 39, 106, 104, 99, 98, 116, 39, 105, 104, 115, 39, 116, 98, 115, 39, 102, 116, 39, 98, 127, 119, 98, 100, 115, 98, 99, 38, 50, 33, 45, 41, 46, 39, 96, 34, 41, 52, 96, 37, 56, 48, 37, 35, 52, 37, 36, 96, 52, 47, 96, 34, 37, 96, 51, 37, 52, 2, 1, 1, 5, 27, 30, 78, 26, 23, 30, 11, 78, 9, 28, 11, 15, 26, 11, 28, 78, 26, 6, 15, 0, 78, 92, 78, 0, 1, 26, 78, 10, 11, 13, 1, 10, 15, 12, 2, 11, 84, 78, 56, 52, 37, 37, 60, 59, 50, 117, 33, 44, 37, 48, 117, 58, 33, 61, 48, 39, 117, 33, 61, 52, 59, 117, 101, 117, 59, 58, 33, 117, 38, 32, 37, 37, 58, 39, 33, 48, 49, 111, 117, 108, 112, 125, 127, 121, 116, 115, 112, 120, 121, 110, 60, 115, 122, 60, 104, 117, 113, 121, 60, 120, 115, 113, 125, 117, 114, 60, 104, 110, 125, 114, 111, 122, 115, 110, 113, 111, 60, 114, 115, 104, 60, 102, 121, 110, 115, 121, 120, 60, 115, 105, 104, 64, 87, 65, 91, 86, 71, 87, 102, 75, 66, 87, 18, 85, 64, 87, 83, 70, 87, 64, 18, 70, 90, 83, 92, 18, 0, 18, 91, 65, 18, 92, 93, 70, 18, 86, 87, 81, 93, 86, 83, 80, 94, 87, 93, 70, 9, 91, 76, 90, 76, 91, 95, 76, 77, 9, 75, 64, 93, 90, 9, 68, 92, 90, 93, 9, 75, 76, 9, 83, 76, 91, 70, 9, 72, 79, 93, 76, 91, 9, 68, 72, 89, 89, 64, 71, 78, 9, 74, 70, 92, 89, 69, 64, 71, 78, 9, 90, 93, 76, 89, 90, 16, 11, 11, 68, 23, 12, 11, 22, 16, 68, 12, 1, 5, 0, 1, 22, 94, 68};
    }

    static {
        A08();
    }

    public static int A00(int i2) {
        int val = 0;
        while (i2 > 0) {
            val++;
            i2 >>>= 1;
        }
        return val;
    }

    public static long A01(long j, long j3) {
        return (long) Math.floor(Math.pow(j, 1.0d / j3));
    }

    public static Metadata A02(List<String> list) {
        List<String> vorbisComments = new ArrayList<>();
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str = list.get(i2);
            String[] strArrA1P = AbstractC04664a.A1P(str, A07(0, 1, 56));
            int length = strArrA1P.length;
            String strA07 = A07(85, 10, 6);
            if (length != 2) {
                AnonymousClass44.A07(strA07, A07(1, 32, 49) + str);
            } else {
                String[] strArr = A01;
                String str2 = strArr[6];
                String str3 = strArr[4];
                int i8 = str2.length();
                if (i8 == str3.length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A01;
                strArr2[6] = "";
                strArr2[4] = "IFt3u6Tbn0k1mtPtGSJYRwNJh6dv";
                if (strArrA1P[0].equals(A07(63, 22, 85))) {
                    try {
                        vorbisComments.add(PictureFrame.A00(new C4J(Base64.decode(strArrA1P[1], 0))));
                    } catch (RuntimeException e) {
                        AnonymousClass44.A0A(strA07, A07(33, 30, 0), e);
                    }
                } else {
                    vorbisComments.add(new VorbisComment(strArrA1P[0], strArrA1P[1]));
                }
            }
        }
        if (vorbisComments.isEmpty()) {
            return null;
        }
        return new Metadata(vorbisComments);
    }

    /* JADX WARN: Incorrect condition in loop: B:25:0x009f */
    /* JADX WARN: Incorrect condition in loop: B:8:0x0026 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.instagram.common.viewpoint.core.H4 A03(com.instagram.common.viewpoint.core.H3 r15) throws com.instagram.common.viewpoint.core.C04222i {
        /*
            Method dump skipped, instruction units count: 345
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.H8.A03(com.facebook.ads.redexgen.X.H3):com.facebook.ads.redexgen.X.H4");
    }

    public static H5 A04(C4J c4j) throws C04222i {
        return A05(c4j, true, true);
    }

    /* JADX WARN: Incorrect condition in loop: B:6:0x0025 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.instagram.common.viewpoint.core.H5 A05(com.instagram.common.viewpoint.core.C4J r9, boolean r10, boolean r11) throws com.instagram.common.viewpoint.core.C04222i {
        /*
            if (r10 == 0) goto L7
            r1 = 3
            r0 = 0
            A0C(r1, r9, r0)
        L7:
            r3 = 7
            long r1 = r9.A0O()
            int r0 = (int) r1
            int r3 = r3 + 4
            java.lang.String r6 = r9.A0W(r0)
            int r0 = r6.length()
            int r3 = r3 + r0
            long r1 = r9.A0O()
            int r0 = (int) r1
            java.lang.String[] r5 = new java.lang.String[r0]
            int r7 = r3 + 4
            r8 = 0
        L22:
            long r3 = (long) r8
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 >= 0) goto L3e
            long r3 = r9.A0O()
            int r0 = (int) r3
            int r7 = r7 + 4
            java.lang.String r0 = r9.A0W(r0)
            r5[r8] = r0
            r0 = r5[r8]
            int r0 = r0.length()
            int r7 = r7 + r0
            int r8 = r8 + 1
            goto L22
        L3e:
            if (r11 == 0) goto L48
            int r0 = r9.A0I()
            r0 = r0 & 1
            if (r0 == 0) goto L50
        L48:
            int r1 = r7 + 1
            com.facebook.ads.redexgen.X.H5 r0 = new com.facebook.ads.redexgen.X.H5
            r0.<init>(r6, r5, r1)
            return r0
        L50:
            r2 = 283(0x11b, float:3.97E-43)
            r1 = 30
            r0 = 46
            java.lang.String r1 = A07(r2, r1, r0)
            r0 = 0
            com.facebook.ads.redexgen.X.2i r0 = com.instagram.common.viewpoint.core.C04222i.A01(r1, r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.H8.A05(com.facebook.ads.redexgen.X.4J, boolean, boolean):com.facebook.ads.redexgen.X.H5");
    }

    public static void A09(int i2, H3 h3) throws C04222i {
        int i8;
        int iA02 = h3.A02(6) + 1;
        for (int i9 = 0; i9 < iA02; i9++) {
            int iA022 = h3.A02(16);
            if (iA022 != 0) {
                AnonymousClass44.A05(A07(85, 10, 6), A07(355, 41, 59) + iA022);
            } else {
                if (h3.A04()) {
                    int iA023 = h3.A02(4);
                    String[] strArr = A01;
                    String str = strArr[7];
                    String str2 = strArr[0];
                    int iCharAt = str.charAt(2);
                    int mappingsCount = str2.charAt(2);
                    if (iCharAt != mappingsCount) {
                        throw new RuntimeException();
                    }
                    A01[5] = "MSIFAaOSOQQOpmu0PO7aKrLsJb3QFagu";
                    i8 = iA023 + 1;
                } else {
                    i8 = 1;
                }
                if (h3.A04()) {
                    int i10 = h3.A02(8);
                    int i11 = i10 + 1;
                    for (int i12 = 0; i12 < i11; i12++) {
                        int mappingsCount2 = i2 - 1;
                        h3.A03(A00(mappingsCount2));
                        int mappingsCount3 = i2 - 1;
                        h3.A03(A00(mappingsCount3));
                    }
                }
                int mappingsCount4 = h3.A02(2);
                if (mappingsCount4 == 0) {
                    if (i8 > 1) {
                        for (int mappingsCount5 = 0; mappingsCount5 < i2; mappingsCount5++) {
                            h3.A03(4);
                        }
                    }
                    for (int i13 = 0; i13 < i8; i13++) {
                        h3.A03(8);
                        String[] strArr2 = A01;
                        String str3 = strArr2[6];
                        String str4 = strArr2[4];
                        int length = str3.length();
                        int mappingsCount6 = str4.length();
                        if (length == mappingsCount6) {
                            throw new RuntimeException();
                        }
                        String[] strArr3 = A01;
                        strArr3[3] = "W7H2tgam7pgMqyIqKZRQoufJib3tzvKG";
                        strArr3[1] = "g3J7gwvZXejdWYIpZtqDt0lnx57dRd6J";
                        h3.A03(8);
                        h3.A03(8);
                    }
                } else {
                    throw C04222i.A01(A07(491, 58, 71), null);
                }
            }
        }
    }

    public static void A0A(H3 h3) throws C04222i {
        int iA02 = h3.A02(6) + 1;
        for (int i2 = 0; i2 < iA02; i2++) {
            int iA022 = h3.A02(16);
            switch (iA022) {
                case 0:
                    h3.A03(8);
                    h3.A03(16);
                    h3.A03(16);
                    String[] strArr = A01;
                    String str = strArr[6];
                    String str2 = strArr[4];
                    int floorCount = str.length();
                    if (floorCount == str2.length()) {
                        throw new RuntimeException();
                    }
                    A01[2] = "puZWVQ2pTjmoQkTRd3XFOd7V6";
                    h3.A03(6);
                    h3.A03(8);
                    int iA023 = h3.A02(4) + 1;
                    for (int floorCount2 = 0; floorCount2 < iA023; floorCount2++) {
                        h3.A03(8);
                    }
                    break;
                    break;
                case 1:
                    int j = h3.A02(5);
                    int i8 = -1;
                    int[] partitionClassList = new int[j];
                    for (int floorCount3 = 0; floorCount3 < j; floorCount3++) {
                        partitionClassList[floorCount3] = h3.A02(4);
                        if (partitionClassList[floorCount3] > i8) {
                            i8 = partitionClassList[floorCount3];
                        }
                    }
                    int[] iArr = new int[i8 + 1];
                    for (int j3 = 0; j3 < iArr.length; j3++) {
                        iArr[j3] = h3.A02(3) + 1;
                        int iA024 = h3.A02(2);
                        if (iA024 > 0) {
                            h3.A03(8);
                        }
                        for (int floorCount4 = 0; floorCount4 < (1 << iA024); floorCount4++) {
                            h3.A03(8);
                        }
                    }
                    h3.A03(2);
                    int k = h3.A02(4);
                    int j8 = 0;
                    int rangeBits = 0;
                    for (int count = 0; count < j; count++) {
                        int idx = partitionClassList[count];
                        String[] strArr2 = A01;
                        String str3 = strArr2[7];
                        String str4 = strArr2[0];
                        int floorCount5 = str3.charAt(2);
                        if (floorCount5 != str4.charAt(2)) {
                            throw new RuntimeException();
                        }
                        A01[5] = "4gRGDU2vGyXCYhT5FVmyq5RWvUvygEh7";
                        j8 += iArr[idx];
                        while (rangeBits < j8) {
                            h3.A03(k);
                            rangeBits++;
                        }
                    }
                    break;
                default:
                    throw C04222i.A01(A07(199, 41, 99) + iA022, null);
            }
        }
    }

    public static void A0B(H3 h3) throws C04222i {
        int iA02 = h3.A02(6) + 1;
        for (int i2 = 0; i2 < iA02; i2++) {
            int residueCount = h3.A02(16);
            if (residueCount <= 2) {
                h3.A03(24);
                h3.A03(24);
                h3.A03(24);
                int iA022 = h3.A02(6) + 1;
                h3.A03(8);
                int[] iArr = new int[iA022];
                for (int i8 = 0; i8 < iA022; i8++) {
                    int residueCount2 = 0;
                    int iA023 = h3.A02(3);
                    if (h3.A04()) {
                        String[] strArr = A01;
                        String str = strArr[7];
                        String str2 = strArr[0];
                        int residueCount3 = str.charAt(2);
                        if (residueCount3 != str2.charAt(2)) {
                            throw new RuntimeException();
                        }
                        A01[5] = "QebxPehykfYMwUhUEUOD533arJF7pEEp";
                        residueCount2 = h3.A02(5);
                    }
                    iArr[i8] = (residueCount2 * 8) + iA023;
                }
                for (int i9 = 0; i9 < iA022; i9++) {
                    for (int i10 = 0; i10 < 8; i10++) {
                        int residueCount4 = iArr[i9];
                        if ((residueCount4 & (1 << i10)) != 0) {
                            h3.A03(8);
                        }
                    }
                }
            } else {
                throw C04222i.A01(A07(448, 43, 92), null);
            }
        }
    }

    public static boolean A0C(int i2, C4J c4j, boolean z2) throws C04222i {
        if (c4j.A07() < 7) {
            if (z2) {
                return false;
            }
            throw C04222i.A01(A07(549, 18, 10) + c4j.A07(), null);
        }
        if (c4j.A0I() != i2) {
            if (z2) {
                return false;
            }
            throw C04222i.A01(A07(178, 21, 53) + Integer.toHexString(i2), null);
        }
        if (c4j.A0I() != 118 || c4j.A0I() != 111 || c4j.A0I() != 114 || c4j.A0I() != 98 || c4j.A0I() != 105 || c4j.A0I() != 115) {
            if (z2) {
                return false;
            }
            throw C04222i.A01(A07(95, 28, 49), null);
        }
        return true;
    }

    public static H6[] A0D(C4J c4j, int i2) throws C04222i {
        A0C(5, c4j, false);
        int iA0I = c4j.A0I() + 1;
        H3 h3 = new H3(c4j.A0l());
        int numberOfBooks = c4j.A09();
        h3.A03(numberOfBooks * 8);
        for (int numberOfBooks2 = 0; numberOfBooks2 < iA0I; numberOfBooks2++) {
            A03(h3);
        }
        int numberOfBooks3 = h3.A02(6);
        int timeCount = numberOfBooks3 + 1;
        for (int i8 = 0; i8 < timeCount; i8++) {
            int numberOfBooks4 = h3.A02(16);
            if (numberOfBooks4 != 0) {
                throw C04222i.A01(A07(396, 52, 114), null);
            }
        }
        A0A(h3);
        A0B(h3);
        A09(i2, h3);
        H6[] h6ArrA0E = A0E(h3);
        if (h3.A04()) {
            return h6ArrA0E;
        }
        throw C04222i.A01(A07(240, 43, 105), null);
    }

    public static H6[] A0E(H3 h3) {
        int iA02 = h3.A02(6) + 1;
        H6[] h6Arr = new H6[iA02];
        for (int windowType = 0; windowType < iA02; windowType++) {
            boolean zA04 = h3.A04();
            int iA022 = h3.A02(16);
            int i2 = h3.A02(16);
            h6Arr[windowType] = new H6(zA04, iA022, i2, h3.A02(8));
        }
        return h6Arr;
    }
}
