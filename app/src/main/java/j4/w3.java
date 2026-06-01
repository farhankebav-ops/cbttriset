package j4;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class w3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x3 f12533b;

    public /* synthetic */ w3(x3 x3Var, int i2) {
        this.f12532a = i2;
        this.f12533b = x3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f12532a) {
            case 0:
                x3 x3Var = this.f12533b;
                if (!x3Var.f12551f) {
                    x3Var.g = null;
                } else {
                    e2.m mVar = x3Var.f12550d;
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    long jA = x3Var.e - mVar.a();
                    if (jA <= 0) {
                        x3Var.f12551f = false;
                        x3Var.g = null;
                        x3Var.f12549c.run();
                    } else {
                        x3Var.g = x3Var.f12547a.schedule(new w3(x3Var, 1), jA, timeUnit);
                    }
                }
                break;
            default:
                x3 x3Var2 = this.f12533b;
                x3Var2.f12548b.execute(new w3(x3Var2, 0));
                break;
        }
    }
}
