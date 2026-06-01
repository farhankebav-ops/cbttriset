package com.bytedance.sdk.component.lEW.EO;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.profileinstaller.a;
import androidx.work.WorkRequest;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE extends ThreadPoolExecutor implements AutoCloseable {
    private boolean Bc;
    private int Cc;
    private int EO;
    private final String IlO;
    private int MY;
    private LinkedHashMap<String, com.bytedance.sdk.component.lEW.EO.IlO.IlO> lEW;
    private int tV;
    private int vCE;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        private String IlO = "cache";
        private int MY = 4;
        private int EO = 100;
        private int tV = 0;
        private long Cc = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
        private boolean vCE = false;
        private TimeUnit Bc = TimeUnit.MILLISECONDS;
        private int lEW = -1;
        private int DmF = 20;
        private boolean NV = false;
        private BlockingQueue<Runnable> EV = new PriorityBlockingQueue();
        private ThreadFactory rp = null;

        public IlO Cc(int i2) {
            this.lEW = i2;
            return this;
        }

        public IlO EO(int i2) {
            this.tV = i2;
            return this;
        }

        public IlO IlO(String str) {
            this.IlO = str;
            return this;
        }

        public IlO MY(int i2) {
            this.EO = i2;
            return this;
        }

        public IlO tV(int i2) {
            this.DmF = i2;
            return this;
        }

        public IlO IlO(int i2) {
            this.MY = i2;
            return this;
        }

        public IlO MY(boolean z2) {
            this.NV = z2;
            return this;
        }

        public IlO IlO(long j) {
            this.Cc = j;
            return this;
        }

        public IlO IlO(boolean z2) {
            this.vCE = z2;
            return this;
        }

        public vCE IlO() {
            if (this.rp == null) {
                this.rp = new tV(this.IlO);
            }
            if (this.MY < 0) {
                this.MY = 8;
            }
            if (this.MY == 0) {
                this.EV = new SynchronousQueue();
            }
            if (this.EV == null) {
                this.EV = new LinkedBlockingQueue();
            }
            if (this.EO > 100) {
                this.EO = 100;
            }
            int i2 = this.EO;
            int i8 = this.MY;
            if (i2 < i8) {
                this.EO = i8;
            }
            if (this.DmF < 0) {
                this.DmF = 20;
            }
            if (this.DmF > 100) {
                this.DmF = 100;
            }
            return new vCE(this);
        }
    }

    private boolean Bc() {
        return this.MY > 0;
    }

    private void Cc() {
        try {
            if (this.tV != 0 && getCorePoolSize() > this.tV && getQueue().size() == 0) {
                setCorePoolSize(this.tV);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private void tV() {
        try {
            if (this.tV != 0 && getCorePoolSize() < this.Cc) {
                int size = getQueue().size();
                if (getActiveCount() < this.tV || size < this.vCE) {
                    return;
                }
                setCorePoolSize(this.Cc);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private void vCE() {
        if (getCompletedTaskCount() > this.MY) {
            Cc ccIlO = EO.IlO();
            if (ccIlO != null) {
                ccIlO.IlO(this);
            }
            this.MY = -1;
        }
    }

    public boolean EO() {
        return this.Bc;
    }

    public void IlO(IlO ilO) {
        try {
            if (ilO.MY >= 0 && this.tV != ilO.MY) {
                int i2 = ilO.MY;
                this.tV = i2;
                setCorePoolSize(i2);
            }
            this.Cc = ilO.EO;
            this.vCE = ilO.tV;
            allowCoreThreadTimeOut(ilO.vCE);
            this.MY = ilO.lEW;
            this.EO = ilO.DmF;
            this.Bc = ilO.NV;
        } catch (Throwable th) {
            th.getMessage();
        }
        String unused = ilO.IlO;
        int unused2 = ilO.MY;
        int unused3 = ilO.EO;
        long unused4 = ilO.Cc;
        int unused5 = ilO.tV;
        int unused6 = ilO.DmF;
        boolean unused7 = ilO.NV;
        BlockingQueue unused8 = ilO.EV;
    }

    public String MY() {
        return this.IlO;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th) {
        boolean z2 = runnable instanceof MY;
        if (z2) {
            ((MY) runnable).EO(SystemClock.elapsedRealtime());
            try {
                if (Bc() && this.lEW != null) {
                    IlO((MY) runnable);
                    vCE();
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }
        super.afterExecute(runnable, th);
        if (z2) {
            MY my = (MY) runnable;
            my.MY();
            my.IlO();
            my.EO();
            my.tV();
            my.Cc();
        }
        Cc();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void beforeExecute(Thread thread, Runnable runnable) {
        if (runnable instanceof MY) {
            ((MY) runnable).MY(SystemClock.elapsedRealtime());
        }
        super.beforeExecute(thread, runnable);
    }

    @Override // java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        a.v(this);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        com.bytedance.sdk.component.lEW.EO.IlO ilOMY;
        if (!(runnable instanceof MY)) {
            runnable = new MY("unknown", runnable) { // from class: com.bytedance.sdk.component.lEW.EO.vCE.3
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnableLEW = lEW();
                    if (runnableLEW != null) {
                        runnableLEW.run();
                    }
                }
            };
        }
        if (!"cache".equals(this.IlO)) {
            String name = Thread.currentThread().getName();
            if (!TextUtils.isEmpty(name) && name.startsWith(tV.IlO(this.IlO)) && (ilOMY = EO.MY()) != null) {
                ilOMY.IlO(this, (MY) runnable);
            }
        }
        ((MY) runnable).IlO(SystemClock.elapsedRealtime());
        try {
            super.execute(runnable);
            tV();
        } catch (Throwable th) {
            IlO(runnable, th);
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
        if ("aidl".equals(this.IlO)) {
            return;
        }
        super.shutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return "aidl".equals(this.IlO) ? Collections.EMPTY_LIST : super.shutdownNow();
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        int iIlO;
        String strMY;
        runnable.getClass();
        final RunnableFuture runnableFutureNewTaskFor = newTaskFor(runnable, null);
        if (runnable instanceof MY) {
            MY my = (MY) runnable;
            iIlO = my.IlO();
            strMY = my.MY();
        } else {
            iIlO = 6;
            strMY = "";
        }
        if (iIlO == 0 || TextUtils.isEmpty(strMY)) {
            new RuntimeException();
        }
        execute(new MY(iIlO, strMY) { // from class: com.bytedance.sdk.component.lEW.EO.vCE.2
            @Override // java.lang.Runnable
            public void run() {
                runnableFutureNewTaskFor.run();
            }
        });
        return runnableFutureNewTaskFor;
    }

    private vCE(IlO ilO) {
        super(ilO.MY, Integer.MAX_VALUE, ilO.Cc, ilO.Bc, (BlockingQueue<Runnable>) ilO.EV, ilO.rp);
        this.Bc = false;
        String unused = ilO.IlO;
        int unused2 = ilO.MY;
        int unused3 = ilO.EO;
        long unused4 = ilO.Cc;
        int unused5 = ilO.tV;
        int unused6 = ilO.DmF;
        boolean unused7 = ilO.NV;
        BlockingQueue unused8 = ilO.EV;
        this.IlO = ilO.IlO;
        this.tV = ilO.MY;
        this.Cc = ilO.EO;
        this.vCE = ilO.tV;
        allowCoreThreadTimeOut(ilO.vCE);
        this.MY = ilO.lEW;
        this.EO = ilO.DmF;
        this.Bc = ilO.NV;
        if (Bc()) {
            final int i2 = this.EO + 4;
            this.lEW = new LinkedHashMap<String, com.bytedance.sdk.component.lEW.EO.IlO.IlO>(i2, 0.75f, true) { // from class: com.bytedance.sdk.component.lEW.EO.vCE.1
                @Override // java.util.LinkedHashMap
                public boolean removeEldestEntry(Map.Entry<String, com.bytedance.sdk.component.lEW.EO.IlO.IlO> entry) {
                    return size() > i2;
                }
            };
        }
    }

    private void IlO(Runnable runnable, Throwable th) {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                Handler handlerEO = EO.EO();
                if (handlerEO != null) {
                    handlerEO.post(runnable);
                    return;
                }
                return;
            }
            runnable.run();
        } catch (Throwable unused) {
        }
    }

    private void IlO(MY my) {
        LinkedHashMap<String, com.bytedance.sdk.component.lEW.EO.IlO.IlO> linkedHashMap = this.lEW;
        if (linkedHashMap != null) {
            com.bytedance.sdk.component.lEW.EO.IlO.IlO ilO = linkedHashMap.get(my.MY());
            if (ilO == null) {
                synchronized (linkedHashMap) {
                    try {
                        ilO = linkedHashMap.get(my.MY());
                        if (ilO == null) {
                            ilO = new com.bytedance.sdk.component.lEW.EO.IlO.IlO();
                            linkedHashMap.put(my.MY(), ilO);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            ilO.IlO(my);
        }
    }

    public LinkedHashMap<String, com.bytedance.sdk.component.lEW.EO.IlO.IlO> IlO() {
        return this.lEW;
    }
}
