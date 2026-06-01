package sg.bigo.ads.common.g.a;

import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import sg.bigo.ads.common.n.e;

/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final LinkedList<Runnable> f15702a = new LinkedList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Object f15703b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final e f15704c;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CountDownLatch f15708a = new CountDownLatch(1);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Runnable f15709b = new Runnable() { // from class: sg.bigo.ads.common.g.a.c.a.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a.this.f15708a.await();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Runnable f15710c;

        public a(Runnable runnable) {
            this.f15710c = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f15710c.run();
            this.f15708a.countDown();
        }
    }

    public c() {
        e eVar = new e("Waitable", 1, 1);
        this.f15704c = eVar;
        eVar.allowCoreThreadTimeOut(true);
    }
}
