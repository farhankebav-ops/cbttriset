package com.ironsource.adqualitysdk.sdk.i;

import android.media.AudioTrack;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewConfiguration;
import com.chartboost.sdk.Chartboost;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class gh extends gk {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static long f2168 = 0;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f2169 = 0;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f2170 = 1;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2171 = 0;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static char f2172 = 42668;

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻐ */
    public final String mo2240() {
        f2170 = (f2169 + 15) % 128;
        String strIntern = m2258("員廳징믓", (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), "낡❲Մ翃\ue921䫛掸ﰳ\ue0f8\udea6", View.MeasureSpec.getMode(0), "\u0000\u0000\u0000\u0000").intern();
        f2170 = (f2169 + 1) % 128;
        return strIntern;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻛ */
    public final Class mo2241() {
        int i2 = (f2170 + 19) % 128;
        f2169 = i2;
        int i8 = i2 + 51;
        f2170 = i8 % 128;
        if (i8 % 2 != 0) {
            return Chartboost.class;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾇ */
    public final bg mo2242() {
        bj bjVar = new bj(mo2240());
        f2169 = (f2170 + 63) % 128;
        return bjVar;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾒ */
    public final String mo2243() {
        char c7;
        int maximumDrawingCacheSize;
        int i2 = f2170 + 3;
        f2169 = i2 % 128;
        if (i2 % 2 != 0) {
            c7 = (char) (45518 >> (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)));
            maximumDrawingCacheSize = ViewConfiguration.getMaximumDrawingCacheSize() + 36;
        } else {
            c7 = (char) (45518 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)));
            maximumDrawingCacheSize = ViewConfiguration.getMaximumDrawingCacheSize() >> 24;
        }
        return m2258("룉広캞낱", c7, "\ue213㜌똌砕ፋ쑾ᢠ䧧ﻎ꺩쥕\uf07c\uf15d㺻ᢰ\ueade鋄숧뽖\ue877Ɋ붴夶鶈\uf19f灚㍰뭗렆", (-1637973064) - maximumDrawingCacheSize, "\u0000\u0000\u0000\u0000").intern();
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m2258(String str, char c7, String str2, int i2, String str3) {
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
                        cArr6[i12] = (char) (((((long) (c9 ^ cArr2[i12])) ^ f2168) ^ ((long) f2171)) ^ ((long) f2172));
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
}
