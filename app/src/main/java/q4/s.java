package q4;

import i4.j0;
import i4.n0;
import i4.n1;
import java.lang.reflect.Array;
import java.net.SocketAddress;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class s extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i4.f f13476d;
    public k e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f13477f;
    public i4.n g;
    public n0 h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final i4.f f13478i;
    public final /* synthetic */ t j;

    public s(t tVar, j0 j0Var, h hVar) {
        this.j = tVar;
        n0 n0Var = (n0) j0Var.b();
        if (n0Var != null) {
            this.h = n0Var;
            f fVar = new f(this, n0Var, 1);
            j0 j0VarC = j0.c();
            j0VarC.d(j0Var.f11878b);
            i4.b bVar = j0Var.f11879c;
            r2.q.D(bVar, "attrs");
            j0VarC.f11879c = bVar;
            Object[][] objArr = j0Var.f11880d;
            Object[][] objArr2 = (Object[][]) Array.newInstance((Class<?>) Object.class, objArr.length, 2);
            j0VarC.f11880d = objArr2;
            System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
            j0VarC.a(fVar);
            this.f13476d = hVar.a(new j0(j0VarC.f11878b, j0VarC.f11879c, j0VarC.f11880d));
        } else {
            this.f13476d = hVar.a(j0Var);
        }
        this.f13478i = this.f13476d.e();
    }

    @Override // i4.f
    public final i4.b d() {
        k kVar = this.e;
        i4.f fVar = this.f13476d;
        if (kVar == null) {
            return fVar.d();
        }
        i4.b bVarD = fVar.d();
        bVarD.getClass();
        k kVar2 = this.e;
        IdentityHashMap identityHashMap = new IdentityHashMap(1);
        identityHashMap.put(t.f13479n, kVar2);
        for (Map.Entry entry : bVarD.f11822a.entrySet()) {
            if (!identityHashMap.containsKey(entry.getKey())) {
                identityHashMap.put((i4.a) entry.getKey(), entry.getValue());
            }
        }
        return new i4.b(identityHashMap);
    }

    @Override // q4.b, i4.f
    public final void p() {
        k kVar = this.e;
        if (kVar != null) {
            this.e = null;
            kVar.f13457f.remove(this);
        }
        super.p();
    }

    @Override // i4.f
    public final void r(n0 n0Var) {
        if (this.h != null) {
            t().r(n0Var);
            return;
        }
        this.h = n0Var;
        t().r(new f(this, n0Var, 1));
    }

    @Override // q4.b, i4.f
    public final void s(List list) {
        t tVar = this.j;
        if (t.g(c()) && t.g(list)) {
            l lVar = tVar.f13480f;
            if (lVar.f13458a.containsValue(this.e)) {
                k kVar = this.e;
                kVar.getClass();
                this.e = null;
                kVar.f13457f.remove(this);
            }
            SocketAddress socketAddress = (SocketAddress) ((i4.u) list.get(0)).f11961a.get(0);
            if (tVar.f13480f.f13458a.containsKey(socketAddress)) {
                ((k) tVar.f13480f.f13458a.get(socketAddress)).a(this);
            }
        } else if (t.g(c()) && !t.g(list)) {
            l lVar2 = tVar.f13480f;
            if (lVar2.f13458a.containsKey(b().f11961a.get(0))) {
                l lVar3 = tVar.f13480f;
                k kVar2 = (k) lVar3.f13458a.get(b().f11961a.get(0));
                kVar2.getClass();
                this.e = null;
                kVar2.f13457f.remove(this);
                android.support.v4.media.g gVar = kVar2.f13454b;
                ((AtomicLong) gVar.f3263b).set(0L);
                ((AtomicLong) gVar.f3264c).set(0L);
                android.support.v4.media.g gVar2 = kVar2.f13455c;
                ((AtomicLong) gVar2.f3263b).set(0L);
                ((AtomicLong) gVar2.f3264c).set(0L);
            }
        } else if (!t.g(c()) && t.g(list)) {
            SocketAddress socketAddress2 = (SocketAddress) ((i4.u) list.get(0)).f11961a.get(0);
            if (tVar.f13480f.f13458a.containsKey(socketAddress2)) {
                ((k) tVar.f13480f.f13458a.get(socketAddress2)).a(this);
            }
        }
        this.f13476d.s(list);
    }

    @Override // q4.b
    public final i4.f t() {
        return this.f13476d;
    }

    @Override // q4.b
    public final String toString() {
        return "OutlierDetectionSubchannel{addresses=" + this.f13476d.c() + '}';
    }

    public final void u() {
        this.f13477f = true;
        n0 n0Var = this.h;
        n1 n1Var = n1.m;
        r2.q.y(!n1Var.f(), "The error status must not be OK");
        n0Var.a(new i4.n(i4.m.f11896c, n1Var));
        this.f13478i.j(2, "Subchannel ejected: {0}", this);
    }
}
