package j4;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f12183a = Logger.getLogger(f1.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f12184b = Collections.unmodifiableSet(EnumSet.of(i4.m1.OK, i4.m1.INVALID_ARGUMENT, i4.m1.NOT_FOUND, i4.m1.ALREADY_EXISTS, i4.m1.FAILED_PRECONDITION, i4.m1.ABORTED, i4.m1.OUT_OF_RANGE, i4.m1.DATA_LOSS));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i4.v0 f12185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final i4.v0 f12186d;
    public static final i4.y0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final i4.v0 f12187f;
    public static final i4.y0 g;
    public static final i4.v0 h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final i4.v0 f12188i;
    public static final i4.v0 j;
    public static final i4.v0 k;
    public static final long l;
    public static final r3 m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final e2.f f12189n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final d1 f12190o;
    public static final e3 p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final e3 f12191q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final e3 f12192r;

    static {
        Charset.forName("US-ASCII");
        f12185c = new i4.v0("grpc-timeout", new e3(14));
        i4.j jVar = i4.a1.f11818d;
        f12186d = new i4.v0("grpc-encoding", jVar);
        int i2 = 13;
        e = i4.g0.a("grpc-accept-encoding", new e3(i2));
        f12187f = new i4.v0("content-encoding", jVar);
        g = i4.g0.a("accept-encoding", new e3(i2));
        h = new i4.v0("content-length", jVar);
        f12188i = new i4.v0("content-type", jVar);
        j = new i4.v0("te", jVar);
        k = new i4.v0("user-agent", jVar);
        e2.c.f11226c.getClass();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        l = timeUnit.toNanos(20L);
        TimeUnit.HOURS.toNanos(2L);
        timeUnit.toNanos(20L);
        m = new r3();
        f12189n = new e2.f("io.grpc.internal.CALL_OPTIONS_RPC_OWNED_BY_BALANCER", 3, false);
        f12190o = new d1();
        p = new e3(10);
        f12191q = new e3(11);
        f12192r = new e3(12);
    }

    public static URI a(String str) {
        String str2;
        r2.q.D(str, "authority");
        try {
            str2 = str;
        } catch (URISyntaxException e4) {
            e = e4;
            str2 = str;
        }
        try {
            return new URI(null, str2, null, null, null);
        } catch (URISyntaxException e8) {
            e = e8;
            throw new IllegalArgumentException("Invalid authority: ".concat(str2), e);
        }
    }

    public static void b(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e4) {
            f12183a.log(Level.WARNING, "exception caught in closeQuietly", (Throwable) e4);
        }
    }

    public static i4.i[] c(i4.d dVar, i4.a1 a1Var, int i2, boolean z2) {
        List list = dVar.f11844d;
        int size = list.size();
        i4.i[] iVarArr = new i4.i[size + 1];
        i4.d dVar2 = i4.d.h;
        f2.b bVar = new f2.b(dVar, i2, z2);
        for (int i8 = 0; i8 < list.size(); i8++) {
            iVarArr[i8] = ((i4.h) list.get(i8)).a(bVar, a1Var);
        }
        iVarArr[size] = f12190o;
        return iVarArr;
    }

    public static String d(InetSocketAddress inetSocketAddress) {
        try {
            return (String) InetSocketAddress.class.getMethod("getHostString", null).invoke(inetSocketAddress, null);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return inetSocketAddress.getHostName();
        }
    }

    public static j2.r e(String str) {
        Boolean bool = Boolean.TRUE;
        String.format(Locale.ROOT, str, 0);
        return new j2.r(Executors.defaultThreadFactory(), str, new AtomicLong(0L), bool);
    }

    public static z f(i4.k0 k0Var, boolean z2) {
        o1 o1Var;
        i4.f fVar = k0Var.f11884a;
        i4.n1 n1Var = k0Var.f11886c;
        if (fVar == null) {
            o1Var = null;
        } else {
            t1 t1Var = (t1) fVar.f();
            o1Var = t1Var.f12470v;
            if (o1Var == null) {
                t1Var.k.execute(new n1(t1Var, 1));
                o1Var = null;
            }
        }
        if (o1Var != null) {
            i4.h hVar = k0Var.f11885b;
            return hVar == null ? o1Var : new z0(hVar, o1Var);
        }
        if (!n1Var.f()) {
            if (k0Var.f11887d) {
                return new z0(h(n1Var), x.f12540c);
            }
            if (!z2) {
                return new z0(h(n1Var), x.f12538a);
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static i4.n1 g(int r3) {
        /*
            r0 = 100
            if (r3 < r0) goto Lb
            r0 = 200(0xc8, float:2.8E-43)
            if (r3 >= r0) goto Lb
            i4.m1 r0 = i4.m1.INTERNAL
            goto L37
        Lb:
            r0 = 400(0x190, float:5.6E-43)
            if (r3 == r0) goto L35
            r0 = 401(0x191, float:5.62E-43)
            if (r3 == r0) goto L32
            r0 = 403(0x193, float:5.65E-43)
            if (r3 == r0) goto L2f
            r0 = 404(0x194, float:5.66E-43)
            if (r3 == r0) goto L2c
            r0 = 429(0x1ad, float:6.01E-43)
            if (r3 == r0) goto L29
            r0 = 431(0x1af, float:6.04E-43)
            if (r3 == r0) goto L35
            switch(r3) {
                case 502: goto L29;
                case 503: goto L29;
                case 504: goto L29;
                default: goto L26;
            }
        L26:
            i4.m1 r0 = i4.m1.UNKNOWN
            goto L37
        L29:
            i4.m1 r0 = i4.m1.UNAVAILABLE
            goto L37
        L2c:
            i4.m1 r0 = i4.m1.UNIMPLEMENTED
            goto L37
        L2f:
            i4.m1 r0 = i4.m1.PERMISSION_DENIED
            goto L37
        L32:
            i4.m1 r0 = i4.m1.UNAUTHENTICATED
            goto L37
        L35:
            i4.m1 r0 = i4.m1.INTERNAL
        L37:
            i4.n1 r0 = r0.a()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "HTTP status code "
            r1.<init>(r2)
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            i4.n1 r3 = r0.h(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: j4.f1.g(int):i4.n1");
    }

    public static i4.n1 h(i4.n1 n1Var) {
        r2.q.x(n1Var != null);
        if (!f12184b.contains(n1Var.f11918a)) {
            return n1Var;
        }
        return i4.n1.l.h("Inappropriate status code from control plane: " + n1Var.f11918a + " " + n1Var.f11919b).g(n1Var.f11920c);
    }
}
