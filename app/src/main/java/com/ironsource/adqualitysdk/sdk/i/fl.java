package com.ironsource.adqualitysdk.sdk.i;

import android.text.TextUtils;
import android.view.Gravity;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class fl extends ee {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static char[] f2060 = null;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f2061 = 1;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static fl f2062;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static char f2063;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f2064;

    static {
        m2227();
        f2062 = new fl();
        f2064 = (f2061 + 19) % 128;
    }

    public fl() {
        super(Cdo.m2067("", -1));
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static void m2227() {
        f2063 = (char) 2;
        f2060 = new char[]{'n', 'u', 'l', 'o'};
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static synchronized fl m2228() {
        int i2 = f2061 + 29;
        f2064 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
        return f2062;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m2229(int i2, byte b8, String str) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (h.f2264) {
            try {
                char[] cArr2 = f2060;
                char c7 = f2063;
                char[] cArr3 = new char[i2];
                if (i2 % 2 != 0) {
                    i2--;
                    cArr3[i2] = (char) (cArr[i2] - b8);
                }
                if (i2 > 1) {
                    h.f2267 = 0;
                    while (true) {
                        int i8 = h.f2267;
                        if (i8 >= i2) {
                            break;
                        }
                        h.f2269 = cArr[i8];
                        h.f2268 = cArr[h.f2267 + 1];
                        if (h.f2269 == h.f2268) {
                            cArr3[h.f2267] = (char) (h.f2269 - b8);
                            cArr3[h.f2267 + 1] = (char) (h.f2268 - b8);
                        } else {
                            h.f2266 = h.f2269 / c7;
                            h.f2263 = h.f2269 % c7;
                            h.f2265 = h.f2268 / c7;
                            h.f2262 = h.f2268 % c7;
                            if (h.f2263 == h.f2262) {
                                h.f2266 = androidx.camera.core.processing.util.a.C(h.f2266, c7, 1, c7);
                                h.f2265 = androidx.camera.core.processing.util.a.C(h.f2265, c7, 1, c7);
                                int i9 = (h.f2266 * c7) + h.f2263;
                                int i10 = (h.f2265 * c7) + h.f2262;
                                int i11 = h.f2267;
                                cArr3[i11] = cArr2[i9];
                                cArr3[i11 + 1] = cArr2[i10];
                            } else if (h.f2266 == h.f2265) {
                                h.f2263 = androidx.camera.core.processing.util.a.C(h.f2263, c7, 1, c7);
                                h.f2262 = androidx.camera.core.processing.util.a.C(h.f2262, c7, 1, c7);
                                int i12 = (h.f2266 * c7) + h.f2263;
                                int i13 = (h.f2265 * c7) + h.f2262;
                                int i14 = h.f2267;
                                cArr3[i14] = cArr2[i12];
                                cArr3[i14 + 1] = cArr2[i13];
                            } else {
                                int i15 = (h.f2266 * c7) + h.f2262;
                                int i16 = (h.f2265 * c7) + h.f2263;
                                int i17 = h.f2267;
                                cArr3[i17] = cArr2[i15];
                                cArr3[i17 + 1] = cArr2[i16];
                            }
                        }
                        h.f2267 += 2;
                    }
                }
                str2 = new String(cArr3);
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }

    public final String toString() {
        int capsMode;
        int absoluteGravity;
        int i2 = f2061 + 15;
        f2064 = i2 % 128;
        if (i2 % 2 != 0) {
            capsMode = 3 >> TextUtils.getCapsMode("", 0, 0);
            absoluteGravity = 16 - Gravity.getAbsoluteGravity(1, 0);
        } else {
            capsMode = TextUtils.getCapsMode("", 0, 0) + 4;
            absoluteGravity = 76 - Gravity.getAbsoluteGravity(0, 0);
        }
        return m2229(capsMode, (byte) absoluteGravity, "\u0001\u0000¸¸").intern();
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.ee
    /* JADX INFO: renamed from: ﻛ */
    public final du mo2156(ds dsVar, cp cpVar) {
        du duVar = new du(null);
        f2064 = (f2061 + 41) % 128;
        return duVar;
    }
}
