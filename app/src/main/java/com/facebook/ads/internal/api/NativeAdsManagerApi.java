package com.facebook.ads.internal.api;

import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeAdsManager;
import com.facebook.proguard.annotations.DoNotStripAny;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@Keep
@DoNotStripAny
public interface NativeAdsManagerApi {
    void disableAutoRefresh();

    int getUniqueNativeAdCount();

    boolean isLoaded();

    void loadAds();

    void loadAds(NativeAdBase.MediaCacheFlag mediaCacheFlag);

    @Nullable
    NativeAd nextNativeAd();

    @Nullable
    NativeAd nextNativeAd(NativeAdListener nativeAdListener);

    void setExtraHints(String str);

    void setListener(NativeAdsManager.Listener listener);
}
