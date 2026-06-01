package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.vungle.ads.internal.protos.Sdk;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class dn {

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static int f1797 = 1;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static char f1798 = 5;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static char[] f1799 = {'w', 'r', 'a', 'p', 'e', 'c', 'o', 'm', 'n', 'x', 't', 'b', 'v', 'i', 'u', 's', 'E', 'J', 'y', 'z', '{', '|', '}', '~', 127};

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static int f1800;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private String f1801;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private String f1802;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private String f1803;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private String f1804;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private boolean f1805;

    public dn(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f1804 = jSONObject.optString(m2060(7 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (byte) (37 - ImageFormat.getBitsPerPixel(0)), "\u0001\u0002\u0003\u0004\u0004\u0000\u0098").intern());
            this.f1802 = jSONObject.optString(m2060((ViewConfiguration.getKeyRepeatDelay() >> 16) + 6, (byte) (AndroidCharacter.getMirror('0') - 19), "\u0006\u0007\u008a\u008a\u0007\t").intern());
            this.f1803 = jSONObject.optString(m2060(5 - Color.green(0), (byte) (57 - MotionEvent.axisFromString("")), "\t\u000e\u000b\u0000\u009b").intern());
            this.f1801 = jSONObject.optString(m2060(7 - (ViewConfiguration.getPressedStateDuration() >> 16), (byte) (KeyEvent.keyCodeFromString("") + 53), "\u0001\u0000\f\r\u000e\u0003¬").intern());
            this.f1805 = jSONObject.optBoolean(m2060((ViewConfiguration.getPressedStateDuration() >> 16) + 10, (byte) (TextUtils.indexOf((CharSequence) "", '0', 0) + 95), "\n\u0013\u0001\u0013\u0005\u000e\u0002\u0003\u0012\u0010").intern());
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final boolean m2061() {
        int i2 = f1797 + 35;
        f1800 = i2 % 128;
        if (i2 % 2 == 0) {
            return this.f1805;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final String m2062() {
        int i2 = f1797;
        String str = this.f1804;
        int i8 = i2 + 45;
        f1800 = i8 % 128;
        if (i8 % 2 == 0) {
            return str;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final String m2063() {
        int i2 = f1800;
        int i8 = i2 + 17;
        f1797 = i8 % 128;
        if (i8 % 2 == 0) {
            throw null;
        }
        String str = this.f1801;
        int i9 = i2 + 9;
        f1797 = i9 % 128;
        if (i9 % 2 != 0) {
            return str;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final String m2064() {
        int i2 = f1797;
        int i8 = i2 + 5;
        f1800 = i8 % 128;
        if (i8 % 2 != 0) {
            throw null;
        }
        String str = this.f1803;
        int i9 = i2 + 91;
        f1800 = i9 % 128;
        if (i9 % 2 == 0) {
            return str;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final String m2065() {
        int i2 = (f1800 + 75) % 128;
        f1797 = i2;
        String str = this.f1802;
        int i8 = i2 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE;
        f1800 = i8 % 128;
        if (i8 % 2 != 0) {
            int i9 = 20 / 0;
        }
        return str;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m2060(int i2, byte b8, String str) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (h.f2264) {
            try {
                char[] cArr2 = f1799;
                char c7 = f1798;
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
}
