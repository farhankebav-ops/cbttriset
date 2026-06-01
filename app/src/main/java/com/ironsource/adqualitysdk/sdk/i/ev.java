package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.media.AudioTrack;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ev extends eo {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f2015 = 1;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f2017;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static char[] f2018 = {50901, 16311};

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static long f2016 = 5403202663872788835L;

    public ev(ee eeVar, ee eeVar2, Cdo cdo) {
        super(eeVar, eeVar2, cdo);
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.eg
    /* JADX INFO: renamed from: ﻛ */
    public final String mo2195() {
        f2015 = (f2017 + 105) % 128;
        String strIntern = m2216((char) (50921 - Color.red(0)), 3 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), View.combineMeasuredStates(0, 0)).intern();
        f2015 = (f2017 + 57) % 128;
        return strIntern;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.el
    /* JADX INFO: renamed from: ｋ */
    public final boolean mo2205(int i2) {
        int i8 = f2017 + 115;
        int i9 = i8 % 128;
        f2015 = i9;
        if (i8 % 2 == 0) {
            throw null;
        }
        if (i2 <= 0) {
            return true;
        }
        f2017 = (i9 + 33) % 128;
        return false;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m2216(char c7, int i2, int i8) {
        String str;
        synchronized (c.f1192) {
            try {
                char[] cArr = new char[i2];
                c.f1193 = 0;
                while (true) {
                    int i9 = c.f1193;
                    if (i9 < i2) {
                        cArr[i9] = (char) ((((long) f2018[i8 + i9]) ^ (((long) i9) * f2016)) ^ ((long) c7));
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
