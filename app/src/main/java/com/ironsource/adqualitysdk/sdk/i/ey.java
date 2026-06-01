package com.ironsource.adqualitysdk.sdk.i;

import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ey extends en {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static char[] f2023 = {'-'};

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f2024 = 0;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static char f2025 = 1;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f2026 = 1;

    public ey(ee eeVar, ee eeVar2, Cdo cdo) {
        super(eeVar, eeVar2, cdo);
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.eg
    /* JADX INFO: renamed from: ﻛ */
    public final String mo2195() {
        f2024 = (f2026 + 31) % 128;
        String strIntern = m2218(-TextUtils.lastIndexOf("", '0'), (byte) ((ViewConfiguration.getScrollBarFadeDuration() >> 16) + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE), "¢").intern();
        int i2 = f2026 + 21;
        f2024 = i2 % 128;
        if (i2 % 2 == 0) {
            return strIntern;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.en
    /* JADX INFO: renamed from: ﾒ */
    public final Number mo2209(Number number, Number number2) {
        int i2 = f2024 + 57;
        f2026 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
        if ((number instanceof Double) || (number2 instanceof Double)) {
            return Double.valueOf(number.doubleValue() - number2.doubleValue());
        }
        if ((number instanceof Long) || (number2 instanceof Long)) {
            Long lValueOf = Long.valueOf(number.longValue() - number2.longValue());
            int i8 = f2026 + 5;
            f2024 = i8 % 128;
            if (i8 % 2 == 0) {
                return lValueOf;
            }
            throw null;
        }
        Integer numValueOf = Integer.valueOf(number.intValue() - number2.intValue());
        int i9 = f2026 + 55;
        f2024 = i9 % 128;
        if (i9 % 2 == 0) {
            return numValueOf;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m2218(int i2, byte b8, String str) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (h.f2264) {
            try {
                char[] cArr2 = f2023;
                char c7 = f2025;
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
}
