package com.google.ads.mediation.pangle;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class PangleConstants {
    public static final String ADX_ID = "207";
    public static final String APP_ID = "appid";
    public static final int ERROR_BANNER_SIZE_MISMATCH = 102;
    public static final int ERROR_CHILD_USER = 103;
    public static final String ERROR_DOMAIN = "com.google.ads.mediation.pangle";
    public static final int ERROR_INVALID_SERVER_PARAMETERS = 101;
    public static final String ERROR_MSG_CHILD_USER = "MobileAds.getRequestConfiguration() indicates the user is a child. Pangle SDK V71 or higher does not support child users.";
    public static final String PANGLE_SDK_ERROR_DOMAIN = "com.pangle.ads";
    public static final String PLACEMENT_ID = "placementid";

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface AdapterError {
    }

    private PangleConstants() {
    }

    @NonNull
    public static AdError createAdapterError(int i2, @NonNull String str) {
        return new AdError(i2, str, "com.google.ads.mediation.pangle");
    }

    public static AdError createChildUserError() {
        return new AdError(103, ERROR_MSG_CHILD_USER, "com.google.ads.mediation.pangle");
    }

    @NonNull
    public static AdError createSdkError(int i2, @NonNull String str) {
        return new AdError(i2, str, PANGLE_SDK_ERROR_DOMAIN);
    }

    public static boolean isChildUser() {
        RequestConfiguration requestConfiguration = MobileAds.getRequestConfiguration();
        return requestConfiguration.getTagForChildDirectedTreatment() == 1 || requestConfiguration.getTagForUnderAgeOfConsent() == 1;
    }
}
