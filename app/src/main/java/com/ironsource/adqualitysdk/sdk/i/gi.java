package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.os.Process;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import com.hyprmx.android.sdk.placement.PlacementType;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class gi extends gk {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f2173 = 0;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static char[] f2174 = {'c', 35786, 5927, 41665, 12028, 47680, 17838, 53745, 23877, 59573, 29788, 'v', 35794, 5893, 41844, 11972, 47673, 17809, 53684, 23884, 59520, 29922, 0, 35747, 5908, 41852, 11937, 47618, 18017, 53716, 23864, 59535, 29838, 21, 35718, 6126, 41815, 11964, 47635, 17990, 53670, 23833, 59718, 29902, ',', 35940, 65375, 29931, 59405, 23978, 53710, 17782};

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static long f2175 = -9163474123766461531L;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2176 = 1;

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻐ */
    public final String mo2240() {
        f2176 = (f2173 + 95) % 128;
        String strIntern = m2259((char) (Color.red(0) + 65335), ImageFormat.getBitsPerPixel(0) + 7, 46 - KeyEvent.keyCodeFromString("")).intern();
        int i2 = f2173 + 31;
        f2176 = i2 % 128;
        if (i2 % 2 != 0) {
            return strIntern;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻛ */
    public final Class mo2241() {
        int i2 = f2173;
        f2176 = (i2 + 15) % 128;
        int i8 = i2 + 111;
        f2176 = i8 % 128;
        if (i8 % 2 != 0) {
            return PlacementType.class;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾇ */
    public final bg mo2242() {
        bq bqVar = new bq(mo2240());
        int i2 = f2173 + 105;
        f2176 = i2 % 128;
        if (i2 % 2 != 0) {
            return bqVar;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾒ */
    public final String mo2243() {
        char absoluteGravity;
        int keyRepeatTimeout;
        int gidForName;
        int i2 = f2176 + 113;
        f2173 = i2 % 128;
        if (i2 % 2 != 0) {
            absoluteGravity = (char) Gravity.getAbsoluteGravity(1, 1);
            keyRepeatTimeout = 85 >> (ViewConfiguration.getKeyRepeatTimeout() - 81);
            gidForName = 1 << Process.getGidForName("");
        } else {
            absoluteGravity = (char) Gravity.getAbsoluteGravity(0, 0);
            keyRepeatTimeout = 46 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
            gidForName = Process.getGidForName("") + 1;
        }
        String strIntern = m2259(absoluteGravity, keyRepeatTimeout, gidForName).intern();
        int i8 = f2176 + 51;
        f2173 = i8 % 128;
        if (i8 % 2 == 0) {
            return strIntern;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m2259(char c7, int i2, int i8) {
        String str;
        synchronized (c.f1192) {
            try {
                char[] cArr = new char[i2];
                c.f1193 = 0;
                while (true) {
                    int i9 = c.f1193;
                    if (i9 < i2) {
                        cArr[i9] = (char) ((((long) f2174[i8 + i9]) ^ (((long) i9) * f2175)) ^ ((long) c7));
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
