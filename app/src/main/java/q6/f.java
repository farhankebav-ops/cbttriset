package q6;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class f extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Thread f13548d;
    public final w0 e;

    public f(v5.h hVar, Thread thread, w0 w0Var) {
        super(hVar, true);
        this.f13548d = thread;
        this.e = w0Var;
    }

    @Override // q6.n1
    public final void r(Object obj) {
        Thread threadCurrentThread = Thread.currentThread();
        Thread thread = this.f13548d;
        if (kotlin.jvm.internal.k.a(threadCurrentThread, thread)) {
            return;
        }
        LockSupport.unpark(thread);
    }
}
