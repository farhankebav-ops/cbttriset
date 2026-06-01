package com.ironsource.adqualitysdk.sdk.i;

import com.vungle.ads.internal.protos.Sdk;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class dj extends da implements ci {

    /* JADX INFO: renamed from: 爫, reason: contains not printable characters */
    private static char f1749 = 23581;

    /* JADX INFO: renamed from: טּ, reason: contains not printable characters */
    private static int f1750 = 1;

    /* JADX INFO: renamed from: ףּ, reason: contains not printable characters */
    private static int f1751 = 0;

    /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
    private static long f1752 = 0;

    /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
    private static int f1753 = 0;

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    private static long f1754 = 7214887859272684907L;

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    private String f1755;

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    private String f1756;

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private String f1757;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private String f1758;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private String f1759;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private String f1760;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private String f1761;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private String f1762;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private String f1763;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private String f1764;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private String f1765;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private String f1766;

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    private Object m1983() {
        int i2 = f1751 + 57;
        f1750 = i2 % 128;
        if (i2 % 2 != 0) {
            return this.f1755;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    private void m1985(String str) {
        int i2 = f1750 + 19;
        int i8 = i2 % 128;
        f1751 = i8;
        int i9 = i2 % 2;
        this.f1756 = str;
        if (i9 != 0) {
            throw null;
        }
        f1750 = (i8 + 15) % 128;
    }

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    private void m1987(String str) {
        int i2 = f1750 + 19;
        int i8 = i2 % 128;
        f1751 = i8;
        int i9 = i2 % 2;
        this.f1755 = str;
        if (i9 != 0) {
            int i10 = 50 / 0;
        }
        f1750 = (i8 + 27) % 128;
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private String m1988() {
        String str;
        int i2 = f1750 + 109;
        int i8 = i2 % 128;
        f1751 = i8;
        if (i2 % 2 != 0) {
            str = this.f1759;
            int i9 = 74 / 0;
        } else {
            str = this.f1759;
        }
        int i10 = i8 + 63;
        f1750 = i10 % 128;
        if (i10 % 2 != 0) {
            return str;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private void m1991(String str) {
        int i2 = f1751;
        this.f1760 = str;
        int i8 = i2 + 55;
        f1750 = i8 % 128;
        if (i8 % 2 == 0) {
            int i9 = 5 / 0;
        }
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private void m1993(String str) {
        int i2 = f1750;
        this.f1759 = str;
        f1751 = (i2 + 73) % 128;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private void m1995(String str) {
        int i2 = f1750 + 37;
        int i8 = i2 % 128;
        f1751 = i8;
        int i9 = i2 % 2;
        this.f1757 = str;
        if (i9 != 0) {
            int i10 = 20 / 0;
        }
        f1750 = (i8 + 5) % 128;
    }

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private void m1997(String str) {
        int i2 = (f1750 + 55) % 128;
        f1751 = i2;
        this.f1758 = str;
        int i8 = i2 + 85;
        f1750 = i8 % 128;
        if (i8 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private void m1999(String str) {
        int i2 = f1750 + 83;
        f1751 = i2 % 128;
        int i8 = i2 % 2;
        this.f1766 = str;
        if (i8 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private void m2002(String str) {
        int i2 = f1751;
        int i8 = i2 + 113;
        f1750 = i8 % 128;
        int i9 = i8 % 2;
        this.f1763 = str;
        if (i9 == 0) {
            throw null;
        }
        int i10 = i2 + 95;
        f1750 = i10 % 128;
        if (i10 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private void m2004(String str) {
        int i2 = f1750 + 87;
        int i8 = i2 % 128;
        f1751 = i8;
        int i9 = i2 % 2;
        this.f1762 = str;
        if (i9 != 0) {
            throw null;
        }
        f1750 = (i8 + 87) % 128;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private String m2005() {
        int i2 = f1750;
        String str = this.f1763;
        int i8 = i2 + 37;
        f1751 = i8 % 128;
        if (i8 % 2 == 0) {
            return str;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private String m2007() {
        int i2 = f1750 + 13;
        int i8 = i2 % 128;
        f1751 = i8;
        if (i2 % 2 != 0) {
            throw null;
        }
        String str = this.f1764;
        int i9 = i8 + 113;
        f1750 = i9 % 128;
        if (i9 % 2 == 0) {
            int i10 = 98 / 0;
        }
        return str;
    }

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    private Object m1984() {
        int i2 = f1750;
        String str = this.f1756;
        f1751 = (i2 + 97) % 128;
        return str;
    }

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    private JSONObject m1986() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(ig.f2493, this.f1766);
            jSONObject.putOpt(ig.f2494, this.f1763);
            jSONObject.putOpt(ig.f2498, this.f1764);
            jSONObject.putOpt(ig.f2501, this.f1762);
            jSONObject.putOpt(ig.f2502, this.f1758);
            jSONObject.putOpt(ig.f2496, this.f1759);
            jSONObject.putOpt(ig.f2497, this.f1760);
            jSONObject.putOpt(ig.f2495, this.f1757);
            jSONObject.putOpt(ig.f2492, this.f1761);
            f1751 = (f1750 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private void m1989(String str) {
        int i2 = f1750;
        int i8 = i2 + 41;
        f1751 = i8 % 128;
        int i9 = i8 % 2;
        this.f1761 = str;
        if (i9 != 0) {
            throw null;
        }
        f1751 = (i2 + 81) % 128;
    }

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private String m1990() {
        int i2 = f1750 + 47;
        f1751 = i2 % 128;
        if (i2 % 2 == 0) {
            return this.f1757;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private String m1992() {
        int i2 = f1751 + 101;
        int i8 = i2 % 128;
        f1750 = i8;
        if (i2 % 2 == 0) {
            throw null;
        }
        String str = this.f1760;
        f1751 = (i8 + 49) % 128;
        return str;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private String m1994() {
        int i2 = f1750;
        String str = this.f1761;
        int i8 = i2 + 31;
        f1751 = i8 % 128;
        if (i8 % 2 == 0) {
            return str;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private String m1996() {
        int i2 = (f1750 + 75) % 128;
        f1751 = i2;
        String str = this.f1758;
        int i8 = i2 + 9;
        f1750 = i8 % 128;
        if (i8 % 2 != 0) {
            return str;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private String m1998() {
        int i2 = (f1750 + 97) % 128;
        f1751 = i2;
        String str = this.f1766;
        int i8 = i2 + 45;
        f1750 = i8 % 128;
        if (i8 % 2 != 0) {
            return str;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private Object m2000() {
        int i2 = f1751 + 109;
        f1750 = i2 % 128;
        if (i2 % 2 != 0) {
            return this.f1765;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private String m2003() {
        int i2 = (f1750 + 51) % 128;
        f1751 = i2;
        String str = this.f1762;
        f1750 = (i2 + 9) % 128;
        return str;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private void m2006(String str) {
        int i2 = f1750 + 73;
        f1751 = i2 % 128;
        int i8 = i2 % 2;
        this.f1764 = str;
        if (i8 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private void m2009(String str) {
        int i2 = f1751;
        int i8 = i2 + 47;
        f1750 = i8 % 128;
        int i9 = i8 % 2;
        this.f1765 = str;
        if (i9 == 0) {
            throw null;
        }
        int i10 = i2 + 1;
        f1750 = i10 % 128;
        if (i10 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m2001(String str, char c7, String str2, int i2, String str3) {
        String str4;
        Object charArray = str3;
        if (str3 != null) {
            charArray = str3.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        Object charArray2 = str2;
        if (str2 != null) {
            charArray2 = str2.toCharArray();
        }
        char[] cArr2 = (char[]) charArray2;
        Object charArray3 = str;
        if (str != null) {
            charArray3 = str.toCharArray();
        }
        char[] cArr3 = (char[]) charArray3;
        synchronized (f.f2031) {
            try {
                char[] cArr4 = (char[]) cArr3.clone();
                char[] cArr5 = (char[]) cArr.clone();
                cArr4[0] = (char) (c7 ^ cArr4[0]);
                cArr5[2] = (char) (cArr5[2] + ((char) i2));
                int length = cArr2.length;
                char[] cArr6 = new char[length];
                f.f2032 = 0;
                while (true) {
                    int i8 = f.f2032;
                    if (i8 < length) {
                        int i9 = (i8 + 2) % 4;
                        int i10 = (i8 + 3) % 4;
                        int i11 = cArr4[i8 % 4] * 32718;
                        char c8 = cArr5[i9];
                        char c9 = (char) ((i11 + c8) % 65535);
                        f.f2030 = c9;
                        cArr5[i10] = (char) com.google.android.gms.ads.internal.client.a.w(cArr4[i10], 32718, c8, 65535);
                        cArr4[i10] = c9;
                        int i12 = f.f2032;
                        cArr6[i12] = (char) (((((long) (c9 ^ cArr2[i12])) ^ f1752) ^ ((long) f1753)) ^ ((long) f1749));
                        f.f2032 = i12 + 1;
                    } else {
                        str4 = new String(cArr6);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str4;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x005a, code lost:
    
        if (r10.equals(m2001("퉜\ue7ef蕻꿨", (char) (1 - (android.view.ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (android.view.ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), "ཷꊕ䗊룮⯱\ue801駢㜎", 1 - (android.os.SystemClock.elapsedRealtime() > 0 ? 1 : (android.os.SystemClock.elapsedRealtime() == 0 ? 0 : -1)), "\u0000\u0000\u0000\u0000").intern()) != false) goto L66;
     */
    @Override // com.ironsource.adqualitysdk.sdk.i.ci
    /* JADX INFO: renamed from: ﾒ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object mo886(java.lang.String r10, java.util.List<java.lang.Object> r11, com.ironsource.adqualitysdk.sdk.i.ch r12) {
        /*
            Method dump skipped, instruction units count: 1182
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.dj.mo886(java.lang.String, java.util.List, com.ironsource.adqualitysdk.sdk.i.ch):java.lang.Object");
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m2008(String str, int i2) {
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
                        cArr2[i8] = (char) (((long) (cArr[i8] ^ (j.f2669 * i8))) ^ f1754);
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
