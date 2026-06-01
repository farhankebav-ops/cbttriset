package com.vungle.ads.internal.task;

import com.vungle.ads.internal.executor.VungleThreadPoolExecutor;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class PriorityRunnable implements VungleThreadPoolExecutor.ComparableRunnable {
    @Override // java.lang.Comparable
    public int compareTo(Object other) {
        k.e(other, "other");
        if (!(other instanceof PriorityRunnable)) {
            return -1;
        }
        return k.g(((PriorityRunnable) other).getPriority(), getPriority());
    }

    public abstract int getPriority();
}
