package com.ironsource.adqualitysdk.sdk.i;

import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class ic {

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static int f2448 = 1;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static byte[] f2449;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static int f2450;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static int f2451;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static short[] f2452;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static final byte[] f2453;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f2454;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f2455;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static /* synthetic */ boolean f2456;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static final byte[] f2457;

    static {
        m2506();
        int i2 = (f2448 + 53) % 128;
        f2451 = i2;
        f2456 = true;
        f2453 = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        f2457 = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9};
        f2448 = (i2 + 107) % 128;
    }

    private ic() {
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static void m2506() {
        f2455 = -1774339556;
        f2454 = Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE;
        f2450 = -1283482610;
        f2449 = new byte[]{19, 118, 89, 116, 103, 94, -74, 34, 88, 98, 126, -87, 19, 122, -88, 96, 81, 125, 110, 34, 88, 98, 126, -87, 32, 96, 108, 108, 103, 106, 88, -73, 35, 98, 100, 114, 82, 111, 108, 50, -107, 120, -109, -122, 125, -43, 50, -103, -57, 65, 118, -113, -111, 113, -36, 66, -123, -121, 123, -110, 123, -113, -53, 64, 125, -43, 66, 124, -113, -53, 51, -115, -111, 121, -115, -124, 124, -39, 45, -109, -115, 120, -115, -111, -127, -52, 127, 112, -100, -115, 65, 119, -127, -99, -56, 63, 127, -117, -117, -122, -119, 119, 16, 26, 54, 97, -40, 24, 36, 28, 34, 39, 14, 29, 115, -37, 26, 28, 42, 10, 39, 36, 104, -52, 49, 24, 103, -38, 15, 40, 42, 10, 117, -37, 30, 32, 20, 43, 20, 40, -35, 68, 114, -33, 62, 34, 66, 51, 32, 66, 42, 54, 116, -35, 48, 54, 51, 54, 122, 29, 47, 2, 35, 67, 80, 83, -19, 52, 80, 10, 58, -120, 113, -127, -125, 123, 126, -71, -77, 22, -7, 20, 7, -2, 86, -77, 26, 72, -75, 20, -8, 24, 9, -10, 24, 0, 12, 74, -64, 0, 12, 4, 10, 15, -10, 5, 91, -62, 0, 12, 0, 12, -3, 0, 0, 0, 0, 0, 0, 0};
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static byte[] m2509(byte[] bArr, int i2, int i8, byte[] bArr2) {
        int i9 = ((i8 + 2) / 3) << 2;
        int i10 = (i9 / Integer.MAX_VALUE) + i9;
        byte[] bArr3 = new byte[i10];
        int i11 = i8 - 2;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < i11) {
            int i15 = ((bArr[i12] << 24) >>> 8) | ((bArr[i12 + 1] << 24) >>> 16) | ((bArr[i12 + 2] << 24) >>> 24);
            bArr3[i13] = bArr2[i15 >>> 18];
            int i16 = i13 + 1;
            bArr3[i16] = bArr2[(i15 >>> 12) & 63];
            bArr3[i13 + 2] = bArr2[(i15 >>> 6) & 63];
            bArr3[i13 + 3] = bArr2[i15 & 63];
            i14 += 4;
            if (i14 == Integer.MAX_VALUE) {
                bArr3[i13 + 4] = 10;
                i14 = 0;
                i13 = i16;
            }
            i12 += 3;
            i13 += 4;
        }
        if (i12 < i8) {
            f2448 = (f2451 + 91) % 128;
            m2512(bArr, i12, i8 - i12, bArr3, i13, bArr2);
            if (i14 + 4 == Integer.MAX_VALUE) {
                int i17 = f2448 + 115;
                f2451 = i17 % 128;
                if (i17 % 2 != 0) {
                    bArr3[i13 - 3] = 83;
                    i13 += 17;
                } else {
                    bArr3[i13 + 4] = 10;
                    i13++;
                }
            }
            i13 += 4;
            f2451 = (f2448 + 87) % 128;
        }
        if (!f2456 && i13 != i10) {
            throw new AssertionError();
        }
        int i18 = f2451 + 105;
        f2448 = i18 % 128;
        if (i18 % 2 != 0) {
            return bArr3;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static byte[] m2510(String str) throws id {
        f2448 = (f2451 + 3) % 128;
        byte[] bytes = str.getBytes();
        byte[] bArrM2507 = m2507(bytes, bytes.length);
        f2448 = (f2451 + 7) % 128;
        return bArrM2507;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static byte[] m2512(byte[] bArr, int i2, int i8, byte[] bArr2, int i9, byte[] bArr3) {
        int i10;
        int i11;
        int i12 = f2448;
        f2451 = (i12 + 107) % 128;
        int i13 = 0;
        if (i8 > 0) {
            f2451 = (i12 + 35) % 128;
            i10 = (bArr[i2] << 24) >>> 8;
            f2451 = (i12 + 37) % 128;
        } else {
            i10 = 0;
        }
        if (i8 > 1) {
            f2448 = (f2451 + 83) % 128;
            i11 = (bArr[i2 + 1] << 24) >>> 16;
        } else {
            i11 = 0;
        }
        int i14 = i10 | i11;
        if (i8 > 2) {
            int i15 = f2448 + 19;
            f2451 = i15 % 128;
            i13 = i15 % 2 != 0 ? (bArr[i2 >> 5] + 115) / 0 : (bArr[i2 + 2] << 24) >>> 24;
        }
        int i16 = i14 | i13;
        if (i8 == 1) {
            bArr2[i9] = bArr3[i16 >>> 18];
            bArr2[i9 + 1] = bArr3[(i16 >>> 12) & 63];
            bArr2[i9 + 2] = 61;
            bArr2[i9 + 3] = 61;
            return bArr2;
        }
        if (i8 == 2) {
            bArr2[i9] = bArr3[i16 >>> 18];
            bArr2[i9 + 1] = bArr3[(i16 >>> 12) & 63];
            bArr2[i9 + 2] = bArr3[(i16 >>> 6) & 63];
            bArr2[i9 + 3] = 61;
            return bArr2;
        }
        if (i8 != 3) {
            return bArr2;
        }
        bArr2[i9] = bArr3[i16 >>> 18];
        bArr2[i9 + 1] = bArr3[(i16 >>> 12) & 63];
        bArr2[i9 + 2] = bArr3[(i16 >>> 6) & 63];
        bArr2[i9 + 3] = bArr3[i16 & 63];
        return bArr2;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static String m2504(byte[] bArr) {
        int i2 = f2451 + 45;
        f2448 = i2 % 128;
        if (i2 % 2 == 0) {
            m2505(bArr, bArr.length, f2453);
            throw null;
        }
        String strM2505 = m2505(bArr, bArr.length, f2453);
        f2448 = (f2451 + 111) % 128;
        return strM2505;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m2505(byte[] bArr, int i2, byte[] bArr2) {
        byte[] bArrM2509 = m2509(bArr, 0, i2, bArr2);
        String str = new String(bArrM2509, 0, bArrM2509.length);
        f2451 = (f2448 + 91) % 128;
        return str;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static byte[] m2507(byte[] bArr, int i2) throws id {
        int i8 = f2448 + 71;
        f2451 = i8 % 128;
        return i8 % 2 != 0 ? m2511(bArr, 1, i2, f2457) : m2511(bArr, 0, i2, f2457);
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m2503(int i2, short s7, int i8, byte b8, int i9) {
        String string;
        synchronized (n.f2979) {
            try {
                StringBuilder sb = new StringBuilder();
                int i10 = f2454;
                int i11 = i2 + i10;
                int i12 = i11 == -1 ? 1 : 0;
                if (i12 != 0) {
                    byte[] bArr = f2449;
                    if (bArr != null) {
                        i11 = (byte) (bArr[f2455 + i8] + i10);
                    } else {
                        i11 = (short) (f2452[f2455 + i8] + i10);
                    }
                }
                if (i11 > 0) {
                    n.f2984 = ((i8 + i11) - 2) + f2455 + i12;
                    n.f2982 = b8;
                    char c7 = (char) (i9 + f2450);
                    n.f2981 = c7;
                    sb.append(c7);
                    n.f2980 = n.f2981;
                    n.f2983 = 1;
                    while (n.f2983 < i11) {
                        byte[] bArr2 = f2449;
                        if (bArr2 != null) {
                            int i13 = n.f2984;
                            n.f2984 = i13 - 1;
                            n.f2981 = (char) (n.f2980 + (((byte) (bArr2[i13] + s7)) ^ n.f2982));
                        } else {
                            short[] sArr = f2452;
                            int i14 = n.f2984;
                            n.f2984 = i14 - 1;
                            n.f2981 = (char) (n.f2980 + (((short) (sArr[i14] + s7)) ^ n.f2982));
                        }
                        sb.append(n.f2981);
                        n.f2980 = n.f2981;
                        n.f2983++;
                    }
                }
                string = sb.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
        return string;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int m2508(byte[] bArr, byte[] bArr2, int i2, byte[] bArr3) {
        byte b8 = bArr[2];
        if (b8 == 61) {
            int i8 = f2451 + 65;
            f2448 = i8 % 128;
            if (i8 % 2 == 0) {
                byte b9 = bArr3[bArr[0]];
                bArr2[i2] = (byte) (((b9 >>> 27) ^ ((b9 >>> 72) / 97)) / 109);
                return 0;
            }
            bArr2[i2] = (byte) ((((bArr3[bArr[1]] << 24) >>> 12) | ((bArr3[bArr[0]] << 24) >>> 6)) >>> 16);
            return 1;
        }
        byte b10 = bArr[3];
        if (b10 == 61) {
            f2448 = (f2451 + 81) % 128;
            int i9 = ((bArr3[bArr[1]] << 24) >>> 12) | ((bArr3[bArr[0]] << 24) >>> 6) | ((bArr3[b8] << 24) >>> 18);
            bArr2[i2] = (byte) (i9 >>> 16);
            bArr2[i2 + 1] = (byte) (i9 >>> 8);
            return 2;
        }
        int i10 = ((bArr3[bArr[1]] << 24) >>> 12) | ((bArr3[bArr[0]] << 24) >>> 6) | ((bArr3[b8] << 24) >>> 18) | ((bArr3[b10] << 24) >>> 24);
        bArr2[i2] = (byte) (i10 >> 16);
        bArr2[i2 + 1] = (byte) (i10 >> 8);
        bArr2[i2 + 2] = (byte) i10;
        int i11 = f2448 + 49;
        f2451 = i11 % 128;
        if (i11 % 2 != 0) {
            int i12 = 37 / 0;
        }
        return 3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0049, code lost:
    
        if (r12 <= 1) goto L22;
     */
    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] m2511(byte[] r19, int r20, int r21, byte[] r22) throws com.ironsource.adqualitysdk.sdk.i.id {
        /*
            Method dump skipped, instruction units count: 593
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.ic.m2511(byte[], int, int, byte[]):byte[]");
    }
}
