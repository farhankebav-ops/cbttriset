package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import com.ironsource.adqualitysdk.sdk.i.bg;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class bh extends bg {

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f808 = 1;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static long f809 = -8647021406490404399L;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f810;

    public bh(String str) {
        super(str);
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m889(String str, int i2) {
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
                        cArr2[i8] = (char) (((long) (cArr[i8] ^ (j.f2669 * i8))) ^ f809);
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

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﱡ */
    public final boolean mo870() {
        int i2 = f810 + 101;
        f808 = i2 % 128;
        if (i2 % 2 != 0) {
            return true;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻐ */
    public final String mo825() {
        f810 = (f808 + 77) % 128;
        String strIntern = m889("\ud994\uf65c蘖囚暑㝛윇", Color.argb(0, 0, 0, 0) + 12227).intern();
        int i2 = f808 + 3;
        f810 = i2 % 128;
        if (i2 % 2 == 0) {
            return strIntern;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻛ */
    public final Class mo826(String str) {
        int i2 = f808;
        int i8 = i2 + 97;
        f810 = i8 % 128;
        if (i8 % 2 != 0) {
            throw null;
        }
        int i9 = i2 + 87;
        f810 = i9 % 128;
        if (i9 % 2 == 0) {
            return null;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﾇ */
    public final Map<String, bg.a> mo827() {
        HashMap map = new HashMap();
        f810 = (f808 + 51) % 128;
        return map;
    }
}
