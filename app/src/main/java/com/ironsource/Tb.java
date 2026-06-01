package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdInfo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Tb extends AbstractC2438m implements InterfaceC2362hc, L0, InterfaceC2629x0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Wb f7630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final C2459n0 f7631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final C2290dc f7632d;
    private C2326fc e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private LevelPlayAdInfo f7633f;

    public Tb(Wb listener, C2459n0 adTools, C2290dc nativeAdProperties) {
        kotlin.jvm.internal.k.e(listener, "listener");
        kotlin.jvm.internal.k.e(adTools, "adTools");
        kotlin.jvm.internal.k.e(nativeAdProperties, "nativeAdProperties");
        this.f7630b = listener;
        this.f7631c = adTools;
        this.f7632d = nativeAdProperties;
        this.f7633f = p();
    }

    private final LevelPlayAdInfo p() {
        String string = this.f7632d.b().toString();
        kotlin.jvm.internal.k.d(string, "nativeAdProperties.adId.toString()");
        String strC = this.f7632d.c();
        String string2 = this.f7632d.a().toString();
        kotlin.jvm.internal.k.d(string2, "nativeAdProperties.adFormat.toString()");
        return new LevelPlayAdInfo(string, strC, string2, null, null, null, null, null, 248, null);
    }

    @Override // com.ironsource.L0
    public final /* synthetic */ void a() {
        mh.a(this);
    }

    @Override // com.ironsource.L0
    public final /* synthetic */ void b(C2544s0 c2544s0) {
        mh.b(this, c2544s0);
    }

    @Override // com.ironsource.InterfaceC2629x0
    public void c(IronSourceError ironSourceError) {
        throw new q5.h("An operation is not implemented: Not yet implemented");
    }

    @Override // com.ironsource.InterfaceC2629x0
    public void f() {
        throw new q5.h("An operation is not implemented: Not yet implemented");
    }

    @Override // com.ironsource.J0
    public void g() {
        this.f7630b.b(this.f7633f);
    }

    public final void q() {
        this.f7633f = p();
        C2326fc c2326fc = this.e;
        if (c2326fc != null) {
            c2326fc.a(true);
        } else {
            kotlin.jvm.internal.k.l("nativeAdUnit");
            throw null;
        }
    }

    public final void r() {
        C2326fc c2326fcA = a(this.f7631c, this.f7632d);
        this.e = c2326fcA;
        if (c2326fcA != null) {
            c2326fcA.a((L0) this);
        } else {
            kotlin.jvm.internal.k.l("nativeAdUnit");
            throw null;
        }
    }

    public final void a(Qb nativeAdBinder) {
        kotlin.jvm.internal.k.e(nativeAdBinder, "nativeAdBinder");
        C2326fc c2326fc = this.e;
        if (c2326fc != null) {
            c2326fc.a(new Yb(nativeAdBinder), this);
        } else {
            kotlin.jvm.internal.k.l("nativeAdUnit");
            throw null;
        }
    }

    private final C2326fc a(C2459n0 c2459n0, C2290dc c2290dc) {
        IronLog.INTERNAL.verbose();
        return new C2326fc(c2459n0, C2344gc.y.a(c2290dc, o().a()), this);
    }

    @Override // com.ironsource.L0
    public void a(C2544s0 adUnitCallback) {
        kotlin.jvm.internal.k.e(adUnitCallback, "adUnitCallback");
        LevelPlayAdInfo levelPlayAdInfoC = adUnitCallback.c();
        if (levelPlayAdInfoC != null) {
            this.f7633f = levelPlayAdInfoC;
            this.f7630b.a(levelPlayAdInfoC);
        }
    }

    @Override // com.ironsource.L0
    public void a(IronSourceError ironSourceError) {
        this.f7630b.onNativeAdLoadFailed(ironSourceError);
    }
}
