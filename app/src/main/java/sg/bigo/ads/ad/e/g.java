package sg.bigo.ads.ad.e;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sg.bigo.ads.ad.e.c;
import sg.bigo.ads.ad.interstitial.AdCountDownButton;
import sg.bigo.ads.ad.interstitial.d.m;
import sg.bigo.ads.ad.interstitial.t;
import sg.bigo.ads.ad.interstitial.u;
import sg.bigo.ads.ad.interstitial.x;
import sg.bigo.ads.ad.interstitial.z;
import sg.bigo.ads.api.VideoController;

/* JADX INFO: loaded from: classes6.dex */
class g extends z {

    @Nullable
    protected h H;
    private boolean L;
    private boolean M;
    private boolean N;
    private boolean O;

    public g(@NonNull Activity activity) {
        super(activity);
        this.L = true;
        this.M = false;
        this.N = false;
        this.O = false;
    }

    private void ar() {
        h hVar = this.H;
        if (hVar != null && !this.M) {
            this.M = true;
            hVar.H();
        } else if (hVar == null) {
            sg.bigo.ads.common.t.a.a(2, "", "Failed to claim reward because of null RewardVideoAd.");
        }
    }

    public static /* synthetic */ boolean f(g gVar) {
        gVar.O = true;
        return true;
    }

    @Override // sg.bigo.ads.ad.interstitial.z, sg.bigo.ads.ad.interstitial.a, sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.ad.interstitial.k.b
    public final void C() {
        this.e = true;
        if (G()) {
            F();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.controller.e.b, sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void N() {
        super.N();
        T t3 = this.y;
        if (t3 == 0) {
            return;
        }
        if (t3 instanceof h) {
            this.H = (h) t3;
        }
        if (this.H == null || !ab()) {
            a("Illegal video content.");
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.controller.e.b, sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void W() {
        if (this.L && c() == 0) {
            d(true);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.z, sg.bigo.ads.ad.interstitial.r
    public final int Y() {
        int i2 = ((sg.bigo.ads.ad.interstitial.a) this).f14180b.a("interstitial_video_style.video_play_page.icon_strategy") != 2 ? 1 : 2;
        if (this.p.get()) {
            return 3;
        }
        return i2;
    }

    @Override // sg.bigo.ads.ad.interstitial.z, sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.ad.interstitial.k.b
    public final void b(String str) {
        this.N = true;
        super.b(str);
    }

    @Override // sg.bigo.ads.ad.interstitial.a
    public final void q() {
        super.q();
        sg.bigo.ads.core.a.a aVarF = ((t) this.y).f();
        if (!this.p.get() || aVarF.bh() == null || this.L) {
            return;
        }
        x xVar = this.h;
        xVar.f15195b = 0;
        xVar.f15196c = 15;
    }

    @Override // sg.bigo.ads.ad.interstitial.z, sg.bigo.ads.ad.interstitial.a
    public final void x() {
        super.x();
        AdCountDownButton adCountDownButton = this.A;
        if (adCountDownButton != null) {
            adCountDownButton.setShowCloseButtonInCountdown(this.L);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.z, sg.bigo.ads.ad.interstitial.a
    public final boolean f(boolean z2) {
        if (this.p.get()) {
            AdCountDownButton adCountDownButton = this.A;
            if (adCountDownButton != null) {
                adCountDownButton.d();
            }
        } else if (!this.M && this.L && c() == 0 && !this.O) {
            final VideoController videoControllerAa = aa();
            new c(this.I).a(new c.a() { // from class: sg.bigo.ads.ad.e.g.1

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                private int f14162c = -1;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                private boolean f14163d = false;
                private boolean e = false;

                private void e() {
                    if (g.this.c() == 3) {
                        g.this.f(this.f14162c);
                    }
                }

                @Override // sg.bigo.ads.ad.e.c.a
                public final void a() {
                    this.f14162c = g.this.c();
                    g.this.f(3);
                    VideoController videoController = videoControllerAa;
                    if (videoController != null && videoController.isPlaying()) {
                        videoControllerAa.pause();
                        this.f14163d = true;
                    }
                    h hVar = g.this.H;
                    if (hVar != null) {
                        sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) hVar.f(), g.this.c(), 2);
                    }
                    g.this.Z().c();
                    ((z) g.this).G.b(false);
                }

                @Override // sg.bigo.ads.ad.e.c.a
                public final void b() {
                    VideoController videoController;
                    e();
                    if (!this.e && this.f14163d && (videoController = videoControllerAa) != null && videoController.isPaused()) {
                        videoControllerAa.play();
                    }
                    g.this.Z().b();
                    ((z) g.this).G.a(false);
                }

                @Override // sg.bigo.ads.ad.e.c.a
                public final void c() {
                    this.e = true;
                    g.f(g.this);
                    if (g.this.K() || g.this.L()) {
                        g.this.T();
                        return;
                    }
                    if (g.this.f14188r != null && g.this.f14188r.y.a()) {
                        e();
                    } else if (!g.this.f14182d && ((sg.bigo.ads.ad.interstitial.a) g.this).f14180b.a("interstitial_video_style.video_play_page.skip_type") != 2) {
                        g.this.T();
                    } else {
                        e();
                        g.this.l(6);
                    }
                }

                @Override // sg.bigo.ads.ad.e.c.a
                public final void d() {
                    u uVarZ = g.this.Z();
                    if (uVarZ instanceof m) {
                        ((m) uVarZ).A();
                    }
                }
            });
            return false;
        }
        boolean zF = super.f(z2);
        if (zF && (this.p.get() || this.N)) {
            ar();
        }
        return zF;
    }

    @Override // sg.bigo.ads.ad.interstitial.z, sg.bigo.ads.api.VideoController.a
    public final void i(boolean z2) {
        AdCountDownButton adCountDownButton;
        super.i(z2);
        if (z2 || c() != 0 || this.L || (adCountDownButton = this.A) == null) {
            return;
        }
        adCountDownButton.setTakeoverTickEvent(false);
        this.A.a(15, (AdCountDownButton.b) null);
    }

    @Override // sg.bigo.ads.ad.interstitial.z, sg.bigo.ads.ad.interstitial.a, sg.bigo.ads.ad.interstitial.r, sg.bigo.ads.ad.interstitial.i
    public final void m() {
        boolean z2;
        super.m();
        sg.bigo.ads.api.a.m mVar = ((sg.bigo.ads.ad.interstitial.a) this).f14181c;
        if (mVar != null) {
            z2 = this.L & (mVar.a("video_play_page.force_staying_time") != -1);
        } else {
            z2 = this.L & (((sg.bigo.ads.ad.interstitial.a) this).f14180b.a("interstitial_video_style.style") != 2);
        }
        this.L = z2;
        if (this.L) {
            return;
        }
        x xVar = this.h;
        xVar.f15195b = 0;
        xVar.f15196c = -1;
    }

    @Override // sg.bigo.ads.ad.interstitial.z, sg.bigo.ads.ad.interstitial.b.a.InterfaceC0249a
    public final void a(boolean z2, boolean z7) {
        super.a(z2, z7);
        if (z2 || z7) {
            AdCountDownButton adCountDownButton = this.A;
            if (adCountDownButton != null) {
                adCountDownButton.d();
            }
            ar();
        }
    }
}
