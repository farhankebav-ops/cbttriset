package com.facebook.ads;

import android.content.Context;
import androidx.annotation.Keep;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.util.common.Preconditions;
import com.facebook.infer.annotation.Nullsafe;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@Keep
@Nullsafe(Nullsafe.Mode.LOCAL)
public final class AudienceNetworkAds {
    public static final String TAG = "FBAudienceNetwork";

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Keep
    @Retention(RetentionPolicy.SOURCE)
    public @interface AdFormat {
        public static final int BANNER = 1;
        public static final int INTERSTITIAL = 2;
        public static final int NATIVE = 4;
        public static final int NATIVE_BANNER = 5;
        public static final int REWARDED_VIDEO = 6;
        public static final int UNKNOWN = 0;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Keep
    public interface InitListener {
        void onInitialized(InitResult initResult);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Keep
    public interface InitResult {
        String getMessage();

        boolean isSuccess();
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Keep
    public interface InitSettingsBuilder {
        void initialize();

        InitSettingsBuilder withInitListener(InitListener initListener);

        InitSettingsBuilder withMediationService(String str);

        InitSettingsBuilder withPlacementIds(List<String> list);
    }

    private AudienceNetworkAds() {
    }

    public static InitSettingsBuilder buildInitSettings(Context context) {
        Preconditions.checkNotNull(context, "Context can not be null.");
        return new com.facebook.ads.internal.api.InitSettingsBuilder(context);
    }

    public static int getAdFormatForPlacement(Context context, String str) {
        return DynamicLoaderFactory.makeLoader(context).createAudienceNetworkAdsApi().getAdFormatForPlacement(str);
    }

    public static void initialize(Context context) {
        Preconditions.checkNotNull(context, "Context can not be null.");
        DynamicLoaderFactory.initialize(context, null, null, false);
    }

    public static boolean isInitialized(Context context) {
        if (DynamicLoaderFactory.getDynamicLoader() == null) {
            return false;
        }
        return DynamicLoaderFactory.makeLoader(context).createAudienceNetworkAdsApi().isInitialized();
    }
}
