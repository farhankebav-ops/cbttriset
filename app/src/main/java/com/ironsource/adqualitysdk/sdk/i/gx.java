package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.ironsource.adqualitysdk.sdk.i.cg;
import com.unity3d.services.UnityServices;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import com.vungle.ads.internal.protos.Sdk;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class gx extends gk {

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static int f2244 = 1;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static int f2245 = 0;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static short[] f2246 = null;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static byte[] f2247 = {-11, -19, -31, -7, -16, -29, -22, -47, 25, -30, -24, -8, -42, -60, 56, -19, -31, -7, -16, -29, -22, -15, -94, 41, -82, 57, -30, -24, -8, -10, -92, 30, -3, -21, -37, -106, -94, 119, -100, -102, 106, 104};

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f2248 = 683296284;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2249 = 45;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f2250 = -1508738418;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class d extends gk {

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private static int f2251 = 1;

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private static int f2252;

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private static char[] f2253 = {23, 'P', 'l', 'k', 't', 'o', 'f', 'd', 'l', 'P', 'G', 'b', 'k', 'P', 'G', 'b', 'l', 'q', 'k', 'n', 'Q', '7', 'R', '\\', 'a', 'k', 'n', 'Z', 'R', 'k', 'n', 'o', 'o', 'n', 'v', 'n', 'i', 'n', 'M', 'Q', 'q', 'k', 'n', 'v', 'V', 'K', '2', 'k', 't', 'q', 'k', 'n', 'v', 'm'};

        /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
        private static boolean m2278() {
            boolean zM864 = bc.m864(new gx());
            f2251 = (f2252 + 37) % 128;
            return zM864;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.gk
        /* JADX INFO: renamed from: ﻐ */
        public final String mo2240() {
            f2251 = (f2252 + 95) % 128;
            String strIntern = m2279("\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000", false, new int[]{46, 8, 0, 2}).intern();
            int i2 = f2252 + 71;
            f2251 = i2 % 128;
            if (i2 % 2 != 0) {
                return strIntern;
            }
            throw null;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.gk
        /* JADX INFO: renamed from: ﻛ */
        public final Class mo2241() {
            if (!m2278()) {
                return AdUnitActivity.class;
            }
            int i2 = f2251 + 29;
            f2252 = i2 % 128;
            if (i2 % 2 == 0) {
                return null;
            }
            throw null;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.gk
        /* JADX INFO: renamed from: ﾇ */
        public final bg mo2242() {
            cg.b bVar = new cg.b(mo2240());
            f2252 = (f2251 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) % 128;
            return bVar;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.gk
        /* JADX INFO: renamed from: ﾒ */
        public final String mo2243() {
            f2251 = (f2252 + 85) % 128;
            if (!m2278()) {
                return m2279("\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0000\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001", false, new int[]{0, 46, 0, 35}).intern();
            }
            f2251 = (f2252 + 113) % 128;
            return null;
        }

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private static String m2279(String str, boolean z2, int[] iArr) throws UnsupportedEncodingException {
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
                    System.arraycopy(f2253, i2, cArr, 0, i8);
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

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻐ */
    public final String mo2240() {
        f2245 = (f2244 + 113) % 128;
        String strIntern = m2277((-46) - TextUtils.indexOf("", "", 0), (short) ((ViewConfiguration.getMinimumFlingVelocity() >> 16) + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE), 1508738452 - TextUtils.getCapsMode("", 0, 0), (byte) (TextUtils.indexOf((CharSequence) "", '0', 0) + 29), Color.green(0) - 683296167).intern();
        int i2 = f2244 + 17;
        f2245 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 98 / 0;
        }
        return strIntern;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻛ */
    public final Class mo2241() {
        int i2 = (f2245 + 59) % 128;
        f2244 = i2;
        int i8 = i2 + 21;
        f2245 = i8 % 128;
        if (i8 % 2 == 0) {
            return UnityServices.class;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾇ */
    public final bg mo2242() {
        cg cgVar = new cg(mo2240());
        f2244 = (f2245 + 47) % 128;
        return cgVar;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾒ */
    public final String mo2243() {
        f2244 = (f2245 + 69) % 128;
        String strIntern = m2277((-46) - (ViewConfiguration.getWindowTouchSlop() >> 8), (short) ((-110) - View.getDefaultSize(0, 0)), 1508738418 - View.resolveSize(0, 0), (byte) (TextUtils.getOffsetBefore("", 0) + 113), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) - 683296184).intern();
        int i2 = f2244 + 53;
        f2245 = i2 % 128;
        if (i2 % 2 == 0) {
            return strIntern;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m2277(int i2, short s7, int i8, byte b8, int i9) {
        String string;
        synchronized (n.f2979) {
            try {
                StringBuilder sb = new StringBuilder();
                int i10 = f2249;
                int i11 = i2 + i10;
                int i12 = i11 == -1 ? 1 : 0;
                if (i12 != 0) {
                    byte[] bArr = f2247;
                    i11 = bArr != null ? (byte) (bArr[f2250 + i8] + i10) : (short) (f2246[f2250 + i8] + i10);
                }
                if (i11 > 0) {
                    n.f2984 = ((i8 + i11) - 2) + f2250 + i12;
                    n.f2982 = b8;
                    char c7 = (char) (i9 + f2248);
                    n.f2981 = c7;
                    sb.append(c7);
                    n.f2980 = n.f2981;
                    n.f2983 = 1;
                    while (n.f2983 < i11) {
                        byte[] bArr2 = f2247;
                        if (bArr2 != null) {
                            int i13 = n.f2984;
                            n.f2984 = i13 - 1;
                            n.f2981 = (char) (n.f2980 + (((byte) (bArr2[i13] + s7)) ^ n.f2982));
                        } else {
                            short[] sArr = f2246;
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
