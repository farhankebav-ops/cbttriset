package com.unity3d.ads.beta;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public enum UnityAdsPrivacyConsentValue {
    NOT_SET(0),
    CONSENT(1),
    NO_CONSENT(2);

    private final int value;

    UnityAdsPrivacyConsentValue(int i2) {
        this.value = i2;
    }

    public final int getValue() {
        return this.value;
    }
}
