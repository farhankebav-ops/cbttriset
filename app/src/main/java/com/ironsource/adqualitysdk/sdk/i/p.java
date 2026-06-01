package com.ironsource.adqualitysdk.sdk.i;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.vungle.ads.internal.protos.Sdk;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class p {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static final Handler f2987;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f2988 = 0;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static char[] f2989 = null;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2990 = 1;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static final Handler f2991;

    static {
        m2972();
        f2991 = new Handler(Looper.getMainLooper());
        f2987 = m2962();
        f2990 = (f2988 + 55) % 128;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static void m2963(iu iuVar) {
        f2990 = (f2988 + 39) % 128;
        try {
            m2966().post(iuVar);
            int i2 = f2990 + 99;
            f2988 = i2 % 128;
            if (i2 % 2 != 0) {
                throw null;
            }
        } catch (Error unused) {
            k.m2856(m2971(new int[]{0, 12, 0, 4}, true, "\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0001").intern(), m2971(new int[]{78, 36, 103, 0}, false, "\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0000\u0000\u0001\u0001\u0000\u0001\u0000\u0000\u0000\u0001\u0001\u0000\u0000\u0001\u0001").intern(), false);
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static void m2964(iu iuVar) {
        int i2 = f2988 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE;
        f2990 = i2 % 128;
        if (i2 % 2 == 0) {
            m2965();
            throw null;
        }
        if (m2965()) {
            m2963(iuVar);
            return;
        }
        iuVar.run();
        int i8 = f2988 + 97;
        f2990 = i8 % 128;
        if (i8 % 2 == 0) {
            int i9 = 89 / 0;
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static void m2967(iu iuVar) {
        if (!m2965()) {
            m2969(iuVar);
            int i2 = f2990 + 113;
            f2988 = i2 % 128;
            if (i2 % 2 != 0) {
                throw null;
            }
            return;
        }
        int i8 = f2990 + 1;
        f2988 = i8 % 128;
        if (i8 % 2 == 0) {
            iuVar.run();
        } else {
            iuVar.run();
            int i9 = 5 / 0;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static Handler m2968() {
        Handler handler;
        int i2 = f2988;
        int i8 = i2 + 5;
        f2990 = i8 % 128;
        if (i8 % 2 == 0) {
            handler = f2991;
            int i9 = 79 / 0;
        } else {
            handler = f2991;
        }
        f2990 = (i2 + 95) % 128;
        return handler;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static void m2972() {
        f2989 = new char[]{':', 'c', 'Z', 'R', 'F', 'G', 'K', 'f', 'v', 'n', 'j', 'f', '#', 'S', 'e', 'j', 'h', 'd', 'B', 'J', 'q', 'G', 'H', 'o', 'q', 's', 'J', 'G', 'n', 'G', 'F', 'g', 'e', 'k', 'G', 'J', 'n', 'm', 'k', 'c', 'b', 'h', 206, 207, 215, 217, 218, 182, 179, 215, 209, 211, 178, 179, 218, 179, 174, 208, 219, 217, 210, 212, 208, 174, 182, 223, 221, 219, 180, 179, 221, 182, 174, 208, 212, 214, 209, 191, 'V', 186, 204, 209, 207, 203, 169, 177, 216, 174, 170, 205, 211, 219, 213, 210, 209, 170, 168, 200, 201, 206, 208, 211, 215, 217, 216, 208, 169, 171, 203, 206, 208, 207, 207, 210, 'x', 249, 255, 256, 264, 266, 251, 234, 225, 223, 220, 224, 237, 222, 155, 234, 239, 155, 223, 224, 231, 228, 220, 193, 169, 169, 169, 226, 233, 228, 244, 237, 239, 224, 237, 155, 167, 237, 224, 231, 223, 233, 220, 227, 155, 223, 233, 240, 234, 237, 226, 230, 222, 220, 221, 155, 224, 239, '2', 'i', 'q', 'r', 'p', 'l', 'i', 'g', 'b', 'a', 'A', 'B', 'l', 'j', 'c', 'k', 'j', 'A', 'G', 'q', 'J', 'B', 'd', 'h', 'j', 'e', 'S', '\\', 'k', 'h', 'h', 'i', 'g', 'd', 'D'};
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static void m2969(iu iuVar) {
        f2988 = (f2990 + 93) % 128;
        try {
            m2968().post(iuVar);
            int i2 = f2990 + 101;
            f2988 = i2 % 128;
            if (i2 % 2 != 0) {
                int i8 = 61 / 0;
            }
        } catch (Error unused) {
            k.m2856(m2971(new int[]{0, 12, 0, 4}, true, "\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0001").intern(), m2971(new int[]{12, 29, 0, 0}, false, "\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0000\u0001\u0000\u0000\u0001\u0000\u0000\u0000\u0000\u0001\u0000\u0001").intern(), false);
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static void m2973(iu iuVar, long j) {
        int i2 = f2990 + 73;
        f2988 = i2 % 128;
        try {
            if (i2 % 2 != 0) {
                m2966().postDelayed(iuVar, j);
                int i8 = 74 / 0;
            } else {
                m2966().postDelayed(iuVar, j);
            }
            int i9 = f2988 + 115;
            f2990 = i9 % 128;
            if (i9 % 2 == 0) {
                throw null;
            }
        } catch (Error unused) {
            k.m2856(m2971(new int[]{0, 12, 0, 4}, true, "\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0001").intern(), m2971(new int[]{78, 36, 103, 0}, false, "\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0000\u0000\u0001\u0001\u0000\u0001\u0000\u0000\u0000\u0001\u0001\u0000\u0000\u0001\u0001").intern(), false);
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static Handler m2962() {
        try {
            HandlerThread handlerThread = new HandlerThread(m2971(new int[]{114, 10, 157, 1}, true, "\u0001\u0000\u0001\u0000\u0001\u0000\u0000\u0001\u0001\u0000").intern());
            f2990 = (f2988 + 107) % 128;
            for (int i2 = 0; i2 < 3; i2++) {
                try {
                    handlerThread.start();
                    Handler handler = new Handler(handlerThread.getLooper());
                    f2990 = (f2988 + 45) % 128;
                    return handler;
                } catch (Error unused) {
                    k.m2856(m2971(new int[]{0, 12, 0, 4}, true, "\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0001").intern(), m2971(new int[]{Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE, 48, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE, 14}, true, null).intern(), true);
                }
            }
        } catch (Error unused2) {
            k.m2856(m2971(new int[]{0, 12, 0, 4}, true, "\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0001").intern(), m2971(new int[]{172, 35, 0, 27}, true, "\u0000\u0000\u0001\u0000\u0001\u0001\u0000\u0000\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0000\u0000\u0001\u0001\u0000").intern(), true);
        }
        return null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static Handler m2966() {
        int i2 = f2988 + 13;
        f2990 = i2 % 128;
        if (i2 % 2 != 0) {
            return f2987;
        }
        int i8 = 62 / 0;
        return f2987;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static void m2970(iu iuVar, long j) {
        int i2 = f2988 + 29;
        f2990 = i2 % 128;
        try {
            if (i2 % 2 != 0) {
                m2968().postDelayed(iuVar, j);
                int i8 = f2990 + 9;
                f2988 = i8 % 128;
                if (i8 % 2 != 0) {
                    int i9 = 72 / 0;
                    return;
                }
                return;
            }
            m2968().postDelayed(iuVar, j);
            throw null;
        } catch (Error unused) {
            k.m2856(m2971(new int[]{0, 12, 0, 4}, true, "\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0001").intern(), m2971(new int[]{41, 37, 108, 0}, true, "\u0000\u0001\u0000\u0001\u0000\u0000\u0000\u0000\u0001\u0000\u0000\u0001\u0000\u0001\u0001\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001").intern(), false);
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static boolean m2965() {
        f2988 = (f2990 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE) % 128;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return false;
        }
        f2990 = (f2988 + 35) % 128;
        return true;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m2971(int[] iArr, boolean z2, String str) throws UnsupportedEncodingException {
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
                System.arraycopy(f2989, i2, cArr, 0, i8);
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
