package com.bytedance.sdk.openadsdk.utils;

import java.security.SecureRandom;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class pP {
    private static final ThreadLocal<SecureRandom> IlO = new ThreadLocal<>();

    public static String IlO() {
        byte[] bArr = new byte[16];
        ThreadLocal<SecureRandom> threadLocal = IlO;
        SecureRandom secureRandom = threadLocal.get();
        if (secureRandom == null) {
            secureRandom = new SecureRandom();
            threadLocal.set(secureRandom);
        }
        secureRandom.nextBytes(bArr);
        byte b8 = (byte) (bArr[6] & 15);
        bArr[6] = b8;
        bArr[6] = (byte) (b8 | 64);
        byte b9 = (byte) (bArr[8] & 63);
        bArr[8] = b9;
        bArr[8] = (byte) (b9 | 128);
        long j = 0;
        long j3 = 0;
        for (int i2 = 0; i2 < 8; i2++) {
            j3 = (j3 << 8) | ((long) (bArr[i2] & 255));
        }
        for (int i8 = 8; i8 < 16; i8++) {
            j = (j << 8) | ((long) (bArr[i8] & 255));
        }
        return new UUID(j3, j).toString();
    }
}
