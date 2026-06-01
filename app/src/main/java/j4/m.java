package j4;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class m extends a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f0 f12306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f12307b = new AtomicInteger(-2147483647);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile i4.n1 f12308c;

    public m(n nVar, f0 f0Var, String str) {
        new e3(this);
        r2.q.D(f0Var, "delegate");
        this.f12306a = f0Var;
    }

    @Override // j4.z
    public final w b(i4.c1 c1Var, i4.a1 a1Var, i4.d dVar, i4.i[] iVarArr) {
        dVar.getClass();
        return this.f12307b.get() >= 0 ? new y0(this.f12308c, x.f12538a, iVarArr) : this.f12306a.b(c1Var, a1Var, dVar, iVarArr);
    }

    @Override // j4.a1, j4.y2
    public final void d(i4.n1 n1Var) {
        r2.q.D(n1Var, "status");
        synchronized (this) {
            try {
                if (this.f12307b.get() < 0) {
                    this.f12308c = n1Var;
                    this.f12307b.addAndGet(Integer.MAX_VALUE);
                    if (this.f12307b.get() != 0) {
                        return;
                    }
                    super.d(n1Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // j4.a1
    public final f0 e() {
        return this.f12306a;
    }
}
