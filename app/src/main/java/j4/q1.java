package j4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class q1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r1 f12377b;

    public /* synthetic */ q1(r1 r1Var, int i2) {
        this.f12376a = i2;
        this.f12377b = r1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f12376a) {
            case 0:
                r1 r1Var = this.f12377b;
                t1 t1Var = (t1) r1Var.f12410c;
                t1Var.f12463n = null;
                if (t1Var.f12472x == null) {
                    o1 o1Var = t1Var.f12469u;
                    o1 o1Var2 = (o1) r1Var.f12409b;
                    if (o1Var == o1Var2) {
                        t1Var.f12470v = o1Var2;
                        t1 t1Var2 = (t1) this.f12377b.f12410c;
                        t1Var2.f12469u = null;
                        t1.e(t1Var2, i4.m.f11895b);
                    }
                } else {
                    r2.q.H(t1Var.f12470v == null, "Unexpected non-null activeTransport");
                    r1 r1Var2 = this.f12377b;
                    ((o1) r1Var2.f12409b).d(((t1) r1Var2.f12410c).f12472x);
                }
                break;
            default:
                r1 r1Var3 = this.f12377b;
                ((t1) r1Var3.f12410c).f12467s.remove((o1) r1Var3.f12409b);
                if (((t1) this.f12377b.f12410c).f12471w.f11911a == i4.m.e && ((t1) this.f12377b.f12410c).f12467s.isEmpty()) {
                    t1 t1Var3 = (t1) this.f12377b.f12410c;
                    t1Var3.k.execute(new n1(t1Var3, 2));
                    break;
                }
                break;
        }
    }
}
