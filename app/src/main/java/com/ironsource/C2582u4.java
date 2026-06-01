package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.u4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2582u4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f10385d;

    public C2582u4() {
        this(null, null, null, null, 15, null);
    }

    public final String a() {
        return this.f10382a;
    }

    public final String b() {
        return this.f10383b;
    }

    public final String c() {
        return this.f10384c;
    }

    public final String d() {
        return this.f10385d;
    }

    public final String e() {
        return this.f10385d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2582u4)) {
            return false;
        }
        C2582u4 c2582u4 = (C2582u4) obj;
        return kotlin.jvm.internal.k.a(this.f10382a, c2582u4.f10382a) && kotlin.jvm.internal.k.a(this.f10383b, c2582u4.f10383b) && kotlin.jvm.internal.k.a(this.f10384c, c2582u4.f10384c) && kotlin.jvm.internal.k.a(this.f10385d, c2582u4.f10385d);
    }

    public final String f() {
        return this.f10384c;
    }

    public final String g() {
        return this.f10382a;
    }

    public final String h() {
        return this.f10383b;
    }

    public int hashCode() {
        return this.f10385d.hashCode() + androidx.camera.core.processing.util.a.b(androidx.camera.core.processing.util.a.b(this.f10382a.hashCode() * 31, 31, this.f10383b), 31, this.f10384c);
    }

    public String toString() {
        String str = this.f10382a;
        String str2 = this.f10383b;
        return androidx.camera.core.processing.util.a.n(a1.a.z("CustomAdapterSettings(customNetworkAdapterName=", str, ", customRewardedVideoAdapterName=", str2, ", customInterstitialAdapterName="), this.f10384c, ", customBannerAdapterName=", this.f10385d, ")");
    }

    public C2582u4(String customNetworkAdapterName, String customRewardedVideoAdapterName, String customInterstitialAdapterName, String customBannerAdapterName) {
        kotlin.jvm.internal.k.e(customNetworkAdapterName, "customNetworkAdapterName");
        kotlin.jvm.internal.k.e(customRewardedVideoAdapterName, "customRewardedVideoAdapterName");
        kotlin.jvm.internal.k.e(customInterstitialAdapterName, "customInterstitialAdapterName");
        kotlin.jvm.internal.k.e(customBannerAdapterName, "customBannerAdapterName");
        this.f10382a = customNetworkAdapterName;
        this.f10383b = customRewardedVideoAdapterName;
        this.f10384c = customInterstitialAdapterName;
        this.f10385d = customBannerAdapterName;
    }

    public final C2582u4 a(String customNetworkAdapterName, String customRewardedVideoAdapterName, String customInterstitialAdapterName, String customBannerAdapterName) {
        kotlin.jvm.internal.k.e(customNetworkAdapterName, "customNetworkAdapterName");
        kotlin.jvm.internal.k.e(customRewardedVideoAdapterName, "customRewardedVideoAdapterName");
        kotlin.jvm.internal.k.e(customInterstitialAdapterName, "customInterstitialAdapterName");
        kotlin.jvm.internal.k.e(customBannerAdapterName, "customBannerAdapterName");
        return new C2582u4(customNetworkAdapterName, customRewardedVideoAdapterName, customInterstitialAdapterName, customBannerAdapterName);
    }

    public static /* synthetic */ C2582u4 a(C2582u4 c2582u4, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = c2582u4.f10382a;
        }
        if ((i2 & 2) != 0) {
            str2 = c2582u4.f10383b;
        }
        if ((i2 & 4) != 0) {
            str3 = c2582u4.f10384c;
        }
        if ((i2 & 8) != 0) {
            str4 = c2582u4.f10385d;
        }
        return c2582u4.a(str, str2, str3, str4);
    }

    public /* synthetic */ C2582u4(String str, String str2, String str3, String str4, int i2, kotlin.jvm.internal.f fVar) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4);
    }
}
