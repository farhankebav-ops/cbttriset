package sg.bigo.ads.ad.interstitial;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import com.vungle.ads.internal.protos.Sdk;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.b.b;
import sg.bigo.ads.ad.c;
import sg.bigo.ads.ad.interstitial.AdCountDownButton;
import sg.bigo.ads.ad.interstitial.e.c;
import sg.bigo.ads.ad.interstitial.f.b;
import sg.bigo.ads.ad.interstitial.h;
import sg.bigo.ads.ad.interstitial.p;
import sg.bigo.ads.ad.interstitial.t;
import sg.bigo.ads.ad.interstitial.v;
import sg.bigo.ads.api.IconAds;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.NativeAd;
import sg.bigo.ads.common.e.a;
import sg.bigo.ads.common.utils.b;
import sg.bigo.ads.common.view.RealtimeBlurLinearLayout;
import sg.bigo.ads.common.view.RoundedFrameLayout;
import sg.bigo.ads.common.view.YandexWarningTextView;
import sg.bigo.ads.controller.landing.LandingPageStyleConfig;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a extends r implements c.a, b.InterfaceC0266b {
    private final List<Integer> G;

    @Nullable
    private p<t> H;

    @NonNull
    private final l L;
    private final WeakHashMap<Object, Integer> M;
    private final Map<Integer, WeakHashMap<Object, Runnable>> N;
    private final a.AbstractC0283a O;
    private boolean P;
    private Runnable Q;
    private int R;
    private int S;
    private final Runnable T;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    protected View f14179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public sg.bigo.ads.api.a.m f14180b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    protected sg.bigo.ads.api.a.m f14181c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f14182d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected boolean f14183f;
    protected boolean g;
    public x h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    protected sg.bigo.ads.ad.interstitial.multi_img.b f14184i;
    protected f j;
    protected final Handler k;
    protected String l;
    protected int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected int f14185n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected int f14186o;
    protected AtomicBoolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected boolean f14187q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    public q f14188r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    protected sg.bigo.ads.ad.interstitial.e.c f14189s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    protected sg.bigo.ads.ad.interstitial.g.a f14190t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected sg.bigo.ads.common.utils.n f14191u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected sg.bigo.ads.common.utils.n f14192v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    protected sg.bigo.ads.common.utils.n f14193w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected sg.bigo.ads.common.utils.n f14194x;

    /* JADX INFO: renamed from: sg.bigo.ads.ad.interstitial.a$3, reason: invalid class name */
    public class AnonymousClass3 extends sg.bigo.ads.common.utils.n {
        public AnonymousClass3(long j) {
            super(j, 1000L);
        }

        @Override // sg.bigo.ads.common.utils.n
        public final void a() {
            a aVar = a.this;
            aVar.a(aVar.f14192v, new Runnable() { // from class: sg.bigo.ads.ad.interstitial.a.3.1
                @Override // java.lang.Runnable
                public final void run() {
                    ViewGroup viewGroup = a.this.D;
                    if (viewGroup != null) {
                        Context context = viewGroup.getContext();
                        int i2 = R.layout.bigo_ad_view_slide_gesture;
                        ViewGroup viewGroup2 = a.this.D;
                        sg.bigo.ads.common.utils.a.a(context, i2, viewGroup2, viewGroup2 != null);
                        View viewFindViewById = a.this.D.findViewById(R.id.inter_slide_gesture_contain);
                        a aVar2 = a.this;
                        aVar2.f14179a = aVar2.D.findViewById(R.id.inter_slide_gesture);
                        View view = a.this.f14179a;
                        if (view == null) {
                            return;
                        }
                        view.setTag(16);
                        u uVarZ = a.this.Z();
                        a aVar3 = a.this;
                        uVarZ.a(aVar3.D, viewFindViewById, aVar3.Y(), 8, 0, a.this.f14179a);
                        a.this.w();
                        final View view2 = a.this.f14179a;
                        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                        alphaAnimation.setDuration(300L);
                        final AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                        alphaAnimation2.setDuration(200L);
                        alphaAnimation2.setStartOffset(200L);
                        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 160.0f, 0.0f);
                        translateAnimation.setDuration(300L);
                        final AnimationSet animationSet = new AnimationSet(true);
                        animationSet.addAnimation(translateAnimation);
                        animationSet.addAnimation(alphaAnimation);
                        animationSet.setAnimationListener(new b.c() { // from class: sg.bigo.ads.ad.interstitial.c.9
                            @Override // sg.bigo.ads.common.utils.b.c, android.view.animation.Animation.AnimationListener
                            public final void onAnimationEnd(Animation animation) {
                                view2.startAnimation(alphaAnimation2);
                            }
                        });
                        alphaAnimation2.setAnimationListener(new b.c() { // from class: sg.bigo.ads.ad.interstitial.c.10
                            @Override // sg.bigo.ads.common.utils.b.c, android.view.animation.Animation.AnimationListener
                            public final void onAnimationEnd(Animation animation) {
                                animationSet.setStartOffset(200L);
                                view2.startAnimation(animationSet);
                            }
                        });
                        view2.startAnimation(animationSet);
                        a.this.f14179a.postDelayed(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.a.3.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                if (sg.bigo.ads.ad.c.a((sg.bigo.ads.ad.c) a.this.y)) {
                                    return;
                                }
                                a.this.v();
                            }
                        }, 5000L);
                    }
                }
            });
        }

        @Override // sg.bigo.ads.common.utils.n
        public final void a(long j) {
        }
    }

    public a(@NonNull Activity activity) {
        super(activity);
        this.G = new ArrayList();
        this.f14182d = false;
        this.e = false;
        this.f14183f = false;
        this.g = false;
        this.k = new Handler(Looper.getMainLooper());
        this.m = 0;
        this.f14185n = 0;
        this.f14186o = 0;
        this.p = new AtomicBoolean(false);
        this.f14187q = true;
        this.L = new l();
        this.M = new WeakHashMap<>();
        this.N = new HashMap();
        this.O = new a.AbstractC0283a() { // from class: sg.bigo.ads.ad.interstitial.a.1
            @Override // sg.bigo.ads.common.e.a.AbstractC0283a
            public final void a(boolean z2) {
                a.this.c(z2);
            }
        };
        this.P = false;
        this.Q = null;
        this.R = 0;
        this.S = 0;
        this.T = new Runnable() { // from class: sg.bigo.ads.ad.interstitial.a.6
            @Override // java.lang.Runnable
            public final void run() {
                a.this.y();
            }
        };
        sg.bigo.ads.ad.interstitial.f.b.f14714a = new WeakReference<>(this);
    }

    public static /* synthetic */ double a(int i2, int i8, int i9, int i10) {
        return Math.max(Math.abs(i2 - i9), Math.abs(i8 - i10));
    }

    private boolean ad() {
        if (!this.P) {
            return true;
        }
        if (c() == 0) {
            return !k() || l();
        }
        return false;
    }

    @NonNull
    private LandingPageStyleConfig ae() {
        sg.bigo.ads.api.a.m mVar = this.f14181c;
        if (mVar == null || !this.f14182d) {
            mVar = null;
        }
        int iA = sg.bigo.ads.ad.interstitial.g.a.a(mVar);
        int iB = sg.bigo.ads.ad.interstitial.g.a.b(mVar);
        sg.bigo.ads.ad.interstitial.g.a aVar = this.f14190t;
        int iA2 = (aVar == null || !aVar.d()) ? 0 : Z().f15141i;
        if (iA2 == 0) {
            iA2 = s.a(this.C, 0);
        }
        int i2 = iA2;
        int measuredHeight = 0;
        Class<? extends sg.bigo.ads.controller.landing.c> clsH = h(iA);
        ViewGroup viewGroup = this.D;
        if (viewGroup != null) {
            measuredHeight = viewGroup.getMeasuredHeight();
        }
        return new LandingPageStyleConfig(clsH, 9, iA, iB, measuredHeight, i2, 0.8f);
    }

    private boolean af() {
        sg.bigo.ads.api.a.m mVar = this.f14181c;
        return mVar != null && mVar.c("layer.is_show_layer");
    }

    public static Class<? extends sg.bigo.ads.controller.landing.c> h(int i2) {
        return i2 == 0 ? sg.bigo.ads.ad.interstitial.f.d.class : (7 == i2 || 8 == i2) ? sg.bigo.ads.ad.interstitial.f.a.class : sg.bigo.ads.ad.interstitial.f.e.class;
    }

    private void k(int i2) {
        sg.bigo.ads.ad.interstitial.multi_img.b bVarD;
        if (i2 != 0) {
            if (i2 == 1 && (bVarD = ((t) this.y).D()) != null) {
                bVarD.a(2, 2);
                return;
            }
            return;
        }
        sg.bigo.ads.ad.interstitial.multi_img.b bVar = this.f14184i;
        if (bVar != null) {
            bVar.a(1, 2);
        }
    }

    public final boolean A() {
        View viewFindViewById;
        View viewFindViewById2;
        View viewFindViewById3;
        sg.bigo.ads.api.a.m mVar;
        int i2 = R.layout.bigo_ad_view_click_guide;
        if (aq()) {
            sg.bigo.ads.api.a.m mVar2 = this.f14181c;
            iA = mVar2 != null ? mVar2.a("layer.guided_click") : -1;
            if (iA == 1) {
                i2 = R.layout.bigo_ad_view_click_guide_landscape_1;
            } else if (iA == 3) {
                i2 = R.layout.bigo_ad_view_click_guide_landscape_3;
            } else {
                i2 = R.layout.bigo_ad_view_click_guide_landscape_2;
                iA = 2;
            }
        }
        if (this.D == null || c() == 2 || c() == 8 || !this.h.f15197d) {
            return false;
        }
        sg.bigo.ads.ad.interstitial.g.a aVar = this.f14190t;
        if (aVar != null) {
            viewFindViewById = aVar.a(this, this.D, Y(), new v.a() { // from class: sg.bigo.ads.ad.interstitial.a.5
                @Override // sg.bigo.ads.ad.interstitial.v.a
                public final void a(View view) {
                    a.this.a(view);
                }
            });
        } else {
            Context context = this.D.getContext();
            ViewGroup viewGroup = this.D;
            sg.bigo.ads.common.utils.a.a(context, i2, viewGroup, viewGroup != null);
            View viewFindViewById4 = this.D.findViewById(R.id.inter_click_guide_container);
            if (viewFindViewById4 != null) {
                Z().a(this.D, viewFindViewById4, Y(), 10, this.h.l, viewFindViewById4);
                viewFindViewById4.setTag(12);
                Button button = (Button) viewFindViewById4.findViewById(R.id.inter_btn_cta);
                if (button != null) {
                    button.setTag(17);
                }
                viewFindViewById4.findViewById(R.id.inter_icon).setTag(17);
                if (this.f14182d) {
                    if (button != null) {
                        button.setBackgroundColor(this.f14186o);
                    }
                    x xVar = this.h;
                    if (xVar.k) {
                        a(viewFindViewById4, 10, ((t) this.y).f15129z, xVar.l);
                    } else {
                        a(viewFindViewById4, 10, r.F, 0);
                    }
                } else {
                    a(viewFindViewById4, 5, ((t) this.y).f15129z, this.h.l);
                }
                c.b(viewFindViewById4);
                View viewFindViewById5 = viewFindViewById4.findViewById(R.id.inter_click_guide);
                View viewFindViewById6 = viewFindViewById4.findViewById(R.id.inter_click_ripple);
                if (viewFindViewById5 != null && viewFindViewById6 != null) {
                    c.a(viewFindViewById5, viewFindViewById6);
                }
                if (iA == 1 && (viewFindViewById3 = viewFindViewById4.findViewById(R.id.inter_btn_cta_layout)) != null) {
                    c.e(viewFindViewById3);
                } else if (iA == 3 && (viewFindViewById2 = viewFindViewById4.findViewById(R.id.inter_click_guide)) != null) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                    alphaAnimation.setDuration(600L);
                    alphaAnimation.setStartOffset(1000L);
                    alphaAnimation.setInterpolator(sg.bigo.ads.common.utils.b.a(1));
                    TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -sg.bigo.ads.common.utils.e.a(viewFindViewById2.getContext(), 160));
                    translateAnimation.setDuration(600L);
                    translateAnimation.setStartOffset(1000L);
                    translateAnimation.setInterpolator(sg.bigo.ads.common.utils.b.a(2));
                    AnimationSet animationSet = new AnimationSet(false);
                    animationSet.addAnimation(alphaAnimation);
                    animationSet.addAnimation(translateAnimation);
                    alphaAnimation.setRepeatCount(Integer.MAX_VALUE);
                    alphaAnimation.setRepeatMode(1);
                    translateAnimation.setRepeatCount(Integer.MAX_VALUE);
                    translateAnimation.setRepeatMode(1);
                    viewFindViewById2.startAnimation(animationSet);
                }
            }
            viewFindViewById = this.D.findViewById(R.id.bigo_ad_layout_click_guide);
            a(viewFindViewById);
            if (viewFindViewById == null) {
                viewFindViewById = viewFindViewById4;
            }
        }
        if (viewFindViewById != null && (mVar = this.f14181c) != null) {
            a(viewFindViewById, this.f14182d ? mVar.a("layer.below_area_dp") : 0, this.f14182d && this.f14181c.a("layer.below_area_clickable") == 1, this.f14182d ? this.f14181c.a("layer.up_area_dp") : 0, this.f14182d && this.f14181c.a("layer.up_area_clickable") == 1, 10, this.h.l);
        }
        f(9);
        a(((long) this.h.e) * 1000);
        return true;
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    public final int B() {
        int iC = c();
        int iD = d();
        switch (iC) {
            case 2:
                if (iD == 5) {
                    return 4;
                }
            case 1:
                return 2;
            case 3:
                return 3;
            case 4:
            default:
                return 1;
            case 5:
            case 6:
                return 4;
            case 7:
            case 8:
                return 5;
            case 9:
                if (iD == 1) {
                    return 2;
                }
                return iD == 5 ? 4 : 9;
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.ad.interstitial.k.b
    public void C() {
        if (G()) {
            ae();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.r, sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.api.core.BaseAdActivityImpl
    public void D() {
        super.D();
        this.k.removeCallbacksAndMessages(null);
        sg.bigo.ads.ad.interstitial.e.c cVar = this.f14189s;
        if (cVar != null) {
            IconAds iconAds = cVar.e;
            if (iconAds != null) {
                iconAds.destroy();
            }
            sg.bigo.ads.common.utils.n nVar = cVar.l;
            if (nVar != null) {
                nVar.b();
                cVar.l = null;
            }
            sg.bigo.ads.common.utils.n nVar2 = cVar.m;
            if (nVar2 != null) {
                nVar2.b();
                cVar.m = null;
            }
            cVar.f14653q.clear();
            cVar.f14654r.clear();
            cVar.f14655s.clear();
            cVar.f14656t.clear();
            cVar.f14651n = true;
            cVar.b();
            cVar.c();
        }
        sg.bigo.ads.common.e.a.b(this.A, this.O);
    }

    public final void E() {
        TextView textView = (TextView) this.D.findViewById(R.id.inter_advertiser);
        if (textView == null) {
            return;
        }
        if (TextUtils.isEmpty(this.l)) {
            textView.setVisibility(8);
            return;
        }
        if (!aq() && (textView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(2, R.id.inter_ad_info);
            layoutParams.addRule(12, 0);
            layoutParams.leftMargin = 18;
            layoutParams.setMarginStart(18);
            layoutParams.bottomMargin = 15;
            textView.setLayoutParams(layoutParams);
            textView.setText(this.l);
        }
    }

    public final boolean F() {
        ae();
        return false;
    }

    public final boolean G() {
        int iC = c();
        return iC == 2 || iC == 6 || iC == 8 || iC == 9;
    }

    public abstract void H();

    /* JADX WARN: Removed duplicated region for block: B:18:0x003b A[PHI: r0
  0x003b: PHI (r0v16 java.lang.Integer) = (r0v15 java.lang.Integer), (r0v18 java.lang.Integer) binds: [B:24:0x0050, B:17:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void I() {
        /*
            r9 = this;
            android.view.ViewGroup r0 = r9.D
            if (r0 == 0) goto Lbc
            sg.bigo.ads.api.a.m r0 = r9.f14181c
            r1 = 4
            r2 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r3 = 2
            r4 = -1
            r5 = 1
            java.lang.String r6 = "video_play_page.background_colour"
            r7 = -7829368(0xffffffffff888888, float:NaN)
            java.lang.String r8 = "#262E33"
            if (r0 == 0) goto L64
            boolean r0 = r9.M()
            if (r0 == 0) goto L64
            sg.bigo.ads.api.a.m r0 = r9.f14181c
            int r0 = r0.a(r6)
            r6 = -100
            if (r0 != r5) goto L27
            r2 = r4
            goto L54
        L27:
            if (r0 != r3) goto L2a
            goto L54
        L2a:
            boolean r2 = r9.aq()
            r3 = 3
            if (r2 == 0) goto L48
            if (r0 != r1) goto L45
            sg.bigo.ads.ad.b.c r0 = r9.C
            java.lang.Integer r0 = sg.bigo.ads.ad.interstitial.s.a(r0)
            if (r0 == 0) goto L40
        L3b:
            int r2 = r0.intValue()
            goto L54
        L40:
            int r2 = sg.bigo.ads.common.utils.q.b(r8, r7)
            goto L54
        L45:
            if (r0 != r3) goto L53
            goto L40
        L48:
            if (r0 != r3) goto L53
            sg.bigo.ads.ad.b.c r0 = r9.C
            java.lang.Integer r0 = sg.bigo.ads.ad.interstitial.s.a(r0)
            if (r0 == 0) goto L40
            goto L3b
        L53:
            r2 = r6
        L54:
            sg.bigo.ads.ad.interstitial.u r0 = r9.Z()
            android.view.ViewGroup r1 = r9.D
            if (r2 == r6) goto L60
            r0.a(r1, r2)
            return
        L60:
            r0.a(r1)
            return
        L64:
            boolean r0 = r9.aq()
            if (r0 == 0) goto Lb3
            sg.bigo.ads.api.a.m r0 = r9.f14181c
            if (r0 == 0) goto Lbc
            int r0 = r0.a(r6)
            if (r0 != r5) goto L7e
            sg.bigo.ads.ad.interstitial.u r0 = r9.Z()
            android.view.ViewGroup r1 = r9.D
            r0.a(r1, r4)
            return
        L7e:
            if (r0 != r3) goto L8a
            sg.bigo.ads.ad.interstitial.u r0 = r9.Z()
            android.view.ViewGroup r1 = r9.D
            r0.a(r1, r2)
            return
        L8a:
            if (r0 != r1) goto L98
            sg.bigo.ads.ad.interstitial.u r0 = r9.Z()
            android.view.ViewGroup r1 = r9.D
            int r2 = r9.m
            r0.a(r1, r2)
            return
        L98:
            r1 = 5
            if (r0 != r1) goto La5
            sg.bigo.ads.ad.interstitial.u r0 = r9.Z()
            android.view.ViewGroup r1 = r9.D
            r0.a(r1)
            return
        La5:
            sg.bigo.ads.ad.interstitial.u r0 = r9.Z()
            android.view.ViewGroup r1 = r9.D
            int r2 = sg.bigo.ads.common.utils.q.b(r8, r7)
            r0.a(r1, r2)
            return
        Lb3:
            sg.bigo.ads.ad.interstitial.u r0 = r9.Z()
            android.view.ViewGroup r1 = r9.D
            r0.a(r1)
        Lbc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.ad.interstitial.a.I():void");
    }

    public final boolean J() {
        sg.bigo.ads.api.a.m mVar = this.f14181c;
        return mVar != null && 1 == mVar.a("endpage.is_endpage", 1);
    }

    public final boolean K() {
        sg.bigo.ads.api.a.m mVar = this.f14181c;
        return (mVar == null || mVar.a("mid_page.show_time") != 0 || J() || af() || this.p.get()) ? false : true;
    }

    public final boolean L() {
        sg.bigo.ads.api.a.m mVar = this.f14181c;
        return (mVar == null || mVar.a("mid_page.show_time") <= 0 || J() || af() || this.p.get()) ? false : true;
    }

    public final boolean M() {
        int iR = R();
        return iR == R.layout.bigo_ad_activity_interstitial_percent_warning || iR == R.layout.bigo_ad_activity_interstitial_percent_warning_landscape;
    }

    @NonNull
    public abstract x b();

    public final int c() {
        synchronized (this.G) {
            try {
                if (this.G.isEmpty()) {
                    return -1;
                }
                return this.G.get(0).intValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final int d() {
        synchronized (this.G) {
            try {
                if (this.G.size() < 2) {
                    return -1;
                }
                return this.G.get(1).intValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e() {
        synchronized (this.N) {
            try {
                WeakHashMap<Object, Runnable> weakHashMapRemove = this.N.remove(1);
                if (!sg.bigo.ads.common.utils.k.a(weakHashMapRemove)) {
                    Iterator<Map.Entry<Object, Runnable>> it = weakHashMapRemove.entrySet().iterator();
                    while (it.hasNext()) {
                        Runnable value = it.next().getValue();
                        if (value != null) {
                            sg.bigo.ads.common.n.d.a(2, value);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void f(int i2) {
        q qVar;
        sg.bigo.ads.ad.b.c cVar;
        sg.bigo.ads.ad.interstitial.e.c cVar2 = this.f14189s;
        if (cVar2 != null) {
            c.a aVar = cVar2.g;
            if (i2 == 0) {
                aVar.f14669a = 1;
            } else if (i2 == 1) {
                aVar.f14669a = 3;
            } else if (i2 == 9) {
                aVar.f14669a = 4;
            } else if (i2 == 10) {
                aVar.f14669a = 2;
            }
        }
        synchronized (this.G) {
            synchronized (this.G) {
                this.G.remove(Integer.valueOf(i2));
            }
            this.G.add(0, Integer.valueOf(i2));
        }
        int iD = d();
        int iC = c();
        if (iC != iD) {
            k(iD);
        }
        sg.bigo.ads.ad.b.c cVar3 = this.C;
        if (cVar3 != null) {
            cVar3.e(i2);
        }
        if (((i2 == 0) | (i2 == 1) | (i2 == 2) | (i2 == 4) | (i2 == 5) | (i2 == 6) | (i2 == 7) | (i2 == 8) | (i2 == 9)) && (cVar = this.C) != null) {
            ((sg.bigo.ads.core.a.a) cVar.f()).b(SystemClock.elapsedRealtime());
        }
        if (i2 != 0 && i2 != 10 && i2 != 3 && (qVar = this.f14188r) != null) {
            qVar.b();
        }
        switch (iC) {
            case 0:
                sg.bigo.ads.ad.interstitial.multi_img.b bVar = this.f14184i;
                if (bVar != null) {
                    bVar.a(1, 1);
                }
                l lVar = this.L;
                lVar.a(lVar.f14822b);
                return;
            case 1:
                sg.bigo.ads.ad.interstitial.multi_img.b bVarD = ((t) this.y).D();
                if (bVarD != null) {
                    bVarD.a(2, 1);
                }
                l lVar2 = this.L;
                lVar2.a(lVar2.f14824d);
                x xVar = this.h;
                if (xVar == null || !xVar.f15197d) {
                    j(R.drawable.bigo_ad_ic_close);
                    return;
                }
                return;
            case 2:
            case 8:
            case 9:
                j(R.drawable.bigo_ad_ic_close);
                l lVar3 = this.L;
                lVar3.a(lVar3.e);
                return;
            case 3:
            case 6:
            default:
                return;
            case 4:
                l lVar4 = this.L;
                lVar4.a(lVar4.g);
                return;
            case 5:
                l lVar5 = this.L;
                lVar5.a(lVar5.f14825f);
                x xVar2 = this.h;
                if (xVar2 == null || !xVar2.f15197d) {
                    j(R.drawable.bigo_ad_ic_close);
                    return;
                }
                return;
            case 7:
                l lVar6 = this.L;
                lVar6.a(lVar6.h);
                x xVar3 = this.h;
                if (xVar3 == null || !xVar3.f15197d) {
                    j(R.drawable.bigo_ad_ic_close);
                    return;
                }
                return;
            case 10:
                l lVar7 = this.L;
                lVar7.a(lVar7.f14823c);
                return;
        }
    }

    public abstract boolean f(boolean z2);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:0x014b  */
    @Override // sg.bigo.ads.ad.interstitial.r, sg.bigo.ads.ad.interstitial.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void g(@androidx.annotation.LayoutRes int r19) {
        /*
            Method dump skipped, instruction units count: 777
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.ad.interstitial.a.g(int):void");
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    public final boolean i() {
        return ad();
    }

    @Override // sg.bigo.ads.ad.interstitial.r, sg.bigo.ads.ad.interstitial.i
    public void j() {
        l lVar;
        sg.bigo.ads.core.a.a aVarF;
        int i2;
        l lVar2;
        sg.bigo.ads.core.a.a aVarF2;
        int i8;
        super.j();
        int iC = c();
        q qVar = this.f14188r;
        if (qVar != null) {
            qVar.d();
        }
        p<t> pVar = this.H;
        if (pVar != null && !pVar.l) {
            p<t>.e eVar = pVar.j;
            if (eVar != null) {
                eVar.f15000a.d();
            }
            p<t>.c cVar = pVar.f14934a;
            if (cVar != null) {
                cVar.f14993b = SystemClock.elapsedRealtime();
            }
            l lVar3 = pVar.p;
            if (lVar3 != null) {
                sg.bigo.ads.api.core.c cVarF = pVar.f14936c.f();
                p.a aVar = pVar.m;
                int i9 = aVar.f14988a;
                int i10 = aVar.f14989b;
                p.a aVar2 = pVar.f14940n;
                lVar3.a(cVarF, lVar3.f14821a, i9, i10, aVar2.f14988a, aVar2.f14989b);
            }
        }
        if (iC == 0) {
            l lVar4 = this.L;
            lVar4.a(((t) this.y).f(), lVar4.f14822b, -1, -1, -1, -1);
        } else {
            if (iC == 10) {
                lVar2 = this.L;
                aVarF2 = ((t) this.y).f();
                i8 = lVar2.f14823c;
            } else {
                if (iC == 1) {
                    lVar = this.L;
                    aVarF = ((t) this.y).f();
                    i2 = lVar.f14824d;
                } else if (iC == 2 || iC == 8 || iC == 9) {
                    lVar = this.L;
                    aVarF = ((t) this.y).f();
                    i2 = lVar.e;
                } else if (iC == 5) {
                    lVar2 = this.L;
                    aVarF2 = ((t) this.y).f();
                    i8 = lVar2.f14825f;
                } else if (iC == 4) {
                    lVar2 = this.L;
                    aVarF2 = ((t) this.y).f();
                    i8 = lVar2.g;
                } else if (iC == 7) {
                    lVar2 = this.L;
                    aVarF2 = ((t) this.y).f();
                    i8 = lVar2.h;
                }
                lVar.a(aVarF, i2, -1, -1, -1, -1);
            }
            lVar2.a(aVarF2, i8, -1, -1, -1, -1);
        }
        sg.bigo.ads.ad.interstitial.e.c cVar2 = this.f14189s;
        if (cVar2 != null) {
            cVar2.f14651n = true;
            sg.bigo.ads.ad.interstitial.e.c.a(cVar2.k, cVar2.f14650i);
            sg.bigo.ads.ad.interstitial.e.c.a(cVar2.j, cVar2.h);
            sg.bigo.ads.common.utils.n nVar = cVar2.l;
            if (nVar != null) {
                nVar.d();
            }
            sg.bigo.ads.common.utils.n nVar2 = cVar2.m;
            if (nVar2 != null) {
                nVar2.d();
            }
        }
        sg.bigo.ads.ad.interstitial.g.a aVar3 = this.f14190t;
        if (aVar3 != null) {
            aVar3.c();
        }
    }

    public final boolean l() {
        if (c() != 0 || !this.P) {
            return false;
        }
        Object objZ = Z();
        if (objZ instanceof sg.bigo.ads.ad.interstitial.f.c) {
            return ((sg.bigo.ads.ad.interstitial.f.c) objZ).K();
        }
        return false;
    }

    @Override // sg.bigo.ads.ad.interstitial.r, sg.bigo.ads.ad.interstitial.i
    @CallSuper
    public void m() {
        super.m();
        this.l = ((t) this.y).f().i();
        sg.bigo.ads.api.a.m mVarE = ((t) this.y).f().e();
        this.f14181c = mVarE;
        if (mVarE != null) {
            this.f14182d = true;
        }
        this.f14180b = ((t) this.y).f().d().q();
        this.h = b();
        sg.bigo.ads.api.a.m mVar = this.f14181c;
        if (mVar == null || !this.f14182d) {
            sg.bigo.ads.api.a.m mVar2 = this.f14180b;
            if (mVar2 != null) {
                a(mVar2);
                return;
            }
            return;
        }
        sg.bigo.ads.ad.interstitial.g.a aVarA = sg.bigo.ads.ad.interstitial.g.a.a(this.I, this.C, mVar, aq());
        this.f14190t = aVarA;
        this.f14189s = new sg.bigo.ads.ad.interstitial.e.c((t) this.y, this.f14181c, aVarA);
        a(this.f14181c);
        this.C.f14035u = new WeakReference<>(this);
    }

    @Override // sg.bigo.ads.ad.interstitial.r
    public final int n() {
        sg.bigo.ads.api.a.m mVar = this.f14181c;
        if (mVar == null) {
            return 0;
        }
        if (this.f14182d) {
            return mVar.a("video_play_page.ad_component_layout");
        }
        return 1;
    }

    @NonNull
    public final h.a o() {
        int i2;
        boolean z2;
        int i8;
        boolean z7;
        int i9;
        sg.bigo.ads.api.a.m mVar = this.f14181c;
        boolean z8 = false;
        if (mVar != null) {
            int iA = this.f14182d ? mVar.a("video_play_page.below_area_dp") : 0;
            boolean z9 = this.f14182d && this.f14181c.a("video_play_page.below_area_clickable") == 1;
            int iA2 = this.f14182d ? this.f14181c.a("video_play_page.up_area_dp") : 0;
            if (this.f14182d && this.f14181c.a("video_play_page.up_area_clickable") == 1) {
                z8 = true;
            }
            int iA3 = this.f14181c.a("video_play_page.click_type");
            int i10 = iA2;
            boolean z10 = z8;
            int i11 = iA;
            a(this.D, i11, z9, i10, z10, 8, iA3);
            i2 = i11;
            z2 = z9;
            i8 = i10;
            z7 = z10;
            i9 = iA3;
        } else {
            i2 = 0;
            z2 = false;
            i8 = 0;
            z7 = false;
            i9 = 0;
        }
        return new h.a(i2, z2, i8, z7, i9);
    }

    public void p() {
        sg.bigo.ads.api.a.m mVar = this.f14181c;
        if (mVar == null || !this.f14182d) {
            return;
        }
        int iA = mVar.a("video_play_page.close_button_style");
        j(iA != 2 ? iA != 3 ? iA != 4 ? iA != 5 ? R.drawable.bigo_ad_ic_close : R.drawable.bigo_ad_ic_close5 : R.drawable.bigo_ad_ic_close4 : R.drawable.bigo_ad_ic_close3 : R.drawable.bigo_ad_ic_close2);
    }

    public void q() {
        int iB;
        if (((t) this.y).f() == null || !((t) this.y).y()) {
            return;
        }
        final sg.bigo.ads.core.a.a aVarF = ((t) this.y).f();
        this.p.set(!aVarF.aZ());
        if (this.p.get() && aVarF.bh() == null && (iB = x.b(this.h.f15200n)) > 0) {
            sg.bigo.ads.common.utils.n nVar = new sg.bigo.ads.common.utils.n(((long) iB) * 1000) { // from class: sg.bigo.ads.ad.interstitial.a.2
                @Override // sg.bigo.ads.common.utils.n
                public final void a() {
                    aVarF.bc();
                    a aVar = a.this;
                    aVar.a(aVar.f14194x, new Runnable() { // from class: sg.bigo.ads.ad.interstitial.a.2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.s();
                        }
                    });
                }

                @Override // sg.bigo.ads.common.utils.n
                public final void a(long j) {
                }
            };
            this.f14194x = nVar;
            nVar.c();
        }
    }

    @CallSuper
    public void r() {
        MediaView mediaView;
        YandexWarningTextView yandexWarningTextView;
        YandexWarningTextView yandexWarningTextView2;
        ViewGroup viewGroup = this.D;
        sg.bigo.ads.ad.b.c cVar = this.C;
        if (viewGroup == null || cVar == null) {
            return;
        }
        sg.bigo.ads.api.c.b.a(aq());
        if (t() && ((t) this.y).f().w() == 2) {
            sg.bigo.ads.api.c.b.a();
        }
        ViewGroup viewGroup2 = this.D;
        if (viewGroup2 != null && (mediaView = (MediaView) viewGroup2.findViewById(R.id.inter_media)) != null && M()) {
            mediaView.setImageBlurBorder(false);
            ViewGroup viewGroup3 = this.D;
            sg.bigo.ads.ad.b.c cVar2 = this.C;
            if (viewGroup3 != null && (yandexWarningTextView = (YandexWarningTextView) viewGroup3.findViewById(R.id.inter_warning)) != null) {
                if (cVar2 == null || ((sg.bigo.ads.core.a.a) cVar2.f()).B() == null || ((sg.bigo.ads.core.a.a) cVar2.f()).B().f() < 0) {
                    yandexWarningTextView2 = yandexWarningTextView;
                } else {
                    int iF = ((sg.bigo.ads.core.a.a) cVar2.f()).B().f();
                    View viewFindViewById = viewGroup3.findViewById(R.id.inter_ad_info_exclude_warning);
                    MediaView mediaView2 = (MediaView) viewGroup3.findViewById(R.id.inter_media);
                    RoundedFrameLayout roundedFrameLayout = (RoundedFrameLayout) viewGroup3.findViewById(R.id.inter_media_layout);
                    float f4 = iF * 0.01f;
                    if (f4 > 0.15f) {
                        f4 = 0.15f;
                    }
                    if (viewFindViewById != null) {
                        yandexWarningTextView.setIsHorizontal(false);
                        sg.bigo.ads.common.utils.u.a(viewFindViewById, new ViewTreeObserver.OnGlobalLayoutListener() { // from class: sg.bigo.ads.ad.interstitial.s.1

                            /* JADX INFO: renamed from: a */
                            final /* synthetic */ View f15120a;

                            /* JADX INFO: renamed from: b */
                            final /* synthetic */ YandexWarningTextView f15121b;

                            /* JADX INFO: renamed from: c */
                            final /* synthetic */ RoundedFrameLayout f15122c;

                            /* JADX INFO: renamed from: d */
                            final /* synthetic */ float f15123d;
                            final /* synthetic */ ViewGroup e;

                            /* JADX INFO: renamed from: f */
                            final /* synthetic */ sg.bigo.ads.ad.b.c f15124f;
                            final /* synthetic */ MediaView g;
                            final /* synthetic */ int h;

                            public AnonymousClass1(View viewFindViewById2, YandexWarningTextView yandexWarningTextView3, RoundedFrameLayout roundedFrameLayout2, float f42, ViewGroup viewGroup32, sg.bigo.ads.ad.b.c cVar22, MediaView mediaView22, int iF2) {
                                view = viewFindViewById2;
                                yandexWarningTextView = yandexWarningTextView3;
                                roundedFrameLayout = roundedFrameLayout2;
                                f = f42;
                                viewGroup = viewGroup32;
                                cVar = cVar22;
                                mediaView = mediaView22;
                                i = iF2;
                            }

                            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                            public final void onGlobalLayout() {
                                int measuredHeight = view.getMeasuredHeight();
                                int iC = sg.bigo.ads.common.utils.e.c(view.getContext());
                                if (measuredHeight <= 0) {
                                    measuredHeight = sg.bigo.ads.common.utils.e.a(view.getContext(), Sdk.SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR_VALUE);
                                }
                                int paddingTop = yandexWarningTextView.getPaddingTop();
                                int paddingBottom = yandexWarningTextView.getPaddingBottom();
                                int iA = sg.bigo.ads.common.utils.e.a(yandexWarningTextView.getContext(), 16);
                                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) yandexWarningTextView.getLayoutParams();
                                int i2 = marginLayoutParams.topMargin;
                                if (iC < 2000) {
                                    iA *= 2;
                                }
                                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) roundedFrameLayout.getLayoutParams();
                                int i8 = marginLayoutParams2.topMargin;
                                int i9 = marginLayoutParams2.bottomMargin;
                                int i10 = marginLayoutParams2.leftMargin;
                                int i11 = marginLayoutParams2.rightMargin;
                                int iRound = Math.round(f * iC) + paddingBottom + paddingTop;
                                int i12 = (((((iC - measuredHeight) - iRound) - i2) - iA) - i8) - i9;
                                if (iC <= 1000) {
                                    i12 = iC / 2;
                                    TextView textView = (TextView) viewGroup.findViewById(R.id.inter_description);
                                    if (textView != null) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
                                        marginLayoutParams3.topMargin = 0;
                                        textView.setLayoutParams(marginLayoutParams3);
                                    }
                                    ViewGroup viewGroup4 = (ViewGroup) viewGroup.findViewById(R.id.bigo_ad_btn_class);
                                    if (viewGroup4 != null) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) viewGroup4.getLayoutParams();
                                        marginLayoutParams4.topMargin = 0;
                                        viewGroup4.setLayoutParams(marginLayoutParams4);
                                    }
                                    TextView textView2 = (TextView) viewGroup.findViewById(R.id.inter_title);
                                    if (textView2 != null) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) textView2.getLayoutParams();
                                        marginLayoutParams5.topMargin = 0;
                                        textView2.setLayoutParams(marginLayoutParams5);
                                    }
                                }
                                int i13 = (view.getContext().getResources().getDisplayMetrics().widthPixels - i10) - i11;
                                sg.bigo.ads.common.p pVarA = s.a(cVar);
                                sg.bigo.ads.common.p pVarA2 = sg.bigo.ads.common.p.a(pVarA.f15849b, pVarA.f15850c, i13, i12);
                                roundedFrameLayout.setCornerRadius(sg.bigo.ads.common.utils.e.a(r1.getContext(), 8));
                                marginLayoutParams2.setMargins(i10, i8, i11, i9);
                                marginLayoutParams2.height = pVarA2.f15850c;
                                marginLayoutParams2.width = pVarA2.f15849b;
                                sg.bigo.ads.common.utils.u.c(mediaView, -1, -1);
                                roundedFrameLayout.setLayoutParams(marginLayoutParams2);
                                if (i == 0) {
                                    yandexWarningTextView.setVisibility(8);
                                    return;
                                }
                                marginLayoutParams.height = iRound;
                                marginLayoutParams.bottomMargin = iA;
                                yandexWarningTextView.setLayoutParams(marginLayoutParams);
                            }
                        });
                    } else {
                        float f8 = f42;
                        yandexWarningTextView2 = yandexWarningTextView3;
                        if (iF2 != 0) {
                            yandexWarningTextView2.setIsHorizontal(true);
                            yandexWarningTextView2.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.s.2

                                /* JADX INFO: renamed from: b */
                                final /* synthetic */ float f15126b;

                                /* JADX INFO: renamed from: c */
                                final /* synthetic */ sg.bigo.ads.ad.b.c f15127c;

                                /* JADX INFO: renamed from: d */
                                final /* synthetic */ RoundedFrameLayout f15128d;
                                final /* synthetic */ MediaView e;

                                public AnonymousClass2(float f82, sg.bigo.ads.ad.b.c cVar22, RoundedFrameLayout roundedFrameLayout2, MediaView mediaView22) {
                                    f = f82;
                                    cVar = cVar22;
                                    roundedFrameLayout = roundedFrameLayout2;
                                    mediaView = mediaView22;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    int iC = sg.bigo.ads.common.utils.e.c(yandexWarningTextView.getContext());
                                    int i2 = yandexWarningTextView.getContext().getResources().getDisplayMetrics().widthPixels;
                                    int iRound = Math.round(f * iC) + yandexWarningTextView.getPaddingBottom() + yandexWarningTextView.getPaddingTop();
                                    ViewGroup.LayoutParams layoutParams = yandexWarningTextView.getLayoutParams();
                                    int iA = sg.bigo.ads.common.utils.e.a(yandexWarningTextView.getContext(), 20);
                                    int i8 = (i2 / 2) - (iA * 3);
                                    sg.bigo.ads.common.p pVarA = s.a(cVar);
                                    roundedFrameLayout.setCornerRadius(sg.bigo.ads.common.utils.e.a(r5.getContext(), 8));
                                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) roundedFrameLayout.getLayoutParams();
                                    marginLayoutParams.setMargins(iA, iA, iA, iA);
                                    if (pVarA.getHeight() <= pVarA.getWidth()) {
                                        marginLayoutParams.width = i8;
                                        marginLayoutParams.height = (int) (((pVarA.getHeight() * 1.0f) * i8) / pVarA.getWidth());
                                        sg.bigo.ads.common.utils.u.c(mediaView, -1, -1);
                                    }
                                    roundedFrameLayout.setLayoutParams(marginLayoutParams);
                                    layoutParams.height = iRound;
                                    yandexWarningTextView.setLayoutParams(layoutParams);
                                }
                            });
                        }
                    }
                }
                yandexWarningTextView2.setVisibility(8);
            }
        }
        Z().a(viewGroup, viewGroup, Y(), S() ? 8 : 1, this.h.f15199i, this.A);
    }

    public boolean t() {
        if (!this.f14182d) {
            return false;
        }
        switch (n()) {
            case 6:
                this.g = false;
                this.f14183f = false;
                if (!aq()) {
                }
                break;
            case 7:
            case 8:
            case 9:
                this.g = false;
                this.f14183f = false;
                break;
            case 10:
                this.g = false;
                this.f14183f = true;
                break;
            case 11:
            case 12:
                this.g = true;
                this.f14183f = false;
                break;
            default:
                this.g = false;
                this.f14183f = false;
                break;
        }
        return false;
    }

    public void u() {
        sg.bigo.ads.api.a.m mVar;
        if (this.f14182d && (mVar = this.f14181c) != null) {
            long jA = ((long) mVar.a("video_play_page.guided_click_gesture_show_time")) * 1000;
            if (jA == 0) {
                return;
            }
            this.f14192v = new AnonymousClass3(jA);
        }
    }

    public final void v() {
        final View viewFindViewById;
        ViewGroup viewGroup = this.D;
        if (viewGroup == null || (viewFindViewById = viewGroup.findViewById(R.id.inter_slide_gesture_contain)) == null) {
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(500L);
        alphaAnimation.setAnimationListener(new b.c() { // from class: sg.bigo.ads.ad.interstitial.c.11
            @Override // sg.bigo.ads.common.utils.b.c, android.view.animation.Animation.AnimationListener
            public final void onAnimationEnd(Animation animation) {
                sg.bigo.ads.common.utils.u.b(viewFindViewById);
            }
        });
        viewFindViewById.startAnimation(alphaAnimation);
        viewFindViewById.setVisibility(8);
    }

    public final void w() {
        View viewFindViewById = this.D.findViewById(R.id.inter_slide_gesture_contain);
        if (viewFindViewById == null) {
            return;
        }
        viewFindViewById.setTag(16);
        viewFindViewById.setOnTouchListener(new View.OnTouchListener() { // from class: sg.bigo.ads.ad.interstitial.a.4
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    a.this.R = (int) motionEvent.getX();
                    a.this.S = (int) motionEvent.getY();
                } else if (action == 1 && a.a(a.this.R, a.this.S, (int) motionEvent.getX(), (int) motionEvent.getY()) > 10.0d) {
                    a.this.v();
                    ((t) a.this.y).f15129z.a((int) motionEvent.getX(), (int) motionEvent.getY(), a.this.R, a.this.S, 8, ((Integer) view.getTag()).intValue());
                }
                return true;
            }
        });
    }

    @CallSuper
    public void x() {
        AdCountDownButton adCountDownButton = this.A;
        if (adCountDownButton == null) {
            return;
        }
        sg.bigo.ads.common.e.a.a(adCountDownButton, this.O);
    }

    public void y() {
        AdCountDownButton adCountDownButton = this.A;
        if (adCountDownButton == null) {
            return;
        }
        if (adCountDownButton.getVisibility() != 0) {
            this.A.setVisibility(0);
            c.b((View) this.A);
        }
        if (c() == 0) {
            int i2 = this.h.f15196c;
            int iB = (i2 >= 0 || ((t) this.y).f().x() == 4) ? i2 : 0;
            if (((t) this.y).y()) {
                sg.bigo.ads.core.a.a aVarF = ((t) this.y).f();
                if (this.p.get() && aVarF.bh() == null) {
                    iB = x.b(this.h.f15200n);
                }
            }
            this.A.a(iB, (AdCountDownButton.b) null);
        }
    }

    public final void z() {
        AdCountDownButton adCountDownButton = this.A;
        if (adCountDownButton == null || adCountDownButton.getVisibility() != 0) {
            return;
        }
        this.A.clearAnimation();
        this.A.setVisibility(4);
    }

    public static boolean i(int i2) {
        return (i2 == 7 || i2 == 8 || i2 == 0) ? false : true;
    }

    @Override // sg.bigo.ads.ad.interstitial.f.b.InterfaceC0266b
    public void d(int i2) {
        this.P = false;
        Runnable runnable = this.Q;
        if (runnable != null) {
            sg.bigo.ads.common.n.d.a(2, runnable);
            this.Q = null;
        } else if (this.B.get()) {
            h();
        }
    }

    public final void e(int i2) {
        ViewGroup viewGroup = this.D;
        if (viewGroup == null) {
            return;
        }
        TextView textView = (TextView) viewGroup.findViewById(R.id.inter_advertiser);
        TextView textView2 = (TextView) this.D.findViewById(R.id.inter_ad_label);
        if (aq()) {
            if (TextUtils.isEmpty(this.l) || textView2 == null || textView2.getContext() == null) {
                return;
            }
            String strA = sg.bigo.ads.common.utils.a.a(textView2.getContext(), R.string.bigo_ad_tag, new Object[0]);
            if (M()) {
                StringBuilder sbX = a1.a.x(strA, " · ");
                sbX.append(this.l);
                textView2.setText(sbX.toString());
                return;
            } else {
                textView2.setText(this.l + " · " + strA);
                return;
            }
        }
        if (textView == null || textView2 == null) {
            return;
        }
        if (TextUtils.isEmpty(this.l)) {
            textView.setVisibility(8);
            return;
        }
        if (!M()) {
            if (i2 != R.layout.bigo_ad_activity_interstitial_native_top) {
                textView.bringToFront();
            }
            textView.setText(this.l);
            textView.setPadding(sg.bigo.ads.common.utils.e.a(this.D.getContext(), 4), sg.bigo.ads.common.utils.e.a(textView.getContext(), 1), sg.bigo.ads.common.utils.e.a(textView.getContext(), 4), sg.bigo.ads.common.utils.e.a(textView.getContext(), 1));
            textView2.setText(R.string.bigo_ad_tag);
            return;
        }
        textView.setVisibility(8);
        textView2.setText(sg.bigo.ads.common.utils.a.a(textView2.getContext(), R.string.bigo_ad_tag, new Object[0]) + " · " + this.l);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // sg.bigo.ads.ad.interstitial.i
    public final boolean f() {
        FrameLayout.LayoutParams layoutParams;
        String str;
        T t3 = this.y;
        byte b8 = 0;
        if (t3 == 0) {
            return false;
        }
        if (((t) t3).f15129z instanceof sg.bigo.ads.ad.b.b) {
            Context context = this.I;
            if (context == null) {
                context = ((t) t3).f15129z.f14024b.e;
            }
            if (context != null) {
                final p<t> pVar = new p<>((sg.bigo.ads.ad.b.b) ((t) t3).f15129z, this, new p.b() { // from class: sg.bigo.ads.ad.interstitial.a.9
                    @Override // sg.bigo.ads.ad.interstitial.p.b
                    public final void a(@Nullable sg.bigo.ads.ad.b.d dVar) {
                        if (dVar == null) {
                            a.this.ap();
                            return;
                        }
                        t tVar = (t) a.this.y;
                        t.b bVar = tVar.C;
                        if (bVar != null) {
                            tVar.f15129z = dVar;
                            Map<NativeAd, Pair<sg.bigo.ads.ad.interstitial.a.b, sg.bigo.ads.ad.interstitial.a.a>> map = bVar.f15136a;
                            Pair<sg.bigo.ads.ad.interstitial.a.b, sg.bigo.ads.ad.interstitial.a.a> pair = map == null ? null : map.get(dVar);
                            if (pair != null) {
                                tVar.A = (sg.bigo.ads.ad.interstitial.a.b) pair.first;
                                tVar.B = (sg.bigo.ads.ad.interstitial.a.a) pair.second;
                            }
                        }
                        a aVar = a.this;
                        aVar.C = dVar;
                        aVar.Q();
                    }
                });
                this.H = pVar;
                pVar.p = this.L;
                ViewGroup viewGroup = (ViewGroup) pVar.f14935b.o(R.id.inter_container);
                if (viewGroup == null) {
                    sg.bigo.ads.common.t.a.a(0, "InterstitialDoubleVideoRenderer", "Failed to start with null container.");
                    str = "Error container";
                } else {
                    final sg.bigo.ads.api.a.m mVar = pVar.f14937d;
                    if (mVar != null) {
                        List<sg.bigo.ads.ad.b.d> listX = pVar.f14936c.x();
                        if (listX == null || listX.size() == 0) {
                            sg.bigo.ads.common.t.a.a(0, "InterstitialDoubleVideoRenderer", "Failed to start with null ready video list.");
                            pVar.e.a(null);
                            p.c.a("Error native videos");
                        } else {
                            b.a aVar = pVar.f14936c.f13878z;
                            String[] strArr = aVar != null ? aVar.e : new String[]{"", ""};
                            if (listX.size() == 1) {
                                sg.bigo.ads.ad.b.d dVar = listX.get(0);
                                sg.bigo.ads.ad.b.b bVar = pVar.f14936c;
                                pVar.a(false, null, dVar, dVar == bVar.f13877x ? 1 : dVar == bVar.y ? 2 : 0, false, true);
                                return true;
                            }
                            boolean z2 = pVar.f14937d.a("multi_ads.page_layout") == 2;
                            final Context context2 = pVar.f14935b.y.f14024b.e;
                            FrameLayout frameLayout = new FrameLayout(context2);
                            pVar.f14938f = frameLayout;
                            viewGroup.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
                            View view = new View(context2);
                            sg.bigo.ads.ad.b.d dVar2 = listX.get(0);
                            sg.bigo.ads.ad.b.d dVar3 = listX.get(1);
                            Integer numF = dVar2.F();
                            Integer numF2 = dVar3.F();
                            if (numF == null) {
                                numF = Integer.valueOf(sg.bigo.ads.common.utils.q.b("#01B5FF", -16776961));
                            }
                            if (numF2 == null) {
                                numF2 = Integer.valueOf(sg.bigo.ads.common.utils.q.b("#FF0054", SupportMenu.CATEGORY_MASK));
                            }
                            p.d dVar4 = new p.d(b8);
                            pVar.k = dVar4;
                            GradientDrawable gradientDrawable = new GradientDrawable();
                            gradientDrawable.setGradientType(0);
                            gradientDrawable.setColors(new int[]{numF.intValue(), numF2.intValue()});
                            gradientDrawable.setOrientation(GradientDrawable.Orientation.BR_TL);
                            gradientDrawable.setGradientCenter(0.0f, 0.0f);
                            dVar4.f14998c = numF;
                            dVar4.f14999d = numF2;
                            dVar4.f14997b = gradientDrawable;
                            view.setBackground(gradientDrawable);
                            pVar.f14942q = view;
                            frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
                            LinearLayout linearLayout = new LinearLayout(context2);
                            linearLayout.setOrientation(1);
                            frameLayout.addView(linearLayout);
                            FrameLayout frameLayout2 = new FrameLayout(context2);
                            linearLayout.addView(frameLayout2, new LinearLayout.LayoutParams(-1, sg.bigo.ads.common.utils.e.a(context2, z2 ? 32 : 50)));
                            if (!z2) {
                                RoundedFrameLayout roundedFrameLayout = new RoundedFrameLayout(context2);
                                roundedFrameLayout.setCornerRadius(sg.bigo.ads.common.utils.e.a(context2, 16));
                                roundedFrameLayout.setStrokeWidth(sg.bigo.ads.common.utils.e.a(context2, 1) * 1.5f);
                                roundedFrameLayout.setStrokeColor(sg.bigo.ads.common.utils.q.b("#7FFFFFFF", -1));
                                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, sg.bigo.ads.common.utils.e.a(context2, 25), 21);
                                layoutParams2.rightMargin = sg.bigo.ads.common.utils.e.a(context2, 10);
                                frameLayout2.addView(roundedFrameLayout, layoutParams2);
                                FrameLayout frameLayout3 = new FrameLayout(context2);
                                frameLayout3.setBackgroundColor(sg.bigo.ads.common.utils.q.b("#1C000000", -7829368));
                                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -1);
                                int iA = sg.bigo.ads.common.utils.e.a(context2, 2);
                                layoutParams3.setMargins(iA, iA, iA, iA);
                                roundedFrameLayout.addView(frameLayout3, layoutParams3);
                                TextView textView = new TextView(context2);
                                textView.setTextColor(-1);
                                textView.setTextSize(14.0f);
                                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2, 17);
                                layoutParams4.leftMargin = sg.bigo.ads.common.utils.e.a(context2, 12);
                                layoutParams4.rightMargin = sg.bigo.ads.common.utils.e.a(context2, 12);
                                frameLayout3.addView(textView, layoutParams4);
                                pVar.g = textView;
                            }
                            final RoundedFrameLayout roundedFrameLayout2 = new RoundedFrameLayout(context2);
                            roundedFrameLayout2.setCornerRadius(sg.bigo.ads.common.utils.e.a(context2, 6));
                            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -1, 1.0f);
                            layoutParams5.leftMargin = sg.bigo.ads.common.utils.e.a(context2, 10);
                            layoutParams5.rightMargin = sg.bigo.ads.common.utils.e.a(context2, 10);
                            linearLayout.addView(roundedFrameLayout2, layoutParams5);
                            pVar.h = roundedFrameLayout2;
                            pVar.a(context2, roundedFrameLayout2, listX.get(0), strArr[0], pVar.m);
                            FrameLayout frameLayout4 = new FrameLayout(context2);
                            linearLayout.addView(frameLayout4, new LinearLayout.LayoutParams(-1, sg.bigo.ads.common.utils.e.a(context2, z2 ? 80 : 64)));
                            TextView textView2 = new TextView(context2);
                            textView2.setTextColor(-1);
                            textView2.setTextSize(20.0f);
                            textView2.setTypeface(Typeface.defaultFromStyle(1));
                            textView2.setSingleLine(true);
                            textView2.setText(R.string.bigo_ad_double_video_choose_video);
                            if (z2) {
                                layoutParams = new FrameLayout.LayoutParams(-2, -2, 49);
                                layoutParams.topMargin = sg.bigo.ads.common.utils.e.a(context2, 16);
                                frameLayout4.addView(textView2, layoutParams);
                                TextView textView3 = new TextView(context2);
                                textView3.setTextColor(sg.bigo.ads.common.utils.q.b("#C8FFFFFF", -1));
                                textView3.setTextSize(13.0f);
                                FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-2, -2, 81);
                                layoutParams6.bottomMargin = sg.bigo.ads.common.utils.e.a(context2, 18);
                                frameLayout4.addView(textView3, layoutParams6);
                                pVar.g = textView3;
                            } else {
                                layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
                                frameLayout4.addView(textView2, layoutParams);
                            }
                            final RoundedFrameLayout roundedFrameLayout3 = new RoundedFrameLayout(context2);
                            roundedFrameLayout3.setCornerRadius(sg.bigo.ads.common.utils.e.a(context2, 6));
                            LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -1, 1.0f);
                            layoutParams7.leftMargin = sg.bigo.ads.common.utils.e.a(context2, 10);
                            layoutParams7.rightMargin = sg.bigo.ads.common.utils.e.a(context2, 10);
                            linearLayout.addView(roundedFrameLayout3, layoutParams7);
                            pVar.f14939i = roundedFrameLayout3;
                            pVar.a(context2, roundedFrameLayout3, listX.get(1), strArr[1], pVar.f14940n);
                            linearLayout.addView(new FrameLayout(context2), new LinearLayout.LayoutParams(-1, sg.bigo.ads.common.utils.e.a(context2, 32)));
                            roundedFrameLayout2.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.p.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    sg.bigo.ads.ad.interstitial.c.a(roundedFrameLayout2, -sg.bigo.ads.common.utils.e.a(context2, 40));
                                }
                            });
                            roundedFrameLayout3.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.p.4
                                @Override // java.lang.Runnable
                                public final void run() {
                                    sg.bigo.ads.ad.interstitial.c.a(roundedFrameLayout3, sg.bigo.ads.common.utils.e.a(context2, 40));
                                }
                            });
                            sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.ad.interstitial.p.5
                                @Override // java.lang.Runnable
                                public final void run() {
                                    int iA2 = mVar.a("multi_ads.auto_play_time");
                                    int i2 = iA2 != 1 ? iA2 == 2 ? 5 : iA2 == 3 ? 10 : 15 : 3;
                                    p pVar2 = p.this;
                                    pVar2.j = new e(i2);
                                    p.this.j.f15000a.c();
                                }
                            });
                            p<t>.c cVar = pVar.f14934a;
                            sg.bigo.ads.ad.b.d dVar5 = pVar.f14936c.f13877x;
                            cVar.f14992a = SystemClock.elapsedRealtime();
                            sg.bigo.ads.core.a.a aVar2 = dVar5 == null ? null : (sg.bigo.ads.core.a.a) dVar5.f();
                            p pVar2 = p.this;
                            p.a aVar3 = pVar2.m;
                            int i2 = aVar3.f14988a;
                            int i8 = aVar3.f14989b;
                            p.a aVar4 = pVar2.f14940n;
                            sg.bigo.ads.core.d.b.a(aVar2, true, 1, 0, false, -1L, i2, i8, -1L, aVar4.f14988a, aVar4.f14989b, -1L);
                            l lVar = pVar.p;
                            if (lVar != null) {
                                lVar.a(lVar.f14821a);
                            }
                        }
                        return true;
                    }
                    sg.bigo.ads.common.t.a.a(0, "InterstitialDoubleVideoRenderer", "Failed to start with null style config.");
                    str = "Error style config";
                }
                p.c.a(str);
                pVar.e.a(null);
                return true;
            }
        }
        return false;
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    public final boolean g() {
        return ad();
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    @Override // sg.bigo.ads.ad.interstitial.r, sg.bigo.ads.ad.interstitial.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void h() {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.ad.interstitial.a.h():void");
    }

    public final boolean k() {
        Object objZ = Z();
        if (objZ instanceof sg.bigo.ads.ad.interstitial.f.c) {
            return ((sg.bigo.ads.ad.interstitial.f.c) objZ).J();
        }
        return false;
    }

    @Override // sg.bigo.ads.ad.c.a
    public LandingPageStyleConfig a(Context context, String str, int i2, boolean z2) {
        LandingPageStyleConfig landingPageStyleConfig;
        q qVar;
        sg.bigo.ads.api.a.m mVar = null;
        mVar = null;
        sg.bigo.ads.api.a.m mVar2 = null;
        LandingPageStyleConfig landingPageStyleConfigAe = null;
        mVar = null;
        if (z2) {
            int iC = c();
            if (iC == 0) {
                u uVarZ = Z();
                sg.bigo.ads.api.a.m mVar3 = this.f14181c;
                if (mVar3 == null || !this.f14182d) {
                    mVar3 = null;
                }
                int iA = sg.bigo.ads.ad.interstitial.d.a.a(uVarZ, mVar3);
                if (i(iA)) {
                    return null;
                }
                return new LandingPageStyleConfig(h(iA), 0, iA, sg.bigo.ads.ad.interstitial.d.a.b(uVarZ, mVar3), 0, 0, 0.0f);
            }
            if (iC == 9) {
                sg.bigo.ads.api.a.m mVar4 = this.f14181c;
                if (mVar4 == null || !this.f14182d) {
                    mVar4 = null;
                }
                int iA2 = sg.bigo.ads.ad.interstitial.g.a.a(mVar4);
                if (i(iA2)) {
                    return null;
                }
                return new LandingPageStyleConfig(h(iA2), 9, iA2, sg.bigo.ads.ad.interstitial.g.a.b(mVar4), 0, 0, 0.0f);
            }
            if (iC != 10) {
                return null;
            }
            sg.bigo.ads.api.a.m mVar5 = this.f14181c;
            if (mVar5 == null || !this.f14182d) {
                mVar5 = null;
            }
            int iA3 = sg.bigo.ads.ad.interstitial.d.a.a(mVar5, "layer.webview_layout");
            if (i(iA3)) {
                return null;
            }
            return new LandingPageStyleConfig(h(iA3), 10, iA3, sg.bigo.ads.ad.interstitial.d.a.b(mVar5, "layer.webview_force_time"), 0, 0, 0.0f);
        }
        int iC2 = c();
        if (iC2 != 0) {
            if (iC2 == 9) {
                landingPageStyleConfigAe = ae();
            } else if (iC2 == 10) {
                sg.bigo.ads.api.a.m mVar6 = this.f14181c;
                if (mVar6 != null && this.f14182d) {
                    mVar2 = mVar6;
                }
                int iA4 = sg.bigo.ads.ad.interstitial.d.a.a(mVar2, "layer.webview_layout");
                int iB = sg.bigo.ads.ad.interstitial.d.a.b(mVar2, "layer.webview_force_time");
                Class<? extends sg.bigo.ads.controller.landing.c> clsH = h(iA4);
                ViewGroup viewGroup = this.D;
                landingPageStyleConfig = new LandingPageStyleConfig(clsH, 10, iA4, iB, viewGroup != null ? viewGroup.getMeasuredHeight() : 0, s.a(this.C, 0), 0.8f);
                if (!landingPageStyleConfig.b() && (qVar = this.f14188r) != null) {
                    qVar.e();
                }
            }
            sg.bigo.ads.ad.interstitial.f.b.a(landingPageStyleConfigAe);
            return landingPageStyleConfigAe;
        }
        u uVarZ2 = Z();
        sg.bigo.ads.api.a.m mVar7 = this.f14181c;
        if (mVar7 != null && this.f14182d) {
            mVar = mVar7;
        }
        int iA5 = sg.bigo.ads.ad.interstitial.d.a.a(uVarZ2, mVar);
        int iB2 = sg.bigo.ads.ad.interstitial.d.a.b(uVarZ2, mVar);
        float f4 = sg.bigo.ads.ad.interstitial.d.a.a(uVarZ2) ? 0.67f : 0.8f;
        Class<? extends sg.bigo.ads.controller.landing.c> clsH2 = h(iA5);
        ViewGroup viewGroup2 = this.D;
        landingPageStyleConfig = new LandingPageStyleConfig(clsH2, 0, iA5, iB2, viewGroup2 != null ? viewGroup2.getMeasuredHeight() : 0, s.a(this.C, 0), f4);
        landingPageStyleConfigAe = landingPageStyleConfig;
        sg.bigo.ads.ad.interstitial.f.b.a(landingPageStyleConfigAe);
        return landingPageStyleConfigAe;
    }

    @Override // sg.bigo.ads.ad.interstitial.f.b.InterfaceC0266b
    public final void b(int i2) {
        if (c() == 0 && i2 == 0 && k() && !l() && this.P && this.B.get()) {
            h();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.f.b.InterfaceC0266b
    public final void c(int i2) {
        if (c() == 0 && i2 == 0 && k() && !l() && this.P && !this.B.get()) {
            j();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    public final void d(boolean z2) {
        AdCountDownButton adCountDownButton = this.A;
        if (adCountDownButton == null || (adCountDownButton.getVisibility() == 0 && this.A.f14166c)) {
            e(z2);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.f.b.InterfaceC0266b
    @CallSuper
    public void a(int i2) {
        this.P = true;
    }

    public void b(boolean z2) {
        sg.bigo.ads.common.utils.n nVar;
        sg.bigo.ads.common.utils.n nVar2 = this.f14192v;
        if (nVar2 != null) {
            nVar2.b();
            this.f14192v = null;
        }
        sg.bigo.ads.common.utils.n nVar3 = this.f14191u;
        if (nVar3 != null) {
            nVar3.b();
            this.f14191u = null;
        }
        if (z2 && (nVar = this.f14193w) != null) {
            nVar.b();
            this.f14193w = null;
        }
        sg.bigo.ads.common.utils.n nVar4 = this.f14194x;
        if (nVar4 != null) {
            nVar4.b();
            this.f14194x = null;
        }
    }

    @CallSuper
    public void c(boolean z2) {
        if (z2) {
            U();
        } else {
            V();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.f.b.InterfaceC0266b
    public final void a(int i2, int i8, int i9, int i10, int i11) {
        if (c() == c() && i11 == 0) {
            Object objZ = Z();
            if (objZ instanceof sg.bigo.ads.ad.interstitial.f.c) {
                sg.bigo.ads.ad.interstitial.f.c cVar = (sg.bigo.ads.ad.interstitial.f.c) objZ;
                cVar.a(i2, i8, i9, i10);
                if (cVar.K() && this.P && !this.B.get()) {
                    j();
                }
            }
        }
    }

    public final void b(Object... objArr) {
        if (objArr.length == 0) {
            return;
        }
        synchronized (this.M) {
            try {
                for (Object obj : objArr) {
                    if (obj != null) {
                        this.M.remove(obj);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(Object... objArr) {
        if (objArr.length == 0) {
            return;
        }
        synchronized (this.N) {
            try {
                WeakHashMap<Object, Runnable> weakHashMap = this.N.get(1);
                if (!sg.bigo.ads.common.utils.k.a(weakHashMap)) {
                    for (Object obj : objArr) {
                        if (obj != null) {
                            weakHashMap.remove(obj);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a(long j) {
        if (j <= 0) {
            y();
            return;
        }
        z();
        this.k.removeCallbacks(this.T);
        this.k.postDelayed(this.T, j);
    }

    public final void a(View view) {
        sg.bigo.ads.ad.interstitial.e.c cVar = this.f14189s;
        if (cVar == null || !(view instanceof ViewGroup)) {
            return;
        }
        sg.bigo.ads.ad.interstitial.e.c.a(cVar.j, cVar.h);
        final sg.bigo.ads.ad.interstitial.e.c cVar2 = this.f14189s;
        final ViewGroup viewGroup = (ViewGroup) view;
        cVar2.p = false;
        sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) cVar2.f14645a.f(), 2);
        if (sg.bigo.ads.ad.interstitial.e.a.b.b(cVar2.f14647c)) {
            cVar2.a(cVar2.f14647c, "config is invalid", 2);
            return;
        }
        if (!cVar2.a(2)) {
            cVar2.a(cVar2.f14647c, "icon request hasScene return false", 2);
            return;
        }
        cVar2.c();
        sg.bigo.ads.ad.interstitial.e.a aVar = cVar2.k;
        if (aVar != null) {
            aVar.f14627b.d();
            sg.bigo.ads.common.utils.u.b(cVar2.k.f14626a);
        }
        cVar2.k = null;
        c.b bVar = new c.b(viewGroup, cVar2.f14647c) { // from class: sg.bigo.ads.ad.interstitial.e.c.4
            private boolean e = false;

            {
                byte b8 = 0;
            }

            @Override // sg.bigo.ads.ad.interstitial.e.c.b
            public final void a(sg.bigo.ads.ad.interstitial.e.a aVar2) {
                sg.bigo.ads.ad.interstitial.g.a aVar3;
                RealtimeBlurLinearLayout realtimeBlurLinearLayout;
                super.a(aVar2);
                if (!this.e || (aVar3 = c.this.f14648d) == null || (realtimeBlurLinearLayout = aVar2.f14626a) == null) {
                    return;
                }
                aVar3.a(realtimeBlurLinearLayout);
            }

            /* JADX WARN: Removed duplicated region for block: B:39:0x00fd  */
            @Override // sg.bigo.ads.ad.interstitial.e.c.b
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final boolean a() {
                /*
                    Method dump skipped, instruction units count: 264
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.ad.interstitial.e.c.AnonymousClass4.a():boolean");
            }
        };
        cVar2.f14650i = bVar;
        bVar.d();
    }

    public final void a(@NonNull View view, int i2, @Nullable sg.bigo.ads.core.adview.h hVar, int i8) {
        ViewGroup viewGroup = this.D;
        if (viewGroup == null) {
            sg.bigo.ads.common.t.a.a(0, "InterstitialNativeActivityImpl", "Failed to set ad click due to native ad view is null.");
        } else {
            sg.bigo.ads.ad.b.a.a(viewGroup, view, i2, hVar, i8);
        }
    }

    public final void e(boolean z2) {
        if (f(z2)) {
            k(c());
            super.d(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(final android.view.View r7, int r8, boolean r9, int r10, boolean r11, int r12, int r13) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof android.widget.FrameLayout
            if (r0 != 0) goto L11
            boolean r0 = r7 instanceof android.widget.RelativeLayout
            if (r0 != 0) goto L11
            java.lang.String r7 = "Failed to update up or below area click due to unsupported view."
            r8 = 0
            java.lang.String r9 = "InterstitialNativeActivityImpl"
            sg.bigo.ads.common.t.a.a(r8, r9, r7)
            return
        L11:
            r0 = r7
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            android.content.Context r1 = r7.getContext()
            if (r1 != 0) goto L1c
            goto Lbf
        L1c:
            r2 = -1
            if (r8 <= 0) goto L72
            android.view.View r3 = new android.view.View
            r3.<init>(r1)
            int r4 = sg.bigo.ads.R.id.bigo_ad_interstitial_below_area_click
            r3.setId(r4)
            r4 = 25
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3.setTag(r4)
            boolean r4 = r0 instanceof android.widget.FrameLayout
            if (r4 == 0) goto L45
            android.widget.FrameLayout$LayoutParams r4 = new android.widget.FrameLayout$LayoutParams
            int r8 = sg.bigo.ads.common.utils.e.a(r1, r8)
            r5 = 80
            r4.<init>(r2, r8, r5)
        L41:
            r0.addView(r3, r4)
            goto L58
        L45:
            boolean r4 = r0 instanceof android.widget.RelativeLayout
            if (r4 == 0) goto L58
            android.widget.RelativeLayout$LayoutParams r4 = new android.widget.RelativeLayout$LayoutParams
            int r8 = sg.bigo.ads.common.utils.e.a(r1, r8)
            r4.<init>(r2, r8)
            r8 = 12
            r4.addRule(r8)
            goto L41
        L58:
            android.view.ViewGroup r8 = r6.D
            if (r9 == 0) goto L68
            if (r8 == 0) goto L72
            T extends sg.bigo.ads.ad.interstitial.k<?> r8 = r6.y
            sg.bigo.ads.ad.interstitial.t r8 = (sg.bigo.ads.ad.interstitial.t) r8
            sg.bigo.ads.ad.b.c r8 = r8.f15129z
            r6.a(r3, r12, r8, r13)
            goto L72
        L68:
            if (r8 == 0) goto L72
            sg.bigo.ads.ad.interstitial.a$7 r9 = new sg.bigo.ads.ad.interstitial.a$7
            r9.<init>()
            sg.bigo.ads.ad.b.a.a(r8, r3, r12, r9, r13)
        L72:
            if (r10 <= 0) goto Lbf
            android.view.View r8 = new android.view.View
            r8.<init>(r1)
            r9 = 24
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r8.setTag(r9)
            boolean r9 = r0 instanceof android.widget.FrameLayout
            if (r9 == 0) goto L93
            android.widget.FrameLayout$LayoutParams r9 = new android.widget.FrameLayout$LayoutParams
            int r10 = sg.bigo.ads.common.utils.e.a(r1, r10)
            r9.<init>(r2, r10)
        L8f:
            r0.addView(r8, r9)
            goto La1
        L93:
            boolean r9 = r0 instanceof android.widget.RelativeLayout
            if (r9 == 0) goto La1
            android.widget.RelativeLayout$LayoutParams r9 = new android.widget.RelativeLayout$LayoutParams
            int r10 = sg.bigo.ads.common.utils.e.a(r1, r10)
            r9.<init>(r2, r10)
            goto L8f
        La1:
            if (r11 == 0) goto Lb1
            android.view.ViewGroup r7 = r6.D
            if (r7 == 0) goto Lbf
            T extends sg.bigo.ads.ad.interstitial.k<?> r7 = r6.y
            sg.bigo.ads.ad.interstitial.t r7 = (sg.bigo.ads.ad.interstitial.t) r7
            sg.bigo.ads.ad.b.c r7 = r7.f15129z
            r6.a(r8, r12, r7, r13)
            return
        Lb1:
            sg.bigo.ads.ad.b.c r9 = r6.C
            if (r9 == 0) goto Lbf
            android.view.ViewGroup r9 = r6.D
            sg.bigo.ads.ad.interstitial.a$8 r10 = new sg.bigo.ads.ad.interstitial.a$8
            r10.<init>()
            sg.bigo.ads.ad.b.a.a(r9, r8, r12, r10, r13)
        Lbf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.ad.interstitial.a.a(android.view.View, int, boolean, int, boolean, int, int):void");
    }

    public void a(@NonNull ViewGroup viewGroup) {
        MediaView mediaView = (MediaView) viewGroup.findViewById(R.id.inter_media);
        if (mediaView != null) {
            mediaView.setTag(5);
        }
        if (this.h.f15194a) {
            viewGroup.setTag(11);
            a(viewGroup, 1, ((t) this.y).f15129z, this.h.f15199i);
            if (mediaView != null) {
                mediaView.b().a(false);
                return;
            }
            return;
        }
        if (!this.f14182d) {
            a(viewGroup, 8, (sg.bigo.ads.core.adview.h) null, 0);
            return;
        }
        if (!(Z() instanceof sg.bigo.ads.ad.interstitial.d.a) && mediaView != null) {
            a(mediaView, 8, ((t) this.y).f15129z, this.h.f15199i);
            if (this.h.f15198f) {
                mediaView.setMediaAreaClickable(true);
                mediaView.b().a(false);
            } else {
                mediaView.setMediaAreaClickable(false);
                mediaView.b().a(true);
            }
        }
        if (!(Z() instanceof sg.bigo.ads.ad.interstitial.d.a)) {
            View viewFindViewById = viewGroup.findViewById(R.id.inter_media_container);
            if (t()) {
                viewFindViewById = viewGroup.findViewById(R.id.inter_media_layout);
            }
            if (viewFindViewById != null) {
                viewFindViewById.setTag(9);
                if (this.h.g) {
                    if (mediaView != null) {
                        mediaView.setOtherClickAreaClick(true);
                    }
                    a(viewFindViewById, 8, ((t) this.y).f15129z, this.h.f15199i);
                } else {
                    if (mediaView != null) {
                        mediaView.setOtherClickAreaClick(false);
                    }
                    a(viewFindViewById, 8, r.F, 0);
                }
            }
        }
        if (Z() instanceof sg.bigo.ads.ad.interstitial.d.a) {
            return;
        }
        View viewFindViewById2 = viewGroup.findViewById(R.id.inter_ad_info);
        if (M() && aq()) {
            viewFindViewById2 = viewGroup.findViewById(R.id.inter_ad_info_inner);
        }
        if (viewFindViewById2 != null) {
            viewFindViewById2.setTag(18);
            if (t()) {
                viewFindViewById2 = viewGroup.findViewById(R.id.inter_media_container);
                viewFindViewById2.setTag(18);
            }
            x xVar = this.h;
            if (xVar.h) {
                a(viewFindViewById2, 8, ((t) this.y).f15129z, xVar.f15199i);
            } else {
                a(viewFindViewById2, 8, r.F, 0);
            }
        }
    }

    private void a(sg.bigo.ads.api.a.m mVar) {
        if (mVar == null) {
            return;
        }
        this.f14184i = ((t) this.y).C();
        sg.bigo.ads.core.a.a aVarF = ((t) this.y).f();
        this.j = new f(mVar.a("video_play_page.gp_element"), mVar.a("video_play_page.gp_force_time"), aVarF != null ? aVarF.n() : "");
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0094, code lost:
    
        if (r11 == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00aa, code lost:
    
        if (r11 == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b0, code lost:
    
        if (r8 == false) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r11) {
        /*
            Method dump skipped, instruction units count: 354
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.ad.interstitial.a.a(boolean):void");
    }

    public final void a(Object... objArr) {
        if (objArr.length == 0) {
            return;
        }
        synchronized (this.M) {
            try {
                for (Object obj : objArr) {
                    if (obj != null) {
                        this.M.put(obj, 1);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // sg.bigo.ads.ad.c.a
    public final boolean a() {
        return this.P;
    }

    @Override // sg.bigo.ads.ad.interstitial.f.b.InterfaceC0266b
    public boolean a(@NonNull MotionEvent motionEvent, @Nullable b.a aVar, int i2) {
        boolean zB;
        AdCountDownButton adCountDownButton = this.A;
        boolean z2 = false;
        if (adCountDownButton != null) {
            if (motionEvent == null || adCountDownButton.f14168f == null) {
                zB = false;
            } else {
                zB = sg.bigo.ads.common.utils.u.b(adCountDownButton.f14168f, (int) motionEvent.getRawX(), (int) motionEvent.getRawY());
            }
            if (zB) {
                if (motionEvent.getAction() == 1) {
                    if (aVar != null && aVar.a()) {
                        z2 = true;
                    }
                    if (z2 && this.Q == null) {
                        if (this.P) {
                            this.Q = new Runnable() { // from class: sg.bigo.ads.ad.interstitial.a.10
                                @Override // java.lang.Runnable
                                public final void run() {
                                    AdCountDownButton adCountDownButton2 = a.this.A;
                                    if (adCountDownButton2 != null) {
                                        adCountDownButton2.a();
                                    }
                                }
                            };
                        } else {
                            AdCountDownButton adCountDownButton2 = this.A;
                            if (adCountDownButton2 != null) {
                                adCountDownButton2.a();
                            }
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final boolean a(Object obj, Runnable runnable) {
        Integer num;
        if (obj == null || runnable == null) {
            return false;
        }
        synchronized (this.M) {
            num = this.M.get(obj);
        }
        if (num == null) {
            runnable.run();
            return false;
        }
        synchronized (this.N) {
            try {
                WeakHashMap<Object, Runnable> weakHashMap = this.N.get(num);
                if (weakHashMap == null) {
                    weakHashMap = new WeakHashMap<>();
                    this.N.put(num, weakHashMap);
                }
                weakHashMap.put(obj, runnable);
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }

    public void s() {
    }
}
