package com.ironsource.adqualitysdk.sdk.i;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class fc extends el {

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static int f2040 = 1;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static char f2041 = 44019;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static char f2042 = 10772;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f2043 = 0;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static char f2044 = 1885;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static char f2045 = 20137;

    public fc(ee eeVar, ee eeVar2, Cdo cdo) {
        super(eeVar, eeVar2, cdo);
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m2222(String str, int i2) {
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
                            char c9 = (char) (c7 - (((c8 + i9) ^ ((c8 << 4) + f2045)) ^ ((c8 >>> 5) + f2042)));
                            cArr3[1] = c9;
                            cArr3[0] = (char) (c8 - (((c9 >>> 5) + f2044) ^ ((c9 + i9) ^ ((c9 << 4) + f2041))));
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

    @Override // com.ironsource.adqualitysdk.sdk.i.el
    /* JADX INFO: renamed from: ﻛ */
    public final boolean mo2204(Object obj, Object obj2) {
        if (obj != obj2) {
            f2040 = (f2043 + 35) % 128;
            return true;
        }
        f2043 = (f2040 + 1) % 128;
        return false;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.el
    /* JADX INFO: renamed from: ｋ */
    public final boolean mo2205(int i2) {
        int i8 = f2043;
        f2040 = (i8 + 13) % 128;
        if (i2 == 0) {
            return false;
        }
        int i9 = (i8 + 51) % 128;
        f2040 = i9;
        int i10 = i9 + 3;
        f2043 = i10 % 128;
        if (i10 % 2 == 0) {
            return true;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.eg
    /* JADX INFO: renamed from: ﻛ */
    public final String mo2195() {
        int i2 = f2043 + 33;
        f2040 = i2 % 128;
        String strIntern = m2222("ىꡖ", i2 % 2 == 0 ? 4 - TextUtils.indexOf((CharSequence) "", (char) 30, 1, 1) : TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 3).intern();
        f2040 = (f2043 + 115) % 128;
        return strIntern;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.el
    /* JADX INFO: renamed from: ｋ */
    public final boolean mo2206(String str, String str2) {
        if (str.equals(str2)) {
            return false;
        }
        f2043 = (f2040 + 99) % 128;
        return true;
    }
}
