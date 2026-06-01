package com.ironsource.adqualitysdk.sdk.i;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class da {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f1667 = 0;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f1668 = 1;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static char[] f1669 = {'F', 183, 224, 215, 207, 174, 183, 222, 219, 219, 212, 191, 23, 'Y', 128, 'V'};

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static <T> T m1896(List<Object> list, int i2, Class<T> cls) {
        T t3 = (T) list.get(i2);
        if (t3 != null) {
            f1668 = (f1667 + 47) % 128;
            if (!cls.isAssignableFrom(t3.getClass())) {
                StringBuilder sb = new StringBuilder();
                sb.append(m1897("\u0001\u0000\u0001\u0000\u0000\u0001\u0000\u0001\u0001\u0000\u0001\u0000", true, new int[]{0, 12, 109, 0}).intern());
                sb.append(t3.getClass().getName());
                sb.append(m1897("\u0001\u0000\u0001\u0001", false, new int[]{12, 4, 15, 0}).intern());
                sb.append(cls.getName());
                throw new ClassCastException(sb.toString());
            }
        }
        int i8 = f1668 + 17;
        f1667 = i8 % 128;
        if (i8 % 2 != 0) {
            int i9 = 58 / 0;
        }
        return t3;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static <T> boolean m1899(List<Object> list, int i2, Class<T> cls) {
        int i8 = f1668 + 57;
        f1667 = i8 % 128;
        if (i8 % 2 != 0) {
            list.get(i2);
            throw null;
        }
        Object obj = list.get(i2);
        if (obj != null && !cls.isAssignableFrom(obj.getClass())) {
            return false;
        }
        int i9 = f1668 + 103;
        f1667 = i9 % 128;
        if (i9 % 2 == 0) {
            return true;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static List<Object> m1898(List<Object> list, int i2) {
        ArrayList arrayList = new ArrayList();
        if (list.size() > i2) {
            f1667 = (f1668 + 81) % 128;
            if (m1899(list, i2, List.class)) {
                List<Object> list2 = (List) m1896(list, i2, List.class);
                f1668 = (f1667 + 69) % 128;
                return list2;
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m1897(String str, boolean z2, int[] iArr) throws UnsupportedEncodingException {
        String str2;
        Object bytes = str;
        if (str != null) {
            bytes = str.getBytes("ISO-8859-1");
        }
        byte[] bArr = (byte[]) bytes;
        synchronized (g.f2126) {
            try {
                int i2 = iArr[0];
                int i8 = iArr[1];
                int i9 = iArr[2];
                int i10 = iArr[3];
                char[] cArr = new char[i8];
                System.arraycopy(f1669, i2, cArr, 0, i8);
                if (bArr != null) {
                    char[] cArr2 = new char[i8];
                    g.f2125 = 0;
                    char c7 = 0;
                    while (true) {
                        int i11 = g.f2125;
                        if (i11 >= i8) {
                            break;
                        }
                        if (bArr[i11] == 1) {
                            cArr2[i11] = (char) (((cArr[i11] << 1) + 1) - c7);
                        } else {
                            cArr2[i11] = (char) ((cArr[i11] << 1) - c7);
                        }
                        c7 = cArr2[i11];
                        g.f2125 = i11 + 1;
                    }
                    cArr = cArr2;
                }
                if (i10 > 0) {
                    char[] cArr3 = new char[i8];
                    System.arraycopy(cArr, 0, cArr3, 0, i8);
                    int i12 = i8 - i10;
                    System.arraycopy(cArr3, 0, cArr, i12, i10);
                    System.arraycopy(cArr3, i10, cArr, 0, i12);
                }
                if (z2) {
                    char[] cArr4 = new char[i8];
                    g.f2125 = 0;
                    while (true) {
                        int i13 = g.f2125;
                        if (i13 >= i8) {
                            break;
                        }
                        cArr4[i13] = cArr[(i8 - i13) - 1];
                        g.f2125 = i13 + 1;
                    }
                    cArr = cArr4;
                }
                if (i9 > 0) {
                    g.f2125 = 0;
                    while (true) {
                        int i14 = g.f2125;
                        if (i14 >= i8) {
                            break;
                        }
                        cArr[i14] = (char) (cArr[i14] - iArr[2]);
                        g.f2125 = i14 + 1;
                    }
                }
                str2 = new String(cArr);
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }
}
