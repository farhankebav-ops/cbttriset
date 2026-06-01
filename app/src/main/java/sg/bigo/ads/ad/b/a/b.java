package sg.bigo.ads.ad.b.a;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import sg.bigo.ads.ad.b.c;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.AdOptionsView;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.NativeAd;
import sg.bigo.ads.api.b.d;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.core.f.a.k;

/* JADX INFO: loaded from: classes6.dex */
public final class b extends sg.bigo.ads.ad.b.d {
    private boolean X;
    private boolean Y;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private a f13863x;
    private d.a<NativeAd> y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f13864z;

    public b(@NonNull sg.bigo.ads.api.core.g gVar) {
        super(gVar);
        this.f13864z = false;
        this.X = false;
        this.Y = false;
        this.f13863x = new a(gVar);
    }

    public static /* synthetic */ void b(b bVar) {
        bVar.X = true;
        if (!bVar.Y || bVar.f14028i) {
            return;
        }
        sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.b.a.b.3
            @Override // java.lang.Runnable
            public final void run() {
                b.d(b.this);
                if (((sg.bigo.ads.ad.b.d) b.this).K == null || b.this.F == null) {
                    return;
                }
                b bVar2 = b.this;
                b.super.a(bVar2.F);
            }
        });
    }

    public static /* synthetic */ void d(b bVar) {
        MediaView mediaView = bVar.F;
        if (mediaView != null) {
            View viewFindViewWithTag = mediaView.findViewWithTag("blur_image_view");
            bVar.F.removeAllViews();
            if (viewFindViewWithTag != null) {
                u.a(viewFindViewWithTag, bVar.F, null, 0);
            }
        }
    }

    @Override // sg.bigo.ads.ad.b.d
    @NonNull
    public final k E() {
        return new k(0, 1);
    }

    @Override // sg.bigo.ads.ad.d, sg.bigo.ads.ad.c
    public final void a() {
        super.a();
        this.f13863x.a();
    }

    @Override // sg.bigo.ads.ad.c
    public final String i() {
        View view = this.f14025c;
        return view == null ? "" : view.getWidth() > this.f14025c.getHeight() * 2 ? "320x50" : "300x250";
    }

    @Override // sg.bigo.ads.ad.b.c
    public final void y() {
        this.f13863x.a(this.y, 0);
        c.b bVar = ((sg.bigo.ads.ad.b.c) this).B;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // sg.bigo.ads.ad.b.c
    public final void a(@NonNull ViewGroup viewGroup, MediaView mediaView, @Nullable View view, @Nullable AdOptionsView adOptionsView, @Nullable List<View> list, int i2, @Nullable View... viewArr) {
        super.a(viewGroup, mediaView, view, adOptionsView, list, i2, viewArr);
        this.Y = true;
        mediaView.setMediaAreaClickable(true);
        mediaView.b().a(false);
        u.a(this.f14025c, ((sg.bigo.ads.ad.b.c) this).C);
    }

    @Override // sg.bigo.ads.ad.b.d, sg.bigo.ads.ad.b.c, sg.bigo.ads.ad.c
    public final void h() {
        if (((sg.bigo.ads.ad.b.c) this).A > 0) {
            a("attach_render_cost", Long.valueOf(SystemClock.elapsedRealtime() - ((sg.bigo.ads.ad.b.c) this).A));
        }
        super.h();
    }

    public static /* synthetic */ void a(b bVar) {
        bVar.f13864z = true;
        if (!bVar.Y || bVar.X || bVar.f14028i) {
            return;
        }
        sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.b.a.b.2
            @Override // java.lang.Runnable
            public final void run() {
                if (b.this.F != null) {
                    b.d(b.this);
                    b.this.f13863x.a(b.this.F);
                }
            }
        });
    }

    @Override // sg.bigo.ads.ad.b.d, sg.bigo.ads.ad.b.c
    public final void a(@Nullable final MediaView mediaView) {
        Runnable runnable;
        if (mediaView == null) {
            return;
        }
        if (this.X && ((sg.bigo.ads.ad.b.d) this).K != null) {
            runnable = new Runnable() { // from class: sg.bigo.ads.ad.b.a.b.4
                @Override // java.lang.Runnable
                public final void run() {
                    mediaView.removeAllViews();
                    b.super.a(mediaView);
                }
            };
        } else if (!this.f13864z) {
            return;
        } else {
            runnable = new Runnable() { // from class: sg.bigo.ads.ad.b.a.b.5
                @Override // java.lang.Runnable
                public final void run() {
                    mediaView.removeAllViews();
                    b.this.f13863x.a(mediaView);
                }
            };
        }
        sg.bigo.ads.common.n.d.b(runnable);
    }

    @Override // sg.bigo.ads.ad.b.d, sg.bigo.ads.ad.b.c
    public final void a(@NonNull final d.a<NativeAd> aVar, int i2) {
        d.a<NativeAd> aVar2 = new d.a<NativeAd>() { // from class: sg.bigo.ads.ad.b.a.b.1
            @Override // sg.bigo.ads.api.b.d.a
            public final /* synthetic */ void a(Ad ad) {
                NativeAd nativeAd = (NativeAd) ad;
                aVar.a(nativeAd);
                if (nativeAd instanceof a) {
                    b.a(b.this);
                } else if (nativeAd instanceof b) {
                    b.b(b.this);
                }
            }

            @Override // sg.bigo.ads.api.b.d.a
            public final /* bridge */ /* synthetic */ void a(Ad ad, int i8, int i9, String str) {
                aVar.a((NativeAd) ad, i8, i9, str);
            }

            @Override // sg.bigo.ads.api.b.d.a
            public final /* bridge */ /* synthetic */ void a(Ad ad, boolean z2, int i8, int i9, String str, boolean z7) {
            }
        };
        this.y = aVar2;
        super.a(aVar2, i2);
    }
}
