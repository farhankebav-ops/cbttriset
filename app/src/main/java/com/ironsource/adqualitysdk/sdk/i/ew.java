package com.ironsource.adqualitysdk.sdk.i;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewConfiguration;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ew extends eo {

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f2019 = 0;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f2020 = 110;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f2021 = 1;

    public ew(ee eeVar, ee eeVar2, Cdo cdo) {
        super(eeVar, eeVar2, cdo);
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m2217(int i2, int i8, String str, int i9, boolean z2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (e.f1927) {
            try {
                char[] cArr2 = new char[i8];
                e.f1926 = 0;
                while (true) {
                    int i10 = e.f1926;
                    if (i10 >= i8) {
                        break;
                    }
                    e.f1929 = cArr[i10];
                    cArr2[e.f1926] = (char) (e.f1929 + i2);
                    int i11 = e.f1926;
                    cArr2[i11] = (char) (cArr2[i11] - f2020);
                    e.f1926 = i11 + 1;
                }
                if (i9 > 0) {
                    e.f1928 = i9;
                    char[] cArr3 = new char[i8];
                    System.arraycopy(cArr2, 0, cArr3, 0, i8);
                    int i12 = e.f1928;
                    System.arraycopy(cArr3, 0, cArr2, i8 - i12, i12);
                    int i13 = e.f1928;
                    System.arraycopy(cArr3, i13, cArr2, 0, i8 - i13);
                }
                if (z2) {
                    char[] cArr4 = new char[i8];
                    e.f1926 = 0;
                    while (true) {
                        int i14 = e.f1926;
                        if (i14 >= i8) {
                            break;
                        }
                        cArr4[i14] = cArr2[(i8 - i14) - 1];
                        e.f1926 = i14 + 1;
                    }
                    cArr2 = cArr4;
                }
                str2 = new String(cArr2);
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.eg
    /* JADX INFO: renamed from: ﻛ */
    public final String mo2195() {
        int i2 = f2021 + 91;
        f2019 = i2 % 128;
        return (i2 % 2 != 0 ? m2217(12600 << ((byte) KeyEvent.getModifierMetaStateMask()), ViewConfiguration.getScrollBarFadeDuration() * 109, "\u0000", -TextUtils.lastIndexOf("", 'Q', 0, 1), false) : m2217(169 - ((byte) KeyEvent.getModifierMetaStateMask()), 1 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), "\u0000", -TextUtils.lastIndexOf("", '0', 0, 0), true)).intern();
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.el
    /* JADX INFO: renamed from: ｋ */
    public final boolean mo2205(int i2) {
        if (i2 < 0) {
            f2019 = (f2021 + 43) % 128;
            return true;
        }
        f2019 = (f2021 + 45) % 128;
        return false;
    }
}
