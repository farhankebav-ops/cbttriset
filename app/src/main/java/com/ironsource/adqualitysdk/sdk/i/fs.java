package com.ironsource.adqualitysdk.sdk.i;

import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.ViewConfiguration;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class fs extends fo {

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f2094 = 0;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static char f2095 = 3;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2096 = 1;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static char[] f2097 = {'r', 'e', 't', 'u', 'n', ' ', ';', 's', 'v'};

    public fs(ee eeVar) {
        super(eeVar);
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m2237(int i2, byte b8, String str) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (h.f2264) {
            try {
                char[] cArr2 = f2097;
                char c7 = f2095;
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

    @Override // com.ironsource.adqualitysdk.sdk.i.fo
    public final String toString() {
        f2094 = (f2096 + 1) % 128;
        if (m2233() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(m2237(AndroidCharacter.getMirror('0') - ')', (byte) (33 - TextUtils.indexOf("", "", 0, 0)), "\u0001\u0002\u0000\u0005\u0001\u0003A").intern());
            sb.append(super.toString());
            return sb.toString();
        }
        String strIntern = m2237(TextUtils.indexOf((CharSequence) "", '0', 0) + 8, (byte) ((ViewConfiguration.getKeyRepeatDelay() >> 16) + 62), "\u0001\u0002\u0000\u0005\u0001\u0003y").intern();
        int i2 = f2096 + 15;
        f2094 = i2 % 128;
        if (i2 % 2 == 0) {
            return strIntern;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.fo, com.ironsource.adqualitysdk.sdk.i.fr
    /* JADX INFO: renamed from: ﻐ */
    public final du mo2225(ds dsVar, cp cpVar) {
        f2096 = (f2094 + 69) % 128;
        du duVarMo2225 = super.mo2225(dsVar, cpVar);
        duVarMo2225.m2149(true);
        f2094 = (f2096 + 79) % 128;
        return duVarMo2225;
    }
}
