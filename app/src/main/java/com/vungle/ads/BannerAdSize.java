package com.vungle.ads;

import com.google.mlkit.common.MlKitException;
import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public enum BannerAdSize {
    VUNGLE_MREC("mrec", MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE, 250),
    BANNER("banner", Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 50),
    BANNER_SHORT("banner_short", MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE, 50),
    BANNER_LEADERBOARD("banner_leaderboard", 728, 90);

    private final int height;
    private final String sizeName;
    private final int width;

    BannerAdSize(String str, int i2, int i8) {
        this.sizeName = str;
        this.width = i2;
        this.height = i8;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getSizeName() {
        return this.sizeName;
    }

    public final int getWidth() {
        return this.width;
    }
}
