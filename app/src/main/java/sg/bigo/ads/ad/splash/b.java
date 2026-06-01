package sg.bigo.ads.ad.splash;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.ValueCallback;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.AdCountDownButton;
import sg.bigo.ads.ad.interstitial.w;
import sg.bigo.ads.ad.interstitial.x;
import sg.bigo.ads.ad.splash.a.c;
import sg.bigo.ads.ad.splash.a.d;
import sg.bigo.ads.ad.splash.a.e;
import sg.bigo.ads.ad.splash.a.f;
import sg.bigo.ads.ad.splash.a.h;
import sg.bigo.ads.ad.splash.a.j;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.AdInteractionListener;
import sg.bigo.ads.api.NativeAd;
import sg.bigo.ads.api.SplashAd;
import sg.bigo.ads.api.SplashAdInteractionListener;
import sg.bigo.ads.api.a.m;
import sg.bigo.ads.api.b.d;
import sg.bigo.ads.api.core.g;
import sg.bigo.ads.api.core.p;
import sg.bigo.ads.common.i;
import sg.bigo.ads.common.utils.n;
import sg.bigo.ads.common.utils.u;

/* JADX INFO: loaded from: classes6.dex */
public final class b extends sg.bigo.ads.ad.c<SplashAd, sg.bigo.ads.core.a.a> implements SplashAd {

    @Nullable
    public final m A;
    public final g B;
    private h C;
    private sg.bigo.ads.ad.splash.a.a D;
    private long E;

    @NonNull
    private final m F;
    private ViewGroup G;
    private AdCountDownButton H;
    private n I;
    private Runnable J;
    private Runnable K;
    private Runnable L;
    private Runnable M;
    private n N;
    private long X;
    private long Y;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public sg.bigo.ads.ad.splash.a.g f15395w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @NonNull
    public final sg.bigo.ads.ad.b.c f15396x;
    boolean y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @NonNull
    final c f15397z;

    public b(@NonNull sg.bigo.ads.ad.b.c cVar, g gVar, @NonNull m mVar, @Nullable m mVar2) {
        super(gVar);
        this.y = false;
        this.X = 0L;
        this.Y = 0L;
        this.F = mVar;
        this.A = mVar2;
        this.B = gVar;
        a((sg.bigo.ads.api.b.a) cVar);
        this.f15396x = cVar;
        c cVar2 = new c() { // from class: sg.bigo.ads.ad.splash.b.1
            @Override // sg.bigo.ads.ad.splash.c, sg.bigo.ads.api.AdInteractionListener
            public final void onAdClicked() {
                super.onAdClicked();
                if (b.this.C != null) {
                    b.this.C.b();
                }
            }

            @Override // sg.bigo.ads.ad.splash.c, sg.bigo.ads.api.SplashAdInteractionListener
            public final void onAdFinished() {
                super.onAdFinished();
            }

            @Override // sg.bigo.ads.ad.splash.c, sg.bigo.ads.api.AdInteractionListener
            public final void onAdImpression() {
                super.onAdImpression();
                b.this.E = SystemClock.elapsedRealtime();
                if (b.this.C != null) {
                    b.this.C.a();
                }
                b.this.x();
            }
        };
        this.f15397z = cVar2;
        cVar.setAdInteractionListener(cVar2);
        int iAs = gVar.f15496a.as();
        int iA = mVar2 != null ? mVar2.a("video_play_page.interactive_method", 0) : 0;
        if (1 == iAs && iA != 0) {
            this.C = new d(gVar, mVar, mVar2, this);
            return;
        }
        if (mVar2 == null || a.b(mVar) || a.b()) {
            this.C = new sg.bigo.ads.ad.splash.a.b(gVar, mVar, mVar2, this);
            return;
        }
        int iA2 = mVar2.a("video_play_page.ad_component_layout");
        if (iA2 == 3) {
            this.C = new e(gVar, mVar, mVar2, this);
        } else if (iA2 == 4 || iA2 == 5) {
            this.C = new f(iA2, gVar, mVar, mVar2, this);
        } else {
            this.C = new sg.bigo.ads.ad.splash.a.b(gVar, mVar, mVar2, this);
        }
    }

    private boolean F() {
        return f().aS() && P();
    }

    private void G() {
        ViewGroup viewGroup;
        if (this.A == null || !C()) {
            return;
        }
        if (this.D == null && (viewGroup = this.G) != null) {
            this.D = new sg.bigo.ads.ad.splash.a.a(viewGroup, this, this.A);
        }
        int iA = this.A.a("endpage.endpage_timing", 0);
        if (iA >= 3) {
            int i2 = iA == 4 ? 5000 : iA == 5 ? 10000 : 3000;
            if (this.N == null && !H()) {
                this.N = new n(i2) { // from class: sg.bigo.ads.ad.splash.b.10
                    @Override // sg.bigo.ads.common.utils.n
                    public final void a() {
                        b bVar = b.this;
                        if (bVar.f14028i || bVar.H()) {
                            return;
                        }
                        sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.splash.b.10.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                b.this.a(8, 12);
                            }
                        });
                    }

                    @Override // sg.bigo.ads.common.utils.n
                    public final void a(long j) {
                    }
                };
            }
            this.N.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean H() {
        sg.bigo.ads.ad.splash.a.a aVar = this.D;
        return aVar != null && aVar.f15290c == c.a.f15330b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        sg.bigo.ads.ad.splash.a.g gVar = this.f15395w;
        if (gVar != null) {
            gVar.a(this.M);
            sg.bigo.ads.common.n.d.a(this.L);
            this.f15395w.c();
            this.f15395w = null;
            this.M = null;
            this.L = null;
        }
    }

    private void N() {
        int iA;
        AdCountDownButton adCountDownButton = this.H;
        if (adCountDownButton == null) {
            return;
        }
        adCountDownButton.d();
        m mVar = this.A;
        if (mVar == null || (iA = mVar.a("endpage.close_click_seconds", 0)) <= 0) {
            return;
        }
        this.H.clearAnimation();
        this.H.setVisibility(4);
        if (this.K == null) {
            this.K = new Runnable() { // from class: sg.bigo.ads.ad.splash.b.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (b.this.A() || b.this.H.getVisibility() == 0) {
                        return;
                    }
                    b.this.H.setVisibility(0);
                    sg.bigo.ads.ad.interstitial.c.b((View) b.this.H);
                }
            };
        }
        sg.bigo.ads.common.n.d.a(2, this.K, ((long) iA) * 1000);
    }

    private boolean O() {
        m mVar = this.A;
        return (mVar == null || 1 != mVar.a("video_play_page.is_auto_close", 0) || P()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean P() {
        m mVar = this.A;
        return mVar != null && 6 == mVar.a("video_play_page.ad_component_layout", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Q() {
        m mVar;
        return C() && (mVar = this.A) != null && 2 == mVar.a("endpage.ad_component_layout", 1);
    }

    public final boolean A() {
        ViewGroup viewGroup;
        if (!O() || (viewGroup = this.G) == null || !(viewGroup.getContext() instanceof AdSplashActivity)) {
            return false;
        }
        d(9);
        return true;
    }

    public final boolean C() {
        m mVar;
        if (a.b() || (mVar = this.A) == null || mVar.a("endpage.endpage_timing", 0) <= 0) {
            return false;
        }
        return !O() || this.A.a("endpage.close_click_seconds", 0) > 0;
    }

    @Override // sg.bigo.ads.ad.c, sg.bigo.ads.api.b.a
    @NonNull
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public final sg.bigo.ads.core.a.a f() {
        return (sg.bigo.ads.core.a.a) this.f15396x.f();
    }

    public final void E() {
        sg.bigo.ads.ad.interstitial.a.b bVar;
        sg.bigo.ads.ad.splash.a.g gVar = this.f15395w;
        if (gVar == null || gVar.f15351a != c.a.f15330b) {
            this.f15396x.a(8, 22);
            return;
        }
        Context context = this.f14024b.e;
        if (gVar.f15355f && (bVar = gVar.f15352b) != null) {
            bVar.f14270f.a(context, null, null);
            return;
        }
        sg.bigo.ads.ad.interstitial.a.a aVar = gVar.f15353c;
        if (aVar != null) {
            sg.bigo.ads.ad.interstitial.a.b.a aVar2 = aVar.f14219b;
            if (aVar2 instanceof sg.bigo.ads.ad.interstitial.a.a.b) {
                ((sg.bigo.ads.ad.interstitial.a.a.b) aVar2).a(context, null, null);
            } else if (aVar2 instanceof sg.bigo.ads.ad.interstitial.a.a.c) {
                ((sg.bigo.ads.ad.interstitial.a.a.c) aVar2).a(context, (i) null);
            }
        }
    }

    @Override // sg.bigo.ads.ad.c
    @NonNull
    public final <ValueType> ValueType b(String str, ValueType valuetype) {
        return (ValueType) this.f15396x.b(str, valuetype);
    }

    @Override // sg.bigo.ads.api.b.a
    public final p c_() {
        sg.bigo.ads.ad.b.c cVar = this.f15396x;
        return cVar != null ? cVar.c_() : this.W;
    }

    public final void d(int i2) {
        this.f15397z.onAdSkipped();
        if (this.B != null) {
            this.X = (SystemClock.elapsedRealtime() - this.Y) + this.X;
            sg.bigo.ads.core.d.b.a(this.B.f15496a, i2, this.E > 0 ? SystemClock.elapsedRealtime() - this.E : 0L, this.X, this);
        }
    }

    @Override // sg.bigo.ads.ad.c
    public final void destroyInMainThread() {
        a.f15260b = false;
        a.f15259a = false;
        super.destroyInMainThread();
        this.f15396x.destroy();
        n nVar = this.N;
        if (nVar != null) {
            nVar.b();
            this.N = null;
        }
        Runnable runnable = this.J;
        if (runnable != null) {
            sg.bigo.ads.common.n.d.b(runnable);
            this.J = null;
        }
        Runnable runnable2 = this.K;
        if (runnable2 != null) {
            sg.bigo.ads.common.n.d.a(runnable2);
            this.K = null;
        }
        h hVar = this.C;
        if (hVar != null) {
            hVar.c();
            this.C = null;
        }
        sg.bigo.ads.ad.splash.a.a aVar = this.D;
        if (aVar != null) {
            aVar.c();
            this.D = null;
        }
        a.a();
        M();
        this.G = null;
    }

    @Override // sg.bigo.ads.api.Ad
    @Nullable
    public final String getCreativeId() {
        return this.f15396x.getCreativeId();
    }

    @Override // sg.bigo.ads.ad.c, sg.bigo.ads.api.Ad
    @Nullable
    public final String getExtraInfo(String str) {
        return null;
    }

    @Override // sg.bigo.ads.api.SplashAd
    public final SplashAd.Style getStyle() {
        return a.c(this.F);
    }

    @Override // sg.bigo.ads.ad.c, sg.bigo.ads.api.Ad
    public final boolean isExpired() {
        return false;
    }

    @Override // sg.bigo.ads.api.SplashAd
    public final boolean isSkippable() {
        return this.y || isExpired() || this.f14028i;
    }

    @Override // sg.bigo.ads.api.SplashAd
    public final void setAdInteractionListener(SplashAdInteractionListener splashAdInteractionListener) {
        super.setAdInteractionListener((AdInteractionListener) splashAdInteractionListener);
        this.f15397z.f15426b = splashAdInteractionListener;
    }

    @Override // sg.bigo.ads.api.SplashAd
    public final void show() {
        a((Activity) null, true);
    }

    @Override // sg.bigo.ads.api.SplashAd
    public final void showInAdContainer(@NonNull ViewGroup viewGroup) {
        this.f15396x.d(2);
        a(viewGroup);
    }

    public final void x() {
        m mVar;
        AdCountDownButton adCountDownButton = this.H;
        if (adCountDownButton == null) {
            this.y = true;
            this.f15397z.onAdFinished();
            return;
        }
        adCountDownButton.setVisibility(0);
        m mVar2 = this.A;
        a.a(this.H, mVar2 == null ? 1 : mVar2.a("video_play_page.close_button_style"));
        int iMax = Math.max(0, this.F.a("splash_duration"));
        h hVar = this.C;
        if (hVar != null && hVar.i().get() && f().bh() == null && (mVar = this.A) != null) {
            iMax = x.b(mVar.a("video_play_page.time_for_show_backup", -1));
        }
        this.I = new n(((long) iMax) * 1000) { // from class: sg.bigo.ads.ad.splash.b.5
            @Override // sg.bigo.ads.common.utils.n
            public final void a() {
                if (b.this.H.f14166c) {
                    if (b.this.C() || !b.this.A()) {
                        sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.splash.b.5.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                if (b.this.C != null) {
                                    b.this.C.j();
                                }
                            }
                        });
                    }
                    b.this.H.d();
                }
                b bVar = b.this;
                bVar.y = true;
                bVar.f15397z.onAdFinished();
            }

            @Override // sg.bigo.ads.common.utils.n
            public final void a(long j) {
                b.this.H.a(j);
            }
        };
        int iMax2 = Math.max(0, this.F.a("splash_close"));
        this.H.setWithUnit(true);
        this.H.setTakeoverTickEvent(true);
        this.H.setOnCloseListener(new AdCountDownButton.a() { // from class: sg.bigo.ads.ad.splash.b.6
            @Override // sg.bigo.ads.ad.interstitial.AdCountDownButton.a
            public final void a() {
                if (b.this.A == null) {
                    b.this.d(8);
                } else if (b.this.C()) {
                    b.this.a(b.this.Q() ? 1 == ((sg.bigo.ads.core.a.a) b.this.f15396x.f()).ad() ? 4 : 5 : 2, 2);
                } else {
                    b.this.d(8);
                }
            }

            @Override // sg.bigo.ads.ad.interstitial.AdCountDownButton.a
            public final void a(Rect rect) {
            }
        });
        h hVar2 = this.C;
        if (hVar2 != null && hVar2.i().get() && f().bh() == null) {
            AdCountDownButton adCountDownButton2 = this.H;
            adCountDownButton2.h.setVisibility(0);
            adCountDownButton2.g.setVisibility(0);
            adCountDownButton2.e();
        } else {
            this.H.a(iMax2, new AdCountDownButton.b() { // from class: sg.bigo.ads.ad.splash.b.7
                @Override // sg.bigo.ads.ad.interstitial.AdCountDownButton.b
                public final void a() {
                    b.this.y = true;
                    sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.splash.b.7.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (b.this.C != null) {
                                b.this.C.j();
                            }
                        }
                    });
                }
            });
        }
        this.I.c();
        final ViewTreeObserver viewTreeObserver = this.H.getViewTreeObserver();
        final ViewTreeObserver.OnWindowFocusChangeListener onWindowFocusChangeListener = new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: sg.bigo.ads.ad.splash.b.8
            @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
            public final void onWindowFocusChanged(boolean z2) {
                b bVar = b.this;
                if (bVar.f15396x.f14028i) {
                    return;
                }
                boolean zIsAttachedToWindow = bVar.H.isAttachedToWindow();
                if (z2 && zIsAttachedToWindow) {
                    b.a(b.this, true);
                    b.this.z();
                } else {
                    b.a(b.this, false);
                    b.this.y();
                }
            }
        };
        viewTreeObserver.addOnWindowFocusChangeListener(onWindowFocusChangeListener);
        this.J = new Runnable() { // from class: sg.bigo.ads.ad.splash.b.9
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    viewTreeObserver.removeOnWindowFocusChangeListener(onWindowFocusChangeListener);
                } catch (Throwable unused) {
                }
            }
        };
    }

    public final void y() {
        AdCountDownButton adCountDownButton = this.H;
        if (adCountDownButton != null && !adCountDownButton.f14166c) {
            adCountDownButton.b();
        }
        n nVar = this.I;
        if (nVar != null && !nVar.e()) {
            this.I.d();
            this.X = (SystemClock.elapsedRealtime() - this.Y) + this.X;
        }
        if (this.f15396x.getVideoController() == null || !this.f15396x.getVideoController().isPlaying()) {
            return;
        }
        this.f15396x.getVideoController().pause();
    }

    public final void z() {
        AdCountDownButton adCountDownButton = this.H;
        if (adCountDownButton != null && !adCountDownButton.f14166c) {
            adCountDownButton.c();
        }
        n nVar = this.I;
        if (nVar != null && nVar.e()) {
            this.I.c();
        }
        if (this.f15396x.getVideoController() != null && this.f15396x.getVideoController().isPaused()) {
            this.f15396x.getVideoController().play();
        }
        this.Y = SystemClock.elapsedRealtime();
    }

    @Override // sg.bigo.ads.api.SplashAd
    public final void show(Activity activity) {
        a(activity, false);
    }

    private void b(@NonNull final ViewGroup viewGroup) {
        ImageView imageView = new ImageView(viewGroup.getContext());
        imageView.setTag("adview_background_main_tag");
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        u.a(imageView, viewGroup, null, 0);
        m mVar = this.A;
        if (mVar != null && 5 != mVar.a("video_play_page.background_colour")) {
            a.a(this.A.a("video_play_page.background_colour"), this.f15396x, viewGroup);
            return;
        }
        w wVar = new w() { // from class: sg.bigo.ads.ad.splash.b.3
            @Override // sg.bigo.ads.ad.interstitial.w
            public final void a() {
                final Bitmap bitmap = sg.bigo.ads.ad.splash.a.b.j;
                if (b.this.f14028i || bitmap == null) {
                    return;
                }
                sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.splash.b.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        final ImageView imageView2;
                        View viewFindViewWithTag = viewGroup.findViewWithTag("adview_background_main_tag");
                        if (viewFindViewWithTag instanceof ImageView) {
                            imageView2 = (ImageView) viewFindViewWithTag;
                        } else {
                            Context context = viewGroup.getContext();
                            if (context != null) {
                                ImageView imageView3 = new ImageView(context);
                                imageView3.setTag("adview_background_main_tag");
                                imageView3.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                u.a(imageView3, viewGroup, null, 0);
                                imageView2 = imageView3;
                            } else {
                                imageView2 = null;
                            }
                        }
                        if (imageView2 != null) {
                            imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            sg.bigo.ads.common.utils.d.a(imageView2.getContext(), bitmap, new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.splash.b.3.1.1
                                @Override // android.webkit.ValueCallback
                                public final /* synthetic */ void onReceiveValue(Bitmap bitmap2) {
                                    Bitmap bitmap3 = bitmap2;
                                    if (bitmap3 != null) {
                                        imageView2.setImageBitmap(bitmap3);
                                    }
                                }
                            });
                        }
                    }
                });
            }
        };
        h hVar = this.C;
        if (hVar != null) {
            hVar.a(wVar);
        }
    }

    @Override // sg.bigo.ads.api.b.a
    public final void a(int i2) {
        super.a(i2);
        this.f15396x.a(i2);
    }

    public final void a(int i2, int i8) {
        sg.bigo.ads.ad.splash.a.g gVar;
        sg.bigo.ads.ad.splash.a.g gVar2;
        final ViewGroup viewGroup = this.G;
        h hVar = this.C;
        if (hVar == null || viewGroup == null) {
            return;
        }
        if (this.D != null && hVar.d() == c.a.f15330b) {
            this.C.a(false, viewGroup, -1);
        }
        if (Q() && (gVar2 = this.f15395w) != null && gVar2.e()) {
            sg.bigo.ads.ad.splash.a.g gVar3 = this.f15395w;
            if (!gVar3.f15354d) {
                gVar3.e = 2;
                gVar3.a(true, viewGroup, i8);
                N();
                return;
            }
        }
        sg.bigo.ads.ad.splash.a.a aVar = this.D;
        if (aVar == null || aVar.f15290c != c.a.f15331c || ((gVar = this.f15395w) != null && gVar.e == 2)) {
            d(i2);
            return;
        }
        aVar.a(true, viewGroup, i8);
        N();
        if (this.f15395w == null || !sg.bigo.ads.api.a.i.f15457a.p().a()) {
            M();
            return;
        }
        sg.bigo.ads.ad.splash.a.g gVar4 = this.f15395w;
        Runnable runnable = this.M;
        if (runnable == null) {
            runnable = new Runnable() { // from class: sg.bigo.ads.ad.splash.b.11
                @Override // java.lang.Runnable
                public final void run() {
                    b bVar = b.this;
                    if (bVar.f14028i) {
                        return;
                    }
                    sg.bigo.ads.common.n.d.a(bVar.L);
                    if (b.this.f15395w != null) {
                        b.this.f15395w.a(this);
                    }
                    sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.splash.b.11.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AnonymousClass11 anonymousClass11 = AnonymousClass11.this;
                            b.a(b.this, viewGroup);
                        }
                    });
                }
            };
            this.M = runnable;
        }
        sg.bigo.ads.ad.interstitial.a.b bVar = gVar4.f15352b;
        if (bVar != null) {
            bVar.f14268c = runnable;
        }
        int iB = sg.bigo.ads.api.a.i.f15457a.p().b();
        if (iB > 0) {
            Runnable runnable2 = this.L;
            if (runnable2 == null) {
                runnable2 = new Runnable() { // from class: sg.bigo.ads.ad.splash.b.12
                    @Override // java.lang.Runnable
                    public final void run() {
                        b bVar2 = b.this;
                        if (bVar2.f14028i) {
                            return;
                        }
                        bVar2.M();
                        b.a(b.this, viewGroup);
                    }
                };
                this.L = runnable2;
            }
            sg.bigo.ads.common.n.d.a(2, runnable2, ((long) iB) * 1000);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v5, types: [android.app.Activity] */
    private void a(Activity activity, boolean z2) {
        sg.bigo.ads.api.a.h hVar;
        if (F()) {
            this.C = new j(this.B, this.F, this.A, this);
        }
        a(activity == 0, z2);
        if (activity != 0) {
            this.f15396x.b(activity);
        }
        this.f15396x.d(1);
        this.f15396x.a(true);
        sg.bigo.ads.core.d.b.a(f());
        if (activity != 0) {
            a(1);
        }
        if (activity == 0 && (hVar = sg.bigo.ads.api.a.i.f15457a) != null && hVar.n().a(16)) {
            activity = sg.bigo.ads.common.f.b.b();
            a(2);
        }
        if (activity == 0) {
            activity = this.f14024b.e;
        }
        if (activity != 0) {
            int iA = this.S.a();
            this.T = iA;
            sg.bigo.ads.api.b.a aVar = this.U;
            if (aVar != null) {
                aVar.c(iA);
            }
            AdSplashActivity.a(activity, this);
        }
    }

    public final void a(@NonNull ViewGroup viewGroup) {
        sg.bigo.ads.ad.splash.a.g gVar;
        String str;
        if (this.C != null) {
            g gVar2 = this.B;
            if (gVar2 != null) {
                sg.bigo.ads.core.d.b.a(gVar2.f15496a, this);
            }
            if (isExpired()) {
                str = "The ad is expired.";
            } else {
                if (!this.f14028i) {
                    ViewGroup viewGroup2 = (ViewGroup) sg.bigo.ads.common.utils.a.a(viewGroup.getContext(), R.layout.bigo_ad_splash_style_root, null, false);
                    u.a(viewGroup2, viewGroup, new ViewGroup.LayoutParams(-1, -1), -1);
                    ViewGroup viewGroup3 = (ViewGroup) viewGroup2.findViewById(R.id.bigo_ad_splash_ad_container);
                    this.G = viewGroup3;
                    this.H = (AdCountDownButton) viewGroup2.findViewById(R.id.bigo_ad_splash_btn_skip);
                    b(viewGroup3);
                    if (P() && (gVar = this.f15395w) != null && gVar.e()) {
                        sg.bigo.ads.ad.splash.a.g gVar3 = this.f15395w;
                        gVar3.e = 1;
                        gVar3.a(true, viewGroup3, 11);
                    } else {
                        this.C.a(true, viewGroup3, -1);
                    }
                    G();
                    return;
                }
                str = "The ad is destroyed.";
            }
            b(2000, 1, str);
        }
    }

    public static /* synthetic */ void a(b bVar, ViewGroup viewGroup) {
        sg.bigo.ads.ad.splash.a.g gVar;
        View viewFindViewById;
        sg.bigo.ads.ad.splash.a.a aVar = bVar.D;
        if (aVar != null && (viewFindViewById = aVar.f15289b.findViewById(R.id.layout_playable_loading)) != null && viewFindViewById.getVisibility() == 0) {
            viewFindViewById.setVisibility(4);
        }
        if (!bVar.Q() || (gVar = bVar.f15395w) == null || !gVar.e() || bVar.f15395w.f15354d) {
            return;
        }
        sg.bigo.ads.ad.splash.a.a aVar2 = bVar.D;
        if (aVar2 != null) {
            aVar2.a(false, viewGroup, -1);
        }
        sg.bigo.ads.ad.splash.a.g gVar2 = bVar.f15395w;
        gVar2.e = 2;
        gVar2.a(true, viewGroup, 14);
    }

    public static /* synthetic */ void a(b bVar, boolean z2) {
        h hVar = bVar.C;
        if (hVar != null) {
            hVar.a(z2);
        }
        sg.bigo.ads.ad.splash.a.a aVar = bVar.D;
        if (aVar != null) {
            aVar.a(z2);
        }
        sg.bigo.ads.ad.splash.a.g gVar = bVar.f15395w;
        if (gVar != null) {
            gVar.a(z2);
        }
        if (!z2) {
            n nVar = bVar.N;
            if (nVar != null) {
                nVar.d();
                return;
            }
            return;
        }
        n nVar2 = bVar.N;
        if (nVar2 == null || !nVar2.e()) {
            return;
        }
        bVar.N.c();
    }

    @Override // sg.bigo.ads.ad.c, sg.bigo.ads.api.b.d
    public final void a(@NonNull final d.a<SplashAd> aVar) {
        super.a(aVar);
        m mVar = this.A;
        if (mVar != null && mVar.a("video_play_page.background_colour") == 4) {
            this.f15396x.b(true);
        }
        this.f15396x.a(new d.a<NativeAd>() { // from class: sg.bigo.ads.ad.splash.b.4
            @Override // sg.bigo.ads.api.b.d.a
            public final /* synthetic */ void a(Ad ad) {
                b bVar = b.this;
                if (bVar.e || bVar.f14027f) {
                    return;
                }
                aVar.a(bVar);
                sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.ad.splash.b.4.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if ((b.this.P() || b.this.Q()) && b.this.f15395w == null) {
                            b bVar2 = b.this;
                            m unused = bVar2.F;
                            m unused2 = b.this.A;
                            b bVar3 = b.this;
                            bVar2.f15395w = new sg.bigo.ads.ad.splash.a.g(bVar3, bVar3.B.f15497b, b.this.B.f15496a);
                        }
                    }
                });
            }

            @Override // sg.bigo.ads.api.b.d.a
            public final /* synthetic */ void a(Ad ad, int i2, int i8, String str) {
                b bVar = b.this;
                if (bVar.e || bVar.f14027f) {
                    return;
                }
                if (i2 == 1006) {
                    sg.bigo.ads.controller.c.a.a(bVar.B == null ? "" : b.this.B.f15497b.l());
                }
                aVar.a(b.this, i2, i8, str);
            }

            @Override // sg.bigo.ads.api.b.d.a
            public final /* synthetic */ void a(Ad ad, boolean z2, int i2, int i8, String str, boolean z7) {
                NativeAd nativeAd = (NativeAd) ad;
                b bVar = b.this;
                if (bVar.e || bVar.f14027f || !(nativeAd instanceof sg.bigo.ads.ad.b.d)) {
                    return;
                }
                if (((sg.bigo.ads.core.a.a) ((sg.bigo.ads.ad.b.d) nativeAd).f()).bh() != null || z2) {
                    aVar.a(b.this);
                } else {
                    aVar.a(b.this, i2, i8, str);
                }
            }
        });
    }

    @Override // sg.bigo.ads.api.b.a
    public final void a(boolean z2, boolean z7) {
        super.a(z2, z7);
        this.f15396x.a(z2, z7);
    }
}
