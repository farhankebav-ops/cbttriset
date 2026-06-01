package q6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class s0 extends t0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f13583c;

    public s0(long j, Runnable runnable) {
        super(j);
        this.f13583c = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13583c.run();
    }

    @Override // q6.t0
    public final String toString() {
        return super.toString() + this.f13583c;
    }
}
