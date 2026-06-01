package com.bytedance.sdk.component.utils;

import a1.a;
import android.os.Build;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import java.security.SecureRandom;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {

    /* JADX INFO: renamed from: com.bytedance.sdk.component.utils.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class C0059IlO {
        static final Random IlO = IlO.EO();
    }

    public static String EO(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 49) {
            return str;
        }
        String strIlO = IlO(str.substring(1, 33), 32);
        String strSubstring = str.substring(33, 49);
        return (strSubstring == null || strIlO == null) ? str : com.bytedance.sdk.component.tV.IlO.MY(str.substring(49), strSubstring, strIlO);
    }

    public static JSONObject IlO(JSONObject jSONObject) {
        return jSONObject == null ? new JSONObject() : IlO(jSONObject.toString());
    }

    public static String MY(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strIlO = IlO();
        String strIlO2 = IlO(strIlO, 32);
        String strMY = MY();
        return a.n(ExifInterface.GPS_MEASUREMENT_3D, strIlO, strMY, (strIlO2 == null || strMY == null) ? null : com.bytedance.sdk.component.tV.IlO.IlO(str, strMY, strIlO2));
    }

    public static JSONObject IlO(String str) {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(str)) {
            try {
                try {
                    String strMY = MY(str);
                    if (!TextUtils.isEmpty(strMY)) {
                        jSONObject.put("message", strMY);
                        jSONObject.put("cypher", 3);
                        return jSONObject;
                    }
                    jSONObject.put("message", str);
                    jSONObject.put("cypher", 0);
                    return jSONObject;
                } catch (Throwable unused) {
                    jSONObject.put("message", str);
                    jSONObject.put("cypher", 0);
                    return jSONObject;
                }
            } catch (Throwable th) {
                th.getMessage();
            }
        }
        return jSONObject;
    }

    public static Random EO() {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                return SecureRandom.getInstanceStrong();
            } catch (Throwable unused) {
                return new SecureRandom();
            }
        }
        return new SecureRandom();
    }

    public static String IlO() {
        String strIlO = IlO(16);
        if (strIlO == null || strIlO.length() != 32) {
            return null;
        }
        return strIlO;
    }

    public static String MY() {
        String strIlO = IlO(8);
        if (strIlO == null || strIlO.length() != 16) {
            return null;
        }
        return strIlO;
    }

    public static String IlO(String str, int i2) {
        if (str == null || str.length() != i2) {
            return null;
        }
        int i8 = i2 / 2;
        return str.substring(i8, i2) + str.substring(0, i8);
    }

    public static String IlO(int i2) {
        try {
            byte[] bArr = new byte[i2];
            C0059IlO.IlO.nextBytes(bArr);
            return Cc.IlO(bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
