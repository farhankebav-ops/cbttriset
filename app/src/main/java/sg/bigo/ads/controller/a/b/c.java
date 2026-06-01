package sg.bigo.ads.controller.a.b;

import android.text.TextUtils;
import android.util.Pair;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import sg.bigo.ads.api.a.i;
import sg.bigo.ads.common.g;
import sg.bigo.ads.controller.b.h;

/* JADX INFO: loaded from: classes6.dex */
public abstract class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final sg.bigo.ads.controller.a.b f16348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final g f16349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final sg.bigo.ads.controller.b.d f16350d;
    protected final h e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected sg.bigo.ads.common.n.e f16351f = null;
    protected AtomicInteger g = new AtomicInteger(0);
    protected AtomicBoolean h = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f16347a = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Runnable f16352i = new Runnable() { // from class: sg.bigo.ads.controller.a.b.c.1
        @Override // java.lang.Runnable
        public final void run() {
            c cVar = c.this;
            if (cVar.f16348b != null) {
                if (cVar.f16351f == null) {
                    cVar.f16351f = cVar.a();
                }
                sg.bigo.ads.common.n.e eVar = c.this.f16351f;
                if (eVar == null || eVar.f15835a.get() != 0) {
                    c.this.d();
                    return;
                }
                Pair<String, Integer> pairA = c.a(c.this);
                if (pairA == null || TextUtils.isEmpty((CharSequence) pairA.first)) {
                    return;
                }
                c.this.a(pairA);
                c.this.f16348b.f16310a.a(0L);
                if (1 == ((Integer) pairA.second).intValue() % i.f15457a.y()) {
                    c.this.a((String) pairA.first, ((Integer) pairA.second).intValue(), "0");
                }
            }
        }
    };

    public c(sg.bigo.ads.controller.a.b bVar, g gVar, sg.bigo.ads.controller.b.d dVar, h hVar) {
        this.f16348b = bVar;
        this.f16349c = gVar;
        this.f16350d = dVar;
        this.e = hVar;
    }

    public static /* synthetic */ Pair a(c cVar) {
        sg.bigo.ads.controller.a.b bVar = cVar.f16348b;
        if (bVar == null || bVar.f16310a == null) {
            return null;
        }
        return cVar.b().a(i.f15457a);
    }

    public abstract sg.bigo.ads.common.n.e a();

    public abstract void a(Pair<String, Integer> pair);

    public abstract sg.bigo.ads.controller.a.a.b b();

    public final void c() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iRound = Math.round((i.f15457a.z() / 2.0f) * 60000.0f);
        long jAbs = Math.abs(jCurrentTimeMillis - this.f16347a);
        if (this.f16347a == 0 || jAbs > iRound) {
            this.f16347a = jCurrentTimeMillis;
            this.g.set(0);
            d();
        }
    }

    public final void d() {
        if (this.g.getAndAdd(1) >= 3 || this.h.get()) {
            return;
        }
        sg.bigo.ads.common.n.d.a(this.f16352i);
        sg.bigo.ads.common.n.d.a(1, this.f16352i, 5000L);
    }

    public final void a(Pair<String, Integer> pair, boolean z2) {
        if (this.f16348b == null || this.f16349c == null || this.f16350d == null || pair == null) {
            return;
        }
        boolean zA = b().a((String) pair.first, this.f16349c.v(), this.f16350d.s(), i.f15457a, z2);
        this.f16348b.f16310a.a(0L);
        if (zA) {
            a((String) pair.first, ((Integer) pair.second).intValue(), "1");
        }
    }

    public final void a(String str, int i2, String str2) {
        String str3 = this instanceof b ? "1" : this instanceof a ? "2" : "0";
        HashMap map = new HashMap();
        map.put("type", str3);
        map.put("host", str);
        map.put("retry_times", String.valueOf(i.f15457a.y()));
        map.put("retry_interval", String.valueOf(i.f15457a.z()));
        map.put("next_retry_interval", String.valueOf(i.f15457a.A()));
        map.put("cur_retry_time", String.valueOf(i2));
        map.put("uuid", this.f16349c.X());
        map.put("action", str2);
        sg.bigo.ads.core.d.b.d(map);
    }

    public static boolean a(int i2) {
        return i2 == 702 || i2 == 701 || i2 == 700;
    }
}
