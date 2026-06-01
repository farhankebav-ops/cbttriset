package sg.bigo.ads.ad.interstitial;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.a.b;
import sg.bigo.ads.ad.interstitial.a.b.c;
import sg.bigo.ads.ad.interstitial.b.a;
import sg.bigo.ads.ad.interstitial.e;
import sg.bigo.ads.ad.interstitial.f.b;
import sg.bigo.ads.ad.interstitial.multi_img.view.IconListView;
import sg.bigo.ads.ad.interstitial.q;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.VideoController;
import sg.bigo.ads.api.core.c;
import sg.bigo.ads.common.utils.b;
import sg.bigo.ads.common.view.RoundedFrameLayout;
import sg.bigo.ads.controller.landing.LandingPageStyleConfig;

/* JADX INFO: loaded from: classes6.dex */
public class z extends sg.bigo.ads.ad.interstitial.a implements a.InterfaceC0249a, VideoController.a {
    public final sg.bigo.ads.ad.interstitial.b.a G;
    private boolean H;
    private boolean L;
    private int M;
    private boolean N;
    private boolean O;
    private Runnable P;
    private Runnable Q;
    private int R;

    @Nullable
    private sg.bigo.ads.ad.interstitial.c.a S;
    private final AtomicBoolean T;
    private boolean U;
    private boolean V;
    private volatile boolean W;
    private final Runnable X;
    private final b Y;

    /* JADX INFO: renamed from: sg.bigo.ads.ad.interstitial.z$18, reason: invalid class name */
    public class AnonymousClass18 extends sg.bigo.ads.common.utils.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f15229a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass18(long j, View view) {
            super(j, 1000L);
            this.f15229a = view;
        }

        @Override // sg.bigo.ads.common.utils.n
        public final void a() {
            z zVar = z.this;
            zVar.a(zVar.f14191u, new Runnable() { // from class: sg.bigo.ads.ad.interstitial.z.18.1
                @Override // java.lang.Runnable
                public final void run() {
                    z.e(z.this);
                    AnonymousClass18.this.f15229a.setVisibility(0);
                    c.a(AnonymousClass18.this.f15229a, new b.c() { // from class: sg.bigo.ads.ad.interstitial.z.18.1.1
                        @Override // sg.bigo.ads.common.utils.b.c, android.view.animation.Animation.AnimationListener
                        public final void onAnimationEnd(Animation animation) {
                            AnonymousClass18 anonymousClass18 = AnonymousClass18.this;
                            if (z.this.E == null || anonymousClass18.f15229a.getTop() <= 0 || z.this.E.getBottom() <= AnonymousClass18.this.f15229a.getTop()) {
                                return;
                            }
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) z.this.E.getLayoutParams();
                            layoutParams.addRule(8, 0);
                            layoutParams.addRule(2, R.id.inter_ad_info);
                            z.this.E.setLayoutParams(layoutParams);
                        }
                    });
                    z.this.E();
                    z.this.at();
                }
            });
        }

        @Override // sg.bigo.ads.common.utils.n
        public final void a(long j) {
        }
    }

    public class a implements sg.bigo.ads.ad.banner.h {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f15251b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f15252c = 9;

        public a(int i2) {
            this.f15251b = i2;
        }

        @Override // sg.bigo.ads.ad.banner.h
        public final void a() {
            if (z.this.c() == 5 || z.this.c() == 1 || z.this.c() == 7 || z.this.c() == 8) {
                z.this.e(true);
            }
        }

        @Override // sg.bigo.ads.ad.banner.h
        public final void a(String str) {
        }

        @Override // sg.bigo.ads.ad.banner.h
        public final void a(sg.bigo.ads.common.i iVar, sg.bigo.ads.api.core.e eVar) {
            ((t) z.this.y).f15129z.a(iVar, this.f15251b, this.f15252c, eVar);
        }

        @Override // sg.bigo.ads.ad.banner.h
        public final void b() {
        }
    }

    public final class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<View> f15254b;

        private b() {
            this.f15254b = new ArrayList();
        }

        @MainThread
        public final void a() {
            if (z.this.D != null) {
                Iterator<View> it = this.f15254b.iterator();
                while (it.hasNext()) {
                    z.this.D.removeView(it.next());
                }
            }
        }

        public /* synthetic */ b(z zVar, byte b8) {
            this();
        }

        @MainThread
        public final void a(View view) {
            this.f15254b.add(view);
        }
    }

    public z(@NonNull Activity activity) {
        super(activity);
        this.H = false;
        this.L = true;
        this.M = 1;
        this.N = false;
        this.O = false;
        this.R = 9;
        this.G = new sg.bigo.ads.ad.interstitial.b.a();
        this.T = new AtomicBoolean(false);
        this.V = true;
        this.X = new Runnable() { // from class: sg.bigo.ads.ad.interstitial.z.11
            @Override // java.lang.Runnable
            public final void run() {
                if (sg.bigo.ads.ad.c.a((sg.bigo.ads.ad.c) z.this.y)) {
                    return;
                }
                z.this.l(5);
                z.m(z.this);
            }
        };
        this.Y = new b(this, (byte) 0);
    }

    private boolean ar() {
        return J() || this.p.get();
    }

    private void as() {
        Z().a();
        sg.bigo.ads.common.utils.n nVar = this.f14191u;
        if (nVar != null) {
            nVar.b();
        }
        sg.bigo.ads.common.utils.n nVar2 = this.f14192v;
        if (nVar2 != null) {
            nVar2.b();
        }
        if (this.T.get()) {
            c(this.f14191u, this.f14192v, Z());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at() {
        if (Z() instanceof sg.bigo.ads.ad.interstitial.d.a) {
            return;
        }
        boolean z2 = this.N;
        if (!z2 && !this.f14182d && this.M == 1) {
            this.k.postDelayed(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.z.5
                @Override // java.lang.Runnable
                public final void run() {
                    if (sg.bigo.ads.ad.c.a((sg.bigo.ads.ad.c) z.this.y)) {
                        return;
                    }
                    z.this.au();
                }
            }, ((long) ((sg.bigo.ads.ad.interstitial.a) this).f14180b.a("interstitial_video_style.video_play_page.cta_animation_show_wait_time")) * 1000);
            return;
        }
        sg.bigo.ads.api.a.m mVar = ((sg.bigo.ads.ad.interstitial.a) this).f14181c;
        if (mVar == null || z2 || !this.f14182d || !mVar.c("video_play_page.is_cta_show_animation")) {
            return;
        }
        au();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void au() {
        View viewFindViewById;
        if ((Z() instanceof sg.bigo.ads.ad.interstitial.d.a) || this.D == null || c() != 0 || !this.H || (viewFindViewById = this.D.findViewById(R.id.inter_btn_cta_layout)) == null) {
            return;
        }
        c.e(viewFindViewById);
        this.N = true;
    }

    private void av() {
        View viewFindViewById;
        ViewGroup viewGroup = this.D;
        if (viewGroup == null || (viewFindViewById = viewGroup.findViewById(R.id.inter_layout_end_page)) == null) {
            return;
        }
        viewFindViewById.setVisibility(8);
    }

    private int aw() {
        sg.bigo.ads.api.a.m mVar;
        if (aq()) {
            if (this.f14182d && (mVar = ((sg.bigo.ads.ad.interstitial.a) this).f14181c) != null) {
                iA = mVar.a("endpage.ad_component_layout");
            }
            return iA != 2 ? R.layout.bigo_ad_activity_interstitial_rich_video_end_landscape : R.layout.bigo_ad_activity_interstitial_rich_video_end_landscape_2;
        }
        if (this.O) {
            return R.layout.bigo_ad_activity_interstitial_rich_video_end;
        }
        iA = this.f14182d ? ((sg.bigo.ads.ad.interstitial.a) this).f14181c.a("endpage.ad_component_layout") : 1;
        return iA != 2 ? iA != 3 ? iA != 4 ? R.layout.bigo_ad_activity_interstitial_rich_video_end : R.layout.bigo_ad_activity_interstitial_rich_video_end_4 : R.layout.bigo_ad_activity_interstitial_rich_video_end_3 : R.layout.bigo_ad_activity_interstitial_rich_video_end_2;
    }

    private void ax() {
        View viewFindViewById;
        Z().f();
        ViewGroup viewGroup = this.D;
        if (viewGroup == null) {
            return;
        }
        if (this.H) {
            View viewFindViewById2 = viewGroup.findViewById(R.id.inter_ad_info);
            if (viewFindViewById2 != null) {
                this.H = false;
                c.a(viewFindViewById2);
            }
            View viewFindViewById3 = this.D.findViewById(R.id.inter_ad_info_new);
            if (viewFindViewById3 != null) {
                this.H = false;
                c.a(viewFindViewById3);
            }
            View viewFindViewById4 = this.D.findViewById(R.id.inter_ad_info_down);
            if (viewFindViewById4 != null) {
                this.H = false;
                c.a(viewFindViewById4);
            }
        }
        if (!this.L || (viewFindViewById = this.D.findViewById(R.id.inter_media_container)) == null) {
            return;
        }
        this.L = false;
        c.c(viewFindViewById);
        MediaView mediaView = (MediaView) viewFindViewById.findViewById(R.id.inter_media);
        if (mediaView != null) {
            mediaView.c();
        }
    }

    public static /* synthetic */ boolean e(z zVar) {
        zVar.H = true;
        return true;
    }

    public static /* synthetic */ int g(z zVar) {
        zVar.R = 8;
        return 8;
    }

    public static /* synthetic */ int i(z zVar) {
        switch (zVar.c()) {
            case 1:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return 9;
            case 2:
            case 9:
                return 10;
            case 3:
            default:
                return 8;
            case 10:
                return 11;
        }
    }

    private int p(int i2) {
        sg.bigo.ads.ad.interstitial.a.a aVar;
        sg.bigo.ads.common.t.a.a(0, 3, "RichInterstitialVideoActivityImpl", "try to show end page view.");
        if (aj() && (aVar = ((t) this.y).B) != null) {
            if (aVar.f14218a && aVar.b()) {
                sg.bigo.ads.common.t.a.a(0, 3, "RichInterstitialVideoActivityImpl", "[VastCompanion] companion resource is available and ready.");
                View viewA = aVar.a();
                if (viewA != null) {
                    if ((viewA instanceof ViewGroup) && !((sg.bigo.ads.ad.interstitial.a) this).f14180b.c("interstitial_video_style.endpage.is_global_click")) {
                        viewA.setOnClickListener(null);
                    }
                    sg.bigo.ads.common.t.a.a(0, 3, "RichInterstitialVideoActivityImpl", "[VastCompanion] show companion end page view.");
                    a(aVar, viewA);
                    return 7;
                }
            }
            if (!aVar.b()) {
                aVar.f();
            }
        }
        sg.bigo.ads.common.t.a.a(0, 3, "RichInterstitialVideoActivityImpl", "show video end page view.");
        if (this.p.get()) {
            q(i2);
            return 1;
        }
        this.O = false;
        k(true);
        return 1;
    }

    private void q(int i2) {
        String str;
        if (((t) this.y).f() != null) {
            sg.bigo.ads.core.a.a aVarF = ((t) this.y).f();
            if (aVarF.bh() == null || this.D == null) {
                sg.bigo.ads.ad.interstitial.a.b bVar = ((t) this.y).A;
                if (bVar == null || !bVar.b()) {
                    this.O = true;
                    k(true);
                    return;
                } else {
                    sg.bigo.ads.common.t.a.a(0, 3, "RichInterstitialVideoActivityImpl", "video is not ready, endpage show HTML for backup.");
                    aVarF.j(3);
                    a(i2, bVar);
                    return;
                }
            }
            ImageView imageView = new ImageView(this.D.getContext());
            imageView.setImageBitmap((Bitmap) aVarF.bh().first);
            sg.bigo.ads.common.utils.u.a(imageView, this.D, new FrameLayout.LayoutParams(-1, -1, 17), -1);
            imageView.setTag(15);
            this.D.setTag(20);
            a(imageView, this.D);
            sg.bigo.ads.api.a.m mVar = ((sg.bigo.ads.ad.interstitial.a) this).f14181c;
            if (mVar != null) {
                str = "endpage.close_click_seconds";
            } else {
                mVar = ((sg.bigo.ads.ad.interstitial.a) this).f14180b;
                str = "interstitial_video_style.endpage.impression_close_seconds";
            }
            a(((long) mVar.a(str)) * 1000);
            AdCountDownButton adCountDownButton = this.A;
            if (adCountDownButton != null) {
                adCountDownButton.d();
            }
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a, sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.ad.interstitial.k.b
    public void C() {
        this.e = true;
        sg.bigo.ads.ad.b.c cVar = ((t) this.y).f15129z;
        boolean z2 = cVar != null && cVar.p == 22;
        if (this.f14182d || c() != 0 || z2) {
            super.C();
        } else {
            l(3);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a, sg.bigo.ads.ad.interstitial.r, sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void D() {
        T t3 = this.y;
        if (t3 != 0) {
            t tVar = (t) t3;
            sg.bigo.ads.ad.interstitial.a.b bVar = tVar.A;
            if (bVar != null) {
                bVar.e();
                tVar.A = null;
            }
            t tVar2 = (t) this.y;
            sg.bigo.ads.ad.interstitial.a.a aVar = tVar2.B;
            if (aVar != null) {
                aVar.e();
                tVar2.B = null;
            }
        }
        Runnable runnable = this.P;
        if (runnable != null) {
            sg.bigo.ads.common.n.d.a(runnable);
        }
        Runnable runnable2 = this.Q;
        if (runnable2 != null) {
            sg.bigo.ads.common.n.d.a(runnable2);
        }
        super.D();
    }

    @Override // sg.bigo.ads.ad.interstitial.a
    public final void H() {
        int i2;
        boolean z2;
        sg.bigo.ads.common.utils.n nVar = this.f14193w;
        if (nVar != null) {
            nVar.b();
            this.f14193w = null;
        }
        sg.bigo.ads.core.a.a aVarF = ((t) this.y).f();
        if (!this.p.get()) {
            i2 = this.h.j;
            z2 = false;
        } else {
            if (aVarF.bh() != null) {
                return;
            }
            i2 = this.h.m;
            z2 = true;
        }
        a(aVarF, z2, i2);
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    public int R() {
        int iN = n();
        if (!aq()) {
            switch (iN) {
                case 2:
                    return R.layout.bigo_ad_activity_interstitial_rich_video_2;
                case 3:
                    return R.layout.bigo_ad_activity_interstitial_rich_video_3;
                case 4:
                    return R.layout.bigo_ad_activity_interstitial_rich_video_4;
                case 5:
                    return R.layout.bigo_ad_activity_interstitial_rich_video_5;
                case 6:
                    return R.layout.bigo_ad_activity_interstitial_rich_video_download_6;
                case 7:
                    return R.layout.bigo_ad_activity_interstitial_rich_video_download_7;
                case 8:
                    return R.layout.bigo_ad_activity_interstitial_rich_video_download_8;
                case 9:
                case 10:
                case 11:
                case 12:
                default:
                    return R.layout.bigo_ad_activity_interstitial_rich_video;
                case 13:
                case 18:
                    return R.layout.bigo_ad_activity_interstitial_rich_video_multi_img_13;
                case 14:
                    return R.layout.bigo_ad_activity_interstitial_rich_video_multi_img_14;
                case 15:
                    return R.layout.bigo_ad_activity_interstitial_rich_video_multi_img_15;
                case 16:
                    return R.layout.bigo_ad_activity_interstitial_rich_video_multi_img_16;
                case 17:
                    return R.layout.bigo_ad_activity_interstitial_rich_video_multi_img_17;
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                    return R.layout.bigo_ad_activity_interstitial_rich_video_19_29;
                case 30:
                    return R.layout.bigo_ad_activity_interstitial_percent_warning;
                case 31:
                case 32:
                    return s.a(s.a(this.C), iN);
            }
        }
        T t3 = this.y;
        sg.bigo.ads.core.a.a aVar = null;
        if (t3 != 0 && ((t) t3).f15129z != null) {
            aVar = (sg.bigo.ads.core.a.a) ((t) t3).f15129z.f();
        }
        boolean z2 = false;
        if (aVar != null) {
            sg.bigo.ads.api.core.n nVarAV = aVar.aV();
            Activity activity = this.I;
            if (nVarAV != null && activity != null && (nVarAV.f15520a * 1.0f) / nVarAV.f15521b == (activity.getResources().getDisplayMetrics().widthPixels * 1.0f) / sg.bigo.ads.common.utils.e.c(activity)) {
                z2 = true;
            }
        }
        if (iN == 1) {
            return z2 ? R.layout.bigo_ad_activity_interstitial_style_landscape_1_full_media : R.layout.bigo_ad_activity_interstitial_style_landscape_1;
        }
        if (iN != 3) {
            return iN != 4 ? iN != 5 ? z2 ? R.layout.bigo_ad_activity_interstitial_style_landscape_2_full_media : R.layout.bigo_ad_activity_interstitial_style_landscape_2 : R.layout.bigo_ad_activity_interstitial_percent_warning_landscape : z2 ? R.layout.bigo_ad_activity_interstitial_style_landscape_4_full_media : R.layout.bigo_ad_activity_interstitial_style_landscape_4;
        }
        sg.bigo.ads.api.a.m mVar = ((sg.bigo.ads.ad.interstitial.a) this).f14181c;
        if (mVar == null) {
            mVar = ((sg.bigo.ads.ad.interstitial.a) this).f14180b;
        }
        if (mVar != null && aVar != null) {
            int iA = mVar.a("video_play_page.gp_element");
            if ((!TextUtils.isEmpty(aVar.n()) || (iA != 0 && iA != 1 && iA != 4)) && this.j != null) {
                return R.layout.bigo_ad_activity_interstitial_style_landscape_3;
            }
        }
        return R.layout.bigo_ad_activity_interstitial_style_landscape_3_no_gp_element;
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    public final boolean S() {
        return this.f14182d;
    }

    @Override // sg.bigo.ads.ad.interstitial.r
    public int Y() {
        return this.p.get() ? 3 : 1;
    }

    public boolean ad() {
        sg.bigo.ads.ad.interstitial.g.a aVar = this.f14190t;
        if (aVar == null || !aVar.d()) {
            return sg.bigo.ads.ad.interstitial.c.a.a(this.S, this.f14182d ? ((sg.bigo.ads.ad.interstitial.a) this).f14181c : null);
        }
        return true;
    }

    public final void ae() {
        Z().a(this.D);
    }

    public final void af() {
        sg.bigo.ads.common.t.a.a(0, 3, "RichInterstitialVideoActivityImpl", "begin to Load backup HTML events called");
        if (aj() || !ar()) {
            return;
        }
        sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.ad.interstitial.z.19
            @Override // java.lang.Runnable
            public final void run() {
                T t3 = z.this.y;
                if (t3 != 0) {
                    ((sg.bigo.ads.core.a.a) ((t) t3).f15129z.f()).d(3);
                    t tVar = (t) z.this.y;
                    sg.bigo.ads.ad.b.c cVar = tVar.f15129z;
                    if (cVar instanceof sg.bigo.ads.ad.b.d) {
                        sg.bigo.ads.ad.b.d dVar = (sg.bigo.ads.ad.b.d) cVar;
                        tVar.A = new sg.bigo.ads.ad.interstitial.a.b(tVar, tVar.f14024b.f15497b, ((sg.bigo.ads.core.a.a) dVar.f()).bn(), tVar.f14024b.f15496a, dVar.J, dVar.K);
                    }
                    z.this.a(tVar.A);
                }
            }
        });
    }

    public final boolean ag() {
        x xVar;
        if (this.U || this.e || (xVar = this.h) == null || xVar.j != 3) {
            return false;
        }
        this.e = true;
        sg.bigo.ads.common.t.a.a(0, 4, "Interstitial Video", "auto click.");
        ((t) this.y).f15129z.a(8, 22);
        return true;
    }

    @Override // sg.bigo.ads.ad.interstitial.b.a.InterfaceC0249a
    public final void ah() {
        AdCountDownButton adCountDownButton = this.A;
        if (adCountDownButton == null || adCountDownButton.f14166c) {
            return;
        }
        adCountDownButton.c();
    }

    @Override // sg.bigo.ads.ad.interstitial.b.a.InterfaceC0249a
    public final void ai() {
        AdCountDownButton adCountDownButton = this.A;
        if (adCountDownButton == null || adCountDownButton.f14166c) {
            return;
        }
        adCountDownButton.b();
    }

    public boolean aj() {
        sg.bigo.ads.api.a.m mVar;
        sg.bigo.ads.ad.interstitial.c.a aVar;
        sg.bigo.ads.api.a.m mVar2;
        if (this.y == 0) {
            return false;
        }
        return (aq() && this.f14182d && (mVar2 = ((sg.bigo.ads.ad.interstitial.a) this).f14181c) != null && mVar2.a("endpage.ad_component_layout") == 3) || !this.f14182d || ((mVar = ((sg.bigo.ads.ad.interstitial.a) this).f14181c) != null && mVar.a("endpage.ad_component_layout") == 5) || ((aVar = this.S) != null && aVar.g());
    }

    public final void ak() {
        if (c() != 0 || this.W) {
            return;
        }
        this.k.postDelayed(this.X, 5000L);
        this.W = true;
    }

    public final void al() {
        sg.bigo.ads.common.t.a.a(0, 3, "RichInterstitialVideoActivityImpl", "midpage is shown when video ready, all timer paused");
        AdCountDownButton adCountDownButton = this.A;
        if (adCountDownButton != null) {
            sg.bigo.ads.common.utils.n nVar = adCountDownButton.f14165b;
            if (nVar != null) {
                nVar.b();
            }
            adCountDownButton.f14166c = true;
            adCountDownButton.f14167d = true;
            adCountDownButton.a(true);
        }
        VideoController videoControllerAa = aa();
        sg.bigo.ads.common.utils.n nVar2 = this.f14191u;
        if (nVar2 != null) {
            nVar2.d();
        }
        sg.bigo.ads.common.utils.n nVar3 = this.f14193w;
        if (nVar3 != null) {
            nVar3.d();
        }
        sg.bigo.ads.common.utils.n nVar4 = this.f14194x;
        if (nVar4 != null) {
            nVar4.d();
        }
        sg.bigo.ads.common.utils.n nVar5 = this.f14192v;
        if (nVar5 != null) {
            nVar5.d();
        }
        if (videoControllerAa == null || !videoControllerAa.isPlaying()) {
            return;
        }
        videoControllerAa.pause();
    }

    public final void am() {
        if (this.W) {
            this.k.removeCallbacks(this.X);
            this.W = false;
        }
    }

    @NonNull
    public LandingPageStyleConfig an() {
        sg.bigo.ads.api.a.m mVar = ((sg.bigo.ads.ad.interstitial.a) this).f14181c;
        if (mVar == null || !this.f14182d) {
            mVar = null;
        }
        int iA = sg.bigo.ads.ad.interstitial.c.a.a(mVar);
        int iB = sg.bigo.ads.ad.interstitial.c.a.b(mVar);
        int iA2 = sg.bigo.ads.ad.interstitial.c.a.a(this.S, mVar) ? Z().f15141i : 0;
        if (iA2 == 0) {
            iA2 = s.a(this.C, 0);
        }
        int i2 = iA2;
        int measuredHeight = 0;
        Class<? extends sg.bigo.ads.controller.landing.c> clsH = sg.bigo.ads.ad.interstitial.a.h(iA);
        ViewGroup viewGroup = this.D;
        if (viewGroup != null) {
            measuredHeight = viewGroup.getMeasuredHeight();
        }
        return new LandingPageStyleConfig(clsH, 1, iA, iB, measuredHeight, i2, 0.8f);
    }

    @Override // sg.bigo.ads.ad.interstitial.a
    @NonNull
    public x b() {
        x xVar = new x();
        sg.bigo.ads.api.a.m mVar = ((sg.bigo.ads.ad.interstitial.a) this).f14181c;
        if (mVar == null) {
            this.f14182d = false;
            xVar.j = 1;
            xVar.f15194a = ((sg.bigo.ads.ad.interstitial.a) this).f14180b.c("interstitial_video_style.video_play_page.is_global_click");
            xVar.f15195b = ((sg.bigo.ads.ad.interstitial.a) this).f14180b.a("interstitial_video_style.video_play_page.impression_close_seconds");
            xVar.f15196c = ((sg.bigo.ads.ad.interstitial.a) this).f14180b.a("interstitial_video_style.video_play_page.close_click_seconds");
            xVar.f15197d = ((sg.bigo.ads.ad.interstitial.a) this).f14180b.c("interstitial_video_style.video_play_page.is_jump_layer");
            xVar.e = ((sg.bigo.ads.ad.interstitial.a) this).f14180b.a("interstitial_video_style.layer.impression_layer_close_seconds");
            return xVar;
        }
        this.f14182d = true;
        xVar.f15198f = mVar.c("video_play_page.media_view_clickable_switch");
        xVar.h = ((sg.bigo.ads.ad.interstitial.a) this).f14181c.c("video_play_page.ad_component_clickable_switch");
        xVar.g = ((sg.bigo.ads.ad.interstitial.a) this).f14181c.c("video_play_page.other_space_clickable_switch");
        xVar.f15199i = ((sg.bigo.ads.ad.interstitial.a) this).f14181c.a("video_play_page.click_type");
        xVar.k = ((sg.bigo.ads.ad.interstitial.a) this).f14181c.c("layer.other_space_clickable_switch");
        xVar.l = ((sg.bigo.ads.ad.interstitial.a) this).f14181c.a("layer.click_type");
        xVar.f15194a = false;
        xVar.f15195b = 0;
        xVar.f15196c = ((sg.bigo.ads.ad.interstitial.a) this).f14181c.a("video_play_page.force_staying_time");
        xVar.f15197d = ((sg.bigo.ads.ad.interstitial.a) this).f14181c.c("layer.is_show_layer");
        xVar.e = ((sg.bigo.ads.ad.interstitial.a) this).f14181c.a("layer.force_staying_time");
        xVar.j = ((sg.bigo.ads.ad.interstitial.a) this).f14181c.a("video_play_page.auto_click");
        xVar.m = ((sg.bigo.ads.ad.interstitial.a) this).f14181c.a("video_play_page.time_for_auto_click", -1);
        xVar.f15200n = ((sg.bigo.ads.ad.interstitial.a) this).f14181c.a("video_play_page.time_for_show_backup", -1);
        return xVar;
    }

    @Override // sg.bigo.ads.ad.interstitial.a, sg.bigo.ads.ad.interstitial.f.b.InterfaceC0266b
    public final void d(int i2) {
        super.d(i2);
        if (c() != 0) {
            as();
            c(this.f14191u, this.f14192v, Z());
        }
        if (this.T.compareAndSet(true, false)) {
            b(this.f14194x, this.f14188r, this.G, this.f14191u, this.f14192v, Z());
            if (this.G.f14284d) {
                c(this.f14191u, this.f14192v, Z());
            }
            e();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a
    public final void f(int i2) {
        ViewGroup viewGroup;
        super.f(i2);
        if (i2 != 9 || J() || (viewGroup = this.D) == null) {
            return;
        }
        viewGroup.postDelayed(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.z.9
            @Override // java.lang.Runnable
            public final void run() {
                if (z.this.I.isFinishing()) {
                    return;
                }
                z.this.j();
            }
        }, 50L);
    }

    @Override // sg.bigo.ads.ad.interstitial.a, sg.bigo.ads.ad.interstitial.r, sg.bigo.ads.ad.interstitial.i
    public void h() {
        VideoController videoControllerAa;
        super.h();
        int iC = c();
        if (iC != 10 && (!this.p.get() || ((sg.bigo.ads.core.a.a) ((t) this.y).f15129z.f()).bh() != null)) {
            sg.bigo.ads.common.utils.n nVar = this.f14191u;
            if (nVar != null && nVar.e()) {
                this.f14191u.c();
            }
            sg.bigo.ads.common.utils.n nVar2 = this.f14192v;
            if (nVar2 != null && nVar2.e()) {
                this.f14192v.c();
            }
        }
        sg.bigo.ads.ad.interstitial.a.b bVar = ((t) this.y).A;
        if (bVar != null) {
            bVar.f14270f.c();
        }
        sg.bigo.ads.ad.interstitial.c.a aVar = this.S;
        if (aVar != null) {
            aVar.b();
        }
        this.G.a(false);
        if ((iC == 0 || iC == 3) && (videoControllerAa = aa()) != null && videoControllerAa.isPaused() && this.V) {
            videoControllerAa.play();
            this.V = false;
        }
        AdCountDownButton adCountDownButton = this.A;
        if (adCountDownButton != null && !adCountDownButton.f14166c) {
            adCountDownButton.c();
        }
        sg.bigo.ads.common.utils.n nVar3 = this.f14194x;
        if (nVar3 != null && nVar3.e()) {
            this.f14194x.c();
        }
        sg.bigo.ads.common.utils.n nVar4 = this.f14193w;
        if (nVar4 == null || !nVar4.e()) {
            return;
        }
        this.f14193w.c();
    }

    @Override // sg.bigo.ads.ad.interstitial.a, sg.bigo.ads.ad.interstitial.r, sg.bigo.ads.ad.interstitial.i
    public void m() {
        super.m();
        sg.bigo.ads.ad.interstitial.b.a aVar = this.G;
        sg.bigo.ads.ad.b.c cVar = ((t) this.y).f15129z;
        x xVar = this.h;
        sg.bigo.ads.api.a.m mVar = this.f14182d ? ((sg.bigo.ads.ad.interstitial.a) this).f14181c : null;
        aVar.f14281a = cVar;
        aVar.f14282b = xVar;
        aVar.f14283c = mVar != null ? mVar.a("video_play_page.countdown_way", 1) : 1;
        this.G.g = this;
        if (!this.f14182d || ((sg.bigo.ads.ad.interstitial.a) this).f14181c == null) {
            return;
        }
        if (J() || this.p.get()) {
            this.S = sg.bigo.ads.ad.interstitial.c.a.a(this.C, ((sg.bigo.ads.ad.interstitial.a) this).f14181c, ((t) this.y).D(), this.f14189s, aq());
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a
    public final void r() {
        final VideoController videoController;
        Button button;
        super.r();
        final sg.bigo.ads.ad.b.c cVar = this.C;
        if (cVar == null || (videoController = cVar.getVideoController()) == null) {
            return;
        }
        u uVarZ = Z();
        final boolean zN = uVarZ instanceof sg.bigo.ads.ad.interstitial.d.a ? ((sg.bigo.ads.ad.interstitial.d.a) uVarZ).n() : false;
        this.E = (Button) o(R.id.inter_btn_mute);
        if (!this.p.get() && (button = this.E) != null && !zN) {
            button.setVisibility(0);
            j(videoController.isMuted());
            this.E.setOnClickListener(new View.OnClickListener() { // from class: sg.bigo.ads.ad.interstitial.z.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    videoController.mute(!r2.isMuted());
                }
            });
        }
        final sg.bigo.ads.ad.interstitial.b.a aVar = this.G;
        videoController.setVideoLifeCallback(new a.c(new VideoController.b() { // from class: sg.bigo.ads.ad.interstitial.z.12
            @Override // sg.bigo.ads.api.VideoController.b
            public final void a() {
                z.this.ak();
            }

            @Override // sg.bigo.ads.api.VideoController.b
            public final void b() {
                z.this.am();
            }

            @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
            public final void onMuteChange(boolean z2) {
                z.this.j(z2);
            }

            @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
            public final void onVideoPause() {
                q qVar = z.this.f14188r;
                if (qVar != null) {
                    qVar.d();
                }
            }

            @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
            public final void onVideoPlay() {
                q qVar = z.this.f14188r;
                if (qVar != null) {
                    qVar.c();
                }
                if (z.this.c() == 10) {
                    z.this.al();
                }
            }

            @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
            public final void onVideoStart() {
                Context context;
                int i2;
                if (z.this.p.compareAndSet(true, false)) {
                    AdCountDownButton adCountDownButton = z.this.A;
                    if (adCountDownButton != null) {
                        adCountDownButton.d();
                        z.this.A.setTakeoverTickEvent(true);
                        z zVar = z.this;
                        zVar.G.h = true;
                        zVar.y();
                    }
                    videoController.notifyPlayViewRegister();
                    z.this.H();
                    sg.bigo.ads.common.utils.n nVar = z.this.f14194x;
                    if (nVar != null) {
                        nVar.b();
                        z.this.f14194x = null;
                    }
                    z zVar2 = z.this;
                    if (zVar2.f14187q) {
                        sg.bigo.ads.common.utils.n nVar2 = zVar2.f14191u;
                        if (nVar2 != null) {
                            nVar2.c();
                        }
                        sg.bigo.ads.common.utils.n nVar3 = z.this.f14192v;
                        if (nVar3 != null) {
                            nVar3.c();
                        }
                    }
                    Button button2 = z.this.E;
                    if (button2 != null && !zN) {
                        button2.setVisibility(0);
                    }
                    z zVar3 = z.this;
                    if (zVar3.D != null) {
                        u uVarZ2 = zVar3.Z();
                        z zVar4 = z.this;
                        ViewGroup viewGroup = zVar4.D;
                        int iY = zVar4.Y();
                        c.d popPage = uVarZ2.f15138c.getPopPage();
                        ImageView imageView = (ImageView) viewGroup.findViewById(R.id.inter_icon);
                        if (imageView != null && !uVarZ2.f15138c.hasIcon()) {
                            String strA = popPage == null ? "" : popPage.a();
                            if (sg.bigo.ads.common.utils.q.a((CharSequence) strA) || !URLUtil.isNetworkUrl(strA)) {
                                if (iY == 2) {
                                    context = imageView.getContext();
                                    i2 = R.drawable.bigo_ad_icon_default;
                                } else if (iY == 1) {
                                    uVarZ2.a(imageView);
                                } else if (iY == 3) {
                                    context = imageView.getContext();
                                    i2 = R.drawable.bigo_ad_icon_novideo_default;
                                }
                                imageView.setImageDrawable(sg.bigo.ads.common.utils.a.a(context, i2));
                            } else {
                                sg.bigo.ads.ad.b.c cVar2 = uVarZ2.f15138c;
                                sg.bigo.ads.common.p.e.a(cVar2.f14024b.e, strA, ((sg.bigo.ads.core.a.a) cVar2.f()).al(), new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.interstitial.u.10

                                    /* JADX INFO: renamed from: a */
                                    final /* synthetic */ ImageView f15147a;

                                    public AnonymousClass10(ImageView imageView2) {
                                        imageView = imageView2;
                                    }

                                    @Override // sg.bigo.ads.common.p.g
                                    public final void a(int i8, @NonNull String str, String str2) {
                                    }

                                    @Override // sg.bigo.ads.common.p.g
                                    public final void a(@NonNull Bitmap bitmap, @NonNull sg.bigo.ads.common.p.f fVar) {
                                        imageView.setImageBitmap(bitmap);
                                    }
                                });
                            }
                        }
                        z.this.I();
                    }
                    z.this.j(videoController.isMuted());
                    Button button3 = z.this.E;
                    if (button3 != null) {
                        button3.setOnClickListener(new View.OnClickListener() { // from class: sg.bigo.ads.ad.interstitial.z.12.1
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                videoController.mute(!r2.isMuted());
                            }
                        });
                    }
                }
                if ((cVar instanceof sg.bigo.ads.ad.b.d) && (z.this.K() || z.this.L())) {
                    ((sg.bigo.ads.ad.b.d) cVar).L = true;
                }
                u uVarZ3 = z.this.Z();
                uVarZ3.d();
                if (uVarZ3 instanceof sg.bigo.ads.ad.interstitial.d.a) {
                    ((sg.bigo.ads.ad.interstitial.d.a) uVarZ3).p();
                }
                if (z.this.S != null) {
                    z.this.S.c(z.this);
                }
                z zVar5 = z.this;
                sg.bigo.ads.ad.interstitial.g.a aVar2 = zVar5.f14190t;
                if (aVar2 != null) {
                    aVar2.c(zVar5);
                }
            }

            @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
            public final void onVideoEnd() {
            }
        }) { // from class: sg.bigo.ads.ad.interstitial.b.a.1
            {
                byte b8 = 0;
            }

            @Override // sg.bigo.ads.ad.interstitial.b.a.c, sg.bigo.ads.api.VideoController.VideoLifeCallback
            public final void onVideoEnd() {
                a aVar2 = a.this;
                aVar2.f14284d = true;
                a.a(aVar2);
                super.onVideoEnd();
            }

            @Override // sg.bigo.ads.ad.interstitial.b.a.c, sg.bigo.ads.api.VideoController.VideoLifeCallback
            public final void onVideoPause() {
                a.this.b(true);
                super.onVideoPause();
            }

            @Override // sg.bigo.ads.ad.interstitial.b.a.c, sg.bigo.ads.api.VideoController.VideoLifeCallback
            public final void onVideoPlay() {
                a.this.a(true);
                super.onVideoPlay();
            }
        });
        videoController.setLoadHTMLCallback(new VideoController.c() { // from class: sg.bigo.ads.ad.interstitial.z.15
            @Override // sg.bigo.ads.api.VideoController.c
            public final void a() {
                z.this.af();
            }
        });
        final sg.bigo.ads.ad.interstitial.b.a aVar2 = this.G;
        videoController.setProgressChangeListener(new a.b(new VideoController.d() { // from class: sg.bigo.ads.ad.interstitial.z.16
            @Override // sg.bigo.ads.api.VideoController.d
            public final void a(int i2, int i8) {
                u uVarZ2 = z.this.Z();
                uVarZ2.d();
                if (uVarZ2 instanceof sg.bigo.ads.ad.interstitial.d.a) {
                    ((sg.bigo.ads.ad.interstitial.d.a) uVarZ2).p();
                }
                if (z.this.S != null) {
                    z.this.S.c(z.this);
                }
                z zVar = z.this;
                sg.bigo.ads.ad.interstitial.g.a aVar3 = zVar.f14190t;
                if (aVar3 != null) {
                    aVar3.c(zVar);
                }
                if (!z.this.N) {
                    z zVar2 = z.this;
                    if (!zVar2.f14182d && zVar2.M == 2 && i2 / i8 >= ((sg.bigo.ads.ad.interstitial.a) z.this).f14180b.b("interstitial_video_style.video_play_page.cta_animation_show_wait_progress")) {
                        z.this.au();
                    }
                }
                z zVar3 = z.this;
                if (((sg.bigo.ads.ad.interstitial.a) zVar3).f14181c == null || zVar3.N) {
                    return;
                }
                z zVar4 = z.this;
                if (zVar4.f14182d && ((sg.bigo.ads.ad.interstitial.a) zVar4).f14181c.c("video_play_page.is_cta_show_animation")) {
                    z.this.au();
                }
            }
        }) { // from class: sg.bigo.ads.ad.interstitial.b.a.2
            {
                byte b8 = 0;
            }

            @Override // sg.bigo.ads.ad.interstitial.b.a.b, sg.bigo.ads.api.VideoController.d
            public final void a(int i2, int i8) {
                a aVar3 = a.this;
                if (aVar3.g != null && !aVar3.a()) {
                    a.this.g.b(i8 - i2);
                }
                super.a(i2, i8);
            }
        });
        videoController.setBackupLoadCallback(this);
    }

    @Override // sg.bigo.ads.ad.interstitial.a
    public void s() {
        q qVar;
        if (((sg.bigo.ads.core.a.a) ((t) this.y).f15129z.f()).bb() && (qVar = this.f14188r) != null && qVar.y.a(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.z.14
            @Override // java.lang.Runnable
            public final void run() {
                z.this.l(1);
            }
        })) {
            sg.bigo.ads.common.t.a.a(0, 3, "RichInterstitialVideoActivityImpl", "backup image show mid_page success");
        } else {
            l(4);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a
    public final boolean t() {
        sg.bigo.ads.api.a.m mVar = ((sg.bigo.ads.ad.interstitial.a) this).f14181c;
        int iA = mVar != null ? this.f14182d ? mVar.a("video_play_page.ad_component_layout") : 1 : 0;
        return (iA == 6 || iA == 7) ? !aq() : iA == 8;
    }

    @Override // sg.bigo.ads.ad.interstitial.a
    public void x() {
        super.x();
        AdCountDownButton adCountDownButton = this.A;
        if (adCountDownButton != null) {
            adCountDownButton.setShowCloseButtonInCountdown(true);
            this.A.setTakeoverTickEvent(!this.p.get());
            this.G.h = true ^ this.p.get();
            if (K()) {
                j(R.drawable.bigo_ad_ic_close);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    @Override // sg.bigo.ads.ad.interstitial.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void y() {
        /*
            r7 = this;
            super.y()
            int r0 = r7.c()
            if (r0 != 0) goto L6f
            sg.bigo.ads.ad.interstitial.b.a r2 = r7.G
            boolean r0 = r2.a()
            if (r0 == 0) goto L6f
            boolean r0 = r2.h
            if (r0 == 0) goto L6f
            sg.bigo.ads.common.utils.n r0 = r2.f14285f
            if (r0 == 0) goto L1c
            r0.b()
        L1c:
            sg.bigo.ads.ad.b.c r0 = r2.f14281a
            if (r0 == 0) goto L27
            sg.bigo.ads.api.core.c r0 = r0.f()
            sg.bigo.ads.core.a.a r0 = (sg.bigo.ads.core.a.a) r0
            goto L28
        L27:
            r0 = 0
        L28:
            if (r0 == 0) goto L45
            sg.bigo.ads.api.core.n r1 = r0.aV()
            r3 = 0
            if (r1 == 0) goto L35
            long r5 = r1.f15522c
            goto L36
        L35:
            r5 = r3
        L36:
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 <= 0) goto L3c
        L3a:
            r3 = r5
            goto L5e
        L3c:
            long r5 = r0.aU()
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 <= 0) goto L45
            goto L3a
        L45:
            sg.bigo.ads.ad.interstitial.x r0 = r2.f14282b
            if (r0 == 0) goto L4c
            int r0 = r0.f15196c
            goto L4d
        L4c:
            r0 = 0
        L4d:
            if (r0 >= 0) goto L58
            sg.bigo.ads.common.utils.r r0 = sg.bigo.ads.common.utils.r.f16034a
            r1 = 15
            long r5 = r0.a(r1)
            goto L3a
        L58:
            long r0 = (long) r0
            r3 = 1000(0x3e8, double:4.94E-321)
            long r5 = r0 * r3
            goto L3a
        L5e:
            sg.bigo.ads.ad.interstitial.b.a$3 r1 = new sg.bigo.ads.ad.interstitial.b.a$3
            sg.bigo.ads.common.utils.r r0 = sg.bigo.ads.common.utils.r.f16034a
            r5 = 1
            long r5 = r0.a(r5)
            r1.<init>(r3, r5)
            r2.f14285f = r1
            r1.c()
        L6f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.ad.interstitial.z.y():void");
    }

    @Override // sg.bigo.ads.ad.interstitial.a, sg.bigo.ads.ad.c.a
    public final LandingPageStyleConfig a(Context context, String str, int i2, boolean z2) {
        LandingPageStyleConfig landingPageStyleConfigAn;
        if (c() != 1) {
            return super.a(context, str, i2, z2);
        }
        if (z2) {
            sg.bigo.ads.api.a.m mVar = ((sg.bigo.ads.ad.interstitial.a) this).f14181c;
            if (mVar == null || !this.f14182d) {
                mVar = null;
            }
            int iA = sg.bigo.ads.ad.interstitial.c.a.a(mVar);
            if (sg.bigo.ads.ad.interstitial.a.i(iA)) {
                iA = 0;
            }
            int i8 = iA;
            landingPageStyleConfigAn = new LandingPageStyleConfig(sg.bigo.ads.ad.interstitial.a.h(i8), 1, i8, sg.bigo.ads.ad.interstitial.c.a.b(mVar), 0, 0, 0.0f);
        } else {
            landingPageStyleConfigAn = an();
        }
        sg.bigo.ads.ad.interstitial.f.b.a(landingPageStyleConfigAn);
        return landingPageStyleConfigAn;
    }

    @Override // sg.bigo.ads.ad.interstitial.b.a.InterfaceC0249a
    public final void b(long j) {
        AdCountDownButton adCountDownButton = this.A;
        if (adCountDownButton != null) {
            adCountDownButton.a(j);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a
    public final void c(boolean z2) {
        super.c(z2);
        this.f14187q = z2;
    }

    @Override // sg.bigo.ads.ad.interstitial.a, sg.bigo.ads.ad.interstitial.r, sg.bigo.ads.ad.interstitial.i
    public void g(@LayoutRes int i2) {
        View viewFindViewById;
        sg.bigo.ads.ad.interstitial.a.a aVar;
        super.g(i2);
        if (this.D == null) {
            return;
        }
        if (ad() && (J() || this.p.get())) {
            Z().i();
        }
        a(aj());
        I();
        this.M = ((sg.bigo.ads.ad.interstitial.a) this).f14180b.a("interstitial_video_style.video_play_page.cta_animation_show_way");
        k(i2);
        sg.bigo.ads.core.a.a aVar2 = (sg.bigo.ads.core.a.a) ((t) this.y).f15129z.f();
        if (aj()) {
            if (this.y != 0 && ar()) {
                a(((t) this.y).A);
                if (this.y != 0 && ar() && (aVar = ((t) this.y).B) != null) {
                    aVar.a(new a(15));
                    aVar.a(new c.a() { // from class: sg.bigo.ads.ad.interstitial.z.21
                        @Override // sg.bigo.ads.ad.interstitial.a.b.c.a
                        public final void a(sg.bigo.ads.common.i iVar, sg.bigo.ads.api.core.e eVar) {
                            ((t) z.this.y).f15129z.a(iVar, 15, 9, eVar);
                        }
                    });
                    sg.bigo.ads.common.t.a.a(0, 3, "RichInterstitialVideoActivityImpl", "begin to preload EndPageCompanion resource : ".concat(String.valueOf(aVar)));
                    aVar.a(this.I);
                }
            }
        } else if (this.p.get() && aVar2.bi()) {
            af();
        }
        if (this.p.get() && aVar2.bh() == null) {
            sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.ad.interstitial.z.17
                @Override // java.lang.Runnable
                public final void run() {
                    q qVar = z.this.f14188r;
                    if (qVar != null) {
                        qVar.d();
                    }
                }
            });
            if (!aq() || (viewFindViewById = this.D.findViewById(R.id.inter_ad_info)) == null) {
                return;
            }
            viewFindViewById.setVisibility(0);
            return;
        }
        sg.bigo.ads.common.utils.n nVar = this.f14191u;
        if (nVar != null) {
            nVar.c();
        }
        sg.bigo.ads.common.utils.n nVar2 = this.f14192v;
        if (nVar2 != null) {
            nVar2.c();
        }
    }

    @CallSuper
    public void i(boolean z2) {
        sg.bigo.ads.common.t.a.a(0, 4, "RichInterstitialVideoActivityImpl", "backup image loaded when show default backup style, so cancel this timer, isVideoReady=".concat(String.valueOf(z2)));
        sg.bigo.ads.common.utils.n nVar = this.f14194x;
        if (nVar != null) {
            nVar.b();
            this.f14194x = null;
        }
        sg.bigo.ads.common.utils.n nVar2 = this.f14193w;
        if (nVar2 != null) {
            nVar2.b();
            this.f14193w = null;
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a, sg.bigo.ads.ad.interstitial.r, sg.bigo.ads.ad.interstitial.i
    public void j() {
        super.j();
        sg.bigo.ads.common.utils.n nVar = this.f14191u;
        if (nVar != null) {
            nVar.d();
        }
        sg.bigo.ads.common.utils.n nVar2 = this.f14192v;
        if (nVar2 != null) {
            nVar2.d();
        }
        sg.bigo.ads.common.utils.n nVar3 = this.f14193w;
        if (nVar3 != null) {
            nVar3.d();
        }
        sg.bigo.ads.common.utils.n nVar4 = this.f14194x;
        if (nVar4 != null) {
            nVar4.d();
        }
        sg.bigo.ads.ad.interstitial.a.b bVar = ((t) this.y).A;
        if (bVar != null) {
            bVar.f14270f.d();
        }
        sg.bigo.ads.ad.interstitial.c.a aVar = this.S;
        if (aVar != null) {
            aVar.c();
        }
        boolean z2 = false;
        this.G.b(false);
        VideoController videoControllerAa = aa();
        if (videoControllerAa != null && videoControllerAa.isPlaying()) {
            z2 = true;
        }
        this.V = z2;
        if (z2) {
            videoControllerAa.pause();
        }
        AdCountDownButton adCountDownButton = this.A;
        if (adCountDownButton == null || adCountDownButton.f14166c) {
            return;
        }
        adCountDownButton.b();
    }

    public void k(int i2) {
        sg.bigo.ads.api.a.m mVar;
        String str;
        RoundedFrameLayout roundedFrameLayout;
        if (Z() instanceof sg.bigo.ads.ad.interstitial.d.a) {
            return;
        }
        e(i2);
        View viewFindViewById = this.D.findViewById(R.id.inter_ad_info);
        if (viewFindViewById != null) {
            int i8 = o().f14783a;
            if (i8 > 0) {
                Context context = viewFindViewById.getContext();
                ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams.leftMargin = sg.bigo.ads.common.utils.e.a(context, 10);
                    marginLayoutParams.rightMargin = sg.bigo.ads.common.utils.e.a(context, 10);
                    marginLayoutParams.bottomMargin = sg.bigo.ads.common.utils.e.a(context, i8);
                }
                View viewFindViewById2 = this.D.findViewById(R.id.inter_ad_info_background);
                if (viewFindViewById2 != null) {
                    if (viewFindViewById2 instanceof RoundedFrameLayout) {
                        roundedFrameLayout = (RoundedFrameLayout) viewFindViewById2;
                        roundedFrameLayout.setCornerRadius(sg.bigo.ads.common.utils.e.a(context, 16));
                    }
                } else if (viewFindViewById instanceof RoundedFrameLayout) {
                    roundedFrameLayout = (RoundedFrameLayout) viewFindViewById;
                    roundedFrameLayout.setCornerRadius(sg.bigo.ads.common.utils.e.a(context, 16));
                }
            }
            if (t() || M()) {
                this.H = true;
                at();
                return;
            }
            if (this.f14182d) {
                mVar = ((sg.bigo.ads.ad.interstitial.a) this).f14181c;
                str = "video_play_page.ad_component_show_time";
            } else {
                mVar = ((sg.bigo.ads.ad.interstitial.a) this).f14180b;
                str = "interstitial_video_style.video_play_page.impression_ad_seconds";
            }
            this.f14191u = new AnonymousClass18(((long) mVar.a(str)) * 1000, viewFindViewById);
        }
    }

    public void l(int i2) {
        View viewFindViewById;
        v();
        b(!this.p.get());
        final sg.bigo.ads.ad.interstitial.a.b bVar = ((t) this.y).A;
        if (J() && aj() && bVar != null && !bVar.f14267b && bVar.f14266a) {
            if (bVar.b()) {
                a(i2, bVar);
                return;
            }
            if (sg.bigo.ads.api.a.i.f15457a.p().a()) {
                Runnable runnable = this.Q;
                if (runnable == null) {
                    runnable = new Runnable() { // from class: sg.bigo.ads.ad.interstitial.z.7
                        @Override // java.lang.Runnable
                        public final void run() {
                            sg.bigo.ads.common.n.d.a(z.this.P);
                            bVar.a(this);
                            sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.z.7.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                                    z.this.a(7, bVar);
                                }
                            });
                        }
                    };
                    this.Q = runnable;
                }
                bVar.f14268c = runnable;
                int iB = sg.bigo.ads.api.a.i.f15457a.p().b();
                if (this.D != null && c() == 0 && c() == 10) {
                    f(4);
                    ax();
                    k(false);
                    z();
                    ViewGroup viewGroup = this.D;
                    if (viewGroup != null && (viewFindViewById = viewGroup.findViewById(R.id.inter_layout_playable_loading)) != null) {
                        viewFindViewById.setVisibility(0);
                        int i8 = iB > 0 ? iB : 1;
                        Runnable runnable2 = this.P;
                        if (runnable2 == null) {
                            runnable2 = new Runnable() { // from class: sg.bigo.ads.ad.interstitial.z.8

                                /* JADX INFO: renamed from: b, reason: collision with root package name */
                                final /* synthetic */ int f15247b = 7;

                                @Override // java.lang.Runnable
                                public final void run() {
                                    if (sg.bigo.ads.ad.c.a((sg.bigo.ads.ad.c) z.this.y)) {
                                        return;
                                    }
                                    if (z.this.Q != null) {
                                        bVar.a(z.this.Q);
                                    }
                                    z.this.m(this.f15247b);
                                }
                            };
                            this.P = runnable2;
                        }
                        sg.bigo.ads.common.n.d.a(2, runnable2, ((long) i8) * 1000);
                    }
                    sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) ((t) this.y).f(), c(), 7);
                    return;
                }
            } else if (a(i2, bVar)) {
                return;
            }
        }
        m(i2);
    }

    public final void m(int i2) {
        if (this.D == null) {
            return;
        }
        if (c() != 0 && c() != 10 && c() != 4) {
            sg.bigo.ads.common.t.a.a(0, "RichInterstitialVideoActivityImpl", "end page can be shown but current page is not main or playable loading or mid page.");
            return;
        }
        if (!J() && !this.p.get()) {
            A();
            return;
        }
        this.Y.a();
        ax();
        f(p(i2));
        sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) ((t) this.y).f(), c(), i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(boolean z2) {
        Button button = this.E;
        if (button != null) {
            button.setBackgroundResource(z2 ? R.drawable.bigo_ad_ic_media_mute : R.drawable.bigo_ad_ic_media_unmute);
        }
    }

    private void k(boolean z2) {
        View view;
        int iB;
        TextView textView;
        sg.bigo.ads.api.a.m mVar;
        ViewGroup viewGroup = this.D;
        if (viewGroup == null) {
            return;
        }
        View viewFindViewById = viewGroup.findViewById(R.id.inter_layout_playable_loading);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
        Runnable runnable = new Runnable() { // from class: sg.bigo.ads.ad.interstitial.z.10
            @Override // java.lang.Runnable
            public final void run() {
                sg.bigo.ads.api.a.m mVar2;
                String str;
                z zVar = z.this;
                if (zVar.f14182d) {
                    mVar2 = ((sg.bigo.ads.ad.interstitial.a) zVar).f14181c;
                    str = "endpage.close_click_seconds";
                } else {
                    mVar2 = ((sg.bigo.ads.ad.interstitial.a) zVar).f14180b;
                    str = "interstitial_video_style.endpage.impression_close_seconds";
                }
                z.this.a(((long) mVar2.a(str)) * 1000);
                AdCountDownButton adCountDownButton = z.this.A;
                if (adCountDownButton != null) {
                    adCountDownButton.d();
                }
            }
        };
        sg.bigo.ads.ad.interstitial.c.a aVar = this.S;
        boolean z7 = false;
        if (aVar != null) {
            View viewA = aVar.a(this, this.D, Y());
            runnable.run();
            view = viewA;
        } else {
            View viewFindViewById2 = this.D.findViewById(R.id.inter_end_page);
            if (viewFindViewById2 == null) {
                Context context = this.D.getContext();
                int iAw = aw();
                ViewGroup viewGroup2 = this.D;
                sg.bigo.ads.common.utils.a.a(context, iAw, viewGroup2, viewGroup2 != null);
            }
            View viewFindViewById3 = this.D.findViewById(R.id.inter_layout_end_page);
            if (viewFindViewById3 != null) {
                viewFindViewById3.setVisibility(0);
            }
            if (viewFindViewById2 == null) {
                View viewFindViewById4 = this.D.findViewById(R.id.inter_end_page);
                View viewFindViewById5 = this.D.findViewById(R.id.inter_end_page_image);
                if (viewFindViewById4 != null && viewFindViewById3 != null) {
                    int i2 = this.f14182d ? 9 : 4;
                    u uVarZ = Z();
                    ViewGroup viewGroup3 = this.D;
                    int iY = Y();
                    sg.bigo.ads.api.a.m mVar2 = ((sg.bigo.ads.ad.interstitial.a) this).f14181c;
                    uVarZ.a(viewGroup3, viewFindViewById3, iY, i2, mVar2 == null ? 0 : mVar2.a("endpage.click_type"), viewFindViewById3);
                    View view2 = viewFindViewById5 == null ? viewFindViewById4 : viewFindViewById5;
                    View view3 = viewFindViewById5 == null ? viewFindViewById3 : viewFindViewById4;
                    view2.setTag(5);
                    view3.setTag(9);
                    a(view2, view3);
                    TextView textView2 = (TextView) viewFindViewById4.findViewById(R.id.inter_advertiser);
                    TextView textView3 = (TextView) viewFindViewById4.findViewById(R.id.inter_ad_label);
                    if (TextUtils.isEmpty(this.l)) {
                        textView2.setVisibility(8);
                    } else {
                        textView2.setText(this.l);
                        textView3.setText(R.string.bigo_ad_tag);
                    }
                    c.d(viewFindViewById4);
                    View viewFindViewById6 = viewFindViewById4.findViewById(R.id.inter_btn_cta);
                    boolean z8 = !this.f14182d || ((sg.bigo.ads.ad.interstitial.a) this).f14181c.c("endpage.is_cta_show_animation");
                    if (z8 && viewFindViewById6 != null) {
                        if (this.f14182d) {
                            viewFindViewById6.setBackgroundColor(this.f14185n);
                        }
                        c.e(viewFindViewById6);
                    }
                    runnable.run();
                    sg.bigo.ads.ad.interstitial.e.c cVar = this.f14189s;
                    if (cVar != null) {
                        cVar.a((ViewGroup) viewFindViewById3, 1);
                    }
                    if (aq()) {
                        Context context2 = viewFindViewById4.getContext();
                        if (!TextUtils.isEmpty(this.l) && textView3 != null && context2 != null) {
                            textView3.setText(this.l + " · " + context2.getString(R.string.bigo_ad_tag));
                        }
                        View viewFindViewById7 = viewFindViewById4.findViewById(R.id.inter_btn_end_page_cta_layout);
                        if (z8 && viewFindViewById7 != null) {
                            if (viewFindViewById6 != null) {
                                viewFindViewById6.clearAnimation();
                            }
                            c.e(viewFindViewById7);
                        }
                        if (this.f14182d && (textView = (TextView) viewFindViewById4.findViewById(R.id.inter_company)) != null) {
                            textView.setTextColor(this.f14185n);
                        }
                        d dVar = new d();
                        TextView textView4 = (TextView) viewFindViewById4.findViewById(R.id.inter_title);
                        if (textView4 != null) {
                            dVar.b(textView4);
                        }
                        TextView textView5 = (TextView) viewFindViewById4.findViewById(R.id.inter_description);
                        if (textView5 != null) {
                            dVar.b(textView5);
                        }
                        sg.bigo.ads.api.a.m mVar3 = ((sg.bigo.ads.ad.interstitial.a) this).f14181c;
                        if (mVar3 != null) {
                            int iA = mVar3.a("video_play_page.background_colour");
                            if (iA == 1) {
                                iB = -1;
                            } else if (iA == 2) {
                                iB = ViewCompat.MEASURED_STATE_MASK;
                            } else if (iA == 4) {
                                iB = this.m;
                            } else if (iA == 5) {
                                Z().a(this.D);
                            } else {
                                iB = sg.bigo.ads.common.utils.q.b("#262E33", -7829368);
                            }
                            dVar.a(iB);
                        }
                        IconListView iconListView = (IconListView) viewFindViewById4.findViewById(R.id.inter_iconlist_download_msg_list);
                        if (this.j != null && iconListView != null) {
                            iconListView.setThemeWhite(dVar.f14443c == d.f14441a);
                            iconListView.a(this.j);
                            iconListView.setVisibility(0);
                        }
                    }
                }
            }
            view = viewFindViewById3;
        }
        if (!z2 || view == null || (mVar = ((sg.bigo.ads.ad.interstitial.a) this).f14181c) == null) {
            return;
        }
        int iA2 = this.f14182d ? mVar.a("endpage.below_area_dp") : 0;
        boolean z9 = this.f14182d && ((sg.bigo.ads.ad.interstitial.a) this).f14181c.a("endpage.below_area_clickable") == 1;
        int iA3 = this.f14182d ? ((sg.bigo.ads.ad.interstitial.a) this).f14181c.a("endpage.up_area_dp") : 0;
        if (this.f14182d && ((sg.bigo.ads.ad.interstitial.a) this).f14181c.a("endpage.up_area_clickable") == 1) {
            z7 = true;
        }
        a(view, iA2, z9, iA3, z7, 9, ((sg.bigo.ads.ad.interstitial.a) this).f14181c.a("video_play_page.click_type"));
    }

    public static /* synthetic */ boolean m(z zVar) {
        zVar.W = false;
        return false;
    }

    @Override // sg.bigo.ads.ad.interstitial.a, sg.bigo.ads.ad.interstitial.f.b.InterfaceC0266b
    public final void a(int i2) {
        super.a(i2);
        this.U = true;
        sg.bigo.ads.common.utils.n nVar = this.f14193w;
        if (nVar != null) {
            nVar.b();
            this.f14193w = null;
        }
        if (c() == 0 && i2 == 0 && k() && !l()) {
            Z().f14622b = new e.a() { // from class: sg.bigo.ads.ad.interstitial.z.2
                @Override // sg.bigo.ads.ad.interstitial.e.a
                public final boolean a(Runnable runnable) {
                    z zVar = z.this;
                    return zVar.a(zVar.Z(), runnable);
                }
            };
            q qVar = this.f14188r;
            if (qVar != null) {
                qVar.C = new q.c() { // from class: sg.bigo.ads.ad.interstitial.z.3
                    @Override // sg.bigo.ads.ad.interstitial.q.c
                    public final boolean a(Runnable runnable) {
                        z zVar = z.this;
                        return zVar.a(zVar.f14188r, runnable);
                    }
                };
            }
            this.T.set(true);
            a(this.f14194x, this.f14188r, this.G, this.f14191u, this.f14192v, Z());
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.ad.interstitial.k.b
    public void b(String str) {
        am();
        sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.z.13
            @Override // java.lang.Runnable
            public final void run() {
                z.this.l(4);
            }
        });
    }

    @Override // sg.bigo.ads.ad.interstitial.a
    public boolean f(boolean z2) {
        q qVar;
        T t3;
        sg.bigo.ads.api.a.m mVar;
        String str;
        int iC = c();
        if (!J() && !this.p.get() && iC == 0) {
            as();
            v();
            b(true);
            AdCountDownButton adCountDownButton = this.A;
            if (adCountDownButton != null) {
                adCountDownButton.d();
            }
            q qVar2 = this.f14188r;
            if (qVar2 != null && (qVar2.y.a() || this.f14188r.D)) {
                return false;
            }
            j();
            return !A();
        }
        if (iC == 0 || iC == 10) {
            as();
            if (iC == 10 || (qVar = this.f14188r) == null || !(qVar.y.a() || this.f14188r.D)) {
                l(2);
                return false;
            }
            f(10);
            return false;
        }
        if (iC == 5) {
            boolean zA = A();
            AdCountDownButton adCountDownButton2 = this.A;
            if (adCountDownButton2 != null) {
                adCountDownButton2.d();
                if (!zA) {
                    if (this.f14182d) {
                        mVar = ((sg.bigo.ads.ad.interstitial.a) this).f14181c;
                        str = "endpage.close_click_seconds";
                    } else {
                        mVar = ((sg.bigo.ads.ad.interstitial.a) this).f14180b;
                        str = "interstitial_video_style.endpage.impression_close_seconds";
                    }
                    a(((long) mVar.a(str)) * 1000);
                }
            }
            if (zA && (t3 = this.y) != 0) {
                sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) ((t) t3).f(), 9, this.R);
                return false;
            }
        }
        if (iC != 1 && iC != 7) {
            return z2;
        }
        boolean zA2 = A();
        if (zA2) {
            sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) ((t) this.y).f(), 9, 10);
        }
        return z2 && !zA2;
    }

    private void a(View view, View view2) {
        sg.bigo.ads.api.a.m mVar;
        if (this.D == null) {
            return;
        }
        if (!this.f14182d && ((sg.bigo.ads.ad.interstitial.a) this).f14180b.c("interstitial_video_style.endpage.is_global_click")) {
            ViewGroup viewGroup = this.D;
            if (viewGroup != null) {
                viewGroup.setTag(11);
                a(this.D, 4, ((t) this.y).f15129z, 0);
                return;
            }
            return;
        }
        if (!this.f14182d || (mVar = ((sg.bigo.ads.ad.interstitial.a) this).f14181c) == null) {
            return;
        }
        if (mVar.c("endpage.media_view_clickable_switch")) {
            a(view, 9, ((t) this.y).f15129z, ((sg.bigo.ads.ad.interstitial.a) this).f14181c.a("endpage.click_type"));
        } else {
            a(view, 9, r.F, 0);
        }
        if (((sg.bigo.ads.ad.interstitial.a) this).f14181c.c("endpage.other_space_clickable_switch")) {
            a(view2, 9, ((t) this.y).f15129z, ((sg.bigo.ads.ad.interstitial.a) this).f14181c.a("endpage.click_type"));
        } else {
            a(view2, 9, r.F, 0);
        }
    }

    private void a(@NonNull sg.bigo.ads.ad.interstitial.a.a aVar, @NonNull View view) {
        sg.bigo.ads.api.a.m mVar;
        String str;
        ViewGroup viewGroup = this.D;
        if (viewGroup != null) {
            Context context = viewGroup.getContext();
            int i2 = R.layout.bigo_ad_activity_interstitial_rich_video_empty_end;
            ViewGroup viewGroup2 = this.D;
            sg.bigo.ads.common.utils.a.a(context, i2, viewGroup2, viewGroup2 != null);
            ViewGroup viewGroup3 = (ViewGroup) this.D.findViewById(R.id.inter_layout_end_page);
            if (viewGroup3 == null) {
                sg.bigo.ads.common.t.a.a(0, "RichInterstitialVideoActivityImpl", "playContainer is null.");
                return;
            }
            sg.bigo.ads.ad.interstitial.e.c cVar = this.f14189s;
            if (cVar != null) {
                cVar.a(viewGroup3, 8);
            }
            sg.bigo.ads.common.utils.u.a(view, (ViewGroup) viewGroup3.findViewById(R.id.inter_end_page), new FrameLayout.LayoutParams(-1, -1, 17), -1);
            view.setTag(20);
            this.D.setTag(20);
            a(view, this.D);
            aVar.a(1);
            if (this.f14182d) {
                mVar = ((sg.bigo.ads.ad.interstitial.a) this).f14181c;
                str = "endpage.close_click_seconds";
            } else {
                mVar = ((sg.bigo.ads.ad.interstitial.a) this).f14180b;
                str = "interstitial_video_style.endpage.impression_close_seconds";
            }
            a(((long) mVar.a(str)) * 1000);
            AdCountDownButton adCountDownButton = this.A;
            if (adCountDownButton != null) {
                adCountDownButton.d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(sg.bigo.ads.ad.interstitial.a.b bVar) {
        if (bVar == null || !ar()) {
            return;
        }
        bVar.f14269d = new b.InterfaceC0247b() { // from class: sg.bigo.ads.ad.interstitial.z.20
            @Override // sg.bigo.ads.ad.interstitial.a.b.InterfaceC0247b
            public final void a() {
                sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.z.20.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        AdCountDownButton adCountDownButton;
                        if (z.this.c() != 5 || (adCountDownButton = z.this.A) == null || adCountDownButton.getVisibility() == 0) {
                            return;
                        }
                        z.g(z.this);
                        z.this.y();
                    }
                });
            }
        };
        bVar.a(new a(13));
        sg.bigo.ads.common.t.a.a(0, 3, "RichInterstitialVideoActivityImpl", "begin to preload PlayableResource resource : ".concat(String.valueOf(bVar)));
        bVar.a(this.I);
    }

    private void a(sg.bigo.ads.core.a.a aVar, boolean z2, int i2) {
        long jA;
        if (z2) {
            int iA = x.a(i2);
            if (iA == 0) {
                sg.bigo.ads.common.t.a.a(0, 4, "Interstitial Video", "fill strategy config no auto click, so return");
                return;
            }
            jA = sg.bigo.ads.common.utils.r.f16034a.a(iA);
        } else {
            long jAL = aVar.aL();
            sg.bigo.ads.common.utils.r rVar = sg.bigo.ads.common.utils.r.f16034a;
            if (jAL <= rVar.a(5)) {
                sg.bigo.ads.common.t.a.a(0, 4, "Interstitial Video", "Video duration is less than 5s，can't trigger auto click");
                return;
            }
            int i8 = this.h.j;
            if (i8 == 5) {
                sg.bigo.ads.api.core.n nVarAV = aVar.aV();
                long jAU = nVarAV != null ? nVarAV.f15522c : 0L;
                if (jAU <= 0) {
                    jAU = aVar.aU();
                }
                sg.bigo.ads.api.a.m mVar = ((sg.bigo.ads.ad.interstitial.a) this).f14181c;
                jA = Math.max(0L, jAU - (((long) (mVar != null ? mVar.a("video_play_page.auto_click_sec") : 0)) * 1000));
            } else if (i8 == 2) {
                jA = rVar.a(5);
            } else {
                if (i8 != 4) {
                    return;
                }
                sg.bigo.ads.api.a.m mVar2 = ((sg.bigo.ads.ad.interstitial.a) this).f14181c;
                jA = rVar.a(mVar2 != null ? mVar2.a("video_play_page.auto_click_sec") : 0);
            }
        }
        if (jA == 0) {
            jA = 500;
        }
        sg.bigo.ads.common.utils.n nVar = new sg.bigo.ads.common.utils.n(jA) { // from class: sg.bigo.ads.ad.interstitial.z.4
            @Override // sg.bigo.ads.common.utils.n
            public final void a() {
                if (z.this.U) {
                    return;
                }
                z zVar = z.this;
                if (zVar.e) {
                    return;
                }
                zVar.e = true;
                ((t) zVar.y).f15129z.a(z.i(zVar), 22);
            }

            @Override // sg.bigo.ads.common.utils.n
            public final void a(long j) {
            }
        };
        this.f14193w = nVar;
        nVar.c();
    }

    public void a(boolean z2, boolean z7) {
        AdCountDownButton adCountDownButton = this.A;
        if (adCountDownButton != null) {
            adCountDownButton.d();
        }
        if (z7 && c() == 0) {
            if (L()) {
                j(R.drawable.bigo_ad_ic_close);
            }
            a(this.G, new Runnable() { // from class: sg.bigo.ads.ad.interstitial.z.6
                @Override // java.lang.Runnable
                public final void run() {
                    z.this.ag();
                    q qVar = z.this.f14188r;
                    if (qVar != null) {
                        if (qVar.D) {
                            return;
                        }
                        if (z.this.f14188r.y.a(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.z.6.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                z.this.l(1);
                            }
                        })) {
                            return;
                        }
                    }
                    z.this.l(1);
                }
            });
        }
    }

    public final boolean a(int i2, @NonNull sg.bigo.ads.ad.interstitial.a.b bVar) {
        View view = bVar.f14270f.f14228i;
        if (!bVar.b()) {
            sg.bigo.ads.common.t.a.a(0, "RichInterstitialVideoActivityImpl", "playableAdCompanion is not ResourceReady");
            bVar.f14270f.f();
            return false;
        }
        if (this.D == null) {
            sg.bigo.ads.common.t.a.a(0, "RichInterstitialVideoActivityImpl", "nativeAdView == null.");
            return false;
        }
        if (view == null) {
            sg.bigo.ads.common.t.a.a(0, "RichInterstitialVideoActivityImpl", "playableView == null.");
            return false;
        }
        if (c() != 0 && c() != 10 && c() != 4) {
            sg.bigo.ads.common.t.a.a(0, "RichInterstitialVideoActivityImpl", "playable page can be shown but current page is not main or playable loading or mid page.");
            return false;
        }
        f(5);
        ax();
        av();
        Context context = this.D.getContext();
        int i8 = R.layout.bigo_ad_activity_interstitial_rich_video_empty_end;
        ViewGroup viewGroup = this.D;
        sg.bigo.ads.common.utils.a.a(context, i8, viewGroup, viewGroup != null);
        ViewGroup viewGroup2 = (ViewGroup) this.D.findViewById(R.id.inter_layout_end_page);
        if (viewGroup2 == null) {
            sg.bigo.ads.common.t.a.a(0, "RichInterstitialVideoActivityImpl", "playContainer is null.");
            return false;
        }
        sg.bigo.ads.ad.interstitial.e.c cVar = this.f14189s;
        if (cVar != null) {
            cVar.a(viewGroup2, 4);
        }
        sg.bigo.ads.common.utils.u.a(view, (ViewGroup) viewGroup2.findViewById(R.id.inter_end_page), new FrameLayout.LayoutParams(-1, -1, 17), -1);
        view.setTag(19);
        this.D.setTag(19);
        a(view, this.D);
        if (this.A != null) {
            sg.bigo.ads.api.a.m mVar = ((sg.bigo.ads.ad.interstitial.a) this).f14181c;
            a(((long) (mVar != null ? mVar.a("endpage.close_click_seconds") : sg.bigo.ads.api.a.i.f15457a.p().c())) * 1000);
            this.A.d();
        }
        this.Y.a(view);
        bVar.a(1);
        sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) ((t) this.y).f(), c(), i2);
        return true;
    }

    @Override // sg.bigo.ads.ad.interstitial.a, sg.bigo.ads.ad.interstitial.f.b.InterfaceC0266b
    public final boolean a(@NonNull MotionEvent motionEvent, @Nullable b.a aVar, int i2) {
        Object objZ = Z();
        if ((objZ instanceof sg.bigo.ads.ad.interstitial.f.c) && (objZ instanceof sg.bigo.ads.ad.interstitial.d.a)) {
            sg.bigo.ads.ad.interstitial.d.a aVar2 = (sg.bigo.ads.ad.interstitial.d.a) objZ;
            sg.bigo.ads.ad.interstitial.f.c cVar = (sg.bigo.ads.ad.interstitial.f.c) objZ;
            if (cVar.J() && !cVar.K()) {
                int rawX = (int) motionEvent.getRawX();
                int rawY = (int) motionEvent.getRawY();
                Button buttonM = aVar2.m();
                if (buttonM != null && sg.bigo.ads.common.utils.u.b(buttonM, rawX, rawY)) {
                    if (motionEvent.getAction() == 1) {
                        buttonM.performClick();
                    }
                    return true;
                }
                MediaView mediaViewL = aVar2.l();
                MediaView.a aVarB = mediaViewL != null ? mediaViewL.b() : null;
                if (aVarB != null && aVarB.a() && sg.bigo.ads.common.utils.u.b(mediaViewL, rawX, rawY)) {
                    if (motionEvent.getAction() == 1) {
                        aVarB.b();
                    }
                    return true;
                }
            }
        }
        return super.a(motionEvent, aVar, i2);
    }
}
