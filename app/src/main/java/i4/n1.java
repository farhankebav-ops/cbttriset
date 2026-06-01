package i4;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class n1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List f11913d;
    public static final n1 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final n1 f11914f;
    public static final n1 g;
    public static final n1 h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final n1 f11915i;
    public static final n1 j;
    public static final n1 k;
    public static final n1 l;
    public static final n1 m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final y0 f11916n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final y0 f11917o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m1 f11918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Throwable f11920c;

    static {
        TreeMap treeMap = new TreeMap();
        for (m1 m1Var : m1.values()) {
            n1 n1Var = (n1) treeMap.put(Integer.valueOf(m1Var.f11909a), new n1(m1Var, null, null));
            if (n1Var != null) {
                throw new IllegalStateException("Code value duplication between " + n1Var.f11918a.name() + " & " + m1Var.name());
            }
        }
        f11913d = Collections.unmodifiableList(new ArrayList(treeMap.values()));
        e = m1.OK.a();
        f11914f = m1.CANCELLED.a();
        g = m1.UNKNOWN.a();
        m1.INVALID_ARGUMENT.a();
        h = m1.DEADLINE_EXCEEDED.a();
        m1.NOT_FOUND.a();
        m1.ALREADY_EXISTS.a();
        f11915i = m1.PERMISSION_DENIED.a();
        m1.UNAUTHENTICATED.a();
        j = m1.RESOURCE_EXHAUSTED.a();
        k = m1.FAILED_PRECONDITION.a();
        m1.ABORTED.a();
        m1.OUT_OF_RANGE.a();
        m1.UNIMPLEMENTED.a();
        l = m1.INTERNAL.a();
        m = m1.UNAVAILABLE.a();
        m1.DATA_LOSS.a();
        f11916n = new y0("grpc-status", false, new j(10));
        f11917o = new y0("grpc-message", false, new j(1));
    }

    public n1(m1 m1Var, String str, Throwable th) {
        r2.q.D(m1Var, "code");
        this.f11918a = m1Var;
        this.f11919b = str;
        this.f11920c = th;
    }

    public static String c(n1 n1Var) {
        String str = n1Var.f11919b;
        m1 m1Var = n1Var.f11918a;
        if (str == null) {
            return m1Var.toString();
        }
        return m1Var + ": " + n1Var.f11919b;
    }

    public static n1 d(int i2) {
        if (i2 >= 0) {
            List list = f11913d;
            if (i2 < list.size()) {
                return (n1) list.get(i2);
            }
        }
        return g.h("Unknown code " + i2);
    }

    public static n1 e(Throwable th) {
        r2.q.D(th, "t");
        for (Throwable cause = th; cause != null; cause = cause.getCause()) {
            if (cause instanceof o1) {
                return ((o1) cause).f11926a;
            }
            if (cause instanceof p1) {
                return ((p1) cause).f11928a;
            }
        }
        return g.g(th);
    }

    public final p1 a() {
        return new p1(this, null);
    }

    public final n1 b(String str) {
        if (str == null) {
            return this;
        }
        Throwable th = this.f11920c;
        m1 m1Var = this.f11918a;
        String str2 = this.f11919b;
        return str2 == null ? new n1(m1Var, str, th) : new n1(m1Var, a1.a.D(str2, "\n", str), th);
    }

    public final boolean f() {
        return m1.OK == this.f11918a;
    }

    public final n1 g(Throwable th) {
        return Objects.equals(this.f11920c, th) ? this : new n1(this.f11918a, this.f11919b, th);
    }

    public final n1 h(String str) {
        return Objects.equals(this.f11919b, str) ? this : new n1(this.f11918a, str, this.f11920c);
    }

    public final String toString() {
        e2.i iVarY = a.a.Y(this);
        iVarY.c(this.f11918a.name(), "code");
        iVarY.c(this.f11919b, "description");
        Throwable th = this.f11920c;
        Object string = th;
        if (th != null) {
            Object obj = e2.r.f11251a;
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            string = stringWriter.toString();
        }
        iVarY.c(string, "cause");
        return iVarY.toString();
    }
}
