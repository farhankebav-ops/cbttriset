package com.facebook.ads.internal.util.common;

import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Base64;
import androidx.annotation.Nullable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class FbValidationUtils {
    public static final String DEBUG_FB_PACKAGE = "com.facebook.wakizashi";
    public static final String FB4A_SHA256_HASH = "4/nh4M+Z0OVqBVumXiQbM5n3zqUkMmsM3W7BMn7Q/cE=";
    public static final String FB_PACKAGE = "com.facebook.katana";

    private static String calculateSHA256Fingerprint(byte[] bArr) throws NoSuchAlgorithmException {
        return Base64.encodeToString(MessageDigest.getInstance("SHA256").digest(bArr), 2);
    }

    public static String getSigningCertificate(@Nullable PackageInfo packageInfo) {
        if (packageInfo == null) {
            return "";
        }
        try {
            Signature[] signatureArr = packageInfo.signatures;
            return signatureArr.length == 0 ? "" : calculateSHA256Fingerprint(signatureArr[0].toByteArray());
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static boolean isFbSigningCertificateValid(String str) {
        return isFbSigningCertificateValid(str, FB4A_SHA256_HASH);
    }

    public static boolean isFbSigningCertificateValid(String str, String str2) {
        return str2.equals(str);
    }
}
