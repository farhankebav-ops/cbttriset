package com.ironsource;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: renamed from: com.ironsource.tf, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2576tf extends Thread {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static C2576tf f10309b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f10310a;

    /* JADX INFO: renamed from: com.ironsource.tf$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a extends HandlerThread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Handler f10311a;

        public a(String str) {
            super(str);
            setUncaughtExceptionHandler(new com.ironsource.mediationsdk.logger.c());
        }

        public Handler a() {
            return this.f10311a;
        }

        public void b() {
            this.f10311a = new Handler(getLooper());
        }
    }

    private C2576tf() {
        a aVar = new a(getClass().getSimpleName());
        this.f10310a = aVar;
        aVar.start();
        this.f10310a.b();
    }

    public static synchronized C2576tf a() {
        try {
            if (f10309b == null) {
                f10309b = new C2576tf();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f10309b;
    }

    public synchronized void a(Runnable runnable) {
        a aVar = this.f10310a;
        if (aVar == null) {
            return;
        }
        Handler handlerA = aVar.a();
        if (handlerA != null) {
            handlerA.post(runnable);
        }
    }
}
