package com.bytedance.sdk.component.embedapplog;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class PangleEncryptUtils {
    static {
        try {
            System.loadLibrary("tobEmbedPagEncrypt");
        } catch (UnsatisfiedLinkError e) {
            Log.e("pangle-encrypt", e.getMessage());
        }
    }

    public static byte[] decrypt(byte[] bArr, int i2) {
        try {
            return ttDecrypt(bArr, i2);
        } catch (Throwable th) {
            Log.e("pangle-encrypt", "decrypt exception " + th.getMessage());
            return null;
        }
    }

    public static byte[] encrypt(byte[] bArr, int i2) {
        try {
            return ttEncrypt(bArr, i2);
        } catch (Throwable th) {
            Log.e("pangle-encrypt", "encrypt exception " + th.getMessage());
            return null;
        }
    }

    private static native byte[] ttDecrypt(byte[] bArr, int i2);

    private static native byte[] ttEncrypt(byte[] bArr, int i2);
}
