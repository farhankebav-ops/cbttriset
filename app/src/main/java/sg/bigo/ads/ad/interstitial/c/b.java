package sg.bigo.ads.ad.interstitial.c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.multi_img.view.d;
import sg.bigo.ads.ad.interstitial.u;
import sg.bigo.ads.common.view.Indicator;
import sg.bigo.ads.common.view.ViewFlow;

/* JADX INFO: loaded from: classes6.dex */
public abstract class b extends a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected final sg.bigo.ads.ad.interstitial.d f14329o;
    protected final sg.bigo.ads.ad.interstitial.multi_img.b p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected ViewFlow f14330q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected Indicator f14331r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected LinearLayout f14332s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected sg.bigo.ads.ad.interstitial.multi_img.view.c f14333t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected sg.bigo.ads.ad.interstitial.multi_img.view.c f14334u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected sg.bigo.ads.ad.interstitial.multi_img.a f14335v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final ValueCallback<Double> f14336w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final AtomicBoolean f14337x;
    private final List<Runnable> y;

    /* JADX INFO: renamed from: sg.bigo.ads.ad.interstitial.c.b$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f14349a;

        static {
            int[] iArr = new int[sg.bigo.ads.ad.interstitial.multi_img.d.values().length];
            f14349a = iArr;
            try {
                iArr[sg.bigo.ads.ad.interstitial.multi_img.d.LTR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14349a[sg.bigo.ads.ad.interstitial.multi_img.d.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14349a[sg.bigo.ads.ad.interstitial.multi_img.d.FULL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14349a[sg.bigo.ads.ad.interstitial.multi_img.d.TILE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public b(@NonNull sg.bigo.ads.ad.b.c cVar, int i2, @NonNull sg.bigo.ads.api.a.m mVar, @NonNull sg.bigo.ads.ad.interstitial.multi_img.b bVar, @Nullable sg.bigo.ads.ad.interstitial.e.c cVar2) {
        super(cVar, i2, mVar, cVar2);
        this.f14336w = new ValueCallback<Double>() { // from class: sg.bigo.ads.ad.interstitial.c.b.1
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(Double d8) {
                Double d9 = d8;
                if (d9 != null) {
                    b.this.b(d9.doubleValue());
                }
            }
        };
        this.f14337x = new AtomicBoolean(false);
        this.y = new ArrayList();
        this.p = bVar;
        this.f14329o = new sg.bigo.ads.ad.interstitial.d();
    }

    public final boolean l() {
        sg.bigo.ads.ad.interstitial.multi_img.b bVar = this.p;
        return bVar == null || bVar.f14844b == sg.bigo.ads.ad.interstitial.multi_img.d.NONE;
    }

    public final void m() {
        this.f14337x.set(true);
    }

    public final void n() {
        this.f14337x.set(false);
        if (sg.bigo.ads.ad.interstitial.multi_img.f.a(this.f14330q)) {
            sg.bigo.ads.ad.interstitial.multi_img.f.a(this.f14330q, new ValueCallback<Integer>() { // from class: sg.bigo.ads.ad.interstitial.c.b.9
                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(Integer num) {
                    Iterator it = b.this.y.iterator();
                    while (it.hasNext()) {
                        b.this.f14330q.post((Runnable) it.next());
                    }
                    b.this.y.clear();
                    sg.bigo.ads.ad.interstitial.multi_img.f.a(b.this.f14330q, (ValueCallback<Integer>) null);
                }
            });
            return;
        }
        Iterator<Runnable> it = this.y.iterator();
        while (it.hasNext()) {
            this.f14330q.post(it.next());
        }
        this.y.clear();
    }

    private sg.bigo.ads.ad.interstitial.multi_img.view.a a(final sg.bigo.ads.ad.interstitial.r rVar, sg.bigo.ads.ad.interstitial.multi_img.c cVar, int i2, String str, boolean z2) {
        final sg.bigo.ads.ad.interstitial.multi_img.view.a aVar = new sg.bigo.ads.ad.interstitial.multi_img.view.a(this.j.getContext(), this.p, cVar, e(), i2, str, z2, new ValueCallback<sg.bigo.ads.ad.interstitial.multi_img.view.a>() { // from class: sg.bigo.ads.ad.interstitial.c.b.12
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(sg.bigo.ads.ad.interstitial.multi_img.view.a aVar2) {
                final sg.bigo.ads.ad.interstitial.multi_img.view.a aVar3 = aVar2;
                sg.bigo.ads.ad.interstitial.v.a(rVar, new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.interstitial.c.b.12.1
                    @Override // android.webkit.ValueCallback
                    public final /* synthetic */ void onReceiveValue(Bitmap bitmap) {
                        Bitmap bitmap2 = bitmap;
                        if (bitmap2 != null) {
                            aVar3.a(bitmap2);
                        }
                    }
                });
            }
        });
        ViewFlow.b bVar = new ViewFlow.b();
        bVar.f16158a = -1;
        bVar.f16159b = -1;
        bVar.f16160c = false;
        bVar.f16161d = cVar.f14860d;
        this.f14330q.addView(aVar.j, bVar);
        if (this.f14335v != null) {
            aVar.f14908r = new d.a() { // from class: sg.bigo.ads.ad.interstitial.c.b.2
                @Override // sg.bigo.ads.ad.interstitial.multi_img.view.d.a
                public final void a() {
                    b.this.f14335v.a(b.this.f14330q.a(aVar.j));
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

    public void b(double d8) {
        if (d8 <= 3.0d) {
            sg.bigo.ads.ad.interstitial.multi_img.view.c cVar = this.f14333t;
            if (cVar != null) {
                cVar.a(false);
            }
            sg.bigo.ads.ad.interstitial.multi_img.view.c cVar2 = this.f14334u;
            if (cVar2 != null) {
                cVar2.a(false);
                return;
            }
            return;
        }
        sg.bigo.ads.ad.interstitial.multi_img.view.c cVar3 = this.f14333t;
        if (cVar3 != null) {
            cVar3.a(true);
        }
        sg.bigo.ads.ad.interstitial.multi_img.view.c cVar4 = this.f14334u;
        if (cVar4 != null) {
            cVar4.a(true);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.c.a
    public final void d(sg.bigo.ads.ad.interstitial.r rVar) {
        b bVar = this;
        Context context = bVar.j.getContext();
        sg.bigo.ads.ad.interstitial.multi_img.b bVar2 = bVar.p;
        List<String> listA = bVar2 != null ? bVar2.a() : null;
        sg.bigo.ads.ad.interstitial.multi_img.b bVar3 = bVar.p;
        boolean z2 = bVar3 != null && bVar3.e;
        sg.bigo.ads.ad.interstitial.multi_img.d dVar = bVar3 != null ? bVar3.f14844b : sg.bigo.ads.ad.interstitial.multi_img.d.NONE;
        sg.bigo.ads.ad.interstitial.multi_img.c cVar = bVar3 != null ? bVar3.f14846d : sg.bigo.ads.ad.interstitial.multi_img.c.FILL_MATCH_SELF;
        sg.bigo.ads.common.p pVarA = sg.bigo.ads.ad.interstitial.s.a(bVar.f15176f);
        bVar.f14330q = (ViewFlow) bVar.k.findViewById(R.id.inter_media_ad_view_flow);
        bVar.f14331r = (Indicator) bVar.k.findViewById(R.id.inter_vf_indicator);
        int iK = bVar.k();
        if (iK == 2) {
            bVar.k.setBackgroundColor(bVar.f14329o.a(ViewCompat.MEASURED_STATE_MASK));
        } else if (iK == 3 || iK == 4) {
            bVar.k.setBackgroundColor(bVar.f14329o.a(ViewCompat.MEASURED_STATE_MASK));
            bVar.f14335v = new sg.bigo.ads.ad.interstitial.multi_img.a(bVar.k, bVar.f14330q, bVar.f14329o, iK);
        } else {
            bVar.k.setBackgroundColor(bVar.f14329o.a(-1));
        }
        bVar.f14332s = (LinearLayout) bVar.k.findViewById(R.id.inter_media_bottom_layout);
        if (sg.bigo.ads.common.utils.q.a((CharSequence) bVar.f15176f.getWarning())) {
            ((ViewGroup.MarginLayoutParams) bVar.f14332s.getLayoutParams()).topMargin = sg.bigo.ads.common.utils.e.a(context, 8);
        }
        g(rVar);
        bVar.f14329o.a(bVar.f14336w);
        if (bVar.p != null) {
            Context context2 = bVar.j.getContext();
            bVar.f14330q.setDividerWidth(sg.bigo.ads.common.utils.e.a(context2, dVar.f14865f));
            bVar.f14330q.setContentMaxWidthSpace(sg.bigo.ads.common.utils.e.a(context2, dVar.f14866i));
            bVar.f14330q.setViewStyle(dVar.j);
            bVar.f14330q.setOnItemChangeListener(new sg.bigo.ads.ad.interstitial.multi_img.f(dVar, bVar.f14331r, bVar.f14335v));
            int i2 = 0;
            int i8 = 0;
            while (listA != null && i8 < listA.size()) {
                String str = listA.get(i8);
                if (!TextUtils.isEmpty(str) && URLUtil.isNetworkUrl(str)) {
                    bVar.a(rVar, cVar, iK, str, ((sg.bigo.ads.core.a.a) bVar.f15176f.f()).al());
                    i2++;
                }
                i8++;
                bVar = this;
            }
            int iMax = Math.max(dVar == sg.bigo.ads.ad.interstitial.multi_img.d.CENTER ? 3 - i2 : 0, 0);
            if (z2) {
                iMax = Math.max(iMax, 1);
            }
            int i9 = iMax;
            for (int i10 = 0; i10 < i9; i10++) {
                final sg.bigo.ads.ad.interstitial.multi_img.view.a aVarA = a(rVar, cVar, iK, (String) null, false);
                sg.bigo.ads.ad.interstitial.v.a(rVar, new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.interstitial.c.b.6
                    @Override // android.webkit.ValueCallback
                    public final /* synthetic */ void onReceiveValue(Bitmap bitmap) {
                        aVarA.a(bitmap);
                    }
                });
            }
            bVar = this;
            bVar.f14330q.setMainChildSize(pVarA);
            int i11 = AnonymousClass4.f14349a[dVar.ordinal()];
            if (i11 == 1 || i11 == 2 || i11 == 3 || i11 == 4) {
                ViewFlow.d dVar2 = new ViewFlow.d() { // from class: sg.bigo.ads.ad.interstitial.c.b.11
                    @Override // sg.bigo.ads.common.view.ViewFlow.d
                    public final void a() {
                        b.this.f15176f.a(4, 29);
                    }
                };
                sg.bigo.ads.ad.interstitial.multi_img.view.c cVar2 = new sg.bigo.ads.ad.interstitial.multi_img.view.c(context2, true);
                bVar.f14333t = cVar2;
                bVar.f14330q.setStartView(cVar2.f14895a);
                bVar.f14330q.setOnStartViewShowListener(dVar2);
                sg.bigo.ads.ad.interstitial.multi_img.view.c cVar3 = new sg.bigo.ads.ad.interstitial.multi_img.view.c(context2, false);
                bVar.f14334u = cVar3;
                bVar.f14330q.setEndView(cVar3.f14895a);
                bVar.f14330q.setOnEndViewShowListener(dVar2);
            }
            int itemCount = dVar == sg.bigo.ads.ad.interstitial.multi_img.d.CENTER ? bVar.f14330q.getItemCount() >> 1 : 0;
            bVar.f14330q.b(itemCount);
            sg.bigo.ads.ad.interstitial.multi_img.a aVar = bVar.f14335v;
            if (aVar != null) {
                aVar.b(itemCount);
            }
        }
        if (bVar.l()) {
            return;
        }
        sg.bigo.ads.ad.interstitial.multi_img.b bVar4 = bVar.p;
        int iA = bVar4 != null ? bVar4.f14843a.a("endpage.multi_guide") : 0;
        switch (iA) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                bVar.a(iA, new Runnable() { // from class: sg.bigo.ads.ad.interstitial.c.b.10
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.this.f14330q.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.c.b.10.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                b bVar5 = b.this;
                                if (bVar5.f14330q.g) {
                                    return;
                                }
                                b.a(bVar5, 3L, 0L, 300L);
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
                bVar.f14330q.setFlipInterval((iA - 5) * 1000);
                bVar.f14330q.c();
                break;
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.c.a
    public final void a(double d8) {
    }

    @Override // sg.bigo.ads.ad.interstitial.v
    public final boolean d() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0060  */
    @Override // sg.bigo.ads.ad.interstitial.c.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r8, boolean r9, boolean r10) {
        /*
            r7 = this;
            sg.bigo.ads.common.view.ViewFlow r0 = r7.f14330q
            java.util.List r0 = r0.getItems()
            android.view.ViewGroup r1 = r7.k
            r2 = 9
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            sg.bigo.ads.ad.b.a.a(r1, r2)
            sg.bigo.ads.common.view.ViewFlow r1 = r7.f14330q
            sg.bigo.ads.ad.b.a.a(r1, r2)
            r1 = 0
            r2 = 4
            if (r10 == 0) goto L2d
            android.view.ViewGroup r10 = r7.j
            android.view.ViewGroup r3 = r7.k
            sg.bigo.ads.ad.b.c r4 = r7.f15176f
            sg.bigo.ads.ad.b.a.a(r10, r3, r2, r4, r8)
            android.view.ViewGroup r10 = r7.j
            sg.bigo.ads.common.view.ViewFlow r3 = r7.f14330q
            sg.bigo.ads.ad.b.c r4 = r7.f15176f
            sg.bigo.ads.ad.b.a.a(r10, r3, r2, r4, r8)
            goto L3d
        L2d:
            android.view.ViewGroup r10 = r7.j
            android.view.ViewGroup r3 = r7.k
            sg.bigo.ads.core.adview.h r4 = sg.bigo.ads.ad.interstitial.r.F
            sg.bigo.ads.ad.b.a.a(r10, r3, r2, r4, r1)
            android.view.ViewGroup r10 = r7.j
            sg.bigo.ads.common.view.ViewFlow r3 = r7.f14330q
            sg.bigo.ads.ad.b.a.a(r10, r3, r2, r4, r1)
        L3d:
            boolean r10 = r7.l()
            if (r10 != 0) goto L62
            sg.bigo.ads.ad.interstitial.multi_img.b r10 = r7.p
            r3 = 1
            if (r10 == 0) goto L51
            sg.bigo.ads.api.a.m r10 = r10.f14843a
            java.lang.String r4 = "endpage.multi_click_type"
            int r10 = r10.a(r4)
            goto L52
        L51:
            r10 = r3
        L52:
            r4 = 2
            r5 = 3
            if (r10 == r4) goto L60
            if (r10 == r5) goto L59
            goto L62
        L59:
            if (r8 == r3) goto L5e
            if (r8 == r4) goto L5e
            goto L60
        L5e:
            r8 = r5
            goto L63
        L60:
            r3 = r1
            goto L5e
        L62:
            r3 = r1
        L63:
            java.util.Iterator r10 = r0.iterator()
        L67:
            boolean r0 = r10.hasNext()
            if (r0 == 0) goto La6
            java.lang.Object r0 = r10.next()
            android.view.View r0 = (android.view.View) r0
            int r4 = sg.bigo.ads.ad.interstitial.multi_img.view.d.e
            java.lang.Object r0 = r0.getTag(r4)
            boolean r4 = r0 instanceof sg.bigo.ads.ad.interstitial.multi_img.view.d
            if (r4 == 0) goto L67
            sg.bigo.ads.ad.interstitial.multi_img.view.d r0 = (sg.bigo.ads.ad.interstitial.multi_img.view.d) r0
            sg.bigo.ads.common.view.RoundedFrameLayout r4 = r0.j
            r5 = 5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            sg.bigo.ads.ad.b.a.a(r4, r5)
            android.view.ViewGroup r4 = r7.j
            sg.bigo.ads.common.view.RoundedFrameLayout r0 = r0.j
            if (r9 == 0) goto La0
            sg.bigo.ads.ad.b.c r5 = r7.f15176f
            if (r3 == 0) goto L9c
            sg.bigo.ads.ad.interstitial.c.b$3 r6 = new sg.bigo.ads.ad.interstitial.c.b$3
            r6.<init>()
            sg.bigo.ads.ad.b.a.a(r4, r0, r2, r5, r6)
            goto L67
        L9c:
            sg.bigo.ads.ad.b.a.a(r4, r0, r2, r5, r8)
            goto L67
        La0:
            sg.bigo.ads.core.adview.h r5 = sg.bigo.ads.ad.interstitial.r.F
            sg.bigo.ads.ad.b.a.a(r4, r0, r2, r5, r1)
            goto L67
        La6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.ad.interstitial.c.b.a(int, boolean, boolean):void");
    }

    public static /* synthetic */ void a(b bVar, final long j, long j3, final long j8) {
        if (j > 0) {
            ViewFlow viewFlow = bVar.f14330q;
            if (!viewFlow.g && !viewFlow.e()) {
                bVar.f14330q.setScrollEnabled(false);
                int iA = sg.bigo.ads.common.utils.e.a(bVar.j.getContext(), 40);
                final int scrollX = bVar.f14330q.getScrollX();
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, iA, 0);
                valueAnimatorOfInt.setDuration(2 * j8);
                valueAnimatorOfInt.setStartDelay(j3);
                valueAnimatorOfInt.setInterpolator(new LinearInterpolator());
                final AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter() { // from class: sg.bigo.ads.ad.interstitial.c.b.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        b.a(b.this, j - 1, 300L, j8);
                    }
                };
                valueAnimatorOfInt.addListener(animatorListenerAdapter);
                valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: sg.bigo.ads.ad.interstitial.c.b.8
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (atomicBoolean.get()) {
                            return;
                        }
                        if (b.this.f14337x.get()) {
                            atomicBoolean.set(true);
                            valueAnimator.removeListener(animatorListenerAdapter);
                            valueAnimator.cancel();
                            b.this.y.add(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.c.b.8.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    AnonymousClass8 anonymousClass8 = AnonymousClass8.this;
                                    b.a(b.this, j, 300L, j8);
                                }
                            });
                            return;
                        }
                        Object animatedValue = valueAnimator.getAnimatedValue();
                        if (animatedValue instanceof Integer) {
                            b.this.f14330q.scrollTo(((Integer) animatedValue).intValue() + scrollX, b.this.f14330q.getScrollY());
                        }
                    }
                });
                valueAnimatorOfInt.start();
                return;
            }
        }
        bVar.f14330q.setScrollEnabled(true);
    }

    @Override // sg.bigo.ads.ad.interstitial.v
    public final void a(@NonNull sg.bigo.ads.ad.interstitial.r rVar, View view) {
    }

    @Override // sg.bigo.ads.ad.interstitial.v
    public final boolean a(@NonNull sg.bigo.ads.ad.interstitial.r rVar, @NonNull ViewGroup viewGroup, @NonNull View view, final u.a aVar, int i2, int i8, int i9, @Nullable View... viewArr) {
        return super.a(rVar, viewGroup, view, new u.a() { // from class: sg.bigo.ads.ad.interstitial.c.b.5
            @Override // sg.bigo.ads.ad.interstitial.u.a
            public final Pair<String, String> a(@NonNull TextView textView, @Nullable String str, @Nullable String str2) {
                if (textView.getTag() == 2 && sg.bigo.ads.common.utils.q.a((CharSequence) str2)) {
                    str2 = b.this.f15176f.getDescription();
                }
                u.a aVar2 = aVar;
                return aVar2 != null ? aVar2.a(textView, str, str2) : Pair.create(str, str2);
            }
        }, i2, i8, i9, viewArr);
    }

    public void g(sg.bigo.ads.ad.interstitial.r rVar) {
    }
}
