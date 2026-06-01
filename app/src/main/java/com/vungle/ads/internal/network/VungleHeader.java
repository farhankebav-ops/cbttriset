package com.vungle.ads.internal.network;

import android.os.Build;
import com.vungle.ads.BuildConfig;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class VungleHeader {
    public static final VungleHeader INSTANCE;
    private static String appId;
    private static String appVersion;
    private static String headerUa;

    static {
        VungleHeader vungleHeader = new VungleHeader();
        INSTANCE = vungleHeader;
        headerUa = vungleHeader.defaultHeader();
    }

    private VungleHeader() {
    }

    private final String defaultHeader() {
        return ("Amazon".equals(Build.MANUFACTURER) ? "VungleAmazon/" : "VungleDroid/").concat(BuildConfig.VERSION_NAME);
    }

    public final String getAppId() {
        return appId;
    }

    public final String getAppVersion() {
        return appVersion;
    }

    public final String getHeaderUa() {
        return headerUa;
    }

    public final void reset() {
        headerUa = defaultHeader();
    }

    public final void setAppId(String str) {
        appId = str;
    }

    public final void setAppVersion(String str) {
        appVersion = str;
    }

    public final void setHeaderUa(String str) {
        k.e(str, "<set-?>");
        headerUa = str;
    }
}
