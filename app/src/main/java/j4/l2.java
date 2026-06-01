package j4;

import java.util.concurrent.Executor;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class l2 extends i4.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n2 f12301a;

    public l2(n2 n2Var) {
        this.f12301a = n2Var;
    }

    @Override // i4.e
    public final String e() {
        return this.f12301a.f12332b;
    }

    @Override // i4.e
    public final i4.f f(i4.c1 c1Var, i4.d dVar) {
        q2 q2Var = this.f12301a.f12334d;
        Logger logger = q2.f12378c0;
        Executor executor = dVar.f11842b;
        if (executor == null) {
            executor = q2Var.h;
        }
        v vVar = new v(c1Var, executor, dVar, q2Var.Z, q2Var.I ? null : this.f12301a.f12334d.f12386f.f12326a.f12636d, this.f12301a.f12334d.L);
        vVar.f12501r = this.f12301a.f12334d.f12388n;
        return vVar;
    }
}
