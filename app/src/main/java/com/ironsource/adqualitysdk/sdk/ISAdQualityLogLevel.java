package com.ironsource.adqualitysdk.sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public enum ISAdQualityLogLevel {
    NONE(0),
    ERROR(1),
    WARNING(2),
    INFO(3),
    DEBUG(4),
    VERBOSE(5);


    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private final int f37;

    ISAdQualityLogLevel(int i2) {
        this.f37 = i2;
    }

    public static ISAdQualityLogLevel fromInt(int i2) {
        if (i2 == 0) {
            return NONE;
        }
        if (i2 == 1) {
            return ERROR;
        }
        if (i2 == 2) {
            return WARNING;
        }
        if (i2 == 3) {
            return INFO;
        }
        if (i2 == 4) {
            return DEBUG;
        }
        if (i2 != 5) {
            return null;
        }
        return VERBOSE;
    }

    public final int getValue() {
        return this.f37;
    }

    public final boolean shouldPrintLog(ISAdQualityLogLevel iSAdQualityLogLevel) {
        int i2 = this.f37;
        return i2 != NONE.f37 && i2 >= iSAdQualityLogLevel.f37;
    }
}
