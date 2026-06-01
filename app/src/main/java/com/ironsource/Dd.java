package com.ironsource;

import android.text.TextUtils;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class Dd {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Dd f6622b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, NetworkSettings> f6623a = new ConcurrentHashMap<>();

    private Dd() {
    }

    public static synchronized Dd c() {
        try {
            if (f6622b == null) {
                f6622b = new Dd();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f6622b;
    }

    public void a(NetworkSettings networkSettings) {
        if (networkSettings == null || TextUtils.isEmpty(networkSettings.getProviderName())) {
            return;
        }
        this.f6623a.put(networkSettings.getProviderName(), networkSettings);
    }

    public NetworkSettings b(String str) {
        NetworkSettings networkSettings = this.f6623a.get(str);
        if (networkSettings != null) {
            return networkSettings;
        }
        NetworkSettings networkSettings2 = new NetworkSettings(str);
        a(networkSettings2);
        return networkSettings2;
    }

    public ConcurrentHashMap<String, NetworkSettings> d() {
        return this.f6623a;
    }

    public void a() {
        this.f6623a.clear();
    }

    public NetworkSettings c(String str) {
        for (NetworkSettings networkSettings : this.f6623a.values()) {
            if ("IronSource".equals(networkSettings.getProviderTypeForReflection()) && str.equalsIgnoreCase(networkSettings.getSubProviderId())) {
                return networkSettings;
            }
        }
        return new NetworkSettings(str);
    }

    public HashSet<String> a(String str, String str2) {
        HashSet<String> hashSet = new HashSet<>();
        try {
            for (NetworkSettings networkSettings : this.f6623a.values()) {
                if (networkSettings.getProviderTypeForReflection().equals(str)) {
                    if (networkSettings.getRewardedVideoSettings() != null && networkSettings.getRewardedVideoSettings().length() > 0 && !TextUtils.isEmpty(networkSettings.getRewardedVideoSettings().optString(str2))) {
                        hashSet.add(networkSettings.getRewardedVideoSettings().optString(str2));
                    }
                    if (networkSettings.getInterstitialSettings() != null && networkSettings.getInterstitialSettings().length() > 0 && !TextUtils.isEmpty(networkSettings.getInterstitialSettings().optString(str2))) {
                        hashSet.add(networkSettings.getInterstitialSettings().optString(str2));
                    }
                    if (networkSettings.getBannerSettings() != null && networkSettings.getBannerSettings().length() > 0 && !TextUtils.isEmpty(networkSettings.getBannerSettings().optString(str2))) {
                        hashSet.add(networkSettings.getBannerSettings().optString(str2));
                    }
                    if (networkSettings.getNativeAdSettings() != null && networkSettings.getNativeAdSettings().length() > 0 && !TextUtils.isEmpty(networkSettings.getNativeAdSettings().optString(str2))) {
                        hashSet.add(networkSettings.getNativeAdSettings().optString(str2));
                    }
                }
            }
            return hashSet;
        } catch (Exception e) {
            C2531r4.d().a(e);
            return hashSet;
        }
    }

    public void b() {
        for (NetworkSettings networkSettings : this.f6623a.values()) {
            if (networkSettings.isMultipleInstances() && !TextUtils.isEmpty(networkSettings.getProviderTypeForReflection())) {
                NetworkSettings networkSettingsB = b(networkSettings.getProviderDefaultInstance());
                networkSettings.setApplicationSettings(IronSourceUtils.b(networkSettings.getApplicationSettings(), networkSettingsB.getApplicationSettings()));
                networkSettings.setInterstitialSettings(IronSourceUtils.b(networkSettings.getInterstitialSettings(), networkSettingsB.getInterstitialSettings()));
                networkSettings.setRewardedVideoSettings(IronSourceUtils.b(networkSettings.getRewardedVideoSettings(), networkSettingsB.getRewardedVideoSettings()));
                networkSettings.setBannerSettings(IronSourceUtils.b(networkSettings.getBannerSettings(), networkSettingsB.getBannerSettings()));
                networkSettings.setNativeAdSettings(IronSourceUtils.b(networkSettings.getNativeAdSettings(), networkSettingsB.getNativeAdSettings()));
            }
        }
    }

    public boolean a(String str) {
        return this.f6623a.containsKey(str);
    }
}
