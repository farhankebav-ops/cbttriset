package z6;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import q5.x;
import q6.k;
import q6.l;
import v6.s;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f17995b = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "head$volatile");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f17996c = AtomicLongFieldUpdater.newUpdater(g.class, "deqIdx$volatile");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f17997d = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "tail$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater e = AtomicLongFieldUpdater.newUpdater(g.class, "enqIdx$volatile");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f17998f = AtomicIntegerFieldUpdater.newUpdater(g.class, "_availablePermits$volatile");
    private volatile /* synthetic */ int _availablePermits$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f17999a;
    private volatile /* synthetic */ long deqIdx$volatile;
    private volatile /* synthetic */ long enqIdx$volatile;
    private volatile /* synthetic */ Object head$volatile;
    private volatile /* synthetic */ Object tail$volatile;

    public g(int i2) {
        if (i2 < 0 || i2 > 1) {
            throw new IllegalArgumentException("The number of acquired permits should be in 0..1".toString());
        }
        i iVar = new i(0L, null, 2);
        this.head$volatile = iVar;
        this.tail$volatile = iVar;
        this._availablePermits$volatile = 1 - i2;
        this.f17999a = new k(this, 2);
    }

    public final void a(b bVar) {
        Object objB;
        i iVar;
        l lVar = bVar.f17990a;
        c cVar = bVar.f17991b;
        while (true) {
            int andDecrement = f17998f.getAndDecrement(this);
            if (andDecrement <= 1) {
                x xVar = x.f13520a;
                if (andDecrement > 0) {
                    c.g.set(cVar, null);
                    lVar.A(xVar, lVar.f13559c, new k(new androidx.camera.core.impl.utils.a(cVar, bVar), 0));
                    return;
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17997d;
                i iVar2 = (i) atomicReferenceFieldUpdater.get(this);
                long andIncrement = e.getAndIncrement(this);
                e eVar = e.f17993b;
                long j = andIncrement / ((long) h.f18004f);
                while (true) {
                    objB = v6.a.b(iVar2, j, eVar);
                    if (!v6.a.e(objB)) {
                        s sVarC = v6.a.c(objB);
                        while (true) {
                            s sVar = (s) atomicReferenceFieldUpdater.get(this);
                            iVar = iVar2;
                            if (sVar.f17648c >= sVarC.f17648c) {
                                break;
                            }
                            if (!sVarC.j()) {
                                break;
                            }
                            while (!atomicReferenceFieldUpdater.compareAndSet(this, sVar, sVarC)) {
                                if (atomicReferenceFieldUpdater.get(this) != sVar) {
                                    if (sVarC.f()) {
                                        sVarC.e();
                                    }
                                    iVar2 = iVar;
                                }
                            }
                            if (sVar.f()) {
                                sVar.e();
                            }
                        }
                    } else {
                        break;
                    }
                    iVar2 = iVar;
                }
                i iVar3 = (i) v6.a.c(objB);
                AtomicReferenceArray atomicReferenceArray = iVar3.e;
                int i2 = (int) (andIncrement % ((long) h.f18004f));
                while (!atomicReferenceArray.compareAndSet(i2, null, bVar)) {
                    if (atomicReferenceArray.get(i2) != null) {
                        e2.f fVar = h.f18001b;
                        e2.f fVar2 = h.f18002c;
                        while (!atomicReferenceArray.compareAndSet(i2, fVar, fVar2)) {
                            if (atomicReferenceArray.get(i2) != fVar) {
                                break;
                            }
                        }
                        c.g.set(cVar, null);
                        lVar.A(xVar, lVar.f13559c, new k(new androidx.camera.core.impl.utils.a(cVar, bVar), 0));
                        return;
                    }
                }
                bVar.b(iVar3, i2);
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b() {
        /*
            Method dump skipped, instruction units count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: z6.g.b():void");
    }
}
