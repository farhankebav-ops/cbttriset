package androidx.camera.core.impl.utils;

import com.ironsource.environment.thread.IronSourceThreadManager;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f3634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f3635c;

    public /* synthetic */ c(Runnable runnable, CountDownLatch countDownLatch, int i2) {
        this.f3633a = i2;
        this.f3634b = runnable;
        this.f3635c = countDownLatch;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3633a) {
            case 0:
                Threads.lambda$runOnMainSync$0(this.f3634b, this.f3635c);
                break;
            default:
                IronSourceThreadManager.a(this.f3634b, this.f3635c);
                break;
        }
    }
}
