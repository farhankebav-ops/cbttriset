package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.os.Process;
import com.ironsource.adqualitysdk.sdk.IronSourceAdQuality;
import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class gb extends gk {

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static int f2133 = 1;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f2134 = 0;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static char f2135 = 45214;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static char f2136 = 30063;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static char f2137 = 14752;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static char f2138 = 42628;

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻐ */
    public final String mo2240() {
        f2134 = (f2133 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
        String strIntern = m2250("ၠ偐Ⴅᩍ뵢긗캧≆䋛㮻⅞䊱㾘\u0dbc냥\uf5ca", 15 - (Process.myTid() >> 22)).intern();
        int i2 = f2133 + 91;
        f2134 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 36 / 0;
        }
        return strIntern;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻛ */
    public final Class mo2241() {
        int i2 = (f2133 + 85) % 128;
        f2134 = i2;
        int i8 = i2 + 41;
        f2133 = i8 % 128;
        if (i8 % 2 != 0) {
            return IronSourceAdQuality.class;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾇ */
    public final bg mo2242() {
        be beVar = new be(mo2240());
        int i2 = f2133 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE;
        f2134 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 63 / 0;
        }
        return beVar;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾒ */
    public final String mo2243() {
        f2133 = (f2134 + 41) % 128;
        String strIntern = m2250("\uf211\ue9f4祯\uea96芰옗伬ώ\ue12f㗚㱓㌝߅许鳣ㄐ巊焃\ue822뽓饔쒺䄬Ꙁ䰭癤\u1f5eﵪ䰭癤\u1f5eﵪ\uf556\ufafb伬ώ\ue9af葹㱓㌝߅许ᚽ\ue69a玠ᵍ뵢긗캧≆伊\udd71", 51 - Color.green(0)).intern();
        f2133 = (f2134 + 63) % 128;
        return strIntern;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m2250(String str, int i2) {
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
                            char c9 = (char) (c7 - (((c8 + i9) ^ ((c8 << 4) + f2137)) ^ ((c8 >>> 5) + f2135)));
                            cArr3[1] = c9;
                            cArr3[0] = (char) (c8 - (((c9 >>> 5) + f2138) ^ ((c9 + i9) ^ ((c9 << 4) + f2136))));
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
