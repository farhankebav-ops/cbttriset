package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class u {

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static int f3085 = 1;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f3086 = 0;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f3087 = 15;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private Map<String, w> f3088 = new HashMap();

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private Map<String, aa> f3090 = new HashMap();

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private Map<String, ad> f3089 = new HashMap();

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ String m3042(JSONObject jSONObject) {
        int i2 = f3086 + 39;
        f3085 = i2 % 128;
        int i8 = i2 % 2;
        String strM3046 = m3046(jSONObject);
        if (i8 == 0) {
            int i9 = 24 / 0;
        }
        return strM3046;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ Map m3044(u uVar) {
        int i2 = f3086;
        f3085 = (i2 + 81) % 128;
        Map<String, aa> map = uVar.f3090;
        int i8 = i2 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE;
        f3085 = i8 % 128;
        if (i8 % 2 != 0) {
            return map;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ Map m3045(u uVar) {
        int i2 = f3085;
        f3086 = (i2 + 51) % 128;
        Map<String, w> map = uVar.f3088;
        int i8 = i2 + 3;
        f3086 = i8 % 128;
        if (i8 % 2 != 0) {
            int i9 = 60 / 0;
        }
        return map;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final void m3051(final JSONObject jSONObject, final l lVar, final jj jjVar, final it itVar) {
        p.m2967(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.u.5
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                String strM3042 = u.m3042(jSONObject);
                w wVar = (w) u.m3045(u.this).get(strM3042);
                if (wVar == null) {
                    wVar = new w(jSONObject, itVar);
                    u.m3045(u.this).put(strM3042, wVar);
                } else {
                    wVar.m3062(itVar);
                    wVar.m3113(jSONObject);
                }
                wVar.m3133((s) lVar);
                wVar.m3111((jg) jjVar);
            }
        });
        f3085 = (f3086 + 21) % 128;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final void m3053() {
        p.m2967(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.u.2
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                ArrayList arrayList = new ArrayList(u.m3044(u.this).values());
                u.m3044(u.this).clear();
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    ((aa) obj).m265();
                }
            }
        });
        int i2 = f3085 + 19;
        f3086 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ Map m3043(u uVar) {
        int i2 = f3086 + 91;
        int i8 = i2 % 128;
        f3085 = i8;
        int i9 = i2 % 2;
        Map<String, ad> map = uVar.f3089;
        if (i9 == 0) {
            throw null;
        }
        f3086 = (i8 + 65) % 128;
        return map;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final void m3050() {
        p.m2967(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.u.1
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                ArrayList arrayList = new ArrayList(u.m3045(u.this).values());
                u.m3045(u.this).clear();
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    ((w) obj).m3109();
                }
            }
        });
        f3086 = (f3085 + 115) % 128;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final void m3052(JSONObject jSONObject, t tVar) {
        f3086 = (f3085 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) % 128;
        m3054(jSONObject, tVar, null);
        int i2 = f3085 + 71;
        f3086 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 9 / 0;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final void m3054(final JSONObject jSONObject, final t tVar, final is isVar) {
        p.m2967(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.u.3
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                String strM3042 = u.m3042(jSONObject);
                ad adVar = (ad) u.m3043(u.this).get(strM3042);
                if (adVar == null) {
                    adVar = new ad(jSONObject, isVar);
                    u.m3043(u.this).put(strM3042, adVar);
                } else {
                    adVar.m327(jSONObject, isVar);
                }
                adVar.m3133(tVar);
            }
        });
        f3086 = (f3085 + 101) % 128;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m3046(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        sb.append(jSONObject.optString(m3047("\uffff\u0004\n\ufffb�\b\ufff7\n\uffff\u0005\u0004￡\ufffb\u000f", 13 - MotionEvent.axisFromString(""), 121 - (ViewConfiguration.getWindowTouchSlop() >> 8), false, 14 - TextUtils.indexOf("", "", 0)).intern()));
        sb.append(m3047("\u0000", 1 - (ViewConfiguration.getPressedStateDuration() >> 16), 61 - KeyEvent.getDeadChar(0, 0), false, 1 - ExpandableListView.getPackedPositionType(0L)).intern());
        sb.append(jSONObject.optString(m3047("\uffff￼\u0000\b￼￩\u0014\u000f\u0004\u0011\u0004\u000f\ufffeￜ", 2 - KeyEvent.getDeadChar(0, 0), 115 - TextUtils.indexOf((CharSequence) "", '0', 0), true, 15 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))).intern()));
        sb.append(jSONObject.optString(m3047("\uffdd\u0011\uffff\u0003\u0010\uffff\u0007\ufffb￨\r\r\ufffb\u0006", Color.blue(0) + 5, 116 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), true, 13 - (KeyEvent.getMaxKeyCode() >> 16)).intern()));
        sb.append(jSONObject.optString(m3047("\u0006\u0002\u0014￠\t\ufffe\u0010\u0010￫\ufffe\n\u0002\ufffe\u0001\ufff3", 13 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 113, false, 15 - (ViewConfiguration.getDoubleTapTimeout() >> 16)).intern()));
        String string = sb.toString();
        int i2 = f3085 + 7;
        f3086 = i2 % 128;
        if (i2 % 2 == 0) {
            return string;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m3047(String str, int i2, int i8, boolean z2, int i9) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (e.f1927) {
            try {
                char[] cArr2 = new char[i9];
                e.f1926 = 0;
                while (true) {
                    int i10 = e.f1926;
                    if (i10 >= i9) {
                        break;
                    }
                    e.f1929 = cArr[i10];
                    cArr2[e.f1926] = (char) (e.f1929 + i8);
                    int i11 = e.f1926;
                    cArr2[i11] = (char) (cArr2[i11] - f3087);
                    e.f1926 = i11 + 1;
                }
                if (i2 > 0) {
                    e.f1928 = i2;
                    char[] cArr3 = new char[i9];
                    System.arraycopy(cArr2, 0, cArr3, 0, i9);
                    int i12 = e.f1928;
                    System.arraycopy(cArr3, 0, cArr2, i9 - i12, i12);
                    int i13 = e.f1928;
                    System.arraycopy(cArr3, i13, cArr2, 0, i9 - i13);
                }
                if (z2) {
                    char[] cArr4 = new char[i9];
                    e.f1926 = 0;
                    while (true) {
                        int i14 = e.f1926;
                        if (i14 >= i9) {
                            break;
                        }
                        cArr4[i14] = cArr2[(i9 - i14) - 1];
                        e.f1926 = i14 + 1;
                    }
                    cArr2 = cArr4;
                }
                str2 = new String(cArr2);
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final void m3049(final JSONObject jSONObject, final x xVar) {
        p.m2967(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.u.4
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                String strM3042 = u.m3042(jSONObject);
                aa aaVar = (aa) u.m3044(u.this).get(strM3042);
                if (aaVar == null) {
                    aaVar = new aa(jSONObject);
                    u.m3044(u.this).put(strM3042, aaVar);
                } else {
                    aaVar.m260(jSONObject);
                }
                aaVar.m3133((s) xVar);
            }
        });
        int i2 = f3085 + 105;
        f3086 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final void m3048() {
        p.m2967(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.u.6
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                ArrayList arrayList = new ArrayList(u.m3043(u.this).values());
                u.m3043(u.this).clear();
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    ((ad) obj).m325();
                }
            }
        });
        int i2 = f3085 + 9;
        f3086 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 24 / 0;
        }
    }
}
