package sg.bigo.ads.ad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.webkit.ProxyConfig;
import com.ironsource.adqualitysdk.sdk.i.a0;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import sg.bigo.ads.ad.a;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.AdActivity;
import sg.bigo.ads.api.AdBid;
import sg.bigo.ads.api.AdError;
import sg.bigo.ads.api.AdInteractionListener;
import sg.bigo.ads.api.a.i;
import sg.bigo.ads.api.b.d;
import sg.bigo.ads.api.core.c;
import sg.bigo.ads.api.core.g;
import sg.bigo.ads.api.core.r;
import sg.bigo.ads.common.f.b;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.controller.landing.LandingPageStyleConfig;
import sg.bigo.ads.controller.landing.a;
import sg.bigo.ads.core.e.a.e;

/* JADX INFO: loaded from: classes6.dex */
public abstract class c<T extends Ad, U extends sg.bigo.ads.api.core.c> extends sg.bigo.ads.api.b.a<T, U> implements b.a {
    private AdBid A;
    private final Set<String> B;
    private final Set<String> C;
    private final Map<String, Object> D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    protected AdInteractionListener f14023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public g f14024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    protected View f14025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public sg.bigo.ads.core.e.a.b f14026d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f14027f;
    public boolean g;
    public boolean h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f14028i;
    public boolean j;
    protected long k;
    public long l;
    public sg.bigo.ads.controller.landing.a m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected int f14029n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected int f14030o;
    public int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected boolean f14031q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f14032r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f14033s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f14034t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    public WeakReference<a> f14035u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f14036v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f14037w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f14038x;
    private boolean y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private long f14039z;

    public interface a {
        LandingPageStyleConfig a(Context context, String str, int i2, boolean z2);

        boolean a();
    }

    public c(@NonNull g gVar) {
        super(gVar.f15498c);
        this.e = false;
        this.f14037w = false;
        this.f14027f = false;
        this.f14038x = false;
        this.g = false;
        this.y = false;
        this.h = false;
        this.f14028i = false;
        this.j = false;
        this.B = new HashSet();
        this.C = new HashSet();
        this.f14031q = false;
        this.f14032r = -1;
        this.f14033s = 0L;
        this.f14034t = 0L;
        this.D = new HashMap();
        this.f14036v = true;
        this.f14024b = gVar;
        x();
        y();
        this.S = new sg.bigo.ads.common.v.a();
    }

    private long A() {
        if (this.f14024b.f15496a.O() != null) {
            return r0.b();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        try {
            sg.bigo.ads.controller.landing.a aVar = this.m;
            if (aVar != null) {
                aVar.a();
            }
        } catch (Throwable unused) {
        }
    }

    private void x() {
        sg.bigo.ads.api.core.c cVar = this.f14024b.f15496a;
        r rVarM = i.f15457a.m();
        c.f[] fVarArrC = cVar.C();
        e[] eVarArr = new e[0];
        if (fVarArrC != null && fVarArrC.length > 0) {
            eVarArr = new e[fVarArrC.length];
            for (int i2 = 0; i2 < fVarArrC.length; i2++) {
                eVarArr[i2] = new e(fVarArrC[i2].a(), this.f14024b.f15499d);
            }
        }
        c.f[] fVarArrD = cVar.D();
        e[] eVarArr2 = new e[0];
        if (fVarArrD != null && fVarArrD.length > 0) {
            eVarArr2 = new e[fVarArrD.length];
            for (int i8 = 0; i8 < fVarArrD.length; i8++) {
                eVarArr2[i8] = new e(fVarArrD[i8].a(), this.f14024b.f15499d);
            }
        }
        c.f[] fVarArrE = cVar.E();
        e[] eVarArr3 = new e[0];
        if (fVarArrE != null && fVarArrE.length > 0) {
            eVarArr3 = new e[fVarArrE.length];
            for (int i9 = 0; i9 < fVarArrE.length; i9++) {
                eVarArr3[i9] = new e(fVarArrE[i9].a(), this.f14024b.f15499d);
            }
        }
        c.f[] fVarArrF = cVar.F();
        e[] eVarArr4 = new e[0];
        if (fVarArrF != null && fVarArrF.length > 0) {
            eVarArr4 = new e[fVarArrF.length];
            for (int i10 = 0; i10 < fVarArrF.length; i10++) {
                eVarArr4[i10] = new e(fVarArrF[i10].a(), this.f14024b.f15499d);
            }
        }
        sg.bigo.ads.core.e.a.b bVarA = a(rVarM, eVarArr, eVarArr2, eVarArr3, eVarArr4);
        this.f14026d = bVarA;
        bVarA.b("express_id", cVar.ab());
    }

    private void y() {
        this.e = false;
        this.f14037w = false;
        this.f14027f = false;
        this.f14038x = false;
        this.g = false;
        this.y = false;
        this.h = false;
        this.f14028i = false;
        this.k = 0L;
        this.l = 0L;
        this.A = null;
        this.j = false;
        this.V = 0;
    }

    private int z() {
        c.a aVarO = this.f14024b.f15496a.O();
        if (aVarO != null) {
            return aVarO.a();
        }
        return 0;
    }

    @NonNull
    public sg.bigo.ads.core.e.a.b a(r rVar, e[] eVarArr, e[] eVarArr2, e[] eVarArr3, e[] eVarArr4) {
        return new sg.bigo.ads.core.e.a.b(rVar, eVarArr, eVarArr2, eVarArr3, eVarArr4, sg.bigo.ads.core.d.b.c(this.f14024b.f15496a, this));
    }

    public void a_() {
        if (isExpired() || this.f14028i) {
            b(2000, 2, this.f14028i ? "The ad is destroyed" : "The ad is expired");
            return;
        }
        if (this.y) {
            return;
        }
        this.y = true;
        this.k = SystemClock.elapsedRealtime();
        h();
        AdInteractionListener adInteractionListener = this.f14023a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdImpression();
        }
    }

    @NonNull
    public <ValueType> ValueType b(String str, ValueType valuetype) {
        ValueType valuetype2 = (ValueType) this.D.get(str);
        return valuetype2 != null ? valuetype2 : valuetype;
    }

    @Override // sg.bigo.ads.api.b.a
    public final void c() {
        if (this.e) {
            return;
        }
        this.e = true;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.l = jElapsedRealtime;
        sg.bigo.ads.api.b.a aVar = this.U;
        if (aVar instanceof c) {
            ((c) aVar).l = jElapsedRealtime;
        }
        if (this.f14024b.f15496a.ah()) {
            return;
        }
        d("filled");
        if (this.f14024b.f15496a.N().k() == 1) {
            s();
        }
        if (this.f14024b.f15496a.N().c() == 2) {
            sg.bigo.ads.a.c.a(this.f14024b.e);
        }
        sg.bigo.ads.common.f.b.a(this);
    }

    @Override // sg.bigo.ads.api.b.a
    public final String d() {
        return f().H();
    }

    @Override // sg.bigo.ads.api.Ad
    @CallSuper
    public final void destroy() {
        this.f14028i = true;
        if (sg.bigo.ads.common.n.d.b()) {
            C();
            destroyInMainThread();
        } else {
            sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.ad.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.C();
                    c.this.destroyInMainThread();
                }
            });
        }
        if (this.j) {
            sg.bigo.ads.common.form.a.a(f().hashCode(), 4);
        }
        sg.bigo.ads.common.form.a.b(f().hashCode());
        setAdInteractionListener(null);
        sg.bigo.ads.common.f.b.b(this);
    }

    @Override // sg.bigo.ads.api.b.a
    public final long e() {
        return f().a();
    }

    @Override // sg.bigo.ads.api.b.a
    @NonNull
    public U f() {
        return (U) this.f14024b.f15496a;
    }

    @Override // sg.bigo.ads.api.Ad
    @Nullable
    public AdBid getBid() {
        if (this.A == null) {
            g gVar = this.f14024b;
            sg.bigo.ads.api.core.c cVar = gVar.f15496a;
            this.A = cVar.ak() ? new a.C0227a(gVar, cVar, this.f14026d) : null;
        }
        return this.A;
    }

    @Override // sg.bigo.ads.api.Ad
    @Nullable
    public String getExtraInfo(String str) {
        g gVar = this.f14024b;
        sg.bigo.ads.api.core.c cVar = gVar != null ? gVar.f15496a : null;
        return cVar != null ? cVar.b(str) : "";
    }

    public void h() {
        int i2;
        l();
        int i8 = this.T;
        int i9 = sg.bigo.ads.common.v.a.e;
        if (i8 != i9) {
            sg.bigo.ads.common.v.a aVar = this.S;
            View view = this.f14025c;
            if (aVar.g == i9) {
                sg.bigo.ads.common.t.a.a(0, 4, "OutAppChecker", "Out app status: 4 - start activity from background");
                i2 = sg.bigo.ads.common.v.a.e;
            } else if (sg.bigo.ads.common.v.a.a(view)) {
                sg.bigo.ads.common.t.a.a(0, 4, "OutAppChecker", "Out app status: 5 - Lock screen");
                i2 = sg.bigo.ads.common.v.a.f16054f;
            } else if (sg.bigo.ads.common.v.a.b(view)) {
                sg.bigo.ads.common.t.a.a(0, 4, "OutAppChecker", "Out app status: 3 - Float window");
                i2 = sg.bigo.ads.common.v.a.f16053d;
            } else {
                sg.bigo.ads.common.t.a.a(0, 4, "OutAppChecker", "Out app status: 1 - not outside app");
                i2 = sg.bigo.ads.common.v.a.f16051b;
            }
            this.T = i2;
        }
        this.f14026d.a(this.T);
        this.f14026d.a(this.f14024b.e, false);
        if (a("06002010")) {
            sg.bigo.ads.core.d.b.a(this.f14024b.e, this, (String) b("show_proportion", ""), i(), ((Integer) b("render_style", 0)).intValue(), u(), ((Long) b("attach_render_cost", -1L)).longValue(), SystemClock.elapsedRealtime() - this.l, ((Integer) b("icon_sta", -1)).intValue(), ((Integer) b("img_sta", -1)).intValue(), ((Integer) b("vid_sta", -1)).intValue());
        }
        if (this.f14024b.f15496a.N().k() == 0) {
            s();
        }
    }

    public String i() {
        if (this.f14025c == null) {
            return "";
        }
        return this.f14025c.getWidth() + "x" + this.f14025c.getHeight();
    }

    @Override // sg.bigo.ads.api.Ad
    public boolean isExpired() {
        return this.f14024b.f15496a.J();
    }

    public final void j() {
        AdInteractionListener adInteractionListener = this.f14023a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdOpened();
        }
    }

    @CallSuper
    public void k() {
        AdInteractionListener adInteractionListener = this.f14023a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClosed();
        }
        this.h = true;
    }

    public void l() {
        d("impression");
    }

    public void m() {
        d("clicked");
    }

    public boolean n() {
        return this.y;
    }

    public final int o() {
        return this.f14024b.f15497b.b();
    }

    public final int p() {
        return this.f14024b.f15496a.w();
    }

    public final int q() {
        if (this.f14034t != f().y()) {
            return -1;
        }
        return this.f14032r;
    }

    public final long r() {
        if (this.f14034t != f().y()) {
            return 0L;
        }
        return this.f14033s;
    }

    public void s() {
        if (this.f14024b.f15496a.N().f() > 0) {
            final sg.bigo.ads.controller.landing.a aVar = new sg.bigo.ads.controller.landing.a(this.f14024b.f15496a);
            this.m = aVar;
            final Context context = this.f14024b.e;
            final String strA = aVar.f16682b.a();
            final String strJ = aVar.f16682b.j();
            final int iC = aVar.f16682b.c();
            int i2 = aVar.f16683c;
            if (((i2 == 4 || i2 == 5) && TextUtils.isEmpty(strJ)) || sg.bigo.ads.core.landing.a.a(strA) || TextUtils.isEmpty(strA) || !strA.startsWith(ProxyConfig.MATCH_HTTP)) {
                return;
            }
            if (iC == 0 || iC == 2) {
                final a.InterfaceC0310a interfaceC0310a = new a.InterfaceC0310a() { // from class: sg.bigo.ads.controller.landing.a.3
                    @Override // sg.bigo.ads.controller.landing.a.InterfaceC0310a
                    public final void a(String str) {
                        sg.bigo.ads.common.t.a.a(0, 3, "Preload", "preloadWebView onStart preloadType = " + a.this.f16683c + ", url = " + str);
                    }

                    @Override // sg.bigo.ads.controller.landing.a.InterfaceC0310a
                    public final void a(String str, long j, boolean z2, int i8) {
                        a.this.f16684d = z2;
                        HashMap map = new HashMap();
                        map.put("land_way", String.valueOf(i8));
                        sg.bigo.ads.core.d.b.a(a.this.f16681a, "preload_cost", j, z2 ? 1 : 0, map);
                        sg.bigo.ads.common.t.a.a(0, 3, "Preload", "preload landing page onComplete preloadType=" + a.this.f16683c + ", success = " + z2 + ", cost = " + j + ", url = " + str);
                        if (z2) {
                            return;
                        }
                        a.this.a();
                    }
                };
                sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.controller.landing.a.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        a aVar2 = a.this;
                        int i8 = aVar2.f16683c;
                        if (i8 != 1) {
                            if (i8 == 4 || i8 == 5) {
                                a.a(aVar2, context, strJ, iC, interfaceC0310a);
                                return;
                            }
                            return;
                        }
                        Uri uri = Uri.parse(strA);
                        a.a(a.this, context, uri.getScheme() + "://" + uri.getHost(), iC, interfaceC0310a);
                    }
                });
            }
        }
    }

    @Override // sg.bigo.ads.api.Ad, sg.bigo.ads.api.IconAds
    @CallSuper
    public void setAdInteractionListener(AdInteractionListener adInteractionListener) {
        this.f14023a = adInteractionListener;
    }

    public final void t() {
        if (this.f14038x) {
            return;
        }
        this.f14038x = true;
        this.f14039z = SystemClock.elapsedRealtime();
    }

    public final long u() {
        if (this.f14039z == 0) {
            return 0L;
        }
        return SystemClock.elapsedRealtime() - this.f14039z;
    }

    public final boolean v() {
        WeakReference<a> weakReference = this.f14035u;
        return (weakReference == null || weakReference.get() == null || !this.f14035u.get().a()) ? false : true;
    }

    private void d(String str) {
        if (this.B.contains(str)) {
            a0.i(0, str, "ignore callback action, action = ", 3, "Ad");
            return;
        }
        sg.bigo.ads.api.core.c cVarF = f();
        Map<String, Object> mapA = sg.bigo.ads.core.b.a.a(str, this.f14024b.f15497b, this.R, cVarF, Integer.valueOf(cVarF.aj()), null, null, this);
        str.getClass();
        if (str.equals("impression") || str.equals("clicked")) {
            mapA.put("ad_size", i());
            mapA.put("show_proportion", b("show_proportion", ""));
            mapA.put("render_style", b("render_style", 0));
        }
        sg.bigo.ads.core.b.b.a().a(str, mapA);
    }

    public void a() {
        x();
        y();
    }

    @Override // sg.bigo.ads.api.b.a
    public final void b() {
        if (this.f14037w) {
            return;
        }
        this.f14037w = true;
        this.f14024b.f15498c.g.b();
        if (a("06002008")) {
            sg.bigo.ads.core.d.b.a(this, ((Boolean) b("is_cache", Boolean.FALSE)).booleanValue());
        }
    }

    public final void c(String str) {
        if (q.a((CharSequence) str)) {
            return;
        }
        this.C.add(str);
    }

    private void c(sg.bigo.ads.common.i iVar, int i2, int i8, sg.bigo.ads.api.core.e eVar) {
        long jElapsedRealtime = this.k > 0 ? SystemClock.elapsedRealtime() - this.k : 0L;
        String strB = iVar != null ? iVar.b() : "";
        String strA = iVar != null ? iVar.a() : "";
        if (a("06002011")) {
            g gVar = this.f14024b;
            Context context = gVar.e;
            sg.bigo.ads.api.core.c cVar = gVar.f15496a;
            String strI = i();
            int i9 = eVar.f15486a;
            int i10 = eVar.g;
            int i11 = this.f14029n + 1;
            this.f14029n = i11;
            int i12 = this.f14030o + 1;
            this.f14030o = i12;
            sg.bigo.ads.core.d.b.a(context, cVar, strI, strB, strA, i2, i8, i9, i10, jElapsedRealtime, i11, i12, this);
        }
    }

    @Override // sg.bigo.ads.api.b.a
    public final void a(int i2, int i8, String str) {
        if (this.f14027f) {
            return;
        }
        this.f14027f = true;
        this.f14024b.f15498c.g.b();
        if (!this.f14024b.f15496a.ah() && a("06002008")) {
            sg.bigo.ads.core.d.b.a(this, i2, i8, str);
        }
    }

    @CallSuper
    public final void b(int i2, int i8, String str) {
        StringBuilder sbW = a1.a.w(i2, "onAdError: (", " subCode:", i8, ") ");
        sbW.append(str);
        sg.bigo.ads.common.t.a.a(2, 5, "", sbW.toString());
        AdError adError = new AdError(i2, i8, str);
        sg.bigo.ads.core.d.b.a(this.f14024b.f15496a, adError, n());
        AdInteractionListener adInteractionListener = this.f14023a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdError(adError);
        }
    }

    @CallSuper
    public final void a(int i2, String str) {
        b(i2, 0, str);
    }

    @Override // sg.bigo.ads.common.f.b.a
    public final void a(Activity activity) {
        Intent intent;
        if (activity != null && (activity instanceof AdActivity) && (intent = activity.getIntent()) != null && intent.getIntExtra("ad_identifier", -1) == hashCode() && intent.getBooleanExtra("create_error_flag", false)) {
            String stringExtra = intent.getStringExtra("create_error_msg");
            b(2005, 0, "Activity create error");
            sg.bigo.ads.core.d.b.a(f(), 3000, 10117, stringExtra);
        }
    }

    @CallSuper
    public void a(@Nullable Point point, int i2, int i8, @NonNull sg.bigo.ads.api.core.e eVar) {
        int i9;
        int i10;
        int width;
        int height;
        m();
        this.f14026d.b("action_type", String.valueOf(eVar.f15486a));
        sg.bigo.ads.core.e.a.b bVar = this.f14026d;
        if (point != null) {
            i10 = point.x;
            i9 = point.y;
        } else {
            i9 = 0;
            i10 = 0;
        }
        View view = this.f14025c;
        if (view != null) {
            width = view.getWidth();
            height = this.f14025c.getHeight();
        } else {
            width = 0;
            height = 0;
        }
        bVar.b("click_prop", q.e(q.a("{'x':%d,'y':%d,'ad_w':%d,'ad_h':%d,'x_r':%s,'y_r':%s,'mode':'%s'}", Integer.valueOf(i10), Integer.valueOf(i9), Integer.valueOf(width), Integer.valueOf(height), Float.valueOf(width > 0 ? new BigDecimal(i10 / width).setScale(3, 4).floatValue() : 0.0f), Float.valueOf(height > 0 ? new BigDecimal(i9 / height).setScale(3, 4).floatValue() : 0.0f), (i8 == 1 || i8 == 2) ? "direct" : i8 == 3 ? "confirm" : "unknown")));
        this.f14026d.b("click_source", String.valueOf(i8));
        this.f14026d.b("click_module", String.valueOf(i2));
        int i11 = eVar.f15486a;
        final boolean zA = i11 != 1 ? i11 != 4 ? false : this.f14024b.f15496a.a(8) : this.f14024b.f15496a.a(4);
        final sg.bigo.ads.core.e.a.b bVar2 = this.f14026d;
        final Context context = this.f14024b.e;
        sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.core.e.a.b.1

            /* JADX INFO: renamed from: a */
            final /* synthetic */ Context f16911a;

            /* JADX INFO: renamed from: b */
            final /* synthetic */ boolean f16912b;

            public AnonymousClass1(final Context context2, final boolean zA2) {
                context = context2;
                z = zA2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                b.this.c(context, z);
            }
        });
        sg.bigo.ads.core.d.b.a(this.f14024b.f15496a, 1, eVar, this);
    }

    public final synchronized void a(String str, Object obj) {
        this.D.put(str, obj);
    }

    public void a(sg.bigo.ads.api.b.a aVar) {
        this.U = aVar;
        if (aVar != null) {
            HashMap map = new HashMap();
            sg.bigo.ads.core.d.b.a((Map<String, String>) map, (sg.bigo.ads.api.b.a) this, false);
            this.f14026d.a(map);
        }
    }

    @CallSuper
    public void a(@NonNull d.a<T> aVar) {
    }

    public final void a(@Nullable sg.bigo.ads.common.i iVar, int i2, int i8, @NonNull sg.bigo.ads.api.core.e eVar) {
        if (isExpired() || this.f14028i) {
            b(2000, 3, this.f14028i ? "The ad is destroyed" : "The ad is expired");
        } else if (z() != 2 || (n() && SystemClock.elapsedRealtime() - this.k >= A())) {
            b(iVar, i2, i8, eVar);
        }
    }

    public final void a(@Nullable sg.bigo.ads.common.i iVar, @NonNull sg.bigo.ads.api.core.e eVar) {
        a(iVar, 0, 1, eVar);
    }

    public final void b(String str) {
        if (q.a((CharSequence) str)) {
            return;
        }
        this.B.add(str);
    }

    public final boolean a(String str) {
        return !this.C.contains(str);
    }

    public static boolean a(c cVar) {
        return cVar == null || cVar.f14028i;
    }

    private void b(@Nullable sg.bigo.ads.common.i iVar, int i2, int i8, @NonNull sg.bigo.ads.api.core.e eVar) {
        this.p = i2;
        if (!this.g && !this.f14028i) {
            this.g = true;
            a(iVar != null ? iVar.f15793b : null, i2, i8, eVar);
        }
        c(iVar, i2, i8, eVar);
        AdInteractionListener adInteractionListener = this.f14023a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
    }

    @MainThread
    public void destroyInMainThread() {
    }
}
