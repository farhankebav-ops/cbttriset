package com.instagram.common.viewpoint.core;

import com.google.common.primitives.ElementTypesAreNonnullByDefault;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.q7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractC2210q7 {
    public static int A00(long value) {
        return (int) ((value >>> 32) ^ value);
    }

    public static int A01(long a8, long b8) {
        if (a8 < b8) {
            return -1;
        }
        return a8 > b8 ? 1 : 0;
    }
}
