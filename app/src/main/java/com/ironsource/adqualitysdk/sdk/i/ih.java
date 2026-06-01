package com.ironsource.adqualitysdk.sdk.i;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.vungle.ads.internal.protos.Sdk;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ih {

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static int f2528 = 1;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static char[] f2529 = {194, 207, 197, 211, 208, 202, 192, 170, 180, 172, 166, 183, 162, 129, 176, 195, 212, 196, 214, 198, 201, 177, 199, 164, 205, 136, 213, 175, 165, 179, 143, 182, 200, 204, 215, 206};

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f2530 = 0;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static boolean f2531 = true;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2532 = 97;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static boolean f2533 = true;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static void m2523(String str, String str2) {
        f2530 = (f2528 + 29) % 128;
        k.m2852(str, str2);
        f2528 = (f2530 + 3) % 128;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static void m2525(String str, String str2) {
        f2530 = (f2528 + 91) % 128;
        k.m2863(str, str2);
        int i2 = f2528 + 71;
        f2530 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m2526(String str, int i2, int[] iArr, String str2) throws UnsupportedEncodingException {
        Object bytes = str2;
        if (str2 != null) {
            bytes = str2.getBytes("ISO-8859-1");
        }
        byte[] bArr = (byte[]) bytes;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (m.f2978) {
            try {
                char[] cArr2 = f2529;
                int i8 = f2532;
                if (f2531) {
                    int length = bArr.length;
                    m.f2976 = length;
                    char[] cArr3 = new char[length];
                    m.f2977 = 0;
                    while (m.f2977 < m.f2976) {
                        int i9 = m.f2977;
                        int i10 = m.f2976 - 1;
                        int i11 = m.f2977;
                        cArr3[i9] = (char) (cArr2[bArr[i10 - i11] + i2] - i8);
                        m.f2977 = i11 + 1;
                    }
                    return new String(cArr3);
                }
                if (f2533) {
                    int length2 = cArr.length;
                    m.f2976 = length2;
                    char[] cArr4 = new char[length2];
                    m.f2977 = 0;
                    while (m.f2977 < m.f2976) {
                        int i12 = m.f2977;
                        int i13 = m.f2976 - 1;
                        int i14 = m.f2977;
                        cArr4[i12] = (char) (cArr2[cArr[i13 - i14] - i2] - i8);
                        m.f2977 = i14 + 1;
                    }
                    return new String(cArr4);
                }
                int length3 = iArr.length;
                m.f2976 = length3;
                char[] cArr5 = new char[length3];
                m.f2977 = 0;
                while (m.f2977 < m.f2976) {
                    int i15 = m.f2977;
                    int i16 = m.f2976 - 1;
                    int i17 = m.f2977;
                    cArr5[i15] = (char) (cArr2[iArr[i16 - i17] - i2] - i8);
                    m.f2977 = i17 + 1;
                }
                return new String(cArr5);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static String m2522(Context context) {
        f2528 = (f2530 + 19) % 128;
        String string = Settings.Secure.getString(context.getApplicationContext().getContentResolver(), m2526(null, 127 - ExpandableListView.getPackedPositionType(0L), null, "\u0083\u0086\u0087\u0083\u0086\u0085\u0084\u0083\u0082\u0081").intern());
        if (string == null) {
            f2528 = (f2530 + 93) % 128;
            m2525(m2526(null, 126 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), null, "\u0091\u0094\u0092\u0082\u0094\u0084\u0094\u0097\u0094\u0084\u0096\u0083\u0094\u0084\u0081\u0095\u0089\u0083\u0094\u0084\u0093\u0092\u0091\u0090\u008f\u008e\u008d\u008c\u008b\u008b\u008a\u0089\u0088").intern(), m2526(null, 128 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), null, "\u009f\u0083\u0086\u008e\u0083\u0094\u009b\u0081\u0084\u0094\u0082\u0094¡\u008e¡\u0082\u0086\u0091 \u008e\u009f\u009d\u0088\u0087\u009d\u0088\u008f\u009e\u009d\u009c\u008d\u008e\u0095\u0092\u009b\u0094\u0097\u008e\u009b\u009a\u0082\u0083\u0099\u0093\u0085\u0098").intern());
            string = m2524(context);
            f2530 = (f2528 + 71) % 128;
        }
        f2530 = (f2528 + 93) % 128;
        return string;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m2524(Context context) {
        f2528 = (f2530 + 19) % 128;
        SharedPreferences sharedPreferences = context.getSharedPreferences(m2526(null, 127 - View.MeasureSpec.getMode(0), null, "\u0090\u0083\u009f£¢\u009f\u0094\u0084\u0085\u009b\u0091").intern(), 0);
        String string = sharedPreferences.getString(m2526(null, 127 - TextUtils.getCapsMode("", 0, 0), null, "\u0083\u0086\u0083\u0094\u009b\u0081\u0084\u0094\u0082\u0094¡\u009f\u0081\u0099¤\u0085\u0085\u0091").intern(), null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String string2 = UUID.randomUUID().toString();
        sharedPreferences.edit().putString(m2526(null, 126 - TextUtils.lastIndexOf("", '0', 0, 0), null, "\u0083\u0086\u0083\u0094\u009b\u0081\u0084\u0094\u0082\u0094¡\u009f\u0081\u0099¤\u0085\u0085\u0091").intern(), string2).commit();
        f2528 = (f2530 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) % 128;
        return string2;
    }
}
