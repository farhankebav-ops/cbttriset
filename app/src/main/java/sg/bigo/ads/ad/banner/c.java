package sg.bigo.ads.ad.banner;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.banner.b;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.AdOptionsView;
import sg.bigo.ads.api.AdSize;
import sg.bigo.ads.api.BannerAdRequest;
import sg.bigo.ads.api.b.a;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.core.h.b;
import sg.bigo.ads.core.mraid.n;

/* JADX INFO: loaded from: classes6.dex */
public final class c<T extends Ad> implements b.InterfaceC0236b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    WebView f13960a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    b f13962c;
    Runnable g;
    sg.bigo.ads.core.c.b h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    h f13965i;
    final T j;
    final sg.bigo.ads.api.core.i k;
    final boolean l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public WeakReference<Activity> f13966n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public a f13967o;
    public g p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    AdOptionsView f13968q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    View f13969r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    boolean f13970s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private sg.bigo.ads.core.mraid.e f13971t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private View f13972u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NonNull
    private final n f13973v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Context f13975x;
    private BannerAdRequest y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private AdSize f13976z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13961b = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f13963d = false;
    boolean e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f13964f = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f13974w = false;
    private final View.OnAttachStateChangeListener A = new View.OnAttachStateChangeListener() { // from class: sg.bigo.ads.ad.banner.c.1
        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            sg.bigo.ads.ad.banner.b.e(c.this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            sg.bigo.ads.ad.banner.b.f(c.this);
            view.removeOnAttachStateChangeListener(this);
        }
    };
    final AtomicBoolean m = new AtomicBoolean(false);

    public interface a {
        void a(int i2, int i8);
    }

    public static class b implements a.InterfaceC0277a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private a.InterfaceC0277a f13994c;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f13993b = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Handler f13992a = new Handler();

        public b(a.InterfaceC0277a interfaceC0277a) {
            this.f13994c = interfaceC0277a;
        }

        private boolean c() {
            if (this.f13993b) {
                return true;
            }
            this.f13992a.removeCallbacks(null);
            this.f13993b = true;
            return false;
        }

        public final void a() {
            a(new sg.bigo.ads.api.core.d(3001, 10102, "Adx media load error because of destroying before loaded"));
        }

        @Override // sg.bigo.ads.api.b.a.InterfaceC0277a
        public final void b() {
            a.InterfaceC0277a interfaceC0277a;
            if (c() || (interfaceC0277a = this.f13994c) == null) {
                return;
            }
            interfaceC0277a.b();
        }

        @Override // sg.bigo.ads.api.b.a.InterfaceC0277a
        public final void a(sg.bigo.ads.api.core.d dVar) {
            a.InterfaceC0277a interfaceC0277a;
            if (c() || (interfaceC0277a = this.f13994c) == null) {
                return;
            }
            interfaceC0277a.a(dVar);
        }
    }

    public c(Context context, sg.bigo.ads.api.core.g gVar, T t3, sg.bigo.ads.api.core.i iVar, @NonNull n nVar, h hVar, boolean z2) {
        this.f13975x = context;
        this.j = t3;
        this.k = iVar;
        this.f13973v = nVar;
        this.f13965i = hVar;
        this.l = z2;
        if (gVar != null) {
            sg.bigo.ads.api.b bVar = gVar.f15498c;
            if (bVar instanceof BannerAdRequest) {
                this.y = (BannerAdRequest) bVar;
            }
        }
    }

    public static /* synthetic */ View a(c cVar, View view) {
        LinearLayout linearLayout = new LinearLayout(cVar.f13975x);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        if (view != null) {
            linearLayout.addView(view);
        }
        if (!q.a((CharSequence) cVar.k.l())) {
            if (cVar.f13968q == null) {
                cVar.f13968q = new AdOptionsView(cVar.f13975x);
            }
            AdOptionsView adOptionsView = cVar.f13968q;
            sg.bigo.ads.api.core.i iVar = cVar.k;
            adOptionsView.a(iVar, iVar.l());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(sg.bigo.ads.common.utils.e.a(cVar.f13975x, 16), sg.bigo.ads.common.utils.e.a(cVar.f13975x, 16), 8388659);
            layoutParams.leftMargin = sg.bigo.ads.common.utils.e.a(cVar.f13975x, 10);
            cVar.f13968q.setLayoutParams(layoutParams);
            linearLayout.addView(cVar.f13968q);
        }
        return linearLayout;
    }

    public final void b() {
        try {
            sg.bigo.ads.ad.banner.b.h(this);
            sg.bigo.ads.core.c.b bVar = this.h;
            if (bVar != null) {
                bVar.b();
            }
            b bVar2 = this.f13962c;
            if (bVar2 != null) {
                bVar2.a();
            }
            if (this.g != null) {
                this.g = null;
            }
            sg.bigo.ads.core.mraid.e eVar = this.f13971t;
            if (eVar != null) {
                eVar.e();
                this.f13971t = null;
            }
            View view = this.f13972u;
            if (view != null) {
                view.removeOnAttachStateChangeListener(this.A);
                this.f13972u = null;
            }
            WebView webView = this.f13960a;
            if (webView != null) {
                u.b(webView);
                this.f13960a = null;
            }
        } catch (Throwable unused) {
        }
    }

    @NonNull
    public final View c() {
        if (this.f13972u == null) {
            sg.bigo.ads.common.t.a.a(2, "BannerAd", "The banner ad is not ready, an empty view will be retrieved.");
            this.f13972u = new FrameLayout(this.f13975x);
        }
        sg.bigo.ads.ad.banner.b.d(this);
        this.f13972u.addOnAttachStateChangeListener(this.A);
        return this.f13972u;
    }

    public final String d() {
        sg.bigo.ads.api.core.i iVar = this.k;
        return iVar != null ? iVar.z() : "";
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0053 A[PHI: r0 r1
  0x0053: PHI (r0v11 android.app.Activity) = (r0v6 android.app.Activity), (r0v13 android.app.Activity) binds: [B:37:0x0094, B:21:0x0051] A[DONT_GENERATE, DONT_INLINE]
  0x0053: PHI (r1v3 T extends sg.bigo.ads.api.Ad) = (r1v1 T extends sg.bigo.ads.api.Ad), (r1v6 T extends sg.bigo.ads.api.Ad) binds: [B:37:0x0094, B:21:0x0051] A[DONT_GENERATE, DONT_INLINE]] */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.content.Context e() {
        /*
            r8 = this;
            java.lang.ref.WeakReference<android.app.Activity> r0 = r8.f13966n
            r1 = 3
            r2 = 0
            java.lang.String r3 = "BannerAd"
            if (r0 == 0) goto L22
            java.lang.Object r0 = r0.get()
            android.app.Activity r0 = (android.app.Activity) r0
            if (r0 == 0) goto L22
            java.lang.String r4 = "Interstitial/Reward Video banner ad get activity context from show(Activity activity)."
            sg.bigo.ads.common.t.a.a(r2, r1, r3, r4)
            T extends sg.bigo.ads.api.Ad r4 = r8.j
            boolean r5 = r4 instanceof sg.bigo.ads.ad.c
            if (r5 == 0) goto L23
            sg.bigo.ads.ad.c r4 = (sg.bigo.ads.ad.c) r4
            r5 = 1
            r4.b(r5)
            goto L23
        L22:
            r0 = 0
        L23:
            if (r0 != 0) goto L97
            sg.bigo.ads.api.a.h r4 = sg.bigo.ads.api.a.i.f15457a
            sg.bigo.ads.core.mraid.n r5 = r8.f13973v
            sg.bigo.ads.core.mraid.n r6 = sg.bigo.ads.core.mraid.n.INTERSTITIAL
            r7 = 2
            if (r5 != r6) goto L59
            if (r4 == 0) goto L97
            sg.bigo.ads.api.a.j r4 = r4.n()
            r5 = 16
            boolean r4 = r4.a(r5)
            if (r4 == 0) goto L97
            android.app.Activity r0 = sg.bigo.ads.common.f.b.b()
            if (r0 != 0) goto L48
            java.lang.String r1 = "Interstitial/Reward Video banner ad failed to get activity context."
        L44:
            sg.bigo.ads.common.t.a.a(r2, r3, r1)
            goto L97
        L48:
            java.lang.String r4 = "Interstitial/Reward Video banner ad get activity context from current activity."
            sg.bigo.ads.common.t.a.a(r2, r1, r3, r4)
            T extends sg.bigo.ads.api.Ad r1 = r8.j
            boolean r2 = r1 instanceof sg.bigo.ads.ad.c
            if (r2 == 0) goto L97
        L53:
            sg.bigo.ads.ad.c r1 = (sg.bigo.ads.ad.c) r1
            r1.b(r7)
            goto L97
        L59:
            if (r4 == 0) goto L97
            sg.bigo.ads.api.a.j r4 = r4.n()
            r5 = 17
            boolean r4 = r4.a(r5)
            if (r4 == 0) goto L97
            android.view.View r4 = r8.f13972u     // Catch: java.lang.Exception -> L80
            android.app.Activity r4 = sg.bigo.ads.common.utils.c.a(r4)     // Catch: java.lang.Exception -> L80
            if (r4 == 0) goto L80
            java.lang.String r0 = "Banner ad get activity context from view."
            sg.bigo.ads.common.t.a.a(r2, r1, r3, r0)     // Catch: java.lang.Exception -> L7f
            T extends sg.bigo.ads.api.Ad r0 = r8.j     // Catch: java.lang.Exception -> L7f
            boolean r5 = r0 instanceof sg.bigo.ads.ad.c     // Catch: java.lang.Exception -> L7f
            if (r5 == 0) goto L7f
            sg.bigo.ads.ad.c r0 = (sg.bigo.ads.ad.c) r0     // Catch: java.lang.Exception -> L7f
            r0.b(r1)     // Catch: java.lang.Exception -> L7f
        L7f:
            r0 = r4
        L80:
            if (r0 != 0) goto L97
            android.app.Activity r0 = sg.bigo.ads.common.f.b.b()
            if (r0 != 0) goto L8b
            java.lang.String r1 = "Banner ad failed to get activity context."
            goto L44
        L8b:
            java.lang.String r4 = "Banner ad get activity context from current activity."
            sg.bigo.ads.common.t.a.a(r2, r1, r3, r4)
            T extends sg.bigo.ads.api.Ad r1 = r8.j
            boolean r2 = r1 instanceof sg.bigo.ads.ad.c
            if (r2 == 0) goto L97
            goto L53
        L97:
            if (r0 != 0) goto L9b
            android.content.Context r0 = r8.f13975x
        L9b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.ad.banner.c.e():android.content.Context");
    }

    public final void f() {
        sg.bigo.ads.common.t.a.a(0, 3, "BannerAd", "performImpression");
        sg.bigo.ads.ad.banner.b.g(this);
        T t3 = this.j;
        if (t3 instanceof e) {
            ((e) t3).a(sg.bigo.ads.ad.banner.b.i(this));
        }
        if (this.f13963d) {
            return;
        }
        this.f13963d = true;
        if (this.e) {
            h();
            g();
            sg.bigo.ads.core.c.b bVar = this.h;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    public final void g() {
        if (this.f13960a != null) {
            sg.bigo.ads.common.t.a.a(0, 3, "BannerAd", "javascript:onViewImpression()");
            this.f13960a.loadUrl("javascript:onViewImpression()");
        }
    }

    public final void h() {
        final WebView webView = this.f13960a;
        if (this.f13974w || !(webView instanceof sg.bigo.ads.core.h.b)) {
            return;
        }
        this.f13974w = true;
        sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.ad.banner.c.2
            @Override // java.lang.Runnable
            public final void run() {
                b.C0318b c0318b;
                long j;
                long jA;
                long j3;
                long jA2;
                long j8;
                byte b8 = 0;
                sg.bigo.ads.common.t.a.a(0, 3, "BannerAd", "Notify webView performance stat.");
                sg.bigo.ads.core.h.b bVar = (sg.bigo.ads.core.h.b) webView;
                if (sg.bigo.ads.api.a.i.f15457a.n().a(0) || sg.bigo.ads.api.a.i.f15457a.n().a(1)) {
                    b.C0318b c0318b2 = bVar.h;
                    sg.bigo.ads.core.h.b.a(c0318b2);
                    if (sg.bigo.ads.api.a.i.f15457a.n().a(1)) {
                        if (bVar.f17104i == null) {
                            bVar.f17104i = new b.c(bVar, b8);
                        }
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        c0318b2.f17110d = bVar.f17104i.a();
                        c0318b2.g = SystemClock.elapsedRealtime() - jElapsedRealtime;
                        c0318b2.f17111f = SystemClock.elapsedRealtime();
                    }
                    c0318b = c0318b2;
                } else {
                    c0318b = null;
                }
                if (c0318b != null) {
                    Boolean bool = c0318b.f17109c;
                    if (bool == null && c0318b.f17110d == null) {
                        return;
                    }
                    Boolean bool2 = c0318b.f17110d;
                    if (bool != null) {
                        long j9 = bool.booleanValue() ? 1L : 0L;
                        jA = sg.bigo.ads.ad.banner.b.a(c.this, c0318b.e);
                        j = j9;
                    } else {
                        j = -1;
                        jA = -1;
                    }
                    if (bool2 != null) {
                        long j10 = bool2.booleanValue() ? 1L : 0L;
                        long j11 = c0318b.g;
                        jA2 = sg.bigo.ads.ad.banner.b.a(c.this, c0318b.f17111f);
                        j3 = j10;
                        j8 = j11;
                    } else {
                        j3 = -1;
                        jA2 = -1;
                        j8 = -1;
                    }
                    sg.bigo.ads.common.t.a.a(0, 3, "BannerAd", "Stat check blank resutl.");
                    sg.bigo.ads.core.d.b.a(c.this.k, j, jA, j3, jA2, j8);
                }
            }
        });
    }

    public final AdSize i() {
        List<AdSize> list;
        if (this.f13976z == null) {
            BannerAdRequest bannerAdRequest = this.y;
            if (bannerAdRequest != null && (list = bannerAdRequest.h) != null) {
                Iterator<AdSize> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    AdSize next = it.next();
                    if (!next.f15431a.equals(AdSize.ADAPTIVE)) {
                        this.f13976z = next;
                        break;
                    }
                }
            }
            if (this.f13976z == null) {
                Context context = this.f13975x;
                this.f13976z = sg.bigo.ads.common.utils.e.c(context, context.getResources().getDisplayMetrics().widthPixels) > 720 ? AdSize.LEADERBOARD : AdSize.BANNER;
            }
        }
        return this.f13976z;
    }

    public static TextView a(Context context, boolean z2) {
        if (!z2) {
            return null;
        }
        TextView textView = new TextView(context);
        textView.setText(sg.bigo.ads.common.utils.a.a(context, R.string.bigo_ad_tag, new Object[0]));
        textView.setBackgroundResource(R.drawable.bigo_ad_bg_ad_tag_white_border);
        textView.setTextColor(q.b("#B2FFFFFF", -1));
        textView.setTextSize(9.0f);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setPadding(sg.bigo.ads.common.utils.e.a(context, 3), sg.bigo.ads.common.utils.e.a(context, 1), sg.bigo.ads.common.utils.e.a(context, 3), sg.bigo.ads.common.utils.e.a(context, 1));
        return textView;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0246  */
    @androidx.annotation.UiThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean c(@androidx.annotation.Nullable final sg.bigo.ads.api.b.a.InterfaceC0277a r13) {
        /*
            Method dump skipped, instruction units count: 800
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.ad.banner.c.c(sg.bigo.ads.api.b.a$a):boolean");
    }

    @UiThread
    public final boolean b(@Nullable a.InterfaceC0277a interfaceC0277a) {
        if (this.f13970s) {
            return true;
        }
        boolean zC = c(interfaceC0277a);
        this.f13970s = zC;
        return zC;
    }

    public static TextView a(Context context, boolean z2, String str) {
        if (!z2 || q.a((CharSequence) str)) {
            return null;
        }
        TextView textView = new TextView(context);
        textView.setText(str);
        textView.setBackgroundResource(R.drawable.bigo_ad_banner_advertiser_background);
        textView.setTextColor(-1);
        textView.setTextSize(9.0f);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setMaxWidth(sg.bigo.ads.common.utils.e.a(context, 240));
        textView.setBackgroundColor(q.b("#FFD6D9DB", -7829368));
        textView.setPadding(sg.bigo.ads.common.utils.e.a(context, 4), sg.bigo.ads.common.utils.e.a(context, 1), sg.bigo.ads.common.utils.e.a(context, 4), sg.bigo.ads.common.utils.e.a(context, 1));
        return textView;
    }

    public final void a() {
        if (sg.bigo.ads.common.n.d.b()) {
            b();
        } else {
            sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.ad.banner.c.4
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.b();
                }
            });
        }
    }

    private void a(FrameLayout.LayoutParams layoutParams, int i2, int i8) {
        layoutParams.width = i2;
        layoutParams.height = i8;
        layoutParams.gravity = 17;
        this.f13972u.setMinimumHeight(i8);
    }

    public final void a(final a.InterfaceC0277a interfaceC0277a) {
        sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.ad.banner.c.3
            @Override // java.lang.Runnable
            public final void run() {
                c cVar = c.this;
                if (cVar.f13961b != 0) {
                    if (cVar.b(interfaceC0277a)) {
                        return;
                    }
                    interfaceC0277a.a(new sg.bigo.ads.api.core.d(3001, 10102, "Adx media load error when preload"));
                    return;
                }
                b bVar = cVar.f13962c;
                if (bVar != null) {
                    bVar.a();
                }
                c.this.f13962c = new b(interfaceC0277a);
                final b bVar2 = c.this.f13962c;
                bVar2.f13992a.postDelayed(new Runnable() { // from class: sg.bigo.ads.ad.banner.c.b.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.this.b();
                    }
                }, 15000L);
                c cVar2 = c.this;
                if (cVar2.b(cVar2.f13962c)) {
                    return;
                }
                c.this.f13962c.a(new sg.bigo.ads.api.core.d(3001, 10102, "Adx media load error when preload"));
            }
        });
    }
}
