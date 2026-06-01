package com.vungle.ads.internal.executor;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NamedThreadFactory implements ThreadFactory {
    private final AtomicInteger atomicInteger;
    private final String name;
    private final ThreadFactory threadFactory;

    public NamedThreadFactory(String name) {
        k.e(name, "name");
        this.name = name;
        this.threadFactory = java.util.concurrent.Executors.defaultThreadFactory();
        this.atomicInteger = new AtomicInteger(0);
    }

    public final String getName() {
        return this.name;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r7) {
        k.e(r7, "r");
        Thread threadNewThread = this.threadFactory.newThread(r7);
        threadNewThread.setName(this.name + "-th-" + this.atomicInteger.incrementAndGet());
        return threadNewThread;
    }
}
