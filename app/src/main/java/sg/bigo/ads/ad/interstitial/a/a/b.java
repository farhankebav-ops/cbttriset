package sg.bigo.ads.ad.interstitial.a.a;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import sg.bigo.ads.ad.banner.b;
import sg.bigo.ads.ad.banner.h;
import sg.bigo.ads.ad.interstitial.a.b.b;
import sg.bigo.ads.ad.interstitial.t;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.common.i;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.controller.landing.d;
import sg.bigo.ads.core.c.c;
import sg.bigo.ads.core.f.a.a;
import sg.bigo.ads.core.f.a.p;
import sg.bigo.ads.core.mraid.c;
import sg.bigo.ads.core.mraid.e;
import sg.bigo.ads.core.mraid.n;

/* JADX INFO: loaded from: classes6.dex */
public final class b implements b.InterfaceC0236b, sg.bigo.ads.ad.interstitial.a.b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    final sg.bigo.ads.api.core.c f14223a;
    long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    sg.bigo.ads.core.c.b f14227f;
    public h g;
    WebView h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f14228i;
    boolean j;
    boolean k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    final b.a f14229n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f14230o;
    private final String p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final a.C0316a f14231q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    private final sg.bigo.ads.core.player.c f14232r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    private final p f14233s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NonNull
    private final Ad f14234t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private e f14235u;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f14224b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f14225c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f14226d = false;
    boolean l = false;
    final C0245b m = new C0245b(0);

    public final class a {
        private a() {
        }

        @JavascriptInterface
        public final void gameEnd(String str) {
            b.a aVar = b.this.f14229n;
            if (aVar != null) {
                aVar.b();
            }
        }

        @JavascriptInterface
        public final void onBGNDomContentLoaded() {
            b bVar = b.this;
            bVar.k = true;
            b.a aVar = bVar.f14229n;
            if (aVar != null) {
                aVar.c(bVar.f14223a, SystemClock.elapsedRealtime() - b.this.e);
            }
        }

        @JavascriptInterface
        public final void onBGNLoaded() {
            b bVar = b.this;
            bVar.j = true;
            b.a aVar = bVar.f14229n;
            if (aVar != null) {
                aVar.b(bVar.f14223a, SystemClock.elapsedRealtime() - b.this.e);
            }
        }

        public /* synthetic */ a(b bVar, byte b8) {
            this();
        }
    }

    /* JADX INFO: renamed from: sg.bigo.ads.ad.interstitial.a.a.b$b, reason: collision with other inner class name */
    public static final class C0245b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f14240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f14241b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private WeakReference<Activity> f14242c;

        private C0245b() {
            this.f14240a = false;
            this.f14241b = -1;
        }

        private void b() {
            if (this.f14240a) {
                int i2 = this.f14241b;
                this.f14241b = -1;
                if (i2 == 0 || i2 == 1) {
                    WeakReference<Activity> weakReference = this.f14242c;
                    Activity activity = weakReference == null ? null : weakReference.get();
                    if (activity == null) {
                        return;
                    }
                    activity.setRequestedOrientation(i2);
                }
            }
        }

        public final void a() {
            this.f14240a = true;
            b();
        }

        public /* synthetic */ C0245b(byte b8) {
            this();
        }

        public final void a(Activity activity, int i2) {
            this.f14241b = i2;
            this.f14242c = new WeakReference<>(activity);
            b();
        }
    }

    public b(@NonNull Ad ad, @NonNull sg.bigo.ads.api.core.c cVar, @Nullable sg.bigo.ads.core.player.c cVar2, @Nullable p pVar, @Nullable a.C0316a c0316a, @Nullable b.a aVar) {
        this.f14231q = c0316a;
        this.p = c0316a == null ? null : c0316a.f16997b;
        this.f14232r = cVar2;
        this.f14233s = pVar;
        this.f14234t = ad;
        this.f14223a = cVar;
        this.f14229n = aVar;
        this.f14230o = !TextUtils.isEmpty(r7);
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    @Nullable
    public final View a() {
        return this.f14228i;
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final boolean b() {
        if (this.f14230o) {
            return this.f14225c;
        }
        return false;
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void c() {
        sg.bigo.ads.common.t.a.a(0, 3, "HtmlVastCompanion", "resume");
        e eVar = this.f14235u;
        if (eVar != null) {
            eVar.d();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void d() {
        sg.bigo.ads.common.t.a.a(0, 3, "HtmlVastCompanion", "pause");
        e eVar = this.f14235u;
        if (eVar != null) {
            eVar.a(false);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void e() {
        sg.bigo.ads.common.t.a.a(0, 3, "HtmlVastCompanion", "release");
        sg.bigo.ads.ad.banner.b.h(this);
        sg.bigo.ads.core.c.b bVar = this.f14227f;
        if (bVar != null) {
            bVar.b();
        }
        e eVar = this.f14235u;
        if (eVar != null) {
            eVar.e();
            this.f14235u = null;
        }
        WebView webView = this.h;
        if (webView != null) {
            u.b(webView);
            this.h = null;
        }
        this.g = null;
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void f() {
        b.a aVar;
        if (this.j || this.k || this.l || (aVar = this.f14229n) == null || this.e <= 0) {
            return;
        }
        aVar.d(this.f14223a, SystemClock.elapsedRealtime() - this.e);
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void a(int i2) {
        if (i2 == 1) {
            this.m.a();
            sg.bigo.ads.core.player.c cVar = this.f14232r;
            if (cVar != null) {
                cVar.b();
            }
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void a(int i2, int i8) {
        int i9;
        int i10;
        WebView webView = this.h;
        if (webView == null) {
            return;
        }
        Context context = webView.getContext();
        a.C0316a c0316a = this.f14231q;
        int i11 = 0;
        if (c0316a != null) {
            i10 = c0316a.f16998c;
            i9 = c0316a.f16999d;
        } else {
            i9 = 0;
            i10 = 0;
        }
        if (sg.bigo.ads.common.utils.e.a(context, i10) <= i2 && sg.bigo.ads.common.utils.e.a(context, i9) <= i8) {
            i11 = i10;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.h.getLayoutParams();
        if (i11 <= 0 || i9 <= 0) {
            layoutParams.width = i2;
            layoutParams.height = i8;
        } else {
            layoutParams.gravity = 17;
            layoutParams.width = sg.bigo.ads.common.utils.e.a(context, i11);
            layoutParams.height = sg.bigo.ads.common.utils.e.a(context, i9);
        }
    }

    public final void a(Context context, String str, i iVar) {
        sg.bigo.ads.api.core.e eVarA;
        sg.bigo.ads.common.t.a.a(0, 3, "HtmlVastCompanion", "handle ad click.");
        b.a aVar = this.f14229n;
        if (aVar == null || !aVar.c()) {
            str = null;
        }
        String str2 = str;
        if (this.f14223a.f().c() == 0 || !(this.f14234t instanceof sg.bigo.ads.ad.c)) {
            eVarA = sg.bigo.ads.ad.interstitial.a.a.a.a(context, this.f14234t, this.f14223a, str2, this.f14233s, this.f14231q);
            eVarA.g = 0;
        } else {
            Context context2 = this.f14228i.getContext();
            Ad ad = this.f14234t;
            d.a(context2, (sg.bigo.ads.ad.c<?, ?>) (ad instanceof t ? ((t) ad).f15129z : (sg.bigo.ads.ad.c) ad));
            eVarA = new sg.bigo.ads.api.core.e();
            eVarA.g = 1;
        }
        sg.bigo.ads.core.player.c cVar = this.f14232r;
        if (cVar != null && !cVar.c()) {
            this.f14232r.a();
        }
        h hVar = this.g;
        if (hVar != null) {
            hVar.a(iVar, eVarA);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final boolean a(final Context context) {
        int i2;
        int i8;
        byte b8 = 0;
        if (!this.f14230o) {
            return false;
        }
        if (this.f14235u == null) {
            try {
                this.f14235u = new e(context, n.INTERSTITIAL);
            } catch (NoClassDefFoundError unused) {
                sg.bigo.ads.common.t.a.a(0, "HtmlVastCompanion", "Banner webview is not support");
            }
            e eVar = this.f14235u;
            if (eVar == null) {
                return false;
            }
            eVar.g = new e.b() { // from class: sg.bigo.ads.ad.interstitial.a.a.b.1
                @Override // sg.bigo.ads.core.mraid.e.b
                public final void a() {
                    b bVar = b.this;
                    bVar.f14225c = true;
                    bVar.f14226d = false;
                    bVar.f14227f = c.a.f16863a.a(b.this.h, new View[0]);
                    b bVar2 = b.this;
                    if (bVar2.f14224b) {
                        if (bVar2.h != null) {
                            sg.bigo.ads.common.t.a.a(0, 3, "HtmlVastCompanion", "javascript:onViewImpression()");
                            bVar2.h.loadUrl("javascript:onViewImpression()");
                        }
                        sg.bigo.ads.core.c.b bVar3 = b.this.f14227f;
                        if (bVar3 != null) {
                            bVar3.a();
                        }
                    }
                    sg.bigo.ads.ad.banner.b.b(b.this);
                    b.a aVar = b.this.f14229n;
                    if (aVar != null) {
                        aVar.a();
                    }
                }

                @Override // sg.bigo.ads.core.mraid.e.b
                public final void b() {
                    b bVar = b.this;
                    bVar.f14226d = false;
                    bVar.l = true;
                    sg.bigo.ads.ad.banner.b.c(bVar);
                    b bVar2 = b.this;
                    b.a aVar = bVar2.f14229n;
                    if (aVar != null) {
                        aVar.a(bVar2.f14223a, SystemClock.elapsedRealtime() - b.this.e);
                    }
                }

                @Override // sg.bigo.ads.core.mraid.e.b
                public final void c() {
                    sg.bigo.ads.common.t.a.a(0, "HtmlVastCompanion", "onRenderProcessGone");
                }

                @Override // sg.bigo.ads.core.mraid.e.b
                public final void d() {
                    sg.bigo.ads.common.t.a.a(0, 3, "HtmlVastCompanion", "onExpand");
                }

                @Override // sg.bigo.ads.core.mraid.e.b
                public final void e() {
                    sg.bigo.ads.common.t.a.a(0, 3, "HtmlVastCompanion", "onResize");
                }

                @Override // sg.bigo.ads.core.mraid.e.b
                public final void f() {
                    h hVar = b.this.g;
                    if (hVar != null) {
                        hVar.a();
                    }
                }

                @Override // sg.bigo.ads.core.mraid.e.b
                public final void g() {
                    h hVar = b.this.g;
                    if (hVar != null) {
                        hVar.a();
                    }
                }

                @Override // sg.bigo.ads.core.mraid.e.b
                public final void a(@NonNull String str, @Nullable i iVar) {
                    b.this.a(context, str, iVar);
                }

                @Override // sg.bigo.ads.core.mraid.e.b
                public final boolean b(Activity activity, int i9) {
                    b.this.m.a(activity, i9);
                    return true;
                }

                @Override // sg.bigo.ads.core.mraid.e.b
                public final boolean a(Activity activity, int i9) {
                    b.this.m.a(activity, i9);
                    return true;
                }
            };
            String strC = a1.a.C(a1.a.C(c.a.f16863a.c(this.p), "\n<script>document.addEventListener('DOMContentLoaded',function(){BGN_PLAYABLE.onBGNDomContentLoaded()});\nwindow.addEventListener('load',function(){BGN_PLAYABLE.onBGNLoaded()});</script>"), "\n<script type=\"text/javascript\">\n    document.body.style.margin = '0px';\n</script>");
            this.e = SystemClock.elapsedRealtime();
            b.a aVar = this.f14229n;
            if (aVar != null) {
                aVar.a(this.f14223a);
            }
            this.f14235u.a(strC, new e.d() { // from class: sg.bigo.ads.ad.interstitial.a.a.b.2
                @Override // sg.bigo.ads.core.mraid.e.d
                public final void a() {
                    sg.bigo.ads.common.t.a.a(0, 3, "HtmlVastCompanion", "onReady");
                }
            });
            this.f14226d = true;
            sg.bigo.ads.common.utils.t.a();
        }
        c.C0321c c0321cB = this.f14235u.b();
        this.h = c0321cB;
        if (c0321cB != null) {
            c0321cB.setOverScrollMode(2);
            this.h.setHorizontalScrollBarEnabled(false);
            this.h.setHorizontalScrollbarOverlay(false);
            this.h.setVerticalScrollBarEnabled(false);
            this.h.setVerticalScrollbarOverlay(false);
            this.h.getSettings().setSupportZoom(false);
            this.h.setBackgroundColor(-1);
            a.C0316a c0316a = this.f14231q;
            if (c0316a != null) {
                i8 = c0316a.f16998c;
                i2 = c0316a.f16999d;
            } else {
                i2 = 0;
                i8 = 0;
            }
            WebView webView = this.h;
            if (webView != null) {
                Object parent = webView.getParent();
                if (parent instanceof FrameLayout) {
                    this.f14228i = (View) parent;
                    sg.bigo.ads.ad.banner.b.a(this);
                    Context context2 = webView.getContext();
                    int i9 = context2.getResources().getDisplayMetrics().widthPixels;
                    int iC = sg.bigo.ads.common.utils.e.c(context2);
                    if (sg.bigo.ads.common.utils.e.a(context2, i8) > i9 || sg.bigo.ads.common.utils.e.a(context2, i2) > iC) {
                        i8 = 0;
                    }
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) webView.getLayoutParams();
                    if (i8 <= 0 || i2 <= 0) {
                        layoutParams.width = -1;
                        layoutParams.height = -1;
                    } else {
                        layoutParams.gravity = 17;
                        layoutParams.width = sg.bigo.ads.common.utils.e.a(context2, i8);
                        layoutParams.height = sg.bigo.ads.common.utils.e.a(context2, i2);
                    }
                }
            }
            this.h.addJavascriptInterface(new a(this, b8), "BGN_PLAYABLE");
        }
        return true;
    }
}
