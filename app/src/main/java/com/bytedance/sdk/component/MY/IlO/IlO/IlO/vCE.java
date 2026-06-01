package com.bytedance.sdk.component.MY.IlO.IlO.IlO;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE extends com.bytedance.sdk.component.MY.IlO.tV {
    private ExecutorService IlO;
    private List<com.bytedance.sdk.component.MY.IlO.MY> MY = new CopyOnWriteArrayList();
    private List<com.bytedance.sdk.component.MY.IlO.MY> EO = new CopyOnWriteArrayList();
    private AtomicInteger tV = new AtomicInteger(64);

    public vCE() {
        if (this.IlO == null) {
            this.IlO = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 20L, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactory() { // from class: com.bytedance.sdk.component.MY.IlO.IlO.IlO.vCE.1
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable, "systemHttp Dispatcher");
                    thread.setDaemon(false);
                    thread.setPriority(10);
                    return thread;
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.MY.IlO.tV
    public List<com.bytedance.sdk.component.MY.IlO.MY> EO() {
        return this.MY;
    }

    @Override // com.bytedance.sdk.component.MY.IlO.tV
    public void IlO(int i2) {
        this.tV.set(i2);
    }

    @Override // com.bytedance.sdk.component.MY.IlO.tV
    public ExecutorService MY() {
        return this.IlO;
    }

    @Override // com.bytedance.sdk.component.MY.IlO.tV
    public List<com.bytedance.sdk.component.MY.IlO.MY> tV() {
        return this.EO;
    }

    @Override // com.bytedance.sdk.component.MY.IlO.tV
    public int IlO() {
        return this.tV.get();
    }
}
