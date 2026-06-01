package com.bytedance.adsdk.ugeno.yoga;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public enum hp {
    STATIC(0),
    RELATIVE(1),
    ABSOLUTE(2);

    private final int tV;

    hp(int i2) {
        this.tV = i2;
    }

    public int IlO() {
        return this.tV;
    }

    public static hp IlO(int i2) {
        if (i2 == 0) {
            return STATIC;
        }
        if (i2 == 1) {
            return RELATIVE;
        }
        if (i2 == 2) {
            return ABSOLUTE;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i2)));
    }

    public static hp IlO(String str) {
        str.getClass();
        switch (str) {
            case "static":
                return STATIC;
            case "relative":
                return RELATIVE;
            case "absolute":
                return ABSOLUTE;
            default:
                throw new IllegalArgumentException("Unknown enum value: ".concat(str));
        }
    }
}
