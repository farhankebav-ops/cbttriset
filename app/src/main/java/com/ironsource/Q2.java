package com.ironsource;

import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.C2422l1;
import com.ironsource.InterfaceC2369i1;
import com.ironsource.P8;
import com.ironsource.mediationsdk.IronSource;
import com.unity3d.ironsourceads.banner.BannerAdInfo;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Q2 implements D2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final M9 f7413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C2411k8 f7414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final W1 f7415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final InterfaceC2495p1 f7416d;
    private final InterfaceC2451mc e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Tf f7417f;
    private final P8 g;
    private final P8.a h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private BannerAdInfo f7418i;
    private WeakReference<R2> j;
    private WeakReference<FrameLayout> k;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v2) {
            kotlin.jvm.internal.k.e(v2, "v");
            C2376i8 size = Q2.this.d().getSize();
            ((FrameLayout) v2).addView(Q2.this.d(), 0, new FrameLayout.LayoutParams(size.c(), size.a(), 17));
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v2) {
            kotlin.jvm.internal.k.e(v2, "v");
            ((FrameLayout) v2).removeAllViews();
        }
    }

    public Q2(M9 adInstance, C2411k8 container, W1 auctionDataReporter, InterfaceC2495p1 analytics, InterfaceC2451mc networkDestroyAPI, Tf threadManager, P8 sessionDepthService, P8.a sessionDepthServiceEditor) {
        kotlin.jvm.internal.k.e(adInstance, "adInstance");
        kotlin.jvm.internal.k.e(container, "container");
        kotlin.jvm.internal.k.e(auctionDataReporter, "auctionDataReporter");
        kotlin.jvm.internal.k.e(analytics, "analytics");
        kotlin.jvm.internal.k.e(networkDestroyAPI, "networkDestroyAPI");
        kotlin.jvm.internal.k.e(threadManager, "threadManager");
        kotlin.jvm.internal.k.e(sessionDepthService, "sessionDepthService");
        kotlin.jvm.internal.k.e(sessionDepthServiceEditor, "sessionDepthServiceEditor");
        this.f7413a = adInstance;
        this.f7414b = container;
        this.f7415c = auctionDataReporter;
        this.f7416d = analytics;
        this.e = networkDestroyAPI;
        this.f7417f = threadManager;
        this.g = sessionDepthService;
        this.h = sessionDepthServiceEditor;
        String strF = adInstance.f();
        kotlin.jvm.internal.k.d(strF, "adInstance.instanceId");
        String strE = adInstance.e();
        kotlin.jvm.internal.k.d(strE, "adInstance.id");
        this.f7418i = new BannerAdInfo(strF, strE);
        this.j = new WeakReference<>(null);
        this.k = new WeakReference<>(null);
        Kc kc = new Kc();
        adInstance.a(kc);
        kc.a(this);
    }

    public final void a(BannerAdInfo bannerAdInfo) {
        kotlin.jvm.internal.k.e(bannerAdInfo, "<set-?>");
        this.f7418i = bannerAdInfo;
    }

    public final void b(WeakReference<FrameLayout> value) {
        kotlin.jvm.internal.k.e(value, "value");
        this.k = value;
        FrameLayout frameLayout = value.get();
        if (frameLayout != null) {
            frameLayout.addOnAttachStateChangeListener(a());
        }
    }

    public final BannerAdInfo c() {
        return this.f7418i;
    }

    public final void finalize() {
        b();
    }

    @Override // com.ironsource.D2
    public void onBannerClick() {
        InterfaceC2369i1.a.f8690a.a().a(this.f7416d);
        this.f7417f.a(new qh(this, 1));
    }

    @Override // com.ironsource.D2
    public void onBannerShowSuccess() {
        P8 p8 = this.g;
        IronSource.a aVar = IronSource.a.BANNER;
        InterfaceC2369i1.a.f8690a.f(new C2422l1.w(p8.a(aVar))).a(this.f7416d);
        this.h.b(aVar);
        this.f7415c.b("onBannerShowSuccess");
        this.f7417f.a(new qh(this, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Q2 this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        R2 r22 = this$0.j.get();
        if (r22 != null) {
            r22.onBannerAdShown();
        }
    }

    public final void a(WeakReference<R2> weakReference) {
        kotlin.jvm.internal.k.e(weakReference, "<set-?>");
        this.j = weakReference;
    }

    public final C2411k8 d() {
        return this.f7414b;
    }

    public final WeakReference<R2> e() {
        return this.j;
    }

    public final WeakReference<FrameLayout> f() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Q2 this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        InterfaceC2369i1.d.f8705a.b().a(this$0.f7416d);
        this$0.e.a(this$0.f7413a);
    }

    public final void b() {
        rh.a(this.f7417f, new qh(this, 0), 0L, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Q2 this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        R2 r22 = this$0.j.get();
        if (r22 != null) {
            r22.onBannerAdClicked();
        }
    }

    private final a a() {
        return new a();
    }

    public /* synthetic */ Q2(M9 m9, C2411k8 c2411k8, W1 w12, InterfaceC2495p1 interfaceC2495p1, InterfaceC2451mc interfaceC2451mc, Tf tf, P8 p8, P8.a aVar, int i2, kotlin.jvm.internal.f fVar) {
        this(m9, c2411k8, w12, interfaceC2495p1, (i2 & 16) != 0 ? new C2471nc() : interfaceC2451mc, (i2 & 32) != 0 ? V7.f7731a : tf, (i2 & 64) != 0 ? Mb.f7131s.d().s() : p8, (i2 & 128) != 0 ? Mb.f7131s.a().h() : aVar);
    }
}
