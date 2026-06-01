package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.warren.VungleApiClient;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class hb extends gk {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f2271 = 1;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2272;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static char[] f2273 = {'y', 233, 228, 229, 230, 237};

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class b extends hb {

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private static int f2274 = 0;

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private static int f2275 = 140;

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private static int f2276 = 1;

        @Override // com.ironsource.adqualitysdk.sdk.i.gk
        /* JADX INFO: renamed from: ﻛ */
        public final Class mo2241() {
            int i2 = f2276 + 103;
            int i8 = i2 % 128;
            f2274 = i8;
            if (i2 % 2 != 0) {
                throw null;
            }
            int i9 = i8 + 51;
            f2276 = i9 % 128;
            if (i9 % 2 == 0) {
                int i10 = 28 / 0;
            }
            return VungleApiClient.class;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.gk
        /* JADX INFO: renamed from: ﾇ */
        public final bg mo2242() {
            cc ccVar = new cc(m2283(249 - (ViewConfiguration.getTouchSlop() >> 8), ImageFormat.getBitsPerPixel(0) + 7, "\u0001\b\t\ufff8\uffff\ufffa", ImageFormat.getBitsPerPixel(0) + 4, true).intern());
            int i2 = f2274 + 3;
            f2276 = i2 % 128;
            if (i2 % 2 == 0) {
                int i8 = 68 / 0;
            }
            return ccVar;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.gk
        /* JADX INFO: renamed from: ﾒ */
        public final String mo2243() {
            f2276 = (f2274 + 77) % 128;
            String strIntern = m2283((ViewConfiguration.getWindowTouchSlop() >> 8) + 239, 33 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), "\u0002\t\u0004\u000b\u0012\ufff3ￋ\u000b\u0002\u000f\u000f\ufffe\u0014ￋ\u0002\t\u0004\u000b\u0012\u0013ￋ\n\f\u0000\u0011\u000b\u0002\u0006\t￠\u0006\r\uffde", 24 - (ViewConfiguration.getLongPressTimeout() >> 16), true).intern();
            f2274 = (f2276 + 23) % 128;
            return strIntern;
        }

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private static String m2283(int i2, int i8, String str, int i9, boolean z2) {
            String str2;
            Object charArray = str;
            if (str != null) {
                charArray = str.toCharArray();
            }
            char[] cArr = (char[]) charArray;
            synchronized (e.f1927) {
                try {
                    char[] cArr2 = new char[i8];
                    e.f1926 = 0;
                    while (true) {
                        int i10 = e.f1926;
                        if (i10 >= i8) {
                            break;
                        }
                        e.f1929 = cArr[i10];
                        cArr2[e.f1926] = (char) (e.f1929 + i2);
                        int i11 = e.f1926;
                        cArr2[i11] = (char) (cArr2[i11] - f2275);
                        e.f1926 = i11 + 1;
                    }
                    if (i9 > 0) {
                        e.f1928 = i9;
                        char[] cArr3 = new char[i8];
                        System.arraycopy(cArr2, 0, cArr3, 0, i8);
                        int i12 = e.f1928;
                        System.arraycopy(cArr3, 0, cArr2, i8 - i12, i12);
                        int i13 = e.f1928;
                        System.arraycopy(cArr3, i13, cArr2, 0, i8 - i13);
                    }
                    if (z2) {
                        char[] cArr4 = new char[i8];
                        e.f1926 = 0;
                        while (true) {
                            int i14 = e.f1926;
                            if (i14 >= i8) {
                                break;
                            }
                            cArr4[i14] = cArr2[(i8 - i14) - 1];
                            e.f1926 = i14 + 1;
                        }
                        cArr2 = cArr4;
                    }
                    str2 = new String(cArr2);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return str2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class d extends hb {

        /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
        private static int f2277 = 0;

        /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
        private static int f2278 = 1;

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private static byte[] f2279 = {34, 44, 35, -42, -41, 3, -16, -45, 5, -10, -45, 47, -45, -45, 53, 2, -23, -45, 41, -46, 41, 37, -35, 106, -24, 33, -39, -42, 39, -37, 44, 47, 17, -111, 37, 41, 25, -29, -45, 47, -45, -45, -43, 98, -21, -44, 38};

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private static int f2280 = 1953477844;

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private static int f2281 = 13;

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private static short[] f2282 = null;

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private static int f2283 = 1095976657;

        @Override // com.ironsource.adqualitysdk.sdk.i.gk
        /* JADX INFO: renamed from: ﻛ */
        public final Class mo2241() {
            int i2 = f2277 + 17;
            int i8 = i2 % 128;
            f2278 = i8;
            if (i2 % 2 == 0) {
                int i9 = 76 / 0;
            }
            int i10 = i8 + 37;
            f2277 = i10 % 128;
            if (i10 % 2 == 0) {
                return com.vungle.ads.internal.network.VungleApiClient.class;
            }
            throw null;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.gk
        /* JADX INFO: renamed from: ﾇ */
        public final bg mo2242() {
            ck ckVar = new ck(mo2240());
            int i2 = f2277 + 75;
            f2278 = i2 % 128;
            if (i2 % 2 == 0) {
                int i8 = 35 / 0;
            }
            return ckVar;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.gk
        /* JADX INFO: renamed from: ﾒ */
        public final String mo2243() {
            f2278 = (f2277 + 71) % 128;
            String strIntern = m2284((ViewConfiguration.getWindowTouchSlop() >> 8) - 14, (short) View.combineMeasuredStates(0, 0), (-1953477845) - TextUtils.indexOf((CharSequence) "", '0'), (byte) (42 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) - 1095976558).intern();
            int i2 = f2278 + 105;
            f2277 = i2 % 128;
            if (i2 % 2 == 0) {
                return strIntern;
            }
            throw null;
        }

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private static String m2284(int i2, short s7, int i8, byte b8, int i9) {
            String string;
            synchronized (n.f2979) {
                try {
                    StringBuilder sb = new StringBuilder();
                    int i10 = f2281;
                    int i11 = i2 + i10;
                    int i12 = i11 == -1 ? 1 : 0;
                    if (i12 != 0) {
                        byte[] bArr = f2279;
                        i11 = bArr != null ? (byte) (bArr[f2280 + i8] + i10) : (short) (f2282[f2280 + i8] + i10);
                    }
                    if (i11 > 0) {
                        n.f2984 = ((i8 + i11) - 2) + f2280 + i12;
                        n.f2982 = b8;
                        char c7 = (char) (i9 + f2283);
                        n.f2981 = c7;
                        sb.append(c7);
                        n.f2980 = n.f2981;
                        n.f2983 = 1;
                        while (n.f2983 < i11) {
                            byte[] bArr2 = f2279;
                            if (bArr2 != null) {
                                int i13 = n.f2984;
                                n.f2984 = i13 - 1;
                                n.f2981 = (char) (n.f2980 + (((byte) (bArr2[i13] + s7)) ^ n.f2982));
                            } else {
                                short[] sArr = f2282;
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
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m2282(String str, boolean z2, int[] iArr) throws UnsupportedEncodingException {
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
                System.arraycopy(f2273, i2, cArr, 0, i8);
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

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻐ */
    public final String mo2240() {
        int i2 = f2272 + 31;
        f2271 = i2 % 128;
        String strIntern = (i2 % 2 == 0 ? m2282("\u0000\u0001\u0001\u0001\u0001\u0001", true, new int[]{0, 6, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE, 1}) : m2282("\u0000\u0001\u0001\u0001\u0001\u0001", true, new int[]{0, 6, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE, 1})).intern();
        f2272 = (f2271 + 15) % 128;
        return strIntern;
    }
}
