package com.google.ads.mediation.unity;

import android.app.Activity;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class UnityBannerViewFactory {
    public UnityBannerViewWrapper createBannerView(Activity activity, String str, UnityBannerSize unityBannerSize) {
        return new UnityBannerViewWrapper(new BannerView(activity, str, unityBannerSize));
    }
}
