package q4;

import i4.k0;
import i4.l0;
import i4.m0;
import i4.n1;
import i4.o0;
import i4.p0;
import j4.e2;
import j4.p3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class x extends o0 {
    public static final Logger m = Logger.getLogger(x.class.getName());
    public final i4.x g;
    public boolean h;
    public i4.m j;
    public final AtomicInteger k;
    public m0 l;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedHashMap f13485f = new LinkedHashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final p3 f13486i = new p3();

    public x(i4.x xVar) {
        this.g = xVar;
        m.log(Level.FINE, "Created");
        this.k = new AtomicInteger(new Random().nextInt());
        this.l = new v();
    }

    @Override // i4.o0
    public final n1 a(l0 l0Var) {
        try {
            this.h = true;
            android.support.v4.media.g gVarG = g(l0Var);
            n1 n1Var = (n1) gVarG.f3263b;
            if (!n1Var.f()) {
                return n1Var;
            }
            j();
            for (i iVar : (List) gVarG.f3264c) {
                iVar.f13447b.f();
                iVar.f13449d = i4.m.e;
                m.log(Level.FINE, "Child balancer {0} deleted", iVar.f13446a);
            }
            return n1Var;
        } finally {
            this.h = false;
        }
    }

    @Override // i4.o0
    public final void c(n1 n1Var) {
        if (this.j != i4.m.f11895b) {
            this.g.n(i4.m.f11896c, new e2(k0.a(n1Var)));
        }
    }

    @Override // i4.o0
    public final void f() {
        Level level = Level.FINE;
        Logger logger = m;
        logger.log(level, "Shutdown");
        LinkedHashMap linkedHashMap = this.f13485f;
        for (i iVar : linkedHashMap.values()) {
            iVar.f13447b.f();
            iVar.f13449d = i4.m.e;
            logger.log(Level.FINE, "Child balancer {0} deleted", iVar.f13446a);
        }
        linkedHashMap.clear();
    }

    public final android.support.v4.media.g g(l0 l0Var) {
        LinkedHashMap linkedHashMap;
        f2.e eVarG;
        j jVar;
        i4.u uVar;
        Level level = Level.FINE;
        Logger logger = m;
        logger.log(level, "Received resolution result: {0}", l0Var);
        HashMap map = new HashMap();
        List list = l0Var.f11891a;
        Iterator it = list.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            linkedHashMap = this.f13485f;
            if (!zHasNext) {
                break;
            }
            j jVar2 = new j((i4.u) it.next());
            i iVar = (i) linkedHashMap.get(jVar2);
            if (iVar != null) {
                map.put(jVar2, iVar);
            } else {
                map.put(jVar2, new i(this, jVar2, this.f13486i, new e2(k0.e)));
            }
        }
        int i2 = 20;
        Object obj = null;
        if (map.isEmpty()) {
            n1 n1VarH = n1.m.h("NameResolver returned no usable address. " + l0Var);
            c(n1VarH);
            return new android.support.v4.media.g(i2, n1VarH, obj);
        }
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            p0 p0Var = ((i) entry.getValue()).f13448c;
            ((i) entry.getValue()).getClass();
            if (linkedHashMap.containsKey(key)) {
                i iVar2 = (i) linkedHashMap.get(key);
                if (iVar2.f13450f) {
                    iVar2.f13450f = false;
                }
            } else {
                linkedHashMap.put(key, (i) entry.getValue());
            }
            i iVar3 = (i) linkedHashMap.get(key);
            if (key instanceof i4.u) {
                jVar = new j((i4.u) key);
            } else {
                r2.q.y(key instanceof j, "key is wrong type");
                jVar = (j) key;
            }
            Iterator it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    uVar = null;
                    break;
                }
                uVar = (i4.u) it2.next();
                if (jVar.equals(new j(uVar))) {
                    break;
                }
            }
            r2.q.D(uVar, key + " no longer present in load balancer children");
            i4.b bVar = i4.b.f11821b;
            List listSingletonList = Collections.singletonList(uVar);
            i4.b bVar2 = i4.b.f11821b;
            Boolean bool = Boolean.TRUE;
            IdentityHashMap identityHashMap = new IdentityHashMap(1);
            identityHashMap.put(o0.e, bool);
            for (Map.Entry entry2 : bVar2.f11822a.entrySet()) {
                if (!identityHashMap.containsKey(entry2.getKey())) {
                    identityHashMap.put((i4.a) entry2.getKey(), entry2.getValue());
                }
            }
            l0 l0Var2 = new l0(listSingletonList, new i4.b(identityHashMap), null);
            ((i) linkedHashMap.get(key)).getClass();
            if (!iVar3.f13450f) {
                iVar3.f13447b.d(l0Var2);
            }
        }
        ArrayList arrayList = new ArrayList();
        Collection collectionKeySet = linkedHashMap.keySet();
        f2.c cVar = f2.e.f11320b;
        if (collectionKeySet instanceof f2.a) {
            eVarG = ((f2.a) collectionKeySet).a();
            if (eVarG.f()) {
                Object[] array = eVarG.toArray(f2.a.f11310a);
                eVarG = f2.e.g(array.length, array);
            }
        } else {
            Object[] array2 = collectionKeySet.toArray();
            r2.q.B(array2.length, array2);
            eVarG = f2.e.g(array2.length, array2);
        }
        f2.c cVarListIterator = eVarG.listIterator(0);
        while (cVarListIterator.hasNext()) {
            Object next = cVarListIterator.next();
            if (!map.containsKey(next)) {
                i iVar4 = (i) linkedHashMap.get(next);
                j jVar3 = iVar4.f13446a;
                if (!iVar4.f13450f) {
                    iVar4.g.f13485f.remove(jVar3);
                    iVar4.f13450f = true;
                    logger.log(Level.FINE, "Child balancer {0} deactivated", jVar3);
                }
                arrayList.add(iVar4);
            }
        }
        return new android.support.v4.media.g(i2, n1.e, arrayList);
    }

    public final w h(Collection collection) {
        ArrayList arrayList = new ArrayList();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(((i) it.next()).e);
        }
        return new w(arrayList, this.k);
    }

    public final void i(i4.m mVar, m0 m0Var) {
        if (mVar == this.j && m0Var.equals(this.l)) {
            return;
        }
        this.g.n(mVar, m0Var);
        this.j = mVar;
        this.l = m0Var;
    }

    public final void j() {
        i4.m mVar;
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = this.f13485f;
        Iterator it = linkedHashMap.values().iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            mVar = i4.m.f11895b;
            if (!zHasNext) {
                break;
            }
            i iVar = (i) it.next();
            if (!iVar.f13450f && iVar.f13449d == mVar) {
                arrayList.add(iVar);
            }
        }
        if (!arrayList.isEmpty()) {
            i(mVar, h(arrayList));
            return;
        }
        Iterator it2 = linkedHashMap.values().iterator();
        while (it2.hasNext()) {
            i4.m mVar2 = ((i) it2.next()).f13449d;
            i4.m mVar3 = i4.m.f11894a;
            if (mVar2 == mVar3 || mVar2 == i4.m.f11897d) {
                i(mVar3, new v());
                return;
            }
        }
        i(i4.m.f11896c, h(linkedHashMap.values()));
    }
}
