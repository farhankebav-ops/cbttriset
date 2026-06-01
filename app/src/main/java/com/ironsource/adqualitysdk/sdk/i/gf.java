package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.api.init.PAGSdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class gf extends gk {

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f2151 = 0;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f2153 = 1;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static char[] f2150 = {'b', 44975, 24536, 4071, 48956, 28495, 8042, 52921, 32469};

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static long f2152 = 7671017891653464022L;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class d extends gf {

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private static int f2154 = 1;

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private static char f2155 = 5;

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private static char[] f2156 = {'c', 'o', 'm', '.', 'b', 'y', 't', 'e', 'd', 'a', 'n', 's', 'k', 'p', 'T', 'A', 'S', 'f', 'g', 'h', 'i', 'j', 'l', 'q', 'r'};

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private static int f2157;

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private static String m2255(int i2, byte b8, String str) {
            String str2;
            Object charArray = str;
            if (str != null) {
                charArray = str.toCharArray();
            }
            char[] cArr = (char[]) charArray;
            synchronized (h.f2264) {
                try {
                    char[] cArr2 = f2156;
                    char c7 = f2155;
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

        @Override // com.ironsource.adqualitysdk.sdk.i.gk
        /* JADX INFO: renamed from: ﻛ */
        public final Class mo2241() {
            Class<TTAdSdk> cls;
            int i2 = f2157;
            int i8 = i2 + 39;
            f2154 = i8 % 128;
            if (i8 % 2 == 0) {
                cls = TTAdSdk.class;
                int i9 = 23 / 0;
            } else {
                cls = TTAdSdk.class;
            }
            f2154 = (i2 + 63) % 128;
            return cls;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.gk
        /* JADX INFO: renamed from: ﾒ */
        public final String mo2243() {
            f2157 = (f2154 + 55) % 128;
            String strIntern = m2255(35 - Color.alpha(0), (byte) (116 - View.combineMeasuredStates(0, 0)), "\u0001\u0002\u0003\u0004\u0000\t\u0007\b\t\u0005\u000f\u0005\b\u0002\r\u0006\r\u0002\u0003\u000b\u0005\f\u0005\t\r\u0006\r\u0002ÈÈ\u0012\u0005\u0012\u0006ß").intern();
            int i2 = f2154 + 77;
            f2157 = i2 % 128;
            if (i2 % 2 != 0) {
                int i8 = 79 / 0;
            }
            return strIntern;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class e extends gf {

        /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
        private static int f2158 = 0;

        /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
        private static int f2159 = 1;

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private static int f2160 = 163257155;

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private static int f2161 = 117;

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private static short[] f2162 = null;

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private static int f2163 = 181559972;

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private static byte[] f2164 = {-74, 0, -14, -9, 1, -110, -27, 77, -4, -116, -2, -52, -66, -118, -8, -44, -60, 0, -110, -8, 4, -108, -6, -114, 2, 66, -60, 0, -110, 62, -70, 5, -114, -10, -122, -120, -110, -116, -16, -49, -62, -119, -9};

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private static String m2256(int i2, short s7, int i8, byte b8, int i9) {
            String string;
            synchronized (n.f2979) {
                try {
                    StringBuilder sb = new StringBuilder();
                    int i10 = f2161;
                    int i11 = i2 + i10;
                    int i12 = i11 == -1 ? 1 : 0;
                    if (i12 != 0) {
                        byte[] bArr = f2164;
                        i11 = bArr != null ? (byte) (bArr[f2163 + i8] + i10) : (short) (f2162[f2163 + i8] + i10);
                    }
                    if (i11 > 0) {
                        n.f2984 = ((i8 + i11) - 2) + f2163 + i12;
                        n.f2982 = b8;
                        char c7 = (char) (i9 + f2160);
                        n.f2981 = c7;
                        sb.append(c7);
                        n.f2980 = n.f2981;
                        n.f2983 = 1;
                        while (n.f2983 < i11) {
                            byte[] bArr2 = f2164;
                            if (bArr2 != null) {
                                int i13 = n.f2984;
                                n.f2984 = i13 - 1;
                                n.f2981 = (char) (n.f2980 + (((byte) (bArr2[i13] + s7)) ^ n.f2982));
                            } else {
                                short[] sArr = f2162;
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

        @Override // com.ironsource.adqualitysdk.sdk.i.gk
        /* JADX INFO: renamed from: ﻛ */
        public final Class mo2241() {
            int i2 = f2159 + 95;
            f2158 = i2 % 128;
            if (i2 % 2 == 0) {
                return PAGSdk.class;
            }
            throw null;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.gk
        /* JADX INFO: renamed from: ﾒ */
        public final String mo2243() {
            f2159 = (f2158 + 41) % 128;
            String strIntern = m2256((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) - 118, (short) (58 - (ViewConfiguration.getScrollDefaultDelay() >> 16)), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) - 181559972, (byte) (61 - KeyEvent.getDeadChar(0, 0)), (-163257056) - (ViewConfiguration.getScrollBarSize() >> 8)).intern();
            int i2 = f2159 + 71;
            f2158 = i2 % 128;
            if (i2 % 2 == 0) {
                return strIntern;
            }
            throw null;
        }
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻐ */
    public final String mo2240() {
        char windowTouchSlop;
        int i2;
        int i8 = f2153 + 57;
        f2151 = i8 % 128;
        if (i8 % 2 != 0) {
            windowTouchSlop = (char) (ViewConfiguration.getWindowTouchSlop() % 90);
            i2 = 8 >> (TypedValue.complexToFraction(0, 1.0f, 2.0f) > 2.0f ? 1 : (TypedValue.complexToFraction(0, 1.0f, 2.0f) == 2.0f ? 0 : -1));
        } else {
            windowTouchSlop = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
            i2 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 9;
        }
        return m2254(windowTouchSlop, i2, TextUtils.getCapsMode("", 0, 0)).intern();
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾇ */
    public final bg mo2242() {
        bk bkVar = new bk(mo2240());
        int i2 = f2153 + 99;
        f2151 = i2 % 128;
        if (i2 % 2 == 0) {
            return bkVar;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m2254(char c7, int i2, int i8) {
        String str;
        synchronized (c.f1192) {
            try {
                char[] cArr = new char[i2];
                c.f1193 = 0;
                while (true) {
                    int i9 = c.f1193;
                    if (i9 < i2) {
                        cArr[i9] = (char) ((((long) f2150[i8 + i9]) ^ (((long) i9) * f2152)) ^ ((long) c7));
                        c.f1193 = i9 + 1;
                    } else {
                        str = new String(cArr);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}
