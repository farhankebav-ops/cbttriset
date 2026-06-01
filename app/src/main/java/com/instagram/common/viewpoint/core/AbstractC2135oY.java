package com.instagram.common.viewpoint.core;

import com.google.common.collect.ElementTypesAreNonnullByDefault;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.oY, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractC2135oY {
    public static <K, V> Map<K, V> A00(int expectedSize) {
        return C1976lv.A0B(expectedSize);
    }

    public static <T> T[] A01(T[] tArr, int i2) {
        if (tArr.length != 0) {
            tArr = (T[]) Arrays.copyOf(tArr, 0);
        }
        return (T[]) Arrays.copyOf(tArr, i2);
    }

    public static <T> T[] A02(Object[] objArr, int i2, int i8, T[] tArr) {
        return (T[]) Arrays.copyOfRange(objArr, i2, i8, tArr.getClass());
    }
}
