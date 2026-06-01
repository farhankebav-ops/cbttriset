package com.ironsource;

import android.text.TextUtils;
import android.util.Base64;
import com.bumptech.glide.load.Key;
import com.ironsource.mediationsdk.logger.IronLog;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class L9 {
    public static synchronized String a(String str) {
        return a(C2499p5.b().c(), str);
    }

    public static synchronized String b(String str) {
        return d(C2499p5.b().c(), str);
    }

    public static synchronized String c(String str) {
        return e(C2499p5.b().c(), str);
    }

    public static synchronized String d(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            byte[] bArrC = c(str, str2);
            if (bArrC != null) {
                return S9.a(bArrC);
            }
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        return "";
    }

    public static synchronized String e(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            return a(str, str2.getBytes("UTF8"));
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return "";
        }
    }

    public static synchronized String a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            byte[] bArrA = S9.a(str2);
            if (bArrA != null) {
                return a(str, bArrA);
            }
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        return "";
    }

    public static synchronized String b(String str, String str2) {
        byte[] bArrC = c(str, str2);
        if (bArrC == null) {
            return "";
        }
        return new String(bArrC);
    }

    public static synchronized byte[] c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            SecretKeySpec secretKeySpecD = d(str);
            byte[] bArr = new byte[16];
            Arrays.fill(bArr, (byte) 0);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
            byte[] bArrDecode = Base64.decode(str2, 0);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(2, secretKeySpecD, ivParameterSpec);
            return cipher.doFinal(bArrDecode);
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error("exception on decryption error: " + e.getMessage());
            return null;
        }
    }

    private static SecretKeySpec d(String str) throws UnsupportedEncodingException {
        byte[] bArr = new byte[32];
        Arrays.fill(bArr, (byte) 0);
        byte[] bytes = str.getBytes(Key.STRING_CHARSET_NAME);
        System.arraycopy(bytes, 0, bArr, 0, bytes.length < 32 ? bytes.length : 32);
        return new SecretKeySpec(bArr, "AES");
    }

    public static synchronized String a(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (bArr == null) {
            return "";
        }
        try {
            SecretKeySpec secretKeySpecD = d(str);
            byte[] bArr2 = new byte[16];
            Arrays.fill(bArr2, (byte) 0);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(1, secretKeySpecD, ivParameterSpec);
            return Base64.encodeToString(cipher.doFinal(bArr), 0).replaceAll(System.getProperty("line.separator"), "");
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return "";
        }
    }
}
