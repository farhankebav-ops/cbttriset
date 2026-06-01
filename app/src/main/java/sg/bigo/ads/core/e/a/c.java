package sg.bigo.ads.core.e.a;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import sg.bigo.ads.api.core.r;
import sg.bigo.ads.core.e.b;

/* JADX INFO: loaded from: classes6.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final Map<String, String> f16923a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected r f16927f;
    protected f g;
    public CopyOnWriteArrayList<e> l;
    public CopyOnWriteArrayList<e> m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CopyOnWriteArrayList<e> f16929n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CopyOnWriteArrayList<e> f16930o;
    private int p;
    public long h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f16928i = 0;
    public long j = 0;
    public long k = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CopyOnWriteArrayList<e> f16924b = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CopyOnWriteArrayList<e> f16925c = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CopyOnWriteArrayList<e> f16926d = new CopyOnWriteArrayList<>();
    public CopyOnWriteArrayList<e> e = new CopyOnWriteArrayList<>();

    public c(r rVar) {
        this.f16927f = rVar;
        HashMap map = new HashMap();
        this.f16923a = map;
        this.g = new f(this.f16927f, map);
    }

    public final void a(int i2) {
        this.p = i2;
        f fVar = this.g;
        if (fVar != null) {
            fVar.f16970r = i2;
        }
    }

    public final void b(final Context context, boolean z2) {
        if (sg.bigo.ads.common.x.a.q()) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z7 = this.f16927f.f15529a;
        Iterator<e> it = this.f16924b.iterator();
        while (it.hasNext()) {
            it.next().e();
        }
        if (z7) {
            this.h = jCurrentTimeMillis;
            this.l = new CopyOnWriteArrayList<>();
            for (e eVar : this.f16924b) {
                if (!z2 || eVar.a()) {
                    if (eVar.c()) {
                        this.l.add(eVar);
                    }
                }
            }
            if (this.l.size() > 0) {
                f fVar = this.g;
                fVar.f16971s = this.l;
                fVar.j = jCurrentTimeMillis;
                fVar.f16966i = 0;
                d.a().a(this.g);
            }
        } else {
            sg.bigo.ads.common.t.a.a(0, 3, "AdTracker", "trackThirdImpression not need retry");
        }
        for (final e eVar2 : this.f16924b) {
            if (!z2 || eVar2.a()) {
                if (eVar2.c()) {
                    a(context, "impl_track", eVar2, z7);
                } else {
                    sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.core.e.a.c.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            c.a(c.this, context, "impl_track", eVar2);
                        }
                    });
                }
            }
        }
    }

    public final void c(final Context context, boolean z2) {
        if (sg.bigo.ads.common.x.a.q()) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z7 = this.f16927f.f15529a;
        Iterator<e> it = this.f16925c.iterator();
        while (it.hasNext()) {
            it.next().e();
        }
        if (z7) {
            this.f16928i = jCurrentTimeMillis;
            this.m = new CopyOnWriteArrayList<>();
            for (e eVar : this.f16925c) {
                if (!z2 || eVar.a()) {
                    if (eVar.c()) {
                        this.m.add(eVar);
                    }
                }
            }
            if (this.m.size() > 0) {
                f fVar = this.g;
                fVar.f16972t = this.m;
                fVar.l = jCurrentTimeMillis;
                fVar.k = 0;
                d.a().a(this.g);
            }
        } else {
            sg.bigo.ads.common.t.a.a(0, 3, "AdTracker", "trackThirdClick not need retry");
        }
        for (final e eVar2 : this.f16925c) {
            if (!z2 || eVar2.a()) {
                if (eVar2.c()) {
                    a(context, "click_track", eVar2, z7);
                } else {
                    sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.core.e.a.c.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            c.a(c.this, context, "click_track", eVar2);
                        }
                    });
                }
            }
        }
    }

    public final void d(final Context context, boolean z2) {
        if (sg.bigo.ads.common.x.a.q()) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z7 = this.f16927f.f15529a;
        Iterator<e> it = this.f16926d.iterator();
        while (it.hasNext()) {
            it.next().e();
        }
        if (z7) {
            this.j = jCurrentTimeMillis;
            this.f16929n = new CopyOnWriteArrayList<>();
            for (e eVar : this.f16926d) {
                if (!z2 || eVar.a()) {
                    if (eVar.c()) {
                        this.f16929n.add(eVar);
                    }
                }
            }
            if (this.f16929n.size() > 0) {
                f fVar = this.g;
                fVar.f16973u = this.f16929n;
                fVar.f16967n = jCurrentTimeMillis;
                fVar.m = 0;
                d.a().a(this.g);
            }
        } else {
            sg.bigo.ads.common.t.a.a(0, 3, "AdTracker", "trackThirdNUrl not need retry");
        }
        for (final e eVar2 : this.f16926d) {
            if (!z2 || eVar2.a()) {
                if (eVar2.c()) {
                    a(context, "nurl_track", eVar2, z7);
                } else {
                    sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.core.e.a.c.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            c.a(c.this, context, "nurl_track", eVar2);
                        }
                    });
                }
            }
        }
    }

    public final void e(final Context context, boolean z2) {
        if (sg.bigo.ads.common.x.a.q()) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z7 = this.f16927f.f15529a;
        Iterator<e> it = this.e.iterator();
        while (it.hasNext()) {
            it.next().e();
        }
        if (z7) {
            this.k = jCurrentTimeMillis;
            this.f16930o = new CopyOnWriteArrayList<>();
            for (e eVar : this.e) {
                if (!z2 || eVar.a()) {
                    if (eVar.c()) {
                        this.f16930o.add(eVar);
                    }
                }
            }
            if (this.f16930o.size() > 0) {
                f fVar = this.g;
                fVar.f16974v = this.f16930o;
                fVar.p = jCurrentTimeMillis;
                fVar.f16968o = 0;
                d.a().a(this.g);
            }
        } else {
            sg.bigo.ads.common.t.a.a(0, 3, "AdTracker", "trackThirdLUrl not need retry");
        }
        for (final e eVar2 : this.e) {
            if (!z2 || eVar2.a()) {
                if (eVar2.c()) {
                    a(context, "lurl_track", eVar2, z7);
                } else {
                    sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.core.e.a.c.4
                        @Override // java.lang.Runnable
                        public final void run() {
                            c.a(c.this, context, "lurl_track", eVar2);
                        }
                    });
                }
            }
        }
    }

    public final void a(Context context, String str, String str2, String str3) {
        h hVarA = h.a(this.f16923a, this.f16927f, this.p, str, str2, str3);
        hVarA.a(context, hVarA.f16980a);
    }

    public final void b(@NonNull String str, @NonNull String str2) {
        for (e eVar : this.f16924b) {
            if (eVar.c()) {
                eVar.a(str, str2);
            }
        }
        for (e eVar2 : this.f16925c) {
            if (eVar2.c()) {
                eVar2.a(str, str2);
            }
        }
        for (e eVar3 : this.f16926d) {
            if (eVar3.c()) {
                eVar3.a(str, str2);
            }
        }
        for (e eVar4 : this.e) {
            if (eVar4.c()) {
                eVar4.a(str, str2);
            }
        }
    }

    private void a(Context context, final String str, final e eVar, final boolean z2) {
        String str2 = eVar.f16961b;
        sg.bigo.ads.common.u.a aVarD = eVar.d();
        int i2 = eVar.f16962c;
        eVar.a();
        sg.bigo.ads.core.e.b.a(context, i2, str, aVarD, str2, this.p, this.f16923a, new b.a() { // from class: sg.bigo.ads.core.e.a.c.5
            @Override // sg.bigo.ads.core.e.b.a
            public final void a() {
                e eVar2 = eVar;
                if (eVar2.f16963d == 1) {
                    c.a(c.this, str, eVar2, true);
                }
                d.a().b(c.this.g);
            }

            @Override // sg.bigo.ads.core.e.b.a
            public final void b() {
                c.a(c.this, str, eVar, z2);
                d.a().b(c.this.g);
            }

            @Override // sg.bigo.ads.core.e.b.a
            public final boolean a(int i8) {
                return c.this.f16927f.a(i8);
            }
        });
    }

    public final void a(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.f16923a.put(str, str2);
    }

    public final void a(String str, String str2, sg.bigo.ads.common.u.a aVar, String str3) {
        HashMap map = new HashMap(this.f16923a);
        if (TextUtils.isEmpty(str)) {
            str = "unknown";
        }
        map.put("action", str);
        map.put("track_url", aVar.a());
        map.put("domain_front", aVar.e() ? aVar.d() : "");
        map.put("track_name", str3);
        map.put("states", str2);
        map.put("retry", "0");
        map.put("out_ad", String.valueOf(this.p));
        if ("impl_track".equals(str)) {
            sg.bigo.ads.core.d.b.a(map);
        } else if ("click_track".equals(str)) {
            sg.bigo.ads.core.d.b.b(map);
        }
    }

    public static /* synthetic */ void a(c cVar, Context context, final String str, e eVar) {
        String strA = eVar.d().a();
        final String str2 = eVar.f16961b;
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        if ("sizmek".equals(str2)) {
            strA = strA.replaceAll("\\?", "%3f");
        }
        cVar.a(str, "start", new sg.bigo.ads.common.u.b.d(strA), str2);
        final sg.bigo.ads.core.h.e eVarA = sg.bigo.ads.core.h.e.a(context);
        if (eVarA != null) {
            eVarA.setWebViewClient(new sg.bigo.ads.core.h.d() { // from class: sg.bigo.ads.core.e.a.c.6
                @Override // sg.bigo.ads.core.h.d
                public final void a(RenderProcessGoneDetail renderProcessGoneDetail) {
                    eVarA.destroy();
                }

                @Override // sg.bigo.ads.core.h.d, android.webkit.WebViewClient
                public final void onPageFinished(WebView webView, String str3) {
                    super.onPageFinished(webView, str3);
                    c.this.a(str, "success", new sg.bigo.ads.common.u.b.d(str3), str2);
                }

                @Override // android.webkit.WebViewClient
                public final boolean shouldOverrideUrlLoading(WebView webView, String str3) {
                    return false;
                }
            });
            try {
                int i2 = eVar.f16960a;
                if (i2 == 1) {
                    eVarA.loadUrl(strA);
                } else if (i2 == 2) {
                    eVarA.loadData(strA, "text/html", Key.STRING_CHARSET_NAME);
                }
            } catch (Exception e) {
                sg.bigo.ads.core.d.b.a(3002, 10106, e.getMessage());
            }
        }
    }

    public static /* synthetic */ void a(c cVar, String str, e eVar, boolean z2) {
        CopyOnWriteArrayList<e> copyOnWriteArrayList;
        CopyOnWriteArrayList<e> copyOnWriteArrayList2;
        CopyOnWriteArrayList<e> copyOnWriteArrayList3;
        CopyOnWriteArrayList<e> copyOnWriteArrayList4;
        if ("impl_track".equals(str)) {
            if (!z2 || (copyOnWriteArrayList4 = cVar.l) == null) {
                return;
            }
            copyOnWriteArrayList4.remove(eVar);
            return;
        }
        if ("click_track".equals(str)) {
            if (!z2 || (copyOnWriteArrayList3 = cVar.m) == null) {
                return;
            }
            copyOnWriteArrayList3.remove(eVar);
            return;
        }
        if ("nurl_track".equals(str)) {
            if (!z2 || (copyOnWriteArrayList2 = cVar.f16929n) == null) {
                return;
            }
            copyOnWriteArrayList2.remove(eVar);
            return;
        }
        if ("lurl_track".equals(str) && z2 && (copyOnWriteArrayList = cVar.f16930o) != null) {
            copyOnWriteArrayList.remove(eVar);
        }
    }
}
