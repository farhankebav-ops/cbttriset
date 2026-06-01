package j4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class t extends h0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f12453c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f12454d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(m2 m2Var, i4.q qVar) {
        super(qVar, 0);
        this.f12454d = m2Var;
    }

    @Override // j4.h0
    public final void b() {
        List list;
        switch (this.f12453c) {
            case 0:
                e2.h hVar = (e2.h) this.f12454d;
                r4.b.c();
                try {
                    r4.b.a();
                    r4.b.f13625a.getClass();
                    if (((i4.n1) hVar.f11232b) == null) {
                        try {
                            ((i4.x) hVar.f11231a).i();
                        } catch (Throwable th) {
                            i4.n1 n1VarH = i4.n1.f11914f.g(th).h("Failed to call onReady.");
                            hVar.f11232b = n1VarH;
                            ((v) hVar.f11233c).l.d(n1VarH);
                        }
                        break;
                    }
                    r4.b.f13625a.getClass();
                    return;
                } catch (Throwable th2) {
                    try {
                        r4.b.f13625a.getClass();
                        break;
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            case 1:
                ((m2) this.f12454d).v();
                return;
            default:
                m0 m0Var = (m0) this.f12454d;
                m0Var.getClass();
                List arrayList = new ArrayList();
                while (true) {
                    synchronized (m0Var) {
                        try {
                            if (m0Var.f12311c.isEmpty()) {
                                m0Var.f12311c = null;
                                m0Var.f12310b = true;
                                return;
                            } else {
                                list = m0Var.f12311c;
                                m0Var.f12311c = arrayList;
                            }
                        } catch (Throwable th4) {
                            throw th4;
                        }
                    }
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((Runnable) it.next()).run();
                    }
                    list.clear();
                    arrayList = list;
                }
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(m2 m2Var, m0 m0Var) {
        super(m2Var.f12316f, 0);
        this.f12454d = m0Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(e2.h hVar) {
        super(((v) hVar.f11233c).h, 0);
        this.f12454d = hVar;
    }
}
