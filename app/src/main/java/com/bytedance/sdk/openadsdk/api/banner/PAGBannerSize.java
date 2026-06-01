package com.bytedance.sdk.openadsdk.api.banner;

import android.content.Context;
import com.bytedance.sdk.openadsdk.utils.EO;
import com.google.mlkit.common.MlKitException;
import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class PAGBannerSize {
    private int EO = 1;
    private int IlO;
    private int MY;
    private int tV;
    public static final PAGBannerSize BANNER_W_320_H_50 = new PAGBannerSize(Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 50);
    public static final PAGBannerSize BANNER_W_300_H_250 = new PAGBannerSize(MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE, 250);
    public static final PAGBannerSize BANNER_W_728_H_90 = new PAGBannerSize(728, 90);

    public PAGBannerSize(int i2, int i8) {
        this.IlO = i2;
        this.MY = i8;
    }

    public static PAGBannerSize getCurrentOrientationAnchoredAdaptiveBannerAdSize(Context context, int i2) {
        int iIlO = EO.IlO(context, i2, 0);
        if (iIlO == EO.IlO) {
            return new PAGBannerSize(-1, -1);
        }
        PAGBannerSize pAGBannerSize = new PAGBannerSize(i2, iIlO);
        pAGBannerSize.EO = 2;
        return pAGBannerSize;
    }

    public static PAGBannerSize getCurrentOrientationInlineAdaptiveBannerAdSize(Context context, int i2) {
        int iIlO = EO.IlO(context, 0);
        if (iIlO == EO.IlO) {
            return new PAGBannerSize(-1, -1);
        }
        PAGBannerSize pAGBannerSize = new PAGBannerSize(i2, 0);
        pAGBannerSize.tV = iIlO;
        pAGBannerSize.EO = 3;
        return pAGBannerSize;
    }

    public static PAGBannerSize getInlineAdaptiveBannerAdSize(int i2, int i8) {
        PAGBannerSize pAGBannerSize = new PAGBannerSize(i2, 0);
        pAGBannerSize.tV = i8;
        pAGBannerSize.EO = 3;
        return pAGBannerSize;
    }

    public int getHeight() {
        return this.MY;
    }

    public int getMaxHeight() {
        return this.tV;
    }

    public int getType() {
        return this.EO;
    }

    public int getWidth() {
        return this.IlO;
    }
}
