package j4;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class m0 extends i4.x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i4.x f12309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f12310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f12311c = new ArrayList();

    public m0(i4.x xVar) {
        this.f12309a = xVar;
    }

    @Override // i4.x
    public final void f(i4.n1 n1Var, i4.a1 a1Var) {
        o(new a4.b(this, n1Var, a1Var, 5));
    }

    @Override // i4.x
    public final void g(i4.a1 a1Var) {
        if (this.f12310b) {
            this.f12309a.g(a1Var);
        } else {
            o(new i0(3, this, a1Var));
        }
    }

    @Override // i4.x
    public final void h(Object obj) {
        if (this.f12310b) {
            this.f12309a.h(obj);
        } else {
            o(new i0(4, this, obj));
        }
    }

    @Override // i4.x
    public final void i() {
        if (this.f12310b) {
            this.f12309a.i();
        } else {
            o(new a4.c(this, 3));
        }
    }

    public final void o(Runnable runnable) {
        synchronized (this) {
            try {
                if (this.f12310b) {
                    runnable.run();
                } else {
                    this.f12311c.add(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
