package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class eb extends ec {

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static int f1935 = 1;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static char f1936 = 5;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static char[] f1937 = {'s', 'u', 'p', 'e', 'r', 'E', 'o', ' ', 'x', 'c', 't', 'i', 'n', 'g', 'm', 'h', 'd', '.', '(', ')', '<', '>', 'v', 'w', 'y'};

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f1938;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private ee[] f1939;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private ee f1940;

    public eb(ee eeVar, String str, List<ee> list, List<ee> list2, Cdo cdo) {
        super(str, list2, cdo);
        this.f1940 = eeVar;
        if (list != null) {
            ee[] eeVarArr = new ee[list.size()];
            this.f1939 = eeVarArr;
            list.toArray(eeVarArr);
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static List<Class> m2180(ee[] eeVarArr, ds dsVar, cp cpVar) {
        ArrayList arrayList = new ArrayList();
        int length = eeVarArr.length;
        f1935 = (f1938 + 25) % 128;
        int i2 = 0;
        while (i2 < length) {
            arrayList.add((Class) eeVarArr[i2].m2189(dsVar, cpVar).m2153());
            i2++;
            f1935 = (f1938 + 51) % 128;
        }
        return arrayList;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.ec
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || eb.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        eb ebVar = (eb) obj;
        ee eeVar = this.f1940;
        if (eeVar == null ? ebVar.f1940 != null : !eeVar.equals(ebVar.f1940)) {
            return false;
        }
        ee[] eeVarArr = this.f1939;
        ee[] eeVarArr2 = ebVar.f1939;
        if (eeVarArr != null) {
            return eeVarArr.equals(eeVarArr2);
        }
        if (eeVarArr2 == null) {
            f1935 = (f1938 + 3) % 128;
            return true;
        }
        f1938 = (f1935 + 109) % 128;
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029 A[PHI: r0
  0x0029: PHI (r0v11 int) = (r0v4 int), (r0v13 int) binds: [B:8:0x0020, B:5:0x0015] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0022 A[PHI: r0
  0x0022: PHI (r0v5 int) = (r0v4 int), (r0v13 int) binds: [B:8:0x0020, B:5:0x0015] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.ironsource.adqualitysdk.sdk.i.ec
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int hashCode() {
        /*
            r4 = this;
            int r0 = com.ironsource.adqualitysdk.sdk.i.eb.f1935
            int r0 = r0 + 123
            int r1 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.eb.f1938 = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L18
            int r0 = super.hashCode()
            int r0 = r0 << 22
            com.ironsource.adqualitysdk.sdk.i.ee r2 = r4.f1940
            if (r2 == 0) goto L29
            goto L22
        L18:
            int r0 = super.hashCode()
            int r0 = r0 * 31
            com.ironsource.adqualitysdk.sdk.i.ee r2 = r4.f1940
            if (r2 == 0) goto L29
        L22:
            com.ironsource.adqualitysdk.sdk.i.ee r2 = r4.f1940
            int r2 = r2.hashCode()
            goto L2a
        L29:
            r2 = r1
        L2a:
            int r0 = r0 + r2
            int r0 = r0 * 31
            com.ironsource.adqualitysdk.sdk.i.ee[] r2 = r4.f1939
            if (r2 == 0) goto L47
            int r1 = com.ironsource.adqualitysdk.sdk.i.eb.f1938
            int r1 = r1 + 23
            int r3 = r1 % 128
            com.ironsource.adqualitysdk.sdk.i.eb.f1935 = r3
            int r1 = r1 % 2
            if (r1 == 0) goto L42
            int r1 = r2.hashCode()
            goto L47
        L42:
            r2.hashCode()
            r0 = 0
            throw r0
        L47:
            int r0 = r0 + r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.eb.hashCode():int");
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.ec
    public final String toString() {
        int i2 = f1938 + 3;
        f1935 = i2 % 128;
        if (i2 % 2 != 0) {
            return mo2181(m2184());
        }
        mo2181(m2184());
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.ec, com.ironsource.adqualitysdk.sdk.i.ee
    /* JADX INFO: renamed from: ﻛ */
    public final du mo2156(ds dsVar, cp cpVar) {
        Method methodM2842;
        List<Object> listM2185 = m2185(dsVar, cpVar);
        ee eeVar = this.f1940;
        if ((eeVar instanceof em) && ((em) eeVar).m2208().equals(m2179(View.MeasureSpec.getSize(0) + 5, (byte) (61 - (ViewConfiguration.getTapTimeout() >> 16)), "\u0001\u0002\u0003\u0004¯").intern())) {
            return cpVar.m1732().m2351().m2353(m2183()).m2081(dsVar, cpVar, listM2185).m2149(false);
        }
        Object objM2153 = this.f1940.m2189(dsVar, cpVar).m2153();
        if (objM2153 instanceof ci) {
            return new du(((ci) objM2153).mo886(m2183(), listM2185, cpVar.m1720()));
        }
        if (objM2153 instanceof cl) {
            String strM2183 = m2183();
            cpVar.m1720();
            return new du(((cl) objM2153).mo1636(cpVar, strM2183, listM2185, dsVar));
        }
        if (objM2153 instanceof cp) {
            synchronized (objM2153) {
                try {
                    cp cpVar2 = (cp) objM2153;
                    dq dqVarM1729 = cpVar2.m1729(m2183());
                    if (dqVarM1729 != null) {
                        return dqVarM1729.m2081(cpVar2.m1722(), cpVar2, listM2185).m2149(false);
                    }
                    String strM1723 = cpVar.m1723();
                    StringBuilder sb = new StringBuilder();
                    sb.append(m2179(23 - (ViewConfiguration.getScrollBarSize() >> 8), (byte) (ExpandableListView.getPackedPositionGroup(0L) + 17), "\t\u0000\u0001\t\u0002\t\b\r\u0004\b\u0000\u000b\f\r\f\b\r\u0004\u000f\u0014\u000b\u00151").intern());
                    sb.append(m2183());
                    co.m1671(strM1723, sb.toString(), new NoSuchMethodException());
                } finally {
                }
            }
        }
        try {
            ee[] eeVarArr = this.f1939;
            if (eeVarArr != null) {
                methodM2842 = jz.m2847(objM2153, m2183(), m2180(eeVarArr, dsVar, cpVar));
            } else {
                methodM2842 = jz.m2842(objM2153, m2183(), listM2185);
            }
            if (methodM2842 != null) {
                return new du(methodM2842.invoke(objM2153, listM2185.toArray()));
            }
            listM2185.add(0, objM2153);
            de deVarM1719 = cpVar.m1719();
            String strM21832 = m2183();
            cpVar.m1720();
            return new du(deVarM1719.mo1636(cpVar, strM21832, listM2185, dsVar));
        } catch (IllegalAccessException e) {
            String strM17232 = cpVar.m1723();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(m2179(23 - Color.argb(0, 0, 0, 0), (byte) (TextUtils.lastIndexOf("", '0') + 18), "\t\u0000\u0001\t\u0002\t\b\r\u0004\b\u0000\u000b\f\r\f\b\r\u0004\u000f\u0014\u000b\u00151").intern());
            sb2.append(this);
            co.m1671(strM17232, sb2.toString(), e);
            return null;
        } catch (IllegalArgumentException e4) {
            String strM17233 = cpVar.m1723();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(m2179(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 24, (byte) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 16), "\t\u0000\u0001\t\u0002\t\b\r\u0004\b\u0000\u000b\f\r\f\b\r\u0004\u000f\u0014\u000b\u00151").intern());
            sb3.append(this);
            co.m1671(strM17233, sb3.toString(), e4);
            return null;
        } catch (Exception e8) {
            throw new RuntimeException(e8);
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private String m2178() {
        int i2 = f1935 + 107;
        f1938 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
        if (this.f1939 == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(m2179(TextUtils.indexOf("", "") + 1, (byte) (15 - TextUtils.indexOf("", "")), "K").intern());
        sb.append(ee.m2188(this.f1939));
        String strZ = com.google.android.gms.ads.internal.client.a.z(sb, m2179((ViewConfiguration.getLongPressTimeout() >> 16) + 1, (byte) (162 - AndroidCharacter.getMirror('0')), "°"));
        int i8 = f1938 + 75;
        f1935 = i8 % 128;
        if (i8 % 2 != 0) {
            return strZ;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m2179(int i2, byte b8, String str) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (h.f2264) {
            try {
                char[] cArr2 = f1937;
                char c7 = f1936;
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

    @Override // com.ironsource.adqualitysdk.sdk.i.ec
    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final String mo2181(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1940);
        sb.append(m2179(1 - ((Process.getThreadPriority(0) + 20) >> 6), (byte) (51 - Gravity.getAbsoluteGravity(0, 0)), "a").intern());
        sb.append(m2183());
        sb.append(m2178());
        sb.append(m2179((ViewConfiguration.getJumpTapTimeout() >> 16) + 1, (byte) (65 - Color.argb(0, 0, 0, 0)), "i").intern());
        sb.append(ee.m2188(objArr));
        String strZ = com.google.android.gms.ads.internal.client.a.z(sb, m2179(View.MeasureSpec.getMode(0) + 1, (byte) (99 - (ViewConfiguration.getScrollDefaultDelay() >> 16)), "\u008c"));
        int i2 = f1935 + 55;
        f1938 = i2 % 128;
        if (i2 % 2 == 0) {
            return strZ;
        }
        throw null;
    }
}
