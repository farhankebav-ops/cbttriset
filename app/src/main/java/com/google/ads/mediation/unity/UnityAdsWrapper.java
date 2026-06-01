package com.google.ads.mediation.unity;

import android.content.Context;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.IUnityAdsTokenListener;
import com.unity3d.ads.TokenConfiguration;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.metadata.MediationMetaData;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class UnityAdsWrapper {
    public MediationMetaData getMediationMetaData(Context context) {
        return new MediationMetaData(context);
    }

    public void getToken(IUnityAdsTokenListener iUnityAdsTokenListener) {
        UnityAds.getToken(iUnityAdsTokenListener);
    }

    public String getVersion() {
        return UnityAds.getVersion();
    }

    public void initialize(Context context, String str, IUnityAdsInitializationListener iUnityAdsInitializationListener) {
        UnityAds.initialize(context, str, false, iUnityAdsInitializationListener);
    }

    public boolean isInitialized() {
        return UnityAds.isInitialized();
    }

    public void getToken(TokenConfiguration tokenConfiguration, IUnityAdsTokenListener iUnityAdsTokenListener) {
        UnityAds.getToken(tokenConfiguration, iUnityAdsTokenListener);
    }
}
