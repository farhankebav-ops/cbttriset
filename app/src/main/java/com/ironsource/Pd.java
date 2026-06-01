package com.ironsource;

import android.os.Bundle;
import com.ironsource.C2300e4;
import com.ironsource.C2422l1;
import com.ironsource.InterfaceC2369i1;
import com.ironsource.Vf;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.ironsourceads.rewarded.RewardedAd;
import com.unity3d.ironsourceads.rewarded.RewardedAdRequest;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Pd implements Cb, InterfaceC2320f6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RewardedAdRequest f7388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Db f7389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final T<RewardedAd> f7390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final InterfaceC2441m2 f7391d;
    private final InterfaceC2607vc e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final InterfaceC2495p1 f7392f;
    private final InterfaceC2260c0<RewardedAd> g;
    private final Vf.c h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Executor f7393i;
    private C2426l5 j;
    private Vf k;
    private W1 l;
    private boolean m;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a implements Vf.a {
        public a() {
        }

        @Override // com.ironsource.Vf.a
        public void a() {
            Pd.this.a(C2668z5.f10625a.s());
        }
    }

    public Pd(RewardedAdRequest adRequest, Db loadTaskConfig, T<RewardedAd> adLoadTaskListener, InterfaceC2441m2 auctionResponseFetcher, InterfaceC2607vc networkLoadApi, InterfaceC2495p1 analytics, InterfaceC2260c0<RewardedAd> adObjectFactory, Vf.c timerFactory, Executor taskFinishedExecutor) {
        kotlin.jvm.internal.k.e(adRequest, "adRequest");
        kotlin.jvm.internal.k.e(loadTaskConfig, "loadTaskConfig");
        kotlin.jvm.internal.k.e(adLoadTaskListener, "adLoadTaskListener");
        kotlin.jvm.internal.k.e(auctionResponseFetcher, "auctionResponseFetcher");
        kotlin.jvm.internal.k.e(networkLoadApi, "networkLoadApi");
        kotlin.jvm.internal.k.e(analytics, "analytics");
        kotlin.jvm.internal.k.e(adObjectFactory, "adObjectFactory");
        kotlin.jvm.internal.k.e(timerFactory, "timerFactory");
        kotlin.jvm.internal.k.e(taskFinishedExecutor, "taskFinishedExecutor");
        this.f7388a = adRequest;
        this.f7389b = loadTaskConfig;
        this.f7390c = adLoadTaskListener;
        this.f7391d = auctionResponseFetcher;
        this.e = networkLoadApi;
        this.f7392f = analytics;
        this.g = adObjectFactory;
        this.h = timerFactory;
        this.f7393i = taskFinishedExecutor;
    }

    @Override // com.ironsource.InterfaceC2320f6
    public void a(M9 adInstance) {
        kotlin.jvm.internal.k.e(adInstance, "adInstance");
        this.f7393i.execute(new ti(7, this, adInstance));
    }

    @Override // com.ironsource.Cb
    public void start() {
        this.j = new C2426l5();
        this.f7392f.a(new C2422l1.s(this.f7389b.f()), new C2422l1.n(this.f7389b.g().b()), new C2422l1.b(this.f7388a.getAdId$mediationsdk_release()));
        InterfaceC2369i1.c.f8699a.a().a(this.f7392f);
        a(this.f7388a.getExtraParams());
        long jH = this.f7389b.h();
        Vf.c cVar = this.h;
        Vf.b bVar = new Vf.b();
        bVar.b(jH);
        Vf vfA = cVar.a(bVar);
        this.k = vfA;
        if (vfA != null) {
            vfA.a(new a());
        }
        Object objA = this.f7391d.a();
        Throwable thA = q5.k.a(objA);
        if (thA != null) {
            a(((C2322f8) thA).a());
            objA = null;
        }
        C2387j2 c2387j2 = (C2387j2) objA;
        if (c2387j2 == null) {
            return;
        }
        InterfaceC2495p1 interfaceC2495p1 = this.f7392f;
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
        EnumC2468n9 enumC2468n9G = this.f7389b.g();
        C2302e6 c2302e6 = new C2302e6();
        c2302e6.a(this);
        M9 m9A = new N9(this.f7388a.getProviderName$mediationsdk_release().value(), c2302e6).a(enumC2468n9G.b(EnumC2468n9.Bidder)).b(this.f7389b.i()).c().a(this.f7388a.getAdId$mediationsdk_release()).a(r5.x.i0(new C2489oc().a(), U5.f7671a.a(this.f7388a.getExtraParams()))).a();
        InterfaceC2495p1 interfaceC2495p12 = this.f7392f;
        String strE = m9A.e();
        kotlin.jvm.internal.k.d(strE, "adInstance.id");
        interfaceC2495p12.a(new C2422l1.b(strE));
        C2641xc c2641xc = new C2641xc(c2387j2, this.f7389b.j());
        this.l = new W1(new C2448m9(this.f7388a.getInstanceId(), enumC2468n9G.b(), c2387j2.a()), new com.ironsource.mediationsdk.d(), c2387j2.c());
        InterfaceC2369i1.d.f8705a.c().a(this.f7392f);
        this.e.a(m9A, c2641xc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Pd this$0, M9 adInstance) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(adInstance, "$adInstance");
        if (this$0.m) {
            return;
        }
        this$0.m = true;
        Vf vf = this$0.k;
        if (vf != null) {
            vf.cancel();
        }
        C2426l5 c2426l5 = this$0.j;
        if (c2426l5 == null) {
            kotlin.jvm.internal.k.l("taskStartedTime");
            throw null;
        }
        InterfaceC2369i1.c.f8699a.a(new C2422l1.f(C2426l5.a(c2426l5))).a(this$0.f7392f);
        W1 w12 = this$0.l;
        if (w12 != null) {
            w12.c("onAdInstanceLoadSuccess");
        }
        InterfaceC2260c0<RewardedAd> interfaceC2260c0 = this$0.g;
        W1 w13 = this$0.l;
        kotlin.jvm.internal.k.b(w13);
        this$0.f7390c.a(interfaceC2260c0.a(adInstance, w13));
    }

    public /* synthetic */ Pd(RewardedAdRequest rewardedAdRequest, Db db, T t3, InterfaceC2441m2 interfaceC2441m2, InterfaceC2607vc interfaceC2607vc, InterfaceC2495p1 interfaceC2495p1, InterfaceC2260c0 interfaceC2260c0, Vf.c cVar, Executor executor, int i2, kotlin.jvm.internal.f fVar) {
        this(rewardedAdRequest, db, t3, interfaceC2441m2, interfaceC2607vc, interfaceC2495p1, interfaceC2260c0, (i2 & 128) != 0 ? new Vf.d() : cVar, (i2 & 256) != 0 ? V7.f7731a.c() : executor);
    }

    private final void a(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        Map<String, String> mapA = U5.f7671a.a(bundle);
        for (String str : mapA.keySet()) {
            InterfaceC2369i1.c.f8699a.a(new C2422l1.l(a1.a.D(str, C2300e4.i.f8399b, String.valueOf(mapA.get(str))))).a(this.f7392f);
        }
    }

    @Override // com.ironsource.InterfaceC2320f6
    public void a(String description) {
        kotlin.jvm.internal.k.e(description, "description");
        a(C2668z5.f10625a.c(description));
    }

    public final void a(IronSourceError error) {
        kotlin.jvm.internal.k.e(error, "error");
        this.f7393i.execute(new ti(8, this, error));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Pd this$0, IronSourceError error) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(error, "$error");
        if (this$0.m) {
            return;
        }
        this$0.m = true;
        Vf vf = this$0.k;
        if (vf != null) {
            vf.cancel();
        }
        InterfaceC2369i1.c.a aVar = InterfaceC2369i1.c.f8699a;
        C2422l1.j jVar = new C2422l1.j(error.getErrorCode());
        C2422l1.k kVar = new C2422l1.k(error.getErrorMessage());
        C2426l5 c2426l5 = this$0.j;
        if (c2426l5 != null) {
            aVar.a(jVar, kVar, new C2422l1.f(C2426l5.a(c2426l5))).a(this$0.f7392f);
            W1 w12 = this$0.l;
            if (w12 != null) {
                w12.a("onAdInstanceLoadFail");
            }
            this$0.f7390c.b(error);
            return;
        }
        kotlin.jvm.internal.k.l("taskStartedTime");
        throw null;
    }
}
