package com.bytedance.adsdk.ugeno.Bc;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class EO {
    public static float IlO(String str, float f4) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return f4;
        }
    }

    public static int IlO(String str, int i2) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i2;
        }
    }

    public static long IlO(String str, long j) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    public static double IlO(String str, double d8) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return d8;
        }
    }

    public static boolean IlO(String str, boolean z2) {
        try {
            return Boolean.parseBoolean(str);
        } catch (NumberFormatException unused) {
            return z2;
        }
    }
}
