package com.ironsource;

import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: renamed from: com.ironsource.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractC2313f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f8499a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Timer f8500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected long f8501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected T f8502d;

    /* JADX INFO: renamed from: com.ironsource.f$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            AbstractC2313f.this.b();
        }
    }

    public AbstractC2313f() {
    }

    public boolean a() {
        return this.f8501c <= 0;
    }

    public abstract void b();

    public void c() {
        synchronized (this.f8499a) {
            try {
                Timer timer = this.f8500b;
                if (timer != null) {
                    timer.cancel();
                    this.f8500b = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void d() {
        this.f8502d = null;
    }

    public void a(T t3) {
        if (a() || t3 == null) {
            return;
        }
        this.f8502d = t3;
        c();
        synchronized (this.f8499a) {
            Timer timer = new Timer();
            this.f8500b = timer;
            timer.schedule(new a(), this.f8501c);
        }
    }

    public AbstractC2313f(long j) {
        this.f8501c = j;
    }
}
