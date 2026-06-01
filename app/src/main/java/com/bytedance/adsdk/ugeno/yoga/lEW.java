package com.bytedance.adsdk.ugeno.yoga;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public enum lEW {
    UNDEFINED(0),
    EXACTLY(1),
    AT_MOST(2);

    private final int tV;

    lEW(int i2) {
        this.tV = i2;
    }

    public static lEW IlO(int i2) {
        if (i2 == 0) {
            return UNDEFINED;
        }
        if (i2 == 1) {
            return EXACTLY;
        }
        if (i2 == 2) {
            return AT_MOST;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i2)));
    }
}
