package sg.bigo.ads.controller.landing;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ironsource.adqualitysdk.sdk.i.a0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.a.a;
import sg.bigo.ads.api.b.f;

/* JADX INFO: loaded from: classes6.dex */
public final class b implements a.c, f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f16700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f16701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f16702c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f16704f;
    private final sg.bigo.ads.api.core.c g;
    private final sg.bigo.ads.ad.c<?, ?> h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final sg.bigo.ads.controller.landing.a f16705i;
    private final int l;
    private final long m;
    private final String e = "ChromeTabStatSession";
    private int j = 0;
    private boolean k = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected long f16703d = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final List<f.a> f16706n = new ArrayList();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final AtomicBoolean f16707o = new AtomicBoolean(true);
    private final AtomicBoolean p = new AtomicBoolean(true);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f16708q = false;

    public static class a implements f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f16709a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f16710b;

        private a(int i2, long j) {
            this.f16709a = i2;
            this.f16710b = System.currentTimeMillis() - j;
        }

        @Override // sg.bigo.ads.api.b.f.a
        public final int a() {
            return this.f16709a;
        }

        @Override // sg.bigo.ads.api.b.f.a
        public final long b() {
            return this.f16710b;
        }

        public /* synthetic */ a(int i2, long j, byte b8) {
            this(i2, j);
        }
    }

    public b(String str, @Nullable sg.bigo.ads.api.core.c cVar, @Nullable sg.bigo.ads.ad.c<?, ?> cVar2, @Nullable sg.bigo.ads.controller.landing.a aVar) {
        long jCurrentTimeMillis;
        this.f16704f = str;
        this.g = cVar;
        this.h = cVar2;
        this.f16705i = aVar;
        if (cVar2 != null) {
            this.l = cVar2.q();
            jCurrentTimeMillis = cVar2.r();
        } else {
            this.l = 0;
            jCurrentTimeMillis = System.currentTimeMillis();
        }
        this.m = jCurrentTimeMillis;
    }

    @Override // sg.bigo.ads.a.a.c
    public final void a() {
        a0.g(0, 3, this.f16704f, "ChromeTabStatSession", new StringBuilder("Chrome tabs shown: "));
        a(1);
    }

    @Override // sg.bigo.ads.a.a.c
    public final void b() {
        sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabStatSession", "Chrome tabs page started: " + this.f16704f);
        this.f16703d = SystemClock.elapsedRealtime();
        this.j = this.j + 1;
        if (this.f16707o.compareAndSet(true, false)) {
            a(4);
        }
    }

    @Override // sg.bigo.ads.a.a.c
    public final void c() {
        this.k = true;
        a0.g(0, 3, this.f16704f, "ChromeTabStatSession", new StringBuilder("Chrome tabs page aborted: "));
    }

    @Override // sg.bigo.ads.a.a.c
    public final void d() {
        a0.g(0, 3, this.f16704f, "ChromeTabStatSession", new StringBuilder("Chrome tabs page failed: "));
        if (this.f16708q) {
            return;
        }
        a(6);
    }

    @Override // sg.bigo.ads.a.a.c
    public final void e() {
        a0.g(0, 3, this.f16704f, "ChromeTabStatSession", new StringBuilder("Chrome tabs page finished: "));
        this.f16708q = true;
        if (this.p.compareAndSet(true, false)) {
            a(5);
        }
    }

    @Override // sg.bigo.ads.a.a.c
    public final void f() {
        a0.g(0, 3, this.f16704f, "ChromeTabStatSession", new StringBuilder("Chrome tabs hidden: "));
        sg.bigo.ads.core.d.b.a(this, this.f16706n.isEmpty() ? null : this.f16706n.get(0), System.currentTimeMillis() - this.m, this.j, this.g, this.h, (String) null);
    }

    @Override // sg.bigo.ads.api.b.f
    public final int h() {
        return 0;
    }

    @Override // sg.bigo.ads.api.b.f
    public final String i() {
        return this.f16704f;
    }

    @Override // sg.bigo.ads.api.b.f
    public final int j() {
        return 0;
    }

    @Override // sg.bigo.ads.api.b.f
    public final int k() {
        return 0;
    }

    @Override // sg.bigo.ads.api.b.f
    public final int l() {
        return this.f16708q ? 100 : 0;
    }

    @Override // sg.bigo.ads.api.b.f
    public final boolean m() {
        sg.bigo.ads.controller.landing.a aVar = this.f16705i;
        return aVar != null && aVar.f16684d;
    }

    @Override // sg.bigo.ads.api.b.f
    public final int n() {
        return this.l;
    }

    @Override // sg.bigo.ads.api.b.f
    public final int o() {
        return 2;
    }

    @Override // sg.bigo.ads.api.b.f
    @Nullable
    public final Map<String, String> p() {
        if (!this.k && TextUtils.isEmpty(this.f16700a) && TextUtils.isEmpty(this.f16702c) && TextUtils.isEmpty(this.f16701b)) {
            return null;
        }
        HashMap map = new HashMap();
        if (this.k) {
            map.put("tab_aborted", "1");
        }
        if (!TextUtils.isEmpty(this.f16700a)) {
            map.put("chrome_pkg", this.f16700a);
        }
        if (!TextUtils.isEmpty(this.f16702c)) {
            map.put("is_chrome_def", TextUtils.equals(this.f16700a, this.f16702c) ? "1" : "0");
        }
        if (!TextUtils.isEmpty(this.f16701b)) {
            map.put("chrome_ver", this.f16701b);
        }
        return map;
    }

    private void a(int i2) {
        a aVar = new a(i2, this.m, (byte) 0);
        this.f16706n.add(0, aVar);
        sg.bigo.ads.core.d.b.a(this, aVar, this.g, this.h, (String) null);
    }
}
