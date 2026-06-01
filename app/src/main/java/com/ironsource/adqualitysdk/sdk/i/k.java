package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.ironsource.adqualitysdk.sdk.ISAdQualityLogLevel;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class k {

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f2941 = 1;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static char[] f2942 = {'\n', 'I', 'r', 'o', 'n', 'S', 'u', 'c', 'e', ' ', 'A', 'd', 'Q', 'a', 'l', 'i', 't', 'y', ':', 11, '\f', '\r', 14, 15, 16};

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static char f2943 = 5;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f2944;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    public static void m2851(String str, String str2) {
        int i2 = f2944 + 35;
        f2941 = i2 % 128;
        int i8 = i2 % 2;
        m2855(str, str, str2);
        if (i8 == 0) {
            throw null;
        }
        f2944 = (f2941 + 63) % 128;
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    public static void m2852(String str, String str2) {
        f2941 = (f2944 + 9) % 128;
        m2869(str, str2, (Object) null);
        int i2 = f2941 + 101;
        f2944 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 43 / 0;
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static void m2856(String str, String str2, boolean z2) {
        f2944 = (f2941 + 9) % 128;
        m2867(str, str, str2, z2);
        int i2 = f2941 + 9;
        f2944 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static ISAdQualityLogLevel m2857() {
        f2944 = (f2941 + 33) % 128;
        ISAdQualityLogLevel iSAdQualityLogLevelM3030 = q.m3013().m3030();
        int i2 = f2944 + 9;
        f2941 = i2 % 128;
        if (i2 % 2 != 0) {
            return iSAdQualityLogLevelM3030;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static boolean m2864() {
        f2944 = (f2941 + 61) % 128;
        boolean zM3032 = q.m3013().m3032();
        f2944 = (f2941 + 67) % 128;
        return zM3032;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static void m2866(String str, String str2, String str3, Object obj, boolean z2) {
        if (obj != null) {
            StringBuilder sbR = androidx.camera.core.processing.util.a.r(str3);
            sbR.append(m2862((byte) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 58), 1 - View.MeasureSpec.getMode(0), "D").intern());
            sbR.append(obj.toString());
            str3 = sbR.toString();
        }
        if (!m2864()) {
            if (z2 && m2857().shouldPrintLog(ISAdQualityLogLevel.DEBUG)) {
                Log.d(m2853(str2), str3);
            }
            f2941 = (f2944 + 39) % 128;
            return;
        }
        int i2 = f2941 + 61;
        f2944 = i2 % 128;
        if (i2 % 2 == 0) {
            Log.d(m2853(str), str3);
        } else {
            Log.d(m2853(str), str3);
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static void m2868(String str, String str2) {
        f2944 = (f2941 + 1) % 128;
        m2872(str, str2, (Throwable) null);
        f2941 = (f2944 + 43) % 128;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static void m2854(String str, String str2) {
        int i2 = f2941 + 55;
        f2944 = i2 % 128;
        int i8 = i2 % 2;
        m2871(str, str, str2, true);
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static void m2861(String str, String str2, Throwable th) {
        int i2 = f2941 + 97;
        f2944 = i2 % 128;
        m2860(str, str, str2, th, i2 % 2 != 0);
        f2941 = (f2944 + 45) % 128;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static void m2863(String str, String str2) {
        f2941 = (f2944 + 7) % 128;
        m2861(str, str2, (Throwable) null);
        f2944 = (f2941 + 61) % 128;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static void m2872(String str, String str2, Throwable th) {
        f2944 = (f2941 + 3) % 128;
        m2860(str, str, str2, th, true);
        f2941 = (f2944 + 101) % 128;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0024, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002f, code lost:
    
        if (m2857().shouldPrintLog(com.ironsource.adqualitysdk.sdk.ISAdQualityLogLevel.VERBOSE) == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0031, code lost:
    
        r2 = com.ironsource.adqualitysdk.sdk.i.k.f2941 + 57;
        com.ironsource.adqualitysdk.sdk.i.k.f2944 = r2 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003b, code lost:
    
        if ((r2 % 2) == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003d, code lost:
    
        android.util.Log.v(m2853(r3), r4);
        r2 = 26 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0048, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
    
        android.util.Log.v(m2853(r3), r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0050, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0014, code lost:
    
        if (m2864() != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
    
        if (m2864() != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
    
        android.util.Log.v(m2853(r2), r4);
     */
    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void m2855(java.lang.String r2, java.lang.String r3, java.lang.String r4) {
        /*
            int r0 = com.ironsource.adqualitysdk.sdk.i.k.f2941
            int r0 = r0 + 109
            int r1 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.k.f2944 = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L17
            boolean r0 = m2864()
            r1 = 34
            int r1 = r1 / 0
            if (r0 == 0) goto L25
            goto L1d
        L17:
            boolean r0 = m2864()
            if (r0 == 0) goto L25
        L1d:
            java.lang.String r2 = m2853(r2)
            android.util.Log.v(r2, r4)
            return
        L25:
            com.ironsource.adqualitysdk.sdk.ISAdQualityLogLevel r2 = m2857()
            com.ironsource.adqualitysdk.sdk.ISAdQualityLogLevel r0 = com.ironsource.adqualitysdk.sdk.ISAdQualityLogLevel.VERBOSE
            boolean r2 = r2.shouldPrintLog(r0)
            if (r2 == 0) goto L50
            int r2 = com.ironsource.adqualitysdk.sdk.i.k.f2941
            int r2 = r2 + 57
            int r0 = r2 % 128
            com.ironsource.adqualitysdk.sdk.i.k.f2944 = r0
            int r2 = r2 % 2
            if (r2 == 0) goto L49
            java.lang.String r2 = m2853(r3)
            android.util.Log.v(r2, r4)
            r2 = 26
            int r2 = r2 / 0
            return
        L49:
            java.lang.String r2 = m2853(r3)
            android.util.Log.v(r2, r4)
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.k.m2855(java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static void m2860(String str, String str2, String str3, Throwable th, boolean z2) {
        int i2 = f2944 + 55;
        f2941 = i2 % 128;
        if (i2 % 2 != 0) {
            if (m2864()) {
                Log.e(m2853(str), str3, th);
                f2944 = (f2941 + 99) % 128;
                return;
            }
            if (z2) {
                int i8 = f2941 + 89;
                f2944 = i8 % 128;
                if (i8 % 2 == 0) {
                    if (m2857().shouldPrintLog(ISAdQualityLogLevel.ERROR)) {
                        f2944 = (f2941 + 87) % 128;
                        Log.e(m2853(str2), str3, th);
                    }
                } else {
                    m2857().shouldPrintLog(ISAdQualityLogLevel.ERROR);
                    throw null;
                }
            }
            int i9 = f2941 + 43;
            f2944 = i9 % 128;
            if (i9 % 2 != 0) {
                int i10 = 40 / 0;
                return;
            }
            return;
        }
        m2864();
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m2862(byte b8, int i2, String str) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (h.f2264) {
            try {
                char[] cArr2 = f2942;
                char c7 = f2943;
                char[] cArr3 = new char[i2];
                if (i2 % 2 != 0) {
                    i2--;
                    cArr3[i2] = (char) (cArr[i2] - b8);
                }
                if (i2 > 1) {
                    h.f2267 = 0;
                    while (true) {
                        int i8 = h.f2267;
                        if (i8 >= i2) {
                            break;
                        }
                        h.f2269 = cArr[i8];
                        h.f2268 = cArr[h.f2267 + 1];
                        if (h.f2269 == h.f2268) {
                            cArr3[h.f2267] = (char) (h.f2269 - b8);
                            cArr3[h.f2267 + 1] = (char) (h.f2268 - b8);
                        } else {
                            h.f2266 = h.f2269 / c7;
                            h.f2263 = h.f2269 % c7;
                            h.f2265 = h.f2268 / c7;
                            h.f2262 = h.f2268 % c7;
                            if (h.f2263 == h.f2262) {
                                h.f2266 = androidx.camera.core.processing.util.a.C(h.f2266, c7, 1, c7);
                                h.f2265 = androidx.camera.core.processing.util.a.C(h.f2265, c7, 1, c7);
                                int i9 = (h.f2266 * c7) + h.f2263;
                                int i10 = (h.f2265 * c7) + h.f2262;
                                int i11 = h.f2267;
                                cArr3[i11] = cArr2[i9];
                                cArr3[i11 + 1] = cArr2[i10];
                            } else if (h.f2266 == h.f2265) {
                                h.f2263 = androidx.camera.core.processing.util.a.C(h.f2263, c7, 1, c7);
                                h.f2262 = androidx.camera.core.processing.util.a.C(h.f2262, c7, 1, c7);
                                int i12 = (h.f2266 * c7) + h.f2263;
                                int i13 = (h.f2265 * c7) + h.f2262;
                                int i14 = h.f2267;
                                cArr3[i14] = cArr2[i12];
                                cArr3[i14 + 1] = cArr2[i13];
                            } else {
                                int i15 = (h.f2266 * c7) + h.f2262;
                                int i16 = (h.f2265 * c7) + h.f2263;
                                int i17 = h.f2267;
                                cArr3[i17] = cArr2[i15];
                                cArr3[i17 + 1] = cArr2[i16];
                            }
                        }
                        h.f2267 += 2;
                    }
                }
                str2 = new String(cArr3);
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static void m2873(String str, String str2, Throwable th, boolean z2) {
        int i2 = f2944 + 85;
        f2941 = i2 % 128;
        int i8 = i2 % 2;
        m2860(str, str, str2, th, z2);
        if (i8 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static void m2871(String str, String str2, String str3, boolean z2) {
        if (m2864()) {
            f2944 = (f2941 + 75) % 128;
            Log.i(m2853(str), str3);
            return;
        }
        if (z2 && m2857().shouldPrintLog(ISAdQualityLogLevel.INFO)) {
            Log.i(m2853(str2), str3);
        }
        int i2 = f2941 + 97;
        f2944 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m2853(String str) {
        String strD = a0.d(new StringBuilder(), m2862((byte) (81 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))), Color.alpha(0) + 22, "\u0002\u0003\u0004\u0000\b\u0000\u0007\u0001\b\t\u0005\u000e\f\r\b\u000b\n\u0013\u0011\u0012\u0013\b"), str);
        int i2 = f2941 + 25;
        f2944 = i2 % 128;
        if (i2 % 2 == 0) {
            return strD;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static void m2870(String str, String str2, String str3, Object obj) {
        f2941 = (f2944 + 71) % 128;
        m2866(str, str2, str3, obj, true);
        f2944 = (f2941 + 81) % 128;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static void m2869(String str, String str2, Object obj) {
        int i2 = f2944 + 85;
        f2941 = i2 % 128;
        m2866(str, str, str2, obj, i2 % 2 == 0);
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static void m2867(String str, String str2, String str3, boolean z2) {
        int i2 = f2944 + 15;
        f2941 = i2 % 128;
        int i8 = i2 % 2;
        m2860(str, str2, str3, null, z2);
        if (i8 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static void m2865(String str, String str2) {
        f2941 = (f2944 + 101) % 128;
        m2871(str, str, str2, false);
        int i2 = f2944 + 41;
        f2941 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static void m2858(String str, String str2) {
        int i2 = f2944 + 23;
        f2941 = i2 % 128;
        int i8 = i2 % 2;
        m2870(str, str, str2, (Object) null);
        if (i8 == 0) {
            int i9 = 90 / 0;
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static void m2859(String str, String str2, Object obj) {
        int i2 = f2941 + 29;
        f2944 = i2 % 128;
        int i8 = i2 % 2;
        m2870(str, str, str2, obj);
        if (i8 != 0) {
            int i9 = 8 / 0;
        }
        f2944 = (f2941 + 75) % 128;
    }
}
