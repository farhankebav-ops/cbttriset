package sg.bigo.ads.core.d.c;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.common.n.c;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Handler f16903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ExecutorService f16904b = Executors.newFixedThreadPool(1, new c("Stat-Worker"));

    /* JADX INFO: renamed from: sg.bigo.ads.core.d.c.a$a, reason: collision with other inner class name */
    public static class C0315a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Future f16906c;

        public C0315a(Runnable runnable) {
            super(runnable);
        }

        @Override // sg.bigo.ads.core.d.c.a.b
        public final void a() {
            Runnable runnable = this.f16907a;
            if (runnable != null) {
                this.f16906c = a.a(runnable);
            }
        }
    }

    public static abstract class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Runnable f16907a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicBoolean f16908b = new AtomicBoolean(false);

        public b(Runnable runnable) {
            this.f16907a = runnable;
        }

        public abstract void a();

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f16908b.get()) {
                return;
            }
            a();
        }
    }

    static {
        HandlerThread handlerThread = new HandlerThread("BGAd-Stat-Handler");
        handlerThread.start();
        f16903a = new Handler(handlerThread.getLooper());
    }

    public static Future a(final Runnable runnable) {
        return f16904b.submit(new Runnable() { // from class: sg.bigo.ads.core.d.c.a.1
            @Override // java.lang.Runnable
            public final void run() {
                StringBuilder sb;
                try {
                    runnable.run();
                } catch (Exception e) {
                    e = e;
                    sb = new StringBuilder("stat thread get exception:");
                    sb.append(e.getLocalizedMessage());
                    sg.bigo.ads.common.t.a.a(0, "Stats", sb.toString());
                } catch (Throwable th) {
                    e = th;
                    sb = new StringBuilder("stat thread get throwable:");
                    sb.append(e.getLocalizedMessage());
                    sg.bigo.ads.common.t.a.a(0, "Stats", sb.toString());
                }
            }
        });
    }

    public static b a(Runnable runnable, long j) {
        C0315a c0315a = new C0315a(runnable);
        f16903a.postDelayed(c0315a, j);
        return c0315a;
    }

    public static void a(b bVar) {
        Future future;
        if (bVar != null) {
            bVar.f16908b.set(true);
            if (bVar instanceof C0315a) {
                C0315a c0315a = (C0315a) bVar;
                if (c0315a.f16906c != null && (future = c0315a.f16906c) != null && !future.isCancelled() && !future.isDone()) {
                    future.cancel(true);
                }
            }
            f16903a.removeCallbacks(bVar);
        }
    }
}
