package s6;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import q6.c0;
import q6.f2;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class c implements f2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f13723a = j.p;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q6.l f13724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h f13725c;

    public c(h hVar) {
        this.f13725c = hVar;
    }

    public final Object a(t6.g gVar) throws Throwable {
        p pVar;
        p pVar2;
        Object obj = this.f13723a;
        boolean z2 = true;
        if (obj == j.p || obj == j.l) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = h.g;
            h hVar = this.f13725c;
            p pVar3 = (p) atomicReferenceFieldUpdater.get(hVar);
            while (!hVar.x()) {
                long andIncrement = h.f13731c.getAndIncrement(hVar);
                long j = j.f13738b;
                long j3 = andIncrement / j;
                int i2 = (int) (andIncrement % j);
                if (pVar3.f17648c != j3) {
                    p pVarQ = hVar.q(j3, pVar3);
                    if (pVarQ == null) {
                        continue;
                    } else {
                        pVar = pVarQ;
                    }
                } else {
                    pVar = pVar3;
                }
                Object objI = hVar.I(pVar, i2, andIncrement, null);
                e2.f fVar = j.m;
                if (objI == fVar) {
                    throw new IllegalStateException("unreachable");
                }
                e2.f fVar2 = j.f13744o;
                if (objI == fVar2) {
                    if (andIncrement < hVar.u()) {
                        pVar.b();
                    }
                    pVar3 = pVar;
                } else if (objI == j.f13743n) {
                    q6.l lVarQ = c0.q(a.a.I(gVar));
                    try {
                        this.f13724b = lVarQ;
                        try {
                            Object objI2 = hVar.I(pVar, i2, andIncrement, this);
                            if (objI2 == fVar) {
                                b(pVar, i2);
                            } else {
                                if (objI2 == fVar2) {
                                    if (andIncrement < hVar.u()) {
                                        pVar.b();
                                    }
                                    p pVar4 = (p) h.g.get(hVar);
                                    while (true) {
                                        if (hVar.x()) {
                                            q6.l lVar = this.f13724b;
                                            kotlin.jvm.internal.k.b(lVar);
                                            this.f13724b = null;
                                            this.f13723a = j.l;
                                            Throwable thR = hVar.r();
                                            if (thR == null) {
                                                lVar.resumeWith(Boolean.FALSE);
                                            } else {
                                                lVar.resumeWith(r2.q.M(thR));
                                            }
                                        } else {
                                            long andIncrement2 = h.f13731c.getAndIncrement(hVar);
                                            long j8 = j.f13738b;
                                            long j9 = andIncrement2 / j8;
                                            int i8 = (int) (andIncrement2 % j8);
                                            if (pVar4.f17648c != j9) {
                                                p pVarQ2 = hVar.q(j9, pVar4);
                                                if (pVarQ2 != null) {
                                                    pVar2 = pVarQ2;
                                                }
                                            } else {
                                                pVar2 = pVar4;
                                            }
                                            Object objI3 = hVar.I(pVar2, i8, andIncrement2, this);
                                            p pVar5 = pVar2;
                                            if (objI3 == j.m) {
                                                b(pVar5, i8);
                                                break;
                                            }
                                            if (objI3 == j.f13744o) {
                                                if (andIncrement2 < hVar.u()) {
                                                    pVar5.b();
                                                }
                                                pVar4 = pVar5;
                                            } else {
                                                if (objI3 == j.f13743n) {
                                                    throw new IllegalStateException("unexpected");
                                                }
                                                pVar5.b();
                                                this.f13723a = objI3;
                                                this.f13724b = null;
                                            }
                                        }
                                    }
                                } else {
                                    pVar.b();
                                    this.f13723a = objI2;
                                    this.f13724b = null;
                                }
                                lVarQ.z(Boolean.TRUE, null);
                            }
                            Object objP = lVarQ.p();
                            w5.a aVar = w5.a.f17774a;
                            return objP;
                        } catch (Throwable th) {
                            th = th;
                            lVarQ.y();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } else {
                    pVar.b();
                    this.f13723a = objI;
                }
            }
            this.f13723a = j.l;
            Throwable thR2 = hVar.r();
            if (thR2 != null) {
                int i9 = v6.t.f17649a;
                throw thR2;
            }
            z2 = false;
        }
        return Boolean.valueOf(z2);
    }

    @Override // q6.f2
    public final void b(v6.s sVar, int i2) {
        q6.l lVar = this.f13724b;
        if (lVar != null) {
            lVar.b(sVar, i2);
        }
    }
}
