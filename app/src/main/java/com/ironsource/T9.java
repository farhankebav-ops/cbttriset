package com.ironsource;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class T9 extends HandlerThread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f7628a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public T9(String name) {
        super(name);
        kotlin.jvm.internal.k.e(name, "name");
    }

    public final void a(Runnable task) {
        kotlin.jvm.internal.k.e(task, "task");
        a(this, task, 0L, 2, null);
    }

    public final void b(Runnable task) {
        kotlin.jvm.internal.k.e(task, "task");
        Handler handler = this.f7628a;
        if (handler != null) {
            handler.removeCallbacks(task);
        }
    }

    public static /* synthetic */ void a(T9 t9, Runnable runnable, long j, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = 0;
        }
        t9.a(runnable, j);
    }

    public final void a(Runnable task, long j) {
        kotlin.jvm.internal.k.e(task, "task");
        Handler handler = this.f7628a;
        if (handler != null) {
            handler.postDelayed(task, j);
        }
    }

    public final void a() {
        this.f7628a = new Handler(getLooper());
    }
}
