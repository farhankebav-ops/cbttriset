package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.ironsource.adqualitysdk.sdk.i.kc;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class dq {

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static int f1826 = 1;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f1827 = 94;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f1828;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private fr f1829;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private String f1830;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private String[] f1831;

    public dq(String str, String str2, JSONObject jSONObject) {
        this.f1830 = dy.m2174(str2);
        List listM2908 = kc.m2908(jSONObject.optJSONArray(m2080((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 200, View.resolveSizeAndState(0, 0, 0) + 4, "\ufff6\b￼\u0007", 1 - (ViewConfiguration.getDoubleTapTimeout() >> 16), true).intern()), new kc.c<String>() { // from class: com.ironsource.adqualitysdk.sdk.i.dq.1
            @Override // com.ironsource.adqualitysdk.sdk.i.kc.c
            /* JADX INFO: renamed from: ｋ */
            public final /* synthetic */ String mo599(JSONArray jSONArray, int i2) {
                return dy.m2174(jSONArray.optString(i2));
            }
        });
        String[] strArr = new String[listM2908.size()];
        this.f1831 = strArr;
        listM2908.toArray(strArr);
        try {
            this.f1829 = new dr(str, str2).m2125(dt.m2140(str, str2, jSONObject.optString(m2080(201 - (ViewConfiguration.getPressedStateDuration() >> 16), 4 - Color.green(0), "\ufff7\u000e\ufff9\u0004", -TextUtils.lastIndexOf("", '0'), true).intern())));
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append(m2080(189 - TextUtils.getTrimmedLength(""), TextUtils.indexOf((CharSequence) "", '0') + 22, "\u0013\u0002\u0011\uffc1\u0013\u0010\u0013\u0013￦\uffc1\u0005\u0010\t\u0015\u0006\u000e\uffc1\b\u000f\n\u0014", 9 - (ViewConfiguration.getFadingEdgeLength() >> 16), true).intern());
            sb.append(this.f1830);
            co.m1671(str, sb.toString(), th);
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private Map<String, Object> m2079(cp cpVar, List<Object> list, List<String> list2) {
        f1828 = (f1826 + 41) % 128;
        if (list.size() == list2.size()) {
            HashMap map = new HashMap();
            for (int i2 = 0; i2 < list.size(); i2++) {
                f1828 = (f1826 + 19) % 128;
                map.put(list2.get(i2), list.get(i2));
            }
            return map;
        }
        String strM1723 = cpVar.m1723();
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1830);
        sb.append(m2080((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 187, 17 - (ViewConfiguration.getEdgeSlop() >> 16), "\u0010ￃￃ\u0007\b\u0017\u0006\b\u0013\u001b\bￃ\u0007\u0012\u000b\u0017\b", TextUtils.indexOf((CharSequence) "", '0') + 3, true).intern());
        sb.append(list2.size());
        sb.append(m2080(189 - Color.alpha(0), TextUtils.getCapsMode("", 0, 0) + 24, "\u0016\u0003\uffc1\u0014\u0015\u000f\u0006\u000e\u0016\b\u0013\u0002\uffc1\uffc1\u0005\u0006\u0017\n\u0006\u0004\u0006\u0013\uffc1\u0015", (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 12, true).intern());
        sb.append(list.size());
        co.m1671(strM1723, sb.toString(), null);
        return null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final du m2081(ds dsVar, cp cpVar, List<Object> list) {
        ds dsVar2 = new ds(m2079(cpVar, list, Arrays.asList(this.f1831)), dsVar.m2134());
        fr frVar = this.f1829;
        if (frVar != null) {
            int i2 = f1826 + 49;
            f1828 = i2 % 128;
            if (i2 % 2 == 0) {
                return frVar.mo2225(dsVar2, cpVar);
            }
            frVar.mo2225(dsVar2, cpVar);
            throw null;
        }
        String strM1723 = cpVar.m1723();
        StringBuilder sb = new StringBuilder();
        sb.append(m2080(Color.red(0) + 185, 7 - Drawable.resolveOpacity(0, 0), "\r\u0019\n\ufff2ￅ\t\u0014", 4 - ExpandableListView.getPackedPositionGroup(0L), true).intern());
        sb.append(this.f1830);
        sb.append(m2080(TextUtils.lastIndexOf("", '0', 0) + 186, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 13, "\u001e\t\u0014\u0007ￅ\u0011\u0011\u001a\u0013ￅ\u0018\u0006\rￅ", 14 - TextUtils.indexOf("", "", 0), true).intern());
        co.m1671(strM1723, sb.toString(), null);
        f1828 = (f1826 + 107) % 128;
        return null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final String m2082() {
        int i2 = f1828;
        String str = this.f1830;
        f1826 = (i2 + 47) % 128;
        return str;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m2080(int i2, int i8, String str, int i9, boolean z2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (e.f1927) {
            try {
                char[] cArr2 = new char[i8];
                e.f1926 = 0;
                while (true) {
                    int i10 = e.f1926;
                    if (i10 >= i8) {
                        break;
                    }
                    e.f1929 = cArr[i10];
                    cArr2[e.f1926] = (char) (e.f1929 + i2);
                    int i11 = e.f1926;
                    cArr2[i11] = (char) (cArr2[i11] - f1827);
                    e.f1926 = i11 + 1;
                }
                if (i9 > 0) {
                    e.f1928 = i9;
                    char[] cArr3 = new char[i8];
                    System.arraycopy(cArr2, 0, cArr3, 0, i8);
                    int i12 = e.f1928;
                    System.arraycopy(cArr3, 0, cArr2, i8 - i12, i12);
                    int i13 = e.f1928;
                    System.arraycopy(cArr3, i13, cArr2, 0, i8 - i13);
                }
                if (z2) {
                    char[] cArr4 = new char[i8];
                    e.f1926 = 0;
                    while (true) {
                        int i14 = e.f1926;
                        if (i14 >= i8) {
                            break;
                        }
                        cArr4[i14] = cArr2[(i8 - i14) - 1];
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
}
