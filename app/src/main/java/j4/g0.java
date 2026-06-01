package j4;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f12199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f12200b;

    public z a(q3 q3Var) {
        i4.m0 m0Var = ((q2) this.f12200b).y;
        if (((q2) this.f12200b).G.get()) {
            return ((q2) this.f12200b).E;
        }
        if (m0Var == null) {
            ((q2) this.f12200b).m.execute(new a4.c(this, 6));
            return ((q2) this.f12200b).E;
        }
        z zVarF = f1.f(m0Var.a(q3Var), Boolean.TRUE.equals(q3Var.f12399a.e));
        return zVarF != null ? zVarF : ((q2) this.f12200b).E;
    }

    public void b(i4.m mVar) {
        r2.q.D(mVar, "newState");
        if (((i4.m) this.f12199a) == mVar || ((i4.m) this.f12199a) == i4.m.e) {
            return;
        }
        this.f12199a = mVar;
        if (((ArrayList) this.f12200b).isEmpty()) {
            return;
        }
        ArrayList arrayList = (ArrayList) this.f12200b;
        this.f12200b = new ArrayList();
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
    }
}
