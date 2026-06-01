package com.unity3d.ads.beta;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface ShowListener<UnityAd> {
    void showClick(UnityAd unityad);

    void showComplete(UnityAd unityad, ShowFinishState showFinishState);

    void showFailed(UnityAd unityad, UnityAdsError unityAdsError);

    void showImpression(UnityAd unityad);

    void showStart(UnityAd unityad);
}
