package com.ironsource.mediationsdk.utils;

import a1.a;
import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class ErrorBuilder {
    private static IronSourceError a() {
        return buildGenericError("Mediation - wrong configuration");
    }

    public static IronSourceError adContainerIsNull(String str) {
        return new IronSourceError(IronSourceError.ERROR_BN_BANNER_CONTAINER_IS_NULL, a.C(str, " banner container is null"));
    }

    public static IronSourceError buildCappedPerPlacementError(String str) {
        return new IronSourceError(IronSourceError.ERROR_PLACEMENT_CAPPED, str);
    }

    public static IronSourceError buildCappedPerSessionError(String str) {
        return new IronSourceError(IronSourceError.ERROR_CAPPED_PER_SESSION, a.C(str, " Show Fail - Networks have reached their cap per session"));
    }

    public static IronSourceError buildGenericError(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "An error occurred";
        }
        return new IronSourceError(510, str);
    }

    public static IronSourceError buildInitFailedError(String str, String str2) {
        return new IronSourceError(508, TextUtils.isEmpty(str) ? a.C(str2, " init failed due to an unknown error") : a.D(str2, " - ", str));
    }

    public static IronSourceError buildInvalidConfigurationError(String str) {
        return new IronSourceError(501, a.m("", str, " Init Fail - Configurations from the server are not valid"));
    }

    public static IronSourceError buildInvalidCredentialsError(String str, String str2, String str3) {
        StringBuilder sbZ = a.z("Init Fail - ", str, " value ", str2, " is not valid");
        sbZ.append(!TextUtils.isEmpty(str3) ? a.l(" - ", str3) : "");
        return new IronSourceError(506, sbZ.toString());
    }

    public static IronSourceError buildInvalidKeyValueError(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return a();
        }
        StringBuilder sbY = a.y("Mediation - ", str, " value is not valid ");
        sbY.append(!TextUtils.isEmpty(str2) ? a.l(" - ", str2) : "");
        return new IronSourceError(506, sbY.toString());
    }

    public static IronSourceError buildKeyNotSetError(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return a();
        }
        return new IronSourceError(505, str3 + " Mediation - " + str + " is not set for " + str2);
    }

    public static IronSourceError buildLoadFailedError(String str, String str2, String str3) {
        String strR = a.r(a.y("", str, " Load Fail"), TextUtils.isEmpty(str2) ? "" : a.l(" ", str2), " - ");
        if (TextUtils.isEmpty(str3)) {
            str3 = "unknown error";
        }
        return new IronSourceError(510, a.C(strR, str3));
    }

    public static IronSourceError buildNoAdsToShowError(String str) {
        return new IronSourceError(509, a.C(str, " Show Fail - No ads to show"));
    }

    public static IronSourceError buildNoConfigurationAvailableError(String str) {
        return new IronSourceError(501, a.m("", str, " Init Fail - Unable to retrieve configurations from the server"));
    }

    public static IronSourceError buildNoInternetConnectionInitFailError(String str) {
        return new IronSourceError(IronSourceError.ERROR_NO_INTERNET_CONNECTION, a.m("", str, " Init Fail - No Internet connection"));
    }

    public static IronSourceError buildNoInternetConnectionLoadFailError(String str) {
        return new IronSourceError(IronSourceError.ERROR_NO_INTERNET_CONNECTION, a.m("", str, " Load Fail - No Internet connection"));
    }

    public static IronSourceError buildNoInternetConnectionShowFailError(String str) {
        return new IronSourceError(IronSourceError.ERROR_NO_INTERNET_CONNECTION, a.m("", str, " Show Fail - No Internet connection"));
    }

    public static IronSourceError buildNonExistentInstanceError(String str) {
        return new IronSourceError(IronSourceError.ERROR_NON_EXISTENT_INSTANCE, a.C(str, " The requested instance does not exist"));
    }

    public static IronSourceError buildShowFailedError(String str, String str2) {
        return new IronSourceError(509, a.D(str, " Show Fail - ", str2));
    }

    public static IronSourceError buildUsingCachedConfigurationError(String str, String str2) {
        return new IronSourceError(502, a.n("Mediation - Unable to retrieve configurations from IronSource server, using cached configurations with appKey:", str, " and userId:", str2));
    }

    public static IronSourceError unsupportedBannerSize(String str) {
        return new IronSourceError(IronSourceError.ERROR_BN_UNSUPPORTED_SIZE, a.C(str, " unsupported banner size"));
    }

    public static IronSourceError buildInitFailedError(String str) {
        StringBuilder sb = new StringBuilder("Init failed - ");
        if (TextUtils.isEmpty(str)) {
            str = "unknown error";
        }
        sb.append(str);
        return new IronSourceError(508, sb.toString());
    }

    public static IronSourceError buildLoadFailedError(String str) {
        return new IronSourceError(510, TextUtils.isEmpty(str) ? "Load failed due to an unknown error" : a.l("Load failed - ", str));
    }
}
