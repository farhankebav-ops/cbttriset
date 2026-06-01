package com.unity3d.ironsourceads.interstitial;

import a1.a;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InterstitialAdInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10885b;

    public InterstitialAdInfo(String instanceId, String adId) {
        k.e(instanceId, "instanceId");
        k.e(adId, "adId");
        this.f10884a = instanceId;
        this.f10885b = adId;
    }

    public final String getAdId() {
        return this.f10885b;
    }

    public final String getInstanceId() {
        return this.f10884a;
    }

    public String toString() {
        return a.o("[instanceId: '", this.f10884a, "', adId: '", this.f10885b, "']");
    }
}
