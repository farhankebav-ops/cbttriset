package com.bytedance.sdk.component.MY.IlO.MY;

import a1.a;
import com.bumptech.glide.load.Key;
import com.ironsource.C2300e4;
import java.net.IDN;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class DmF {
    public static final Charset IlO = Charset.forName(Key.STRING_CHARSET_NAME);

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0078, code lost:
    
        if (r4 == 16) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x007a, code lost:
    
        if (r5 != (-1)) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007c, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007d, code lost:
    
        r12 = r4 - r5;
        java.lang.System.arraycopy(r1, r5, r1, 16 - r12, r12);
        java.util.Arrays.fill(r1, r5, (16 - r4) + r5, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x008d, code lost:
    
        return java.net.InetAddress.getByAddress(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0093, code lost:
    
        throw new java.lang.AssertionError();
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.net.InetAddress EO(java.lang.String r12, int r13, int r14) {
        /*
            r0 = 16
            byte[] r1 = new byte[r0]
            r2 = 0
            r3 = -1
            r4 = r2
            r5 = r3
            r6 = r5
        L9:
            r7 = 0
            if (r13 >= r14) goto L78
            if (r4 != r0) goto Lf
            return r7
        Lf:
            int r8 = r13 + 2
            r9 = 2
            if (r8 > r14) goto L27
            java.lang.String r10 = "::"
            boolean r10 = r12.regionMatches(r13, r10, r2, r9)
            if (r10 == 0) goto L27
            if (r5 == r3) goto L1f
            return r7
        L1f:
            int r4 = r4 + 2
            r5 = r4
            if (r8 != r14) goto L25
            goto L78
        L25:
            r6 = r8
            goto L4b
        L27:
            if (r4 == 0) goto L34
            java.lang.String r8 = ":"
            r10 = 1
            boolean r8 = r12.regionMatches(r13, r8, r2, r10)
            if (r8 == 0) goto L36
            int r13 = r13 + 1
        L34:
            r6 = r13
            goto L4b
        L36:
            java.lang.String r8 = "."
            boolean r13 = r12.regionMatches(r13, r8, r2, r10)
            if (r13 == 0) goto L4a
            int r13 = r4 + (-2)
            boolean r12 = IlO(r12, r6, r14, r1, r13)
            if (r12 != 0) goto L47
            return r7
        L47:
            int r4 = r4 + 2
            goto L78
        L4a:
            return r7
        L4b:
            r8 = r2
            r13 = r6
        L4d:
            if (r13 >= r14) goto L5f
            char r10 = r12.charAt(r13)
            int r10 = IlO(r10)
            if (r10 == r3) goto L5f
            int r8 = r8 << 4
            int r8 = r8 + r10
            int r13 = r13 + 1
            goto L4d
        L5f:
            int r10 = r13 - r6
            if (r10 == 0) goto L77
            r11 = 4
            if (r10 <= r11) goto L67
            goto L77
        L67:
            int r7 = r4 + 1
            int r10 = r8 >>> 8
            r10 = r10 & 255(0xff, float:3.57E-43)
            byte r10 = (byte) r10
            r1[r4] = r10
            int r4 = r4 + r9
            r8 = r8 & 255(0xff, float:3.57E-43)
            byte r8 = (byte) r8
            r1[r7] = r8
            goto L9
        L77:
            return r7
        L78:
            if (r4 == r0) goto L89
            if (r5 != r3) goto L7d
            return r7
        L7d:
            int r12 = r4 - r5
            int r13 = 16 - r12
            java.lang.System.arraycopy(r1, r5, r1, r13, r12)
            int r0 = r0 - r4
            int r0 = r0 + r5
            java.util.Arrays.fill(r1, r5, r0, r2)
        L89:
            java.net.InetAddress r12 = java.net.InetAddress.getByAddress(r1)     // Catch: java.net.UnknownHostException -> L8e
            return r12
        L8e:
            java.lang.AssertionError r12 = new java.lang.AssertionError
            r12.<init>()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.MY.IlO.MY.DmF.EO(java.lang.String, int, int):java.net.InetAddress");
    }

    public static int IlO(char c7) {
        if (c7 >= '0' && c7 <= '9') {
            return c7 - '0';
        }
        if (c7 >= 'a' && c7 <= 'f') {
            return c7 - 'W';
        }
        if (c7 < 'A' || c7 > 'F') {
            return -1;
        }
        return c7 - '7';
    }

    public static int MY(String str, int i2, int i8) {
        for (int i9 = i8 - 1; i9 >= i2; i9--) {
            char cCharAt = str.charAt(i9);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i9 + 1;
            }
        }
        return i2;
    }

    public static void IlO(long j, long j3, long j8) {
        if ((j3 | j8) < 0 || j3 > j || j - j3 < j8) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private static boolean MY(String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt <= 31 || cCharAt >= 127 || " #%/:?@[\\]".indexOf(cCharAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static int IlO(String str, int i2, int i8) {
        while (i2 < i8) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i2;
            }
            i2++;
        }
        return i8;
    }

    public static int IlO(String str, int i2, int i8, String str2) {
        while (i2 < i8) {
            if (str2.indexOf(str.charAt(i2)) != -1) {
                return i2;
            }
            i2++;
        }
        return i8;
    }

    public static int IlO(String str, int i2, int i8, char c7) {
        while (i2 < i8) {
            if (str.charAt(i2) == c7) {
                return i2;
            }
            i2++;
        }
        return i8;
    }

    public static String IlO(String str) {
        InetAddress inetAddressEO;
        if (str.contains(":")) {
            if (str.startsWith(C2300e4.i.f8403d) && str.endsWith(C2300e4.i.e)) {
                inetAddressEO = EO(str, 1, str.length() - 1);
            } else {
                inetAddressEO = EO(str, 0, str.length());
            }
            if (inetAddressEO == null) {
                return null;
            }
            byte[] address = inetAddressEO.getAddress();
            if (address.length == 16) {
                return IlO(address);
            }
            throw new AssertionError(a.m("Invalid IPv6 address: '", str, "'"));
        }
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (lowerCase.isEmpty()) {
                return null;
            }
            if (MY(lowerCase)) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    private static boolean IlO(String str, int i2, int i8, byte[] bArr, int i9) {
        int i10 = i9;
        while (i2 < i8) {
            if (i10 == bArr.length) {
                return false;
            }
            if (i10 != i9) {
                if (str.charAt(i2) != '.') {
                    return false;
                }
                i2++;
            }
            int i11 = i2;
            int i12 = 0;
            while (i11 < i8) {
                char cCharAt = str.charAt(i11);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                if ((i12 == 0 && i2 != i11) || (i12 = ((i12 * 10) + cCharAt) - 48) > 255) {
                    return false;
                }
                i11++;
            }
            if (i11 - i2 == 0) {
                return false;
            }
            bArr[i10] = (byte) i12;
            i10++;
            i2 = i11;
        }
        return i10 == i9 + 4;
    }

    private static String IlO(byte[] bArr) {
        int i2 = -1;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i9 < bArr.length) {
            int i11 = i9;
            while (i11 < 16 && bArr[i11] == 0 && bArr[i11 + 1] == 0) {
                i11 += 2;
            }
            int i12 = i11 - i9;
            if (i12 > i10 && i12 >= 4) {
                i2 = i9;
                i10 = i12;
            }
            i9 = i11 + 2;
        }
        IlO ilO = new IlO();
        while (i8 < bArr.length) {
            if (i8 == i2) {
                ilO.MY(58);
                i8 += i10;
                if (i8 == 16) {
                    ilO.MY(58);
                }
            } else {
                if (i8 > 0) {
                    ilO.MY(58);
                }
                ilO.MY(((bArr[i8] & 255) << 8) | (bArr[i8 + 1] & 255));
                i8 += 2;
            }
        }
        return ilO.EO();
    }

    public static boolean IlO(byte[] bArr, int i2, byte[] bArr2, int i8, int i9) {
        for (int i10 = 0; i10 < i9; i10++) {
            if (bArr[i10 + i2] != bArr2[i10 + i8]) {
                return false;
            }
        }
        return true;
    }
}
