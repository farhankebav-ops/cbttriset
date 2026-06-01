package sg.bigo.ads.ad.splash.a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.w;
import sg.bigo.ads.ad.splash.a.c;
import sg.bigo.ads.api.AdOptionsView;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.SplashAdRequest;
import sg.bigo.ads.api.VideoController;
import sg.bigo.ads.api.a.m;
import sg.bigo.ads.api.core.o;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes6.dex */
public final class j implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    protected final m f15384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    protected final m f15385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    protected sg.bigo.ads.ad.splash.b f15386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f15387d = c.a.f15329a;

    @NonNull
    sg.bigo.ads.api.core.g e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f15388f;

    @Nullable
    private View g;

    public j(@NonNull sg.bigo.ads.api.core.g gVar, @NonNull m mVar, @NonNull m mVar2, @NonNull sg.bigo.ads.ad.splash.b bVar) {
        this.f15386c = bVar;
        this.f15384a = mVar;
        this.f15385b = mVar2;
        this.e = gVar;
        this.f15388f = gVar.f15496a.i();
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    public final void a() {
        VideoController videoController;
        if (this.f15387d == c.a.f15330b && (videoController = this.f15386c.f15396x.getVideoController()) != null) {
            videoController.setVideoLifeCallback(new VideoController.VideoLifeCallback() { // from class: sg.bigo.ads.ad.splash.a.j.1
                @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
                public final void onVideoPause() {
                    j.this.f15386c.y();
                }

                @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
                public final void onVideoPlay() {
                    j.this.f15386c.z();
                }

                @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
                public final void onVideoEnd() {
                }

                @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
                public final void onVideoStart() {
                }

                @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
                public final void onMuteChange(boolean z2) {
                }
            });
        }
        sg.bigo.ads.api.core.g gVar = this.f15386c.B;
        final String strL = gVar == null ? "" : gVar.f15497b.l();
        sg.bigo.ads.common.n.d.a(3, new Runnable() { // from class: sg.bigo.ads.ad.splash.a.j.2
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
    public final void c() {
        this.f15387d = c.a.f15332d;
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    @NonNull
    public final int d() {
        return this.f15387d;
    }

    @Override // sg.bigo.ads.ad.splash.a.h
    public final AtomicBoolean i() {
        return new AtomicBoolean(false);
    }

    @Override // sg.bigo.ads.ad.splash.a.h
    public final void a(w wVar) {
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    public final void a(boolean z2) {
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    public final void a(boolean z2, @NonNull ViewGroup viewGroup, int i2) {
        int i8;
        if (z2) {
            View view = this.g;
            if (view == null) {
                this.f15387d = c.a.f15330b;
                sg.bigo.ads.ad.b.c cVar = this.f15386c.f15396x;
                if (cVar != null) {
                    o oVar = (o) cVar.f();
                    String title = null;
                    this.g = sg.bigo.ads.common.utils.a.a(viewGroup.getContext(), sg.bigo.ads.ad.splash.a.b(this.f15384a) ? R.layout.bigo_ad_splash_style_halfscreen_vpaid : R.layout.bigo_ad_splash_style_fullscreen_vpaid, null, false);
                    viewGroup.addView(this.g, 1, new ViewGroup.LayoutParams(-1, -1));
                    viewGroup.setTag(11);
                    MediaView mediaView = (MediaView) viewGroup.findViewById(R.id.bigo_ad_splash_media);
                    if (mediaView != null) {
                        mediaView.setImageBlurBorder(false);
                    }
                    AdOptionsView adOptionsView = (AdOptionsView) viewGroup.findViewById(R.id.bigo_ad_splash_options);
                    ArrayList arrayList = new ArrayList();
                    boolean zB = sg.bigo.ads.ad.splash.a.b(this.f15384a);
                    final ImageView imageView = (ImageView) viewGroup.findViewById(R.id.bigo_ad_splash_icon);
                    if (imageView != null) {
                        imageView.setTag(1);
                        if (zB) {
                            sg.bigo.ads.api.b bVar = this.e.f15498c;
                            if ((bVar instanceof SplashAdRequest) && (i8 = ((SplashAdRequest) bVar).h) != 0) {
                                imageView.setImageResource(i8);
                            }
                        } else {
                            String strC = oVar.av() != null ? oVar.av().c() : null;
                            if (!q.a((CharSequence) strC) && URLUtil.isNetworkUrl(strC)) {
                                sg.bigo.ads.common.p.e.b(this.f15386c.f14024b.e, null, strC, oVar.al(), new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.splash.a.j.3
                                    @Override // sg.bigo.ads.common.p.g
                                    public final void a(int i9, @NonNull String str, String str2) {
                                    }

                                    @Override // sg.bigo.ads.common.p.g
                                    public final void a(@NonNull Bitmap bitmap, @NonNull sg.bigo.ads.common.p.f fVar) {
                                        if (j.this.f15387d == c.a.f15330b) {
                                            imageView.setImageBitmap(bitmap);
                                        }
                                    }
                                });
                            }
                        }
                    }
                    TextView textView = (TextView) viewGroup.findViewById(R.id.bigo_ad_splash_title);
                    if (textView != null) {
                        textView.setTag(2);
                        if (zB) {
                            sg.bigo.ads.api.b bVar2 = this.e.f15498c;
                            if (bVar2 instanceof SplashAdRequest) {
                                title = ((SplashAdRequest) bVar2).f15442i;
                            }
                        } else {
                            title = cVar.getTitle();
                        }
                        if (!TextUtils.isEmpty(title)) {
                            textView.setText(title);
                        }
                    }
                    TextView textView2 = (TextView) viewGroup.findViewById(R.id.inter_splash_advertiser);
                    TextView textView3 = (TextView) viewGroup.findViewById(R.id.inter_splash_adtage);
                    if (textView2 != null && textView3 != null) {
                        if (q.a((CharSequence) this.f15388f)) {
                            textView2.setVisibility(8);
                        } else {
                            textView3.setText(R.string.bigo_ad_tag);
                            textView2.setText(this.f15388f);
                            textView2.setPadding(sg.bigo.ads.common.utils.e.a(textView2.getContext(), 4), sg.bigo.ads.common.utils.e.a(textView2.getContext(), 1), sg.bigo.ads.common.utils.e.a(textView2.getContext(), 4), sg.bigo.ads.common.utils.e.a(textView2.getContext(), 1));
                        }
                    }
                    sg.bigo.ads.core.adview.h hVar = new sg.bigo.ads.core.adview.h() { // from class: sg.bigo.ads.ad.splash.a.j.4
                        @Override // sg.bigo.ads.core.adview.h
                        public final void a(int i9, int i10, int i11, int i12, int i13, int i14) {
                        }
                    };
                    View viewFindViewById = viewGroup.findViewById(R.id.layout_contain_view);
                    int iA = this.f15385b.a("video_play_page.click_type");
                    if (mediaView != null) {
                        mediaView.b().a(this.f15385b.a("video_play_page.media_view_clickable_switch") == 1);
                    }
                    if (viewFindViewById != null) {
                        viewFindViewById.setTag(9);
                        sg.bigo.ads.ad.b.a.a(viewGroup, viewFindViewById, 8, this.f15385b.a("video_play_page.other_space_clickable_switch") == 1 ? cVar : hVar, iA);
                    }
                    cVar.registerViewForInteraction(viewGroup, mediaView, (ImageView) null, adOptionsView, arrayList);
                    if (mediaView != null && sg.bigo.ads.ad.splash.a.b()) {
                        mediaView.getLayoutParams().width = -2;
                        mediaView.getLayoutParams().height = -1;
                    }
                    View viewFindViewById2 = viewGroup.findViewById(R.id.inter_layout_ad_tag);
                    if (viewFindViewById2 != null) {
                        sg.bigo.ads.ad.b.a.a(viewGroup, viewFindViewById2, 8, hVar, iA);
                    }
                    if (viewFindViewById != null) {
                        sg.bigo.ads.ad.splash.a.a(viewGroup, viewFindViewById, this.f15385b.a("video_play_page.below_area_dp"), this.f15385b.a("video_play_page.below_area_clickable") == 1, this.f15385b.a("video_play_page.up_area_dp"), this.f15385b.a("video_play_page.up_area_clickable") == 1, 8, iA, cVar);
                        return;
                    }
                    return;
                }
                return;
            }
            this.f15387d = c.a.f15330b;
            view.setVisibility(0);
            return;
        }
        View view2 = this.g;
        if (view2 != null) {
            this.f15387d = c.a.f15331c;
            view2.setVisibility(8);
            this.f15387d = c.a.f15332d;
        }
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    public final void b() {
    }

    @Override // sg.bigo.ads.ad.splash.a.h
    public final void j() {
    }
}
