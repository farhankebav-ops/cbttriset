package com.ironsource;

import com.ironsource.InterfaceC2565t4;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Aa extends AbstractC2438m implements P2, Ca, InterfaceC2484o7 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C2459n0 f6329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final K2 f6330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final WeakReference<InterfaceC2631x2> f6331d;
    private LevelPlayAdInfo e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Ba f6332f;

    public Aa(InterfaceC2631x2 listener, C2459n0 adTools, K2 bannerAdProperties, X2 bannerViewContainer) {
        kotlin.jvm.internal.k.e(listener, "listener");
        kotlin.jvm.internal.k.e(adTools, "adTools");
        kotlin.jvm.internal.k.e(bannerAdProperties, "bannerAdProperties");
        kotlin.jvm.internal.k.e(bannerViewContainer, "bannerViewContainer");
        this.f6329b = adTools;
        this.f6330c = bannerAdProperties;
        this.f6331d = new WeakReference<>(listener);
        this.e = q();
        this.f6332f = Za.f7916a.a(adTools, bannerViewContainer, adTools.d(bannerAdProperties.c()), bannerAdProperties, this, p(), (64 & 64) != 0 ? new InterfaceC2565t4.a() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final M2 a(Aa this$0, boolean z2) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        return this$0.a(this$0.f6329b, this$0.f6330c, z2);
    }

    private final O2 p() {
        return new ah(this, 0);
    }

    private final LevelPlayAdInfo q() {
        String string = this.f6330c.b().toString();
        kotlin.jvm.internal.k.d(string, "bannerAdProperties.adId.toString()");
        String strC = this.f6330c.c();
        String string2 = this.f6330c.a().toString();
        kotlin.jvm.internal.k.d(string2, "bannerAdProperties.adFormat.toString()");
        return new LevelPlayAdInfo(string, strC, string2, null, null, null, null, null, 248, null);
    }

    @Override // com.ironsource.InterfaceC2484o7
    public void c() {
        this.f6332f.c();
    }

    @Override // com.ironsource.InterfaceC2484o7
    public void d() {
        this.f6332f.d();
    }

    @Override // com.ironsource.InterfaceC2484o7
    public void e() {
        this.f6332f.e();
    }

    @Override // com.ironsource.J0
    public void g() {
        onAdClicked();
    }

    @Override // com.ironsource.P2
    public /* bridge */ /* synthetic */ q5.x i() {
        r();
        return q5.x.f13520a;
    }

    @Override // com.ironsource.P2
    public /* bridge */ /* synthetic */ q5.x j() {
        t();
        return q5.x.f13520a;
    }

    @Override // com.ironsource.Ca
    public void k() {
        InterfaceC2631x2 interfaceC2631x2 = this.f6331d.get();
        if (interfaceC2631x2 != null) {
            interfaceC2631x2.b(this.e);
        }
    }

    @Override // com.ironsource.Ca
    public void l() {
        InterfaceC2631x2 interfaceC2631x2 = this.f6331d.get();
        if (interfaceC2631x2 != null) {
            interfaceC2631x2.a(this.e);
        }
    }

    @Override // com.ironsource.P2
    public /* bridge */ /* synthetic */ q5.x m() {
        s();
        return q5.x.f13520a;
    }

    @Override // com.ironsource.Ca
    public void n() {
        InterfaceC2631x2 interfaceC2631x2 = this.f6331d.get();
        if (interfaceC2631x2 != null) {
            interfaceC2631x2.c(this.e);
        }
    }

    @Override // com.ironsource.Ca
    public void onAdClicked() {
        InterfaceC2631x2 interfaceC2631x2 = this.f6331d.get();
        if (interfaceC2631x2 != null) {
            interfaceC2631x2.d(this.e);
        }
    }

    @Override // com.ironsource.Ca
    public void onAdLeftApplication() {
        InterfaceC2631x2 interfaceC2631x2 = this.f6331d.get();
        if (interfaceC2631x2 != null) {
            interfaceC2631x2.e(this.e);
        }
    }

    @Override // com.ironsource.Ca
    public void onAdLoaded(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.e = adInfo;
        InterfaceC2631x2 interfaceC2631x2 = this.f6331d.get();
        if (interfaceC2631x2 != null) {
            interfaceC2631x2.a(adInfo, false);
        }
    }

    public void r() {
        onAdLeftApplication();
    }

    public void s() {
        n();
    }

    public void t() {
        l();
    }

    private final M2 a(C2459n0 c2459n0, K2 k22, boolean z2) {
        IronLog.INTERNAL.verbose();
        return new M2(c2459n0, N2.f7262z.a(k22, o().a(), z2), this);
    }

    @Override // com.ironsource.InterfaceC2484o7
    public void b() {
        this.f6332f.b();
    }

    @Override // com.ironsource.Ca
    public void e(IronSourceError ironSourceError) {
        InterfaceC2631x2 interfaceC2631x2 = this.f6331d.get();
        if (interfaceC2631x2 != null) {
            LevelPlayAdInfo levelPlayAdInfo = this.e;
            String string = this.f6330c.b().toString();
            kotlin.jvm.internal.k.d(string, "bannerAdProperties.adId.toString()");
            interfaceC2631x2.a(levelPlayAdInfo, new LevelPlayAdError(ironSourceError, string, this.f6330c.c()));
        }
    }

    @Override // com.ironsource.Ca
    public void b(IronSourceError ironSourceError) {
        InterfaceC2631x2 interfaceC2631x2 = this.f6331d.get();
        if (interfaceC2631x2 != null) {
            String string = this.f6330c.b().toString();
            kotlin.jvm.internal.k.d(string, "bannerAdProperties.adId.toString()");
            interfaceC2631x2.a(new LevelPlayAdError(ironSourceError, string, this.f6330c.c()));
        }
    }
}
