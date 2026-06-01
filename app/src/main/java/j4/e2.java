package j4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class e2 extends i4.m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12174a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i4.k0 f12175b;

    public e2(i4.k0 k0Var) {
        r2.q.D(k0Var, "result");
        this.f12175b = k0Var;
    }

    @Override // i4.m0
    public final i4.k0 a(q3 q3Var) {
        switch (this.f12174a) {
        }
        return this.f12175b;
    }

    public final String toString() {
        switch (this.f12174a) {
            case 0:
                e2.i iVar = new e2.i(e2.class.getSimpleName());
                iVar.c(this.f12175b, "panicPickResult");
                return iVar.toString();
            default:
                return "FixedResultPicker(" + this.f12175b + ")";
        }
    }

    public e2(Throwable th) {
        i4.n1 n1VarG = i4.n1.l.h("Panic! This is a bug!").g(th);
        i4.k0 k0Var = i4.k0.e;
        r2.q.y(!n1VarG.f(), "drop status shouldn't be OK");
        this.f12175b = new i4.k0(null, null, n1VarG, true);
    }
}
