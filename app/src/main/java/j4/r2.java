package j4;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class r2 extends i4.x {
    public static final Method E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a4.a f12412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a4.a f12413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f12414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i4.h1 f12415d;
    public final ArrayList e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f12416f;
    public final String g;
    public final i4.t h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final i4.l f12417i;
    public final long j;
    public final int k;
    public final int l;
    public final long m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f12418n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f12419o;
    public final i4.b0 p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f12420q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f12421r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f12422s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f12423t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f12424u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f12425v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final k4.f f12426w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final k4.f f12427x;
    public static final Logger y = Logger.getLogger(r2.class.getName());

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final long f12411z = TimeUnit.MINUTES.toMillis(30);
    public static final long A = TimeUnit.SECONDS.toMillis(1);
    public static final a4.a B = new a4.a(f1.p, 19);
    public static final i4.t C = i4.t.f11955d;
    public static final i4.l D = i4.l.f11889b;

    static {
        Method declaredMethod;
        try {
            Class<?> cls = Class.forName("io.grpc.census.InternalCensusStatsAccessor");
            Class<?> cls2 = Boolean.TYPE;
            declaredMethod = cls.getDeclaredMethod("getClientInterceptor", cls2, cls2, cls2, cls2);
        } catch (ClassNotFoundException e) {
            y.log(Level.FINE, "Unable to apply census stats", (Throwable) e);
            declaredMethod = null;
        } catch (NoSuchMethodException e4) {
            y.log(Level.FINE, "Unable to apply census stats", (Throwable) e4);
            declaredMethod = null;
        }
        E = declaredMethod;
    }

    public r2(String str, k4.f fVar, k4.f fVar2) {
        i4.h1 h1Var;
        a4.a aVar = B;
        this.f12412a = aVar;
        this.f12413b = aVar;
        this.f12414c = new ArrayList();
        Logger logger = i4.h1.f11869d;
        synchronized (i4.h1.class) {
            try {
                if (i4.h1.e == null) {
                    ArrayList arrayList = new ArrayList();
                    try {
                        boolean z2 = w0.f12525a;
                        arrayList.add(w0.class);
                    } catch (ClassNotFoundException e) {
                        i4.h1.f11869d.log(Level.FINE, "Unable to find DNS NameResolver", (Throwable) e);
                    }
                    List<i4.g1> listH = i4.f.h(i4.g1.class, Collections.unmodifiableList(arrayList), i4.g1.class.getClassLoader(), new i4.j(9));
                    if (listH.isEmpty()) {
                        i4.h1.f11869d.warning("No NameResolverProviders found via ServiceLoader, including for DNS. This is probably due to a broken build. If using ProGuard, check your configuration");
                    }
                    i4.h1.e = new i4.h1();
                    for (i4.g1 g1Var : listH) {
                        i4.h1.f11869d.fine("Service loader found " + g1Var);
                        i4.h1.e.a(g1Var);
                    }
                    i4.h1.e.c();
                }
                h1Var = i4.h1.e;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f12415d = h1Var;
        this.e = new ArrayList();
        this.g = "pick_first";
        this.h = C;
        this.f12417i = D;
        this.j = f12411z;
        this.k = 5;
        this.l = 5;
        this.m = 16777216L;
        this.f12418n = 1048576L;
        this.f12419o = true;
        this.p = i4.b0.e;
        this.f12420q = true;
        this.f12421r = true;
        this.f12422s = true;
        this.f12423t = true;
        this.f12424u = true;
        this.f12425v = true;
        r2.q.D(str, TypedValues.AttributesType.S_TARGET);
        this.f12416f = str;
        this.f12426w = fVar;
        this.f12427x = fVar2;
    }
}
