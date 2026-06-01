package com.bytedance.adsdk.ugeno.yoga;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public enum bWL {
    NO_WRAP(0),
    WRAP(1),
    WRAP_REVERSE(2);

    private final int tV;

    bWL(int i2) {
        this.tV = i2;
    }

    public int IlO() {
        return this.tV;
    }

    public static bWL IlO(int i2) {
        if (i2 == 0) {
            return NO_WRAP;
        }
        if (i2 == 1) {
            return WRAP;
        }
        if (i2 == 2) {
            return WRAP_REVERSE;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i2)));
    }

    public static bWL IlO(String str) {
        str.getClass();
        switch (str) {
            case "nowrap":
                return NO_WRAP;
            case "wrap":
                return WRAP;
            case "wrap_reverse":
                return WRAP_REVERSE;
            default:
                throw new IllegalArgumentException("Unknown enum value: ".concat(str));
        }
    }
}
