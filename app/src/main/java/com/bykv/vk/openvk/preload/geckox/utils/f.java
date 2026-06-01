package com.bykv.vk.openvk.preload.geckox.utils;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class f implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile f f5050a;

    public static f a() {
        if (f5050a == null) {
            synchronized (f.class) {
                try {
                    if (f5050a == null) {
                        f5050a = new f();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f5050a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        com.bykv.vk.openvk.preload.geckox.b.t().execute(runnable);
    }
}
