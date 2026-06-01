package q6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class d implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c[] f13540a;

    public d(c[] cVarArr) {
        this.f13540a = cVarArr;
    }

    @Override // q6.i
    public final void a(Throwable th) {
        b();
    }

    public final void b() {
        for (c cVar : this.f13540a) {
            o0 o0Var = cVar.f13531f;
            if (o0Var == null) {
                kotlin.jvm.internal.k.l("handle");
                throw null;
            }
            o0Var.dispose();
        }
    }

    public final String toString() {
        return "DisposeHandlersOnCancel[" + this.f13540a + ']';
    }
}
