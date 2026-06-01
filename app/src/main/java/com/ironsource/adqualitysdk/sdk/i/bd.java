package com.ironsource.adqualitysdk.sdk.i;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.ironsource.adqualitysdk.sdk.i.bg;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class bd extends bg {

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f776 = 1;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f778;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static char[] f777 = {36111, 42573, 56217, 3283, 8226, 21858, 36536};

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static long f775 = -2157842704576206007L;

    public bd(String str) {
        super(str);
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    public final boolean mo870() {
        int i2 = f776 + 33;
        f778 = i2 % 128;
        return i2 % 2 == 0;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻐ */
    public final String mo825() {
        char cAxisFromString;
        int i2;
        int i8 = f776 + 73;
        f778 = i8 % 128;
        if (i8 % 2 != 0) {
            cAxisFromString = (char) (36169 % MotionEvent.axisFromString(""));
            i2 = 14 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
        } else {
            cAxisFromString = (char) (36169 - MotionEvent.axisFromString(""));
            i2 = 8 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
        }
        return m869(cAxisFromString, i2, TextUtils.getTrimmedLength("")).intern();
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻛ */
    public final Class mo826(String str) {
        int i2 = f778 + 19;
        int i8 = i2 % 128;
        f776 = i8;
        if (i2 % 2 == 0) {
            throw null;
        }
        int i9 = i8 + 15;
        f778 = i9 % 128;
        if (i9 % 2 == 0) {
            return null;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﾇ */
    public final Map<String, bg.a> mo827() {
        HashMap map = new HashMap();
        f778 = (f776 + 47) % 128;
        return map;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m869(char c7, int i2, int i8) {
        String str;
        synchronized (c.f1192) {
            try {
                char[] cArr = new char[i2];
                c.f1193 = 0;
                while (true) {
                    int i9 = c.f1193;
                    if (i9 < i2) {
                        cArr[i9] = (char) ((((long) f777[i8 + i9]) ^ (((long) i9) * f775)) ^ ((long) c7));
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
