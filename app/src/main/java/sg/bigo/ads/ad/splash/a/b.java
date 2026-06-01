package sg.bigo.ads.ad.splash.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.s;
import sg.bigo.ads.ad.interstitial.w;
import sg.bigo.ads.ad.interstitial.x;
import sg.bigo.ads.ad.splash.a.c;
import sg.bigo.ads.api.AdOptionsView;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.NativeAd;
import sg.bigo.ads.api.SplashAdRequest;
import sg.bigo.ads.api.VideoController;
import sg.bigo.ads.api.a.m;
import sg.bigo.ads.api.core.o;
import sg.bigo.ads.common.utils.n;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes6.dex */
public class b implements h {

    @Nullable
    public static Bitmap j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    n f15300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    protected final m f15301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    protected final m f15302c;
    n e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    n f15304f;

    @NonNull
    protected sg.bigo.ads.ad.splash.b h;

    @NonNull
    sg.bigo.ads.api.core.g k;
    private final String l;
    private Runnable m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    private View f15306n;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    AtomicBoolean f15303d = new AtomicBoolean(false);
    final AtomicBoolean g = new AtomicBoolean(false);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f15305i = c.a.f15329a;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f15307o = 0;
    private final List<w> p = new ArrayList();

    public b(@NonNull sg.bigo.ads.api.core.g gVar, @NonNull m mVar, @Nullable m mVar2, @NonNull sg.bigo.ads.ad.splash.b bVar) {
        this.h = bVar;
        this.f15301b = mVar;
        this.f15302c = mVar2;
        this.k = gVar;
        this.l = gVar.f15496a.i();
    }

    private void l() {
        n nVar = this.e;
        if (nVar != null) {
            nVar.b();
            this.e = null;
        }
        if (this.m != null) {
            this.m = null;
        }
    }

    private void m() {
        this.f15305i = c.a.f15332d;
        n nVar = this.f15300a;
        if (nVar != null) {
            nVar.b();
        }
        n nVar2 = this.f15304f;
        if (nVar2 != null) {
            nVar2.b();
        }
        l();
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    public final void a() {
        VideoController videoController;
        if (this.f15305i == c.a.f15330b && (videoController = this.h.f15396x.getVideoController()) != null) {
            videoController.setVideoLifeCallback(new VideoController.VideoLifeCallback() { // from class: sg.bigo.ads.ad.splash.a.b.1
                @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
                public final void onVideoEnd() {
                    if (!b.this.h.C()) {
                        b.this.h.A();
                    }
                    sg.bigo.ads.ad.splash.b bVar = b.this.h;
                    m mVar = bVar.A;
                    if (mVar == null || mVar.a("endpage.endpage_timing", 0) != 2) {
                        return;
                    }
                    bVar.a(8, 1);
                }

                @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
                public final void onVideoPause() {
                    b.this.h.y();
                }

                @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
                public final void onVideoPlay() {
                    b.this.h.z();
                }

                @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
                public final void onVideoStart() {
                    if (b.this.g.compareAndSet(true, false)) {
                        b.this.h();
                        n nVar = b.this.f15300a;
                        if (nVar != null) {
                            nVar.b();
                            b.this.f15300a = null;
                        }
                        b.this.h.x();
                        n nVar2 = b.this.f15304f;
                        if (nVar2 != null) {
                            nVar2.b();
                            b.this.f15304f = null;
                        }
                    }
                }

                @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
                public final void onMuteChange(boolean z2) {
                }
            });
            videoController.setBackupLoadCallback(new VideoController.a() { // from class: sg.bigo.ads.ad.splash.a.b.5
                @Override // sg.bigo.ads.api.VideoController.a
                public final void i(boolean z2) {
                    sg.bigo.ads.common.t.a.a(0, 4, "SplashAd", "backup image loaded when show default backup style, so cancel this timer");
                    n nVar = b.this.e;
                    if (nVar != null) {
                        nVar.b();
                        b.this.e = null;
                    }
                    n nVar2 = b.this.f15300a;
                    if (nVar2 != null) {
                        nVar2.b();
                        b.this.f15300a = null;
                    }
                    b.this.h.x();
                    n nVar3 = b.this.f15304f;
                    if (nVar3 != null) {
                        nVar3.b();
                        b.this.f15304f = null;
                    }
                }
            });
        }
        h();
        sg.bigo.ads.api.core.g gVar = this.h.B;
        final String strL = gVar == null ? "" : gVar.f15497b.l();
        sg.bigo.ads.common.n.d.a(3, new Runnable() { // from class: sg.bigo.ads.ad.splash.a.b.12
            @Override // java.lang.Runnable
            public final void run() {
                sg.bigo.ads.controller.c.a.a(strL);
                sg.bigo.ads.common.x.a.j(strL);
                String str = strL;
                sg.bigo.ads.common.x.a.a(str, sg.bigo.ads.common.x.a.i(str) + 1);
                sg.bigo.ads.common.x.a.a(strL, System.currentTimeMillis());
            }
        });
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    public final void b() {
        l();
        this.f15303d.set(true);
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    public void c() {
        m();
        j = null;
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    @NonNull
    public final int d() {
        return this.f15305i;
    }

    @LayoutRes
    public int e() {
        return (this.f15302c != null && f()) ? sg.bigo.ads.ad.splash.a.b(this.f15301b) ? R.layout.bigo_ad_splash_style_halfscreen : R.layout.bigo_ad_splash_style_fullscreen_immersive : sg.bigo.ads.ad.splash.a.a(this.f15301b);
    }

    public final boolean f() {
        m mVar = this.f15302c;
        return mVar != null && 2 == mVar.a("video_play_page.ad_component_layout", 1);
    }

    public boolean g() {
        return true;
    }

    public final void h() {
        int iA;
        int iMax;
        int iB;
        final int iA2;
        n nVar = this.e;
        if (nVar != null) {
            nVar.b();
            this.e = null;
        }
        final int i2 = -1;
        if (this.g.get() && this.h.f().bh() == null) {
            m mVar = this.f15302c;
            if (mVar != null && (iA2 = x.a(mVar.a("video_play_page.time_for_auto_click", -1))) > 0) {
                n nVar2 = new n(((long) iA2) * 1000) { // from class: sg.bigo.ads.ad.splash.a.b.9
                    @Override // sg.bigo.ads.common.utils.n
                    public final void a() {
                        if (b.this.f15303d.compareAndSet(false, true)) {
                            sg.bigo.ads.common.t.a.a(0, 4, "Interstitial Video", a1.a.q(new StringBuilder("auto click after "), "s", iA2));
                            b.this.h.E();
                        }
                    }

                    @Override // sg.bigo.ads.common.utils.n
                    public final void a(long j3) {
                    }
                };
                this.e = nVar2;
                nVar2.c();
            }
            m mVar2 = this.f15302c;
            if (mVar2 == null || (iB = x.b(mVar2.a("video_play_page.time_for_show_backup", -1))) <= 0) {
                return;
            }
            n nVar3 = new n(((long) iB) * 1000) { // from class: sg.bigo.ads.ad.splash.a.b.2
                @Override // sg.bigo.ads.common.utils.n
                public final void a() {
                    b.this.h.a(10, 13);
                }

                @Override // sg.bigo.ads.common.utils.n
                public final void a(long j3) {
                }
            };
            this.f15304f = nVar3;
            nVar3.c();
            return;
        }
        m mVar3 = this.f15302c;
        if (mVar3 == null || (iA = mVar3.a("video_play_page.auto_click")) < 2 || iA > 7) {
            return;
        }
        if (iA <= 5) {
            i2 = iA;
        } else if (iA == 7 && (iMax = Math.max(0, this.f15301b.a("splash_duration"))) > 0 && this.f15300a != null) {
            i2 = iMax - 1;
        }
        if (i2 >= 0) {
            n nVar4 = new n(((long) i2) * 1000) { // from class: sg.bigo.ads.ad.splash.a.b.10
                @Override // sg.bigo.ads.common.utils.n
                public final void a() {
                    if (b.this.f15303d.compareAndSet(false, true)) {
                        sg.bigo.ads.common.t.a.a(0, 4, "Interstitial Video", a1.a.q(new StringBuilder("auto click after "), "s", i2));
                        b.this.h.E();
                    }
                }

                @Override // sg.bigo.ads.common.utils.n
                public final void a(long j3) {
                }
            };
            this.e = nVar4;
            nVar4.c();
        } else if (iA == 6) {
            this.m = new Runnable() { // from class: sg.bigo.ads.ad.splash.a.b.11
                @Override // java.lang.Runnable
                public final void run() {
                    if (b.this.f15303d.compareAndSet(false, true)) {
                        sg.bigo.ads.common.t.a.a(0, 4, "Interstitial Video", "auto click after ");
                        b.this.h.E();
                    }
                }
            };
        }
    }

    @Override // sg.bigo.ads.ad.splash.a.h
    public final AtomicBoolean i() {
        return this.g;
    }

    @Override // sg.bigo.ads.ad.splash.a.h
    public final void j() {
        Runnable runnable = this.m;
        if (runnable != null) {
            runnable.run();
            this.m = null;
        }
    }

    public final void k() {
        this.f15307o = 2;
        Iterator<w> it = this.p.iterator();
        while (it.hasNext()) {
            it.next().a();
            it.remove();
        }
    }

    public void a(ViewGroup viewGroup, int i2) {
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.bigo_ad_splash_btn_cta_container);
        boolean zG = g();
        if (viewGroup2 != null) {
            if (zG) {
                sg.bigo.ads.ad.splash.a.a(viewGroup2, i2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
    }

    public final void a(@NonNull sg.bigo.ads.ad.b.c cVar, final ImageView imageView) {
        sg.bigo.ads.ad.splash.a.a(cVar, new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.splash.a.b.8
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(Bitmap bitmap) {
                final Bitmap bitmap2 = bitmap;
                imageView.post(new Runnable() { // from class: sg.bigo.ads.ad.splash.a.b.8.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        imageView.setImageBitmap(bitmap2);
                    }
                });
            }
        });
    }

    @Override // sg.bigo.ads.ad.splash.a.h
    public final void a(w wVar) {
        if (wVar == null) {
            return;
        }
        if (j != null) {
            wVar.a();
            return;
        }
        this.p.add(wVar);
        if (this.f15307o == 1) {
            return;
        }
        o oVar = (o) this.h.f15396x.f();
        if (!oVar.aR()) {
            String strAT = oVar.aT();
            if (q.a((CharSequence) strAT)) {
                k();
                return;
            } else {
                this.f15307o = 1;
                sg.bigo.ads.common.p.e.a(this.h.f14024b.e, strAT, oVar.al(), new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.splash.a.b.4
                    @Override // sg.bigo.ads.common.p.g
                    public final void a(int i2, @NonNull String str, String str2) {
                        b.this.k();
                    }

                    @Override // sg.bigo.ads.common.p.g
                    public final void a(@NonNull Bitmap bitmap, @NonNull sg.bigo.ads.common.p.f fVar) {
                        b.j = bitmap;
                        b.this.k();
                    }
                });
                return;
            }
        }
        String strB = sg.bigo.ads.common.o.b(this.h.f14024b.e, oVar.aN());
        if (q.a((CharSequence) strB)) {
            k();
            return;
        }
        this.f15307o = 1;
        final String path = Uri.parse(strB).getPath();
        sg.bigo.ads.common.n.d.a(3, new Runnable() { // from class: sg.bigo.ads.ad.splash.a.b.3
            @Override // java.lang.Runnable
            public final void run() {
                b.j = sg.bigo.ads.common.utils.d.a(Uri.parse(path).getPath(), b.this.h.f14024b.e);
                b.this.k();
            }
        });
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    public void a(boolean z2) {
        if (!z2) {
            n nVar = this.e;
            if (nVar != null) {
                nVar.d();
            }
            n nVar2 = this.f15304f;
            if (nVar2 != null) {
                nVar2.d();
                return;
            }
            return;
        }
        n nVar3 = this.e;
        if (nVar3 != null && nVar3.e()) {
            this.e.c();
        }
        n nVar4 = this.f15304f;
        if (nVar4 == null || !nVar4.e()) {
            return;
        }
        this.f15304f.c();
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    public void a(boolean z2, @NonNull ViewGroup viewGroup, int i2) {
        int i8;
        int i9;
        int i10;
        View view;
        boolean z7;
        String title;
        int i11;
        if (z2) {
            View view2 = this.f15306n;
            if (view2 == null) {
                this.f15305i = c.a.f15330b;
                o oVar = (o) this.h.f15396x.f();
                if (oVar.w() == 2 && !oVar.aZ()) {
                    this.g.set(true);
                }
                this.f15306n = sg.bigo.ads.common.utils.a.a(viewGroup.getContext(), e(), null, false);
                viewGroup.addView(this.f15306n, 1, new ViewGroup.LayoutParams(-1, -1));
                viewGroup.setTag(11);
                MediaView mediaView = (MediaView) viewGroup.findViewById(R.id.bigo_ad_splash_media);
                if (mediaView != null) {
                    mediaView.setImageBlurBorder(false);
                }
                AdOptionsView adOptionsView = (AdOptionsView) viewGroup.findViewById(R.id.bigo_ad_splash_options);
                final sg.bigo.ads.ad.b.c cVar = this.h.f15396x;
                ArrayList arrayList = new ArrayList();
                boolean zB = sg.bigo.ads.ad.splash.a.b(this.f15301b);
                final ImageView imageView = (ImageView) viewGroup.findViewById(R.id.bigo_ad_splash_icon);
                if (imageView != null) {
                    imageView.setTag(1);
                    if (zB) {
                        sg.bigo.ads.api.b bVar = this.k.f15498c;
                        if ((bVar instanceof SplashAdRequest) && (i11 = ((SplashAdRequest) bVar).h) != 0) {
                            imageView.setImageResource(i11);
                        }
                        i8 = 2;
                    } else {
                        String strC = oVar.av() != null ? oVar.av().c() : null;
                        if (q.a((CharSequence) strC) || !URLUtil.isNetworkUrl(strC)) {
                            i8 = 2;
                            a(cVar, imageView);
                        } else {
                            i8 = 2;
                            sg.bigo.ads.common.p.e.b(this.h.f14024b.e, null, strC, oVar.al(), new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.splash.a.b.6
                                @Override // sg.bigo.ads.common.p.g
                                public final void a(int i12, @NonNull String str, String str2) {
                                    b bVar2 = b.this;
                                    if (bVar2.f15305i == c.a.f15330b) {
                                        bVar2.a(cVar, imageView);
                                    }
                                }

                                @Override // sg.bigo.ads.common.p.g
                                public final void a(@NonNull Bitmap bitmap, @NonNull sg.bigo.ads.common.p.f fVar) {
                                    if (b.this.f15305i == c.a.f15330b) {
                                        imageView.setImageBitmap(bitmap);
                                    }
                                }
                            });
                        }
                    }
                } else {
                    i8 = 2;
                }
                TextView textView = (TextView) viewGroup.findViewById(R.id.bigo_ad_splash_title);
                if (textView != null) {
                    textView.setTag(Integer.valueOf(i8));
                    if (zB) {
                        sg.bigo.ads.api.b bVar2 = this.k.f15498c;
                        title = bVar2 instanceof SplashAdRequest ? ((SplashAdRequest) bVar2).f15442i : null;
                    } else {
                        title = cVar.getTitle();
                    }
                    if (!TextUtils.isEmpty(title)) {
                        textView.setText(title);
                    }
                }
                TextView textView2 = (TextView) viewGroup.findViewById(R.id.inter_splash_advertiser);
                TextView textView3 = (TextView) viewGroup.findViewById(R.id.inter_splash_adtage);
                if (q.a((CharSequence) this.l)) {
                    textView2.setVisibility(8);
                    i9 = 8;
                } else {
                    textView3.setText(R.string.bigo_ad_tag);
                    textView2.setText(this.l);
                    i9 = 8;
                    textView2.setPadding(sg.bigo.ads.common.utils.e.a(textView2.getContext(), 4), sg.bigo.ads.common.utils.e.a(textView2.getContext(), 1), sg.bigo.ads.common.utils.e.a(textView2.getContext(), 4), sg.bigo.ads.common.utils.e.a(textView2.getContext(), 1));
                }
                Button button = (Button) viewGroup.findViewById(R.id.bigo_ad_splash_btn_cta);
                if (button != null) {
                    button.setTag(7);
                    if (!TextUtils.isEmpty(cVar.getCallToAction())) {
                        button.setText(cVar.getCallToAction());
                    }
                    arrayList.add(button);
                    if (sg.bigo.ads.ad.splash.a.b()) {
                        button.getLayoutParams().width = sg.bigo.ads.common.utils.e.a(button.getContext(), 333);
                    }
                    Drawable background = button.getBackground();
                    m mVar = this.f15302c;
                    if (mVar != null && (background instanceof GradientDrawable)) {
                        ((GradientDrawable) background).setColor(s.a(cVar, mVar.a("video_play_page.cta_color"), null));
                    }
                }
                TextView textView4 = (TextView) viewGroup.findViewById(R.id.bigo_ad_splash_description);
                if (textView4 != null) {
                    textView4.setTag(6);
                    String description = cVar.getDescription();
                    if (!TextUtils.isEmpty(description)) {
                        textView4.setText(description);
                    }
                    arrayList.add(textView4);
                }
                TextView textView5 = (TextView) viewGroup.findViewById(R.id.inter_warning);
                if (textView5 != null) {
                    textView5.setTag(Integer.valueOf(i9));
                    String warning = cVar.getWarning();
                    if (!TextUtils.isEmpty(warning)) {
                        textView5.setText(warning);
                    }
                    arrayList.add(textView5);
                }
                ImageView imageView2 = (ImageView) viewGroup.findViewById(R.id.splash_rating_star);
                if (imageView2 != null) {
                    String creativeId = cVar.getCreativeId();
                    if (creativeId == null) {
                        creativeId = "";
                    }
                    Bitmap bitmapA = sg.bigo.ads.common.utils.d.a(imageView2.getContext(), (sg.bigo.ads.ad.b.f.a(creativeId, 4) * 0.5f) + 3.5f, R.drawable.bigo_ad_ic_star, R.drawable.bigo_ad_ic_star_normal, R.drawable.bigo_ad_ic_star_half);
                    if (bitmapA != null) {
                        imageView2.setTag(26);
                        imageView2.setImageBitmap(bitmapA);
                    }
                }
                cVar.registerViewForInteraction(viewGroup, mediaView, (ImageView) null, adOptionsView, arrayList);
                if (mediaView != null) {
                    if (sg.bigo.ads.ad.splash.a.b()) {
                        mediaView.getLayoutParams().width = -2;
                        mediaView.getLayoutParams().height = -1;
                    }
                    if (cVar.getCreativeType() == NativeAd.CreativeType.VIDEO) {
                        mediaView.b().a(false);
                    }
                }
                if (this.f15302c != null) {
                    sg.bigo.ads.core.adview.h hVar = new sg.bigo.ads.core.adview.h() { // from class: sg.bigo.ads.ad.splash.a.b.7
                        @Override // sg.bigo.ads.core.adview.h
                        public final void a(int i12, int i13, int i14, int i15, int i16, int i17) {
                        }
                    };
                    View viewFindViewById = viewGroup.findViewById(R.id.layout_contain_view);
                    int iA = this.f15302c.a("video_play_page.click_type");
                    if (mediaView != null) {
                        if (this.f15302c.c("video_play_page.media_view_clickable_switch")) {
                            sg.bigo.ads.ad.b.a.a(viewGroup, mediaView, i9, cVar, iA);
                        } else {
                            sg.bigo.ads.ad.b.a.a(viewGroup, mediaView, i9, hVar, iA);
                        }
                        if (viewFindViewById != null) {
                            viewFindViewById.setTag(9);
                        }
                        if (this.f15302c.c("video_play_page.other_space_clickable_switch")) {
                            mediaView.setOtherClickAreaClick(true);
                            i10 = 8;
                            sg.bigo.ads.ad.b.a.a(viewGroup, viewGroup, 8, cVar, iA);
                            if (viewFindViewById != null) {
                                sg.bigo.ads.ad.b.a.a(viewGroup, viewFindViewById, 8, cVar, iA);
                            }
                        } else {
                            i10 = 8;
                            mediaView.setOtherClickAreaClick(false);
                            sg.bigo.ads.ad.b.a.a(viewGroup, viewGroup, 8, hVar, iA);
                            if (viewFindViewById != null) {
                                sg.bigo.ads.ad.b.a.a(viewGroup, viewFindViewById, 8, hVar, iA);
                            }
                        }
                    } else {
                        i10 = i9;
                    }
                    if (button != null) {
                        sg.bigo.ads.ad.b.a.a(viewGroup, button, i10, cVar, iA);
                    }
                    if (imageView != null) {
                        if (zB) {
                            sg.bigo.ads.ad.b.a.a(viewGroup, imageView, i10, hVar, iA);
                        } else {
                            sg.bigo.ads.ad.b.a.a(viewGroup, imageView, i10, cVar, iA);
                        }
                    }
                    if (textView != null) {
                        if (zB) {
                            sg.bigo.ads.ad.b.a.a(viewGroup, textView, i10, hVar, iA);
                        } else {
                            sg.bigo.ads.ad.b.a.a(viewGroup, textView, i10, cVar, iA);
                        }
                    }
                    View viewFindViewById2 = viewGroup.findViewById(R.id.inter_layout_ad_tag);
                    if (viewFindViewById2 != null) {
                        sg.bigo.ads.ad.b.a.a(viewGroup, viewFindViewById2, i10, hVar, iA);
                    }
                    View viewFindViewById3 = viewGroup.findViewById(R.id.layout_ad_component);
                    if (viewFindViewById3 != null) {
                        viewFindViewById3.setTag(18);
                        if (this.f15302c.c("video_play_page.ad_component_clickable_switch")) {
                            sg.bigo.ads.ad.b.a.a(viewGroup, viewFindViewById3, 8, cVar, iA);
                        } else {
                            sg.bigo.ads.ad.b.a.a(viewGroup, viewFindViewById3, 8, hVar, iA);
                        }
                    }
                    if (viewFindViewById != null) {
                        int iA2 = this.f15302c.a("video_play_page.below_area_dp");
                        if (this.f15302c.a("video_play_page.below_area_clickable") == 1) {
                            view = viewFindViewById;
                            z7 = true;
                        } else {
                            view = viewFindViewById;
                            z7 = false;
                        }
                        sg.bigo.ads.ad.splash.a.a(viewGroup, view, iA2, z7, this.f15302c.a("video_play_page.up_area_dp"), this.f15302c.a("video_play_page.up_area_clickable") == 1, 8, iA, cVar);
                    }
                } else {
                    int iA3 = this.f15301b.a("splash_clickable_area");
                    if (iA3 == 1) {
                        sg.bigo.ads.ad.b.a.a(viewGroup, viewGroup, 1, cVar, 0);
                    } else if (iA3 == i8 && mediaView != null) {
                        mediaView.setOnTouchListener(null);
                    }
                }
                int iA4 = this.f15301b.a("splash_cta_type");
                m mVar2 = this.f15302c;
                if (mVar2 != null) {
                    int iA5 = mVar2.a("video_play_page.is_cta_show_animation");
                    if (iA5 <= 0 || iA5 > 6) {
                        iA5 = 1;
                    }
                    iA4 = iA5 - 1;
                }
                if (iA4 == 5 && button != null) {
                    button.setTextSize(2, 15.0f);
                    button.setBackground(null);
                    View viewFindViewById4 = viewGroup.findViewById(R.id.splash_footer_bg);
                    if (viewFindViewById4 != null) {
                        viewFindViewById4.setVisibility(0);
                        viewFindViewById4.setTag(14);
                        sg.bigo.ads.ad.b.a.a(viewGroup, viewFindViewById4, this.f15302c != null ? 8 : 1, cVar, 0);
                    }
                }
                a(viewGroup, iA4);
                return;
            }
            this.f15305i = c.a.f15330b;
            view2.setVisibility(0);
            return;
        }
        View view3 = this.f15306n;
        if (view3 != null) {
            this.f15305i = c.a.f15331c;
            view3.setVisibility(8);
            m();
        }
    }
}
