package com.vungle.ads.internal.util;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class HandlerScheduler {
    private final Handler handler = new Handler(Looper.getMainLooper());

    private final long calculateTime(long j) {
        return SystemClock.uptimeMillis() + j;
    }

    public final void cancel(String tag) {
        k.e(tag, "tag");
        this.handler.removeCallbacksAndMessages(tag);
    }

    public final void cancelAll() {
        this.handler.removeCallbacksAndMessages(null);
    }

    public final void schedule(Runnable runnable, String tag, long j) {
        k.e(runnable, "runnable");
        k.e(tag, "tag");
        this.handler.postAtTime(runnable, tag, calculateTime(j));
    }

    public final void schedule(Runnable runnable, long j) {
        k.e(runnable, "runnable");
        this.handler.postAtTime(runnable, calculateTime(j));
    }
}
