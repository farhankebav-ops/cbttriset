package p0;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class r implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f13304a;

    public r(ExecutorService executorService) {
        this.f13304a = executorService;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f13304a.execute(new a4.c(runnable, 19));
    }
}
