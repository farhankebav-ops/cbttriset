package j4;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class y1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a2 f12557b;

    public /* synthetic */ y1(a2 a2Var, int i2) {
        this.f12556a = i2;
        this.f12557b = a2Var;
    }

    private final void a() {
        a2 a2Var;
        boolean z2;
        synchronized (this.f12557b) {
            try {
                a2Var = this.f12557b;
                if (a2Var.f12105d != 6) {
                    a2Var.f12105d = 6;
                    z2 = true;
                } else {
                    z2 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z2) {
            ((k4.n) a2Var.f12104c.f3216b).s(i4.n1.m.h("Keepalive failed. The connection is likely gone"));
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z2;
        switch (this.f12556a) {
            case 0:
                a();
                return;
            default:
                synchronized (this.f12557b) {
                    try {
                        a2 a2Var = this.f12557b;
                        a2Var.f12106f = null;
                        int i2 = a2Var.f12105d;
                        if (i2 == 2) {
                            a2Var.f12105d = 4;
                            a2Var.e = a2Var.f12102a.schedule(a2Var.g, a2Var.j, TimeUnit.NANOSECONDS);
                            z2 = true;
                        } else {
                            if (i2 == 3) {
                                ScheduledExecutorService scheduledExecutorService = a2Var.f12102a;
                                b2 b2Var = a2Var.h;
                                long j = a2Var.f12107i;
                                e2.m mVar = a2Var.f12103b;
                                a2Var.f12106f = scheduledExecutorService.schedule(b2Var, j - mVar.a(), TimeUnit.NANOSECONDS);
                                this.f12557b.f12105d = 2;
                            }
                            z2 = false;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                if (z2) {
                    a4.a aVar = this.f12557b.f12104c;
                    ((k4.n) aVar.f3216b).p(new z1(aVar));
                    return;
                }
                return;
        }
    }
}
