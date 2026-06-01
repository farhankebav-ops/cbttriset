package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.ironsource.adqualitysdk.sdk.i.bg;
import com.my.target.ads.Reward;
import com.my.target.common.MyTargetVersion;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class bx extends bg {

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static long f1127 = 3893996694930472985L;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f1128 = 0;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static long f1129 = -275039829338753846L;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f1130 = 1;

    public bx(String str) {
        super(str);
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ String m1323(Reward reward) {
        int i2 = f1130 + 71;
        f1128 = i2 % 128;
        if (i2 % 2 != 0) {
            m1325(reward);
            throw null;
        }
        String strM1325 = m1325(reward);
        int i8 = f1128 + 71;
        f1130 = i8 % 128;
        if (i8 % 2 != 0) {
            return strM1325;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m1325(Reward reward) {
        int i2 = f1130 + 89;
        f1128 = i2 % 128;
        int i8 = i2 % 2;
        String str = reward.type;
        if (i8 != 0) {
            throw null;
        }
        int i9 = f1130 + 3;
        f1128 = i9 % 128;
        if (i9 % 2 == 0) {
            return str;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m1326(String str, int i2) {
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
                        cArr2[i8] = (char) (((long) (cArr[i8] ^ (j.f2669 * i8))) ^ f1129);
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0269  */
    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻛ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Class mo826(java.lang.String r13) {
        /*
            Method dump skipped, instruction units count: 820
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.bx.mo826(java.lang.String):java.lang.Class");
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﾇ */
    public final Map<String, bg.a> mo827() {
        HashMap map = new HashMap();
        map.put(m1326("\uf4adైհḭᜳ⠾⇁㫩㎖㒁䶵䕗幻", (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 63718).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bx.1
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bx.m1323((Reward) list.get(0));
            }
        });
        int i2 = f1128 + 97;
        f1130 = i2 % 128;
        if (i2 % 2 != 0) {
            return map;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻐ */
    public final String mo825() {
        int i2 = f1130 + 109;
        f1128 = i2 % 128;
        try {
            try {
                return (String) (i2 % 2 != 0 ? MyTargetVersion.class.getDeclaredField(m1326("\uf49c풞뒺钪瓇哐㓢", 2973 - Drawable.resolveOpacity(0, 0)).intern()) : MyTargetVersion.class.getDeclaredField(m1326("\uf49c풞뒺钪瓇哐㓢", Drawable.resolveOpacity(0, 0) + 8209).intern())).get(null);
            } catch (Exception unused) {
                return null;
            }
        } catch (Exception unused2) {
            return hu.m2386().m2388().m2439(MyTargetVersion.class, m1324("\ue846\ue818䍰̵㩒먄䰭\ue87e䌬뫪䳏\ue8a5䎈뫌谽䴊", -TextUtils.lastIndexOf("", '0', 0, 0)).intern());
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m1324(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (i.f2441) {
            try {
                char[] cArrM2497 = i.m2497(f1127, cArr, i2);
                i.f2442 = 4;
                while (true) {
                    int i8 = i.f2442;
                    if (i8 < cArrM2497.length) {
                        i.f2443 = i8 - 4;
                        cArrM2497[i8] = (char) (((long) (cArrM2497[i8] ^ cArrM2497[i8 % 4])) ^ (((long) r2) * f1127));
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
