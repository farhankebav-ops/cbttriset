package sg.bigo.ads.api;

import android.content.Context;
import com.google.mlkit.common.MlKitException;
import com.vungle.ads.internal.protos.Sdk;
import sg.bigo.ads.common.p;
import sg.bigo.ads.common.utils.e;

/* JADX INFO: loaded from: classes6.dex */
public final class AdSize extends p {
    public static final String ADAPTIVE = "adaptive";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static p f15430d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15431a;
    public static final AdSize BANNER = new AdSize(Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 50, "320x50");
    public static final AdSize MEDIUM_RECTANGLE = new AdSize(MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE, 250, "300x250");
    public static final AdSize LARGE_BANNER = new AdSize(Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 90, "320x90");
    public static final AdSize MOBILE_LARGE_LEADERBOARD = new AdSize(Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 100, "320x100");
    public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90");

    private AdSize(int i2, int i8, String str) {
        super(i2, i8);
        this.f15431a = str;
    }

    public static int dp2px(Context context, int i2) {
        if (context == null) {
            return 0;
        }
        return e.a(context, i2);
    }

    public static AdSize getAdaptiveAdSize(Context context, int i2) {
        float f4;
        float f8;
        int iRound;
        if (context == null || i2 == 0) {
            return BANNER;
        }
        if (f15430d == null) {
            f15430d = e.e(context);
        }
        int height = f15430d.getHeight();
        if (height <= 0) {
            return BANNER;
        }
        int iMin = Math.min(90, Math.round(height * 0.15f));
        if (i2 < 0) {
            i2 = f15430d.getWidth();
        }
        if (i2 <= 655) {
            if (i2 > 632) {
                iRound = 81;
            } else if (i2 > 526) {
                f4 = i2 / 468.0f;
                f8 = 60.0f;
            } else if (i2 > 432) {
                iRound = 68;
            } else {
                f4 = i2 / 320.0f;
                f8 = 50.0f;
            }
            return new AdSize(i2, Math.max(Math.min(iRound, iMin), 50), ADAPTIVE);
        }
        f4 = i2 / 728.0f;
        f8 = 90.0f;
        iRound = Math.round(f4 * f8);
        return new AdSize(i2, Math.max(Math.min(iRound, iMin), 50), ADAPTIVE);
    }

    @Override // sg.bigo.ads.common.p
    public final int getHeight() {
        return super.getHeight();
    }

    @Override // sg.bigo.ads.common.p
    public final int getWidth() {
        return super.getWidth();
    }
}
