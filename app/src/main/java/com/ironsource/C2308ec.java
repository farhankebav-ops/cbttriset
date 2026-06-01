package com.ironsource;

import android.app.Activity;
import com.ironsource.AbstractC2547s3;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.ads.nativead.AdapterNativeAdData;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNativeAdInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import com.ironsource.mediationsdk.adunit.adapter.listener.NativeAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: renamed from: com.ironsource.ec, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2308ec extends AbstractC2547s3<Q0> implements NativeAdListener, C0 {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private AdapterNativeAdData f8458r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private AdapterNativeAdViewBinder f8459s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2308ec(InterfaceC2591ud threadInterface, C2421l0 adSmashData, BaseAdAdapter<?, AdapterAdListener> baseAdAdapter, C2434ld c2434ld, C2461n2 item, Q0 q02) {
        super(threadInterface, adSmashData, baseAdAdapter, new C2243b1(adSmashData.g(), adSmashData.g().getNativeAdSettings(), IronSource.a.NATIVE_AD), item, q02);
        kotlin.jvm.internal.k.e(threadInterface, "threadInterface");
        kotlin.jvm.internal.k.e(adSmashData, "adSmashData");
        kotlin.jvm.internal.k.e(item, "item");
        this.g = c2434ld;
    }

    private final void J() {
        C2294dg c2294dg;
        IronLog.INTERNAL.verbose(d());
        if (y()) {
            super.onAdOpened();
            return;
        }
        if (this.e != AbstractC2547s3.h.FAILED) {
            String str = String.format("unexpected onAdOpened for %s, state - %s", Arrays.copyOf(new Object[]{k(), this.e}, 2));
            D0 d0 = this.f9794d;
            if (d0 == null || (c2294dg = d0.j) == null) {
                return;
            }
            c2294dg.q(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C2308ec this$0, AdapterNativeAdData adapterNativeAdData, AdapterNativeAdViewBinder nativeAdViewBinder) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(adapterNativeAdData, "$adapterNativeAdData");
        kotlin.jvm.internal.k.e(nativeAdViewBinder, "$nativeAdViewBinder");
        this$0.a(adapterNativeAdData, nativeAdViewBinder);
    }

    @Override // com.ironsource.AbstractC2547s3
    public void G() {
        C2294dg c2294dg;
        if (!(this.f9793c instanceof AdapterNativeAdInterface)) {
            IronLog.INTERNAL.error(a("adapter not instance of AdapterNativeAdInterface"));
            return;
        }
        if (ContextProvider.getInstance().getCurrentActiveActivity() == null) {
            IronLog.INTERNAL.error(a("activity must not be null"));
            D0 d0 = this.f9794d;
            if (d0 == null || (c2294dg = d0.j) == null) {
                return;
            }
            c2294dg.g("activity must not be null");
            return;
        }
        Object obj = this.f9793c;
        kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNativeAdInterface<com.ironsource.mediationsdk.adunit.adapter.listener.NativeAdListener>");
        AdData mCurrentAdData = this.k;
        kotlin.jvm.internal.k.d(mCurrentAdData, "mCurrentAdData");
        Activity currentActiveActivity = ContextProvider.getInstance().getCurrentActiveActivity();
        kotlin.jvm.internal.k.d(currentActiveActivity, "getInstance().currentActiveActivity");
        ((AdapterNativeAdInterface) obj).loadAd(mCurrentAdData, currentActiveActivity, this);
    }

    public final AdapterNativeAdViewBinder R() {
        return this.f8459s;
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.listener.NativeAdListener
    public void onAdLoadSuccess(AdapterNativeAdData adapterNativeAdData, AdapterNativeAdViewBinder nativeAdViewBinder) {
        kotlin.jvm.internal.k.e(adapterNativeAdData, "adapterNativeAdData");
        kotlin.jvm.internal.k.e(nativeAdViewBinder, "nativeAdViewBinder");
        if (u().e()) {
            u().a(new androidx.camera.core.processing.c(this, adapterNativeAdData, nativeAdViewBinder, 22));
        } else {
            a(adapterNativeAdData, nativeAdViewBinder);
        }
    }

    @Override // com.ironsource.AbstractC2547s3, com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdOpened() {
        if (u().e()) {
            u().a(new ch(this, 9));
        } else {
            J();
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdShowFailed(int i2, String str) {
        throw new q5.h("An operation is not implemented: Not yet implemented");
    }

    private final void a(AdapterNativeAdData adapterNativeAdData, AdapterNativeAdViewBinder adapterNativeAdViewBinder) {
        this.f8458r = adapterNativeAdData;
        this.f8459s = adapterNativeAdViewBinder;
        super.onAdLoadSuccess();
    }

    public final void P() {
        C2294dg c2294dg;
        Ab ab;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(k());
        a(AbstractC2547s3.h.NONE);
        Object obj = this.f9793c;
        if (obj == null) {
            ironLog.warning("mAdapter == null");
            return;
        }
        try {
            if (obj instanceof AdapterNativeAdInterface) {
                AdData mCurrentAdData = this.k;
                kotlin.jvm.internal.k.d(mCurrentAdData, "mCurrentAdData");
                ((AdapterNativeAdInterface) obj).destroyAd(mCurrentAdData);
            } else {
                ironLog.error(a("adapter not instance of AdapterNativeAdInterface"));
            }
        } catch (Throwable th) {
            C2531r4.d().a(th);
            String strL = a1.a.l("destroyNativeAd - exception = ", th.getLocalizedMessage());
            IronLog.INTERNAL.error(a(strL));
            D0 d0 = this.f9794d;
            if (d0 != null && (c2294dg = d0.j) != null) {
                c2294dg.g(strL);
            }
        }
        D0 d02 = this.f9794d;
        if (d02 == null || (ab = d02.f6419f) == null) {
            return;
        }
        Integer sessionDepth = r();
        kotlin.jvm.internal.k.d(sessionDepth, "sessionDepth");
        ab.a(sessionDepth.intValue());
    }

    public final AdapterNativeAdData Q() {
        return this.f8458r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C2308ec this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        this$0.J();
    }

    @Override // com.ironsource.AbstractC2547s3, com.ironsource.C0
    public Map<String, Object> a(A0 event) {
        kotlin.jvm.internal.k.e(event, "event");
        Map<String, Object> data = super.a(event);
        if (this.g != null) {
            kotlin.jvm.internal.k.d(data, "data");
            data.put("placement", j());
        }
        kotlin.jvm.internal.k.d(data, "data");
        return data;
    }
}
