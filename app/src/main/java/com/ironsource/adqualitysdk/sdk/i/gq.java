package com.ironsource.adqualitysdk.sdk.i;

import android.text.TextUtils;
import android.view.View;
import com.vungle.ads.internal.protos.Sdk;
import jp.maio.sdk.android.MaioAds;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class gq extends gk {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f2208 = 1;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static long f2209 = 1718531341791055039L;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f2210;

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻐ */
    public final String mo2240() {
        f2210 = (f2208 + 77) % 128;
        String strIntern = m2269("攆贤そ쎗敫䇺ꥊꗅ", -TextUtils.indexOf((CharSequence) "", '0')).intern();
        int i2 = f2208 + 53;
        f2210 = i2 % 128;
        if (i2 % 2 == 0) {
            return strIntern;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻛ */
    public final Class mo2241() {
        int i2 = f2208;
        int i8 = i2 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE;
        f2210 = i8 % 128;
        if (i8 % 2 != 0) {
            throw null;
        }
        f2210 = (i2 + 39) % 128;
        return MaioAds.class;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾇ */
    public final bg mo2242() {
        bs bsVar = new bs(mo2240());
        int i2 = f2210 + 25;
        f2208 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 52 / 0;
        }
        return bsVar;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾒ */
    public final String mo2243() {
        int i2 = f2210 + 39;
        f2208 = i2 % 128;
        return m2269("䖲쉰듃膄䗘\u0ebfⶓ\ue7d4眯㶢磖ᢓ‹\uf0a3䯞䶟\udd27Ɬ蛕织踭媶퇉뎇묓\u09baⳀ\ue4c2琛㲳翖", i2 % 2 == 0 ? 1 >> View.resolveSizeAndState(1, 0, 1) : View.resolveSizeAndState(0, 0, 0) + 1).intern();
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m2269(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (i.f2441) {
            try {
                char[] cArrM2497 = i.m2497(f2209, cArr, i2);
                i.f2442 = 4;
                while (true) {
                    int i8 = i.f2442;
                    if (i8 < cArrM2497.length) {
                        i.f2443 = i8 - 4;
                        cArrM2497[i8] = (char) (((long) (cArrM2497[i8] ^ cArrM2497[i8 % 4])) ^ (((long) r2) * f2209));
                        i.f2442 = i8 + 1;
                    } else {
                        str2 = new String(cArrM2497, 4, cArrM2497.length - 4);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }
}
