package com.vungle.ads.internal.util;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class RangeUtil {
    public static final RangeUtil INSTANCE = new RangeUtil();

    private RangeUtil() {
    }

    public static /* synthetic */ boolean isInRange$default(RangeUtil rangeUtil, int i2, int i8, int i9, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            i9 = Integer.MAX_VALUE;
        }
        return rangeUtil.isInRange(i2, i8, i9);
    }

    public final boolean isInRange(float f4, float f8, float f9) {
        return f8 <= f4 && f4 <= f9;
    }

    public static /* synthetic */ boolean isInRange$default(RangeUtil rangeUtil, float f4, float f8, float f9, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            f9 = Float.MAX_VALUE;
        }
        return rangeUtil.isInRange(f4, f8, f9);
    }

    public final boolean isInRange(int i2, int i8, int i9) {
        return i8 <= i2 && i2 <= i9;
    }
}
