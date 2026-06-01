package sg.bigo.ads.ad.interstitial.d;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.d.a;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.common.utils.b;
import sg.bigo.ads.common.view.RealtimeBlurLinearLayout;
import sg.bigo.ads.common.view.RoundedFrameLayout;
import sg.bigo.ads.common.view.RoundedImageView;
import sg.bigo.ads.common.w.b;

/* JADX INFO: loaded from: classes6.dex */
public class b extends sg.bigo.ads.ad.interstitial.d.a implements sg.bigo.ads.ad.interstitial.f.c {

    @Nullable
    protected ViewGroup A;

    @Nullable
    protected Button B;

    @Nullable
    protected RoundedFrameLayout C;

    @Nullable
    protected MediaView D;

    @Nullable
    protected TextView E;

    @Nullable
    protected TextView F;

    @Nullable
    protected Button G;

    @Nullable
    protected Button H;

    @Nullable
    protected RoundedImageView I;
    protected int J;
    protected int K;
    protected boolean L;
    private int M;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected RelativeLayout f14481x;

    @Nullable
    protected RealtimeBlurLinearLayout y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    protected ViewGroup f14482z;

    /* JADX INFO: renamed from: sg.bigo.ads.ad.interstitial.d.b$6, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f14492a;

        static {
            int[] iArr = new int[sg.bigo.ads.ad.interstitial.b.values().length];
            f14492a = iArr;
            try {
                iArr[sg.bigo.ads.ad.interstitial.b.f14273a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14492a[sg.bigo.ads.ad.interstitial.b.f14275c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14492a[sg.bigo.ads.ad.interstitial.b.f14274b.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14492a[sg.bigo.ads.ad.interstitial.b.e.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14492a[sg.bigo.ads.ad.interstitial.b.f14276d.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @RequiresApi(api = 19)
    public class a extends b.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private RectF f14494b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private RectF f14495c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private RectF f14496d;
        private float e = Float.NaN;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private RectF f14497f;

        public a() {
        }

        @Override // sg.bigo.ads.common.utils.b.a
        @CallSuper
        public final void a(TransitionValues transitionValues, TransitionValues transitionValues2) {
            if (transitionValues.view == b.this.y) {
                Rect rect = (Rect) transitionValues.values.get("android:changeBounds:bounds");
                Rect rect2 = (Rect) transitionValues2.values.get("android:changeBounds:bounds");
                b bVar = b.this;
                Rect rect3 = new Rect(sg.bigo.ads.common.utils.u.a(bVar.B, bVar.J));
                this.f14494b = new RectF(rect3);
                if (rect3.intersect(rect2)) {
                    this.f14495c = new RectF(rect);
                    this.f14496d = new RectF(rect2);
                    this.e = b.this.B.getTranslationY();
                    this.f14497f = new RectF(rect2);
                }
            }
        }

        @Override // sg.bigo.ads.common.utils.b.a
        public final void a(Object obj, Object obj2) {
            if (obj != b.this.y || this.f14495c == null || this.f14496d == null || this.f14497f == null || this.f14494b == null || !(obj2 instanceof PointF) || Float.isNaN(this.e)) {
                return;
            }
            PointF pointF = (PointF) obj2;
            if (this.f14495c.centerX() != this.f14496d.centerX()) {
                b.this.B.setTranslationY(this.e - (Math.abs(this.f14497f.top - this.f14494b.bottom) * (Math.abs(pointF.x - this.f14495c.left) / Math.abs(this.f14496d.left - this.f14495c.left))));
            } else {
                this.f14497f.offsetTo(pointF.x, pointF.y);
                if (new RectF(this.f14494b).intersect(this.f14497f)) {
                    b.this.B.setTranslationY((this.e + this.f14497f.top) - this.f14494b.bottom);
                }
            }
        }
    }

    public b(@NonNull sg.bigo.ads.ad.b.c cVar) {
        super(cVar);
        this.K = -1;
        this.L = false;
    }

    private boolean L() {
        return ((sg.bigo.ads.core.a.a) ((sg.bigo.ads.ad.interstitial.u) this).f15138c.f()).aR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public sg.bigo.ads.common.p b(int i2, int i8, int i9, int i10) {
        sg.bigo.ads.common.p pVar;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.C.getLayoutParams();
        sg.bigo.ads.common.p pVarA = sg.bigo.ads.ad.interstitial.s.a(((sg.bigo.ads.ad.interstitial.u) this).f15138c);
        if (pVarA.a(i2, i8)) {
            this.C.setCornerRadius(0.0f);
            marginLayoutParams.setMargins(0, 0, 0, 0);
            marginLayoutParams.width = -1;
            marginLayoutParams.height = -1;
            pVar = new sg.bigo.ads.common.p(i2, i8);
        } else {
            this.C.setCornerRadius(sg.bigo.ads.common.utils.e.a(r2.getContext(), 8));
            marginLayoutParams.setMargins(i9, i10, i9, i10);
            sg.bigo.ads.common.p pVarA2 = sg.bigo.ads.common.p.a(pVarA.f15849b, pVarA.f15850c, i2 - (i9 * 2), i8 - (i10 * 2));
            int i11 = pVarA2.f15849b;
            marginLayoutParams.width = i11;
            int i12 = pVarA2.f15850c;
            marginLayoutParams.height = i12;
            pVar = new sg.bigo.ads.common.p(i11, i12);
        }
        sg.bigo.ads.common.utils.u.c(this.D, -1, -1);
        this.C.setLayoutParams(marginLayoutParams);
        return pVar;
    }

    public void A() {
        if (v()) {
            Button button = this.G;
            if (button != null) {
                sg.bigo.ads.ad.interstitial.c.e(button);
            }
            Button button2 = this.H;
            if (button2 != null) {
                sg.bigo.ads.ad.interstitial.c.e(button2);
            }
        }
    }

    public final void B() {
        Button button;
        if (this.f14450q == null || (button = this.B) == null || button.getVisibility() != 0) {
            return;
        }
        float translationY = this.B.getTranslationY();
        RectF rectF = new RectF(sg.bigo.ads.common.utils.u.a(this.B, this.J));
        rectF.offset(0.0f, -translationY);
        float f4 = rectF.top;
        RectF rectF2 = new RectF(sg.bigo.ads.common.utils.u.a(this.f14455v, 0));
        float f8 = rectF2.top;
        if (rectF2.intersect(rectF)) {
            rectF.offset(0.0f, f8 - rectF.bottom);
        }
        RealtimeBlurLinearLayout realtimeBlurLinearLayout = this.y;
        if (realtimeBlurLinearLayout != null && realtimeBlurLinearLayout.getVisibility() == 0) {
            RectF rectF3 = new RectF(sg.bigo.ads.common.utils.u.a(this.y, 0));
            float f9 = rectF3.top;
            if (rectF3.intersect(rectF)) {
                rectF.offset(0.0f, f9 - rectF.bottom);
            }
        }
        float f10 = rectF.top;
        if (f10 != f4) {
            this.B.setTranslationY(f10 - f4);
        } else {
            this.B.setTranslationY(0.0f);
        }
    }

    public final void C() {
        sg.bigo.ads.common.utils.u.a(this.C, new ViewTreeObserver.OnGlobalLayoutListener() { // from class: sg.bigo.ads.ad.interstitial.d.b.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                b.this.B();
            }
        });
    }

    public void D() {
        if (this.y == null) {
            return;
        }
        final int iY = y();
        Runnable runnable = new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.b.4
            @Override // java.lang.Runnable
            public final void run() {
                b.this.y.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.b.4.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        b.this.a(iY > 0);
                    }
                });
            }
        };
        if (iY == 0) {
            runnable.run();
        } else {
            a(iY, runnable);
        }
    }

    public void E() {
        RealtimeBlurLinearLayout realtimeBlurLinearLayout = this.y;
        if (realtimeBlurLinearLayout == null || this.f14450q == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = realtimeBlurLinearLayout.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = -(this.f14450q.getMeasuredHeight() - sg.bigo.ads.common.utils.u.a(this.f14450q, this.y).y);
            this.y.requestLayout();
        }
    }

    public void F() {
        RealtimeBlurLinearLayout realtimeBlurLinearLayout = this.y;
        if (realtimeBlurLinearLayout == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = realtimeBlurLinearLayout.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = this.M;
            this.y.requestLayout();
        }
    }

    public void G() {
        sg.bigo.ads.ad.interstitial.x xVar = this.f14452s;
        int i2 = xVar != null ? xVar.f15199i : 0;
        View viewFindViewById = this.f14450q.findViewById(R.id.inter_media_container);
        sg.bigo.ads.ad.b.a.a(viewFindViewById, 9);
        sg.bigo.ads.ad.interstitial.x xVar2 = this.f14452s;
        if (xVar2 == null || !xVar2.g) {
            MediaView mediaView = this.D;
            if (mediaView != null) {
                mediaView.setOtherClickAreaClick(false);
            }
            if (viewFindViewById != null) {
                sg.bigo.ads.ad.b.a.a(this.f14450q, viewFindViewById, 8, sg.bigo.ads.ad.interstitial.r.F, 0);
            }
        } else {
            MediaView mediaView2 = this.D;
            if (mediaView2 != null) {
                mediaView2.setOtherClickAreaClick(true);
            }
            if (viewFindViewById != null) {
                sg.bigo.ads.ad.b.a.a(this.f14450q, viewFindViewById, 8, ((sg.bigo.ads.ad.interstitial.u) this).f15138c, i2);
            }
        }
        sg.bigo.ads.ad.interstitial.x xVar3 = this.f14452s;
        boolean z2 = xVar3 != null && xVar3.f15198f;
        MediaView mediaView3 = this.D;
        if (mediaView3 != null) {
            sg.bigo.ads.ad.b.a.a(this.f14450q, mediaView3, 8, ((sg.bigo.ads.ad.interstitial.u) this).f15138c, i2);
            this.D.setMediaAreaClickable(z2);
            this.D.b().a(!z2);
        }
        sg.bigo.ads.ad.interstitial.x xVar4 = this.f14452s;
        boolean z7 = xVar4 != null && xVar4.h;
        RealtimeBlurLinearLayout realtimeBlurLinearLayout = this.y;
        if (realtimeBlurLinearLayout != null) {
            sg.bigo.ads.ad.b.a.a(realtimeBlurLinearLayout, 18);
            ViewGroup viewGroup = this.f14450q;
            if (z7) {
                sg.bigo.ads.ad.b.a.a(viewGroup, this.y, 8, ((sg.bigo.ads.ad.interstitial.u) this).f15138c, this.f14452s.f15199i);
            } else {
                sg.bigo.ads.ad.b.a.a(viewGroup, this.y, 8, sg.bigo.ads.ad.interstitial.r.F, 0);
            }
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.f.c
    public final int H() {
        if (this.K == -1) {
            sg.bigo.ads.api.a.m mVar = this.f14453t;
            this.K = mVar != null ? mVar.a("video_play_page.webview_layout") : 0;
        }
        int i2 = this.K;
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return i2;
            default:
                return 0;
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.f.c
    public final int I() {
        return sg.bigo.ads.ad.interstitial.d.a.b(this.f14453t, "video_play_page.webview_force_time");
    }

    @Override // sg.bigo.ads.ad.interstitial.f.c
    public final boolean J() {
        int iH = H();
        return iH == 5 || iH == 6;
    }

    @Override // sg.bigo.ads.ad.interstitial.f.c
    public final boolean K() {
        return this.L;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.a
    @Nullable
    public final ViewGroup k() {
        return this.C;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.a
    @Nullable
    public final MediaView l() {
        return this.D;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.a
    @Nullable
    public final Button m() {
        return this.B;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.a
    public final boolean n() {
        return true;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.a
    public final void q() {
        String strI = ((sg.bigo.ads.core.a.a) ((sg.bigo.ads.ad.interstitial.u) this).f15138c.f()).i();
        TextView textView = (TextView) this.f14450q.findViewById(R.id.inter_advertiser);
        if (TextUtils.isEmpty(strI)) {
            textView.setVisibility(8);
        } else {
            textView.setText(strI);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00d5  */
    @Override // sg.bigo.ads.ad.interstitial.d.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void t() {
        /*
            Method dump skipped, instruction units count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.ad.interstitial.d.b.t():void");
    }

    public int z() {
        return R.id.inter_component_19;
    }

    private void b(@ColorInt int i2, @ColorInt int i8, int i9) {
        if (this.y != null) {
            float f4 = i9;
            this.y.setBlurStyle(new sg.bigo.ads.common.view.a.b(f4, f4, f4, f4, i2, i8, sg.bigo.ads.common.utils.e.a(r0.getContext(), 1)));
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.d.a
    public final void a(double d8) {
        TextView textView;
        int i2;
        if (d8 <= 3.0d) {
            textView = this.f14455v;
            if (textView == null) {
                return;
            } else {
                i2 = sg.bigo.ads.ad.interstitial.d.f14442b;
            }
        } else {
            textView = this.f14455v;
            if (textView == null) {
                return;
            } else {
                i2 = sg.bigo.ads.ad.interstitial.d.f14441a;
            }
        }
        textView.setTextColor(sg.bigo.ads.common.w.b.a(i2, 0.6f));
    }

    private void a(@ColorInt int i2, @ColorInt int i8, int i9) {
        if (this.y != null) {
            float f4 = i9;
            this.y.setBackground(sg.bigo.ads.common.utils.d.a(f4, f4, f4, f4, i2, i8, sg.bigo.ads.common.utils.e.a(r0.getContext(), 1)));
        }
    }

    public void b(@NonNull sg.bigo.ads.ad.interstitial.b bVar) {
        float fA = sg.bigo.ads.common.utils.e.a(this.y.getContext(), 8);
        Button button = (Button) this.y.findViewById(R.id.inter_btn_cta_main);
        this.H = button;
        if (button != null) {
            button.setBackground(sg.bigo.ads.common.utils.d.a(fA, fA, fA, fA, (Rect) null, -16724924));
            bVar.a(this.H);
        }
        Button button2 = (Button) this.y.findViewById(R.id.inter_btn_cta);
        this.G = button2;
        if (button2 != null) {
            button2.setBackground(sg.bigo.ads.common.utils.d.a(fA, fA, fA, fA, (Rect) null, 0));
            bVar.a(this.G);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.f.c
    public final void a(int i2, int i8, int i9, int i10) {
        if (J()) {
            if (i2 >= i9) {
                this.L = true;
                return;
            }
            this.L = false;
            if (this.f14481x != null) {
                int iMin = (i9 - Math.min(i2, i8)) + i10;
                ViewGroup.LayoutParams layoutParams = this.f14481x.getLayoutParams();
                if (iMin != layoutParams.height) {
                    layoutParams.height = iMin;
                    this.f14481x.requestLayout();
                    b(this.f14481x.getMeasuredWidth(), layoutParams.height, sg.bigo.ads.common.utils.e.a(this.C.getContext(), 12), sg.bigo.ads.common.utils.e.a(this.C.getContext(), 12));
                    B();
                }
            }
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.u
    public final void a(@NonNull ViewGroup viewGroup, @NonNull View view, int i2, int i8, int i9, @Nullable View... viewArr) {
        super.a(viewGroup, view, i2, i8, i9, viewArr);
        G();
        sg.bigo.ads.ad.interstitial.u.a((View) this.f14450q);
    }

    public final void a(boolean z2) {
        if (this.y == null || this.f14456w) {
            return;
        }
        final a.C0259a c0259aU = u();
        Button button = this.G;
        if (button != null) {
            sg.bigo.ads.ad.interstitial.d.b(button, c0259aU.f14479a);
        }
        if (z2) {
            E();
            this.y.setVisibility(0);
            this.y.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.b.5
                @Override // java.lang.Runnable
                public final void run() {
                    TransitionSet transitionSet = new TransitionSet();
                    transitionSet.addTransition(b.this.new a());
                    transitionSet.addListener((Transition.TransitionListener) new sg.bigo.ads.common.h() { // from class: sg.bigo.ads.ad.interstitial.d.b.5.1
                        @Override // sg.bigo.ads.common.h, android.transition.Transition.TransitionListener
                        public final void onTransitionEnd(Transition transition) {
                            b.this.A();
                            AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                            if (c0259aU.f14480b) {
                                b bVar = b.this;
                                bVar.a(bVar.G, new b.a());
                            }
                        }

                        @Override // sg.bigo.ads.common.h, android.transition.Transition.TransitionListener
                        public final void onTransitionStart(Transition transition) {
                        }
                    });
                    transitionSet.setDuration(300L);
                    TransitionManager.beginDelayedTransition(b.this.f14451r, transitionSet);
                    b.this.F();
                }
            });
        } else {
            this.y.setVisibility(0);
            B();
            A();
            if (c0259aU.f14480b) {
                a(this.G, new b.a());
            }
        }
    }

    public boolean a(@NonNull sg.bigo.ads.ad.interstitial.b bVar) {
        if (y() < 0) {
            return false;
        }
        ViewStub viewStub = (ViewStub) this.f14450q.findViewById(z());
        if (viewStub != null) {
            this.f14482z = (ViewGroup) viewStub.inflate();
        }
        RealtimeBlurLinearLayout realtimeBlurLinearLayout = (RealtimeBlurLinearLayout) this.f14450q.findViewById(R.id.inter_component_layout);
        this.y = realtimeBlurLinearLayout;
        if (realtimeBlurLinearLayout == null) {
            return false;
        }
        this.I = (RoundedImageView) realtimeBlurLinearLayout.findViewById(R.id.inter_icon);
        this.E = (TextView) this.y.findViewById(R.id.inter_title);
        TextView textView = (TextView) this.y.findViewById(R.id.inter_description);
        this.F = textView;
        bVar.a(this.E, textView);
        bVar.a(this.I);
        sg.bigo.ads.common.utils.u.a(this.y, new ViewTreeObserver.OnGlobalLayoutListener() { // from class: sg.bigo.ads.ad.interstitial.d.b.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                b.this.D();
            }
        });
        ViewGroup.LayoutParams layoutParams = this.y.getLayoutParams();
        layoutParams.width = -1;
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            this.M = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }
        this.y.setVisibility(4);
        this.y.requestLayout();
        return true;
    }
}
