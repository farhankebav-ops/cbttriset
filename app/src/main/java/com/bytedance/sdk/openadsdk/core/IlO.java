package com.bytedance.sdk.openadsdk.core;

import android.util.Base64;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class IlO {
    private static final String IlO = EO();
    private static final String MY = cl.tV().EO();

    private static String EO() {
        char[] cArr = {203, 182, 168, 176, 207, 148, 149, 178, 205, 182, 149, 166, 134, 178, 184, 176, 206, 174, 187, 178, 150, 185, 167, 166};
        char[] cArr2 = new char[24];
        for (int i2 = 23; i2 >= 0; i2--) {
            cArr2[23 - i2] = (char) (cArr[i2] ^ 255);
        }
        return new String(cArr2);
    }

    public static String IlO() {
        return new String(Base64.decode(IlO, 0)).substring(2);
    }

    public static String MY() {
        return new String(Base64.decode(MY, 0)).substring(2);
    }
}
