package com.bytedance.sdk.component.lEW;

import android.os.Looper;
import android.text.TextUtils;
import androidx.appcompat.app.c;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class IlO extends ThreadPoolExecutor implements AutoCloseable {
    private String IlO;

    /* JADX INFO: renamed from: com.bytedance.sdk.component.lEW.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class C0057IlO {
        private RejectedExecutionHandler lEW;
        private String IlO = "io";
        private int MY = 1;
        private long EO = 30;
        private TimeUnit tV = TimeUnit.SECONDS;
        private int Cc = Integer.MAX_VALUE;
        private BlockingQueue<Runnable> vCE = null;
        private ThreadFactory Bc = null;
        private int DmF = 5;

        public C0057IlO IlO(String str) {
            this.IlO = str;
            return this;
        }

        public C0057IlO MY(int i2) {
            this.DmF = i2;
            return this;
        }

        public C0057IlO IlO(int i2) {
            this.MY = i2;
            return this;
        }

        public C0057IlO IlO(long j) {
            this.EO = j;
            return this;
        }

        public C0057IlO IlO(TimeUnit timeUnit) {
            this.tV = timeUnit;
            return this;
        }

        public C0057IlO IlO(BlockingQueue<Runnable> blockingQueue) {
            this.vCE = blockingQueue;
            return this;
        }

        public C0057IlO IlO(ThreadFactory threadFactory) {
            this.Bc = threadFactory;
            return this;
        }

        public C0057IlO IlO(RejectedExecutionHandler rejectedExecutionHandler) {
            this.lEW = rejectedExecutionHandler;
            return this;
        }

        public IlO IlO() {
            if (this.Bc == null) {
                this.Bc = Cc.IlO().createThreadFactory(this.DmF, this.IlO);
            }
            if (this.lEW == null) {
                this.lEW = vCE.lEW();
            }
            if (this.vCE == null) {
                this.vCE = new LinkedBlockingQueue();
            }
            return new IlO(this.IlO, this.MY, this.Cc, this.EO, this.tV, this.vCE, this.Bc, this.lEW);
        }
    }

    public IlO(String str, int i2, int i8, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i2, i8, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        this.IlO = str;
    }

    private void IlO(Runnable runnable) {
        try {
            super.execute(runnable);
        } catch (OutOfMemoryError e) {
            IlO(runnable, e);
        } catch (Throwable th) {
            IlO(runnable, th);
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th) {
        BlockingQueue<Runnable> queue;
        super.afterExecute(runnable, th);
        if (!vCE.Bc() || TextUtils.isEmpty(this.IlO) || (queue = getQueue()) == null) {
            return;
        }
        String str = this.IlO;
        str.getClass();
        switch (str) {
            case "io":
                IlO(queue, 2);
                break;
            case "log":
                IlO(queue, 4);
                break;
            case "aidl":
                IlO(queue, 2);
                break;
        }
    }

    @Override // java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        c.v(this);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        BlockingQueue<Runnable> queue;
        if (runnable instanceof lEW) {
            IlO(new MY((lEW) runnable, this));
        } else {
            IlO(new MY(new lEW("unknown") { // from class: com.bytedance.sdk.component.lEW.IlO.1
                @Override // java.lang.Runnable
                public void run() {
                    runnable.run();
                }
            }, this));
        }
        if (!vCE.Bc() || TextUtils.isEmpty(this.IlO) || (queue = getQueue()) == null) {
            return;
        }
        String str = this.IlO;
        str.getClass();
        switch (str) {
            case "io":
                IlO(queue, vCE.IlO + 2, getCorePoolSize() * 2);
                break;
            case "log":
                IlO(queue, 8, 8);
                break;
            case "aidl":
                IlO(queue, 5, 5);
                break;
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
        if ("io".equals(this.IlO) || "aidl".equals(this.IlO)) {
            return;
        }
        super.shutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return ("io".equals(this.IlO) || "aidl".equals(this.IlO)) ? Collections.EMPTY_LIST : super.shutdownNow();
    }

    private void IlO(Runnable runnable, OutOfMemoryError outOfMemoryError) {
        IlO(runnable, (Throwable) outOfMemoryError);
    }

    private void IlO(Runnable runnable, Throwable th) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            try {
                runnable.run();
            } catch (Throwable unused) {
            }
        }
    }

    private void IlO(BlockingQueue<Runnable> blockingQueue, int i2) {
        if (getCorePoolSize() == i2 || blockingQueue == null || blockingQueue.size() > 0) {
            return;
        }
        try {
            setCorePoolSize(i2);
            getCorePoolSize();
            getMaximumPoolSize();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private void IlO(BlockingQueue<Runnable> blockingQueue, int i2, int i8) {
        if (getCorePoolSize() == i2 || blockingQueue == null || blockingQueue.size() < i8) {
            return;
        }
        try {
            setCorePoolSize(i2);
            getCorePoolSize();
            getMaximumPoolSize();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public String IlO() {
        return this.IlO;
    }
}
