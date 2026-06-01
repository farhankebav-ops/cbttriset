package q6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a extends n1 implements v5.c, a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v5.h f13523c;

    public a(v5.h hVar, boolean z2) {
        super(z2);
        I((f1) hVar.get(e1.f13546a));
        this.f13523c = hVar.plus(this);
    }

    @Override // q6.n1
    public final void H(e2.s sVar) {
        c0.r(this.f13523c, sVar);
    }

    @Override // q6.n1
    public final void S(Object obj) {
        if (!(obj instanceof u)) {
            b0(obj);
            return;
        }
        u uVar = (u) obj;
        a0(u.f13590b.get(uVar) != 0, uVar.f13591a);
    }

    public final void c0(b0 b0Var, a aVar, e6.p pVar) {
        int iOrdinal = b0Var.ordinal();
        q5.x xVar = q5.x.f13520a;
        if (iOrdinal == 0) {
            try {
                v6.a.h(xVar, a.a.I(a.a.s(pVar, aVar, this)));
                return;
            } finally {
                resumeWith(r2.q.M(th));
            }
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                a.a.I(a.a.s(pVar, aVar, this)).resumeWith(xVar);
                return;
            }
            if (iOrdinal != 3) {
                throw new e2.s(3);
            }
            try {
                v5.h hVar = this.f13523c;
                Object objL = v6.a.l(hVar, null);
                try {
                    kotlin.jvm.internal.d0.d(2, pVar);
                    Object objInvoke = pVar.invoke(aVar, this);
                    if (objInvoke != w5.a.f17774a) {
                        resumeWith(objInvoke);
                    }
                } finally {
                    v6.a.g(hVar, objL);
                }
            } catch (Throwable th) {
            }
        }
    }

    @Override // v5.c
    public final v5.h getContext() {
        return this.f13523c;
    }

    @Override // q6.a0
    public final v5.h getCoroutineContext() {
        return this.f13523c;
    }

    @Override // v5.c
    public final void resumeWith(Object obj) {
        Throwable thA = q5.k.a(obj);
        if (thA != null) {
            obj = new u(false, thA);
        }
        Object objO = O(obj);
        if (objO == c0.e) {
            return;
        }
        s(objO);
    }

    @Override // q6.n1
    public final String x() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    public void b0(Object obj) {
    }

    public void a0(boolean z2, Throwable th) {
    }
}
