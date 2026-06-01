package j4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class n1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t1 f12330b;

    public /* synthetic */ n1(t1 t1Var, int i2) {
        this.f12329a = i2;
        this.f12330b = t1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f12329a) {
            case 0:
                t1 t1Var = this.f12330b;
                t1Var.p = null;
                t1Var.f12462i.i(2, "CONNECTING after backoff");
                t1.e(t1Var, i4.m.f11894a);
                t1.f(t1Var);
                break;
            case 1:
                if (this.f12330b.f12471w.f11911a == i4.m.f11897d) {
                    this.f12330b.f12462i.i(2, "CONNECTING as requested");
                    t1.e(this.f12330b, i4.m.f11894a);
                    t1.f(this.f12330b);
                }
                break;
            default:
                t1 t1Var2 = this.f12330b;
                t1Var2.f12462i.i(2, "Terminated");
                q2 q2Var = ((p2) t1Var2.f12460d.f12230c).m;
                q2Var.A.remove(t1Var2);
                q2.g(q2Var);
                break;
        }
    }
}
