package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.ImageFormat;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.ironsource.adqualitysdk.sdk.i.aq;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ao extends aq.AnonymousClass1 {

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f360 = 160;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f361 = 1;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f362;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final Object m522(String str) {
        f361 = (f362 + 19) % 128;
        JSONObject jSONObjectM523 = m523();
        if (jSONObjectM523 == null) {
            int i2 = f362 + 69;
            f361 = i2 % 128;
            if (i2 % 2 == 0) {
                int i8 = 36 / 0;
            }
            return null;
        }
        Object objOpt = jSONObjectM523.opt(str);
        int i9 = f362 + 99;
        f361 = i9 % 128;
        if (i9 % 2 != 0) {
            return objOpt;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final JSONObject m523() {
        f362 = (f361 + 9) % 128;
        JSONObject jSONObjectOptJSONObject = m565().optJSONObject(m521((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 270, 6 - View.MeasureSpec.getSize(0), "\u0006\ufffb\ufff3\u0004\u0006\u0005", 4 - ImageFormat.getBitsPerPixel(0), true).intern());
        f362 = (f361 + 47) % 128;
        return jSONObjectOptJSONObject;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final String m524() {
        JSONObject jSONObjectM565;
        String strM521;
        int i2 = f362 + 109;
        f361 = i2 % 128;
        if (i2 % 2 == 0) {
            jSONObjectM565 = m565();
            strM521 = m521(2650 >>> TextUtils.indexOf("", ""), 5 >> TextUtils.lastIndexOf("", 'd', 1, 1), "\ufff6\u0005\u0005", 4 >> ((byte) KeyEvent.getModifierMetaStateMask()), true);
        } else {
            jSONObjectM565 = m565();
            strM521 = m521(TextUtils.indexOf("", "") + 271, 2 - TextUtils.lastIndexOf("", '0', 0, 0), "\ufff6\u0005\u0005", ((byte) KeyEvent.getModifierMetaStateMask()) + 4, false);
        }
        return jSONObjectM565.optString(strM521.intern());
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m521(int i2, int i8, String str, int i9, boolean z2) {
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
                    cArr2[i11] = (char) (cArr2[i11] - f360);
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
