package sg.bigo.ads.ad.interstitial.multi_img.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import sg.bigo.ads.ad.interstitial.v;
import sg.bigo.ads.common.utils.e;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.common.view.AdImageView;
import sg.bigo.ads.common.view.FixContentFrameLayout;
import sg.bigo.ads.common.view.RoundedFrameLayout;
import sg.bigo.ads.common.w.b;

/* JADX INFO: loaded from: classes6.dex */
public abstract class d<T extends View> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f14899b = 300;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f14900c = 500;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f14901d = v.e;
    public static int e = -188383023;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f14902a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final Context f14903f;
    protected sg.bigo.ads.ad.interstitial.multi_img.c g;
    protected int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected final int f14904i;

    @NonNull
    public final RoundedFrameLayout j;
    public final FixContentFrameLayout k;

    @NonNull
    public final T l;
    public final AdImageView m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f14905n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f14906o;
    public Bitmap p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f14907q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public a f14908r;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ValueAnimator f14910t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private ValueAnimator f14911u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f14912v = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f14909s = false;

    public interface a {
        void a();

        void b();
    }

    public d(Context context, sg.bigo.ads.ad.interstitial.multi_img.c cVar, boolean z2, int i2, int i8, @LayoutRes int i9, @IdRes int i10, @IdRes int i11, @IdRes int i12) {
        this.f14903f = context;
        this.f14902a = z2;
        this.f14904i = i8;
        RoundedFrameLayout roundedFrameLayout = (RoundedFrameLayout) sg.bigo.ads.common.utils.a.a(context, i9, null, false);
        this.j = roundedFrameLayout;
        this.k = (FixContentFrameLayout) roundedFrameLayout.findViewById(i10);
        this.l = (T) roundedFrameLayout.findViewById(i11);
        this.m = (AdImageView) roundedFrameLayout.findViewById(i12);
        a(cVar);
        a(i2);
        this.f14907q = f14901d;
        u.a(roundedFrameLayout, new ViewTreeObserver.OnGlobalLayoutListener() { // from class: sg.bigo.ads.ad.interstitial.multi_img.view.d.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                d.this.f14912v = SystemClock.elapsedRealtime();
            }
        });
        roundedFrameLayout.setTag(e, this);
    }

    public final boolean c(int i2) {
        return this.f14909s ? i2 == 5 : i2 == 4;
    }

    public final boolean d(int i2) {
        return this.f14909s ? i2 == 4 : i2 == 3;
    }

    public final void b(final int i2) {
        if (a()) {
            this.m.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.multi_img.view.d.5
                @Override // java.lang.Runnable
                public final void run() {
                    d.this.m.setBackgroundColor(i2);
                }
            });
        }
    }

    public final void a(int i2) {
        int i8;
        if (i2 != Integer.MIN_VALUE) {
            if (i2 != 4) {
                if (i2 == 1) {
                    i8 = -1;
                } else if (i2 != 2) {
                    i2 = 3;
                } else {
                    i8 = ViewCompat.MEASURED_STATE_MASK;
                }
            }
            this.h = i2;
        }
        i8 = 0;
        b(i8);
        this.h = i2;
    }

    public final void b(Bitmap bitmap) {
        a aVar;
        boolean z2 = true;
        boolean z7 = false;
        boolean z8 = ((this.f14912v > 0L ? 1 : (this.f14912v == 0L ? 0 : -1)) != 0 ? SystemClock.elapsedRealtime() - this.f14912v : 0L) > f14899b;
        if (c(this.f14904i) || c(this.h)) {
            this.p = sg.bigo.ads.common.utils.d.b(this.f14903f, bitmap);
            if (c(this.f14904i)) {
                this.f14906o = sg.bigo.ads.common.w.b.a(this.p, ViewCompat.MEASURED_STATE_MASK);
            } else {
                this.f14906o = ViewCompat.MEASURED_STATE_MASK;
            }
            final b.a aVar2 = new b.a() { // from class: sg.bigo.ads.ad.interstitial.multi_img.view.d.2
                @Override // sg.bigo.ads.common.w.b.a
                public final long a() {
                    return d.f14900c;
                }

                @Override // sg.bigo.ads.common.w.b.a
                public final void b(int i2) {
                    if (d.this.f14908r != null) {
                        d.this.f14908r.b();
                    }
                }

                @Override // sg.bigo.ads.common.w.b.a
                public final boolean a(int i2) {
                    d.this.f14907q = i2;
                    d dVar = d.this;
                    if (dVar.c(dVar.h)) {
                        d dVar2 = d.this;
                        d.a(dVar2, dVar2.p, d.this.f14907q);
                    }
                    if (d.this.f14908r != null) {
                        d.this.f14908r.a();
                    }
                    return super.a(i2);
                }
            };
            if (z8) {
                ValueAnimator valueAnimator = this.f14911u;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, f14901d);
                this.f14911u = valueAnimatorOfInt;
                valueAnimatorOfInt.setInterpolator(new LinearInterpolator());
                this.f14911u.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: sg.bigo.ads.ad.interstitial.multi_img.view.d.6
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        Object animatedValue = valueAnimator2.getAnimatedValue();
                        if (animatedValue instanceof Integer) {
                            int iIntValue = ((Integer) animatedValue).intValue();
                            b.a aVar3 = aVar2;
                            if (aVar3 != null) {
                                aVar3.a(iIntValue);
                            }
                        }
                    }
                });
                this.f14911u.addListener(new AnimatorListenerAdapter() { // from class: sg.bigo.ads.ad.interstitial.multi_img.view.d.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        b.a aVar3 = aVar2;
                        if (aVar3 != null) {
                            aVar3.b(d.f14901d);
                        }
                    }
                });
                if (aVar2.a() >= 0) {
                    this.f14911u.setDuration(aVar2.a());
                }
                this.f14911u.start();
            } else {
                aVar2.a(f14901d);
                aVar2.b(f14901d);
            }
            z7 = true;
        }
        if (d(this.f14904i) || d(this.h)) {
            int iA = sg.bigo.ads.common.w.b.a(bitmap, ViewCompat.MEASURED_STATE_MASK);
            final b.a aVar3 = new b.a() { // from class: sg.bigo.ads.ad.interstitial.multi_img.view.d.3
                @Override // sg.bigo.ads.common.w.b.a
                public final long a() {
                    return d.f14900c;
                }

                @Override // sg.bigo.ads.common.w.b.a
                public final void b(int i2) {
                    if (d.this.f14908r != null) {
                        d.this.f14908r.b();
                    }
                }

                @Override // sg.bigo.ads.common.w.b.a
                public final boolean a(int i2) {
                    d.this.f14905n = i2;
                    d dVar = d.this;
                    if (dVar.d(dVar.h)) {
                        d dVar2 = d.this;
                        dVar2.b(dVar2.f14905n);
                    }
                    if (d.this.f14908r != null) {
                        d.this.f14908r.a();
                    }
                    return super.a(i2);
                }
            };
            if (z8) {
                ValueAnimator valueAnimator2 = this.f14910t;
                if (valueAnimator2 != null) {
                    valueAnimator2.cancel();
                }
                this.f14910t = sg.bigo.ads.common.w.b.a(this.m, iA, new b.a() { // from class: sg.bigo.ads.ad.interstitial.multi_img.view.d.8
                    @Override // sg.bigo.ads.common.w.b.a
                    public final long a() {
                        b.a aVar4 = aVar3;
                        if (aVar4 != null) {
                            return aVar4.a();
                        }
                        return -1L;
                    }

                    @Override // sg.bigo.ads.common.w.b.a
                    public final void b(int i2) {
                        b.a aVar4 = aVar3;
                        if (aVar4 != null) {
                            aVar4.b(i2);
                        }
                    }

                    @Override // sg.bigo.ads.common.w.b.a
                    public final boolean a(int i2) {
                        b.a aVar4 = aVar3;
                        if (aVar4 == null) {
                            return true;
                        }
                        aVar4.a(i2);
                        return true;
                    }
                });
            } else {
                aVar3.a(iA);
                aVar3.b(iA);
            }
        } else {
            z2 = z7;
        }
        if (z2 || (aVar = this.f14908r) == null) {
            return;
        }
        aVar.b();
    }

    public final void a(int i2, int i8) {
        if (i2 <= 0 || i8 <= 0) {
            return;
        }
        FixContentFrameLayout.a aVar = (FixContentFrameLayout.a) this.l.getLayoutParams();
        if (aVar.f16070a == i2 || aVar.f16071b == i8) {
            return;
        }
        aVar.f16070a = i2;
        aVar.f16071b = i8;
        this.l.setLayoutParams(aVar);
    }

    public final void a(sg.bigo.ads.ad.interstitial.multi_img.c cVar) {
        FixContentFrameLayout fixContentFrameLayout;
        boolean z2;
        this.g = cVar;
        if (a()) {
            int iA = e.a(this.f14903f, 12);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams.gravity = 17;
            layoutParams.topMargin = iA;
            layoutParams.leftMargin = iA;
            layoutParams.rightMargin = iA;
            layoutParams.bottomMargin = iA;
            layoutParams.height = -2;
            layoutParams.width = -2;
            this.k.setLayoutParams(layoutParams);
            fixContentFrameLayout = this.k;
            z2 = true;
        } else {
            fixContentFrameLayout = this.k;
            z2 = false;
        }
        fixContentFrameLayout.setFixContent(z2);
    }

    public static /* synthetic */ void a(d dVar, final Bitmap bitmap, final int i2) {
        if (dVar.a()) {
            dVar.m.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.multi_img.view.d.4
                @Override // java.lang.Runnable
                public final void run() {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(d.this.m.getResources(), bitmap);
                    bitmapDrawable.setAlpha(i2);
                    d.this.m.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    d.this.m.setImageDrawable(bitmapDrawable);
                }
            });
        }
    }

    public boolean a() {
        return this.f14902a;
    }
}
