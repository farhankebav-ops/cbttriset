package j4;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class i2 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a4.a f12256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Executor f12257b;

    public i2(a4.a aVar) {
        r2.q.D(aVar, "executorPool");
        this.f12256a = aVar;
    }

    public final synchronized void a() {
        Executor executor = this.f12257b;
        if (executor != null) {
            c5.b((b5) this.f12256a.f3216b, executor);
            this.f12257b = null;
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        Executor executor;
        synchronized (this) {
            try {
                if (this.f12257b == null) {
                    Executor executor2 = (Executor) c5.a((b5) this.f12256a.f3216b);
                    Executor executor3 = this.f12257b;
                    if (executor2 == null) {
                        throw new NullPointerException(a.a.K("%s.getObject()", executor3));
                    }
                    this.f12257b = executor2;
                }
                executor = this.f12257b;
            } catch (Throwable th) {
                throw th;
            }
        }
        executor.execute(runnable);
    }
}
