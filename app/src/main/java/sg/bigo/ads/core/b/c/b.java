package sg.bigo.ads.core.b.c;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.common.n.c;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Handler f16836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ExecutorService f16837b = Executors.newFixedThreadPool(1, new c("Callback-Worker"));

    public static class a extends AbstractRunnableC0312b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Future f16839c;

        public a(Runnable runnable) {
            super(runnable);
        }

        @Override // sg.bigo.ads.core.b.c.b.AbstractRunnableC0312b
        public final void a() {
            Runnable runnable = this.f16840a;
            if (runnable != null) {
                this.f16839c = b.a(runnable);
            }
        }
    }

    /* JADX INFO: renamed from: sg.bigo.ads.core.b.c.b$b, reason: collision with other inner class name */
    public static abstract class AbstractRunnableC0312b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Runnable f16840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicBoolean f16841b = new AtomicBoolean(false);

        public AbstractRunnableC0312b(Runnable runnable) {
            this.f16840a = runnable;
        }

        public abstract void a();

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f16841b.get()) {
                return;
            }
            a();
        }
    }

    static {
        HandlerThread handlerThread = new HandlerThread("BGAd-Callback-Handler");
        handlerThread.start();
        f16836a = new Handler(handlerThread.getLooper());
    }

    public static Future<?> a(final Runnable runnable) {
        return f16837b.submit(new Runnable() { // from class: sg.bigo.ads.core.b.c.b.1
            @Override // java.lang.Runnable
            public final void run() {
                StringBuilder sb;
                try {
                    runnable.run();
                } catch (Exception e) {
                    e = e;
                    sb = new StringBuilder("callback thread get exception:");
                    sb.append(e.getLocalizedMessage());
                    sg.bigo.ads.core.b.c.a.a(sb.toString());
                } catch (Throwable th) {
                    e = th;
                    sb = new StringBuilder("callback thread get throwable:");
                    sb.append(e.getLocalizedMessage());
                    sg.bigo.ads.core.b.c.a.a(sb.toString());
                }
            }
        });
    }

    public static AbstractRunnableC0312b a(Runnable runnable, long j) {
        a aVar = new a(runnable);
        f16836a.postDelayed(aVar, j);
        return aVar;
    }

    public static void a(AbstractRunnableC0312b abstractRunnableC0312b) {
        Future future;
        if (abstractRunnableC0312b != null) {
            abstractRunnableC0312b.f16841b.set(true);
            if (abstractRunnableC0312b instanceof a) {
                a aVar = (a) abstractRunnableC0312b;
                if (aVar.f16839c != null && (future = aVar.f16839c) != null && !future.isCancelled() && !future.isDone()) {
                    future.cancel(true);
                }
            }
            f16836a.removeCallbacks(abstractRunnableC0312b);
        }
    }
}
