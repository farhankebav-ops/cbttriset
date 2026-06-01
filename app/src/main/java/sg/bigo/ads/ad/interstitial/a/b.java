package sg.bigo.ads.ad.interstitial.a;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import sg.bigo.ads.ad.banner.h;
import sg.bigo.ads.ad.interstitial.a.b.a;
import sg.bigo.ads.ad.interstitial.a.b.b;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.a.l;
import sg.bigo.ads.api.core.c;
import sg.bigo.ads.core.f.a.a;
import sg.bigo.ads.core.f.a.p;

/* JADX INFO: loaded from: classes6.dex */
public final class b implements sg.bigo.ads.ad.interstitial.a.b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f14266a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Runnable f14268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InterfaceC0247b f14269d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final sg.bigo.ads.ad.interstitial.a.a.b f14270f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f14267b = false;
    final a.C0248a e = new a.C0248a();

    public final class a implements b.a {
        private a() {
        }

        @Override // sg.bigo.ads.ad.interstitial.a.b.b.a
        public final void a() {
            Runnable runnable = b.this.f14268c;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // sg.bigo.ads.ad.interstitial.a.b.b.a
        public final void b() {
            InterfaceC0247b interfaceC0247b = b.this.f14269d;
            if (interfaceC0247b != null) {
                interfaceC0247b.a();
            }
        }

        @Override // sg.bigo.ads.ad.interstitial.a.b.b.a
        public final void c(@NonNull c cVar, long j) {
            b.this.e.a(cVar, 1, j);
        }

        @Override // sg.bigo.ads.ad.interstitial.a.b.b.a
        public final void d(@NonNull c cVar, long j) {
            b.this.e.a(cVar, 5, j);
        }

        public /* synthetic */ a(b bVar, byte b8) {
            this();
        }

        @Override // sg.bigo.ads.ad.interstitial.a.b.b.a
        public final void a(@NonNull c cVar) {
            b.this.e.a(cVar, 6, 0L);
        }

        @Override // sg.bigo.ads.ad.interstitial.a.b.b.a
        public final void b(@NonNull c cVar, long j) {
            b.this.e.a(cVar, 2, j);
        }

        @Override // sg.bigo.ads.ad.interstitial.a.b.b.a
        public final boolean c() {
            return false;
        }

        @Override // sg.bigo.ads.ad.interstitial.a.b.b.a
        public final void a(@NonNull c cVar, long j) {
            b.this.e.a(cVar, 0, j);
        }
    }

    /* JADX INFO: renamed from: sg.bigo.ads.ad.interstitial.a.b$b, reason: collision with other inner class name */
    public interface InterfaceC0247b {
        void a();
    }

    public b(@NonNull Ad ad, @NonNull l lVar, @NonNull c cVar, @Nullable sg.bigo.ads.core.player.c cVar2, @Nullable p pVar) {
        sg.bigo.ads.core.f.a.a next;
        byte b8 = 0;
        a.C0316a c0316aBn = ad instanceof sg.bigo.ads.core.a.a ? ((sg.bigo.ads.core.a.a) ad).bn() : null;
        if ((c0316aBn == null || !c0316aBn.a()) && pVar != null) {
            Iterator<sg.bigo.ads.core.f.a.a> it = pVar.A.iterator();
            while (it.hasNext() && ((next = it.next()) == null || (c0316aBn = next.a()) == null || !c0316aBn.a())) {
            }
        }
        a.C0316a c0316a = c0316aBn;
        boolean zS = lVar.s();
        boolean zAc = cVar.ac();
        boolean z2 = c0316a != null && c0316a.a();
        int iX = cVar.x();
        boolean z7 = (zS || cVar.ar()) && zAc && z2 && (iX == 3 || iX == 4 || iX == 12 || iX == 20);
        this.f14266a = z7;
        this.f14270f = z7 ? new sg.bigo.ads.ad.interstitial.a.a.b(ad, cVar, cVar2, pVar, c0316a, new a(this, b8)) : new sg.bigo.ads.ad.interstitial.a.a.b(ad, cVar, null, null, null, null);
        sg.bigo.ads.common.t.a.a(0, 3, "PlayableAdCompanion", "The ad with slot: " + lVar.l() + ", pid: " + lVar.n() + " is playable: " + z7);
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    @Nullable
    public final View a() {
        return this.f14270f.f14228i;
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final boolean b() {
        if (this.f14266a) {
            return this.f14270f.b();
        }
        return false;
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void c() {
        this.f14270f.c();
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void d() {
        this.f14270f.d();
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void e() {
        this.f14270f.e();
        this.f14269d = null;
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void f() {
        this.f14270f.f();
    }

    public b(@NonNull Ad ad, @NonNull l lVar, @NonNull a.C0316a c0316a, @NonNull c cVar, @Nullable sg.bigo.ads.core.player.c cVar2, @Nullable p pVar) {
        byte b8 = 0;
        boolean z2 = cVar.x() == 3 || cVar.x() == 4 || cVar.x() == 20;
        this.f14266a = z2;
        if (z2) {
            this.f14270f = new sg.bigo.ads.ad.interstitial.a.a.b(ad, cVar, cVar2, pVar, c0316a, new a(this, b8));
        } else {
            this.f14270f = new sg.bigo.ads.ad.interstitial.a.a.b(ad, cVar, null, null, null, null);
        }
        sg.bigo.ads.common.t.a.a(0, 3, "PlayableAdCompanion", "The ad with slot: " + lVar.l() + ", pid: " + lVar.n() + " is playable: " + z2);
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void a(int i2) {
        if (i2 == 1) {
            this.f14267b = true;
        }
        this.f14270f.a(i2);
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void a(int i2, int i8) {
        this.f14270f.a(i2, i8);
    }

    public final void a(Runnable runnable) {
        if (this.f14268c == runnable) {
            this.f14268c = null;
        }
    }

    public final void a(h hVar) {
        this.f14270f.g = hVar;
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final boolean a(Context context) {
        if (this.f14266a) {
            return this.f14270f.a(context);
        }
        return false;
    }
}
