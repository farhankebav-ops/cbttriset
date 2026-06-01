package j4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class o3 extends i4.o0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i4.x f12351f;
    public i4.f g;
    public i4.m h = i4.m.f11897d;

    public o3(i4.x xVar) {
        this.f12351f = xVar;
    }

    @Override // i4.o0
    public final i4.n1 a(i4.l0 l0Var) {
        Boolean bool;
        List list = l0Var.f11891a;
        if (list.isEmpty()) {
            i4.n1 n1VarH = i4.n1.m.h("NameResolver returned no usable address. addrs=" + list + ", attrs=" + l0Var.f11892b);
            c(n1VarH);
            return n1VarH;
        }
        Object obj = l0Var.f11893c;
        if ((obj instanceof m3) && (bool = ((m3) obj).f12321a) != null && bool.booleanValue()) {
            ArrayList arrayList = new ArrayList(list);
            Collections.shuffle(arrayList, new Random());
            list = arrayList;
        }
        i4.f fVar = this.g;
        if (fVar == null) {
            i4.j0 j0VarC = i4.j0.c();
            j0VarC.d(list);
            i4.j0 j0Var = new i4.j0(j0VarC.f11878b, j0VarC.f11879c, j0VarC.f11880d);
            i4.x xVar = this.f12351f;
            i4.f fVarA = xVar.a(j0Var);
            fVarA.r(new l3(this, fVarA));
            this.g = fVarA;
            n3 n3Var = new n3(i4.k0.b(fVarA, null));
            i4.m mVar = i4.m.f11894a;
            this.h = mVar;
            xVar.n(mVar, n3Var);
            fVarA.n();
        } else {
            fVar.s(list);
        }
        return i4.n1.e;
    }

    @Override // i4.o0
    public final void c(i4.n1 n1Var) {
        i4.f fVar = this.g;
        if (fVar != null) {
            fVar.p();
            this.g = null;
        }
        n3 n3Var = new n3(i4.k0.a(n1Var));
        i4.m mVar = i4.m.f11896c;
        this.h = mVar;
        this.f12351f.n(mVar, n3Var);
    }

    @Override // i4.o0
    public final void e() {
        i4.f fVar = this.g;
        if (fVar != null) {
            fVar.n();
        }
    }

    @Override // i4.o0
    public final void f() {
        i4.f fVar = this.g;
        if (fVar != null) {
            fVar.p();
        }
    }
}
