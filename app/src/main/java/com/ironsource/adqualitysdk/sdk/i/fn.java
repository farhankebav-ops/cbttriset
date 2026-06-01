package com.ironsource.adqualitysdk.sdk.i;

import android.media.AudioTrack;
import android.os.Process;
import android.view.ViewConfiguration;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class fn extends fr {

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f2070 = 1;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2071;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static char[] f2069 = {38177, 47144, 53012, 4713, 8524, 29701};

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static long f2068 = 626892188336008473L;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m2231(char c7, int i2, int i8) {
        String str;
        synchronized (c.f1192) {
            try {
                char[] cArr = new char[i2];
                c.f1193 = 0;
                while (true) {
                    int i9 = c.f1193;
                    if (i9 < i2) {
                        cArr[i9] = (char) ((((long) f2069[i8 + i9]) ^ (((long) i9) * f2068)) ^ ((long) c7));
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

    public final String toString() {
        f2071 = (f2070 + 11) % 128;
        String strIntern = m2231((char) ((Process.myPid() >> 22) + 38211), 6 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1).intern();
        f2071 = (f2070 + 89) % 128;
        return strIntern;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.fr
    /* JADX INFO: renamed from: ﻐ */
    public final du mo2225(ds dsVar, cp cpVar) {
        du duVar = new du(null);
        duVar.m2147();
        f2071 = (f2070 + 71) % 128;
        return duVar;
    }
}
