package sg.bigo.ads.ad.interstitial.h;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.AdCountDownButton;
import sg.bigo.ads.ad.interstitial.i;
import sg.bigo.ads.ad.interstitial.t;
import sg.bigo.ads.ad.interstitial.u;
import sg.bigo.ads.api.a.m;
import sg.bigo.ads.core.h.c;
import sg.bigo.ads.core.h.d;
import sg.bigo.ads.core.h.e;

/* JADX INFO: loaded from: classes6.dex */
public class a extends i<t> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static boolean f14787c = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ProgressBar f14788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    m f14789b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    sg.bigo.ads.common.ac.a f14790d;
    private e e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f14791f;
    private boolean g;

    /* JADX INFO: renamed from: sg.bigo.ads.ad.interstitial.h.a$a, reason: collision with other inner class name */
    public static class C0267a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a f14795a;

        public C0267a(a aVar) {
            this.f14795a = aVar;
        }

        @Override // android.webkit.WebChromeClient
        public final void onProgressChanged(WebView webView, int i2) {
            super.onProgressChanged(webView, i2);
            ProgressBar progressBar = this.f14795a.f14788a;
            if (progressBar == null || i2 <= 5) {
                return;
            }
            if (i2 > 95) {
                i2 = 95;
            }
            progressBar.setProgress(i2);
        }
    }

    public static class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a f14796a;

        public b(a aVar) {
            this.f14796a = aVar;
        }

        @Override // sg.bigo.ads.core.h.d
        public final void a(RenderProcessGoneDetail renderProcessGoneDetail) {
            sg.bigo.ads.core.d.b.a(3002, 10105, "The render process was gone.");
            this.f14796a.ap();
        }

        @Override // sg.bigo.ads.core.h.d, android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (this.f14796a.c() <= 1) {
                a.d(this.f14796a);
            }
            if (!a.f14787c) {
                ViewGroup viewGroup = (ViewGroup) this.f14796a.o(R.id.bigo_ad_bottom_privacy_content);
                if (viewGroup != null) {
                    viewGroup.setVisibility(8);
                }
            } else if (2 == this.f14796a.p()) {
                this.f14796a.d();
            }
            a.n();
        }

        @Override // android.webkit.WebViewClient
        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            int i2;
            sg.bigo.ads.common.ac.a aVar;
            this.f14796a.a();
            this.f14796a.b();
            a aVar2 = this.f14796a;
            if (aVar2.K != 0 && (aVar = aVar2.f14790d) != null && aVar.a()) {
                sg.bigo.ads.api.core.e eVar = new sg.bigo.ads.api.core.e();
                eVar.g = 2;
                ((t) aVar2.K).f15129z.a(aVar2.f14790d.f15579b, eVar);
            }
            super.onPageStarted(webView, str, bitmap);
            final a aVar3 = this.f14796a;
            int i8 = 3;
            if (a.f14787c) {
                int iA = aVar3.f14789b.a("video_play_page.webview_force_time");
                i2 = (iA == 5 || iA == 6 || iA == 7 || iA == 8) ? iA - 3 : 0;
            } else {
                int iA2 = aVar3.f14789b.a("video_play_page.webview2_force_time");
                if (iA2 == 0) {
                    i8 = 0;
                } else if (iA2 == 1 || iA2 == 2 || iA2 == 3 || iA2 == 4) {
                    i8 = iA2 + 1;
                }
                i2 = i8;
            }
            AdCountDownButton adCountDownButton = aVar3.A;
            if (adCountDownButton != null) {
                if (i2 > 0) {
                    adCountDownButton.postDelayed(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.h.a.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (sg.bigo.ads.ad.c.a((sg.bigo.ads.ad.c) a.this.y)) {
                                return;
                            }
                            a.this.A.setVisibility(0);
                        }
                    }, ((long) i2) * 1000);
                } else {
                    adCountDownButton.setVisibility(0);
                }
            }
        }

        @Override // sg.bigo.ads.core.h.d, android.webkit.WebViewClient
        public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }

        @Override // sg.bigo.ads.core.h.d, android.webkit.WebViewClient
        public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }
    }

    public a(@NonNull Activity activity) {
        super(activity);
        this.g = false;
    }

    public static /* synthetic */ boolean n() {
        f14787c = false;
        return false;
    }

    private boolean o() {
        return 1 == this.f14789b.a("video_play_page.is_loading");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int p() {
        m mVar = this.f14789b;
        if (mVar == null) {
            return 1;
        }
        int iA = mVar.a("video_play_page.imp_timing", 1);
        if (1 == iA || 2 == iA) {
            return iA;
        }
        return 1;
    }

    @NonNull
    private u q() {
        return sg.bigo.ads.ad.interstitial.d.a.a(((t) this.y).f15129z);
    }

    @Override // sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void D() {
        super.D();
        e eVar = this.e;
        if (eVar != null) {
            eVar.destroy();
            this.e = null;
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.controller.e.b, sg.bigo.ads.api.core.BaseAdActivityImpl
    public void N() {
        T t3;
        AdCountDownButton adCountDownButton;
        super.N();
        T t7 = this.K;
        if (t7 == 0) {
            ap();
            return;
        }
        m mVarE = ((t) t7).f().e();
        this.f14789b = mVarE;
        if (mVarE == null) {
            ap();
            return;
        }
        e eVarA = e.a(this.I);
        this.e = eVarA;
        if (eVarA == null) {
            ap();
            return;
        }
        ((t) this.K).f15129z.f14036v = false;
        f14787c = true;
        this.f14791f = o(R.id.bigo_web_loading_container);
        int iA = this.f14789b.a("video_play_page.webview_layout", 7);
        if (iA != 7 && iA != 8) {
            iA = 7;
        }
        if (7 == iA && (adCountDownButton = this.A) != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) adCountDownButton.getLayoutParams();
            layoutParams.gravity = 8388659;
            layoutParams.leftMargin = sg.bigo.ads.common.utils.e.a(this.I, 20);
            layoutParams.topMargin = sg.bigo.ads.common.utils.e.a(this.I, 10);
        }
        b();
        a();
        e eVar = this.e;
        if (eVar != null) {
            eVar.setWebViewClient(new b(this));
            this.e.setWebChromeClient(new C0267a(this));
            ViewGroup viewGroup = (ViewGroup) o(R.id.inter_webview_container);
            if (viewGroup != null) {
                sg.bigo.ads.common.utils.u.a(this.e, viewGroup, new FrameLayout.LayoutParams(-1, -1), -1);
                if (1 == p()) {
                    d();
                }
                if (this.K != 0) {
                    this.e.setOnTouchListener(new View.OnTouchListener() { // from class: sg.bigo.ads.ad.interstitial.h.a.1
                        @Override // android.view.View.OnTouchListener
                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            if (a.this.f14790d == null) {
                                a.this.f14790d = new sg.bigo.ads.common.ac.a(a.this.I);
                            }
                            a.this.f14790d.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                }
            }
            ViewGroup viewGroup2 = (ViewGroup) o(R.id.inter_native_ad_view);
            if (viewGroup2 != null && (t3 = this.K) != 0 && ((t) t3).f15129z != null) {
                TextView textView = (TextView) viewGroup2.findViewById(R.id.inter_advertiser);
                TextView textView2 = (TextView) viewGroup2.findViewById(R.id.inter_ad_label);
                String advertiser = ((t) this.K).f15129z.getAdvertiser();
                if (textView != null && textView2 != null) {
                    boolean zIsEmpty = TextUtils.isEmpty(advertiser);
                    textView.setVisibility(zIsEmpty ? 8 : 0);
                    if (!zIsEmpty) {
                        textView.setText(advertiser);
                        textView2.setText(sg.bigo.ads.common.utils.a.a(this.I.getApplicationContext(), R.string.bigo_ad_tag, new Object[0]));
                    }
                }
            }
        }
        this.e.loadUrl(((t) this.K).f().N().a());
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    public final int R() {
        return R.layout.bigo_ad_activity_interstitial_sab;
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    public final boolean S() {
        return false;
    }

    public final int c() {
        int iA = this.f14789b.a("video_play_page.loading_timing");
        if (iA == 2) {
            return 3;
        }
        if (iA != 3) {
            return iA != 4 ? 1 : 10;
        }
        return 5;
    }

    public final void d() {
        ViewGroup viewGroup = (ViewGroup) o(R.id.inter_native_ad_view);
        if (viewGroup != null) {
            q().a(viewGroup, viewGroup, 1, 1, 0, null);
        }
    }

    public boolean k() {
        return false;
    }

    public static /* synthetic */ void d(a aVar) {
        View view = aVar.f14791f;
        if (view != null) {
            aVar.g = false;
            view.setVisibility(8);
        }
    }

    public final void b() {
        if (this.A != null) {
            if (!e() || k()) {
                this.A.setVisibility(8);
            }
        }
    }

    public boolean e() {
        return false;
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    public final boolean f() {
        return false;
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    public final void g(int i2) {
    }

    public final void a() {
        View view;
        if (!this.g && o()) {
            if (this.f14791f == null || this.f14788a == null) {
                View viewO = o(R.id.bigo_web_loading_container);
                this.f14791f = viewO;
                if (viewO != null) {
                    this.f14788a = (ProgressBar) viewO.findViewById(R.id.bigo_ad_webview_loading_progress);
                }
            }
            View view2 = this.f14791f;
            if (view2 != null) {
                view2.setVisibility(0);
                ProgressBar progressBar = this.f14788a;
                if (progressBar != null) {
                    progressBar.setProgress(5);
                }
            }
            int iC = c();
            if (iC > 1 && (view = this.f14791f) != null) {
                view.postDelayed(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.h.a.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (sg.bigo.ads.ad.c.a((sg.bigo.ads.ad.c) a.this.y)) {
                            return;
                        }
                        a.d(a.this);
                    }
                }, ((long) iC) * 1000);
            }
            this.g = true;
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    public final void m() {
    }
}
