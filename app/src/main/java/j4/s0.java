package j4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class s0 implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f12439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f12440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f12441c = new ArrayList();

    public s0(y yVar) {
        this.f12439a = yVar;
    }

    public final void a(Runnable runnable) {
        synchronized (this) {
            try {
                if (this.f12440b) {
                    runnable.run();
                } else {
                    this.f12441c.add(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        List list;
        List arrayList = new ArrayList();
        while (true) {
            synchronized (this) {
                try {
                    if (this.f12441c.isEmpty()) {
                        this.f12441c = null;
                        this.f12440b = true;
                        return;
                    } else {
                        list = this.f12441c;
                        this.f12441c = arrayList;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
            list.clear();
            arrayList = list;
        }
    }

    @Override // j4.y
    public final void c(i4.n1 n1Var, x xVar, i4.a1 a1Var) {
        a(new b(this, n1Var, xVar, a1Var, 1));
    }

    @Override // j4.y
    public final void f(i4.a1 a1Var) {
        a(new i0(12, this, a1Var));
    }

    @Override // j4.y
    public final void g(a4.a aVar) {
        if (this.f12440b) {
            this.f12439a.g(aVar);
        } else {
            a(new i0(11, this, aVar));
        }
    }

    @Override // j4.y
    public final void o() {
        if (this.f12440b) {
            this.f12439a.o();
        } else {
            a(new a4.c(this, 4));
        }
    }
}
