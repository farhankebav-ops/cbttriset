package com.ironsource.adqualitysdk.sdk.i;

import android.text.TextUtils;
import com.vungle.ads.internal.protos.Sdk;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class dk extends da implements ci {

    /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
    private static boolean f1767 = true;

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    private static int f1768 = 0;

    /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
    private static int f1769 = 208;

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    private static int f1770 = 1;

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    private static boolean f1771 = true;

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static char[] f1772 = {311, 309, 324, 294, 313, 308, 319, 293, 322, 316, 323, 281, 307, 318, 277, 275, 305, 326, 292, 329, 320, 291, 325, 317, 312, 310};

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static long f1773 = 8354517608150215280L;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private ho f1774;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private ho f1776;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private final List<String> f1781 = new ArrayList();

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private final List<String> f1778 = new ArrayList();

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private final List<String> f1780 = new ArrayList();

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private final List<String> f1777 = new ArrayList();

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private final List<String> f1779 = new ArrayList();

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private JSONObject f1775 = new JSONObject();

    /* JADX INFO: renamed from: 爫, reason: contains not printable characters */
    private JSONObject m2010() {
        JSONObject jSONObject = new JSONObject();
        try {
            ho hoVar = this.f1776;
            if (hoVar != null) {
                f1768 = (f1770 + 99) % 128;
                jSONObject.put(ig.f2508, hoVar.m2339());
                f1768 = (f1770 + 97) % 128;
            }
            ho hoVar2 = this.f1774;
            if (hoVar2 != null) {
                jSONObject.put(ig.f2503, hoVar2.m2339());
            }
            if (this.f1781.size() > 0) {
                jSONObject.put(ig.f2504, new JSONArray((Collection) this.f1781));
            }
            if (this.f1778.size() > 0) {
                jSONObject.put(ig.f2500, new JSONArray((Collection) this.f1778));
            }
            if (this.f1780.size() > 0) {
                jSONObject.put(ig.f2499, new JSONArray((Collection) this.f1780));
            }
            if (this.f1777.size() > 0) {
                jSONObject.put(ig.f2507, new JSONArray((Collection) this.f1777));
            }
            if (this.f1779.size() > 0) {
                jSONObject.put(ig.f2505, new JSONArray((Collection) this.f1779));
                f1770 = (f1768 + 1) % 128;
            }
            if (this.f1775.length() > 0) {
                jSONObject.putOpt(ig.f2506, this.f1775.toString());
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
    private String m2011() {
        String strOptString;
        int i2 = f1770 + 107;
        f1768 = i2 % 128;
        if (i2 % 2 != 0) {
            strOptString = this.f1775.optString(ig.f2499);
            int i8 = 20 / 0;
        } else {
            strOptString = this.f1775.optString(ig.f2499);
        }
        int i9 = f1770 + 93;
        f1768 = i9 % 128;
        if (i9 % 2 == 0) {
            return strOptString;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    private String m2012() {
        f1768 = (f1770 + 57) % 128;
        String strOptString = this.f1775.optString(ig.f2507);
        f1770 = (f1768 + 31) % 128;
        return strOptString;
    }

    /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
    private JSONObject m2014() {
        int i2 = (f1768 + 9) % 128;
        f1770 = i2;
        JSONObject jSONObject = this.f1775;
        f1768 = (i2 + 37) % 128;
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Object m2015() {
        /*
            r2 = this;
            int r0 = com.ironsource.adqualitysdk.sdk.i.dk.f1770
            int r0 = r0 + 41
            int r1 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.dk.f1768 = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L35
            java.util.List<java.lang.String> r0 = r2.f1781
            int r0 = r0.size()
            if (r0 > 0) goto L2f
            java.util.List<java.lang.String> r0 = r2.f1778
            int r0 = r0.size()
            if (r0 > 0) goto L2f
            int r0 = com.ironsource.adqualitysdk.sdk.i.dk.f1770
            int r0 = r0 + 125
            int r0 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.dk.f1768 = r0
            java.util.List<java.lang.String> r0 = r2.f1779
            int r0 = r0.size()
            if (r0 <= 0) goto L2d
            goto L2f
        L2d:
            r0 = 0
            goto L30
        L2f:
            r0 = 1
        L30:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            return r0
        L35:
            java.util.List<java.lang.String> r0 = r2.f1781
            r0.size()
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.dk.m2015():java.lang.Object");
    }

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    private String m2016() {
        int i2 = f1770 + 31;
        f1768 = i2 % 128;
        if (i2 % 2 == 0) {
            return this.f1775.optString(ig.f2497);
        }
        this.f1775.optString(ig.f2497);
        throw null;
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private String m2017() {
        int i2 = f1768 + 115;
        f1770 = i2 % 128;
        if (i2 % 2 != 0) {
            return this.f1775.optString(ig.f2505);
        }
        int i8 = 83 / 0;
        return this.f1775.optString(ig.f2505);
    }

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private String m2019() {
        f1768 = (f1770 + 13) % 128;
        String strOptString = this.f1775.optString(ig.f2504);
        int i2 = f1770 + 1;
        f1768 = i2 % 128;
        if (i2 % 2 == 0) {
            return strOptString;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private ho m2021() {
        int i2 = (f1768 + 91) % 128;
        f1770 = i2;
        ho hoVar = this.f1776;
        f1768 = (i2 + 19) % 128;
        return hoVar;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private void m2024(String str) {
        f1768 = (f1770 + 23) % 128;
        try {
            this.f1775.put(ig.f2505, str);
            int i2 = f1770 + 87;
            f1768 = i2 % 128;
            if (i2 % 2 != 0) {
                int i8 = 6 / 0;
            }
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private ho m2025() {
        int i2 = f1768;
        ho hoVar = this.f1774;
        int i8 = i2 + 15;
        f1770 = i8 % 128;
        if (i8 % 2 == 0) {
            int i9 = 85 / 0;
        }
        return hoVar;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private List<String> m2027() {
        int i2 = f1768 + 63;
        f1770 = i2 % 128;
        if (i2 % 2 != 0) {
            return this.f1778;
        }
        int i8 = 1 / 0;
        return this.f1778;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private List<String> m2032() {
        int i2 = f1768;
        List<String> list = this.f1781;
        int i8 = i2 + 17;
        f1770 = i8 % 128;
        if (i8 % 2 != 0) {
            return list;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private List<String> m2037() {
        int i2 = f1768 + 15;
        f1770 = i2 % 128;
        if (i2 % 2 != 0) {
            return this.f1780;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private List<String> m2041() {
        int i2 = f1770;
        int i8 = i2 + 31;
        f1768 = i8 % 128;
        if (i8 % 2 != 0) {
            throw null;
        }
        List<String> list = this.f1779;
        int i9 = i2 + 81;
        f1768 = i9 % 128;
        if (i9 % 2 != 0) {
            int i10 = 82 / 0;
        }
        return list;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private List<String> m2045() {
        List<String> list;
        int i2 = f1768;
        int i8 = i2 + 107;
        f1770 = i8 % 128;
        if (i8 % 2 == 0) {
            list = this.f1777;
            int i9 = 72 / 0;
        } else {
            list = this.f1777;
        }
        f1770 = (i2 + 45) % 128;
        return list;
    }

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    private void m2013(String str) {
        int i2 = f1770 + 71;
        f1768 = i2 % 128;
        try {
            if (i2 % 2 == 0) {
                this.f1775.put(ig.f2497, str);
            } else {
                this.f1775.put(ig.f2497, str);
                throw null;
            }
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private void m2018(String str) {
        f1770 = (f1768 + 29) % 128;
        try {
            this.f1775.put(ig.f2507, str);
            int i2 = f1770 + 75;
            f1768 = i2 % 128;
            if (i2 % 2 != 0) {
                throw null;
            }
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private void m2020(String str) {
        int i2 = f1770 + 113;
        f1768 = i2 % 128;
        try {
            if (i2 % 2 != 0) {
                this.f1775.put(ig.f2504, str);
                int i8 = 64 / 0;
            } else {
                this.f1775.put(ig.f2504, str);
            }
            f1770 = (f1768 + 89) % 128;
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private void m2022(String str) {
        f1770 = (f1768 + 57) % 128;
        try {
            this.f1775.put(ig.f2499, str);
            f1768 = (f1770 + 33) % 128;
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private void m2026(String str) {
        f1770 = (f1768 + 81) % 128;
        try {
            this.f1775.put(ig.f2500, str);
            f1768 = (f1770 + 87) % 128;
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private void m2030(List<String> list) {
        f1770 = (f1768 + 5) % 128;
        m2031(list, this.f1777);
        f1768 = (f1770 + 113) % 128;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private void m2034(List<String> list) {
        int i2 = f1768 + 83;
        f1770 = i2 % 128;
        if (i2 % 2 == 0) {
            m2031(list, this.f1781);
            throw null;
        }
        m2031(list, this.f1781);
        int i8 = f1770 + 57;
        f1768 = i8 % 128;
        if (i8 % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private void m2039(String str) {
        f1768 = (f1770 + 11) % 128;
        m2047(str, this.f1781);
        int i2 = f1768 + 93;
        f1770 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 74 / 0;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private void m2042(String str) {
        f1770 = (f1768 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) % 128;
        m2047(str, this.f1778);
        int i2 = f1770 + 99;
        f1768 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private void m2046(String str) {
        int i2 = f1770 + 1;
        f1768 = i2 % 128;
        if (i2 % 2 != 0) {
            m2047(str, this.f1777);
            throw null;
        }
        m2047(str, this.f1777);
        f1770 = (f1768 + 47) % 128;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private void m2029(String str) {
        int i2 = f1770 + 115;
        f1768 = i2 % 128;
        if (i2 % 2 != 0) {
            m2047(str, this.f1779);
            throw null;
        }
        m2047(str, this.f1779);
        f1768 = (f1770 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) % 128;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private void m2033(String str) {
        f1768 = (f1770 + 9) % 128;
        m2047(str, this.f1780);
        f1768 = (f1770 + 5) % 128;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private void m2040(List<String> list) {
        int i2 = f1770 + 103;
        f1768 = i2 % 128;
        if (i2 % 2 != 0) {
            m2031(list, this.f1778);
            int i8 = 56 / 0;
        } else {
            m2031(list, this.f1778);
        }
        int i9 = f1768 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE;
        f1770 = i9 % 128;
        if (i9 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private void m2043(List<String> list) {
        int i2 = f1770 + 107;
        f1768 = i2 % 128;
        if (i2 % 2 == 0) {
            m2031(list, this.f1780);
        } else {
            m2031(list, this.f1780);
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private void m2048(List<String> list) {
        f1768 = (f1770 + 105) % 128;
        m2031(list, this.f1779);
        int i2 = f1770 + 25;
        f1768 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private String m2023() {
        String strOptString;
        int i2 = f1768 + 71;
        f1770 = i2 % 128;
        if (i2 % 2 == 0) {
            strOptString = this.f1775.optString(ig.f2500);
            int i8 = 61 / 0;
        } else {
            strOptString = this.f1775.optString(ig.f2500);
        }
        int i9 = f1768 + 3;
        f1770 = i9 % 128;
        if (i9 % 2 != 0) {
            return strOptString;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private void m2028(ho hoVar) {
        int i2 = f1768;
        int i8 = i2 + 35;
        f1770 = i8 % 128;
        if (i8 % 2 == 0) {
            throw null;
        }
        if (hoVar != null) {
            f1770 = (i2 + 1) % 128;
            this.f1774 = hoVar;
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private void m2035(JSONObject jSONObject) {
        int i2 = f1768 + 11;
        f1770 = i2 % 128;
        int i8 = i2 % 2;
        this.f1775 = kc.m2895(jSONObject);
        if (i8 == 0) {
            int i9 = 37 / 0;
        }
        f1770 = (f1768 + 73) % 128;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private void m2038(ho hoVar) {
        int i2 = f1768;
        int i8 = i2 + 39;
        f1770 = i8 % 128;
        if (i8 % 2 == 0) {
            throw null;
        }
        if (hoVar != null) {
            int i9 = i2 + 45;
            f1770 = i9 % 128;
            int i10 = i9 % 2;
            this.f1776 = hoVar;
            if (i10 == 0) {
                int i11 = 39 / 0;
            }
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static void m2047(String str, List<String> list) {
        int i2 = f1770 + 41;
        f1768 = i2 % 128;
        if (i2 % 2 == 0) {
            if (list == null || TextUtils.isEmpty(str)) {
                return;
            }
            int i8 = f1768 + 89;
            f1770 = i8 % 128;
            if (i8 % 2 == 0) {
                list.contains(str);
                throw null;
            }
            if (list.contains(str)) {
                return;
            }
            list.add(str);
            return;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static void m2031(List<String> list, List<String> list2) {
        Iterator<String> it;
        if (list != null) {
            int i2 = f1770 + 3;
            f1768 = i2 % 128;
            if (i2 % 2 != 0) {
                it = list.iterator();
                int i8 = 71 / 0;
            } else {
                it = list.iterator();
            }
            while (it.hasNext()) {
                f1770 = (f1768 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) % 128;
                m2047(it.next(), list2);
            }
        }
        f1768 = (f1770 + 101) % 128;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m2036(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (i.f2441) {
            try {
                char[] cArrM2497 = i.m2497(f1773, cArr, i2);
                i.f2442 = 4;
                while (true) {
                    int i8 = i.f2442;
                    if (i8 < cArrM2497.length) {
                        i.f2443 = i8 - 4;
                        cArrM2497[i8] = (char) (((long) (cArrM2497[i8] ^ cArrM2497[i8 % 4])) ^ (((long) r2) * f1773));
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x01cb, code lost:
    
        if ((r11 % 2) == 0) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0248, code lost:
    
        if (r11.equals(m2036("\ud7ae\uf40f譈곶\ud7c9\ude1a\udfdc폰縇⁛疍薉葻覍⍄繵⪁폊\ud91a퀅烋", android.text.TextUtils.getCapsMode("", 0, 0)).intern()) != false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x02b5, code lost:
    
        if (r11.equals(m2036("褌ꏬ딤\ud93d襫觹\ue1b0\ua62e₾瞹䯥\uf059\uc966aᴡஹ琵萬\ue761", android.view.ViewConfiguration.getTouchSlop() >> 8).intern()) != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x02c3, code lost:
    
        return java.lang.Integer.valueOf(m2021().m2339());
     */
    @Override // com.ironsource.adqualitysdk.sdk.i.ci
    /* JADX INFO: renamed from: ﾒ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object mo886(java.lang.String r11, java.util.List<java.lang.Object> r12, com.ironsource.adqualitysdk.sdk.i.ch r13) {
        /*
            Method dump skipped, instruction units count: 1368
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.dk.mo886(java.lang.String, java.util.List, com.ironsource.adqualitysdk.sdk.i.ch):java.lang.Object");
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m2044(String str, int i2, int[] iArr, String str2) throws UnsupportedEncodingException {
        Object bytes = str2;
        if (str2 != null) {
            bytes = str2.getBytes("ISO-8859-1");
        }
        byte[] bArr = (byte[]) bytes;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (m.f2978) {
            try {
                char[] cArr2 = f1772;
                int i8 = f1769;
                if (f1771) {
                    int length = bArr.length;
                    m.f2976 = length;
                    char[] cArr3 = new char[length];
                    m.f2977 = 0;
                    while (m.f2977 < m.f2976) {
                        int i9 = m.f2977;
                        int i10 = m.f2976 - 1;
                        int i11 = m.f2977;
                        cArr3[i9] = (char) (cArr2[bArr[i10 - i11] + i2] - i8);
                        m.f2977 = i11 + 1;
                    }
                    return new String(cArr3);
                }
                if (f1767) {
                    int length2 = cArr.length;
                    m.f2976 = length2;
                    char[] cArr4 = new char[length2];
                    m.f2977 = 0;
                    while (m.f2977 < m.f2976) {
                        int i12 = m.f2977;
                        int i13 = m.f2976 - 1;
                        int i14 = m.f2977;
                        cArr4[i12] = (char) (cArr2[cArr[i13 - i14] - i2] - i8);
                        m.f2977 = i14 + 1;
                    }
                    return new String(cArr4);
                }
                int length3 = iArr.length;
                m.f2976 = length3;
                char[] cArr5 = new char[length3];
                m.f2977 = 0;
                while (m.f2977 < m.f2976) {
                    int i15 = m.f2977;
                    int i16 = m.f2976 - 1;
                    int i17 = m.f2977;
                    cArr5[i15] = (char) (cArr2[iArr[i16 - i17] - i2] - i8);
                    m.f2977 = i17 + 1;
                }
                return new String(cArr5);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
