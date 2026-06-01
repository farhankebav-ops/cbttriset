package j4;

import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class k3 extends i4.o0 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Logger f12286o = Logger.getLogger(k3.class.getName());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i4.x f12287f;
    public p1 h;
    public android.support.v4.media.g k;
    public i4.m l;
    public i4.m m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f12289n;
    public final HashMap g = new HashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f12288i = 0;
    public boolean j = true;

    public k3(i4.x xVar) {
        boolean z2 = false;
        i4.m mVar = i4.m.f11897d;
        this.l = mVar;
        this.m = mVar;
        Logger logger = f1.f12183a;
        String property = System.getenv("GRPC_EXPERIMENTAL_XDS_DUALSTACK_ENDPOINTS");
        property = property == null ? System.getProperty("GRPC_EXPERIMENTAL_XDS_DUALSTACK_ENDPOINTS") : property;
        if (!n7.b.R(property) && Boolean.parseBoolean(property)) {
            z2 = true;
        }
        this.f12289n = z2;
        this.f12287f = xVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i4.o0
    public final i4.n1 a(i4.l0 l0Var) {
        int iB;
        List list;
        i4.m mVar;
        if (this.l == i4.m.e) {
            return i4.n1.k.h("Already shut down");
        }
        List list2 = l0Var.f11891a;
        Object obj = l0Var.f11892b;
        if (list2.isEmpty()) {
            i4.n1 n1VarH = i4.n1.m.h("NameResolver returned no usable address. addrs=" + list2 + ", attrs=" + obj);
            c(n1VarH);
            return n1VarH;
        }
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            if (((i4.u) it.next()) == null) {
                i4.n1 n1VarH2 = i4.n1.m.h("NameResolver returned address list with null endpoint. addrs=" + list2 + ", attrs=" + obj);
                c(n1VarH2);
                return n1VarH2;
            }
        }
        this.j = true;
        f2.c cVar = f2.e.f11320b;
        a.a.o(4, "initialCapacity");
        Object[] objArrCopyOf = new Object[4];
        int iD = f2.b.d(objArrCopyOf.length, list2.size() + 0);
        if (iD > objArrCopyOf.length) {
            objArrCopyOf = Arrays.copyOf(objArrCopyOf, iD);
        }
        if (list2 instanceof f2.a) {
            iB = ((f2.a) list2).b(0, objArrCopyOf);
        } else {
            int i2 = 0;
            boolean z2 = false;
            for (Object obj2 : list2) {
                obj2.getClass();
                int iD2 = f2.b.d(objArrCopyOf.length, i2 + 1);
                if (iD2 > objArrCopyOf.length || z2) {
                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, iD2);
                    z2 = false;
                }
                objArrCopyOf[i2] = obj2;
                i2++;
            }
            iB = i2;
        }
        f2.k kVarG = f2.e.g(iB, objArrCopyOf);
        p1 p1Var = this.h;
        i4.m mVar2 = i4.m.f11895b;
        if (p1Var == null) {
            p1 p1Var2 = new p1();
            p1Var2.f12363a = kVarG != null ? kVarG : Collections.EMPTY_LIST;
            this.h = p1Var2;
        } else if (this.l == mVar2) {
            SocketAddress socketAddressA = p1Var.a();
            p1 p1Var3 = this.h;
            if (kVarG != null) {
                list = kVarG;
            } else {
                p1Var3.getClass();
                list = Collections.EMPTY_LIST;
            }
            p1Var3.f12363a = list;
            p1Var3.f12364b = 0;
            p1Var3.f12365c = 0;
            if (this.h.e(socketAddressA)) {
                return i4.n1.e;
            }
            p1 p1Var4 = this.h;
            p1Var4.f12364b = 0;
            p1Var4.f12365c = 0;
        } else {
            p1Var.f12363a = kVarG != null ? kVarG : Collections.EMPTY_LIST;
            p1Var.f12364b = 0;
            p1Var.f12365c = 0;
        }
        HashMap map = this.g;
        HashSet<SocketAddress> hashSet = new HashSet(map.keySet());
        HashSet hashSet2 = new HashSet();
        f2.c cVarListIterator = kVarG.listIterator(0);
        while (cVarListIterator.hasNext()) {
            hashSet2.addAll(((i4.u) cVarListIterator.next()).f11961a);
        }
        for (SocketAddress socketAddress : hashSet) {
            if (!hashSet2.contains(socketAddress)) {
                ((j3) map.remove(socketAddress)).f12269a.p();
            }
        }
        int size = hashSet.size();
        i4.m mVar3 = i4.m.f11894a;
        if (size == 0 || (mVar = this.l) == mVar3 || mVar == mVar2) {
            this.l = mVar3;
            i(mVar3, new h3(i4.k0.e));
            g();
            e();
        } else {
            i4.m mVar4 = i4.m.f11897d;
            if (mVar == mVar4) {
                i(mVar4, new i3(this, this));
            } else if (mVar == i4.m.f11896c) {
                g();
                e();
            }
        }
        return i4.n1.e;
    }

    @Override // i4.o0
    public final void c(i4.n1 n1Var) {
        HashMap map = this.g;
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            ((j3) it.next()).f12269a.p();
        }
        map.clear();
        i(i4.m.f11896c, new h3(i4.k0.a(n1Var)));
    }

    @Override // i4.o0
    public final void e() {
        i4.f fVar;
        p1 p1Var = this.h;
        if (p1Var == null || !p1Var.c() || this.l == i4.m.e) {
            return;
        }
        SocketAddress socketAddressA = this.h.a();
        HashMap map = this.g;
        boolean zContainsKey = map.containsKey(socketAddressA);
        Logger logger = f12286o;
        if (zContainsKey) {
            fVar = ((j3) map.get(socketAddressA)).f12269a;
        } else {
            g3 g3Var = new g3(this);
            i4.j0 j0VarC = i4.j0.c();
            i4.u[] uVarArr = {new i4.u(socketAddressA)};
            a.a.o(1, "arraySize");
            ArrayList arrayList = new ArrayList(r2.q.p0(((long) 1) + 5 + ((long) 0)));
            Collections.addAll(arrayList, uVarArr);
            j0VarC.d(arrayList);
            j0VarC.a(g3Var);
            final i4.f fVarA = this.f12287f.a(new i4.j0(j0VarC.f11878b, j0VarC.f11879c, j0VarC.f11880d));
            if (fVarA == null) {
                logger.warning("Was not able to create subchannel for " + socketAddressA);
                throw new IllegalStateException("Can't create subchannel");
            }
            j3 j3Var = new j3(fVarA, g3Var);
            g3Var.f12222b = j3Var;
            map.put(socketAddressA, j3Var);
            if (fVarA.d().f11822a.get(i4.o0.f11924d) == null) {
                g3Var.f12221a = i4.n.a(i4.m.f11895b);
            }
            fVarA.r(new i4.n0() { // from class: j4.f3
                @Override // i4.n0
                public final void a(i4.n nVar) {
                    i4.f fVar2;
                    k3 k3Var = this.f12194a;
                    i4.x xVar = k3Var.f12287f;
                    i4.m mVar = nVar.f11911a;
                    HashMap map2 = k3Var.g;
                    i4.f fVar3 = fVarA;
                    j3 j3Var2 = (j3) map2.get((SocketAddress) fVar3.b().f11961a.get(0));
                    if (j3Var2 == null || (fVar2 = j3Var2.f12269a) != fVar3 || mVar == i4.m.e) {
                        return;
                    }
                    i4.m mVar2 = i4.m.f11897d;
                    if (mVar == mVar2) {
                        xVar.k();
                    }
                    j3.a(j3Var2, mVar);
                    i4.m mVar3 = k3Var.l;
                    i4.m mVar4 = i4.m.f11894a;
                    i4.m mVar5 = i4.m.f11896c;
                    if (mVar3 == mVar5 || k3Var.m == mVar5) {
                        if (mVar == mVar4) {
                            return;
                        }
                        if (mVar == mVar2) {
                            k3Var.e();
                            return;
                        }
                    }
                    int iOrdinal = mVar.ordinal();
                    if (iOrdinal == 0) {
                        k3Var.l = mVar4;
                        k3Var.i(mVar4, new h3(i4.k0.e));
                        return;
                    }
                    if (iOrdinal == 1) {
                        k3Var.g();
                        for (j3 j3Var3 : map2.values()) {
                            if (!j3Var3.f12269a.equals(fVar2)) {
                                j3Var3.f12269a.p();
                            }
                        }
                        map2.clear();
                        i4.m mVar6 = i4.m.f11895b;
                        j3.a(j3Var2, mVar6);
                        map2.put((SocketAddress) fVar2.b().f11961a.get(0), j3Var2);
                        k3Var.h.e((SocketAddress) fVar3.b().f11961a.get(0));
                        k3Var.l = mVar6;
                        k3Var.j(j3Var2);
                        return;
                    }
                    if (iOrdinal != 2) {
                        if (iOrdinal != 3) {
                            throw new IllegalArgumentException("Unsupported state:" + mVar);
                        }
                        p1 p1Var2 = k3Var.h;
                        p1Var2.f12364b = 0;
                        p1Var2.f12365c = 0;
                        k3Var.l = mVar2;
                        k3Var.i(mVar2, new i3(k3Var, k3Var));
                        return;
                    }
                    if (k3Var.h.c() && ((j3) map2.get(k3Var.h.a())).f12269a == fVar3 && k3Var.h.b()) {
                        k3Var.g();
                        k3Var.e();
                    }
                    p1 p1Var3 = k3Var.h;
                    if (p1Var3 == null || p1Var3.c()) {
                        return;
                    }
                    int size = map2.size();
                    List list = (List) k3Var.h.f12363a;
                    if (size < (list != null ? list.size() : 0)) {
                        return;
                    }
                    Iterator it = map2.values().iterator();
                    while (it.hasNext()) {
                        if (!((j3) it.next()).f12272d) {
                            return;
                        }
                    }
                    k3Var.l = mVar5;
                    k3Var.i(mVar5, new h3(i4.k0.a(nVar.f11912b)));
                    int i2 = k3Var.f12288i + 1;
                    k3Var.f12288i = i2;
                    List list2 = (List) k3Var.h.f12363a;
                    if (i2 >= (list2 != null ? list2.size() : 0) || k3Var.j) {
                        k3Var.j = false;
                        k3Var.f12288i = 0;
                        xVar.k();
                    }
                }
            });
            fVar = fVarA;
        }
        int iOrdinal = ((j3) map.get(socketAddressA)).f12270b.ordinal();
        if (iOrdinal == 0) {
            if (this.f12289n) {
                h();
                return;
            } else {
                fVar.n();
                return;
            }
        }
        if (iOrdinal == 1) {
            logger.warning("Requesting a connection even though we have a READY subchannel");
            return;
        }
        if (iOrdinal == 2) {
            this.h.b();
            e();
        } else {
            if (iOrdinal != 3) {
                return;
            }
            fVar.n();
            j3.a((j3) map.get(socketAddressA), i4.m.f11894a);
            h();
        }
    }

    @Override // i4.o0
    public final void f() {
        Level level = Level.FINE;
        HashMap map = this.g;
        f12286o.log(level, "Shutting down, currently have {} subchannels created", Integer.valueOf(map.size()));
        i4.m mVar = i4.m.e;
        this.l = mVar;
        this.m = mVar;
        g();
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            ((j3) it.next()).f12269a.p();
        }
        map.clear();
    }

    public final void g() {
        android.support.v4.media.g gVar = this.k;
        if (gVar != null) {
            gVar.c();
            this.k = null;
        }
    }

    public final void h() {
        if (this.f12289n) {
            android.support.v4.media.g gVar = this.k;
            if (gVar != null) {
                i4.r1 r1Var = (i4.r1) gVar.f3263b;
                if (!r1Var.f11948c && !r1Var.f11947b) {
                    return;
                }
            }
            i4.x xVar = this.f12287f;
            this.k = xVar.e().c(new a4.c(this, 11), 250L, TimeUnit.MILLISECONDS, xVar.c());
        }
    }

    public final void i(i4.m mVar, i4.m0 m0Var) {
        if (mVar == this.m && (mVar == i4.m.f11897d || mVar == i4.m.f11894a)) {
            return;
        }
        this.m = mVar;
        this.f12287f.n(mVar, m0Var);
    }

    public final void j(j3 j3Var) {
        i4.m mVar = j3Var.f12270b;
        i4.m mVar2 = i4.m.f11895b;
        if (mVar != mVar2) {
            return;
        }
        i4.n nVar = j3Var.f12271c.f12221a;
        i4.m mVar3 = nVar.f11911a;
        if (mVar3 == mVar2) {
            i(mVar2, new e2(i4.k0.b(j3Var.f12269a, null)));
            return;
        }
        i4.m mVar4 = i4.m.f11896c;
        if (mVar3 == mVar4) {
            i(mVar4, new h3(i4.k0.a(nVar.f11912b)));
        } else if (this.m != mVar4) {
            i(mVar3, new h3(i4.k0.e));
        }
    }
}
