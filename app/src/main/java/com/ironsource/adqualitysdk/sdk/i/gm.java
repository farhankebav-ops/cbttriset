package com.ironsource.adqualitysdk.sdk.i;

import android.text.TextUtils;
import com.inmobi.sdk.InMobiSdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class gm extends gk {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static long f2189 = 5657521403065740628L;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f2190 = 1;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f2191;

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻐ */
    public final String mo2240() {
        int i2 = f2191 + 63;
        f2190 = i2 % 128;
        return m2264("ⴽᗅ峇蟆컊㇆", i2 % 2 == 0 ? TextUtils.getCapsMode("", 0, 1) + 2101 : TextUtils.getCapsMode("", 0, 0) + 14591).intern();
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻛ */
    public final Class mo2241() {
        int i2 = f2191;
        f2190 = (i2 + 27) % 128;
        int i8 = i2 + 5;
        f2190 = i8 % 128;
        if (i8 % 2 != 0) {
            return InMobiSdk.class;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾇ */
    public final bg mo2242() {
        bo boVar = new bo(mo2240());
        f2190 = (f2191 + 9) % 128;
        return boVar;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾒ */
    public final String mo2243() {
        f2190 = (f2191 + 71) % 128;
        String strIntern = m2264("ⴷ驖䏣ଽ\uf089렛憷⻀陞忨ܸ첈됬綶⪌鉾寪̤좑뀡禹⛶\uee6e埴", 46957 - TextUtils.indexOf("", "", 0, 0)).intern();
        f2190 = (f2191 + 9) % 128;
        return strIntern;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m2264(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (j.f2671) {
            try {
                j.f2669 = i2;
                char[] cArr2 = new char[cArr.length];
                j.f2670 = 0;
                while (true) {
                    int i8 = j.f2670;
                    if (i8 < cArr.length) {
                        cArr2[i8] = (char) (((long) (cArr[i8] ^ (j.f2669 * i8))) ^ f2189);
                        j.f2670++;
                    } else {
                        str2 = new String(cArr2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }
}
