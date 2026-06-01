package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.drawable.Drawable;
import android.view.ViewConfiguration;
import com.ironsource.adqualitysdk.sdk.IronSourceAdQuality;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ga extends gk {

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static int f2127 = 1;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static char f2128 = 42148;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static char f2129 = 61956;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static char f2130 = 43338;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2131 = 0;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static char f2132 = 50062;

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻐ */
    public final String mo2240() {
        int i2 = f2127 + 75;
        f2131 = i2 % 128;
        String strIntern = m2249("\uf11c᪣鵽䙉ี桬틮־帄堺뙹ꠢ", i2 % 2 != 0 ? 20 >>> (ViewConfiguration.getPressedStateDuration() * 72) : 11 - (ViewConfiguration.getPressedStateDuration() >> 16)).intern();
        f2127 = (f2131 + 111) % 128;
        return strIntern;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻛ */
    public final Class mo2241() {
        int i2 = f2131 + 105;
        int i8 = i2 % 128;
        f2127 = i8;
        if (i2 % 2 == 0) {
            int i9 = 4 / 0;
        }
        f2131 = (i8 + 27) % 128;
        return IronSourceAdQuality.class;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾇ */
    public final bg mo2242() {
        bf bfVar = new bf(mo2240());
        int i2 = f2127 + 99;
        f2131 = i2 % 128;
        if (i2 % 2 == 0) {
            return bfVar;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾒ */
    public final String mo2243() {
        f2127 = (f2131 + 17) % 128;
        String strIntern = m2249("悔鏕ᅏ힔䄤ဩꖟዷᢉ扫Ⓧ蝉ਤ쎵硂ꑓ틍핑燬焑ṭ㷥\ueb7a\udf86Ҕ砳例\ue586Ҕ砳例\ue586솋\u1775ꖟዷ\ueece룗Ⓧ蝉ਤ쎵䪜ꀖ㭤읮盕額눿⭍\ue5a4\ude1c", Drawable.resolveOpacity(0, 0) + 51).intern();
        f2127 = (f2131 + 109) % 128;
        return strIntern;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m2249(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (o.f2985) {
            try {
                char[] cArr2 = new char[cArr.length];
                o.f2986 = 0;
                char[] cArr3 = new char[2];
                while (true) {
                    int i8 = o.f2986;
                    if (i8 < cArr.length) {
                        cArr3[0] = cArr[i8];
                        cArr3[1] = cArr[i8 + 1];
                        int i9 = 58224;
                        for (int i10 = 0; i10 < 16; i10++) {
                            char c7 = cArr3[1];
                            char c8 = cArr3[0];
                            char c9 = (char) (c7 - (((c8 + i9) ^ ((c8 << 4) + f2129)) ^ ((c8 >>> 5) + f2132)));
                            cArr3[1] = c9;
                            cArr3[0] = (char) (c8 - (((c9 >>> 5) + f2130) ^ ((c9 + i9) ^ ((c9 << 4) + f2128))));
                            i9 -= 40503;
                        }
                        int i11 = o.f2986;
                        cArr2[i11] = cArr3[0];
                        cArr2[i11 + 1] = cArr3[1];
                        o.f2986 = i11 + 2;
                    } else {
                        str2 = new String(cArr2, 0, i2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }
}
