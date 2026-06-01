package com.ironsource.adqualitysdk.sdk.i;

import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class je {

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static int f2767 = 0;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static int f2768 = 1;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static long f2769 = 0;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static char f2770 = 3265;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2771;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private JSONObject f2772;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private String f2773;

    public je(JSONObject jSONObject) {
        this(jSONObject, UUID.randomUUID().toString());
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final String m2682() {
        int i2 = f2768 + 99;
        f2767 = i2 % 128;
        if (i2 % 2 == 0) {
            return this.f2773;
        }
        int i8 = 79 / 0;
        return this.f2773;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final JSONObject m2683() {
        int i2 = f2768 + 93;
        int i8 = i2 % 128;
        f2767 = i8;
        if (i2 % 2 != 0) {
            throw null;
        }
        JSONObject jSONObject = this.f2772;
        int i9 = i8 + 43;
        f2768 = i9 % 128;
        if (i9 % 2 == 0) {
            int i10 = 12 / 0;
        }
        return jSONObject;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final JSONObject m2684() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(m2681("Ⲑ麊ন\uf6cc", (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1), "溮\udfc6㓳\udaa1⢈\udcff࠱꼫", ViewConfiguration.getEdgeSlop() >> 16, "\u0000\u0000\u0000\u0000").intern(), this.f2772);
        jSONObject.put(m2681("\uef2e㝷纁\ue998", (char) (39038 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1))), "\ue144㞥䤯ᔾ", KeyEvent.keyCodeFromString(""), "\u0000\u0000\u0000\u0000").intern(), this.f2773);
        int i2 = f2767 + 91;
        f2768 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 45 / 0;
        }
        return jSONObject;
    }

    public je(JSONObject jSONObject, String str) {
        this.f2772 = jSONObject;
        this.f2773 = str;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m2681(String str, char c7, String str2, int i2, String str3) {
        String str4;
        Object charArray = str3;
        if (str3 != null) {
            charArray = str3.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        Object charArray2 = str2;
        if (str2 != null) {
            charArray2 = str2.toCharArray();
        }
        char[] cArr2 = (char[]) charArray2;
        Object charArray3 = str;
        if (str != null) {
            charArray3 = str.toCharArray();
        }
        char[] cArr3 = (char[]) charArray3;
        synchronized (f.f2031) {
            try {
                char[] cArr4 = (char[]) cArr3.clone();
                char[] cArr5 = (char[]) cArr.clone();
                cArr4[0] = (char) (c7 ^ cArr4[0]);
                cArr5[2] = (char) (cArr5[2] + ((char) i2));
                int length = cArr2.length;
                char[] cArr6 = new char[length];
                f.f2032 = 0;
                while (true) {
                    int i8 = f.f2032;
                    if (i8 < length) {
                        int i9 = (i8 + 2) % 4;
                        int i10 = (i8 + 3) % 4;
                        int i11 = cArr4[i8 % 4] * 32718;
                        char c8 = cArr5[i9];
                        char c9 = (char) ((i11 + c8) % 65535);
                        f.f2030 = c9;
                        cArr5[i10] = (char) com.google.android.gms.ads.internal.client.a.w(cArr4[i10], 32718, c8, 65535);
                        cArr4[i10] = c9;
                        int i12 = f.f2032;
                        cArr6[i12] = (char) (((((long) (c9 ^ cArr2[i12])) ^ f2769) ^ ((long) f2771)) ^ ((long) f2770));
                        f.f2032 = i12 + 1;
                    } else {
                        str4 = new String(cArr6);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str4;
    }
}
