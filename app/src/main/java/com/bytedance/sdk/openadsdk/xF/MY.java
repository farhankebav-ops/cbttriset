package com.bytedance.sdk.openadsdk.xF;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    private IlO Cc;
    private lEW MY;
    private int tV;
    private ScheduledExecutorService IlO = null;
    private long EO = 0;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
    }

    public MY(lEW lew, int i2) {
        this.MY = lew;
        this.tV = i2;
    }

    public void IlO(long j) {
        this.EO = j;
    }

    public boolean MY() {
        ScheduledExecutorService scheduledExecutorService = this.IlO;
        if (scheduledExecutorService != null) {
            return scheduledExecutorService.isShutdown();
        }
        return true;
    }

    public void IlO(int i2) {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1);
        this.IlO = scheduledExecutorServiceNewScheduledThreadPool;
        scheduledExecutorServiceNewScheduledThreadPool.scheduleAtFixedRate(new Runnable() { // from class: com.bytedance.sdk.openadsdk.xF.MY.1
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                long unused = MY.this.EO;
                if (System.currentTimeMillis() - MY.this.EO > MY.this.tV) {
                    MY.this.IlO.shutdown();
                    if (MY.this.MY != null) {
                        MY.this.MY.MY(0, "Automatic detection of stuck");
                    }
                    if (MY.this.Cc != null) {
                        IlO unused2 = MY.this.Cc;
                    }
                }
            }
        }, 0L, i2, TimeUnit.MILLISECONDS);
    }

    public void IlO() {
        ScheduledExecutorService scheduledExecutorService = this.IlO;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
        }
    }
}
