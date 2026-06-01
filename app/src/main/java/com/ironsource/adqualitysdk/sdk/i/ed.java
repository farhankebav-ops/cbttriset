package com.ironsource.adqualitysdk.sdk.i;

import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import com.vungle.ads.internal.protos.Sdk;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ed extends ee {

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static int f1947 = 1;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static int f1948 = 0;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static char[] f1949 = {215, 260, 257, 178, 261, 247, 262, 251, 256, 249, 252, 264, 243, 254, 263, 269, 190, 180, 204, 271};

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static boolean f1950 = true;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static boolean f1951 = true;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f1952 = 146;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private Map<String, ee> f1953;

    public ed(Map<String, ee> map, Cdo cdo) {
        super(cdo);
        this.f1953 = new HashMap();
        for (String str : map.keySet()) {
            this.f1953.put(dy.m2174(str), map.get(str));
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m2186(String str, int i2, int[] iArr, String str2) throws UnsupportedEncodingException {
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
                char[] cArr2 = f1949;
                int i8 = f1952;
                if (f1951) {
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
                if (f1950) {
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

    public final boolean equals(Object obj) {
        if (this == obj) {
            f1947 = (f1948 + 19) % 128;
            return true;
        }
        if (obj != null && ed.class == obj.getClass()) {
            ed edVar = (ed) obj;
            Map<String, ee> map = this.f1953;
            if (map != null) {
                f1947 = (f1948 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
                return map.equals(edVar.f1953);
            }
            if (edVar.f1953 == null) {
                f1948 = (f1947 + 33) % 128;
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = f1948;
        f1947 = (i2 + 15) % 128;
        Map<String, ee> map = this.f1953;
        if (map == null) {
            return 0;
        }
        f1947 = (i2 + 111) % 128;
        int iHashCode = map.hashCode();
        int i8 = f1948 + 69;
        f1947 = i8 % 128;
        if (i8 % 2 != 0) {
            return iHashCode;
        }
        throw null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(m2186(null, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 127, null, "\u0090").intern());
        boolean z2 = true;
        for (String str : this.f1953.keySet()) {
            if (!z2) {
                f1948 = (f1947 + 45) % 128;
                sb.append(m2186(null, (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 127, null, "\u0084\u0091").intern());
            }
            sb.append(m2186(null, 126 - TextUtils.indexOf((CharSequence) "", '0', 0), null, "\u0092").intern());
            sb.append(str);
            sb.append(m2186(null, 127 - TextUtils.indexOf("", ""), null, "\u0084\u0093\u0084\u0092").intern());
            sb.append(this.f1953.get(str));
            z2 = false;
        }
        String strZ = com.google.android.gms.ads.internal.client.a.z(sb, m2186(null, (ViewConfiguration.getJumpTapTimeout() >> 16) + 127, null, "\u0094"));
        int i2 = f1947 + 73;
        f1948 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 28 / 0;
        }
        return strZ;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.ee
    /* JADX INFO: renamed from: ﻛ */
    public final du mo2156(ds dsVar, cp cpVar) {
        JSONObject jSONObject = new JSONObject();
        Iterator<String> it = this.f1953.keySet().iterator();
        while (it.hasNext()) {
            int i2 = f1947 + 61;
            f1948 = i2 % 128;
            if (i2 % 2 != 0) {
                String next = it.next();
                jSONObject.put(next, this.f1953.get(next).m2189(dsVar, cpVar).m2153());
                throw null;
            }
            String next2 = it.next();
            try {
                jSONObject.put(next2, this.f1953.get(next2).m2189(dsVar, cpVar).m2153());
                f1947 = (f1948 + 111) % 128;
            } catch (JSONException e) {
                String strM1723 = cpVar.m1723();
                StringBuilder sb = new StringBuilder();
                sb.append(m2186(null, (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 127, null, "\u0084\u0086\u008f\u008e\u008d\u008c\u0084\u0089\u0083\u0085\u008b\u0084\u008a\u0089\u0088\u0087\u0087\u0086\u0085\u0084\u0082\u0083\u0082\u0082\u0081").intern());
                sb.append(m2190());
                co.m1671(strM1723, sb.toString(), e);
            }
            String strM17232 = cpVar.m1723();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(m2186(null, (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 127, null, "\u0084\u0086\u008f\u008e\u008d\u008c\u0084\u0089\u0083\u0085\u008b\u0084\u008a\u0089\u0088\u0087\u0087\u0086\u0085\u0084\u0082\u0083\u0082\u0082\u0081").intern());
            sb2.append(m2190());
            co.m1671(strM17232, sb2.toString(), e);
        }
        return new du(jSONObject);
    }
}
