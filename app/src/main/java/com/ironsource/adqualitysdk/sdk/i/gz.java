package com.ironsource.adqualitysdk.sdk.i;

import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.yandex.mobile.ads.common.MobileAds;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class gz extends gk {

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f2259 = 0;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static long f2260 = -5554146638539099596L;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2261 = 1;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m2281(String str, int i2) {
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
                        cArr2[i8] = (char) (((long) (cArr[i8] ^ (j.f2669 * i8))) ^ f2260);
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

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻐ */
    public final String mo2240() {
        int i2 = f2261 + 43;
        f2259 = i2 % 128;
        String strIntern = (i2 % 2 != 0 ? m2281("牍ࣴ蜘ᶳ飕ᝩ", 22767 % TextUtils.indexOf((CharSequence) "", 'n')) : m2281("牍ࣴ蜘ᶳ飕ᝩ", 31392 - TextUtils.indexOf((CharSequence) "", '0'))).intern();
        int i8 = f2259 + 27;
        f2261 = i8 % 128;
        if (i8 % 2 != 0) {
            return strIntern;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻛ */
    public final Class mo2241() {
        int i2 = f2261 + 1;
        int i8 = i2 % 128;
        f2259 = i8;
        if (i2 % 2 != 0) {
            throw null;
        }
        int i9 = i8 + 65;
        f2261 = i9 % 128;
        if (i9 % 2 == 0) {
            int i10 = 15 / 0;
        }
        return MobileAds.class;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾇ */
    public final bg mo2242() {
        cj cjVar = new cj(mo2240());
        int i2 = f2261 + 45;
        f2259 = i2 % 128;
        if (i2 % 2 == 0) {
            return cjVar;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾒ */
    public final String mo2243() {
        int i2 = f2259 + 73;
        f2261 = i2 % 128;
        String strIntern = m2281("牗楸䐟⍳ề\uf5fa킈쾥ꭉ虷組壘㟿ኑষ\ue555쁡뽉騣燉泻䯅❕ɾ螺퐲돕껫藎悎屁㭫ᘽෛ\ue8f7잼ꊼ鹈", i2 % 2 == 0 ? (ViewConfiguration.getScrollBarFadeDuration() / 112) * 918 : 6947 - (ViewConfiguration.getScrollBarFadeDuration() >> 16)).intern();
        int i8 = f2261 + 93;
        f2259 = i8 % 128;
        if (i8 % 2 == 0) {
            return strIntern;
        }
        throw null;
    }
}
