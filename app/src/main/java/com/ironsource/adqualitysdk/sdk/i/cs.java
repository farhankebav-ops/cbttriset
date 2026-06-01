package com.ironsource.adqualitysdk.sdk.i;

import android.app.Activity;
import android.content.Context;
import android.view.ViewConfiguration;
import com.ironsource.adqualitysdk.sdk.ISAdQualityAdType;
import com.ironsource.adqualitysdk.sdk.IronSourceAdQuality;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class cs extends da {

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f1537 = 0;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static long f1538 = 6109973089952735663L;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f1539 = 1;

    /* JADX INFO: renamed from: 爫, reason: contains not printable characters */
    private static ik m1788() {
        f1537 = (f1539 + 59) % 128;
        ik ikVarM2716 = jh.m2711().m2716();
        f1539 = (f1537 + 61) % 128;
        return ikVarM2716;
    }

    /* JADX INFO: renamed from: ﬤ, reason: contains not printable characters */
    public static JSONObject m1789() {
        f1537 = (f1539 + 87) % 128;
        JSONObject jSONObjectM523 = aq.m530().mo541().m523();
        int i2 = f1539 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE;
        f1537 = i2 % 128;
        if (i2 % 2 == 0) {
            return jSONObjectM523;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
    public static String m1790() {
        int i2 = f1539 + 51;
        f1537 = i2 % 128;
        if (i2 % 2 != 0) {
            aq.m530().mo541().m524();
            throw null;
        }
        String strM524 = aq.m530().mo541().m524();
        int i8 = f1539 + 113;
        f1537 = i8 % 128;
        if (i8 % 2 == 0) {
            return strM524;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    public static double m1791() {
        double dMo550;
        int i2 = f1539 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE;
        f1537 = i2 % 128;
        if (i2 % 2 != 0) {
            dMo550 = aq.m530().mo550();
            int i8 = 2 / 0;
        } else {
            dMo550 = aq.m530().mo550();
        }
        f1539 = (f1537 + 7) % 128;
        return dMo550;
    }

    /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
    public static JSONObject m1792() {
        int i2 = f1539 + 9;
        f1537 = i2 % 128;
        if (i2 % 2 == 0) {
            return aq.m530().mo541().m565();
        }
        aq.m530().mo541().m565();
        throw null;
    }

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    public static boolean m1793() {
        f1539 = (f1537 + 63) % 128;
        boolean zMo548 = aq.m530().mo548();
        f1539 = (f1537 + 23) % 128;
        return zMo548;
    }

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    public static boolean m1794() {
        int i2 = f1537 + 59;
        f1539 = i2 % 128;
        if (i2 % 2 == 0) {
            aq.m530().mo553();
            throw null;
        }
        boolean zMo553 = aq.m530().mo553();
        int i8 = f1539 + 53;
        f1537 = i8 % 128;
        if (i8 % 2 != 0) {
            int i9 = 18 / 0;
        }
        return zMo553;
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    public static di m1795() {
        di diVar = new di();
        f1539 = (f1537 + 33) % 128;
        return diVar;
    }

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    public static JSONObject m1798() {
        JSONObject jSONObjectM2895;
        int i2 = f1539 + 19;
        f1537 = i2 % 128;
        if (i2 % 2 != 0) {
            jSONObjectM2895 = kc.m2895(aq.m530().m565());
            int i8 = 24 / 0;
        } else {
            jSONObjectM2895 = kc.m2895(aq.m530().m565());
        }
        f1539 = (f1537 + 27) % 128;
        return jSONObjectM2895;
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    public static String m1799() {
        String sDKVersion;
        int i2 = f1539 + 115;
        f1537 = i2 % 128;
        if (i2 % 2 != 0) {
            sDKVersion = IronSourceAdQuality.getSDKVersion();
            int i8 = 44 / 0;
        } else {
            sDKVersion = IronSourceAdQuality.getSDKVersion();
        }
        int i9 = f1539 + 33;
        f1537 = i9 % 128;
        if (i9 % 2 == 0) {
            return sDKVersion;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    public static dj m1800() {
        dj djVar = new dj();
        f1539 = (f1537 + 27) % 128;
        return djVar;
    }

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    public static dg m1802() {
        dg dgVar = new dg();
        f1537 = (f1539 + 101) % 128;
        return dgVar;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static Object m1807(cp cpVar, List<Object> list) {
        f1539 = (f1537 + 103) % 128;
        cpVar.m1726((String) da.m1896(list, 0, String.class), (JSONObject) da.m1896(list, 1, JSONObject.class));
        f1537 = (f1539 + 101) % 128;
        return null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static Object m1810(cp cpVar) {
        int i2 = f1539 + 113;
        f1537 = i2 % 128;
        if (i2 % 2 != 0) {
            cpVar.m1728();
            throw null;
        }
        Context contextM1728 = cpVar.m1728();
        f1539 = (f1537 + 53) % 128;
        return contextM1728;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static long m1812() {
        int i2 = f1537 + 39;
        f1539 = i2 % 128;
        if (i2 % 2 == 0) {
            m1788().m2550();
            throw null;
        }
        long jM2550 = m1788().m2550();
        int i8 = f1539 + 65;
        f1537 = i8 % 128;
        if (i8 % 2 == 0) {
            return jM2550;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static long m1816() {
        f1539 = (f1537 + 71) % 128;
        long jM2801 = jv.m2801();
        f1537 = (f1539 + 111) % 128;
        return jM2801;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final Object m1818(final cp cpVar, List<Object> list, final ds dsVar) {
        final dq dqVar;
        int i2 = f1539 + 99;
        f1537 = i2 % 128;
        if (i2 % 2 != 0) {
            dqVar = (dq) da.m1896(list, 1, dq.class);
            if (dqVar == null) {
                return null;
            }
        } else {
            dqVar = (dq) da.m1896(list, 0, dq.class);
            if (dqVar == null) {
                return null;
            }
        }
        cpVar.m1731(new io() { // from class: com.ironsource.adqualitysdk.sdk.i.cs.4
            @Override // com.ironsource.adqualitysdk.sdk.i.io
            /* JADX INFO: renamed from: ﻛ */
            public final JSONObject mo716(String str, JSONObject jSONObject) {
                return (JSONObject) dqVar.m2081(dsVar, cpVar, Arrays.asList(str, jSONObject)).m2153();
            }
        });
        f1537 = (f1539 + 41) % 128;
        return null;
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    public static String m1796(cp cpVar) {
        f1539 = (f1537 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE) % 128;
        String strM2352 = cpVar.m1732().m2352();
        f1539 = (f1537 + 99) % 128;
        return strM2352;
    }

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    public static String m1797(cp cpVar) {
        int i2 = f1537 + 57;
        f1539 = i2 % 128;
        int i8 = i2 % 2;
        String strM1669 = cpVar.m1730().m1669();
        if (i8 == 0) {
            int i9 = 73 / 0;
        }
        f1539 = (f1537 + 51) % 128;
        return strM1669;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    public static String m1801(cp cpVar) {
        int i2 = f1539 + 103;
        f1537 = i2 % 128;
        int i8 = i2 % 2;
        String strM1666 = cpVar.m1730().m1666();
        if (i8 != 0) {
            int i9 = 60 / 0;
        }
        f1537 = (f1539 + 77) % 128;
        return strM1666;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static dk m1809() {
        dk dkVar = new dk();
        f1537 = (f1539 + 97) % 128;
        return dkVar;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static String m1817(cp cpVar) {
        int i2 = f1539 + 79;
        f1537 = i2 % 128;
        int i8 = i2 % 2;
        cn cnVarM1730 = cpVar.m1730();
        if (i8 != 0) {
            cnVarM1730.m1661();
            throw null;
        }
        String strM1661 = cnVarM1730.m1661();
        f1537 = (f1539 + 1) % 128;
        return strM1661;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static String m1811(List<Object> list) {
        f1539 = (f1537 + 63) % 128;
        String lowerCase = ISAdQualityAdType.fromInt(((Integer) da.m1896(list, 0, Integer.class)).intValue()).name().toLowerCase();
        int i2 = f1537 + 27;
        f1539 = i2 % 128;
        if (i2 % 2 != 0) {
            return lowerCase;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static Object m1803(cp cpVar) {
        int i2 = f1537 + 43;
        f1539 = i2 % 128;
        if (i2 % 2 != 0) {
            return cpVar.m1730();
        }
        cpVar.m1730();
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static Activity m1806() {
        int i2 = f1539 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE;
        f1537 = i2 % 128;
        if (i2 % 2 != 0) {
            jf.m2685().mo2688();
            throw null;
        }
        Activity activityMo2688 = jf.m2685().mo2688();
        int i8 = f1537 + 85;
        f1539 = i8 % 128;
        if (i8 % 2 != 0) {
            return activityMo2688;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static JSONObject m1815(cp cpVar) {
        int i2 = f1539 + 15;
        f1537 = i2 % 128;
        if (i2 % 2 == 0) {
            return cpVar.m1721();
        }
        cpVar.m1721();
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static JSONObject m1805() {
        f1539 = (f1537 + 77) % 128;
        ik ikVarM1788 = m1788();
        JSONObject jSONObjectM2904 = kc.m2904(ikVarM1788.m2547(), ikVarM1788.m2548(), ikVarM1788.m2550(), ikVarM1788.m2549());
        f1537 = (f1539 + 35) % 128;
        return jSONObjectM2904;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static String m1808(cp cpVar) {
        int i2 = f1539 + 101;
        f1537 = i2 % 128;
        int i8 = i2 % 2;
        cn cnVarM1730 = cpVar.m1730();
        if (i8 != 0) {
            cnVarM1730.m1663();
            throw null;
        }
        String strM1663 = cnVarM1730.m1663();
        f1537 = (f1539 + 59) % 128;
        return strM1663;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static Object m1813(List<Object> list) {
        String strM1814;
        int i2 = f1539 + 89;
        f1537 = i2 % 128;
        if (i2 % 2 != 0) {
            ViewConfiguration.getScrollBarFadeDuration();
            strM1814 = m1814("鄲\u1fc5䕂ﲚ酳㸎ٍ駢\u17ef럂輱ᜧ鰳ケᗐ蹔", 0);
        } else {
            strM1814 = m1814("鄲\u1fc5䕂ﲚ酳㸎ٍ駢\u17ef럂輱ᜧ鰳ケᗐ蹔", (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 1);
        }
        k.m2854(strM1814.intern(), (String) da.m1896(list, 0, String.class));
        int i8 = f1537 + 61;
        f1539 = i8 % 128;
        if (i8 % 2 != 0) {
            return null;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final Object m1819(List<Object> list) {
        String str = (String) da.m1896(list, 0, String.class);
        List<Object> listM1898 = da.m1898(list, 1);
        aw awVarM3029 = q.m3013().m3029();
        if (awVarM3029 != null) {
            int i2 = f1539 + 79;
            f1537 = i2 % 128;
            if (i2 % 2 != 0) {
                awVarM3029.m711(str, listM1898);
                int i8 = 20 / 0;
            } else {
                awVarM3029.m711(str, listM1898);
            }
        }
        int i9 = f1537 + 27;
        f1539 = i9 % 128;
        if (i9 % 2 != 0) {
            return null;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static Object m1804(List<Object> list) {
        f1537 = (f1539 + 103) % 128;
        Object objM522 = aq.m530().mo541().m522((String) da.m1896(list, 0, String.class));
        f1537 = (f1539 + 105) % 128;
        return objM522;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m1814(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (i.f2441) {
            try {
                char[] cArrM2497 = i.m2497(f1538, cArr, i2);
                i.f2442 = 4;
                while (true) {
                    int i8 = i.f2442;
                    if (i8 < cArrM2497.length) {
                        i.f2443 = i8 - 4;
                        cArrM2497[i8] = (char) (((long) (cArrM2497[i8] ^ cArrM2497[i8 % 4])) ^ (((long) r2) * f1538));
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
