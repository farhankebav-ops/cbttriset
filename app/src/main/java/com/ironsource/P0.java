package com.ironsource;

import com.ironsource.N0;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class P0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final N0 f7361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Gb f7362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final C2640xb f7363c = c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Timer f7364d;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            P0.this.f7362b.b();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class b extends TimerTask {
        public b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            P0.this.f7362b.b();
        }
    }

    public P0(N0 n02, Gb gb) {
        this.f7361a = n02;
        this.f7362b = gb;
    }

    private synchronized void b(long j) {
        j();
        Timer timer = new Timer();
        this.f7364d = timer;
        timer.schedule(new b(), j);
    }

    private C2640xb c() {
        return new C2640xb(new a(), com.ironsource.lifecycle.b.d(), new Wf());
    }

    private synchronized void j() {
        Timer timer = this.f7364d;
        if (timer != null) {
            timer.cancel();
            this.f7364d = null;
        }
    }

    public boolean d() {
        return this.f7361a.c() > 0;
    }

    public void e() {
        if (this.f7361a.e()) {
            IronLog.INTERNAL.verbose();
            b(this.f7361a.c());
        }
    }

    public void f() {
        if (this.f7361a.a() == N0.a.AUTOMATIC_LOAD_AFTER_CLOSE) {
            IronLog.INTERNAL.verbose();
            b(this.f7361a.d());
        }
    }

    public void g() {
        if (this.f7361a.e()) {
            IronLog.INTERNAL.verbose();
            b(0L);
        }
    }

    public void h() {
        if (this.f7361a.a() != N0.a.AUTOMATIC_LOAD_WHILE_SHOW || this.f7361a.d() < 0) {
            return;
        }
        IronLog.INTERNAL.verbose();
        b(this.f7361a.d());
    }

    public void i() {
        C2640xb c2640xb = this.f7363c;
        if (c2640xb != null) {
            c2640xb.b();
        }
    }

    public void k() {
        if (this.f7361a.a() != N0.a.MANUAL_WITH_AUTOMATIC_RELOAD || this.f7361a.b() <= 0) {
            return;
        }
        IronLog.INTERNAL.verbose();
        a(this.f7361a.b());
    }

    public void a() {
        if (this.f7361a.a() == N0.a.MANUAL_WITH_AUTOMATIC_RELOAD) {
            IronLog.INTERNAL.verbose();
            i();
        }
    }

    public N0 b() {
        return this.f7361a;
    }

    public void a(long j) {
        C2640xb c2640xb = this.f7363c;
        if (c2640xb != null) {
            c2640xb.a(j);
        }
    }
}
