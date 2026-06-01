package q6;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class w extends v5.a implements v5.e {
    public static final v Key = new v(v5.d.f17609a, new androidx.activity.u(11));

    public w() {
        super(v5.d.f17609a);
    }

    public static /* synthetic */ w limitedParallelism$default(w wVar, int i2, String str, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: limitedParallelism");
        }
        if ((i8 & 2) != 0) {
            str = null;
        }
        return wVar.limitedParallelism(i2, str);
    }

    public abstract void dispatch(v5.h hVar, Runnable runnable);

    public void dispatchYield(v5.h hVar, Runnable runnable) {
        dispatch(hVar, runnable);
    }

    @Override // v5.a, v5.h
    public <E extends v5.f> E get(v5.g key) {
        E e;
        kotlin.jvm.internal.k.e(key, "key");
        if (!(key instanceof v)) {
            if (v5.d.f17609a == key) {
                return this;
            }
            return null;
        }
        v vVar = (v) key;
        v5.g key2 = getKey();
        kotlin.jvm.internal.k.e(key2, "key");
        if ((key2 == vVar || vVar.f13594b == key2) && (e = (E) vVar.f13593a.invoke(this)) != null) {
            return e;
        }
        return null;
    }

    @Override // v5.e
    public final <T> v5.c<T> interceptContinuation(v5.c<? super T> cVar) {
        return new v6.f(this, cVar);
    }

    public boolean isDispatchNeeded(v5.h hVar) {
        return !(this instanceof c2);
    }

    public w limitedParallelism(int i2, String str) {
        v6.a.a(i2);
        return new v6.g(this, i2, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
    
        if (((v5.f) r3.f13593a.invoke(r2)) == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
    
        if (v5.d.f17609a == r3) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002b, code lost:
    
        return v5.i.f17610a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
    
        return r2;
     */
    @Override // v5.a, v5.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public v5.h minusKey(v5.g r3) {
        /*
            r2 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.k.e(r3, r0)
            boolean r1 = r3 instanceof q6.v
            if (r1 == 0) goto L25
            q6.v r3 = (q6.v) r3
            v5.g r1 = r2.getKey()
            kotlin.jvm.internal.k.e(r1, r0)
            if (r1 == r3) goto L1a
            v5.g r0 = r3.f13594b
            if (r0 != r1) goto L19
            goto L1a
        L19:
            return r2
        L1a:
            e6.l r3 = r3.f13593a
            java.lang.Object r3 = r3.invoke(r2)
            v5.f r3 = (v5.f) r3
            if (r3 == 0) goto L2c
            goto L29
        L25:
            v5.d r0 = v5.d.f17609a
            if (r0 != r3) goto L2c
        L29:
            v5.i r3 = v5.i.f17610a
            return r3
        L2c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: q6.w.minusKey(v5.g):v5.h");
    }

    @Override // v5.e
    public final void releaseInterceptedContinuation(v5.c<?> cVar) {
        kotlin.jvm.internal.k.c(cVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        v6.f fVar = (v6.f) cVar;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = v6.f.h;
        while (atomicReferenceFieldUpdater.get(fVar) == v6.a.f17615c) {
        }
        Object obj = atomicReferenceFieldUpdater.get(fVar);
        l lVar = obj instanceof l ? (l) obj : null;
        if (lVar != null) {
            lVar.m();
        }
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + c0.p(this);
    }

    public /* synthetic */ w limitedParallelism(int i2) {
        return limitedParallelism(i2, null);
    }

    public final w plus(w wVar) {
        return wVar;
    }
}
