package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Z implements Y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC2607vc f7872a;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f7873a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f7874b = 1000;

        private a() {
        }
    }

    public Z(InterfaceC2607vc networkLoadApi) {
        kotlin.jvm.internal.k.e(networkLoadApi, "networkLoadApi");
        this.f7872a = networkLoadApi;
    }

    @Override // com.ironsource.Y
    public String a() {
        return this.f7872a.a();
    }

    @Override // com.ironsource.Y
    public void a(M9 adInstance, Map<String, String> loadParams) {
        kotlin.jvm.internal.k.e(adInstance, "adInstance");
        kotlin.jvm.internal.k.e(loadParams, "loadParams");
        try {
            this.f7872a.a(adInstance, new C2641xc(null, false, 3, null));
        } catch (Exception e) {
            C2531r4.d().a(e);
            com.google.android.gms.ads.internal.client.a.r("load ad with identifier: ", adInstance.e(), " failed. error: ", e.getMessage(), IronLog.ADAPTER_API);
            String strL = a1.a.l("1000: loadAd failed: ", e.getMessage());
            Ic icB = adInstance.b();
            if (icB instanceof C2302e6) {
                Ic icB2 = adInstance.b();
                kotlin.jvm.internal.k.c(icB2, "null cannot be cast to non-null type com.unity3d.ironsourceads.internal.FullScreenAdInstanceListenerWrapper");
                ((C2302e6) icB2).onInterstitialLoadFailed(strL);
            } else if (icB instanceof Kc) {
                Ic icB3 = adInstance.b();
                kotlin.jvm.internal.k.c(icB3, "null cannot be cast to non-null type com.unity3d.ironsourceads.internal.OnBannerListenerWrapper");
                ((Kc) icB3).onBannerLoadFail(strL);
            }
        }
    }
}
