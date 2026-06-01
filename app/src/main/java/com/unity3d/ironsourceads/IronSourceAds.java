package com.unity3d.ironsourceads;

import android.content.Context;
import com.ironsource.P9;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.r;
import java.util.List;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class IronSourceAds {
    public static final IronSourceAds INSTANCE = new IronSourceAds();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum AdFormat {
        BANNER("Banner"),
        INTERSTITIAL("Interstitial"),
        REWARDED("RewardedVideo");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10866a;

        AdFormat(String str) {
            this.f10866a = str;
        }

        public final String getValue() {
            return this.f10866a;
        }
    }

    private IronSourceAds() {
    }

    public static final void enableDebugMode(boolean z2) {
        IronLog.API.info("enabled: " + z2);
        r.m().a(z2);
    }

    public static final String getSdkVersion() {
        IronLog.API.info("");
        return "9.0.0";
    }

    public static final void init(Context context, InitRequest initRequest, InitListener initializationListener) {
        k.e(context, "context");
        k.e(initRequest, "initRequest");
        k.e(initializationListener, "initializationListener");
        P9.f7378a.a(context, initRequest, initializationListener);
    }

    public static final void setConsent(boolean z2) {
        IronLog.API.info("consent: " + z2);
        r.m().b(z2);
    }

    public static final void setMetaData(String key, String value) {
        k.e(key, "key");
        k.e(value, "value");
        IronLog.API.info("key = " + key + ", value = " + value);
        P9.f7378a.a(key, value);
    }

    public static final void setMetaData(String key, List<String> values) {
        k.e(key, "key");
        k.e(values, "values");
        IronLog.API.info("key = " + key + ", values = " + values);
        r.m().a(key, values);
    }
}
