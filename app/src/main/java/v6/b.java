package v6;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f17618a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_next$volatile");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f17619b = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_prev$volatile");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;

    public b(s sVar) {
        this._prev$volatile = sVar;
    }

    public final void b() {
        f17619b.set(this, null);
    }

    public final b c() {
        Object obj = f17618a.get(this);
        if (obj == a.f17613a) {
            return null;
        }
        return (b) obj;
    }

    public abstract boolean d();

    public final void e() {
        b bVarC;
        if (c() == null) {
            return;
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17619b;
            b bVar = (b) atomicReferenceFieldUpdater.get(this);
            while (bVar != null && bVar.d()) {
                bVar = (b) atomicReferenceFieldUpdater.get(bVar);
            }
            b bVarC2 = c();
            kotlin.jvm.internal.k.b(bVarC2);
            while (bVarC2.d() && (bVarC = bVarC2.c()) != null) {
                bVarC2 = bVarC;
            }
            while (true) {
                Object obj = atomicReferenceFieldUpdater.get(bVarC2);
                b bVar2 = ((b) obj) == null ? null : bVar;
                while (!atomicReferenceFieldUpdater.compareAndSet(bVarC2, obj, bVar2)) {
                    if (atomicReferenceFieldUpdater.get(bVarC2) != obj) {
                        break;
                    }
                }
            }
            if (bVar != null) {
                f17618a.set(bVar, bVarC2);
            }
            if (!bVarC2.d() || bVarC2.c() == null) {
                if (bVar == null || !bVar.d()) {
                    return;
                }
            }
        }
    }
}
