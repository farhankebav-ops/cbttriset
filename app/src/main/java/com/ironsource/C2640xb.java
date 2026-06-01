package com.ironsource;

import android.util.Log;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: renamed from: com.ironsource.xb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2640xb {
    private static final String g = "xb";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.ironsource.lifecycle.b f10509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Runnable f10510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Wf f10511c;
    private Timer e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f10512d = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final InterfaceC2413ka f10513f = new a();

    /* JADX INFO: renamed from: com.ironsource.xb$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class b extends TimerTask {
        public b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            C2640xb c2640xb = C2640xb.this;
            c2640xb.f10509a.b(c2640xb.f10513f);
            C2640xb.this.f10511c.b();
            C2640xb.this.f10510b.run();
        }
    }

    public C2640xb(Runnable runnable, com.ironsource.lifecycle.b bVar, Wf wf) {
        this.f10510b = runnable;
        this.f10509a = bVar;
        this.f10511c = wf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        synchronized (this.f10512d) {
            try {
                Timer timer = this.e;
                if (timer != null) {
                    timer.cancel();
                    this.e = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a() {
        a(0L);
    }

    public void b() {
        c();
        this.f10509a.b(this.f10513f);
        this.f10511c.b();
    }

    public void a(long j) {
        if (j < 0) {
            Log.d(g, "cannot start timer with delay < 0");
            return;
        }
        this.f10509a.a(this.f10513f);
        this.f10511c.a(j);
        if (this.f10509a.e()) {
            this.f10511c.c(System.currentTimeMillis());
        } else {
            b(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j) {
        synchronized (this.f10512d) {
            c();
            Timer timer = new Timer();
            this.e = timer;
            timer.schedule(new b(), j);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.xb$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements InterfaceC2413ka {
        public a() {
        }

        @Override // com.ironsource.InterfaceC2413ka
        public void a() {
            C2640xb.this.f10511c.c(System.currentTimeMillis());
            C2640xb.this.c();
        }

        @Override // com.ironsource.InterfaceC2413ka
        public void b() {
            C2640xb.this.f10511c.b(System.currentTimeMillis());
            C2640xb c2640xb = C2640xb.this;
            c2640xb.b(c2640xb.f10511c.a());
        }

        @Override // com.ironsource.InterfaceC2413ka
        public void c() {
        }

        @Override // com.ironsource.InterfaceC2413ka
        public void d() {
        }
    }
}
