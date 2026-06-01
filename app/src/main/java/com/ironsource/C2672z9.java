package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.sdk.utils.SDKUtils;
import com.unity3d.ironsourceads.interstitial.InterstitialAdLoaderListener;
import com.unity3d.ironsourceads.interstitial.InterstitialAdRequest;

/* JADX INFO: renamed from: com.ironsource.z9, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2672z9 implements Fb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterstitialAdRequest f10632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InterstitialAdLoaderListener f10633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InterfaceC2279d1 f10634c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final InterfaceC2478o1 f10635d;

    public C2672z9(InterstitialAdRequest adRequest, InterstitialAdLoaderListener publisherListener, InterfaceC2279d1 adapterConfigProvider, InterfaceC2478o1 analyticsFactory) {
        kotlin.jvm.internal.k.e(adRequest, "adRequest");
        kotlin.jvm.internal.k.e(publisherListener, "publisherListener");
        kotlin.jvm.internal.k.e(adapterConfigProvider, "adapterConfigProvider");
        kotlin.jvm.internal.k.e(analyticsFactory, "analyticsFactory");
        this.f10632a = adRequest;
        this.f10633b = publisherListener;
        this.f10634c = adapterConfigProvider;
        this.f10635d = analyticsFactory;
    }

    @Override // com.ironsource.Fb
    public Cb a() throws Exception {
        IronSourceError ironSourceErrorB;
        String instanceId = this.f10632a.getInstanceId();
        String sDKVersion = SDKUtils.getSDKVersion();
        IronSource.a aVar = IronSource.a.INTERSTITIAL;
        kotlin.jvm.internal.k.d(sDKVersion, "getSDKVersion()");
        InterfaceC2495p1 interfaceC2495p1A = this.f10635d.a(new C2386j1(sDKVersion, instanceId, aVar, false, false, false, 56, null));
        try {
            Db dbA = new Eb(this.f10632a.getAdm(), this.f10632a.getProviderName$mediationsdk_release(), this.f10634c, C2415kc.e.a().c().get()).a();
            new C2638x9(dbA).a();
            C2624wc c2624wc = new C2624wc();
            C2423l2 c2423l2 = new C2423l2(this.f10632a.getAdm(), this.f10632a.getProviderName$mediationsdk_release());
            InterstitialAdRequest interstitialAdRequest = this.f10632a;
            kotlin.jvm.internal.k.b(dbA);
            V7 v7 = V7.f7731a;
            return new C2621w9(interstitialAdRequest, dbA, new C2655y9(v7, this.f10633b), c2423l2, c2624wc, interfaceC2495p1A, new C2553s9(interfaceC2495p1A, v7.c()), null, null, 384, null);
        } catch (Exception e) {
            C2531r4.d().a(e);
            if (e instanceof C2508pe) {
                ironSourceErrorB = ((C2508pe) e).a();
            } else {
                C2668z5 c2668z5 = C2668z5.f10625a;
                String message = e.getMessage();
                if (message == null) {
                    message = "unknown error";
                }
                ironSourceErrorB = c2668z5.b(message);
            }
            return new A5(this.f10632a, new C2655y9(V7.f7731a, this.f10633b), interfaceC2495p1A, ironSourceErrorB);
        }
    }

    public /* synthetic */ C2672z9(InterstitialAdRequest interstitialAdRequest, InterstitialAdLoaderListener interstitialAdLoaderListener, InterfaceC2279d1 interfaceC2279d1, InterfaceC2478o1 interfaceC2478o1, int i2, kotlin.jvm.internal.f fVar) {
        this(interstitialAdRequest, interstitialAdLoaderListener, interfaceC2279d1, (i2 & 8) != 0 ? new C2460n1(IronSource.a.INTERSTITIAL) : interfaceC2478o1);
    }
}
