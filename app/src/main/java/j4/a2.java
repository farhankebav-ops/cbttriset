package j4;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f12102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e2.m f12103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a4.a f12104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12105d;
    public ScheduledFuture e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ScheduledFuture f12106f;
    public final b2 g;
    public final b2 h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f12107i;
    public final long j;

    static {
        TimeUnit.SECONDS.toNanos(10L);
        TimeUnit.MILLISECONDS.toNanos(10L);
    }

    public a2(a4.a aVar, ScheduledExecutorService scheduledExecutorService, long j, long j3) {
        e2.m mVar = new e2.m();
        this.f12105d = 1;
        this.g = new b2(new y1(this, 0));
        this.h = new b2(new y1(this, 1));
        this.f12104c = aVar;
        r2.q.D(scheduledExecutorService, "scheduler");
        this.f12102a = scheduledExecutorService;
        this.f12103b = mVar;
        this.f12107i = j;
        this.j = j3;
        mVar.f11240a = false;
        mVar.b();
    }

    public final synchronized void a() {
        try {
            e2.m mVar = this.f12103b;
            mVar.f11240a = false;
            mVar.b();
            int i2 = this.f12105d;
            if (i2 == 2) {
                this.f12105d = 3;
            } else if (i2 == 4 || i2 == 5) {
                ScheduledFuture scheduledFuture = this.e;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                if (this.f12105d == 5) {
                    this.f12105d = 1;
                } else {
                    this.f12105d = 2;
                    r2.q.H(this.f12106f == null, "There should be no outstanding pingFuture");
                    this.f12106f = this.f12102a.schedule(this.h, this.f12107i, TimeUnit.NANOSECONDS);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void b() {
        try {
            int i2 = this.f12105d;
            if (i2 == 1) {
                this.f12105d = 2;
                if (this.f12106f == null) {
                    ScheduledExecutorService scheduledExecutorService = this.f12102a;
                    b2 b2Var = this.h;
                    long j = this.f12107i;
                    e2.m mVar = this.f12103b;
                    this.f12106f = scheduledExecutorService.schedule(b2Var, j - mVar.a(), TimeUnit.NANOSECONDS);
                }
            } else if (i2 == 5) {
                this.f12105d = 4;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void c() {
    }
}
