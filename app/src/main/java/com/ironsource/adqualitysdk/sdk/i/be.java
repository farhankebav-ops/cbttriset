package com.ironsource.adqualitysdk.sdk.i;

import android.text.AndroidCharacter;
import android.text.TextUtils;
import com.ironsource.adqualitysdk.sdk.i.bg;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class be extends bg {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f779 = 0;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f780 = 1;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static long f781 = 0;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static char f782 = 0;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f783 = -703389678;

    public be(String str) {
        super(str);
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m871(String str, char c7, String str2, int i2, String str3) {
        String str4;
        Object charArray = str3;
        if (str3 != null) {
            charArray = str3.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        Object charArray2 = str2;
        if (str2 != null) {
            charArray2 = str2.toCharArray();
        }
        char[] cArr2 = (char[]) charArray2;
        Object charArray3 = str;
        if (str != null) {
            charArray3 = str.toCharArray();
        }
        char[] cArr3 = (char[]) charArray3;
        synchronized (f.f2031) {
            try {
                char[] cArr4 = (char[]) cArr3.clone();
                char[] cArr5 = (char[]) cArr.clone();
                cArr4[0] = (char) (c7 ^ cArr4[0]);
                cArr5[2] = (char) (cArr5[2] + ((char) i2));
                int length = cArr2.length;
                char[] cArr6 = new char[length];
                f.f2032 = 0;
                while (true) {
                    int i8 = f.f2032;
                    if (i8 < length) {
                        int i9 = (i8 + 2) % 4;
                        int i10 = (i8 + 3) % 4;
                        int i11 = cArr4[i8 % 4] * 32718;
                        char c8 = cArr5[i9];
                        char c9 = (char) ((i11 + c8) % 65535);
                        f.f2030 = c9;
                        cArr5[i10] = (char) com.google.android.gms.ads.internal.client.a.w(cArr4[i10], 32718, c8, 65535);
                        cArr4[i10] = c9;
                        int i12 = f.f2032;
                        cArr6[i12] = (char) (((((long) (c9 ^ cArr2[i12])) ^ f781) ^ ((long) f783)) ^ ((long) f782));
                        f.f2032 = i12 + 1;
                    } else {
                        str4 = new String(cArr6);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str4;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﱡ */
    public final boolean mo870() {
        int i2 = f780;
        int i8 = i2 + 27;
        f779 = i8 % 128;
        boolean z2 = i8 % 2 == 0;
        int i9 = i2 + 95;
        f779 = i9 % 128;
        if (i9 % 2 == 0) {
            return z2;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    public final boolean mo872() {
        f779 = (f780 + 45) % 128;
        return true;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻐ */
    public final String mo825() {
        f779 = (f780 + 85) % 128;
        String strIntern = m871("ꬠ᩵ᙐ\u16fb", (char) ('0' - AndroidCharacter.getMirror('0')), "纍䶈⒡閫\ueed1\u1ad9\ua6fe", 1343911338 - TextUtils.indexOf((CharSequence) "", '0', 0), "\u0000\u0000\u0000\u0000").intern();
        int i2 = f780 + 59;
        f779 = i2 % 128;
        if (i2 % 2 == 0) {
            return strIntern;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻛ */
    public final Class mo826(String str) {
        int i2 = f780 + 99;
        f779 = i2 % 128;
        if (i2 % 2 == 0) {
            return null;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﾇ */
    public final Map<String, bg.a> mo827() {
        HashMap map = new HashMap();
        int i2 = f779 + 9;
        f780 = i2 % 128;
        if (i2 % 2 != 0) {
            return map;
        }
        throw null;
    }
}
