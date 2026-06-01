package s4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class n implements u4.b, Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f13684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f13685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Thread f13686c;

    public n(Runnable runnable, o oVar) {
        this.f13684a = runnable;
        this.f13685b = oVar;
    }

    @Override // u4.b
    public final void dispose() {
        if (this.f13686c == Thread.currentThread()) {
            o oVar = this.f13685b;
            if (oVar instanceof i5.j) {
                i5.j jVar = (i5.j) oVar;
                if (jVar.f12012b) {
                    return;
                }
                jVar.f12012b = true;
                jVar.f12011a.shutdown();
                return;
            }
        }
        this.f13685b.dispose();
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13686c = Thread.currentThread();
        try {
            this.f13684a.run();
        } finally {
            dispose();
            this.f13686c = null;
        }
    }
}
