package j2;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class f extends a.a {
    @Override // a.a
    public final void Q(l lVar, l lVar2) {
        lVar.f12080b = lVar2;
    }

    @Override // a.a
    public final void R(l lVar, Thread thread) {
        lVar.f12079a = thread;
    }

    @Override // a.a
    public final boolean k(p4.a aVar, d dVar, d dVar2) {
        synchronized (aVar) {
            try {
                if (aVar.f12084b != dVar) {
                    return false;
                }
                aVar.f12084b = dVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // a.a
    public final boolean l(m mVar, Object obj, Object obj2) {
        synchronized (mVar) {
            try {
                if (mVar.f12083a != obj) {
                    return false;
                }
                mVar.f12083a = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // a.a
    public final boolean m(m mVar, l lVar, l lVar2) {
        synchronized (mVar) {
            try {
                if (mVar.f12085c != lVar) {
                    return false;
                }
                mVar.f12085c = lVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // a.a
    public final d y(p4.a aVar) {
        d dVar;
        d dVar2 = d.f12066d;
        synchronized (aVar) {
            try {
                dVar = aVar.f12084b;
                if (dVar != dVar2) {
                    aVar.f12084b = dVar2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    @Override // a.a
    public final l z(p4.a aVar) {
        l lVar;
        l lVar2 = l.f12078c;
        synchronized (aVar) {
            try {
                lVar = aVar.f12085c;
                if (lVar != lVar2) {
                    aVar.f12085c = lVar2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return lVar;
    }
}
