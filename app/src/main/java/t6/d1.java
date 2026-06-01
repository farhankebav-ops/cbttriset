package t6;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class d1 extends u6.b implements q0, e, u6.l {
    public static final /* synthetic */ AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(d1.class, Object.class, "_state$volatile");
    private volatile /* synthetic */ Object _state$volatile;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f17431d;

    public d1(Object obj) {
        this._state$volatile = obj;
    }

    @Override // u6.b
    public final u6.d b() {
        return new e1();
    }

    @Override // u6.b
    public final u6.d[] c() {
        return new e1[2];
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x007e, code lost:
    
        if (((t6.g1) r0).a(r3) == r4) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0096, code lost:
    
        if (r2 != r4) goto L36;
     */
    /* JADX WARN: Path cross not found for [B:44:0x00ac, B:46:0x00b2], limit reached: 74 */
    /* JADX WARN: Path cross not found for [B:46:0x00b2, B:44:0x00ac], limit reached: 74 */
    /* JADX WARN: Path cross not found for [B:46:0x00b2, B:54:0x00cd], limit reached: 74 */
    /* JADX WARN: Path cross not found for [B:66:0x0111, B:67:0x0112], limit reached: 74 */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009e A[Catch: all -> 0x003d, TryCatch #1 {all -> 0x003d, blocks: (B:14:0x0039, B:36:0x0096, B:38:0x009e, B:41:0x00a5, B:42:0x00a9, B:44:0x00ac, B:54:0x00cd, B:57:0x00dd, B:58:0x00f9, B:64:0x0109, B:61:0x0100, B:63:0x0106, B:46:0x00b2, B:50:0x00b9, B:21:0x0052, B:24:0x005d, B:35:0x0087), top: B:73:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ac A[Catch: all -> 0x003d, TryCatch #1 {all -> 0x003d, blocks: (B:14:0x0039, B:36:0x0096, B:38:0x009e, B:41:0x00a5, B:42:0x00a9, B:44:0x00ac, B:54:0x00cd, B:57:0x00dd, B:58:0x00f9, B:64:0x0109, B:61:0x0100, B:63:0x0106, B:46:0x00b2, B:50:0x00b9, B:21:0x0052, B:24:0x005d, B:35:0x0087), top: B:73:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00dd A[Catch: all -> 0x003d, TryCatch #1 {all -> 0x003d, blocks: (B:14:0x0039, B:36:0x0096, B:38:0x009e, B:41:0x00a5, B:42:0x00a9, B:44:0x00ac, B:54:0x00cd, B:57:0x00dd, B:58:0x00f9, B:64:0x0109, B:61:0x0100, B:63:0x0106, B:46:0x00b2, B:50:0x00b9, B:21:0x0052, B:24:0x005d, B:35:0x0087), top: B:73:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x00dc -> B:36:0x0096). Please report as a decompilation issue!!! */
    @Override // t6.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object collect(t6.f r18, v5.c r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 281
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.d1.collect(t6.f, v5.c):java.lang.Object");
    }

    @Override // t6.p0
    public final boolean d(Object obj) {
        h(obj);
        return true;
    }

    @Override // u6.l
    public final e e(v5.h hVar, int i2, s6.a aVar) {
        return (((i2 < 0 || i2 >= 2) && i2 != -2) || aVar != s6.a.f13719b) ? x0.n(this, hVar, i2, aVar) : this;
    }

    @Override // t6.p0, t6.f
    public final Object emit(Object obj, v5.c cVar) {
        h(obj);
        return q5.x.f13520a;
    }

    public final boolean g(Object obj, Object obj2) {
        e2.f fVar = u6.c.f17544b;
        if (obj == null) {
            obj = fVar;
        }
        if (obj2 == null) {
            obj2 = fVar;
        }
        return i(obj, obj2);
    }

    @Override // t6.b1
    public final Object getValue() {
        e2.f fVar = u6.c.f17544b;
        Object obj = e.get(this);
        if (obj == fVar) {
            return null;
        }
        return obj;
    }

    public final void h(Object obj) {
        if (obj == null) {
            obj = u6.c.f17544b;
        }
        i(null, obj);
    }

    public final boolean i(Object obj, Object obj2) {
        int i2;
        u6.d[] dVarArr;
        e2.f fVar;
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj != null && !kotlin.jvm.internal.k.a(obj3, obj)) {
                return false;
            }
            if (kotlin.jvm.internal.k.a(obj3, obj2)) {
                return true;
            }
            atomicReferenceFieldUpdater.set(this, obj2);
            int i8 = this.f17431d;
            if ((i8 & 1) != 0) {
                this.f17431d = i8 + 2;
                return true;
            }
            int i9 = i8 + 1;
            this.f17431d = i9;
            u6.d[] dVarArr2 = this.f17540a;
            while (true) {
                e1[] e1VarArr = (e1[]) dVarArr2;
                if (e1VarArr != null) {
                    for (e1 e1Var : e1VarArr) {
                        if (e1Var != null) {
                            AtomicReference atomicReference = e1Var.f17434a;
                            while (true) {
                                Object obj4 = atomicReference.get();
                                if (obj4 != null && obj4 != (fVar = x0.f17505c)) {
                                    e2.f fVar2 = x0.f17504b;
                                    if (obj4 != fVar2) {
                                        while (!atomicReference.compareAndSet(obj4, fVar2)) {
                                            if (atomicReference.get() != obj4) {
                                                break;
                                            }
                                        }
                                        ((q6.l) obj4).resumeWith(q5.x.f13520a);
                                        break;
                                    }
                                    while (!atomicReference.compareAndSet(obj4, fVar)) {
                                        if (atomicReference.get() != obj4) {
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                synchronized (this) {
                    i2 = this.f17431d;
                    if (i2 == i9) {
                        this.f17431d = i9 + 1;
                        return true;
                    }
                    dVarArr = this.f17540a;
                }
                dVarArr2 = dVarArr;
                i9 = i2;
            }
        }
    }
}
