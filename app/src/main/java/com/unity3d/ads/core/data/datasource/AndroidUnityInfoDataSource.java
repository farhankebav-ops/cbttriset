package com.unity3d.ads.core.data.datasource;

import android.content.Context;
import com.unity3d.services.UnityAdsConstants;
import com.unity3d.services.core.preferences.AndroidPreferences;
import kotlin.jvm.internal.k;
import n6.m;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidUnityInfoDataSource {
    private final String prefName;

    public AndroidUnityInfoDataSource(Context applicationContext) {
        k.e(applicationContext, "applicationContext");
        this.prefName = applicationContext.getPackageName() + ".v2.playerprefs";
    }

    private final String getPlayerPrefId(String str) {
        String string = AndroidPreferences.getString(this.prefName, str);
        if (string == null || m.A0(string)) {
            return null;
        }
        return string;
    }

    public final String getUnityInstallationId() {
        return getPlayerPrefId(UnityAdsConstants.Preferences.PREF_KEY_UNITY_INSTALLATION_ID);
    }

    public final String getUnityMegaSessionId() {
        return getPlayerPrefId(UnityAdsConstants.Preferences.PREF_KEY_UNITY_MEGA_SESSION_ID);
    }
}
