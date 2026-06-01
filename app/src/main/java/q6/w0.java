package q6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class w0 extends w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f13596d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f13597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f13598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r5.i f13599c;

    @Override // q6.w
    public final w limitedParallelism(int i2, String str) {
        v6.a.a(i2);
        return str != null ? new v6.o(this, str) : this;
    }

    public final void o(boolean z2) {
        long j = this.f13597a - (z2 ? 4294967296L : 1L);
        this.f13597a = j;
        if (j <= 0 && this.f13598b) {
            shutdown();
        }
    }

    public final void p(k0 k0Var) {
        r5.i iVar = this.f13599c;
        if (iVar == null) {
            iVar = new r5.i();
            this.f13599c = iVar;
        }
        iVar.addLast(k0Var);
    }

    public abstract Thread q();

    public final void r(boolean z2) {
        this.f13597a = (z2 ? 4294967296L : 1L) + this.f13597a;
        if (z2) {
            return;
        }
        this.f13598b = true;
    }

    public abstract long s();

    public abstract void shutdown();

    public final boolean t() {
        r5.i iVar = this.f13599c;
        if (iVar == null) {
            return false;
        }
        k0 k0Var = (k0) (iVar.isEmpty() ? null : iVar.removeFirst());
        if (k0Var == null) {
            return false;
        }
        k0Var.run();
        return true;
    }

    public void u(long j, t0 t0Var) {
        d0.h.W(j, t0Var);
    }
}
