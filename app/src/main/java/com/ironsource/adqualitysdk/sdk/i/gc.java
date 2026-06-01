package com.ironsource.adqualitysdk.sdk.i;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.ironsource.adqualitysdk.sdk.IronSourceAdQuality;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class gc extends gk {

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2141 = 1;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f2142;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static char[] f2140 = {8357, 52844, 64801, 60583, 39867, 35181, 47159, 42955, 22173, 17476, 29441, 25283, 4505, 162, 11822, 56620, 52466, 64418, 59753, 38968, 34766, 46726, 42076, 21260, 17101, 29087, 24751, 3631, 15673, 11507, 56251, 51507, 63535, 59345, 38531, 33863, 45857, 41680, 20877, 16567, 28269, 7470, 3285, 15285, 10571, 55314, 51137, 63105, 58463, 37639, 33477, 1576, 59624, 56242, 51829, 48437, 45041, 40613, 33103, 28677, 25297, 21903, 17495, 14105, 9787};

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static long f2139 = -8808215556371845435L;

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻐ */
    public final String mo2240() {
        int i2 = f2141 + 91;
        f2142 = i2 % 128;
        String strIntern = (i2 % 2 != 0 ? m2251((char) (9430 % View.getDefaultSize(1, 0)), 71 % View.resolveSizeAndState(1, 0, 0), 125 - (ViewConfiguration.getTapTimeout() % 7)) : m2251((char) (1609 - View.getDefaultSize(0, 0)), 14 - View.resolveSizeAndState(0, 0, 0), (ViewConfiguration.getTapTimeout() >> 16) + 51)).intern();
        int i8 = f2141 + 19;
        f2142 = i8 % 128;
        if (i8 % 2 == 0) {
            return strIntern;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻛ */
    public final Class mo2241() {
        int i2 = f2142 + 55;
        f2141 = i2 % 128;
        if (i2 % 2 != 0) {
            return IronSourceAdQuality.class;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾇ */
    public final bg mo2242() {
        bh bhVar = new bh(mo2240());
        f2141 = (f2142 + 53) % 128;
        return bhVar;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾒ */
    public final String mo2243() {
        char cNormalizeMetaState;
        int doubleTapTimeout;
        int minimumFlingVelocity;
        int i2 = f2141 + 5;
        f2142 = i2 % 128;
        if (i2 % 2 != 0) {
            cNormalizeMetaState = (char) (2487 << KeyEvent.normalizeMetaState(0));
            doubleTapTimeout = ViewConfiguration.getDoubleTapTimeout() * 7747;
            minimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity() + 40;
        } else {
            cNormalizeMetaState = (char) (8390 - KeyEvent.normalizeMetaState(0));
            doubleTapTimeout = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 51;
            minimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity() >> 16;
        }
        String strIntern = m2251(cNormalizeMetaState, doubleTapTimeout, minimumFlingVelocity).intern();
        f2141 = (f2142 + 47) % 128;
        return strIntern;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m2251(char c7, int i2, int i8) {
        String str;
        synchronized (c.f1192) {
            try {
                char[] cArr = new char[i2];
                c.f1193 = 0;
                while (true) {
                    int i9 = c.f1193;
                    if (i9 < i2) {
                        cArr[i9] = (char) ((((long) f2140[i8 + i9]) ^ (((long) i9) * f2139)) ^ ((long) c7));
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
