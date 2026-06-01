package com.ironsource.adqualitysdk.sdk.i;

import com.ironsource.adqualitysdk.sdk.i.kc;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class dp {

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static int f1815 = 1;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static char[] f1816 = {'9', 't', 'r', 'j', 'k', ':', 'k', 'b', 'i', 's', 's', 'j', 'a', '9', 'r', 'k', 'c', 'g', 'i', 'i', 'r', 220, 220, 225, 226, '9', 's', 'q', 'i', 'm', 'm', '9', 'k', 'i', 'k', 'n', 'l', 'i'};

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static int f1817;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private Map<String, dl> f1818;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private Map<String, dq> f1819;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private List<dm> f1820;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private String f1821;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private List<String> f1822;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private String f1823;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private boolean f1824;

    public dp(final String str, String str2, JSONObject jSONObject) {
        this.f1821 = dy.m2174(str2);
        this.f1823 = dy.m2174(jSONObject.optString(m2069("\u0001\u0000\u0001\u0001\u0001", false, new int[]{0, 5, 0, 0}).intern()));
        this.f1824 = jSONObject.optBoolean(m2069("\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001", true, new int[]{5, 8, 0, 0}).intern());
        this.f1822 = m2071(kc.m2908(jSONObject.optJSONArray(m2069("\u0001\u0001\u0001\u0001\u0001\u0000\u0000", true, new int[]{13, 7, 0, 0}).intern()), new kc.c<String>() { // from class: com.ironsource.adqualitysdk.sdk.i.dp.5
            @Override // com.ironsource.adqualitysdk.sdk.i.kc.c
            /* JADX INFO: renamed from: ｋ */
            public final /* synthetic */ String mo599(JSONArray jSONArray, int i2) {
                return dy.m2174(jSONArray.optString(i2));
            }
        }));
        this.f1820 = m2071(kc.m2908(jSONObject.optJSONArray(m2069("\u0000\u0001\u0000\u0001\u0001", true, new int[]{20, 5, 112, 3}).intern()), new kc.c<dm>() { // from class: com.ironsource.adqualitysdk.sdk.i.dp.1
            @Override // com.ironsource.adqualitysdk.sdk.i.kc.c
            /* JADX INFO: renamed from: ｋ */
            public final /* synthetic */ dm mo599(JSONArray jSONArray, int i2) {
                return new dm(jSONArray.optJSONObject(i2));
            }
        }));
        this.f1818 = m2070(kc.m2902(jSONObject.optJSONObject(m2069("\u0001\u0001\u0000\u0001\u0001\u0001", true, new int[]{25, 6, 0, 0}).intern()), new kc.b<dl>() { // from class: com.ironsource.adqualitysdk.sdk.i.dp.3
            @Override // com.ironsource.adqualitysdk.sdk.i.kc.b
            /* JADX INFO: renamed from: ﻐ */
            public final /* synthetic */ dl mo595(JSONObject jSONObject2, String str3) {
                return new dl(jSONObject2.optJSONObject(str3));
            }
        }));
        this.f1819 = m2070(kc.m2902(jSONObject.optJSONObject(m2069("\u0001\u0001\u0001\u0001\u0000\u0001\u0000", true, new int[]{31, 7, 0, 0}).intern()), new kc.b<dq>() { // from class: com.ironsource.adqualitysdk.sdk.i.dp.4
            @Override // com.ironsource.adqualitysdk.sdk.i.kc.b
            /* JADX INFO: renamed from: ﻐ */
            public final /* synthetic */ dq mo595(JSONObject jSONObject2, String str3) {
                return new dq(str, str3, jSONObject2.optJSONObject(str3));
            }
        }));
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
    
        return new java.util.HashMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0010, code lost:
    
        if (r2 != null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0013, code lost:
    
        if (r2 != null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
    
        r1 = r1 + 89;
        com.ironsource.adqualitysdk.sdk.i.dp.f1817 = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
    
        if ((r1 % 2) != 0) goto L11;
     */
    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static <K, V> java.util.Map<K, V> m2070(java.util.Map<K, V> r2) {
        /*
            int r0 = com.ironsource.adqualitysdk.sdk.i.dp.f1817
            int r0 = r0 + 123
            int r1 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.dp.f1815 = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L13
            r0 = 39
            int r0 = r0 / 0
            if (r2 == 0) goto L22
            goto L15
        L13:
            if (r2 == 0) goto L22
        L15:
            int r1 = r1 + 89
            int r0 = r1 % 128
            com.ironsource.adqualitysdk.sdk.i.dp.f1817 = r0
            int r1 = r1 % 2
            if (r1 != 0) goto L20
            return r2
        L20:
            r2 = 0
            throw r2
        L22:
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.dp.m2070(java.util.Map):java.util.Map");
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static <T> List<T> m2071(List<T> list) {
        int i2;
        if (list != null) {
            int i8 = f1815 + 79;
            f1817 = i8 % 128;
            i2 = i8 % 2 != 0 ? 38 : 34;
            return list;
        }
        list = new ArrayList<>();
        int i9 = f1815 + 115;
        f1817 = i9 % 128;
        if (i9 % 2 == 0) {
            return list;
        }
        int i10 = i2 / 0;
        return list;
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    public final List<dm> m2072() {
        int i2 = f1817 + 109;
        f1815 = i2 % 128;
        if (i2 % 2 != 0) {
            return this.f1820;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    public final Map<String, dl> m2073() {
        int i2 = f1817;
        int i8 = i2 + 105;
        f1815 = i8 % 128;
        if (i8 % 2 == 0) {
            throw null;
        }
        Map<String, dl> map = this.f1818;
        f1815 = (i2 + 99) % 128;
        return map;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final String m2074() {
        int i2 = (f1815 + 53) % 128;
        f1817 = i2;
        String str = this.f1823;
        int i8 = i2 + 75;
        f1815 = i8 % 128;
        if (i8 % 2 == 0) {
            int i9 = 34 / 0;
        }
        return str;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final boolean m2077() {
        int i2 = f1817;
        boolean z2 = this.f1824;
        f1815 = (i2 + 41) % 128;
        return z2;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final Map<String, dq> m2078() {
        int i2 = f1815 + 85;
        int i8 = i2 % 128;
        f1817 = i8;
        if (i2 % 2 != 0) {
            throw null;
        }
        Map<String, dq> map = this.f1819;
        int i9 = i8 + 57;
        f1815 = i9 % 128;
        if (i9 % 2 != 0) {
            return map;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final List<String> m2076() {
        int i2 = f1815;
        List<String> list = this.f1822;
        int i8 = i2 + 37;
        f1817 = i8 % 128;
        if (i8 % 2 == 0) {
            return list;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final String m2075() {
        int i2 = (f1815 + 7) % 128;
        f1817 = i2;
        String str = this.f1821;
        int i8 = i2 + 89;
        f1815 = i8 % 128;
        if (i8 % 2 == 0) {
            int i9 = 48 / 0;
        }
        return str;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m2069(String str, boolean z2, int[] iArr) throws UnsupportedEncodingException {
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
                System.arraycopy(f1816, i2, cArr, 0, i8);
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
}
