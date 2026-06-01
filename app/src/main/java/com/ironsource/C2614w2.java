package com.ironsource;

import com.ironsource.AbstractC2388j3;
import com.ironsource.Za;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.ironsource.w2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2614w2 extends AbstractC2438m implements P2, InterfaceC2424l3, InterfaceC2484o7 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C2459n0 f10470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final K2 f10471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final WeakReference<InterfaceC2631x2> f10472d;
    private LevelPlayAdInfo e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private LevelPlayAdInfo f10473f;
    private final AbstractC2388j3 g;

    public C2614w2(InterfaceC2631x2 listener, C2459n0 adTools, K2 bannerAdProperties, X2 bannerViewContainer) {
        kotlin.jvm.internal.k.e(listener, "listener");
        kotlin.jvm.internal.k.e(adTools, "adTools");
        kotlin.jvm.internal.k.e(bannerAdProperties, "bannerAdProperties");
        kotlin.jvm.internal.k.e(bannerViewContainer, "bannerViewContainer");
        this.f10470b = adTools;
        this.f10471c = bannerAdProperties;
        this.f10472d = new WeakReference<>(listener);
        this.e = r();
        this.f10473f = r();
        this.g = AbstractC2388j3.f8761c.a(adTools, bannerViewContainer, q(), bannerAdProperties, this, p());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final M2 a(C2614w2 this$0, boolean z2) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        return this$0.a(this$0.f10470b, this$0.f10471c, z2);
    }

    private final O2 p() {
        return new ah(this, 5);
    }

    private final AbstractC2388j3.b q() {
        Za.a aVarD = this.f10470b.d(this.f10471c.c());
        Long lJ = this.f10471c.j();
        long jLongValue = lJ != null ? lJ.longValue() : aVarD.d();
        Boolean boolI = this.f10471c.i();
        return new AbstractC2388j3.b(jLongValue, boolI != null ? boolI.booleanValue() : aVarD.f());
    }

    private final LevelPlayAdInfo r() {
        String string = this.f10471c.b().toString();
        kotlin.jvm.internal.k.d(string, "bannerAdProperties.adId.toString()");
        String strC = this.f10471c.c();
        String string2 = this.f10471c.a().toString();
        kotlin.jvm.internal.k.d(string2, "bannerAdProperties.adFormat.toString()");
        return new LevelPlayAdInfo(string, strC, string2, null, null, null, null, null, 248, null);
    }

    @Override // com.ironsource.InterfaceC2484o7
    public void c() {
        this.g.c();
    }

    @Override // com.ironsource.InterfaceC2484o7
    public void d() {
        this.g.d();
    }

    @Override // com.ironsource.InterfaceC2484o7
    public void e() {
        this.g.e();
    }

    @Override // com.ironsource.InterfaceC2424l3
    public void f(IronSourceError ironSourceError) {
        InterfaceC2631x2 interfaceC2631x2 = this.f10472d.get();
        if (interfaceC2631x2 != null) {
            LevelPlayAdInfo levelPlayAdInfo = this.e;
            String string = this.f10471c.b().toString();
            kotlin.jvm.internal.k.d(string, "bannerAdProperties.adId.toString()");
            interfaceC2631x2.a(levelPlayAdInfo, new LevelPlayAdError(ironSourceError, string, this.f10471c.c()));
        }
    }

    @Override // com.ironsource.J0
    public void g() {
        InterfaceC2631x2 interfaceC2631x2 = this.f10472d.get();
        if (interfaceC2631x2 != null) {
            interfaceC2631x2.d(this.e);
        }
    }

    @Override // com.ironsource.InterfaceC2424l3
    public void h() {
        this.e = this.f10473f;
        this.f10473f = r();
        InterfaceC2631x2 interfaceC2631x2 = this.f10472d.get();
        if (interfaceC2631x2 != null) {
            interfaceC2631x2.b(this.e);
        }
    }

    @Override // com.ironsource.P2
    public /* bridge */ /* synthetic */ q5.x i() {
        s();
        return q5.x.f13520a;
    }

    @Override // com.ironsource.P2
    public /* bridge */ /* synthetic */ q5.x j() {
        u();
        return q5.x.f13520a;
    }

    @Override // com.ironsource.P2
    public /* bridge */ /* synthetic */ q5.x m() {
        t();
        return q5.x.f13520a;
    }

    public void s() {
        InterfaceC2631x2 interfaceC2631x2 = this.f10472d.get();
        if (interfaceC2631x2 != null) {
            interfaceC2631x2.e(this.e);
        }
    }

    public void t() {
        InterfaceC2631x2 interfaceC2631x2 = this.f10472d.get();
        if (interfaceC2631x2 != null) {
            interfaceC2631x2.c(this.e);
        }
    }

    public void u() {
        InterfaceC2631x2 interfaceC2631x2 = this.f10472d.get();
        if (interfaceC2631x2 != null) {
            interfaceC2631x2.a(this.e);
        }
    }

    private final M2 a(C2459n0 c2459n0, K2 k22, boolean z2) {
        IronLog.INTERNAL.verbose();
        return new M2(c2459n0, N2.f7262z.a(k22, o().a(), z2), this);
    }

    @Override // com.ironsource.InterfaceC2484o7
    public void b() {
        this.g.b();
    }

    @Override // com.ironsource.InterfaceC2424l3
    public void c(C2544s0 adUnitCallback) {
        kotlin.jvm.internal.k.e(adUnitCallback, "adUnitCallback");
        LevelPlayAdInfo levelPlayAdInfoC = adUnitCallback.c();
        if (levelPlayAdInfoC != null) {
            this.f10473f = levelPlayAdInfoC;
            InterfaceC2631x2 interfaceC2631x2 = this.f10472d.get();
            if (interfaceC2631x2 != null) {
                interfaceC2631x2.a(levelPlayAdInfoC, false);
            }
        }
    }

    @Override // com.ironsource.InterfaceC2424l3
    public void d(IronSourceError ironSourceError) {
        InterfaceC2631x2 interfaceC2631x2 = this.f10472d.get();
        if (interfaceC2631x2 != null) {
            String string = this.f10471c.b().toString();
            kotlin.jvm.internal.k.d(string, "bannerAdProperties.adId.toString()");
            interfaceC2631x2.a(new LevelPlayAdError(ironSourceError, string, this.f10471c.c()));
        }
    }
}
