package com.ironsource;

import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlay;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Lf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Gf f7094a;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class c implements Fa {
        public c() {
        }

        @Override // com.ironsource.Fa
        public void b(IronSourceError ironSourceError) {
            Lf.this.a(Mf.f7241b, LevelPlay.AdFormat.BANNER, Pf.f7396a.a(ironSourceError != null ? ironSourceError.getErrorMessage() : null));
        }

        @Override // com.ironsource.Fa
        public void d(AdInfo adInfo) {
            Lf.this.a(Mf.f7244f, LevelPlay.AdFormat.BANNER, Pf.f7396a.a(adInfo));
        }

        @Override // com.ironsource.Fa
        public void e(AdInfo adInfo) {
            Lf.this.a(Mf.j, LevelPlay.AdFormat.BANNER, Pf.f7396a.a(adInfo));
        }

        @Override // com.ironsource.Fa
        public void f(AdInfo adInfo) {
            Lf.this.a(Mf.m, LevelPlay.AdFormat.BANNER, Pf.f7396a.a(adInfo));
        }

        @Override // com.ironsource.Fa
        public void g(AdInfo adInfo) {
            Lf.this.a(Mf.k, LevelPlay.AdFormat.BANNER, Pf.f7396a.a(adInfo));
        }

        @Override // com.ironsource.Fa
        public void h(AdInfo adInfo) {
            Lf.this.a(Mf.l, LevelPlay.AdFormat.BANNER, Pf.f7396a.a(adInfo));
        }
    }

    public Lf(Gf javaScriptEvaluator) {
        kotlin.jvm.internal.k.e(javaScriptEvaluator, "javaScriptEvaluator");
        this.f7094a = javaScriptEvaluator;
    }

    private final void b() {
        Kf kf = Kf.f7064a;
        kf.a((InterfaceC2361hb) null);
        kf.a((InterfaceC2555sb) null);
        kf.a((Fa) null);
    }

    private final void c() {
        Kf.f7064a.e();
    }

    public final void d() {
        Kf kf = Kf.f7064a;
        kf.a(new a());
        kf.a(new b());
        kf.a(new c());
    }

    public final void a() {
        b();
        c();
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a implements InterfaceC2361hb {
        public a() {
        }

        @Override // com.ironsource.InterfaceC2361hb
        public void a(AdInfo adInfo) {
            Lf.this.a(Mf.f7240a, LevelPlay.AdFormat.INTERSTITIAL, Pf.f7396a.a(adInfo));
        }

        @Override // com.ironsource.InterfaceC2361hb
        public void b(IronSourceError ironSourceError) {
            Lf.this.a(Mf.f7241b, LevelPlay.AdFormat.INTERSTITIAL, Pf.f7396a.a(ironSourceError != null ? ironSourceError.getErrorMessage() : null));
        }

        @Override // com.ironsource.InterfaceC2361hb
        public void c(AdInfo adInfo) {
            Lf.this.a(Mf.f7242c, LevelPlay.AdFormat.INTERSTITIAL, Pf.f7396a.a(adInfo));
        }

        @Override // com.ironsource.InterfaceC2361hb
        public void d(AdInfo adInfo) {
            Lf.this.a(Mf.f7244f, LevelPlay.AdFormat.INTERSTITIAL, Pf.f7396a.a(adInfo));
        }

        @Override // com.ironsource.InterfaceC2361hb
        public void e(AdInfo adInfo) {
            Lf.this.a(Mf.f7243d, LevelPlay.AdFormat.INTERSTITIAL, Pf.f7396a.a(adInfo));
        }

        @Override // com.ironsource.InterfaceC2361hb
        public void a(IronSourceError ironSourceError, AdInfo adInfo) {
            Lf.this.a(Mf.e, LevelPlay.AdFormat.INTERSTITIAL, Pf.f7396a.a(ironSourceError != null ? ironSourceError.getErrorMessage() : null, adInfo));
        }

        @Override // com.ironsource.InterfaceC2361hb
        public void b(AdInfo adInfo) {
            Lf.this.a(Mf.g, LevelPlay.AdFormat.INTERSTITIAL, Pf.f7396a.a(adInfo));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b implements InterfaceC2589ub, InterfaceC2572tb {
        public b() {
        }

        @Override // com.ironsource.InterfaceC2589ub
        public void a(AdInfo adInfo) {
            Lf.this.a(Mf.f7240a, LevelPlay.AdFormat.REWARDED, Pf.f7396a.a(adInfo));
        }

        @Override // com.ironsource.InterfaceC2589ub
        public void b(IronSourceError ironSourceError) {
            Lf.this.a(Mf.f7241b, LevelPlay.AdFormat.REWARDED, Pf.f7396a.a(ironSourceError != null ? ironSourceError.getErrorMessage() : null));
        }

        @Override // com.ironsource.InterfaceC2555sb
        public void c(AdInfo adInfo) {
            Lf.this.a(Mf.f7242c, LevelPlay.AdFormat.REWARDED, Pf.f7396a.a(adInfo));
        }

        @Override // com.ironsource.InterfaceC2572tb
        public void d(AdInfo adInfo) {
            Lf.this.a(Mf.h, LevelPlay.AdFormat.REWARDED, Pf.f7396a.a(adInfo));
        }

        @Override // com.ironsource.InterfaceC2572tb
        public void a() {
            Lf.this.a(Mf.f7246n, LevelPlay.AdFormat.REWARDED, Pf.f7396a.a(new Object[0]));
        }

        @Override // com.ironsource.InterfaceC2555sb
        public void b(C2434ld c2434ld, AdInfo adInfo) {
            Lf.this.a(Mf.f7245i, LevelPlay.AdFormat.REWARDED, Pf.f7396a.a(Kf.f7064a.a(c2434ld), adInfo));
        }

        @Override // com.ironsource.InterfaceC2555sb
        public void a(IronSourceError ironSourceError, AdInfo adInfo) {
            Lf.this.a(Mf.e, LevelPlay.AdFormat.REWARDED, Pf.f7396a.a(ironSourceError != null ? ironSourceError.getErrorMessage() : null, adInfo));
        }

        @Override // com.ironsource.InterfaceC2555sb
        public void a(C2434ld c2434ld, AdInfo adInfo) {
            Lf.this.a(Mf.f7244f, LevelPlay.AdFormat.REWARDED, Pf.f7396a.a(Kf.f7064a.a(c2434ld), adInfo));
        }

        @Override // com.ironsource.InterfaceC2555sb
        public void b(AdInfo adInfo) {
            Lf.this.a(Mf.g, LevelPlay.AdFormat.REWARDED, Pf.f7396a.a(adInfo));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, LevelPlay.AdFormat adFormat, List<? extends Object> list) {
        this.f7094a.a(str, adFormat, list);
    }
}
