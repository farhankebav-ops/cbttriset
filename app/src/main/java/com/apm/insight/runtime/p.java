package com.apm.insight.runtime;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HandlerThread f4672a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile Handler f4675d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Queue<c> f4673b = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Queue<Message> f4674c = new ConcurrentLinkedQueue();
    private final Object e = new Object();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            while (!p.this.f4674c.isEmpty()) {
                if (p.this.f4675d != null) {
                    try {
                        p.this.f4675d.sendMessageAtFrontOfQueue((Message) p.this.f4674c.poll());
                    } catch (Throwable unused) {
                    }
                }
            }
            while (!p.this.f4673b.isEmpty()) {
                c cVar = (c) p.this.f4673b.poll();
                if (p.this.f4675d != null) {
                    try {
                        p.this.f4675d.sendMessageAtTime(cVar.f4680a, cVar.f4681b);
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class b extends HandlerThread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private volatile int f4677a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile boolean f4678b;

        public b(String str) {
            super(str);
            this.f4677a = 0;
            this.f4678b = false;
        }

        @Override // android.os.HandlerThread
        public final void onLooperPrepared() {
            super.onLooperPrepared();
            synchronized (p.this.e) {
                p.this.f4675d = new Handler();
            }
            p.this.f4675d.post(p.this.new a());
            while (true) {
                try {
                    Looper.loop();
                } catch (Throwable th) {
                    try {
                        com.apm.insight.b.f.a(com.apm.insight.e.g()).a().c();
                        if (this.f4677a < 5) {
                            com.apm.insight.c.a();
                            j.a(th, "NPTH_CATCH");
                        } else if (!this.f4678b) {
                            this.f4678b = true;
                            com.apm.insight.c.a();
                            j.a(new RuntimeException(), "NPTH_ERR_MAX");
                        }
                        this.f4677a++;
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Message f4680a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f4681b;

        public c(Message message, long j) {
            this.f4680a = message;
            this.f4681b = j;
        }
    }

    static {
        new Object() { // from class: com.apm.insight.runtime.p.1
        };
        new Object() { // from class: com.apm.insight.runtime.p.2
        };
    }

    public p(String str) {
        this.f4672a = new b(str);
    }

    public final void b() {
        this.f4672a.start();
    }

    public final HandlerThread c() {
        return this.f4672a;
    }

    private Message b(Runnable runnable) {
        return Message.obtain(this.f4675d, runnable);
    }

    @Nullable
    public final Handler a() {
        return this.f4675d;
    }

    private boolean b(Message message, long j) {
        if (this.f4675d == null) {
            synchronized (this.e) {
                try {
                    if (this.f4675d == null) {
                        this.f4673b.add(new c(message, j));
                        return true;
                    }
                } finally {
                }
            }
        }
        try {
            return this.f4675d.sendMessageAtTime(message, j);
        } catch (Throwable unused) {
            return true;
        }
    }

    public final boolean a(Runnable runnable) {
        return a(b(runnable), 0L);
    }

    public final boolean a(Runnable runnable, long j) {
        return a(b(runnable), j);
    }

    private boolean a(Message message, long j) {
        if (j < 0) {
            j = 0;
        }
        return b(message, SystemClock.uptimeMillis() + j);
    }
}
