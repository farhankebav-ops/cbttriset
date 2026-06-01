package q6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class d2 extends v6.r {
    public final ThreadLocal e;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    public d2(v5.c cVar, v5.h hVar) {
        e2 e2Var = e2.f13547a;
        super(cVar, hVar.get(e2Var) == null ? hVar.plus(e2Var) : hVar);
        this.e = new ThreadLocal();
        if (cVar.getContext().get(v5.d.f17609a) instanceof w) {
            return;
        }
        Object objL = v6.a.l(hVar, null);
        v6.a.g(hVar, objL);
        e0(hVar, objL);
    }

    public final boolean d0() {
        boolean z2 = this.threadLocalIsSet && this.e.get() == null;
        this.e.remove();
        return !z2;
    }

    public final void e0(v5.h hVar, Object obj) {
        this.threadLocalIsSet = true;
        this.e.set(new q5.i(hVar, obj));
    }

    @Override // v6.r, q6.n1
    public final void s(Object obj) {
        if (this.threadLocalIsSet) {
            q5.i iVar = (q5.i) this.e.get();
            if (iVar != null) {
                v6.a.g((v5.h) iVar.f13498a, iVar.f13499b);
            }
            this.e.remove();
        }
        Object objY = c0.y(obj);
        v5.c cVar = this.f17646d;
        v5.h context = cVar.getContext();
        Object objL = v6.a.l(context, null);
        d2 d2VarG = objL != v6.a.f17616d ? c0.G(cVar, context, objL) : null;
        try {
            this.f17646d.resumeWith(objY);
            if (d2VarG == null || d2VarG.d0()) {
                v6.a.g(context, objL);
            }
        } catch (Throwable th) {
            if (d2VarG == null || d2VarG.d0()) {
                v6.a.g(context, objL);
            }
            throw th;
        }
    }
}
