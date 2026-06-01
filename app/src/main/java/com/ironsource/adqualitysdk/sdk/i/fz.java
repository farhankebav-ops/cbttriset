package com.ironsource.adqualitysdk.sdk.i;

import android.text.TextUtils;
import android.view.KeyEvent;
import com.amazon.device.ads.DTBAdRequest;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class fz extends gk {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f2122 = 0;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f2123 = 1;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static long f2124 = 971099048499108340L;

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻐ */
    public final String mo2240() {
        int i2 = f2123 + 29;
        f2122 = i2 % 128;
        return m2248("妕泼㍟說谏卣\u19cbⱇ\uf2af", i2 % 2 != 0 ? 23932 << TextUtils.indexOf((CharSequence) "", (char) 5, 1, 0) : TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 13670).intern();
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻛ */
    public final Class mo2241() {
        int i2 = f2123 + 27;
        f2122 = i2 % 128;
        if (i2 % 2 == 0) {
            return DTBAdRequest.class;
        }
        int i8 = 43 / 0;
        return DTBAdRequest.class;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾇ */
    public final bg mo2242() {
        bi biVar = new bi(mo2240());
        f2122 = (f2123 + 25) % 128;
        return biVar;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾒ */
    public final String mo2243() {
        int i2 = f2122 + 89;
        f2123 = i2 % 128;
        return m2248("妗畀/\udf4b\ueaf9맞咷恳㽃쨩饔듹䏕ẝ⩧壟鐡ꍑ绳ෑ\ud89b\uf42d荢帍派㣖\ud7ae\ue2bf빥䵊ᠫ㜔싧醻", i2 % 2 == 0 ? 28551 - ((byte) KeyEvent.getModifierMetaStateMask()) : ((byte) KeyEvent.getModifierMetaStateMask()) + 11484).intern();
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m2248(String str, int i2) {
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
                        cArr2[i8] = (char) (((long) (cArr[i8] ^ (j.f2669 * i8))) ^ f2124);
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
