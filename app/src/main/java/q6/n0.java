package q6;

import java.util.concurrent.ScheduledFuture;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class n0 implements o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledFuture f13573a;

    public n0(ScheduledFuture scheduledFuture) {
        this.f13573a = scheduledFuture;
    }

    @Override // q6.o0
    public final void dispose() {
        this.f13573a.cancel(false);
    }

    public final String toString() {
        return "DisposableFutureHandle[" + this.f13573a + ']';
    }
}
