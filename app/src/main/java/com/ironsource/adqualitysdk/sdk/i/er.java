package com.ironsource.adqualitysdk.sdk.i;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class er extends eo {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f2000 = 0;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f2001 = 1;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static long f2002 = -4808092426746911067L;

    public er(ee eeVar, ee eeVar2, Cdo cdo) {
        super(eeVar, eeVar2, cdo);
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m2212(String str, int i2) {
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
                        cArr2[i8] = (char) (((long) (cArr[i8] ^ (j.f2669 * i8))) ^ f2002);
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

    @Override // com.ironsource.adqualitysdk.sdk.i.eg
    /* JADX INFO: renamed from: ﻛ */
    public final String mo2195() {
        int i2 = f2000 + 29;
        f2001 = i2 % 128;
        return (i2 % 2 == 0 ? m2212("⚛┓", 23884 % TextUtils.indexOf((CharSequence) "", '1')) : m2212("⚛┓", TextUtils.indexOf((CharSequence) "", '0') + 908)).intern();
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.el
    /* JADX INFO: renamed from: ｋ */
    public final boolean mo2205(int i2) {
        int i8 = (f2000 + 25) % 128;
        f2001 = i8;
        if (i2 >= 0) {
            return true;
        }
        f2000 = (i8 + 79) % 128;
        return false;
    }
}
