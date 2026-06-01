package j4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f12124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f12125c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f12126d;
    public final /* synthetic */ Object e;

    public /* synthetic */ b(Object obj, Object obj2, Object obj3, Object obj4, int i2) {
        this.f12123a = i2;
        this.e = obj;
        this.f12124b = obj2;
        this.f12125c = obj3;
        this.f12126d = obj4;
    }

    /* JADX WARN: Finally extract failed */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f12123a) {
            case 0:
                ((c) this.e).b((i4.n1) this.f12124b, (x) this.f12125c, (i4.a1) this.f12126d);
                return;
            case 1:
                ((s0) this.e).f12439a.c((i4.n1) this.f12124b, (x) this.f12125c, (i4.a1) this.f12126d);
                return;
            case 2:
                g2 g2Var = (g2) this.e;
                g2Var.f12220z = true;
                g2Var.f12216u.c((i4.n1) this.f12124b, (x) this.f12125c, (i4.a1) this.f12126d);
                return;
            default:
                synchronized (((c5) this.e)) {
                    try {
                        if (((a5) this.f12124b).f12121b == 0) {
                            try {
                                ((b5) this.f12125c).close(this.f12126d);
                                ((c5) this.e).f12147a.remove((b5) this.f12125c);
                                if (((c5) this.e).f12147a.isEmpty()) {
                                    ((c5) this.e).f12149c.shutdown();
                                    ((c5) this.e).f12149c = null;
                                }
                            } catch (Throwable th) {
                                ((c5) this.e).f12147a.remove((b5) this.f12125c);
                                if (((c5) this.e).f12147a.isEmpty()) {
                                    ((c5) this.e).f12149c.shutdown();
                                    ((c5) this.e).f12149c = null;
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                return;
        }
    }
}
