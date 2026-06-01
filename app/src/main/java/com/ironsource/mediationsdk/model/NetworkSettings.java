package com.ironsource.mediationsdk.model;

import android.text.TextUtils;
import com.ironsource.C2531r4;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class NetworkSettings {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f9244r = "customNetwork";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f9245s = "customNetworkPackage";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String f9246t = "customNetworkAdapterName";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONObject f9249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private JSONObject f9250d;
    private JSONObject e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private JSONObject f9251f;
    private JSONObject g;
    private String h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f9252i;
    private boolean j;
    private String k;
    private int l;
    private int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f9253n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f9254o;
    private String p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f9255q;

    public NetworkSettings(String str) {
        this.f9247a = str;
        this.k = str;
        this.f9248b = str;
        this.p = str;
        this.f9255q = str;
        this.f9250d = new JSONObject();
        this.e = new JSONObject();
        this.f9251f = new JSONObject();
        this.g = new JSONObject();
        this.f9249c = new JSONObject();
        this.l = -1;
        this.m = -1;
        this.f9253n = -1;
        this.f9254o = -1;
    }

    public String getAdSourceNameForEvents() {
        return this.f9252i;
    }

    public JSONObject getApplicationSettings() {
        return this.f9249c;
    }

    public int getBannerPriority() {
        return this.f9253n;
    }

    public JSONObject getBannerSettings() {
        return this.f9251f;
    }

    public String getCustomNetwork() {
        JSONObject jSONObject = this.f9249c;
        if (jSONObject != null) {
            return jSONObject.optString("customNetwork");
        }
        return null;
    }

    public String getCustomNetworkAdapterName(IronSource.a aVar) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        JSONObject jSONObject5;
        if (aVar == null && (jSONObject5 = this.f9249c) != null) {
            return jSONObject5.optString(f9246t);
        }
        if (aVar.equals(IronSource.a.REWARDED_VIDEO) && (jSONObject4 = this.f9250d) != null) {
            return jSONObject4.optString(f9246t);
        }
        if (aVar.equals(IronSource.a.INTERSTITIAL) && (jSONObject3 = this.e) != null) {
            return jSONObject3.optString(f9246t);
        }
        if (aVar.equals(IronSource.a.BANNER) && (jSONObject2 = this.f9251f) != null) {
            return jSONObject2.optString(f9246t);
        }
        if (!aVar.equals(IronSource.a.NATIVE_AD) || (jSONObject = this.g) == null) {
            return null;
        }
        return jSONObject.optString(f9246t);
    }

    public String getCustomNetworkPackage() {
        JSONObject jSONObject = this.f9249c;
        return jSONObject != null ? jSONObject.optString(f9245s, "") : "";
    }

    public int getInstanceType(IronSource.a aVar) {
        if (aVar == IronSource.a.REWARDED_VIDEO) {
            return getRewardedVideoSettings().optInt("instanceType");
        }
        if (aVar == IronSource.a.INTERSTITIAL) {
            return getInterstitialSettings().optInt("instanceType");
        }
        if (aVar == IronSource.a.BANNER) {
            return getBannerSettings().optInt("instanceType");
        }
        if (aVar == IronSource.a.NATIVE_AD) {
            return getNativeAdSettings().optInt("instanceType");
        }
        return 1;
    }

    public int getInterstitialPriority() {
        return this.m;
    }

    public JSONObject getInterstitialSettings() {
        return this.e;
    }

    public int getMaxAdsPerSession(IronSource.a aVar) {
        if (aVar == IronSource.a.REWARDED_VIDEO) {
            return getRewardedVideoSettings().optInt("maxAdsPerSession", 99);
        }
        if (aVar == IronSource.a.INTERSTITIAL) {
            return getInterstitialSettings().optInt("maxAdsPerSession", 99);
        }
        if (aVar == IronSource.a.BANNER) {
            return getBannerSettings().optInt("maxAdsPerSession", 99);
        }
        if (aVar == IronSource.a.NATIVE_AD) {
            return getNativeAdSettings().optInt("maxAdsPerSession", 99);
        }
        return 99;
    }

    public int getNativeAdPriority() {
        return this.f9254o;
    }

    public JSONObject getNativeAdSettings() {
        return this.g;
    }

    public String getProviderDefaultInstance() {
        return this.p;
    }

    public String getProviderInstanceName() {
        return this.k;
    }

    public String getProviderName() {
        return this.f9247a;
    }

    public String getProviderNetworkKey() {
        return this.f9255q;
    }

    public String getProviderTypeForReflection() {
        return this.f9248b;
    }

    public int getRewardedVideoPriority() {
        return this.l;
    }

    public JSONObject getRewardedVideoSettings() {
        return this.f9250d;
    }

    public String getSubProviderId() {
        return this.h;
    }

    public boolean isBidder(IronSource.a aVar) {
        return !isCustomNetwork() && getInstanceType(aVar) == 2;
    }

    public boolean isCustomNetwork() {
        return !TextUtils.isEmpty(getCustomNetwork());
    }

    public boolean isIronSource() {
        return getProviderTypeForReflection().equalsIgnoreCase("IronSource");
    }

    public boolean isMultipleInstances() {
        return this.j;
    }

    public void setAdSourceNameForEvents(String str) {
        this.f9252i = str;
    }

    public void setApplicationSettings(JSONObject jSONObject) {
        this.f9249c = jSONObject;
    }

    public void setBannerPriority(int i2) {
        this.f9253n = i2;
    }

    public void setBannerSettings(JSONObject jSONObject) {
        this.f9251f = jSONObject;
    }

    public void setInterstitialPriority(int i2) {
        this.m = i2;
    }

    public void setInterstitialSettings(JSONObject jSONObject) {
        this.e = jSONObject;
    }

    public void setIsMultipleInstances(boolean z2) {
        this.j = z2;
    }

    public void setNativeAdPriority(int i2) {
        this.f9254o = i2;
    }

    public void setNativeAdSettings(JSONObject jSONObject) {
        this.g = jSONObject;
    }

    public void setProviderNetworkKey(String str) {
        this.f9255q = str;
    }

    public void setRewardedVideoPriority(int i2) {
        this.l = i2;
    }

    public void setRewardedVideoSettings(JSONObject jSONObject) {
        this.f9250d = jSONObject;
    }

    public void setSubProviderId(String str) {
        this.h = str;
    }

    public boolean shouldEarlyInit() {
        JSONObject jSONObject = this.f9249c;
        if (jSONObject != null) {
            return jSONObject.optBoolean(IronSourceConstants.EARLY_INIT_FIELD);
        }
        return false;
    }

    public void setBannerSettings(String str, Object obj) {
        try {
            this.f9251f.put(str, obj);
        } catch (JSONException e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    public void setInterstitialSettings(String str, Object obj) {
        try {
            this.e.put(str, obj);
        } catch (JSONException e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    public void setNativeAdSettings(String str, Object obj) {
        try {
            this.g.put(str, obj);
        } catch (JSONException e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    public void setRewardedVideoSettings(String str, Object obj) {
        try {
            this.f9250d.put(str, obj);
        } catch (JSONException e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    public NetworkSettings(String str, String str2, String str3, String str4, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5) {
        this.f9247a = str;
        this.k = str;
        this.f9248b = str2;
        this.p = str3;
        this.f9255q = str4;
        this.f9250d = jSONObject2;
        this.e = jSONObject3;
        this.f9251f = jSONObject4;
        this.g = jSONObject5;
        this.f9249c = jSONObject;
        this.l = -1;
        this.m = -1;
        this.f9253n = -1;
        this.f9254o = -1;
    }

    public NetworkSettings(NetworkSettings networkSettings) {
        this.f9247a = networkSettings.getProviderName();
        this.k = networkSettings.getProviderName();
        this.f9248b = networkSettings.getProviderTypeForReflection();
        this.f9250d = networkSettings.getRewardedVideoSettings();
        this.e = networkSettings.getInterstitialSettings();
        this.f9251f = networkSettings.getBannerSettings();
        this.g = networkSettings.getNativeAdSettings();
        this.f9249c = networkSettings.getApplicationSettings();
        this.l = networkSettings.getRewardedVideoPriority();
        this.m = networkSettings.getInterstitialPriority();
        this.f9253n = networkSettings.getBannerPriority();
        this.f9254o = networkSettings.getNativeAdPriority();
        this.p = networkSettings.getProviderDefaultInstance();
        this.f9255q = networkSettings.getProviderNetworkKey();
    }
}
