package com.ironsource.adqualitysdk.sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public enum ISAdQualityInitError {
    AD_QUALITY_SDK_WAS_SHUTDOWN(0),
    ILLEGAL_USER_ID(1),
    ILLEGAL_APP_KEY(2),
    EXCEPTION_ON_INIT(3),
    NO_NETWORK_CONNECTION(4),
    CONFIG_LOAD_TIMEOUT(5),
    CONNECTOR_LOAD_TIMEOUT(6),
    AD_NETWORK_VERSION_NOT_SUPPORTED_YET(7),
    AD_NETWORK_SDK_REQUIRES_NEWER_AD_QUALITY_SDK(8),
    AD_QUALITY_ALREADY_INITIALIZED(9);


    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private final int f35;

    ISAdQualityInitError(int i2) {
        this.f35 = i2;
    }

    public static ISAdQualityInitError fromInt(int i2) {
        switch (i2) {
            case 0:
                return AD_QUALITY_SDK_WAS_SHUTDOWN;
            case 1:
                return ILLEGAL_USER_ID;
            case 2:
                return ILLEGAL_APP_KEY;
            case 3:
                return EXCEPTION_ON_INIT;
            case 4:
                return NO_NETWORK_CONNECTION;
            case 5:
                return CONFIG_LOAD_TIMEOUT;
            case 6:
                return CONNECTOR_LOAD_TIMEOUT;
            case 7:
                return AD_NETWORK_VERSION_NOT_SUPPORTED_YET;
            case 8:
                return AD_NETWORK_SDK_REQUIRES_NEWER_AD_QUALITY_SDK;
            case 9:
                return AD_QUALITY_ALREADY_INITIALIZED;
            default:
                return null;
        }
    }

    public final int getValue() {
        return this.f35;
    }
}
