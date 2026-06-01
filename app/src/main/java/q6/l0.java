package q6;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class l0 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f13563a;

    public l0(w wVar) {
        this.f13563a = wVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        w wVar = this.f13563a;
        v5.i iVar = v5.i.f17610a;
        if (wVar.isDispatchNeeded(iVar)) {
            wVar.dispatch(iVar, runnable);
        } else {
            runnable.run();
        }
    }

    public final String toString() {
        return this.f13563a.toString();
    }
}
