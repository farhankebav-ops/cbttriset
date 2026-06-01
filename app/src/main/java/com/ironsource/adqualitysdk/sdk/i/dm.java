package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.ironsource.adqualitysdk.sdk.ISAdQualityAdType;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class dm {

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static int f1788 = 0;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static int f1789 = 1;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static int f1790 = 138;

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private String f1791;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private ISAdQualityAdType f1792;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private String f1793;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private JSONObject f1794;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private String f1795;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private List<String> f1796;

    public dm(JSONObject jSONObject) {
        this.f1792 = ISAdQualityAdType.UNKNOWN;
        this.f1793 = dy.m2174(jSONObject.optString(m2053(KeyEvent.getDeadChar(0, 0) + 250, (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 4, "\u0004\t\u0000\ufff5", (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 3, false).intern()));
        String strM2174 = dy.m2174(jSONObject.optString(m2053(240 - (ViewConfiguration.getScrollBarSize() >> 8), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 5, "\u0013\n\uffff\ufffb\ufffe￮", 3 - View.MeasureSpec.getMode(0), false).intern()));
        if (!TextUtils.isEmpty(strM2174)) {
            this.f1792 = ISAdQualityAdType.fromInt(Integer.parseInt(strM2174));
        }
        this.f1794 = jSONObject.optJSONObject(m2053(245 - Color.blue(0), 7 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), "\u0007\ufff6\u0005\b\u0002\ufff6", TextUtils.indexOf("", "") + 3, true).intern());
        this.f1796 = kc.m2901(jSONObject, m2053(245 - (Process.myTid() >> 22), (Process.myTid() >> 22) + 10, "\b\ufffa\ufffe\t\ufffe\u000b\ufffe\t\ufff8\ufff6", Drawable.resolveOpacity(0, 0) + 10, true).intern(), new ArrayList());
        this.f1795 = dy.m2174(jSONObject.optString(m2053(243 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 11 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), "\u0003\u000b￼\t\r\u0000￼\u000e\uffdd\u0000", 3 - TextUtils.lastIndexOf("", '0', 0), false).intern()));
        this.f1791 = dy.m2174(jSONObject.optString(m2053((ViewConfiguration.getScrollDefaultDelay() >> 16) + 242, View.resolveSize(0, 0) + 14, "\u000f\u000b\uffdf�\f\f�\n\u000f�\ufffa￮\u0001�", 8 - ExpandableListView.getPackedPositionType(0L), false).intern()));
    }

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    public final String m2054() {
        int i2 = f1789;
        String str = this.f1791;
        f1788 = (i2 + 81) % 128;
        return str;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final List<String> m2055() {
        int i2 = f1788;
        int i8 = i2 + 95;
        f1789 = i8 % 128;
        if (i8 % 2 == 0) {
            throw null;
        }
        List<String> list = this.f1796;
        f1789 = (i2 + 65) % 128;
        return list;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final String m2056() {
        String str;
        int i2 = f1789;
        int i8 = i2 + 27;
        f1788 = i8 % 128;
        if (i8 % 2 != 0) {
            str = this.f1795;
            int i9 = 20 / 0;
        } else {
            str = this.f1795;
        }
        int i10 = i2 + 49;
        f1788 = i10 % 128;
        if (i10 % 2 == 0) {
            return str;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final ISAdQualityAdType m2057() {
        int i2 = f1789 + 81;
        f1788 = i2 % 128;
        if (i2 % 2 == 0) {
            return this.f1792;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final String m2058() {
        int i2 = f1788 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE;
        int i8 = i2 % 128;
        f1789 = i8;
        if (i2 % 2 == 0) {
            throw null;
        }
        String str = this.f1793;
        int i9 = i8 + 5;
        f1788 = i9 % 128;
        if (i9 % 2 != 0) {
            int i10 = 6 / 0;
        }
        return str;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final JSONObject m2059() {
        int i2 = (f1789 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE) % 128;
        f1788 = i2;
        JSONObject jSONObject = this.f1794;
        f1789 = (i2 + 99) % 128;
        return jSONObject;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m2053(int i2, int i8, String str, int i9, boolean z2) {
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
                    cArr2[i11] = (char) (cArr2[i11] - f1790);
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
