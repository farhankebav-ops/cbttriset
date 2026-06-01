package v6;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import q6.c0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f17631a = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_next$volatile");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f17632b = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_prev$volatile");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f17633c = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_removedRef$volatile");
    private volatile /* synthetic */ Object _next$volatile = this;
    private volatile /* synthetic */ Object _prev$volatile = this;
    private volatile /* synthetic */ Object _removedRef$volatile;

    public final boolean c(j jVar, int i2) {
        while (true) {
            j jVarD = d();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17632b;
            if (jVarD == null) {
                Object obj = atomicReferenceFieldUpdater.get(this);
                while (true) {
                    jVarD = (j) obj;
                    if (!jVarD.g()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(jVarD);
                }
            }
            if (jVarD instanceof h) {
                return (((h) jVarD).f17630d & i2) == 0 && jVarD.c(jVar, i2);
            }
            atomicReferenceFieldUpdater.set(jVar, jVarD);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f17631a;
            atomicReferenceFieldUpdater2.set(jVar, this);
            while (!atomicReferenceFieldUpdater2.compareAndSet(jVarD, this, jVar)) {
                if (atomicReferenceFieldUpdater2.get(jVarD) != this) {
                    break;
                }
            }
            jVar.e(this);
            return true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0031, code lost:
    
        r6 = ((v6.p) r6).f17645a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
    
        if (r5.compareAndSet(r4, r3, r6) == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0041, code lost:
    
        if (r5.get(r4) == r3) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final v6.j d() {
        /*
            r9 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = v6.j.f17632b
            java.lang.Object r1 = r0.get(r9)
            v6.j r1 = (v6.j) r1
            r2 = 0
            r3 = r1
        La:
            r4 = r2
        Lb:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = v6.j.f17631a
            java.lang.Object r6 = r5.get(r3)
            if (r6 != r9) goto L24
            if (r1 != r3) goto L16
            return r3
        L16:
            boolean r2 = r0.compareAndSet(r9, r1, r3)
            if (r2 == 0) goto L1d
            return r3
        L1d:
            java.lang.Object r2 = r0.get(r9)
            if (r2 == r1) goto L16
            goto L0
        L24:
            boolean r7 = r9.g()
            if (r7 == 0) goto L2b
            return r2
        L2b:
            boolean r7 = r6 instanceof v6.p
            if (r7 == 0) goto L4b
            if (r4 == 0) goto L44
            v6.p r6 = (v6.p) r6
            v6.j r6 = r6.f17645a
        L35:
            boolean r7 = r5.compareAndSet(r4, r3, r6)
            if (r7 == 0) goto L3d
            r3 = r4
            goto La
        L3d:
            java.lang.Object r7 = r5.get(r4)
            if (r7 == r3) goto L35
            goto L0
        L44:
            java.lang.Object r3 = r0.get(r3)
            v6.j r3 = (v6.j) r3
            goto Lb
        L4b:
            java.lang.String r4 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode"
            kotlin.jvm.internal.k.c(r6, r4)
            r4 = r6
            v6.j r4 = (v6.j) r4
            r8 = r4
            r4 = r3
            r3 = r8
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: v6.j.d():v6.j");
    }

    public final void e(j jVar) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17632b;
            j jVar2 = (j) atomicReferenceFieldUpdater.get(jVar);
            if (f17631a.get(this) != jVar) {
                return;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(jVar, jVar2, this)) {
                if (atomicReferenceFieldUpdater.get(jVar) != jVar2) {
                    break;
                }
            }
            if (g()) {
                jVar.d();
                return;
            }
            return;
        }
    }

    public final j f() {
        j jVar;
        Object obj = f17631a.get(this);
        p pVar = obj instanceof p ? (p) obj : null;
        if (pVar != null && (jVar = pVar.f17645a) != null) {
            return jVar;
        }
        kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        return (j) obj;
    }

    public boolean g() {
        return f17631a.get(this) instanceof p;
    }

    public String toString() {
        return new i(this, c0.class, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;", 1) + '@' + c0.p(this);
    }
}
