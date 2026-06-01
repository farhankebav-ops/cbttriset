package com.bytedance.sdk.component.lEW;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class DmF implements ThreadFactory {
    public static final String THREAD_GROUP_NAME_PRE = "csj_g_";
    public static final String THREAD_NAME_PRE = "csj_";
    public static volatile boolean sCrashHappened;
    protected int EO;
    protected final ThreadGroup IlO;
    protected final String MY;
    private final AtomicInteger tV;

    public DmF(String str) {
        this(5, str);
    }

    public Thread IlO(ThreadGroup threadGroup, Runnable runnable, String str) {
        return new Thread(threadGroup, runnable, str);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        if (sCrashHappened) {
            return null;
        }
        Thread threadIlO = IlO(this.IlO, runnable, this.MY + this.tV.getAndIncrement());
        if (threadIlO.isDaemon()) {
            threadIlO.setDaemon(false);
        }
        int i2 = this.EO;
        if (i2 > 10 || i2 <= 0) {
            this.EO = 5;
        }
        threadIlO.setPriority(this.EO);
        return threadIlO;
    }

    public DmF(int i2, String str) {
        this.tV = new AtomicInteger(1);
        this.EO = i2;
        this.IlO = new ThreadGroup(THREAD_GROUP_NAME_PRE.concat(String.valueOf(str)));
        this.MY = THREAD_NAME_PRE.concat(String.valueOf(str));
    }
}
