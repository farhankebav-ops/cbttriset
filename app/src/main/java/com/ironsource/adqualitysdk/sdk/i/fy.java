package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.os.Process;
import com.applovin.sdk.AppLovinSdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class fy extends gk {

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static long f2119 = 7514779857201363134L;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f2120 = 1;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2121;

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻐ */
    public final String mo2240() {
        int i2 = f2120 + 27;
        f2121 = i2 % 128;
        return (i2 % 2 != 0 ? m2247("磟쑹Ơ价訍흛ᒝ凑", 48311 >>> ((Process.getThreadPriority(1) >>> 36) << 103)) : m2247("磟쑹Ơ价訍흛ᒝ凑", 48311 - ((Process.getThreadPriority(0) + 20) >> 6))).intern();
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻛ */
    public final Class mo2241() {
        int i2 = f2121 + 95;
        f2120 = i2 % 128;
        if (i2 % 2 != 0) {
            return AppLovinSdk.class;
        }
        int i8 = 76 / 0;
        return AppLovinSdk.class;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾇ */
    public final bg mo2242() {
        bm bmVar = new bm(mo2240());
        int i2 = f2121 + 103;
        f2120 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 89 / 0;
        }
        return bmVar;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾒ */
    public final String mo2243() {
        int i2 = f2120 + 63;
        f2121 = i2 % 128;
        String strIntern = m2247("磝㼪\uf725꽡朳Ἡ휬輏䜉；뜙漙❔\udf72靠你ܠ뽔睨⽯\ue76e齆坚ཚ의置㞤\uefac", i2 % 2 != 0 ? Color.argb(0, 1, 1, 1) + 9409 : 18427 - Color.argb(0, 0, 0, 0)).intern();
        f2121 = (f2120 + 73) % 128;
        return strIntern;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m2247(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (j.f2671) {
            try {
                j.f2669 = i2;
                char[] cArr2 = new char[cArr.length];
                j.f2670 = 0;
                while (true) {
                    int i8 = j.f2670;
                    if (i8 < cArr.length) {
                        cArr2[i8] = (char) (((long) (cArr[i8] ^ (j.f2669 * i8))) ^ f2119);
                        j.f2670++;
                    } else {
                        str2 = new String(cArr2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }
}
