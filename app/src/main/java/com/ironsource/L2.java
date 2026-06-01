package com.ironsource;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.AbstractC2547s3;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBannerInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBindAdViewInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener;
import com.ironsource.mediationsdk.adunit.adapter.listener.BannerAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class L2 extends AbstractC2547s3<InterfaceC2527r0> implements BannerAdListener, C0 {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f7079t = "bannerLayout";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f7080u = "bannerSize";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final com.ironsource.mediationsdk.q f7081r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final boolean f7082s;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a extends AbstractRunnableC2382ie {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f7083b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ FrameLayout.LayoutParams f7084c;

        public a(View view, FrameLayout.LayoutParams layoutParams) {
            this.f7083b = view;
            this.f7084c = layoutParams;
        }

        @Override // com.ironsource.AbstractRunnableC2382ie
        public void a() {
            L2.this.a(this.f7083b, this.f7084c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class b extends AbstractRunnableC2382ie {
        public b() {
        }

        @Override // com.ironsource.AbstractRunnableC2382ie
        public void a() {
            L2.this.J();
        }
    }

    public L2(InterfaceC2591ud interfaceC2591ud, C2421l0 c2421l0, BaseAdAdapter<?, AdapterAdViewListener> baseAdAdapter, com.ironsource.mediationsdk.q qVar, C2434ld c2434ld, boolean z2, C2461n2 c2461n2, InterfaceC2527r0 interfaceC2527r0) {
        super(interfaceC2591ud, c2421l0, baseAdAdapter, new C2243b1(c2421l0.g(), c2421l0.g().getBannerSettings(), IronSource.a.BANNER), c2461n2, interfaceC2527r0);
        this.f7081r = qVar;
        this.g = c2434ld;
        this.f7082s = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(d());
        if (y()) {
            super.onAdOpened();
            return;
        }
        if (this.e == AbstractC2547s3.h.FAILED) {
            return;
        }
        ironLog.error("unexpected onAdOpened for " + k() + ", state - " + this.e);
        if (this.f9794d != null) {
            this.f9794d.j.q("unexpected onAdOpened, state - " + this.e);
        }
    }

    @Override // com.ironsource.AbstractC2547s3
    public void G() {
        Object obj = this.f9793c;
        if (obj instanceof AdapterBannerInterface) {
            ((AdapterBannerInterface) obj).loadAd(this.k, ContextProvider.getInstance().getCurrentActiveActivity(), this.f7081r.getSize(), this);
        } else {
            IronLog.INTERNAL.error(a("adapter not instance of AdapterBannerInterface"));
        }
    }

    @Override // com.ironsource.AbstractC2547s3
    public boolean O() {
        return false;
    }

    public void R() {
        Object obj = this.f9793c;
        if (obj instanceof AdapterBindAdViewInterface) {
            ((AdapterBindAdViewInterface) obj).onAdViewWillBind(this.k);
        }
    }

    @Override // com.ironsource.AbstractC2547s3
    public AdData a(String str, Map<String, Object> map) {
        return new AdData(str, q(), a(map));
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public final /* synthetic */ void onAdLeftApplication(Map map) {
        b3.d.a(this, map);
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public final /* synthetic */ void onAdLoadSuccess(View view, FrameLayout.LayoutParams layoutParams, Map map) {
        b3.d.b(this, view, layoutParams, map);
    }

    @Override // com.ironsource.AbstractC2547s3, com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdOpened() {
        if (u().e()) {
            u().a(new b());
        } else {
            J();
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public final /* synthetic */ void onAdScreenDismissed(Map map) {
        b3.d.c(this, map);
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public final /* synthetic */ void onAdScreenPresented(Map map) {
        b3.d.d(this, map);
    }

    @Override // com.ironsource.AbstractC2547s3
    public boolean v() {
        return this.f7082s;
    }

    public void P() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(k());
        a(AbstractC2547s3.h.NONE);
        Object obj = this.f9793c;
        if (obj == null) {
            ironLog.warning("mAdapter == null");
            return;
        }
        try {
            if (obj instanceof AdapterBannerInterface) {
                ((AdapterBannerInterface) obj).destroyAd(this.k);
            } else {
                ironLog.error(a("adapter not instance of AdapterBannerInterface"));
            }
        } catch (Throwable th) {
            C2531r4.d().a(th);
            String str = "destroyBanner - exception = " + th.getLocalizedMessage() + " state = " + this.e;
            IronLog.INTERNAL.error(a(str));
            D0 d0 = this.f9794d;
            if (d0 != null) {
                d0.j.g(str);
            }
        }
        D0 d02 = this.f9794d;
        if (d02 != null) {
            d02.f6419f.a(r().intValue());
        }
    }

    public void Q() {
        Object obj = this.f9793c;
        if (obj instanceof AdapterBindAdViewInterface) {
            ((AdapterBindAdViewInterface) obj).onAdViewBound(this.k);
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public void onAdLeftApplication() {
        D0 d0;
        C2434ld c2434ld = this.g;
        if (c2434ld != null && (d0 = this.f9794d) != null) {
            d0.f6420i.f(c2434ld.c());
        }
        Listener listener = this.f9792b;
        if (listener != 0) {
            ((InterfaceC2527r0) listener).c(this);
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public void onAdLoadSuccess(View view, FrameLayout.LayoutParams layoutParams) {
        if (u().e()) {
            u().a(new a(view, layoutParams));
        } else {
            a(view, layoutParams);
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public void onAdScreenDismissed() {
        D0 d0;
        C2434ld c2434ld = this.g;
        if (c2434ld != null && (d0 = this.f9794d) != null) {
            d0.f6420i.c(c2434ld.c());
        }
        Listener listener = this.f9792b;
        if (listener != 0) {
            ((InterfaceC2527r0) listener).b(this);
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public void onAdScreenPresented() {
        D0 d0;
        C2434ld c2434ld = this.g;
        if (c2434ld != null && (d0 = this.f9794d) != null) {
            d0.f6420i.h(c2434ld.c());
        }
        Listener listener = this.f9792b;
        if (listener != 0) {
            ((InterfaceC2527r0) listener).f(this);
        }
    }

    @Override // com.ironsource.AbstractC2547s3
    public Map<String, Object> a(Map<String, Object> map) {
        Map<String, Object> mapA = super.a(map);
        C2421l0 c2421l0 = this.f9791a;
        if (c2421l0 != null && this.f7081r != null && TextUtils.isEmpty(c2421l0.g().getCustomNetwork())) {
            mapA.put(f7079t, this.f7081r);
        }
        return mapA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, FrameLayout.LayoutParams layoutParams) {
        Listener listener;
        super.onAdLoadSuccess();
        if (!y() || (listener = this.f9792b) == 0) {
            return;
        }
        ((InterfaceC2527r0) listener).a(this, view, layoutParams);
    }

    @Override // com.ironsource.AbstractC2547s3, com.ironsource.C0
    public Map<String, Object> a(A0 a02) {
        Map<String, Object> mapA = super.a(a02);
        com.ironsource.mediationsdk.q qVar = this.f7081r;
        if (qVar != null && !qVar.b()) {
            com.ironsource.mediationsdk.l.a(mapA, this.f7081r.getSize());
        }
        if (this.g != null) {
            mapA.put("placement", j());
        }
        return mapA;
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdShowFailed(int i2, String str) {
    }
}
