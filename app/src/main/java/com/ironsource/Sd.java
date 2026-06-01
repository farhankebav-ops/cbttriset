package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.sdk.utils.SDKUtils;
import com.unity3d.ironsourceads.rewarded.RewardedAdLoaderListener;
import com.unity3d.ironsourceads.rewarded.RewardedAdRequest;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Sd implements Fb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RewardedAdRequest f7602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RewardedAdLoaderListener f7603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InterfaceC2279d1 f7604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final InterfaceC2478o1 f7605d;

    public Sd(RewardedAdRequest adRequest, RewardedAdLoaderListener publisherListener, InterfaceC2279d1 adapterConfigProvider, InterfaceC2478o1 analyticsFactory) {
        kotlin.jvm.internal.k.e(adRequest, "adRequest");
        kotlin.jvm.internal.k.e(publisherListener, "publisherListener");
        kotlin.jvm.internal.k.e(adapterConfigProvider, "adapterConfigProvider");
        kotlin.jvm.internal.k.e(analyticsFactory, "analyticsFactory");
        this.f7602a = adRequest;
        this.f7603b = publisherListener;
        this.f7604c = adapterConfigProvider;
        this.f7605d = analyticsFactory;
    }

    @Override // com.ironsource.Fb
    public Cb a() throws Exception {
        IronSourceError ironSourceErrorD;
        String instanceId = this.f7602a.getInstanceId();
        String sDKVersion = SDKUtils.getSDKVersion();
        IronSource.a aVar = IronSource.a.REWARDED_VIDEO;
        kotlin.jvm.internal.k.d(sDKVersion, "getSDKVersion()");
        InterfaceC2495p1 interfaceC2495p1A = this.f7605d.a(new C2386j1(sDKVersion, instanceId, aVar, false, false, false, 56, null));
        try {
            Db dbA = new Eb(this.f7602a.getAdm(), this.f7602a.getProviderName$mediationsdk_release(), this.f7604c, C2415kc.e.a().c().get()).a();
            new Qd(dbA).a();
            C2624wc c2624wc = new C2624wc();
            C2423l2 c2423l2 = new C2423l2(this.f7602a.getAdm(), this.f7602a.getProviderName$mediationsdk_release());
            RewardedAdRequest rewardedAdRequest = this.f7602a;
            kotlin.jvm.internal.k.b(dbA);
            V7 v7 = V7.f7731a;
            return new Pd(rewardedAdRequest, dbA, new Rd(v7, this.f7603b), c2423l2, c2624wc, interfaceC2495p1A, new Kd(interfaceC2495p1A, v7.c()), null, null, 384, null);
        } catch (Exception e) {
            C2531r4.d().a(e);
            if (e instanceof C2508pe) {
                ironSourceErrorD = ((C2508pe) e).a();
            } else {
                C2668z5 c2668z5 = C2668z5.f10625a;
                String message = e.getMessage();
                if (message == null) {
                    message = "Unknown error";
                }
                ironSourceErrorD = c2668z5.d(message);
            }
            return new B5(this.f7602a, new Rd(V7.f7731a, this.f7603b), interfaceC2495p1A, ironSourceErrorD);
        }
    }

    public /* synthetic */ Sd(RewardedAdRequest rewardedAdRequest, RewardedAdLoaderListener rewardedAdLoaderListener, InterfaceC2279d1 interfaceC2279d1, InterfaceC2478o1 interfaceC2478o1, int i2, kotlin.jvm.internal.f fVar) {
        this(rewardedAdRequest, rewardedAdLoaderListener, interfaceC2279d1, (i2 & 8) != 0 ? new C2460n1(IronSource.a.REWARDED_VIDEO) : interfaceC2478o1);
    }
}
