package sg.bigo.ads.ad.splash.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import java.util.List;
import sg.bigo.ads.ad.interstitial.a.b.c;
import sg.bigo.ads.ad.splash.a.c;
import sg.bigo.ads.api.AdOptionsView;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.a.l;
import sg.bigo.ads.core.f.a.p;

/* JADX INFO: loaded from: classes6.dex */
public final class g implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public sg.bigo.ads.ad.interstitial.a.b f15352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public sg.bigo.ads.ad.interstitial.a.a f15353c;
    public int g;

    @NonNull
    private final sg.bigo.ads.ad.splash.b h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f15351a = c.a.f15329a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f15354d = false;
    public int e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f15355f = false;

    public static class a implements sg.bigo.ads.ad.banner.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f15358a = 13;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f15359b = 6;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final sg.bigo.ads.ad.splash.b f15360c;

        public a(@NonNull sg.bigo.ads.ad.splash.b bVar) {
            this.f15360c = bVar;
        }

        @Override // sg.bigo.ads.ad.banner.h
        public final void a() {
            this.f15360c.d(this.f15359b);
        }

        @Override // sg.bigo.ads.ad.banner.h
        public final void a(String str) {
        }

        @Override // sg.bigo.ads.ad.banner.h
        public final void a(sg.bigo.ads.common.i iVar, sg.bigo.ads.api.core.e eVar) {
            this.f15360c.f15396x.a(iVar, this.f15358a, this.f15359b, eVar);
        }

        @Override // sg.bigo.ads.ad.banner.h
        public final void b() {
        }
    }

    public g(@NonNull final sg.bigo.ads.ad.splash.b bVar, @NonNull l lVar, @NonNull sg.bigo.ads.api.core.c cVar) {
        p pVar;
        l lVar2;
        sg.bigo.ads.api.core.c cVar2;
        int i2 = 0;
        int i8 = 1;
        this.g = 0;
        this.h = bVar;
        sg.bigo.ads.ad.b.c cVar3 = bVar.f15396x;
        boolean z2 = cVar3 instanceof sg.bigo.ads.ad.b.d;
        sg.bigo.ads.core.player.c cVar4 = z2 ? ((sg.bigo.ads.ad.b.d) cVar3).J : null;
        if (z2) {
            pVar = ((sg.bigo.ads.ad.b.d) cVar3).K;
            cVar2 = cVar;
            lVar2 = lVar;
        } else {
            pVar = null;
            lVar2 = lVar;
            cVar2 = cVar;
        }
        sg.bigo.ads.ad.interstitial.a.b bVar2 = new sg.bigo.ads.ad.interstitial.a.b(cVar3, lVar2, cVar2, cVar4, pVar);
        this.f15352b = bVar2;
        sg.bigo.ads.api.core.c cVar5 = cVar2;
        sg.bigo.ads.ad.interstitial.a.a aVar = new sg.bigo.ads.ad.interstitial.a.a(bVar2.f14266a, cVar3, lVar2, cVar5, z2 ? ((sg.bigo.ads.ad.b.d) cVar3).J : null, z2 ? ((sg.bigo.ads.ad.b.d) cVar3).K : null);
        this.f15353c = aVar;
        if (this.f15352b.f14266a) {
            i2 = 1;
        } else if (aVar.f14218a) {
            i2 = 2;
        }
        this.g = i2;
        cVar5.d(i2);
        if (!this.f15352b.f14266a && !(this.f15353c.f14219b instanceof sg.bigo.ads.ad.interstitial.a.a.b)) {
            i8 = 2;
        }
        cVar5.e(i8);
        sg.bigo.ads.ad.interstitial.a.b bVar3 = this.f15352b;
        if (bVar3 != null) {
            bVar3.a(new a(bVar));
            this.f15352b.a(bVar.f14024b.f15500f);
        }
        sg.bigo.ads.ad.interstitial.a.a aVar2 = this.f15353c;
        if (aVar2 != null) {
            aVar2.a(new a(bVar));
            this.f15353c.a(new c.a() { // from class: sg.bigo.ads.ad.splash.a.g.1
                @Override // sg.bigo.ads.ad.interstitial.a.b.c.a
                public final void a(sg.bigo.ads.common.i iVar, sg.bigo.ads.api.core.e eVar) {
                    bVar.f15396x.a(iVar, 15, 9, eVar);
                }
            });
            this.f15353c.a(bVar.f14024b.f15500f);
        }
    }

    private boolean f() {
        sg.bigo.ads.ad.interstitial.a.b bVar = this.f15352b;
        if (bVar == null || !bVar.f14266a || !bVar.b()) {
            return false;
        }
        sg.bigo.ads.ad.interstitial.a.b bVar2 = this.f15352b;
        return (bVar2.f14267b || bVar2.f14270f.f14228i == null) ? false : true;
    }

    private boolean g() {
        sg.bigo.ads.ad.interstitial.a.a aVar = this.f15353c;
        return aVar != null && aVar.f14218a && aVar.b() && this.f15353c.a() != null;
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    public final void a() {
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    public final void c() {
        this.f15351a = c.a.f15332d;
        sg.bigo.ads.ad.interstitial.a.b bVar = this.f15352b;
        if (bVar != null) {
            bVar.e();
            this.f15352b = null;
        }
        sg.bigo.ads.ad.interstitial.a.a aVar = this.f15353c;
        if (aVar != null) {
            aVar.e();
            this.f15353c = null;
        }
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    @NonNull
    public final int d() {
        return this.f15351a;
    }

    public final boolean e() {
        return f() || g();
    }

    public final void a(Runnable runnable) {
        sg.bigo.ads.ad.interstitial.a.b bVar = this.f15352b;
        if (bVar != null) {
            bVar.a(runnable);
        }
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    public final void a(boolean z2) {
        if (z2) {
            if (this.f15355f) {
                sg.bigo.ads.ad.interstitial.a.b bVar = this.f15352b;
                if (bVar != null) {
                    bVar.f14270f.c();
                    return;
                }
                return;
            }
            sg.bigo.ads.ad.interstitial.a.a aVar = this.f15353c;
            if (aVar != null) {
                aVar.c();
                return;
            }
            return;
        }
        if (this.f15355f) {
            sg.bigo.ads.ad.interstitial.a.b bVar2 = this.f15352b;
            if (bVar2 != null) {
                bVar2.f14270f.d();
                return;
            }
            return;
        }
        sg.bigo.ads.ad.interstitial.a.a aVar2 = this.f15353c;
        if (aVar2 != null) {
            aVar2.d();
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [sg.bigo.ads.api.core.c] */
    @Override // sg.bigo.ads.ad.splash.a.c
    public final void a(boolean z2, @NonNull ViewGroup viewGroup, int i2) {
        int i8;
        this.f15351a = z2 ? c.a.f15330b : c.a.f15331c;
        if (z2) {
            if (this.e == 2) {
                viewGroup.removeViewAt(1);
            }
            if (f()) {
                View view = this.f15352b.f14270f.f14228i;
                viewGroup.addView(view, 1, new FrameLayout.LayoutParams(-1, -1));
                if (view != null) {
                    view.setTag(19);
                }
                this.f15352b.a(1);
                this.f15354d = true;
                this.f15355f = true;
                i8 = 5;
            } else {
                View viewA = this.f15353c.a();
                viewGroup.addView(viewA, 1, new FrameLayout.LayoutParams(-1, -1));
                if (viewA != null) {
                    viewA.setTag(20);
                }
                this.f15353c.a(1);
                this.f15354d = true;
                i8 = 7;
            }
            int i9 = this.e == 2 ? 9 : 8;
            sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) this.h.f15396x.f(), i8, i2);
            this.h.f15396x.a(viewGroup, (MediaView) null, (ImageView) null, (AdOptionsView) null, (List<View>) null, i9, null);
        }
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    public final void b() {
    }
}
