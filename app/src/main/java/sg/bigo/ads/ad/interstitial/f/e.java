package sg.bigo.ads.ad.interstitial.f;

import android.app.Activity;
import android.graphics.PointF;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.f.b;
import sg.bigo.ads.common.h;
import sg.bigo.ads.common.utils.b;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.common.view.RoundedFrameLayout;
import sg.bigo.ads.controller.landing.LandingPageStyleConfig;

/* JADX INFO: loaded from: classes6.dex */
public class e extends d {
    private final a E;
    private final a F;
    private final AtomicBoolean G;
    private boolean H;
    private final b.a K;
    private boolean L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final b f14724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final int f14725c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final int f14726d;
    protected final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final int f14727f;
    protected final int g;
    protected RoundedFrameLayout h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected RelativeLayout f14728i;
    protected View j;
    protected LinearLayout k;
    protected ImageView l;
    protected TextView m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected RelativeLayout f14729n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected ImageView f14730o;
    protected ImageView p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected ImageView f14731q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected ImageView f14732r;

    /* JADX INFO: renamed from: sg.bigo.ads.ad.interstitial.f.e$10, reason: invalid class name */
    public class AnonymousClass10 implements ValueCallback<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup.MarginLayoutParams f14734a;

        public AnonymousClass10(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.f14734a = marginLayoutParams;
        }

        @Override // android.webkit.ValueCallback
        public final /* synthetic */ void onReceiveValue(Integer num) {
            this.f14734a.topMargin = num.intValue();
            e.this.h.requestLayout();
            e.this.h.getMeasuredWidth();
            e eVar = e.this;
            eVar.f(eVar.f14725c - this.f14734a.topMargin);
        }
    }

    /* JADX INFO: renamed from: sg.bigo.ads.ad.interstitial.f.e$2, reason: invalid class name */
    public class AnonymousClass2 implements ValueCallback<Void> {
        public AnonymousClass2() {
        }

        @Override // android.webkit.ValueCallback
        public final /* synthetic */ void onReceiveValue(Void r1) {
            e.e(e.this);
        }
    }

    public class a implements View.OnTouchListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f14747b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f14748c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f14749d;
        private int e;

        private a() {
            this.f14747b = ViewConfiguration.get(e.this.I).getScaledTouchSlop();
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0065  */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean onTouch(android.view.View r3, android.view.MotionEvent r4) {
            /*
                r2 = this;
                sg.bigo.ads.ad.interstitial.f.e r3 = sg.bigo.ads.ad.interstitial.f.e.this
                boolean r3 = r3.f()
                r0 = 0
                if (r3 != 0) goto L9b
                sg.bigo.ads.ad.interstitial.f.e r3 = sg.bigo.ads.ad.interstitial.f.e.this
                java.util.concurrent.atomic.AtomicBoolean r3 = sg.bigo.ads.ad.interstitial.f.e.c(r3)
                boolean r3 = r3.get()
                if (r3 != 0) goto L17
                goto L9b
            L17:
                int r3 = r4.getAction()
                r1 = 1
                if (r3 == 0) goto L6b
                if (r3 == r1) goto L39
                r0 = 2
                if (r3 == r0) goto L28
                r4 = 3
                if (r3 == r4) goto L65
                goto L9a
            L28:
                float r3 = r4.getRawY()
                int r3 = (int) r3
                int r4 = r2.e
                int r4 = r3 - r4
                r2.e = r3
                sg.bigo.ads.ad.interstitial.f.e r3 = sg.bigo.ads.ad.interstitial.f.e.this
                r3.c(r4)
                goto L9a
            L39:
                float r3 = r4.getRawX()
                float r4 = r4.getRawY()
                float r0 = r2.f14748c
                float r0 = r0 - r3
                float r3 = java.lang.Math.abs(r0)
                int r0 = r2.f14747b
                float r0 = (float) r0
                int r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
                if (r3 >= 0) goto L65
                float r3 = r2.f14749d
                float r3 = r3 - r4
                float r3 = java.lang.Math.abs(r3)
                int r4 = r2.f14747b
                float r4 = (float) r4
                int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
                if (r3 >= 0) goto L65
                sg.bigo.ads.ad.interstitial.f.e r3 = sg.bigo.ads.ad.interstitial.f.e.this
                int r4 = r3.e
                sg.bigo.ads.ad.interstitial.f.e.c(r3, r4)
                goto L9a
            L65:
                sg.bigo.ads.ad.interstitial.f.e r3 = sg.bigo.ads.ad.interstitial.f.e.this
                r3.g()
                goto L9a
            L6b:
                float r3 = r4.getRawX()
                r2.f14748c = r3
                float r3 = r4.getRawY()
                r2.f14749d = r3
                sg.bigo.ads.ad.interstitial.f.e r3 = sg.bigo.ads.ad.interstitial.f.e.this
                boolean r3 = r3.f()
                if (r3 == 0) goto L85
                sg.bigo.ads.ad.interstitial.f.e r3 = sg.bigo.ads.ad.interstitial.f.e.this
                sg.bigo.ads.ad.interstitial.f.b r3 = r3.f14724b
                if (r3 != 0) goto L92
            L85:
                sg.bigo.ads.ad.interstitial.f.e r3 = sg.bigo.ads.ad.interstitial.f.e.this
                r3.f()
                sg.bigo.ads.ad.interstitial.f.e r3 = sg.bigo.ads.ad.interstitial.f.e.this
                boolean r3 = sg.bigo.ads.ad.interstitial.f.e.g(r3)
                if (r3 != 0) goto L93
            L92:
                return r0
            L93:
                float r3 = r4.getRawY()
                int r3 = (int) r3
                r2.e = r3
            L9a:
                return r1
            L9b:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.ad.interstitial.f.e.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }

        public /* synthetic */ a(e eVar, byte b8) {
            this();
        }
    }

    public e(@NonNull Activity activity) {
        b bVar;
        int i2;
        super(activity);
        this.G = new AtomicBoolean(true);
        byte b8 = 0;
        this.H = false;
        this.K = new b.a() { // from class: sg.bigo.ads.ad.interstitial.f.e.1
            @Override // sg.bigo.ads.ad.interstitial.f.b.a
            public final boolean a() {
                if (e.this.u()) {
                    return false;
                }
                e.this.d(0);
                return true;
            }
        };
        this.L = true;
        LandingPageStyleConfig landingPageStyleConfig = ((d) this).f14718a;
        if (landingPageStyleConfig != null) {
            int i8 = landingPageStyleConfig.f16676a;
            switch (i8) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    bVar = new b(landingPageStyleConfig.f16678c, i8, landingPageStyleConfig.e, landingPageStyleConfig.f16680f);
                    break;
                default:
                    bVar = new b(0, 1, landingPageStyleConfig.e, landingPageStyleConfig.f16680f);
                    break;
            }
        } else {
            bVar = null;
        }
        this.f14724b = bVar;
        int iA = sg.bigo.ads.common.utils.e.a(this.I, 20);
        this.f14726d = iA;
        LandingPageStyleConfig landingPageStyleConfig2 = ((d) this).f14718a;
        this.f14725c = ((landingPageStyleConfig2 == null || (i2 = landingPageStyleConfig2.f16679d) <= 0) ? sg.bigo.ads.common.utils.e.c(this.I) - sg.bigo.ads.common.utils.e.a(this.I, 48) : i2) - iA;
        this.e = 0;
        this.f14727f = (int) ((1.0f - (bVar != null ? bVar.e() : 1.0f)) * this.f14725c);
        this.g = sg.bigo.ads.common.utils.e.a(activity, 3);
        this.E = new a(this, b8);
        this.F = new a(this, b8);
        activity.setTheme(R.style.LandingPageStyle);
        ao();
        Window window = this.I.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = this.f14725c;
        attributes.gravity = 80;
        window.setAttributes(attributes);
        activity.overridePendingTransition(0, 0);
    }

    private boolean x() {
        WebView webView = this.B;
        if (webView == null) {
            return false;
        }
        return webView.canGoForward();
    }

    @Override // sg.bigo.ads.controller.landing.c, sg.bigo.ads.core.landing.WebViewActivityImpl, sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void X() {
        super.X();
        this.I.overridePendingTransition(0, 0);
        b bVar = this.f14724b;
        if (bVar != null) {
            bVar.c();
        }
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl
    public final int a() {
        return R.layout.bigo_ad_activity_interstitial_landingpage;
    }

    @Override // sg.bigo.ads.ad.interstitial.f.d, sg.bigo.ads.controller.landing.c, sg.bigo.ads.core.landing.WebViewActivityImpl
    public final void b() {
        String host;
        ImageView imageView;
        super.b();
        this.h = (RoundedFrameLayout) o(R.id.inter_landpage_webview_page);
        this.f14728i = (RelativeLayout) o(R.id.inter_webview_top_bar);
        this.k = (LinearLayout) o(R.id.inter_webview_top_action_bar);
        this.l = (ImageView) o(R.id.inter_webview_open);
        this.m = (TextView) o(R.id.inter_webview_host);
        this.f14732r = (ImageView) o(R.id.inter_webview_safe);
        this.j = o(R.id.inter_webview_top_indicator);
        this.f14729n = (RelativeLayout) o(R.id.inter_webview_bottom_bar);
        this.f14730o = (ImageView) o(R.id.inter_webview_forward);
        this.p = (ImageView) o(R.id.inter_webview_copy);
        this.f14731q = (ImageView) o(R.id.inter_webview_refresh);
        this.l.setOnClickListener(this);
        this.f14730o.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.f14731q.setOnClickListener(this);
        View viewO = o(R.id.inter_webview_top_middle);
        int i2 = 8;
        this.l.setVisibility(c() ? 8 : 0);
        this.f14730o.setVisibility(c() ? 8 : 0);
        this.p.setVisibility(c() ? 8 : 0);
        this.f14731q.setVisibility(c() ? 8 : 0);
        this.f14729n.setVisibility(c() ? 8 : 0);
        ImageView imageView2 = this.A;
        if (imageView2 != null) {
            imageView2.setVisibility(c() ? 8 : 0);
        }
        View view = this.j;
        if (view != null) {
            view.setVisibility(c() ? 8 : 0);
        }
        if (viewO != null) {
            viewO.setVisibility(c() ? 8 : 0);
        }
        b bVar = this.f14724b;
        if (bVar != null) {
            this.f14728i.setLayoutDirection(bVar.f() ? 1 : 0);
        }
        this.k.setLayoutDirection(this.f14728i.getLayoutDirection());
        this.f17124z.setLayoutDirection(0);
        this.l.setLayoutDirection(0);
        this.y.setLayoutDirection(0);
        this.f17123x.setLayoutDirection(0);
        this.m.setLayoutDirection(0);
        this.f17123x.setMaxLines(1);
        float fA = sg.bigo.ads.common.utils.e.a(this.I, 16);
        this.h.a(fA, fA, 0.0f, 0.0f);
        this.f17123x.setVisibility(8);
        this.m.setVisibility(8);
        String str = this.C;
        boolean zIsHttpsUrl = URLUtil.isHttpsUrl(str);
        try {
            host = Uri.parse(str).getHost();
        } catch (Exception unused) {
            host = "";
        }
        this.m.setText(host);
        if (q.a((CharSequence) host)) {
            this.m.setVisibility(8);
            imageView = this.f14732r;
        } else {
            this.m.setVisibility(0);
            imageView = this.f14732r;
            if (zIsHttpsUrl) {
                i2 = 0;
            }
        }
        imageView.setVisibility(i2);
        this.f14728i.setOnTouchListener(this.F);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.h.getLayoutParams();
        b bVar2 = this.f14724b;
        if (bVar2 != null) {
            marginLayoutParams.topMargin = bVar2.g() ? this.e : this.f14727f;
        }
        this.h.requestLayout();
        u.a(this.h, new ViewTreeObserver.OnGlobalLayoutListener() { // from class: sg.bigo.ads.ad.interstitial.f.e.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                e.d(e.this);
            }
        });
        b bVar3 = this.f14724b;
        if ((bVar3 == null || bVar3.d() != 0) && !c()) {
            Drawable progressDrawable = this.y.getProgressDrawable();
            if (progressDrawable instanceof LayerDrawable) {
                Drawable drawable = ((ClipDrawable) ((LayerDrawable) progressDrawable).findDrawableByLayerId(android.R.id.progress)).getDrawable();
                if (drawable instanceof GradientDrawable) {
                    GradientDrawable gradientDrawable = (GradientDrawable) drawable;
                    b bVar4 = this.f14724b;
                    gradientDrawable.setColors(new int[]{bVar4 != null ? bVar4.d() : -1, -1312769});
                }
            }
        }
    }

    @Override // sg.bigo.ads.controller.landing.c, sg.bigo.ads.core.landing.WebViewActivityImpl
    public final void d() {
        super.d();
        b bVar = this.f14724b;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl
    public final void e() {
        super.e();
        b bVar = this.f14724b;
        if (bVar != null) {
            bVar.b();
        }
    }

    public final void g() {
        float f4 = ((ViewGroup.MarginLayoutParams) this.h.getLayoutParams()).topMargin;
        int i2 = this.f14727f;
        if (f4 <= i2 * 0.8f) {
            i2 = 0;
        }
        g(i2);
    }

    @Override // sg.bigo.ads.controller.landing.c, sg.bigo.ads.api.b.f
    public final int h() {
        b bVar = this.f14724b;
        if (bVar == null) {
            return 0;
        }
        return bVar.f14716c;
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl, android.view.View.OnClickListener
    public void onClick(View view) {
        WebView webView;
        super.onClick(view);
        if (view == this.l) {
            sg.bigo.ads.core.landing.a.a(this.I, this.C, (JSONArray) null);
            return;
        }
        if (view == this.f14730o) {
            WebView webView2 = this.B;
            if (webView2 == null || !webView2.canGoForward()) {
                return;
            }
            this.B.goForward();
            return;
        }
        if (view == this.p) {
            if (sg.bigo.ads.common.utils.c.g(this.I, this.C)) {
                Activity activity = this.I;
                Toast.makeText(activity, sg.bigo.ads.common.utils.a.a(activity, R.string.bigo_ad_link_copied, new Object[0]), 0).show();
                return;
            }
            return;
        }
        if (view != this.f14731q || (webView = this.B) == null) {
            return;
        }
        webView.reload();
    }

    public static /* synthetic */ void d(e eVar) {
        if (eVar.G.compareAndSet(true, false)) {
            long jAbs = (long) Math.abs(((eVar.f14725c - ((ViewGroup.MarginLayoutParams) eVar.h.getLayoutParams()).topMargin) * 1.5f) / eVar.g);
            sg.bigo.ads.common.a.a aVar = new sg.bigo.ads.common.a.a() { // from class: sg.bigo.ads.ad.interstitial.f.e.4
                @Override // sg.bigo.ads.common.a.a
                public final void a(float f4, float f8, int i2, int i8) {
                    e.this.f((int) (i8 - f8));
                }

                @Override // sg.bigo.ads.common.a.a, android.view.animation.Animation.AnimationListener
                public final void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    e.this.G.set(true);
                }
            };
            aVar.setDuration(jAbs);
            eVar.h.startAnimation(aVar);
        }
    }

    public static /* synthetic */ boolean e(e eVar) {
        eVar.L = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i2) {
        View view;
        int i8 = this.f14725c;
        int i9 = i8 - this.f14727f;
        int i10 = this.f14726d;
        if (i2 == i8 && (view = this.j) != null && !this.H) {
            this.H = true;
            view.postDelayed(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.f.e.3
                @Override // java.lang.Runnable
                public final void run() {
                    TransitionSet transitionSet = new TransitionSet();
                    transitionSet.addTransition(new b.a());
                    transitionSet.addTransition(new Fade(2));
                    transitionSet.setDuration(300L);
                    TransitionManager.beginDelayedTransition(e.this.h, transitionSet);
                    e.this.j.setVisibility(8);
                }
            }, 500L);
        }
        b bVar = this.f14724b;
        if (bVar != null) {
            bVar.a(i2, i9, i8, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i2) {
        int iMax = Math.max(this.e, Math.min(this.f14727f, i2));
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.h.getLayoutParams();
        if (marginLayoutParams.topMargin == iMax) {
            return;
        }
        long jAbs = (long) Math.abs(((iMax - r1) * 2.0f) / this.g);
        this.L = false;
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(new b.a() { // from class: sg.bigo.ads.ad.interstitial.f.e.8
            @Override // sg.bigo.ads.common.utils.b.a
            public final void a(Object obj, Object obj2) {
                RoundedFrameLayout roundedFrameLayout = e.this.h;
                if (obj == roundedFrameLayout && (obj2 instanceof PointF)) {
                    roundedFrameLayout.getMeasuredWidth();
                    e.this.f((int) (r2.f14725c - ((PointF) obj2).y));
                }
            }
        });
        transitionSet.setDuration(jAbs);
        transitionSet.addListener((Transition.TransitionListener) new h() { // from class: sg.bigo.ads.ad.interstitial.f.e.9
            @Override // sg.bigo.ads.common.h, android.transition.Transition.TransitionListener
            public final void onTransitionEnd(Transition transition) {
                super.onTransitionEnd(transition);
                e.e(e.this);
            }
        });
        TransitionManager.beginDelayedTransition(this.h, transitionSet);
        marginLayoutParams.topMargin = iMax;
        this.h.requestLayout();
    }

    @Override // sg.bigo.ads.ad.interstitial.f.d, sg.bigo.ads.controller.landing.c, sg.bigo.ads.core.landing.WebViewActivityImpl
    public final void a(String str) {
        super.a(str);
        this.A.setEnabled(v());
        this.f14730o.setEnabled(x());
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl
    public final void b(final int i2) {
        final Runnable runnable = new Runnable() { // from class: sg.bigo.ads.ad.interstitial.f.e.6
            @Override // java.lang.Runnable
            public final void run() {
                e.super.b(i2);
            }
        };
        if (this.G.compareAndSet(true, false)) {
            long jAbs = (long) Math.abs(((this.f14725c - ((ViewGroup.MarginLayoutParams) this.h.getLayoutParams()).topMargin) * 1.5f) / this.g);
            sg.bigo.ads.common.a.a aVar = new sg.bigo.ads.common.a.a() { // from class: sg.bigo.ads.ad.interstitial.f.e.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0.0f, 1.0f);
                }

                @Override // sg.bigo.ads.common.a.a
                public final void a(float f4, float f8, int i8, int i9) {
                    e.this.f((int) (i9 - f8));
                }

                @Override // sg.bigo.ads.common.a.a, android.view.animation.Animation.AnimationListener
                public final void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    Runnable runnable2 = runnable;
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            };
            aVar.setFillAfter(true);
            aVar.setDuration(jAbs);
            this.h.startAnimation(aVar);
        }
    }

    public final void c(int i2) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.h.getLayoutParams();
        int iMin = Math.min(Math.max(this.e, marginLayoutParams.topMargin + i2), this.f14727f);
        marginLayoutParams.topMargin = iMin;
        this.h.requestLayout();
        this.h.getMeasuredWidth();
        f(this.f14725c - iMin);
    }

    @Override // sg.bigo.ads.ad.interstitial.f.d, sg.bigo.ads.controller.landing.c, sg.bigo.ads.core.landing.WebViewActivityImpl
    public final void a(String str, boolean z2) {
        super.a(str, z2);
        this.A.setEnabled(v());
        this.f14730o.setEnabled(x());
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl
    public final void b(String str) {
        super.b(str);
        TextView textView = this.f17123x;
        if (textView != null) {
            textView.setVisibility(q.a((CharSequence) str) ? 8 : 0);
        }
    }

    public final boolean f() {
        return ((ViewGroup.MarginLayoutParams) this.h.getLayoutParams()).topMargin <= this.e;
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl
    public final boolean a(MotionEvent motionEvent) {
        return this.E.onTouch(this.B, motionEvent);
    }

    @Override // sg.bigo.ads.api.core.BaseAdActivityImpl
    public final boolean b(MotionEvent motionEvent) {
        b bVar = this.f14724b;
        return bVar != null ? bVar.a(motionEvent, this.K) || super.b(motionEvent) : super.b(motionEvent);
    }
}
