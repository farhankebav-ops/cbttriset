package com.ironsource.adqualitysdk.sdk.i;

import android.view.KeyEvent;
import android.widget.ExpandableListView;
import com.vungle.ads.internal.protos.Sdk;
import net.pubnative.lite.sdk.HyBid;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class gw extends gk {

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static int f2238 = 1;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f2239 = 0;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static char f2240 = 27870;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static char f2241 = 33469;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static char f2242 = 37754;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static char f2243 = 20484;

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻐ */
    public final String mo2240() {
        f2239 = (f2238 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
        String strIntern = m2276("ῖ\ue4cd鏻\ued02ఞ\uf651賽Ᵹ\uf2b4쐻", KeyEvent.keyCodeFromString("") + 9).intern();
        f2239 = (f2238 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
        return strIntern;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻛ */
    public final Class mo2241() {
        int i2 = f2239 + 53;
        int i8 = i2 % 128;
        f2238 = i8;
        if (i2 % 2 == 0) {
            throw null;
        }
        f2239 = (i8 + 103) % 128;
        return HyBid.class;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾇ */
    public final bg mo2242() {
        by byVar = new by(mo2240());
        f2238 = (f2239 + 85) % 128;
        return byVar;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾒ */
    public final String mo2243() {
        int i2 = f2238 + 97;
        f2239 = i2 % 128;
        return m2276("☃沐ᯒ堩ῖ\ue4cd鏻\ued02ఞ\uf651賽Ᵹǰ뾱⥫칱ꏲ䓖녿䫇ꄤ뿁壧\ue840똣㏰㍚ቌ", i2 % 2 != 0 ? Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE << (ExpandableListView.getPackedPositionForChild(1, 1) > 1L ? 1 : (ExpandableListView.getPackedPositionForChild(1, 1) == 1L ? 0 : -1)) : (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 29).intern();
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m2276(String str, int i2) {
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
                            char c9 = (char) (c7 - (((c8 + i9) ^ ((c8 << 4) + f2242)) ^ ((c8 >>> 5) + f2241)));
                            cArr3[1] = c9;
                            cArr3[0] = (char) (c8 - (((c9 >>> 5) + f2240) ^ ((c9 + i9) ^ ((c9 << 4) + f2243))));
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
