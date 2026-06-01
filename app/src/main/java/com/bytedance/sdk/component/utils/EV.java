package com.bytedance.sdk.component.utils;

import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EV {
    private static final byte[] IlO = IlO("VP8X");

    private static byte[] IlO(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new byte[1];
        }
    }

    public static boolean IlO(byte[] bArr, int i2) {
        try {
            boolean zIlO = IlO(bArr, i2 + 12, IlO);
            int i8 = i2 + 20;
            if (bArr.length <= i8) {
                return false;
            }
            boolean z2 = (bArr[i8] & 2) == 2;
            if (zIlO && z2) {
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static boolean IlO(byte[] bArr, int i2, byte[] bArr2) {
        if (bArr2 == null || bArr == null || bArr2.length + i2 > bArr.length) {
            return false;
        }
        for (int i8 = 0; i8 < bArr2.length; i8++) {
            if (bArr[i8 + i2] != bArr2[i8]) {
                return false;
            }
        }
        return true;
    }
}
