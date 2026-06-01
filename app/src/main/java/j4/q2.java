package j4;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class q2 extends i4.r0 implements i4.d0 {

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final Logger f12378c0 = Logger.getLogger(q2.class.getName());
    public static final Pattern d0 = Pattern.compile("[a-zA-Z][a-zA-Z0-9+.-]*:/.*");

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final i4.n1 f12379e0;
    public static final i4.n1 f0;
    public static final w2 g0;
    public static final d2 h0;
    public static final k0 i0;
    public final HashSet A;
    public LinkedHashSet B;
    public final Object C;
    public final HashSet D;
    public final p0 E;
    public final h F;
    public final AtomicBoolean G;
    public boolean H;
    public volatile boolean I;
    public final CountDownLatch J;
    public final e3 K;
    public final h L;
    public final q M;
    public final o N;
    public final i4.b0 O;
    public final n2 P;
    public w2 Q;
    public boolean R;
    public final boolean S;
    public final g T;
    public final long U;
    public final long V;
    public final boolean W;
    public final i4.j X;
    public final m1 Y;
    public final g0 Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i4.e0 f12380a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final x3 f12381a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12382b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f12383b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i4.h1 f12384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i4.d1 f12385d;
    public final g5 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n f12386f;
    public final o2 g;
    public final Executor h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a4.a f12387i;
    public final i2 j;
    public final i2 k;
    public final e3 l;
    public final i4.s1 m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final i4.t f12388n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final i4.l f12389o;
    public final e2.n p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final long f12390q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final g0 f12391r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final e3 f12392s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final i4.e f12393t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ArrayList f12394u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public r4 f12395v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f12396w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public j2 f12397x;
    public volatile i4.m0 y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f12398z;

    static {
        i4.n1 n1Var = i4.n1.m;
        n1Var.h("Channel shutdownNow invoked");
        f12379e0 = n1Var.h("Channel shutdown invoked");
        f0 = n1Var.h("Subchannel shutdown invoked");
        g0 = new w2(null, new HashMap(), new HashMap(), null, null, null);
        h0 = new d2();
        i0 = new k0(1);
    }

    public q2(r2 r2Var, k4.g gVar, e3 e3Var, a4.a aVar, e2.n nVar, ArrayList arrayList) {
        int i2;
        e3 e3Var2 = e3.f12177c;
        i4.s1 s1Var = new i4.s1(new f2(this));
        this.m = s1Var;
        g0 g0Var = new g0();
        g0Var.f12200b = new ArrayList();
        g0Var.f12199a = i4.m.f11897d;
        this.f12391r = g0Var;
        this.A = new HashSet(16, 0.75f);
        this.C = new Object();
        this.D = new HashSet(1, 0.75f);
        h hVar = new h();
        hVar.f12234d = this;
        hVar.f12231a = new Object();
        hVar.f12232b = new HashSet();
        this.F = hVar;
        this.G = new AtomicBoolean(false);
        this.J = new CountDownLatch(1);
        this.f12383b0 = 1;
        this.Q = g0;
        this.R = false;
        this.T = new g(1);
        this.X = i4.r.f11941d;
        a4.a aVar2 = new a4.a(this, 17);
        this.Y = new m1(this, 1);
        g0 g0Var2 = new g0();
        g0Var2.f12200b = this;
        this.Z = g0Var2;
        String str = r2Var.f12416f;
        r2.q.D(str, TypedValues.AttributesType.S_TARGET);
        this.f12382b = str;
        i4.e0 e0Var = new i4.e0("Channel", str, i4.e0.f11851d.incrementAndGet());
        this.f12380a = e0Var;
        this.l = e3Var2;
        a4.a aVar3 = r2Var.f12412a;
        r2.q.D(aVar3, "executorPool");
        this.f12387i = aVar3;
        Executor executor = (Executor) c5.a((b5) aVar3.f3216b);
        r2.q.D(executor, "executor");
        this.h = executor;
        a4.a aVar4 = r2Var.f12413b;
        r2.q.D(aVar4, "offloadExecutorPool");
        i2 i2Var = new i2(aVar4);
        this.k = i2Var;
        n nVar2 = new n(gVar, i2Var);
        this.f12386f = nVar2;
        o2 o2Var = new o2(gVar.f12636d);
        this.g = o2Var;
        q qVar = new q(e0Var, e3Var2.p(), a1.a.m("Channel for '", str, "'"));
        this.M = qVar;
        o oVar = new o(qVar, e3Var2);
        this.N = oVar;
        r3 r3Var = f1.m;
        boolean z2 = r2Var.f12419o;
        this.W = z2;
        g5 g5Var = new g5(r2Var.g);
        this.e = g5Var;
        i4.h1 h1Var = r2Var.f12415d;
        this.f12384c = h1Var;
        s4 s4Var = new s4(z2, r2Var.k, r2Var.l, g5Var);
        int i8 = r2Var.f12427x.f12632a.g;
        int iB = q0.c.b(i8);
        if (iB == 0) {
            i2 = 443;
        } else {
            if (iB != 1) {
                throw new AssertionError(com.ironsource.adqualitysdk.sdk.i.a0.q(i8).concat(" not handled"));
            }
            i2 = 80;
        }
        Integer numValueOf = Integer.valueOf(i2);
        r3Var.getClass();
        i4.d1 d1Var = new i4.d1(numValueOf, r3Var, s1Var, s4Var, o2Var, oVar, i2Var);
        this.f12385d = d1Var;
        nVar2.f12326a.getClass();
        this.f12395v = i(str, h1Var, d1Var, Collections.singleton(InetSocketAddress.class));
        this.j = new i2(aVar);
        p0 p0Var = new p0(executor, s1Var);
        this.E = p0Var;
        p0Var.c(aVar2);
        this.f12392s = e3Var;
        boolean z7 = r2Var.f12420q;
        this.S = z7;
        n2 n2Var = new n2(this, this.f12395v.d());
        this.P = n2Var;
        int size = arrayList.size();
        int i9 = 0;
        i4.e gVar2 = n2Var;
        while (i9 < size) {
            Object obj = arrayList.get(i9);
            i9++;
            gVar2 = new i4.g(gVar2, (p4.g) obj);
        }
        this.f12393t = gVar2;
        this.f12394u = new ArrayList(r2Var.e);
        r2.q.D(nVar, "stopwatchSupplier");
        this.p = nVar;
        long j = r2Var.j;
        if (j == -1) {
            this.f12390q = j;
        } else {
            r2.q.z(j >= r2.A, "invalid idleTimeoutMillis %s", j);
            this.f12390q = r2Var.j;
        }
        this.f12381a0 = new x3(new a4.c(this, 7), s1Var, nVar2.f12326a.f12636d, (e2.m) nVar.get());
        i4.t tVar = r2Var.h;
        r2.q.D(tVar, "decompressorRegistry");
        this.f12388n = tVar;
        i4.l lVar = r2Var.f12417i;
        r2.q.D(lVar, "compressorRegistry");
        this.f12389o = lVar;
        this.V = r2Var.m;
        this.U = r2Var.f12418n;
        this.K = new e3(16);
        this.L = new h();
        i4.b0 b0Var = r2Var.p;
        b0Var.getClass();
        this.O = b0Var;
        if (z7) {
            return;
        }
        this.R = true;
    }

    public static void g(q2 q2Var) {
        if (!q2Var.I && q2Var.G.get() && q2Var.A.isEmpty() && q2Var.D.isEmpty()) {
            q2Var.N.i(2, "Terminated");
            a4.a aVar = q2Var.f12387i;
            c5.b((b5) aVar.f3216b, q2Var.h);
            i2 i2Var = q2Var.j;
            synchronized (i2Var) {
                Executor executor = i2Var.f12257b;
                if (executor != null) {
                    c5.b((b5) i2Var.f12256a.f3216b, executor);
                    i2Var.f12257b = null;
                }
            }
            q2Var.k.a();
            q2Var.f12386f.close();
            q2Var.I = true;
            q2Var.J.countDown();
        }
    }

    public static r4 i(String str, i4.h1 h1Var, i4.d1 d1Var, Collection collection) {
        URI uri;
        i4.d1 d1Var2;
        String str2;
        String str3;
        String str4;
        StringBuilder sb = new StringBuilder();
        v0 v0Var = null;
        try {
            uri = new URI(str);
        } catch (URISyntaxException e) {
            sb.append(e.getMessage());
            uri = null;
        }
        i4.g1 g1VarB = uri != null ? h1Var.b(uri.getScheme()) : null;
        if (g1VarB == null && !d0.matcher(str).matches()) {
            try {
                synchronized (h1Var) {
                    str4 = h1Var.f11870a;
                }
                uri = new URI(str4, "", "/" + str, null);
                g1VarB = h1Var.b(uri.getScheme());
            } catch (URISyntaxException e4) {
                throw new IllegalArgumentException(e4);
            }
        }
        if (g1VarB == null) {
            if (sb.length() > 0) {
                str3 = " (" + ((Object) sb) + ")";
            } else {
                str3 = "";
            }
            throw new IllegalArgumentException(a1.a.m("Could not find a NameResolverProvider for ", str, str3));
        }
        if (collection != null && !collection.containsAll(Collections.singleton(InetSocketAddress.class))) {
            throw new IllegalArgumentException(a1.a.o("Address types of NameResolver '", uri.getScheme(), "' for '", str, "' not supported by transport"));
        }
        if ("dns".equals(uri.getScheme())) {
            String path = uri.getPath();
            r2.q.D(path, "targetPath");
            if (!path.startsWith("/")) {
                throw new IllegalArgumentException(a.a.K("the path component (%s) of the target (%s) must start with '/'", path, uri));
            }
            String strSubstring = path.substring(1);
            uri.getAuthority();
            d1Var2 = d1Var;
            v0Var = new v0(strSubstring, d1Var2, f1.p, new e2.m(), w0.f12525a);
        } else {
            d1Var2 = d1Var;
        }
        if (v0Var != null) {
            e3 e3Var = new e3(9);
            o2 o2Var = d1Var2.e;
            if (o2Var == null) {
                throw new IllegalStateException("ScheduledExecutorService not set in Builder");
            }
            i4.s1 s1Var = d1Var2.f11848c;
            return new r4(v0Var, new l(e3Var, o2Var, s1Var), s1Var);
        }
        if (sb.length() > 0) {
            str2 = " (" + ((Object) sb) + ")";
        } else {
            str2 = "";
        }
        throw new IllegalArgumentException(a1.a.m("cannot create a NameResolver for ", str, str2));
    }

    @Override // i4.d0
    public final i4.e0 a() {
        return this.f12380a;
    }

    @Override // i4.e
    public final String e() {
        return this.f12393t.e();
    }

    @Override // i4.e
    public final i4.f f(i4.c1 c1Var, i4.d dVar) {
        return this.f12393t.f(c1Var, dVar);
    }

    public final void h() {
        this.m.d();
        if (this.G.get() || this.f12398z) {
            return;
        }
        if (((Set) this.Y.f11225b).isEmpty()) {
            j();
        } else {
            this.f12381a0.f12551f = false;
        }
        if (this.f12397x != null) {
            return;
        }
        this.N.i(2, "Exiting idle mode");
        j2 j2Var = new j2(this);
        g5 g5Var = this.e;
        g5Var.getClass();
        h hVar = new h();
        hVar.f12234d = g5Var;
        hVar.f12231a = j2Var;
        i4.q0 q0Var = (i4.q0) g5Var.f12229b;
        String str = (String) g5Var.f12230c;
        i4.p0 p0VarC = q0Var.c(str);
        hVar.f12233c = p0VarC;
        if (p0VarC == null) {
            throw new IllegalStateException(a1.a.m("Could not find policy '", str, "'. Make sure its implementation is either registered to LoadBalancerRegistry or included in META-INF/services/io.grpc.LoadBalancerProvider from your jar files."));
        }
        hVar.f12232b = p0VarC.b(j2Var);
        j2Var.f12267a = hVar;
        this.f12397x = j2Var;
        this.f12395v.m(new k2(this, j2Var, this.f12395v));
        this.f12396w = true;
    }

    public final void j() {
        long j = this.f12390q;
        if (j == -1) {
            return;
        }
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        x3 x3Var = this.f12381a0;
        x3Var.getClass();
        long nanos = timeUnit.toNanos(j);
        e2.m mVar = x3Var.f12550d;
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        long jA = mVar.a() + nanos;
        x3Var.f12551f = true;
        if (jA - x3Var.e < 0 || x3Var.g == null) {
            ScheduledFuture scheduledFuture = x3Var.g;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            x3Var.g = x3Var.f12547a.schedule(new w3(x3Var, 1), nanos, timeUnit2);
        }
        x3Var.e = jA;
    }

    public final void k(boolean z2) {
        this.m.d();
        if (z2) {
            r2.q.H(this.f12396w, "nameResolver is not started");
            r2.q.H(this.f12397x != null, "lbHelper is null");
        }
        r4 r4Var = this.f12395v;
        if (r4Var != null) {
            r4Var.l();
            this.f12396w = false;
            if (z2) {
                String str = this.f12382b;
                i4.h1 h1Var = this.f12384c;
                i4.d1 d1Var = this.f12385d;
                this.f12386f.f12326a.getClass();
                this.f12395v = i(str, h1Var, d1Var, Collections.singleton(InetSocketAddress.class));
            } else {
                this.f12395v = null;
            }
        }
        j2 j2Var = this.f12397x;
        if (j2Var != null) {
            h hVar = j2Var.f12267a;
            ((i4.o0) hVar.f12232b).f();
            hVar.f12232b = null;
            this.f12397x = null;
        }
        this.y = null;
    }

    public final String toString() {
        e2.i iVarY = a.a.Y(this);
        iVarY.d("logId", this.f12380a.f11854c);
        iVarY.c(this.f12382b, TypedValues.AttributesType.S_TARGET);
        return iVarY.toString();
    }
}
