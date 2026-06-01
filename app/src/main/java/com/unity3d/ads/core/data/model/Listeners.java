package com.unity3d.ads.core.data.model;

import com.unity3d.ads.UnityAds;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface Listeners {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class DefaultImpls {
        public static void onClick(Listeners listeners, String placementId) {
            k.e(placementId, "placementId");
        }

        public static void onComplete(Listeners listeners, String placementId, UnityAds.UnityAdsShowCompletionState state) {
            k.e(placementId, "placementId");
            k.e(state, "state");
        }

        public static void onError(Listeners listeners, String placementId, UnityAds.UnityAdsShowError error, String message) {
            k.e(placementId, "placementId");
            k.e(error, "error");
            k.e(message, "message");
        }

        public static void onLeftApplication(Listeners listeners, String placementId) {
            k.e(placementId, "placementId");
        }

        public static void onStart(Listeners listeners, String placementId) {
            k.e(placementId, "placementId");
        }
    }

    void onClick(String str);

    void onComplete(String str, UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState);

    void onError(String str, UnityAds.UnityAdsShowError unityAdsShowError, String str2);

    void onLeftApplication(String str);

    void onStart(String str);
}
