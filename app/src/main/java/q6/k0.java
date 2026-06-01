package q6;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class k0 extends x6.i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13559c;

    public k0(int i2) {
        super(0L, false);
        this.f13559c = i2;
    }

    public abstract v5.c c();

    public Throwable d(Object obj) {
        u uVar = obj instanceof u ? (u) obj : null;
        if (uVar != null) {
            return uVar.f13591a;
        }
        return null;
    }

    public final void h(Throwable th) {
        c0.r(c().getContext(), new d6.a("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object i();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            v5.c cVarC = c();
            kotlin.jvm.internal.k.c(cVarC, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            v6.f fVar = (v6.f) cVarC;
            v5.c cVar = fVar.e;
            Object obj = fVar.g;
            v5.h context = cVar.getContext();
            Object objL = v6.a.l(context, obj);
            f1 f1Var = null;
            d2 d2VarG = objL != v6.a.f17616d ? c0.G(cVar, context, objL) : null;
            try {
                v5.h context2 = cVar.getContext();
                Object objI = i();
                Throwable thD = d(objI);
                if (thD == null) {
                    int i2 = this.f13559c;
                    boolean z2 = true;
                    if (i2 != 1 && i2 != 2) {
                        z2 = false;
                    }
                    if (z2) {
                        f1Var = (f1) context2.get(e1.f13546a);
                    }
                }
                if (f1Var != null && !f1Var.isActive()) {
                    CancellationException cancellationExceptionG = f1Var.g();
                    a(cancellationExceptionG);
                    cVar.resumeWith(r2.q.M(cancellationExceptionG));
                } else if (thD != null) {
                    cVar.resumeWith(r2.q.M(thD));
                } else {
                    cVar.resumeWith(g(objI));
                }
                if (d2VarG != null && !d2VarG.d0()) {
                    return;
                }
                v6.a.g(context, objL);
            } catch (Throwable th) {
                if (d2VarG == null || d2VarG.d0()) {
                    v6.a.g(context, objL);
                }
                throw th;
            }
        } catch (Throwable th2) {
            h(th2);
        }
    }

    public void a(CancellationException cancellationException) {
    }

    public Object g(Object obj) {
        return obj;
    }
}
