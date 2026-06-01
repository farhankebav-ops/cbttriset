package com.ironsource.adqualitysdk.sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public enum ISAdQualityMediationNetwork {
    UNKNOWN(-1),
    ADMOB(0),
    DT_FAIR_BID(1),
    HELIUM(2),
    LEVEL_PLAY(3),
    MAX(4),
    UNITY(5),
    SELF_MEDIATED(6),
    OTHER(7);


    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private final int f39;

    ISAdQualityMediationNetwork(int i2) {
        this.f39 = i2;
    }

    public static ISAdQualityMediationNetwork fromInt(int i2) {
        switch (i2) {
            case -1:
                return UNKNOWN;
            case 0:
                return ADMOB;
            case 1:
                return DT_FAIR_BID;
            case 2:
                return HELIUM;
            case 3:
                return LEVEL_PLAY;
            case 4:
                return MAX;
            case 5:
                return UNITY;
            case 6:
                return SELF_MEDIATED;
            case 7:
                return OTHER;
            default:
                return null;
        }
    }

    public final int getValue() {
        return this.f39;
    }
}
