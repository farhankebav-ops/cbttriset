package com.google.firebase.messaging.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public interface ExecutorFactory {
    void executeOneOff(String str, String str2, ThreadPriority threadPriority, Runnable runnable);

    ScheduledExecutorService newScheduledThreadPool(int i2, ThreadPriority threadPriority);

    ScheduledExecutorService newScheduledThreadPool(int i2, ThreadFactory threadFactory, ThreadPriority threadPriority);

    ExecutorService newSingleThreadExecutor(ThreadPriority threadPriority);

    ExecutorService newSingleThreadExecutor(ThreadFactory threadFactory, ThreadPriority threadPriority);

    ExecutorService newThreadPool(int i2, ThreadPriority threadPriority);

    ExecutorService newThreadPool(int i2, ThreadFactory threadFactory, ThreadPriority threadPriority);

    ExecutorService newThreadPool(ThreadPriority threadPriority);

    ExecutorService newThreadPool(ThreadFactory threadFactory, ThreadPriority threadPriority);

    Future<?> submitOneOff(String str, String str2, ThreadPriority threadPriority, Runnable runnable);
}
