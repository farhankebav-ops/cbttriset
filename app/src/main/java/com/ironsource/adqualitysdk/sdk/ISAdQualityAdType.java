package com.ironsource.adqualitysdk.sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public enum ISAdQualityAdType {
    UNKNOWN(-1),
    RICH_MEDIA(0),
    INTERSTITIAL(1),
    APP_WALL(2),
    VIDEO(3),
    REWARDED_VIDEO(4),
    NATIVE(5),
    BANNER(6),
    OFFER_WALL(7),
    NATIVE_HTML(8),
    EXTERNAL(9),
    REWARDED(10),
    INTERACTIVE(11);


    /* JADX INFO: renamed from: ﻛ, reason: collision with root package name */
    private final int f7987;

    ISAdQualityAdType(int i2) {
        this.f7987 = i2;
    }

    public static ISAdQualityAdType fromInt(int i2) {
        switch (i2) {
            case -1:
                return UNKNOWN;
            case 0:
                return RICH_MEDIA;
            case 1:
                return INTERSTITIAL;
            case 2:
                return APP_WALL;
            case 3:
                return VIDEO;
            case 4:
                return REWARDED_VIDEO;
            case 5:
                return NATIVE;
            case 6:
                return BANNER;
            case 7:
                return OFFER_WALL;
            case 8:
                return NATIVE_HTML;
            case 9:
                return EXTERNAL;
            case 10:
                return REWARDED;
            case 11:
                return INTERACTIVE;
            default:
                return null;
        }
    }

    public final int getValue() {
        return this.f7987;
    }
}
