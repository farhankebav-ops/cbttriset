package com.vungle.ads;

import android.content.Context;
import com.google.mlkit.common.MlKitException;
import com.ironsource.adqualitysdk.sdk.i.a0;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.model.Placement;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.util.ViewUtility;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class VungleAdSize {
    private final int height;
    private boolean isAdaptiveHeight;
    private boolean isAdaptiveWidth;
    private final int width;
    public static final Companion Companion = new Companion(null);
    public static final VungleAdSize BANNER = new VungleAdSize(Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 50);
    public static final VungleAdSize BANNER_SHORT = new VungleAdSize(MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE, 50);
    public static final VungleAdSize BANNER_LEADERBOARD = new VungleAdSize(728, 90);
    public static final VungleAdSize MREC = new VungleAdSize(MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE, 250);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final VungleAdSize getAdSizeWithWidth(Context context, int i2) {
            k.e(context, "context");
            int iIntValue = ((Number) ViewUtility.INSTANCE.getDeviceWidthAndHeightWithOrientation(context, 0).f13499b).intValue();
            if (i2 < 0) {
                i2 = 0;
            }
            VungleAdSize vungleAdSize = new VungleAdSize(i2, iIntValue);
            if (vungleAdSize.getWidth() == 0) {
                vungleAdSize.setAdaptiveWidth$vungle_ads_release(true);
            }
            vungleAdSize.setAdaptiveHeight$vungle_ads_release(true);
            return vungleAdSize;
        }

        public final VungleAdSize getAdSizeWithWidthAndHeight(int i2, int i8) {
            if (i2 < 0) {
                i2 = 0;
            }
            if (i8 < 0) {
                i8 = 0;
            }
            VungleAdSize vungleAdSize = new VungleAdSize(i2, i8);
            if (vungleAdSize.getWidth() == 0) {
                vungleAdSize.setAdaptiveWidth$vungle_ads_release(true);
            }
            if (vungleAdSize.getHeight() == 0) {
                vungleAdSize.setAdaptiveHeight$vungle_ads_release(true);
            }
            return vungleAdSize;
        }

        public final VungleAdSize getValidAdSizeFromSize(int i2, int i8, String placementId) {
            k.e(placementId, "placementId");
            Placement placement = ConfigManager.INSTANCE.getPlacement(placementId);
            if (placement != null) {
                if (!placement.isInline()) {
                    placement = null;
                }
                if (placement != null) {
                    return VungleAdSize.Companion.getAdSizeWithWidthAndHeight(i2, i8);
                }
            }
            VungleAdSize vungleAdSize = VungleAdSize.MREC;
            if (i2 >= vungleAdSize.getWidth() && i8 >= vungleAdSize.getHeight()) {
                return vungleAdSize;
            }
            VungleAdSize vungleAdSize2 = VungleAdSize.BANNER_LEADERBOARD;
            if (i2 >= vungleAdSize2.getWidth() && i8 >= vungleAdSize2.getHeight()) {
                return vungleAdSize2;
            }
            VungleAdSize vungleAdSize3 = VungleAdSize.BANNER;
            if (i2 >= vungleAdSize3.getWidth() && i8 >= vungleAdSize3.getHeight()) {
                return vungleAdSize3;
            }
            VungleAdSize vungleAdSize4 = VungleAdSize.BANNER_SHORT;
            return (i2 < vungleAdSize4.getWidth() || i8 < vungleAdSize4.getHeight()) ? getAdSizeWithWidthAndHeight(i2, i8) : vungleAdSize4;
        }

        private Companion() {
        }
    }

    public VungleAdSize(int i2, int i8) {
        this.width = i2;
        this.height = i8;
    }

    public static final VungleAdSize getAdSizeWithWidth(Context context, int i2) {
        return Companion.getAdSizeWithWidth(context, i2);
    }

    public static final VungleAdSize getAdSizeWithWidthAndHeight(int i2, int i8) {
        return Companion.getAdSizeWithWidthAndHeight(i2, i8);
    }

    public static final VungleAdSize getValidAdSizeFromSize(int i2, int i8, String str) {
        return Companion.getValidAdSizeFromSize(i2, i8, str);
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    public final boolean isAdaptiveHeight$vungle_ads_release() {
        return this.isAdaptiveHeight;
    }

    public final boolean isAdaptiveWidth$vungle_ads_release() {
        return this.isAdaptiveWidth;
    }

    public final boolean isValidSize$vungle_ads_release() {
        return this.width >= 0 && this.height >= 0;
    }

    public final void setAdaptiveHeight$vungle_ads_release(boolean z2) {
        this.isAdaptiveHeight = z2;
    }

    public final void setAdaptiveWidth$vungle_ads_release(boolean z2) {
        this.isAdaptiveWidth = z2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("VungleAdSize(width=");
        sb.append(this.width);
        sb.append(", height=");
        return a0.c(sb, this.height, ')');
    }
}
