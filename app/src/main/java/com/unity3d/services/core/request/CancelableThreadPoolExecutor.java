package com.unity3d.services.core.request;

import com.ironsource.hi;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class CancelableThreadPoolExecutor extends ThreadPoolExecutor implements AutoCloseable {
    private final List<Runnable> _activeRunnable;

    public CancelableThreadPoolExecutor(int i2, int i8, long j, TimeUnit timeUnit, LinkedBlockingQueue<Runnable> linkedBlockingQueue) {
        super(i2, i8, j, timeUnit, linkedBlockingQueue);
        this._activeRunnable = new LinkedList();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public synchronized void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        this._activeRunnable.remove(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public synchronized void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        this._activeRunnable.add(runnable);
    }

    public synchronized void cancel() {
        for (Runnable runnable : this._activeRunnable) {
            if (runnable instanceof WebRequestRunnable) {
                ((WebRequestRunnable) runnable).setCancelStatus(true);
            }
        }
    }

    @Override // java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        hi.p(this);
    }
}
