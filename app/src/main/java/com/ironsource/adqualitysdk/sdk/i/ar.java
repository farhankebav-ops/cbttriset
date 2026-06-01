package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.ironsource.adqualitysdk.sdk.i.aq;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ar extends aq.AnonymousClass1 {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f414 = 1;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f417;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private final int f418 = (int) TimeUnit.SECONDS.toMillis(120);

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int[] f416 = {2089360450, -1179128170, -1289311320, 1734615361, -1791190540, 615014278, 144141020, 1857450806, 1974857075, -38114740, 646624792, 1475090293, 777460066, 1250427740, -721861962, 1742615024, 1254257618, 677994917};

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static long f415 = -4163521717169148991L;

    public ar(ax axVar) {
        m600(new int[]{-360766167, 1926551849, 1504456421, -1301286124}, (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 7).intern();
        m601("⮤ဈ峮饍씡Ɗ买訬\uf69a", 15269 - Color.red(0)).intern();
        m566(axVar);
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    public final long m602() {
        f417 = (f414 + 37) % 128;
        long jOptLong = m565().optLong(m600(new int[]{1194568379, 208661044}, 3 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))).intern(), 0L);
        int i2 = f417 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE;
        f414 = i2 % 128;
        if (i2 % 2 != 0) {
            return jOptLong;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    public final String m603() {
        f414 = (f417 + 113) % 128;
        JSONObject jSONObjectOptJSONObject = m565().optJSONObject(m601("⮴埔퍣", KeyEvent.keyCodeFromString("") + 31847).intern());
        if (jSONObjectOptJSONObject == null) {
            return m600(new int[]{-360766167, 1926551849, 1504456421, -1301286124}, 7 - ((Process.getThreadPriority(0) + 20) >> 6)).intern();
        }
        int i2 = f417 + 89;
        f414 = i2 % 128;
        return i2 % 2 == 0 ? jSONObjectOptJSONObject.optString(m601("⮱", 13765 >>> ExpandableListView.getPackedPositionType(0L)).intern(), m600(new int[]{-360766167, 1926551849, 1504456421, -1301286124}, (ViewConfiguration.getDoubleTapTimeout() % 88) * 62).intern()) : jSONObjectOptJSONObject.optString(m601("⮱", 7529 - ExpandableListView.getPackedPositionType(0L)).intern(), m600(new int[]{-360766167, 1926551849, 1504456421, -1301286124}, 7 - (ViewConfiguration.getDoubleTapTimeout() >> 16)).intern());
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    public final long m604() {
        JSONObject jSONObjectM565;
        String strIntern;
        long j;
        int i2 = f417 + 57;
        f414 = i2 % 128;
        if (i2 % 2 == 0) {
            jSONObjectM565 = m565();
            strIntern = m600(new int[]{458384271, -1112428692}, 3 >> Color.green(1)).intern();
            j = 1;
        } else {
            jSONObjectM565 = m565();
            strIntern = m600(new int[]{458384271, -1112428692}, 3 - Color.green(0)).intern();
            j = 0;
        }
        return jSONObjectM565.optLong(strIntern, j);
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    public final long m605() {
        JSONObject jSONObjectM565;
        String strIntern;
        long j;
        int i2 = f417 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE;
        f414 = i2 % 128;
        if (i2 % 2 == 0) {
            jSONObjectM565 = m565();
            strIntern = m600(new int[]{1796884369, -1734959409}, 2 % ((Process.getThreadPriority(0) >> 91) >> 56)).intern();
            j = 1;
        } else {
            jSONObjectM565 = m565();
            strIntern = m600(new int[]{1796884369, -1734959409}, 2 - ((Process.getThreadPriority(0) + 20) >> 6)).intern();
            j = 0;
        }
        return jSONObjectM565.optLong(strIntern, j);
    }

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    public final String m606() {
        JSONObject jSONObjectOptJSONObject;
        int i2 = f417 + 115;
        f414 = i2 % 128;
        if (i2 % 2 != 0 ? (jSONObjectOptJSONObject = m565().optJSONObject(m601("⮴埔퍣", 31847 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))).intern())) != null : (jSONObjectOptJSONObject = m565().optJSONObject(m601("⮴埔퍣", (ExpandableListView.getPackedPositionForGroup(1) > 1L ? 1 : (ExpandableListView.getPackedPositionForGroup(1) == 1L ? 0 : -1)) * 26162).intern())) != null) {
            return jSONObjectOptJSONObject.optString(m600(new int[]{1551814106, 1394714337}, View.MeasureSpec.getMode(0) + 1).intern(), m601("⮤ဈ峮饍씡Ɗ买訬\uf69a", (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 15269).intern());
        }
        String strIntern = m601("⮤ဈ峮饍씡Ɗ买訬\uf69a", 15269 - Color.alpha(0)).intern();
        int i8 = f414 + 19;
        f417 = i8 % 128;
        if (i8 % 2 == 0) {
            return strIntern;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final int m607() {
        f414 = (f417 + 61) % 128;
        int iOptInt = m565().optInt(m600(new int[]{-319893108, 814841533}, Color.rgb(0, 0, 0) + 16777219).intern(), 40);
        int i2 = f414 + 97;
        f417 = i2 % 128;
        if (i2 % 2 == 0) {
            return iOptInt;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final int m608() {
        JSONObject jSONObjectM565;
        String strM600;
        int i2 = f417 + 65;
        f414 = i2 % 128;
        if (i2 % 2 == 0) {
            jSONObjectM565 = m565();
            Process.getThreadPriority(0);
            strM600 = m600(new int[]{2018397849, 238262043}, 2);
        } else {
            jSONObjectM565 = m565();
            strM600 = m600(new int[]{2018397849, 238262043}, 3 - ((Process.getThreadPriority(0) + 20) >> 6));
        }
        return jSONObjectM565.optInt(strM600.intern(), this.f418);
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final List<String> m609() {
        List<String> listM729 = m564().m729();
        listM729.addAll(kc.m2901(m565(), m601("⮤偈\udc43", 31741 - Drawable.resolveOpacity(0, 0)).intern(), new ArrayList()));
        int i2 = f414 + 67;
        f417 = i2 % 128;
        if (i2 % 2 == 0) {
            return listM729;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final int m610() {
        JSONObject jSONObjectM565;
        String strIntern;
        int i2;
        int i8 = f414 + 3;
        f417 = i8 % 128;
        if (i8 % 2 != 0) {
            jSONObjectM565 = m565();
            strIntern = m600(new int[]{472075682, -55888423}, View.getDefaultSize(0, 0) + 5).intern();
            i2 = 9280;
        } else {
            jSONObjectM565 = m565();
            strIntern = m600(new int[]{472075682, -55888423}, View.getDefaultSize(0, 0) + 3).intern();
            i2 = 9850;
        }
        return jSONObjectM565.optInt(strIntern, i2);
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final List<String> m611() {
        List<String> listM734 = m564().m734();
        listM734.addAll(kc.m2901(m565(), m601("⮧⅘㹣", (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 2797).intern(), new ArrayList()));
        int i2 = f417 + 103;
        f414 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 11 / 0;
        }
        return listM734;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m600(int[] iArr, int i2) {
        String str;
        synchronized (d.f1664) {
            try {
                char[] cArr = new char[4];
                char[] cArr2 = new char[iArr.length << 1];
                int[] iArr2 = (int[]) f416.clone();
                d.f1665 = 0;
                while (true) {
                    int i8 = d.f1665;
                    if (i8 < iArr.length) {
                        int i9 = iArr[i8];
                        char c7 = (char) (i9 >> 16);
                        cArr[0] = c7;
                        char c8 = (char) i9;
                        cArr[1] = c8;
                        char c9 = (char) (iArr[i8 + 1] >> 16);
                        cArr[2] = c9;
                        char c10 = (char) iArr[i8 + 1];
                        cArr[3] = c10;
                        d.f1663 = (c7 << 16) + c8;
                        d.f1666 = (c9 << 16) + c10;
                        d.m1895(iArr2);
                        for (int i10 = 0; i10 < 16; i10++) {
                            int i11 = d.f1663 ^ iArr2[i10];
                            d.f1663 = i11;
                            int iM1894 = d.m1894(i11) ^ d.f1666;
                            int i12 = d.f1663;
                            d.f1663 = iM1894;
                            d.f1666 = i12;
                        }
                        int i13 = d.f1663;
                        int i14 = d.f1666;
                        d.f1663 = i14;
                        d.f1666 = i13;
                        int i15 = i13 ^ iArr2[16];
                        d.f1666 = i15;
                        int i16 = i14 ^ iArr2[17];
                        d.f1663 = i16;
                        cArr[0] = (char) (i16 >>> 16);
                        cArr[1] = (char) i16;
                        cArr[2] = (char) (i15 >>> 16);
                        cArr[3] = (char) i15;
                        d.m1895(iArr2);
                        int i17 = d.f1665;
                        cArr2[i17 << 1] = cArr[0];
                        cArr2[(i17 << 1) + 1] = cArr[1];
                        cArr2[(i17 << 1) + 2] = cArr[2];
                        cArr2[(i17 << 1) + 3] = cArr[3];
                        d.f1665 = i17 + 2;
                    } else {
                        str = new String(cArr2, 0, i2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m601(String str, int i2) {
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
                        cArr2[i8] = (char) (((long) (cArr[i8] ^ (j.f2669 * i8))) ^ f415);
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
