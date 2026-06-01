package x6;

import q6.c0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class j extends i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f17817c;

    public j(long j, Runnable runnable, boolean z2) {
        super(j, z2);
        this.f17817c = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17817c.run();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Task[");
        Runnable runnable = this.f17817c;
        sb.append(runnable.getClass().getSimpleName());
        sb.append('@');
        sb.append(c0.p(runnable));
        sb.append(", ");
        sb.append(this.f17815a);
        sb.append(", ");
        return a1.a.e(']', this.f17816b ? "Blocking" : "Non-blocking", sb);
    }
}
