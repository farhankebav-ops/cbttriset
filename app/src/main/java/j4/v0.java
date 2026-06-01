package j4;

import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class v0 extends i4.x {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Logger f12502s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Set f12503t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final boolean f12504u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final boolean f12505v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final boolean f12506w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static String f12507x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i4.i1 f12508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Random f12509b = new Random();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile t0 f12510c = t0.f12455a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference f12511d = new AtomicReference();
    public final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f12512f;
    public final int g;
    public final b5 h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f12513i;
    public final i4.s1 j;
    public final e2.m k;
    public boolean l;
    public boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Executor f12514n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f12515o;
    public final s4 p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f12516q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public i4.f f12517r;

    static {
        Logger logger = Logger.getLogger(v0.class.getName());
        f12502s = logger;
        f12503t = Collections.unmodifiableSet(new HashSet(Arrays.asList("clientLanguage", "percentage", "clientHostname", "serviceConfig")));
        String property = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi", com.ironsource.mediationsdk.metadata.a.g);
        String property2 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi_localhost", "false");
        String property3 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_service_config", "false");
        f12504u = Boolean.parseBoolean(property);
        f12505v = Boolean.parseBoolean(property2);
        f12506w = Boolean.parseBoolean(property3);
        try {
            try {
                try {
                    if (Class.forName("j4.u1", true, v0.class.getClassLoader()).asSubclass(u0.class).getConstructor(null).newInstance(null) == null) {
                        throw null;
                    }
                    throw new ClassCastException();
                } catch (Exception e) {
                    logger.log(Level.FINE, "Can't construct JndiResourceResolverFactory, skipping.", (Throwable) e);
                }
            } catch (Exception e4) {
                logger.log(Level.FINE, "Can't find JndiResourceResolverFactory ctor, skipping.", (Throwable) e4);
            }
        } catch (ClassCastException e8) {
            logger.log(Level.FINE, "Unable to cast JndiResourceResolverFactory, skipping.", (Throwable) e8);
        } catch (ClassNotFoundException e9) {
            logger.log(Level.FINE, "Unable to find JndiResourceResolverFactory, skipping.", (Throwable) e9);
        }
    }

    public v0(String str, i4.d1 d1Var, b5 b5Var, e2.m mVar, boolean z2) {
        r2.q.D(d1Var, "args");
        this.h = b5Var;
        r2.q.D(str, "name");
        URI uriCreate = URI.create("//".concat(str));
        r2.q.w(str, "Invalid DNS name: %s", uriCreate.getHost() != null);
        String authority = uriCreate.getAuthority();
        if (authority == null) {
            throw new NullPointerException(a.a.K("nameUri (%s) doesn't have an authority", uriCreate));
        }
        this.e = authority;
        this.f12512f = uriCreate.getHost();
        if (uriCreate.getPort() == -1) {
            this.g = d1Var.f11846a;
        } else {
            this.g = uriCreate.getPort();
        }
        i4.i1 i1Var = d1Var.f11847b;
        r2.q.D(i1Var, "proxyDetector");
        this.f12508a = i1Var;
        long nanos = 0;
        if (!z2) {
            String property = System.getProperty("networkaddress.cache.ttl");
            long j = 30;
            if (property != null) {
                try {
                    j = Long.parseLong(property);
                } catch (NumberFormatException unused) {
                    f12502s.log(Level.WARNING, "Property({0}) valid is not valid number format({1}), fall back to default({2})", new Object[]{"networkaddress.cache.ttl", property, 30L});
                }
            }
            nanos = j > 0 ? TimeUnit.SECONDS.toNanos(j) : j;
        }
        this.f12513i = nanos;
        this.k = mVar;
        i4.s1 s1Var = d1Var.f11848c;
        r2.q.D(s1Var, "syncContext");
        this.j = s1Var;
        i2 i2Var = d1Var.g;
        this.f12514n = i2Var;
        this.f12515o = i2Var == null;
        s4 s4Var = d1Var.f11849d;
        r2.q.D(s4Var, "serviceConfigParser");
        this.p = s4Var;
    }

    public static Map p(Map map, Random random, String str) {
        for (Map.Entry entry : map.entrySet()) {
            n7.b.V(entry, "Bad key: %s", f12503t.contains(entry.getKey()));
        }
        List listD = x1.d("clientLanguage", map);
        if (listD != null && !listD.isEmpty()) {
            Iterator it = listD.iterator();
            while (it.hasNext()) {
                if ("java".equalsIgnoreCase((String) it.next())) {
                }
            }
            return null;
        }
        Double dE = x1.e("percentage", map);
        if (dE != null) {
            int iIntValue = dE.intValue();
            n7.b.V(dE, "Bad percentage: %s", iIntValue >= 0 && iIntValue <= 100);
            if (random.nextInt(100) >= iIntValue) {
                return null;
            }
        }
        List listD2 = x1.d("clientHostname", map);
        if (listD2 != null && !listD2.isEmpty()) {
            Iterator it2 = listD2.iterator();
            while (it2.hasNext()) {
                if (((String) it2.next()).equals(str)) {
                }
            }
            return null;
        }
        Map mapG = x1.g("serviceConfig", map);
        if (mapG != null) {
            return mapG;
        }
        throw new e2.s(String.format("key '%s' missing in '%s'", map, "serviceConfig"), 0);
    }

    public static ArrayList q() {
        List<String> list = Collections.EMPTY_LIST;
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (str.startsWith("grpc_config=")) {
                String strSubstring = str.substring(12);
                Logger logger = w1.f12526a;
                JsonReader jsonReader = new JsonReader(new StringReader(strSubstring));
                try {
                    Object objA = w1.a(jsonReader);
                    if (!(objA instanceof List)) {
                        throw new ClassCastException("wrong type " + objA);
                    }
                    List list2 = (List) objA;
                    x1.a(list2);
                    arrayList.addAll(list2);
                } finally {
                    try {
                        jsonReader.close();
                    } catch (IOException e) {
                        logger.log(Level.WARNING, "Failed to close", (Throwable) e);
                    }
                }
            } else {
                f12502s.log(Level.FINE, "Ignoring non service config {0}", new Object[]{str});
            }
        }
        return arrayList;
    }

    @Override // i4.x
    public final String d() {
        return this.e;
    }

    @Override // i4.x
    public final void j() {
        r2.q.H(this.f12517r != null, "not started");
        r();
    }

    @Override // i4.x
    public final void l() {
        if (this.m) {
            return;
        }
        this.m = true;
        Executor executor = this.f12514n;
        if (executor == null || !this.f12515o) {
            return;
        }
        c5.b(this.h, executor);
        this.f12514n = null;
    }

    @Override // i4.x
    public final void m(i4.f fVar) {
        r2.q.H(this.f12517r == null, "already started");
        if (this.f12515o) {
            this.f12514n = (Executor) c5.a(this.h);
        }
        this.f12517r = fVar;
        r();
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final e2.h o() {
        /*
            Method dump skipped, instruction units count: 380
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: j4.v0.o():e2.h");
    }

    public final void r() {
        if (this.f12516q || this.m) {
            return;
        }
        if (this.l) {
            long j = this.f12513i;
            if (j != 0) {
                if (j <= 0) {
                    return;
                }
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                if (this.k.a() <= j) {
                    return;
                }
            }
        }
        this.f12516q = true;
        this.f12514n.execute(new i0(this, this.f12517r));
    }

    public final List s() {
        try {
            try {
                t0 t0Var = this.f12510c;
                String str = this.f12512f;
                t0Var.getClass();
                List listUnmodifiableList = Collections.unmodifiableList(Arrays.asList(InetAddress.getAllByName(str)));
                ArrayList arrayList = new ArrayList(listUnmodifiableList.size());
                Iterator it = listUnmodifiableList.iterator();
                while (it.hasNext()) {
                    arrayList.add(new i4.u(new InetSocketAddress((InetAddress) it.next(), this.g)));
                }
                return Collections.unmodifiableList(arrayList);
            } catch (Exception e) {
                Object obj = e2.r.f11251a;
                if (e instanceof RuntimeException) {
                    throw ((RuntimeException) e);
                }
                throw new RuntimeException(e);
            }
        } catch (Throwable th) {
            if (0 != 0) {
                f12502s.log(Level.FINE, "Address resolution failure", (Throwable) null);
            }
            throw th;
        }
    }
}
