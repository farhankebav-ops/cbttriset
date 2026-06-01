package j4;

import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class z3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Collection f12568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m4 f12569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Future f12570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Future f12571d;
    public final /* synthetic */ g2 e;

    public z3(g2 g2Var, Collection collection, m4 m4Var, Future future, Future future2) {
        this.e = g2Var;
        this.f12568a = collection;
        this.f12569b = m4Var;
        this.f12570c = future;
        this.f12571d = future2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i4.n1 n1Var;
        for (m4 m4Var : this.f12568a) {
            if (m4Var != this.f12569b) {
                m4Var.f12322a.d(g2.G);
            }
        }
        Future future = this.f12570c;
        if (future != null) {
            future.cancel(false);
        }
        Future future2 = this.f12571d;
        if (future2 != null) {
            future2.cancel(false);
        }
        g2 g2Var = this.e;
        h hVar = ((q2) g2Var.D.f12200b).F;
        synchronized (hVar.f12231a) {
            try {
                ((HashSet) hVar.f12232b).remove(g2Var);
                if (((HashSet) hVar.f12232b).isEmpty()) {
                    n1Var = (i4.n1) hVar.f12233c;
                    hVar.f12232b = new HashSet();
                } else {
                    n1Var = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (n1Var != null) {
            ((q2) hVar.f12234d).E.d(n1Var);
        }
    }
}
