package com.ironsource;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: renamed from: com.ironsource.yb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2657yb implements InterfaceC2413ka {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Timer f10565b;
    private long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Runnable f10568f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10564a = "INTERNAL";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f10566c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Long f10567d = null;

    /* JADX INFO: renamed from: com.ironsource.yb$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            C2657yb.this.f10568f.run();
        }
    }

    public C2657yb(long j, Runnable runnable, boolean z2) {
        this.e = j;
        this.f10568f = runnable;
        if (z2) {
            g();
        }
    }

    private synchronized void f() {
        Timer timer = this.f10565b;
        if (timer != null) {
            timer.cancel();
            this.f10565b = null;
        }
    }

    private synchronized void h() {
        if (this.f10565b == null) {
            Timer timer = new Timer();
            this.f10565b = timer;
            timer.schedule(new a(), this.e);
            Calendar.getInstance().setTimeInMillis(this.f10567d.longValue());
        }
    }

    @Override // com.ironsource.InterfaceC2413ka
    public void b() {
        Long l;
        if (this.f10565b == null && (l = this.f10567d) != null) {
            long jLongValue = l.longValue() - System.currentTimeMillis();
            this.e = jLongValue;
            if (jLongValue > 0) {
                h();
            } else {
                e();
                this.f10568f.run();
            }
        }
    }

    public void e() {
        f();
        this.f10566c = false;
        this.f10567d = null;
        com.ironsource.lifecycle.b.d().b(this);
    }

    public void g() {
        if (this.f10566c) {
            return;
        }
        this.f10566c = true;
        com.ironsource.lifecycle.b.d().a(this);
        this.f10567d = Long.valueOf(System.currentTimeMillis() + this.e);
        if (com.ironsource.lifecycle.b.d().e()) {
            return;
        }
        h();
    }

    @Override // com.ironsource.InterfaceC2413ka
    public void a() {
        if (this.f10565b != null) {
            f();
        }
    }

    @Override // com.ironsource.InterfaceC2413ka
    public void c() {
    }

    @Override // com.ironsource.InterfaceC2413ka
    public void d() {
    }
}
