package com.ironsource;

import android.app.Activity;
import com.ironsource.C2422l1;
import com.ironsource.InterfaceC2369i1;
import com.ironsource.P8;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.ironsourceads.interstitial.InterstitialAdInfo;
import java.util.Map;

/* JADX INFO: renamed from: com.ironsource.u9, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2587u9 implements InterfaceC2338g6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private M9 f10389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private InterfaceC2224a0 f10390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private X1 f10391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private InterfaceC2495p1 f10392d;
    private InterfaceC2451mc e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Tf f10393f;
    private P8 g;
    private P8.a h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map<String, C2587u9> f10394i;
    private InterstitialAdInfo j;
    private InterfaceC2604v9 k;

    public C2587u9(M9 adInstance, InterfaceC2224a0 adNetworkShow, X1 auctionDataReporter, InterfaceC2495p1 analytics, InterfaceC2451mc networkDestroyAPI, Tf threadManager, P8 sessionDepthService, P8.a sessionDepthServiceEditor, Map<String, C2587u9> retainer) {
        kotlin.jvm.internal.k.e(adInstance, "adInstance");
        kotlin.jvm.internal.k.e(adNetworkShow, "adNetworkShow");
        kotlin.jvm.internal.k.e(auctionDataReporter, "auctionDataReporter");
        kotlin.jvm.internal.k.e(analytics, "analytics");
        kotlin.jvm.internal.k.e(networkDestroyAPI, "networkDestroyAPI");
        kotlin.jvm.internal.k.e(threadManager, "threadManager");
        kotlin.jvm.internal.k.e(sessionDepthService, "sessionDepthService");
        kotlin.jvm.internal.k.e(sessionDepthServiceEditor, "sessionDepthServiceEditor");
        kotlin.jvm.internal.k.e(retainer, "retainer");
        this.f10389a = adInstance;
        this.f10390b = adNetworkShow;
        this.f10391c = auctionDataReporter;
        this.f10392d = analytics;
        this.e = networkDestroyAPI;
        this.f10393f = threadManager;
        this.g = sessionDepthService;
        this.h = sessionDepthServiceEditor;
        this.f10394i = retainer;
        String strF = adInstance.f();
        kotlin.jvm.internal.k.d(strF, "adInstance.instanceId");
        String strE = this.f10389a.e();
        kotlin.jvm.internal.k.d(strE, "adInstance.id");
        this.j = new InterstitialAdInfo(strF, strE);
        C2302e6 c2302e6 = new C2302e6();
        this.f10389a.a(c2302e6);
        c2302e6.a(this);
    }

    public final void a(InterstitialAdInfo interstitialAdInfo) {
        kotlin.jvm.internal.k.e(interstitialAdInfo, "<set-?>");
        this.j = interstitialAdInfo;
    }

    public final InterstitialAdInfo b() {
        return this.j;
    }

    public final InterfaceC2604v9 c() {
        return this.k;
    }

    public final boolean d() {
        boolean zA = this.f10390b.a(this.f10389a);
        InterfaceC2369i1.a.f8690a.a(zA).a(this.f10392d);
        return zA;
    }

    public final void finalize() {
        a();
    }

    @Override // com.ironsource.InterfaceC2338g6
    public void onAdInstanceDidBecomeVisible() {
        InterfaceC2369i1.a.f8690a.f(new InterfaceC2440m1[0]).a(this.f10392d);
    }

    @Override // com.ironsource.InterfaceC2338g6
    public void onAdInstanceDidClick() {
        InterfaceC2369i1.a.f8690a.a().a(this.f10392d);
        this.f10393f.a(new ui(this, 1));
    }

    @Override // com.ironsource.InterfaceC2338g6
    public void onAdInstanceDidDismiss() {
        this.f10394i.remove(this.j.getAdId());
        InterfaceC2369i1.a.f8690a.a(new InterfaceC2440m1[0]).a(this.f10392d);
        this.f10393f.a(new ui(this, 3));
    }

    @Override // com.ironsource.InterfaceC2338g6
    public void onAdInstanceDidShow() {
        P8 p8 = this.g;
        IronSource.a aVar = IronSource.a.INTERSTITIAL;
        InterfaceC2369i1.a.f8690a.b(new C2422l1.w(p8.a(aVar))).a(this.f10392d);
        this.h.b(aVar);
        this.f10391c.b("onAdInstanceDidShow");
        this.f10393f.a(new ui(this, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(C2587u9 this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        InterfaceC2604v9 interfaceC2604v9 = this$0.k;
        if (interfaceC2604v9 != null) {
            interfaceC2604v9.onAdInstanceDidClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(C2587u9 this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        InterfaceC2604v9 interfaceC2604v9 = this$0.k;
        if (interfaceC2604v9 != null) {
            interfaceC2604v9.onAdInstanceDidDismiss();
        }
    }

    public final void a(InterfaceC2604v9 interfaceC2604v9) {
        this.k = interfaceC2604v9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(C2587u9 this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        InterfaceC2604v9 interfaceC2604v9 = this$0.k;
        if (interfaceC2604v9 != null) {
            interfaceC2604v9.onAdInstanceDidShow();
        }
    }

    public final void a(Activity activity) {
        kotlin.jvm.internal.k.e(activity, "activity");
        this.f10394i.put(this.j.getAdId(), this);
        if (!this.f10390b.a(this.f10389a)) {
            a(C2668z5.f10625a.t());
        } else {
            InterfaceC2369i1.a.f8690a.d(new InterfaceC2440m1[0]).a(this.f10392d);
            this.f10390b.a(activity, this.f10389a);
        }
    }

    @Override // com.ironsource.InterfaceC2338g6
    public void a(String str) {
        a(C2668z5.f10625a.c(new IronSourceError(0, str)));
    }

    private final void a(IronSourceError ironSourceError) {
        this.f10394i.remove(this.j.getAdId());
        InterfaceC2369i1.a.f8690a.a(new C2422l1.j(ironSourceError.getErrorCode()), new C2422l1.k(ironSourceError.getErrorMessage())).a(this.f10392d);
        this.f10393f.a(new ti(23, this, ironSourceError));
    }

    public /* synthetic */ C2587u9(M9 m9, InterfaceC2224a0 interfaceC2224a0, X1 x12, InterfaceC2495p1 interfaceC2495p1, InterfaceC2451mc interfaceC2451mc, Tf tf, P8 p8, P8.a aVar, Map map, int i2, kotlin.jvm.internal.f fVar) {
        this(m9, interfaceC2224a0, x12, interfaceC2495p1, (i2 & 16) != 0 ? new C2471nc() : interfaceC2451mc, (i2 & 32) != 0 ? V7.f7731a : tf, (i2 & 64) != 0 ? Mb.f7131s.d().s() : p8, (i2 & 128) != 0 ? Mb.f7131s.a().h() : aVar, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C2587u9 this$0, IronSourceError error) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(error, "$error");
        InterfaceC2604v9 interfaceC2604v9 = this$0.k;
        if (interfaceC2604v9 != null) {
            interfaceC2604v9.onAdInstanceDidFailedToShow(error);
        }
    }

    public final void a() {
        rh.a(this.f10393f, new ui(this, 0), 0L, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C2587u9 this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        InterfaceC2369i1.d.f8705a.b().a(this$0.f10392d);
        this$0.e.a(this$0.f10389a);
    }

    @Override // com.ironsource.InterfaceC2338g6
    public void onAdInstanceDidReward(String str, int i2) {
    }
}
