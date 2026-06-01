package j4;

import java.util.HashSet;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class j0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m2 f12264b;

    public /* synthetic */ j0(m2 m2Var, int i2) {
        this.f12263a = i2;
        this.f12264b = m2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f12263a) {
            case 0:
                this.f12264b.f12317i.m();
                return;
            case 1:
                this.f12264b.f12317i.g();
                return;
            default:
                m2 m2Var = this.f12264b;
                LinkedHashSet linkedHashSet = m2Var.f12320q.f12334d.B;
                if (linkedHashSet != null) {
                    linkedHashSet.remove(m2Var);
                    if (this.f12264b.f12320q.f12334d.B.isEmpty()) {
                        q2 q2Var = this.f12264b.f12320q.f12334d;
                        q2Var.Y.c(q2Var.C, false);
                        q2 q2Var2 = this.f12264b.f12320q.f12334d;
                        q2Var2.B = null;
                        if (q2Var2.G.get()) {
                            h hVar = this.f12264b.f12320q.f12334d.F;
                            i4.n1 n1Var = q2.f12379e0;
                            synchronized (hVar.f12231a) {
                                try {
                                    if (((i4.n1) hVar.f12233c) == null) {
                                        hVar.f12233c = n1Var;
                                        boolean zIsEmpty = ((HashSet) hVar.f12232b).isEmpty();
                                        if (zIsEmpty) {
                                            ((q2) hVar.f12234d).E.d(n1Var);
                                        }
                                    }
                                } finally {
                                }
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
        }
    }
}
