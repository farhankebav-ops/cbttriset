package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.sdk.utils.SDKUtils;
import com.unity3d.ironsourceads.AdSize;
import com.unity3d.ironsourceads.banner.BannerAdLoaderListener;
import com.unity3d.ironsourceads.banner.BannerAdRequest;

/* JADX INFO: renamed from: com.ironsource.g3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2335g3 implements Fb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BannerAdRequest f8567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BannerAdLoaderListener f8568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InterfaceC2279d1 f8569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final InterfaceC2478o1 f8570d;

    public C2335g3(BannerAdRequest adRequest, BannerAdLoaderListener publisherListener, InterfaceC2279d1 adapterConfigProvider, InterfaceC2478o1 analyticsFactory) {
        kotlin.jvm.internal.k.e(adRequest, "adRequest");
        kotlin.jvm.internal.k.e(publisherListener, "publisherListener");
        kotlin.jvm.internal.k.e(adapterConfigProvider, "adapterConfigProvider");
        kotlin.jvm.internal.k.e(analyticsFactory, "analyticsFactory");
        this.f8567a = adRequest;
        this.f8568b = publisherListener;
        this.f8569c = adapterConfigProvider;
        this.f8570d = analyticsFactory;
    }

    @Override // com.ironsource.Fb
    public Cb a() throws Exception {
        IronSourceError ironSourceErrorA;
        String instanceId = this.f8567a.getInstanceId();
        String sDKVersion = SDKUtils.getSDKVersion();
        IronSource.a aVar = IronSource.a.BANNER;
        kotlin.jvm.internal.k.d(sDKVersion, "getSDKVersion()");
        InterfaceC2495p1 interfaceC2495p1A = this.f8570d.a(new C2386j1(sDKVersion, instanceId, aVar, false, false, false, 56, null));
        try {
            Db dbA = new Eb(this.f8567a.getAdm(), this.f8567a.getProviderName$mediationsdk_release(), this.f8569c, C2415kc.e.a().c().get()).a();
            new C2299e3(dbA, this.f8567a.getSize()).a();
            C2624wc c2624wc = new C2624wc();
            C2423l2 c2423l2 = new C2423l2(this.f8567a.getAdm(), this.f8567a.getProviderName$mediationsdk_release());
            BannerAdRequest bannerAdRequest = this.f8567a;
            AdSize size = bannerAdRequest.getSize();
            kotlin.jvm.internal.k.b(dbA);
            V7 v7 = V7.f7731a;
            return new C2281d3(bannerAdRequest, size, c2423l2, dbA, c2624wc, interfaceC2495p1A, new C2317f3(v7, this.f8568b), new F2(interfaceC2495p1A, v7.c()), null, null, 768, null);
        } catch (Exception e) {
            C2531r4.d().a(e);
            if (e instanceof C2508pe) {
                ironSourceErrorA = ((C2508pe) e).a();
            } else {
                C2668z5 c2668z5 = C2668z5.f10625a;
                String message = e.getMessage();
                if (message == null) {
                    message = "Unknown error";
                }
                ironSourceErrorA = c2668z5.a(message);
            }
            return new C2651y5(ironSourceErrorA, new C2317f3(V7.f7731a, this.f8568b), interfaceC2495p1A);
        }
    }

    public /* synthetic */ C2335g3(BannerAdRequest bannerAdRequest, BannerAdLoaderListener bannerAdLoaderListener, InterfaceC2279d1 interfaceC2279d1, InterfaceC2478o1 interfaceC2478o1, int i2, kotlin.jvm.internal.f fVar) {
        this(bannerAdRequest, bannerAdLoaderListener, interfaceC2279d1, (i2 & 8) != 0 ? new C2460n1(IronSource.a.BANNER) : interfaceC2478o1);
    }
}
