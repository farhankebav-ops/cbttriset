package com.ironsource.adqualitysdk.sdk.i;

import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class et extends en {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f2009 = 0;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f2010 = 1;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2011 = 138;

    public et(ee eeVar, ee eeVar2, Cdo cdo) {
        super(eeVar, eeVar2, cdo);
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.eg
    /* JADX INFO: renamed from: ﻛ */
    public final String mo2195() {
        f2009 = (f2010 + 39) % 128;
        String strIntern = m2214(185 - View.MeasureSpec.makeMeasureSpec(0, 0), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), "\u0000", (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), false).intern();
        int i2 = f2010 + 93;
        f2009 = i2 % 128;
        if (i2 % 2 == 0) {
            return strIntern;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.en
    /* JADX INFO: renamed from: ﾒ */
    public final Number mo2209(Number number, Number number2) {
        int i2 = f2010;
        f2009 = (i2 + 101) % 128;
        if (!(number instanceof Double)) {
            int i8 = i2 + 57;
            int i9 = i8 % 128;
            f2009 = i9;
            if (i8 % 2 != 0) {
                throw null;
            }
            if (!(number2 instanceof Double)) {
                if (!(number instanceof Long)) {
                    int i10 = i9 + 89;
                    f2010 = i10 % 128;
                    if (i10 % 2 == 0) {
                        throw null;
                    }
                    if (!(number2 instanceof Long)) {
                        return Integer.valueOf(number.intValue() / number2.intValue());
                    }
                }
                return Long.valueOf(number.longValue() / number2.longValue());
            }
        }
        return Double.valueOf(number.doubleValue() / number2.doubleValue());
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m2214(int i2, int i8, String str, int i9, boolean z2) {
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
                    cArr2[i11] = (char) (cArr2[i11] - f2011);
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
}
