package com.ironsource;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
final class F5 extends HandlerThread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f6751a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F5(String name) {
        super(name);
        kotlin.jvm.internal.k.e(name, "name");
    }

    public final void a(Runnable task) {
        kotlin.jvm.internal.k.e(task, "task");
        Handler handler = this.f6751a;
        if (handler != null) {
            handler.post(task);
        }
    }

    public final void a() {
        this.f6751a = new Handler(getLooper());
    }
}
