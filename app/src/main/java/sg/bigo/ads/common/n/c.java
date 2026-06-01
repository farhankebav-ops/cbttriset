package sg.bigo.ads.common.n;

import androidx.annotation.NonNull;
import java.lang.Thread;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public final class c implements ThreadFactory {
    private static a e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f15810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicInteger f15811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ThreadFactory f15812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f15813d;

    public c(String str) {
        this(str, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.f15812c.newThread(runnable);
        threadNewThread.setName(this.f15810a + "-" + this.f15811b.getAndIncrement());
        if (this.f15813d) {
            threadNewThread.setPriority(10);
        }
        threadNewThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: sg.bigo.ads.common.n.c.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(@NonNull Thread thread, @NonNull Throwable th) {
                if (c.e != null) {
                    c.e.a(th);
                }
            }
        });
        return threadNewThread;
    }

    public c(String str, boolean z2) {
        this.f15810a = "BGAd-".concat(String.valueOf(str));
        this.f15811b = new AtomicInteger(1);
        this.f15812c = Executors.defaultThreadFactory();
        this.f15813d = z2;
    }

    public static void a(a aVar) {
        e = aVar;
    }
}
