package com.bytedance.adsdk.ugeno.yoga;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public enum vCE {
    FLEX_START(0),
    CENTER(1),
    FLEX_END(2),
    SPACE_BETWEEN(3),
    SPACE_AROUND(4),
    SPACE_EVENLY(5);

    private final int Bc;

    vCE(int i2) {
        this.Bc = i2;
    }

    public int IlO() {
        return this.Bc;
    }

    public static vCE IlO(int i2) {
        if (i2 == 0) {
            return FLEX_START;
        }
        if (i2 == 1) {
            return CENTER;
        }
        if (i2 == 2) {
            return FLEX_END;
        }
        if (i2 == 3) {
            return SPACE_BETWEEN;
        }
        if (i2 == 4) {
            return SPACE_AROUND;
        }
        if (i2 == 5) {
            return SPACE_EVENLY;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i2)));
    }

    public static vCE IlO(String str) {
        str.getClass();
        switch (str) {
            case "center":
                return CENTER;
            case "space_around":
                return SPACE_AROUND;
            case "space_evenly":
                return SPACE_EVENLY;
            case "flex_start":
                return FLEX_START;
            case "space_between":
                return SPACE_BETWEEN;
            case "flex_end":
                return FLEX_END;
            default:
                throw new IllegalArgumentException("Unknown enum value: ".concat(str));
        }
    }
}
