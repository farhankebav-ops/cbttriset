package sg.bigo.ads.controller.landing;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.text.TextUtils;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.CallSuper;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.mlkit.common.MlKitException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import sg.bigo.ads.api.b.f;
import sg.bigo.ads.common.u.g;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.common.utils.r;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.core.h.e;
import sg.bigo.ads.core.landing.WebViewActivityImpl;

/* JADX INFO: loaded from: classes6.dex */
public class c extends WebViewActivityImpl implements f {
    private final ValueCallback<Boolean> E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f16711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f16712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f16713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f16714d;
    private int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f16715f;
    private final int g;
    private final long h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private sg.bigo.ads.controller.landing.a f16716i;
    private boolean j;
    private final int k;
    private final List<f.a> l;
    private int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG, to = 100)
    private int f16717n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f16718o;
    private final String p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    private WebHistoryItem f16719q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f16720r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public sg.bigo.ads.ad.c<?, ?> f16721s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    protected sg.bigo.ads.api.core.c f16722t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected boolean f16723u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected int f16724v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    protected boolean f16725w;

    public static class a implements f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f16728a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f16729b;

        private a(int i2, long j) {
            this.f16728a = i2;
            this.f16729b = System.currentTimeMillis() - j;
        }

        @Override // sg.bigo.ads.api.b.f.a
        public final int a() {
            return this.f16728a;
        }

        @Override // sg.bigo.ads.api.b.f.a
        public final long b() {
            return this.f16729b;
        }

        public /* synthetic */ a(int i2, long j, byte b8) {
            this(i2, j);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x008f. Please report as an issue. */
    public c(@NonNull Activity activity) {
        int intExtra;
        int i2;
        super(activity);
        this.f16711a = MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE;
        this.f16713c = -1L;
        this.f16714d = 0;
        this.f16715f = false;
        this.l = new ArrayList();
        this.m = 0;
        this.f16717n = 0;
        this.f16718o = 0;
        this.f16725w = false;
        this.E = new ValueCallback<Boolean>() { // from class: sg.bigo.ads.controller.landing.c.1
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(Boolean bool) {
                Boolean bool2 = bool;
                if (c.this.f17124z != null) {
                    if (bool2 == null || !bool2.booleanValue()) {
                        ViewParent parent = c.this.f17124z.getParent();
                        if (parent instanceof ViewGroup) {
                            TransitionSet transitionSet = new TransitionSet();
                            transitionSet.addTransition(new Fade(1));
                            transitionSet.setDuration(300L);
                            TransitionManager.beginDelayedTransition((ViewGroup) parent, transitionSet);
                        }
                    }
                    c.this.f17124z.setEnabled(true);
                    c.this.f17124z.setVisibility(0);
                }
            }
        };
        Intent intent = this.I.getIntent();
        int i8 = -1;
        if (intent != null) {
            int intExtra2 = intent.getIntExtra("ad_identifier", -1);
            this.k = intent.getIntExtra("land_way", -1);
            intExtra = intent.getIntExtra("webview_force_time", -1);
            i8 = intExtra2;
        } else {
            this.k = -1;
            intExtra = -1;
        }
        sg.bigo.ads.ad.c<?, ?> cVarB = d.b(i8);
        this.f16721s = cVarB;
        if (cVarB != null) {
            this.f16722t = cVarB.f();
            this.g = this.f16721s.q();
            this.h = this.f16721s.r();
            this.f16716i = this.f16721s.m;
            this.f16712b = this.f16722t.N().e();
            this.e = this.f16722t.d().f();
        } else {
            this.g = 0;
            this.h = System.currentTimeMillis();
        }
        switch (intExtra) {
            case -1:
                this.f16720r = false;
                this.f16723u = false;
                this.f16724v = 0;
                break;
            case 0:
            default:
                this.f16720r = true;
                this.f16723u = false;
                this.f16724v = 0;
                break;
            case 1:
            case 2:
            case 3:
            case 4:
                this.f16720r = false;
                this.f16723u = true;
                i2 = intExtra + 1;
                this.f16724v = i2;
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                this.f16720r = true;
                this.f16723u = false;
                i2 = intExtra - 3;
                this.f16724v = i2;
                break;
        }
        this.p = a(activity);
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl, sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void D() {
        super.D();
        sg.bigo.ads.controller.landing.a aVar = this.f16716i;
        if (aVar != null) {
            aVar.f16684d = false;
            this.f16716i = null;
        }
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl, sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void N() {
        this.f16713c = SystemClock.elapsedRealtime();
        c(1);
        super.N();
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl, sg.bigo.ads.api.core.BaseAdActivityImpl
    @CallSuper
    public void X() {
        super.X();
        if (this.f16721s != null) {
            d.a();
            this.f16721s = null;
        }
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl, sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void g(boolean z2) {
        if (z2) {
            ao();
        }
    }

    public int h() {
        return 0;
    }

    @Override // sg.bigo.ads.api.b.f
    public final String i() {
        return this.C;
    }

    @Override // sg.bigo.ads.api.b.f
    public final int j() {
        return this.m;
    }

    @Override // sg.bigo.ads.api.b.f
    public final int k() {
        return this.f16718o;
    }

    @Override // sg.bigo.ads.api.b.f
    public final int l() {
        return this.f16717n;
    }

    @Override // sg.bigo.ads.api.b.f
    public final boolean m() {
        sg.bigo.ads.controller.landing.a aVar = this.f16716i;
        return aVar != null && aVar.f16684d;
    }

    @Override // sg.bigo.ads.api.b.f
    public final int n() {
        return this.g;
    }

    @Override // sg.bigo.ads.api.b.f
    public final int o() {
        return this.k;
    }

    @Override // sg.bigo.ads.api.b.f
    @Nullable
    public final Map<String, String> p() {
        return null;
    }

    public final void q() {
        ImageView imageView = this.f17124z;
        if (imageView != null) {
            imageView.setVisibility(4);
            this.f17124z.setEnabled(false);
        }
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl
    @Nullable
    public final WebView r() {
        e eVar;
        sg.bigo.ads.controller.landing.a aVar = this.f16716i;
        e eVar2 = null;
        if (aVar != null && aVar.b() && (eVar = aVar.f16685f) != null) {
            u.b(eVar);
            e eVar3 = aVar.f16685f;
            aVar.f16685f = null;
            eVar2 = eVar3;
        }
        if (eVar2 == null) {
            return super.r();
        }
        this.j = true;
        return eVar2;
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl
    public final void s() {
        c(2);
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl
    public final void t() {
        if (this.B == null) {
            return;
        }
        sg.bigo.ads.controller.landing.a aVar = this.f16716i;
        if (aVar != null) {
            if (aVar.f16683c == 2 && !q.a((CharSequence) aVar.e)) {
                this.B.loadDataWithBaseURL(this.C, this.f16716i.e, "text/html", Key.STRING_CHARSET_NAME, null);
                c(3);
                return;
            }
            int i2 = this.f16716i.f16683c;
            if (i2 == 3 && this.j) {
                this.D = SystemClock.elapsedRealtime();
                b(this.B.getTitle());
                if (this.f16716i.f16684d) {
                    ProgressBar progressBar = this.y;
                    if (progressBar != null) {
                        progressBar.setAlpha(0.0f);
                    }
                    a(this.C);
                    return;
                }
                return;
            }
            if (i2 == 4 && this.j) {
                this.f16719q = this.B.copyBackForwardList().getCurrentItem();
            }
        }
        sg.bigo.ads.api.core.c cVar = this.f16722t;
        if (cVar != null) {
            this.C = sg.bigo.ads.core.landing.a.a(cVar.N().h(), this.f16722t.N().i(), this.C);
        }
        super.t();
        c(3);
    }

    public final boolean u() {
        int i2;
        if (this.f16720r || this.f16723u) {
            ImageView imageView = this.f17124z;
            return (imageView == null || imageView.isEnabled()) ? false : true;
        }
        if (!this.f16715f && (i2 = this.e) > 0 && i2 <= 10000) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f16713c;
            if (jElapsedRealtime > 0 && jElapsedRealtime < i2) {
                return true;
            }
        }
        return false;
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl
    public final boolean v() {
        WebView webView = this.B;
        if (webView == null) {
            return false;
        }
        if (this.f16719q != null) {
            WebBackForwardList webBackForwardListCopyBackForwardList = webView.copyBackForwardList();
            int currentIndex = webBackForwardListCopyBackForwardList.getCurrentIndex();
            if (currentIndex <= 0) {
                return super.v();
            }
            WebHistoryItem itemAtIndex = webBackForwardListCopyBackForwardList.getItemAtIndex(currentIndex - 1);
            if (itemAtIndex != null) {
                return (TextUtils.equals(this.f16719q.getOriginalUrl(), itemAtIndex.getOriginalUrl()) || TextUtils.equals(this.f16719q.getUrl(), itemAtIndex.getUrl())) ? false : true;
            }
        }
        return super.v();
    }

    public final void w() {
        if (this.f16724v <= 0) {
            this.E.onReceiveValue(Boolean.TRUE);
            return;
        }
        WebView webView = this.B;
        if (webView != null) {
            webView.postDelayed(new Runnable() { // from class: sg.bigo.ads.controller.landing.c.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (c.this.E != null) {
                        c.this.E.onReceiveValue(Boolean.FALSE);
                    }
                }
            }, r.f16034a.a(this.f16724v));
        }
    }

    private static String a(Activity activity) {
        String packageName;
        String str;
        try {
            packageName = activity.getPackageName();
            str = activity.getPackageManager().getActivityInfo(activity.getComponentName(), 0).taskAffinity;
        } catch (PackageManager.NameNotFoundException | Exception unused) {
        }
        if (TextUtils.equals(packageName, str)) {
            return null;
        }
        return str;
    }

    private void c(int i2) {
        a aVar = new a(i2, this.h, (byte) 0);
        this.l.add(0, aVar);
        sg.bigo.ads.api.core.c cVar = this.f16722t;
        if (cVar != null) {
            sg.bigo.ads.core.d.b.a(this, aVar, cVar, this.f16721s, this.p);
        }
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl
    public void b() {
        super.b();
        if (this.f16720r || this.f16723u) {
            q();
        }
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl
    public final String d(String str) {
        sg.bigo.ads.api.core.c cVar = this.f16722t;
        return cVar != null ? sg.bigo.ads.core.landing.a.a(cVar.N().h(), this.f16722t.N().i(), str) : super.d(str);
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl
    public final void e(int i2) {
        super.e(i2);
        String str = this.f16712b;
        if (!TextUtils.isEmpty(str)) {
            sg.bigo.ads.common.u.b.a aVar = new sg.bigo.ads.common.u.b.a(sg.bigo.ads.common.y.a.a(), new sg.bigo.ads.common.u.b.d(str), this.I);
            aVar.k = sg.bigo.ads.common.u.a.e.a();
            g.a(aVar, null);
        }
        if (this.f16722t != null) {
            sg.bigo.ads.core.d.b.a(this, this.l.isEmpty() ? null : this.l.get(0), System.currentTimeMillis() - this.h, this.f16714d, this.f16722t, this.f16721s, this.p);
        }
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl
    public void a(int i2) {
        super.a(i2);
        this.f16717n = Math.max(this.f16717n, i2);
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl
    public final void c(String str) {
        super.c(str);
        this.f16718o++;
        this.m = !URLUtil.isNetworkUrl(str) ? 1 : 0;
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl
    public void d() {
        super.d();
        if (this.f16720r) {
            w();
        }
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl
    public final void a(int i2, String str, String str2) {
        super.a(i2, str, str2);
        if (this.f16715f) {
            return;
        }
        c(6);
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl
    public final void d(int i2) {
        if (u()) {
            return;
        }
        super.d(i2);
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl
    public void a(String str) {
        super.a(str);
        if (!this.f16715f) {
            this.f16717n = 100;
            c(5);
            if (this.f16723u) {
                w();
            }
        }
        this.f16715f = true;
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl
    public void a(String str, boolean z2) {
        super.a(str, z2);
        if (z2) {
            c(4);
        }
        int i2 = this.f16714d;
        if (i2 == 0) {
            this.C = str;
        }
        this.f16714d = i2 + 1;
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl
    public final void a(@NonNull sg.bigo.ads.api.core.e eVar) {
        sg.bigo.ads.api.core.c cVar = this.f16722t;
        if (cVar != null) {
            sg.bigo.ads.core.d.b.a(cVar, 2, eVar, this.f16721s);
        }
    }
}
