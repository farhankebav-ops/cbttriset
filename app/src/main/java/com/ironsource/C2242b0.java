package com.ironsource;

import android.app.Activity;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.HashMap;

/* JADX INFO: renamed from: com.ironsource.b0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2242b0 implements InterfaceC2224a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bc f8025a;

    public C2242b0(Bc networkShowApi) {
        kotlin.jvm.internal.k.e(networkShowApi, "networkShowApi");
        this.f8025a = networkShowApi;
    }

    @Override // com.ironsource.InterfaceC2224a0
    public void a(Activity activity, M9 adInstance) {
        kotlin.jvm.internal.k.e(activity, "activity");
        kotlin.jvm.internal.k.e(adInstance, "adInstance");
        com.google.android.gms.ads.internal.client.a.r("Show: networkInstanceId=", adInstance.g(), " adInstanceId=", adInstance.e(), IronLog.ADAPTER_API);
        this.f8025a.a(activity, adInstance, new HashMap());
    }

    @Override // com.ironsource.InterfaceC2224a0
    public boolean a(M9 adInstance) {
        kotlin.jvm.internal.k.e(adInstance, "adInstance");
        return this.f8025a.a(adInstance);
    }
}
