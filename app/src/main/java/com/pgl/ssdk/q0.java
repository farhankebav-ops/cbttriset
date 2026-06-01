package com.pgl.ssdk;

import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class q0 {
    public static Handler a() {
        return z0.a().b();
    }

    public static Handler b() {
        return z0.a().c();
    }

    public static void a(Runnable runnable) {
        Handler handlerA;
        if (runnable == null || (handlerA = a()) == null) {
            return;
        }
        handlerA.post(runnable);
    }

    public static void b(Runnable runnable) {
        Handler handlerB;
        if (runnable == null || (handlerB = b()) == null) {
            return;
        }
        handlerB.post(runnable);
    }
}
