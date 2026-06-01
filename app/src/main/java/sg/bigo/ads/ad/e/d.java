package sg.bigo.ads.ad.e;

import android.app.Activity;
import androidx.annotation.NonNull;
import sg.bigo.ads.ad.e.c;
import sg.bigo.ads.ad.interstitial.AdCountDownButton;
import sg.bigo.ads.common.utils.n;
import sg.bigo.ads.common.utils.r;

/* JADX INFO: loaded from: classes6.dex */
public class d extends sg.bigo.ads.ad.interstitial.h.a {
    private h e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f14152f;
    private boolean g;
    private n h;

    public d(@NonNull Activity activity) {
        super(activity);
        this.f14152f = false;
        this.g = false;
    }

    public static /* synthetic */ void h(d dVar) {
        n nVar = dVar.h;
        if (nVar != null) {
            nVar.d();
        }
        AdCountDownButton adCountDownButton = dVar.A;
        if (adCountDownButton != null) {
            adCountDownButton.b();
        }
    }

    public static /* synthetic */ boolean i(d dVar) {
        dVar.g = true;
        return true;
    }

    public static /* synthetic */ void k(d dVar) {
        n nVar = dVar.h;
        if (nVar != null) {
            nVar.c();
        }
        AdCountDownButton adCountDownButton = dVar.A;
        if (adCountDownButton != null) {
            adCountDownButton.c();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.h.a, sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.controller.e.b, sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void N() {
        super.N();
        T t3 = this.y;
        if (t3 == 0) {
            return;
        }
        if (t3 instanceof h) {
            this.e = (h) t3;
        } else {
            a("Illegal SAB content.");
        }
        if (this.A != null) {
            this.h = new n(r.f16034a.a(1)) { // from class: sg.bigo.ads.ad.e.d.1
                @Override // sg.bigo.ads.common.utils.n
                public final void a() {
                    sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.ad.e.d.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (d.this.e == null || d.this.f14152f) {
                                sg.bigo.ads.common.t.a.a(2, "", "Failed to claim reward because of null RewardVideoAd.");
                            } else {
                                d.e(d.this);
                                d.this.e.H();
                            }
                            if (d.this.A != null) {
                                d.this.A.d();
                            }
                        }
                    });
                }

                @Override // sg.bigo.ads.common.utils.n
                public final void a(long j) {
                    if (d.this.A != null) {
                        d.this.A.a(j);
                    }
                }
            };
            this.A.setVisibility(0);
            this.A.setTakeoverTickEvent(true);
            this.A.setShowCloseButtonInCountdown(true);
            this.A.a(1, (AdCountDownButton.b) null);
            this.h.c();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    public final void d(boolean z2) {
        if (this.A.getVisibility() != 0) {
            return;
        }
        if (!this.f14152f) {
            new c(this.I).a(new c.a() { // from class: sg.bigo.ads.ad.e.d.2
                @Override // sg.bigo.ads.ad.e.c.a
                public final void a() {
                    d.h(d.this);
                }

                @Override // sg.bigo.ads.ad.e.c.a
                public final void c() {
                    d.i(d.this);
                    d.this.T();
                }

                @Override // sg.bigo.ads.ad.e.c.a
                public final void d() {
                    d.k(d.this);
                }

                @Override // sg.bigo.ads.ad.e.c.a
                public final void b() {
                }
            });
            return;
        }
        n nVar = this.h;
        if (nVar != null) {
            nVar.b();
            this.h = null;
        }
        AdCountDownButton adCountDownButton = this.A;
        if (adCountDownButton != null) {
            adCountDownButton.d();
        }
        super.d(true);
    }

    @Override // sg.bigo.ads.ad.interstitial.h.a
    public final boolean e() {
        return true;
    }

    public static /* synthetic */ boolean e(d dVar) {
        dVar.f14152f = true;
        return true;
    }

    @Override // sg.bigo.ads.ad.interstitial.h.a
    public final boolean k() {
        return this.f14152f;
    }
}
