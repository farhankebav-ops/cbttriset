package com.bytedance.sdk.component.lEW.EO;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV implements ThreadFactory {
    public static volatile boolean EO;
    protected final ThreadGroup IlO;
    protected final String MY;
    private final AtomicInteger tV = new AtomicInteger(1);

    public tV(String str) {
        this.IlO = new ThreadGroup("pag_g_".concat(String.valueOf(str)));
        this.MY = IlO(str);
    }

    public Thread IlO(ThreadGroup threadGroup, Runnable runnable, String str) {
        return new Thread(threadGroup, runnable, str);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        if (EO) {
            return null;
        }
        Thread threadIlO = IlO(this.IlO, runnable, this.MY + "_" + this.tV.getAndIncrement());
        if (threadIlO.isDaemon()) {
            threadIlO.setDaemon(false);
        }
        return threadIlO;
    }

    public static String IlO(String str) {
        return "pag_".concat(String.valueOf(str));
    }
}
