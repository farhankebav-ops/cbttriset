package com.ironsource.adqualitysdk.sdk.i;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ez extends eg {

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f2027 = 0;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f2028 = 1;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static long f2029 = 6823446894326390185L;

    public ez(ee eeVar, ee eeVar2, Cdo cdo) {
        super(eeVar, eeVar2, cdo);
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m2219(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (i.f2441) {
            try {
                char[] cArrM2497 = i.m2497(f2029, cArr, i2);
                i.f2442 = 4;
                while (true) {
                    int i8 = i.f2442;
                    if (i8 < cArrM2497.length) {
                        i.f2443 = i8 - 4;
                        cArrM2497[i8] = (char) (((long) (cArrM2497[i8] ^ cArrM2497[i8 % 4])) ^ (((long) r2) * f2029));
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

    @Override // com.ironsource.adqualitysdk.sdk.i.ee
    /* JADX INFO: renamed from: ﻛ */
    public final du mo2156(ds dsVar, cp cpVar) {
        f2028 = (f2027 + 91) % 128;
        du duVarM2189 = m2196().m2189(dsVar, cpVar);
        if (duVarM2189.m2150()) {
            return duVarM2189;
        }
        du duVarM21892 = m2194().m2189(dsVar, cpVar);
        int i2 = f2027 + 31;
        f2028 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 25 / 0;
        }
        return duVarM21892;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.eg
    /* JADX INFO: renamed from: ﻛ */
    public final String mo2195() {
        f2028 = (f2027 + 109) % 128;
        String strIntern = m2219("\ud8c1\ud8bd蕗颂\ued54䞡", 1 - View.getDefaultSize(0, 0)).intern();
        int i2 = f2027 + 69;
        f2028 = i2 % 128;
        if (i2 % 2 != 0) {
            return strIntern;
        }
        throw null;
    }
}
