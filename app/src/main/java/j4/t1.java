package j4;

import com.ironsource.C2300e4;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class t1 implements i4.d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i4.e0 f12457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e3 f12459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g5 f12460d;
    public final b0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ScheduledExecutorService f12461f;
    public final i4.b0 g;
    public final h h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final i4.f f12462i;
    public final List j;
    public final i4.s1 k;
    public final p1 l;
    public volatile List m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public x0 f12463n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final e2.m f12464o;
    public android.support.v4.media.g p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public android.support.v4.media.g f12465q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public y2 f12466r;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public o1 f12469u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile o1 f12470v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public i4.n1 f12472x;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ArrayList f12467s = new ArrayList();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final m1 f12468t = new m1(this, 0);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public volatile i4.n f12471w = i4.n.a(i4.m.f11897d);

    public t1(List list, String str, e3 e3Var, n nVar, ScheduledExecutorService scheduledExecutorService, e2.n nVar2, i4.s1 s1Var, g5 g5Var, i4.b0 b0Var, h hVar, q qVar, i4.e0 e0Var, i4.f fVar, ArrayList arrayList) {
        r2.q.D(list, "addressGroups");
        r2.q.y(!list.isEmpty(), "addressGroups is empty");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            r2.q.D(it.next(), "addressGroups contains null entry");
        }
        List listUnmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        this.m = listUnmodifiableList;
        p1 p1Var = new p1();
        p1Var.f12363a = listUnmodifiableList;
        this.l = p1Var;
        this.f12458b = str;
        this.f12459c = e3Var;
        this.e = nVar;
        this.f12461f = scheduledExecutorService;
        this.f12464o = (e2.m) nVar2.get();
        this.k = s1Var;
        this.f12460d = g5Var;
        this.g = b0Var;
        this.h = hVar;
        r2.q.D(qVar, "channelTracer");
        r2.q.D(e0Var, "logId");
        this.f12457a = e0Var;
        r2.q.D(fVar, "channelLogger");
        this.f12462i = fVar;
        this.j = arrayList;
    }

    public static void e(t1 t1Var, i4.m mVar) {
        t1Var.k.d();
        t1Var.g(i4.n.a(mVar));
    }

    public static void f(t1 t1Var) {
        SocketAddress socketAddress;
        i4.y yVar;
        p1 p1Var = t1Var.l;
        i4.s1 s1Var = t1Var.k;
        s1Var.d();
        r2.q.H(t1Var.p == null, "Should have no reconnectTask scheduled");
        if (p1Var.f12364b == 0 && p1Var.f12365c == 0) {
            e2.m mVar = t1Var.f12464o;
            mVar.f11240a = false;
            mVar.b();
        }
        SocketAddress socketAddress2 = (SocketAddress) ((i4.u) ((List) p1Var.f12363a).get(p1Var.f12364b)).f11961a.get(p1Var.f12365c);
        if (socketAddress2 instanceof i4.y) {
            yVar = (i4.y) socketAddress2;
            socketAddress = yVar.f11976b;
        } else {
            socketAddress = socketAddress2;
            yVar = null;
        }
        i4.b bVar = ((i4.u) ((List) p1Var.f12363a).get(p1Var.f12364b)).f11962b;
        String str = (String) bVar.f11822a.get(i4.u.f11960d);
        a0 a0Var = new a0();
        a0Var.f12099a = "unknown-authority";
        a0Var.f12100b = i4.b.f11821b;
        if (str == null) {
            str = t1Var.f12458b;
        }
        r2.q.D(str, "authority");
        a0Var.f12099a = str;
        a0Var.f12100b = bVar;
        a0Var.f12101c = yVar;
        s1 s1Var2 = new s1();
        s1Var2.f12442d = t1Var.f12457a;
        o1 o1Var = new o1(t1Var.e.m(socketAddress, a0Var, s1Var2), t1Var.h);
        s1Var2.f12442d = o1Var.a();
        t1Var.f12469u = o1Var;
        t1Var.f12467s.add(o1Var);
        Runnable runnableC = o1Var.c(new r1(t1Var, o1Var));
        if (runnableC != null) {
            s1Var.b(runnableC);
        }
        t1Var.f12462i.j(2, "Started transport {0}", s1Var2.f12442d);
    }

    public static String h(i4.n1 n1Var) {
        StringBuilder sb = new StringBuilder();
        i4.m1 m1Var = n1Var.f11918a;
        Throwable th = n1Var.f11920c;
        sb.append(m1Var);
        String str = n1Var.f11919b;
        if (str != null) {
            androidx.camera.core.processing.util.a.z(sb, "(", str, ")");
        }
        if (th != null) {
            sb.append(C2300e4.i.f8403d);
            sb.append(th);
            sb.append(C2300e4.i.e);
        }
        return sb.toString();
    }

    @Override // i4.d0
    public final i4.e0 a() {
        return this.f12457a;
    }

    public final void g(i4.n nVar) {
        this.k.d();
        if (this.f12471w.f11911a != nVar.f11911a) {
            r2.q.H(this.f12471w.f11911a != i4.m.e, "Cannot transition out of SHUTDOWN to " + nVar);
            this.f12471w = nVar;
            ((i4.n0) this.f12460d.f12229b).a(nVar);
        }
    }

    public final String toString() {
        e2.i iVarY = a.a.Y(this);
        iVarY.d("logId", this.f12457a.f11854c);
        iVarY.c(this.m, "addressGroups");
        return iVarY.toString();
    }
}
