package com.ironsource;

import android.content.Context;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.ads.nativead.AdapterNativeAdData;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNativeAdInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import com.ironsource.mediationsdk.adunit.adapter.listener.NativeAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.logger.IronLog;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Xb extends AbstractC2662z implements NativeAdListener {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private AdapterNativeAdData f7797x;
    private AdapterNativeAdViewBinder y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Xb(V0 adTools, A instanceData, G adInstancePayload, D listener) {
        super(adTools, instanceData, adInstancePayload, listener);
        kotlin.jvm.internal.k.e(adTools, "adTools");
        kotlin.jvm.internal.k.e(instanceData, "instanceData");
        kotlin.jvm.internal.k.e(adInstancePayload, "adInstancePayload");
        kotlin.jvm.internal.k.e(listener, "listener");
    }

    @Override // com.ironsource.AbstractC2662z
    public void A() {
        if (!(g() instanceof AdapterNativeAdInterface)) {
            IronLog.INTERNAL.error(a("adapter not instance of AdapterNativeAdInterface"));
            return;
        }
        AdData adDataI = i();
        if (ContextProvider.getInstance().getCurrentActiveActivity() == null) {
            IronLog.INTERNAL.error(a("activity must not be null"));
            f().e().h().g("activity must not be null");
            return;
        }
        Object objG = g();
        kotlin.jvm.internal.k.c(objG, "null cannot be cast to non-null type com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNativeAdInterface<com.ironsource.mediationsdk.adunit.adapter.listener.NativeAdListener>");
        Context activeContext = ContextProvider.getInstance().getActiveContext();
        kotlin.jvm.internal.k.d(activeContext, "getInstance().activeContext");
        ((AdapterNativeAdInterface) objG).loadAd(adDataI, activeContext, this);
    }

    public final AdapterNativeAdData I() {
        return this.f7797x;
    }

    public final AdapterNativeAdViewBinder J() {
        return this.y;
    }

    @Override // com.ironsource.AbstractC2662z
    public void a(I adInstancePresenter) {
        kotlin.jvm.internal.k.e(adInstancePresenter, "adInstancePresenter");
        adInstancePresenter.a(this);
    }

    @Override // com.ironsource.AbstractC2662z
    public void b() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(q());
        if (g() == null) {
            ironLog.warning("adapter == null");
            return;
        }
        try {
            if (g() instanceof AdapterNativeAdInterface) {
                Object objG = g();
                kotlin.jvm.internal.k.c(objG, "null cannot be cast to non-null type com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNativeAdInterface<*>");
                ((AdapterNativeAdInterface) objG).destroyAd(i());
            } else {
                ironLog.error(a("adapter not instance of AdapterNativeAdInterface"));
            }
        } catch (Throwable th) {
            C2531r4.d().a(th);
            String strL = a1.a.l("destroyNativeAd - exception = ", th.getLocalizedMessage());
            IronLog.INTERNAL.error(a(strL));
            f().e().h().g(strL);
        }
        super.b();
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.listener.NativeAdListener
    public void onAdLoadSuccess(AdapterNativeAdData adapterNativeAdData, AdapterNativeAdViewBinder nativeAdViewBinder) {
        kotlin.jvm.internal.k.e(adapterNativeAdData, "adapterNativeAdData");
        kotlin.jvm.internal.k.e(nativeAdViewBinder, "nativeAdViewBinder");
        this.f7797x = adapterNativeAdData;
        this.y = nativeAdViewBinder;
        super.onAdLoadSuccess();
    }

    public final void a(Qb nativeAdBinder) {
        kotlin.jvm.internal.k.e(nativeAdBinder, "nativeAdBinder");
        nativeAdBinder.a(this.f7797x);
        nativeAdBinder.a(this.y);
    }
}
