package com.google.ads.mediation.ironsource;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.MediationUtils;
import com.google.android.gms.ads.MobileAds;
import com.ironsource.mediationsdk.ISBannerSize;
import com.unity3d.ironsourceads.AdSize;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IronSourceAdapterUtils {
    public static AdError buildAdErrorAdapterDomain(int i2, @NonNull String str) {
        return new AdError(i2, str, "com.google.ads.mediation.ironsource");
    }

    public static AdError buildAdErrorIronSourceDomain(int i2, @NonNull String str) {
        return new AdError(i2, str, IronSourceMediationAdapter.IRONSOURCE_SDK_ERROR_DOMAIN);
    }

    public static <T> boolean canLoadIronSourceAdInstance(@NonNull String str, @NonNull ConcurrentHashMap<String, WeakReference<T>> concurrentHashMap) {
        WeakReference<T> weakReference = concurrentHashMap.get(str);
        return weakReference == null || weakReference.get() == null;
    }

    @NonNull
    public static AdSize getAdSizeFromGoogleAdSize(@NonNull Context context, @NonNull com.google.android.gms.ads.AdSize adSize) {
        com.google.android.gms.ads.AdSize adSize2 = com.google.android.gms.ads.AdSize.BANNER;
        com.google.android.gms.ads.AdSize adSize3 = com.google.android.gms.ads.AdSize.MEDIUM_RECTANGLE;
        com.google.android.gms.ads.AdSize adSize4 = com.google.android.gms.ads.AdSize.LARGE_BANNER;
        com.google.android.gms.ads.AdSize adSize5 = com.google.android.gms.ads.AdSize.LEADERBOARD;
        com.google.android.gms.ads.AdSize adSizeFindClosestSize = MediationUtils.findClosestSize(context, adSize, new ArrayList(Arrays.asList(adSize2, adSize3, adSize4, adSize5)));
        return adSizeFindClosestSize == null ? AdSize.banner() : adSize2.equals(adSizeFindClosestSize) ? AdSize.banner() : adSize3.equals(adSizeFindClosestSize) ? AdSize.mediumRectangle() : adSize4.equals(adSizeFindClosestSize) ? AdSize.large() : adSize5.equals(adSizeFindClosestSize) ? AdSize.leaderboard() : AdSize.banner();
    }

    public static String getAdapterVersion() {
        return BuildConfig.ADAPTER_VERSION;
    }

    @Nullable
    public static ISBannerSize getISBannerSizeFromGoogleAdSize(@NonNull Context context, @NonNull com.google.android.gms.ads.AdSize adSize) {
        ArrayList arrayList = new ArrayList();
        com.google.android.gms.ads.AdSize adSize2 = com.google.android.gms.ads.AdSize.BANNER;
        arrayList.add(adSize2);
        com.google.android.gms.ads.AdSize adSize3 = com.google.android.gms.ads.AdSize.MEDIUM_RECTANGLE;
        arrayList.add(adSize3);
        com.google.android.gms.ads.AdSize adSize4 = com.google.android.gms.ads.AdSize.LARGE_BANNER;
        arrayList.add(adSize4);
        com.google.android.gms.ads.AdSize adSizeFindClosestSize = MediationUtils.findClosestSize(context, adSize, arrayList);
        if (adSizeFindClosestSize == null) {
            return null;
        }
        return adSize2.equals(adSizeFindClosestSize) ? ISBannerSize.BANNER : adSize3.equals(adSizeFindClosestSize) ? ISBannerSize.RECTANGLE : adSize4.equals(adSizeFindClosestSize) ? ISBannerSize.LARGE : new ISBannerSize(adSizeFindClosestSize.getWidth(), adSizeFindClosestSize.getHeight());
    }

    public static String getMediationType() {
        return "AdMob" + prepareVersionToiAdsSdk(getAdapterVersion()) + "SDK" + prepareVersionToiAdsSdk(MobileAds.getVersion().toString()) + "iAds511";
    }

    public static String prepareVersionToiAdsSdk(@NonNull String str) {
        return str.replace(".", "");
    }

    public static AdError validateIronSourceAdLoadParams(@NonNull Context context, @NonNull String str) {
        if (!(context instanceof Activity)) {
            return new AdError(102, "IronSource requires an Activity context to load ads.", "com.google.ads.mediation.ironsource");
        }
        if (TextUtils.isEmpty(str)) {
            return new AdError(101, "Missing or invalid instance ID.", "com.google.ads.mediation.ironsource");
        }
        return null;
    }
}
