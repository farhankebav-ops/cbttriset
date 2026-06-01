package com.ironsource;

import com.ironsource.sdk.IronSourceNetwork;

/* JADX INFO: renamed from: com.ironsource.wc, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2624wc implements InterfaceC2607vc {
    @Override // com.ironsource.InterfaceC2607vc
    public void a(M9 adInstance, C2641xc loadParams) throws Exception {
        kotlin.jvm.internal.k.e(adInstance, "adInstance");
        kotlin.jvm.internal.k.e(loadParams, "loadParams");
        IronSourceNetwork.loadAd(adInstance, loadParams.a());
    }

    @Override // com.ironsource.InterfaceC2607vc
    public String a() {
        String version = IronSourceNetwork.getVersion();
        kotlin.jvm.internal.k.d(version, "getVersion()");
        return version;
    }
}
