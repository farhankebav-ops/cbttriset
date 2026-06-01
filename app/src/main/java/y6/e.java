package y6;

import e6.l;
import e6.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.k;
import q5.x;
import q6.f2;
import q6.j;
import r2.q;
import v6.s;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class e implements q6.i, f, f2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f17862f = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "state$volatile");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v5.h f17863a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f17865c;
    private volatile /* synthetic */ Object state$volatile = h.f17868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f17864b = new ArrayList(2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f17866d = -1;
    public Object e = h.f17871d;

    public e(v5.h hVar) {
        this.f17863a = hVar;
    }

    @Override // q6.i
    public final void a(Throwable th) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17862f;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == h.f17869b) {
                return;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, h.f17870c)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
            ArrayList arrayList = this.f17864b;
            if (arrayList == null) {
                return;
            }
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj2 = arrayList.get(i2);
                i2++;
                ((c) obj2).a();
            }
            this.e = h.f17871d;
            this.f17864b = null;
            return;
        }
    }

    @Override // q6.f2
    public final void b(s sVar, int i2) {
        this.f17865c = sVar;
        this.f17866d = i2;
    }

    public final Object c(x5.c cVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17862f;
        Object obj = atomicReferenceFieldUpdater.get(this);
        k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation.ClauseData<R of kotlinx.coroutines.selects.SelectImplementation>");
        c cVar2 = (c) obj;
        Object obj2 = this.e;
        ArrayList arrayList = this.f17864b;
        if (arrayList != null) {
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj3 = arrayList.get(i2);
                i2++;
                c cVar3 = (c) obj3;
                if (cVar3 != cVar2) {
                    cVar3.a();
                }
            }
            atomicReferenceFieldUpdater.set(this, h.f17869b);
            this.e = h.f17871d;
            this.f17864b = null;
        }
        Object objInvoke = cVar2.f17856c.invoke(cVar2.f17854a, cVar2.f17857d, obj2);
        v5.c cVar4 = cVar2.e;
        return cVar2.f17857d == h.e ? ((l) cVar4).invoke(cVar) : ((p) cVar4).invoke(objInvoke, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d(x5.c r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: y6.e.d(x5.c):java.lang.Object");
    }

    public final c e(Object obj) {
        ArrayList arrayList = this.f17864b;
        Object obj2 = null;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            Object obj3 = arrayList.get(i2);
            i2++;
            if (((c) obj3).f17854a == obj) {
                obj2 = obj3;
                break;
            }
        }
        c cVar = (c) obj2;
        if (cVar != null) {
            return cVar;
        }
        throw new IllegalStateException(("Clause with object " + obj + " is not found").toString());
    }

    public final void f(c cVar, boolean z2) {
        Object obj = cVar.f17854a;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17862f;
        if (atomicReferenceFieldUpdater.get(this) instanceof c) {
            return;
        }
        if (!z2) {
            ArrayList arrayList = this.f17864b;
            k.b(arrayList);
            if (!arrayList.isEmpty()) {
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj2 = arrayList.get(i2);
                    i2++;
                    if (((c) obj2).f17854a == obj) {
                        throw new IllegalStateException(("Cannot use select clauses on the same object: " + obj).toString());
                    }
                }
            }
        }
        cVar.f17855b.invoke(obj, this, cVar.f17857d);
        if (this.e != h.f17871d) {
            atomicReferenceFieldUpdater.set(this, cVar);
            return;
        }
        if (!z2) {
            ArrayList arrayList2 = this.f17864b;
            k.b(arrayList2);
            arrayList2.add(cVar);
        }
        cVar.g = this.f17865c;
        cVar.h = this.f17866d;
        this.f17865c = null;
        this.f17866d = -1;
    }

    public final int g(Object obj, Object obj2) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17862f;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (!(obj3 instanceof j)) {
                if (k.a(obj3, h.f17869b) || (obj3 instanceof c)) {
                    return 3;
                }
                if (k.a(obj3, h.f17870c)) {
                    return 2;
                }
                if (k.a(obj3, h.f17868a)) {
                    List listJ0 = q.j0(obj);
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj3, listJ0)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj3) {
                            break;
                        }
                    }
                    return 1;
                }
                if (!(obj3 instanceof List)) {
                    throw new IllegalStateException(("Unexpected state: " + obj3).toString());
                }
                ArrayList arrayListG1 = r5.l.g1((Collection) obj3, obj);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj3, arrayListG1)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj3) {
                        break;
                    }
                }
                return 1;
            }
            c cVarE = e(obj);
            if (cVarE != null) {
                e6.q qVar = cVarE.f17858f;
                e6.q qVar2 = qVar != null ? (e6.q) qVar.invoke(this, cVarE.f17857d, obj2) : null;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj3, cVarE)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj3) {
                        break;
                    }
                }
                j jVar = (j) obj3;
                this.e = obj2;
                e2.f fVarF = jVar.f(x.f13520a, qVar2);
                if (fVarF == null) {
                    this.e = h.f17871d;
                    return 2;
                }
                jVar.q(fVarF);
                return 0;
            }
            continue;
        }
    }
}
