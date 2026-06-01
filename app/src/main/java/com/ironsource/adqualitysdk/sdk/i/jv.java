package com.ironsource.adqualitysdk.sdk.i;

import android.os.SystemClock;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class jv {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f2904 = 0;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f2905 = 1;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static char[] f2906 = {'s', 227, 222, 226, 216, 219, 234, 226, 222, 218, 223, 215, 206, 198, '\"', '[', 'r', 'p', 'p', 'I', 'B', 'n', 'n', 'd', 'l', 't', 'n', 'k', 'j', 'C', '@', 'j', 'v', 's', 'h', 'A', 'J', 'j', 'j', 'o', '\"', 'L', 'A', '9', 'B', 'B', '9', '?', 'M', 'G', 'K', 'D', 'B', 'X', 'b', 'd', 'f', 'k', 'j', 'T', ' ', 'C', 'L', '@', '8', 'B', 'B', '8', '>', 'O', 'J', 'I', 'P', 'S', 'O', 'N', 'I', 'C', 'N', 'P', 'N', 'N', 'J', 'H', '<', ';', 'G', 'I', ';', '3', '5', '<', 'E', 'N', '4', 'h', '*', 'T', 'M', '9', '2', 'C', 138, 139, 141, 147, 147, 'i', 'c', 138, 139, 142, 146, 148, 149, 138, 132, 132, 'b', 'i', 144, 144, 146, '{', '7', 'k', 'i', 'f', '@', 'J', 'r', 't', 'u', 'j', 'd', 'd', 'B', 'C', 'j', 'k', 'n', 'j', 'c', 'k', 'j', 'A', 'I', 'p', 'p', 'r', '['};

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static long m2801() {
        f2905 = (f2904 + 39) % 128;
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        f2904 = (f2905 + 61) % 128;
        return timeInMillis;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00fc A[Catch: all -> 0x0132, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0132, blocks: (B:15:0x00cc, B:23:0x00fc), top: B:41:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0100  */
    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m2802(java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19) {
        /*
            Method dump skipped, instruction units count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.jv.m2802(java.lang.String, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static void m2807(iu iuVar) {
        int i2 = f2905 + 29;
        f2904 = i2 % 128;
        try {
            if (i2 % 2 == 0) {
                Executors.newSingleThreadExecutor().execute(iuVar);
            } else {
                Executors.newSingleThreadExecutor().execute(iuVar);
                throw null;
            }
        } catch (Throwable th) {
            kd.m2919(m2803("\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001", true, new int[]{0, 14, 116, 0}).intern(), m2803("\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0000", false, new int[]{14, 26, 0, 0}).intern(), th, false);
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static long m2805() {
        long jElapsedRealtime;
        int i2 = f2905 + 19;
        f2904 = i2 % 128;
        if (i2 % 2 != 0) {
            jElapsedRealtime = SystemClock.elapsedRealtime();
            int i8 = 90 / 0;
        } else {
            jElapsedRealtime = SystemClock.elapsedRealtime();
        }
        f2905 = (f2904 + 13) % 128;
        return jElapsedRealtime;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static List m2806(List list, List list2) {
        HashSet hashSet = new HashSet(list);
        if (list2 != null) {
            f2904 = (f2905 + 57) % 128;
            hashSet.addAll(list2);
            f2904 = (f2905 + 115) % 128;
        }
        return new ArrayList(hashSet);
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static byte[] m2804(String str) {
        int length;
        byte[] bArr;
        int i2;
        int i8 = f2904 + 67;
        f2905 = i8 % 128;
        if (i8 % 2 == 0) {
            length = str.length();
            bArr = new byte[length << 4];
            i2 = 1;
        } else {
            length = str.length();
            bArr = new byte[length / 2];
            i2 = 0;
        }
        while (i2 < length) {
            f2904 = (f2905 + 23) % 128;
            bArr[i2 / 2] = (byte) (Character.digit(str.charAt(i2 + 1), 16) + (Character.digit(str.charAt(i2), 16) << 4));
            i2 += 2;
        }
        f2905 = (f2904 + 13) % 128;
        return bArr;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m2803(String str, boolean z2, int[] iArr) throws UnsupportedEncodingException {
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
                System.arraycopy(f2906, i2, cArr, 0, i8);
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
