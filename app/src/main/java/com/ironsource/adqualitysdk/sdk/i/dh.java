package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.media.AudioTrack;
import android.os.Process;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.ironsource.adqualitysdk.sdk.i.kc;
import com.vungle.ads.internal.protos.Sdk;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class dh {

    /* JADX INFO: renamed from: ףּ, reason: contains not printable characters */
    private static int f1714 = 1;

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    private static int f1717;

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    private Map<String, dp> f1719;

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private String f1720;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private String f1721;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private ds f1722;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private dn f1723;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private String f1724;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private String f1725;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private JSONObject f1726;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private String f1727;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private String f1728;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private ds f1729;

    /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
    private static char[] f1715 = {'_', 194, 192, 192, 'x', 245, 243, 227, 239, 249, 242, 250, 253, 250, 242, '<', 'y', 'w', 'y', '}', 'v', 'x', 143, 289, 294, 293, 293, 282, ':', 's', 'n', 'j', 'o', 'r', 'k', 'i', 'i', '<', 'v', 't', 'r', 't', 'x', 'q', 'c', 'k', 'w', 'o', 'l', 'Z', '^', 'g', 'e', 'm', 'q'};

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    private static char f1718 = 5;

    /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
    private static char[] f1716 = {'m', 'a', 'x', 'S', 'd', 'k', 'g', 'l', 'o', 'b', 'C', 'n', 's', 't', 'E', 'r', ' ', 'c', 'e', 'i', 'f', 'w', 'V', 'J', 'p'};

    public dh(String str, ds dsVar) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f1726 = jSONObject;
            this.f1729 = dsVar;
            this.f1725 = jSONObject.optString(m1948("\u0000\u0001\u0001\u0000", false, new int[]{0, 4, 89, 1}).intern());
            this.f1727 = this.f1726.optString(m1948("\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0001", true, new int[]{4, 11, 140, 0}).intern());
            this.f1728 = this.f1726.optString(m1948("\u0001\u0001\u0000\u0000\u0001\u0001\u0001", true, new int[]{15, 7, 11, 0}).intern());
            this.f1720 = this.f1726.optString(m1948("\u0000\u0001\u0000\u0000\u0001\u0001", false, new int[]{22, 6, 186, 2}).intern());
            this.f1724 = this.f1726.optString(m1946((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 6, (byte) (109 - (ViewConfiguration.getKeyRepeatDelay() >> 16)), "\u0001\u0002\u0003\u0004\u0000\t").intern());
            if (this.f1726.has(m1946((ViewConfiguration.getFadingEdgeLength() >> 16) + 12, (byte) (TextUtils.getOffsetBefore("", 0) + 99), "\u0007\b\t\u0005\u0002\u0006\r\u0005\f\r\u000e\r").intern())) {
                m1947(this.f1726.optJSONObject(m1946(12 - View.combineMeasuredStates(0, 0), (byte) (99 - TextUtils.getOffsetBefore("", 0)), "\u0007\b\t\u0005\u0002\u0006\r\u0005\f\r\u000e\r").intern()));
            }
        } catch (Throwable th) {
            co.m1671(this.f1725, m1946(32 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (byte) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 58), "\n\u0013\u0012\u0005\u0010\u0011\u0012\u0010\u0010\u0003\u000e\u0012\u0010\u000b\u0011\u0012\u0006\r\r\u0010\u0012\f\u0005\u0012\u0011\u0012\u0006\r\u0018\u000f¡").intern(), th);
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ String m1945(dh dhVar) {
        int i2 = f1717;
        int i8 = i2 + 51;
        f1714 = i8 % 128;
        int i9 = i8 % 2;
        String str = dhVar.f1725;
        if (i9 == 0) {
            throw null;
        }
        int i10 = i2 + 59;
        f1714 = i10 % 128;
        if (i10 % 2 == 0) {
            int i11 = 25 / 0;
        }
        return str;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private void m1947(JSONObject jSONObject) {
        f1714 = (f1717 + 43) % 128;
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            int i2 = f1714 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE;
            f1717 = i2 % 128;
            if (i2 % 2 != 0) {
                String next = itKeys.next();
                this.f1729.m2135(next, jSONObject.opt(next));
                int i8 = 50 / 0;
            } else {
                String next2 = itKeys.next();
                this.f1729.m2135(next2, jSONObject.opt(next2));
            }
        }
    }

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    public final Map<String, dp> m1949() {
        int i2 = f1717 + 35;
        f1714 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
        if (this.f1719 == null) {
            this.f1719 = kc.m2902(this.f1726.optJSONObject(m1948("\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001", true, new int[]{28, 9, 0, 4}).intern()), new kc.b<dp>() { // from class: com.ironsource.adqualitysdk.sdk.i.dh.4
                @Override // com.ironsource.adqualitysdk.sdk.i.kc.b
                /* JADX INFO: renamed from: ﻐ */
                public final /* synthetic */ dp mo595(JSONObject jSONObject, String str) {
                    return new dp(dh.m1945(dh.this), str, jSONObject.optJSONObject(str));
                }
            });
            f1717 = (f1714 + 85) % 128;
        }
        return this.f1719;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    public final dn m1950() {
        f1717 = (f1714 + 45) % 128;
        if (this.f1723 == null) {
            this.f1723 = new dn(this.f1726.optJSONObject(m1946(10 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (byte) (44 - TextUtils.indexOf("", "", 0, 0)), "\u0017\u0010\u0007\u0018\u000f\u0013\u0016\u0018\u009f").intern()));
            f1714 = (f1717 + 67) % 128;
        }
        return this.f1723;
    }

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    public final ds m1951() {
        int i2 = f1717 + 105;
        f1714 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
        if (this.f1722 == null) {
            ds dsVar = new ds(kc.m2902(this.f1726.optJSONObject(m1946(TextUtils.lastIndexOf("", '0', 0, 0) + 7, (byte) (103 - (ViewConfiguration.getDoubleTapTimeout() >> 16)), "\u0012\u0007\f\r\u000e\r").intern()), new kc.b<Object>() { // from class: com.ironsource.adqualitysdk.sdk.i.dh.3

                /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
                private static int f1730 = 1;

                /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
                private static int f1731 = 95;

                /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
                private static int f1732;

                /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
                private static String m1958(int i8, int i9, String str, int i10, boolean z2) {
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
                                int i11 = e.f1926;
                                if (i11 >= i9) {
                                    break;
                                }
                                e.f1929 = cArr[i11];
                                cArr2[e.f1926] = (char) (e.f1929 + i8);
                                int i12 = e.f1926;
                                cArr2[i12] = (char) (cArr2[i12] - f1731);
                                e.f1926 = i12 + 1;
                            }
                            if (i10 > 0) {
                                e.f1928 = i10;
                                char[] cArr3 = new char[i9];
                                System.arraycopy(cArr2, 0, cArr3, 0, i9);
                                int i13 = e.f1928;
                                System.arraycopy(cArr3, 0, cArr2, i9 - i13, i13);
                                int i14 = e.f1928;
                                System.arraycopy(cArr3, i14, cArr2, 0, i9 - i14);
                            }
                            if (z2) {
                                char[] cArr4 = new char[i9];
                                e.f1926 = 0;
                                while (true) {
                                    int i15 = e.f1926;
                                    if (i15 >= i9) {
                                        break;
                                    }
                                    cArr4[i15] = cArr2[(i9 - i15) - 1];
                                    e.f1926 = i15 + 1;
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

                @Override // com.ironsource.adqualitysdk.sdk.i.kc.b
                /* JADX INFO: renamed from: ﻐ */
                public final Object mo595(JSONObject jSONObject, String str) {
                    String strOptString;
                    int i8 = f1730 + 75;
                    f1732 = i8 % 128;
                    try {
                        if (i8 % 2 != 0) {
                            strOptString = jSONObject.optString(str);
                            int i9 = 31 / 0;
                            if (jSONObject.opt(str) instanceof String) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(m1958((ViewConfiguration.getLongPressTimeout() >> 16) + Sdk.SDKError.Reason.EMPTY_TPAT_ERROR_VALUE, 1 - (Process.myTid() >> 22), "\u0000", 1 - (ViewConfiguration.getScrollBarSize() >> 8), true).intern());
                                sb.append(strOptString);
                                sb.append(m1958(View.resolveSizeAndState(0, 0, 0) + Sdk.SDKError.Reason.EMPTY_TPAT_ERROR_VALUE, Color.rgb(0, 0, 0) + 16777217, "\u0000", (ViewConfiguration.getKeyRepeatDelay() >> 16) + 1, true).intern());
                                strOptString = sb.toString();
                            }
                        } else {
                            strOptString = jSONObject.optString(str);
                            if (jSONObject.opt(str) instanceof String) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(m1958((ViewConfiguration.getLongPressTimeout() >> 16) + Sdk.SDKError.Reason.EMPTY_TPAT_ERROR_VALUE, 1 - (Process.myTid() >> 22), "\u0000", 1 - (ViewConfiguration.getScrollBarSize() >> 8), true).intern());
                                sb2.append(strOptString);
                                sb2.append(m1958(View.resolveSizeAndState(0, 0, 0) + Sdk.SDKError.Reason.EMPTY_TPAT_ERROR_VALUE, Color.rgb(0, 0, 0) + 16777217, "\u0000", (ViewConfiguration.getKeyRepeatDelay() >> 16) + 1, true).intern());
                                strOptString = sb2.toString();
                            }
                        }
                        String strM1945 = dh.m1945(dh.this);
                        ee eeVarM2126 = new dr(strM1945, strOptString).m2126(dt.m2140(strM1945, strOptString, strOptString));
                        f1732 = (f1730 + 35) % 128;
                        return eeVarM2126;
                    } catch (Throwable th) {
                        String strM19452 = dh.m1945(dh.this);
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(m1958(ExpandableListView.getPackedPositionGroup(0L) + 190, (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 13, "\u000f\b\uffc1￦\u0013\u0013\u0010\u0013\uffc1\u0011\u0002\u0013\u0014\n", View.resolveSize(0, 0) + 3, false).intern());
                        sb3.append(str);
                        sb3.append(m1958(TextUtils.indexOf("", "", 0) + 179, ExpandableListView.getPackedPositionGroup(0L) + 8, "\u001b\u001a\u001f ￦ￌￌ\u000f", Color.alpha(0) + 6, false).intern());
                        sb3.append(jSONObject.optString(str));
                        co.m1671(strM19452, sb3.toString(), th);
                        return null;
                    }
                }
            }), this.f1729, true);
            this.f1722 = dsVar;
            dsVar.m2137(kc.m2908(this.f1726.optJSONArray(m1946(7 - TextUtils.getCapsMode("", 0, 0), (byte) (17 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))), "\u0003\u000f\u0004\u0005\u0013\u0010\u0084").intern()), new kc.c<String>() { // from class: com.ironsource.adqualitysdk.sdk.i.dh.1
                @Override // com.ironsource.adqualitysdk.sdk.i.kc.c
                /* JADX INFO: renamed from: ｋ */
                public final /* synthetic */ String mo599(JSONArray jSONArray, int i8) {
                    return dy.m2174(jSONArray.optString(i8));
                }
            }));
        }
        ds dsVar2 = this.f1722;
        int i8 = f1714 + 99;
        f1717 = i8 % 128;
        if (i8 % 2 != 0) {
            int i9 = 97 / 0;
        }
        return dsVar2;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final String m1952() {
        int i2 = f1717;
        int i8 = i2 + 93;
        f1714 = i8 % 128;
        if (i8 % 2 == 0) {
            throw null;
        }
        String str = this.f1724;
        f1714 = (i2 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
        return str;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final String m1953() {
        int i2 = f1714;
        String str = this.f1728;
        f1717 = (i2 + 105) % 128;
        return str;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final String m1956() {
        int i2 = (f1714 + 59) % 128;
        f1717 = i2;
        String str = this.f1725;
        f1714 = (i2 + 97) % 128;
        return str;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final String m1954() {
        int i2 = f1717;
        String str = this.f1720;
        f1714 = (i2 + 67) % 128;
        return str;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final String m1957(String str) {
        Map<String, String> mapM2903;
        f1717 = (f1714 + 37) % 128;
        if (this.f1721 == null && (mapM2903 = kc.m2903(this.f1726.optJSONObject(m1948("\u0001\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0000\u0000\u0000\u0001\u0001\u0001\u0001", true, new int[]{37, 18, 6, 0}).intern()))) != null) {
            ArrayList<String> arrayList = new ArrayList(mapM2903.keySet());
            Collections.sort(arrayList, new Comparator<String>() { // from class: com.ironsource.adqualitysdk.sdk.i.dh.5
                @Override // java.util.Comparator
                public final /* synthetic */ int compare(String str2, String str3) {
                    return ka.m2874(str2, str3);
                }
            });
            String str2 = null;
            for (String str3 : arrayList) {
                if (ka.m2874(str, str3) >= 0) {
                    int i2 = f1717 + 69;
                    f1714 = i2 % 128;
                    if (i2 % 2 == 0) {
                        str2 = mapM2903.get(str3);
                        int i8 = 57 / 0;
                    } else {
                        str2 = mapM2903.get(str3);
                    }
                }
            }
            this.f1721 = str2;
        }
        return this.f1721;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final String m1955() {
        int i2 = (f1717 + 115) % 128;
        f1714 = i2;
        String str = this.f1727;
        f1717 = (i2 + 107) % 128;
        return str;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m1946(int i2, byte b8, String str) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (h.f2264) {
            try {
                char[] cArr2 = f1716;
                char c7 = f1718;
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
    private static String m1948(String str, boolean z2, int[] iArr) throws UnsupportedEncodingException {
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
                System.arraycopy(f1715, i2, cArr, 0, i8);
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
