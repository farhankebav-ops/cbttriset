package com.unity3d.ironsourceads.banner;

import a1.a;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class BannerAdInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10869b;

    public BannerAdInfo(String instanceId, String adId) {
        k.e(instanceId, "instanceId");
        k.e(adId, "adId");
        this.f10868a = instanceId;
        this.f10869b = adId;
    }

    public static /* synthetic */ BannerAdInfo copy$default(BannerAdInfo bannerAdInfo, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = bannerAdInfo.f10868a;
        }
        if ((i2 & 2) != 0) {
            str2 = bannerAdInfo.f10869b;
        }
        return bannerAdInfo.copy(str, str2);
    }

    public final String component1() {
        return this.f10868a;
    }

    public final String component2() {
        return this.f10869b;
    }

    public final BannerAdInfo copy(String instanceId, String adId) {
        k.e(instanceId, "instanceId");
        k.e(adId, "adId");
        return new BannerAdInfo(instanceId, adId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BannerAdInfo)) {
            return false;
        }
        BannerAdInfo bannerAdInfo = (BannerAdInfo) obj;
        return k.a(this.f10868a, bannerAdInfo.f10868a) && k.a(this.f10869b, bannerAdInfo.f10869b);
    }

    public final String getAdId() {
        return this.f10869b;
    }

    public final String getInstanceId() {
        return this.f10868a;
    }

    public int hashCode() {
        return this.f10869b.hashCode() + (this.f10868a.hashCode() * 31);
    }

    public String toString() {
        return a.o("[instanceId: '", this.f10868a, "', adId: '", this.f10869b, "']");
    }
}
