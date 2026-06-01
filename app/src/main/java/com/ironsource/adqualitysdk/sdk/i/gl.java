package com.ironsource.adqualitysdk.sdk.i;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class gl extends gk {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f2184 = 0;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f2185 = 0;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static char f2186 = 6202;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static long f2187 = 0;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f2188 = 1;

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻐ */
    public final String mo2240() {
        char cKeyCodeFromString;
        int i2;
        int i8 = f2188 + 41;
        f2184 = i8 % 128;
        if (i8 % 2 != 0) {
            cKeyCodeFromString = (char) KeyEvent.keyCodeFromString("");
            i2 = 1373290478 % (SystemClock.uptimeMillis() > 1L ? 1 : (SystemClock.uptimeMillis() == 1L ? 0 : -1));
        } else {
            cKeyCodeFromString = (char) KeyEvent.keyCodeFromString("");
            i2 = 1373290478 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
        }
        String strIntern = m2263("\ued49\udabf끑㜣", cKeyCodeFromString, "䙱场웾⇏\ue479㢮ḝ㏎┄後뽴", i2, "\u0000\u0000\u0000\u0000").intern();
        int i9 = f2184 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE;
        f2188 = i9 % 128;
        if (i9 % 2 == 0) {
            int i10 = 7 / 0;
        }
        return strIntern;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻛ */
    public final Class mo2241() {
        int i2 = f2184 + 89;
        f2188 = i2 % 128;
        if (i2 % 2 != 0) {
            return InneractiveAdManager.class;
        }
        int i8 = 2 / 0;
        return InneractiveAdManager.class;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾇ */
    public final bg mo2242() {
        bt btVar = new bt(mo2240());
        f2184 = (f2188 + 99) % 128;
        return btVar;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾒ */
    public final String mo2243() {
        int i2 = f2188 + 5;
        f2184 = i2 % 128;
        return (i2 % 2 != 0 ? m2263("\uf0ce臂塘䛮", (char) (TextUtils.lastIndexOf("", ']') + 61017), "산ᐛ\ue278힛퍟鑀箎ꏴ첧ི摢鴣켧ﻣꕙു뵃䓬䛵槱㥻ᵖꡔ\ude9dⳕ髙ச⠞耰\udfc3Ｑ锷月\u1259铳䲘쳹颟Ǜ뻳\udb50捻魊춥鱞ᑞ왅꾍胪傜\ue2d9琠텠䇢눿", 1484899057 << MotionEvent.axisFromString(""), "\u0000\u0000\u0000\u0000") : m2263("\uf0ce臂塘䛮", (char) (TextUtils.lastIndexOf("", '0') + 61017), "산ᐛ\ue278힛퍟鑀箎ꏴ첧ི摢鴣켧ﻣꕙു뵃䓬䛵槱㥻ᵖꡔ\ude9dⳕ髙ச⠞耰\udfc3Ｑ锷月\u1259铳䲘쳹颟Ǜ뻳\udb50捻魊춥鱞ᑞ왅꾍胪傜\ue2d9琠텠䇢눿", MotionEvent.axisFromString("") + 1484899057, "\u0000\u0000\u0000\u0000")).intern();
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m2263(String str, char c7, String str2, int i2, String str3) {
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
                        cArr6[i12] = (char) (((((long) (c9 ^ cArr2[i12])) ^ f2187) ^ ((long) f2185)) ^ ((long) f2186));
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
