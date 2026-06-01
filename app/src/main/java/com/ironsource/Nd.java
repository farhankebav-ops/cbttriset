package com.ironsource;

import android.app.Activity;
import com.ironsource.C2422l1;
import com.ironsource.InterfaceC2369i1;
import com.ironsource.P8;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.unity3d.ironsourceads.rewarded.RewardedAdInfo;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Nd implements InterfaceC2338g6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private M9 f7288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private InterfaceC2224a0 f7289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private X1 f7290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private InterfaceC2495p1 f7291d;
    private InterfaceC2451mc e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Tf f7292f;
    private P8 g;
    private P8.a h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map<String, Nd> f7293i;
    private RewardedAdInfo j;
    private Od k;

    public Nd(M9 adInstance, InterfaceC2224a0 adNetworkShow, X1 auctionDataReporter, InterfaceC2495p1 analytics, InterfaceC2451mc networkDestroyAPI, Tf threadManager, P8 sessionDepthService, P8.a sessionDepthServiceEditor, Map<String, Nd> retainer) {
        kotlin.jvm.internal.k.e(adInstance, "adInstance");
        kotlin.jvm.internal.k.e(adNetworkShow, "adNetworkShow");
        kotlin.jvm.internal.k.e(auctionDataReporter, "auctionDataReporter");
        kotlin.jvm.internal.k.e(analytics, "analytics");
        kotlin.jvm.internal.k.e(networkDestroyAPI, "networkDestroyAPI");
        kotlin.jvm.internal.k.e(threadManager, "threadManager");
        kotlin.jvm.internal.k.e(sessionDepthService, "sessionDepthService");
        kotlin.jvm.internal.k.e(sessionDepthServiceEditor, "sessionDepthServiceEditor");
        kotlin.jvm.internal.k.e(retainer, "retainer");
        this.f7288a = adInstance;
        this.f7289b = adNetworkShow;
        this.f7290c = auctionDataReporter;
        this.f7291d = analytics;
        this.e = networkDestroyAPI;
        this.f7292f = threadManager;
        this.g = sessionDepthService;
        this.h = sessionDepthServiceEditor;
        this.f7293i = retainer;
        String strF = adInstance.f();
        kotlin.jvm.internal.k.d(strF, "adInstance.instanceId");
        String strE = this.f7288a.e();
        kotlin.jvm.internal.k.d(strE, "adInstance.id");
        this.j = new RewardedAdInfo(strF, strE);
        C2302e6 c2302e6 = new C2302e6();
        this.f7288a.a(c2302e6);
        c2302e6.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Nd this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        Od od = this$0.k;
        if (od != null) {
            od.onRewardedAdShown();
        }
    }

    public final void a(RewardedAdInfo rewardedAdInfo) {
        kotlin.jvm.internal.k.e(rewardedAdInfo, "<set-?>");
        this.j = rewardedAdInfo;
    }

    public final RewardedAdInfo b() {
        return this.j;
    }

    public final Od c() {
        return this.k;
    }

    public final boolean d() {
        boolean zA = this.f7289b.a(this.f7288a);
        InterfaceC2369i1.a.f8690a.a(zA).a(this.f7291d);
        return zA;
    }

    public final void finalize() {
        a();
    }

    @Override // com.ironsource.InterfaceC2338g6
    public void onAdInstanceDidBecomeVisible() {
        InterfaceC2369i1.a.f8690a.f(new InterfaceC2440m1[0]).a(this.f7291d);
    }

    @Override // com.ironsource.InterfaceC2338g6
    public void onAdInstanceDidClick() {
        InterfaceC2369i1.a.f8690a.a().a(this.f7291d);
        this.f7292f.a(new oh(this, 1));
    }

    @Override // com.ironsource.InterfaceC2338g6
    public void onAdInstanceDidDismiss() {
        this.f7293i.remove(this.j.getAdId());
        InterfaceC2369i1.a.f8690a.a(new InterfaceC2440m1[0]).a(this.f7291d);
        this.f7292f.a(new oh(this, 0));
    }

    @Override // com.ironsource.InterfaceC2338g6
    public void onAdInstanceDidReward(String str, int i2) {
        C2422l1.u uVar = new C2422l1.u("Virtual Item");
        C2422l1.t tVar = new C2422l1.t(1);
        C2422l1.q qVar = new C2422l1.q("DefaultRewardedVideo");
        String strA = IronSourceUtils.a(System.currentTimeMillis(), this.f7288a.g());
        kotlin.jvm.internal.k.d(strA, "getTransId(System.curren…illis(), adInstance.name)");
        InterfaceC2369i1.a.f8690a.c(uVar, tVar, qVar, new C2422l1.y(strA)).a(this.f7291d);
        this.f7292f.a(new oh(this, 2));
    }

    @Override // com.ironsource.InterfaceC2338g6
    public void onAdInstanceDidShow() {
        P8 p8 = this.g;
        IronSource.a aVar = IronSource.a.REWARDED_VIDEO;
        InterfaceC2369i1.a.f8690a.b(new C2422l1.w(p8.a(aVar))).a(this.f7291d);
        this.h.b(aVar);
        this.f7290c.b("onAdInstanceDidShow");
        this.f7292f.a(new oh(this, 4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Nd this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        Od od = this$0.k;
        if (od != null) {
            od.onRewardedAdClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Nd this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        Od od = this$0.k;
        if (od != null) {
            od.onRewardedAdDismissed();
        }
    }

    public final void a(Od od) {
        this.k = od;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Nd this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        Od od = this$0.k;
        if (od != null) {
            od.onUserEarnedReward();
        }
    }

    public final void a(Activity activity) {
        kotlin.jvm.internal.k.e(activity, "activity");
        this.f7293i.put(this.j.getAdId(), this);
        if (!this.f7289b.a(this.f7288a)) {
            a(C2668z5.f10625a.t());
        } else {
            InterfaceC2369i1.a.f8690a.d(new InterfaceC2440m1[0]).a(this.f7291d);
            this.f7289b.a(activity, this.f7288a);
        }
    }

    @Override // com.ironsource.InterfaceC2338g6
    public void a(String str) {
        a(C2668z5.f10625a.c(new IronSourceError(0, str)));
    }

    private final void a(IronSourceError ironSourceError) {
        this.f7293i.remove(this.j.getAdId());
        InterfaceC2369i1.a.f8690a.a(new C2422l1.j(ironSourceError.getErrorCode()), new C2422l1.k(ironSourceError.getErrorMessage())).a(this.f7291d);
        this.f7292f.a(new ti(5, this, ironSourceError));
    }

    public /* synthetic */ Nd(M9 m9, InterfaceC2224a0 interfaceC2224a0, X1 x12, InterfaceC2495p1 interfaceC2495p1, InterfaceC2451mc interfaceC2451mc, Tf tf, P8 p8, P8.a aVar, Map map, int i2, kotlin.jvm.internal.f fVar) {
        this(m9, interfaceC2224a0, x12, interfaceC2495p1, (i2 & 16) != 0 ? new C2471nc() : interfaceC2451mc, (i2 & 32) != 0 ? V7.f7731a : tf, (i2 & 64) != 0 ? Mb.f7131s.d().s() : p8, (i2 & 128) != 0 ? Mb.f7131s.a().h() : aVar, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Nd this$0, IronSourceError error) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(error, "$error");
        Od od = this$0.k;
        if (od != null) {
            od.onRewardedAdFailedToShow(error);
        }
    }

    public final void a() {
        rh.a(this.f7292f, new oh(this, 3), 0L, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Nd this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        InterfaceC2369i1.d.f8705a.b().a(this$0.f7291d);
        this$0.e.a(this$0.f7288a);
    }
}
