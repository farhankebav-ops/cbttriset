package com.ironsource.adqualitysdk.sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public enum ISAdQualityDeviceIdType {
    NONE(0),
    GAID(1),
    IDFA(2);


    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private final int f33;

    ISAdQualityDeviceIdType(int i2) {
        this.f33 = i2;
    }

    public static ISAdQualityDeviceIdType fromInt(int i2) {
        if (i2 == 0) {
            return NONE;
        }
        if (i2 == 1) {
            return GAID;
        }
        if (i2 != 2) {
            return null;
        }
        return IDFA;
    }

    public final int getValue() {
        return this.f33;
    }
}
