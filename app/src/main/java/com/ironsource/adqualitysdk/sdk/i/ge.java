package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.text.TextUtils;
import com.fyber.FairBid;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ge extends gk {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f2147 = 1;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2148 = 0;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static long f2149 = 923122982339501505L;

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻐ */
    public final String mo2240() {
        f2148 = (f2147 + 21) % 128;
        String strIntern = m2253("噽嘛뎱灲\ue5eeℛ\uee11쮙ﳟ㪽糧", -TextUtils.lastIndexOf("", '0', 0, 0)).intern();
        int i2 = f2147 + 33;
        f2148 = i2 % 128;
        if (i2 % 2 == 0) {
            return strIntern;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻛ */
    public final Class mo2241() {
        Class<FairBid> cls;
        int i2 = f2147 + 113;
        int i8 = i2 % 128;
        f2148 = i8;
        if (i2 % 2 != 0) {
            cls = FairBid.class;
            int i9 = 89 / 0;
        } else {
            cls = FairBid.class;
        }
        int i10 = i8 + 109;
        f2147 = i10 % 128;
        if (i10 % 2 != 0) {
            return cls;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾇ */
    public final bg mo2242() {
        bn bnVar = new bn(mo2240());
        f2148 = (f2147 + 99) % 128;
        return bnVar;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾒ */
    public final String mo2243() {
        f2148 = (f2147 + 69) % 128;
        String strIntern = m2253("ꮋꯨ\u17ea볩⯮\udce9䩄܆㊃黸㗢ꊡ䗱ƣ껊㖩컮裻⟊䲥矿", Color.green(0) + 1).intern();
        f2147 = (f2148 + 91) % 128;
        return strIntern;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m2253(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (i.f2441) {
            try {
                char[] cArrM2497 = i.m2497(f2149, cArr, i2);
                i.f2442 = 4;
                while (true) {
                    int i8 = i.f2442;
                    if (i8 < cArrM2497.length) {
                        i.f2443 = i8 - 4;
                        cArrM2497[i8] = (char) (((long) (cArrM2497[i8] ^ cArrM2497[i8 % 4])) ^ (((long) r2) * f2149));
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
