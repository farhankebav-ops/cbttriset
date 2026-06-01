package sg.bigo.ads.ad.e;

import android.app.Activity;
import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sg.bigo.ads.ad.e.c;
import sg.bigo.ads.ad.interstitial.AdCountDownButton;
import sg.bigo.ads.ad.interstitial.m;
import sg.bigo.ads.ad.interstitial.n;
import sg.bigo.ads.ad.interstitial.o;
import sg.bigo.ads.common.utils.r;

/* JADX INFO: loaded from: classes6.dex */
class a extends m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    protected b f14139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f14140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f14141d;
    private boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f14142f;

    public a(@NonNull Activity activity) {
        super(activity);
        this.f14140c = true;
        this.f14141d = false;
        this.e = false;
        this.f14142f = false;
    }

    public static /* synthetic */ boolean c(a aVar) {
        aVar.f14142f = true;
        return true;
    }

    public static /* synthetic */ boolean s(a aVar) {
        aVar.e = true;
        return true;
    }

    @Override // sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.controller.e.b, sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void N() {
        super.N();
        T t3 = this.y;
        if (t3 == 0) {
            return;
        }
        if (t3 instanceof b) {
            this.f14139b = (b) t3;
        }
        if (this.f14139b == null) {
            a("Illegal reward banner content.");
        }
        if (this.A.getVisibility() != 0) {
            this.A.setVisibility(0);
            sg.bigo.ads.ad.interstitial.c.b((View) this.A);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.controller.e.b, sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void W() {
        if (this.f14140c) {
            d(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        b bVar = this.f14139b;
        if (bVar != null && !this.f14141d) {
            this.f14141d = true;
            bVar.D();
        } else if (bVar == null) {
            sg.bigo.ads.common.t.a.a(2, "", "Failed to claim reward because of null RewardVideoAd.");
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.m
    public final void a() {
        T t3 = this.y;
        if (t3 == 0) {
            return;
        }
        n nVarC = ((o) t3).C();
        if (nVarC == null) {
            this.A.a(15, new AdCountDownButton.b() { // from class: sg.bigo.ads.ad.e.a.1
                @Override // sg.bigo.ads.ad.interstitial.AdCountDownButton.b
                public final void a() {
                    sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.e.a.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (a.this.A != null) {
                                a.this.A.d();
                            }
                            a.c(a.this);
                            a.this.b();
                        }
                    });
                }
            });
            return;
        }
        int i2 = nVarC.f14928b;
        if (i2 < 0) {
            this.A.setShowCloseButtonInCountdown(false);
        }
        this.A.setTakeoverTickEvent(true);
        this.A.a(i2, (AdCountDownButton.b) null);
        int i8 = nVarC.e;
        sg.bigo.ads.common.utils.n nVar = new sg.bigo.ads.common.utils.n(r.f16034a.a(i8 >= 5 ? i8 : 15)) { // from class: sg.bigo.ads.ad.e.a.2
            @Override // sg.bigo.ads.common.utils.n
            public final void a() {
                sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.ad.e.a.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (a.this.A != null) {
                            a.this.A.d();
                        }
                        a.c(a.this);
                        a.this.b();
                    }
                });
            }

            @Override // sg.bigo.ads.common.utils.n
            public final void a(long j) {
                if (a.this.A != null) {
                    a.this.A.a(j);
                }
            }
        };
        ((m) this).f14832a = nVar;
        nVar.c();
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    public final void d(boolean z2) {
        if (this.A.getVisibility() == 0) {
            AdCountDownButton adCountDownButton = this.A;
            if (adCountDownButton.f14166c) {
                if (!this.e && !this.f14142f) {
                    new c(this.I).a(new c.a() { // from class: sg.bigo.ads.ad.e.a.3
                        @Override // sg.bigo.ads.ad.e.c.a
                        public final void a() {
                            if (((m) a.this).f14832a != null) {
                                ((m) a.this).f14832a.d();
                            }
                            if (a.this.A != null) {
                                a.this.A.b();
                            }
                        }

                        @Override // sg.bigo.ads.ad.e.c.a
                        public final void b() {
                            if (((m) a.this).f14832a != null && ((m) a.this).f14832a.e()) {
                                ((m) a.this).f14832a.c();
                            }
                            if (a.this.A == null || a.this.A.f14166c) {
                                return;
                            }
                            a.this.A.c();
                        }

                        @Override // sg.bigo.ads.ad.e.c.a
                        public final void c() {
                            a.s(a.this);
                            a.this.T();
                        }

                        @Override // sg.bigo.ads.ad.e.c.a
                        public final void d() {
                        }
                    });
                    return;
                }
                adCountDownButton.d();
                b();
                super.d(true);
            }
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.m, sg.bigo.ads.ad.interstitial.i
    public final void g(@LayoutRes int i2) {
        super.g(i2);
    }
}
