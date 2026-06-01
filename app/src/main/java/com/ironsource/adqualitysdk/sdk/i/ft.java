package com.ironsource.adqualitysdk.sdk.i;

import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.android.gms.ads.MobileAds;
import com.ironsource.adqualitysdk.sdk.i.ba;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ft extends gk {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static long f2098 = 2205309593012926715L;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f2099 = 0;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2100 = 1;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static boolean m2238() {
        int i2 = f2099 + 107;
        f2100 = i2 % 128;
        try {
            if (i2 % 2 == 0) {
                Prode.m249();
                throw null;
            }
            if (Prode.m249()) {
                return true;
            }
            Class.forName(m2239("셓넫섰\ue23d㣕䦿Ꭶ툊⋘涣㞰\uf66fۧ熝寝詽櫹ᗰ翵긏亊㧤掵䈓늢\uddcf螁昹隿\ue1db\uab6d竺既蔶켤ộ\ude5cꤞ\uf322㋪쉹䴃", (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))).intern());
            f2099 = (f2100 + 9) % 128;
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final String mo2240() {
        int i2 = f2100 + 43;
        f2099 = i2 % 128;
        return (i2 % 2 != 0 ? m2239("멦和먇挳\udf91갓銨㔏姨", 1 << ExpandableListView.getPackedPositionGroup(0L)) : m2239("멦和먇挳\udf91갓銨㔏姨", 1 - ExpandableListView.getPackedPositionGroup(0L))).intern();
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final Class mo2241() {
        int i2 = f2100 + 1;
        int i8 = i2 % 128;
        f2099 = i8;
        if (i2 % 2 != 0) {
            throw null;
        }
        f2100 = (i8 + 3) % 128;
        return MobileAds.class;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final bg mo2242() {
        f2100 = (f2099 + 81) % 128;
        if (m2238()) {
            return new ba.d(mo2240());
        }
        ba baVar = new ba(mo2240());
        int i2 = f2099 + 31;
        f2100 = i2 % 128;
        if (i2 % 2 != 0) {
            return baVar;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final String mo2243() {
        int windowTouchSlop;
        int i2 = f2100 + 13;
        f2099 = i2 % 128;
        if (i2 % 2 != 0) {
            ViewConfiguration.getWindowTouchSlop();
            windowTouchSlop = 0;
        } else {
            windowTouchSlop = 1 - (ViewConfiguration.getWindowTouchSlop() >> 8);
        }
        String strIntern = m2239("\ue3dc糟\ue3bf茝䒓葋犆까Wꁗ嚐訩⑨뱩㫽\uf63b䡶\ud804ổ퉉氅\uf410ʕ㹕逭ျ\ue6a1᩿됰Ⱟ쩍ڧ\ud8c7䣒긞抚ﳙ擅鈯亱", windowTouchSlop).intern();
        int i8 = f2100 + 47;
        f2099 = i8 % 128;
        if (i8 % 2 == 0) {
            return strIntern;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m2239(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (i.f2441) {
            try {
                char[] cArrM2497 = i.m2497(f2098, cArr, i2);
                i.f2442 = 4;
                while (true) {
                    int i8 = i.f2442;
                    if (i8 < cArrM2497.length) {
                        i.f2443 = i8 - 4;
                        cArrM2497[i8] = (char) (((long) (cArrM2497[i8] ^ cArrM2497[i8 % 4])) ^ (((long) r2) * f2098));
                        i.f2442 = i8 + 1;
                    } else {
                        str2 = new String(cArrM2497, 4, cArrM2497.length - 4);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }
}
