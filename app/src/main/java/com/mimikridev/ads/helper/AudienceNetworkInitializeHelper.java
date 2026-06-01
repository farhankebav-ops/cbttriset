package com.mimikridev.ads.helper;

import android.content.Context;
import android.util.Log;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AudienceNetworkAds;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class AudienceNetworkInitializeHelper implements AudienceNetworkAds.InitListener {
    public static void initialize(Context context) {
        if (AudienceNetworkAds.isInitialized(context)) {
            return;
        }
        AudienceNetworkAds.buildInitSettings(context).withInitListener(new AudienceNetworkInitializeHelper()).initialize();
    }

    public static void initializeAd(Context context, boolean z2) {
        if (AudienceNetworkAds.isInitialized(context)) {
            return;
        }
        if (z2) {
            AdSettings.turnOnSDKDebugger(context);
            AdSettings.setTestMode(true);
            AdSettings.setIntegrationErrorMode(AdSettings.IntegrationErrorMode.INTEGRATION_ERROR_CRASH_DEBUG_MODE);
        }
        AudienceNetworkAds.buildInitSettings(context).withInitListener(new AudienceNetworkInitializeHelper()).initialize();
    }

    @Override // com.facebook.ads.AudienceNetworkAds.InitListener
    public void onInitialized(AudienceNetworkAds.InitResult initResult) {
        Log.d(AudienceNetworkAds.TAG, initResult.getMessage());
    }
}
