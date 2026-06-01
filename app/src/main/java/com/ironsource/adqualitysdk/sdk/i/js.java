package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import com.vungle.ads.internal.protos.Sdk;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class js {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static char f2883 = 6;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f2884 = 0;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2885 = 1;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static char[] f2886 = {'f', 's', 'a', 'u', 't', 'i', 'd', 'p', 'A', 'Q', 'l', 'y', 'S', 'D', 'K', 'E', 'v', 'e', 'n', 'G', 'r', 'o', ' ', 'g', '/', 'm', 'j', 'h', 'k', 'q', 'w', 'x', 'z', '{', '|', '}'};

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static JSONObject m2765(String str, aw awVar, boolean z2, as asVar) {
        JSONObject jSONObject = new JSONObject();
        if (z2) {
            try {
                jSONObject.put(m2764(3 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (byte) ((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 79), "\u0001\u0002").intern(), true);
            } catch (JSONException e) {
                k.m2861(m2764(26 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (byte) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 113), "\t\u0007\u000f\t\u0004\b\u0000\u0005\u0006\u0011\u000e\u000f\u0010\u0011\f\u0017\u0001\u0016\f\u0017\u000e\u0017\u0003\u0005\u0016\u0015").intern(), m2764(51 - View.resolveSizeAndState(0, 0, 0), (byte) (View.combineMeasuredStates(0, 0) + 3), "\u000e\u0015\u0015\u0016\u0015\u0017\u0000\b\u000b\u0000\u0013\u0012\u0012\u0004\u0002\u0017\u0002\u0005\u0017\u0004\u0013\u0000\u0005\u0003oo\u001c\u0006\u0003\u0002\n\u001c\u0001\t\b\u0000\u0005\u0010\u001c\n\u0001\u001d\u0010\u0017\u0003\u0016\u0014\u001c\u0003\u0013q").intern(), (Throwable) e);
            }
        }
        if (asVar.m616()) {
            f2885 = (f2884 + 61) % 128;
            jSONObject.put(m2764(5 - Color.blue(0), (byte) (TextUtils.indexOf("", "") + 104), "\u0003\u0004\u0005\u0000Ì").intern(), true);
        }
        jSONObject.put(m2764((ViewConfiguration.getTapTimeout() >> 16) + 4, (byte) ((ViewConfiguration.getLongPressTimeout() >> 16) + 108), "\t\u0001\u0000\u000b").intern(), str);
        f2885 = (f2884 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) % 128;
        kc.m2910(jSONObject, awVar.m706());
        kc.m2910(jSONObject, awVar.m708());
        return jSONObject;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m2764(int i2, byte b8, String str) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (h.f2264) {
            try {
                char[] cArr2 = f2886;
                char c7 = f2883;
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
