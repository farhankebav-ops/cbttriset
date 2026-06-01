package com.bytedance.adsdk.ugeno.yoga;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class DmF {
    public static long IlO(float f4, float f8) {
        return ((long) Float.floatToRawIntBits(f8)) | (((long) Float.floatToRawIntBits(f4)) << 32);
    }

    public static long IlO(int i2, int i8) {
        return IlO(i2, i8);
    }
}
