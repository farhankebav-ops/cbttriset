package p4;

import i4.a1;
import i4.n1;
import i4.p1;
import i4.x;
import j2.m;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class d extends x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f13330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f13331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13332c = false;

    public d(a aVar) {
        this.f13330a = aVar;
    }

    @Override // i4.x
    public final void f(n1 n1Var, a1 a1Var) {
        boolean zF = n1Var.f();
        a aVar = this.f13330a;
        if (!zF) {
            if (m.g.l(aVar, null, new j2.c(new p1(n1Var, a1Var)))) {
                a.d(aVar, false);
                return;
            }
            return;
        }
        if (!this.f13332c) {
            if (m.g.l(aVar, null, new j2.c(new p1(n1.l.h("No value received for unary call"), a1Var)))) {
                a.d(aVar, false);
            }
        }
        Object obj = this.f13331b;
        if (obj == null) {
            obj = m.f12081d;
        }
        if (m.g.l(aVar, null, obj)) {
            a.d(aVar, false);
        }
    }

    @Override // i4.x
    public final void h(Object obj) {
        if (this.f13332c) {
            throw n1.l.h("More than one value received for unary call").a();
        }
        this.f13331b = obj;
        this.f13332c = true;
    }

    @Override // i4.x
    public final void g(a1 a1Var) {
    }
}
