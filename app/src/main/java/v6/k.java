package v6;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f17634a = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_cur$volatile");
    private volatile /* synthetic */ Object _cur$volatile = new m(8, false);

    public final boolean a(Runnable runnable) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17634a;
            m mVar = (m) atomicReferenceFieldUpdater.get(this);
            int iA = mVar.a(runnable);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                m mVarC = mVar.c();
                while (!atomicReferenceFieldUpdater.compareAndSet(this, mVar, mVarC) && atomicReferenceFieldUpdater.get(this) == mVar) {
                }
            } else if (iA == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17634a;
            m mVar = (m) atomicReferenceFieldUpdater.get(this);
            if (mVar.b()) {
                return;
            }
            m mVarC = mVar.c();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, mVar, mVarC) && atomicReferenceFieldUpdater.get(this) == mVar) {
            }
        }
    }

    public final int c() {
        m mVar = (m) f17634a.get(this);
        mVar.getClass();
        long j = m.f17636f.get(mVar);
        return (((int) ((j & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j))) & 1073741823;
    }

    public final Object d() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17634a;
            m mVar = (m) atomicReferenceFieldUpdater.get(this);
            Object objD = mVar.d();
            if (objD != m.g) {
                return objD;
            }
            m mVarC = mVar.c();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, mVar, mVarC) && atomicReferenceFieldUpdater.get(this) == mVar) {
            }
        }
    }
}
