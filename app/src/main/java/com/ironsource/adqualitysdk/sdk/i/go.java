package com.ironsource.adqualitysdk.sdk.i;

import android.os.Process;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.moloco.sdk.publisher.Moloco;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class go extends gk {

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f2202 = 1;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2203;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static char[] f2201 = {'c', 64785, 64145, 63572, 62869, 62233, 61592, 60957, 60307, 59649, 59074, 58393, 57740, 57101, 56522, 55826, 55189, 54588, 53936, 53299, 52651, 52030, 51377, 50720, 50174, 49411, 48803, 48166, 47527, 46885, 46251, 30926, 34226, 33331, 32950, 36152, 35770};

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static long f2204 = 291457814825139582L;

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻐ */
    public final String mo2240() {
        f2203 = (f2202 + 15) % 128;
        String strIntern = m2267((char) (30883 - (Process.myPid() >> 22)), 6 - TextUtils.indexOf("", ""), 31 - (Process.myTid() >> 22)).intern();
        int i2 = f2202 + 7;
        f2203 = i2 % 128;
        if (i2 % 2 == 0) {
            return strIntern;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻛ */
    public final Class mo2241() {
        int i2 = (f2202 + 51) % 128;
        f2203 = i2;
        f2202 = (i2 + 25) % 128;
        return Moloco.class;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾇ */
    public final bg mo2242() {
        bu buVar = new bu(mo2240());
        int i2 = f2202 + 41;
        f2203 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 80 / 0;
        }
        return buVar;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾒ */
    public final String mo2243() {
        f2202 = (f2203 + 99) % 128;
        String strIntern = m2267((char) (Process.myPid() >> 22), (Process.myPid() >> 22) + 31, ViewConfiguration.getTapTimeout() >> 16).intern();
        f2202 = (f2203 + 35) % 128;
        return strIntern;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m2267(char c7, int i2, int i8) {
        String str;
        synchronized (c.f1192) {
            try {
                char[] cArr = new char[i2];
                c.f1193 = 0;
                while (true) {
                    int i9 = c.f1193;
                    if (i9 < i2) {
                        cArr[i9] = (char) ((((long) f2201[i8 + i9]) ^ (((long) i9) * f2204)) ^ ((long) c7));
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
