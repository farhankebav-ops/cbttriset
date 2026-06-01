package com.ironsource;

import android.content.Context;
import android.os.Bundle;
import com.ironsource.C2300e4;
import com.ironsource.C2422l1;
import com.ironsource.InterfaceC2369i1;
import com.ironsource.Vf;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.AdapterUtils;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.ironsourceads.AdSize;
import com.unity3d.ironsourceads.banner.BannerAdRequest;
import com.unity3d.ironsourceads.banner.BannerAdView;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.d3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2281d3 implements Cb, B2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BannerAdRequest f8177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AdSize f8178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InterfaceC2441m2 f8179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Db f8180d;
    private final InterfaceC2607vc e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final InterfaceC2495p1 f8181f;
    private final T<BannerAdView> g;
    private final E2 h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Vf.c f8182i;
    private final Executor j;
    private C2426l5 k;
    private Vf l;
    private W1 m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f8183n;

    /* JADX INFO: renamed from: com.ironsource.d3$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a implements Vf.a {
        public a() {
        }

        @Override // com.ironsource.Vf.a
        public void a() {
            C2281d3.this.a(C2668z5.f10625a.s());
        }
    }

    public C2281d3(BannerAdRequest adRequest, AdSize size, InterfaceC2441m2 auctionResponseFetcher, Db loadTaskConfig, InterfaceC2607vc networkLoadApi, InterfaceC2495p1 analytics, T<BannerAdView> adLoadTaskListener, E2 adLayoutFactory, Vf.c timerFactory, Executor taskFinishedExecutor) {
        kotlin.jvm.internal.k.e(adRequest, "adRequest");
        kotlin.jvm.internal.k.e(size, "size");
        kotlin.jvm.internal.k.e(auctionResponseFetcher, "auctionResponseFetcher");
        kotlin.jvm.internal.k.e(loadTaskConfig, "loadTaskConfig");
        kotlin.jvm.internal.k.e(networkLoadApi, "networkLoadApi");
        kotlin.jvm.internal.k.e(analytics, "analytics");
        kotlin.jvm.internal.k.e(adLoadTaskListener, "adLoadTaskListener");
        kotlin.jvm.internal.k.e(adLayoutFactory, "adLayoutFactory");
        kotlin.jvm.internal.k.e(timerFactory, "timerFactory");
        kotlin.jvm.internal.k.e(taskFinishedExecutor, "taskFinishedExecutor");
        this.f8177a = adRequest;
        this.f8178b = size;
        this.f8179c = auctionResponseFetcher;
        this.f8180d = loadTaskConfig;
        this.e = networkLoadApi;
        this.f8181f = analytics;
        this.g = adLoadTaskListener;
        this.h = adLayoutFactory;
        this.f8182i = timerFactory;
        this.j = taskFinishedExecutor;
    }

    private final void a(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        Map<String, String> mapA = U5.f7671a.a(bundle);
        for (String str : mapA.keySet()) {
            InterfaceC2369i1.c.f8699a.a(new C2422l1.l(a1.a.D(str, C2300e4.i.f8399b, String.valueOf(mapA.get(str))))).a(this.f8181f);
        }
    }

    @Override // com.ironsource.B2
    public void onBannerLoadFail(String description) {
        kotlin.jvm.internal.k.e(description, "description");
        a(C2668z5.f10625a.c(description));
    }

    @Override // com.ironsource.B2
    public void onBannerLoadSuccess(M9 adInstance, C2411k8 adContainer) {
        kotlin.jvm.internal.k.e(adInstance, "adInstance");
        kotlin.jvm.internal.k.e(adContainer, "adContainer");
        this.j.execute(new androidx.camera.core.processing.c(this, adInstance, adContainer, 20));
    }

    @Override // com.ironsource.Cb
    public void start() {
        this.k = new C2426l5();
        this.f8181f.a(new C2422l1.s(this.f8180d.f()), new C2422l1.n(this.f8180d.g().b()), new C2422l1.c(this.f8178b), new C2422l1.b(this.f8177a.getAdId$mediationsdk_release()));
        InterfaceC2369i1.c.f8699a.a().a(this.f8181f);
        a(this.f8177a.getExtraParams());
        long jH = this.f8180d.h();
        Vf.c cVar = this.f8182i;
        Vf.b bVar = new Vf.b();
        bVar.b(jH);
        Vf vfA = cVar.a(bVar);
        this.l = vfA;
        if (vfA != null) {
            vfA.a(new a());
        }
        Object objA = this.f8179c.a();
        Throwable thA = q5.k.a(objA);
        if (thA != null) {
            a(((C2322f8) thA).a());
            objA = null;
        }
        C2387j2 c2387j2 = (C2387j2) objA;
        if (c2387j2 == null) {
            return;
        }
        InterfaceC2495p1 interfaceC2495p1 = this.f8181f;
        String strB = c2387j2.b();
        if (strB != null) {
            interfaceC2495p1.a(new C2422l1.d(strB));
        }
        JSONObject jSONObjectF = c2387j2.f();
        if (jSONObjectF != null) {
            interfaceC2495p1.a(new C2422l1.m(jSONObjectF));
        }
        String strA = c2387j2.a();
        if (strA != null) {
            interfaceC2495p1.a(new C2422l1.g(strA));
        }
        EnumC2468n9 enumC2468n9G = this.f8180d.g();
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        C2376i8 c2376i8 = new C2376i8(AdapterUtils.dpToPixels(applicationContext, this.f8178b.getWidth()), AdapterUtils.dpToPixels(applicationContext, this.f8178b.getHeight()), this.f8178b.getSizeDescription());
        Kc kc = new Kc();
        kc.a(this);
        M9 adInstance = new N9(this.f8177a.getProviderName$mediationsdk_release().value(), kc).a(enumC2468n9G.b(EnumC2468n9.Bidder)).a(c2376i8).b(this.f8180d.i()).a(this.f8177a.getAdId$mediationsdk_release()).a(r5.x.i0(new C2489oc().a(), U5.f7671a.a(this.f8177a.getExtraParams()))).a();
        C2641xc c2641xc = new C2641xc(c2387j2, this.f8180d.j());
        this.m = new W1(new C2448m9(this.f8177a.getInstanceId(), enumC2468n9G.b(), c2387j2.a()), new com.ironsource.mediationsdk.d(), c2387j2.c());
        InterfaceC2369i1.d.f8705a.c().a(this.f8181f);
        InterfaceC2607vc interfaceC2607vc = this.e;
        kotlin.jvm.internal.k.d(adInstance, "adInstance");
        interfaceC2607vc.a(adInstance, c2641xc);
    }

    public /* synthetic */ C2281d3(BannerAdRequest bannerAdRequest, AdSize adSize, InterfaceC2441m2 interfaceC2441m2, Db db, InterfaceC2607vc interfaceC2607vc, InterfaceC2495p1 interfaceC2495p1, T t3, E2 e22, Vf.c cVar, Executor executor, int i2, kotlin.jvm.internal.f fVar) {
        this(bannerAdRequest, adSize, interfaceC2441m2, db, interfaceC2607vc, interfaceC2495p1, t3, e22, (i2 & 256) != 0 ? new Vf.d() : cVar, (i2 & 512) != 0 ? V7.f7731a.c() : executor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C2281d3 this$0, M9 adInstance, C2411k8 adContainer) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(adInstance, "$adInstance");
        kotlin.jvm.internal.k.e(adContainer, "$adContainer");
        if (this$0.f8183n) {
            return;
        }
        this$0.f8183n = true;
        Vf vf = this$0.l;
        if (vf != null) {
            vf.cancel();
        }
        C2426l5 c2426l5 = this$0.k;
        if (c2426l5 != null) {
            InterfaceC2369i1.c.f8699a.a(new C2422l1.f(C2426l5.a(c2426l5))).a(this$0.f8181f);
            W1 w12 = this$0.m;
            if (w12 != null) {
                w12.c("onBannerLoadSuccess");
            }
            E2 e22 = this$0.h;
            W1 w13 = this$0.m;
            kotlin.jvm.internal.k.b(w13);
            this$0.g.a(e22.a(adInstance, adContainer, w13));
            return;
        }
        kotlin.jvm.internal.k.l("taskStartedTime");
        throw null;
    }

    public final void a(IronSourceError error) {
        kotlin.jvm.internal.k.e(error, "error");
        this.j.execute(new ti(14, this, error));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C2281d3 this$0, IronSourceError error) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(error, "$error");
        if (this$0.f8183n) {
            return;
        }
        this$0.f8183n = true;
        Vf vf = this$0.l;
        if (vf != null) {
            vf.cancel();
        }
        InterfaceC2369i1.c.a aVar = InterfaceC2369i1.c.f8699a;
        C2422l1.j jVar = new C2422l1.j(error.getErrorCode());
        C2422l1.k kVar = new C2422l1.k(error.getErrorMessage());
        C2426l5 c2426l5 = this$0.k;
        if (c2426l5 != null) {
            aVar.a(jVar, kVar, new C2422l1.f(C2426l5.a(c2426l5))).a(this$0.f8181f);
            W1 w12 = this$0.m;
            if (w12 != null) {
                w12.a("onBannerLoadFail");
            }
            this$0.g.b(error);
            return;
        }
        kotlin.jvm.internal.k.l("taskStartedTime");
        throw null;
    }
}
