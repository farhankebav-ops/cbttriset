package com.unity3d.mediation;

import android.content.Context;
import com.ironsource.C2486o9;
import com.ironsource.C2606vb;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.r;
import com.unity3d.mediation.impression.LevelPlayImpressionDataListener;
import com.unity3d.mediation.segment.LevelPlaySegment;
import java.util.List;
import kotlin.jvm.internal.k;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class LevelPlay {
    public static final LevelPlay INSTANCE = new LevelPlay();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum AdFormat {
        BANNER("banner"),
        INTERSTITIAL("interstitial"),
        REWARDED("rewarded"),
        NATIVE_AD("nativeAd");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10907a;

        AdFormat(String str) {
            this.f10907a = str;
        }

        public final String getValue() {
            return this.f10907a;
        }
    }

    private LevelPlay() {
    }

    public static final void addImpressionDataListener(LevelPlayImpressionDataListener listener) {
        k.e(listener, "listener");
        IronLog.API.info("adding listener: ".concat(listener.getClass().getSimpleName()));
        C2606vb.f10443a.a(listener);
    }

    public static final String getSdkVersion() {
        IronLog.API.info("");
        return "9.0.0";
    }

    public static final void init(Context context, LevelPlayInitRequest initRequest, LevelPlayInitListener listener) {
        k.e(context, "context");
        k.e(initRequest, "initRequest");
        k.e(listener, "listener");
        C2606vb.f10443a.a(context, initRequest, listener);
    }

    public static final void launchTestSuite(Context context) {
        k.e(context, "context");
        IronLog.API.info("");
        r.m().c(context);
    }

    public static final void removeImpressionDataListener(LevelPlayImpressionDataListener listener) {
        k.e(listener, "listener");
        IronLog.API.info("removing listener: ".concat(listener.getClass().getSimpleName()));
        C2606vb.f10443a.b(listener);
    }

    public static final void setAdaptersDebug(boolean z2) {
        IronLog.API.info("enabled: " + z2);
        r.m().a(z2);
    }

    public static final void setConsent(boolean z2) {
        IronLog.API.info("consent: " + z2);
        r.m().b(z2);
    }

    public static final boolean setDynamicUserId(String dynamicUserId) {
        k.e(dynamicUserId, "dynamicUserId");
        IronLog.API.info("dynamicUserId: ".concat(dynamicUserId));
        return r.m().b(dynamicUserId);
    }

    public static final void setMetaData(String key, String value) {
        k.e(key, "key");
        k.e(value, "value");
        IronLog.API.info("key = " + key + ", value = " + value);
        C2606vb.f10443a.a(key, value);
    }

    public static final void setNetworkData(String networkKey, JSONObject networkData) {
        k.e(networkKey, "networkKey");
        k.e(networkData, "networkData");
        IronLog.API.info("networkKey = " + networkKey + ", networkData = " + networkData);
        r.m().b(networkKey, networkData);
    }

    public static final void setSegment(LevelPlaySegment segment) {
        k.e(segment, "segment");
        IronLog.API.info("");
        C2606vb.f10443a.b(segment);
    }

    public static final void validateIntegration(Context context) {
        k.e(context, "context");
        IronLog.API.info("");
        C2486o9.f9556a.a(context);
    }

    public static final void setMetaData(String key, List<String> values) {
        k.e(key, "key");
        k.e(values, "values");
        IronLog.API.info("key = " + key + ", values = " + values);
        r.m().a(key, values);
    }
}
