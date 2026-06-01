package com.bytedance.adsdk.ugeno.yoga;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@com.bytedance.adsdk.ugeno.yoga.IlO.IlO
public enum YogaLogLevel {
    ERROR(0),
    WARN(1),
    INFO(2),
    DEBUG(3),
    VERBOSE(4),
    FATAL(5);

    private final int Bc;

    YogaLogLevel(int i2) {
        this.Bc = i2;
    }

    @com.bytedance.adsdk.ugeno.yoga.IlO.IlO
    public static YogaLogLevel fromInt(int i2) {
        if (i2 == 0) {
            return ERROR;
        }
        if (i2 == 1) {
            return WARN;
        }
        if (i2 == 2) {
            return INFO;
        }
        if (i2 == 3) {
            return DEBUG;
        }
        if (i2 == 4) {
            return VERBOSE;
        }
        if (i2 == 5) {
            return FATAL;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i2)));
    }
}
