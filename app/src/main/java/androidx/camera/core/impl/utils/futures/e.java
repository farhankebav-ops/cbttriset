package androidx.camera.core.impl.utils.futures;

import java.util.concurrent.ScheduledFuture;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ScheduledFuture f3651b;

    public /* synthetic */ e(ScheduledFuture scheduledFuture, int i2) {
        this.f3650a = i2;
        this.f3651b = scheduledFuture;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3650a) {
            case 0:
                this.f3651b.cancel(true);
                break;
            default:
                this.f3651b.cancel(true);
                break;
        }
    }
}
