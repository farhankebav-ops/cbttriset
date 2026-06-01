package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.qq.e.comm.managers.GDTAdSdk;
import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class gy extends gk {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f2254 = 1;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static long f2255 = -3638578346156077155L;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static char f2256;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2257;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f2258;

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻐ */
    public final String mo2240() {
        f2258 = (f2254 + 91) % 128;
        String strIntern = m2280("ꙝ漣舖\u0602", (char) Color.alpha(0), "尹軬摇\ue823꒖\ud97eⓡ", 385454758 - (ViewConfiguration.getTapTimeout() >> 16), "依귰ⱅ춁").intern();
        int i2 = f2258 + 23;
        f2254 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 21 / 0;
        }
        return strIntern;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻛ */
    public final Class mo2241() {
        int i2 = f2258;
        f2254 = (i2 + 35) % 128;
        int i8 = i2 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE;
        f2254 = i8 % 128;
        if (i8 % 2 != 0) {
            return GDTAdSdk.class;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾇ */
    public final bg mo2242() {
        cf cfVar = new cf(mo2240());
        int i2 = f2258 + 47;
        f2254 = i2 % 128;
        if (i2 % 2 != 0) {
            return cfVar;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾒ */
    public final String mo2243() {
        f2258 = (f2254 + 111) % 128;
        String strIntern = m2280("䤟ꢠ彧㵱", (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 29022), "ꏝ챮晨撎\uf331└⫒䀜⤾ఋ洼醵⯲㟥\ue89a\uf515旌鴲\ud81b\ue7a5햽礖ᒑ㬀ﳖ\ue22f쳯䈏헵㔖\uec4b", 1739104329 - TextUtils.getOffsetAfter("", 0), "依귰ⱅ춁").intern();
        f2258 = (f2254 + 67) % 128;
        return strIntern;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m2280(String str, char c7, String str2, int i2, String str3) {
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
                        cArr6[i12] = (char) (((((long) (c9 ^ cArr2[i12])) ^ f2255) ^ ((long) f2257)) ^ ((long) f2256));
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
