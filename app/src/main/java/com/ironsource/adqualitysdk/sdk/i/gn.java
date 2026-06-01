package com.ironsource.adqualitysdk.sdk.i;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.ironsource.G5;
import com.ironsource.adqualitysdk.sdk.i.bv;
import com.mbridge.msdk.MBridgeSDK;
import com.mintegral.msdk.MIntegralSDK;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class gn {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class b extends gk {

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private static int f2192 = 0;

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private static int f2193 = 1;

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private static char[] f2194 = {'9', 'i', 'f', 'M', 'M', 'p', 'k', 'g', 'L', G5.T, 'K', '[', 'q', 'l', 'f', 'l', 'i', 'f', '_', 'K', 'G', 'W', 'i', 'n', 'M', 'M', 'k', 'k', 'q', 'l', 'f', '6', 'k', 'k', 'q', 'l', 'f', 'l', 'i', 'f'};

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private static String m2265(String str, boolean z2, int[] iArr) throws UnsupportedEncodingException {
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
                    System.arraycopy(f2194, i2, cArr, 0, i8);
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
            f2192 = (f2193 + 83) % 128;
            String strIntern = m2265("\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001", false, new int[]{31, 9, 0, 0}).intern();
            int i2 = f2192 + 49;
            f2193 = i2 % 128;
            if (i2 % 2 != 0) {
                return strIntern;
            }
            throw null;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.gk
        /* JADX INFO: renamed from: ﻛ */
        public final Class mo2241() {
            int i2 = (f2193 + 21) % 128;
            f2192 = i2;
            int i8 = i2 + 5;
            f2193 = i8 % 128;
            if (i8 % 2 != 0) {
                return MIntegralSDK.class;
            }
            throw null;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.gk
        /* JADX INFO: renamed from: ﾇ */
        public final bg mo2242() {
            bv.a aVar = new bv.a(mo2240());
            int i2 = f2193 + 33;
            f2192 = i2 % 128;
            if (i2 % 2 == 0) {
                return aVar;
            }
            throw null;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.gk
        /* JADX INFO: renamed from: ﾒ */
        public final String mo2243() {
            int i2 = f2192 + 75;
            f2193 = i2 % 128;
            String strIntern = (i2 % 2 == 0 ? m2265("\u0000\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0001\u0000\u0001\u0000\u0001\u0000", false, new int[]{0, 31, 0, 21}) : m2265("\u0000\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0001\u0000\u0001\u0000\u0001\u0000", false, new int[]{0, 31, 0, 21})).intern();
            f2193 = (f2192 + 57) % 128;
            return strIntern;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class c extends gk {

        /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
        private static int f2195 = 1;

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private static char f2196 = 43446;

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private static int f2197 = 0;

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private static char f2198 = 19037;

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private static char f2199 = 2312;

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private static char f2200 = 37557;

        @Override // com.ironsource.adqualitysdk.sdk.i.gk
        /* JADX INFO: renamed from: ﻐ */
        public final String mo2240() {
            f2195 = (f2197 + 91) % 128;
            String strIntern = m2266("싇\ue17f\udfcb\uee37泑缤旣ޖԿ滽", 9 - TextUtils.indexOf("", "", 0, 0)).intern();
            f2197 = (f2195 + 91) % 128;
            return strIntern;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.gk
        /* JADX INFO: renamed from: ﻛ */
        public final Class mo2241() {
            int i2 = f2197;
            int i8 = i2 + 33;
            f2195 = i8 % 128;
            if (i8 % 2 == 0) {
                throw null;
            }
            f2195 = (i2 + 33) % 128;
            return MBridgeSDK.class;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.gk
        /* JADX INFO: renamed from: ﾇ */
        public final bg mo2242() {
            bv.b bVar = new bv.b(mo2240());
            int i2 = f2195 + 35;
            f2197 = i2 % 128;
            if (i2 % 2 == 0) {
                return bVar;
            }
            throw null;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.gk
        /* JADX INFO: renamed from: ﾒ */
        public final String mo2243() {
            f2195 = (f2197 + 85) % 128;
            String strIntern = m2266("썯\u20c3苲뺒泤妘术艭\uec91㞯痩鵟㦻龒\ueb4f⦇䑴䋎ꖶ뵿璝愡鯳竨\ue0b3禒擄鶎", 27 - (ViewConfiguration.getWindowTouchSlop() >> 8)).intern();
            int i2 = f2195 + 45;
            f2197 = i2 % 128;
            if (i2 % 2 == 0) {
                return strIntern;
            }
            throw null;
        }

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private static String m2266(String str, int i2) {
            String str2;
            Object charArray = str;
            if (str != null) {
                charArray = str.toCharArray();
            }
            char[] cArr = (char[]) charArray;
            synchronized (o.f2985) {
                try {
                    char[] cArr2 = new char[cArr.length];
                    o.f2986 = 0;
                    char[] cArr3 = new char[2];
                    while (true) {
                        int i8 = o.f2986;
                        if (i8 < cArr.length) {
                            cArr3[0] = cArr[i8];
                            cArr3[1] = cArr[i8 + 1];
                            int i9 = 58224;
                            for (int i10 = 0; i10 < 16; i10++) {
                                char c7 = cArr3[1];
                                char c8 = cArr3[0];
                                char c9 = (char) (c7 - (((c8 + i9) ^ ((c8 << 4) + f2199)) ^ ((c8 >>> 5) + f2198)));
                                cArr3[1] = c9;
                                cArr3[0] = (char) (c8 - (((c9 >>> 5) + f2200) ^ ((c9 + i9) ^ ((c9 << 4) + f2196))));
                                i9 -= 40503;
                            }
                            int i11 = o.f2986;
                            cArr2[i11] = cArr3[0];
                            cArr2[i11 + 1] = cArr3[1];
                            o.f2986 = i11 + 2;
                        } else {
                            str2 = new String(cArr2, 0, i2);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return str2;
        }
    }

    public gn() {
    }

    public gn(Context context) {
        context.getApplicationContext();
    }
}
