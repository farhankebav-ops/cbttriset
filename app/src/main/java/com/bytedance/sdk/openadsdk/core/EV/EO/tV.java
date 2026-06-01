package com.bytedance.sdk.openadsdk.core.EV.EO;

import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV {
    public static final List<String> IlO = Arrays.asList("video/mp4", "video/3gpp");

    public static double IlO(int i2, double d8, int i8, int i9, int i10, @Nullable String str) {
        double dIlO = IlO(i2, d8, i8, i9);
        return (1.0d / ((dIlO + 1.0d) + IlO(i10))) * IlO(str);
    }

    private static double IlO(int i2, double d8, int i8, int i9) {
        return (d8 > 0.0d ? Math.abs(d8 - (i9 > 0 ? ((double) i8) / ((double) i9) : 0.0d)) : 0.0d) + (i2 > 0 ? Math.abs((i2 - i8) / i2) : 0.0d);
    }

    private static double IlO(int i2) {
        int iMax = Math.max(i2, 0);
        if (700 > iMax || iMax > 1500) {
            return Math.min(Math.abs(700 - iMax) / 700.0f, Math.abs(1500 - iMax) / 1500.0f);
        }
        return 0.0d;
    }

    private static double IlO(String str) {
        if (str == null) {
            str = "";
        }
        int iHashCode = str.hashCode();
        if (iHashCode != -1664118616) {
            return (iHashCode == 1331848029 && str.equals("video/mp4")) ? 1.5d : 1.0d;
        }
        str.equals("video/3gpp");
        return 1.0d;
    }
}
