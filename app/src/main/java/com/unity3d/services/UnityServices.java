package com.unity3d.services;

import android.content.Context;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.services.core.lifecycle.CachedLifecycle;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.properties.Session;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class UnityServices {
    public static final UnityServices INSTANCE = new UnityServices();
    private static final boolean isSupported = true;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum UnityServicesError {
        INVALID_ARGUMENT,
        INIT_SANITY_CHECK_FAIL
    }

    private UnityServices() {
    }

    public static final boolean getDebugMode() {
        return SdkProperties.getDebugMode();
    }

    public static final String getVersion() {
        String versionName = SdkProperties.getVersionName();
        k.d(versionName, "getVersionName()");
        return versionName;
    }

    public static final synchronized void initialize(Context context, String str, boolean z2, IUnityAdsInitializationListener iUnityAdsInitializationListener) {
        try {
            DeviceLog.entered();
            SdkProperties.addInitializationListener(iUnityAdsInitializationListener);
            SdkProperties.setTestMode(z2);
            SdkProperties.setDebugMode(SdkProperties.getDebugMode());
            DeviceLog.info("Initializing Unity Services " + SdkProperties.getVersionName() + " (" + SdkProperties.getVersionCode() + ") with game id " + str + " in " + (z2 ? "test mode" : "production mode") + ", session " + Session.Default.getId());
            CachedLifecycle.register();
            UnityAdsSDK.initialize$default(new UnityAdsSDK(null, 1, 0 == true ? 1 : 0), str, null, 2, null);
        } catch (Throwable th) {
            throw th;
        }
    }

    public static final boolean isInitialized() {
        return SdkProperties.isInitialized();
    }

    public static final boolean isSupported() {
        return isSupported;
    }

    public static final void setDebugMode(boolean z2) {
        SdkProperties.setDebugMode(z2);
    }

    public static /* synthetic */ void getDebugMode$annotations() {
    }

    public static /* synthetic */ void getVersion$annotations() {
    }

    public static /* synthetic */ void isInitialized$annotations() {
    }

    public static /* synthetic */ void isSupported$annotations() {
    }
}
