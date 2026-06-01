package com.ironsource;

import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBannerInterface;
import com.ironsource.mediationsdk.adunit.adapter.listener.BannerAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.logger.IronLog;
import com.unity3d.mediation.LevelPlayAdInfo;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: renamed from: com.ironsource.y2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2648y2 extends AbstractC2662z implements BannerAdListener {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private WeakReference<A2> f10543x;
    private View y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private FrameLayout.LayoutParams f10544z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2648y2(V0 adTools, A instanceData, G adInstancePayload, A2 listener) {
        super(adTools, instanceData, adInstancePayload, listener);
        kotlin.jvm.internal.k.e(adTools, "adTools");
        kotlin.jvm.internal.k.e(instanceData, "instanceData");
        kotlin.jvm.internal.k.e(adInstancePayload, "adInstancePayload");
        kotlin.jvm.internal.k.e(listener, "listener");
        this.f10543x = new WeakReference<>(listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(C2648y2 this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        this$0.K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(C2648y2 this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        this$0.L();
    }

    @Override // com.ironsource.AbstractC2662z
    public void A() {
        if (!(g() instanceof AdapterBannerInterface)) {
            IronLog.INTERNAL.error(a("adapter not instance of AdapterBannerInterface"));
            return;
        }
        AdData adDataI = i();
        ISBannerSize iSBannerSizeI = I();
        Map<String, Object> adUnitData = adDataI.getAdUnitData();
        kotlin.jvm.internal.k.d(adUnitData, "adData.adUnitData");
        adUnitData.put(L2.f7079t, new com.ironsource.mediationsdk.q(ContextProvider.getInstance().getApplicationContext(), iSBannerSizeI));
        Object objG = g();
        kotlin.jvm.internal.k.c(objG, "null cannot be cast to non-null type com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBannerInterface<com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener>");
        ((AdapterBannerInterface) objG).loadAd(adDataI, ContextProvider.getInstance().getCurrentActiveActivity(), iSBannerSizeI, this);
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
        C2623wb.a(f(), new aj(this, 0), 0L, 2, (Object) null);
        if (g() == null) {
            ironLog.warning("adapter == null");
            return;
        }
        try {
            if (g() instanceof AdapterBannerInterface) {
                Object objG = g();
                kotlin.jvm.internal.k.c(objG, "null cannot be cast to non-null type com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBannerInterface<*>");
                ((AdapterBannerInterface) objG).destroyAd(i());
            } else {
                ironLog.error(a("adapter not instance of AdapterBannerInterface"));
            }
        } catch (Throwable th) {
            C2531r4.d().a(th);
            String strL = a1.a.l("destroyBanner - exception = ", th.getLocalizedMessage());
            IronLog.INTERNAL.error(a(strL));
            f().e().h().g(strL);
        }
        super.b();
    }

    @Override // com.ironsource.AbstractC2662z
    public LevelPlayAdInfo e() {
        String string = n().i().b().b().toString();
        kotlin.jvm.internal.k.d(string, "instanceData.adUnitData.…roperties.adId.toString()");
        String strC = n().i().b().c();
        String string2 = n().h().toString();
        kotlin.jvm.internal.k.d(string2, "instanceData.adFormat.toString()");
        Y8 y8A = n().n().a(k());
        Bb bbD = n().n().d();
        AbstractC2595v0 abstractC2595v0I = n().i();
        kotlin.jvm.internal.k.c(abstractC2595v0I, "null cannot be cast to non-null type com.unity3d.mediation.internal.ads.controllers.adunits.data.BannerAdUnitData");
        return new LevelPlayAdInfo(string, strC, string2, y8A, bbD, ((N2) abstractC2595v0I).b().h(), n().i().l(), null, 128, null);
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public final /* synthetic */ void onAdLeftApplication(Map map) {
        b3.d.a(this, map);
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public final /* synthetic */ void onAdLoadSuccess(View view, FrameLayout.LayoutParams layoutParams, Map map) {
        b3.d.b(this, view, layoutParams, map);
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public final /* synthetic */ void onAdScreenDismissed(Map map) {
        b3.d.c(this, map);
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public final /* synthetic */ void onAdScreenPresented(Map map) {
        b3.d.d(this, map);
    }

    private final ISBannerSize I() {
        V0 v0F = f();
        AbstractC2595v0 abstractC2595v0I = n().i();
        kotlin.jvm.internal.k.c(abstractC2595v0I, "null cannot be cast to non-null type com.unity3d.mediation.internal.ads.controllers.adunits.data.BannerAdUnitData");
        return v0F.a(((N2) abstractC2595v0I).b().h());
    }

    private final void J() {
        C2434ld c2434ldJ = j();
        if (c2434ldJ != null) {
            f().e().a().f(c2434ldJ.c());
        }
        A2 a22 = this.f10543x.get();
        if (a22 != null) {
            a22.a(this);
        }
    }

    private final void K() {
        C2434ld c2434ldJ = j();
        if (c2434ldJ != null) {
            f().e().a().c(c2434ldJ.c());
        }
        A2 a22 = this.f10543x.get();
        if (a22 != null) {
            a22.b(this);
        }
    }

    private final void L() {
        C2434ld c2434ldJ = j();
        if (c2434ldJ != null) {
            f().e().a().h(c2434ldJ.c());
        }
        A2 a22 = this.f10543x.get();
        if (a22 != null) {
            a22.c(this);
        }
    }

    public final void a(pg viewBinder) {
        kotlin.jvm.internal.k.e(viewBinder, "viewBinder");
        C2623wb.a(f(), new ti(28, this, viewBinder), 0L, 2, (Object) null);
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public void onAdLeftApplication() {
        a(new aj(this, 3));
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public void onAdLoadSuccess(View adView, FrameLayout.LayoutParams frameLayoutParams) {
        kotlin.jvm.internal.k.e(adView, "adView");
        kotlin.jvm.internal.k.e(frameLayoutParams, "frameLayoutParams");
        C2623wb.a(f(), new androidx.camera.core.processing.c(this, adView, frameLayoutParams, 25), 0L, 2, (Object) null);
        super.onAdLoadSuccess();
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public void onAdScreenDismissed() {
        a(new aj(this, 2));
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public void onAdScreenPresented() {
        a(new aj(this, 4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C2648y2 this$0, pg viewBinder) {
        FrameLayout.LayoutParams layoutParams;
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(viewBinder, "$viewBinder");
        View view = this$0.y;
        if (view == null || (layoutParams = this$0.f10544z) == null) {
            return;
        }
        viewBinder.a(view, layoutParams, this$0.f());
        IronLog.INTERNAL.verbose(C2459n0.a(this$0.f(), "Bind banner view", (String) null, 2, (Object) null));
        this$0.f().d(new aj(this$0, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C2648y2 this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        this$0.y = null;
        this$0.f10544z = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C2648y2 this$0, View adView, FrameLayout.LayoutParams frameLayoutParams) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(adView, "$adView");
        kotlin.jvm.internal.k.e(frameLayoutParams, "$frameLayoutParams");
        this$0.y = adView;
        this$0.f10544z = frameLayoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(C2648y2 this$0) {
        String strC;
        kotlin.jvm.internal.k.e(this$0, "this$0");
        M mA = this$0.f().e().a();
        C2434ld c2434ldJ = this$0.j();
        if (c2434ldJ == null || (strC = c2434ldJ.c()) == null) {
            strC = "";
        }
        mA.j(strC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(C2648y2 this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        this$0.J();
    }
}
