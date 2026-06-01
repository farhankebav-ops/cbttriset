package com.ironsource.adqualitysdk.sdk.i;

import com.ironsource.adqualitysdk.sdk.i.aq;
import com.vungle.ads.internal.protos.Sdk;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ap extends aq.AnonymousClass1 {

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f363 = 1;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f364;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static char[] f365 = {'7', 'n', 'i', 'd', 'k', 'q', 'p', 'r', 'k', 'i', 'd', 22, '5', 'i', 'k', 'H', 144, 142, 144, 148, 141, 127, 134, 146, 147, 141, 134, 139, 144, 144, 139};

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private final String f366;

    public ap(ax axVar) {
        m525("\u0000\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000", false, new int[]{0, 10, 0, 8}).intern();
        StringBuilder sb = new StringBuilder();
        sb.append(m525("\u0000", false, new int[]{10, 1, 85, 0}).intern());
        sb.append(UUID.randomUUID().toString().replace(m525("\u0001", false, new int[]{11, 1, 0, 0}).intern(), ""));
        this.f366 = sb.toString();
        m566(axVar);
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private JSONObject m526() {
        JSONObject jSONObjectOptJSONObject;
        int i2 = f364 + 29;
        f363 = i2 % 128;
        if (i2 % 2 != 0 ? (jSONObjectOptJSONObject = m565().optJSONObject(m525("\u0000\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000", false, new int[]{0, 10, 0, 8}).intern())) == null : (jSONObjectOptJSONObject = m565().optJSONObject(m525("\u0000\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000", true, new int[]{0, 10, 0, 8}).intern())) == null) {
            jSONObjectOptJSONObject = new JSONObject();
            f363 = (f364 + 113) % 128;
        }
        int i8 = f364 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE;
        f363 = i8 % 128;
        if (i8 % 2 == 0) {
            int i9 = 35 / 0;
        }
        return jSONObjectOptJSONObject;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final String m527(String str) {
        int i2 = f363 + 63;
        f364 = i2 % 128;
        if (i2 % 2 != 0) {
            m526().optJSONObject(str);
            throw null;
        }
        JSONObject jSONObjectOptJSONObject = m526().optJSONObject(str);
        if (jSONObjectOptJSONObject == null) {
            return null;
        }
        int i8 = f364 + 5;
        f363 = i8 % 128;
        return jSONObjectOptJSONObject.optString((i8 % 2 == 0 ? m525("\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0000", false, new int[]{15, 16, 34, 0}) : m525("\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0000", true, new int[]{15, 16, 34, 0})).intern());
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final String m529() {
        f364 = (f363 + 5) % 128;
        String strOptString = m565().optString(m525("\u0000\u0001\u0001", false, new int[]{12, 3, 0, 0}).intern(), this.f366);
        int i2 = f364 + 85;
        f363 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 59 / 0;
        }
        return strOptString;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m525(String str, boolean z2, int[] iArr) throws UnsupportedEncodingException {
        String str2;
        Object bytes = str;
        if (str != null) {
            bytes = str.getBytes("ISO-8859-1");
        }
        byte[] bArr = (byte[]) bytes;
        synchronized (g.f2126) {
            try {
                int i2 = iArr[0];
                int i8 = iArr[1];
                int i9 = iArr[2];
                int i10 = iArr[3];
                char[] cArr = new char[i8];
                System.arraycopy(f365, i2, cArr, 0, i8);
                if (bArr != null) {
                    char[] cArr2 = new char[i8];
                    g.f2125 = 0;
                    char c7 = 0;
                    while (true) {
                        int i11 = g.f2125;
                        if (i11 >= i8) {
                            break;
                        }
                        if (bArr[i11] == 1) {
                            cArr2[i11] = (char) (((cArr[i11] << 1) + 1) - c7);
                        } else {
                            cArr2[i11] = (char) ((cArr[i11] << 1) - c7);
                        }
                        c7 = cArr2[i11];
                        g.f2125 = i11 + 1;
                    }
                    cArr = cArr2;
                }
                if (i10 > 0) {
                    char[] cArr3 = new char[i8];
                    System.arraycopy(cArr, 0, cArr3, 0, i8);
                    int i12 = i8 - i10;
                    System.arraycopy(cArr3, 0, cArr, i12, i10);
                    System.arraycopy(cArr3, i10, cArr, 0, i12);
                }
                if (z2) {
                    char[] cArr4 = new char[i8];
                    g.f2125 = 0;
                    while (true) {
                        int i13 = g.f2125;
                        if (i13 >= i8) {
                            break;
                        }
                        cArr4[i13] = cArr[(i8 - i13) - 1];
                        g.f2125 = i13 + 1;
                    }
                    cArr = cArr4;
                }
                if (i9 > 0) {
                    g.f2125 = 0;
                    while (true) {
                        int i14 = g.f2125;
                        if (i14 >= i8) {
                            break;
                        }
                        cArr[i14] = (char) (cArr[i14] - iArr[2]);
                        g.f2125 = i14 + 1;
                    }
                }
                str2 = new String(cArr);
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final boolean m528() {
        f363 = (f364 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) % 128;
        boolean zHas = m565().has(m525("\u0000\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000", false, new int[]{0, 10, 0, 8}).intern());
        int i2 = f363 + 61;
        f364 = i2 % 128;
        if (i2 % 2 == 0) {
            return zHas;
        }
        throw null;
    }
}
