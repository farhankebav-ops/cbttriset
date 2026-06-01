package com.ironsource;

import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: renamed from: com.ironsource.de, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2292de {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private C2496p2 f8245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private InterfaceC2310ee f8246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Timer f8247c = null;

    /* JADX INFO: renamed from: com.ironsource.de$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            C2292de.this.f8246b.b();
        }
    }

    /* JADX INFO: renamed from: com.ironsource.de$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class b extends TimerTask {
        public b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            C2292de.this.f8246b.b();
        }
    }

    public C2292de(C2496p2 c2496p2, InterfaceC2310ee interfaceC2310ee) {
        this.f8245a = c2496p2;
        this.f8246b = interfaceC2310ee;
    }

    private void d() {
        Timer timer = this.f8247c;
        if (timer != null) {
            timer.cancel();
            this.f8247c = null;
        }
    }

    public void b() {
        synchronized (this) {
            d();
        }
        this.f8246b.b();
    }

    public synchronized void c() {
        d();
        Timer timer = new Timer();
        this.f8247c = timer;
        timer.schedule(new a(), this.f8245a.j());
    }

    public synchronized void a() {
        d();
        Timer timer = new Timer();
        this.f8247c = timer;
        timer.schedule(new b(), this.f8245a.b());
    }
}
