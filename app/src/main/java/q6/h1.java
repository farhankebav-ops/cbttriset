package q6;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class h1 extends n1 implements s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f13554c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h1(f1 f1Var) {
        super(true);
        boolean z2 = true;
        I(f1Var);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = n1.f13575b;
        o oVar = (o) atomicReferenceFieldUpdater.get(this);
        p pVar = oVar instanceof p ? (p) oVar : null;
        if (pVar == null) {
            z2 = false;
            break;
        }
        n1 n1VarH = pVar.h();
        while (!n1VarH.D()) {
            o oVar2 = (o) atomicReferenceFieldUpdater.get(n1VarH);
            p pVar2 = oVar2 instanceof p ? (p) oVar2 : null;
            if (pVar2 == null) {
                z2 = false;
                break;
            }
            n1VarH = pVar2.h();
        }
        this.f13554c = z2;
    }

    @Override // q6.n1
    public final boolean D() {
        return this.f13554c;
    }

    @Override // q6.n1
    public final boolean E() {
        return true;
    }
}
