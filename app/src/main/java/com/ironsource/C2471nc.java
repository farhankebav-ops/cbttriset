package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.IronSourceNetwork;

/* JADX INFO: renamed from: com.ironsource.nc, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2471nc implements InterfaceC2451mc {
    @Override // com.ironsource.InterfaceC2451mc
    public void a(M9 adInstance) {
        kotlin.jvm.internal.k.e(adInstance, "adInstance");
        try {
            IronSourceNetwork.destroyAd(adInstance);
        } catch (Exception e) {
            C2531r4.d().a(e);
            com.google.android.gms.ads.internal.client.a.r("destroy ad with identifier: ", adInstance.e(), " failed. error: ", e.getMessage(), IronLog.ADAPTER_API);
        }
    }
}
