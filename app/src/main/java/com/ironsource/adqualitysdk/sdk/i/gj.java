package com.ironsource.adqualitysdk.sdk.i;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import com.five_corp.ad.FiveAd;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class gj extends gk {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f2177 = 1;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f2178;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static char[] f2179 = {63999, 64125, 65261, 62232, 63426, 59443, 60606, 57627, 58803, 58881, 55935, 57076, 54084, 55172, 51257, 52394, 49490, 50612, 50697, 47712, 48865, 45947, 47052, 25026, 25155, 26318, 27499, 28669, 28678};

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static long f2180 = -7506103602390170738L;

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻐ */
    public final String mo2240() {
        f2177 = (f2178 + 107) % 128;
        String strIntern = m2260((char) (24996 - (ViewConfiguration.getPressedStateDuration() >> 16)), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 6, 23 - (ViewConfiguration.getEdgeSlop() >> 16)).intern();
        f2178 = (f2177 + 17) % 128;
        return strIntern;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻛ */
    public final Class mo2241() {
        int i2 = (f2178 + 65) % 128;
        f2177 = i2;
        int i8 = i2 + 105;
        f2178 = i8 % 128;
        if (i8 % 2 == 0) {
            return FiveAd.class;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾇ */
    public final bg mo2242() {
        br brVar = new br(mo2240());
        int i2 = f2177 + 69;
        f2178 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 34 / 0;
        }
        return brVar;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾒ */
    public final String mo2243() {
        char fadingEdgeLength;
        int iIndexOf;
        int deadChar;
        int i2 = f2178 + 13;
        f2177 = i2 % 128;
        if (i2 % 2 == 0) {
            fadingEdgeLength = (char) (63900 << (ViewConfiguration.getFadingEdgeLength() * 71));
            iIndexOf = TextUtils.indexOf("", "") + 37;
            deadChar = KeyEvent.getDeadChar(0, 1);
        } else {
            fadingEdgeLength = (char) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 63900);
            iIndexOf = TextUtils.indexOf("", "") + 23;
            deadChar = KeyEvent.getDeadChar(0, 0);
        }
        return m2260(fadingEdgeLength, iIndexOf, deadChar).intern();
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m2260(char c7, int i2, int i8) {
        String str;
        synchronized (c.f1192) {
            try {
                char[] cArr = new char[i2];
                c.f1193 = 0;
                while (true) {
                    int i9 = c.f1193;
                    if (i9 < i2) {
                        cArr[i9] = (char) ((((long) f2179[i8 + i9]) ^ (((long) i9) * f2180)) ^ ((long) c7));
                        c.f1193 = i9 + 1;
                    } else {
                        str = new String(cArr);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}
