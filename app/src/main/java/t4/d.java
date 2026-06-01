package t4;

import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class d implements Runnable, u4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f17406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Runnable f17407b;

    public d(Handler handler, Runnable runnable) {
        this.f17406a = handler;
        this.f17407b = runnable;
    }

    @Override // u4.b
    public final void dispose() {
        this.f17406a.removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f17407b.run();
        } catch (Throwable th) {
            n7.b.F(th);
        }
    }
}
