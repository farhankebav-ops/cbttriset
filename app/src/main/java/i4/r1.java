package i4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class r1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f11946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f11948c;

    public r1(Runnable runnable) {
        this.f11946a = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f11947b) {
            return;
        }
        this.f11948c = true;
        this.f11946a.run();
    }
}
