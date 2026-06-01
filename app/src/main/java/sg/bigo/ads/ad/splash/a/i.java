package sg.bigo.ads.ad.splash.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import java.util.HashSet;
import java.util.Set;
import sg.bigo.ads.ad.b.a;
import sg.bigo.ads.ad.interstitial.multi_img.view.d;
import sg.bigo.ads.ad.interstitial.w;
import sg.bigo.ads.ad.interstitial.x;
import sg.bigo.ads.api.a.m;
import sg.bigo.ads.common.view.Indicator;
import sg.bigo.ads.common.view.RoundedFrameLayout;
import sg.bigo.ads.common.view.ViewFlow;

/* JADX INFO: loaded from: classes6.dex */
public final class i extends sg.bigo.ads.ad.interstitial.e {
    static final Set<sg.bigo.ads.ad.interstitial.multi_img.view.d> j = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ViewFlow f15361c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Indicator f15362d;
    RoundedFrameLayout e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    sg.bigo.ads.ad.interstitial.multi_img.a f15363f;
    sg.bigo.ads.ad.interstitial.multi_img.view.b g;

    @NonNull
    final sg.bigo.ads.ad.interstitial.multi_img.b h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    final x f15364i;

    @NonNull
    final sg.bigo.ads.ad.b.c l;

    @NonNull
    final ViewGroup m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    sg.bigo.ads.ad.interstitial.multi_img.view.c f15366o;
    sg.bigo.ads.ad.interstitial.multi_img.view.c p;
    final a.InterfaceC0230a k = new a.InterfaceC0230a() { // from class: sg.bigo.ads.ad.splash.a.i.1
        @Override // sg.bigo.ads.ad.b.a.InterfaceC0230a
        public final boolean a() {
            if (i.this.f15361c != null) {
                return i.this.f15361c.h;
            }
            return false;
        }
    };

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    w f15367q = new w() { // from class: sg.bigo.ads.ad.splash.a.i.3
        @Override // sg.bigo.ads.ad.interstitial.w
        public final void a() {
            Bitmap bitmap = b.j;
            boolean zAR = ((sg.bigo.ads.core.a.a) i.this.l.f()).aR();
            if (bitmap != null) {
                if (zAR) {
                    synchronized (i.j) {
                        i.j.remove(i.this.g);
                    }
                }
                i.this.g.a(bitmap);
            }
        }
    };

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    final sg.bigo.ads.ad.interstitial.d f15365n = new sg.bigo.ads.ad.interstitial.d();

    /* JADX INFO: renamed from: sg.bigo.ads.ad.splash.a.i$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f15371a;

        static {
            int[] iArr = new int[sg.bigo.ads.ad.interstitial.multi_img.d.values().length];
            f15371a = iArr;
            try {
                iArr[sg.bigo.ads.ad.interstitial.multi_img.d.LTR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15371a[sg.bigo.ads.ad.interstitial.multi_img.d.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15371a[sg.bigo.ads.ad.interstitial.multi_img.d.FULL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15371a[sg.bigo.ads.ad.interstitial.multi_img.d.TILE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public i(@NonNull sg.bigo.ads.ad.b.c cVar, @NonNull ViewGroup viewGroup, @NonNull x xVar, @NonNull sg.bigo.ads.ad.interstitial.multi_img.b bVar) {
        this.l = cVar;
        this.m = viewGroup;
        this.h = bVar;
        this.f15364i = xVar;
    }

    public final sg.bigo.ads.ad.interstitial.multi_img.view.a a(Context context, sg.bigo.ads.ad.interstitial.multi_img.c cVar, int i2, String str, boolean z2) {
        final sg.bigo.ads.ad.interstitial.multi_img.view.a aVar = new sg.bigo.ads.ad.interstitial.multi_img.view.a(context, this.h, cVar, d(), i2, str, z2, null);
        aVar.f14909s = true;
        ViewFlow.b bVar = new ViewFlow.b();
        bVar.f16158a = -1;
        bVar.f16159b = -1;
        bVar.f16160c = false;
        bVar.f16161d = cVar.f14860d;
        this.f15361c.addView(aVar.j, bVar);
        if (this.f15363f != null) {
            aVar.f14908r = new d.a() { // from class: sg.bigo.ads.ad.splash.a.i.10
                @Override // sg.bigo.ads.ad.interstitial.multi_img.view.d.a
                public final void a() {
                    i.this.f15363f.a(i.this.f15361c.a(aVar.j));
                }

                @Override // sg.bigo.ads.ad.interstitial.multi_img.view.d.a
                public final void b() {
                    aVar.f14908r = null;
                    a();
                }
            };
        }
        return aVar;
    }

    public final int d() {
        m mVar = this.h.f14843a;
        if (mVar == null) {
            return 1;
        }
        return sg.bigo.ads.ad.interstitial.multi_img.e.a(mVar.a("video_play_page.mediaview_colour"));
    }

    public final boolean e() {
        return this.h.f14844b == sg.bigo.ads.ad.interstitial.multi_img.d.NONE;
    }

    public final void f() {
        if (e()) {
            return;
        }
        int iA = this.h.f14843a.a("video_play_page.multi_guide");
        switch (iA) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                a(iA, new Runnable() { // from class: sg.bigo.ads.ad.splash.a.i.8
                    @Override // java.lang.Runnable
                    public final void run() {
                        i.this.f15361c.post(new Runnable() { // from class: sg.bigo.ads.ad.splash.a.i.8.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                if (i.this.f15361c.g) {
                                    return;
                                }
                                i.a(i.this, 3L, 0L, 300L);
                            }
                        });
                    }
                });
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                this.f15361c.setFlipInterval((iA - 5) * 1000);
                this.f15361c.c();
                break;
        }
    }

    public static /* synthetic */ void a(i iVar, final long j3, long j8, final long j9) {
        if (j3 > 0) {
            ViewFlow viewFlow = iVar.f15361c;
            if (!viewFlow.g && !viewFlow.e()) {
                iVar.f15361c.setScrollEnabled(false);
                int iA = sg.bigo.ads.common.utils.e.a(iVar.m.getContext(), 40);
                final int scrollX = iVar.f15361c.getScrollX();
                ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, iA, 0);
                valueAnimatorOfInt.setDuration(2 * j9);
                valueAnimatorOfInt.setStartDelay(j8);
                valueAnimatorOfInt.setInterpolator(new LinearInterpolator());
                valueAnimatorOfInt.addListener(new AnimatorListenerAdapter() { // from class: sg.bigo.ads.ad.splash.a.i.6
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        i.a(i.this, j3 - 1, 300L, j9);
                    }
                });
                valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: sg.bigo.ads.ad.splash.a.i.7
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Object animatedValue = valueAnimator.getAnimatedValue();
                        if (animatedValue instanceof Integer) {
                            i.this.f15361c.scrollTo(((Integer) animatedValue).intValue() + scrollX, i.this.f15361c.getScrollY());
                        }
                    }
                });
                valueAnimatorOfInt.start();
                return;
            }
        }
        iVar.f15361c.setScrollEnabled(true);
    }
}
