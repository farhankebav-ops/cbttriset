package com.ironsource.adqualitysdk.sdk.i;

import android.view.KeyEvent;
import com.ironsource.adqualitysdk.sdk.i.bg;
import com.vungle.ads.internal.protos.Sdk;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.maio.sdk.android.MaioAds;
import jp.maio.sdk.android.MaioAdsListenerInterface;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class bs extends bg {

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static int f1024 = 1;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static char f1025 = 7005;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f1026 = 0;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static char f1027 = 36058;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static char f1028 = 16694;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static char f1029 = 50028;

    public bs(String str) {
        super(str);
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ void m1183(MaioAdsListenerInterface maioAdsListenerInterface) {
        f1026 = (f1024 + 7) % 128;
        m1181(maioAdsListenerInterface);
        f1026 = (f1024 + 39) % 128;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻐ */
    public final String mo825() {
        f1024 = (f1026 + 85) % 128;
        String sdkVersion = MaioAds.getSdkVersion();
        int i2 = f1024 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE;
        f1026 = i2 % 128;
        if (i2 % 2 == 0) {
            return sdkVersion;
        }
        throw null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0118  */
    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻛ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Class mo826(java.lang.String r10) {
        /*
            Method dump skipped, instruction units count: 372
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.bs.mo826(java.lang.String):java.lang.Class");
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﾇ */
    public final Map<String, bg.a> mo827() {
        HashMap map = new HashMap();
        map.put(m1182("栌አ辋㈯ퟟ㵒⻠䮆끤践楧㜱灢橯\uf826Ⳍˠ抱", (KeyEvent.getMaxKeyCode() >> 16) + 18).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bs.2
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                bs.m1183((MaioAdsListenerInterface) list.get(0));
                return null;
            }
        });
        int i2 = f1024 + 17;
        f1026 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 21 / 0;
        }
        return map;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m1182(String str, int i2) {
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
                            char c9 = (char) (c7 - (((c8 + i9) ^ ((c8 << 4) + f1027)) ^ ((c8 >>> 5) + f1028)));
                            cArr3[1] = c9;
                            cArr3[0] = (char) (c8 - (((c9 >>> 5) + f1029) ^ ((c9 + i9) ^ ((c9 << 4) + f1025))));
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

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static void m1181(MaioAdsListenerInterface maioAdsListenerInterface) {
        int i2 = f1026 + 115;
        f1024 = i2 % 128;
        int i8 = i2 % 2;
        MaioAds.setMaioAdsListener(maioAdsListenerInterface);
        if (i8 == 0) {
            throw null;
        }
        f1024 = (f1026 + 63) % 128;
    }
}
